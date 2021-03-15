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

public class ImputeParams {
    private List<Double> frame;
    private Keyvals keyvals;
    private ImputeParamsMethod method;
    private Object value;

    /**
     * A frame specification as a two-element array used to control the window over which the
     * specified method is applied. The array entries should either be a number indicating the
     * offset from the current data object, or null to indicate unbounded rows preceding or
     * following the current data object. For example, the value `[-5, 5]` indicates that the
     * window should include five objects preceding and five objects following the current
     * object.
     *
     * __Default value:__:  `[null, null]` indicating that the window includes all objects.
     */
    @JsonProperty("frame")
    public List<Double> getFrame() { return frame; }
    @JsonProperty("frame")
    public void setFrame(List<Double> value) { this.frame = value; }

    /**
     * Defines the key values that should be considered for imputation. An array of key values
     * or an object defining a [number
     * sequence](https://vega.github.io/vega-lite/docs/impute.html#sequence-def).
     *
     * If provided, this will be used in addition to the key values observed within the input
     * data. If not provided, the values will be derived from all unique values of the `key`
     * field. For `impute` in `encoding`, the key field is the x-field if the y-field is
     * imputed, or vice versa.
     *
     * If there is no impute grouping, this property _must_ be specified.
     */
    @JsonProperty("keyvals")
    public Keyvals getKeyvals() { return keyvals; }
    @JsonProperty("keyvals")
    public void setKeyvals(Keyvals value) { this.keyvals = value; }

    /**
     * The imputation method to use for the field value of imputed data objects. One of
     * `"value"`, `"mean"`, `"median"`, `"max"` or `"min"`.
     *
     * __Default value:__  `"value"`
     */
    @JsonProperty("method")
    public ImputeParamsMethod getMethod() { return method; }
    @JsonProperty("method")
    public void setMethod(ImputeParamsMethod value) { this.method = value; }

    /**
     * The field value to use when the imputation `method` is `"value"`.
     */
    @JsonProperty("value")
    public Object getValue() { return value; }
    @JsonProperty("value")
    public void setValue(Object value) { this.value = value; }
}
