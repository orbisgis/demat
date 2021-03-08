package org.orbisgis.demat.vega;

import com.fasterxml.jackson.annotation.*;

/**
 * An object hash for defining default properties for each type of selections.
 */
public class SelectionConfig {
    private IntervalSelectionConfig interval;
    private MultiSelectionConfig multi;
    private SingleSelectionConfig single;

    /**
     * The default definition for an
     * [`interval`](https://vega.github.io/vega-lite/docs/selection.html#type) selection. All
     * properties and transformations for an interval selection definition (except `type`) may
     * be specified here.
     *
     * For instance, setting `interval` to `{"translate": false}` disables the ability to move
     * interval selections by default.
     */
    @JsonProperty("interval")
    public IntervalSelectionConfig getInterval() { return interval; }
    @JsonProperty("interval")
    public void setInterval(IntervalSelectionConfig value) { this.interval = value; }

    /**
     * The default definition for a
     * [`multi`](https://vega.github.io/vega-lite/docs/selection.html#type) selection. All
     * properties and transformations for a multi selection definition (except `type`) may be
     * specified here.
     *
     * For instance, setting `multi` to `{"toggle": "event.altKey"}` adds additional values to
     * multi selections when clicking with the alt-key pressed by default.
     */
    @JsonProperty("multi")
    public MultiSelectionConfig getMulti() { return multi; }
    @JsonProperty("multi")
    public void setMulti(MultiSelectionConfig value) { this.multi = value; }

    /**
     * The default definition for a
     * [`single`](https://vega.github.io/vega-lite/docs/selection.html#type) selection. All
     * properties and transformations   for a single selection definition (except `type`) may be
     * specified here.
     *
     * For instance, setting `single` to `{"on": "dblclick"}` populates single selections on
     * double-click by default.
     */
    @JsonProperty("single")
    public SingleSelectionConfig getSingle() { return single; }
    @JsonProperty("single")
    public void setSingle(SingleSelectionConfig value) { this.single = value; }
}
