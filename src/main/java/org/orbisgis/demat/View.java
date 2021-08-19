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

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.orbisgis.demat.api.IEncodingProperty;
import org.orbisgis.demat.vega.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.*;

import static j2html.TagCreator.*;
import static j2html.TagCreator.rawHtml;

/**
 * A Vega-Lite top-level specification. This is the root class for all Vega-Lite
 * specifications. (The json schema is generated from this type.)
 *
 * @author Erwan Bocher, CNRS 2021
 */
public class View {
    private String schema;
    private ViewAlign align;
    private Autosize autosize;
    private Background background;
    private Bounds bounds;
    private Center center;
    private Config config;
    private Data data;
    private Map<String, InlineDatasetValue> datasets;
    private String description;
    private Encoding encoding;
    private Height height;
    private Mark mark;
    private String name;
    private Padding padding;
    private List<Parameter> params;
    private Projection projection;
    private Resolve resolve;
    private Map<String, SelectionDef> selection;
    private Spacing spacing;
    private Title title;
    private List<Transform> transform;
    private Map<String, Object> usermeta;
    private ViewBackground view;
    private Height width;
    private Number columns;
    private Facet facet;
    private ViewSpec spec;
    private List<LayerElement> layer;
    private Repeat repeat;
    private List<NormalizedSpec> concat;
    private List<NormalizedSpec> vconcat;
    private List<NormalizedSpec> hconcat;
    private String showDir = System.getProperty("java.io.tmpdir")+File.separator+"demat";

    /**
     * URL to [JSON schema](http://json-schema.org/) for a Vega-Lite specification. Unless you
     * have a reason to change this, use `https://vega.github.io/schema/vega-lite/v4.json`.
     * Setting the `$schema` property allows automatic validation and autocomplete in editors
     * that support JSON schema.
     */
    @JsonProperty("$schema")
    public String getSchema() { return schema; }
    @JsonProperty("$schema")
    public void setSchema(String value) { this.schema = value; }

    /**
     * The alignment to apply to grid rows and columns. The supported string values are `"all"`,
     * `"each"`, and `"none"`.
     *
     * - For `"none"`, a flow layout will be used, in which adjacent subviews are simply placed
     * one after the other. - For `"each"`, subviews will be aligned into a clean grid
     * structure, but each row or column may be of variable size. - For `"all"`, subviews will
     * be aligned and each row or column will be sized identically based on the maximum observed
     * size. String values for this property will be applied to both grid rows and columns.
     *
     * Alternatively, an object value of the form `{"row": string, "column": string}` can be
     * used to supply different alignments for rows and columns.
     *
     * __Default value:__ `"all"`.
     */
    @JsonProperty("align")
    public ViewAlign getAlign() { return align; }
    @JsonProperty("align")
    public void setAlign(ViewAlign value) { this.align = value; }

    /**
     * How the visualization size should be determined. If a string, should be one of `"pad"`,
     * `"fit"` or `"none"`. Object values can additionally specify parameters for content sizing
     * and automatic resizing.
     *
     * __Default value__: `pad`
     */
    @JsonProperty("autosize")
    public Autosize getAutosize() { return autosize; }
    @JsonProperty("autosize")
    public void setAutosize(Autosize value) { this.autosize = value; }

    /**
     * CSS color property to use as the background of the entire view.
     *
     * __Default value:__ `"white"`
     */
    @JsonProperty("background")
    public Background getBackground() { return background; }
    @JsonProperty("background")
    public void setBackground(Background value) { this.background = value; }

    /**
     * The bounds calculation method to use for determining the extent of a sub-plot. One of
     * `full` (the default) or `flush`.
     *
     * - If set to `full`, the entire calculated bounds (including axes, title, and legend) will
     * be used. - If set to `flush`, only the specified width and height values for the sub-view
     * will be used. The `flush` setting can be useful when attempting to place sub-plots
     * without axes or legends into a uniform grid structure.
     *
     * __Default value:__ `"full"`
     */
    @JsonProperty("bounds")
    public Bounds getBounds() { return bounds; }
    @JsonProperty("bounds")
    public void setBounds(Bounds value) { this.bounds = value; }

