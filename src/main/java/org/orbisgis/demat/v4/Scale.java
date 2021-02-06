package org.orbisgis.demat.v4;

import com.fasterxml.jackson.annotation.*;

public class Scale {
    private CornerRadiusUnion align;
    private CornerRadiusUnion base;
    private ScaleBins bins;
    private Aria clamp;
    private CornerRadiusUnion constant;
    private DomainUnion domain;
    private DomainM domainMax;
    private CornerRadiusUnion domainMid;
    private DomainM domainMin;
    private CornerRadiusUnion exponent;
    private ScaleInterpolate interpolate;
    private Nice nice;
    private CornerRadiusUnion padding;
    private CornerRadiusUnion paddingInner;
    private CornerRadiusUnion paddingOuter;
    private ScaleRange range;
    private X rangeMax;
    private X rangeMin;
    private Aria reverse;
    private Aria round;
    private Scheme scheme;
    private ScaleType type;
    private Aria zero;

    /**
     * The alignment of the steps within the scale range.
     *
     * This value must lie in the range `[0,1]`. A value of `0.5` indicates that the steps
     * should be centered within the range. A value of `0` or `1` may be used to shift the bands
     * to one side, say to position them adjacent to an axis.
     *
     * __Default value:__ `0.5`
     */
    @JsonProperty("align")
    public CornerRadiusUnion getAlign() { return align; }
    @JsonProperty("align")
    public void setAlign(CornerRadiusUnion value) { this.align = value; }

    /**
     * The logarithm base of the `log` scale (default `10`).
     */
    @JsonProperty("base")
    public CornerRadiusUnion getBase() { return base; }
    @JsonProperty("base")
    public void setBase(CornerRadiusUnion value) { this.base = value; }

    /**
     * Bin boundaries can be provided to scales as either an explicit array of bin boundaries or
     * as a bin specification object. The legal values are: - An [array](../types/#Array)
     * literal of bin boundary values. For example, `[0, 5, 10, 15, 20]`. The array must include
     * both starting and ending boundaries. The previous example uses five values to indicate a
     * total of four bin intervals: [0-5), [5-10), [10-15), [15-20]. Array literals may include
     * signal references as elements. - A [bin specification
     * object](https://vega.github.io/vega-lite/docs/scale.html#bins) that indicates the bin
     * _step_ size, and optionally the _start_ and _stop_ boundaries. - An array of bin
     * boundaries over the scale domain. If provided, axes and legends will use the bin
     * boundaries to inform the choice of tick marks and text labels.
     */
    @JsonProperty("bins")
    public ScaleBins getBins() { return bins; }
    @JsonProperty("bins")
    public void setBins(ScaleBins value) { this.bins = value; }

    /**
     * If `true`, values that exceed the data domain are clamped to either the minimum or
     * maximum range value
     *
     * __Default value:__ derived from the [scale
     * config](https://vega.github.io/vega-lite/docs/config.html#scale-config)'s `clamp` (`true`
     * by default).
     */
    @JsonProperty("clamp")
    public Aria getClamp() { return clamp; }
    @JsonProperty("clamp")
    public void setClamp(Aria value) { this.clamp = value; }

    /**
     * A constant determining the slope of the symlog function around zero. Only used for
     * `symlog` scales.
     *
     * __Default value:__ `1`
     */
    @JsonProperty("constant")
    public CornerRadiusUnion getConstant() { return constant; }
    @JsonProperty("constant")
    public void setConstant(CornerRadiusUnion value) { this.constant = value; }

    /**
     * Customized domain values in the form of constant values or dynamic values driven by a
     * selection.
     *
     * 1) Constant `domain` for _quantitative_ fields can take one of the following forms:
     *
     * - A two-element array with minimum and maximum values. To create a diverging scale, this
     * two-element array can be combined with the `domainMid` property. - An array with more
     * than two entries, for [Piecewise quantitative
     * scales](https://vega.github.io/vega-lite/docs/scale.html#piecewise). - A string value
     * `"unaggregated"`, if the input field is aggregated, to indicate that the domain should
     * include the raw data values prior to the aggregation.
     *
     * 2) Constant `domain` for _temporal_ fields can be a two-element array with minimum and
     * maximum values, in the form of either timestamps or the [DateTime definition
     * objects](https://vega.github.io/vega-lite/docs/types.html#datetime).
     *
     * 3) Constant `domain` for _ordinal_ and _nominal_ fields can be an array that lists valid
     * input values.
     *
     * 4) To combine (union) specified constant domain with the field's values, `domain` can be
     * an object with a `unionWith` property that specify constant domain to be combined. For
     * example, `domain: {unionWith: [0, 100]}` for a quantitative scale means that the scale
     * domain always includes `[0, 100]`, but will include other values in the fields beyond
     * `[0, 100]`.
     *
     * 5) Domain can also takes an object defining a field or encoding of a selection that
     * [interactively
     * determines](https://vega.github.io/vega-lite/docs/selection.html#scale-domains) the scale
     * domain.
     */
    @JsonProperty("domain")
    public DomainUnion getDomain() { return domain; }
    @JsonProperty("domain")
    public void setDomain(DomainUnion value) { this.domain = value; }

