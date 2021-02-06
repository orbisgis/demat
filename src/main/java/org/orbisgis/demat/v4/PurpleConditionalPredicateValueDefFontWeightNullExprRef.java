package org.orbisgis.demat.v4;

import com.fasterxml.jackson.annotation.*;

public class PurpleConditionalPredicateValueDefFontWeightNullExprRef {
    private PredicateCompositionElement test;
    private ValueUnion value;
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
    public ValueUnion getValue() { return value; }
    @JsonProperty("value")
    public void setValue(ValueUnion value) { this.value = value; }

    /**
     * Vega expression (which can refer to Vega-Lite parameters).
     */
    @JsonProperty("expr")
    public String getExpr() { return expr; }
    @JsonProperty("expr")
    public void setExpr(String value) { this.expr = value; }
}
