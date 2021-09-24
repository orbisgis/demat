/*
 * DEMAT is java wrapper on top of the vega-lite library
 *
 * Demat is breton word to said "Hello".
 *
 * DEMAT is part of the OrbisGIS platform.
 *
 * OrbisGIS platform is a set of open source tools to access, process, display
 * and share geographical informations.
 *
 * It is leaded by CNRS within the French Lab-STICC laboratory <http://www.lab-sticc.fr/>,
 * DECIDE team of Vannes.
 *
 * OrbisGIS is dedicated to research in GIScience.
 *
 * The GIS group of the DECIDE team is located at :
 *
 * Laboratoire Lab-STICC – CNRS UMR 6285
 * Equipe DECIDE
 * UNIVERSITÉ DE BRETAGNE-SUD
 * Institut Universitaire de Technologie de Vannes
 * 8, Rue Montaigne - BP 561 56017 Vannes Cedex
 *
 * DEMAT is distributed under LGPL 3 license.
 *
 * Copyright (C) 2021 CNRS (Lab-STICC UMR CNRS 6285)
 *
 *
 * DEMAT is free software: you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * DEMAT is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * DEMAT. If not, see <http://www.gnu.org/licenses/>.
 *
 * For more information, please consult: <http://www.orbisgis.org/>
 * or contact directly:
 * info_at_ orbisgis.org
 */
package org.orbisgis.demat.vega;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.orbisgis.demat.vega.legend.LegendText;

/**
 * Arc-specific Config
 *
 * Image-specific Config
 *
 * Rect-Specific Config
 *
 * Area-Specific Config
 *
 * Bar-Specific Config
 *
 * Circle-Specific Config
 *
 * Geoshape-Specific Config
 *
 * Mark Config
 *
 * Point-Specific Config
 *
 * Rule-Specific Config
 *
 * Square-Specific Config
 *
 * Default style for chart subtitles
 *
 * Default style for chart titles
 *
 * Default style for axis, legend, and header labels.
 *
 * Default style for axis, legend, and header titles.
 *
 * Text-Specific Config
 *
 * Line-Specific Config
 *
 * Trail-Specific Config
 *
 * Tick-Specific Config
 */
public class StyleValue {
    private TitleAlignUnion align;
    private Angle angle;
    private Aria aria;
    private Background ariaRole;
    private Background ariaRoleDescription;
    private Aria aspect;
    private Background baseline;
    private Double binSpacing;
    private BlendUnion blend;
    private StyleColor color;
    private Double continuousBandSize;
    private CornerRadius cornerRadius;
    private CornerRadius cornerRadiusBottomLeft;
    private CornerRadius cornerRadiusBottomRight;
    private CornerRadius cornerRadiusTopLeft;
    private CornerRadius cornerRadiusTopRight;
    private CursorUnion cursor;
    private Background description;
    private Dir dir;
    private Double discreteBandSize;
    private CornerRadius dx;
    private CornerRadius dy;
    private Background ellipsis;
    private CornerRadius endAngle;
    private StyleFill fill;
    private Boolean filled;
    private Opacity fillOpacity;
    private Background font;
    private FontSize fontSize;
    private Background fontStyle;
    private FontWeightUnion fontWeight;
    private CornerRadius height;
    private Background href;
    private CornerRadius innerRadius;
    private MarkConfigExprOrSignalRefInterpolate interpolate;
    private Invalid invalid;
    private CornerRadius limit;
    private Background lineBreak;
    private CornerRadius lineHeight;
    private Opacity opacity;
    private Boolean order;
    private StyleOrient orient;
    private CornerRadius outerRadius;
    private CornerRadius padAngle;
    private CornerRadius radius;
    private CornerRadius radius2;
    private Background shape;
    private FontSize size;
    private Aria smooth;
    private CornerRadius startAngle;
    private StyleFill stroke;
    private Cap strokeCap;
    private StrokeDashUnion strokeDash;
    private CornerRadius strokeDashOffset;
    private StrokeJoinUnion strokeJoin;
    private CornerRadius strokeMiterLimit;
    private CornerRadius strokeOffset;
    private Opacity strokeOpacity;
    private FontSize strokeWidth;
    private CornerRadius tension;
    private ConditionalPredicateValueDefTextExprRefText text;
    private Angle theta;
    private CornerRadius theta2;
    private Double timeUnitBand;
    private Double timeUnitBandPosition;
    private StyleTooltip tooltip;
    private Background url;
    private CornerRadius width;
    private Coordinate coordinate;
    private Coordinate coordinate2;
    private Coordinate y;
    private Coordinate y2;
    private Line line;
    private Point point;
    private CornerRadius cornerRadiusEnd;
    private Double bandSize;
    private Double thickness;
    private CornerRadius bandPosition;
    private Aria domain;
    private Cap domainCap;
    private Background domainColor;
    private StrokeDashUnion domainDash;
    private CornerRadius domainDashOffset;
    private CornerRadius domainOpacity;
    private CornerRadius domainWidth;
    private Format format;
    private String formatType;
    private Boolean grid;
    private Cap gridCap;
    private GridColorUnion gridColor;
    private AxisGridDash gridDash;
    private GridDashOffsetUnion gridDashOffset;
    private GridOpacityUnion gridOpacity;
    private GridWidthUnion gridWidth;
    private ConditionalAxisPropertyAlignNull labelAlign;
    private LabelAngle labelAngle;
    private TextBaseline labelBaseline;
    private Label labelBound;
    private GridColorUnion labelColor;
    private String labelExpr;
    private LabelFlush labelFlush;
    private CornerRadius labelFlushOffset;
    private ConditionalAxisPropertyStringNull labelFont;
    private GridWidthUnion labelFontSize;
    private ConditionalAxisPropertyFontStyleNull labelFontStyle;
    private FontWeight labelFontWeight;
    private CornerRadius labelLimit;
    private CornerRadius labelLineHeight;
    private GridDashOffsetUnion labelOffset;
    private GridDashOffsetUnion labelOpacity;
    private LabelOverlap labelOverlap;
    private GridDashOffsetUnion labelPadding;
    private Aria labels;
    private CornerRadius labelSeparation;
    private CornerRadius maxExtent;
    private CornerRadius minExtent;
    private Double offset;
    private CornerRadius position;
    private LegendText style;
    private TickBandUnion tickBand;
    private Cap tickCap;
    private GridColorUnion tickColor;
    private TickCount tickCount;
    private AxisTickDash tickDash;
    private GridDashOffsetUnion tickDashOffset;
    private Aria tickExtra;
    private CornerRadius tickMinStep;
    private CornerRadius tickOffset;
    private GridDashOffsetUnion tickOpacity;
    private Aria tickRound;
    private Aria ticks;
    private GridWidthUnion tickSize;
    private GridWidthUnion tickWidth;
    private LegendText title;
    private TitleAlignUnion titleAlign;
    private TitleAnchorUnion titleAnchor;
    private CornerRadius titleAngle;
    private Background titleBaseline;
    private Background titleColor;
    private Background titleFont;
    private FontSize titleFontSize;
    private Background titleFontStyle;
    private FontWeightUnion titleFontWeight;
    private FontSize titleLimit;
    private CornerRadius titleLineHeight;
    private CornerRadius titleOpacity;
    private CornerRadius titlePadding;
    private CornerRadius titleX;
    private CornerRadius titleY;
    private CornerRadius translate;
    private Values values;
    private Double zindex;

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