    /**
     * Boolean flag indicating if subviews should be centered relative to their respective rows
     * or columns.
     *
     * An object value of the form `{"row": boolean, "column": boolean}` can be used to supply
     * different centering values for rows and columns.
     *
     * __Default value:__ `false`
     *
     * Boolean flag indicating if subviews should be centered relative to their respective rows
     * or columns.
     *
     * __Default value:__ `false`
     */
    @JsonProperty("center")
    public Center getCenter() { return center; }
    @JsonProperty("center")
    public void setCenter(Center value) { this.center = value; }

    /**
     * Vega-Lite configuration object. This property can only be defined at the top-level of a
     * specification.
     */
    @JsonProperty("config")
    public Config getConfig() { return config; }
    @JsonProperty("config")
    public void setConfig(Config value) { this.config = value; }

    /**
     * An object describing the data source. Set to `null` to ignore the parent's data source.
     * If no data is set, it is derived from the parent.
     */
    @JsonProperty("data")
    public Data getData() { return data; }
    @JsonProperty("data")
    public void setData(Data value) { this.data = value; }

    /**
     * A global data store for named datasets. This is a mapping from names to inline datasets.
     * This can be an array of objects or primitive values or a string. Arrays of primitive
     * values are ingested as objects with a `data` property.
     */
    @JsonProperty("datasets")
    public Map<String, InlineDatasetValue> getDatasets() { return datasets; }
    @JsonProperty("datasets")
    public void setDatasets(Map<String, InlineDatasetValue> value) { this.datasets = value; }

    /**
     * Description of this mark for commenting purpose.
     */
    @JsonProperty("description")
    public String getDescription() { return description; }
    @JsonProperty("description")
    public void setDescription(String value) { this.description = value; }

    /**
     * A key-value mapping between encoding channels and definition of fields.
     *
     * A shared key-value mapping between encoding channels and definition of fields in the
     * underlying layers.
     */
    @JsonProperty("encoding")
    public Encoding getEncoding() { return encoding; }
    @JsonProperty("encoding")
    public void setEncoding(Encoding value) { this.encoding = value; }

    /**
     * The height of a visualization.
     *
     * - For a plot with a continuous y-field, height should be a number. - For a plot with
     * either a discrete y-field or no y-field, height can be either a number indicating a fixed
     * height or an object in the form of `{step: number}` defining the height per discrete
     * step. (No y-field is equivalent to having one discrete step.) - To enable responsive
     * sizing on height, it should be set to `"container"`.
     *
     * __Default value:__ Based on `config.view.continuousHeight` for a plot with a continuous
     * y-field and `config.view.discreteHeight` otherwise.
     *
     * __Note:__ For plots with [`row` and `column`
     * channels](https://vega.github.io/vega-lite/docs/encoding.html#facet), this represents the
     * height of a single view and the `"container"` option cannot be used.
     *
     * __See also:__ [`height`](https://vega.github.io/vega-lite/docs/size.html) documentation.
     */
    @JsonProperty("height")
    public Height getHeight() { return height; }
    @JsonProperty("height")
    public void setHeight(Height value) { this.height = value; }

    /**
     * A string describing the mark type (one of `"bar"`, `"circle"`, `"square"`, `"tick"`,
     * `"line"`, `"area"`, `"point"`, `"rule"`, `"geoshape"`, and `"text"`) or a [mark
     * definition object](https://vega.github.io/vega-lite/docs/mark.html#mark-def).
     */
    @JsonProperty("mark")
    public Mark getMark() { return mark; }
    @JsonProperty("mark")
    public void setMark(Mark value) { this.mark = value; }

