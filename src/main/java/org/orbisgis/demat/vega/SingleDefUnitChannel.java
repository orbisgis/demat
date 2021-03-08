package org.orbisgis.demat.vega;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

/**
 * The encoding channel to extract selected values for, when a selection is
 * [projected](https://vega.github.io/vega-lite/docs/project.html) over multiple fields or
 * encodings.
 */
public enum SingleDefUnitChannel {
    ANGLE, COLOR, DESCRIPTION, FILL, FILL_OPACITY, HREF, KEY, LATITUDE, LATITUDE2, LONGITUDE, LONGITUDE2, OPACITY, RADIUS, RADIUS2, SHAPE, SIZE, STROKE, STROKE_DASH, STROKE_OPACITY, STROKE_WIDTH, TEXT, THETA, THETA2, URL, X, X2, Y, Y2;

    @JsonValue
    public String toValue() {
        switch (this) {
            case ANGLE: return "angle";
            case COLOR: return "color";
            case DESCRIPTION: return "description";
            case FILL: return "fill";
            case FILL_OPACITY: return "fillOpacity";
            case HREF: return "href";
            case KEY: return "key";
            case LATITUDE: return "latitude";
            case LATITUDE2: return "latitude2";
            case LONGITUDE: return "longitude";
            case LONGITUDE2: return "longitude2";
            case OPACITY: return "opacity";
            case RADIUS: return "radius";
            case RADIUS2: return "radius2";
            case SHAPE: return "shape";
            case SIZE: return "size";
            case STROKE: return "stroke";
            case STROKE_DASH: return "strokeDash";
            case STROKE_OPACITY: return "strokeOpacity";
            case STROKE_WIDTH: return "strokeWidth";
            case TEXT: return "text";
            case THETA: return "theta";
            case THETA2: return "theta2";
            case URL: return "url";
            case X: return "x";
            case X2: return "x2";
            case Y: return "y";
            case Y2: return "y2";
        }
        return null;
    }

    @JsonCreator
    public static SingleDefUnitChannel forValue(String value) throws IOException {
        if (value.equals("angle")) return ANGLE;
        if (value.equals("color")) return COLOR;
        if (value.equals("description")) return DESCRIPTION;
        if (value.equals("fill")) return FILL;
        if (value.equals("fillOpacity")) return FILL_OPACITY;
        if (value.equals("href")) return HREF;
        if (value.equals("key")) return KEY;
        if (value.equals("latitude")) return LATITUDE;
        if (value.equals("latitude2")) return LATITUDE2;
        if (value.equals("longitude")) return LONGITUDE;
        if (value.equals("longitude2")) return LONGITUDE2;
        if (value.equals("opacity")) return OPACITY;
        if (value.equals("radius")) return RADIUS;
        if (value.equals("radius2")) return RADIUS2;
        if (value.equals("shape")) return SHAPE;
        if (value.equals("size")) return SIZE;
        if (value.equals("stroke")) return STROKE;
        if (value.equals("strokeDash")) return STROKE_DASH;
        if (value.equals("strokeOpacity")) return STROKE_OPACITY;
        if (value.equals("strokeWidth")) return STROKE_WIDTH;
        if (value.equals("text")) return TEXT;
        if (value.equals("theta")) return THETA;
        if (value.equals("theta2")) return THETA2;
        if (value.equals("url")) return URL;
        if (value.equals("x")) return X;
        if (value.equals("x2")) return X2;
        if (value.equals("y")) return Y;
        if (value.equals("y2")) return Y2;
        throw new IOException("Cannot deserialize SingleDefUnitChannel");
    }
}
