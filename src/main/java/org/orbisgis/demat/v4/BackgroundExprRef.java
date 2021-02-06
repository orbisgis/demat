package org.orbisgis.demat.v4;

import com.fasterxml.jackson.annotation.*;

public class BackgroundExprRef {
    private String expr;

    /**
     * Vega expression (which can refer to Vega-Lite parameters).
     */
    @JsonProperty("expr")
    public String getExpr() { return expr; }
    @JsonProperty("expr")
    public void setExpr(String value) { this.expr = value; }
}
