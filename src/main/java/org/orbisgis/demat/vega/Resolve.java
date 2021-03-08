package org.orbisgis.demat.vega;

import com.fasterxml.jackson.annotation.*;

/**
 * Scale, axis, and legend resolutions for view composition specifications.
 *
 * Defines how scales, axes, and legends from different specs should be combined. Resolve is
 * a mapping from `scale`, `axis`, and `legend` to a mapping from channels to resolutions.
 * Scales and guides can be resolved to be `"independent"` or `"shared"`.
 */
public class Resolve {
    private AxisResolveMap axis;
    private LegendResolveMap legend;
    private ScaleResolveMap scale;

    @JsonProperty("axis")
    public AxisResolveMap getAxis() { return axis; }
    @JsonProperty("axis")
    public void setAxis(AxisResolveMap value) { this.axis = value; }

    @JsonProperty("legend")
    public LegendResolveMap getLegend() { return legend; }
    @JsonProperty("legend")
    public void setLegend(LegendResolveMap value) { this.legend = value; }

    @JsonProperty("scale")
    public ScaleResolveMap getScale() { return scale; }
    @JsonProperty("scale")
    public void setScale(ScaleResolveMap value) { this.scale = value; }
}
