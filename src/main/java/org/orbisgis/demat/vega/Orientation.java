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
 * The orientation of a non-stacked bar, tick, area, and line charts. The value is either
 * horizontal (default) or vertical. - For bar, rule and tick, this determines whether the
 * size of the bar and tick should be applied to x or y dimension. - For area, this property
 * determines the orient property of the Vega output. - For line and trail marks, this
 * property determines the sort order of the points in the line if `config.sortLineBy` is
 * not specified. For stacked charts, this is always determined by the orientation of the
 * stack; therefore explicitly specified value will be ignored.
 *
 * The direction of the legend, one of `"vertical"` or `"horizontal"`.
 *
 * __Default value:__ - For top-/bottom-`orient`ed legends, `"horizontal"` - For
 * left-/right-`orient`ed legends, `"vertical"` - For top/bottom-left/right-`orient`ed
 * legends, `"horizontal"` for gradient legends and `"vertical"` for symbol legends.
 *
 * The default direction (`"horizontal"` or `"vertical"`) for gradient legends.
 *
 * __Default value:__ `"vertical"`.
 *
 * The default direction (`"horizontal"` or `"vertical"`) for symbol legends.
 *
 * __Default value:__ `"vertical"`.
 *
 * Orientation of the box plot. This is normally automatically determined based on types of
 * fields on x and y channels. However, an explicit `orient` be specified when the
 * orientation is ambiguous.
 *
 * __Default value:__ `"vertical"`.
 *
 * Orientation of the error bar. This is normally automatically determined, but can be
 * specified when the orientation is ambiguous and cannot be automatically determined.
 *
 * Orientation of the error band. This is normally automatically determined, but can be
 * specified when the orientation is ambiguous and cannot be automatically determined.
 */
public enum Orientation {
    HORIZONTAL, VERTICAL;

    @JsonValue
    public String toValue() {
        switch (this) {
            case HORIZONTAL: return "horizontal";
            case VERTICAL: return "vertical";
        }
        return null;
    }

    @JsonCreator
    public static Orientation forValue(String value) throws IOException {
        if (value.equals("horizontal")) return HORIZONTAL;
        if (value.equals("vertical")) return VERTICAL;
        throw new IOException("Cannot deserialize Orientation");
    }
}
