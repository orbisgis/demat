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

import com.fasterxml.jackson.annotation.*;
import java.util.List;

/**
 * Definition for fields to be repeated. One of: 1) An array of fields to be repeated. If
 * `"repeat"` is an array, the field can be referred to as `{"repeat": "repeat"}`. The
 * repeated views are laid out in a wrapped row. You can set the number of columns to
 * control the wrapping. 2) An object that maps `"row"` and/or `"column"` to the listed
 * fields to be repeated along the particular orientations. The objects `{"repeat": "row"}`
 * and `{"repeat": "column"}` can be used to refer to the repeated field respectively.
 */
public class RepeatMapping {
    private List<String> column;
    private List<String> row;
    private List<String> layer;

    /**
     * An array of fields to be repeated horizontally.
     */
    @JsonProperty("column")
    public List<String> getColumn() { return column; }
    @JsonProperty("column")
    public void setColumn(List<String> value) { this.column = value; }

    /**
     * An array of fields to be repeated vertically.
     */
    @JsonProperty("row")
    public List<String> getRow() { return row; }
    @JsonProperty("row")
    public void setRow(List<String> value) { this.row = value; }

    /**
     * An array of fields to be repeated as layers.
     */
    @JsonProperty("layer")
    public List<String> getLayer() { return layer; }
    @JsonProperty("layer")
    public void setLayer(List<String> value) { this.layer = value; }
}
