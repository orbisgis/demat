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

public class LegendResolveMap {
    private ResolveMode angle;
    private ResolveMode color;
    private ResolveMode fill;
    private ResolveMode fillOpacity;
    private ResolveMode opacity;
    private ResolveMode shape;
    private ResolveMode size;
    private ResolveMode stroke;
    private ResolveMode strokeDash;
    private ResolveMode strokeOpacity;
    private ResolveMode strokeWidth;

    @JsonProperty("angle")
    public ResolveMode getAngle() { return angle; }
    @JsonProperty("angle")
    public void setAngle(ResolveMode value) { this.angle = value; }

    @JsonProperty("color")
    public ResolveMode getColor() { return color; }
    @JsonProperty("color")
    public void setColor(ResolveMode value) { this.color = value; }

    @JsonProperty("fill")
    public ResolveMode getFill() { return fill; }
    @JsonProperty("fill")
    public void setFill(ResolveMode value) { this.fill = value; }

    @JsonProperty("fillOpacity")
    public ResolveMode getFillOpacity() { return fillOpacity; }
    @JsonProperty("fillOpacity")
    public void setFillOpacity(ResolveMode value) { this.fillOpacity = value; }

    @JsonProperty("opacity")
    public ResolveMode getOpacity() { return opacity; }
    @JsonProperty("opacity")
    public void setOpacity(ResolveMode value) { this.opacity = value; }

    @JsonProperty("shape")
    public ResolveMode getShape() { return shape; }
    @JsonProperty("shape")
    public void setShape(ResolveMode value) { this.shape = value; }

    @JsonProperty("size")
    public ResolveMode getSize() { return size; }
    @JsonProperty("size")
    public void setSize(ResolveMode value) { this.size = value; }

    @JsonProperty("stroke")
    public ResolveMode getStroke() { return stroke; }
    @JsonProperty("stroke")
    public void setStroke(ResolveMode value) { this.stroke = value; }

    @JsonProperty("strokeDash")
    public ResolveMode getStrokeDash() { return strokeDash; }
    @JsonProperty("strokeDash")
    public void setStrokeDash(ResolveMode value) { this.strokeDash = value; }

    @JsonProperty("strokeOpacity")
    public ResolveMode getStrokeOpacity() { return strokeOpacity; }
    @JsonProperty("strokeOpacity")
    public void setStrokeOpacity(ResolveMode value) { this.strokeOpacity = value; }

    @JsonProperty("strokeWidth")
    public ResolveMode getStrokeWidth() { return strokeWidth; }
    @JsonProperty("strokeWidth")
    public void setStrokeWidth(ResolveMode value) { this.strokeWidth = value; }
}
