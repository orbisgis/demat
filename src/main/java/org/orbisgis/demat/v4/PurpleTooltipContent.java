package org.orbisgis.demat.v4;

import com.fasterxml.jackson.annotation.*;

public class PurpleTooltipContent {
    private Content content;
    private String expr;

    @JsonProperty("content")
    public Content getContent() { return content; }
    @JsonProperty("content")
    public void setContent(Content value) { this.content = value; }

    /**
     * Vega expression (which can refer to Vega-Lite parameters).
     */
    @JsonProperty("expr")
    public String getExpr() { return expr; }
    @JsonProperty("expr")
    public void setExpr(String value) { this.expr = value; }
}
