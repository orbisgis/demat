package org.orbisgis.demat;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.orbisgis.demat.v4.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demat {


    /**
     * Create a chart object
     * it refers to a single view configuration for vega-lite
     * @return
     */
    public static Chart chart() {
        Coordinate coordinate = new Coordinate();
        coordinate.setSchema("https://vega.github.io/schema/vega-lite/v4.json");
        Chart chart = new Chart();
        chart.setCoordinate(coordinate);
        return chart;
    }

    public static URLData urlData(Object[][] values){
        URLData  urlData = new URLData();
        urlData.setValues(urlDataInlineDataset(values));
        return urlData;
    }

    public static URLData urlData(List<Map> values){
        URLData  urlData = new URLData();
        urlData.setValues(urlDataInlineDataset(values));
        return urlData;
    }

    public static URLDataInlineDataset urlDataInlineDataset(List<Map> values) {
        List<InlineDataset> inlines = new ArrayList<InlineDataset>();
        for (Map map :values) {
            InlineDataset inlineDataset = new InlineDataset();
            inlineDataset.anythingMapValue=map;
            inlines.add(inlineDataset);
        }
        URLDataInlineDataset urlDataInlineDataset = new URLDataInlineDataset();
        urlDataInlineDataset.unionArrayValue=inlines;
        return urlDataInlineDataset;
    }

        public static URLDataInlineDataset urlDataInlineDataset(Object[][] values){
        List<InlineDataset> inlines = new ArrayList<InlineDataset>();
        Object[] firstRow = values[0];
        for (int i = 1; i < values.length ; i++) {
            InlineDataset inlineDataset = new InlineDataset();
            Map<String, Object> rows = new HashMap<>();
            Object[] cols = values[i];
            for (int j = 0; j < values.length ; j++) {
                rows.put(String.valueOf(firstRow[j]), cols[j]);
            }
            inlineDataset.anythingMapValue= rows;
            inlines.add(inlineDataset);
        }
        URLDataInlineDataset urlDataInlineDataset = new URLDataInlineDataset();
        urlDataInlineDataset.unionArrayValue=inlines;
        return urlDataInlineDataset;
    }
    /**
     * Create inline values data from a two dimensional array
     *
     * @param values
     * @return
     */
    public static Data data(Object[][] values) {
        Data data = new Data();
        data.setValues(urlDataInlineDataset(values));
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
        data.setValues(urlDataInlineDataset(values));
        return data;
    }

    /**
     * Return a X encoding class
     * @return
     */
    public static XClass X(String fieldValue) {
        XClass xClass = new XClass();
        xClass.setField(new Field(fieldValue));
        return xClass;
    }

    public static Encoding encoding() {
        Encoding encoding = new Encoding();
        return encoding;
    }

    public static YClass Y() {
        return new YClass();
    }

    public static YClass Y(String fieldValue) {
        YClass yClass = new YClass();
        yClass.setField(new Field(fieldValue));
        return yClass;
    }

    public static List<Map> fromJson(File jsonFile) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonFile, new TypeReference<List<Map>>() {});
    }

    public static Map fromJson(InputStream reader) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(reader, Map.class);
    }

}
