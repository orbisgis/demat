package org.orbisgis.demat.v4;

import com.fasterxml.jackson.annotation.*;

public class ScaleBinParams {
    private Double start;
    private double step;
    private Double stop;

    /**
     * The starting (lowest-valued) bin boundary.
     *
     * __Default value:__ The lowest value of the scale domain will be used.
     */
    @JsonProperty("start")
    public Double getStart() { return start; }
    @JsonProperty("start")
    public void setStart(Double value) { this.start = value; }

    /**
     * The step size defining the bin interval width.
     */
    @JsonProperty("step")
    public double getStep() { return step; }
    @JsonProperty("step")
    public void setStep(double value) { this.step = value; }

    /**
     * The stopping (highest-valued) bin boundary.
     *
     * __Default value:__ The highest value of the scale domain will be used.
     */
    @JsonProperty("stop")
    public Double getStop() { return stop; }
    @JsonProperty("stop")
    public void setStop(Double value) { this.stop = value; }
}
