package org.orbisgis.demat.v4;

import com.fasterxml.jackson.annotation.*;
import java.util.List;
import java.util.Map;

/**
 * Vega-Lite configuration object. This property can only be defined at the top-level of a
 * specification.
 */
public class Config {
    private RectConfig arc;
    private AreaConfig area;
    private Boolean aria;
    private Autosize autosize;
    private AxisConfig axis;
    private AxisConfig axisBand;
    private AxisConfig axisBottom;
    private AxisConfig axisDiscrete;
    private AxisConfig axisLeft;
    private AxisConfig axisPoint;
    private AxisConfig axisQuantitative;
    private AxisConfig axisRight;
    private AxisConfig axisTemporal;
    private AxisConfig axisTop;
    private AxisConfig axisX;
    private AxisConfig axisXBand;
    private AxisConfig axisXDiscrete;
    private AxisConfig axisXPoint;
    private AxisConfig axisXQuantitative;
    private AxisConfig axisXTemporal;
    private AxisConfig axisY;
    private AxisConfig axisYBand;
    private AxisConfig axisYDiscrete;
    private AxisConfig axisYPoint;
    private AxisConfig axisYQuantitative;
    private AxisConfig axisYTemporal;
    private BackgroundUnion background;
    private BarConfig bar;
    private BoxPlotConfig boxplot;
    private MarkConfig circle;
    private CompositionConfig concat;
    private String countTitle;
    private Boolean customFormatTypes;
    private ErrorBandConfig errorband;
    private ErrorBarConfig errorbar;
    private CompositionConfig facet;
    private FieldTitle fieldTitle;
    private String font;
    private MarkConfig geoshape;
    private HeaderConfig header;
    private HeaderConfig headerColumn;
    private HeaderConfig headerFacet;
    private HeaderConfig headerRow;
    private RectConfig image;
    private LegendConfig legend;
    private LineConfig line;
    private BackgroundUnion lineBreak;
    private MarkConfig mark;
    private String numberFormat;
    private Padding padding;
    private List<Parameter> params;
    private MarkConfig point;
    private Projection projection;
    private Map<String, RangeValue> range;
    private RectConfig rect;
    private MarkConfig rule;
    private ScaleConfig scale;
    private SelectionConfig selection;
    private MarkConfig square;
    private Map<String, StyleValue> style;
    private MarkConfig text;
    private TickConfig tick;
    private String timeFormat;
    private BaseTitleNoValueRefs title;
    private LineConfig trail;
    private ViewConfig view;

    /**
     * Arc-specific Config
     */
    @JsonProperty("arc")
    public RectConfig getArc() { return arc; }
    @JsonProperty("arc")
    public void setArc(RectConfig value) { this.arc = value; }

    /**
     * Area-Specific Config
     */
    @JsonProperty("area")
    public AreaConfig getArea() { return area; }
    @JsonProperty("area")
    public void setArea(AreaConfig value) { this.area = value; }

    /**
     * A boolean flag indicating if ARIA default attributes should be included for marks and
     * guides (SVG output only). If false, the `"aria-hidden"` attribute will be set for all
     * guides, removing them from the ARIA accessibility tree and Vega-Lite will not generate
     * default descriptions for marks.
     *
     * __Default value:__ `true`.
     */
    @JsonProperty("aria")
    public Boolean getAria() { return aria; }
    @JsonProperty("aria")
    public void setAria(Boolean value) { this.aria = value; }

    /**
     * How the visualization size should be determined. If a string, should be one of `"pad"`,
     * `"fit"` or `"none"`. Object values can additionally specify parameters for content sizing
     * and automatic resizing.
     *
     * __Default value__: `pad`
     */
    @JsonProperty("autosize")
    public Autosize getAutosize() { return autosize; }
    @JsonProperty("autosize")
    public void setAutosize(Autosize value) { this.autosize = value; }

