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

import com.fasterxml.jackson.annotation.JsonProperty;
import org.orbisgis.demat.vega.data.Data;
import org.orbisgis.demat.vega.resolve.Resolve;
import org.orbisgis.demat.vega.transform.Transform;

import java.util.List;
import java.util.Map;

/**
 * A specification of the view that gets repeated.
 *
 * A full layered plot specification, which may contains `encoding` and `projection`
 * properties that will be applied to underlying unit (single-view) specifications.
 *
 * A unit specification, which can contain either [primitive marks or composite
 * marks](https://vega.github.io/vega-lite/docs/mark.html#types).
 */
public class LayerElement {
    private Data data;
    private String description;
    private LayerEncoding encoding;
    private Height height;
    private List<LayerElement> layer;
    private String name;
    private Projection projection;
    private Resolve resolve;
    private Title title;
    private List<Transform> transform;
    private ViewBackground view;
    private Height width;
    private Mark mark;
    private Map<String, SelectionDef> selection;

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
     * A shared key-value mapping between encoding channels and definition of fields in the
     * underlying layers.
     *
     * A key-value mapping between encoding channels and definition of fields.
     */
    @JsonProperty("encoding")
    public LayerEncoding getEncoding() { return encoding; }
    @JsonProperty("encoding")
    public void setEncoding(LayerEncoding value) { this.encoding = value; }

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
     * Name of the visualization for later reference.
     */
    @JsonProperty("name")
    public String getName() { return name; }
    @JsonProperty("name")
    public void setName(String value) { this.name = value; }

    /**
     * An object defining properties of the geographic projection shared by underlying layers.
     *
     * An object defining properties of geographic projection, which will be applied to `shape`
     * path for `"geoshape"` marks and to `latitude` and `"longitude"` channels for other marks.
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
     * A string describing the mark type (one of `"bar"`, `"circle"`, `"square"`, `"tick"`,
     * `"line"`, `"area"`, `"point"`, `"rule"`, `"geoshape"`, and `"text"`) or a [mark
     * definition object](https://vega.github.io/vega-lite/docs/mark.html#mark-def).
     */
    @JsonProperty("mark")
    public Mark getMark() { return mark; }
    @JsonProperty("mark")
    public void setMark(Mark value) { this.mark = value; }

    /**
     * A key-value mapping between selection names and definitions.
     */
    @JsonProperty("selection")
    public Map<String, SelectionDef> getSelection() { return selection; }
    @JsonProperty("selection")
    public void setSelection(Map<String, SelectionDef> value) { this.selection = value; }
}
