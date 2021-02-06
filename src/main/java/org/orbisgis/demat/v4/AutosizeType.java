package org.orbisgis.demat.v4;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

/**
 * The sizing format type. One of `"pad"`, `"fit"`, `"fit-x"`, `"fit-y"`,  or `"none"`. See
 * the [autosize type](https://vega.github.io/vega-lite/docs/size.html#autosize)
 * documentation for descriptions of each.
 *
 * __Default value__: `"pad"`
 */
public enum AutosizeType {
    FIT, FIT_X, FIT_Y, NONE, PAD;

    @JsonValue
    public String toValue() {
        switch (this) {
            case FIT: return "fit";
            case FIT_X: return "fit-x";
            case FIT_Y: return "fit-y";
            case NONE: return "none";
            case PAD: return "pad";
        }
        return null;
    }

    @JsonCreator
    public static AutosizeType forValue(String value) throws IOException {
        if (value.equals("fit")) return FIT;
        if (value.equals("fit-x")) return FIT_X;
        if (value.equals("fit-y")) return FIT_Y;
        if (value.equals("none")) return NONE;
        if (value.equals("pad")) return PAD;
        throw new IOException("Cannot deserialize AutosizeType");
    }
}
