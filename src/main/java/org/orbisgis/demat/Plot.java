/*
 * DEMAT is java wrapper on top of the vega-lite library
 *
 * Demat is breton word to said "Hello".
 *
 * DEMAT is part of the OrbisGIS platform.
 *
 * OrbisGIS platform is a set of open source tools to access, process, display
 * and share geographical informations.
 *
 * It is leaded by CNRS within the French Lab-STICC laboratory <http://www.lab-sticc.fr/>,
 * DECIDE team of Vannes.
 *
 * OrbisGIS is dedicated to research in GIScience.
 *
 * The GIS group of the DECIDE team is located at :
 *
 * Laboratoire Lab-STICC – CNRS UMR 6285
 * Equipe DECIDE
 * UNIVERSITÉ DE BRETAGNE-SUD
 * Institut Universitaire de Technologie de Vannes
 * 8, Rue Montaigne - BP 561 56017 Vannes Cedex
 *
 * DEMAT is distributed under LGPL 3 license.
 *
 * Copyright (C) 2021 CNRS (Lab-STICC UMR CNRS 6285)
 *
 *
 * DEMAT is free software: you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * DEMAT is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * DEMAT. If not, see <http://www.gnu.org/licenses/>.
 *
 * For more information, please consult: <http://www.orbisgis.org/>
 * or contact directly:
 * info_at_ orbisgis.org
 */
package org.orbisgis.demat;

import org.orbisgis.demat.maps.Maps;
import org.orbisgis.demat.vega.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * A Vega-Lite top-level specification. This is the root class for all Vega-Lite
 * specifications.
 *
 * @author Erwan Bocher, CNRS 2021
 */
public class Plot implements IRenderer {

    private View view;
    private Renderer renderer;

    public Plot(View view) {
        this.renderer = new Renderer(view);
    }

    public static Plot Plot(Object... elements) {
        View view_ = new View();
        Plot plot = new Plot(view_);
        view_.setSchema("https://vega.github.io/schema/vega-lite/v5.json");
        for (Object element : elements) {
            if (element instanceof Data) {
                view_.setData((Data) element);
            } else {
                throw new RuntimeException("Unknown vega-lite element");
            }
        }
        plot.setView(view_);
        return plot;
    }

    //---------------
    // Methods for pattern builder
    //---------------

    public static Chart Chart(Object... elements) {
        Chart chart = new Chart();
        for (Object element : elements) {
            if (element instanceof Data) {
                chart.setData((Data) element);
            } else {
                throw new RuntimeException("Unknown vega-lite element");
            }
        }
        return chart;
    }

    public static Data Data(Object[][] values) {
        return PlotUtils.urlData(values);
    }

    public static Data Data(List<Map> values) {
        return PlotUtils.urlData(values);
    }

    public static Data Data(LinkedHashMap values) {
        return PlotUtils.urlData(values);
    }

    public static Maps Maps() {
        return new Maps();
    }


    /**
     * Create a Color encoding
     *
     * @return
     */
    public static Color Color(Object... elements) {
        Color color = new Color();
        for (Object element : elements) {
            if (element instanceof Aggregate) {
                color.setAggregate((Aggregate) element);
            } else if (element instanceof Double) {
                color.setBand((Double) element);
            } else if (element instanceof AngleBin) {
                color.setBand((Double) element);
            } else if (element instanceof ColorCondition) {
                color.setCondition((ColorCondition) element);
            } else if (element instanceof Field) {
                color.setField((Field) element);
            } else if (element instanceof Legend) {
                color.setLegend((Legend) element);
            } else if (element instanceof Scale) {
                color.setScale((Scale) element);
            } else if (element instanceof SortUnion) {
                color.setSort((SortUnion) element);
            } else if (element instanceof TimeUnitUnion) {
                color.setTimeUnit((TimeUnitUnion) element);
            } else if (element instanceof LegendText) {
                color.setTitle((LegendText) element);
            } else if (element instanceof Type) {
                color.setType((Type) element);
            } else if (element instanceof PrimitiveValue) {
                color.setDatum((PrimitiveValue) element);
            } else if (element instanceof Gradient) {
                color.setValue((Gradient) element);
            } else if (element instanceof String) {
                color.setField((String) element);
            } else {
                throw new RuntimeException("Unsupported element for color");
            }
        }
        return color;
    }

