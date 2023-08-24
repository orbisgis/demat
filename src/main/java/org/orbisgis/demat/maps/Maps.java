package org.orbisgis.demat.maps;

import org.h2gis.utilities.JDBCUtilities;
import org.orbisgis.data.api.dataset.ITable;
import org.orbisgis.data.api.dsl.IFilterBuilder;
import org.orbisgis.demat.PlotUtils;
import org.orbisgis.demat.vega.*;
import org.orbisgis.demat.vega.data.Data;
import org.orbisgis.demat.vega.encoding.Color;
import org.orbisgis.demat.vega.encoding.Encoding;
import org.orbisgis.demat.vega.legend.Legend;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Maps {

    static double DEFAULT_MAP_SIZE = 500;

    /**
     * Create a unique values map with the first column as default value to map
     *
     * @return
     */
    public static UniqueValuesMap uniqueValues(IFilterBuilder filterBuilder) {
        return uniqueValues(filterBuilder.getTable());
    }
    /**
     * Create a unique values map with the first column as default value to map
     *
     * @return
     */
    public static UniqueValuesMap uniqueValues(ITable table) {
        String firstColumn = PlotUtils.getFirstNoGeomColumn(table);
        Data data1 = new Data();
        data1.setTable(table);
        UniqueValuesMap map = Maps.uniqueValues(data1);
        if(firstColumn!=null && !firstColumn.isEmpty()){
            map.field("properties."+firstColumn);
        }
        return map;
    }

    /**
     * Create a unique values map
     *
     * @return
     */
    public static UniqueValuesMap uniqueValues(Data data) {
        UniqueValuesMap chart = new UniqueValuesMap();
        Projection projection = new Projection();
        projection.setType(ProjectionType.IDENTITY);
        chart.setProjection(projection);
        Height height = new Height();
        height.size = DEFAULT_MAP_SIZE;
        chart.setHeight(height);
        chart.setWidth(height);
        chart.setData(data);
        chart.setData(data);
        Color color = new Color();
        Scale scale = new Scale();
        Mark mark = new Mark();
        mark.type = "geoshape";
        chart.setMark(mark);
        Encoding encoding = new Encoding();
        Legend legend = new Legend();
        color.setLegend(legend);
        color.setScale(scale);
        encoding.setColor(color);
        chart.setEncoding(encoding);
        return chart;
    }

    public static UniqueValuesMap uniqueValues() {
        UniqueValuesMap chart = new UniqueValuesMap();
        Projection projection = new Projection();
        projection.setType(ProjectionType.IDENTITY);
        chart.setProjection(projection);
        Height height = new Height();
        height.size = DEFAULT_MAP_SIZE;
        chart.setHeight(height);
        chart.setWidth(height);
        Color color = new Color();
        Scale scale = new Scale();
        Mark mark = new Mark();
        mark.type = "geoshape";
        chart.setMark(mark);
        Encoding encoding = new Encoding();
        Legend legend = new Legend();
        color.setLegend(legend);
        color.setScale(scale);
        encoding.setColor(color);
        chart.setEncoding(encoding);
        return chart;
    }


    public static ChoroplethMap choropleth(IFilterBuilder filterBuilder) {
        return choropleth(filterBuilder.getTable());
    }


    public static ChoroplethMap choropleth(ITable table) {
        String firstColumn = null;
        try {
            firstColumn = JDBCUtilities.getFirstNumericColumn((ResultSetMetaData) table.getMetaData());
        } catch (SQLException e) {
        }
        Data data1 = new Data();
        data1.setTable(table);
        ChoroplethMap map = Maps.choropleth(data1);
        if(firstColumn!=null && !firstColumn.isEmpty()){
            map.field("properties."+firstColumn);
        }
        return map;
    }

    public static ChoroplethMap choropleth(Data data) {
        ChoroplethMap chart = new ChoroplethMap();
        Projection projection = new Projection();
        projection.setType(ProjectionType.IDENTITY);
        chart.setProjection(projection);
        Height height = new Height();
        height.size = DEFAULT_MAP_SIZE;
        chart.setHeight(height);
        chart.setWidth(height);
        chart.setData(data);
        Color color = new Color();
        color.quantitative();
        Scale scale = new Scale();
        Mark mark = new Mark();
        mark.type = "geoshape";
        chart.setMark(mark);
        Encoding encoding = new Encoding();
        Legend legend = new Legend();
        color.setLegend(legend);
        color.setScale(scale);
        encoding.setColor(color);
        chart.setEncoding(encoding);
        return chart;
    }

    public static  ManualIntervalMap manualInterval() {
        ManualIntervalMap chart = new ManualIntervalMap();
        Projection projection = new Projection();
        projection.setType(ProjectionType.IDENTITY);
        chart.setProjection(projection);
        Height height = new Height();
        height.size = DEFAULT_MAP_SIZE;
        chart.setHeight(height);
        chart.setWidth(height);
        Color color = new Color();
        color.quantitative();
        Scale scale = new Scale();
        scale.setType(ScaleType.THRESHOLD);
        Mark mark = new Mark();
        mark.type = "geoshape";
        chart.setMark(mark);
        Encoding encoding = new Encoding();
        Legend legend = new Legend();
        color.setLegend(legend);
        color.setScale(scale);
        encoding.setColor(color);
        chart.setEncoding(encoding);
        return chart;
    }

    public static ManualIntervalMap manualInterval(Data data) {
        ManualIntervalMap chart = new ManualIntervalMap();
        Projection projection = new Projection();
        projection.setType(ProjectionType.IDENTITY);
        chart.setProjection(projection);
        Height height = new Height();
        height.size = DEFAULT_MAP_SIZE;
        chart.setHeight(height);
        chart.setWidth(height);
        chart.setData(data);
        Color color = new Color();
        color.quantitative();
        Scale scale = new Scale();
        scale.setType(ScaleType.THRESHOLD);
        Mark mark = new Mark();
        mark.type = "geoshape";
        chart.setMark(mark);
        Encoding encoding = new Encoding();
        Legend legend = new Legend();
        color.setLegend(legend);
        color.setScale(scale);
        encoding.setColor(color);
        chart.setEncoding(encoding);
        return chart;
    }

    public static ChoroplethMap choropleth() {
        ChoroplethMap chart = new ChoroplethMap();
        Projection projection = new Projection();
        projection.setType(ProjectionType.IDENTITY);
        chart.setProjection(projection);
        Height height = new Height();
        height.size = DEFAULT_MAP_SIZE;
        chart.setHeight(height);
        chart.setWidth(height);
        Color color = new Color();
        color.quantitative();
        Scale scale = new Scale();
        Mark mark = new Mark();
        mark.type = "geoshape";
        chart.setMark(mark);
        Encoding encoding = new Encoding();
        Legend legend = new Legend();
        color.setLegend(legend);
        color.setScale(scale);
        encoding.setColor(color);
        chart.setEncoding(encoding);
        return chart;
    }
}
