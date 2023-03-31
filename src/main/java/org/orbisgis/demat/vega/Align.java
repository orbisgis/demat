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
 * Horizontal text alignment of axis tick labels, overriding the default setting for the
 * current axis orientation.
 *
 * Horizontal text alignment of axis titles.
 *
 * The alignment of the legend label, can be left, center, or right.
 *
 * Horizontal text alignment for legend titles.
 *
 * __Default value:__ `"left"`.
 *
 * The horizontal alignment of the text or ranged marks (area, bar, image, rect, rule). One
 * of `"left"`, `"right"`, `"center"`.
 *
 * __Note:__ Expression reference is *not* supported for range marks.
 *
 * Horizontal text alignment for title text. One of `"left"`, `"center"`, or `"right"`.
 *
 * @author Erwan Bocher, CNRS 2021 - 2023
 */
public enum Align {
    CENTER, LEFT, RIGHT;

    @JsonValue
    public String toValue() {
        switch (this) {
            case CENTER: return "center";
            case LEFT: return "left";
            case RIGHT: return "right";
        }
        return null;
    }

    @JsonCreator
    public static Align forValue(String value) throws IOException {
        if (value.equals("center")) return CENTER;
        if (value.equals("left")) return LEFT;
        if (value.equals("right")) return RIGHT;
        throw new IOException("Cannot deserialize Align");
    }
}