    /**
     * Sets the maximum value in the scale domain, overriding the `domain` property. This
     * property is only intended for use with scales having continuous domains.
     */
    @JsonProperty("domainMax")
    public DomainM getDomainMax() { return domainMax; }
    @JsonProperty("domainMax")
    public void setDomainMax(DomainM value) { this.domainMax = value; }

    /**
     * Inserts a single mid-point value into a two-element domain. The mid-point value must lie
     * between the domain minimum and maximum values. This property can be useful for setting a
     * midpoint for [diverging color
     * scales](https://vega.github.io/vega-lite/docs/scale.html#piecewise). The domainMid
     * property is only intended for use with scales supporting continuous, piecewise domains.
     */
    @JsonProperty("domainMid")
    public CornerRadiusUnion getDomainMid() { return domainMid; }
    @JsonProperty("domainMid")
    public void setDomainMid(CornerRadiusUnion value) { this.domainMid = value; }

    /**
     * Sets the minimum value in the scale domain, overriding the domain property. This property
     * is only intended for use with scales having continuous domains.
     */
    @JsonProperty("domainMin")
    public DomainM getDomainMin() { return domainMin; }
    @JsonProperty("domainMin")
    public void setDomainMin(DomainM value) { this.domainMin = value; }

    /**
     * The exponent of the `pow` scale.
     */
    @JsonProperty("exponent")
    public CornerRadiusUnion getExponent() { return exponent; }
    @JsonProperty("exponent")
    public void setExponent(CornerRadiusUnion value) { this.exponent = value; }

    /**
     * The interpolation method for range values. By default, a general interpolator for
     * numbers, dates, strings and colors (in HCL space) is used. For color ranges, this
     * property allows interpolation in alternative color spaces. Legal values include `rgb`,
     * `hsl`, `hsl-long`, `lab`, `hcl`, `hcl-long`, `cubehelix` and `cubehelix-long` ('-long'
     * variants use longer paths in polar coordinate spaces). If object-valued, this property
     * accepts an object with a string-valued _type_ property and an optional numeric _gamma_
     * property applicable to rgb and cubehelix interpolators. For more, see the [d3-interpolate
     * documentation](https://github.com/d3/d3-interpolate).
     *
     * * __Default value:__ `hcl`
     */
    @JsonProperty("interpolate")
    public ScaleInterpolate getInterpolate() { return interpolate; }
    @JsonProperty("interpolate")
    public void setInterpolate(ScaleInterpolate value) { this.interpolate = value; }

    /**
     * Extending the domain so that it starts and ends on nice round values. This method
     * typically modifies the scale’s domain, and may only extend the bounds to the nearest
     * round value. Nicing is useful if the domain is computed from data and may be irregular.
     * For example, for a domain of _[0.201479…, 0.996679…]_, a nice domain might be _[0.2,
     * 1.0]_.
     *
     * For quantitative scales such as linear, `nice` can be either a boolean flag or a number.
     * If `nice` is a number, it will represent a desired tick count. This allows greater
     * control over the step size used to extend the bounds, guaranteeing that the returned
     * ticks will exactly cover the domain.
     *
     * For temporal fields with time and utc scales, the `nice` value can be a string indicating
     * the desired time interval. Legal values are `"millisecond"`, `"second"`, `"minute"`,
     * `"hour"`, `"day"`, `"week"`, `"month"`, and `"year"`. Alternatively, `time` and `utc`
     * scales can accept an object-valued interval specifier of the form `{"interval": "month",
     * "step": 3}`, which includes a desired number of interval steps. Here, the domain would
     * snap to quarter (Jan, Apr, Jul, Oct) boundaries.
     *
     * __Default value:__ `true` for unbinned _quantitative_ fields; `false` otherwise.
     */
    @JsonProperty("nice")
    public Nice getNice() { return nice; }
    @JsonProperty("nice")
    public void setNice(Nice value) { this.nice = value; }

