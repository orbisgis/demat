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

/**
 * Scale configuration determines default properties for all
 * [scales](https://vega.github.io/vega-lite/docs/scale.html). For a full list of scale
 * configuration options, please see the [corresponding section of the scale
 * documentation](https://vega.github.io/vega-lite/docs/scale.html#config).
 */
public class ScaleConfig {
    private CornerRadius bandPaddingInner;
    private CornerRadius bandPaddingOuter;
    private CornerRadius barBandPaddingInner;
    private Aria clamp;
    private CornerRadius continuousPadding;
    private Double maxBandSize;
    private Double maxFontSize;
    private Double maxOpacity;
    private Double maxSize;
    private Double maxStrokeWidth;
    private Double minBandSize;
    private Double minFontSize;
    private Double minOpacity;
    private Double minSize;
    private Double minStrokeWidth;
    private CornerRadius pointPadding;
    private Double quantileCount;
    private Double quantizeCount;
    private CornerRadius rectBandPaddingInner;
    private Aria round;
    private Boolean useUnaggregatedDomain;
    private Aria xReverse;

    /**
     * Default inner padding for `x` and `y` band-ordinal scales.
     *
     * __Default value:__ - `barBandPaddingInner` for bar marks (`0.1` by default) -
     * `rectBandPaddingInner` for rect and other marks (`0` by default)
     */
    @JsonProperty("bandPaddingInner")
    public CornerRadius getBandPaddingInner() { return bandPaddingInner; }
    @JsonProperty("bandPaddingInner")
    public void setBandPaddingInner(CornerRadius value) { this.bandPaddingInner = value; }

    /**
     * Default outer padding for `x` and `y` band-ordinal scales.
     *
     * __Default value:__ `paddingInner/2` (which makes _width/height = number of unique values
     * * step_)
     */
    @JsonProperty("bandPaddingOuter")
    public CornerRadius getBandPaddingOuter() { return bandPaddingOuter; }
    @JsonProperty("bandPaddingOuter")
    public void setBandPaddingOuter(CornerRadius value) { this.bandPaddingOuter = value; }

    /**
     * Default inner padding for `x` and `y` band-ordinal scales of `"bar"` marks.
     *
     * __Default value:__ `0.1`
     */
    @JsonProperty("barBandPaddingInner")
    public CornerRadius getBarBandPaddingInner() { return barBandPaddingInner; }
    @JsonProperty("barBandPaddingInner")
    public void setBarBandPaddingInner(CornerRadius value) { this.barBandPaddingInner = value; }

    /**
     * If true, values that exceed the data domain are clamped to either the minimum or maximum
     * range value
     */
    @JsonProperty("clamp")
    public Aria getClamp() { return clamp; }
    @JsonProperty("clamp")
    public void setClamp(Aria value) { this.clamp = value; }

    /**
     * Default padding for continuous scales.
     *
     * __Default:__ `5` for continuous x-scale of a vertical bar and continuous y-scale of a
     * horizontal bar.; `0` otherwise.
     */
    @JsonProperty("continuousPadding")
    public CornerRadius getContinuousPadding() { return continuousPadding; }
    @JsonProperty("continuousPadding")
    public void setContinuousPadding(CornerRadius value) { this.continuousPadding = value; }

    /**
     * The default max value for mapping quantitative fields to bar's size/bandSize.
     *
     * If undefined (default), we will use the axis's size (width or height) - 1.
     */
    @JsonProperty("maxBandSize")
    public Double getMaxBandSize() { return maxBandSize; }
    @JsonProperty("maxBandSize")
    public void setMaxBandSize(Double value) { this.maxBandSize = value; }

    /**
     * The default max value for mapping quantitative fields to text's size/fontSize.
     *
     * __Default value:__ `40`
     */
    @JsonProperty("maxFontSize")
    public Double getMaxFontSize() { return maxFontSize; }
    @JsonProperty("maxFontSize")
    public void setMaxFontSize(Double value) { this.maxFontSize = value; }

    /**
     * Default max opacity for mapping a field to opacity.
     *
     * __Default value:__ `0.8`
     */
    @JsonProperty("maxOpacity")
    public Double getMaxOpacity() { return maxOpacity; }
    @JsonProperty("maxOpacity")
    public void setMaxOpacity(Double value) { this.maxOpacity = value; }

    /**
     * Default max value for point size scale.
     */
    @JsonProperty("maxSize")
    public Double getMaxSize() { return maxSize; }
    @JsonProperty("maxSize")
    public void setMaxSize(Double value) { this.maxSize = value; }

    /**
     * Default max strokeWidth for the scale of strokeWidth for rule and line marks and of size
     * for trail marks.
     *
     * __Default value:__ `4`
     */
    @JsonProperty("maxStrokeWidth")
    public Double getMaxStrokeWidth() { return maxStrokeWidth; }
    @JsonProperty("maxStrokeWidth")
    public void setMaxStrokeWidth(Double value) { this.maxStrokeWidth = value; }

