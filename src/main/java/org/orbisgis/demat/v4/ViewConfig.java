package org.orbisgis.demat.v4;

import com.fasterxml.jackson.annotation.*;

/**
 * Default properties for [single view
 * plots](https://vega.github.io/vega-lite/docs/spec.html#single).
 */
public class ViewConfig {
    private Boolean clip;
    private Double continuousHeight;
    private Double continuousWidth;
    private CornerRadius cornerRadius;
    private Cursor cursor;
    private DiscreteHeightUnion discreteHeight;
    private DiscreteWidthUnion discreteWidth;
    private Background fill;
    private Opacity fillOpacity;
    private Double height;
    private CornerRadius opacity;
    private Double step;
    private Background stroke;
    private Cap strokeCap;
    private StrokeDashUnion strokeDash;
    private CornerRadius strokeDashOffset;
    private StrokeJoinUnion strokeJoin;
    private CornerRadius strokeMiterLimit;
    private Opacity strokeOpacity;
    private FontSize strokeWidth;
    private Double width;

    /**
     * Whether the view should be clipped.
     */
    @JsonProperty("clip")
    public Boolean getClip() { return clip; }
    @JsonProperty("clip")
    public void setClip(Boolean value) { this.clip = value; }

    /**
     * The default height when the plot has a continuous y-field for x or latitude, or has arc
     * marks.
     *
     * __Default value:__ `200`
     */
    @JsonProperty("continuousHeight")
    public Double getContinuousHeight() { return continuousHeight; }
    @JsonProperty("continuousHeight")
    public void setContinuousHeight(Double value) { this.continuousHeight = value; }

    /**
     * The default width when the plot has a continuous field for x or longitude, or has arc
     * marks.
     *
     * __Default value:__ `200`
     */
    @JsonProperty("continuousWidth")
    public Double getContinuousWidth() { return continuousWidth; }
    @JsonProperty("continuousWidth")
    public void setContinuousWidth(Double value) { this.continuousWidth = value; }

    @JsonProperty("cornerRadius")
    public CornerRadius getCornerRadius() { return cornerRadius; }
    @JsonProperty("cornerRadius")
    public void setCornerRadius(CornerRadius value) { this.cornerRadius = value; }

    /**
     * The mouse cursor used over the view. Any valid [CSS cursor
     * type](https://developer.mozilla.org/en-US/docs/Web/CSS/cursor#Values) can be used.
     */
    @JsonProperty("cursor")
    public Cursor getCursor() { return cursor; }
    @JsonProperty("cursor")
    public void setCursor(Cursor value) { this.cursor = value; }

    /**
     * The default height when the plot has non arc marks and either a discrete y-field or no
     * y-field. The height can be either a number indicating a fixed height or an object in the
     * form of `{step: number}` defining the height per discrete step.
     *
     * __Default value:__ a step size based on `config.view.step`.
     */
    @JsonProperty("discreteHeight")
    public DiscreteHeightUnion getDiscreteHeight() { return discreteHeight; }
    @JsonProperty("discreteHeight")
    public void setDiscreteHeight(DiscreteHeightUnion value) { this.discreteHeight = value; }

    /**
     * The default width when the plot has non-arc marks and either a discrete x-field or no
     * x-field. The width can be either a number indicating a fixed width or an object in the
     * form of `{step: number}` defining the width per discrete step.
     *
     * __Default value:__ a step size based on `config.view.step`.
     */
    @JsonProperty("discreteWidth")
    public DiscreteWidthUnion getDiscreteWidth() { return discreteWidth; }
    @JsonProperty("discreteWidth")
    public void setDiscreteWidth(DiscreteWidthUnion value) { this.discreteWidth = value; }

    /**
     * The fill color.
     *
     * __Default value:__ `undefined`
     */
    @JsonProperty("fill")
    public Background getFill() { return fill; }
    @JsonProperty("fill")
    public void setFill(Background value) { this.fill = value; }

    @JsonProperty("fillOpacity")
    public Opacity getFillOpacity() { return fillOpacity; }
    @JsonProperty("fillOpacity")
    public void setFillOpacity(Opacity value) { this.fillOpacity = value; }

    /**
     * Default height
     *
     * __Deprecated:__ Since Vega-Lite 4.0. Please use continuousHeight and discreteHeight
     * instead.
     */
    @JsonProperty("height")
    public Double getHeight() { return height; }
    @JsonProperty("height")
    public void setHeight(Double value) { this.height = value; }

    /**
     * The overall opacity (value between [0,1]).
     *
     * __Default value:__ `0.7` for non-aggregate plots with `point`, `tick`, `circle`, or
     * `square` marks or layered `bar` charts and `1` otherwise.
     */
    @JsonProperty("opacity")
    public CornerRadius getOpacity() { return opacity; }
    @JsonProperty("opacity")
    public void setOpacity(CornerRadius value) { this.opacity = value; }

    /**
     * Default step size for x-/y- discrete fields.
     */
    @JsonProperty("step")
    public Double getStep() { return step; }
    @JsonProperty("step")
    public void setStep(Double value) { this.step = value; }

    /**
     * The stroke color.
     *
     * __Default value:__ `"#ddd"`
     */
    @JsonProperty("stroke")
    public Background getStroke() { return stroke; }
    @JsonProperty("stroke")
    public void setStroke(Background value) { this.stroke = value; }

    @JsonProperty("strokeCap")
    public Cap getStrokeCap() { return strokeCap; }
    @JsonProperty("strokeCap")
    public void setStrokeCap(Cap value) { this.strokeCap = value; }

    @JsonProperty("strokeDash")
    public StrokeDashUnion getStrokeDash() { return strokeDash; }
    @JsonProperty("strokeDash")
    public void setStrokeDash(StrokeDashUnion value) { this.strokeDash = value; }

    @JsonProperty("strokeDashOffset")
    public CornerRadius getStrokeDashOffset() { return strokeDashOffset; }
    @JsonProperty("strokeDashOffset")
    public void setStrokeDashOffset(CornerRadius value) { this.strokeDashOffset = value; }

    @JsonProperty("strokeJoin")
    public StrokeJoinUnion getStrokeJoin() { return strokeJoin; }
    @JsonProperty("strokeJoin")
    public void setStrokeJoin(StrokeJoinUnion value) { this.strokeJoin = value; }

    @JsonProperty("strokeMiterLimit")
    public CornerRadius getStrokeMiterLimit() { return strokeMiterLimit; }
    @JsonProperty("strokeMiterLimit")
    public void setStrokeMiterLimit(CornerRadius value) { this.strokeMiterLimit = value; }

    @JsonProperty("strokeOpacity")
    public Opacity getStrokeOpacity() { return strokeOpacity; }
    @JsonProperty("strokeOpacity")
    public void setStrokeOpacity(Opacity value) { this.strokeOpacity = value; }

    @JsonProperty("strokeWidth")
    public FontSize getStrokeWidth() { return strokeWidth; }
    @JsonProperty("strokeWidth")
    public void setStrokeWidth(FontSize value) { this.strokeWidth = value; }

    /**
     * Default width
     *
     * __Deprecated:__ Since Vega-Lite 4.0. Please use continuousWidth and discreteWidth instead.
     */
    @JsonProperty("width")
    public Double getWidth() { return width; }
    @JsonProperty("width")
    public void setWidth(Double value) { this.width = value; }
}