    /**
     * The rotation angle of the text, in degrees.
     */
    @JsonProperty("angle")
    public Angle getAngle() { return angle; }
    @JsonProperty("angle")
    public void setAngle(Angle value) { this.angle = value; }

    /**
     * A boolean flag indicating if [ARIA
     * attributes](https://developer.mozilla.org/en-US/docs/Web/Accessibility/ARIA) should be
     * included (SVG output only). If `false`, the "aria-hidden" attribute will be set on the
     * output SVG element, removing the mark item from the ARIA accessibility tree.
     */
    @JsonProperty("aria")
    public Aria getAria() { return aria; }
    @JsonProperty("aria")
    public void setAria(Aria value) { this.aria = value; }

    /**
     * Sets the type of user interface element of the mark item for [ARIA
     * accessibility](https://developer.mozilla.org/en-US/docs/Web/Accessibility/ARIA) (SVG
     * output only). If specified, this property determines the "role" attribute. Warning: this
     * property is experimental and may be changed in the future.
     */
    @JsonProperty("ariaRole")
    public Background getAriaRole() { return ariaRole; }
    @JsonProperty("ariaRole")
    public void setAriaRole(Background value) { this.ariaRole = value; }

    /**
     * A human-readable, author-localized description for the role of the mark item for [ARIA
     * accessibility](https://developer.mozilla.org/en-US/docs/Web/Accessibility/ARIA) (SVG
     * output only). If specified, this property determines the "aria-roledescription"
     * attribute. Warning: this property is experimental and may be changed in the future.
     */
    @JsonProperty("ariaRoleDescription")
    public Background getAriaRoleDescription() { return ariaRoleDescription; }
    @JsonProperty("ariaRoleDescription")
    public void setAriaRoleDescription(Background value) { this.ariaRoleDescription = value; }

    /**
     * Whether to keep aspect ratio of image marks.
     */
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
    public Background getBaseline() { return baseline; }
    @JsonProperty("baseline")
    public void setBaseline(Background value) { this.baseline = value; }

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

    /**
     * The color blend mode for drawing an item on its current background. Any valid [CSS
     * mix-blend-mode](https://developer.mozilla.org/en-US/docs/Web/CSS/mix-blend-mode) value
     * can be used.
     *
     * __Default value: `"source-over"`
     */
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
    public StyleColor getColor() { return color; }
    @JsonProperty("color")
    public void setColor(StyleColor value) { this.color = value; }

    /**
     * The default size of the bars on continuous scales.
     *
     * __Default value:__ `5`
     */
    @JsonProperty("continuousBandSize")
    public Double getContinuousBandSize() { return continuousBandSize; }
    @JsonProperty("continuousBandSize")
    public void setContinuousBandSize(Double value) { this.continuousBandSize = value; }

    /**
     * The radius in pixels of rounded rectangles or arcs' corners.
     *
     * __Default value:__ `0`
     */
    @JsonProperty("cornerRadius")
    public CornerRadius getCornerRadius() { return cornerRadius; }
    @JsonProperty("cornerRadius")
    public void setCornerRadius(CornerRadius value) { this.cornerRadius = value; }

    /**
     * The radius in pixels of rounded rectangles' bottom left corner.
     *
     * __Default value:__ `0`
     */
    @JsonProperty("cornerRadiusBottomLeft")
    public CornerRadius getCornerRadiusBottomLeft() { return cornerRadiusBottomLeft; }
    @JsonProperty("cornerRadiusBottomLeft")
    public void setCornerRadiusBottomLeft(CornerRadius value) { this.cornerRadiusBottomLeft = value; }

    /**
     * The radius in pixels of rounded rectangles' bottom right corner.
     *
     * __Default value:__ `0`
     */
    @JsonProperty("cornerRadiusBottomRight")
    public CornerRadius getCornerRadiusBottomRight() { return cornerRadiusBottomRight; }
    @JsonProperty("cornerRadiusBottomRight")
    public void setCornerRadiusBottomRight(CornerRadius value) { this.cornerRadiusBottomRight = value; }

    /**
     * The radius in pixels of rounded rectangles' top right corner.
     *
     * __Default value:__ `0`
     */
    @JsonProperty("cornerRadiusTopLeft")
    public CornerRadius getCornerRadiusTopLeft() { return cornerRadiusTopLeft; }
    @JsonProperty("cornerRadiusTopLeft")
    public void setCornerRadiusTopLeft(CornerRadius value) { this.cornerRadiusTopLeft = value; }

    /**
     * The radius in pixels of rounded rectangles' top left corner.
     *
     * __Default value:__ `0`
     */
    @JsonProperty("cornerRadiusTopRight")
    public CornerRadius getCornerRadiusTopRight() { return cornerRadiusTopRight; }
    @JsonProperty("cornerRadiusTopRight")
    public void setCornerRadiusTopRight(CornerRadius value) { this.cornerRadiusTopRight = value; }

    /**
     * The mouse cursor used over the mark. Any valid [CSS cursor
     * type](https://developer.mozilla.org/en-US/docs/Web/CSS/cursor#Values) can be used.
     */
    @JsonProperty("cursor")
    public CursorUnion getCursor() { return cursor; }
    @JsonProperty("cursor")
    public void setCursor(CursorUnion value) { this.cursor = value; }

    /**
     * A text description of the mark item for [ARIA
     * accessibility](https://developer.mozilla.org/en-US/docs/Web/Accessibility/ARIA) (SVG
     * output only). If specified, this property determines the ["aria-label"
     * attribute](https://developer.mozilla.org/en-US/docs/Web/Accessibility/ARIA/ARIA_Techniques/Using_the_aria-label_attribute).
     */
    @JsonProperty("description")
    public Background getDescription() { return description; }
    @JsonProperty("description")
    public void setDescription(Background value) { this.description = value; }

    /**
     * The direction of the text. One of `"ltr"` (left-to-right) or `"rtl"` (right-to-left).
     * This property determines on which side is truncated in response to the limit parameter.
     *
     * __Default value:__ `"ltr"`
     */
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

    /**
     * The horizontal offset, in pixels, between the text label and its anchor point. The offset
     * is applied after rotation by the _angle_ property.
     */
    @JsonProperty("dx")
    public CornerRadius getDx() { return dx; }
    @JsonProperty("dx")
    public void setDx(CornerRadius value) { this.dx = value; }

