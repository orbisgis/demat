package org.orbisgis.demat.vega;

import com.fasterxml.jackson.annotation.*;

public class JoinAggregateFieldDef {
    private String as;
    private String field;
    private AggregateOp op;

    /**
     * The output name for the join aggregate operation.
     */
    @JsonProperty("as")
    public String getAs() { return as; }
    @JsonProperty("as")
    public void setAs(String value) { this.as = value; }

    /**
     * The data field for which to compute the aggregate function. This can be omitted for
     * functions that do not operate over a field such as `"count"`.
     */
    @JsonProperty("field")
    public String getField() { return field; }
    @JsonProperty("field")
    public void setField(String value) { this.field = value; }

    /**
     * The aggregation operation to apply (e.g., `"sum"`, `"average"` or `"count"`). See the
     * list of all supported operations
     * [here](https://vega.github.io/vega-lite/docs/aggregate.html#ops).
     */
    @JsonProperty("op")
    public AggregateOp getOp() { return op; }
    @JsonProperty("op")
    public void setOp(AggregateOp value) { this.op = value; }
}
