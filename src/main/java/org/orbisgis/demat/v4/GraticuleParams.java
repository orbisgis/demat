package org.orbisgis.demat.v4;

import com.fasterxml.jackson.annotation.*;
import java.util.List;

public class GraticuleParams {
    private List<List<Double>> extent;
    private List<List<Double>> extentMajor;
    private List<List<Double>> extentMinor;
    private Double precision;
    private List<Double> step;
    private List<Double> stepMajor;
    private List<Double> stepMinor;

    /**
     * Sets both the major and minor extents to the same values.
     */
    @JsonProperty("extent")
    public List<List<Double>> getExtent() { return extent; }
    @JsonProperty("extent")
    public void setExtent(List<List<Double>> value) { this.extent = value; }

    /**
     * The major extent of the graticule as a two-element array of coordinates.
     */
    @JsonProperty("extentMajor")
    public List<List<Double>> getExtentMajor() { return extentMajor; }
    @JsonProperty("extentMajor")
    public void setExtentMajor(List<List<Double>> value) { this.extentMajor = value; }

    /**
     * The minor extent of the graticule as a two-element array of coordinates.
     */
    @JsonProperty("extentMinor")
    public List<List<Double>> getExtentMinor() { return extentMinor; }
    @JsonProperty("extentMinor")
    public void setExtentMinor(List<List<Double>> value) { this.extentMinor = value; }

    /**
     * The precision of the graticule in degrees.
     *
     * __Default value:__ `2.5`
     */
    @JsonProperty("precision")
    public Double getPrecision() { return precision; }
    @JsonProperty("precision")
    public void setPrecision(Double value) { this.precision = value; }

    /**
     * Sets both the major and minor step angles to the same values.
     */
    @JsonProperty("step")
    public List<Double> getStep() { return step; }
    @JsonProperty("step")
    public void setStep(List<Double> value) { this.step = value; }

    /**
     * The major step angles of the graticule.
     *
     *
     * __Default value:__ `[90, 360]`
     */
    @JsonProperty("stepMajor")
    public List<Double> getStepMajor() { return stepMajor; }
    @JsonProperty("stepMajor")
    public void setStepMajor(List<Double> value) { this.stepMajor = value; }

    /**
     * The minor step angles of the graticule.
     *
     * __Default value:__ `[10, 10]`
     */
    @JsonProperty("stepMinor")
    public List<Double> getStepMinor() { return stepMinor; }
    @JsonProperty("stepMinor")
    public void setStepMinor(List<Double> value) { this.stepMinor = value; }
}
