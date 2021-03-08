package org.orbisgis.demat.vega;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

/**
 * The direction of the text. One of `"ltr"` (left-to-right) or `"rtl"` (right-to-left).
 * This property determines on which side is truncated in response to the limit parameter.
 *
 * __Default value:__ `"ltr"`
 */
public enum TextDirection {
    LTR, RTL;

    @JsonValue
    public String toValue() {
        switch (this) {
            case LTR: return "ltr";
            case RTL: return "rtl";
        }
        return null;
    }

    @JsonCreator
    public static TextDirection forValue(String value) throws IOException {
        if (value.equals("ltr")) return LTR;
        if (value.equals("rtl")) return RTL;
        throw new IOException("Cannot deserialize TextDirection");
    }
}
