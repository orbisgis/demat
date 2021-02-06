package org.orbisgis.demat.v4;

import com.fasterxml.jackson.annotation.*;
import java.util.List;

public class RangeRange {
    private Double count;
    private List<Double> extent;
    private RangeText scheme;

    @JsonProperty("count")
    public Double getCount() { return count; }
    @JsonProperty("count")
    public void setCount(Double value) { this.count = value; }

    @JsonProperty("extent")
    public List<Double> getExtent() { return extent; }
    @JsonProperty("extent")
    public void setExtent(List<Double> value) { this.extent = value; }

    @JsonProperty("scheme")
    public RangeText getScheme() { return scheme; }
    @JsonProperty("scheme")
    public void setScheme(RangeText value) { this.scheme = value; }
}
