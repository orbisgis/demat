package org.orbisgis.demat.v4;

import com.fasterxml.jackson.annotation.*;

/**
 * A field definition for the (flexible) facet of trellis plots.
 *
 * If either `row` or `column` is specified, this channel will be ignored.
 */
public class FacetEncodingFieldDef {
    private Aggregate aggregate;
    private CoordinateAlign align;
    private Double band;
    private AngleBin bin;
    private Bounds bounds;
    private Center center;
    private Double columns;
    private Field field;
    private Header header;
    private PurpleSortArray sort;
    private Spacing spacing;
    private TimeUnitUnion timeUnit;
    private LegendText title;
    private StandardType type;

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
     * The alignment to apply to grid rows and columns. The supported string values are `"all"`,
     * `"each"`, and `"none"`.
     *
     * - For `"none"`, a flow layout will be used, in which adjacent subviews are simply placed
     * one after the other. - For `"each"`, subviews will be aligned into a clean grid
     * structure, but each row or column may be of variable size. - For `"all"`, subviews will
     * be aligned and each row or column will be sized identically based on the maximum observed
     * size. String values for this property will be applied to both grid rows and columns.
     *
     * Alternatively, an object value of the form `{"row": string, "column": string}` can be
     * used to supply different alignments for rows and columns.
     *
     * __Default value:__ `"all"`.
     */
    @JsonProperty("align")
    public CoordinateAlign getAlign() { return align; }
    @JsonProperty("align")
    public void setAlign(CoordinateAlign value) { this.align = value; }

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
    public AngleBin getBin() { return bin; }
    @JsonProperty("bin")
    public void setBin(AngleBin value) { this.bin = value; }

    /**
     * The bounds calculation method to use for determining the extent of a sub-plot. One of
     * `full` (the default) or `flush`.
     *
     * - If set to `full`, the entire calculated bounds (including axes, title, and legend) will
     * be used. - If set to `flush`, only the specified width and height values for the sub-view
     * will be used. The `flush` setting can be useful when attempting to place sub-plots
     * without axes or legends into a uniform grid structure.
     *
     * __Default value:__ `"full"`
     */
    @JsonProperty("bounds")
    public Bounds getBounds() { return bounds; }
    @JsonProperty("bounds")
    public void setBounds(Bounds value) { this.bounds = value; }

    /**
     * Boolean flag indicating if subviews should be centered relative to their respective rows
     * or columns.
     *
     * An object value of the form `{"row": boolean, "column": boolean}` can be used to supply
     * different centering values for rows and columns.
     *
     * __Default value:__ `false`
     */
    @JsonProperty("center")
    public Center getCenter() { return center; }
    @JsonProperty("center")
    public void setCenter(Center value) { this.center = value; }

    /**
     * The number of columns to include in the view composition layout.
     *
     * __Default value__: `undefined` -- An infinite number of columns (a single row) will be
     * assumed. This is equivalent to `hconcat` (for `concat`) and to using the `column` channel
     * (for `facet` and `repeat`).
     *
     * __Note__:
     *
     * 1) This property is only for: - the general (wrappable) `concat` operator (not
     * `hconcat`/`vconcat`) - the `facet` and `repeat` operator with one field/repetition
     * definition (without row/column nesting)
     *
     * 2) Setting the `columns` to `1` is equivalent to `vconcat` (for `concat`) and to using
     * the `row` channel (for `facet` and `repeat`).
     */
    @JsonProperty("columns")
    public Double getColumns() { return columns; }
    @JsonProperty("columns")
    public void setColumns(Double value) { this.columns = value; }

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
     * An object defining properties of a facet's header.
     */
    @JsonProperty("header")
    public Header getHeader() { return header; }
    @JsonProperty("header")
    public void setHeader(Header value) { this.header = value; }

    /**
     * Sort order for the encoded field.
     *
     * For continuous fields (quantitative or temporal), `sort` can be either `"ascending"` or
     * `"descending"`.
     *
     * For discrete fields, `sort` can be one of the following: - `"ascending"` or
     * `"descending"` -- for sorting by the values' natural order in JavaScript. - [A sort field
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
     * __Note:__ `null` is not supported for `row` and `column`.
     */
    @JsonProperty("sort")
    public PurpleSortArray getSort() { return sort; }
    @JsonProperty("sort")
    public void setSort(PurpleSortArray value) { this.sort = value; }

    /**
     * The spacing in pixels between sub-views of the composition operator. An object of the
     * form `{"row": number, "column": number}` can be used to set different spacing values for
     * rows and columns.
     *
     * __Default value__: Depends on `"spacing"` property of [the view composition
     * configuration](https://vega.github.io/vega-lite/docs/config.html#view-config) (`20` by
     * default)
     */
    @JsonProperty("spacing")
    public Spacing getSpacing() { return spacing; }
    @JsonProperty("spacing")
    public void setSpacing(Spacing value) { this.spacing = value; }

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
    public StandardType getType() { return type; }
    @JsonProperty("type")
    public void setType(StandardType value) { this.type = value; }
}
