package org.orbisgis.demat.v4;

import com.fasterxml.jackson.annotation.*;

/**
 * Properties of a legend or boolean flag for determining whether to show it.
 */
public class Legend {
    private Aria aria;
    private CornerRadiusUnion clipHeight;
    private CornerRadiusUnion columnPadding;
    private CornerRadiusUnion columns;
    private CornerRadiusUnion cornerRadius;
    private BackgroundUnion description;
    private Orientation direction;
    private BackgroundUnion fillColor;
    private Format format;
    private String formatType;
    private FontSize gradientLength;
    private CornerRadiusUnion gradientOpacity;
    private BackgroundUnion gradientStrokeColor;
    private FontSize gradientStrokeWidth;
    private FontSize gradientThickness;
    private GridAlign gridAlign;
    private TitleAlignUnion labelAlign;
    private BackgroundUnion labelBaseline;
    private BackgroundUnion labelColor;
    private String labelExpr;
    private BackgroundUnion labelFont;
    private FontSize labelFontSize;
    private BackgroundUnion labelFontStyle;
    private FontWeightUnion labelFontWeight;
    private CornerRadiusUnion labelLimit;
    private CornerRadiusUnion labelOffset;
    private CornerRadiusUnion labelOpacity;
    private LabelOverlap labelOverlap;
    private CornerRadiusUnion labelPadding;
    private CornerRadiusUnion labelSeparation;
    private CornerRadiusUnion legendX;
    private CornerRadiusUnion legendY;
    private CornerRadiusUnion offset;
    private LegendOrient orient;
    private CornerRadiusUnion padding;
    private CornerRadiusUnion rowPadding;
    private BackgroundUnion strokeColor;
    private StrokeDashUnion symbolDash;
    private CornerRadiusUnion symbolDashOffset;
    private BackgroundUnion symbolFillColor;
    private CornerRadiusUnion symbolLimit;
    private CornerRadiusUnion symbolOffset;
    private CornerRadiusUnion symbolOpacity;
    private FontSize symbolSize;
    private BackgroundUnion symbolStrokeColor;
    private FontSize symbolStrokeWidth;
    private BackgroundUnion symbolType;
    private TickCount tickCount;
    private CornerRadiusUnion tickMinStep;
    private LegendText title;
    private TitleAlignUnion titleAlign;
    private TitleAnchorUnion titleAnchor;
    private BackgroundUnion titleBaseline;
    private BackgroundUnion titleColor;
    private BackgroundUnion titleFont;
    private CornerRadiusUnion titleFontSize;
    private BackgroundUnion titleFontStyle;
    private FontWeightUnion titleFontWeight;
    private FontSize titleLimit;
    private CornerRadiusUnion titleLineHeight;
    private CornerRadiusUnion titleOpacity;
    private TitleOrientUnion titleOrient;
    private CornerRadiusUnion titlePadding;
    private LegendType type;
    private Values values;
    private Double zindex;

    @JsonProperty("aria")
    public Aria getAria() { return aria; }
    @JsonProperty("aria")
    public void setAria(Aria value) { this.aria = value; }

    @JsonProperty("clipHeight")
    public CornerRadiusUnion getClipHeight() { return clipHeight; }
    @JsonProperty("clipHeight")
    public void setClipHeight(CornerRadiusUnion value) { this.clipHeight = value; }

    @JsonProperty("columnPadding")
    public CornerRadiusUnion getColumnPadding() { return columnPadding; }
    @JsonProperty("columnPadding")
    public void setColumnPadding(CornerRadiusUnion value) { this.columnPadding = value; }

    @JsonProperty("columns")
    public CornerRadiusUnion getColumns() { return columns; }
    @JsonProperty("columns")
    public void setColumns(CornerRadiusUnion value) { this.columns = value; }

    @JsonProperty("cornerRadius")
    public CornerRadiusUnion getCornerRadius() { return cornerRadius; }
    @JsonProperty("cornerRadius")
    public void setCornerRadius(CornerRadiusUnion value) { this.cornerRadius = value; }

    @JsonProperty("description")
    public BackgroundUnion getDescription() { return description; }
    @JsonProperty("description")
    public void setDescription(BackgroundUnion value) { this.description = value; }

