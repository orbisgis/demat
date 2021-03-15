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
package org.orbisgis.demat.vega;

import com.fasterxml.jackson.annotation.*;
import java.util.List;
import java.util.Map;

/**
 * A specification of the view that gets repeated.
 *
 * Any specification in Vega-Lite.
 *
 * Unit spec that can have a composite mark and row or column channels (shorthand for a
 * facet spec).
 *
 * A full layered plot specification, which may contains `encoding` and `projection`
 * properties that will be applied to underlying unit (single-view) specifications.
 *
 * Base interface for a repeat specification.
 *
 * Base interface for a facet specification.
 *
 * Base interface for a generalized concatenation specification.
 *
 * Base interface for a vertical concatenation specification.
 *
 * Base interface for a horizontal concatenation specification.
 *
 * A unit specification, which can contain either [primitive marks or composite
 * marks](https://vega.github.io/vega-lite/docs/mark.html#types).
 *
 * A specification of the view that gets faceted.
 */
public class NormalizedSpecSpec {
    private ViewAlign align;
    private Bounds bounds;
    private Center center;
    private Data data;
    private String description;
    private SpecEncoding encoding;
    private Height height;
    private Mark mark;
    private String name;
    private Projection projection;
    private Resolve resolve;
    private Map<String, SelectionDef> selection;
    private Spacing spacing;
    private Title title;
    private List<Transform> transform;
    private ViewBackground view;
    private Height width;
    private List<LayerElement> layer;
    private Double columns;
    private Repeat repeat;
    private NormalizedSpecSpec spec;
    private FacetFieldName facet;
    private List<Spec> concat;
    private List<Spec> vconcat;
    private List<Spec> hconcat;

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
     * An object describing the data source. Set to `null` to ignore the parent's data source.
     * If no data is set, it is derived from the parent.
     */
    @JsonProperty("data")
    public Data getData() { return data; }
    @JsonProperty("data")
    public void setData(Data value) { this.data = value; }

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
    public SpecEncoding getEncoding() { return encoding; }
    @JsonProperty("encoding")
    public void setEncoding(SpecEncoding value) { this.encoding = value; }

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
     *
     * __Deprecated:__ Please avoid using width in a unit spec that's a part of a layer spec.
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
     * An object defining the view background's fill and stroke.
     *
     * __Default value:__ none (transparent)
     *
     * __Deprecated:__ Please avoid using width in a unit spec that's a part of a layer spec.
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
     *
     * __Deprecated:__ Please avoid using width in a unit spec that's a part of a layer spec.
     */
    @JsonProperty("width")
    public Height getWidth() { return width; }
    @JsonProperty("width")
    public void setWidth(Height value) { this.width = value; }

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
     * A specification of the view that gets repeated.
     *
     * A specification of the view that gets faceted.
     */
    @JsonProperty("spec")
    public NormalizedSpecSpec getSpec() { return spec; }
    @JsonProperty("spec")
    public void setSpec(NormalizedSpecSpec value) { this.spec = value; }

    /**
     * Definition for how to facet the data. One of: 1) [a field definition for faceting the
     * plot by one field](https://vega.github.io/vega-lite/docs/facet.html#field-def) 2) [An
     * object that maps `row` and `column` channels to their field
     * definitions](https://vega.github.io/vega-lite/docs/facet.html#mapping)
     */
    @JsonProperty("facet")
    public FacetFieldName getFacet() { return facet; }
    @JsonProperty("facet")
    public void setFacet(FacetFieldName value) { this.facet = value; }

    /**
     * A list of views to be concatenated.
     */
    @JsonProperty("concat")
    public List<Spec> getConcat() { return concat; }
    @JsonProperty("concat")
    public void setConcat(List<Spec> value) { this.concat = value; }

    /**
     * A list of views to be concatenated and put into a column.
     */
    @JsonProperty("vconcat")
    public List<Spec> getVconcat() { return vconcat; }
    @JsonProperty("vconcat")
    public void setVconcat(List<Spec> value) { this.vconcat = value; }

    /**
     * A list of views to be concatenated and put into a row.
     */
    @JsonProperty("hconcat")
    public List<Spec> getHconcat() { return hconcat; }
    @JsonProperty("hconcat")
    public void setHconcat(List<Spec> value) { this.hconcat = value; }
}
