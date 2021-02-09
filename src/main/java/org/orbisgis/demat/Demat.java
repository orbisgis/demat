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
    public static X X(String fieldValue) {
        X x = new X();
        x.setField(new Field(fieldValue));
        return x;
    }

    public static Encoding encoding() {
        Encoding encoding = new Encoding();
        return encoding;
    }


    public static Color color(String fieldValue) {
        Color color = new Color();
        color.setField(new Field(fieldValue));
        return color;
    }

    public static Color color() {
        return new Color();
    }

    public static Y Y() {
        return new Y();
    }

    public static Y Y(String fieldValue) {
        Y y = new Y();
        y.setField(new Field(fieldValue));
        return y;
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
