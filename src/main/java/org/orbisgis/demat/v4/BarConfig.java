package org.orbisgis.demat.v4;

import com.fasterxml.jackson.annotation.*;

/**
 * Bar-Specific Config
 */
public class BarConfig {
    private TitleAlignUnion align;
    private Angle angle;
    private Aria aria;
    private BackgroundUnion ariaRole;
    private BackgroundUnion ariaRoleDescription;
    private Aria aspect;
    private BackgroundUnion baseline;
    private Double binSpacing;
    private BlendUnion blend;
    private MarkConfigExprOrSignalRefColor color;
    private Double continuousBandSize;
    private CornerRadiusUnion cornerRadius;
    private CornerRadiusUnion cornerRadiusBottomLeft;
    private CornerRadiusUnion cornerRadiusBottomRight;
    private CornerRadiusUnion cornerRadiusEnd;
    private CornerRadiusUnion cornerRadiusTopLeft;
    private CornerRadiusUnion cornerRadiusTopRight;
    private CursorUnion cursor;
    private BackgroundUnion description;
    private Dir dir;
    private Double discreteBandSize;
    private CornerRadiusUnion dx;
    private CornerRadiusUnion dy;
    private BackgroundUnion ellipsis;
    private CornerRadiusUnion endAngle;
    private MarkConfigExprOrSignalRefFill fill;
    private Boolean filled;
    private Opacity fillOpacity;
    private BackgroundUnion font;
    private FontSize fontSize;
    private BackgroundUnion fontStyle;
    private FontWeightUnion fontWeight;
    private CornerRadiusUnion height;
    private BackgroundUnion href;
    private CornerRadiusUnion innerRadius;
    private MarkConfigExprOrSignalRefInterpolate interpolate;
    private Invalid invalid;
    private CornerRadiusUnion limit;
    private BackgroundUnion lineBreak;
    private CornerRadiusUnion lineHeight;
    private CornerRadiusUnion opacity;
    private Boolean order;
    private Orientation orient;
    private CornerRadiusUnion outerRadius;
    private CornerRadiusUnion padAngle;
    private CornerRadiusUnion radius;
    private CornerRadiusUnion radius2;
    private BackgroundUnion shape;
    private CornerRadiusUnion size;
    private Aria smooth;
    private CornerRadiusUnion startAngle;
    private MarkConfigExprOrSignalRefFill stroke;
    private Cap strokeCap;
    private StrokeDashUnion strokeDash;
    private CornerRadiusUnion strokeDashOffset;
    private StrokeJoinUnion strokeJoin;
    private CornerRadiusUnion strokeMiterLimit;
    private CornerRadiusUnion strokeOffset;
    private Opacity strokeOpacity;
    private FontSize strokeWidth;
    private CornerRadiusUnion tension;
    private ConditionalPredicateValueDefTextExprRefText text;
    private CornerRadiusUnion theta;
    private CornerRadiusUnion theta2;
    private Double timeUnitBand;
    private Double timeUnitBandPosition;
    private MarkConfigExprOrSignalRefTooltip tooltip;
    private BackgroundUnion url;
    private CornerRadiusUnion width;
    private X x;
    private X x2;
    private X y;
    private X y2;

    /**
     * The horizontal alignment of the text or ranged marks (area, bar, image, rect, rule). One
     * of `"left"`, `"right"`, `"center"`.
     *
     * __Note:__ Expression reference is *not* supported for range marks.
     */
    @JsonProperty("align")
    public TitleAlignUnion getAlign() { return align; }
    @JsonProperty("align")
    public void setAlign(TitleAlignUnion value) { this.align = value; }

    @JsonProperty("angle")
    public Angle getAngle() { return angle; }
    @JsonProperty("angle")
    public void setAngle(Angle value) { this.angle = value; }

    @JsonProperty("aria")
    public Aria getAria() { return aria; }
    @JsonProperty("aria")
    public void setAria(Aria value) { this.aria = value; }

    @JsonProperty("ariaRole")
    public BackgroundUnion getAriaRole() { return ariaRole; }
    @JsonProperty("ariaRole")
    public void setAriaRole(BackgroundUnion value) { this.ariaRole = value; }

    @JsonProperty("ariaRoleDescription")
    public BackgroundUnion getAriaRoleDescription() { return ariaRoleDescription; }
    @JsonProperty("ariaRoleDescription")
    public void setAriaRoleDescription(BackgroundUnion value) { this.ariaRoleDescription = value; }

