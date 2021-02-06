package org.orbisgis.demat.v4;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

/**
 * Determines how size calculation should be performed, one of `"content"` or `"padding"`.
 * The default setting (`"content"`) interprets the width and height settings as the data
 * rectangle (plotting) dimensions, to which padding is then added. In contrast, the
 * `"padding"` setting includes the padding within the view size calculations, such that the
 * width and height settings indicate the **total** intended size of the view.
 *
 * __Default value__: `"content"`
 */
public enum Contains {
    CONTENT, PADDING;

    @JsonValue
    public String toValue() {
        switch (this) {
            case CONTENT: return "content";
            case PADDING: return "padding";
        }
        return null;
    }

    @JsonCreator
    public static Contains forValue(String value) throws IOException {
        if (value.equals("content")) return CONTENT;
        if (value.equals("padding")) return PADDING;
        throw new IOException("Cannot deserialize Contains");
    }
}
