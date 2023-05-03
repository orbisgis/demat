package org.orbisgis.demat;

import com.caoccao.javet.exceptions.JavetException;
import java.io.*;

public class IOUtils{
    private static JavascriptEngine javascriptEngine;


    static String saveAsPNG(String json, String jsDirectory, File outputImage, boolean delete) throws IOException, JavetException {
        if(javascriptEngine==null) {
            javascriptEngine=new JavascriptEngine(jsDirectory);
        }
        javascriptEngine.setDirectory(jsDirectory);
        return javascriptEngine.savePNG(json, outputImage, delete, 2);
    }

    static String saveAsSVG(String json, String jsDirectory, File outputSVG, boolean delete) throws IOException, JavetException {
        if(javascriptEngine==null) {
            javascriptEngine=new JavascriptEngine(jsDirectory);
        }
        javascriptEngine.setDirectory(jsDirectory);
        return javascriptEngine.saveSVG(json, outputSVG, delete);
    }

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
}