    /**
     * The vertical offset, in pixels, between the text label and its anchor point. The offset
     * is applied after rotation by the _angle_ property.
     */
    @JsonProperty("dy")
    public CornerRadius getDy() { return dy; }
    @JsonProperty("dy")
    public void setDy(CornerRadius value) { this.dy = value; }

    /**
     * The ellipsis string for text truncated in response to the limit parameter.
     *
     * __Default value:__ `"…"`
     */
    @JsonProperty("ellipsis")
    public Background getEllipsis() { return ellipsis; }
    @JsonProperty("ellipsis")
    public void setEllipsis(Background value) { this.ellipsis = value; }

    /**
     * The end angle in radians for arc marks. A value of `0` indicates up (north), increasing
     * values proceed clockwise.
     */
    @JsonProperty("endAngle")
    public CornerRadius getEndAngle() { return endAngle; }
    @JsonProperty("endAngle")
    public void setEndAngle(CornerRadius value) { this.endAngle = value; }

    /**
     * Default fill color. This property has higher precedence than `config.color`. Set to
     * `null` to remove fill.
     *
     * __Default value:__ (None)
     */
    @JsonProperty("fill")
    public StyleFill getFill() { return fill; }
    @JsonProperty("fill")
    public void setFill(StyleFill value) { this.fill = value; }

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

    /**
     * The fill opacity (value between [0,1]).
     *
     * __Default value:__ `1`
     */
    @JsonProperty("fillOpacity")
    public Opacity getFillOpacity() { return fillOpacity; }
    @JsonProperty("fillOpacity")
    public void setFillOpacity(Opacity value) { this.fillOpacity = value; }

    /**
     * The typeface to set the text in (e.g., `"Helvetica Neue"`).
     */
    @JsonProperty("font")
    public Background getFont() { return font; }
    @JsonProperty("font")
    public void setFont(Background value) { this.font = value; }

    /**
     * The font size, in pixels.
     *
     * __Default value:__ `11`
     */
    @JsonProperty("fontSize")
    public FontSize getFontSize() { return fontSize; }
    @JsonProperty("fontSize")
    public void setFontSize(FontSize value) { this.fontSize = value; }

    /**
     * The font style (e.g., `"italic"`).
     */
    @JsonProperty("fontStyle")
    public Background getFontStyle() { return fontStyle; }
    @JsonProperty("fontStyle")
    public void setFontStyle(Background value) { this.fontStyle = value; }

    /**
     * The font weight. This can be either a string (e.g `"bold"`, `"normal"`) or a number
     * (`100`, `200`, `300`, ..., `900` where `"normal"` = `400` and `"bold"` = `700`).
     */
    @JsonProperty("fontWeight")
    public FontWeightUnion getFontWeight() { return fontWeight; }
    @JsonProperty("fontWeight")
    public void setFontWeight(FontWeightUnion value) { this.fontWeight = value; }

    /**
     * Height of the marks.
     */
    @JsonProperty("height")
    public CornerRadius getHeight() { return height; }
    @JsonProperty("height")
    public void setHeight(CornerRadius value) { this.height = value; }

    /**
     * A URL to load upon mouse click. If defined, the mark acts as a hyperlink.
     */
    @JsonProperty("href")
    public Background getHref() { return href; }
    @JsonProperty("href")
    public void setHref(Background value) { this.href = value; }

    /**
     * The inner radius in pixels of arc marks. `innerRadius` is an alias for `radius2`.
     */
    @JsonProperty("innerRadius")
    public CornerRadius getInnerRadius() { return innerRadius; }
    @JsonProperty("innerRadius")
    public void setInnerRadius(CornerRadius value) { this.innerRadius = value; }

    /**
     * The line interpolation method to use for line and area marks. One of the following: -
     * `"linear"`: piecewise linear segments, as in a polyline. - `"linear-closed"`: close the
     * linear segments to form a polygon. - `"step"`: alternate between horizontal and vertical
     * segments, as in a step function. - `"step-before"`: alternate between vertical and
     * horizontal segments, as in a step function. - `"step-after"`: alternate between
     * horizontal and vertical segments, as in a step function. - `"basis"`: a B-spline, with
     * control point duplication on the ends. - `"basis-open"`: an open B-spline; may not
     * intersect the start or end. - `"basis-closed"`: a closed B-spline, as in a loop. -
     * `"cardinal"`: a Cardinal spline, with control point duplication on the ends. -
     * `"cardinal-open"`: an open Cardinal spline; may not intersect the start or end, but will
     * intersect other control points. - `"cardinal-closed"`: a closed Cardinal spline, as in a
     * loop. - `"bundle"`: equivalent to basis, except the tension parameter is used to
     * straighten the spline. - `"monotone"`: cubic interpolation that preserves monotonicity in
     * y.
     */
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

    /**
     * The maximum length of the text mark in pixels. The text value will be automatically
     * truncated if the rendered size exceeds the limit.
     *
     * __Default value:__ `0` -- indicating no limit
     */
    @JsonProperty("limit")
    public CornerRadius getLimit() { return limit; }
    @JsonProperty("limit")
    public void setLimit(CornerRadius value) { this.limit = value; }

    /**
     * A delimiter, such as a newline character, upon which to break text strings into multiple
     * lines. This property is ignored if the text is array-valued.
     */
    @JsonProperty("lineBreak")
    public Background getLineBreak() { return lineBreak; }
    @JsonProperty("lineBreak")
    public void setLineBreak(Background value) { this.lineBreak = value; }

    /**
     * The line height in pixels (the spacing between subsequent lines of text) for multi-line
     * text marks.
     */
    @JsonProperty("lineHeight")
    public CornerRadius getLineHeight() { return lineHeight; }
    @JsonProperty("lineHeight")
    public void setLineHeight(CornerRadius value) { this.lineHeight = value; }

    /**
     * The overall opacity (value between [0,1]).
     *
     * __Default value:__ `0.7` for non-aggregate plots with `point`, `tick`, `circle`, or
     * `square` marks or layered `bar` charts and `1` otherwise.
     */
    @JsonProperty("opacity")
    public Opacity getOpacity() { return opacity; }
    @JsonProperty("opacity")
    public void setOpacity(Opacity value) { this.opacity = value; }

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
     *
     * The orientation of the axis. One of `"top"`, `"bottom"`, `"left"` or `"right"`. The
     * orientation can be used to further specialize the axis type (e.g., a y-axis oriented
     * towards the right edge of the chart).
     *
     * __Default value:__ `"bottom"` for x-axes and `"left"` for y-axes.
     */
    @JsonProperty("orient")
    public StyleOrient getOrient() { return orient; }
    @JsonProperty("orient")
    public void setOrient(StyleOrient value) { this.orient = value; }

