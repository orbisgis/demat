package org.orbisgis.demat;

import org.orbisgis.demat.vega.*;

import java.io.IOException;

/**
 * Parameters to build a chart
 */
public class Chart extends NormalizedSpec implements IRenderer {

    private View view;
    private Renderer renderer;


    public Chart description(String description) {
        this.setDescription(description);
        return this;
    }

    public Chart name(String name) {
        this.setName(name);
        return this;
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
            }
        }
        this.setEncoding(encoding);
        return this;
    }

    public Projection projection() {
        return new Projection();
    }

    /**
     * Save into an html file
     * Delete it if exists
     *
     * @param path
     * @return
     */
    public String save(String path) throws IOException {
        build();
        return this.renderer.save(path, true);
    }

    void build() {
        this.view = new View();
        view.setSchema("https://vega.github.io/schema/vega-lite/v5.json");
        this.view.setTitle(this.getTitle());
        this.view.setEncoding(this.getEncoding());
        this.view.setData(this.getData());
        this.view.setAlign(this.getAlign());
        this.view.setBounds(this.getBounds());
        this.view.setCenter(this.getCenter());
        this.view.setDescription(this.getDescription());
        this.view.setHeight(this.getHeight());
        this.view.setMark(this.getMark());
        this.view.setName(this.getName());
        this.view.setProjection(this.getProjection());
        this.view.setResolve(this.getResolve());
        this.view.setSelection(this.getSelection());
        this.view.setSpacing(this.getSpacing());
        this.view.setTransform(this.getTransform());
        this.view.setView(this.getView());
        this.view.setWidth(this.getWidth());
        this.view.setLayer(this.getLayer());
        this.view.setColumns(this.getColumns());
        this.view.setRepeat(this.getRepeat());
        this.view.setFacet(this.getFacet());
        this.view.setConcat(this.getConcat());
        this.view.setHconcat(this.getHconcat());
        this.setVconcat(this.getVconcat());
        this.renderer = new Renderer(view);
    }

    /**
     *
     */
    public void show() {
        build();
        this.renderer.show();
    }

    @Override
    public String save() throws IOException {
        return this.renderer.save();
    }

    public void setView(View view) {
        this.view = view;
    }

    public void setRenderer(Renderer renderer) {
        this.renderer = renderer;
    }
}
