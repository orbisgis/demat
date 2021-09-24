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
package org.orbisgis.demat.vega.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class GraticuleParams {
    private List<List<Double>> extent;
    private List<List<Double>> extentMajor;
    private List<List<Double>> extentMinor;
    private Double precision;
    private List<Double> step;
    private List<Double> stepMajor;
    private List<Double> stepMinor;

    /**
     * Sets both the major and minor extents to the same values.
     */
    @JsonProperty("extent")
    public List<List<Double>> getExtent() { return extent; }
    @JsonProperty("extent")
    public void setExtent(List<List<Double>> value) { this.extent = value; }

    /**
     * The major extent of the graticule as a two-element array of coordinates.
     */
    @JsonProperty("extentMajor")
    public List<List<Double>> getExtentMajor() { return extentMajor; }
    @JsonProperty("extentMajor")
    public void setExtentMajor(List<List<Double>> value) { this.extentMajor = value; }

    /**
     * The minor extent of the graticule as a two-element array of coordinates.
     */
    @JsonProperty("extentMinor")
    public List<List<Double>> getExtentMinor() { return extentMinor; }
    @JsonProperty("extentMinor")
    public void setExtentMinor(List<List<Double>> value) { this.extentMinor = value; }

    /**
     * The precision of the graticule in degrees.
     *
     * __Default value:__ `2.5`
     */
    @JsonProperty("precision")
    public Double getPrecision() { return precision; }
    @JsonProperty("precision")
    public void setPrecision(Double value) { this.precision = value; }

    /**
     * Sets both the major and minor step angles to the same values.
     */
    @JsonProperty("step")
    public List<Double> getStep() { return step; }
    @JsonProperty("step")
    public void setStep(List<Double> value) { this.step = value; }

    /**
     * The major step angles of the graticule.
     *
     *
     * __Default value:__ `[90, 360]`
     */
    @JsonProperty("stepMajor")
    public List<Double> getStepMajor() { return stepMajor; }
    @JsonProperty("stepMajor")
    public void setStepMajor(List<Double> value) { this.stepMajor = value; }

    /**
     * The minor step angles of the graticule.
     *
     * __Default value:__ `[10, 10]`
     */
    @JsonProperty("stepMinor")
    public List<Double> getStepMinor() { return stepMinor; }
    @JsonProperty("stepMinor")
    public void setStepMinor(List<Double> value) { this.stepMinor = value; }
}
