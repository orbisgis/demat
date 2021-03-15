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

import com.fasterxml.jackson.annotation.*;

/**
 * A key-value mapping between encoding channels and definition of fields.
 *
 * A shared key-value mapping between encoding channels and definition of fields in the
 * underlying layers.
 */
public class Encoding {
    private AngleClass angle;
    private Color color;
    private RowColumnEncodingFieldDef column;
    private DescriptionClass description;
    private Detail detail;
    private FacetEncodingFieldDef facet;
    private FillClass fill;
    private FillOpacityClass fillOpacity;
    private HrefClass href;
    private KeyClass key;
    private LatitudeClass latitude;
    private Latitude2Class latitude2;
    private LongitudeClass longitude;
    private Longitude2Class longitude2;
    private OpacityClass opacity;
    private Order order;
    private RadiusClass radius;
    private Radius2Class radius2;
    private RowColumnEncodingFieldDef row;
    private MarkPropDefStringNullTypeForShape shape;
    private SizeClass size;
    private StrokeClass stroke;
    private MarkPropDefNumber strokeDash;
    private StrokeOpacityClass strokeOpacity;
    private StrokeWidthClass strokeWidth;
    private TextDef text;
    private ThetaClass theta;
    private Theta2Class theta2;
    private EncodingTooltip tooltip;
    private URLClass url;
    private X x;
    private X2 x2;
    private XError xError;
    private XError2 xError2;
    private Y y;
    private Y2 y2;
    private YError yError;
    private YError2 yError2;

    /**
     * Rotation angle of point and text marks.
     */
    @JsonProperty("angle")
    public AngleClass getAngle() { return angle; }
    @JsonProperty("angle")
    public void setAngle(AngleClass value) { this.angle = value; }

    /**
     * Color of the marks – either fill or stroke color based on  the `filled` property of mark
     * definition. By default, `color` represents fill color for `"area"`, `"bar"`, `"tick"`,
     * `"text"`, `"trail"`, `"circle"`, and `"square"` / stroke color for `"line"` and
     * `"point"`.
     *
     * __Default value:__ If undefined, the default color depends on [mark
     * config](https://vega.github.io/vega-lite/docs/config.html#mark-config)'s `color`
     * property.
     *
     * _Note:_ 1) For fine-grained control over both fill and stroke colors of the marks, please
     * use the `fill` and `stroke` channels. The `fill` or `stroke` encodings have higher
     * precedence than `color`, thus may override the `color` encoding if conflicting encodings
     * are specified. 2) See the scale documentation for more information about customizing
     * [color scheme](https://vega.github.io/vega-lite/docs/scale.html#scheme).
     */
    @JsonProperty("color")
    public Color getColor() { return color; }
    @JsonProperty("color")
    public void setColor(Color value) { this.color = value; }

    /**
     * A field definition for the horizontal facet of trellis plots.
     */
    @JsonProperty("column")
    public RowColumnEncodingFieldDef getColumn() { return column; }
    @JsonProperty("column")
    public void setColumn(RowColumnEncodingFieldDef value) { this.column = value; }

    /**
     * A text description of this mark for ARIA accessibility (SVG output only). For SVG output
     * the `"aria-label"` attribute will be set to this description.
     */
    @JsonProperty("description")
    public DescriptionClass getDescription() { return description; }
    @JsonProperty("description")
    public void setDescription(DescriptionClass value) { this.description = value; }

    /**
     * Additional levels of detail for grouping data in aggregate views and in line, trail, and
     * area marks without mapping data to a specific visual channel.
     */
    @JsonProperty("detail")
    public Detail getDetail() { return detail; }
    @JsonProperty("detail")
    public void setDetail(Detail value) { this.detail = value; }

    /**
     * A field definition for the (flexible) facet of trellis plots.
     *
     * If either `row` or `column` is specified, this channel will be ignored.
     */
    @JsonProperty("facet")
    public FacetEncodingFieldDef getFacet() { return facet; }
    @JsonProperty("facet")
    public void setFacet(FacetEncodingFieldDef value) { this.facet = value; }

