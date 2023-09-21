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

public class Def {
    private Box box;
    private Boolean clip;
    private MarkColorConfig color;
    private Extent extent;
    private Box median;
    private CornerRadius opacity;
    private Orientation orient;
    private Box outliers;
    private Box rule;
    private CornerRadius size;
    private Box ticks;
    private String type;
    private Double thickness;
    private Box band;
    private Box borders;
    private MarkConfigExprOrSignalRefInterpolate interpolate;
    private Opacity tension;
    private TitleAlignUnion align;
    private Angle angle;
    private Aria aria;
    private Background ariaRole;
    private Background ariaRoleDescription;
    private Aria aspect;
    private Double bandSize;
    private Background baseline;
    private Double binSpacing;
    private BlendUnion blend;
    private Double continuousBandSize;
    private CornerRadius cornerRadius;
    private CornerRadius cornerRadiusBottomLeft;
    private CornerRadius cornerRadiusBottomRight;
    private CornerRadius cornerRadiusEnd;
    private CornerRadius cornerRadiusTopLeft;
    private CornerRadius cornerRadiusTopRight;
    private CursorUnion cursor;
    private Background description;
    private Dir dir;
    private Double discreteBandSize;
    private CornerRadius dx;
    private CornerRadius dy;
    private Background ellipsis;
    private MarkFill fill;
    private Boolean filled;
    private Opacity fillOpacity;
    private Background font;
    private FontSize fontSize;
    private Background fontStyle;
    private FontWeightUnion fontWeight;
    private CornerRadius height;
    private Background href;
    private CornerRadius innerRadius;
    private Invalid invalid;
    private CornerRadius limit;
    private Line line;
    private Background lineBreak;
    private CornerRadius lineHeight;
    private Boolean order;
    private CornerRadius outerRadius;
    private CornerRadius padAngle;
    private Point point;
    private CornerRadius radius;
    private CornerRadius radius2;
    private CornerRadius radius2Offset;
    private CornerRadius radiusOffset;
    private Background shape;
    private Aria smooth;
    private MarkStroke stroke;
    private Cap strokeCap;
    private StrokeDashUnion strokeDash;
    private CornerRadius strokeDashOffset;
    private StrokeJoinUnion strokeJoin;
    private CornerRadius strokeMiterLimit;
    private CornerRadius strokeOffset;
    private Opacity strokeOpacity;
    private FontSize strokeWidth;
    private LegendText style;
    private TextDef text;
    private CornerRadius theta;
    private CornerRadius theta2;
    private CornerRadius theta2Offset;
    private CornerRadius thetaOffset;
    private Double timeUnitBand;
    private Double timeUnitBandPosition;
    private Tooltip tooltip;
    private Background url;
    private CornerRadius width;
    private Coordinate coordinate;
    private Coordinate coordinate2;
    private CornerRadius x2Offset;
    private CornerRadius xOffset;
    private Coordinate y;
    private Coordinate y2;
    private CornerRadius y2Offset;
    private CornerRadius yOffset;

    @JsonProperty("box")
    public Box getBox() { return box; }
    @JsonProperty("box")
    public void setBox(Box value) { this.box = value; }

    /**
     * Whether a composite mark be clipped to the enclosing group’s width and height.
     *
     * Whether a mark be clipped to the enclosing group’s width and height.
     */
    @JsonProperty("clip")
    public Boolean getClip() { return clip; }
    @JsonProperty("clip")
    public void setClip(Boolean value) { this.clip = value; }

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
    public MarkColorConfig getColor() { return color; }
    @JsonProperty("color")
    public void setColor(MarkColorConfig value) { this.color = value; }

    /**
     * The extent of the whiskers. Available options include: - `"min-max"`: min and max are the
     * lower and upper whiskers respectively. - A number representing multiple of the
     * interquartile range. This number will be multiplied by the IQR to determine whisker
     * boundary, which spans from the smallest data to the largest data within the range _[Q1 -
     * k * IQR, Q3 + k * IQR]_ where _Q1_ and _Q3_ are the first and third quartiles while _IQR_
     * is the interquartile range (_Q3-Q1_).
     *
     * __Default value:__ `1.5`.
     *
     * The extent of the rule. Available options include: - `"ci"`: Extend the rule to the
     * confidence interval of the mean. - `"stderr"`: The size of rule are set to the value of
     * standard error, extending from the mean. - `"stdev"`: The size of rule are set to the
     * value of standard deviation, extending from the mean. - `"iqr"`: Extend the rule to the
     * q1 and q3.
     *
     * __Default value:__ `"stderr"`.
     *
     * The extent of the band. Available options include: - `"ci"`: Extend the band to the
     * confidence interval of the mean. - `"stderr"`: The size of band are set to the value of
     * standard error, extending from the mean. - `"stdev"`: The size of band are set to the
     * value of standard deviation, extending from the mean. - `"iqr"`: Extend the band to the
     * q1 and q3.
     *
     * __Default value:__ `"stderr"`.
     */
    @JsonProperty("extent")
    public Extent getExtent() { return extent; }
    @JsonProperty("extent")
    public void setExtent(Extent value) { this.extent = value; }

