package org.orbisgis.demat.v4;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

/**
 * Defines how Vega-Lite generates title for fields. There are three possible styles: -
 * `"verbal"` (Default) - displays function in a verbal style (e.g., "Sum of field",
 * "Year-month of date", "field (binned)"). - `"function"` - displays function using
 * parentheses and capitalized texts (e.g., "SUM(field)", "YEARMONTH(date)", "BIN(field)").
 * - `"plain"` - displays only the field name without functions (e.g., "field", "date",
 * "field").
 */
public enum FieldTitle {
    FUNCTIONAL, PLAIN, VERBAL;

    @JsonValue
    public String toValue() {
        switch (this) {
            case FUNCTIONAL: return "functional";
            case PLAIN: return "plain";
            case VERBAL: return "verbal";
        }
        return null;
    }

    @JsonCreator
    public static FieldTitle forValue(String value) throws IOException {
        if (value.equals("functional")) return FUNCTIONAL;
        if (value.equals("plain")) return PLAIN;
        if (value.equals("verbal")) return VERBAL;
        throw new IOException("Cannot deserialize FieldTitle");
    }
}
