package org.orbisgis.demat.v4;

import com.fasterxml.jackson.annotation.*;

public class Axis {
    private Aria aria;
    private CornerRadiusUnion bandPosition;
    private BackgroundUnion description;
    private Aria domain;
    private Cap domainCap;
    private BackgroundUnion domainColor;
    private StrokeDashUnion domainDash;
    private CornerRadiusUnion domainDashOffset;
    private CornerRadiusUnion domainOpacity;
    private CornerRadiusUnion domainWidth;
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
    private CornerRadiusUnion labelFlushOffset;
    private ConditionalAxisPropertyStringNull labelFont;
    private GridWidthUnion labelFontSize;
    private ConditionalAxisPropertyFontStyleNull labelFontStyle;
    private FontWeight labelFontWeight;
    private CornerRadiusUnion labelLimit;
    private CornerRadiusUnion labelLineHeight;
    private GridDashOffsetUnion labelOffset;
    private GridDashOffsetUnion labelOpacity;
    private LabelOverlap labelOverlap;
    private GridDashOffsetUnion labelPadding;
    private Aria labels;
    private CornerRadiusUnion labelSeparation;
    private CornerRadiusUnion maxExtent;
    private CornerRadiusUnion minExtent;
    private Double offset;
    private TitleOrientUnion orient;
    private CornerRadiusUnion position;
    private LegendText style;
    private TickBandUnion tickBand;
    private Cap tickCap;
    private GridColorUnion tickColor;
    private TickCount tickCount;
    private AxisTickDash tickDash;
    private GridDashOffsetUnion tickDashOffset;
    private Aria tickExtra;
    private CornerRadiusUnion tickMinStep;
    private CornerRadiusUnion tickOffset;
    private GridDashOffsetUnion tickOpacity;
    private Aria tickRound;
    private Aria ticks;
    private GridWidthUnion tickSize;
    private GridWidthUnion tickWidth;
    private LegendText title;
    private TitleAlignUnion titleAlign;
    private TitleAnchorUnion titleAnchor;
    private CornerRadiusUnion titleAngle;
    private BackgroundUnion titleBaseline;
    private BackgroundUnion titleColor;
    private BackgroundUnion titleFont;
    private FontSize titleFontSize;
    private BackgroundUnion titleFontStyle;
    private FontWeightUnion titleFontWeight;
    private FontSize titleLimit;
    private CornerRadiusUnion titleLineHeight;
    private CornerRadiusUnion titleOpacity;
    private CornerRadiusUnion titlePadding;
    private CornerRadiusUnion titleX;
    private CornerRadiusUnion titleY;
    private CornerRadiusUnion translate;
    private Values values;
    private Double zindex;

    @JsonProperty("aria")
    public Aria getAria() { return aria; }
    @JsonProperty("aria")
    public void setAria(Aria value) { this.aria = value; }

    @JsonProperty("bandPosition")
    public CornerRadiusUnion getBandPosition() { return bandPosition; }
    @JsonProperty("bandPosition")
    public void setBandPosition(CornerRadiusUnion value) { this.bandPosition = value; }

    @JsonProperty("description")
    public BackgroundUnion getDescription() { return description; }
    @JsonProperty("description")
    public void setDescription(BackgroundUnion value) { this.description = value; }

    @JsonProperty("domain")
    public Aria getDomain() { return domain; }
    @JsonProperty("domain")
    public void setDomain(Aria value) { this.domain = value; }

    @JsonProperty("domainCap")
    public Cap getDomainCap() { return domainCap; }
    @JsonProperty("domainCap")
    public void setDomainCap(Cap value) { this.domainCap = value; }

    @JsonProperty("domainColor")
    public BackgroundUnion getDomainColor() { return domainColor; }
    @JsonProperty("domainColor")
    public void setDomainColor(BackgroundUnion value) { this.domainColor = value; }

    @JsonProperty("domainDash")
    public StrokeDashUnion getDomainDash() { return domainDash; }
    @JsonProperty("domainDash")
    public void setDomainDash(StrokeDashUnion value) { this.domainDash = value; }

    @JsonProperty("domainDashOffset")
    public CornerRadiusUnion getDomainDashOffset() { return domainDashOffset; }
    @JsonProperty("domainDashOffset")
    public void setDomainDashOffset(CornerRadiusUnion value) { this.domainDashOffset = value; }

    @JsonProperty("domainOpacity")
    public CornerRadiusUnion getDomainOpacity() { return domainOpacity; }
    @JsonProperty("domainOpacity")
    public void setDomainOpacity(CornerRadiusUnion value) { this.domainOpacity = value; }

    @JsonProperty("domainWidth")
    public CornerRadiusUnion getDomainWidth() { return domainWidth; }
    @JsonProperty("domainWidth")
    public void setDomainWidth(CornerRadiusUnion value) { this.domainWidth = value; }

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
    public CornerRadiusUnion getLabelFlushOffset() { return labelFlushOffset; }
    @JsonProperty("labelFlushOffset")
    public void setLabelFlushOffset(CornerRadiusUnion value) { this.labelFlushOffset = value; }

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
    public CornerRadiusUnion getLabelLimit() { return labelLimit; }
    @JsonProperty("labelLimit")
    public void setLabelLimit(CornerRadiusUnion value) { this.labelLimit = value; }

