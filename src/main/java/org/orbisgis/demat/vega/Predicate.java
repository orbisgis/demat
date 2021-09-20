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

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Predicate {
    private Filter not;
    private List<PredicateCompositionElement> and;
    private List<PredicateCompositionElement> or;
    private Equal equal;
    private String field;
    private TimeUnitUnion timeUnit;
    private LogicalNotPredicateRange range;
    private List<SelectionInitInterval> oneOf;
    private Lt lt;
    private Lt gt;
    private Lt lte;
    private Lt gte;
    private Boolean valid;
    private ConditionalValueDefNumberExprRefSelectionComposition selection;

    @JsonProperty("not")
    public Filter getNot() {
        return not;
    }

    @JsonProperty("not")
    public void setNot(Filter value) {
        this.not = value;
    }

    @JsonProperty("and")
    public List<PredicateCompositionElement> getAnd() { return and; }
    @JsonProperty("and")
    public void setAnd(List<PredicateCompositionElement> value) { this.and = value; }

    @JsonProperty("or")
    public List<PredicateCompositionElement> getOr() { return or; }
    @JsonProperty("or")
    public void setOr(List<PredicateCompositionElement> value) { this.or = value; }

    /**
     * The value that the field should be equal to.
     */
    @JsonProperty("equal")
    public Equal getEqual() { return equal; }
    @JsonProperty("equal")
    public void setEqual(Equal value) { this.equal = value; }

    /**
     * Field to be tested.
     */
    @JsonProperty("field")
    public String getField() { return field; }
    @JsonProperty("field")
    public void setField(String value) { this.field = value; }

    /**
     * Time unit for the field to be tested.
     */
    @JsonProperty("timeUnit")
    public TimeUnitUnion getTimeUnit() { return timeUnit; }
    @JsonProperty("timeUnit")
    public void setTimeUnit(TimeUnitUnion value) { this.timeUnit = value; }

    /**
     * An array of inclusive minimum and maximum values for a field value of a data item to be
     * included in the filtered data.
     */
    @JsonProperty("range")
    public LogicalNotPredicateRange getRange() { return range; }
    @JsonProperty("range")
    public void setRange(LogicalNotPredicateRange value) { this.range = value; }

    /**
     * A set of values that the `field`'s value should be a member of, for a data item included
     * in the filtered data.
     */
    @JsonProperty("oneOf")
    public List<SelectionInitInterval> getOneOf() { return oneOf; }
    @JsonProperty("oneOf")
    public void setOneOf(List<SelectionInitInterval> value) { this.oneOf = value; }

    /**
     * The value that the field should be less than.
     */
    @JsonProperty("lt")
    public Lt getLt() { return lt; }
    @JsonProperty("lt")
    public void setLt(Lt value) { this.lt = value; }

    /**
     * The value that the field should be greater than.
     */
    @JsonProperty("gt")
    public Lt getGt() { return gt; }
    @JsonProperty("gt")
    public void setGt(Lt value) { this.gt = value; }

    /**
     * The value that the field should be less than or equals to.
     */
    @JsonProperty("lte")
    public Lt getLTE() { return lte; }
    @JsonProperty("lte")
    public void setLTE(Lt value) { this.lte = value; }

    /**
     * The value that the field should be greater than or equals to.
     */
    @JsonProperty("gte")
    public Lt getGte() { return gte; }
    @JsonProperty("gte")
    public void setGte(Lt value) { this.gte = value; }

    /**
     * If set to true the field's value has to be valid, meaning both not `null` and not
     * [`NaN`](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/NaN).
     */
    @JsonProperty("valid")
    public Boolean getValid() { return valid; }
    @JsonProperty("valid")
    public void setValid(Boolean value) { this.valid = value; }

    /**
     * Filter using a selection name or a logical composition of selection names.
     */
    @JsonProperty("selection")
    public ConditionalValueDefNumberExprRefSelectionComposition getSelection() { return selection; }
    @JsonProperty("selection")
    public void setSelection(ConditionalValueDefNumberExprRefSelectionComposition value) { this.selection = value; }
}
