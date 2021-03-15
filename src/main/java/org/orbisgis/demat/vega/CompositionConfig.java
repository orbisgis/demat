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

/**
 * Default configuration for all concatenation and repeat view composition operators
 * (`concat`, `hconcat`, `vconcat`, and `repeat`)
 *
 * Default configuration for the `facet` view composition operator
 */
public class CompositionConfig {
    private Double columns;
    private Double spacing;

    /**
     * The number of columns to include in the view composition layout.
     *
     * __Default value__: `undefined` -- An infinite number of columns (a single row) will be
     * assumed. This is equivalent to `hconcat` (for `concat`) and to using the `column` channel
     * (for `facet` and `repeat`).
     *
     * __Note__:
     *
     * 1) This property is only for: - the general (wrappable) `concat` operator (not
     * `hconcat`/`vconcat`) - the `facet` and `repeat` operator with one field/repetition
     * definition (without row/column nesting)
     *
     * 2) Setting the `columns` to `1` is equivalent to `vconcat` (for `concat`) and to using
     * the `row` channel (for `facet` and `repeat`).
     */
    @JsonProperty("columns")
    public Double getColumns() { return columns; }
    @JsonProperty("columns")
    public void setColumns(Double value) { this.columns = value; }

    /**
     * The default spacing in pixels between composed sub-views.
     *
     * __Default value__: `20`
     */
    @JsonProperty("spacing")
    public Double getSpacing() { return spacing; }
    @JsonProperty("spacing")
    public void setSpacing(Double value) { this.spacing = value; }
}
