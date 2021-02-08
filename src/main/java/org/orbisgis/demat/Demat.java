package org.orbisgis.demat;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.orbisgis.demat.v4.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class Demat {


    View view ;



    public void setView(View view) {
        this.view = view;
    }

    public View getView() {
        return view;
    }

    /**
     * Create a chart object
     * it refers to a single view configuration for vega-lite
     * @return
     */
    public static View view() {
        Demat demat = new Demat();
        View view = new View();
        view.setSchema("https://vega.github.io/schema/vega-lite/v4.json");
        demat.setView(view);
        return view;
    }

    /**
     * Create inline values data from a two dimensional array
     *
     * @param values
     * @return
     */
    public static Data data(Object[][] values) {
        Data data = new Data();
        data.setValues(ViewUtils.urlDataInlineDataset(values));
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
        data.setValues(ViewUtils.urlDataInlineDataset(values));
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


    public static ColorClass color(String fieldValue) {
        ColorClass colorClass = new ColorClass();
        colorClass.setField(new Field(fieldValue));
        return colorClass;
    }

    public static ColorClass color() {
        return new ColorClass();
    }

    public static YClass Y() {
        return new YClass();
    }

    public static YClass Y(String fieldValue) {
        YClass yClass = new YClass();
        yClass.setField(new Field(fieldValue));
        return yClass;
    }

    public static void hconcat(View... views) {

    }


    public static LinkedHashMap<Object,Object> fromJson(File jsonFile) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return (LinkedHashMap<Object,Object>) mapper.readValue(jsonFile, Object.class);
    }

    public static LinkedHashMap<Object,Object>  fromJson(InputStream reader) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return (LinkedHashMap<Object,Object>) mapper.readValue(reader, Object.class);
    }
}
