package org.orbisgis.demat.vega;

import com.fasterxml.jackson.annotation.*;
import java.util.List;

public class SchemeParams {
    private Double count;
    private List<Double> extent;
    private String name;
    private String expr;

    /**
     * The number of colors to use in the scheme. This can be useful for scale types such as
     * `"quantize"`, which use the length of the scale range to determine the number of discrete
     * bins for the scale domain.
     */
    @JsonProperty("count")
    public Double getCount() { return count; }
    @JsonProperty("count")
    public void setCount(Double value) { this.count = value; }

    /**
     * The extent of the color range to use. For example `[0.2, 1]` will rescale the color
     * scheme such that color values in the range _[0, 0.2)_ are excluded from the scheme.
     */
    @JsonProperty("extent")
    public List<Double> getExtent() { return extent; }
    @JsonProperty("extent")
    public void setExtent(List<Double> value) { this.extent = value; }

    /**
     * A color scheme name for ordinal scales (e.g., `"category10"` or `"blues"`).
     *
     * For the full list of supported schemes, please refer to the [Vega
     * Scheme](https://vega.github.io/vega/docs/schemes/#reference) reference.
     */
    @JsonProperty("name")
    public String getName() { return name; }
    @JsonProperty("name")
    public void setName(String value) { this.name = value; }

    /**
     * Vega expression (which can refer to Vega-Lite parameters).
     */
    @JsonProperty("expr")
    public String getExpr() { return expr; }
    @JsonProperty("expr")
    public void setExpr(String value) { this.expr = value; }
}
