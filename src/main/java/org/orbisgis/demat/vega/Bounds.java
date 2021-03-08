package org.orbisgis.demat.vega;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

/**
 * The bounds calculation method to use for determining the extent of a sub-plot. One of
 * `full` (the default) or `flush`.
 *
 * - If set to `full`, the entire calculated bounds (including axes, title, and legend) will
 * be used. - If set to `flush`, only the specified width and height values for the sub-view
 * will be used. The `flush` setting can be useful when attempting to place sub-plots
 * without axes or legends into a uniform grid structure.
 *
 * __Default value:__ `"full"`
 */
public enum Bounds {
    FLUSH, FULL;

    @JsonValue
    public String toValue() {
        switch (this) {
            case FLUSH: return "flush";
            case FULL: return "full";
        }
        return null;
    }

    @JsonCreator
    public static Bounds forValue(String value) throws IOException {
        if (value.equals("flush")) return FLUSH;
        if (value.equals("full")) return FULL;
        throw new IOException("Cannot deserialize Bounds");
    }
}
