package org.orbisgis.demat.vega;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

/**
 * The orientation of the legend, which determines how the legend is positioned within the
 * scene. One of `"left"`, `"right"`, `"top"`, `"bottom"`, `"top-left"`, `"top-right"`,
 * `"bottom-left"`, `"bottom-right"`, `"none"`.
 *
 * __Default value:__ `"right"`
 */
public enum LegendOrient {
    BOTTOM, BOTTOM_LEFT, BOTTOM_RIGHT, LEFT, NONE, RIGHT, TOP, TOP_LEFT, TOP_RIGHT;

    @JsonValue
    public String toValue() {
        switch (this) {
            case BOTTOM: return "bottom";
            case BOTTOM_LEFT: return "bottom-left";
            case BOTTOM_RIGHT: return "bottom-right";
            case LEFT: return "left";
            case NONE: return "none";
            case RIGHT: return "right";
            case TOP: return "top";
            case TOP_LEFT: return "top-left";
            case TOP_RIGHT: return "top-right";
        }
        return null;
    }

    @JsonCreator
    public static LegendOrient forValue(String value) throws IOException {
        if (value.equals("bottom")) return BOTTOM;
        if (value.equals("bottom-left")) return BOTTOM_LEFT;
        if (value.equals("bottom-right")) return BOTTOM_RIGHT;
        if (value.equals("left")) return LEFT;
        if (value.equals("none")) return NONE;
        if (value.equals("right")) return RIGHT;
        if (value.equals("top")) return TOP;
        if (value.equals("top-left")) return TOP_LEFT;
        if (value.equals("top-right")) return TOP_RIGHT;
        throw new IOException("Cannot deserialize LegendOrient");
    }
}
