package org.orbisgis.demat.vega;

import com.fasterxml.jackson.annotation.*;
import java.util.List;

public class HilariousExprRef {
    private String expr;
    private TentacledConditionalPredicateValueDefNumberNullExprRef condition;
    private List<Double> value;

    /**
     * Vega expression (which can refer to Vega-Lite parameters).
     */
    @JsonProperty("expr")
    public String getExpr() { return expr; }
    @JsonProperty("expr")
    public void setExpr(String value) { this.expr = value; }

    @JsonProperty("condition")
    public TentacledConditionalPredicateValueDefNumberNullExprRef getCondition() { return condition; }
    @JsonProperty("condition")
    public void setCondition(TentacledConditionalPredicateValueDefNumberNullExprRef value) { this.condition = value; }

    /**
     * A constant value in visual domain (e.g., `"red"` / `"#0099ff"` / [gradient
     * definition](https://vega.github.io/vega-lite/docs/types.html#gradient) for color, values
     * between `0` to `1` for opacity).
     */
    @JsonProperty("value")
    public List<Double> getValue() { return value; }
    @JsonProperty("value")
    public void setValue(List<Double> value) { this.value = value; }
}
