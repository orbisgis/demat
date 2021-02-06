package org.orbisgis.demat.v4;

import com.fasterxml.jackson.annotation.*;

public class MagentaExprRef {
    private Double bottom;
    private Double left;
    private Double right;
    private Double top;
    private String expr;

    @JsonProperty("bottom")
    public Double getBottom() { return bottom; }
    @JsonProperty("bottom")
    public void setBottom(Double value) { this.bottom = value; }

    @JsonProperty("left")
    public Double getLeft() { return left; }
    @JsonProperty("left")
    public void setLeft(Double value) { this.left = value; }

    @JsonProperty("right")
    public Double getRight() { return right; }
    @JsonProperty("right")
    public void setRight(Double value) { this.right = value; }

    @JsonProperty("top")
    public Double getTop() { return top; }
    @JsonProperty("top")
    public void setTop(Double value) { this.top = value; }

    /**
     * Vega expression (which can refer to Vega-Lite parameters).
     */
    @JsonProperty("expr")
    public String getExpr() { return expr; }
    @JsonProperty("expr")
    public void setExpr(String value) { this.expr = value; }
}
