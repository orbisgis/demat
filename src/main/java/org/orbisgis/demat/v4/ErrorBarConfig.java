package org.orbisgis.demat.v4;

import com.fasterxml.jackson.annotation.*;

/**
 * ErrorBar Config
 */
public class ErrorBarConfig {
    private ErrorBarExtent extent;
    private Box rule;
    private Double size;
    private Double thickness;
    private Box ticks;

    /**
     * The extent of the rule. Available options include: - `"ci"`: Extend the rule to the
     * confidence interval of the mean. - `"stderr"`: The size of rule are set to the value of
     * standard error, extending from the mean. - `"stdev"`: The size of rule are set to the
     * value of standard deviation, extending from the mean. - `"iqr"`: Extend the rule to the
     * q1 and q3.
     *
     * __Default value:__ `"stderr"`.
     */
    @JsonProperty("extent")
    public ErrorBarExtent getExtent() { return extent; }
    @JsonProperty("extent")
    public void setExtent(ErrorBarExtent value) { this.extent = value; }

    @JsonProperty("rule")
    public Box getRule() { return rule; }
    @JsonProperty("rule")
    public void setRule(Box value) { this.rule = value; }

    /**
     * Size of the ticks of an error bar
     */
    @JsonProperty("size")
    public Double getSize() { return size; }
    @JsonProperty("size")
    public void setSize(Double value) { this.size = value; }

    /**
     * Thickness of the ticks and the bar of an error bar
     */
    @JsonProperty("thickness")
    public Double getThickness() { return thickness; }
    @JsonProperty("thickness")
    public void setThickness(Double value) { this.thickness = value; }

    @JsonProperty("ticks")
    public Box getTicks() { return ticks; }
    @JsonProperty("ticks")
    public void setTicks(Box value) { this.ticks = value; }
}