    @JsonProperty("aspect")
    public Aria getAspect() { return aspect; }
    @JsonProperty("aspect")
    public void setAspect(Aria value) { this.aspect = value; }

    /**
     * For text marks, the vertical text baseline. One of `"alphabetic"` (default), `"top"`,
     * `"middle"`, `"bottom"`, `"line-top"`, `"line-bottom"`, or an expression reference that
     * provides one of the valid values. The `"line-top"` and `"line-bottom"` values operate
     * similarly to `"top"` and `"bottom"`, but are calculated relative to the `lineHeight`
     * rather than `fontSize` alone.
     *
     * For range marks, the vertical alignment of the marks. One of `"top"`, `"middle"`,
     * `"bottom"`.
     *
     * __Note:__ Expression reference is *not* supported for range marks.
     */
    @JsonProperty("baseline")
    public BackgroundUnion getBaseline() { return baseline; }
    @JsonProperty("baseline")
    public void setBaseline(BackgroundUnion value) { this.baseline = value; }

    /**
     * Offset between bars for binned field. The ideal value for this is either 0 (preferred by
     * statisticians) or 1 (Vega-Lite default, D3 example style).
     *
     * __Default value:__ `1`
     */
    @JsonProperty("binSpacing")
    public Double getBinSpacing() { return binSpacing; }
    @JsonProperty("binSpacing")
    public void setBinSpacing(Double value) { this.binSpacing = value; }

    @JsonProperty("blend")
    public BlendUnion getBlend() { return blend; }
    @JsonProperty("blend")
    public void setBlend(BlendUnion value) { this.blend = value; }

    /**
     * Default color.
     *
     * __Default value:__ <span style="color: #4682b4;">&#9632;</span> `"#4682b4"`
     *
     * __Note:__ - This property cannot be used in a [style
     * config](https://vega.github.io/vega-lite/docs/mark.html#style-config). - The `fill` and
     * `stroke` properties have higher precedence than `color` and will override `color`.
     */
    @JsonProperty("color")
    public MarkConfigExprOrSignalRefColor getColor() { return color; }
    @JsonProperty("color")
    public void setColor(MarkConfigExprOrSignalRefColor value) { this.color = value; }

    /**
     * The default size of the bars on continuous scales.
     *
     * __Default value:__ `5`
     */
    @JsonProperty("continuousBandSize")
    public Double getContinuousBandSize() { return continuousBandSize; }
    @JsonProperty("continuousBandSize")
    public void setContinuousBandSize(Double value) { this.continuousBandSize = value; }

    @JsonProperty("cornerRadius")
    public CornerRadiusUnion getCornerRadius() { return cornerRadius; }
    @JsonProperty("cornerRadius")
    public void setCornerRadius(CornerRadiusUnion value) { this.cornerRadius = value; }

    @JsonProperty("cornerRadiusBottomLeft")
    public CornerRadiusUnion getCornerRadiusBottomLeft() { return cornerRadiusBottomLeft; }
    @JsonProperty("cornerRadiusBottomLeft")
    public void setCornerRadiusBottomLeft(CornerRadiusUnion value) { this.cornerRadiusBottomLeft = value; }

    @JsonProperty("cornerRadiusBottomRight")
    public CornerRadiusUnion getCornerRadiusBottomRight() { return cornerRadiusBottomRight; }
    @JsonProperty("cornerRadiusBottomRight")
    public void setCornerRadiusBottomRight(CornerRadiusUnion value) { this.cornerRadiusBottomRight = value; }

    /**
     * - For vertical bars, top-left and top-right corner radius. - For horizontal bars,
     * top-right and bottom-right corner radius.
     */
    @JsonProperty("cornerRadiusEnd")
    public CornerRadiusUnion getCornerRadiusEnd() { return cornerRadiusEnd; }
    @JsonProperty("cornerRadiusEnd")
    public void setCornerRadiusEnd(CornerRadiusUnion value) { this.cornerRadiusEnd = value; }

    @JsonProperty("cornerRadiusTopLeft")
    public CornerRadiusUnion getCornerRadiusTopLeft() { return cornerRadiusTopLeft; }
    @JsonProperty("cornerRadiusTopLeft")
    public void setCornerRadiusTopLeft(CornerRadiusUnion value) { this.cornerRadiusTopLeft = value; }

