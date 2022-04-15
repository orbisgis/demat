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

public class SelectionDef {
    private BindUnion bind;
    private ClearUnion clear;
    private Empty empty;
    private List<SingleDefUnitChannel> encodings;
    private List<String> fields;
    private Init init;
    private Boolean nearest;
    private OnUnion on;
    private SelectionResolution resolve;
    private String type;
    private Translate toggle;
    private BrushConfig mark;
    private Translate translate;
    private Translate zoom;

    /**
     * When set, a selection is populated by input elements (also known as dynamic query
     * widgets) or by interacting with the corresponding legend. Direct manipulation interaction
     * is disabled by default; to re-enable it, set the selection's
     * [`on`](https://vega.github.io/vega-lite/docs/selection.html#common-selection-properties)
     * property.
     *
     * Legend bindings are restricted to selections that only specify a single field or
     * encoding.
     *
     * Query widget binding takes the form of Vega's [input element binding
     * definition](https://vega.github.io/vega/docs/signals/#bind) or can be a mapping between
     * projected field/encodings and binding definitions.
     *
     * __See also:__ [`bind`](https://vega.github.io/vega-lite/docs/bind.html) documentation.
     *
     * When set, a selection is populated by interacting with the corresponding legend. Direct
     * manipulation interaction is disabled by default; to re-enable it, set the selection's
     * [`on`](https://vega.github.io/vega-lite/docs/selection.html#common-selection-properties)
     * property.
     *
     * Legend bindings are restricted to selections that only specify a single field or
     * encoding.
     *
     * Establishes a two-way binding between the interval selection and the scales used within
     * the same view. This allows a user to interactively pan and zoom the view.
     *
     * __See also:__ [`bind`](https://vega.github.io/vega-lite/docs/bind.html) documentation.
     */
    @JsonProperty("bind")
    public BindUnion getBind() { return bind; }
    @JsonProperty("bind")
    public void setBind(BindUnion value) { this.bind = value; }

    /**
     * Clears the selection, emptying it of all values. Can be a [Event
     * Stream](https://vega.github.io/vega/docs/event-streams/) or `false` to disable.
     *
     * __Default value:__ `dblclick`.
     *
     * __See also:__ [`clear`](https://vega.github.io/vega-lite/docs/clear.html) documentation.
     */
    @JsonProperty("clear")
    public ClearUnion getClear() { return clear; }
    @JsonProperty("clear")
    public void setClear(ClearUnion value) { this.clear = value; }

    /**
     * By default, `all` data values are considered to lie within an empty selection. When set
     * to `none`, empty selections contain no data values.
     */
    @JsonProperty("empty")
    public Empty getEmpty() { return empty; }
    @JsonProperty("empty")
    public void setEmpty(Empty value) { this.empty = value; }

    /**
     * An array of encoding channels. The corresponding data field values must match for a data
     * tuple to fall within the selection.
     *
     * __See also:__ [`encodings`](https://vega.github.io/vega-lite/docs/project.html)
     * documentation.
     */
    @JsonProperty("encodings")
    public List<SingleDefUnitChannel> getEncodings() { return encodings; }
    @JsonProperty("encodings")
    public void setEncodings(List<SingleDefUnitChannel> value) { this.encodings = value; }

    /**
     * An array of field names whose values must match for a data tuple to fall within the
     * selection.
     *
     * __See also:__ [`fields`](https://vega.github.io/vega-lite/docs/project.html)
     * documentation.
     */
    @JsonProperty("fields")
    public List<String> getFields() { return fields; }
    @JsonProperty("fields")
    public void setFields(List<String> value) { this.fields = value; }

    /**
     * Initialize the selection with a mapping between [projected channels or field
     * names](https://vega.github.io/vega-lite/docs/project.html) and initial values.
     *
     * __See also:__ [`init`](https://vega.github.io/vega-lite/docs/init.html) documentation.
     *
     * Initialize the selection with a mapping between [projected channels or field
     * names](https://vega.github.io/vega-lite/docs/project.html) and an initial value (or array
     * of values).
     *
     * __See also:__ [`init`](https://vega.github.io/vega-lite/docs/init.html) documentation.
     *
     * Initialize the selection with a mapping between [projected channels or field
     * names](https://vega.github.io/vega-lite/docs/project.html) and arrays of initial values.
     *
     * __See also:__ [`init`](https://vega.github.io/vega-lite/docs/init.html) documentation.
     */
    @JsonProperty("init")
    public Init getInit() { return init; }
    @JsonProperty("init")
    public void setInit(Init value) { this.init = value; }