    /**
     * The outer radius in pixels of arc marks. `outerRadius` is an alias for `radius`.
     */
    @JsonProperty("outerRadius")
    public CornerRadius getOuterRadius() { return outerRadius; }
    @JsonProperty("outerRadius")
    public void setOuterRadius(CornerRadius value) { this.outerRadius = value; }

    /**
     * The angular padding applied to sides of the arc, in radians.
     */
    @JsonProperty("padAngle")
    public CornerRadius getPadAngle() { return padAngle; }
    @JsonProperty("padAngle")
    public void setPadAngle(CornerRadius value) { this.padAngle = value; }

    /**
     * For arc mark, the primary (outer) radius in pixels.
     *
     * For text marks, polar coordinate radial offset, in pixels, of the text from the origin
     * determined by the `x` and `y` properties.
     */
    @JsonProperty("radius")
    public CornerRadius getRadius() { return radius; }
    @JsonProperty("radius")
    public void setRadius(CornerRadius value) { this.radius = value; }

    /**
     * The secondary (inner) radius in pixels of arc marks.
     */
    @JsonProperty("radius2")
    public CornerRadius getRadius2() { return radius2; }
    @JsonProperty("radius2")
    public void setRadius2(CornerRadius value) { this.radius2 = value; }

    /**
     * Shape of the point marks. Supported values include: - plotting shapes: `"circle"`,
     * `"square"`, `"cross"`, `"diamond"`, `"triangle-up"`, `"triangle-down"`,
     * `"triangle-right"`, or `"triangle-left"`. - the line symbol `"stroke"` - centered
     * directional shapes `"arrow"`, `"wedge"`, or `"triangle"` - a custom [SVG path
     * string](https://developer.mozilla.org/en-US/docs/Web/SVG/Tutorial/Paths) (For correct
     * sizing, custom shape paths should be defined within a square bounding box with
     * coordinates ranging from -1 to 1 along both the x and y dimensions.)
     *
     * __Default value:__ `"circle"`
     */
    @JsonProperty("shape")
    public Background getShape() { return shape; }
    @JsonProperty("shape")
    public void setShape(Background value) { this.shape = value; }

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
    public FontSize getSize() { return size; }
    @JsonProperty("size")
    public void setSize(FontSize value) { this.size = value; }

    /**
     * A boolean flag (default true) indicating if the image should be smoothed when resized. If
     * false, individual pixels should be scaled directly rather than interpolated with
     * smoothing. For SVG rendering, this option may not work in some browsers due to lack of
     * standardization.
     */
    @JsonProperty("smooth")
    public Aria getSmooth() { return smooth; }
    @JsonProperty("smooth")
    public void setSmooth(Aria value) { this.smooth = value; }

    /**
     * The start angle in radians for arc marks. A value of `0` indicates up (north), increasing
     * values proceed clockwise.
     */
    @JsonProperty("startAngle")
    public CornerRadius getStartAngle() { return startAngle; }
    @JsonProperty("startAngle")
    public void setStartAngle(CornerRadius value) { this.startAngle = value; }

    /**
     * Default stroke color. This property has higher precedence than `config.color`. Set to
     * `null` to remove stroke.
     *
     * __Default value:__ (None)
     */
    @JsonProperty("stroke")
    public StyleFill getStroke() { return stroke; }
    @JsonProperty("stroke")
    public void setStroke(StyleFill value) { this.stroke = value; }

    /**
     * The stroke cap for line ending style. One of `"butt"`, `"round"`, or `"square"`.
     *
     * __Default value:__ `"butt"`
     */
    @JsonProperty("strokeCap")
    public Cap getStrokeCap() { return strokeCap; }
    @JsonProperty("strokeCap")
    public void setStrokeCap(Cap value) { this.strokeCap = value; }

    /**
     * An array of alternating stroke, space lengths for creating dashed or dotted lines.
     */
    @JsonProperty("strokeDash")
    public StrokeDashUnion getStrokeDash() { return strokeDash; }
    @JsonProperty("strokeDash")
    public void setStrokeDash(StrokeDashUnion value) { this.strokeDash = value; }

    /**
     * The offset (in pixels) into which to begin drawing with the stroke dash array.
     */
    @JsonProperty("strokeDashOffset")
    public CornerRadius getStrokeDashOffset() { return strokeDashOffset; }
    @JsonProperty("strokeDashOffset")
    public void setStrokeDashOffset(CornerRadius value) { this.strokeDashOffset = value; }

    /**
     * The stroke line join method. One of `"miter"`, `"round"` or `"bevel"`.
     *
     * __Default value:__ `"miter"`
     */
    @JsonProperty("strokeJoin")
    public StrokeJoinUnion getStrokeJoin() { return strokeJoin; }
    @JsonProperty("strokeJoin")
    public void setStrokeJoin(StrokeJoinUnion value) { this.strokeJoin = value; }

    /**
     * The miter limit at which to bevel a line join.
     */
    @JsonProperty("strokeMiterLimit")
    public CornerRadius getStrokeMiterLimit() { return strokeMiterLimit; }
    @JsonProperty("strokeMiterLimit")
    public void setStrokeMiterLimit(CornerRadius value) { this.strokeMiterLimit = value; }

    /**
     * The offset in pixels at which to draw the group stroke and fill. If unspecified, the
     * default behavior is to dynamically offset stroked groups such that 1 pixel stroke widths
     * align with the pixel grid.
     */
    @JsonProperty("strokeOffset")
    public CornerRadius getStrokeOffset() { return strokeOffset; }
    @JsonProperty("strokeOffset")
    public void setStrokeOffset(CornerRadius value) { this.strokeOffset = value; }

    /**
     * The stroke opacity (value between [0,1]).
     *
     * __Default value:__ `1`
     */
    @JsonProperty("strokeOpacity")
    public Opacity getStrokeOpacity() { return strokeOpacity; }
    @JsonProperty("strokeOpacity")
    public void setStrokeOpacity(Opacity value) { this.strokeOpacity = value; }

    /**
     * The stroke width, in pixels.
     */
    @JsonProperty("strokeWidth")
    public FontSize getStrokeWidth() { return strokeWidth; }
    @JsonProperty("strokeWidth")
    public void setStrokeWidth(FontSize value) { this.strokeWidth = value; }

    /**
     * Depending on the interpolation type, sets the tension parameter (for line and area marks).
     */
    @JsonProperty("tension")
    public CornerRadius getTension() { return tension; }
    @JsonProperty("tension")
    public void setTension(CornerRadius value) { this.tension = value; }

    /**
     * Text-Specific Config
     *
     * Placeholder text if the `text` channel is not specified
     */
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
    public Angle getTheta() { return theta; }
    @JsonProperty("theta")
    public void setTheta(Angle value) { this.theta = value; }

