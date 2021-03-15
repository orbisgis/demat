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
