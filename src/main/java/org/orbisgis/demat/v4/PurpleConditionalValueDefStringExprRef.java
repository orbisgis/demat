package org.orbisgis.demat.v4;

import com.fasterxml.jackson.annotation.*;

public class PurpleConditionalValueDefStringExprRef {
    private ConditionalValueDefNumberExprRefPredicateComposition test;
    private BackgroundUnion value;
    private ConditionalValueDefNumberExprRefSelectionComposition selection;

    /**
     * Predicate for triggering the condition
     */
    @JsonProperty("test")
    public ConditionalValueDefNumberExprRefPredicateComposition getTest() { return test; }
    @JsonProperty("test")
    public void setTest(ConditionalValueDefNumberExprRefPredicateComposition value) { this.test = value; }

    /**
     * A constant value in visual domain (e.g., `"red"` / `"#0099ff"` / [gradient
     * definition](https://vega.github.io/vega-lite/docs/types.html#gradient) for color, values
     * between `0` to `1` for opacity).
     */
    @JsonProperty("value")
    public BackgroundUnion getValue() { return value; }
    @JsonProperty("value")
    public void setValue(BackgroundUnion value) { this.value = value; }

    /**
     * A [selection name](https://vega.github.io/vega-lite/docs/selection.html), or a series of
     * [composed selections](https://vega.github.io/vega-lite/docs/selection.html#compose).
     */
    @JsonProperty("selection")
    public ConditionalValueDefNumberExprRefSelectionComposition getSelection() { return selection; }
    @JsonProperty("selection")
    public void setSelection(ConditionalValueDefNumberExprRefSelectionComposition value) { this.selection = value; }
}
