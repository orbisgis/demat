package org.orbisgis.demat.vega;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

/**
 * By default, `all` data values are considered to lie within an empty selection. When set
 * to `none`, empty selections contain no data values.
 */
public enum Empty {
    ALL, NONE;

    @JsonValue
    public String toValue() {
        switch (this) {
            case ALL: return "all";
            case NONE: return "none";
        }
        return null;
    }

    @JsonCreator
    public static Empty forValue(String value) throws IOException {
        if (value.equals("all")) return ALL;
        if (value.equals("none")) return NONE;
        throw new IOException("Cannot deserialize Empty");
    }
}
