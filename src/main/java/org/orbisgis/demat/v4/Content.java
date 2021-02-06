package org.orbisgis.demat.v4;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum Content {
    DATA, ENCODING;

    @JsonValue
    public String toValue() {
        switch (this) {
            case DATA: return "data";
            case ENCODING: return "encoding";
        }
        return null;
    }

    @JsonCreator
    public static Content forValue(String value) throws IOException {
        if (value.equals("data")) return DATA;
        if (value.equals("encoding")) return ENCODING;
        throw new IOException("Cannot deserialize Content");
    }
}
