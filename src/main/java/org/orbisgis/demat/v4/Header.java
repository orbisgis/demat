package org.orbisgis.demat.v4;

import com.fasterxml.jackson.annotation.*;

/**
 * An object defining properties of a facet's header.
 *
 * Headers of row / column channels for faceted plots.
 */
public class Header {
    private Format format;
    private String formatType;
    private TitleAlignUnion labelAlign;
    private TitleAnchorEnum labelAnchor;
    private Double labelAngle;
    private BackgroundUnion labelBaseline;
    private BackgroundUnion labelColor;
    private String labelExpr;
    private BackgroundUnion labelFont;
    private CornerRadiusUnion labelFontSize;
    private BackgroundUnion labelFontStyle;
    private FontWeightUnion labelFontWeight;
    private CornerRadiusUnion labelLimit;
    private CornerRadiusUnion labelLineHeight;
    private Orient labelOrient;
    private CornerRadiusUnion labelPadding;
    private Boolean labels;
    private Orient orient;
    private LegendText title;
    private TitleAlignUnion titleAlign;
    private TitleAnchorEnum titleAnchor;
    private Double titleAngle;
    private BackgroundUnion titleBaseline;
    private BackgroundUnion titleColor;
    private BackgroundUnion titleFont;
    private CornerRadiusUnion titleFontSize;
    private BackgroundUnion titleFontStyle;
    private FontWeightUnion titleFontWeight;
    private CornerRadiusUnion titleLimit;
    private CornerRadiusUnion titleLineHeight;
    private Orient titleOrient;
    private CornerRadiusUnion titlePadding;

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
     * Horizontal text alignment of header labels. One of `"left"`, `"center"`, or `"right"`.
     */
    @JsonProperty("labelAlign")
    public TitleAlignUnion getLabelAlign() { return labelAlign; }
    @JsonProperty("labelAlign")
    public void setLabelAlign(TitleAlignUnion value) { this.labelAlign = value; }

    /**
     * The anchor position for placing the labels. One of `"start"`, `"middle"`, or `"end"`. For
     * example, with a label orientation of top these anchor positions map to a left-, center-,
     * or right-aligned label.
     */
    @JsonProperty("labelAnchor")
    public TitleAnchorEnum getLabelAnchor() { return labelAnchor; }
    @JsonProperty("labelAnchor")
    public void setLabelAnchor(TitleAnchorEnum value) { this.labelAnchor = value; }

    /**
     * The rotation angle of the header labels.
     *
     * __Default value:__ `0` for column header, `-90` for row header.
     */
    @JsonProperty("labelAngle")
    public Double getLabelAngle() { return labelAngle; }
    @JsonProperty("labelAngle")
    public void setLabelAngle(Double value) { this.labelAngle = value; }

    /**
     * The vertical text baseline for the header labels. One of `"alphabetic"` (default),
     * `"top"`, `"middle"`, `"bottom"`, `"line-top"`, or `"line-bottom"`. The `"line-top"` and
     * `"line-bottom"` values operate similarly to `"top"` and `"bottom"`, but are calculated
     * relative to the `titleLineHeight` rather than `titleFontSize` alone.
     */
    @JsonProperty("labelBaseline")
    public BackgroundUnion getLabelBaseline() { return labelBaseline; }
    @JsonProperty("labelBaseline")
    public void setLabelBaseline(BackgroundUnion value) { this.labelBaseline = value; }

    /**
     * The color of the header label, can be in hex color code or regular color name.
     */
    @JsonProperty("labelColor")
    public BackgroundUnion getLabelColor() { return labelColor; }
    @JsonProperty("labelColor")
    public void setLabelColor(BackgroundUnion value) { this.labelColor = value; }

    /**
     * [Vega expression](https://vega.github.io/vega/docs/expressions/) for customizing labels.
     *
     * __Note:__ The label text and value can be assessed via the `label` and `value` properties
     * of the header's backing `datum` object.
     */
    @JsonProperty("labelExpr")
    public String getLabelExpr() { return labelExpr; }
    @JsonProperty("labelExpr")
    public void setLabelExpr(String value) { this.labelExpr = value; }

