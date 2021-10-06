package org.orbisgis.demat;


import j2html.tags.DomContent;

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


    /**
     * Save into an html file
     *
     * @param outputFile
     * @param delete
     * @return
     */
    default String save(File outputFile, boolean delete) throws IOException {
        FileUtils.deployJSFiles(new File(getHTMLDirectory()));
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
                        script().withSrc(FileUtils.JS_FOLDER + File.separator + FileUtils.JS_FILES[0]),
                        script().withSrc(FileUtils.JS_FOLDER + File.separator + FileUtils.JS_FILES[1]),
                        script().withSrc(FileUtils.JS_FOLDER + File.separator + FileUtils.JS_FILES[2])
                ),
                body(getDomElements())
        ).render(fileWriter);
        fileWriter.close();
        return outputFile.getAbsolutePath();
    }

    DomContent getDomElements();
}
