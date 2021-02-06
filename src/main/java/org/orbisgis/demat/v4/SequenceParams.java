package org.orbisgis.demat.v4;

import com.fasterxml.jackson.annotation.*;

/**
 * Generate a sequence of numbers.
 */
public class SequenceParams {
    private String as;
    private double start;
    private Double step;
    private double stop;

    /**
     * The name of the generated sequence field.
     *
     * __Default value:__ `"data"`
     */
    @JsonProperty("as")
    public String getAs() { return as; }
    @JsonProperty("as")
    public void setAs(String value) { this.as = value; }

    /**
     * The starting value of the sequence (inclusive).
     */
    @JsonProperty("start")
    public double getStart() { return start; }
    @JsonProperty("start")
    public void setStart(double value) { this.start = value; }

    /**
     * The step value between sequence entries.
     *
     * __Default value:__ `1`
     */
    @JsonProperty("step")
    public Double getStep() { return step; }
    @JsonProperty("step")
    public void setStep(Double value) { this.step = value; }

    /**
     * The ending value of the sequence (exclusive).
     */
    @JsonProperty("stop")
    public double getStop() { return stop; }
    @JsonProperty("stop")
    public void setStop(double value) { this.stop = value; }
}
