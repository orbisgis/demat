package org.orbisgis.demat.v4;

import com.fasterxml.jackson.annotation.*;

/**
 * Legend configuration, which determines default properties for all
 * [legends](https://vega.github.io/vega-lite/docs/legend.html). For a full list of legend
 * configuration options, please see the [corresponding section of in the legend
 * documentation](https://vega.github.io/vega-lite/docs/legend.html#config).
 */
public class LegendConfig {
    private Aria aria;
    private CornerRadiusUnion clipHeight;
    private CornerRadiusUnion columnPadding;
    private CornerRadiusUnion columns;
    private CornerRadiusUnion cornerRadius;
    private BackgroundUnion description;
    private Orientation direction;
    private Boolean disable;
    private BackgroundUnion fillColor;
    private Direction gradientDirection;
    private Double gradientHorizontalMaxLength;
    private Double gradientHorizontalMinLength;
    private CornerRadiusUnion gradientLabelLimit;
    private CornerRadiusUnion gradientLabelOffset;
    private FontSize gradientLength;
    private CornerRadiusUnion gradientOpacity;
    private BackgroundUnion gradientStrokeColor;
    private FontSize gradientStrokeWidth;
    private FontSize gradientThickness;
    private Double gradientVerticalMaxLength;
    private Double gradientVerticalMinLength;
    private GridAlign gridAlign;
    private TitleAlignUnion labelAlign;
    private BackgroundUnion labelBaseline;
    private BackgroundUnion labelColor;
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
    private BackgroundExprRef layout;
    private CornerRadiusUnion legendX;
    private CornerRadiusUnion legendY;
    private CornerRadiusUnion offset;
    private LegendOrient orient;
    private CornerRadiusUnion padding;
    private CornerRadiusUnion rowPadding;
    private BackgroundUnion strokeColor;
    private StrokeDashUnion strokeDash;
    private CornerRadiusUnion strokeWidth;
    private BackgroundUnion symbolBaseFillColor;
    private BackgroundUnion symbolBaseStrokeColor;
    private StrokeDashUnion symbolDash;
    private CornerRadiusUnion symbolDashOffset;
    private Direction symbolDirection;
    private BackgroundUnion symbolFillColor;
    private CornerRadiusUnion symbolLimit;
    private CornerRadiusUnion symbolOffset;
    private CornerRadiusUnion symbolOpacity;
    private FontSize symbolSize;
    private BackgroundUnion symbolStrokeColor;
    private FontSize symbolStrokeWidth;
    private BackgroundUnion symbolType;
    private TickCount tickCount;
    private Object title;
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
    private Double unselectedOpacity;
    private FontSize zindex;

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

    /**
     * Disable legend by default
     */
    @JsonProperty("disable")
    public Boolean getDisable() { return disable; }
    @JsonProperty("disable")
    public void setDisable(Boolean value) { this.disable = value; }

    @JsonProperty("fillColor")
    public BackgroundUnion getFillColor() { return fillColor; }
    @JsonProperty("fillColor")
    public void setFillColor(BackgroundUnion value) { this.fillColor = value; }

    @JsonProperty("gradientDirection")
    public Direction getGradientDirection() { return gradientDirection; }
    @JsonProperty("gradientDirection")
    public void setGradientDirection(Direction value) { this.gradientDirection = value; }

    /**
     * Max legend length for a horizontal gradient when `config.legend.gradientLength` is
     * undefined.
     *
     * __Default value:__ `200`
     */
    @JsonProperty("gradientHorizontalMaxLength")
    public Double getGradientHorizontalMaxLength() { return gradientHorizontalMaxLength; }
    @JsonProperty("gradientHorizontalMaxLength")
    public void setGradientHorizontalMaxLength(Double value) { this.gradientHorizontalMaxLength = value; }

    /**
     * Min legend length for a horizontal gradient when `config.legend.gradientLength` is
     * undefined.
     *
     * __Default value:__ `100`
     */
    @JsonProperty("gradientHorizontalMinLength")
    public Double getGradientHorizontalMinLength() { return gradientHorizontalMinLength; }
    @JsonProperty("gradientHorizontalMinLength")
    public void setGradientHorizontalMinLength(Double value) { this.gradientHorizontalMinLength = value; }

    @JsonProperty("gradientLabelLimit")
    public CornerRadiusUnion getGradientLabelLimit() { return gradientLabelLimit; }
    @JsonProperty("gradientLabelLimit")
    public void setGradientLabelLimit(CornerRadiusUnion value) { this.gradientLabelLimit = value; }

