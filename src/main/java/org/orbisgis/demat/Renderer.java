package org.orbisgis.demat;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static j2html.TagCreator.*;

public class Renderer implements IRenderer {

    private final View view;
    private String showDir = System.getProperty("java.io.tmpdir") + File.separator + "demat";

    public Renderer(View view) {
        this.view = view;
    }

    public View getView() {
        return this.view;
    }

    /**
     * Set a new directory path to store the HTML file generated
     * for rendering vegalite view
     *
     * @return
     */
    public void setShowDir(String showDirPath) {
        this.showDir = showDirPath;
    }

    /**
     * Check the show directory file
     *
     * @return
     */
    public File checkShowDir() {
        File showDirFile = new File(showDir);
        if (!showDirFile.isDirectory() && !showDirFile.exists()) {
            showDirFile.mkdir();
        } else if (!showDirFile.isDirectory()) {
            throw new RuntimeException("Invalid directory path");
        }
        return showDirFile;
    }

    /**
     * Show the vega-lite chart in the default browser of the OS
     * Save the html file in a tmp file
     */
    public void show() {
        try {
            File outputFile = File.createTempFile("demat", ".html", checkShowDir());
            this.save(outputFile, true);
            PlotUtils.openBrowser(outputFile.getAbsolutePath());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Save into the show directory
     *
     * @return
     */
    public String save() throws IOException {
        File outputFile = File.createTempFile("demat", ".html", checkShowDir());
        return save(outputFile.getAbsolutePath());
    }

    /**
     * Save into an html file
     * Delete if it exists
     *
     * @param path
     * @return
     */
    public String save(String path) throws IOException {
        return save(path, true);
    }

    /**
     * Save into an html file
     *
     * @param outputFile
     * @param delete
     * @return
     */
    public String save(File outputFile, boolean delete) throws IOException {
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
        StringBuilder json = new StringBuilder("var spec =\n");
        json.append(toJson()).append(";\n var opt = {\"renderer\": \"canvas\", \"actions\": true,\"scaleFactor\":2};\n" +
                " vegaEmbed(\"#vis\", spec, opt);");
        FileWriter fileWriter = new FileWriter(outputFile);
        html(
                head(
                        meta().withCharset("UTF-8"),
                        script().withSrc("https://cdn.jsdelivr.net/npm/vega@5.19.1"),
                        script().withSrc("https://cdn.jsdelivr.net/npm/vega-lite@5.0.0"),
                        script().withSrc("https://cdn.jsdelivr.net/npm/vega-embed@6.15.1")
                ),
                body(
                        div().withId("vis"),
                        script(rawHtml(json.toString()))

                )
        ).render(fileWriter);
        fileWriter.close();
        return outputFile.getAbsolutePath();
    }

    /**
     * Save into an html file
     *
     * @param path
     * @param delete
     * @return
     */
    public String save(String path, boolean delete) throws IOException {
        return save(new File(path), delete);
    }

    public String toJson() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return objectMapper.writeValueAsString(this.getView());
    }


}
