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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import j2html.tags.ContainerTag;
import j2html.tags.DomContent;
import org.orbisgis.data.api.dataset.ISpatialTable;
import org.orbisgis.data.api.dataset.ITable;
import org.orbisgis.data.api.dsl.IFilterBuilder;
import org.orbisgis.demat.decoration.Source;
import org.orbisgis.demat.maps.*;
import org.orbisgis.demat.vega.*;
import org.orbisgis.demat.vega.condition.ConditionalValueNumber;
import org.orbisgis.demat.vega.condition.ConditionalValueString;
import org.orbisgis.demat.vega.data.*;
import org.orbisgis.demat.vega.encoding.*;
import org.orbisgis.demat.vega.encoding.Tooltip;
import org.orbisgis.demat.vega.layout.Layer;
import org.orbisgis.demat.vega.legend.Legend;
import org.orbisgis.demat.vega.legend.LegendText;
import org.orbisgis.demat.vega.resolve.*;
import org.orbisgis.demat.vega.transform.AggregatedFieldDef;
import org.orbisgis.demat.vega.transform.GroupBy;
import org.orbisgis.demat.vega.transform.Transform;
import org.orbisgis.demat.vega.transform.aggregate.Count;

import java.io.File;
import java.io.IOException;
import java.util.*;

import static j2html.TagCreator.*;

/**
 * A Vega-Lite top-level specification. This is the root class for all Vega-Lite
 * specifications.
 *
 * @author Erwan Bocher, CNRS 2021 - 2023
 */
public class Plot extends ContainerTag<Plot> implements ViewCommonMethods<Plot>, IRenderer {

    public View view;

    private String htmlDirectory = System.getProperty("java.io.tmpdir") + File.separator + "demat";

    public Plot(View view) {
        super("div");
        this.view = view;
    }

    public static Plot Plot(Object... elements) {
        View view_ = new View();
        Plot plot = new Plot(view_);
        view_.setSchema("https://vega.github.io/schema/vega-lite/v5.json");
        for (Object element : elements) {
            if (element instanceof Data) {
                view_.setData((Data) element);
            } else if (element instanceof DataSet) {
                view_.setDatasets((DataSet) element);
            } else if (element instanceof Encoding) {
                view_.setEncoding((Encoding) element);
            } else if (element instanceof Title) {
                view_.setTitle((Title) element);
            } else if (element instanceof Transform) {
                view_.setTransform((Transform) element);
            } else if (element instanceof Layer) {
                view_.setLayer((Layer) element);
            } else if (element instanceof Projection) {
                view_.setProjection((Projection) element);
            }else if (element instanceof Projection) {
                view_.setProjection((Projection) element);
            }
            else {
                throw new RuntimeException("Unknown vega-lite element : " + element.getClass());
            }
        }
        plot.setView(view_);
        return plot;
    }

    //---------------
    // Methods for pattern builder
    //---------------

    public static Source Source(String text) {
        Source source = new Source();
        return source.text(text);
    }

    public static Source Source() {
        return new Source();
    }

    public static Chart Chart(Object... elements) {
        Chart chart = new Chart();
        for (Object element : elements) {
            if (element instanceof Data) {
                chart.setData((Data) element);
            } else if (element instanceof Mark) {
                chart.setMark((Mark) element);
            } else if (element instanceof ITable) {
                Data data = new Data();
                data.setTable((ITable) element);
                chart.setData(data);
            } else if (element instanceof IFilterBuilder) {
                Data data = new Data();
                data.setTable(((IFilterBuilder) element).getTable());
                chart.setData(data);
            } else {
                throw new RuntimeException("Unknown vega-lite element");
            }
        }
        return chart;
    }

    /**
     * Create a new empty Data element
     *
     * @return
     */
    public static Data Data() {
        Data data = new Data();
        DataValues dataValues = new DataValues();
        dataValues.anythingMapValue=new HashMap<>();
        data.setDataValues(dataValues);
        return data;
    }


