package org.orbisgis.demat.v4;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

/**
 * The [encoding channel](https://vega.github.io/vega-lite/docs/encoding.html#channels) to
 * sort by (e.g., `"x"`, `"y"`)
 */
public enum SortByChannel {
    COLOR, FILL, FILL_OPACITY, OPACITY, SHAPE, SIZE, STROKE, STROKE_OPACITY, STROKE_WIDTH, TEXT, X, Y;

    @JsonValue
    public String toValue() {
        switch (this) {
            case COLOR: return "color";
            case FILL: return "fill";
            case FILL_OPACITY: return "fillOpacity";
            case OPACITY: return "opacity";
            case SHAPE: return "shape";
            case SIZE: return "size";
            case STROKE: return "stroke";
            case STROKE_OPACITY: return "strokeOpacity";
            case STROKE_WIDTH: return "strokeWidth";
            case TEXT: return "text";
            case X: return "x";
            case Y: return "y";
        }
        return null;
    }

    @JsonCreator
    public static SortByChannel forValue(String value) throws IOException {
        if (value.equals("color")) return COLOR;
        if (value.equals("fill")) return FILL;
        if (value.equals("fillOpacity")) return FILL_OPACITY;
        if (value.equals("opacity")) return OPACITY;
        if (value.equals("shape")) return SHAPE;
        if (value.equals("size")) return SIZE;
        if (value.equals("stroke")) return STROKE;
        if (value.equals("strokeOpacity")) return STROKE_OPACITY;
        if (value.equals("strokeWidth")) return STROKE_WIDTH;
        if (value.equals("text")) return TEXT;
        if (value.equals("x")) return X;
        if (value.equals("y")) return Y;
        throw new IOException("Cannot deserialize SortByChannel");
    }
}
