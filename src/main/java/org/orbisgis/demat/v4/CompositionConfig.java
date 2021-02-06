package org.orbisgis.demat.v4;

import com.fasterxml.jackson.annotation.*;

/**
 * Default configuration for all concatenation and repeat view composition operators
 * (`concat`, `hconcat`, `vconcat`, and `repeat`)
 *
 * Default configuration for the `facet` view composition operator
 */
public class CompositionConfig {
    private Double columns;
    private Double spacing;

    /**
     * The number of columns to include in the view composition layout.
     *
     * __Default value__: `undefined` -- An infinite number of columns (a single row) will be
     * assumed. This is equivalent to `hconcat` (for `concat`) and to using the `column` channel
     * (for `facet` and `repeat`).
     *
     * __Note__:
     *
     * 1) This property is only for: - the general (wrappable) `concat` operator (not
     * `hconcat`/`vconcat`) - the `facet` and `repeat` operator with one field/repetition
     * definition (without row/column nesting)
     *
     * 2) Setting the `columns` to `1` is equivalent to `vconcat` (for `concat`) and to using
     * the `row` channel (for `facet` and `repeat`).
     */
    @JsonProperty("columns")
    public Double getColumns() { return columns; }
    @JsonProperty("columns")
    public void setColumns(Double value) { this.columns = value; }

    /**
     * The default spacing in pixels between composed sub-views.
     *
     * __Default value__: `20`
     */
    @JsonProperty("spacing")
    public Double getSpacing() { return spacing; }
    @JsonProperty("spacing")
    public void setSpacing(Double value) { this.spacing = value; }
}
