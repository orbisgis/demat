package org.orbisgis.demat.vega;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

/**
 * The sort order. One of `"ascending"` (default) or `"descending"`.
 */
public enum SortOrder {
    ASCENDING, DESCENDING;

    @JsonValue
    public String toValue() {
        switch (this) {
            case ASCENDING: return "ascending";
            case DESCENDING: return "descending";
        }
        return null;
    }

    @JsonCreator
    public static SortOrder forValue(String value) throws IOException {
        if (value.equals("ascending")) return ASCENDING;
        if (value.equals("descending")) return DESCENDING;
        throw new IOException("Cannot deserialize SortOrder");
    }
}