    /**
     * Name of the visualization for later reference.
     */
    @JsonProperty("name")
    public String getName() { return name; }
    @JsonProperty("name")
    public void setName(String value) { this.name = value; }

    /**
     * The default visualization padding, in pixels, from the edge of the visualization canvas
     * to the data rectangle. If a number, specifies padding for all sides. If an object, the
     * value should have the format `{"left": 5, "top": 5, "right": 5, "bottom": 5}` to specify
     * padding for each side of the visualization.
     *
     * __Default value__: `5`
     */
    @JsonProperty("padding")
    public Padding getPadding() { return padding; }
    @JsonProperty("padding")
    public void setPadding(Padding value) { this.padding = value; }

    /**
     * Dynamic variables that parameterize a visualization.
     */
    @JsonProperty("params")
    public List<Parameter> getParams() { return params; }
    @JsonProperty("params")
    public void setParams(List<Parameter> value) { this.params = value; }

    /**
     * An object defining properties of geographic projection, which will be applied to `shape`
     * path for `"geoshape"` marks and to `latitude` and `"longitude"` channels for other
     * marks.
     *
     * An object defining properties of the geographic projection shared by underlying layers.
     */
    @JsonProperty("projection")
    public Projection getProjection() { return projection; }
    @JsonProperty("projection")
    public void setProjection(Projection value) { this.projection = value; }

    /**
     * Scale, axis, and legend resolutions for view composition specifications.
     */
    @JsonProperty("resolve")
    public Resolve getResolve() { return resolve; }
    @JsonProperty("resolve")
    public void setResolve(Resolve value) { this.resolve = value; }

    /**
     * A key-value mapping between selection names and definitions.
     */
    @JsonProperty("selection")
    public Map<String, SelectionDef> getSelection() { return selection; }
    @JsonProperty("selection")
    public void setSelection(Map<String, SelectionDef> value) { this.selection = value; }

    /**
     * The spacing in pixels between sub-views of the composition operator. An object of the
     * form `{"row": number, "column": number}` can be used to set different spacing values for
     * rows and columns.
     *
     * __Default value__: Depends on `"spacing"` property of [the view composition
     * configuration](https://vega.github.io/vega-lite/docs/config.html#view-config) (`20` by
     * default)
     *
     * The spacing in pixels between sub-views of the concat operator.
     *
     * __Default value__: `10`
     */
    @JsonProperty("spacing")
    public Spacing getSpacing() { return spacing; }
    @JsonProperty("spacing")
    public void setSpacing(Spacing value) { this.spacing = value; }

    /**
     * Title for the plot.
     */
    @JsonProperty("title")
    public Title getTitle() { return title; }
    @JsonProperty("title")
    public void setTitle(Title value) { this.title = value; }

    /**
     * An array of data transformations such as filter and new field calculation.
     */
    @JsonProperty("transform")
    public List<Transform> getTransform() { return transform; }
    @JsonProperty("transform")
    public void setTransform(List<Transform> value) { this.transform = value; }

    /**
     * Optional metadata that will be passed to Vega. This object is completely ignored by Vega
     * and Vega-Lite and can be used for custom metadata.
     */
    @JsonProperty("usermeta")
    public Map<String, Object> getUsermeta() { return usermeta; }
    @JsonProperty("usermeta")
    public void setUsermeta(Map<String, Object> value) { this.usermeta = value; }

    /**
     * An object defining the view background's fill and stroke.
     *
     * __Default value:__ none (transparent)
     */
    @JsonProperty("view")
    public ViewBackground getView() { return view; }
    @JsonProperty("view")
    public void setView(ViewBackground value) { this.view = value; }

