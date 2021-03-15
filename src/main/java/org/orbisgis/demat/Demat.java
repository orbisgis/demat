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

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * Main class to manage vega-lite element and build the vega-lite views
 * @author Erwan Bocher, CNRS 2021
 */
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
