package org.orbisgis.demat.v4;

import com.fasterxml.jackson.annotation.*;
import java.util.List;

public class DomainUnionWith {
    private String field;
    private String selection;
    private SingleDefUnitChannel encoding;
    private List<SelectionInitInterval> unionWith;
    private String expr;

    /**
     * The field name to extract selected values for, when a selection is
     * [projected](https://vega.github.io/vega-lite/docs/project.html) over multiple fields or
     * encodings.
     */
    @JsonProperty("field")
    public String getField() { return field; }
    @JsonProperty("field")
    public void setField(String value) { this.field = value; }

    /**
     * The name of a selection.
     */
    @JsonProperty("selection")
    public String getSelection() { return selection; }
    @JsonProperty("selection")
    public void setSelection(String value) { this.selection = value; }

    /**
     * The encoding channel to extract selected values for, when a selection is
     * [projected](https://vega.github.io/vega-lite/docs/project.html) over multiple fields or
     * encodings.
     */
    @JsonProperty("encoding")
    public SingleDefUnitChannel getEncoding() { return encoding; }
    @JsonProperty("encoding")
    public void setEncoding(SingleDefUnitChannel value) { this.encoding = value; }

    /**
     * Customized domain values to be union with the field's values.
     *
     * 1) `domain` for _quantitative_ fields can take one of the following forms:
     *
     * - a two-element array with minimum and maximum values. - an array with more than two
     * entries, for [Piecewise  quantitative
     * scales](https://vega.github.io/vega-lite/docs/scale.html#piecewise). (Alternatively, the
     * `domainMid` property can be set for a diverging scale.) - a string value
     * `"unaggregated"`, if the input field is aggregated, to indicate that the domain should
     * include the raw data values prior to the aggregation.
     *
     * 2) `domain` for _temporal_ fields can be a two-element array minimum and maximum values,
     * in the form of either timestamps or the [DateTime definition
     * objects](https://vega.github.io/vega-lite/docs/types.html#datetime).
     *
     * 3) `domain` for _ordinal_ and _nominal_ fields can be an array that lists valid input
     * values.
     */
    @JsonProperty("unionWith")
    public List<SelectionInitInterval> getUnionWith() { return unionWith; }
    @JsonProperty("unionWith")
    public void setUnionWith(List<SelectionInitInterval> value) { this.unionWith = value; }

    /**
     * Vega expression (which can refer to Vega-Lite parameters).
     */
    @JsonProperty("expr")
    public String getExpr() { return expr; }
    @JsonProperty("expr")
    public void setExpr(String value) { this.expr = value; }
}