    /**
     * The font of the header label.
     */
    @JsonProperty("labelFont")
    public BackgroundUnion getLabelFont() { return labelFont; }
    @JsonProperty("labelFont")
    public void setLabelFont(BackgroundUnion value) { this.labelFont = value; }

    /**
     * The font size of the header label, in pixels.
     */
    @JsonProperty("labelFontSize")
    public CornerRadiusUnion getLabelFontSize() { return labelFontSize; }
    @JsonProperty("labelFontSize")
    public void setLabelFontSize(CornerRadiusUnion value) { this.labelFontSize = value; }

    /**
     * The font style of the header label.
     */
    @JsonProperty("labelFontStyle")
    public BackgroundUnion getLabelFontStyle() { return labelFontStyle; }
    @JsonProperty("labelFontStyle")
    public void setLabelFontStyle(BackgroundUnion value) { this.labelFontStyle = value; }

    /**
     * The font weight of the header label.
     */
    @JsonProperty("labelFontWeight")
    public FontWeightUnion getLabelFontWeight() { return labelFontWeight; }
    @JsonProperty("labelFontWeight")
    public void setLabelFontWeight(FontWeightUnion value) { this.labelFontWeight = value; }

    /**
     * The maximum length of the header label in pixels. The text value will be automatically
     * truncated if the rendered size exceeds the limit.
     *
     * __Default value:__ `0`, indicating no limit
     */
    @JsonProperty("labelLimit")
    public CornerRadiusUnion getLabelLimit() { return labelLimit; }
    @JsonProperty("labelLimit")
    public void setLabelLimit(CornerRadiusUnion value) { this.labelLimit = value; }

    /**
     * Line height in pixels for multi-line header labels or title text with `"line-top"` or
     * `"line-bottom"` baseline.
     */
    @JsonProperty("labelLineHeight")
    public CornerRadiusUnion getLabelLineHeight() { return labelLineHeight; }
    @JsonProperty("labelLineHeight")
    public void setLabelLineHeight(CornerRadiusUnion value) { this.labelLineHeight = value; }

    /**
     * The orientation of the header label. One of `"top"`, `"bottom"`, `"left"` or `"right"`.
     */
    @JsonProperty("labelOrient")
    public Orient getLabelOrient() { return labelOrient; }
    @JsonProperty("labelOrient")
    public void setLabelOrient(Orient value) { this.labelOrient = value; }

    /**
     * The padding, in pixel, between facet header's label and the plot.
     *
     * __Default value:__ `10`
     */
    @JsonProperty("labelPadding")
    public CornerRadiusUnion getLabelPadding() { return labelPadding; }
    @JsonProperty("labelPadding")
    public void setLabelPadding(CornerRadiusUnion value) { this.labelPadding = value; }

    /**
     * A boolean flag indicating if labels should be included as part of the header.
     *
     * __Default value:__ `true`.
     */
    @JsonProperty("labels")
    public Boolean getLabels() { return labels; }
    @JsonProperty("labels")
    public void setLabels(Boolean value) { this.labels = value; }

    /**
     * Shortcut for setting both labelOrient and titleOrient.
     */
    @JsonProperty("orient")
    public Orient getOrient() { return orient; }
    @JsonProperty("orient")
    public void setOrient(Orient value) { this.orient = value; }

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

    /**
     * Horizontal text alignment (to the anchor) of header titles.
     */
    @JsonProperty("titleAlign")
    public TitleAlignUnion getTitleAlign() { return titleAlign; }
    @JsonProperty("titleAlign")
    public void setTitleAlign(TitleAlignUnion value) { this.titleAlign = value; }

    /**
     * The anchor position for placing the title. One of `"start"`, `"middle"`, or `"end"`. For
     * example, with an orientation of top these anchor positions map to a left-, center-, or
     * right-aligned title.
     */
    @JsonProperty("titleAnchor")
    public TitleAnchorEnum getTitleAnchor() { return titleAnchor; }
    @JsonProperty("titleAnchor")
    public void setTitleAnchor(TitleAnchorEnum value) { this.titleAnchor = value; }

