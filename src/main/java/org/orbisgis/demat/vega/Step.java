package org.orbisgis.demat.vega;

import com.fasterxml.jackson.annotation.*;

public class Step {
    private double step;

    /**
     * The size (width/height) per discrete step.
     */
    @JsonProperty("step")
    public double getStep() { return step; }
    @JsonProperty("step")
    public void setStep(double value) { this.step = value; }
}
