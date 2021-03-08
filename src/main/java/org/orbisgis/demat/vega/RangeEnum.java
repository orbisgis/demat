package org.orbisgis.demat.vega;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum RangeEnum {
    CATEGORY, DIVERGING, HEATMAP, HEIGHT, ORDINAL, RAMP, SYMBOL, WIDTH;

    @JsonValue
    public String toValue() {
        switch (this) {
            case CATEGORY: return "category";
            case DIVERGING: return "diverging";
            case HEATMAP: return "heatmap";
            case HEIGHT: return "height";
            case ORDINAL: return "ordinal";
            case RAMP: return "ramp";
            case SYMBOL: return "symbol";
            case WIDTH: return "width";
        }
        return null;
    }

    @JsonCreator
    public static RangeEnum forValue(String value) throws IOException {
        if (value.equals("category")) return CATEGORY;
        if (value.equals("diverging")) return DIVERGING;
        if (value.equals("heatmap")) return HEATMAP;
        if (value.equals("height")) return HEIGHT;
        if (value.equals("ordinal")) return ORDINAL;
        if (value.equals("ramp")) return RAMP;
        if (value.equals("symbol")) return SYMBOL;
        if (value.equals("width")) return WIDTH;
        throw new IOException("Cannot deserialize RangeEnum");
    }
}