    /**
     * Axis configuration, which determines default properties for all `x` and `y`
     * [axes](https://vega.github.io/vega-lite/docs/axis.html). For a full list of axis
     * configuration options, please see the [corresponding section of the axis
     * documentation](https://vega.github.io/vega-lite/docs/axis.html#config).
     */
    @JsonProperty("axis")
    public AxisConfig getAxis() { return axis; }
    @JsonProperty("axis")
    public void setAxis(AxisConfig value) { this.axis = value; }

    /**
     * Config for axes with "band" scales.
     */
    @JsonProperty("axisBand")
    public AxisConfig getAxisBand() { return axisBand; }
    @JsonProperty("axisBand")
    public void setAxisBand(AxisConfig value) { this.axisBand = value; }

    /**
     * Config for x-axis along the bottom edge of the chart.
     */
    @JsonProperty("axisBottom")
    public AxisConfig getAxisBottom() { return axisBottom; }
    @JsonProperty("axisBottom")
    public void setAxisBottom(AxisConfig value) { this.axisBottom = value; }

    /**
     * Config for axes with "point" or "band" scales.
     */
    @JsonProperty("axisDiscrete")
    public AxisConfig getAxisDiscrete() { return axisDiscrete; }
    @JsonProperty("axisDiscrete")
    public void setAxisDiscrete(AxisConfig value) { this.axisDiscrete = value; }

    /**
     * Config for y-axis along the left edge of the chart.
     */
    @JsonProperty("axisLeft")
    public AxisConfig getAxisLeft() { return axisLeft; }
    @JsonProperty("axisLeft")
    public void setAxisLeft(AxisConfig value) { this.axisLeft = value; }

    /**
     * Config for axes with "point" scales.
     */
    @JsonProperty("axisPoint")
    public AxisConfig getAxisPoint() { return axisPoint; }
    @JsonProperty("axisPoint")
    public void setAxisPoint(AxisConfig value) { this.axisPoint = value; }

    /**
     * Config for quantitative axes.
     */
    @JsonProperty("axisQuantitative")
    public AxisConfig getAxisQuantitative() { return axisQuantitative; }
    @JsonProperty("axisQuantitative")
    public void setAxisQuantitative(AxisConfig value) { this.axisQuantitative = value; }

    /**
     * Config for y-axis along the right edge of the chart.
     */
    @JsonProperty("axisRight")
    public AxisConfig getAxisRight() { return axisRight; }
    @JsonProperty("axisRight")
    public void setAxisRight(AxisConfig value) { this.axisRight = value; }

    /**
     * Config for temporal axes.
     */
    @JsonProperty("axisTemporal")
    public AxisConfig getAxisTemporal() { return axisTemporal; }
    @JsonProperty("axisTemporal")
    public void setAxisTemporal(AxisConfig value) { this.axisTemporal = value; }

    /**
     * Config for x-axis along the top edge of the chart.
     */
    @JsonProperty("axisTop")
    public AxisConfig getAxisTop() { return axisTop; }
    @JsonProperty("axisTop")
    public void setAxisTop(AxisConfig value) { this.axisTop = value; }

    /**
     * X-axis specific config.
     */
    @JsonProperty("axisX")
    public AxisConfig getAxisX() { return axisX; }
    @JsonProperty("axisX")
    public void setAxisX(AxisConfig value) { this.axisX = value; }

    /**
     * Config for x-axes with "band" scales.
     */
    @JsonProperty("axisXBand")
    public AxisConfig getAxisXBand() { return axisXBand; }
    @JsonProperty("axisXBand")
    public void setAxisXBand(AxisConfig value) { this.axisXBand = value; }

    /**
     * Config for x-axes with "point" or "band" scales.
     */
    @JsonProperty("axisXDiscrete")
    public AxisConfig getAxisXDiscrete() { return axisXDiscrete; }
    @JsonProperty("axisXDiscrete")
    public void setAxisXDiscrete(AxisConfig value) { this.axisXDiscrete = value; }

    /**
     * Config for x-axes with "point" scales.
     */
    @JsonProperty("axisXPoint")
    public AxisConfig getAxisXPoint() { return axisXPoint; }
    @JsonProperty("axisXPoint")
    public void setAxisXPoint(AxisConfig value) { this.axisXPoint = value; }

