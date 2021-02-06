package org.orbisgis.demat.v4;

import com.fasterxml.jackson.annotation.*;

public class ExprRef {
    private String expr;
    private Double gamma;
    private ExprRefType type;

    /**
     * Vega expression (which can refer to Vega-Lite parameters).
     */
    @JsonProperty("expr")
    public String getExpr() { return expr; }
    @JsonProperty("expr")
    public void setExpr(String value) { this.expr = value; }

    @JsonProperty("gamma")
    public Double getGamma() { return gamma; }
    @JsonProperty("gamma")
    public void setGamma(Double value) { this.gamma = value; }

    @JsonProperty("type")
    public ExprRefType getType() { return type; }
    @JsonProperty("type")
    public void setType(ExprRefType value) { this.type = value; }
}
