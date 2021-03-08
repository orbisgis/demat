package org.orbisgis.demat.vega;

import com.fasterxml.jackson.annotation.*;
import java.util.List;

/**
 * Binning properties or boolean flag for determining whether to bin data or not.
 */
public class BinParams {
    private Double anchor;
    private Double base;
    private Boolean binned;
    private List<Double> divide;
    private BinExtent extent;
    private Double maxbins;
    private Double minstep;
    private Boolean nice;
    private Double step;
    private List<Double> steps;

    /**
     * A value in the binned domain at which to anchor the bins, shifting the bin boundaries if
     * necessary to ensure that a boundary aligns with the anchor value.
     *
     * __Default value:__ the minimum bin extent value
     */
    @JsonProperty("anchor")
    public Double getAnchor() { return anchor; }
    @JsonProperty("anchor")
    public void setAnchor(Double value) { this.anchor = value; }

    /**
     * The number base to use for automatic bin determination (default is base 10).
     *
     * __Default value:__ `10`
     */
    @JsonProperty("base")
    public Double getBase() { return base; }
    @JsonProperty("base")
    public void setBase(Double value) { this.base = value; }

    /**
     * When set to `true`, Vega-Lite treats the input data as already binned.
     */
    @JsonProperty("binned")
    public Boolean getBinned() { return binned; }
    @JsonProperty("binned")
    public void setBinned(Boolean value) { this.binned = value; }

    /**
     * Scale factors indicating allowable subdivisions. The default value is [5, 2], which
     * indicates that for base 10 numbers (the default base), the method may consider dividing
     * bin sizes by 5 and/or 2. For example, for an initial step size of 10, the method can
     * check if bin sizes of 2 (= 10/5), 5 (= 10/2), or 1 (= 10/(5*2)) might also satisfy the
     * given constraints.
     *
     * __Default value:__ `[5, 2]`
     */
    @JsonProperty("divide")
    public List<Double> getDivide() { return divide; }
    @JsonProperty("divide")
    public void setDivide(List<Double> value) { this.divide = value; }

    /**
     * A two-element (`[min, max]`) array indicating the range of desired bin values.
     */
    @JsonProperty("extent")
    public BinExtent getExtent() { return extent; }
    @JsonProperty("extent")
    public void setExtent(BinExtent value) { this.extent = value; }

    /**
     * Maximum number of bins.
     *
     * __Default value:__ `6` for `row`, `column` and `shape` channels; `10` for other channels
     */
    @JsonProperty("maxbins")
    public Double getMaxbins() { return maxbins; }
    @JsonProperty("maxbins")
    public void setMaxbins(Double value) { this.maxbins = value; }

    /**
     * A minimum allowable step size (particularly useful for integer values).
     */
    @JsonProperty("minstep")
    public Double getMinstep() { return minstep; }
    @JsonProperty("minstep")
    public void setMinstep(Double value) { this.minstep = value; }

    /**
     * If true, attempts to make the bin boundaries use human-friendly boundaries, such as
     * multiples of ten.
     *
     * __Default value:__ `true`
     */
    @JsonProperty("nice")
    public Boolean getNice() { return nice; }
    @JsonProperty("nice")
    public void setNice(Boolean value) { this.nice = value; }

    /**
     * An exact step size to use between bins.
     *
     * __Note:__ If provided, options such as maxbins will be ignored.
     */
    @JsonProperty("step")
    public Double getStep() { return step; }
    @JsonProperty("step")
    public void setStep(Double value) { this.step = value; }

    /**
     * An array of allowable step sizes to choose from.
     */
    @JsonProperty("steps")
    public List<Double> getSteps() { return steps; }
    @JsonProperty("steps")
    public void setSteps(List<Double> value) { this.steps = value; }
}