    @JsonProperty("median")
    public Box getMedian() { return median; }
    @JsonProperty("median")
    public void setMedian(Box value) { this.median = value; }

    /**
     * The opacity (value between [0,1]) of the mark.
     *
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
     * Orientation of the box plot. This is normally automatically determined based on types of
     * fields on x and y channels. However, an explicit `orient` be specified when the
     * orientation is ambiguous.
     *
     * __Default value:__ `"vertical"`.
     *
     * Orientation of the error bar. This is normally automatically determined, but can be
     * specified when the orientation is ambiguous and cannot be automatically determined.
     *
     * Orientation of the error band. This is normally automatically determined, but can be
     * specified when the orientation is ambiguous and cannot be automatically determined.
     *
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

    @JsonProperty("outliers")
    public Box getOutliers() { return outliers; }
    @JsonProperty("outliers")
    public void setOutliers(Box value) { this.outliers = value; }

    @JsonProperty("rule")
    public Box getRule() { return rule; }
    @JsonProperty("rule")
    public void setRule(Box value) { this.rule = value; }

    /**
     * Size of the box and median tick of a box plot
     *
     * Size of the ticks of an error bar
     *
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
    public CornerRadius getSize() { return size; }
    @JsonProperty("size")
    public void setSize(CornerRadius value) { this.size = value; }

    @JsonProperty("ticks")
    public Box getTicks() { return ticks; }
    @JsonProperty("ticks")
    public void setTicks(Box value) { this.ticks = value; }

    /**
     * The mark type. This could a primitive mark type (one of `"bar"`, `"circle"`, `"square"`,
     * `"tick"`, `"line"`, `"area"`, `"point"`, `"geoshape"`, `"rule"`, and `"text"`) or a
     * composite mark type (`"boxplot"`, `"errorband"`, `"errorbar"`).
     */
    @JsonProperty("type")
    public String getType() { return type; }
    @JsonProperty("type")
    public void setType(String value) { this.type = value; }

    /**
     * Thickness of the ticks and the bar of an error bar
     *
     * Thickness of the tick mark.
     *
     * __Default value:__  `1`
     */
    @JsonProperty("thickness")
    public Double getThickness() { return thickness; }
    @JsonProperty("thickness")
    public void setThickness(Double value) { this.thickness = value; }

    @JsonProperty("band")
    public Box getBand() { return band; }
    @JsonProperty("band")
    public void setBand(Box value) { this.band = value; }

    @JsonProperty("borders")
    public Box getBorders() { return borders; }
    @JsonProperty("borders")
    public void setBorders(Box value) { this.borders = value; }

    /**
     * The line interpolation method for the error band. One of the following: - `"linear"`:
     * piecewise linear segments, as in a polyline. - `"linear-closed"`: close the linear
     * segments to form a polygon. - `"step"`: a piecewise constant function (a step function)
     * consisting of alternating horizontal and vertical lines. The y-value changes at the
     * midpoint of each pair of adjacent x-values. - `"step-before"`: a piecewise constant
     * function (a step function) consisting of alternating horizontal and vertical lines. The
     * y-value changes before the x-value. - `"step-after"`: a piecewise constant function (a
     * step function) consisting of alternating horizontal and vertical lines. The y-value
     * changes after the x-value. - `"basis"`: a B-spline, with control point duplication on the
     * ends. - `"basis-open"`: an open B-spline; may not intersect the start or end. -
     * `"basis-closed"`: a closed B-spline, as in a loop. - `"cardinal"`: a Cardinal spline,
     * with control point duplication on the ends. - `"cardinal-open"`: an open Cardinal spline;
     * may not intersect the start or end, but will intersect other control points. -
     * `"cardinal-closed"`: a closed Cardinal spline, as in a loop. - `"bundle"`: equivalent to
     * basis, except the tension parameter is used to straighten the spline. - `"monotone"`:
     * cubic interpolation that preserves monotonicity in y.
     */
    @JsonProperty("interpolate")
    public MarkConfigExprOrSignalRefInterpolate getInterpolate() { return interpolate; }
    @JsonProperty("interpolate")
    public void setInterpolate(MarkConfigExprOrSignalRefInterpolate value) { this.interpolate = value; }