    @JsonProperty("cornerRadiusTopRight")
    public CornerRadiusUnion getCornerRadiusTopRight() { return cornerRadiusTopRight; }
    @JsonProperty("cornerRadiusTopRight")
    public void setCornerRadiusTopRight(CornerRadiusUnion value) { this.cornerRadiusTopRight = value; }

    @JsonProperty("cursor")
    public CursorUnion getCursor() { return cursor; }
    @JsonProperty("cursor")
    public void setCursor(CursorUnion value) { this.cursor = value; }

    @JsonProperty("description")
    public BackgroundUnion getDescription() { return description; }
    @JsonProperty("description")
    public void setDescription(BackgroundUnion value) { this.description = value; }

    @JsonProperty("dir")
    public Dir getDir() { return dir; }
    @JsonProperty("dir")
    public void setDir(Dir value) { this.dir = value; }

    /**
     * The default size of the bars with discrete dimensions. If unspecified, the default size
     * is  `step-2`, which provides 2 pixel offset between bars.
     */
    @JsonProperty("discreteBandSize")
    public Double getDiscreteBandSize() { return discreteBandSize; }
    @JsonProperty("discreteBandSize")
    public void setDiscreteBandSize(Double value) { this.discreteBandSize = value; }

    @JsonProperty("dx")
    public CornerRadiusUnion getDx() { return dx; }
    @JsonProperty("dx")
    public void setDx(CornerRadiusUnion value) { this.dx = value; }

    @JsonProperty("dy")
    public CornerRadiusUnion getDy() { return dy; }
    @JsonProperty("dy")
    public void setDy(CornerRadiusUnion value) { this.dy = value; }

    @JsonProperty("ellipsis")
    public BackgroundUnion getEllipsis() { return ellipsis; }
    @JsonProperty("ellipsis")
    public void setEllipsis(BackgroundUnion value) { this.ellipsis = value; }

    @JsonProperty("endAngle")
    public CornerRadiusUnion getEndAngle() { return endAngle; }
    @JsonProperty("endAngle")
    public void setEndAngle(CornerRadiusUnion value) { this.endAngle = value; }

    /**
     * Default fill color. This property has higher precedence than `config.color`. Set to
     * `null` to remove fill.
     *
     * __Default value:__ (None)
     */
    @JsonProperty("fill")
    public MarkConfigExprOrSignalRefFill getFill() { return fill; }
    @JsonProperty("fill")
    public void setFill(MarkConfigExprOrSignalRefFill value) { this.fill = value; }

    /**
     * Whether the mark's color should be used as fill color instead of stroke color.
     *
     * __Default value:__ `false` for all `point`, `line`, and `rule` marks as well as
     * `geoshape` marks for
     * [`graticule`](https://vega.github.io/vega-lite/docs/data.html#graticule) data sources;
     * otherwise, `true`.
     *
     * __Note:__ This property cannot be used in a [style
     * config](https://vega.github.io/vega-lite/docs/mark.html#style-config).
     */
    @JsonProperty("filled")
    public Boolean getFilled() { return filled; }
    @JsonProperty("filled")
    public void setFilled(Boolean value) { this.filled = value; }

    @JsonProperty("fillOpacity")
    public Opacity getFillOpacity() { return fillOpacity; }
    @JsonProperty("fillOpacity")
    public void setFillOpacity(Opacity value) { this.fillOpacity = value; }

    @JsonProperty("font")
    public BackgroundUnion getFont() { return font; }
    @JsonProperty("font")
    public void setFont(BackgroundUnion value) { this.font = value; }

    @JsonProperty("fontSize")
    public FontSize getFontSize() { return fontSize; }
    @JsonProperty("fontSize")
    public void setFontSize(FontSize value) { this.fontSize = value; }

    @JsonProperty("fontStyle")
    public BackgroundUnion getFontStyle() { return fontStyle; }
    @JsonProperty("fontStyle")
    public void setFontStyle(BackgroundUnion value) { this.fontStyle = value; }

    @JsonProperty("fontWeight")
    public FontWeightUnion getFontWeight() { return fontWeight; }
    @JsonProperty("fontWeight")
    public void setFontWeight(FontWeightUnion value) { this.fontWeight = value; }

    @JsonProperty("height")
    public CornerRadiusUnion getHeight() { return height; }
    @JsonProperty("height")
    public void setHeight(CornerRadiusUnion value) { this.height = value; }

    @JsonProperty("href")
    public BackgroundUnion getHref() { return href; }
    @JsonProperty("href")
    public void setHref(BackgroundUnion value) { this.href = value; }

