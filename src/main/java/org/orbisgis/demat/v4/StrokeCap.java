package org.orbisgis.demat.v4;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

/**
 * The stroke cap for line ending style. One of `"butt"`, `"round"`, or `"square"`.
 *
 * __Default value:__ `"butt"`
 *
 * The stroke cap for the domain line's ending style. One of `"butt"`, `"round"` or
 * `"square"`.
 *
 * __Default value:__ `"butt"`
 *
 * The stroke cap for grid lines' ending style. One of `"butt"`, `"round"` or `"square"`.
 *
 * __Default value:__ `"butt"`
 *
 * The stroke cap for the tick lines' ending style. One of `"butt"`, `"round"` or
 * `"square"`.
 *
 * __Default value:__ `"butt"`
 */
public enum StrokeCap {
    BUTT, ROUND, SQUARE;

    @JsonValue
    public String toValue() {
        switch (this) {
            case BUTT: return "butt";
            case ROUND: return "round";
            case SQUARE: return "square";
        }
        return null;
    }

    @JsonCreator
    public static StrokeCap forValue(String value) throws IOException {
        if (value.equals("butt")) return BUTT;
        if (value.equals("round")) return ROUND;
        if (value.equals("square")) return SQUARE;
        throw new IOException("Cannot deserialize StrokeCap");
    }
}
