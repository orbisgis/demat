package org.orbisgis.demat.vega;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum MarkType {
    ARC, AREA, GROUP, IMAGE, LINE, PATH, RECT, RULE, SHAPE, SYMBOL, TEXT, TRAIL;

    @JsonValue
    public String toValue() {
        switch (this) {
            case ARC: return "arc";
            case AREA: return "area";
            case GROUP: return "group";
            case IMAGE: return "image";
            case LINE: return "line";
            case PATH: return "path";
            case RECT: return "rect";
            case RULE: return "rule";
            case SHAPE: return "shape";
            case SYMBOL: return "symbol";
            case TEXT: return "text";
            case TRAIL: return "trail";
        }
        return null;
    }

    @JsonCreator
    public static MarkType forValue(String value) throws IOException {
        if (value.equals("arc")) return ARC;
        if (value.equals("area")) return AREA;
        if (value.equals("group")) return GROUP;
        if (value.equals("image")) return IMAGE;
        if (value.equals("line")) return LINE;
        if (value.equals("path")) return PATH;
        if (value.equals("rect")) return RECT;
        if (value.equals("rule")) return RULE;
        if (value.equals("shape")) return SHAPE;
        if (value.equals("symbol")) return SYMBOL;
        if (value.equals("text")) return TEXT;
        if (value.equals("trail")) return TRAIL;
        throw new IOException("Cannot deserialize MarkType");
    }
}