    /**
     * The end angle of arc marks in radians. A value of 0 indicates up or “north”, increasing
     * values proceed clockwise.
     */
    @JsonProperty("theta2")
    public CornerRadius getTheta2() { return theta2; }
    @JsonProperty("theta2")
    public void setTheta2(CornerRadius value) { this.theta2 = value; }

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
    public StyleTooltip getTooltip() { return tooltip; }
    @JsonProperty("tooltip")
    public void setTooltip(StyleTooltip value) { this.tooltip = value; }

    /**
     * The URL of the image file for image marks.
     */
    @JsonProperty("url")
    public Background getURL() { return url; }
    @JsonProperty("url")
    public void setURL(Background value) { this.url = value; }

    /**
     * Width of the marks.
     */
    @JsonProperty("width")
    public CornerRadius getWidth() { return width; }
    @JsonProperty("width")
    public void setWidth(CornerRadius value) { this.width = value; }

    /**
     * X coordinates of the marks, or width of horizontal `"bar"` and `"area"` without specified
     * `x2` or `width`.
     *
     * The `value` of this channel can be a number or a string `"width"` for the width of the
     * plot.
     */
    @JsonProperty("x")
    public Coordinate getCoordinate() { return coordinate; }
    @JsonProperty("x")
    public void setCoordinate(Coordinate value) { this.coordinate = value; }

    /**
     * X2 coordinates for ranged `"area"`, `"bar"`, `"rect"`, and  `"rule"`.
     *
     * The `value` of this channel can be a number or a string `"width"` for the width of the
     * plot.
     */
    @JsonProperty("x2")
    public Coordinate getCoordinate2() { return coordinate2; }
    @JsonProperty("x2")
    public void setCoordinate2(Coordinate value) { this.coordinate2 = value; }

    /**
     * Y coordinates of the marks, or height of vertical `"bar"` and `"area"` without specified
     * `y2` or `height`.
     *
     * The `value` of this channel can be a number or a string `"height"` for the height of the
     * plot.
     */
    @JsonProperty("y")
    public Coordinate getY() { return y; }
    @JsonProperty("y")
    public void setY(Coordinate value) { this.y = value; }

    /**
     * Y2 coordinates for ranged `"area"`, `"bar"`, `"rect"`, and  `"rule"`.
     *
     * The `value` of this channel can be a number or a string `"height"` for the height of the
     * plot.
     */
    @JsonProperty("y2")
    public Coordinate getY2() { return y2; }
    @JsonProperty("y2")
    public void setY2(Coordinate value) { this.y2 = value; }

    /**
     * A flag for overlaying line on top of area marks, or an object defining the properties of
     * the overlayed lines.
     *
     * - If this value is an empty object (`{}`) or `true`, lines with default properties will
     * be used.
     *
     * - If this value is `false`, no lines would be automatically added to area marks.
     *
     * __Default value:__ `false`.
     *
     * Line-Specific Config
     */
    @JsonProperty("line")
    public Line getLine() { return line; }
    @JsonProperty("line")
    public void setLine(Line value) { this.line = value; }

    /**
     * A flag for overlaying points on top of line or area marks, or an object defining the
     * properties of the overlayed points.
     *
     * - If this property is `"transparent"`, transparent points will be used (for enhancing
     * tooltips and selections).
     *
     * - If this property is an empty object (`{}`) or `true`, filled points with default
     * properties will be used.
     *
     * - If this property is `false`, no points would be automatically added to line or area
     * marks.
     *
     * __Default value:__ `false`.
     *
     * Point-Specific Config
     */
    @JsonProperty("point")
    public Point getPoint() { return point; }
    @JsonProperty("point")
    public void setPoint(Point value) { this.point = value; }

    /**
     * - For vertical bars, top-left and top-right corner radius. - For horizontal bars,
     * top-right and bottom-right corner radius.
     */
    @JsonProperty("cornerRadiusEnd")
    public CornerRadius getCornerRadiusEnd() { return cornerRadiusEnd; }
    @JsonProperty("cornerRadiusEnd")
    public void setCornerRadiusEnd(CornerRadius value) { this.cornerRadiusEnd = value; }

    /**
     * The width of the ticks.
     *
     * __Default value:__  3/4 of step (width step for horizontal ticks and height step for
     * vertical ticks).
     */
    @JsonProperty("bandSize")
    public Double getBandSize() { return bandSize; }
    @JsonProperty("bandSize")
    public void setBandSize(Double value) { this.bandSize = value; }

    /**
     * Thickness of the tick mark.
     *
     * __Default value:__  `1`
     */
    @JsonProperty("thickness")
    public Double getThickness() { return thickness; }
    @JsonProperty("thickness")
    public void setThickness(Double value) { this.thickness = value; }

    @JsonProperty("bandPosition")
    public CornerRadius getBandPosition() { return bandPosition; }
    @JsonProperty("bandPosition")
    public void setBandPosition(CornerRadius value) { this.bandPosition = value; }

    @JsonProperty("domain")
    public Aria getDomain() { return domain; }
    @JsonProperty("domain")
    public void setDomain(Aria value) { this.domain = value; }

    @JsonProperty("domainCap")
    public Cap getDomainCap() { return domainCap; }
    @JsonProperty("domainCap")
    public void setDomainCap(Cap value) { this.domainCap = value; }

    @JsonProperty("domainColor")
    public Background getDomainColor() { return domainColor; }
    @JsonProperty("domainColor")
    public void setDomainColor(Background value) { this.domainColor = value; }

    @JsonProperty("domainDash")
    public StrokeDashUnion getDomainDash() { return domainDash; }
    @JsonProperty("domainDash")
    public void setDomainDash(StrokeDashUnion value) { this.domainDash = value; }

    @JsonProperty("domainDashOffset")
    public CornerRadius getDomainDashOffset() { return domainDashOffset; }
    @JsonProperty("domainDashOffset")
    public void setDomainDashOffset(CornerRadius value) { this.domainDashOffset = value; }

    @JsonProperty("domainOpacity")
    public CornerRadius getDomainOpacity() { return domainOpacity; }
    @JsonProperty("domainOpacity")
    public void setDomainOpacity(CornerRadius value) { this.domainOpacity = value; }

    @JsonProperty("domainWidth")
    public CornerRadius getDomainWidth() { return domainWidth; }
    @JsonProperty("domainWidth")
    public void setDomainWidth(CornerRadius value) { this.domainWidth = value; }

    /**
     * When used with the default `"number"` and `"time"` format type, the text formatting
     * pattern for labels of guides (axes, legends, headers) and text marks.
     *
     * - If the format type is `"number"` (e.g., for quantitative fields), this is D3's [number
     * format pattern](https://github.com/d3/d3-format#locale_format). - If the format type is
     * `"time"` (e.g., for temporal fields), this is D3's [time format
     * pattern](https://github.com/d3/d3-time-format#locale_format).
     *
     * See the [format documentation](https://vega.github.io/vega-lite/docs/format.html) for
     * more examples.
     *
     * When used with a [custom
     * `formatType`](https://vega.github.io/vega-lite/docs/config.html#custom-format-type), this
     * value will be passed as `format` alongside `datum.value` to the registered function.
     *
     * __Default value:__  Derived from
     * [numberFormat](https://vega.github.io/vega-lite/docs/config.html#format) config for
     * number format and from
     * [timeFormat](https://vega.github.io/vega-lite/docs/config.html#format) config for time
     * format.
     */
    @JsonProperty("format")
    public Format getFormat() { return format; }
    @JsonProperty("format")
    public void setFormat(Format value) { this.format = value; }

