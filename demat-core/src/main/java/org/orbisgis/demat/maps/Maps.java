package org.orbisgis.demat.maps;

import org.orbisgis.demat.vega.*;
import org.orbisgis.demat.vega.data.Data;
import org.orbisgis.demat.vega.encoding.Color;
import org.orbisgis.demat.vega.encoding.Encoding;

public class Maps {

    double DEFAULT_MAP_SIZE = 500;

    /**
     * Create a unique values map
     *
     * @return
     */
    public UniqueValuesMap uniqueValuesMap(Data data) {
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
        color.setScale(scale);
        encoding.setColor(color);
        chart.setEncoding(encoding);
        return chart;
    }

    public UniqueValuesMap uniqueValuesMap() {
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
        color.setScale(scale);
        encoding.setColor(color);
        chart.setEncoding(encoding);
        return chart;
    }

    public ChoroplethMap choroplethMap(Data data) {
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
        color.setScale(scale);
        encoding.setColor(color);
        chart.setEncoding(encoding);
        return chart;
    }

    public ManualIntervalMap manualIntervalMap() {
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
        color.setScale(scale);
        encoding.setColor(color);
        chart.setEncoding(encoding);
        return chart;
    }

    public ManualIntervalMap manualIntervalMap(Data data) {
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
        color.setScale(scale);
        encoding.setColor(color);
        chart.setEncoding(encoding);
        return chart;
    }

    public ChoroplethMap choroplethMap() {
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
        color.setScale(scale);
        encoding.setColor(color);
        chart.setEncoding(encoding);
        return chart;
    }
}