    /**
     * The width of a visualization.
     *
     * - For a plot with a continuous x-field, width should be a number. - For a plot with
     * either a discrete x-field or no x-field, width can be either a number indicating a fixed
     * width or an object in the form of `{step: number}` defining the width per discrete step.
     * (No x-field is equivalent to having one discrete step.) - To enable responsive sizing on
     * width, it should be set to `"container"`.
     *
     * __Default value:__ Based on `config.view.continuousWidth` for a plot with a continuous
     * x-field and `config.view.discreteWidth` otherwise.
     *
     * __Note:__ For plots with [`row` and `column`
     * channels](https://vega.github.io/vega-lite/docs/encoding.html#facet), this represents the
     * width of a single view and the `"container"` option cannot be used.
     *
     * __See also:__ [`width`](https://vega.github.io/vega-lite/docs/size.html) documentation.
     */
    @JsonProperty("width")
    public Height getWidth() { return width; }
    @JsonProperty("width")
    public void setWidth(Height value) { this.width = value; }

    /**
     * The number of columns to include in the view composition layout.
     *
     * __Default value__: `undefined` -- An infinite number of columns (a single row) will be
     * assumed. This is equivalent to `hconcat` (for `concat`) and to using the `column` channel
     * (for `facet` and `repeat`).
     *
     * __Note__:
     *
     * 1) This property is only for: - the general (wrappable) `concat` operator (not
     * `hconcat`/`vconcat`) - the `facet` and `repeat` operator with one field/repetition
     * definition (without row/column nesting)
     *
     * 2) Setting the `columns` to `1` is equivalent to `vconcat` (for `concat`) and to using
     * the `row` channel (for `facet` and `repeat`).
     */
    @JsonProperty("columns")
    public Number getColumns() { return columns; }
    @JsonProperty("columns")
    public void setColumns(Number value) { this.columns = value; }

    /**
     * Definition for how to facet the data. One of: 1) [a field definition for faceting the
     * plot by one field](https://vega.github.io/vega-lite/docs/facet.html#field-def) 2) [An
     * object that maps `row` and `column` channels to their field
     * definitions](https://vega.github.io/vega-lite/docs/facet.html#mapping)
     */
    @JsonProperty("facet")
    public Facet getFacet() { return facet; }
    @JsonProperty("facet")
    public void setFacet(Facet value) { this.facet = value; }

    /**
     * A specification of the view that gets faceted.
     *
     * A specification of the view that gets repeated.
     */
    @JsonProperty("spec")
    public ViewSpec getSpec() { return spec; }
    @JsonProperty("spec")
    public void setSpec(ViewSpec value) { this.spec = value; }

    /**
     * Layer or single view specifications to be layered.
     *
     * __Note__: Specifications inside `layer` cannot use `row` and `column` channels as
     * layering facet specifications is not allowed. Instead, use the [facet
     * operator](https://vega.github.io/vega-lite/docs/facet.html) and place a layer inside a
     * facet.
     */
    @JsonProperty("layer")
    public List<LayerElement> getLayer() { return layer; }
    @JsonProperty("layer")
    public void setLayer(List<LayerElement> value) { this.layer = value; }

    /**
     * Definition for fields to be repeated. One of: 1) An array of fields to be repeated. If
     * `"repeat"` is an array, the field can be referred to as `{"repeat": "repeat"}`. The
     * repeated views are laid out in a wrapped row. You can set the number of columns to
     * control the wrapping. 2) An object that maps `"row"` and/or `"column"` to the listed
     * fields to be repeated along the particular orientations. The objects `{"repeat": "row"}`
     * and `{"repeat": "column"}` can be used to refer to the repeated field respectively.
     */
    @JsonProperty("repeat")
    public Repeat getRepeat() { return repeat; }
    @JsonProperty("repeat")
    public void setRepeat(Repeat value) { this.repeat = value; }

    /**
     * A list of views to be concatenated.
     */
    @JsonProperty("concat")
    public List<NormalizedSpec> getConcat() { return concat; }
    @JsonProperty("concat")
    public void setConcat(List<NormalizedSpec> value) { this.concat = value; }