    /**
     * The tension parameter for the interpolation type of the error band.
     */
    @JsonProperty("tension")
    public Opacity getTension() { return tension; }
    @JsonProperty("tension")
    public void setTension(Opacity value) { this.tension = value; }

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
    public Background getAriaRole() { return ariaRole; }
    @JsonProperty("ariaRole")
    public void setAriaRole(Background value) { this.ariaRole = value; }

    @JsonProperty("ariaRoleDescription")
    public Background getAriaRoleDescription() { return ariaRoleDescription; }
    @JsonProperty("ariaRoleDescription")
    public void setAriaRoleDescription(Background value) { this.ariaRoleDescription = value; }

    @JsonProperty("aspect")
    public Aria getAspect() { return aspect; }
    @JsonProperty("aspect")
    public void setAspect(Aria value) { this.aspect = value; }

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

    @JsonProperty("blend")
    public BlendUnion getBlend() { return blend; }
    @JsonProperty("blend")
    public void setBlend(BlendUnion value) { this.blend = value; }

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
    public CornerRadius getCornerRadius() { return cornerRadius; }
    @JsonProperty("cornerRadius")
    public void setCornerRadius(CornerRadius value) { this.cornerRadius = value; }

    @JsonProperty("cornerRadiusBottomLeft")
    public CornerRadius getCornerRadiusBottomLeft() { return cornerRadiusBottomLeft; }
    @JsonProperty("cornerRadiusBottomLeft")
    public void setCornerRadiusBottomLeft(CornerRadius value) { this.cornerRadiusBottomLeft = value; }

    @JsonProperty("cornerRadiusBottomRight")
    public CornerRadius getCornerRadiusBottomRight() { return cornerRadiusBottomRight; }
    @JsonProperty("cornerRadiusBottomRight")
    public void setCornerRadiusBottomRight(CornerRadius value) { this.cornerRadiusBottomRight = value; }

    /**
     * - For vertical bars, top-left and top-right corner radius. - For horizontal bars,
     * top-right and bottom-right corner radius.
     */
    @JsonProperty("cornerRadiusEnd")
    public CornerRadius getCornerRadiusEnd() { return cornerRadiusEnd; }
    @JsonProperty("cornerRadiusEnd")
    public void setCornerRadiusEnd(CornerRadius value) { this.cornerRadiusEnd = value; }

    @JsonProperty("cornerRadiusTopLeft")
    public CornerRadius getCornerRadiusTopLeft() { return cornerRadiusTopLeft; }
    @JsonProperty("cornerRadiusTopLeft")
    public void setCornerRadiusTopLeft(CornerRadius value) { this.cornerRadiusTopLeft = value; }

    @JsonProperty("cornerRadiusTopRight")
    public CornerRadius getCornerRadiusTopRight() { return cornerRadiusTopRight; }
    @JsonProperty("cornerRadiusTopRight")
    public void setCornerRadiusTopRight(CornerRadius value) { this.cornerRadiusTopRight = value; }

    @JsonProperty("cursor")
    public CursorUnion getCursor() { return cursor; }
    @JsonProperty("cursor")
    public void setCursor(CursorUnion value) { this.cursor = value; }

    @JsonProperty("description")
    public Background getDescription() { return description; }
    @JsonProperty("description")
    public void setDescription(Background value) { this.description = value; }

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
    public CornerRadius getDx() { return dx; }
    @JsonProperty("dx")
    public void setDx(CornerRadius value) { this.dx = value; }

    @JsonProperty("dy")
    public CornerRadius getDy() { return dy; }
    @JsonProperty("dy")
    public void setDy(CornerRadius value) { this.dy = value; }

    @JsonProperty("ellipsis")
    public Background getEllipsis() { return ellipsis; }
    @JsonProperty("ellipsis")
    public void setEllipsis(Background value) { this.ellipsis = value; }

