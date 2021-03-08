package org.orbisgis.demat.vega;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum ExprRefType {
    CUBEHELIX, CUBEHELIX_LONG, RGB;

    @JsonValue
    public String toValue() {
        switch (this) {
            case CUBEHELIX: return "cubehelix";
            case CUBEHELIX_LONG: return "cubehelix-long";
            case RGB: return "rgb";
        }
        return null;
    }

    @JsonCreator
    public static ExprRefType forValue(String value) throws IOException {
        if (value.equals("cubehelix")) return CUBEHELIX;
        if (value.equals("cubehelix-long")) return CUBEHELIX_LONG;
        if (value.equals("rgb")) return RGB;
        throw new IOException("Cannot deserialize ExprRefType");
    }
}
