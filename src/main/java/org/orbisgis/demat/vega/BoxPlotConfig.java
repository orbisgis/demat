package org.orbisgis.demat.vega;

import com.fasterxml.jackson.annotation.*;

/**
 * Box Config
 */
public class BoxPlotConfig {
    private Box box;
    private Extent extent;
    private Box median;
    private Box outliers;
    private Box rule;
    private Double size;
    private Box ticks;

    @JsonProperty("box")
    public Box getBox() { return box; }
    @JsonProperty("box")
    public void setBox(Box value) { this.box = value; }

    /**
     * The extent of the whiskers. Available options include: - `"min-max"`: min and max are the
     * lower and upper whiskers respectively. - A number representing multiple of the
     * interquartile range. This number will be multiplied by the IQR to determine whisker
     * boundary, which spans from the smallest data to the largest data within the range _[Q1 -
     * k * IQR, Q3 + k * IQR]_ where _Q1_ and _Q3_ are the first and third quartiles while _IQR_
     * is the interquartile range (_Q3-Q1_).
     *
     * __Default value:__ `1.5`.
     */
    @JsonProperty("extent")
    public Extent getExtent() { return extent; }
    @JsonProperty("extent")
    public void setExtent(Extent value) { this.extent = value; }

    @JsonProperty("median")
    public Box getMedian() { return median; }
    @JsonProperty("median")
    public void setMedian(Box value) { this.median = value; }

    @JsonProperty("outliers")
    public Box getOutliers() { return outliers; }
    @JsonProperty("outliers")
    public void setOutliers(Box value) { this.outliers = value; }

    @JsonProperty("rule")
    public Box getRule() { return rule; }
    @JsonProperty("rule")
    public void setRule(Box value) { this.rule = value; }

    /**
     * Size of the box and median tick of a box plot
     */
    @JsonProperty("size")
    public Double getSize() { return size; }
    @JsonProperty("size")
    public void setSize(Double value) { this.size = value; }

    @JsonProperty("ticks")
    public Box getTicks() { return ticks; }
    @JsonProperty("ticks")
    public void setTicks(Box value) { this.ticks = value; }
}
