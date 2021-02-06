package org.orbisgis.demat.v4;

import com.fasterxml.jackson.annotation.*;
import java.util.List;
import java.util.Map;

/**
 * The default definition for a
 * [`multi`](https://vega.github.io/vega-lite/docs/selection.html#type) selection. All
 * properties and transformations for a multi selection definition (except `type`) may be
 * specified here.
 *
 * For instance, setting `multi` to `{"toggle": "event.altKey"}` adds additional values to
 * multi selections when clicking with the alt-key pressed by default.
 */
public class MultiSelectionConfig {
    private LegendBinding bind;
    private ClearUnion clear;
    private Empty empty;
    private List<SingleDefUnitChannel> encodings;
    private List<String> fields;
    private List<Map<String, SelectionInit>> init;
    private Boolean nearest;
    private OnUnion on;
    private SelectionResolution resolve;
    private Translate toggle;

    /**
     * When set, a selection is populated by interacting with the corresponding legend. Direct
     * manipulation interaction is disabled by default; to re-enable it, set the selection's
     * [`on`](https://vega.github.io/vega-lite/docs/selection.html#common-selection-properties)
     * property.
     *
     * Legend bindings are restricted to selections that only specify a single field or encoding.
     */
    @JsonProperty("bind")
    public LegendBinding getBind() { return bind; }
    @JsonProperty("bind")
    public void setBind(LegendBinding value) { this.bind = value; }

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
     * names](https://vega.github.io/vega-lite/docs/project.html) and an initial value (or array
     * of values).
     *
     * __See also:__ [`init`](https://vega.github.io/vega-lite/docs/init.html) documentation.
     */
    @JsonProperty("init")
    public List<Map<String, SelectionInit>> getInit() { return init; }
    @JsonProperty("init")
    public void setInit(List<Map<String, SelectionInit>> value) { this.init = value; }

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
}
