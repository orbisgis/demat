package org.orbisgis.demat.v4;

import com.fasterxml.jackson.annotation.*;
import java.util.List;

public class PurpleConditionalPredicateValueDefNumberNullExprRef {
    private PredicateCompositionElement test;
    private List<Double> value;
    private String expr;

    /**
     * Predicate for triggering the condition
     */
    @JsonProperty("test")
    public PredicateCompositionElement getTest() { return test; }
    @JsonProperty("test")
    public void setTest(PredicateCompositionElement value) { this.test = value; }

    /**
     * A constant value in visual domain (e.g., `"red"` / `"#0099ff"` / [gradient
     * definition](https://vega.github.io/vega-lite/docs/types.html#gradient) for color, values
     * between `0` to `1` for opacity).
     */
    @JsonProperty("value")
    public List<Double> getValue() { return value; }
    @JsonProperty("value")
    public void setValue(List<Double> value) { this.value = value; }

    /**
     * Vega expression (which can refer to Vega-Lite parameters).
     */
    @JsonProperty("expr")
    public String getExpr() { return expr; }
    @JsonProperty("expr")
    public void setExpr(String value) { this.expr = value; }
}
