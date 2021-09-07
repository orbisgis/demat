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
import org.orbisgis.demat.api.IEncodingProperty;

/**
 * X coordinates of the marks, or width of horizontal `"bar"` and `"area"` without specified
 * `x2` or `width`.
 *
 * The `value` of this channel can be a number or a string `"width"` for the width of the
 * plot.
 *
 * Y coordinates of the marks, or height of vertical `"bar"` and `"area"` without specified
 * `y2` or `height`.
 *
 * The `value` of this channel can be a number or a string `"height"` for the height of the
 * plot.
 *
 * Definition object for a constant value (primitive value or gradient definition) of an
 * encoding channel.
 */
public class X implements IEncodingProperty {
    private Aggregate aggregate;
    private Axis axis;
    private Double band;
    private DescriptionBin bin;
    private Field field;
    private ImputeParams impute;
    private Scale scale;
    private SortUnion sort;
    private Stack stack;
    private TimeUnitUnion timeUnit;
    private LegendText title;
    private Type type;
    private PrimitiveValue datum;
    private Coordinate value;

    /**
     * Aggregation function for the field (e.g., `"mean"`, `"sum"`, `"median"`, `"min"`,
     * `"max"`, `"count"`).
     *
     * __Default value:__ `undefined` (None)
     *
     * __See also:__ [`aggregate`](https://vega.github.io/vega-lite/docs/aggregate.html)
     * documentation.
     */
    @JsonProperty("aggregate")
    public Aggregate getAggregate() { return aggregate; }
    @JsonProperty("aggregate")
    public void setAggregate(Aggregate value) { this.aggregate = value; }

    /**
     * An object defining properties of axis's gridlines, ticks and labels. If `null`, the axis
     * for the encoding channel will be removed.
     *
     * __Default value:__ If undefined, default [axis
     * properties](https://vega.github.io/vega-lite/docs/axis.html) are applied.
     *
     * __See also:__ [`axis`](https://vega.github.io/vega-lite/docs/axis.html) documentation.
     */
    @JsonProperty("axis")
    public Axis getAxis() { return axis; }
    @JsonProperty("axis")
    public void setAxis(Axis value) { this.axis = value; }

    /**
     * For rect-based marks (`rect`, `bar`, and `image`), mark size relative to bandwidth of
     * [band scales](https://vega.github.io/vega-lite/docs/scale.html#band), bins or time units.
     * If set to `1`, the mark size is set to the bandwidth, the bin interval, or the time unit
     * interval. If set to `0.5`, the mark size is half of the bandwidth or the time unit
     * interval.
     *
     * For other marks, relative position on a band of a stacked, binned, time unit or band
     * scale. If set to `0`, the marks will be positioned at the beginning of the band. If set
     * to `0.5`, the marks will be positioned in the middle of the band.
     */
    @JsonProperty("band")
    public Double getBand() { return band; }
    @JsonProperty("band")
    public void setBand(Double value) { this.band = value; }

    /**
     * A flag for binning a `quantitative` field, [an object defining binning
     * parameters](https://vega.github.io/vega-lite/docs/bin.html#params), or indicating that
     * the data for `x` or `y` channel are binned before they are imported into Vega-Lite
     * (`"binned"`).
     *
     * - If `true`, default [binning parameters](https://vega.github.io/vega-lite/docs/bin.html)
     * will be applied.
     *
     * - If `"binned"`, this indicates that the data for the `x` (or `y`) channel are already
     * binned. You can map the bin-start field to `x` (or `y`) and the bin-end field to `x2` (or
     * `y2`). The scale and axis will be formatted similar to binning in Vega-Lite.  To adjust
     * the axis ticks based on the bin step, you can also set the axis's
     * [`tickMinStep`](https://vega.github.io/vega-lite/docs/axis.html#ticks) property.
     *
     * __Default value:__ `false`
     *
     * __See also:__ [`bin`](https://vega.github.io/vega-lite/docs/bin.html) documentation.
     */
    @JsonProperty("bin")
    public DescriptionBin getBin() { return bin; }
    @JsonProperty("bin")
    public void setBin(DescriptionBin value) { this.bin = value; }

