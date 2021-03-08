package org.orbisgis.demat.vega;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

/**
 * The sort order. One of `"ascending"` (default) or `"descending"`.
 *
 * The [encoding channel](https://vega.github.io/vega-lite/docs/encoding.html#channels) to
 * sort by (e.g., `"x"`, `"y"`)
 */
public enum Sort {
    ASCENDING, COLOR, DESCENDING, FILL, FILL_OPACITY, OPACITY, SHAPE, SIZE, SORT_COLOR, SORT_FILL, SORT_FILL_OPACITY, SORT_OPACITY, SORT_SHAPE, SORT_SIZE, SORT_STROKE, SORT_STROKE_OPACITY, SORT_STROKE_WIDTH, SORT_TEXT, SORT_X, SORT_Y, STROKE, STROKE_OPACITY, STROKE_WIDTH, TEXT, X, Y;

    @JsonValue
    public String toValue() {
        switch (this) {
            case ASCENDING: return "ascending";
            case COLOR: return "color";
            case DESCENDING: return "descending";
            case FILL: return "fill";
            case FILL_OPACITY: return "fillOpacity";
            case OPACITY: return "opacity";
            case SHAPE: return "shape";
            case SIZE: return "size";
            case SORT_COLOR: return "-color";
            case SORT_FILL: return "-fill";
            case SORT_FILL_OPACITY: return "-fillOpacity";
            case SORT_OPACITY: return "-opacity";
            case SORT_SHAPE: return "-shape";
            case SORT_SIZE: return "-size";
            case SORT_STROKE: return "-stroke";
            case SORT_STROKE_OPACITY: return "-strokeOpacity";
            case SORT_STROKE_WIDTH: return "-strokeWidth";
            case SORT_TEXT: return "-text";
            case SORT_X: return "-x";
            case SORT_Y: return "-y";
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
    public static Sort forValue(String value) throws IOException {
        if (value.equals("ascending")) return ASCENDING;
        if (value.equals("color")) return COLOR;
        if (value.equals("descending")) return DESCENDING;
        if (value.equals("fill")) return FILL;
        if (value.equals("fillOpacity")) return FILL_OPACITY;
        if (value.equals("opacity")) return OPACITY;
        if (value.equals("shape")) return SHAPE;
        if (value.equals("size")) return SIZE;
        if (value.equals("-color")) return SORT_COLOR;
        if (value.equals("-fill")) return SORT_FILL;
        if (value.equals("-fillOpacity")) return SORT_FILL_OPACITY;
        if (value.equals("-opacity")) return SORT_OPACITY;
        if (value.equals("-shape")) return SORT_SHAPE;
        if (value.equals("-size")) return SORT_SIZE;
        if (value.equals("-stroke")) return SORT_STROKE;
        if (value.equals("-strokeOpacity")) return SORT_STROKE_OPACITY;
        if (value.equals("-strokeWidth")) return SORT_STROKE_WIDTH;
        if (value.equals("-text")) return SORT_TEXT;
        if (value.equals("-x")) return SORT_X;
        if (value.equals("-y")) return SORT_Y;
        if (value.equals("stroke")) return STROKE;
        if (value.equals("strokeOpacity")) return STROKE_OPACITY;
        if (value.equals("strokeWidth")) return STROKE_WIDTH;
        if (value.equals("text")) return TEXT;
        if (value.equals("x")) return X;
        if (value.equals("y")) return Y;
        throw new IOException("Cannot deserialize Sort");
    }
}