    /**
     * Default fill color. This property has higher precedence than `config.color`. Set to
     * `null` to remove fill.
     *
     * __Default value:__ (None)
     */
    @JsonProperty("fill")
    public MarkFill getFill() { return fill; }
    @JsonProperty("fill")
    public void setFill(MarkFill value) { this.fill = value; }

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
    public Background getFont() { return font; }
    @JsonProperty("font")
    public void setFont(Background value) { this.font = value; }

    @JsonProperty("fontSize")
    public FontSize getFontSize() { return fontSize; }
    @JsonProperty("fontSize")
    public void setFontSize(FontSize value) { this.fontSize = value; }

    @JsonProperty("fontStyle")
    public Background getFontStyle() { return fontStyle; }
    @JsonProperty("fontStyle")
    public void setFontStyle(Background value) { this.fontStyle = value; }

    @JsonProperty("fontWeight")
    public FontWeightUnion getFontWeight() { return fontWeight; }
    @JsonProperty("fontWeight")
    public void setFontWeight(FontWeightUnion value) { this.fontWeight = value; }

    @JsonProperty("height")
    public CornerRadius getHeight() { return height; }
    @JsonProperty("height")
    public void setHeight(CornerRadius value) { this.height = value; }

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
    public CornerRadius getLimit() { return limit; }
    @JsonProperty("limit")
    public void setLimit(CornerRadius value) { this.limit = value; }

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
     */
    @JsonProperty("line")
    public Line getLine() { return line; }
    @JsonProperty("line")
    public void setLine(Line value) { this.line = value; }

    @JsonProperty("lineBreak")
    public Background getLineBreak() { return lineBreak; }
    @JsonProperty("lineBreak")
    public void setLineBreak(Background value) { this.lineBreak = value; }

    @JsonProperty("lineHeight")
    public CornerRadius getLineHeight() { return lineHeight; }
    @JsonProperty("lineHeight")
    public void setLineHeight(CornerRadius value) { this.lineHeight = value; }

    /**
     * For line and trail marks, this `order` property can be set to `null` or `false` to make
     * the lines use the original order in the data sources.
     */
    @JsonProperty("order")
    public Boolean getOrder() { return order; }
    @JsonProperty("order")
    public void setOrder(Boolean value) { this.order = value; }

    /**
     * The outer radius in pixels of arc marks. `outerRadius` is an alias for `radius`.
     */
    @JsonProperty("outerRadius")
    public CornerRadius getOuterRadius() { return outerRadius; }
    @JsonProperty("outerRadius")
    public void setOuterRadius(CornerRadius value) { this.outerRadius = value; }

    @JsonProperty("padAngle")
    public CornerRadius getPadAngle() { return padAngle; }
    @JsonProperty("padAngle")
    public void setPadAngle(CornerRadius value) { this.padAngle = value; }

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
     */
    @JsonProperty("point")
    public Point getPoint() { return point; }
    @JsonProperty("point")
    public void setPoint(Point value) { this.point = value; }

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
     * Offset for radius2.
     */
    @JsonProperty("radius2Offset")
    public CornerRadius getRadius2Offset() { return radius2Offset; }
    @JsonProperty("radius2Offset")
    public void setRadius2Offset(CornerRadius value) { this.radius2Offset = value; }

    /**
     * Offset for radius.
     */
    @JsonProperty("radiusOffset")
    public CornerRadius getRadiusOffset() { return radiusOffset; }
    @JsonProperty("radiusOffset")
    public void setRadiusOffset(CornerRadius value) { this.radiusOffset = value; }

    @JsonProperty("shape")
    public Background getShape() { return shape; }
    @JsonProperty("shape")
    public void setShape(Background value) { this.shape = value; }

    @JsonProperty("smooth")
    public Aria getSmooth() { return smooth; }
    @JsonProperty("smooth")
    public void setSmooth(Aria value) { this.smooth = value; }

    /**
     * Default stroke color. This property has higher precedence than `config.color`. Set to
     * `null` to remove stroke.
     *
     * __Default value:__ (None)
     */
    @JsonProperty("stroke")
    public MarkStroke getStroke() { return stroke; }
    @JsonProperty("stroke")
    public void setStroke(MarkStroke value) { this.stroke = value; }

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

    @JsonProperty("strokeOffset")
    public CornerRadius getStrokeOffset() { return strokeOffset; }
    @JsonProperty("strokeOffset")
    public void setStrokeOffset(CornerRadius value) { this.strokeOffset = value; }

