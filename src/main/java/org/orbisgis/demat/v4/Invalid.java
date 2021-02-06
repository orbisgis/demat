package org.orbisgis.demat.v4;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum Invalid {
    FILTER;

    @JsonValue
    public String toValue() {
        switch (this) {
            case FILTER: return "filter";
        }
        return null;
    }

    @JsonCreator
    public static Invalid forValue(String value) throws IOException {
        if (value.equals("filter")) return FILTER;
        throw new IOException("Cannot deserialize Invalid");
    }
}
