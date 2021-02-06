package org.orbisgis.demat.v4;

import com.fasterxml.jackson.annotation.*;

/**
 * Title configuration, which determines default properties for all
 * [titles](https://vega.github.io/vega-lite/docs/title.html). For a full list of title
 * configuration options, please see the [corresponding section of the title
 * documentation](https://vega.github.io/vega-lite/docs/title.html#config).
 */
public class BaseTitleNoValueRefs {
    private Align align;
    private TitleAnchorUnion anchor;
    private CornerRadiusUnion angle;
    private Aria aria;
    private String baseline;
    private BackgroundUnion color;
    private CornerRadiusUnion dx;
    private CornerRadiusUnion dy;
    private BackgroundUnion font;
    private FontSize fontSize;
    private BackgroundUnion fontStyle;
    private FontWeightUnion fontWeight;
    private BackgroundUnion frame;
    private FontSize limit;
    private CornerRadiusUnion lineHeight;
    private CornerRadiusUnion offset;
    private TitleParamsOrient orient;
    private BackgroundUnion subtitleColor;
    private BackgroundUnion subtitleFont;
    private FontSize subtitleFontSize;
    private BackgroundUnion subtitleFontStyle;
    private FontWeightUnion subtitleFontWeight;
    private CornerRadiusUnion subtitleLineHeight;
    private CornerRadiusUnion subtitlePadding;
    private FontSize zindex;

    /**
     * Horizontal text alignment for title text. One of `"left"`, `"center"`, or `"right"`.
     */
    @JsonProperty("align")
    public Align getAlign() { return align; }
    @JsonProperty("align")
    public void setAlign(Align value) { this.align = value; }

    @JsonProperty("anchor")
    public TitleAnchorUnion getAnchor() { return anchor; }
    @JsonProperty("anchor")
    public void setAnchor(TitleAnchorUnion value) { this.anchor = value; }

    @JsonProperty("angle")
    public CornerRadiusUnion getAngle() { return angle; }
    @JsonProperty("angle")
    public void setAngle(CornerRadiusUnion value) { this.angle = value; }

    @JsonProperty("aria")
    public Aria getAria() { return aria; }
    @JsonProperty("aria")
    public void setAria(Aria value) { this.aria = value; }

    /**
     * Vertical text baseline for title and subtitle text. One of `"alphabetic"` (default),
     * `"top"`, `"middle"`, `"bottom"`, `"line-top"`, or `"line-bottom"`. The `"line-top"` and
     * `"line-bottom"` values operate similarly to `"top"` and `"bottom"`, but are calculated
     * relative to the *lineHeight* rather than *fontSize* alone.
     */
    @JsonProperty("baseline")
    public String getBaseline() { return baseline; }
    @JsonProperty("baseline")
    public void setBaseline(String value) { this.baseline = value; }

    @JsonProperty("color")
    public BackgroundUnion getColor() { return color; }
    @JsonProperty("color")
    public void setColor(BackgroundUnion value) { this.color = value; }

    @JsonProperty("dx")
    public CornerRadiusUnion getDx() { return dx; }
    @JsonProperty("dx")
    public void setDx(CornerRadiusUnion value) { this.dx = value; }

    @JsonProperty("dy")
    public CornerRadiusUnion getDy() { return dy; }
    @JsonProperty("dy")
    public void setDy(CornerRadiusUnion value) { this.dy = value; }

    @JsonProperty("font")
    public BackgroundUnion getFont() { return font; }
    @JsonProperty("font")
    public void setFont(BackgroundUnion value) { this.font = value; }

    @JsonProperty("fontSize")
    public FontSize getFontSize() { return fontSize; }
    @JsonProperty("fontSize")
    public void setFontSize(FontSize value) { this.fontSize = value; }

    @JsonProperty("fontStyle")
    public BackgroundUnion getFontStyle() { return fontStyle; }
    @JsonProperty("fontStyle")
    public void setFontStyle(BackgroundUnion value) { this.fontStyle = value; }

    @JsonProperty("fontWeight")
    public FontWeightUnion getFontWeight() { return fontWeight; }
    @JsonProperty("fontWeight")
    public void setFontWeight(FontWeightUnion value) { this.fontWeight = value; }

    @JsonProperty("frame")
    public BackgroundUnion getFrame() { return frame; }
    @JsonProperty("frame")
    public void setFrame(BackgroundUnion value) { this.frame = value; }

    @JsonProperty("limit")
    public FontSize getLimit() { return limit; }
    @JsonProperty("limit")
    public void setLimit(FontSize value) { this.limit = value; }

    @JsonProperty("lineHeight")
    public CornerRadiusUnion getLineHeight() { return lineHeight; }
    @JsonProperty("lineHeight")
    public void setLineHeight(CornerRadiusUnion value) { this.lineHeight = value; }

    @JsonProperty("offset")
    public CornerRadiusUnion getOffset() { return offset; }
    @JsonProperty("offset")
    public void setOffset(CornerRadiusUnion value) { this.offset = value; }

    @JsonProperty("orient")
    public TitleParamsOrient getOrient() { return orient; }
    @JsonProperty("orient")
    public void setOrient(TitleParamsOrient value) { this.orient = value; }

    @JsonProperty("subtitleColor")
    public BackgroundUnion getSubtitleColor() { return subtitleColor; }
    @JsonProperty("subtitleColor")
    public void setSubtitleColor(BackgroundUnion value) { this.subtitleColor = value; }

    @JsonProperty("subtitleFont")
    public BackgroundUnion getSubtitleFont() { return subtitleFont; }
    @JsonProperty("subtitleFont")
    public void setSubtitleFont(BackgroundUnion value) { this.subtitleFont = value; }

    @JsonProperty("subtitleFontSize")
    public FontSize getSubtitleFontSize() { return subtitleFontSize; }
    @JsonProperty("subtitleFontSize")
    public void setSubtitleFontSize(FontSize value) { this.subtitleFontSize = value; }

    @JsonProperty("subtitleFontStyle")
    public BackgroundUnion getSubtitleFontStyle() { return subtitleFontStyle; }
    @JsonProperty("subtitleFontStyle")
    public void setSubtitleFontStyle(BackgroundUnion value) { this.subtitleFontStyle = value; }

    @JsonProperty("subtitleFontWeight")
    public FontWeightUnion getSubtitleFontWeight() { return subtitleFontWeight; }
    @JsonProperty("subtitleFontWeight")
    public void setSubtitleFontWeight(FontWeightUnion value) { this.subtitleFontWeight = value; }

    @JsonProperty("subtitleLineHeight")
    public CornerRadiusUnion getSubtitleLineHeight() { return subtitleLineHeight; }
    @JsonProperty("subtitleLineHeight")
    public void setSubtitleLineHeight(CornerRadiusUnion value) { this.subtitleLineHeight = value; }

    @JsonProperty("subtitlePadding")
    public CornerRadiusUnion getSubtitlePadding() { return subtitlePadding; }
    @JsonProperty("subtitlePadding")
    public void setSubtitlePadding(CornerRadiusUnion value) { this.subtitlePadding = value; }

    @JsonProperty("zindex")
    public FontSize getZindex() { return zindex; }
    @JsonProperty("zindex")
    public void setZindex(FontSize value) { this.zindex = value; }
}
