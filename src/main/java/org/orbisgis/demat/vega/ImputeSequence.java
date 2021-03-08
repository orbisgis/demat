package org.orbisgis.demat.vega;

import com.fasterxml.jackson.annotation.*;

public class ImputeSequence {
    private Double start;
    private Double step;
    private double stop;

    /**
     * The starting value of the sequence. __Default value:__ `0`
     */
    @JsonProperty("start")
    public Double getStart() { return start; }
    @JsonProperty("start")
    public void setStart(Double value) { this.start = value; }

    /**
     * The step value between sequence entries. __Default value:__ `1` or `-1` if `stop < start`
     */
    @JsonProperty("step")
    public Double getStep() { return step; }
    @JsonProperty("step")
    public void setStep(Double value) { this.step = value; }

    /**
     * The ending value(exclusive) of the sequence.
     */
    @JsonProperty("stop")
    public double getStop() { return stop; }
    @JsonProperty("stop")
    public void setStop(double value) { this.stop = value; }
}