    /**
     * For _[continuous](https://vega.github.io/vega-lite/docs/scale.html#continuous)_ scales,
     * expands the scale domain to accommodate the specified number of pixels on each of the
     * scale range. The scale range must represent pixels for this parameter to function as
     * intended. Padding adjustment is performed prior to all other adjustments, including the
     * effects of the `zero`, `nice`, `domainMin`, and `domainMax` properties.
     *
     * For _[band](https://vega.github.io/vega-lite/docs/scale.html#band)_ scales, shortcut for
     * setting `paddingInner` and `paddingOuter` to the same value.
     *
     * For _[point](https://vega.github.io/vega-lite/docs/scale.html#point)_ scales, alias for
     * `paddingOuter`.
     *
     * __Default value:__ For _continuous_ scales, derived from the [scale
     * config](https://vega.github.io/vega-lite/docs/scale.html#config)'s `continuousPadding`.
     * For _band and point_ scales, see `paddingInner` and `paddingOuter`. By default, Vega-Lite
     * sets padding such that _width/height = number of unique values * step_.
     */
    @JsonProperty("padding")
    public CornerRadiusUnion getPadding() { return padding; }
    @JsonProperty("padding")
    public void setPadding(CornerRadiusUnion value) { this.padding = value; }

    /**
     * The inner padding (spacing) within each band step of band scales, as a fraction of the
     * step size. This value must lie in the range [0,1].
     *
     * For point scale, this property is invalid as point scales do not have internal band
     * widths (only step sizes between bands).
     *
     * __Default value:__ derived from the [scale
     * config](https://vega.github.io/vega-lite/docs/scale.html#config)'s `bandPaddingInner`.
     */
    @JsonProperty("paddingInner")
    public CornerRadiusUnion getPaddingInner() { return paddingInner; }
    @JsonProperty("paddingInner")
    public void setPaddingInner(CornerRadiusUnion value) { this.paddingInner = value; }

    /**
     * The outer padding (spacing) at the ends of the range of band and point scales, as a
     * fraction of the step size. This value must lie in the range [0,1].
     *
     * __Default value:__ derived from the [scale
     * config](https://vega.github.io/vega-lite/docs/scale.html#config)'s `bandPaddingOuter` for
     * band scales and `pointPadding` for point scales. By default, Vega-Lite sets outer padding
     * such that _width/height = number of unique values * step_.
     */
    @JsonProperty("paddingOuter")
    public CornerRadiusUnion getPaddingOuter() { return paddingOuter; }
    @JsonProperty("paddingOuter")
    public void setPaddingOuter(CornerRadiusUnion value) { this.paddingOuter = value; }

    /**
     * The range of the scale. One of:
     *
     * - A string indicating a [pre-defined named scale
     * range](https://vega.github.io/vega-lite/docs/scale.html#range-config) (e.g., example,
     * `"symbol"`, or `"diverging"`).
     *
     * - For [continuous scales](https://vega.github.io/vega-lite/docs/scale.html#continuous),
     * two-element array indicating  minimum and maximum values, or an array with more than two
     * entries for specifying a [piecewise
     * scale](https://vega.github.io/vega-lite/docs/scale.html#piecewise).
     *
     * - For [discrete](https://vega.github.io/vega-lite/docs/scale.html#discrete) and
     * [discretizing](https://vega.github.io/vega-lite/docs/scale.html#discretizing) scales, an
     * array of desired output values or an object with a `field` property representing the
     * range values.  For example, if a field `color` contains CSS color names, we can set
     * `range` to `{field: "color"}`.
     *
     * __Notes:__
     *
     * 1) For color scales you can also specify a color
     * [`scheme`](https://vega.github.io/vega-lite/docs/scale.html#scheme) instead of `range`.
     *
     * 2) Any directly specified `range` for `x` and `y` channels will be ignored. Range can be
     * customized via the view's corresponding
     * [size](https://vega.github.io/vega-lite/docs/size.html) (`width` and `height`).
     */
    @JsonProperty("range")
    public ScaleRange getRange() { return range; }
    @JsonProperty("range")
    public void setRange(ScaleRange value) { this.range = value; }

    /**
     * Sets the maximum value in the scale range, overriding the `range` property or the default
     * range. This property is only intended for use with scales having continuous ranges.
     */
    @JsonProperty("rangeMax")
    public X getRangeMax() { return rangeMax; }
    @JsonProperty("rangeMax")
    public void setRangeMax(X value) { this.rangeMax = value; }

