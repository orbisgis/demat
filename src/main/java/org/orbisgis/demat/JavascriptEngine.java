package org.orbisgis.demat;

import com.caoccao.javet.exceptions.JavetException;
import com.caoccao.javet.interop.V8Host;
import com.caoccao.javet.interop.V8Runtime;
import com.caoccao.javet.interop.engine.IJavetEngine;
import com.caoccao.javet.interop.engine.JavetEnginePool;
import com.caoccao.javet.values.V8Value;
import com.caoccao.javet.values.reference.V8ValueObject;
import com.caoccao.javet.values.reference.V8ValuePromise;
import com.kitfox.svg.SVGException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This class uses the javet library to execute javascript code on V8 runtime
 *
 * @author Erwan Bocher, CNRS 2023
 */
public class JavascriptEngine {

    V8Host v8Host;
    JavetEnginePool<V8Runtime> javetEnginePool;
    private V8Runtime v8Runtime;

    private String jsDirectory;

    /**
     * Initialize JavetEnginePool
     */
    public JavascriptEngine(String jsDirectory) {
        v8Host = V8Host.getNodeInstance();
        javetEnginePool = new JavetEnginePool<>();
        javetEnginePool.getConfig().setEngineGuardCheckIntervalMillis(1000);
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
        String svgFunction = "var jsonFile;" +
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
    }

    /**
     * Save the vega-lite chart in a SVG file
     *
     * @param outputFile
     * @return
     * @throws JavetException
     */
    public String saveSVG(String vega_spec, File outputFile, boolean delete) throws JavetException, IOException {
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
     * @return
     * @throws JavetException
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
