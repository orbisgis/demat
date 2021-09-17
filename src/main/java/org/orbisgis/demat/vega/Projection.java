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

/**
 * Projection configuration, which determines default properties for all
 * [projections](https://vega.github.io/vega-lite/docs/projection.html). For a full list of
 * projection configuration options, please see the [corresponding section of the projection
 * documentation](https://vega.github.io/vega-lite/docs/projection.html#config).
 *
 * Any property of Projection can be in config
 *
 * An object defining properties of geographic projection, which will be applied to `shape`
 * path for `"geoshape"` marks and to `latitude` and `"longitude"` channels for other
 * marks.
 *
 * An object defining properties of the geographic projection shared by underlying layers.
 */
public class Projection {
    private ProjectionType type;
    private List<Double> center;
    private Double clipAngle;
    private List<List<Double>> clipExtent;
    private Double coefficient;
    private Double distance;
    private List<List<Double>> extent;
    private Object fit;
    private Double fraction;
    private Double lobes;
    private Double parallel;
    private List<Double> parallels;
    private Double pointRadius;
    private Double precision;
    private Double radius;
    private Double ratio;
    private Boolean reflectX;
    private Boolean reflectY;
    private List<Double> rotate;
    private Double scale;
    private List<Double> size;
    private Double spacing;
    private Double tilt;
    private List<Double> translate;

    /**
     * The projection's center, a two-element array of longitude and latitude in degrees.
     *
     * __Default value:__ `[0, 0]`
     */
    @JsonProperty("center")
    public List<Double> getCenter() { return center; }
    @JsonProperty("center")
    public void setCenter(List<Double> value) { this.center = value; }

    /**
     * The projection's clipping circle radius to the specified angle in degrees. If `null`,
     * switches to [antimeridian](http://bl.ocks.org/mbostock/3788999) cutting rather than
     * small-circle clipping.
     */
    @JsonProperty("clipAngle")
    public Double getClipAngle() { return clipAngle; }
    @JsonProperty("clipAngle")
    public void setClipAngle(Double value) { this.clipAngle = value; }

    /**
     * The projection's viewport clip extent to the specified bounds in pixels. The extent
     * bounds are specified as an array `[[x0, y0], [x1, y1]]`, where `x0` is the left-side of
     * the viewport, `y0` is the top, `x1` is the right and `y1` is the bottom. If `null`, no
     * viewport clipping is performed.
     */
    @JsonProperty("clipExtent")
    public List<List<Double>> getClipExtent() { return clipExtent; }
    @JsonProperty("clipExtent")
    public void setClipExtent(List<List<Double>> value) { this.clipExtent = value; }

    @JsonProperty("coefficient")
    public Double getCoefficient() { return coefficient; }
    @JsonProperty("coefficient")
    public void setCoefficient(Double value) { this.coefficient = value; }

    @JsonProperty("distance")
    public Double getDistance() { return distance; }
    @JsonProperty("distance")
    public void setDistance(Double value) { this.distance = value; }

    @JsonProperty("extent")
    public List<List<Double>> getExtent() { return extent; }
    @JsonProperty("extent")
    public void setExtent(List<List<Double>> value) { this.extent = value; }

    @JsonProperty("fit")
    public Object getFit() { return fit; }
    @JsonProperty("fit")
    public void setFit(Object value) { this.fit = value; }

    @JsonProperty("fraction")
    public Double getFraction() { return fraction; }
    @JsonProperty("fraction")
    public void setFraction(Double value) { this.fraction = value; }

    @JsonProperty("lobes")
    public Double getLobes() { return lobes; }
    @JsonProperty("lobes")
    public void setLobes(Double value) { this.lobes = value; }

    @JsonProperty("parallel")
    public Double getParallel() { return parallel; }
    @JsonProperty("parallel")
    public void setParallel(Double value) { this.parallel = value; }

    /**
     * For conic projections, the [two standard
     * parallels](https://en.wikipedia.org/wiki/Map_projection#Conic) that define the map
     * layout. The default depends on the specific conic projection used.
     */
    @JsonProperty("parallels")
    public List<Double> getParallels() { return parallels; }
    @JsonProperty("parallels")
    public void setParallels(List<Double> value) { this.parallels = value; }