    /**
     * The rotation angle of the header title.
     *
     * __Default value:__ `0`.
     */
    @JsonProperty("titleAngle")
    public Double getTitleAngle() { return titleAngle; }
    @JsonProperty("titleAngle")
    public void setTitleAngle(Double value) { this.titleAngle = value; }

    /**
     * The vertical text baseline for the header title. One of `"alphabetic"` (default),
     * `"top"`, `"middle"`, `"bottom"`, `"line-top"`, or `"line-bottom"`. The `"line-top"` and
     * `"line-bottom"` values operate similarly to `"top"` and `"bottom"`, but are calculated
     * relative to the `titleLineHeight` rather than `titleFontSize` alone.
     *
     * __Default value:__ `"middle"`
     */
    @JsonProperty("titleBaseline")
    public BackgroundUnion getTitleBaseline() { return titleBaseline; }
    @JsonProperty("titleBaseline")
    public void setTitleBaseline(BackgroundUnion value) { this.titleBaseline = value; }

    /**
     * Color of the header title, can be in hex color code or regular color name.
     */
    @JsonProperty("titleColor")
    public BackgroundUnion getTitleColor() { return titleColor; }
    @JsonProperty("titleColor")
    public void setTitleColor(BackgroundUnion value) { this.titleColor = value; }

    /**
     * Font of the header title. (e.g., `"Helvetica Neue"`).
     */
    @JsonProperty("titleFont")
    public BackgroundUnion getTitleFont() { return titleFont; }
    @JsonProperty("titleFont")
    public void setTitleFont(BackgroundUnion value) { this.titleFont = value; }

    /**
     * Font size of the header title.
     */
    @JsonProperty("titleFontSize")
    public CornerRadiusUnion getTitleFontSize() { return titleFontSize; }
    @JsonProperty("titleFontSize")
    public void setTitleFontSize(CornerRadiusUnion value) { this.titleFontSize = value; }

    /**
     * The font style of the header title.
     */
    @JsonProperty("titleFontStyle")
    public BackgroundUnion getTitleFontStyle() { return titleFontStyle; }
    @JsonProperty("titleFontStyle")
    public void setTitleFontStyle(BackgroundUnion value) { this.titleFontStyle = value; }

    /**
     * Font weight of the header title. This can be either a string (e.g `"bold"`, `"normal"`)
     * or a number (`100`, `200`, `300`, ..., `900` where `"normal"` = `400` and `"bold"` =
     * `700`).
     */
    @JsonProperty("titleFontWeight")
    public FontWeightUnion getTitleFontWeight() { return titleFontWeight; }
    @JsonProperty("titleFontWeight")
    public void setTitleFontWeight(FontWeightUnion value) { this.titleFontWeight = value; }

    /**
     * The maximum length of the header title in pixels. The text value will be automatically
     * truncated if the rendered size exceeds the limit.
     *
     * __Default value:__ `0`, indicating no limit
     */
    @JsonProperty("titleLimit")
    public CornerRadiusUnion getTitleLimit() { return titleLimit; }
    @JsonProperty("titleLimit")
    public void setTitleLimit(CornerRadiusUnion value) { this.titleLimit = value; }

    /**
     * Line height in pixels for multi-line header title text or title text with `"line-top"` or
     * `"line-bottom"` baseline.
     */
    @JsonProperty("titleLineHeight")
    public CornerRadiusUnion getTitleLineHeight() { return titleLineHeight; }
    @JsonProperty("titleLineHeight")
    public void setTitleLineHeight(CornerRadiusUnion value) { this.titleLineHeight = value; }

    /**
     * The orientation of the header title. One of `"top"`, `"bottom"`, `"left"` or `"right"`.
     */
    @JsonProperty("titleOrient")
    public Orient getTitleOrient() { return titleOrient; }
    @JsonProperty("titleOrient")
    public void setTitleOrient(Orient value) { this.titleOrient = value; }

    /**
     * The padding, in pixel, between facet header's title and the label.
     *
     * __Default value:__ `10`
     */
    @JsonProperty("titlePadding")
    public CornerRadiusUnion getTitlePadding() { return titlePadding; }
    @JsonProperty("titlePadding")
    public void setTitlePadding(CornerRadiusUnion value) { this.titlePadding = value; }
}