    /**
     * The inner radius in pixels of arc marks. `innerRadius` is an alias for `radius2`.
     */
    @JsonProperty("innerRadius")
    public CornerRadiusUnion getInnerRadius() { return innerRadius; }
    @JsonProperty("innerRadius")
    public void setInnerRadius(CornerRadiusUnion value) { this.innerRadius = value; }

    @JsonProperty("interpolate")
    public MarkConfigExprOrSignalRefInterpolate getInterpolate() { return interpolate; }
    @JsonProperty("interpolate")
    public void setInterpolate(MarkConfigExprOrSignalRefInterpolate value) { this.interpolate = value; }

    /**
     * Defines how Vega-Lite should handle marks for invalid values (`null` and `NaN`). - If set
     * to `"filter"` (default), all data items with null values will be skipped (for line,
     * trail, and area marks) or filtered (for other marks). - If `null`, all data items are
     * included. In this case, invalid values will be interpreted as zeroes.
     */
    @JsonProperty("invalid")
    public Invalid getInvalid() { return invalid; }
    @JsonProperty("invalid")
    public void setInvalid(Invalid value) { this.invalid = value; }

    @JsonProperty("limit")
    public CornerRadiusUnion getLimit() { return limit; }
    @JsonProperty("limit")
    public void setLimit(CornerRadiusUnion value) { this.limit = value; }

    @JsonProperty("lineBreak")
    public BackgroundUnion getLineBreak() { return lineBreak; }
    @JsonProperty("lineBreak")
    public void setLineBreak(BackgroundUnion value) { this.lineBreak = value; }

    @JsonProperty("lineHeight")
    public CornerRadiusUnion getLineHeight() { return lineHeight; }
    @JsonProperty("lineHeight")
    public void setLineHeight(CornerRadiusUnion value) { this.lineHeight = value; }

    /**
     * The overall opacity (value between [0,1]).
     *
     * __Default value:__ `0.7` for non-aggregate plots with `point`, `tick`, `circle`, or
     * `square` marks or layered `bar` charts and `1` otherwise.
     */
    @JsonProperty("opacity")
    public CornerRadiusUnion getOpacity() { return opacity; }
    @JsonProperty("opacity")
    public void setOpacity(CornerRadiusUnion value) { this.opacity = value; }

    /**
     * For line and trail marks, this `order` property can be set to `null` or `false` to make
     * the lines use the original order in the data sources.
     */
    @JsonProperty("order")
    public Boolean getOrder() { return order; }
    @JsonProperty("order")
    public void setOrder(Boolean value) { this.order = value; }

    /**
     * The orientation of a non-stacked bar, tick, area, and line charts. The value is either
     * horizontal (default) or vertical. - For bar, rule and tick, this determines whether the
     * size of the bar and tick should be applied to x or y dimension. - For area, this property
     * determines the orient property of the Vega output. - For line and trail marks, this
     * property determines the sort order of the points in the line if `config.sortLineBy` is
     * not specified. For stacked charts, this is always determined by the orientation of the
     * stack; therefore explicitly specified value will be ignored.
     */
    @JsonProperty("orient")
    public Orientation getOrient() { return orient; }
    @JsonProperty("orient")
    public void setOrient(Orientation value) { this.orient = value; }

    /**
     * The outer radius in pixels of arc marks. `outerRadius` is an alias for `radius`.
     */
    @JsonProperty("outerRadius")
    public CornerRadiusUnion getOuterRadius() { return outerRadius; }
    @JsonProperty("outerRadius")
    public void setOuterRadius(CornerRadiusUnion value) { this.outerRadius = value; }

    @JsonProperty("padAngle")
    public CornerRadiusUnion getPadAngle() { return padAngle; }
    @JsonProperty("padAngle")
    public void setPadAngle(CornerRadiusUnion value) { this.padAngle = value; }

    /**
     * For arc mark, the primary (outer) radius in pixels.
     *
     * For text marks, polar coordinate radial offset, in pixels, of the text from the origin
     * determined by the `x` and `y` properties.
     */
    @JsonProperty("radius")
    public CornerRadiusUnion getRadius() { return radius; }
    @JsonProperty("radius")
    public void setRadius(CornerRadiusUnion value) { this.radius = value; }

    /**
     * The secondary (inner) radius in pixels of arc marks.
     */
    @JsonProperty("radius2")
    public CornerRadiusUnion getRadius2() { return radius2; }
    @JsonProperty("radius2")
    public void setRadius2(CornerRadiusUnion value) { this.radius2 = value; }

