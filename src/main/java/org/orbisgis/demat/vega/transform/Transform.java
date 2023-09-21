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
package org.orbisgis.demat.vega.transform;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.orbisgis.demat.vega.*;
import org.orbisgis.demat.vega.legend.LegendText;

import java.util.Arrays;
import java.util.List;

public class Transform {
    private List<AggregatedFieldDef> aggregate;
    private GroupBy groupby;
    private String as;
    private AngleBin bin;
    private String field;
    private String calculate;
    private Double bandwidth;
    private Boolean counts;
    private Boolean cumulative;
    private String density;
    private List<Double> extent;
    private Double maxsteps;
    private Double minsteps;
    private Double steps;
    private Filter filter;
    private List<String> flatten;
    private List<String> fold;
    private List<Double> frame;
    private String impute;
    private String key;
    private Keyvals keyvals;
    private TransformMethod method;
    private Object value;
    private List<JoinAggregateFieldDef> joinaggregate;
    private String loess;
    private String on;
    private String transformDefault;
    private Lookup from;
    private String lookup;
    private List<Double> probs;
    private String quantile;
    private Double step;
    private Double order;
    private Boolean params;
    private String regression;
    private TimeUnitUnion timeUnit;
    private Double sample;
    private StackOffset offset;
    private List<SortField> sort;
    private String stack;
    private Boolean ignorePeers;
    private List<WindowFieldDef> window;
    private Double limit;
    private String op;
    private String pivot;

    /**
     * Array of objects that define fields to aggregate.
     */
    @JsonProperty("aggregate")
    public List<AggregatedFieldDef> getAggregate() { return aggregate; }
    @JsonProperty("aggregate")
    public void setAggregate(List<AggregatedFieldDef> value) { this.aggregate = value; }

    /**
     * The data fields to group by. If not specified, a single group containing all data objects
     * will be used.
     *
     * An optional array of fields by which to group the values. Imputation will then be
     * performed on a per-group basis.
     *
     * The data fields for partitioning the data objects into separate groups. If unspecified,
     * all data points will be in a single group.
     *
     * The data fields to group by.
     *
     * The data fields for partitioning the data objects into separate windows. If unspecified,
     * all data points will be in a single window.
     *
     * The optional data fields to group by. If not specified, a single group containing all
     * data objects will be used.
     */
    @JsonProperty("groupby")
    public GroupBy getGroupby() { return groupby; }
    @JsonProperty("groupby")
    public void setGroupby(GroupBy value) { this.groupby = value; }

    /**
     * The output fields at which to write the start and end bin values. This can be either a
     * string or an array of strings with two elements denoting the name for the fields for bin
     * start and bin end respectively. If a single string (e.g., `"val"`) is provided, the end
     * field will be `"val_end"`.
     *
     * The field for storing the computed formula value.
     *
     * The output fields for the sample value and corresponding density estimate.
     *
     * __Default value:__ `["value", "density"]`
     *
     * The output field names for extracted array values.
     *
     * __Default value:__ The field name of the corresponding array field
     *
     * The output field names for the key and value properties produced by the fold transform.
     * __Default value:__ `["key", "value"]`
     *
     * The output field names for the smoothed points generated by the loess transform.
     *
     * __Default value:__ The field names of the input x and y values.
     *
     * The output fields on which to store the looked up data values.
     *
     * For data lookups, this property may be left blank if `from.fields` has been specified
     * (those field names will be used); if `from.fields` has not been specified, `as` must be a
     * string.
     *
     * For selection lookups, this property is optional: if unspecified, looked up values will
     * be stored under a property named for the selection; and if specified, it must correspond
     * to `from.fields`.
     *
     * The output field names for the probability and quantile values.
     *
     * __Default value:__ `["prob", "value"]`
     *
     * The output field names for the smoothed points generated by the regression transform.
     *
     * __Default value:__ The field names of the input x and y values.
     *
     * The output field to write the timeUnit value.
     *
     * Output field names. This can be either a string or an array of strings with two elements
     * denoting the name for the fields for stack start and stack end respectively. If a single
     * string(e.g., `"val"`) is provided, the end field will be `"val_end"`.
     */
    @JsonProperty("as")
    public String getAs() { return as; }
    @JsonProperty("as")
    public void setAs(String value) { this.as = value; }