    /**
     * Config for x-quantitative axes.
     */
    @JsonProperty("axisXQuantitative")
    public AxisConfig getAxisXQuantitative() { return axisXQuantitative; }
    @JsonProperty("axisXQuantitative")
    public void setAxisXQuantitative(AxisConfig value) { this.axisXQuantitative = value; }

    /**
     * Config for x-temporal axes.
     */
    @JsonProperty("axisXTemporal")
    public AxisConfig getAxisXTemporal() { return axisXTemporal; }
    @JsonProperty("axisXTemporal")
    public void setAxisXTemporal(AxisConfig value) { this.axisXTemporal = value; }

    /**
     * Y-axis specific config.
     */
    @JsonProperty("axisY")
    public AxisConfig getAxisY() { return axisY; }
    @JsonProperty("axisY")
    public void setAxisY(AxisConfig value) { this.axisY = value; }

    /**
     * Config for y-axes with "band" scales.
     */
    @JsonProperty("axisYBand")
    public AxisConfig getAxisYBand() { return axisYBand; }
    @JsonProperty("axisYBand")
    public void setAxisYBand(AxisConfig value) { this.axisYBand = value; }

    /**
     * Config for y-axes with "point" or "band" scales.
     */
    @JsonProperty("axisYDiscrete")
    public AxisConfig getAxisYDiscrete() { return axisYDiscrete; }
    @JsonProperty("axisYDiscrete")
    public void setAxisYDiscrete(AxisConfig value) { this.axisYDiscrete = value; }

    /**
     * Config for y-axes with "point" scales.
     */
    @JsonProperty("axisYPoint")
    public AxisConfig getAxisYPoint() { return axisYPoint; }
    @JsonProperty("axisYPoint")
    public void setAxisYPoint(AxisConfig value) { this.axisYPoint = value; }

    /**
     * Config for y-quantitative axes.
     */
    @JsonProperty("axisYQuantitative")
    public AxisConfig getAxisYQuantitative() { return axisYQuantitative; }
    @JsonProperty("axisYQuantitative")
    public void setAxisYQuantitative(AxisConfig value) { this.axisYQuantitative = value; }

    /**
     * Config for y-temporal axes.
     */
    @JsonProperty("axisYTemporal")
    public AxisConfig getAxisYTemporal() { return axisYTemporal; }
    @JsonProperty("axisYTemporal")
    public void setAxisYTemporal(AxisConfig value) { this.axisYTemporal = value; }

    /**
     * CSS color property to use as the background of the entire view.
     *
     * __Default value:__ `"white"`
     */
    @JsonProperty("background")
    public BackgroundUnion getBackground() { return background; }
    @JsonProperty("background")
    public void setBackground(BackgroundUnion value) { this.background = value; }

    /**
     * Bar-Specific Config
     */
    @JsonProperty("bar")
    public BarConfig getBar() { return bar; }
    @JsonProperty("bar")
    public void setBar(BarConfig value) { this.bar = value; }

    /**
     * Box Config
     */
    @JsonProperty("boxplot")
    public BoxPlotConfig getBoxplot() { return boxplot; }
    @JsonProperty("boxplot")
    public void setBoxplot(BoxPlotConfig value) { this.boxplot = value; }

    /**
     * Circle-Specific Config
     */
    @JsonProperty("circle")
    public MarkConfig getCircle() { return circle; }
    @JsonProperty("circle")
    public void setCircle(MarkConfig value) { this.circle = value; }

    /**
     * Default configuration for all concatenation and repeat view composition operators
     * (`concat`, `hconcat`, `vconcat`, and `repeat`)
     */
    @JsonProperty("concat")
    public CompositionConfig getConcat() { return concat; }
    @JsonProperty("concat")
    public void setConcat(CompositionConfig value) { this.concat = value; }

    /**
     * Default axis and legend title for count fields.
     *
     * __Default value:__ `'Count of Records`.
     */
    @JsonProperty("countTitle")
    public String getCountTitle() { return countTitle; }
    @JsonProperty("countTitle")
    public void setCountTitle(String value) { this.countTitle = value; }

