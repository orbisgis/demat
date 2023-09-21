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

public class WindowFieldDef {
    private String as;
    private String field;
    private Op op;
    private Double param;

    /**
     * The output name for the window operation.
     */
    @JsonProperty("as")
    public String getAs() { return as; }
    @JsonProperty("as")
    public void setAs(String value) { this.as = value; }

    /**
     * The data field for which to compute the aggregate or window function. This can be omitted
     * for window functions that do not operate over a field such as `"count"`, `"rank"`,
     * `"dense_rank"`.
     */
    @JsonProperty("field")
    public String getField() { return field; }
    @JsonProperty("field")
    public void setField(String value) { this.field = value; }

    /**
     * The window or aggregation operation to apply within a window (e.g., `"rank"`, `"lead"`,
     * `"sum"`, `"average"` or `"count"`). See the list of all supported operations
     * [here](https://vega.github.io/vega-lite/docs/window.html#ops).
     */
    @JsonProperty("op")
    public Op getOp() { return op; }
    @JsonProperty("op")
    public void setOp(Op value) { this.op = value; }

    /**
     * Parameter values for the window functions. Parameter values can be omitted for operations
     * that do not accept a parameter.
     *
     * See the list of all supported operations and their parameters
     * [here](https://vega.github.io/vega-lite/docs/transforms/window.html).
     */
    @JsonProperty("param")
    public Double getParam() { return param; }
    @JsonProperty("param")
    public void setParam(Double value) { this.param = value; }
}
