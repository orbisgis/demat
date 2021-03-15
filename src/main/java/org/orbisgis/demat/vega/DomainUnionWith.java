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

public class DomainUnionWith {
    private String field;
    private String selection;
    private SingleDefUnitChannel encoding;
    private List<SelectionInitInterval> unionWith;
    private String expr;

    /**
     * The field name to extract selected values for, when a selection is
     * [projected](https://vega.github.io/vega-lite/docs/project.html) over multiple fields or
     * encodings.
     */
    @JsonProperty("field")
    public String getField() { return field; }
    @JsonProperty("field")
    public void setField(String value) { this.field = value; }

    /**
     * The name of a selection.
     */
    @JsonProperty("selection")
    public String getSelection() { return selection; }
    @JsonProperty("selection")
    public void setSelection(String value) { this.selection = value; }

    /**
     * The encoding channel to extract selected values for, when a selection is
     * [projected](https://vega.github.io/vega-lite/docs/project.html) over multiple fields or
     * encodings.
     */
    @JsonProperty("encoding")
    public SingleDefUnitChannel getEncoding() { return encoding; }
    @JsonProperty("encoding")
    public void setEncoding(SingleDefUnitChannel value) { this.encoding = value; }

    /**
     * Customized domain values to be union with the field's values.
     *
     * 1) `domain` for _quantitative_ fields can take one of the following forms:
     *
     * - a two-element array with minimum and maximum values. - an array with more than two
     * entries, for [Piecewise  quantitative
     * scales](https://vega.github.io/vega-lite/docs/scale.html#piecewise). (Alternatively, the
     * `domainMid` property can be set for a diverging scale.) - a string value
     * `"unaggregated"`, if the input field is aggregated, to indicate that the domain should
     * include the raw data values prior to the aggregation.
     *
     * 2) `domain` for _temporal_ fields can be a two-element array minimum and maximum values,
     * in the form of either timestamps or the [DateTime definition
     * objects](https://vega.github.io/vega-lite/docs/types.html#datetime).
     *
     * 3) `domain` for _ordinal_ and _nominal_ fields can be an array that lists valid input
     * values.
     */
    @JsonProperty("unionWith")
    public List<SelectionInitInterval> getUnionWith() { return unionWith; }
    @JsonProperty("unionWith")
    public void setUnionWith(List<SelectionInitInterval> value) { this.unionWith = value; }

    /**
     * Vega expression (which can refer to Vega-Lite parameters).
     */
    @JsonProperty("expr")
    public String getExpr() { return expr; }
    @JsonProperty("expr")
    public void setExpr(String value) { this.expr = value; }
}