    /**
     * The default min value for mapping quantitative fields to bar and tick's size/bandSize
     * scale with zero=false.
     *
     * __Default value:__ `2`
     */
    @JsonProperty("minBandSize")
    public Double getMinBandSize() { return minBandSize; }
    @JsonProperty("minBandSize")
    public void setMinBandSize(Double value) { this.minBandSize = value; }

    /**
     * The default min value for mapping quantitative fields to tick's size/fontSize scale with
     * zero=false
     *
     * __Default value:__ `8`
     */
    @JsonProperty("minFontSize")
    public Double getMinFontSize() { return minFontSize; }
    @JsonProperty("minFontSize")
    public void setMinFontSize(Double value) { this.minFontSize = value; }

    /**
     * Default minimum opacity for mapping a field to opacity.
     *
     * __Default value:__ `0.3`
     */
    @JsonProperty("minOpacity")
    public Double getMinOpacity() { return minOpacity; }
    @JsonProperty("minOpacity")
    public void setMinOpacity(Double value) { this.minOpacity = value; }

    /**
     * Default minimum value for point size scale with zero=false.
     *
     * __Default value:__ `9`
     */
    @JsonProperty("minSize")
    public Double getMinSize() { return minSize; }
    @JsonProperty("minSize")
    public void setMinSize(Double value) { this.minSize = value; }

    /**
     * Default minimum strokeWidth for the scale of strokeWidth for rule and line marks and of
     * size for trail marks with zero=false.
     *
     * __Default value:__ `1`
     */
    @JsonProperty("minStrokeWidth")
    public Double getMinStrokeWidth() { return minStrokeWidth; }
    @JsonProperty("minStrokeWidth")
    public void setMinStrokeWidth(Double value) { this.minStrokeWidth = value; }

    /**
     * Default outer padding for `x` and `y` point-ordinal scales.
     *
     * __Default value:__ `0.5` (which makes _width/height = number of unique values * step_)
     */
    @JsonProperty("pointPadding")
    public CornerRadius getPointPadding() { return pointPadding; }
    @JsonProperty("pointPadding")
    public void setPointPadding(CornerRadius value) { this.pointPadding = value; }

    /**
     * Default range cardinality for
     * [`quantile`](https://vega.github.io/vega-lite/docs/scale.html#quantile) scale.
     *
     * __Default value:__ `4`
     */
    @JsonProperty("quantileCount")
    public Double getQuantileCount() { return quantileCount; }
    @JsonProperty("quantileCount")
    public void setQuantileCount(Double value) { this.quantileCount = value; }

    /**
     * Default range cardinality for
     * [`quantize`](https://vega.github.io/vega-lite/docs/scale.html#quantize) scale.
     *
     * __Default value:__ `4`
     */
    @JsonProperty("quantizeCount")
    public Double getQuantizeCount() { return quantizeCount; }
    @JsonProperty("quantizeCount")
    public void setQuantizeCount(Double value) { this.quantizeCount = value; }

    /**
     * Default inner padding for `x` and `y` band-ordinal scales of `"rect"` marks.
     *
     * __Default value:__ `0`
     */
    @JsonProperty("rectBandPaddingInner")
    public CornerRadius getRectBandPaddingInner() { return rectBandPaddingInner; }
    @JsonProperty("rectBandPaddingInner")
    public void setRectBandPaddingInner(CornerRadius value) { this.rectBandPaddingInner = value; }

    /**
     * If true, rounds numeric output values to integers. This can be helpful for snapping to
     * the pixel grid. (Only available for `x`, `y`, and `size` scales.)
     */
    @JsonProperty("round")
    public Aria getRound() { return round; }
    @JsonProperty("round")
    public void setRound(Aria value) { this.round = value; }

    /**
     * Use the source data range before aggregation as scale domain instead of aggregated data
     * for aggregate axis.
     *
     * This is equivalent to setting `domain` to `"unaggregate"` for aggregated _quantitative_
     * fields by default.
     *
     * This property only works with aggregate functions that produce values within the raw data
     * domain (`"mean"`, `"average"`, `"median"`, `"q1"`, `"q3"`, `"min"`, `"max"`). For other
     * aggregations that produce values outside of the raw data domain (e.g. `"count"`,
     * `"sum"`), this property is ignored.
     *
     * __Default value:__ `false`
     */
    @JsonProperty("useUnaggregatedDomain")
    public Boolean getUseUnaggregatedDomain() { return useUnaggregatedDomain; }
    @JsonProperty("useUnaggregatedDomain")
    public void setUseUnaggregatedDomain(Boolean value) { this.useUnaggregatedDomain = value; }

    /**
     * Reverse x-scale by default (useful for right-to-left charts).
     */
    @JsonProperty("xReverse")
    public Aria getXReverse() { return xReverse; }
    @JsonProperty("xReverse")
    public void setXReverse(Aria value) { this.xReverse = value; }
}