    /**
     * An object indicating bin properties, or simply `true` for using default bin parameters.
     */
    @JsonProperty("bin")
    public AngleBin getBin() { return bin; }
    @JsonProperty("bin")
    public void setBin(AngleBin value) { this.bin = value; }

    /**
     * The data field to bin.
     *
     * The data field to apply time unit.
     */
    @JsonProperty("field")
    public String getField() { return field; }
    @JsonProperty("field")
    public void setField(String value) { this.field = value; }

    /**
     * A [expression](https://vega.github.io/vega-lite/docs/types.html#expression) string. Use
     * the variable `datum` to refer to the current data object.
     */
    @JsonProperty("calculate")
    public String getCalculate() { return calculate; }
    @JsonProperty("calculate")
    public void setCalculate(String value) { this.calculate = value; }

    /**
     * The bandwidth (standard deviation) of the Gaussian kernel. If unspecified or set to zero,
     * the bandwidth value is automatically estimated from the input data using Scott’s rule.
     *
     * A bandwidth parameter in the range `[0, 1]` that determines the amount of smoothing.
     *
     * __Default value:__ `0.3`
     */
    @JsonProperty("bandwidth")
    public Double getBandwidth() { return bandwidth; }
    @JsonProperty("bandwidth")
    public void setBandwidth(Double value) { this.bandwidth = value; }

    /**
     * A boolean flag indicating if the output values should be probability estimates (false) or
     * smoothed counts (true).
     *
     * __Default value:__ `false`
     */
    @JsonProperty("counts")
    public Boolean getCounts() { return counts; }
    @JsonProperty("counts")
    public void setCounts(Boolean value) { this.counts = value; }

    /**
     * A boolean flag indicating whether to produce density estimates (false) or cumulative
     * density estimates (true).
     *
     * __Default value:__ `false`
     */
    @JsonProperty("cumulative")
    public Boolean getCumulative() { return cumulative; }
    @JsonProperty("cumulative")
    public void setCumulative(Boolean value) { this.cumulative = value; }

    /**
     * The data field for which to perform density estimation.
     */
    @JsonProperty("density")
    public String getDensity() { return density; }
    @JsonProperty("density")
    public void setDensity(String value) { this.density = value; }

    /**
     * A [min, max] domain from which to sample the distribution. If unspecified, the extent
     * will be determined by the observed minimum and maximum values of the density value
     * field.
     *
     * A [min, max] domain over the independent (x) field for the starting and ending points of
     * the generated trend line.
     */
    @JsonProperty("extent")
    public List<Double> getExtent() { return extent; }
    @JsonProperty("extent")
    public void setExtent(List<Double> value) { this.extent = value; }

    /**
     * The maximum number of samples to take along the extent domain for plotting the density.
     *
     * __Default value:__ `200`
     */
    @JsonProperty("maxsteps")
    public Double getMaxsteps() { return maxsteps; }
    @JsonProperty("maxsteps")
    public void setMaxsteps(Double value) { this.maxsteps = value; }

    /**
     * The minimum number of samples to take along the extent domain for plotting the density.
     *
     * __Default value:__ `25`
     */
    @JsonProperty("minsteps")
    public Double getMinsteps() { return minsteps; }
    @JsonProperty("minsteps")
    public void setMinsteps(Double value) { this.minsteps = value; }

    /**
     * The exact number of samples to take along the extent domain for plotting the density. If
     * specified, overrides both minsteps and maxsteps to set an exact number of uniform
     * samples. Potentially useful in conjunction with a fixed extent to ensure consistent
     * sample points for stacked densities.
     */
    @JsonProperty("steps")
    public Double getSteps() { return steps; }
    @JsonProperty("steps")
    public void setSteps(Double value) { this.steps = value; }

