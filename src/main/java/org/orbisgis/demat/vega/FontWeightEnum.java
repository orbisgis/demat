package org.orbisgis.demat.vega;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum FontWeightEnum {
    BOLD, BOLDER, LIGHTER, NORMAL;

    @JsonValue
    public String toValue() {
        switch (this) {
            case BOLD: return "bold";
            case BOLDER: return "bolder";
            case LIGHTER: return "lighter";
            case NORMAL: return "normal";
        }
        return null;
    }

    @JsonCreator
    public static FontWeightEnum forValue(String value) throws IOException {
        if (value.equals("bold")) return BOLD;
        if (value.equals("bolder")) return BOLDER;
        if (value.equals("lighter")) return LIGHTER;
        if (value.equals("normal")) return NORMAL;
        throw new IOException("Cannot deserialize FontWeightEnum");
    }
}