    /**
     * The direction of the legend, one of `"vertical"` or `"horizontal"`.
     *
     * __Default value:__ - For top-/bottom-`orient`ed legends, `"horizontal"` - For
     * left-/right-`orient`ed legends, `"vertical"` - For top/bottom-left/right-`orient`ed
     * legends, `"horizontal"` for gradient legends and `"vertical"` for symbol legends.
     */
    @JsonProperty("direction")
    public Orientation getDirection() { return direction; }
    @JsonProperty("direction")
    public void setDirection(Orientation value) { this.direction = value; }

    @JsonProperty("fillColor")
    public BackgroundUnion getFillColor() { return fillColor; }
    @JsonProperty("fillColor")
    public void setFillColor(BackgroundUnion value) { this.fillColor = value; }

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

    @JsonProperty("gradientLength")
    public FontSize getGradientLength() { return gradientLength; }
    @JsonProperty("gradientLength")
    public void setGradientLength(FontSize value) { this.gradientLength = value; }

    @JsonProperty("gradientOpacity")
    public CornerRadiusUnion getGradientOpacity() { return gradientOpacity; }
    @JsonProperty("gradientOpacity")
    public void setGradientOpacity(CornerRadiusUnion value) { this.gradientOpacity = value; }

    @JsonProperty("gradientStrokeColor")
    public BackgroundUnion getGradientStrokeColor() { return gradientStrokeColor; }
    @JsonProperty("gradientStrokeColor")
    public void setGradientStrokeColor(BackgroundUnion value) { this.gradientStrokeColor = value; }

    @JsonProperty("gradientStrokeWidth")
    public FontSize getGradientStrokeWidth() { return gradientStrokeWidth; }
    @JsonProperty("gradientStrokeWidth")
    public void setGradientStrokeWidth(FontSize value) { this.gradientStrokeWidth = value; }

    @JsonProperty("gradientThickness")
    public FontSize getGradientThickness() { return gradientThickness; }
    @JsonProperty("gradientThickness")
    public void setGradientThickness(FontSize value) { this.gradientThickness = value; }

    @JsonProperty("gridAlign")
    public GridAlign getGridAlign() { return gridAlign; }
    @JsonProperty("gridAlign")
    public void setGridAlign(GridAlign value) { this.gridAlign = value; }

    @JsonProperty("labelAlign")
    public TitleAlignUnion getLabelAlign() { return labelAlign; }
    @JsonProperty("labelAlign")
    public void setLabelAlign(TitleAlignUnion value) { this.labelAlign = value; }

    @JsonProperty("labelBaseline")
    public BackgroundUnion getLabelBaseline() { return labelBaseline; }
    @JsonProperty("labelBaseline")
    public void setLabelBaseline(BackgroundUnion value) { this.labelBaseline = value; }

    @JsonProperty("labelColor")
    public BackgroundUnion getLabelColor() { return labelColor; }
    @JsonProperty("labelColor")
    public void setLabelColor(BackgroundUnion value) { this.labelColor = value; }

    /**
     * [Vega expression](https://vega.github.io/vega/docs/expressions/) for customizing labels.
     *
     * __Note:__ The label text and value can be assessed via the `label` and `value` properties
     * of the legend's backing `datum` object.
     */
    @JsonProperty("labelExpr")
    public String getLabelExpr() { return labelExpr; }
    @JsonProperty("labelExpr")
    public void setLabelExpr(String value) { this.labelExpr = value; }

    @JsonProperty("labelFont")
    public BackgroundUnion getLabelFont() { return labelFont; }
    @JsonProperty("labelFont")
    public void setLabelFont(BackgroundUnion value) { this.labelFont = value; }

    @JsonProperty("labelFontSize")
    public FontSize getLabelFontSize() { return labelFontSize; }
    @JsonProperty("labelFontSize")
    public void setLabelFontSize(FontSize value) { this.labelFontSize = value; }

    @JsonProperty("labelFontStyle")
    public BackgroundUnion getLabelFontStyle() { return labelFontStyle; }
    @JsonProperty("labelFontStyle")
    public void setLabelFontStyle(BackgroundUnion value) { this.labelFontStyle = value; }

    @JsonProperty("labelFontWeight")
    public FontWeightUnion getLabelFontWeight() { return labelFontWeight; }
    @JsonProperty("labelFontWeight")
    public void setLabelFontWeight(FontWeightUnion value) { this.labelFontWeight = value; }

