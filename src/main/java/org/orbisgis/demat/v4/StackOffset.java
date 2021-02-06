package org.orbisgis.demat.v4;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

/**
 * Mode for stacking marks. One of `"zero"` (default), `"center"`, or `"normalize"`. The
 * `"zero"` offset will stack starting at `0`. The `"center"` offset will center the stacks.
 * The `"normalize"` offset will compute percentage values for each stack point, with output
 * values in the range `[0,1]`.
 *
 * __Default value:__ `"zero"`
 */
public enum StackOffset {
    CENTER, NORMALIZE, ZERO;

    @JsonValue
    public String toValue() {
        switch (this) {
            case CENTER: return "center";
            case NORMALIZE: return "normalize";
            case ZERO: return "zero";
        }
        return null;
    }

    @JsonCreator
    public static StackOffset forValue(String value) throws IOException {
        if (value.equals("center")) return CENTER;
        if (value.equals("normalize")) return NORMALIZE;
        if (value.equals("zero")) return ZERO;
        throw new IOException("Cannot deserialize StackOffset");
    }
}
