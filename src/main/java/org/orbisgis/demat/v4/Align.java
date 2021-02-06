package org.orbisgis.demat.v4;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

/**
 * Horizontal text alignment of axis tick labels, overriding the default setting for the
 * current axis orientation.
 *
 * Horizontal text alignment of axis titles.
 *
 * The alignment of the legend label, can be left, center, or right.
 *
 * Horizontal text alignment for legend titles.
 *
 * __Default value:__ `"left"`.
 *
 * The horizontal alignment of the text or ranged marks (area, bar, image, rect, rule). One
 * of `"left"`, `"right"`, `"center"`.
 *
 * __Note:__ Expression reference is *not* supported for range marks.
 *
 * Horizontal text alignment for title text. One of `"left"`, `"center"`, or `"right"`.
 */
public enum Align {
    CENTER, LEFT, RIGHT;

    @JsonValue
    public String toValue() {
        switch (this) {
            case CENTER: return "center";
            case LEFT: return "left";
            case RIGHT: return "right";
        }
        return null;
    }

    @JsonCreator
    public static Align forValue(String value) throws IOException {
        if (value.equals("center")) return CENTER;
        if (value.equals("left")) return LEFT;
        if (value.equals("right")) return RIGHT;
        throw new IOException("Cannot deserialize Align");
    }
}
