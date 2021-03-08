package org.orbisgis.demat.vega;

import com.fasterxml.jackson.annotation.*;

/**
 * A sort definition for transform
 */
public class SortField {
    private String field;
    private SortOrder order;

    /**
     * The name of the field to sort.
     */
    @JsonProperty("field")
    public String getField() { return field; }
    @JsonProperty("field")
    public void setField(String value) { this.field = value; }

    /**
     * Whether to sort the field in ascending or descending order. One of `"ascending"`
     * (default), `"descending"`, or `null` (no not sort).
     */
    @JsonProperty("order")
    public SortOrder getOrder() { return order; }
    @JsonProperty("order")
    public void setOrder(SortOrder value) { this.order = value; }
}
