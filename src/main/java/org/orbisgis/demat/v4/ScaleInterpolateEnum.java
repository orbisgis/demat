package org.orbisgis.demat.v4;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum ScaleInterpolateEnum {
    CUBEHELIX, CUBEHELIX_LONG, HCL, HCL_LONG, HSL, HSL_LONG, LAB, RGB;

    @JsonValue
    public String toValue() {
        switch (this) {
            case CUBEHELIX: return "cubehelix";
            case CUBEHELIX_LONG: return "cubehelix-long";
            case HCL: return "hcl";
            case HCL_LONG: return "hcl-long";
            case HSL: return "hsl";
            case HSL_LONG: return "hsl-long";
            case LAB: return "lab";
            case RGB: return "rgb";
        }
        return null;
    }

    @JsonCreator
    public static ScaleInterpolateEnum forValue(String value) throws IOException {
        if (value.equals("cubehelix")) return CUBEHELIX;
        if (value.equals("cubehelix-long")) return CUBEHELIX_LONG;
        if (value.equals("hcl")) return HCL;
        if (value.equals("hcl-long")) return HCL_LONG;
        if (value.equals("hsl")) return HSL;
        if (value.equals("hsl-long")) return HSL_LONG;
        if (value.equals("lab")) return LAB;
        if (value.equals("rgb")) return RGB;
        throw new IOException("Cannot deserialize ScaleInterpolateEnum");
    }
}