    @JsonProperty("labelLimit")
    public CornerRadiusUnion getLabelLimit() { return labelLimit; }
    @JsonProperty("labelLimit")
    public void setLabelLimit(CornerRadiusUnion value) { this.labelLimit = value; }

    @JsonProperty("labelOffset")
    public CornerRadiusUnion getLabelOffset() { return labelOffset; }
    @JsonProperty("labelOffset")
    public void setLabelOffset(CornerRadiusUnion value) { this.labelOffset = value; }

    @JsonProperty("labelOpacity")
    public CornerRadiusUnion getLabelOpacity() { return labelOpacity; }
    @JsonProperty("labelOpacity")
    public void setLabelOpacity(CornerRadiusUnion value) { this.labelOpacity = value; }

    @JsonProperty("labelOverlap")
    public LabelOverlap getLabelOverlap() { return labelOverlap; }
    @JsonProperty("labelOverlap")
    public void setLabelOverlap(LabelOverlap value) { this.labelOverlap = value; }

    @JsonProperty("labelPadding")
    public CornerRadiusUnion getLabelPadding() { return labelPadding; }
    @JsonProperty("labelPadding")
    public void setLabelPadding(CornerRadiusUnion value) { this.labelPadding = value; }

    @JsonProperty("labelSeparation")
    public CornerRadiusUnion getLabelSeparation() { return labelSeparation; }
    @JsonProperty("labelSeparation")
    public void setLabelSeparation(CornerRadiusUnion value) { this.labelSeparation = value; }

    @JsonProperty("legendX")
    public CornerRadiusUnion getLegendX() { return legendX; }
    @JsonProperty("legendX")
    public void setLegendX(CornerRadiusUnion value) { this.legendX = value; }

    @JsonProperty("legendY")
    public CornerRadiusUnion getLegendY() { return legendY; }
    @JsonProperty("legendY")
    public void setLegendY(CornerRadiusUnion value) { this.legendY = value; }

    @JsonProperty("offset")
    public CornerRadiusUnion getOffset() { return offset; }
    @JsonProperty("offset")
    public void setOffset(CornerRadiusUnion value) { this.offset = value; }

    /**
     * The orientation of the legend, which determines how the legend is positioned within the
     * scene. One of `"left"`, `"right"`, `"top"`, `"bottom"`, `"top-left"`, `"top-right"`,
     * `"bottom-left"`, `"bottom-right"`, `"none"`.
     *
     * __Default value:__ `"right"`
     */
    @JsonProperty("orient")
    public LegendOrient getOrient() { return orient; }
    @JsonProperty("orient")
    public void setOrient(LegendOrient value) { this.orient = value; }

    @JsonProperty("padding")
    public CornerRadiusUnion getPadding() { return padding; }
    @JsonProperty("padding")
    public void setPadding(CornerRadiusUnion value) { this.padding = value; }

    @JsonProperty("rowPadding")
    public CornerRadiusUnion getRowPadding() { return rowPadding; }
    @JsonProperty("rowPadding")
    public void setRowPadding(CornerRadiusUnion value) { this.rowPadding = value; }

    @JsonProperty("strokeColor")
    public BackgroundUnion getStrokeColor() { return strokeColor; }
    @JsonProperty("strokeColor")
    public void setStrokeColor(BackgroundUnion value) { this.strokeColor = value; }

    @JsonProperty("symbolDash")
    public StrokeDashUnion getSymbolDash() { return symbolDash; }
    @JsonProperty("symbolDash")
    public void setSymbolDash(StrokeDashUnion value) { this.symbolDash = value; }

    @JsonProperty("symbolDashOffset")
    public CornerRadiusUnion getSymbolDashOffset() { return symbolDashOffset; }
    @JsonProperty("symbolDashOffset")
    public void setSymbolDashOffset(CornerRadiusUnion value) { this.symbolDashOffset = value; }

    @JsonProperty("symbolFillColor")
    public BackgroundUnion getSymbolFillColor() { return symbolFillColor; }
    @JsonProperty("symbolFillColor")
    public void setSymbolFillColor(BackgroundUnion value) { this.symbolFillColor = value; }

