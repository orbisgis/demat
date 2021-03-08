package org.orbisgis.demat.vega;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

/**
 * Default title orientation (`"top"`, `"bottom"`, `"left"`, or `"right"`)
 */
public enum TitleOrient {
    BOTTOM, LEFT, NONE, RIGHT, TOP;

    @JsonValue
    public String toValue() {
        switch (this) {
            case BOTTOM: return "bottom";
            case LEFT: return "left";
            case NONE: return "none";
            case RIGHT: return "right";
            case TOP: return "top";
        }
        return null;
    }

    @JsonCreator
    public static TitleOrient forValue(String value) throws IOException {
        if (value.equals("bottom")) return BOTTOM;
        if (value.equals("left")) return LEFT;
        if (value.equals("none")) return NONE;
        if (value.equals("right")) return RIGHT;
        if (value.equals("top")) return TOP;
        throw new IOException("Cannot deserialize TitleOrient");
    }
}
