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

public class ScaleResolveMap {
    private AngleResolve angle;
    private ColorResolve color;
    private FillResolve fill;
    private FillOpacityResolve fillOpacity;
    private OpacityResolve opacity;
    private RadiusResolve radius;
    private ShapeResolve shape;
    private SizeResolve size;
    private StrokeResolve stroke;
    private StrokeDashResolve strokeDash;
    private StrokeOpacityResolve strokeOpacity;
    private StrokeWidthResolve strokeWidth;
    private ThetaResolve theta;
    private XResolve x;
    private YResolve y;

    @JsonProperty("angle")
    public AngleResolve getAngle() {
        return angle;
    }

    @JsonProperty("angle")
    public void setAngle(AngleResolve value) {
        this.angle = value;
    }

    @JsonProperty("color")
    public ColorResolve getColor() {
        return color;
    }

    @JsonProperty("color")
    public void setColor(ColorResolve value) {
        this.color = value;
    }

    @JsonProperty("fill")
    public FillResolve getFill() {
        return fill;
    }

    @JsonProperty("fill")
    public void setFill(FillResolve value) {
        this.fill = value;
    }

    @JsonProperty("fillOpacity")
    public FillOpacityResolve getFillOpacity() {
        return fillOpacity;
    }

    @JsonProperty("fillOpacity")
    public void setFillOpacity(FillOpacityResolve value) {
        this.fillOpacity = value;
    }

    @JsonProperty("opacity")
    public OpacityResolve getOpacity() {
        return opacity;
    }

    @JsonProperty("opacity")
    public void setOpacity(OpacityResolve value) {
        this.opacity = value;
    }

    @JsonProperty("radius")
    public RadiusResolve getRadius() {
        return radius;
    }

    @JsonProperty("radius")
    public void setRadius(RadiusResolve value) {
        this.radius = value;
    }

    @JsonProperty("shape")
    public ShapeResolve getShape() {
        return shape;
    }

    @JsonProperty("shape")
    public void setShape(ShapeResolve value) {
        this.shape = value;
    }

    @JsonProperty("size")
    public SizeResolve getSize() {
        return size;
    }

    @JsonProperty("size")
    public void setSize(SizeResolve value) {
        this.size = value;
    }

    @JsonProperty("stroke")
    public StrokeResolve getStroke() {
        return stroke;
    }

    @JsonProperty("stroke")
    public void setStroke(StrokeResolve value) {
        this.stroke = value;
    }

    @JsonProperty("strokeDash")
    public StrokeDashResolve getStrokeDash() {
        return strokeDash;
    }

    @JsonProperty("strokeDash")
    public void setStrokeDash(StrokeDashResolve value) {
        this.strokeDash = value;
    }

    @JsonProperty("strokeOpacity")
    public StrokeOpacityResolve getStrokeOpacity() {
        return strokeOpacity;
    }

    @JsonProperty("strokeOpacity")
    public void setStrokeOpacity(StrokeOpacityResolve value) {
        this.strokeOpacity = value;
    }

    @JsonProperty("strokeWidth")
    public StrokeWidthResolve getStrokeWidth() {
        return strokeWidth;
    }

    @JsonProperty("strokeWidth")
    public void setStrokeWidth(StrokeWidthResolve value) {
        this.strokeWidth = value;
    }

    @JsonProperty("theta")
    public ThetaResolve getTheta() {
        return theta;
    }

    @JsonProperty("theta")
    public void setTheta(ThetaResolve value) {
        this.theta = value;
    }

    @JsonProperty("x")
    public XResolve getX() {
        return x;
    }

    @JsonProperty("x")
    public void setX(XResolve value) {
        this.x = value;
    }

    @JsonProperty("y")
    public YResolve getY() {
        return y;
    }

    @JsonProperty("y")
    public void setY(YResolve value) {
        this.y = value;
    }
}
