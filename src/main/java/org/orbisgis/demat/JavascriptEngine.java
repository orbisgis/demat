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
import com.caoccao.javet.interop.V8Host;
import com.caoccao.javet.interop.V8Runtime;
import com.caoccao.javet.interop.engine.IJavetEngine;
import com.caoccao.javet.interop.engine.JavetEnginePool;
import com.caoccao.javet.values.V8Value;
import com.caoccao.javet.values.reference.V8ValueObject;
import com.caoccao.javet.values.reference.V8ValuePromise;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kitfox.svg.SVGException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This class uses the javet library to execute javascript code on V8 runtime
 *
 * @author Erwan Bocher, CNRS 2023-2024
 */
public class JavascriptEngine {

    V8Host v8Host;
    JavetEnginePool<V8Runtime> javetEnginePool;
    private V8Runtime v8Runtime;

    private String jsDirectory;

    private ObjectMapper jsonMapper;

    /**
     * Initialize JavetEnginePool
     */
    public JavascriptEngine(String jsDirectory) {
        v8Host = V8Host.getNodeInstance();
        javetEnginePool = new JavetEnginePool<>();
        //TODO update -> javetEnginePool.getConfig().setEngineGuardCheckIntervalMillis(1000);
        javetEnginePool.getConfig().setJSRuntimeType(v8Host.getJSRuntimeType());
        this.jsDirectory = jsDirectory;
        try {
            initV8Engine();
        } catch (JavetException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public V8Host getV8Host() {
        return v8Host;
    }


    void initV8Engine() throws JavetException, IOException {
        FileUtils.deployJSFiles(new File(jsDirectory));
        IJavetEngine iJavetEngine = javetEnginePool.getEngine();
        v8Runtime = iJavetEngine.getV8Runtime();
        v8Runtime.allowEval(true);
        //Loading the vega-lite libs
        v8Runtime.getExecutor(new File(jsDirectory + File.separator + FileUtils.JS_FOLDER + File.separator + FileUtils.JS_FILES[0])).executeVoid();
        v8Runtime.getExecutor(new File(jsDirectory + File.separator + FileUtils.JS_FOLDER + File.separator + FileUtils.JS_FILES[1])).executeVoid();

        //Loading the SVG function
        String svgFunction = "var jsonFile;"+
                "function svg() {\n" +
                "var vegaspec = vegaLite.compile(JSON.parse(jsonFile)).spec;" +
                "    var view = new vega.View(vega.parse(vegaspec))\n" +
                "            .renderer('none')\n" +
                "            .initialize()\n" +
                "            .run()\n" +
                "            ;\n" +
                "    return view.toSVG();\n" +
                "}";
        v8Runtime.getExecutor(svgFunction).executeVoid();
        jsonMapper = new ObjectMapper();

    }

    /**
     * Save the vega-lite chart in a SVG file
     *
     * @param outputFile the file to store the result
     * @return the absolute path of the file
     */
    public String saveSVG(String json, File outputFile, boolean delete) throws JavetException, IOException {
        if (outputFile.exists()) {
            if (delete) {
                outputFile.delete();
            }
        }
        boolean success = false;
        try (V8ValueObject v8ValueObject = v8Runtime.createV8ValueObject()) {
            v8Runtime.getGlobalObject().set("jsonFile", v8ValueObject);
        }
        v8Runtime.getGlobalObject().set("jsonFile", json);

        try (V8ValuePromise v8ValuePromise = v8Runtime.getExecutor(
                "svg();").execute()) {
            v8Runtime.await();
            if (v8ValuePromise.isFulfilled()) {
                V8Value result = v8ValuePromise.getResult();
                try {
                    FileWriter fileWriter = new FileWriter(outputFile);
                    fileWriter.write(result.toString());
                    fileWriter.close();
                    success = true;
                } catch (IOException e) {
                    v8Runtime.getGlobalObject().delete("jsonFile");
                    throw new RuntimeException(e);
                }
            }
        }
        v8Runtime.getGlobalObject().delete("jsonFile");
        if (!success) {
            throw new RuntimeException("Cannot save the SVG file");
        }
        return outputFile.getAbsolutePath();
    }


    /**
     * Save the vega-lite chart in a PNG file
     *
     * @param outputFile
     * @param vega_spec the input vega spec
     * @param outputFile the file to store the result
     * @return the absolute path of the file
     */
    public String savePNG(String vega_spec, File outputFile, boolean delete, float ratio) throws JavetException {
        if (outputFile.exists()) {
            if (delete) {
                outputFile.delete();
            }
        }
        boolean success = false;
        try (V8ValueObject v8ValueObject = v8Runtime.createV8ValueObject()) {
            v8Runtime.getGlobalObject().set("jsonFile", v8ValueObject);
        }
        v8Runtime.getGlobalObject().set("jsonFile", vega_spec);

        try (V8ValuePromise v8ValuePromise = v8Runtime.getExecutor(
                "svg();").execute()) {
            v8Runtime.await();
            if (v8ValuePromise.isFulfilled()) {
                V8Value result = v8ValuePromise.getResult();
                try {
                    SvgRasterizer svgRasterizer =  new SvgRasterizer();
                    svgRasterizer.save(result.toString(), ratio, outputFile);
                    success = true;
                } catch (IOException | SVGException e) {
                    v8Runtime.getGlobalObject().delete("jsonFile");
                    throw new RuntimeException(e);
                }
            }
        }
        v8Runtime.getGlobalObject().delete("jsonFile");
        if (!success) {
            throw new RuntimeException("Cannot save the PNG file");
        }
        return outputFile.getAbsolutePath();
    }


    public void setDirectory(String jsDirectory) throws JavetException, IOException {
        if (!this.jsDirectory.equals(jsDirectory)) {
            this.jsDirectory = jsDirectory;
            initV8Engine();
        }
    }
}
