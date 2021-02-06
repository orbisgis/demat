package org.orbisgis.demat.v4;

import com.fasterxml.jackson.annotation.*;
import java.util.List;
import java.util.Map;

/**
 * A Vega-Lite top-level specification. This is the root class for all Vega-Lite
 * specifications. (The json schema is generated from this type.)
 */
public class Coordinate {
    private String schema;
    private CoordinateAlign align;
    private Autosize autosize;
    private BackgroundUnion background;
    private Bounds bounds;
    private Center center;
    private Config config;
    private URLData data;
    private Map<String, InlineDatasetValue> datasets;
    private String description;
    private Encoding encoding;
    private Height height;
    private AnyMark mark;
    private String name;
    private Padding padding;
    private List<Parameter> params;
    private Projection projection;
    private Resolve resolve;
    private Map<String, SelectionDef> selection;
    private Spacing spacing;
    private TitleUnion title;
    private List<Transform> transform;
    private Map<String, Object> usermeta;
    private ViewBackground view;
    private Height width;
    private Double columns;
    private Facet facet;
    private CoordinateSpec spec;
    private List<LayerElement> layer;
    private RepeatUnion repeat;
    private List<NormalizedSpec> concat;
    private List<NormalizedSpec> vconcat;
    private List<NormalizedSpec> hconcat;

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
    public CoordinateAlign getAlign() { return align; }
    @JsonProperty("align")
    public void setAlign(CoordinateAlign value) { this.align = value; }

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
    public BackgroundUnion getBackground() { return background; }
    @JsonProperty("background")
    public void setBackground(BackgroundUnion value) { this.background = value; }

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
    public URLData getData() { return data; }
    @JsonProperty("data")
    public void setData(URLData value) { this.data = value; }

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
    public AnyMark getMark() { return mark; }
    @JsonProperty("mark")
    public void setMark(AnyMark value) { this.mark = value; }

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
    public TitleUnion getTitle() { return title; }
    @JsonProperty("title")
    public void setTitle(TitleUnion value) { this.title = value; }

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
    public Double getColumns() { return columns; }
    @JsonProperty("columns")
    public void setColumns(Double value) { this.columns = value; }

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
    public CoordinateSpec getSpec() { return spec; }
    @JsonProperty("spec")
    public void setSpec(CoordinateSpec value) { this.spec = value; }

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
    public RepeatUnion getRepeat() { return repeat; }
    @JsonProperty("repeat")
    public void setRepeat(RepeatUnion value) { this.repeat = value; }

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
}
