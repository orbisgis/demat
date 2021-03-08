package org.orbisgis.demat.vega;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

/**
 * The alignment to apply to symbol legends rows and columns. The supported string values
 * are `"all"`, `"each"` (the default), and `none`. For more information, see the [grid
 * layout documentation](https://vega.github.io/vega/docs/layout).
 *
 * __Default value:__ `"each"`.
 *
 * The alignment to apply to row/column facet's subplot. The supported string values are
 * `"all"`, `"each"`, and `"none"`.
 *
 * - For `"none"`, a flow layout will be used, in which adjacent subviews are simply placed
 * one after the other. - For `"each"`, subviews will be aligned into a clean grid
 * structure, but each row or column may be of variable size. - For `"all"`, subviews will
 * be aligned and each row or column will be sized identically based on the maximum observed
 * size. String values for this property will be applied to both grid rows and columns.
 *
 * __Default value:__ `"all"`.
 */
public enum LayoutAlign {
    ALL, EACH, NONE;

    @JsonValue
    public String toValue() {
        switch (this) {
            case ALL: return "all";
            case EACH: return "each";
            case NONE: return "none";
        }
        return null;
    }

    @JsonCreator
    public static LayoutAlign forValue(String value) throws IOException {
        if (value.equals("all")) return ALL;
        if (value.equals("each")) return EACH;
        if (value.equals("none")) return NONE;
        throw new IOException("Cannot deserialize LayoutAlign");
    }
}
