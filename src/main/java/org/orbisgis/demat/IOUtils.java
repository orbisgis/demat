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
import j2html.tags.UnescapedText;

import java.io.*;

import static j2html.TagCreator.*;

/**
 * @author Erwan Bocher, CNRS 2023-2024
 */
public class IOUtils{
    private static JavascriptEngine javascriptEngine;


    /**
     * Run vega-lite js and rasterize the svg spec as PNG
     *
     * @param json
     * @param jsDirectory
     * @param outputImage
     * @param delete
     * @return
     * @throws IOException
     * @throws JavetException
     */
    static String saveAsPNG(String json, String jsDirectory, File outputImage, boolean delete) throws IOException, JavetException {
        if(javascriptEngine==null) {
            javascriptEngine=new JavascriptEngine(jsDirectory);
        }
        javascriptEngine.setDirectory(jsDirectory);
        return javascriptEngine.savePNG(json, outputImage, delete, 2);
    }

    /**
     * Run vega-lite js and save into a svg file the spec
     *
     * @param spec
     * @param jsDirectory
     * @param outputSVG
     * @param delete
     * @return
     * @throws IOException
     * @throws JavetException
     */
    static String saveAsSVG(String spec, String jsDirectory, File outputSVG, boolean delete) throws IOException, JavetException {
        if(javascriptEngine==null) {
            javascriptEngine=new JavascriptEngine(jsDirectory);
        }
        javascriptEngine.setDirectory(jsDirectory);
        return javascriptEngine.saveSVG(spec, outputSVG, delete);
    }

    /**
     * Save a  json
     * @param json
     * @param outputJson
     * @param delete
     * @return
     */
    static String saveAsJSON(String json, File outputJson, boolean delete){
        if (outputJson.exists()) {
            if (delete) {
                outputJson.delete();
            }
        }
        try {
            FileWriter fileWriter = new FileWriter(outputJson);
            fileWriter.write(json);
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return outputJson.getAbsolutePath();
    }

    /**
     * Save the vega-spec as and HTML file
     * @param json
     * @param jsDirectory
     * @param outputHTML
     * @param delete
     * @return
     * @throws IOException
     */
    static String saveAsHTML(String json, String jsDirectory, File outputHTML, boolean delete) throws IOException {
        FileUtils.deployJSFiles(new File(jsDirectory));
        if (outputHTML == null) {
            return null;
        }
        if (outputHTML.exists()) {
            if (delete) {
                outputHTML.delete();
            } else {
                return null;
            }
        }
        StringBuilder vega_embed = new StringBuilder("vegaEmbed('#").append("demat").append("',");
        vega_embed.append(json).append(",{renderer: 'svg',downloadFileName :'").append("demat_chart").append("'}).catch(console.error);");
        UnescapedText body = join(div().withId("demat"), script(rawHtml(vega_embed.toString())));
        FileWriter fileWriter = new FileWriter(outputHTML);
        html(
                head(
                        meta().withCharset("UTF-8"),
                        script().withSrc(jsDirectory + File.separator + FileUtils.JS_FOLDER + File.separator + FileUtils.JS_FILES[0]),
                        script().withSrc(jsDirectory + File.separator + FileUtils.JS_FOLDER + File.separator + FileUtils.JS_FILES[1]),
                        script().withSrc(jsDirectory + File.separator + FileUtils.JS_FOLDER + File.separator + FileUtils.JS_FILES[2])
                ),
                body(body)
        ).render(fileWriter);
        fileWriter.close();
        return outputHTML.getAbsolutePath();
    }
}