    @JsonProperty("labelLineHeight")
    public CornerRadiusUnion getLabelLineHeight() { return labelLineHeight; }
    @JsonProperty("labelLineHeight")
    public void setLabelLineHeight(CornerRadiusUnion value) { this.labelLineHeight = value; }

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
    public CornerRadiusUnion getLabelSeparation() { return labelSeparation; }
    @JsonProperty("labelSeparation")
    public void setLabelSeparation(CornerRadiusUnion value) { this.labelSeparation = value; }

    @JsonProperty("maxExtent")
    public CornerRadiusUnion getMaxExtent() { return maxExtent; }
    @JsonProperty("maxExtent")
    public void setMaxExtent(CornerRadiusUnion value) { this.maxExtent = value; }

    @JsonProperty("minExtent")
    public CornerRadiusUnion getMinExtent() { return minExtent; }
    @JsonProperty("minExtent")
    public void setMinExtent(CornerRadiusUnion value) { this.minExtent = value; }

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
     * The orientation of the axis. One of `"top"`, `"bottom"`, `"left"` or `"right"`. The
     * orientation can be used to further specialize the axis type (e.g., a y-axis oriented
     * towards the right edge of the chart).
     *
     * __Default value:__ `"bottom"` for x-axes and `"left"` for y-axes.
     */
    @JsonProperty("orient")
    public TitleOrientUnion getOrient() { return orient; }
    @JsonProperty("orient")
    public void setOrient(TitleOrientUnion value) { this.orient = value; }

    /**
     * The anchor position of the axis in pixels. For x-axes with top or bottom orientation,
     * this sets the axis group x coordinate. For y-axes with left or right orientation, this
     * sets the axis group y coordinate.
     *
     * __Default value__: `0`
     */
    @JsonProperty("position")
    public CornerRadiusUnion getPosition() { return position; }
    @JsonProperty("position")
    public void setPosition(CornerRadiusUnion value) { this.position = value; }

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
    public CornerRadiusUnion getTickMinStep() { return tickMinStep; }
    @JsonProperty("tickMinStep")
    public void setTickMinStep(CornerRadiusUnion value) { this.tickMinStep = value; }

    @JsonProperty("tickOffset")
    public CornerRadiusUnion getTickOffset() { return tickOffset; }
    @JsonProperty("tickOffset")
    public void setTickOffset(CornerRadiusUnion value) { this.tickOffset = value; }

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
    public CornerRadiusUnion getTitleAngle() { return titleAngle; }
    @JsonProperty("titleAngle")
    public void setTitleAngle(CornerRadiusUnion value) { this.titleAngle = value; }

    @JsonProperty("titleBaseline")
    public BackgroundUnion getTitleBaseline() { return titleBaseline; }
    @JsonProperty("titleBaseline")
    public void setTitleBaseline(BackgroundUnion value) { this.titleBaseline = value; }

    @JsonProperty("titleColor")
    public BackgroundUnion getTitleColor() { return titleColor; }
    @JsonProperty("titleColor")
    public void setTitleColor(BackgroundUnion value) { this.titleColor = value; }

    @JsonProperty("titleFont")
    public BackgroundUnion getTitleFont() { return titleFont; }
    @JsonProperty("titleFont")
    public void setTitleFont(BackgroundUnion value) { this.titleFont = value; }

    @JsonProperty("titleFontSize")
    public FontSize getTitleFontSize() { return titleFontSize; }
    @JsonProperty("titleFontSize")
    public void setTitleFontSize(FontSize value) { this.titleFontSize = value; }

    @JsonProperty("titleFontStyle")
    public BackgroundUnion getTitleFontStyle() { return titleFontStyle; }
    @JsonProperty("titleFontStyle")
    public void setTitleFontStyle(BackgroundUnion value) { this.titleFontStyle = value; }

    @JsonProperty("titleFontWeight")
    public FontWeightUnion getTitleFontWeight() { return titleFontWeight; }
    @JsonProperty("titleFontWeight")
    public void setTitleFontWeight(FontWeightUnion value) { this.titleFontWeight = value; }

    @JsonProperty("titleLimit")
    public FontSize getTitleLimit() { return titleLimit; }
    @JsonProperty("titleLimit")
    public void setTitleLimit(FontSize value) { this.titleLimit = value; }

    @JsonProperty("titleLineHeight")
    public CornerRadiusUnion getTitleLineHeight() { return titleLineHeight; }
    @JsonProperty("titleLineHeight")
    public void setTitleLineHeight(CornerRadiusUnion value) { this.titleLineHeight = value; }

    @JsonProperty("titleOpacity")
    public CornerRadiusUnion getTitleOpacity() { return titleOpacity; }
    @JsonProperty("titleOpacity")
    public void setTitleOpacity(CornerRadiusUnion value) { this.titleOpacity = value; }

    @JsonProperty("titlePadding")
    public CornerRadiusUnion getTitlePadding() { return titlePadding; }
    @JsonProperty("titlePadding")
    public void setTitlePadding(CornerRadiusUnion value) { this.titlePadding = value; }

    @JsonProperty("titleX")
    public CornerRadiusUnion getTitleX() { return titleX; }
    @JsonProperty("titleX")
    public void setTitleX(CornerRadiusUnion value) { this.titleX = value; }

    @JsonProperty("titleY")
    public CornerRadiusUnion getTitleY() { return titleY; }
    @JsonProperty("titleY")
    public void setTitleY(CornerRadiusUnion value) { this.titleY = value; }

    @JsonProperty("translate")
    public CornerRadiusUnion getTranslate() { return translate; }
    @JsonProperty("translate")
    public void setTranslate(CornerRadiusUnion value) { this.translate = value; }

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