    /**
     * Fill color of the marks. __Default value:__ If undefined, the default color depends on
     * [mark config](https://vega.github.io/vega-lite/docs/config.html#mark-config)'s `color`
     * property.
     *
     * _Note:_ The `fill` encoding has higher precedence than `color`, thus may override the
     * `color` encoding if conflicting encodings are specified.
     */
    @JsonProperty("fill")
    public FillClass getFill() { return fill; }
    @JsonProperty("fill")
    public void setFill(FillClass value) { this.fill = value; }

    /**
     * Fill opacity of the marks.
     *
     * __Default value:__ If undefined, the default opacity depends on [mark
     * config](https://vega.github.io/vega-lite/docs/config.html#mark-config)'s `fillOpacity`
     * property.
     */
    @JsonProperty("fillOpacity")
    public FillOpacityClass getFillOpacity() { return fillOpacity; }
    @JsonProperty("fillOpacity")
    public void setFillOpacity(FillOpacityClass value) { this.fillOpacity = value; }

    /**
     * A URL to load upon mouse click.
     */
    @JsonProperty("href")
    public HrefClass getHref() { return href; }
    @JsonProperty("href")
    public void setHref(HrefClass value) { this.href = value; }

    /**
     * A data field to use as a unique key for data binding. When a visualization’s data is
     * updated, the key value will be used to match data elements to existing mark instances.
     * Use a key channel to enable object constancy for transitions over dynamic data.
     */
    @JsonProperty("key")
    public KeyClass getKey() { return key; }
    @JsonProperty("key")
    public void setKey(KeyClass value) { this.key = value; }

    /**
     * Latitude position of geographically projected marks.
     */
    @JsonProperty("latitude")
    public LatitudeClass getLatitude() { return latitude; }
    @JsonProperty("latitude")
    public void setLatitude(LatitudeClass value) { this.latitude = value; }

    /**
     * Latitude-2 position for geographically projected ranged `"area"`, `"bar"`, `"rect"`, and
     * `"rule"`.
     */
    @JsonProperty("latitude2")
    public Latitude2Class getLatitude2() { return latitude2; }
    @JsonProperty("latitude2")
    public void setLatitude2(Latitude2Class value) { this.latitude2 = value; }

    /**
     * Longitude position of geographically projected marks.
     */
    @JsonProperty("longitude")
    public LongitudeClass getLongitude() { return longitude; }
    @JsonProperty("longitude")
    public void setLongitude(LongitudeClass value) { this.longitude = value; }

    /**
     * Longitude-2 position for geographically projected ranged `"area"`, `"bar"`, `"rect"`,
     * and  `"rule"`.
     */
    @JsonProperty("longitude2")
    public Longitude2Class getLongitude2() { return longitude2; }
    @JsonProperty("longitude2")
    public void setLongitude2(Longitude2Class value) { this.longitude2 = value; }

    /**
     * Opacity of the marks.
     *
     * __Default value:__ If undefined, the default opacity depends on [mark
     * config](https://vega.github.io/vega-lite/docs/config.html#mark-config)'s `opacity`
     * property.
     */
    @JsonProperty("opacity")
    public OpacityClass getOpacity() { return opacity; }
    @JsonProperty("opacity")
    public void setOpacity(OpacityClass value) { this.opacity = value; }

    /**
     * Order of the marks. - For stacked marks, this `order` channel encodes [stack
     * order](https://vega.github.io/vega-lite/docs/stack.html#order). - For line and trail
     * marks, this `order` channel encodes order of data points in the lines. This can be useful
     * for creating [a connected
     * scatterplot](https://vega.github.io/vega-lite/examples/connected_scatterplot.html).
     * Setting `order` to `{"value": null}` makes the line marks use the original order in the
     * data sources. - Otherwise, this `order` channel encodes layer order of the marks.
     *
     * __Note__: In aggregate plots, `order` field should be `aggregate`d to avoid creating
     * additional aggregation grouping.
     */
    @JsonProperty("order")
    public Order getOrder() { return order; }
    @JsonProperty("order")
    public void setOrder(Order value) { this.order = value; }

