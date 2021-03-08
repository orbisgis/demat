package org.orbisgis.demat.vega;

import com.fasterxml.jackson.annotation.*;

public class AutoSizeParams {
    private Contains contains;
    private Boolean resize;
    private AutosizeType type;

    /**
     * Determines how size calculation should be performed, one of `"content"` or `"padding"`.
     * The default setting (`"content"`) interprets the width and height settings as the data
     * rectangle (plotting) dimensions, to which padding is then added. In contrast, the
     * `"padding"` setting includes the padding within the view size calculations, such that the
     * width and height settings indicate the **total** intended size of the view.
     *
     * __Default value__: `"content"`
     */
    @JsonProperty("contains")
    public Contains getContains() { return contains; }
    @JsonProperty("contains")
    public void setContains(Contains value) { this.contains = value; }

    /**
     * A boolean flag indicating if autosize layout should be re-calculated on every view
     * update.
     *
     * __Default value__: `false`
     */
    @JsonProperty("resize")
    public Boolean getResize() { return resize; }
    @JsonProperty("resize")
    public void setResize(Boolean value) { this.resize = value; }

    /**
     * The sizing format type. One of `"pad"`, `"fit"`, `"fit-x"`, `"fit-y"`,  or `"none"`. See
     * the [autosize type](https://vega.github.io/vega-lite/docs/size.html#autosize)
     * documentation for descriptions of each.
     *
     * __Default value__: `"pad"`
     */
    @JsonProperty("type")
    public AutosizeType getType() { return type; }
    @JsonProperty("type")
    public void setType(AutosizeType value) { this.type = value; }
}