    @JsonProperty("shape")
    public BackgroundUnion getShape() { return shape; }
    @JsonProperty("shape")
    public void setShape(BackgroundUnion value) { this.shape = value; }

    /**
     * Default size for marks. - For `point`/`circle`/`square`, this represents the pixel area
     * of the marks. Note that this value sets the area of the symbol; the side lengths will
     * increase with the square root of this value. - For `bar`, this represents the band size
     * of the bar, in pixels. - For `text`, this represents the font size, in pixels.
     *
     * __Default value:__ - `30` for point, circle, square marks; width/height's `step` - `2`
     * for bar marks with discrete dimensions; - `5` for bar marks with continuous dimensions; -
     * `11` for text marks.
     */
    @JsonProperty("size")
    public CornerRadiusUnion getSize() { return size; }
    @JsonProperty("size")
    public void setSize(CornerRadiusUnion value) { this.size = value; }

    @JsonProperty("smooth")
    public Aria getSmooth() { return smooth; }
    @JsonProperty("smooth")
    public void setSmooth(Aria value) { this.smooth = value; }

    @JsonProperty("startAngle")
    public CornerRadiusUnion getStartAngle() { return startAngle; }
    @JsonProperty("startAngle")
    public void setStartAngle(CornerRadiusUnion value) { this.startAngle = value; }

    /**
     * Default stroke color. This property has higher precedence than `config.color`. Set to
     * `null` to remove stroke.
     *
     * __Default value:__ (None)
     */
    @JsonProperty("stroke")
    public MarkConfigExprOrSignalRefFill getStroke() { return stroke; }
    @JsonProperty("stroke")
    public void setStroke(MarkConfigExprOrSignalRefFill value) { this.stroke = value; }

    @JsonProperty("strokeCap")
    public Cap getStrokeCap() { return strokeCap; }
    @JsonProperty("strokeCap")
    public void setStrokeCap(Cap value) { this.strokeCap = value; }

    @JsonProperty("strokeDash")
    public StrokeDashUnion getStrokeDash() { return strokeDash; }
    @JsonProperty("strokeDash")
    public void setStrokeDash(StrokeDashUnion value) { this.strokeDash = value; }

    @JsonProperty("strokeDashOffset")
    public CornerRadiusUnion getStrokeDashOffset() { return strokeDashOffset; }
    @JsonProperty("strokeDashOffset")
    public void setStrokeDashOffset(CornerRadiusUnion value) { this.strokeDashOffset = value; }

    @JsonProperty("strokeJoin")
    public StrokeJoinUnion getStrokeJoin() { return strokeJoin; }
    @JsonProperty("strokeJoin")
    public void setStrokeJoin(StrokeJoinUnion value) { this.strokeJoin = value; }

    @JsonProperty("strokeMiterLimit")
    public CornerRadiusUnion getStrokeMiterLimit() { return strokeMiterLimit; }
    @JsonProperty("strokeMiterLimit")
    public void setStrokeMiterLimit(CornerRadiusUnion value) { this.strokeMiterLimit = value; }

    @JsonProperty("strokeOffset")
    public CornerRadiusUnion getStrokeOffset() { return strokeOffset; }
    @JsonProperty("strokeOffset")
    public void setStrokeOffset(CornerRadiusUnion value) { this.strokeOffset = value; }

    @JsonProperty("strokeOpacity")
    public Opacity getStrokeOpacity() { return strokeOpacity; }
    @JsonProperty("strokeOpacity")
    public void setStrokeOpacity(Opacity value) { this.strokeOpacity = value; }

    @JsonProperty("strokeWidth")
    public FontSize getStrokeWidth() { return strokeWidth; }
    @JsonProperty("strokeWidth")
    public void setStrokeWidth(FontSize value) { this.strokeWidth = value; }

    @JsonProperty("tension")
    public CornerRadiusUnion getTension() { return tension; }
    @JsonProperty("tension")
    public void setTension(CornerRadiusUnion value) { this.tension = value; }

    @JsonProperty("text")
    public ConditionalPredicateValueDefTextExprRefText getText() { return text; }
    @JsonProperty("text")
    public void setText(ConditionalPredicateValueDefTextExprRefText value) { this.text = value; }

