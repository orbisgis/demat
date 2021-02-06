package org.orbisgis.demat.v4;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum ResolveMode {
    INDEPENDENT, SHARED;

    @JsonValue
    public String toValue() {
        switch (this) {
            case INDEPENDENT: return "independent";
            case SHARED: return "shared";
        }
        return null;
    }

    @JsonCreator
    public static ResolveMode forValue(String value) throws IOException {
        if (value.equals("independent")) return INDEPENDENT;
        if (value.equals("shared")) return SHARED;
        throw new IOException("Cannot deserialize ResolveMode");
    }
}
