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
package org.orbisgis.demat.vega.legend;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.io.IOException;

/**
 * The orientation of the legend, which determines how the legend is positioned within the
 * scene. One of `"left"`, `"right"`, `"top"`, `"bottom"`, `"top-left"`, `"top-right"`,
 * `"bottom-left"`, `"bottom-right"`, `"none"`.
 * <p>
 * __Default value:__ `"right"`
 */
public enum LegendOrient {
    BOTTOM, BOTTOM_LEFT, BOTTOM_RIGHT, LEFT, NONE, RIGHT, TOP, TOP_LEFT, TOP_RIGHT;

    @JsonValue
    public String toValue() {
        switch (this) {
            case BOTTOM: return "bottom";
            case BOTTOM_LEFT: return "bottom-left";
            case BOTTOM_RIGHT: return "bottom-right";
            case LEFT: return "left";
            case NONE: return "none";
            case RIGHT: return "right";
            case TOP: return "top";
            case TOP_LEFT: return "top-left";
            case TOP_RIGHT: return "top-right";
        }
        return null;
    }

    @JsonCreator
    public static LegendOrient forValue(String value) throws IOException {
        if (value.equals("bottom")) return BOTTOM;
        if (value.equals("bottom-left")) return BOTTOM_LEFT;
        if (value.equals("bottom-right")) return BOTTOM_RIGHT;
        if (value.equals("left")) return LEFT;
        if (value.equals("none")) return NONE;
        if (value.equals("right")) return RIGHT;
        if (value.equals("top")) return TOP;
        if (value.equals("top-left")) return TOP_LEFT;
        if (value.equals("top-right")) return TOP_RIGHT;
        throw new IOException("Cannot deserialize LegendOrient");
    }
}
