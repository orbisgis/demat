package org.orbisgis.demat.v4;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

/**
 * The orientation of the header label. One of `"top"`, `"bottom"`, `"left"` or `"right"`.
 *
 * Shortcut for setting both labelOrient and titleOrient.
 *
 * The orientation of the header title. One of `"top"`, `"bottom"`, `"left"` or `"right"`.
 *
 * Orientation of the legend title.
 */
public enum Orient {
    BOTTOM, LEFT, RIGHT, TOP;

    @JsonValue
    public String toValue() {
        switch (this) {
            case BOTTOM: return "bottom";
            case LEFT: return "left";
            case RIGHT: return "right";
            case TOP: return "top";
        }
        return null;
    }

    @JsonCreator
    public static Orient forValue(String value) throws IOException {
        if (value.equals("bottom")) return BOTTOM;
        if (value.equals("left")) return LEFT;
        if (value.equals("right")) return RIGHT;
        if (value.equals("top")) return TOP;
        throw new IOException("Cannot deserialize Orient");
    }
}