    /**
     * Allow the `formatType` property for text marks and guides to accept a custom formatter
     * function [registered as a Vega
     * expression](https://vega.github.io/vega-lite/usage/compile.html#format-type).
     */
    @JsonProperty("customFormatTypes")
    public Boolean getCustomFormatTypes() { return customFormatTypes; }
    @JsonProperty("customFormatTypes")
    public void setCustomFormatTypes(Boolean value) { this.customFormatTypes = value; }

    /**
     * ErrorBand Config
     */
    @JsonProperty("errorband")
    public ErrorBandConfig getErrorband() { return errorband; }
    @JsonProperty("errorband")
    public void setErrorband(ErrorBandConfig value) { this.errorband = value; }

    /**
     * ErrorBar Config
     */
    @JsonProperty("errorbar")
    public ErrorBarConfig getErrorbar() { return errorbar; }
    @JsonProperty("errorbar")
    public void setErrorbar(ErrorBarConfig value) { this.errorbar = value; }

    /**
     * Default configuration for the `facet` view composition operator
     */
    @JsonProperty("facet")
    public CompositionConfig getFacet() { return facet; }
    @JsonProperty("facet")
    public void setFacet(CompositionConfig value) { this.facet = value; }

    /**
     * Defines how Vega-Lite generates title for fields. There are three possible styles: -
     * `"verbal"` (Default) - displays function in a verbal style (e.g., "Sum of field",
     * "Year-month of date", "field (binned)"). - `"function"` - displays function using
     * parentheses and capitalized texts (e.g., "SUM(field)", "YEARMONTH(date)", "BIN(field)").
     * - `"plain"` - displays only the field name without functions (e.g., "field", "date",
     * "field").
     */
    @JsonProperty("fieldTitle")
    public FieldTitle getFieldTitle() { return fieldTitle; }
    @JsonProperty("fieldTitle")
    public void setFieldTitle(FieldTitle value) { this.fieldTitle = value; }

    /**
     * Default font for all text marks, titles, and labels.
     */
    @JsonProperty("font")
    public String getFont() { return font; }
    @JsonProperty("font")
    public void setFont(String value) { this.font = value; }

    /**
     * Geoshape-Specific Config
     */
    @JsonProperty("geoshape")
    public MarkConfig getGeoshape() { return geoshape; }
    @JsonProperty("geoshape")
    public void setGeoshape(MarkConfig value) { this.geoshape = value; }

    /**
     * Header configuration, which determines default properties for all
     * [headers](https://vega.github.io/vega-lite/docs/header.html).
     *
     * For a full list of header configuration options, please see the [corresponding section of
     * in the header documentation](https://vega.github.io/vega-lite/docs/header.html#config).
     */
    @JsonProperty("header")
    public HeaderConfig getHeader() { return header; }
    @JsonProperty("header")
    public void setHeader(HeaderConfig value) { this.header = value; }

    /**
     * Header configuration, which determines default properties for column
     * [headers](https://vega.github.io/vega-lite/docs/header.html).
     *
     * For a full list of header configuration options, please see the [corresponding section of
     * in the header documentation](https://vega.github.io/vega-lite/docs/header.html#config).
     */
    @JsonProperty("headerColumn")
    public HeaderConfig getHeaderColumn() { return headerColumn; }
    @JsonProperty("headerColumn")
    public void setHeaderColumn(HeaderConfig value) { this.headerColumn = value; }

    /**
     * Header configuration, which determines default properties for non-row/column facet
     * [headers](https://vega.github.io/vega-lite/docs/header.html).
     *
     * For a full list of header configuration options, please see the [corresponding section of
     * in the header documentation](https://vega.github.io/vega-lite/docs/header.html#config).
     */
    @JsonProperty("headerFacet")
    public HeaderConfig getHeaderFacet() { return headerFacet; }
    @JsonProperty("headerFacet")
    public void setHeaderFacet(HeaderConfig value) { this.headerFacet = value; }

