package org.orbisgis.demat.vega;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum RepeatEnum {
    COLUMN, LAYER, REPEAT, ROW;

    @JsonValue
    public String toValue() {
        switch (this) {
            case COLUMN: return "column";
            case LAYER: return "layer";
            case REPEAT: return "repeat";
            case ROW: return "row";
        }
        return null;
    }

    @JsonCreator
    public static RepeatEnum forValue(String value) throws IOException {
        if (value.equals("column")) return COLUMN;
        if (value.equals("layer")) return LAYER;
        if (value.equals("repeat")) return REPEAT;
        if (value.equals("row")) return ROW;
        throw new IOException("Cannot deserialize RepeatEnum");
    }
}