    /**
     * The format type for labels. One of `"number"`, `"time"`, or a [registered custom format
     * type](https://vega.github.io/vega-lite/docs/config.html#custom-format-type).
     *
     * __Default value:__ - `"time"` for temporal fields and ordinal and nominal fields with
     * `timeUnit`. - `"number"` for quantitative fields as well as ordinal and nominal fields
     * without `timeUnit`.
     */
    @JsonProperty("formatType")
    public String getFormatType() { return formatType; }
    @JsonProperty("formatType")
    public void setFormatType(String value) { this.formatType = value; }

    /**
     * A boolean flag indicating if grid lines should be included as part of the axis
     *
     * __Default value:__ `true` for [continuous
     * scales](https://vega.github.io/vega-lite/docs/scale.html#continuous) that are not binned;
     * otherwise, `false`.
     */
    @JsonProperty("grid")
    public Boolean getGrid() { return grid; }
    @JsonProperty("grid")
    public void setGrid(Boolean value) { this.grid = value; }

    @JsonProperty("gridCap")
    public Cap getGridCap() { return gridCap; }
    @JsonProperty("gridCap")
    public void setGridCap(Cap value) { this.gridCap = value; }

    @JsonProperty("gridColor")
    public GridColorUnion getGridColor() { return gridColor; }
    @JsonProperty("gridColor")
    public void setGridColor(GridColorUnion value) { this.gridColor = value; }

    @JsonProperty("gridDash")
    public AxisGridDash getGridDash() { return gridDash; }
    @JsonProperty("gridDash")
    public void setGridDash(AxisGridDash value) { this.gridDash = value; }

    @JsonProperty("gridDashOffset")
    public GridDashOffsetUnion getGridDashOffset() { return gridDashOffset; }
    @JsonProperty("gridDashOffset")
    public void setGridDashOffset(GridDashOffsetUnion value) { this.gridDashOffset = value; }

    @JsonProperty("gridOpacity")
    public GridOpacityUnion getGridOpacity() { return gridOpacity; }
    @JsonProperty("gridOpacity")
    public void setGridOpacity(GridOpacityUnion value) { this.gridOpacity = value; }

    @JsonProperty("gridWidth")
    public GridWidthUnion getGridWidth() { return gridWidth; }
    @JsonProperty("gridWidth")
    public void setGridWidth(GridWidthUnion value) { this.gridWidth = value; }

    @JsonProperty("labelAlign")
    public ConditionalAxisPropertyAlignNull getLabelAlign() { return labelAlign; }
    @JsonProperty("labelAlign")
    public void setLabelAlign(ConditionalAxisPropertyAlignNull value) { this.labelAlign = value; }

    @JsonProperty("labelAngle")
    public LabelAngle getLabelAngle() { return labelAngle; }
    @JsonProperty("labelAngle")
    public void setLabelAngle(LabelAngle value) { this.labelAngle = value; }

    @JsonProperty("labelBaseline")
    public TextBaseline getLabelBaseline() { return labelBaseline; }
    @JsonProperty("labelBaseline")
    public void setLabelBaseline(TextBaseline value) { this.labelBaseline = value; }

    @JsonProperty("labelBound")
    public Label getLabelBound() { return labelBound; }
    @JsonProperty("labelBound")
    public void setLabelBound(Label value) { this.labelBound = value; }

    @JsonProperty("labelColor")
    public GridColorUnion getLabelColor() { return labelColor; }
    @JsonProperty("labelColor")
    public void setLabelColor(GridColorUnion value) { this.labelColor = value; }

    /**
     * [Vega expression](https://vega.github.io/vega/docs/expressions/) for customizing labels.
     *
     * __Note:__ The label text and value can be assessed via the `label` and `value` properties
     * of the axis's backing `datum` object.
     */
    @JsonProperty("labelExpr")
    public String getLabelExpr() { return labelExpr; }
    @JsonProperty("labelExpr")
    public void setLabelExpr(String value) { this.labelExpr = value; }

    /**
     * Indicates if the first and last axis labels should be aligned flush with the scale range.
     * Flush alignment for a horizontal axis will left-align the first label and right-align the
     * last label. For vertical axes, bottom and top text baselines are applied instead. If this
     * property is a number, it also indicates the number of pixels by which to offset the first
     * and last labels; for example, a value of 2 will flush-align the first and last labels and
     * also push them 2 pixels outward from the center of the axis. The additional adjustment
     * can sometimes help the labels better visually group with corresponding axis ticks.
     *
     * __Default value:__ `true` for axis of a continuous x-scale. Otherwise, `false`.
     */
    @JsonProperty("labelFlush")
    public LabelFlush getLabelFlush() { return labelFlush; }
    @JsonProperty("labelFlush")
    public void setLabelFlush(LabelFlush value) { this.labelFlush = value; }

    @JsonProperty("labelFlushOffset")
    public CornerRadius getLabelFlushOffset() { return labelFlushOffset; }
    @JsonProperty("labelFlushOffset")
    public void setLabelFlushOffset(CornerRadius value) { this.labelFlushOffset = value; }

    @JsonProperty("labelFont")
    public ConditionalAxisPropertyStringNull getLabelFont() { return labelFont; }
    @JsonProperty("labelFont")
    public void setLabelFont(ConditionalAxisPropertyStringNull value) { this.labelFont = value; }

    @JsonProperty("labelFontSize")
    public GridWidthUnion getLabelFontSize() { return labelFontSize; }
    @JsonProperty("labelFontSize")
    public void setLabelFontSize(GridWidthUnion value) { this.labelFontSize = value; }

    @JsonProperty("labelFontStyle")
    public ConditionalAxisPropertyFontStyleNull getLabelFontStyle() { return labelFontStyle; }
    @JsonProperty("labelFontStyle")
    public void setLabelFontStyle(ConditionalAxisPropertyFontStyleNull value) { this.labelFontStyle = value; }

    @JsonProperty("labelFontWeight")
    public FontWeight getLabelFontWeight() { return labelFontWeight; }
    @JsonProperty("labelFontWeight")
    public void setLabelFontWeight(FontWeight value) { this.labelFontWeight = value; }

    @JsonProperty("labelLimit")
    public CornerRadius getLabelLimit() { return labelLimit; }
    @JsonProperty("labelLimit")
    public void setLabelLimit(CornerRadius value) { this.labelLimit = value; }