    /**
     * The `filter` property must be a predication definition, which can take one of the
     * following forms:
     *
     * 1) an [expression](https://vega.github.io/vega-lite/docs/types.html#expression) string,
     * where `datum` can be used to refer to the current data object. For example, `{filter:
     * "datum.b2 > 60"}` would make the output data includes only items that have values in the
     * field `b2` over 60.
     *
     * 2) one of the [field
     * predicates](https://vega.github.io/vega-lite/docs/predicate.html#field-predicate):
     * [`equal`](https://vega.github.io/vega-lite/docs/predicate.html#field-equal-predicate),
     * [`lt`](https://vega.github.io/vega-lite/docs/predicate.html#lt-predicate),
     * [`lte`](https://vega.github.io/vega-lite/docs/predicate.html#lte-predicate),
     * [`gt`](https://vega.github.io/vega-lite/docs/predicate.html#gt-predicate),
     * [`gte`](https://vega.github.io/vega-lite/docs/predicate.html#gte-predicate),
     * [`range`](https://vega.github.io/vega-lite/docs/predicate.html#range-predicate),
     * [`oneOf`](https://vega.github.io/vega-lite/docs/predicate.html#one-of-predicate), or
     * [`valid`](https://vega.github.io/vega-lite/docs/predicate.html#valid-predicate),
     *
     * 3) a [selection
     * predicate](https://vega.github.io/vega-lite/docs/predicate.html#selection-predicate),
     * which define the names of a selection that the data point should belong to (or a logical
     * composition of selections).
     *
     * 4) a [logical
     * composition](https://vega.github.io/vega-lite/docs/predicate.html#composition) of (1),
     * (2), or (3).
     */
    @JsonProperty("filter")
    public Filter getFilter() {
        return filter;
    }

    @JsonProperty("filter")
    public void setFilter(Filter value) {
        this.filter = value;
    }

    /**
     * An array of one or more data fields containing arrays to flatten. If multiple fields are
     * specified, their array values should have a parallel structure, ideally with the same
     * length. If the lengths of parallel arrays do not match, the longest array will be used
     * with `null` values added for missing entries.
     */
    @JsonProperty("flatten")
    public List<String> getFlatten() { return flatten; }
    @JsonProperty("flatten")
    public void setFlatten(List<String> value) { this.flatten = value; }

    @JsonProperty("flatten")
    public void setFlatten(String... values) { this.flatten = Arrays.asList(values);  }

    /**
     * An array of data fields indicating the properties to fold.
     */
    @JsonProperty("fold")
    public List<String> getFold() { return fold; }
    @JsonProperty("fold")
    public void setFold(List<String> value) { this.fold = value; }

    /**
     * A frame specification as a two-element array used to control the window over which the
     * specified method is applied. The array entries should either be a number indicating the
     * offset from the current data object, or null to indicate unbounded rows preceding or
     * following the current data object. For example, the value `[-5, 5]` indicates that the
     * window should include five objects preceding and five objects following the current
     * object.
     *
     * __Default value:__:  `[null, null]` indicating that the window includes all objects.
     *
     * A frame specification as a two-element array indicating how the sliding window should
     * proceed. The array entries should either be a number indicating the offset from the
     * current data object, or null to indicate unbounded rows preceding or following the
     * current data object. The default value is `[null, 0]`, indicating that the sliding window
     * includes the current object and all preceding objects. The value `[-5, 5]` indicates that
     * the window should include five objects preceding and five objects following the current
     * object. Finally, `[null, null]` indicates that the window frame should always include all
     * data objects. If you this frame and want to assign the same value to add objects, you can
     * use the simpler [join aggregate
     * transform](https://vega.github.io/vega-lite/docs/joinaggregate.html). The only operators
     * affected are the aggregation operations and the `first_value`, `last_value`, and
     * `nth_value` window operations. The other window operations are not affected by this.
     *
     * __Default value:__:  `[null, 0]` (includes the current object and all preceding objects)
     */
    @JsonProperty("frame")
    public List<Double> getFrame() { return frame; }
    @JsonProperty("frame")
    public void setFrame(List<Double> value) { this.frame = value; }

    /**
     * The data field for which the missing values should be imputed.
     */
    @JsonProperty("impute")
    public String getImpute() { return impute; }
    @JsonProperty("impute")
    public void setImpute(String value) { this.impute = value; }