    /**
     * __Required.__ A string defining the name of the field from which to pull a data value or
     * an object defining iterated values from the
     * [`repeat`](https://vega.github.io/vega-lite/docs/repeat.html) operator.
     *
     * __See also:__ [`field`](https://vega.github.io/vega-lite/docs/field.html) documentation.
     *
     * __Notes:__ 1)  Dots (`.`) and brackets (`[` and `]`) can be used to access nested objects
     * (e.g., `"field": "foo.bar"` and `"field": "foo['bar']"`). If field names contain dots or
     * brackets but are not nested, you can use `\\` to escape dots and brackets (e.g.,
     * `"a\\.b"` and `"a\\[0\\]"`). See more details about escaping in the [field
     * documentation](https://vega.github.io/vega-lite/docs/field.html). 2) `field` is not
     * required if `aggregate` is `count`.
     */
    @JsonProperty("field")
    public Field getField() { return field; }
    @JsonProperty("field")
    public void setField(Field value) { this.field = value; }

    /**
     * An object defining the properties of the Impute Operation to be applied. The field value
     * of the other positional channel is taken as `key` of the `Impute` Operation. The field of
     * the `color` channel if specified is used as `groupby` of the `Impute` Operation.
     *
     * __See also:__ [`impute`](https://vega.github.io/vega-lite/docs/impute.html) documentation.
     */
    @JsonProperty("impute")
    public ImputeParams getImpute() { return impute; }
    @JsonProperty("impute")
    public void setImpute(ImputeParams value) { this.impute = value; }

    /**
     * An object defining properties of the channel's scale, which is the function that
     * transforms values in the data domain (numbers, dates, strings, etc) to visual values
     * (pixels, colors, sizes) of the encoding channels.
     *
     * If `null`, the scale will be [disabled and the data value will be directly
     * encoded](https://vega.github.io/vega-lite/docs/scale.html#disable).
     *
     * __Default value:__ If undefined, default [scale
     * properties](https://vega.github.io/vega-lite/docs/scale.html) are applied.
     *
     * __See also:__ [`scale`](https://vega.github.io/vega-lite/docs/scale.html) documentation.
     */
    @JsonProperty("scale")
    public Scale getScale() { return scale; }
    @JsonProperty("scale")
    public void setScale(Scale value) { this.scale = value; }

    /**
     * Sort order for the encoded field.
     *
     * For continuous fields (quantitative or temporal), `sort` can be either `"ascending"` or
     * `"descending"`.
     *
     * For discrete fields, `sort` can be one of the following: - `"ascending"` or
     * `"descending"` -- for sorting by the values' natural order in JavaScript. - [A string
     * indicating an encoding channel name to sort
     * by](https://vega.github.io/vega-lite/docs/sort.html#sort-by-encoding) (e.g., `"x"` or
     * `"y"`) with an optional minus prefix for descending sort (e.g., `"-x"` to sort by
     * x-field, descending). This channel string is short-form of [a sort-by-encoding
     * definition](https://vega.github.io/vega-lite/docs/sort.html#sort-by-encoding). For
     * example, `"sort": "-x"` is equivalent to `"sort": {"encoding": "x", "order":
     * "descending"}`. - [A sort field
     * definition](https://vega.github.io/vega-lite/docs/sort.html#sort-field) for sorting by
     * another field. - [An array specifying the field values in preferred
     * order](https://vega.github.io/vega-lite/docs/sort.html#sort-array). In this case, the
     * sort order will obey the values in the array, followed by any unspecified values in their
     * original order. For discrete time field, values in the sort array can be [date-time
     * definition objects](types#datetime). In addition, for time units `"month"` and `"day"`,
     * the values can be the month or day names (case insensitive) or their 3-letter initials
     * (e.g., `"Mon"`, `"Tue"`). - `null` indicating no sort.
     *
     * __Default value:__ `"ascending"`
     *
     * __Note:__ `null` and sorting by another channel is not supported for `row` and `column`.
     *
     * __See also:__ [`sort`](https://vega.github.io/vega-lite/docs/sort.html) documentation.
     */
    @JsonProperty("sort")
    public SortUnion getSort() { return sort; }
    @JsonProperty("sort")
    public void setSort(SortUnion value) { this.sort = value; }

