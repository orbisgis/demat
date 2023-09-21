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

public class TimeUnitParams {
    private Double maxbins;
    private Double step;
    private TimeUnit unit;
    private Boolean utc;

    /**
     * If no `unit` is specified, maxbins is used to infer time units.
     */
    @JsonProperty("maxbins")
    public Double getMaxbins() { return maxbins; }
    @JsonProperty("maxbins")
    public void setMaxbins(Double value) { this.maxbins = value; }

    /**
     * The number of steps between bins, in terms of the least significant unit provided.
     */
    @JsonProperty("step")
    public Double getStep() { return step; }
    @JsonProperty("step")
    public void setStep(Double value) { this.step = value; }

    /**
     * Defines how date-time values should be binned.
     */
    @JsonProperty("unit")
    public TimeUnit getUnit() { return unit; }
    @JsonProperty("unit")
    public void setUnit(TimeUnit value) { this.unit = value; }

    /**
     * True to use UTC timezone. Equivalent to using a `utc` prefixed `TimeUnit`.
     */
    @JsonProperty("utc")
    public Boolean getUTC() { return utc; }
    @JsonProperty("utc")
    public void setUTC(Boolean value) { this.utc = value; }
}
