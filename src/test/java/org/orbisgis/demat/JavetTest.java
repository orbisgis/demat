package org.orbisgis.demat;

import com.caoccao.javet.exceptions.JavetException;
import com.caoccao.javet.interop.V8Host;
import com.caoccao.javet.interop.V8Runtime;
import com.caoccao.javet.values.V8Value;
import com.caoccao.javet.values.reference.V8ValueObject;
import com.caoccao.javet.values.reference.V8ValuePromise;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.orbisgis.demat.vega.data.Data;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.orbisgis.demat.Plot.Maps;

public class JavetTest {


    private static Data GRID_INDICATORS = null;
    private static Data RSU_GEOINDICATORS = null;

    @BeforeAll
    public static void loadData() throws IOException {
        LinkedHashMap geojson = (LinkedHashMap) Read.json(JavetTest.class.getClassLoader().getResourceAsStream("rsu_geoindicators.geojson"));
        RSU_GEOINDICATORS = Plot.Data((List<Map>) geojson.get("features"));
        geojson = (LinkedHashMap) Read.json(JavetTest.class.getClassLoader().getResourceAsStream("grid_indicators.geojson"));
        GRID_INDICATORS = Plot.Data((List<Map>) geojson.get("features"));
    }

    @Test
    void testSimpleMapV8Mode() throws Exception {
        long start = System.currentTimeMillis();
        // Step 1: Create a V8 runtime from V8 host in try-with-resource.
        try (V8Runtime v8Runtime = V8Host.getV8Instance().createV8Runtime()) {
             v8Runtime.getExecutor(new File(Plot.class.getResource("vega.js").getPath())).executeVoid();
            v8Runtime.getExecutor(new File(Plot.class.getResource("vega-embed.js").getPath())).executeVoid();
            v8Runtime.getExecutor(new File(Plot.class.getResource("vega-lite.js").getPath())).executeVoid();

            Chart chart = Maps().choroplethMap(RSU_GEOINDICATORS).field("properties.BUILDING_FRACTION").
                    legend("Building fractions").domain(Arrays.asList(0, 0.1, 0.2, 0.3));

            String svgFunction  = "var jsonFile;" +
                    "function svg() {\n" +
                    "var vegaspec = vegaLite.compile(JSON.parse(jsonFile)).spec;"+
                    "    var view = new vega.View(vega.parse(vegaspec))\n" +
                    "            .renderer('none')\n" +
                    "            .initialize()\n" +
                    "            .run()\n" +
                    "            ;\n" +
                    "    return view.toSVG();\n" +
                    "}";
            v8Runtime.getExecutor(svgFunction).executeVoid();

            File outputSVG = new File("/tmp/chart.svg");
            if(outputSVG.exists()){
                outputSVG.delete();
            }
            try (V8ValueObject v8ValueObject = v8Runtime.createV8ValueObject()) {
                v8Runtime.getGlobalObject().set("jsonFile", v8ValueObject);
            }
            v8Runtime.getGlobalObject().set("jsonFile", chart.toJson());
            try (V8ValuePromise v8ValuePromise = v8Runtime.getExecutor(
                    "svg();").execute()) {
                if(v8ValuePromise.isFulfilled()){
                    V8Value result = v8ValuePromise.getResult();
                    try {
                        FileWriter fileWriter = new FileWriter(outputSVG);
                        fileWriter.write(result.toString());
                        fileWriter.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                }
                v8Runtime.await();
            }
            v8Runtime.getGlobalObject().delete("jsonFile");

            long end = System.currentTimeMillis();

            System.out.println("Time "+(end-start));
        } catch (JavetException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testSimpleMapNodeJSMode() throws Exception {
        long start = System.currentTimeMillis();
        // Step 1: Create a V8 runtime from V8 host in try-with-resource.
        try (V8Runtime v8Runtime = V8Host.getNodeInstance().createV8Runtime()) {
            v8Runtime.allowEval(true);
            v8Runtime.getExecutor(new File(Plot.class.getResource("vega.js").getPath())).executeVoid();
            v8Runtime.getExecutor(new File(Plot.class.getResource("vega-embed.js").getPath())).executeVoid();
            v8Runtime.getExecutor(new File(Plot.class.getResource("vega-lite.js").getPath())).executeVoid();

            Chart chart = Maps().choroplethMap(RSU_GEOINDICATORS).field("properties.BUILDING_FRACTION").
                    legend("Building fractions").domain(Arrays.asList(0, 0.1, 0.2, 0.3));

            String svgFunction  = "var jsonFile;" +
                    "function svg() {\n" +
                    "var vegaspec = vegaLite.compile(JSON.parse(jsonFile)).spec;"+
                    "    var view = new vega.View(vega.parse(vegaspec))\n" +
                    "            .renderer('none')\n" +
                    "            .initialize()\n" +
                    "            .run()\n" +
                    "            ;\n" +
                    "    return view.toSVG();\n" +
                    "}";
            v8Runtime.getExecutor(svgFunction).executeVoid();

            File outputSVG = new File("/tmp/chart.svg");
            if(outputSVG.exists()){
                outputSVG.delete();
            }
            try (V8ValueObject v8ValueObject = v8Runtime.createV8ValueObject()) {
                v8Runtime.getGlobalObject().set("jsonFile", v8ValueObject);
            }
            v8Runtime.getGlobalObject().set("jsonFile", chart.toJson());
            try (V8ValuePromise v8ValuePromise = v8Runtime.getExecutor(
                    "svg();").execute()) {
                if(v8ValuePromise.isFulfilled()){
                    V8Value result = v8ValuePromise.getResult();
                    try {
                        FileWriter fileWriter = new FileWriter(outputSVG);
                        fileWriter.write(result.toString());
                        fileWriter.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                }
                v8Runtime.await();
            }
            v8Runtime.getGlobalObject().delete("jsonFile");

            long end = System.currentTimeMillis();

            System.out.println("Time "+(end-start));
        } catch (JavetException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
