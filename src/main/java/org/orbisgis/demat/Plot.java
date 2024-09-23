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
 * Copyright (C) 2021-2024 CNRS (Lab-STICC UMR CNRS 6285)
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

import com.caoccao.javet.exceptions.JavetException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.orbisgis.data.api.dataset.ITable;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

/**
 * Main class to renderer vega-lite spec
 *
 * @author Erwan Bocher, CNRS 2023-2024
 */
public class Plot {

    // The folder to store the vega-lite libraries
    private static String DEMAT_FOLDER = System.getProperty("java.io.tmpdir") + File.separator + "demat";

    private static String VEGA_SCHEMA = "https://vega.github.io/schema/vega-lite/v5.json";
    private static ObjectMapper jsonMapper;

    /**
     * Method to transform the VEGA spec as SVG file
     */
    static public void toSVG(Map spec, String path) throws IOException, JavetException {
         toSVG(spec, Path.of(path).toFile());
    }

    /**
     * Method to transform the VEGA spec as SVG file
     */
    static public void toSVG(Map spec, File path) throws IOException, JavetException {
        if (spec == null || spec.isEmpty()) {
            throw new RuntimeException("The input spec cannot be null or empty");
        }
        prepareSpec(spec);
        if (FileUtils.isExtensionWellFormated(path, "svg")) {
            IOUtils.saveAsSVG(getJSONMapper().writeValueAsString(spec), DEMAT_FOLDER, path, true);
        } else {
            throw new RuntimeException("Wrong file extension. Please set .svg");
        }
    }

    /**
     * Method to transform the VEGA spec as JSON file
     */
    static public void toJSON(Map spec, String path) throws IOException, JavetException {
        toJSON(spec,  Path.of(path).toFile());
    }

    /**
     * Method to transform the VEGA spec as JSON file
     */
    static public void toJSON(Map spec, File path) throws IOException, JavetException {
        if (spec == null || spec.isEmpty()) {
            throw new RuntimeException("The input spec cannot be null or empty");
        }
        prepareSpec(spec);
        if (FileUtils.isExtensionWellFormated(path, "json")) {
            IOUtils.saveAsJSON(getJSONMapper().writeValueAsString(spec), path, true);
        } else {
            throw new RuntimeException("Wrong file extension. Please set .json");
        }
    }

    /**
     * Method to transform the VEGA spec as PNG file
     */
    static public void toPNG(Map spec, String path) throws IOException, JavetException {
        toPNG(spec,  Path.of(path).toFile());
    }

    /**
     * Method to transform the VEGA spec as PNG file
     */
    static public void toPNG(Map spec, File path) throws IOException, JavetException {
        if (spec == null || spec.isEmpty()) {
            throw new RuntimeException("The input spec cannot be null or empty");
        }
        prepareSpec(spec);
        if (FileUtils.isExtensionWellFormated(path, "png")) {
            IOUtils.saveAsPNG(getJSONMapper().writeValueAsString(spec), DEMAT_FOLDER, path, true);
        } else {
            throw new RuntimeException("Wrong file extension. Please set .png");
        }
    }

    /**
     * Method to transform the VEGA spec as HTML file
     */
    static public void toHTML(Map spec, String path) throws IOException, JavetException {
        toHTML(spec, Path.of(path).toFile());
    }



        /**
         * Method to transform the VEGA spec as HTML file
         */
    static public void toHTML(Map spec, File path) throws IOException, JavetException {
        if (spec == null || spec.isEmpty()) {
            throw new RuntimeException("The input spec cannot be null or empty");
        }
        //Put the default vega json schema
        spec.put("$schema", VEGA_SCHEMA);
        IOUtils.saveAsHTML(getJSONMapper().writeValueAsString(spec), DEMAT_FOLDER, path, true);
    }

    /**
     * Get the jackson object to map POJO to json
     *
     * @return
     */
    static ObjectMapper getJSONMapper() {
        if (jsonMapper == null) {
            jsonMapper = new ObjectMapper();
            SimpleModule tableModule = new SimpleModule();
            tableModule.addSerializer(ITable.class, new TableSerializer());
            jsonMapper.registerModule(tableModule);
            SimpleModule localFileModule = new SimpleModule();
            localFileModule.addSerializer(LocalFile.class, new LocalFileSerializer());
            jsonMapper.registerModule(localFileModule);
        }
        return jsonMapper;
    }

    /**
     * Show the spec in an HTML file
     *
     * @param spec
     */
    static void show(Map spec) {
        try {
            File outputFile = File.createTempFile("demat", ".html", checkShowDir());
            toHTML(spec, outputFile);
            FileUtils.openBrowser(outputFile.getAbsolutePath());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Check the show directory file
     *
     * @return
     */
    static File checkShowDir() {
        File showDirFile = new File(getDematFolder());
        if (!showDirFile.isDirectory() && !showDirFile.exists()) {
            showDirFile.mkdir();
        } else if (!showDirFile.isDirectory()) {
            throw new RuntimeException("Invalid directory path");
        }
        return showDirFile;
    }

    /**
     * Return the folder used to store vega js files
     *
     * @return
     */
    public static String getDematFolder() {
        return DEMAT_FOLDER;
    }

    /**
     * Change the default demat folder used to store vega js files
     *
     * @param dematFolder
     */
    public static void setDematFolder(String dematFolder) {
        DEMAT_FOLDER = dematFolder;
    }

    /**
     * Iterate over the vega spec to replace local file
     * @param spec
     * @return
     */
    private static Map prepareSpec(Map spec ){
        if (spec == null || spec.isEmpty()) {
            throw new RuntimeException("The input spec cannot be null or empty");
        }
        //Put the default vega json schema
        spec.put("$schema", VEGA_SCHEMA);
        findDeep(spec);
        return spec;
    }

    /**
     * Replace the local file set in data:url to use an internal serializer
     * that read the file
     * @param m input map
     */
    static void findDeep(Object m) {
        if (m instanceof List) {
            ((List<?>) m).forEach(val -> findDeep(val));
        } else if (m instanceof Map) {
            for (var entry : ((Map<?, ?>) m).entrySet()) {
                if(entry.getValue() instanceof Map){
                    replace((Map) entry.getValue());
                }else{
                    findDeep(entry.getValue());
                }
            }
        }
    }

    /**
     * Replace the local file by the serializer
     * @param data input data entry
     */
    static void replace (Map data) {
        String url = (String) data.get("url");
        if (url!=null) {
            if (!url.startsWith("http")) {
                if (url.endsWith(".json") || url.endsWith(".csv") || url.endsWith(".tsv")|| url.endsWith(".geojson")) {
                    //Let's replace it with by the LocalFile object.
                    data.remove("url");
                    data.put("values", new LocalFile(url));
                }
            }
        }
    }

}