    @JsonProperty("strokeOpacity")
    public Opacity getStrokeOpacity() { return strokeOpacity; }
    @JsonProperty("strokeOpacity")
    public void setStrokeOpacity(Opacity value) { this.strokeOpacity = value; }

    @JsonProperty("strokeWidth")
    public FontSize getStrokeWidth() { return strokeWidth; }
    @JsonProperty("strokeWidth")
    public void setStrokeWidth(FontSize value) { this.strokeWidth = value; }

    /**
     * A string or array of strings indicating the name of custom styles to apply to the mark. A
     * style is a named collection of mark property defaults defined within the [style
     * configuration](https://vega.github.io/vega-lite/docs/mark.html#style-config). If style is
     * an array, later styles will override earlier styles. Any [mark
     * properties](https://vega.github.io/vega-lite/docs/encoding.html#mark-prop) explicitly
     * defined within the `encoding` will override a style default.
     *
     * __Default value:__ The mark's name. For example, a bar mark will have style `"bar"` by
     * default. __Note:__ Any specified style will augment the default style. For example, a bar
     * mark with `"style": "foo"` will receive from `config.style.bar` and `config.style.foo`
     * (the specified style `"foo"` has higher precedence).
     */
    @JsonProperty("style")
    public LegendText getStyle() { return style; }
    @JsonProperty("style")
    public void setStyle(LegendText value) { this.style = value; }

    @JsonProperty("text")
    public TextDef getText() { return text; }
    @JsonProperty("text")
    public void setText(TextDef value) { this.text = value; }

    /**
     * - For arc marks, the arc length in radians if theta2 is not specified, otherwise the
     * start arc angle. (A value of 0 indicates up or “north”, increasing values proceed
     * clockwise.)
     *
     * - For text marks, polar coordinate angle in radians.
     */
    @JsonProperty("theta")
    public CornerRadius getTheta() { return theta; }
    @JsonProperty("theta")
    public void setTheta(CornerRadius value) { this.theta = value; }

    /**
     * The end angle of arc marks in radians. A value of 0 indicates up or “north”, increasing
     * values proceed clockwise.
     */
    @JsonProperty("theta2")
    public CornerRadius getTheta2() { return theta2; }
    @JsonProperty("theta2")
    public void setTheta2(CornerRadius value) { this.theta2 = value; }

    /**
     * Offset for theta2.
     */
    @JsonProperty("theta2Offset")
    public CornerRadius getTheta2Offset() { return theta2Offset; }
    @JsonProperty("theta2Offset")
    public void setTheta2Offset(CornerRadius value) { this.theta2Offset = value; }

    /**
     * Offset for theta.
     */
    @JsonProperty("thetaOffset")
    public CornerRadius getThetaOffset() { return thetaOffset; }
    @JsonProperty("thetaOffset")
    public void setThetaOffset(CornerRadius value) { this.thetaOffset = value; }

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
    public Tooltip getTooltip() { return tooltip; }
    @JsonProperty("tooltip")
    public void setTooltip(Tooltip value) { this.tooltip = value; }

    @JsonProperty("url")
    public Background getURL() { return url; }
    @JsonProperty("url")
    public void setURL(Background value) { this.url = value; }

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
     * Offset for x2-position.
     */
    @JsonProperty("x2Offset")
    public CornerRadius getX2Offset() { return x2Offset; }
    @JsonProperty("x2Offset")
    public void setX2Offset(CornerRadius value) { this.x2Offset = value; }

    /**
     * Offset for x-position.
     */
    @JsonProperty("xOffset")
    public CornerRadius getXOffset() { return xOffset; }
    @JsonProperty("xOffset")
    public void setXOffset(CornerRadius value) { this.xOffset = value; }

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
     * Offset for y2-position.
     */
    @JsonProperty("y2Offset")
    public CornerRadius getY2Offset() { return y2Offset; }
    @JsonProperty("y2Offset")
    public void setY2Offset(CornerRadius value) { this.y2Offset = value; }

    /**
     * Offset for y-position.
     */
    @JsonProperty("yOffset")
    public CornerRadius getYOffset() { return yOffset; }
    @JsonProperty("yOffset")
    public void setYOffset(CornerRadius value) { this.yOffset = value; }


    //Builder functions

    public Def radius(double value){
        CornerRadius c = new CornerRadius();
        c.value=value;
        setRadius(c);
        return this;
    }