    /**
     * Header configuration, which determines default properties for row
     * [headers](https://vega.github.io/vega-lite/docs/header.html).
     *
     * For a full list of header configuration options, please see the [corresponding section of
     * in the header documentation](https://vega.github.io/vega-lite/docs/header.html#config).
     */
    @JsonProperty("headerRow")
    public HeaderConfig getHeaderRow() { return headerRow; }
    @JsonProperty("headerRow")
    public void setHeaderRow(HeaderConfig value) { this.headerRow = value; }

    /**
     * Image-specific Config
     */
    @JsonProperty("image")
    public RectConfig getImage() { return image; }
    @JsonProperty("image")
    public void setImage(RectConfig value) { this.image = value; }

    /**
     * Legend configuration, which determines default properties for all
     * [legends](https://vega.github.io/vega-lite/docs/legend.html). For a full list of legend
     * configuration options, please see the [corresponding section of in the legend
     * documentation](https://vega.github.io/vega-lite/docs/legend.html#config).
     */
    @JsonProperty("legend")
    public LegendConfig getLegend() { return legend; }
    @JsonProperty("legend")
    public void setLegend(LegendConfig value) { this.legend = value; }

    /**
     * Line-Specific Config
     */
    @JsonProperty("line")
    public LineConfig getLine() { return line; }
    @JsonProperty("line")
    public void setLine(LineConfig value) { this.line = value; }

    /**
     * A delimiter, such as a newline character, upon which to break text strings into multiple
     * lines. This property provides a global default for text marks, which is overridden by
     * mark or style config settings, and by the lineBreak mark encoding channel. If
     * signal-valued, either string or regular expression (regexp) values are valid.
     */
    @JsonProperty("lineBreak")
    public BackgroundUnion getLineBreak() { return lineBreak; }
    @JsonProperty("lineBreak")
    public void setLineBreak(BackgroundUnion value) { this.lineBreak = value; }

    /**
     * Mark Config
     */
    @JsonProperty("mark")
    public MarkConfig getMark() { return mark; }
    @JsonProperty("mark")
    public void setMark(MarkConfig value) { this.mark = value; }

    /**
     * D3 Number format for guide labels and text marks. For example `"s"` for SI units. Use
     * [D3's number format pattern](https://github.com/d3/d3-format#locale_format).
     */
    @JsonProperty("numberFormat")
    public String getNumberFormat() { return numberFormat; }
    @JsonProperty("numberFormat")
    public void setNumberFormat(String value) { this.numberFormat = value; }

    /**
     * The default visualization padding, in pixels, from the edge of the visualization canvas
     * to the data rectangle. If a number, specifies padding for all sides. If an object, the
     * value should have the format `{"left": 5, "top": 5, "right": 5, "bottom": 5}` to specify
     * padding for each side of the visualization.
     *
     * __Default value__: `5`
     */
    @JsonProperty("padding")
    public Padding getPadding() { return padding; }
    @JsonProperty("padding")
    public void setPadding(Padding value) { this.padding = value; }

    /**
     * Dynamic variables that parameterize a visualization.
     */
    @JsonProperty("params")
    public List<Parameter> getParams() { return params; }
    @JsonProperty("params")
    public void setParams(List<Parameter> value) { this.params = value; }

    /**
     * Point-Specific Config
     */
    @JsonProperty("point")
    public MarkConfig getPoint() { return point; }
    @JsonProperty("point")
    public void setPoint(MarkConfig value) { this.point = value; }

    /**
     * Projection configuration, which determines default properties for all
     * [projections](https://vega.github.io/vega-lite/docs/projection.html). For a full list of
     * projection configuration options, please see the [corresponding section of the projection
     * documentation](https://vega.github.io/vega-lite/docs/projection.html#config).
     */
    @JsonProperty("projection")
    public Projection getProjection() { return projection; }
    @JsonProperty("projection")
    public void setProjection(Projection value) { this.projection = value; }

