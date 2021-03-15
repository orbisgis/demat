/*
 * DEMAT is java wrapper on top of the vega-lite library
 *
 * Demat is breton word to said "Hello".
 *
 * DEMAT is part of the OrbisGIS platform.
 *
 * OrbisGIS platform is a set of open source tools to access, process, display
 * and share geographical informations.
 *
 * It is leaded by CNRS within the French Lab-STICC laboratory <http://www.lab-sticc.fr/>,
 * DECIDE team of Vannes.
 *
 * OrbisGIS is dedicated to research in GIScience.
 *
 * The GIS group of the DECIDE team is located at :
 *
 * Laboratoire Lab-STICC – CNRS UMR 6285
 * Equipe DECIDE
 * UNIVERSITÉ DE BRETAGNE-SUD
 * Institut Universitaire de Technologie de Vannes
 * 8, Rue Montaigne - BP 561 56017 Vannes Cedex
 *
 * DEMAT is distributed under LGPL 3 license.
 *
 * Copyright (C) 2021 CNRS (Lab-STICC UMR CNRS 6285)
 *
 *
 * DEMAT is free software: you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * DEMAT is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * DEMAT. If not, see <http://www.gnu.org/licenses/>.
 *
 * For more information, please consult: <http://www.orbisgis.org/>
 * or contact directly:
 * info_at_ orbisgis.org
 */
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
