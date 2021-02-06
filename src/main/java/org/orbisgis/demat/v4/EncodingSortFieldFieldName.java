package org.orbisgis.demat.v4;

import com.fasterxml.jackson.annotation.*;

/**
 * A sort definition for sorting a discrete scale in an encoding field definition.
 */
public class EncodingSortFieldFieldName {
    private String field;
    private NonArgAggregateOp op;
    private SortOrder order;

    /**
     * The data [field](https://vega.github.io/vega-lite/docs/field.html) to sort by.
     *
     * __Default value:__ If unspecified, defaults to the field specified in the outer data
     * reference.
     */
    @JsonProperty("field")
    public String getField() { return field; }
    @JsonProperty("field")
    public void setField(String value) { this.field = value; }

    /**
     * An [aggregate operation](https://vega.github.io/vega-lite/docs/aggregate.html#ops) to
     * perform on the field prior to sorting (e.g., `"count"`, `"mean"` and `"median"`). An
     * aggregation is required when there are multiple values of the sort field for each encoded
     * data field. The input data objects will be aggregated, grouped by the encoded data
     * field.
     *
     * For a full list of operations, please see the documentation for
     * [aggregate](https://vega.github.io/vega-lite/docs/aggregate.html#ops).
     *
     * __Default value:__ `"sum"` for stacked plots. Otherwise, `"min"`.
     */
    @JsonProperty("op")
    public NonArgAggregateOp getOp() { return op; }
    @JsonProperty("op")
    public void setOp(NonArgAggregateOp value) { this.op = value; }

    /**
     * The sort order. One of `"ascending"` (default), `"descending"`, or `null` (no not sort).
     */
    @JsonProperty("order")
    public SortOrder getOrder() { return order; }
    @JsonProperty("order")
    public void setOrder(SortOrder value) { this.order = value; }
}
