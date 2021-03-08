package org.orbisgis.demat.vega;

import com.fasterxml.jackson.annotation.*;

public class DiscreteHeightClass {
    private double step;

    @JsonProperty("step")
    public double getStep() { return step; }
    @JsonProperty("step")
    public void setStep(double value) { this.step = value; }
}