    @JsonProperty("gradientLabelOffset")
    public CornerRadiusUnion getGradientLabelOffset() { return gradientLabelOffset; }
    @JsonProperty("gradientLabelOffset")
    public void setGradientLabelOffset(CornerRadiusUnion value) { this.gradientLabelOffset = value; }

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

    /**
     * Max legend length for a vertical gradient when `config.legend.gradientLength` is
     * undefined.
     *
     * __Default value:__ `200`
     */
    @JsonProperty("gradientVerticalMaxLength")
    public Double getGradientVerticalMaxLength() { return gradientVerticalMaxLength; }
    @JsonProperty("gradientVerticalMaxLength")
    public void setGradientVerticalMaxLength(Double value) { this.gradientVerticalMaxLength = value; }

    /**
     * Min legend length for a vertical gradient when `config.legend.gradientLength` is
     * undefined.
     *
     * __Default value:__ `100`
     */
    @JsonProperty("gradientVerticalMinLength")
    public Double getGradientVerticalMinLength() { return gradientVerticalMinLength; }
    @JsonProperty("gradientVerticalMinLength")
    public void setGradientVerticalMinLength(Double value) { this.gradientVerticalMinLength = value; }

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

    /**
     * The strategy to use for resolving overlap of labels in gradient legends. If `false`, no
     * overlap reduction is attempted. If set to `true` or `"parity"`, a strategy of removing
     * every other label is used. If set to `"greedy"`, a linear scan of the labels is
     * performed, removing any label that overlaps with the last visible label (this often works
     * better for log-scaled axes).
     *
     * __Default value:__ `"greedy"` for `log scales otherwise `true`.
     */
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

    @JsonProperty("layout")
    public BackgroundExprRef getLayout() { return layout; }
    @JsonProperty("layout")
    public void setLayout(BackgroundExprRef value) { this.layout = value; }

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

    @JsonProperty("strokeDash")
    public StrokeDashUnion getStrokeDash() { return strokeDash; }
    @JsonProperty("strokeDash")
    public void setStrokeDash(StrokeDashUnion value) { this.strokeDash = value; }

    @JsonProperty("strokeWidth")
    public CornerRadiusUnion getStrokeWidth() { return strokeWidth; }
    @JsonProperty("strokeWidth")
    public void setStrokeWidth(CornerRadiusUnion value) { this.strokeWidth = value; }

    @JsonProperty("symbolBaseFillColor")
    public BackgroundUnion getSymbolBaseFillColor() { return symbolBaseFillColor; }
    @JsonProperty("symbolBaseFillColor")
    public void setSymbolBaseFillColor(BackgroundUnion value) { this.symbolBaseFillColor = value; }

    @JsonProperty("symbolBaseStrokeColor")
    public BackgroundUnion getSymbolBaseStrokeColor() { return symbolBaseStrokeColor; }
    @JsonProperty("symbolBaseStrokeColor")
    public void setSymbolBaseStrokeColor(BackgroundUnion value) { this.symbolBaseStrokeColor = value; }

    @JsonProperty("symbolDash")
    public StrokeDashUnion getSymbolDash() { return symbolDash; }
    @JsonProperty("symbolDash")
    public void setSymbolDash(StrokeDashUnion value) { this.symbolDash = value; }

    @JsonProperty("symbolDashOffset")
    public CornerRadiusUnion getSymbolDashOffset() { return symbolDashOffset; }
    @JsonProperty("symbolDashOffset")
    public void setSymbolDashOffset(CornerRadiusUnion value) { this.symbolDashOffset = value; }

    @JsonProperty("symbolDirection")
    public Direction getSymbolDirection() { return symbolDirection; }
    @JsonProperty("symbolDirection")
    public void setSymbolDirection(Direction value) { this.symbolDirection = value; }

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
     * Set to null to disable title for the axis, legend, or header.
     */
    @JsonProperty("title")
    public Object getTitle() { return title; }
    @JsonProperty("title")
    public void setTitle(Object value) { this.title = value; }

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
     * The opacity of unselected legend entries.
     *
     * __Default value:__ 0.35.
     */
    @JsonProperty("unselectedOpacity")
    public Double getUnselectedOpacity() { return unselectedOpacity; }
    @JsonProperty("unselectedOpacity")
    public void setUnselectedOpacity(Double value) { this.unselectedOpacity = value; }

    @JsonProperty("zindex")
    public FontSize getZindex() { return zindex; }
    @JsonProperty("zindex")
    public void setZindex(FontSize value) { this.zindex = value; }
}