    /**
     * When true, an invisible voronoi diagram is computed to accelerate discrete selection. The
     * data value _nearest_ the mouse cursor is added to the selection.
     *
     * __See also:__ [`nearest`](https://vega.github.io/vega-lite/docs/nearest.html)
     * documentation.
     */
    @JsonProperty("nearest")
    public Boolean getNearest() { return nearest; }
    @JsonProperty("nearest")
    public void setNearest(Boolean value) { this.nearest = value; }

    /**
     * A [Vega event stream](https://vega.github.io/vega/docs/event-streams/) (object or
     * selector) that triggers the selection. For interval selections, the event stream must
     * specify a [start and
     * end](https://vega.github.io/vega/docs/event-streams/#between-filters).
     */
    @JsonProperty("on")
    public OnUnion getOn() { return on; }
    @JsonProperty("on")
    public void setOn(OnUnion value) { this.on = value; }

    /**
     * With layered and multi-view displays, a strategy that determines how selections' data
     * queries are resolved when applied in a filter transform, conditional encoding rule, or
     * scale domain.
     *
     * __See also:__ [`resolve`](https://vega.github.io/vega-lite/docs/selection-resolve.html)
     * documentation.
     */
    @JsonProperty("resolve")
    public SelectionResolution getResolve() { return resolve; }
    @JsonProperty("resolve")
    public void setResolve(SelectionResolution value) { this.resolve = value; }

    /**
     * Determines the default event processing and data query for the selection. Vega-Lite
     * currently supports three selection types:
     *
     * - `"single"` -- to select a single discrete data value on `click`. - `"multi"` -- to
     * select multiple discrete data value; the first value is selected on `click` and
     * additional values toggled on shift-`click`. - `"interval"` -- to select a continuous
     * range of data values on `drag`.
     */
    @JsonProperty("type")
    public String getType() { return type; }
    @JsonProperty("type")
    public void setType(String value) { this.type = value; }

    /**
     * Controls whether data values should be toggled or only ever inserted into multi
     * selections. Can be `true`, `false` (for insertion only), or a [Vega
     * expression](https://vega.github.io/vega/docs/expressions/).
     *
     * __Default value:__ `true`, which corresponds to `event.shiftKey` (i.e., data values are
     * toggled when a user interacts with the shift-key pressed).
     *
     * Setting the value to the Vega expression `"true"` will toggle data values without the
     * user pressing the shift-key.
     *
     * __See also:__ [`toggle`](https://vega.github.io/vega-lite/docs/toggle.html) documentation.
     */
    @JsonProperty("toggle")
    public Translate getToggle() { return toggle; }
    @JsonProperty("toggle")
    public void setToggle(Translate value) { this.toggle = value; }

    /**
     * An interval selection also adds a rectangle mark to depict the extents of the interval.
     * The `mark` property can be used to customize the appearance of the mark.
     *
     * __See also:__ [`mark`](https://vega.github.io/vega-lite/docs/selection-mark.html)
     * documentation.
     */
    @JsonProperty("mark")
    public BrushConfig getMark() { return mark; }
    @JsonProperty("mark")
    public void setMark(BrushConfig value) { this.mark = value; }

    /**
     * When truthy, allows a user to interactively move an interval selection back-and-forth.
     * Can be `true`, `false` (to disable panning), or a [Vega event stream
     * definition](https://vega.github.io/vega/docs/event-streams/) which must include a start
     * and end event to trigger continuous panning.
     *
     * __Default value:__ `true`, which corresponds to `[mousedown, window:mouseup] >
     * window:mousemove!` which corresponds to clicks and dragging within an interval selection
     * to reposition it.
     *
     * __See also:__ [`translate`](https://vega.github.io/vega-lite/docs/translate.html)
     * documentation.
     */
    @JsonProperty("translate")
    public Translate getTranslate() { return translate; }
    @JsonProperty("translate")
    public void setTranslate(Translate value) { this.translate = value; }

    /**
     * When truthy, allows a user to interactively resize an interval selection. Can be `true`,
     * `false` (to disable zooming), or a [Vega event stream
     * definition](https://vega.github.io/vega/docs/event-streams/). Currently, only `wheel`
     * events are supported.
     *
     * __Default value:__ `true`, which corresponds to `wheel!`.
     *
     * __See also:__ [`zoom`](https://vega.github.io/vega-lite/docs/zoom.html) documentation.
     */
    @JsonProperty("zoom")
    public Translate getZoom() { return zoom; }
    @JsonProperty("zoom")
    public void setZoom(Translate value) { this.zoom = value; }
}