    /**
     * Type of stacking offset if the field should be stacked. `stack` is only applicable for
     * `x`, `y`, `theta`, and `radius` channels with continuous domains. For example, `stack` of
     * `y` can be used to customize stacking for a vertical bar chart.
     *
     * `stack` can be one of the following values: - `"zero"` or `true`: stacking with baseline
     * offset at zero value of the scale (for creating typical stacked
     * [bar](https://vega.github.io/vega-lite/docs/stack.html#bar) and
     * [area](https://vega.github.io/vega-lite/docs/stack.html#area) chart). - `"normalize"` -
     * stacking with normalized domain (for creating [normalized stacked bar and area
     * charts](https://vega.github.io/vega-lite/docs/stack.html#normalized). <br/> -`"center"` -
     * stacking with center baseline (for
     * [streamgraph](https://vega.github.io/vega-lite/docs/stack.html#streamgraph)). - `null` or
     * `false` - No-stacking. This will produce layered
     * [bar](https://vega.github.io/vega-lite/docs/stack.html#layered-bar-chart) and area
     * chart.
     *
     * __Default value:__ `zero` for plots with all of the following conditions are true: (1)
     * the mark is `bar`, `area`, or `arc`; (2) the stacked measure channel (x or y) has a
     * linear scale; (3) At least one of non-position channels mapped to an unaggregated field
     * that is different from x and y. Otherwise, `null` by default.
     *
     * __See also:__ [`stack`](https://vega.github.io/vega-lite/docs/stack.html) documentation.
     */
    @JsonProperty("stack")
    public Stack getStack() { return stack; }
    @JsonProperty("stack")
    public void setStack(Stack value) { this.stack = value; }

    /**
     * Time unit (e.g., `year`, `yearmonth`, `month`, `hours`) for a temporal field. or [a
     * temporal field that gets casted as
     * ordinal](https://vega.github.io/vega-lite/docs/type.html#cast).
     *
     * __Default value:__ `undefined` (None)
     *
     * __See also:__ [`timeUnit`](https://vega.github.io/vega-lite/docs/timeunit.html)
     * documentation.
     */
    @JsonProperty("timeUnit")
    public TimeUnitUnion getTimeUnit() { return timeUnit; }
    @JsonProperty("timeUnit")
    public void setTimeUnit(TimeUnitUnion value) { this.timeUnit = value; }

    /**
     * A title for the field. If `null`, the title will be removed.
     *
     * __Default value:__  derived from the field's name and transformation function
     * (`aggregate`, `bin` and `timeUnit`). If the field has an aggregate function, the function
     * is displayed as part of the title (e.g., `"Sum of Profit"`). If the field is binned or
     * has a time unit applied, the applied function is shown in parentheses (e.g., `"Profit
     * (binned)"`, `"Transaction Date (year-month)"`). Otherwise, the title is simply the field
     * name.
     *
     * __Notes__:
     *
     * 1) You can customize the default field title format by providing the
     * [`fieldTitle`](https://vega.github.io/vega-lite/docs/config.html#top-level-config)
     * property in the [config](https://vega.github.io/vega-lite/docs/config.html) or
     * [`fieldTitle` function via the `compile` function's
     * options](https://vega.github.io/vega-lite/docs/compile.html#field-title).
     *
     * 2) If both field definition's `title` and axis, header, or legend `title` are defined,
     * axis/header/legend title will be used.
     */
    @JsonProperty("title")
    public LegendText getTitle() { return title; }
    @JsonProperty("title")
    public void setTitle(LegendText value) { this.title = value; }