    /**
     * A key field that uniquely identifies data objects within a group. Missing key values
     * (those occurring in the data but not in the current group) will be imputed.
     */
    @JsonProperty("key")
    public String getKey() { return key; }
    @JsonProperty("key")
    public void setKey(String value) { this.key = value; }

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
     *
     * The functional form of the regression model. One of `"linear"`, `"log"`, `"exp"`,
     * `"pow"`, `"quad"`, or `"poly"`.
     *
     * __Default value:__ `"linear"`
     */
    @JsonProperty("method")
    public TransformMethod getMethod() { return method; }
    @JsonProperty("method")
    public void setMethod(TransformMethod value) { this.method = value; }

    /**
     * The field value to use when the imputation `method` is `"value"`.
     *
     * The data field to populate pivoted fields. The aggregate values of this field become the
     * values of the new pivoted fields.
     */
    @JsonProperty("value")
    public Object getValue() { return value; }
    @JsonProperty("value")
    public void setValue(Object value) { this.value = value; }

    /**
     * The definition of the fields in the join aggregate, and what calculations to use.
     */
    @JsonProperty("joinaggregate")
    public List<JoinAggregateFieldDef> getJoinaggregate() { return joinaggregate; }
    @JsonProperty("joinaggregate")
    public void setJoinaggregate(List<JoinAggregateFieldDef> value) { this.joinaggregate = value; }

    /**
     * The data field of the dependent variable to smooth.
     */
    @JsonProperty("loess")
    public String getLoess() { return loess; }
    @JsonProperty("loess")
    public void setLoess(String value) { this.loess = value; }

    /**
     * The data field of the independent variable to use a predictor.
     */
    @JsonProperty("on")
    public String getOn() { return on; }
    @JsonProperty("on")
    public void setOn(String value) { this.on = value; }

    /**
     * The default value to use if lookup fails.
     *
     * __Default value:__ `null`
     */
    @JsonProperty("default")
    public String getTransformDefault() { return transformDefault; }
    @JsonProperty("default")
    public void setTransformDefault(String value) { this.transformDefault = value; }

    /**
     * Data source or selection for secondary data reference.
     */
    @JsonProperty("from")
    public Lookup getFrom() { return from; }
    @JsonProperty("from")
    public void setFrom(Lookup value) { this.from = value; }

    /**
     * Key in primary data source.
     */
    @JsonProperty("lookup")
    public String getLookup() { return lookup; }
    @JsonProperty("lookup")
    public void setLookup(String value) { this.lookup = value; }

    /**
     * An array of probabilities in the range (0, 1) for which to compute quantile values. If
     * not specified, the *step* parameter will be used.
     */
    @JsonProperty("probs")
    public List<Double> getProbs() { return probs; }
    @JsonProperty("probs")
    public void setProbs(List<Double> value) { this.probs = value; }

    /**
     * The data field for which to perform quantile estimation.
     */
    @JsonProperty("quantile")
    public String getQuantile() { return quantile; }
    @JsonProperty("quantile")
    public void setQuantile(String value) { this.quantile = value; }

    /**
     * A probability step size (default 0.01) for sampling quantile values. All values from
     * one-half the step size up to 1 (exclusive) will be sampled. This parameter is only used
     * if the *probs* parameter is not provided.
     */
    @JsonProperty("step")
    public Double getStep() { return step; }
    @JsonProperty("step")
    public void setStep(Double value) { this.step = value; }

    /**
     * The polynomial order (number of coefficients) for the 'poly' method.
     *
     * __Default value:__ `3`
     */
    @JsonProperty("order")
    public Double getOrder() { return order; }
    @JsonProperty("order")
    public void setOrder(Double value) { this.order = value; }

    /**
     * A boolean flag indicating if the transform should return the regression model parameters
     * (one object per group), rather than trend line points. The resulting objects include a
     * `coef` array of fitted coefficient values (starting with the intercept term and then
     * including terms of increasing order) and an `rSquared` value (indicating the total
     * variance explained by the model).
     *
     * __Default value:__ `false`
     */
    @JsonProperty("params")
    public Boolean getParams() { return params; }
    @JsonProperty("params")
    public void setParams(Boolean value) { this.params = value; }

