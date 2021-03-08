package org.orbisgis.demat.vega;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

/**
 * For band scales, indicates if ticks and grid lines should be placed at the `"center"` of
 * a band (default) or at the band `"extent"`s to indicate intervals
 */
public enum TickBandEnum {
    CENTER, EXTENT;

    @JsonValue
    public String toValue() {
        switch (this) {
            case CENTER: return "center";
            case EXTENT: return "extent";
        }
        return null;
    }

    @JsonCreator
    public static TickBandEnum forValue(String value) throws IOException {
        if (value.equals("center")) return CENTER;
        if (value.equals("extent")) return EXTENT;
        throw new IOException("Cannot deserialize TickBandEnum");
    }
}