    @JsonProperty("labelLineHeight")
    public CornerRadius getLabelLineHeight() { return labelLineHeight; }
    @JsonProperty("labelLineHeight")
    public void setLabelLineHeight(CornerRadius value) { this.labelLineHeight = value; }

    @JsonProperty("labelOffset")
    public GridDashOffsetUnion getLabelOffset() { return labelOffset; }
    @JsonProperty("labelOffset")
    public void setLabelOffset(GridDashOffsetUnion value) { this.labelOffset = value; }

    @JsonProperty("labelOpacity")
    public GridDashOffsetUnion getLabelOpacity() { return labelOpacity; }
    @JsonProperty("labelOpacity")
    public void setLabelOpacity(GridDashOffsetUnion value) { this.labelOpacity = value; }

    /**
     * The strategy to use for resolving overlap of axis labels. If `false` (the default), no
     * overlap reduction is attempted. If set to `true` or `"parity"`, a strategy of removing
     * every other label is used (this works well for standard linear axes). If set to
     * `"greedy"`, a linear scan of the labels is performed, removing any labels that overlaps
     * with the last visible label (this often works better for log-scaled axes).
     *
     * __Default value:__ `true` for non-nominal fields with non-log scales; `"greedy"` for log
     * scales; otherwise `false`.
     */
    @JsonProperty("labelOverlap")
    public LabelOverlap getLabelOverlap() { return labelOverlap; }
    @JsonProperty("labelOverlap")
    public void setLabelOverlap(LabelOverlap value) { this.labelOverlap = value; }

    @JsonProperty("labelPadding")
    public GridDashOffsetUnion getLabelPadding() { return labelPadding; }
    @JsonProperty("labelPadding")
    public void setLabelPadding(GridDashOffsetUnion value) { this.labelPadding = value; }

    @JsonProperty("labels")
    public Aria getLabels() { return labels; }
    @JsonProperty("labels")
    public void setLabels(Aria value) { this.labels = value; }

    @JsonProperty("labelSeparation")
    public CornerRadius getLabelSeparation() { return labelSeparation; }
    @JsonProperty("labelSeparation")
    public void setLabelSeparation(CornerRadius value) { this.labelSeparation = value; }

    @JsonProperty("maxExtent")
    public CornerRadius getMaxExtent() { return maxExtent; }
    @JsonProperty("maxExtent")
    public void setMaxExtent(CornerRadius value) { this.maxExtent = value; }

    @JsonProperty("minExtent")
    public CornerRadius getMinExtent() { return minExtent; }
    @JsonProperty("minExtent")
    public void setMinExtent(CornerRadius value) { this.minExtent = value; }

    /**
     * The offset, in pixels, by which to displace the axis from the edge of the enclosing group
     * or data rectangle.
     *
     * __Default value:__ derived from the [axis
     * config](https://vega.github.io/vega-lite/docs/config.html#facet-scale-config)'s `offset`
     * (`0` by default)
     */
    @JsonProperty("offset")
    public Double getOffset() { return offset; }
    @JsonProperty("offset")
    public void setOffset(Double value) { this.offset = value; }

    /**
     * The anchor position of the axis in pixels. For x-axes with top or bottom orientation,
     * this sets the axis group x coordinate. For y-axes with left or right orientation, this
     * sets the axis group y coordinate.
     *
     * __Default value__: `0`
     */
    @JsonProperty("position")
    public CornerRadius getPosition() { return position; }
    @JsonProperty("position")
    public void setPosition(CornerRadius value) { this.position = value; }

    /**
     * A string or array of strings indicating the name of custom styles to apply to the axis. A
     * style is a named collection of axis property defined within the [style
     * configuration](https://vega.github.io/vega-lite/docs/mark.html#style-config). If style is
     * an array, later styles will override earlier styles.
     *
     * __Default value:__ (none) __Note:__ Any specified style will augment the default style.
     * For example, an x-axis mark with `"style": "foo"` will use `config.axisX` and
     * `config.style.foo` (the specified style `"foo"` has higher precedence).
     */
    @JsonProperty("style")
    public LegendText getStyle() { return style; }
    @JsonProperty("style")
    public void setStyle(LegendText value) { this.style = value; }

    @JsonProperty("tickBand")
    public TickBandUnion getTickBand() { return tickBand; }
    @JsonProperty("tickBand")
    public void setTickBand(TickBandUnion value) { this.tickBand = value; }

    @JsonProperty("tickCap")
    public Cap getTickCap() { return tickCap; }
    @JsonProperty("tickCap")
    public void setTickCap(Cap value) { this.tickCap = value; }

    @JsonProperty("tickColor")
    public GridColorUnion getTickColor() { return tickColor; }
    @JsonProperty("tickColor")
    public void setTickColor(GridColorUnion value) { this.tickColor = value; }

    /**
     * A desired number of ticks, for axes visualizing quantitative scales. The resulting number
     * may be different so that values are "nice" (multiples of 2, 5, 10) and lie within the
     * underlying scale's range.
     *
     * For scales of type `"time"` or `"utc"`, the tick count can instead be a time interval
     * specifier. Legal string values are `"millisecond"`, `"second"`, `"minute"`, `"hour"`,
     * `"day"`, `"week"`, `"month"`, and `"year"`. Alternatively, an object-valued interval
     * specifier of the form `{"interval": "month", "step": 3}` includes a desired number of
     * interval steps. Here, ticks are generated for each quarter (Jan, Apr, Jul, Oct)
     * boundary.
     *
     * __Default value__: Determine using a formula `ceil(width/40)` for x and `ceil(height/40)`
     * for y.
     */
    @JsonProperty("tickCount")
    public TickCount getTickCount() { return tickCount; }
    @JsonProperty("tickCount")
    public void setTickCount(TickCount value) { this.tickCount = value; }

    @JsonProperty("tickDash")
    public AxisTickDash getTickDash() { return tickDash; }
    @JsonProperty("tickDash")
    public void setTickDash(AxisTickDash value) { this.tickDash = value; }

    @JsonProperty("tickDashOffset")
    public GridDashOffsetUnion getTickDashOffset() { return tickDashOffset; }
    @JsonProperty("tickDashOffset")
    public void setTickDashOffset(GridDashOffsetUnion value) { this.tickDashOffset = value; }

    @JsonProperty("tickExtra")
    public Aria getTickExtra() { return tickExtra; }
    @JsonProperty("tickExtra")
    public void setTickExtra(Aria value) { this.tickExtra = value; }

    /**
     * The minimum desired step between axis ticks, in terms of scale domain values. For
     * example, a value of `1` indicates that ticks should not be less than 1 unit apart. If
     * `tickMinStep` is specified, the `tickCount` value will be adjusted, if necessary, to
     * enforce the minimum step value.
     */
    @JsonProperty("tickMinStep")
    public CornerRadius getTickMinStep() { return tickMinStep; }
    @JsonProperty("tickMinStep")
    public void setTickMinStep(CornerRadius value) { this.tickMinStep = value; }