    /**
     * The data field of the dependent variable to predict.
     */
    @JsonProperty("regression")
    public String getRegression() { return regression; }
    @JsonProperty("regression")
    public void setRegression(String value) { this.regression = value; }

    /**
     * The timeUnit.
     */
    @JsonProperty("timeUnit")
    public TimeUnitUnion getTimeUnit() { return timeUnit; }
    @JsonProperty("timeUnit")
    public void setTimeUnit(TimeUnitUnion value) { this.timeUnit = value; }

    /**
     * The maximum number of data objects to include in the sample.
     *
     * __Default value:__ `1000`
     */
    @JsonProperty("sample")
    public Double getSample() { return sample; }
    @JsonProperty("sample")
    public void setSample(Double value) { this.sample = value; }

    /**
     * Mode for stacking marks. One of `"zero"` (default), `"center"`, or `"normalize"`. The
     * `"zero"` offset will stack starting at `0`. The `"center"` offset will center the stacks.
     * The `"normalize"` offset will compute percentage values for each stack point, with output
     * values in the range `[0,1]`.
     *
     * __Default value:__ `"zero"`
     */
    @JsonProperty("offset")
    public StackOffset getOffset() { return offset; }
    @JsonProperty("offset")
    public void setOffset(StackOffset value) { this.offset = value; }

    /**
     * Field that determines the order of leaves in the stacked charts.
     *
     * A sort field definition for sorting data objects within a window. If two data objects are
     * considered equal by the comparator, they are considered "peer" values of equal rank. If
     * sort is not specified, the order is undefined: data objects are processed in the order
     * they are observed and none are considered peers (the ignorePeers parameter is ignored and
     * treated as if set to `true`).
     */
    @JsonProperty("sort")
    public List<SortField> getSort() { return sort; }
    @JsonProperty("sort")
    public void setSort(List<SortField> value) { this.sort = value; }

    /**
     * The field which is stacked.
     */
    @JsonProperty("stack")
    public String getStack() { return stack; }
    @JsonProperty("stack")
    public void setStack(String value) { this.stack = value; }

    /**
     * Indicates if the sliding window frame should ignore peer values (data that are considered
     * identical by the sort criteria). The default is false, causing the window frame to expand
     * to include all peer values. If set to true, the window frame will be defined by offset
     * values only. This setting only affects those operations that depend on the window frame,
     * namely aggregation operations and the first_value, last_value, and nth_value window
     * operations.
     *
     * __Default value:__ `false`
     */
    @JsonProperty("ignorePeers")
    public Boolean getIgnorePeers() { return ignorePeers; }
    @JsonProperty("ignorePeers")
    public void setIgnorePeers(Boolean value) { this.ignorePeers = value; }

    /**
     * The definition of the fields in the window, and what calculations to use.
     */
    @JsonProperty("window")
    public List<WindowFieldDef> getWindow() { return window; }
    @JsonProperty("window")
    public void setWindow(List<WindowFieldDef> value) { this.window = value; }

    /**
     * An optional parameter indicating the maximum number of pivoted fields to generate. The
     * default (`0`) applies no limit. The pivoted `pivot` names are sorted in ascending order
     * prior to enforcing the limit. __Default value:__ `0`
     */
    @JsonProperty("limit")
    public Double getLimit() { return limit; }
    @JsonProperty("limit")
    public void setLimit(Double value) { this.limit = value; }

    /**
     * The aggregation operation to apply to grouped `value` field values. __Default value:__
     * `sum`
     */
    @JsonProperty("op")
    public String getOp() { return op; }
    @JsonProperty("op")
    public void setOp(String value) { this.op = value; }

    /**
     * The data field to pivot on. The unique values of this field become new field names in the
     * output stream.
     */
    @JsonProperty("pivot")
    public String getPivot() { return pivot; }
    @JsonProperty("pivot")
    public void setPivot(String value) { this.pivot = value; }
}
