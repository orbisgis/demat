package org.orbisgis.demat;

import org.orbisgis.demat.vega.*;

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
        view.setSchema("https://vega.github.io/schema/vega-lite/v5.json");
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
     * Create data values data from a LinkedHashMap
     *
     * @param values
     * @return
     */
    public static Data data (LinkedHashMap values) {
        return ViewUtils.urlData(values);
    }

    /**
     * Create a X encoding
     * @return
     */
    public static X x() {
        return new X();
    }

    /**
     * Return a X encoding class
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
     * @param fieldValue
     * @return
     */
    public static Color color(String fieldValue) {
        Color color = new Color();
        color.setField(new Field(fieldValue));
        return color;
    }

    /**
     * Create a Color encoding
     * @return
     */
    public static Color color() {
        return new Color();
    }

    /**
     * Create a Y encoding
     * @return
     */
    public static Y y() {
        return new Y();
    }

    /**
     * Create a Y encoding
     * @return
     */
    public static Y y(String fieldValue) {
        Y y = new Y();
        y.setField(new Field(fieldValue));
        return y;
    }

    public static void hconcat(View... views) {

    }

    public static Data json(InputStream resourceAsStream) {
        Object json = Read.json(resourceAsStream);
        if(json instanceof LinkedHashMap){
            return data(( LinkedHashMap<Object, Object>)json);
        }
        else if(json instanceof List){
            return  data((List<Map>) json);
        }
        throw new RuntimeException("Unsuported input data");
    }

    /**
     * Load the cars json file provided by vega-lite code source
     * @return
     */
    public static Data cars(){
        try {
            return Read.toData(Demat.class.getResourceAsStream("cars.json"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Load the seattle_weather json file provided by vega-lite code source
     * @return
     */
    public static Data seattle_weather(){
        try {
            return Read.csv(Demat.class.getResourceAsStream("seattle-weather.csv"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
