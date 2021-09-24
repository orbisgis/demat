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
package org.orbisgis.demat.vega.resolve;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Scale, axis, and legend resolutions for view composition specifications.
 *
 * Defines how scales, axes, and legends from different specs should be combined. Resolve is
 * a mapping from `scale`, `axis`, and `legend` to a mapping from channels to resolutions.
 * Scales and guides can be resolved to be `"independent"` or `"shared"`.
 */
public class Resolve {
    private AxisResolveMap axis;
    private LegendResolveMap legend;
    private ScaleResolveMap scale;

    @JsonProperty("axis")
    public AxisResolveMap getAxis() { return axis; }
    @JsonProperty("axis")
    public void setAxis(AxisResolveMap value) { this.axis = value; }

    @JsonProperty("legend")
    public LegendResolveMap getLegend() { return legend; }
    @JsonProperty("legend")
    public void setLegend(LegendResolveMap value) { this.legend = value; }

    @JsonProperty("scale")
    public ScaleResolveMap getScale() { return scale; }
    @JsonProperty("scale")
    public void setScale(ScaleResolveMap value) { this.scale = value; }
}
