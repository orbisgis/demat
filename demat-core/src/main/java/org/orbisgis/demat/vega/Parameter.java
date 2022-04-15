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

public class Parameter {
    private Binding bind;
    private String description;
    private String expr;
    private String name;
    private Object value;

    /**
     * Binds the parameter to an external input element such as a slider, selection list or
     * radio button group.
     */
    @JsonProperty("bind")
    public Binding getBind() { return bind; }
    @JsonProperty("bind")
    public void setBind(Binding value) { this.bind = value; }

    /**
     * A text description of the parameter, useful for inline documentation.
     */
    @JsonProperty("description")
    public String getDescription() { return description; }
    @JsonProperty("description")
    public void setDescription(String value) { this.description = value; }

    /**
     * An expression for the value of the parameter. This expression may include other
     * parameters, in which case the parameter will automatically update in response to upstream
     * parameter changes.
     */
    @JsonProperty("expr")
    public String getExpr() { return expr; }
    @JsonProperty("expr")
    public void setExpr(String value) { this.expr = value; }

    /**
     * Required. A unique name for the parameter. Parameter names should be valid JavaScript
     * identifiers: they should contain only alphanumeric characters (or “$”, or “_”) and may
     * not start with a digit. Reserved keywords that may not be used as parameter names are
     * "datum", "event", "item", and "parent".
     */
    @JsonProperty("name")
    public String getName() { return name; }
    @JsonProperty("name")
    public void setName(String value) { this.name = value; }

    /**
     * The initial value of the parameter.
     *
     * __Default value:__ `undefined`
     */
    @JsonProperty("value")
    public Object getValue() { return value; }
    @JsonProperty("value")
    public void setValue(Object value) { this.value = value; }
}