    /**
     * An object hash that defines default range arrays or schemes for using with scales. For a
     * full list of scale range configuration options, please see the [corresponding section of
     * the scale documentation](https://vega.github.io/vega-lite/docs/scale.html#config).
     */
    @JsonProperty("range")
    public Map<String, RangeValue> getRange() { return range; }
    @JsonProperty("range")
    public void setRange(Map<String, RangeValue> value) { this.range = value; }

    /**
     * Rect-Specific Config
     */
    @JsonProperty("rect")
    public RectConfig getRect() { return rect; }
    @JsonProperty("rect")
    public void setRect(RectConfig value) { this.rect = value; }

    /**
     * Rule-Specific Config
     */
    @JsonProperty("rule")
    public MarkConfig getRule() { return rule; }
    @JsonProperty("rule")
    public void setRule(MarkConfig value) { this.rule = value; }

    /**
     * Scale configuration determines default properties for all
     * [scales](https://vega.github.io/vega-lite/docs/scale.html). For a full list of scale
     * configuration options, please see the [corresponding section of the scale
     * documentation](https://vega.github.io/vega-lite/docs/scale.html#config).
     */
    @JsonProperty("scale")
    public ScaleConfig getScale() { return scale; }
    @JsonProperty("scale")
    public void setScale(ScaleConfig value) { this.scale = value; }

    /**
     * An object hash for defining default properties for each type of selections.
     */
    @JsonProperty("selection")
    public SelectionConfig getSelection() { return selection; }
    @JsonProperty("selection")
    public void setSelection(SelectionConfig value) { this.selection = value; }

    /**
     * Square-Specific Config
     */
    @JsonProperty("square")
    public MarkConfig getSquare() { return square; }
    @JsonProperty("square")
    public void setSquare(MarkConfig value) { this.square = value; }

    /**
     * An object hash that defines key-value mappings to determine default properties for marks
     * with a given [style](https://vega.github.io/vega-lite/docs/mark.html#mark-def). The keys
     * represent styles names; the values have to be valid [mark configuration
     * objects](https://vega.github.io/vega-lite/docs/mark.html#config).
     */
    @JsonProperty("style")
    public Map<String, StyleValue> getStyle() { return style; }
    @JsonProperty("style")
    public void setStyle(Map<String, StyleValue> value) { this.style = value; }

    /**
     * Text-Specific Config
     */
    @JsonProperty("text")
    public MarkConfig getText() { return text; }
    @JsonProperty("text")
    public void setText(MarkConfig value) { this.text = value; }

    /**
     * Tick-Specific Config
     */
    @JsonProperty("tick")
    public TickConfig getTick() { return tick; }
    @JsonProperty("tick")
    public void setTick(TickConfig value) { this.tick = value; }

    /**
     * Default time format for raw time values (without time units) in text marks, legend labels
     * and header labels.
     *
     * __Default value:__ `"%b %d, %Y"` __Note:__ Axes automatically determine the format for
     * each label automatically so this config does not affect axes.
     */
    @JsonProperty("timeFormat")
    public String getTimeFormat() { return timeFormat; }
    @JsonProperty("timeFormat")
    public void setTimeFormat(String value) { this.timeFormat = value; }

    /**
     * Title configuration, which determines default properties for all
     * [titles](https://vega.github.io/vega-lite/docs/title.html). For a full list of title
     * configuration options, please see the [corresponding section of the title
     * documentation](https://vega.github.io/vega-lite/docs/title.html#config).
     */
    @JsonProperty("title")
    public BaseTitleNoValueRefs getTitle() { return title; }
    @JsonProperty("title")
    public void setTitle(BaseTitleNoValueRefs value) { this.title = value; }

    /**
     * Trail-Specific Config
     */
    @JsonProperty("trail")
    public LineConfig getTrail() { return trail; }
    @JsonProperty("trail")
    public void setTrail(LineConfig value) { this.trail = value; }

    /**
     * Default properties for [single view
     * plots](https://vega.github.io/vega-lite/docs/spec.html#single).
     */
    @JsonProperty("view")
    public ViewConfig getView() { return view; }
    @JsonProperty("view")
    public void setView(ViewConfig value) { this.view = value; }
}
