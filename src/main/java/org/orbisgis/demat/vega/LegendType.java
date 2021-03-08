package org.orbisgis.demat.vega;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

/**
 * The type of the legend. Use `"symbol"` to create a discrete legend and `"gradient"` for a
 * continuous color gradient.
 *
 * __Default value:__ `"gradient"` for non-binned quantitative fields and temporal fields;
 * `"symbol"` otherwise.
 */
public enum LegendType {
    GRADIENT, SYMBOL;

    @JsonValue
    public String toValue() {
        switch (this) {
            case GRADIENT: return "gradient";
            case SYMBOL: return "symbol";
        }
        return null;
    }

    @JsonCreator
    public static LegendType forValue(String value) throws IOException {
        if (value.equals("gradient")) return GRADIENT;
        if (value.equals("symbol")) return SYMBOL;
        throw new IOException("Cannot deserialize LegendType");
    }
}