    /**
     * A list of views to be concatenated and put into a column.
     */
    @JsonProperty("vconcat")
    public List<NormalizedSpec> getVconcat() { return vconcat; }
    @JsonProperty("vconcat")
    public void setVconcat(List<NormalizedSpec> value) { this.vconcat = value; }

    /**
     * A list of views to be concatenated and put into a row.
     */
    @JsonProperty("hconcat")
    public List<NormalizedSpec> getHconcat() { return hconcat; }
    @JsonProperty("hconcat")
    public void setHconcat(List<NormalizedSpec> value) { this.hconcat = value; }


    public View description(String description) {
        this.description=description;
        return this;
    }

    public View name(String name) {
        this.name=name;
        return this;
    }

    public View data(Data data) {
        this.setData(data);
        return this;
    }

    public View data(Object[][] values) {
        this.setData(ViewUtils.urlData(values));
        return this;
    }

    public View data(List<Map> values) {
        this.setData(ViewUtils.urlData(values));
        return this;
    }

    public View data(LinkedHashMap values) {
        this.setData(ViewUtils.urlData(values));
        return this;
    }

    public View data(String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        DataValues dataValues = mapper.readValue(json, DataValues.class);
        Data data = new Data();
        data.setValues(dataValues);
        this.setData(data);
        return this;
    }

    public View data(ResultSet resultSet) throws JsonProcessingException {
        Data data = new Data();
        DataValues dataValues = new DataValues();
        //dataValues.
        data.setValues(dataValues);
        this.setData(data);
        return this;
    }

    /**
     * Create a mark_geoshape
     * @return
     */
    public View mark_geoshape() {
        Mark mark = new Mark();
        mark.type = "geoshape";
        this.mark= mark;
        return this;
    }

    /**
     * Create a mark_bar
     * @return
     */
    public View mark_bar() {
        Mark mark = new Mark();
        mark.type = "bar";
        this.mark= mark;
        return this;
    }

    /**
     * Create a mark_bar
     * @return
     */
    public View mark_area() {
        Mark mark = new Mark();
        mark.type = "area";
        this.mark= mark;
        return this;
    }

    /**
     * Create a mark_tick
     * @return
     */
    public View mark_tick() {
        Mark mark = new Mark();
        mark.type = "tick";
        this.mark= mark;
        return this;
    }

    /**
     * Set height to the view
     * @param height
     * @return
     */
    public View height(double height){
        Height height_ = new Height();
        height_.doubleValue=height;
        this.height= height_;
        return this;
    }

    /**
     * Set width to the view
     * @param width
     * @return
     */
    public View width(double width){
        Height height_ = new Height();
        height_.doubleValue=width;
        this.width= height_;
        return this;
    }

    /**
     * Construct the encoding element
     * @param properties any encoding elements , X, Y, Color...
     * @return
     */
    public View encode(IEncodingProperty... properties) {
        Encoding encoding = new Encoding();
        for (IEncodingProperty property:properties){
            if(property  instanceof X){
                encoding.setX((X) property);
            }
            else if(property  instanceof Y){
                encoding.setY((Y) property);
            }
            else if(property  instanceof Color){
                encoding.setColor((Color) property);
            }
        }
        this.setEncoding(encoding);
         return this;
    }

