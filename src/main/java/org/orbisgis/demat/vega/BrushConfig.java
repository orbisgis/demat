package org.orbisgis.demat.vega;

import com.fasterxml.jackson.annotation.*;
import java.util.List;

/**
 * An interval selection also adds a rectangle mark to depict the extents of the interval.
 * The `mark` property can be used to customize the appearance of the mark.
 *
 * __See also:__ [`mark`](https://vega.github.io/vega-lite/docs/selection-mark.html)
 * documentation.
 */
public class BrushConfig {
    private Cursor cursor;
    private String fill;
    private Double fillOpacity;
    private String stroke;
    private List<Double> strokeDash;
    private Double strokeDashOffset;
    private Double strokeOpacity;
    private Double strokeWidth;

    /**
     * The mouse cursor used over the interval mark. Any valid [CSS cursor
     * type](https://developer.mozilla.org/en-US/docs/Web/CSS/cursor#Values) can be used.
     */
    @JsonProperty("cursor")
    public Cursor getCursor() { return cursor; }
    @JsonProperty("cursor")
    public void setCursor(Cursor value) { this.cursor = value; }

    /**
     * The fill color of the interval mark.
     *
     * __Default value:__ `"#333333"`
     */
    @JsonProperty("fill")
    public String getFill() { return fill; }
    @JsonProperty("fill")
    public void setFill(String value) { this.fill = value; }

    /**
     * The fill opacity of the interval mark (a value between `0` and `1`).
     *
     * __Default value:__ `0.125`
     */
    @JsonProperty("fillOpacity")
    public Double getFillOpacity() { return fillOpacity; }
    @JsonProperty("fillOpacity")
    public void setFillOpacity(Double value) { this.fillOpacity = value; }

    /**
     * The stroke color of the interval mark.
     *
     * __Default value:__ `"#ffffff"`
     */
    @JsonProperty("stroke")
    public String getStroke() { return stroke; }
    @JsonProperty("stroke")
    public void setStroke(String value) { this.stroke = value; }

    /**
     * An array of alternating stroke and space lengths, for creating dashed or dotted lines.
     */
    @JsonProperty("strokeDash")
    public List<Double> getStrokeDash() { return strokeDash; }
    @JsonProperty("strokeDash")
    public void setStrokeDash(List<Double> value) { this.strokeDash = value; }

    /**
     * The offset (in pixels) with which to begin drawing the stroke dash array.
     */
    @JsonProperty("strokeDashOffset")
    public Double getStrokeDashOffset() { return strokeDashOffset; }
    @JsonProperty("strokeDashOffset")
    public void setStrokeDashOffset(Double value) { this.strokeDashOffset = value; }

    /**
     * The stroke opacity of the interval mark (a value between `0` and `1`).
     */
    @JsonProperty("strokeOpacity")
    public Double getStrokeOpacity() { return strokeOpacity; }
    @JsonProperty("strokeOpacity")
    public void setStrokeOpacity(Double value) { this.strokeOpacity = value; }

    /**
     * The stroke width of the interval mark.
     */
    @JsonProperty("strokeWidth")
    public Double getStrokeWidth() { return strokeWidth; }
    @JsonProperty("strokeWidth")
    public void setStrokeWidth(Double value) { this.strokeWidth = value; }
}