    @JsonProperty("symbolLimit")
    public CornerRadiusUnion getSymbolLimit() { return symbolLimit; }
    @JsonProperty("symbolLimit")
    public void setSymbolLimit(CornerRadiusUnion value) { this.symbolLimit = value; }

    @JsonProperty("symbolOffset")
    public CornerRadiusUnion getSymbolOffset() { return symbolOffset; }
    @JsonProperty("symbolOffset")
    public void setSymbolOffset(CornerRadiusUnion value) { this.symbolOffset = value; }

    @JsonProperty("symbolOpacity")
    public CornerRadiusUnion getSymbolOpacity() { return symbolOpacity; }
    @JsonProperty("symbolOpacity")
    public void setSymbolOpacity(CornerRadiusUnion value) { this.symbolOpacity = value; }

    @JsonProperty("symbolSize")
    public FontSize getSymbolSize() { return symbolSize; }
    @JsonProperty("symbolSize")
    public void setSymbolSize(FontSize value) { this.symbolSize = value; }

    @JsonProperty("symbolStrokeColor")
    public BackgroundUnion getSymbolStrokeColor() { return symbolStrokeColor; }
    @JsonProperty("symbolStrokeColor")
    public void setSymbolStrokeColor(BackgroundUnion value) { this.symbolStrokeColor = value; }

    @JsonProperty("symbolStrokeWidth")
    public FontSize getSymbolStrokeWidth() { return symbolStrokeWidth; }
    @JsonProperty("symbolStrokeWidth")
    public void setSymbolStrokeWidth(FontSize value) { this.symbolStrokeWidth = value; }

    @JsonProperty("symbolType")
    public BackgroundUnion getSymbolType() { return symbolType; }
    @JsonProperty("symbolType")
    public void setSymbolType(BackgroundUnion value) { this.symbolType = value; }

    @JsonProperty("tickCount")
    public TickCount getTickCount() { return tickCount; }
    @JsonProperty("tickCount")
    public void setTickCount(TickCount value) { this.tickCount = value; }

    /**
     * The minimum desired step between legend ticks, in terms of scale domain values. For
     * example, a value of `1` indicates that ticks should not be less than 1 unit apart. If
     * `tickMinStep` is specified, the `tickCount` value will be adjusted, if necessary, to
     * enforce the minimum step value.
     *
     * __Default value__: `undefined`
     */
    @JsonProperty("tickMinStep")
    public CornerRadiusUnion getTickMinStep() { return tickMinStep; }
    @JsonProperty("tickMinStep")
    public void setTickMinStep(CornerRadiusUnion value) { this.tickMinStep = value; }

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
    public CornerRadiusUnion getTitleFontSize() { return titleFontSize; }
    @JsonProperty("titleFontSize")
    public void setTitleFontSize(CornerRadiusUnion value) { this.titleFontSize = value; }

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

    @JsonProperty("titleOrient")
    public TitleOrientUnion getTitleOrient() { return titleOrient; }
    @JsonProperty("titleOrient")
    public void setTitleOrient(TitleOrientUnion value) { this.titleOrient = value; }

    @JsonProperty("titlePadding")
    public CornerRadiusUnion getTitlePadding() { return titlePadding; }
    @JsonProperty("titlePadding")
    public void setTitlePadding(CornerRadiusUnion value) { this.titlePadding = value; }

    /**
     * The type of the legend. Use `"symbol"` to create a discrete legend and `"gradient"` for a
     * continuous color gradient.
     *
     * __Default value:__ `"gradient"` for non-binned quantitative fields and temporal fields;
     * `"symbol"` otherwise.
     */
    @JsonProperty("type")
    public LegendType getType() { return type; }
    @JsonProperty("type")
    public void setType(LegendType value) { this.type = value; }

    /**
     * Explicitly set the visible legend values.
     */
    @JsonProperty("values")
    public Values getValues() { return values; }
    @JsonProperty("values")
    public void setValues(Values value) { this.values = value; }

    /**
     * A non-negative integer indicating the z-index of the legend. If zindex is 0, legend
     * should be drawn behind all chart elements. To put them in front, use zindex = 1.
     */
    @JsonProperty("zindex")
    public Double getZindex() { return zindex; }
    @JsonProperty("zindex")
    public void setZindex(Double value) { this.zindex = value; }
}