    /**
     * Create a Scale element
     *
     * @return
     */
    public static Scale Scale(Object... elements) {
        Scale scale = new Scale();
        for (Object element : elements) {
            if (element instanceof Domain) {
                scale.setDomain((Domain) element);
            } else if (element instanceof ScaleRange) {
                scale.setRange((ScaleRange) element);
            } else {
                throw new RuntimeException("Unsupported element for scale");
            }
        }
        return scale;
    }

    public static ScaleType Quantize() {
        return ScaleType.QUANTIZE;
    }

    public static ScaleType Quantile() {
        return ScaleType.QUANTILE;
    }


    //---------------
    // static object constructors
    //---------------

    /**
     * Create a domainMid element
     *
     * @param value
     * @return
     */
    public static CornerRadius DomainMid(double value) {
        CornerRadius cornerRadius = new CornerRadius();
        cornerRadius.doubleValue = value;
        return cornerRadius;
    }

    /**
     * Create a scale range according a set of values
     *
     * @param values
     * @return
     */
    public static ScaleRange Range(List values) {
        ScaleRange scaleRange = new ScaleRange();
        scaleRange.values = values;
        return scaleRange;
    }

    /**
     * Create a scale range from a field
     *
     * @param field name of the field
     * @return
     */
    public static ScaleRange Range(String field) {
        ScaleRange scaleRange = new ScaleRange();
        RangeField rangeField = new RangeField();
        rangeField.setField(field);
        scaleRange.rangeField = rangeField;
        return scaleRange;
    }

    /**
     * Create a X encoding
     *
     * @return
     */
    public static X X() {
        return new X();
    }

    /**
     * Return a X encoding class
     *
     * @return
     */
    public static X X(String fieldValue) {
        X x = new X();
        x.setField(new Field(fieldValue));
        return x;
    }

    /**
     * Create a Y encoding
     *
     * @return
     */
    public static Y Y() {
        return new Y();
    }

    /**
     * Create a Y encoding
     *
     * @return
     */
    public static Y Y(String fieldValue) {
        Y y = new Y();
        y.setField(new Field(fieldValue));
        return y;
    }

    public static Projection Projection() {
        return new Projection();
    }

    public static Domain Domain(List<Object> values) {
        Domain domain = new Domain();
        domain.values = values;
        return domain;
    }

    public static Legend Legend(String title) {
        Legend legend = new Legend();
        LegendText legendText = new LegendText();
        legendText.stringValue = title;
        legend.setTitle(legendText);
        return legend;
    }

    private void setView(View view) {
        this.view = view;
    }

    public Chart chart(Object... elements) {
        Chart chart = new Chart();
        for (Object element : elements) {
            if (element instanceof Data) {
                chart.setData((Data) element);
            } else if (element instanceof Mark) {
                chart.setMark((Mark) element);
            } else if (element instanceof Encoding) {
                chart.setEncoding((Encoding) element);
            } else {
                throw new RuntimeException("Unknown vega-lite element");
            }
        }
        chart.setView(this.view);
        chart.setRenderer(this.renderer);
        return chart;
    }

    public Plot data() {
        this.view.setData(new Data());
        return this;
    }

    public Plot description(String description) {
        this.view.setDescription(description);
        return this;
    }

    public Plot name(String name) {
        this.view.setName(name);
        return this;
    }

    /**
     * Set height to the plot
     *
     * @param height
     * @return
     */
    public Plot height(double height) {
        Height height_ = new Height();
        height_.doubleValue = height;
        this.view.setHeight(height_);
        return this;
    }

    /**
     * Set width to the plot
     *
     * @param width
     * @return
     */
    public Plot width(double width) {
        Height height_ = new Height();
        height_.doubleValue = width;
        this.view.setWidth(height_);
        return this;
    }

    public Plot hconcat(Chart... charts) {
        this.view.setHconcat(Arrays.asList(charts));
        return this;
    }

    public Plot vconcat(Chart... charts) {
        this.view.setVconcat(Arrays.asList(charts));
        return this;
    }

    public Plot concat(Chart... charts) {
        this.view.setConcat(Arrays.asList(charts));
        return this;
    }

    @Override
    public void show() {
        this.renderer.show();
    }

    @Override
    public String save() throws IOException {
        return this.renderer.save();
    }

    @Override
    public String save(String path) throws IOException {
        return this.renderer.save(path);
    }
}