    public String toJson() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return objectMapper.writeValueAsString(this);
    }

    /**
     * Save into the show directory
     * @return
     */
    public String save() throws IOException {
        File outputFile = File.createTempFile("vegalite", ".html", checkShowDir());
        return save(outputFile.getAbsolutePath());
    }

    /**
     * Save into an html file
     * @param path
     * @return
     */
    public String save(String path) throws IOException {
        return save(path, false);
    }


    /**
     * Save into an html file
     * @param outputFile
     * @param delete
     * @return
     */
    public String save(File outputFile, boolean delete) throws IOException {
        if(outputFile==null){
            return null;
        }
        if(outputFile.exists() ){
            if(delete){
                outputFile.delete();
            }
            else{
                return null;
            }
        }
        StringBuilder json =  new StringBuilder("var spec =\n");
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
                body (
                        div().withId("vis"),
                        script(rawHtml(json.toString()))

                )
        ).render(fileWriter);
        fileWriter.close();
        return outputFile.getAbsolutePath();
    }

    /**
     * Save into an html file
     * @param path
     * @param delete
     * @return
     */
    public String save(String path, boolean delete) throws IOException {
        return save(new File(path), delete);
    }

    public View mark(Mark mark){
        this.mark= mark;
        return this;
    }

    public View concat( View... views) {
        ArrayList<NormalizedSpec> concat_ = new ArrayList<>();;
        for(View view :views){
            concat_.add(copy(view));
        }
        this.concat=concat_;
        this.projection=null;
        return this;
    }

    public View concat(int numColumns, View... views) {
        ArrayList<NormalizedSpec> concat_ = new ArrayList<>();;
        for(View view :views){
            concat_.add(copy(view));
        }
        this.concat=concat_;
        this.columns=numColumns;
        this.projection=null;
        return this;
    }

    /**
     * Copy from view to NormalizedSpec
     * @param view
     * @return
     */
    public NormalizedSpec copy(View view){
        NormalizedSpec normalizedSpec = new NormalizedSpec();
        normalizedSpec.setAlign(view.getAlign());
        normalizedSpec.setBounds(view.getBounds());
        normalizedSpec.setCenter(view.getCenter());
        normalizedSpec.setColumns(view.getColumns());
        normalizedSpec.setConcat(view.getConcat());
        normalizedSpec.setData(view.getData());
        normalizedSpec.setDescription(view.getDescription());
        normalizedSpec.setEncoding(view.getEncoding());
        normalizedSpec.setFacet(view.getFacet());
        normalizedSpec.setRepeat(view.getRepeat());
        normalizedSpec.setMark(view.getMark());
        normalizedSpec.setHeight(view.getHeight());
        normalizedSpec.setWidth(view.getWidth());
        normalizedSpec.setName(view.getName());
        normalizedSpec.setTitle(view.getTitle());
        normalizedSpec.setProjection(view.getProjection());
        normalizedSpec.setSelection(view.getSelection());
        normalizedSpec.setTransform(view.getTransform());
        return normalizedSpec;
    }

    public View hconcat(View... views) {
        ArrayList<NormalizedSpec> hconcat_ = new ArrayList<>();;
        for(View view :views){
            hconcat_.add(copy(view));
        }
        this.hconcat=hconcat_;
        return this;
    }

    public View projection(ProjectionType projectionType) {
        Projection projection = new Projection();
        projection.setType(projectionType);
        this.projection=projection;
        return this;
    }

    public View projection(Projection projection) {
        this.projection=projection;
        return this;
    }

    public View title(String title) {
        Title title_ = new Title();
        title_.title=title;
        this.title=title_;
        return this;
    }

    public void setTransform(Transform... transforms) {
        this.transform= Arrays.asList(transforms);
    }

    /**
     * Set a new directory path to store the HTML file generated
     * for rendering vegalite view
     * @return
     */
    public void setShowDir(String showDirPath) {
        this.showDir=showDirPath;
    }

    /**
     * Check the show directory file
     * @return
     */
    public File checkShowDir(){
        File showDirFile = new File(showDir);
        if(!showDirFile.isDirectory()){
            throw new RuntimeException("Invalid directory path");
        }
        if(!showDirFile.exists()){
            showDirFile.mkdir();
        }
        return showDirFile;
    }

    /**
     * Show the vega-lite chart in the default browser of the OS
     * Save the html file in a tmp file
     */
    public void show() {
        try {
            File outputFile = File.createTempFile("vegalite", ".html", checkShowDir());
            this.save(outputFile, true);
            ViewUtils.openBrowser(outputFile.getAbsolutePath());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
