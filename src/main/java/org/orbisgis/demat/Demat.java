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

import org.orbisgis.demat.vega.*;

import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Main class to manage vega-lite element and build the vega-lite views
 *
 * @author Erwan Bocher, CNRS 2021
 */
public class Demat {

    View view;

    /**
     * Create a chart object
     * it refers to a single view configuration for vega-lite
     *
     * @return
     */
    public static View view() {
        Demat demat = new Demat();
        View view = new View();
        view.setSchema("https://vega.github.io/schema/vega-lite/v5.json");
        demat.setView(view);
        return view;
    }

    /**
     * Create a chart object
     * it refers to a single view configuration for vega-lite
     *
     * @return
     */
    public static View view(Object... elements) {
        Demat demat = new Demat();
        View view = new View();
        view.setSchema("https://vega.github.io/schema/vega-lite/v5.json");
        demat.setView(view);
        for (Object element : elements) {
            if (element instanceof Projection) {
                view.setProjection((Projection) element);
            } else {
                throw new RuntimeException("Unknown vega-lite element");
            }
        }
        return view;
    }


    public static Read read() {
        return new Read();
    }

    /**
     * Create inline values data from a two dimensional array
     *
     * @param values
     * @return
     */
    public static Data data(Object[][] values) {
        Data data = new Data();
        data.setValues(PlotUtils.urlDataInlineDataset(values));
        return data;
    }

    /**
     * Create inline values data from a list of map
     *
     * @param values
     * @return
     */
    public static Data data(List<Map> values) {
        Data data = new Data();
        data.setValues(PlotUtils.urlDataInlineDataset(values));
        return data;
    }

    /**
     * Create data values data from a LinkedHashMap
     *
     * @param values
     * @return
     */
    public static Data data(LinkedHashMap values) {
        return PlotUtils.urlData(values);
    }

    /**
     * Create a X encoding
     *
     * @return
     */
    public static X x() {
        return new X();
    }

    /**
     * Return a X encoding class
     *
     * @return
     */
    public static X x(String fieldValue) {
        X x = new X();
        x.setField(new Field(fieldValue));
        return x;
    }

    public static Encoding encoding() {
        Encoding encoding = new Encoding();
        return encoding;
    }

    /**
     * Create a Color encoding from a property name
     *
     * @param fieldValue
     * @return
     */
    public static Color color(String fieldValue) {
        Color color = new Color();
        color.setField(new Field(fieldValue));
        return color;
    }

    /**
     * Create a Color encoding from a property name
     *
     * @param fieldValue
     * @return
     */
    public static Color color(String fieldValue, Scale scale) {
        Color color = new Color();
        color.setField(new Field(fieldValue));
        color.setScale(scale);
        return color;
    }

    /**
     * Create a Color encoding
     *
     * @return
     */
    public static Color color() {
        return new Color();
    }

    /**
     * Create a Scale element
     *
     * @return
     */
    public static Scale scale(Object... elements) {
        Scale scale = new Scale();
        for (Object element : elements) {
            if (element instanceof Domain) {
                scale.setDomain((Domain) element);
            } else if (element instanceof ScaleRange) {
                scale.setRange((ScaleRange) element);
            } else {
                throw new RuntimeException("Unknown vega-lite element");
            }
        }
        return scale;
    }

    /**
     * Create a domainMid element
     *
     * @param value
     * @return
     */
    public static CornerRadius domainMid(double value) {
        CornerRadius cornerRadius = new CornerRadius();
        cornerRadius.doubleValue = value;
        return cornerRadius;
    }

    /**
     * Create a domain according a set of values
     *
     * @param values
     * @return
     */
    public static Domain domain(List values) {
        Domain domain_ = new Domain();
        domain_.values = values;
        return domain_;
    }

    /**
     * Create a domain according a value
     *
     * @param value
     * @return
     */
    public static Domain domain(String value) {
        Domain domain_ = new Domain();
        domain_.value = value;
        return domain_;
    }

    /**
     * Create a scale range according a set of values
     *
     * @param values
     * @return
     */
    public static ScaleRange range(List values) {
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
    public static ScaleRange range(String field) {
        ScaleRange scaleRange = new ScaleRange();
        RangeField rangeField = new RangeField();
        rangeField.setField(field);
        scaleRange.rangeField = rangeField;
        return scaleRange;
    }

    /**
     * Create a Y encoding
     *
     * @return
     */
    public static Y y() {
        return new Y();
    }

    /**
     * Create a Y encoding
     *
     * @return
     */
    public static Y y(String fieldValue) {
        Y y = new Y();
        y.setField(new Field(fieldValue));
        return y;
    }

    public static Projection projection() {
        return new Projection();
    }

    public static void hconcat(View... views) {

    }

    public static Data json(InputStream resourceAsStream) {
        Object json = Read.json(resourceAsStream);
        if (json instanceof LinkedHashMap) {
            return data((LinkedHashMap<Object, Object>) json);
        } else if (json instanceof List) {
            return data((List<Map>) json);
        }
        throw new RuntimeException("Unsuported input data");
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

}
