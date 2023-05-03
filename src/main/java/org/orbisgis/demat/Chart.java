package org.orbisgis.demat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import j2html.tags.DomContent;
import org.orbisgis.demat.vega.*;
import org.orbisgis.demat.vega.encoding.*;

import java.io.File;
import java.util.UUID;

import static j2html.TagCreator.*;

/**
 * Parameters to build a chart
 */
public class Chart extends NormalizedSpec implements ViewCommonMethods<Chart>, IRenderer {

    private final String id;
    private String htmlDirectory = System.getProperty("java.io.tmpdir") + File.separator + "demat";

    private View parentView = null;

    public Chart() {
        this.id = "vis" + UUID.randomUUID();
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
     * Create a mark_image
     *
     * @return
     */
    public Chart mark_image() {
        Mark mark = new Mark();
        mark.type = "image";
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
     * Create a mark_area
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
            }else if (element instanceof Text) {
                encoding.setText((Text) element);
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

    public View getParentView() {
        return parentView;
    }

    @JsonIgnore
    @Override
    public String getHTMLDirectory() {
        return htmlDirectory;
    }

    @Override
    public void setHTMLDirectory(String htmlDirectory) {
        this.htmlDirectory = htmlDirectory;
    }


    @Override
    public String toJson() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return objectMapper.writeValueAsString(this);
    }

    @JsonIgnore
    @Override
    public DomContent getDomElements() {
        try {
            Title title = this.getTitle();
            ViewBackground viewBackground = new ViewBackground();
            Background background = new Background();
            background.value ="transparent";
            viewBackground.setStroke(background);
            this.setViewBackground(viewBackground);
            String exportImageTitle = "demat_chart";
            if (title != null) {
                exportImageTitle = title.title;
            }
            StringBuilder json = new StringBuilder("vegaEmbed('#").append(this.getId()).append("',");
            json.append(toJson()).append(",{renderer: 'svg',downloadFileName :'").append(exportImageTitle).append("'}).catch(console.error);");
            return join(div().withId(this.getId()), script(rawHtml(json.toString())));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public String getId() {
        return id;
    }

}