    /**
     * - For arc marks, the arc length in radians if theta2 is not specified, otherwise the
     * start arc angle. (A value of 0 indicates up or “north”, increasing values proceed
     * clockwise.)
     *
     * - For text marks, polar coordinate angle in radians.
     */
    @JsonProperty("theta")
    public CornerRadiusUnion getTheta() { return theta; }
    @JsonProperty("theta")
    public void setTheta(CornerRadiusUnion value) { this.theta = value; }

    /**
     * The end angle of arc marks in radians. A value of 0 indicates up or “north”, increasing
     * values proceed clockwise.
     */
    @JsonProperty("theta2")
    public CornerRadiusUnion getTheta2() { return theta2; }
    @JsonProperty("theta2")
    public void setTheta2(CornerRadiusUnion value) { this.theta2 = value; }

    /**
     * Default relative band size for a time unit. If set to `1`, the bandwidth of the marks
     * will be equal to the time unit band step. If set to `0.5`, bandwidth of the marks will be
     * half of the time unit band step.
     */
    @JsonProperty("timeUnitBand")
    public Double getTimeUnitBand() { return timeUnitBand; }
    @JsonProperty("timeUnitBand")
    public void setTimeUnitBand(Double value) { this.timeUnitBand = value; }

    /**
     * Default relative band position for a time unit. If set to `0`, the marks will be
     * positioned at the beginning of the time unit band step. If set to `0.5`, the marks will
     * be positioned in the middle of the time unit band step.
     */
    @JsonProperty("timeUnitBandPosition")
    public Double getTimeUnitBandPosition() { return timeUnitBandPosition; }
    @JsonProperty("timeUnitBandPosition")
    public void setTimeUnitBandPosition(Double value) { this.timeUnitBandPosition = value; }

    /**
     * The tooltip text string to show upon mouse hover or an object defining which fields
     * should the tooltip be derived from.
     *
     * - If `tooltip` is `true` or `{"content": "encoding"}`, then all fields from `encoding`
     * will be used. - If `tooltip` is `{"content": "data"}`, then all fields that appear in the
     * highlighted data point will be used. - If set to `null` or `false`, then no tooltip will
     * be used.
     *
     * See the [`tooltip`](https://vega.github.io/vega-lite/docs/tooltip.html) documentation for
     * a detailed discussion about tooltip  in Vega-Lite.
     *
     * __Default value:__ `null`
     */
    @JsonProperty("tooltip")
    public MarkConfigExprOrSignalRefTooltip getTooltip() { return tooltip; }
    @JsonProperty("tooltip")
    public void setTooltip(MarkConfigExprOrSignalRefTooltip value) { this.tooltip = value; }

    @JsonProperty("url")
    public BackgroundUnion getURL() { return url; }
    @JsonProperty("url")
    public void setURL(BackgroundUnion value) { this.url = value; }

    @JsonProperty("width")
    public CornerRadiusUnion getWidth() { return width; }
    @JsonProperty("width")
    public void setWidth(CornerRadiusUnion value) { this.width = value; }

    /**
     * X coordinates of the marks, or width of horizontal `"bar"` and `"area"` without specified
     * `x2` or `width`.
     *
     * The `value` of this channel can be a number or a string `"width"` for the width of the
     * plot.
     */
    @JsonProperty("x")
    public X getX() { return x; }
    @JsonProperty("x")
    public void setX(X value) { this.x = value; }

    /**
     * X2 coordinates for ranged `"area"`, `"bar"`, `"rect"`, and  `"rule"`.
     *
     * The `value` of this channel can be a number or a string `"width"` for the width of the
     * plot.
     */
    @JsonProperty("x2")
    public X getX2() { return x2; }
    @JsonProperty("x2")
    public void setX2(X value) { this.x2 = value; }

    /**
     * Y coordinates of the marks, or height of vertical `"bar"` and `"area"` without specified
     * `y2` or `height`.
     *
     * The `value` of this channel can be a number or a string `"height"` for the height of the
     * plot.
     */
    @JsonProperty("y")
    public X getY() { return y; }
    @JsonProperty("y")
    public void setY(X value) { this.y = value; }

    /**
     * Y2 coordinates for ranged `"area"`, `"bar"`, `"rect"`, and  `"rule"`.
     *
     * The `value` of this channel can be a number or a string `"height"` for the height of the
     * plot.
     */
    @JsonProperty("y2")
    public X getY2() { return y2; }
    @JsonProperty("y2")
    public void setY2(X value) { this.y2 = value; }
}
