package org.orbisgis.demat.vega;

import com.fasterxml.jackson.annotation.*;

public class AggregatedFieldDef {
    private String as;
    private String field;
    private AggregateOp op;

    /**
     * The output field names to use for each aggregated field.
     */
    @JsonProperty("as")
    public String getAs() { return as; }
    @JsonProperty("as")
    public void setAs(String value) { this.as = value; }

    /**
     * The data field for which to compute aggregate function. This is required for all
     * aggregation operations except `"count"`.
     */
    @JsonProperty("field")
    public String getField() { return field; }
    @JsonProperty("field")
    public void setField(String value) { this.field = value; }

    /**
     * The aggregation operation to apply to the fields (e.g., `"sum"`, `"average"`, or
     * `"count"`). See the [full list of supported aggregation
     * operations](https://vega.github.io/vega-lite/docs/aggregate.html#ops) for more
     * information.
     */
    @JsonProperty("op")
    public AggregateOp getOp() { return op; }
    @JsonProperty("op")
    public void setOp(AggregateOp value) { this.op = value; }
}