    /**
     * The outer radius in pixels of arc marks.
     */
    @JsonProperty("radius")
    public RadiusClass getRadius() { return radius; }
    @JsonProperty("radius")
    public void setRadius(RadiusClass value) { this.radius = value; }

    /**
     * The inner radius in pixels of arc marks.
     */
    @JsonProperty("radius2")
    public Radius2Class getRadius2() { return radius2; }
    @JsonProperty("radius2")
    public void setRadius2(Radius2Class value) { this.radius2 = value; }

    /**
     * A field definition for the vertical facet of trellis plots.
     */
    @JsonProperty("row")
    public RowColumnEncodingFieldDef getRow() { return row; }
    @JsonProperty("row")
    public void setRow(RowColumnEncodingFieldDef value) { this.row = value; }

    /**
     * Shape of the mark.
     *
     * 1. For `point` marks the supported values include:    - plotting shapes: `"circle"`,
     * `"square"`, `"cross"`, `"diamond"`, `"triangle-up"`, `"triangle-down"`,
     * `"triangle-right"`, or `"triangle-left"`.    - the line symbol `"stroke"`    - centered
     * directional shapes `"arrow"`, `"wedge"`, or `"triangle"`    - a custom [SVG path
     * string](https://developer.mozilla.org/en-US/docs/Web/SVG/Tutorial/Paths) (For correct
     * sizing, custom shape paths should be defined within a square bounding box with
     * coordinates ranging from -1 to 1 along both the x and y dimensions.)
     *
     * 2. For `geoshape` marks it should be a field definition of the geojson data
     *
     * __Default value:__ If undefined, the default shape depends on [mark
     * config](https://vega.github.io/vega-lite/docs/config.html#point-config)'s `shape`
     * property. (`"circle"` if unset.)
     */
    @JsonProperty("shape")
    public MarkPropDefStringNullTypeForShape getShape() { return shape; }
    @JsonProperty("shape")
    public void setShape(MarkPropDefStringNullTypeForShape value) { this.shape = value; }

    /**
     * Size of the mark. - For `"point"`, `"square"` and `"circle"`, – the symbol size, or pixel
     * area of the mark. - For `"bar"` and `"tick"` – the bar and tick's size. - For `"text"` –
     * the text's font size. - Size is unsupported for `"line"`, `"area"`, and `"rect"`. (Use
     * `"trail"` instead of line with varying size)
     */
    @JsonProperty("size")
    public SizeClass getSize() { return size; }
    @JsonProperty("size")
    public void setSize(SizeClass value) { this.size = value; }

    /**
     * Stroke color of the marks. __Default value:__ If undefined, the default color depends on
     * [mark config](https://vega.github.io/vega-lite/docs/config.html#mark-config)'s `color`
     * property.
     *
     * _Note:_ The `stroke` encoding has higher precedence than `color`, thus may override the
     * `color` encoding if conflicting encodings are specified.
     */
    @JsonProperty("stroke")
    public StrokeClass getStroke() { return stroke; }
    @JsonProperty("stroke")
    public void setStroke(StrokeClass value) { this.stroke = value; }

    /**
     * Stroke dash of the marks.
     *
     * __Default value:__ `[1,0]` (No dash).
     */
    @JsonProperty("strokeDash")
    public MarkPropDefNumber getStrokeDash() { return strokeDash; }
    @JsonProperty("strokeDash")
    public void setStrokeDash(MarkPropDefNumber value) { this.strokeDash = value; }

    /**
     * Stroke opacity of the marks.
     *
     * __Default value:__ If undefined, the default opacity depends on [mark
     * config](https://vega.github.io/vega-lite/docs/config.html#mark-config)'s `strokeOpacity`
     * property.
     */
    @JsonProperty("strokeOpacity")
    public StrokeOpacityClass getStrokeOpacity() { return strokeOpacity; }
    @JsonProperty("strokeOpacity")
    public void setStrokeOpacity(StrokeOpacityClass value) { this.strokeOpacity = value; }

