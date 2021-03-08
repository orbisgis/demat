package org.orbisgis.demat.vega;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

/**
 * With layered and multi-view displays, a strategy that determines how selections' data
 * queries are resolved when applied in a filter transform, conditional encoding rule, or
 * scale domain.
 *
 * __See also:__ [`resolve`](https://vega.github.io/vega-lite/docs/selection-resolve.html)
 * documentation.
 */
public enum SelectionResolution {
    GLOBAL, INTERSECT, UNION;

    @JsonValue
    public String toValue() {
        switch (this) {
            case GLOBAL: return "global";
            case INTERSECT: return "intersect";
            case UNION: return "union";
        }
        return null;
    }

    @JsonCreator
    public static SelectionResolution forValue(String value) throws IOException {
        if (value.equals("global")) return GLOBAL;
        if (value.equals("intersect")) return INTERSECT;
        if (value.equals("union")) return UNION;
        throw new IOException("Cannot deserialize SelectionResolution");
    }
}