    /**
     * The default radius (in pixels) to use when drawing GeoJSON `Point` and `MultiPoint`
     * geometries. This parameter sets a constant default value. To modify the point radius in
     * response to data, see the corresponding parameter of the GeoPath and GeoShape
     * transforms.
     *
     * __Default value:__ `4.5`
     */
    @JsonProperty("pointRadius")
    public Double getPointRadius() { return pointRadius; }
    @JsonProperty("pointRadius")
    public void setPointRadius(Double value) { this.pointRadius = value; }

    /**
     * The threshold for the projection's [adaptive
     * resampling](http://bl.ocks.org/mbostock/3795544) to the specified value in pixels. This
     * value corresponds to the [Douglas–Peucker
     * distance](http://en.wikipedia.org/wiki/Ramer%E2%80%93Douglas%E2%80%93Peucker_algorithm).
     * If precision is not specified, returns the projection's current resampling precision
     * which defaults to `√0.5 ≅ 0.70710…`.
     */
    @JsonProperty("precision")
    public Double getPrecision() { return precision; }
    @JsonProperty("precision")
    public void setPrecision(Double value) { this.precision = value; }

    @JsonProperty("radius")
    public Double getRadius() { return radius; }
    @JsonProperty("radius")
    public void setRadius(Double value) { this.radius = value; }

    @JsonProperty("ratio")
    public Double getRatio() { return ratio; }
    @JsonProperty("ratio")
    public void setRatio(Double value) { this.ratio = value; }

    @JsonProperty("reflectX")
    public Boolean getReflectX() { return reflectX; }
    @JsonProperty("reflectX")
    public void setReflectX(Boolean value) { this.reflectX = value; }

    @JsonProperty("reflectY")
    public Boolean getReflectY() { return reflectY; }
    @JsonProperty("reflectY")
    public void setReflectY(Boolean value) { this.reflectY = value; }

    /**
     * The projection's three-axis rotation to the specified angles, which must be a two- or
     * three-element array of numbers [`lambda`, `phi`, `gamma`] specifying the rotation angles
     * in degrees about each spherical axis. (These correspond to yaw, pitch and roll.)
     *
     * __Default value:__ `[0, 0, 0]`
     */
    @JsonProperty("rotate")
    public List<Double> getRotate() { return rotate; }
    @JsonProperty("rotate")
    public void setRotate(List<Double> value) { this.rotate = value; }

    /**
     * The projection’s scale (zoom) factor, overriding automatic fitting. The default scale is
     * projection-specific. The scale factor corresponds linearly to the distance between
     * projected points; however, scale factor values are not equivalent across projections.
     */
    @JsonProperty("scale")
    public Double getScale() { return scale; }
    @JsonProperty("scale")
    public void setScale(Double value) { this.scale = value; }

    @JsonProperty("size")
    public List<Double> getSize() { return size; }
    @JsonProperty("size")
    public void setSize(List<Double> value) { this.size = value; }

    @JsonProperty("spacing")
    public Double getSpacing() { return spacing; }
    @JsonProperty("spacing")
    public void setSpacing(Double value) { this.spacing = value; }

    @JsonProperty("tilt")
    public Double getTilt() { return tilt; }
    @JsonProperty("tilt")
    public void setTilt(Double value) { this.tilt = value; }

    /**
     * The projection’s translation offset as a two-element array `[tx, ty]`.
     */
    @JsonProperty("translate")
    public List<Double> getTranslate() { return translate; }
    @JsonProperty("translate")
    public void setTranslate(List<Double> value) { this.translate = value; }

    /**
     * The cartographic projection to use. This value is case-insensitive, for example
     * `"albers"` and `"Albers"` indicate the same projection type. You can find all valid
     * projection types [in the
     * documentation](https://vega.github.io/vega-lite/docs/projection.html#projection-types).
     *
     * __Default value:__ `mercator`
     */
    @JsonProperty("type")
    public ProjectionType getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(ProjectionType value) {
        this.type = value;
    }

    public Projection identity() {
        this.setType(ProjectionType.IDENTITY);
        return this;
    }
}