    /**
     * Stroke width of the marks.
     *
     * __Default value:__ If undefined, the default stroke width depends on [mark
     * config](https://vega.github.io/vega-lite/docs/config.html#mark-config)'s `strokeWidth`
     * property.
     */
    @JsonProperty("strokeWidth")
    public StrokeWidthClass getStrokeWidth() { return strokeWidth; }
    @JsonProperty("strokeWidth")
    public void setStrokeWidth(StrokeWidthClass value) { this.strokeWidth = value; }

    /**
     * Text of the `text` mark.
     */
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
    public ThetaClass getTheta() { return theta; }
    @JsonProperty("theta")
    public void setTheta(ThetaClass value) { this.theta = value; }

    /**
     * The end angle of arc marks in radians. A value of 0 indicates up or “north”, increasing
     * values proceed clockwise.
     */
    @JsonProperty("theta2")
    public Theta2Class getTheta2() { return theta2; }
    @JsonProperty("theta2")
    public void setTheta2(Theta2Class value) { this.theta2 = value; }

    /**
     * The tooltip text to show upon mouse hover. Specifying `tooltip` encoding overrides [the
     * `tooltip` property in the mark
     * definition](https://vega.github.io/vega-lite/docs/mark.html#mark-def).
     *
     * See the [`tooltip`](https://vega.github.io/vega-lite/docs/tooltip.html) documentation for
     * a detailed discussion about tooltip in Vega-Lite.
     */
    @JsonProperty("tooltip")
    public EncodingTooltip getTooltip() { return tooltip; }
    @JsonProperty("tooltip")
    public void setTooltip(EncodingTooltip value) { this.tooltip = value; }

    /**
     * The URL of an image mark.
     */
    @JsonProperty("url")
    public URLClass getURL() { return url; }
    @JsonProperty("url")
    public void setURL(URLClass value) { this.url = value; }

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
    public X2 getX2() { return x2; }
    @JsonProperty("x2")
    public void setX2(X2 value) { this.x2 = value; }

    /**
     * Error value of x coordinates for error specified `"errorbar"` and `"errorband"`.
     */
    @JsonProperty("xError")
    public XError getXError() { return xError; }
    @JsonProperty("xError")
    public void setXError(XError value) { this.xError = value; }

    /**
     * Secondary error value of x coordinates for error specified `"errorbar"` and `"errorband"`.
     */
    @JsonProperty("xError2")
    public XError2 getXError2() { return xError2; }
    @JsonProperty("xError2")
    public void setXError2(XError2 value) { this.xError2 = value; }

    /**
     * Y coordinates of the marks, or height of vertical `"bar"` and `"area"` without specified
     * `y2` or `height`.
     *
     * The `value` of this channel can be a number or a string `"height"` for the height of the
     * plot.
     */
    @JsonProperty("y")
    public Y getY() { return y; }
    @JsonProperty("y")
    public void setY(Y value) { this.y = value; }

    /**
     * Y2 coordinates for ranged `"area"`, `"bar"`, `"rect"`, and  `"rule"`.
     *
     * The `value` of this channel can be a number or a string `"height"` for the height of the
     * plot.
     */
    @JsonProperty("y2")
    public Y2 getY2() { return y2; }
    @JsonProperty("y2")
    public void setY2(Y2 value) { this.y2 = value; }

    /**
     * Error value of y coordinates for error specified `"errorbar"` and `"errorband"`.
     */
    @JsonProperty("yError")
    public YError getYError() { return yError; }
    @JsonProperty("yError")
    public void setYError(YError value) { this.yError = value; }

    /**
     * Secondary error value of y coordinates for error specified `"errorbar"` and `"errorband"`.
     */
    @JsonProperty("yError2")
    public YError2 getYError2() { return yError2; }
    @JsonProperty("yError2")
    public void setYError2(YError2 value) { this.yError2 = value; }
}
