package org.orbisgis.demat.vega;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum BlendEnum {
    COLOR, COLOR_BURN, COLOR_DODGE, DARKEN, DIFFERENCE, EXCLUSION, HARD_LIGHT, HUE, LIGHTEN, LUMINOSITY, MULTIPLY, OVERLAY, SATURATION, SCREEN, SOFT_LIGHT;

    @JsonValue
    public String toValue() {
        switch (this) {
            case COLOR: return "color";
            case COLOR_BURN: return "color-burn";
            case COLOR_DODGE: return "color-dodge";
            case DARKEN: return "darken";
            case DIFFERENCE: return "difference";
            case EXCLUSION: return "exclusion";
            case HARD_LIGHT: return "hard-light";
            case HUE: return "hue";
            case LIGHTEN: return "lighten";
            case LUMINOSITY: return "luminosity";
            case MULTIPLY: return "multiply";
            case OVERLAY: return "overlay";
            case SATURATION: return "saturation";
            case SCREEN: return "screen";
            case SOFT_LIGHT: return "soft-light";
        }
        return null;
    }

    @JsonCreator
    public static BlendEnum forValue(String value) throws IOException {
        if (value.equals("color")) return COLOR;
        if (value.equals("color-burn")) return COLOR_BURN;
        if (value.equals("color-dodge")) return COLOR_DODGE;
        if (value.equals("darken")) return DARKEN;
        if (value.equals("difference")) return DIFFERENCE;
        if (value.equals("exclusion")) return EXCLUSION;
        if (value.equals("hard-light")) return HARD_LIGHT;
        if (value.equals("hue")) return HUE;
        if (value.equals("lighten")) return LIGHTEN;
        if (value.equals("luminosity")) return LUMINOSITY;
        if (value.equals("multiply")) return MULTIPLY;
        if (value.equals("overlay")) return OVERLAY;
        if (value.equals("saturation")) return SATURATION;
        if (value.equals("screen")) return SCREEN;
        if (value.equals("soft-light")) return SOFT_LIGHT;
        throw new IOException("Cannot deserialize BlendEnum");
    }
}