    public static Data JSON(String jsonPath) throws IOException {
        LinkedHashMap json = (LinkedHashMap) Read.json(new File(jsonPath));
        return Data(json);
    }

    public static Data GeoJSON(String jsonPath) throws IOException {
        LinkedHashMap json = (LinkedHashMap) Read.geojson(new File(jsonPath));
        List<Map> data = (List<Map>) json.get("features");
        if (data == null) {
            throw new RuntimeException("Malformed geojson file");
        }
        return Data(data);
    }

    /**
     * Build a data object from json values
     *
     * @param jsonValues
     * @return
     */
    public static Data Data(String jsonValues) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Data data = new Data();
            data.setDataValues(objectMapper.readValue(jsonValues, DataValues.class));
            return data;
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Cannot parse the json value");
        }
    }


    public static Data Data(ISpatialTable spatialTable) throws Exception {
        return PlotUtils.urlData(spatialTable);
    }

    public static Data Data(ITable table) throws Exception {
        return PlotUtils.urlData(table);
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

    public static Data Data(Object... elements) {
        Data data = new Data();
        for (Object element : elements) {
            if (element instanceof LinkedHashMap) {
                DataValues urlDataInlineDataset = new DataValues();
                urlDataInlineDataset.anythingMapValue = (Map<String, Object>) element;
                data.setDataValues(urlDataInlineDataset);
            } else if (element instanceof ITable) {
                try {
                    data.setDataValues(PlotUtils.dataValues((ITable) element));
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            } else if (element instanceof ISpatialTable) {
                try {
                    data.setDataValues(PlotUtils.dataValues((ISpatialTable) element));
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            } else if (element instanceof Graticule) {
                data.setGraticule((Graticule) element);
            }
        }
        return data;

    }


    public static Graticule Graticule() {
        Graticule graticule = new Graticule();
        graticule.graticuleParamsValue = new GraticuleParams();
        return graticule;
    }


    /**
     * Create a DataSet from Data
     *
     * @param data
     * @return
     */
    public static DataSet DataSet(Data... data) {
        DataSet dataSet = new DataSet();
        for (Data data_tmp : data) {
            if (data_tmp.getName() != null) {
                dataSet.addDataValues(data_tmp.getName(), data_tmp.getDataValues());
            }
        }
        return dataSet;
    }

    /**
     * Create a Choropleth Map
     *
     * @param data input data
     * @return
     */
    public static ChoroplethMap ChoroplethMap(Object data) {
        if (data instanceof Data) {
            return Maps.choropleth((Data) data);
        } else if (data instanceof ITable) {
            return Maps.choropleth((ITable) data);
        } else if (data instanceof IFilterBuilder) {
            return Maps.choropleth((IFilterBuilder) data);
        } else {
            throw new RuntimeException("Unknown data type");
        }
    }

    /**
     * Create a Choropleth Map
     *
     * @return
     */
    public static ChoroplethMap ChoroplethMap() {
        return Maps.choropleth();
    }

    /**
     * Create a unique values map
     *
     * @param data
     * @return
     */
    public static UniqueValuesMap UniqueValuesMap(Object data) {
        if (data instanceof Data) {
            return Maps.uniqueValues((Data) data);
        } else if (data instanceof ITable) {
            return Maps.uniqueValues((ITable) data);
        } else if (data instanceof IFilterBuilder) {
            return Maps.uniqueValues((IFilterBuilder) data);
        } else {
            throw new RuntimeException("Unknown data type");
        }
    }

    /**
     * Create a unique values map
     *
     * @return
     */
    public static UniqueValuesMap UniqueValuesMap() {
        return Maps.uniqueValues();
    }

    /**
     * Create a manual interval map
     *
     * @param data
     * @return
     */
    public static ManualIntervalMap ManualIntervalMap(Object data) {
        if (data instanceof Data) {
            return Maps.manualInterval((Data) data);
        } else if (data instanceof ITable) {
            Data data1 = new Data();
            data1.setTable((ITable) data);
            return Maps.manualInterval(data1);
        } else if (data instanceof IFilterBuilder) {
            Data data1 = new Data();
            data1.setTable(((IFilterBuilder) data).getTable());
            return Maps.manualInterval(data1);
        } else {
            throw new RuntimeException("Unknown data type");
        }
    }

    public static ManualIntervalMap ManualIntervalMap() {
        return Maps.manualInterval();
    }

    public static SingleSymbolMap SingleSymbolMap(Object data) {
        if (data instanceof Data) {
            SingleSymbolMap map = Maps.singleSymbolMap();
            map.setData((Data) data);
            return map;
        } else if (data instanceof ITable) {
            Data data1 = new Data();
            data1.setTable((ITable) data);
            SingleSymbolMap map = Maps.singleSymbolMap();
            map.setData(data1);
            return map;
        } else if (data instanceof IFilterBuilder) {
            Data data1 = new Data();
            data1.setTable(((IFilterBuilder) data).getTable());
            SingleSymbolMap map = Maps.singleSymbolMap();
            map.setData(data1);
            return map;
        } else {
            throw new RuntimeException("Unknown data type");
        }
    }

    public static SingleSymbolMap SingleSymbolMap() {
        return Maps.singleSymbolMap();
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
            } else if (element instanceof ConditionalValueString) {
                ConditionalValueString condition = (ConditionalValueString) element;
                ColorCondition colorCondition = new ColorCondition();
                ConditionalGradient conditionalGradient = new ConditionalGradient();
                conditionalGradient.setTest(condition.getTest());
                Gradient gradient = new Gradient();
                gradient.value = condition.getValue();
                conditionalGradient.setValue(gradient);
                ArrayList<ConditionalGradient> conditions = new ArrayList();
                conditions.add(conditionalGradient);
                colorCondition.conditionalGradients = conditions;
                color.setCondition(colorCondition);
            } else if (element instanceof Map) {
                Map map = (Map) element;
                Domain domain = new Domain();
                domain.values = new ArrayList<>(map.keySet());
                ScaleRange range = new ScaleRange();
                range.values = new ArrayList<>(map.values());
                Scale scale = new Scale();
                scale.setDomain(domain);
                scale.setRange(range);
                color.setScale(scale);
            } else {
                throw new RuntimeException("Unsupported element for color");
            }
        }
        return color;
    }

    /**
     * Create a gradient color
     *
     * @param value
     * @return
     */
    public static Gradient Gradient(String value) {
        Gradient gradient = new Gradient();
        gradient.value = value;
        return gradient;
    }

    public static Object Condition(String expression, Object value) {
        if (value instanceof Number) {
            ConditionalValueNumber condition = new ConditionalValueNumber();
            Filter filter = new Filter();
            filter.expression = expression;
            condition.setTest(filter);
            condition.setValue((Number) value);
            return condition;
        } else if (value instanceof String) {
            ConditionalValueString condition = new ConditionalValueString();
            Filter filter = new Filter();
            filter.expression = expression;
            condition.setTest(filter);
            condition.setValue((String) value);
            return condition;
        } else {
            throw new RuntimeException("Unsupported condition");
        }

    }

    /**
     * Create a Encoding element
     *
     * @return
     */
    public static Encoding Encoding(Object... elements) {
        Encoding encoding = new Encoding();
        for (Object element : elements) {
            if (element instanceof Color) {
                encoding.setColor((Color) element);
            } else if (element instanceof X) {
                encoding.setX((X) element);
            } else if (element instanceof Y) {
                encoding.setY((Y) element);
            } else if (element instanceof Tooltip) {
                encoding.setTooltip((Tooltip) element);
            } else if (element instanceof X2) {
                encoding.setX2((X2) element);
            } else if (element instanceof Y2) {
                encoding.setY2((Y2) element);
            } else if (element instanceof Radius) {
                encoding.setRadius((Radius) element);
            } else if (element instanceof Theta) {
                encoding.setTheta((Theta) element);
            } else {
                throw new RuntimeException("Unsupported element " + element.getClass() + " for encoding");
            }
        }
        return encoding;
    }

    /**
     * Create a Encoding element
     *
     * @return
     */
    public static Transform Transform(Object... elements) {
        Transform transform = new Transform();
        ArrayList<AggregatedFieldDef> aggregatedFields = null;
        for (Object element : elements) {
            if (element instanceof AggregatedFieldDef) {
                if (aggregatedFields == null) {
                    aggregatedFields = new ArrayList<AggregatedFieldDef>();
                }
                aggregatedFields.add((AggregatedFieldDef) element);

            } else if (element instanceof GroupBy) {
                transform.setGroupby((GroupBy) element);
            }
        }
        transform.setAggregate(aggregatedFields);

        return transform;
    }

    /**
     * Create a Field element
     *
     * @param name
     * @return
     */
    public Field Field(String name) {
        return new Field(name);
    }

    /**
     * Create a count operator
     *
     * @param asField
     * @return
     */
    public static Count Count(String asField) {
        return new Count(asField);
    }

    /**
     * Create a groupBy with a field
     *
     * @param fields
     * @return
     */
    public static GroupBy GroupBy(String... fields) {
        return new GroupBy(fields);
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

    public static ScaleType SQRT() {
        return ScaleType.SQRT;
    }


    public static ToolTipField ToolTipField() {
        return new ToolTipField();
    }

    public static ToolTipField ToolTipField(String fieldValue) {
        ToolTipField toolTipField = new ToolTipField();
        toolTipField.setField(new Field(fieldValue));
        return toolTipField;
    }

    /**
     * Create a Tooltip channel
     *
     * @return
     */
    public static Tooltip Tooltip(String fieldValue) {
        Tooltip tooltip = new Tooltip();
        ToolTipField toolTipField = new ToolTipField();
        toolTipField.setField(new Field(fieldValue));
        tooltip.setToolTipField(toolTipField);
        return tooltip;
    }

    /**
     * Create a Tooltip channel
     *
     * @return
     */
    public static Tooltip Tooltip(ToolTipField toolTipField) {
        Tooltip tooltip = new Tooltip();
        tooltip.setToolTipField(toolTipField);
        return tooltip;
    }

    /**
     * Create a Tooltip channel
     *
     * @return
     */
    public static Tooltip Tooltip(List<ToolTipField> toolTipFields) {
        Tooltip tooltip = new Tooltip();
        tooltip.setToolTipFields(toolTipFields);
        return tooltip;
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
        cornerRadius.value = value;
        return cornerRadius;
    }

    /**
     * Create a scale range according a set of objects
     *
     * @param elements
     * @return
     */
    public static ScaleRange Range(Object... elements) {
        return ScaleRange.build(elements);
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
        X x = new X();
        x.setScale(new Scale());
        return x;
    }

    /**
     * Return a X encoding class
     *
     * @return
     */
    public static X X(String fieldValue) {
        X x = new X();
        x.setScale(new Scale());
        x.setField(new Field(fieldValue));
        return x;
    }

    /**
     * Create a Y encoding
     *
     * @return
     */
    public static Y Y() {
        Y y = new Y();
        y.setScale(new Scale());
        return y;
    }

    /**
     * Create a Y encoding
     *
     * @return
     */
    public static Y Y(String fieldValue) {
        Y y = new Y();
        y.setScale(new Scale());
        y.setField(new Field(fieldValue));
        return y;
    }

    /**
     * Create a Text encoding
     *
     * @param fieldValue
     * @return
     */
    public static Text Text(String fieldValue) {
        Text text = new Text();
        text.setField(new Field(fieldValue));
        return text;
    }

    public static Longitude Longitude(String fieldValue){
        Longitude longitude = new Longitude();
        longitude.setField(new Field(fieldValue));
        return longitude;
    }
    public static Latitude Latitude(String fieldValue){
        Latitude latitude = new Latitude();
        latitude.setField(new Field(fieldValue));
        return latitude;
    }


    /**
     * Return a Radius encoding class
     *
     * @return
     */
    public static Radius Radius(Object... elements) {
        Radius radius = new Radius();
        for (Object element : elements) {
            if (element instanceof String) {
                radius.setField(new Field((String) element));
            } else if (element instanceof Scale) {
                radius.setScale((Scale) element);
            }
        }
        return radius;
    }

    /**
     * Return a Theta encoding class
     *
     * @return
     */
    public static Theta Theta(String fieldValue) {
        Theta theta = new Theta();
        theta.setField(new Field(fieldValue));
        return theta;
    }

    /**
     * Create a Size encoding
     *
     * @return
     */
    public static Size Size(String fieldValue) {
        Size size = new Size();
        size.setField(new Field(fieldValue));
        return size;
    }

    /**
     * Create a Size encoding
     *
     * @return
     */
    public static Size Size() {
        Size size = new Size();
        return size;
    }


    /**
     * Create a mark arc def
     *
     * @return
     */
    public static Def Arc() {
        Def def = new Def();
        def.setType("arc");
        return def;
    }

    /**
     * Create a mark
     *
     * @return
     */
    public static Mark Mark(Def def) {
        Mark mark = new Mark();
        mark.def = def;
        return mark;
    }

    /**
     * Create a mark boxplot def
     *
     * @return
     */
    public static Def BoxPlot() {
        Def def = new Def();
        def.setType("boxplot");
        return def;
    }

    /**
     * Create a text def
     *
     * @return
     */
    public static Def Text() {
        Def def = new Def();
        def.setType("text");
        return def;
    }

    /**
     * Create a square def
     *
     * @return
     */
    public static Def Square() {
        Def def = new Def();
        def.setType("square");
        return def;
    }

    /**
     * Create a point def
     *
     * @return
     */
    public static Def Point() {
        Def def = new Def();
        def.setType("point");
        return def;
    }

    /**
     * Create a line def
     *
     * @return
     */
    public static Def Line() {
        Def def = new Def();
        def.setType("line");
        return def;
    }

    /**
     * Create a tick def
     *
     * @return
     */
    public static Def Tick() {
        Def def = new Def();
        def.setType("tick");
        return def;
    }

    /**
     * Create a rect def
     *
     * @return
     */
    public static Def Rect() {
        Def def = new Def();
        def.setType("rect");
        return def;
    }

    /**
     * Create a image def
     *
     * @return
     */
    public static Def Image() {
        Def def = new Def();
        def.setType("image");
        return def;
    }

    /**
     * Create a geoshape def
     *
     * @return
     */
    public static Def Geoshape() {
        Def def = new Def();
        def.setType("geoshape");
        return def;
    }

    /**
     * Create a circle def
     *
     * @return
     */
    public static Def Circle() {
        Def def = new Def();
        def.setType("circle");
        return def;
    }


    /**
     * Create a area def
     *
     * @return
     */
    public static Def Area() {
        Def def = new Def();
        def.setType("area");
        return def;
    }

    /**
     * Create a mark bar def
     *
     * @return
     */
    public static Def Bar() {
        Def def = new Def();
        def.setType("bar");
        return def;
    }

    public static Layer Layer() {
        return new Layer();
    }

    public static Layer Layer(Object... elements) {
        Layer layer = new Layer();
        for (Object element : elements) {
            if(element instanceof Chart){
                layer.setLayerElement(PlotUtils.chartToLayerElement((Chart) element));
            }
            else {
                throw new RuntimeException("Unsupported element for Layer : "+ element);
            }
        }
        return layer;
    }

    public static Projection Projection() {
        return new Projection();
    }

    public static Domain Domain(List<Object> values) {
        Domain domain = new Domain();
        domain.values = values;
        return domain;
    }

    public static LegendText LegendText(String title) {
        LegendText legendText = new LegendText();
        legendText.title = title;
        return legendText;
    }

    public static LegendText LegendText(String... titles) {
        LegendText legendText = new LegendText();
        legendText.titles = Arrays.asList(titles);
        return legendText;
    }

    /**
     * Create Horizontal orientation
     *
     * @return
     */
    public static Orientation HorizontalDirection() {
        return Orientation.HORIZONTAL;
    }

    /**
     * Create Vertical orientation
     *
     * @return
     */
    public static Orientation VerticalDirection() {
        return Orientation.VERTICAL;
    }

    public static Legend Legend(Object... elements) {
        Legend legend = new Legend();
        for (Object element : elements) {
            if (element instanceof Orientation) {
                legend.setDirection((Orientation) element);
            } else if (element instanceof String) {
                LegendText legendText = new LegendText();
                legendText.title = (String) element;
                legend.setTitle(legendText);
            } else {
                throw new RuntimeException("Unsupported element for Legend : "+ element);
            }
        }
        return legend;
    }

    public static ScaleResolveMap ScaleResolve(Object... elements) {
        ScaleResolveMap scaleResolveMap = new ScaleResolveMap();
        for (Object element : elements) {
            if (element instanceof ColorResolve) {
                scaleResolveMap.setColor((ColorResolve) element);
            } else if (element instanceof AngleResolve) {
                scaleResolveMap.setAngle((AngleResolve) element);
            } else if (element instanceof FillResolve) {
                scaleResolveMap.setFill((FillResolve) element);
            } else if (element instanceof FillOpacityResolve) {
                scaleResolveMap.setFillOpacity((FillOpacityResolve) element);
            } else if (element instanceof OpacityResolve) {
                scaleResolveMap.setOpacity((OpacityResolve) element);
            } else if (element instanceof RadiusResolve) {
                scaleResolveMap.setRadius((RadiusResolve) element);
            } else if (element instanceof ShapeResolve) {
                scaleResolveMap.setShape((ShapeResolve) element);
            } else if (element instanceof SizeResolve) {
                scaleResolveMap.setSize((SizeResolve) element);
            } else if (element instanceof StrokeResolve) {
                scaleResolveMap.setStroke((StrokeResolve) element);
            } else if (element instanceof StrokeDashResolve) {
                scaleResolveMap.setStrokeDash((StrokeDashResolve) element);
            } else if (element instanceof StrokeOpacityResolve) {
                scaleResolveMap.setStrokeOpacity((StrokeOpacityResolve) element);
            } else if (element instanceof StrokeWidthResolve) {
                scaleResolveMap.setStrokeWidth((StrokeWidthResolve) element);
            } else if (element instanceof ThetaResolve) {
                scaleResolveMap.setTheta((ThetaResolve) element);
            } else if (element instanceof XResolve) {
                scaleResolveMap.setX((XResolve) element);
            } else if (element instanceof YResolve) {
                scaleResolveMap.setY((YResolve) element);
            } else {
                throw new RuntimeException("Unknown vega-lite element");
            }
        }
        return scaleResolveMap;
    }

    public static ColorResolve ColorResolve() {
        return new ColorResolve();
    }

    public static AngleResolve AngleResolve() {
        return new AngleResolve();
    }

    public static FillResolve FillResolve() {
        return new FillResolve();
    }

    private FillOpacityResolve FillOpacityResolve() {
        return new FillOpacityResolve();
    }

    public static OpacityResolve OpacityResolve() {
        return new OpacityResolve();
    }

    public static RadiusResolve RadiusResolve() {
        return new RadiusResolve();
    }

    public static ShapeResolve ShapeResolve() {
        return new ShapeResolve();
    }

    public static SizeResolve SizeResolve() {
        return new SizeResolve();
    }

    public static StrokeResolve StrokeResolve() {
        return new StrokeResolve();
    }

    public static StrokeDashResolve StrokeDashResolve() {
        return new StrokeDashResolve();
    }

    public static StrokeOpacityResolve StrokeOpacityResolve() {
        return new StrokeOpacityResolve();
    }

    public static StrokeWidthResolve StrokeWidthResolve() {
        return new StrokeWidthResolve();
    }

    public static ThetaResolve ThetaResolve() {
        return new ThetaResolve();
    }

    public static XResolve XResolve() {
        return new XResolve();
    }

    public static YResolve YResolve() {
        return new YResolve();
    }

    public static Title Title(Object... elements) {
        Title title = new Title();
        for (Object element : elements) {
            if (element instanceof String) {
                title.title = (String) element;
            } else if (element instanceof List) {
                title.titles = (List<String>) element;
            } else if (element instanceof TitleParams) {
                title.titleParams = (TitleParams) element;
            }
        }
        return title;
    }

    public static TitleParams TitleParams() {
        TitleParams titleParams = new TitleParams();
        return titleParams;
    }

    public static double Radians(double value){
        return  Math.toRadians(value);
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
        chart.setParentView(this.view);
        return chart;
    }

    public Plot data() {
        this.view.setData(new Data());
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

    public Plot concat(int columns, Chart... charts) {
        this.view.setColumns(columns);
        this.view.setConcat(Arrays.asList(charts));
        return this;
    }

    public Plot layer(Object... elements) {
        List<LayerElement> layers = new ArrayList<LayerElement>();
        for (Object element : elements) {
            if (element instanceof Chart) {
                layers.add(PlotUtils.chartToLayerElement((Chart) element));
            } else if (element instanceof Mark) {
                LayerElement layerElement = new LayerElement();
                layerElement.setMark((Mark) element);
                layers.add(layerElement);
            }
        }
        this.view.setLayer(layers);
        return this;
    }

    public Plot resolve(Object... elements) {
        Resolve resolve = null;
        if (this.view.getResolve() == null) {
            resolve = new Resolve();
        }
        for (Object element : elements) {
            if (element instanceof ScaleResolveMap) {
                resolve.setScale((ScaleResolveMap) element);
            } else if (element instanceof LegendResolveMap) {
                resolve.setLegend((LegendResolveMap) element);
            } else if (element instanceof AxisResolveMap) {
                resolve.setAxis((AxisResolveMap) element);
            } else {
                throw new RuntimeException("Unknown vega-lite element");
            }
        }
        this.view.setResolve(resolve);
        return this;
    }

    @JsonIgnore
    @Override
    public String getHTMLDirectory() {
        return htmlDirectory;
    }

    @Override
    public void setHTMLDirectory(String htmlDirectory) {
        this.htmlDirectory = htmlDirectory;
    }

    @Override
    public String toJson() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return objectMapper.writeValueAsString(this.view);
    }

    @JsonIgnore
    @Override
    public DomContent getDomElements() {
        try {
            String div_identifier = UUID.randomUUID().toString();
            Title title = this.view.getTitle();
            Config config = new Config();
            ViewConfig viewConfig = new ViewConfig();
            Background background = new Background();
            background.value = "transparent";
            viewConfig.setStroke(background);
            config.setView(viewConfig);
            this.view.setConfig(config);
            String exportImageTitle = "demat_plot";
            if (title != null) {
                exportImageTitle = title.title;
            }
            String json = "vegaEmbed('#vis" + div_identifier + "'," +
                    toJson() + ",{renderer: 'svg',downloadFileName :'" + exportImageTitle + "'}).catch(console.error);";
            return join(this.withId("vis" + div_identifier), script(rawHtml(json)));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
