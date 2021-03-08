package org.orbisgis.demat.vega;

import com.fasterxml.jackson.annotation.*;

public class TickCountTimeIntervalStep {
    private TimeInterval interval;
    private Double step;
    private String expr;

    @JsonProperty("interval")
    public TimeInterval getInterval() { return interval; }
    @JsonProperty("interval")
    public void setInterval(TimeInterval value) { this.interval = value; }

    @JsonProperty("step")
    public Double getStep() { return step; }
    @JsonProperty("step")
    public void setStep(Double value) { this.step = value; }

    /**
     * Vega expression (which can refer to Vega-Lite parameters).
     */
    @JsonProperty("expr")
    public String getExpr() { return expr; }
    @JsonProperty("expr")
    public void setExpr(String value) { this.expr = value; }
}
