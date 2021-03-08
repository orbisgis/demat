package org.orbisgis.demat.vega;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

/**
 * The stroke line join method. One of `"miter"`, `"round"` or `"bevel"`.
 *
 * __Default value:__ `"miter"`
 */
public enum StrokeJoin {
    BEVEL, MITER, ROUND;

    @JsonValue
    public String toValue() {
        switch (this) {
            case BEVEL: return "bevel";
            case MITER: return "miter";
            case ROUND: return "round";
        }
        return null;
    }

    @JsonCreator
    public static StrokeJoin forValue(String value) throws IOException {
        if (value.equals("bevel")) return BEVEL;
        if (value.equals("miter")) return MITER;
        if (value.equals("round")) return ROUND;
        throw new IOException("Cannot deserialize StrokeJoin");
    }
}
