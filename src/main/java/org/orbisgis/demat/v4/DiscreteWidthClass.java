package org.orbisgis.demat.v4;

import com.fasterxml.jackson.annotation.*;

public class DiscreteWidthClass {
    private double step;

    @JsonProperty("step")
    public double getStep() { return step; }
    @JsonProperty("step")
    public void setStep(double value) { this.step = value; }
}
