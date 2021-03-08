package org.orbisgis.demat.vega;

import com.fasterxml.jackson.annotation.*;

public class GradientStop {
    private String color;
    private double offset;

    /**
     * The color value at this point in the gradient.
     */
    @JsonProperty("color")
    public String getColor() { return color; }
    @JsonProperty("color")
    public void setColor(String value) { this.color = value; }

    /**
     * The offset fraction for the color stop, indicating its position within the gradient.
     */
    @JsonProperty("offset")
    public double getOffset() { return offset; }
    @JsonProperty("offset")
    public void setOffset(double value) { this.offset = value; }
}
