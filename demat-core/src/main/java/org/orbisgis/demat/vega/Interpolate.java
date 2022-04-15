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
 * The line interpolation method to use for line and area marks. One of the following: -
 * `"linear"`: piecewise linear segments, as in a polyline. - `"linear-closed"`: close the
 * linear segments to form a polygon. - `"step"`: alternate between horizontal and vertical
 * segments, as in a step function. - `"step-before"`: alternate between vertical and
 * horizontal segments, as in a step function. - `"step-after"`: alternate between
 * horizontal and vertical segments, as in a step function. - `"basis"`: a B-spline, with
 * control point duplication on the ends. - `"basis-open"`: an open B-spline; may not
 * intersect the start or end. - `"basis-closed"`: a closed B-spline, as in a loop. -
 * `"cardinal"`: a Cardinal spline, with control point duplication on the ends. -
 * `"cardinal-open"`: an open Cardinal spline; may not intersect the start or end, but will
 * intersect other control points. - `"cardinal-closed"`: a closed Cardinal spline, as in a
 * loop. - `"bundle"`: equivalent to basis, except the tension parameter is used to
 * straighten the spline. - `"monotone"`: cubic interpolation that preserves monotonicity in
 * y.
 *
 * The line interpolation method for the error band. One of the following: - `"linear"`:
 * piecewise linear segments, as in a polyline. - `"linear-closed"`: close the linear
 * segments to form a polygon. - `"step"`: a piecewise constant function (a step function)
 * consisting of alternating horizontal and vertical lines. The y-value changes at the
 * midpoint of each pair of adjacent x-values. - `"step-before"`: a piecewise constant
 * function (a step function) consisting of alternating horizontal and vertical lines. The
 * y-value changes before the x-value. - `"step-after"`: a piecewise constant function (a
 * step function) consisting of alternating horizontal and vertical lines. The y-value
 * changes after the x-value. - `"basis"`: a B-spline, with control point duplication on the
 * ends. - `"basis-open"`: an open B-spline; may not intersect the start or end. -
 * `"basis-closed"`: a closed B-spline, as in a loop. - `"cardinal"`: a Cardinal spline,
 * with control point duplication on the ends. - `"cardinal-open"`: an open Cardinal spline;
 * may not intersect the start or end, but will intersect other control points. -
 * `"cardinal-closed"`: a closed Cardinal spline, as in a loop. - `"bundle"`: equivalent to
 * basis, except the tension parameter is used to straighten the spline. - `"monotone"`:
 * cubic interpolation that preserves monotonicity in y.
 */
public enum Interpolate {
    BASIS, BASIS_CLOSED, BASIS_OPEN, BUNDLE, CARDINAL, CARDINAL_CLOSED, CARDINAL_OPEN, CATMULL_ROM, LINEAR, LINEAR_CLOSED, MONOTONE, NATURAL, STEP, STEP_AFTER, STEP_BEFORE;

    @JsonValue
    public String toValue() {
        switch (this) {
            case BASIS: return "basis";
            case BASIS_CLOSED: return "basis-closed";
            case BASIS_OPEN: return "basis-open";
            case BUNDLE: return "bundle";
            case CARDINAL: return "cardinal";
            case CARDINAL_CLOSED: return "cardinal-closed";
            case CARDINAL_OPEN: return "cardinal-open";
            case CATMULL_ROM: return "catmull-rom";
            case LINEAR: return "linear";
            case LINEAR_CLOSED: return "linear-closed";
            case MONOTONE: return "monotone";
            case NATURAL: return "natural";
            case STEP: return "step";
            case STEP_AFTER: return "step-after";
            case STEP_BEFORE: return "step-before";
        }
        return null;
    }

    @JsonCreator
    public static Interpolate forValue(String value) throws IOException {
        if (value.equals("basis")) return BASIS;
        if (value.equals("basis-closed")) return BASIS_CLOSED;
        if (value.equals("basis-open")) return BASIS_OPEN;
        if (value.equals("bundle")) return BUNDLE;
        if (value.equals("cardinal")) return CARDINAL;
        if (value.equals("cardinal-closed")) return CARDINAL_CLOSED;
        if (value.equals("cardinal-open")) return CARDINAL_OPEN;
        if (value.equals("catmull-rom")) return CATMULL_ROM;
        if (value.equals("linear")) return LINEAR;
        if (value.equals("linear-closed")) return LINEAR_CLOSED;
        if (value.equals("monotone")) return MONOTONE;
        if (value.equals("natural")) return NATURAL;
        if (value.equals("step")) return STEP;
        if (value.equals("step-after")) return STEP_AFTER;
        if (value.equals("step-before")) return STEP_BEFORE;
        throw new IOException("Cannot deserialize Interpolate");
    }
}