    /**
     * Sets the minimum value in the scale range, overriding the `range` property or the default
     * range. This property is only intended for use with scales having continuous ranges.
     */
    @JsonProperty("rangeMin")
    public X getRangeMin() { return rangeMin; }
    @JsonProperty("rangeMin")
    public void setRangeMin(X value) { this.rangeMin = value; }

    /**
     * If true, reverses the order of the scale range. __Default value:__ `false`.
     */
    @JsonProperty("reverse")
    public Aria getReverse() { return reverse; }
    @JsonProperty("reverse")
    public void setReverse(Aria value) { this.reverse = value; }

    /**
     * If `true`, rounds numeric output values to integers. This can be helpful for snapping to
     * the pixel grid.
     *
     * __Default value:__ `false`.
     */
    @JsonProperty("round")
    public Aria getRound() { return round; }
    @JsonProperty("round")
    public void setRound(Aria value) { this.round = value; }

    /**
     * A string indicating a color
     * [scheme](https://vega.github.io/vega-lite/docs/scale.html#scheme) name (e.g.,
     * `"category10"` or `"blues"`) or a [scheme parameter
     * object](https://vega.github.io/vega-lite/docs/scale.html#scheme-params).
     *
     * Discrete color schemes may be used with
     * [discrete](https://vega.github.io/vega-lite/docs/scale.html#discrete) or
     * [discretizing](https://vega.github.io/vega-lite/docs/scale.html#discretizing) scales.
     * Continuous color schemes are intended for use with color scales.
     *
     * For the full list of supported schemes, please refer to the [Vega
     * Scheme](https://vega.github.io/vega/docs/schemes/#reference) reference.
     */
    @JsonProperty("scheme")
    public Scheme getScheme() { return scheme; }
    @JsonProperty("scheme")
    public void setScheme(Scheme value) { this.scheme = value; }

    /**
     * The type of scale. Vega-Lite supports the following categories of scale types:
     *
     * 1) [**Continuous Scales**](https://vega.github.io/vega-lite/docs/scale.html#continuous)
     * -- mapping continuous domains to continuous output ranges
     * ([`"linear"`](https://vega.github.io/vega-lite/docs/scale.html#linear),
     * [`"pow"`](https://vega.github.io/vega-lite/docs/scale.html#pow),
     * [`"sqrt"`](https://vega.github.io/vega-lite/docs/scale.html#sqrt),
     * [`"symlog"`](https://vega.github.io/vega-lite/docs/scale.html#symlog),
     * [`"log"`](https://vega.github.io/vega-lite/docs/scale.html#log),
     * [`"time"`](https://vega.github.io/vega-lite/docs/scale.html#time),
     * [`"utc"`](https://vega.github.io/vega-lite/docs/scale.html#utc).
     *
     * 2) [**Discrete Scales**](https://vega.github.io/vega-lite/docs/scale.html#discrete) --
     * mapping discrete domains to discrete
     * ([`"ordinal"`](https://vega.github.io/vega-lite/docs/scale.html#ordinal)) or continuous
     * ([`"band"`](https://vega.github.io/vega-lite/docs/scale.html#band) and
     * [`"point"`](https://vega.github.io/vega-lite/docs/scale.html#point)) output ranges.
     *
     * 3) [**Discretizing
     * Scales**](https://vega.github.io/vega-lite/docs/scale.html#discretizing) -- mapping
     * continuous domains to discrete output ranges
     * [`"bin-ordinal"`](https://vega.github.io/vega-lite/docs/scale.html#bin-ordinal),
     * [`"quantile"`](https://vega.github.io/vega-lite/docs/scale.html#quantile),
     * [`"quantize"`](https://vega.github.io/vega-lite/docs/scale.html#quantize) and
     * [`"threshold"`](https://vega.github.io/vega-lite/docs/scale.html#threshold).
     *
     * __Default value:__ please see the [scale type
     * table](https://vega.github.io/vega-lite/docs/scale.html#type).
     */
    @JsonProperty("type")
    public ScaleType getType() { return type; }
    @JsonProperty("type")
    public void setType(ScaleType value) { this.type = value; }

    /**
     * If `true`, ensures that a zero baseline value is included in the scale domain.
     *
     * __Default value:__ `true` for x and y channels if the quantitative field is not binned
     * and no custom `domain` is provided; `false` otherwise.
     *
     * __Note:__ Log, time, and utc scales do not support `zero`.
     */
    @JsonProperty("zero")
    public Aria getZero() { return zero; }
    @JsonProperty("zero")
    public void setZero(Aria value) { this.zero = value; }
}