    public Def radius(String expression){
        CornerRadius c = new CornerRadius();
        ExprRef exprRef= new ExprRef();
        exprRef.setExpr(expression);
        c.exprRef=exprRef;
        this.setRadius(c);
        return this;
    }

    public Def radius2(double value){
        CornerRadius c = new CornerRadius();
        c.value=value;
        this.setRadius2(c);
        return this;
    }

    public Def radius2(String expression){
        CornerRadius c = new CornerRadius();
        ExprRef exprRef= new ExprRef();
        exprRef.setExpr(expression);
        c.exprRef=exprRef;
        this.setRadius2(c);
        return this;
    }

    public Def innerRadius(double value){
        CornerRadius c = new CornerRadius();
        c.value=value;
        this.setInnerRadius(c);
        return this;
    }

    public Def innerRadius(String expression){
        CornerRadius c = new CornerRadius();
        ExprRef exprRef= new ExprRef();
        exprRef.setExpr(expression);
        c.exprRef=exprRef;
        this.setInnerRadius(c);
        return this;
    }

    public Def outerRadius(double value){
        CornerRadius c = new CornerRadius();
        c.value=value;
        this.setOuterRadius(c);
        return this;
    }

    public Def outerRadius(String expression){
        CornerRadius c = new CornerRadius();
        ExprRef exprRef= new ExprRef();
        exprRef.setExpr(expression);
        c.exprRef=exprRef;
        this.setOuterRadius(c);
        return this;
    }

    public Def radiusOffset(double value){
        CornerRadius c = new CornerRadius();
        c.value=value;
        this.setRadiusOffset(c);
        return this;
    }

    public Def radiusOffset(String expression){
        CornerRadius c = new CornerRadius();
        ExprRef exprRef= new ExprRef();
        exprRef.setExpr(expression);
        c.exprRef=exprRef;
        this.setRadiusOffset(c);
        return this;
    }

    public Def theta(double value){
        CornerRadius c = new CornerRadius();
        c.value=value;
        this.setTheta(c);
        return this;
    }

    public Def theta2(double value){
        CornerRadius c = new CornerRadius();
        c.value=value;
        this.setTheta2(c);
        return this;
    }

    public Def thetaOffset(double value){
        CornerRadius c = new CornerRadius();
        c.value=value;
        this.setThetaOffset(c);
        return this;
    }

    public Def thetaOffset(String expression){
        this.setThetaOffset(VegaFactory.createCornerExpression(expression));
        return this;
    }

    public Def tooltip(boolean value) {
        Tooltip tooltip1 = new Tooltip();
        tooltip1.boolValue=value;
        this.setTooltip(tooltip1);
        return this;
    }

    public Def stroke(String value){
        MarkStroke markStroke = new MarkStroke();
        markStroke.color=value;
        this.setStroke(markStroke);
        return this;
    }

    public Def strokeWidth(double value){
        FontSize   fontSize = new FontSize();
        fontSize.value = value;
        this.setStrokeWidth(fontSize);
        return this;
    }

    public Def strokeWidth(String expression){
        FontSize   fontSize = new FontSize();
        fontSize.exprRef = VegaFactory.createExpression(expression);
        this.setStrokeWidth(fontSize);
        return this;
    }


    public Def fill(String color) {
        MarkFill markFill =  new MarkFill();
        markFill.color=color;
        this.setFill(markFill);
        return this;
    }

    public Def filled(boolean value) {
        this.setFilled(value);
        return this;
    }

    public Def fillOpacity(double value){
        this.setFillOpacity(VegaFactory.createOpacity(value));
        return this;
    }

    public Def fillOpacity(String expression){
        this.setFillOpacity(VegaFactory.createOpacity(expression));
        return this;
    }

    public Def yOffset(double value){
        this.setYOffset(VegaFactory.createCornerValue(value));
        return  this;
    }

    public Def yOffset(ExprRef expression){
        this.setYOffset(VegaFactory.createCornerExpression(expression));
        return  this;
    }

    public Def xOffset(double value){
        this.setXOffset(VegaFactory.createCornerValue(value));
        return  this;
    }

    public Def xOffset(ExprRef expression){
        this.setXOffset(VegaFactory.createCornerExpression(expression));
        return  this;
    }

    public Def color(String value){
        this.setColor(VegaFactory.createMarkColorConfig(value));
        return this;
    }

}
