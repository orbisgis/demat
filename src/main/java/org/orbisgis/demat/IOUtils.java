package org.orbisgis.demat;

import com.kitfox.svg.SVGException;
import org.graalvm.polyglot.*;
import java.awt.*;
import java.io.*;
import java.util.function.Consumer;

public class IOUtils {
    static Engine engine = null;
    private static Source vega_js;
    private static Source vega_lite;
    private static Source svgFunctionCompiled;


    static void saveAsPNG(String json, String jsDirectory, File outputImage, boolean delete) throws IOException {
        if (outputImage.exists()) {
            if (delete) {
                outputImage.delete();
            }
        }
        FileUtils.deployJSFiles(new File(jsDirectory));
        if(engine==null) {
            engine = Engine.newBuilder()
                    .option("engine.WarnInterpreterOnly", "false")
                    .build();
            Source.Builder source = Source.newBuilder("js", new File(jsDirectory+  File.separator + FileUtils.JS_FOLDER + File.separator + FileUtils.JS_FILES[0]));
            vega_js = source.build();
            Source.Builder source2 = Source.newBuilder("js", new File(jsDirectory+  File.separator + FileUtils.JS_FOLDER + File.separator + FileUtils.JS_FILES[1]));
            vega_lite = source2.build();
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
            Source.Builder svgFunctionSrc = Source.newBuilder("js", svgFunction, "svg");
            svgFunctionCompiled = svgFunctionSrc.build();
        }
        Context ctx = Context.newBuilder("js").allowHostClassLookup(s -> true)
                .allowHostAccess(HostAccess.ALL).engine(engine).build();
        ctx.eval(vega_js);
        ctx.eval(vega_lite);
        ctx.eval(svgFunctionCompiled);

        ctx.getBindings("js").putMember("jsonFile", json);
        Value jsPromise = ctx.eval("js", "svg();");
        Consumer<Object> javaThen = (value) -> {
            SvgRasterizer svgRasterizer =  new SvgRasterizer();
            try {
                svgRasterizer.save(value.toString(), new Dimension(800, 800), outputImage);
            } catch (SVGException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
        jsPromise.invokeMember("then", javaThen);
    }

    static void saveAsSVG(String json, String jsDirectory, File outputSVG, boolean delete) throws IOException {
        if (outputSVG.exists()) {
            if (delete) {
                outputSVG.delete();
            }
        }
        FileUtils.deployJSFiles(new File(jsDirectory));
        if(engine==null) {
            engine = Engine.newBuilder()
                    .option("engine.WarnInterpreterOnly", "false")
                    .build();
        }
        Context ctx = Context.newBuilder("js").allowHostClassLookup(s -> true)
                .allowHostAccess(HostAccess.ALL).engine(engine).build();
        Source.Builder source = Source.newBuilder("js", new File(jsDirectory+  File.separator + FileUtils.JS_FOLDER + File.separator + FileUtils.JS_FILES[0]));
        ctx.eval( source.build());
        Source.Builder source2 = Source.newBuilder("js", new File(jsDirectory+  File.separator + FileUtils.JS_FOLDER + File.separator + FileUtils.JS_FILES[1]));
        ctx.eval( source2.build());

        Source.Builder source3 = Source.newBuilder("js", new File(jsDirectory+  File.separator + FileUtils.JS_FOLDER + File.separator + FileUtils.JS_FILES[2]));
        ctx.eval( source3.build());

        String svgFunction  = "var jsonFile;" +
                "function svg() {\n" +
                "var vegaspec = vegaLite.compile(JSON.parse(jsonFile)).spec;"+
                "    var view = new vega.View(vega.parse(vegaspec))\n" +
                "            .renderer('svg')\n" +
                "            .initialize()\n" +
                "            .run()\n" +
                "            ;\n" +
                "    return view.toSVG();\n" +
                "}";
        Source.Builder svgFunctionSrc = Source.newBuilder("js", svgFunction, "svg");
        ctx.eval(svgFunctionSrc.build());

        ctx.getBindings("js").putMember("jsonFile", json);
        Value jsPromise = ctx.eval("js", "svg();");

        Consumer<Object> javaThen = (value) -> {
            try {
                FileWriter fileWriter = new FileWriter(outputSVG);
                fileWriter.write(value.toString());
                fileWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
        jsPromise.invokeMember("then", javaThen);
    }

    static void saveAsJSON(String json, File outputJson, boolean delete){
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
    }
}
