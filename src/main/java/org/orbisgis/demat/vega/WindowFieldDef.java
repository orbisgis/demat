package org.orbisgis.demat.vega;

import com.fasterxml.jackson.annotation.*;

public class WindowFieldDef {
    private String as;
    private String field;
    private Op op;
    private Double param;

    /**
     * The output name for the window operation.
     */
    @JsonProperty("as")
    public String getAs() { return as; }
    @JsonProperty("as")
    public void setAs(String value) { this.as = value; }

    /**
     * The data field for which to compute the aggregate or window function. This can be omitted
     * for window functions that do not operate over a field such as `"count"`, `"rank"`,
     * `"dense_rank"`.
     */
    @JsonProperty("field")
    public String getField() { return field; }
    @JsonProperty("field")
    public void setField(String value) { this.field = value; }

    /**
     * The window or aggregation operation to apply within a window (e.g., `"rank"`, `"lead"`,
     * `"sum"`, `"average"` or `"count"`). See the list of all supported operations
     * [here](https://vega.github.io/vega-lite/docs/window.html#ops).
     */
    @JsonProperty("op")
    public Op getOp() { return op; }
    @JsonProperty("op")
    public void setOp(Op value) { this.op = value; }

    /**
     * Parameter values for the window functions. Parameter values can be omitted for operations
     * that do not accept a parameter.
     *
     * See the list of all supported operations and their parameters
     * [here](https://vega.github.io/vega-lite/docs/transforms/window.html).
     */
    @JsonProperty("param")
    public Double getParam() { return param; }
    @JsonProperty("param")
    public void setParam(Double value) { this.param = value; }
}