    @JsonProperty("tickOffset")
    public CornerRadius getTickOffset() { return tickOffset; }
    @JsonProperty("tickOffset")
    public void setTickOffset(CornerRadius value) { this.tickOffset = value; }

    @JsonProperty("tickOpacity")
    public GridDashOffsetUnion getTickOpacity() { return tickOpacity; }
    @JsonProperty("tickOpacity")
    public void setTickOpacity(GridDashOffsetUnion value) { this.tickOpacity = value; }

    @JsonProperty("tickRound")
    public Aria getTickRound() { return tickRound; }
    @JsonProperty("tickRound")
    public void setTickRound(Aria value) { this.tickRound = value; }

    @JsonProperty("ticks")
    public Aria getTicks() { return ticks; }
    @JsonProperty("ticks")
    public void setTicks(Aria value) { this.ticks = value; }

    @JsonProperty("tickSize")
    public GridWidthUnion getTickSize() { return tickSize; }
    @JsonProperty("tickSize")
    public void setTickSize(GridWidthUnion value) { this.tickSize = value; }

    @JsonProperty("tickWidth")
    public GridWidthUnion getTickWidth() { return tickWidth; }
    @JsonProperty("tickWidth")
    public void setTickWidth(GridWidthUnion value) { this.tickWidth = value; }

    /**
     * A title for the field. If `null`, the title will be removed.
     *
     * __Default value:__  derived from the field's name and transformation function
     * (`aggregate`, `bin` and `timeUnit`). If the field has an aggregate function, the function
     * is displayed as part of the title (e.g., `"Sum of Profit"`). If the field is binned or
     * has a time unit applied, the applied function is shown in parentheses (e.g., `"Profit
     * (binned)"`, `"Transaction Date (year-month)"`). Otherwise, the title is simply the field
     * name.
     *
     * __Notes__:
     *
     * 1) You can customize the default field title format by providing the
     * [`fieldTitle`](https://vega.github.io/vega-lite/docs/config.html#top-level-config)
     * property in the [config](https://vega.github.io/vega-lite/docs/config.html) or
     * [`fieldTitle` function via the `compile` function's
     * options](https://vega.github.io/vega-lite/docs/compile.html#field-title).
     *
     * 2) If both field definition's `title` and axis, header, or legend `title` are defined,
     * axis/header/legend title will be used.
     */
    @JsonProperty("title")
    public LegendText getTitle() { return title; }
    @JsonProperty("title")
    public void setTitle(LegendText value) { this.title = value; }

    @JsonProperty("titleAlign")
    public TitleAlignUnion getTitleAlign() { return titleAlign; }
    @JsonProperty("titleAlign")
    public void setTitleAlign(TitleAlignUnion value) { this.titleAlign = value; }

    @JsonProperty("titleAnchor")
    public TitleAnchorUnion getTitleAnchor() { return titleAnchor; }
    @JsonProperty("titleAnchor")
    public void setTitleAnchor(TitleAnchorUnion value) { this.titleAnchor = value; }

    @JsonProperty("titleAngle")
    public CornerRadius getTitleAngle() { return titleAngle; }
    @JsonProperty("titleAngle")
    public void setTitleAngle(CornerRadius value) { this.titleAngle = value; }

    @JsonProperty("titleBaseline")
    public Background getTitleBaseline() { return titleBaseline; }
    @JsonProperty("titleBaseline")
    public void setTitleBaseline(Background value) { this.titleBaseline = value; }

    @JsonProperty("titleColor")
    public Background getTitleColor() { return titleColor; }
    @JsonProperty("titleColor")
    public void setTitleColor(Background value) { this.titleColor = value; }

    @JsonProperty("titleFont")
    public Background getTitleFont() { return titleFont; }
    @JsonProperty("titleFont")
    public void setTitleFont(Background value) { this.titleFont = value; }

    @JsonProperty("titleFontSize")
    public FontSize getTitleFontSize() { return titleFontSize; }
    @JsonProperty("titleFontSize")
    public void setTitleFontSize(FontSize value) { this.titleFontSize = value; }

    @JsonProperty("titleFontStyle")
    public Background getTitleFontStyle() { return titleFontStyle; }
    @JsonProperty("titleFontStyle")
    public void setTitleFontStyle(Background value) { this.titleFontStyle = value; }

    @JsonProperty("titleFontWeight")
    public FontWeightUnion getTitleFontWeight() { return titleFontWeight; }
    @JsonProperty("titleFontWeight")
    public void setTitleFontWeight(FontWeightUnion value) { this.titleFontWeight = value; }

    @JsonProperty("titleLimit")
    public FontSize getTitleLimit() { return titleLimit; }
    @JsonProperty("titleLimit")
    public void setTitleLimit(FontSize value) { this.titleLimit = value; }

    @JsonProperty("titleLineHeight")
    public CornerRadius getTitleLineHeight() { return titleLineHeight; }
    @JsonProperty("titleLineHeight")
    public void setTitleLineHeight(CornerRadius value) { this.titleLineHeight = value; }

    @JsonProperty("titleOpacity")
    public CornerRadius getTitleOpacity() { return titleOpacity; }
    @JsonProperty("titleOpacity")
    public void setTitleOpacity(CornerRadius value) { this.titleOpacity = value; }

    @JsonProperty("titlePadding")
    public CornerRadius getTitlePadding() { return titlePadding; }
    @JsonProperty("titlePadding")
    public void setTitlePadding(CornerRadius value) { this.titlePadding = value; }

    @JsonProperty("titleX")
    public CornerRadius getTitleX() { return titleX; }
    @JsonProperty("titleX")
    public void setTitleX(CornerRadius value) { this.titleX = value; }

    @JsonProperty("titleY")
    public CornerRadius getTitleY() { return titleY; }
    @JsonProperty("titleY")
    public void setTitleY(CornerRadius value) { this.titleY = value; }

    @JsonProperty("translate")
    public CornerRadius getTranslate() { return translate; }
    @JsonProperty("translate")
    public void setTranslate(CornerRadius value) { this.translate = value; }

    /**
     * Explicitly set the visible axis tick values.
     */
    @JsonProperty("values")
    public Values getValues() { return values; }
    @JsonProperty("values")
    public void setValues(Values value) { this.values = value; }

    /**
     * A non-negative integer indicating the z-index of the axis. If zindex is 0, axes should be
     * drawn behind all chart elements. To put them in front, set `zindex` to `1` or more.
     *
     * __Default value:__ `0` (behind the marks).
     */
    @JsonProperty("zindex")
    public Double getZindex() { return zindex; }
    @JsonProperty("zindex")
    public void setZindex(Double value) { this.zindex = value; }
}
