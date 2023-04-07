package org.orbisgis.demat;


import com.fasterxml.jackson.core.JsonProcessingException;
import j2html.tags.DomContent;
import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Engine;
import org.graalvm.polyglot.HostAccess;
import org.graalvm.polyglot.Source;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static j2html.TagCreator.*;

public interface IRenderer {


    String getHTMLDirectory();

    /**
     * Set a new directory path to store the HTML file generated
     * for rendering vegalite view
     *
     * @param htmlDirectory
     */
    void setHTMLDirectory(String htmlDirectory);

    /**
     * Check the show directory file
     *
     * @return
     */
    default File checkShowDir() {
        File showDirFile = new File(getHTMLDirectory());
        if (!showDirFile.isDirectory() && !showDirFile.exists()) {
            showDirFile.mkdir();
        } else if (!showDirFile.isDirectory()) {
            throw new RuntimeException("Invalid directory path");
        }
        return showDirFile;
    }

    default void show() {
        try {
            File outputFile = File.createTempFile("demat", ".html", checkShowDir());
            save(outputFile, true);
            PlotUtils.openBrowser(outputFile.getAbsolutePath());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    default String save() throws IOException {
        return save(new File(getHTMLDirectory()), true);
    }

    default String save(String path) throws IOException {
        return save(new File(path), true);
    }

    default String save(File file) throws IOException {
        return save(file, true);
    }

    /**
     * Save into an html file
     *
     * @param outputFile
     * @param delete
     * @return
     */
    default String save(File outputFile, boolean delete) throws IOException {
        if(FileUtils.isExtensionWellFormated(outputFile,"png")){
            try {
                IOUtils.saveAsPNG(toJson(), getHTMLDirectory(), outputFile, delete);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        else if(FileUtils.isExtensionWellFormated(outputFile,"svg")){
            try {
                IOUtils.saveAsSVG(toJson(), getHTMLDirectory(), outputFile, delete);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        else if(FileUtils.isExtensionWellFormated(outputFile,"json")){
                IOUtils.saveAsJSON(toJson(), outputFile, delete);
        }
        else if(FileUtils.isExtensionWellFormated(outputFile,"html")) {
            String jsDirectory = getHTMLDirectory();
            FileUtils.deployJSFiles(new File(jsDirectory));
            if (outputFile == null) {
                return null;
            }
            if (outputFile.exists()) {
                if (delete) {
                    outputFile.delete();
                } else {
                    return null;
                }
            }
            FileWriter fileWriter = new FileWriter(outputFile);
            html(
                    head(
                            meta().withCharset("UTF-8"),
                            script().withSrc(jsDirectory + File.separator + FileUtils.JS_FOLDER + File.separator + FileUtils.JS_FILES[0]),
                            script().withSrc(jsDirectory + File.separator + FileUtils.JS_FOLDER + File.separator + FileUtils.JS_FILES[1]),
                            script().withSrc(jsDirectory + File.separator + FileUtils.JS_FOLDER + File.separator + FileUtils.JS_FILES[2])
                    ),
                    body(getDomElements())
            ).render(fileWriter);
            fileWriter.close();
            return outputFile.getAbsolutePath();
        }else {
            throw new RuntimeException("Cannot save the file " + outputFile.getAbsolutePath());
        }
        return null;
    }

    DomContent getDomElements();

    /**
     * Build a json representation of the chart
     *
     * @return
     * @throws JsonProcessingException
     */
    String toJson() throws JsonProcessingException;
}
