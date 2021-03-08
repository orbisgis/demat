package org.orbisgis.demat.vega;

import com.fasterxml.jackson.annotation.*;

public class LegendStreamBinding {
    private LegendUnion legend;

    @JsonProperty("legend")
    public LegendUnion getLegend() { return legend; }
    @JsonProperty("legend")
    public void setLegend(LegendUnion value) { this.legend = value; }
}