    /**
     * The type of measurement (`"quantitative"`, `"temporal"`, `"ordinal"`, or `"nominal"`) for
     * the encoded field or constant value (`datum`). It can also be a `"geojson"` type for
     * encoding ['geoshape'](https://vega.github.io/vega-lite/docs/geoshape.html).
     *
     * Vega-Lite automatically infers data types in many cases as discussed below. However, type
     * is required for a field if: (1) the field is not nominal and the field encoding has no
     * specified `aggregate` (except `argmin` and `argmax`), `bin`, scale type, custom `sort`
     * order, nor `timeUnit` or (2) if you wish to use an ordinal scale for a field with `bin`
     * or `timeUnit`.
     *
     * __Default value:__
     *
     * 1) For a data `field`, `"nominal"` is the default data type unless the field encoding has
     * `aggregate`, `channel`, `bin`, scale type, `sort`, or `timeUnit` that satisfies the
     * following criteria: - `"quantitative"` is the default type if (1) the encoded field
     * contains `bin` or `aggregate` except `"argmin"` and `"argmax"`, (2) the encoding channel
     * is `latitude` or `longitude` channel or (3) if the specified scale type is [a
     * quantitative scale](https://vega.github.io/vega-lite/docs/scale.html#type). -
     * `"temporal"` is the default type if (1) the encoded field contains `timeUnit` or (2) the
     * specified scale type is a time or utc scale - `ordinal""` is the default type if (1) the
     * encoded field contains a [custom `sort`
     * order](https://vega.github.io/vega-lite/docs/sort.html#specifying-custom-sort-order), (2)
     * the specified scale type is an ordinal/point/band scale, or (3) the encoding channel is
     * `order`.
     *
     * 2) For a constant value in data domain (`datum`): - `"quantitative"` if the datum is a
     * number - `"nominal"` if the datum is a string - `"temporal"` if the datum is [a date time
     * object](https://vega.github.io/vega-lite/docs/datetime.html)
     *
     * __Note:__ - Data `type` describes the semantics of the data rather than the primitive
     * data types (number, string, etc.). The same primitive data type can have different types
     * of measurement. For example, numeric data can represent quantitative, ordinal, or nominal
     * data. - Data values for a temporal field can be either a date-time string (e.g.,
     * `"2015-03-07 12:32:17"`, `"17:01"`, `"2015-03-16"`. `"2015"`) or a timestamp number
     * (e.g., `1552199579097`). - When using with
     * [`bin`](https://vega.github.io/vega-lite/docs/bin.html), the `type` property can be
     * either `"quantitative"` (for using a linear bin scale) or [`"ordinal"` (for using an
     * ordinal bin scale)](https://vega.github.io/vega-lite/docs/type.html#cast-bin). - When
     * using with [`timeUnit`](https://vega.github.io/vega-lite/docs/timeunit.html), the `type`
     * property can be either `"temporal"` (default, for using a temporal scale) or [`"ordinal"`
     * (for using an ordinal scale)](https://vega.github.io/vega-lite/docs/type.html#cast-bin).
     * - When using with [`aggregate`](https://vega.github.io/vega-lite/docs/aggregate.html),
     * the `type` property refers to the post-aggregation data type. For example, we can
     * calculate count `distinct` of a categorical field `"cat"` using `{"aggregate":
     * "distinct", "field": "cat"}`. The `"type"` of the aggregate output is `"quantitative"`. -
     * Secondary channels (e.g., `x2`, `y2`, `xError`, `yError`) do not have `type` as they must
     * have exactly the same type as their primary channels (e.g., `x`, `y`).
     *
     * __See also:__ [`type`](https://vega.github.io/vega-lite/docs/type.html) documentation.
     */
    @JsonProperty("type")
    public Type getType() { return type; }
    @JsonProperty("type")
    public void setType(Type value) { this.type = value; }

    /**
     * A constant value in data domain.
     */
    @JsonProperty("datum")
    public PrimitiveValue getDatum() { return datum; }
    @JsonProperty("datum")
    public void setDatum(PrimitiveValue value) { this.datum = value; }

    /**
     * A constant value in visual domain (e.g., `"red"` / `"#0099ff"` / [gradient
     * definition](https://vega.github.io/vega-lite/docs/types.html#gradient) for color, values
     * between `0` to `1` for opacity).
     */
    @JsonProperty("value")
    public Coordinate getValue() { return value; }
    @JsonProperty("value")
    public void setValue(Coordinate value) { this.value = value; }


    /*
    ---
    Additional methods to simplify the use
    ---
    */

    /**
     * Declare as quantitative value
     * @return
     */
    public X quantitative() {
        this.setType(Type.QUANTITATIVE);
        return this;
    }

    /**
     * Declare as nominal value
     * @return
     */
    public X nominal() {
        this.setType(Type.NOMINAL);
        return this;
    }

    /**
     * Declare as ordinal value
     * @return
     */
    public X ordinal() {
        this.setType(Type.ORDINAL);
        return this;
    }

    /**
     * Declare as temporal value
     * @return
     */
    public X temporal() {
        this.setType(Type.TEMPORAL);
        return this;
    }

    /**
     * Count X values
     * @return
     */
    public X count() {
        Aggregate aggregate = new Aggregate();
        aggregate.enumValue=NonArgAggregateOp.COUNT;
        this.setAggregate(aggregate);
        return this;
    }

    public X timeUnit(TimeUnit timeUnit) {
        this.setTimeUnit(new TimeUnitUnion(timeUnit));
        return this;
    }

    /**
     * Discretizes numeric values into a set of bins
     * @param isBin
     * @return
     */
    public X bin(boolean isBin){
        DescriptionBin descriptionBin = new DescriptionBin();
        descriptionBin.isBin=true;
        this.setBin(descriptionBin);
        return this;
    }

    /**
     * Set a sum operator on the X value
     * @return
     */
    public X sum(){
        Aggregate aggregate = new Aggregate();
        aggregate.enumValue = NonArgAggregateOp.SUM;
        this.setAggregate(aggregate);
        return this;
    }
}
