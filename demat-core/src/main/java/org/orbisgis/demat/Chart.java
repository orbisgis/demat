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
 * Copyright (C) 2021 CNRS (Lab-STICC UMR CNRS 6285)
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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import j2html.tags.DomContent;
import org.orbisgis.demat.vega.Mark;
import org.orbisgis.demat.vega.NormalizedSpec;
import org.orbisgis.demat.vega.Projection;
import org.orbisgis.demat.vega.Title;
import org.orbisgis.demat.vega.encoding.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;

import static j2html.TagCreator.*;

/**
 * @author  Erwan Bocher, CNRS
 * Parameters to build a chart
 */
public class Chart extends NormalizedSpec implements ViewCommonMethods<Chart> {

    private String id;
    private String htmlDirectory  = System.getProperty("java.io.tmpdir") + File.separator + "demat";

    private View parentView = null;

    public Chart() {
        this.id = "vis" + UUID.randomUUID();
    }


    String save() throws IOException {
        return save(new File(getHTMLDirectory()), true);
    }

    String save(String path) throws IOException {
        return save(new File(path), true);
    }

    /**
     * Save into an html file
     *
     * @param outputFile
     * @param delete
     * @return
     */
    public String save(File outputFile, boolean delete) throws IOException {
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
                        script().withSrc(jsDirectory+  File.separator + FileUtils.JS_FOLDER + File.separator + FileUtils.JS_FILES[0]),
                        script().withSrc(jsDirectory+  File.separator + FileUtils.JS_FOLDER + File.separator + FileUtils.JS_FILES[1])
                ),
                body(getDomElements())
        ).render(fileWriter);
        fileWriter.close();
        return outputFile.getAbsolutePath();
    }

    /**
     * Create a mark_geoshape
     *
     * @return
     */
    public Chart mark_geoshape() {
        Mark mark = new Mark();
        mark.type = "geoshape";
        this.setMark(mark);
        return this;
    }

    /**
     * Create a mark_bar
     *
     * @return
     */
    public Chart mark_bar() {
        Mark mark = new Mark();
        mark.type = "bar";
        this.setMark(mark);
        return this;
    }

    /**
     * Create a mark_rect
     *
     * @return
     */
    public Chart mark_rect() {
        Mark mark = new Mark();
        mark.type = "rect";
        this.setMark(mark);
        return this;
    }

    /**
     * Create a mark_bar
     *
     * @return
     */
    public Chart mark_area() {
        Mark mark = new Mark();
        mark.type = "area";
        this.setMark(mark);
        return this;
    }

    /**
     * Create a mark_tick
     *
     * @return
     */
    public Chart mark_tick() {
        Mark mark = new Mark();
        mark.type = "tick";
        this.setMark(mark);
        return this;
    }

    /**
     * Create a mark_line
     *
     * @return
     */
    public Chart mark_line() {
        Mark mark = new Mark();
        mark.type = "line";
        this.setMark(mark);
        return this;
    }

    /**
     * Create a mark_line
     *
     * @return
     */
    public Chart mark_point() {
        Mark mark = new Mark();
        mark.type = "point";
        this.setMark(mark);
        return this;
    }

    /**
     * Create a mark_square
     *
     * @return
     */
    public Chart mark_square() {
        Mark mark = new Mark();
        mark.type = "square";
        this.setMark(mark);
        return this;
    }

    /**
     * Create a mark_text
     *
     * @return
     */
    public Chart mark_text() {
        Mark mark = new Mark();
        mark.type = "text";
        this.setMark(mark);
        return this;
    }

    /**
     * Add a new Mark to the Chart
     *
     * @return
     */
    public Chart mark(Mark mark) {
        this.setMark(mark);
        return this;
    }

    /**
     * Construct the encoding element
     *
     * @param encodings any encoding elements , X, Y, Color...
     * @return
     */
    public Chart encode(Object... encodings) {
        Encoding encoding = new Encoding();
        for (Object element : encodings) {
            if (element instanceof X) {
                encoding.setX((X) element);
            } else if (element instanceof Y) {
                encoding.setY((Y) element);
            } else if (element instanceof Color) {
                encoding.setColor((Color) element);
            } else if (element instanceof Tooltip) {
                encoding.setTooltip((Tooltip) element);
            }else if (element instanceof TextDef) {
                encoding.setText((TextDef) element);
            }
        }
        this.setEncoding(encoding);
        return this;
    }

    public Projection projection() {
        return new Projection();
    }


    public void setParentView(View view) {
        this.parentView = view;
    }

    @JsonIgnore
    public String getHTMLDirectory() {
        return htmlDirectory;
    }


    @Override
    public void show() throws RendererNotFoundException{
        RendererService rendererService =  RendererService.getInstance();
        rendererService.show(this);
    }

    /**
     * Build a json representation of the chart
     *
     * @return
     * @throws JsonProcessingException
     */
    String toJson() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return objectMapper.writeValueAsString(this);
    }

    @JsonIgnore
    public DomContent getDomElements() {
        try {
            Title title = this.getTitle();
            String exportImageTitle = "demat_chart";
            if (title != null) {
                exportImageTitle = title.title;
            }
            StringBuilder json = new StringBuilder("let vegaspec = vegaLite.compile(")
                    .append(toJson()).
                    append(
                    " ).spec\n").append(
                    " var view = new vega.View(vega.parse(vegaspec))\n"+
                            "  .logLevel(vega.Warn) // set view logging level\n" +
                            "  .initialize(document.querySelector('#vis')) // set parent DOM element\n" +
                            "  .renderer('canvas') // set render type (defaults to 'canvas')\n" +
                            "  .hover() // enable hover event processing\n" +
                            "  .run(); // update and render the view ").
                    append("\nfunction svg(){" +
                            "\n view.toSVG()\n" +
                            "  .then(svgString => {\n" +
                            "      const filename = 'chart.svg';\n" +
                            "      const url = 'data:image/svg+xml,' + encodeURIComponent(svgString);\n" +
                            "      const link = document.createElement('a');\n" +
                            "      link.setAttribute('href', url);\n" +
                            "      link.setAttribute('target', '_blank');\n" +
                            "      link.setAttribute('download', filename);\n" +
                            "      link.dispatchEvent(new MouseEvent('click'));\n" +
                            "    })" +
                            "};\n")
                    .append("// generate a static PNG image\n" +
                            "function png(){\n"+
                            "  view\n" +
                            "    .toCanvas()\n" +
                            "    .then(canvas => {\n" +
                            "      const filename = 'chart.png';\n" +
                            "      const url = canvas.toDataURL();\n" +
                            "      const link = document.createElement('a');\n" +
                            "      link.setAttribute('href', url);\n" +
                            "      link.setAttribute('target', '_blank');\n" +
                            "      link.setAttribute('download', filename);\n" +
                            "      link.dispatchEvent(new MouseEvent('click'));\n" +
                            "    })\n" +
                            "    .catch((err) => {\n" +
                            "      console.error(err);\n" +
                            "    });"+
                            "};");
            return join(div().withId("vis"), script(rawHtml(json.toString())));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Identifier used to name the vega-lite div view
     * @return
     */
    public String getId() {
        return id;
    }

    @Override
    public void setHTMLDirectory(String htmlDirectory) {
        this.htmlDirectory=htmlDirectory;
    }
}
