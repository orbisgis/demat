package org.orbisgis.demat.v4;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum TitleAnchorEnum {
    END, MIDDLE, START;

    @JsonValue
    public String toValue() {
        switch (this) {
            case END: return "end";
            case MIDDLE: return "middle";
            case START: return "start";
        }
        return null;
    }

    @JsonCreator
    public static TitleAnchorEnum forValue(String value) throws IOException {
        if (value.equals("end")) return END;
        if (value.equals("middle")) return MIDDLE;
        if (value.equals("start")) return START;
        throw new IOException("Cannot deserialize TitleAnchorEnum");
    }
}
