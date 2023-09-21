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
package org.orbisgis.demat.vega.legend;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.orbisgis.demat.vega.*;

/**
 * Properties of a legend or boolean flag for determining whether to show it.
 */
public class Legend {
    private Aria aria;
    private CornerRadius clipHeight;
    private CornerRadius columnPadding;
    private CornerRadius columns;
    private CornerRadius cornerRadius;
    private Background description;
    private Orientation direction;
    private Background fillColor;
    private Format format;
    private String formatType;
    private FontSize gradientLength;
    private CornerRadius gradientOpacity;
    private Background gradientStrokeColor;
    private FontSize gradientStrokeWidth;
    private FontSize gradientThickness;
    private GridAlign gridAlign;
    private TitleAlignUnion labelAlign;
    private Background labelBaseline;
    private Background labelColor;
    private String labelExpr;
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
    private CornerRadius legendX;
    private CornerRadius legendY;
    private CornerRadius offset;
    private LegendOrient orient;
    private CornerRadius padding;
    private CornerRadius rowPadding;
    private Background strokeColor;
    private StrokeDashUnion symbolDash;
    private CornerRadius symbolDashOffset;
    private Background symbolFillColor;
    private CornerRadius symbolLimit;
    private CornerRadius symbolOffset;
    private CornerRadius symbolOpacity;
    private FontSize symbolSize;
    private Background symbolStrokeColor;
    private FontSize symbolStrokeWidth;
    private Background symbolType;
    private TickCount tickCount;
    private CornerRadius tickMinStep;
    private LegendText title;
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
    private LegendType type;
    private Values values;
    private Double zindex;

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

    @JsonProperty("fillColor")
    public Background getFillColor() { return fillColor; }
    @JsonProperty("fillColor")
    public void setFillColor(Background value) { this.fillColor = value; }

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

    @JsonProperty("symbolDash")
    public StrokeDashUnion getSymbolDash() { return symbolDash; }
    @JsonProperty("symbolDash")
    public void setSymbolDash(StrokeDashUnion value) { this.symbolDash = value; }

    @JsonProperty("symbolDashOffset")
    public CornerRadius getSymbolDashOffset() { return symbolDashOffset; }
    @JsonProperty("symbolDashOffset")
    public void setSymbolDashOffset(CornerRadius value) { this.symbolDashOffset = value; }

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
     * The minimum desired step between legend ticks, in terms of scale domain values. For
     * example, a value of `1` indicates that ticks should not be less than 1 unit apart. If
     * `tickMinStep` is specified, the `tickCount` value will be adjusted, if necessary, to
     * enforce the minimum step value.
     *
     * __Default value__: `undefined`
     */
    @JsonProperty("tickMinStep")
    public CornerRadius getTickMinStep() { return tickMinStep; }
    @JsonProperty("tickMinStep")
    public void setTickMinStep(CornerRadius value) { this.tickMinStep = value; }

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

    /**
     * Add a legend title
     * @param title
     */
    public void setTitle(String title) {
        LegendText legendText = new LegendText();
        legendText.title = title;
        this.setTitle(legendText);
    }

    /**
     * Add a formating rule character
     * @param format
     */
    public void setFormat(String format) {
        Format format_ = new Format();
        format_.stringValue=format;
        this.format =format_;
    }

    public Legend horizontal(){
        this.setDirection(Orientation.HORIZONTAL);
        return this;
    }

    public Legend vertical(){
        this.setDirection(Orientation.VERTICAL);
        return this;
    }

    public Legend gradientLength(Double value){
        FontSize  fs = new FontSize();
        fs.value =value;
        this.setGradientLength(fs);
        return this;
    }
    /**
     * Change the labels of the legend
     * @param labels
     */
    public Legend labels(String labels) {
        this.setLabelExpr(labels);
        return this;
    }
}
