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
 * Legend configuration, which determines default properties for all
 * [legends](https://vega.github.io/vega-lite/docs/legend.html). For a full list of legend
 * configuration options, please see the [corresponding section of in the legend
 * documentation](https://vega.github.io/vega-lite/docs/legend.html#config).
 */
public class LegendConfig {
    private Aria aria;
    private CornerRadius clipHeight;
    private CornerRadius columnPadding;
    private CornerRadius columns;
    private CornerRadius cornerRadius;
    private Background description;
    private Orientation direction;
    private Boolean disable;
    private Background fillColor;
    private Direction gradientDirection;
    private Double gradientHorizontalMaxLength;
    private Double gradientHorizontalMinLength;
    private CornerRadius gradientLabelLimit;
    private CornerRadius gradientLabelOffset;
    private FontSize gradientLength;
    private CornerRadius gradientOpacity;
    private Background gradientStrokeColor;
    private FontSize gradientStrokeWidth;
    private FontSize gradientThickness;
    private Double gradientVerticalMaxLength;
    private Double gradientVerticalMinLength;
    private GridAlign gridAlign;
    private TitleAlignUnion labelAlign;
    private Background labelBaseline;
    private Background labelColor;
    private Background labelFont;
    private FontSize labelFontSize;
    private Background labelFontStyle;
    private FontWeightUnion labelFontWeight;
    private CornerRadius labelLimit;
    private CornerRadius labelOffset;
    private CornerRadius labelOpacity;
    private LabelOverlap labelOverlap;
    private CornerRadius labelPadding;
    private CornerRadius labelSeparation;
    private BackgroundExprRef layout;
    private CornerRadius legendX;
    private CornerRadius legendY;
    private CornerRadius offset;
    private LegendOrient orient;
    private CornerRadius padding;
    private CornerRadius rowPadding;
    private Background strokeColor;
    private StrokeDashUnion strokeDash;
    private CornerRadius strokeWidth;
    private Background symbolBaseFillColor;
    private Background symbolBaseStrokeColor;
    private StrokeDashUnion symbolDash;
    private CornerRadius symbolDashOffset;
    private Direction symbolDirection;
    private Background symbolFillColor;
    private CornerRadius symbolLimit;
    private CornerRadius symbolOffset;
    private CornerRadius symbolOpacity;
    private FontSize symbolSize;
    private Background symbolStrokeColor;
    private FontSize symbolStrokeWidth;
    private Background symbolType;
    private TickCount tickCount;
    private Object title;
    private TitleAlignUnion titleAlign;
    private TitleAnchorUnion titleAnchor;
    private Background titleBaseline;
    private Background titleColor;
    private Background titleFont;
    private CornerRadius titleFontSize;
    private Background titleFontStyle;
    private FontWeightUnion titleFontWeight;
    private FontSize titleLimit;
    private CornerRadius titleLineHeight;
    private CornerRadius titleOpacity;
    private TitleOrientUnion titleOrient;
    private CornerRadius titlePadding;
    private Double unselectedOpacity;
    private FontSize zindex;

    @JsonProperty("aria")
    public Aria getAria() { return aria; }
    @JsonProperty("aria")
    public void setAria(Aria value) { this.aria = value; }

    @JsonProperty("clipHeight")
    public CornerRadius getClipHeight() { return clipHeight; }
    @JsonProperty("clipHeight")
    public void setClipHeight(CornerRadius value) { this.clipHeight = value; }

    @JsonProperty("columnPadding")
    public CornerRadius getColumnPadding() { return columnPadding; }
    @JsonProperty("columnPadding")
    public void setColumnPadding(CornerRadius value) { this.columnPadding = value; }

    @JsonProperty("columns")
    public CornerRadius getColumns() { return columns; }
    @JsonProperty("columns")
    public void setColumns(CornerRadius value) { this.columns = value; }

    @JsonProperty("cornerRadius")
    public CornerRadius getCornerRadius() { return cornerRadius; }
    @JsonProperty("cornerRadius")
    public void setCornerRadius(CornerRadius value) { this.cornerRadius = value; }

    @JsonProperty("description")
    public Background getDescription() { return description; }
    @JsonProperty("description")
    public void setDescription(Background value) { this.description = value; }

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
    public Background getFillColor() { return fillColor; }
    @JsonProperty("fillColor")
    public void setFillColor(Background value) { this.fillColor = value; }

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
    public CornerRadius getGradientLabelLimit() { return gradientLabelLimit; }
    @JsonProperty("gradientLabelLimit")
    public void setGradientLabelLimit(CornerRadius value) { this.gradientLabelLimit = value; }

    @JsonProperty("gradientLabelOffset")
    public CornerRadius getGradientLabelOffset() { return gradientLabelOffset; }
    @JsonProperty("gradientLabelOffset")
    public void setGradientLabelOffset(CornerRadius value) { this.gradientLabelOffset = value; }

    @JsonProperty("gradientLength")
    public FontSize getGradientLength() { return gradientLength; }
    @JsonProperty("gradientLength")
    public void setGradientLength(FontSize value) { this.gradientLength = value; }

    @JsonProperty("gradientOpacity")
    public CornerRadius getGradientOpacity() { return gradientOpacity; }
    @JsonProperty("gradientOpacity")
    public void setGradientOpacity(CornerRadius value) { this.gradientOpacity = value; }

    @JsonProperty("gradientStrokeColor")
    public Background getGradientStrokeColor() { return gradientStrokeColor; }
    @JsonProperty("gradientStrokeColor")
    public void setGradientStrokeColor(Background value) { this.gradientStrokeColor = value; }

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
    public Background getLabelBaseline() { return labelBaseline; }
    @JsonProperty("labelBaseline")
    public void setLabelBaseline(Background value) { this.labelBaseline = value; }

    @JsonProperty("labelColor")
    public Background getLabelColor() { return labelColor; }
    @JsonProperty("labelColor")
    public void setLabelColor(Background value) { this.labelColor = value; }

    @JsonProperty("labelFont")
    public Background getLabelFont() { return labelFont; }
    @JsonProperty("labelFont")
    public void setLabelFont(Background value) { this.labelFont = value; }

    @JsonProperty("labelFontSize")
    public FontSize getLabelFontSize() { return labelFontSize; }
    @JsonProperty("labelFontSize")
    public void setLabelFontSize(FontSize value) { this.labelFontSize = value; }

    @JsonProperty("labelFontStyle")
    public Background getLabelFontStyle() { return labelFontStyle; }
    @JsonProperty("labelFontStyle")
    public void setLabelFontStyle(Background value) { this.labelFontStyle = value; }

    @JsonProperty("labelFontWeight")
    public FontWeightUnion getLabelFontWeight() { return labelFontWeight; }
    @JsonProperty("labelFontWeight")
    public void setLabelFontWeight(FontWeightUnion value) { this.labelFontWeight = value; }

    @JsonProperty("labelLimit")
    public CornerRadius getLabelLimit() { return labelLimit; }
    @JsonProperty("labelLimit")
    public void setLabelLimit(CornerRadius value) { this.labelLimit = value; }

    @JsonProperty("labelOffset")
    public CornerRadius getLabelOffset() { return labelOffset; }
    @JsonProperty("labelOffset")
    public void setLabelOffset(CornerRadius value) { this.labelOffset = value; }

    @JsonProperty("labelOpacity")
    public CornerRadius getLabelOpacity() { return labelOpacity; }
    @JsonProperty("labelOpacity")
    public void setLabelOpacity(CornerRadius value) { this.labelOpacity = value; }

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
    public CornerRadius getLabelPadding() { return labelPadding; }
    @JsonProperty("labelPadding")
    public void setLabelPadding(CornerRadius value) { this.labelPadding = value; }

    @JsonProperty("labelSeparation")
    public CornerRadius getLabelSeparation() { return labelSeparation; }
    @JsonProperty("labelSeparation")
    public void setLabelSeparation(CornerRadius value) { this.labelSeparation = value; }

    @JsonProperty("layout")
    public BackgroundExprRef getLayout() { return layout; }
    @JsonProperty("layout")
    public void setLayout(BackgroundExprRef value) { this.layout = value; }

    @JsonProperty("legendX")
    public CornerRadius getLegendX() { return legendX; }
    @JsonProperty("legendX")
    public void setLegendX(CornerRadius value) { this.legendX = value; }

    @JsonProperty("legendY")
    public CornerRadius getLegendY() { return legendY; }
    @JsonProperty("legendY")
    public void setLegendY(CornerRadius value) { this.legendY = value; }

    @JsonProperty("offset")
    public CornerRadius getOffset() { return offset; }
    @JsonProperty("offset")
    public void setOffset(CornerRadius value) { this.offset = value; }

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
    public CornerRadius getPadding() { return padding; }
    @JsonProperty("padding")
    public void setPadding(CornerRadius value) { this.padding = value; }

    @JsonProperty("rowPadding")
    public CornerRadius getRowPadding() { return rowPadding; }
    @JsonProperty("rowPadding")
    public void setRowPadding(CornerRadius value) { this.rowPadding = value; }

    @JsonProperty("strokeColor")
    public Background getStrokeColor() { return strokeColor; }
    @JsonProperty("strokeColor")
    public void setStrokeColor(Background value) { this.strokeColor = value; }

    @JsonProperty("strokeDash")
    public StrokeDashUnion getStrokeDash() { return strokeDash; }
    @JsonProperty("strokeDash")
    public void setStrokeDash(StrokeDashUnion value) { this.strokeDash = value; }

    @JsonProperty("strokeWidth")
    public CornerRadius getStrokeWidth() { return strokeWidth; }
    @JsonProperty("strokeWidth")
    public void setStrokeWidth(CornerRadius value) { this.strokeWidth = value; }

    @JsonProperty("symbolBaseFillColor")
    public Background getSymbolBaseFillColor() { return symbolBaseFillColor; }
    @JsonProperty("symbolBaseFillColor")
    public void setSymbolBaseFillColor(Background value) { this.symbolBaseFillColor = value; }

    @JsonProperty("symbolBaseStrokeColor")
    public Background getSymbolBaseStrokeColor() { return symbolBaseStrokeColor; }
    @JsonProperty("symbolBaseStrokeColor")
    public void setSymbolBaseStrokeColor(Background value) { this.symbolBaseStrokeColor = value; }

    @JsonProperty("symbolDash")
    public StrokeDashUnion getSymbolDash() { return symbolDash; }
    @JsonProperty("symbolDash")
    public void setSymbolDash(StrokeDashUnion value) { this.symbolDash = value; }

    @JsonProperty("symbolDashOffset")
    public CornerRadius getSymbolDashOffset() { return symbolDashOffset; }
    @JsonProperty("symbolDashOffset")
    public void setSymbolDashOffset(CornerRadius value) { this.symbolDashOffset = value; }

    @JsonProperty("symbolDirection")
    public Direction getSymbolDirection() { return symbolDirection; }
    @JsonProperty("symbolDirection")
    public void setSymbolDirection(Direction value) { this.symbolDirection = value; }

    @JsonProperty("symbolFillColor")
    public Background getSymbolFillColor() { return symbolFillColor; }
    @JsonProperty("symbolFillColor")
    public void setSymbolFillColor(Background value) { this.symbolFillColor = value; }

    @JsonProperty("symbolLimit")
    public CornerRadius getSymbolLimit() { return symbolLimit; }
    @JsonProperty("symbolLimit")
    public void setSymbolLimit(CornerRadius value) { this.symbolLimit = value; }

    @JsonProperty("symbolOffset")
    public CornerRadius getSymbolOffset() { return symbolOffset; }
    @JsonProperty("symbolOffset")
    public void setSymbolOffset(CornerRadius value) { this.symbolOffset = value; }

    @JsonProperty("symbolOpacity")
    public CornerRadius getSymbolOpacity() { return symbolOpacity; }
    @JsonProperty("symbolOpacity")
    public void setSymbolOpacity(CornerRadius value) { this.symbolOpacity = value; }

    @JsonProperty("symbolSize")
    public FontSize getSymbolSize() { return symbolSize; }
    @JsonProperty("symbolSize")
    public void setSymbolSize(FontSize value) { this.symbolSize = value; }

    @JsonProperty("symbolStrokeColor")
    public Background getSymbolStrokeColor() { return symbolStrokeColor; }
    @JsonProperty("symbolStrokeColor")
    public void setSymbolStrokeColor(Background value) { this.symbolStrokeColor = value; }

    @JsonProperty("symbolStrokeWidth")
    public FontSize getSymbolStrokeWidth() { return symbolStrokeWidth; }
    @JsonProperty("symbolStrokeWidth")
    public void setSymbolStrokeWidth(FontSize value) { this.symbolStrokeWidth = value; }

    @JsonProperty("symbolType")
    public Background getSymbolType() { return symbolType; }
    @JsonProperty("symbolType")
    public void setSymbolType(Background value) { this.symbolType = value; }

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
    public CornerRadius getTitleFontSize() { return titleFontSize; }
    @JsonProperty("titleFontSize")
    public void setTitleFontSize(CornerRadius value) { this.titleFontSize = value; }

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

    @JsonProperty("titleOrient")
    public TitleOrientUnion getTitleOrient() { return titleOrient; }
    @JsonProperty("titleOrient")
    public void setTitleOrient(TitleOrientUnion value) { this.titleOrient = value; }

    @JsonProperty("titlePadding")
    public CornerRadius getTitlePadding() { return titlePadding; }
    @JsonProperty("titlePadding")
    public void setTitlePadding(CornerRadius value) { this.titlePadding = value; }

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
