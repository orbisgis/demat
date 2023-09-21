package org.orbisgis.demat.vega.encoding;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.orbisgis.demat.vega.Type;
import org.orbisgis.demat.vega.legend.LegendText;

import java.util.Arrays;

public abstract class ChannelCommonMethods<T> {

    public Type type;
    public LegendText title;

    /**
     * The type of measurement (`"quantitative"`, `"temporal"`, `"ordinal"`, or `"nominal"`) for
     * the encoded field or constant value (`datum`). It can also be a `"geojson"` type for
     * encoding ['geoshape'](https://vega.github.io/vega-lite/docs/geoshape.html).
     * <p>
     * Vega-Lite automatically infers data types in many cases as discussed below. However, type
     * is required for a field if: (1) the field is not nominal and the field encoding has no
     * specified `aggregate` (except `argmin` and `argmax`), `bin`, scale type, custom `sort`
     * order, nor `timeUnit` or (2) if you wish to use an ordinal scale for a field with `bin`
     * or `timeUnit`.
     * <p>
     * __Default value:__
     * <p>
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
     * <p>
     * 2) For a constant value in data domain (`datum`): - `"quantitative"` if the datum is a
     * number - `"nominal"` if the datum is a string - `"temporal"` if the datum is [a date time
     * object](https://vega.github.io/vega-lite/docs/datetime.html)
     * <p>
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
     * <p>
     * __See also:__ [`type`](https://vega.github.io/vega-lite/docs/type.html) documentation.
     */
    @JsonProperty("type")
    public Type getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(Type value) {
        this.type = value;
    }

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

    /*
    ---
    Additional methods to simplify the use
    ---
    */

    /**
     * Declare as quantitative value
     *
     * @return
     */
    public T quantitative() {
        setType(Type.QUANTITATIVE);
        return (T) this;
    }

    /**
     * Declare as nominal value
     *
     * @return
     */
    public T nominal() {
        setType(Type.NOMINAL);
        return (T) this;
    }

    /**
     * Declare as ordinal value
     *
     * @return
     */
    public T ordinal() {
        setType(Type.ORDINAL);
        return (T) this;
    }

    /**
     * Declare as temporal value
     *
     * @return
     */
    public T temporal() {
        setType(Type.TEMPORAL);
        return (T) this;
    }

    /**
     * Set a title
     *
     * @return
     */
    public T title(String title) {
        LegendText legendText = new LegendText();
        legendText.title=title;
        setTitle(legendText);
        return (T) this;
    }

    /**
     * Set titles
     *
     * @return
     */
    public T title(String... titles) {
        LegendText legendText = new LegendText();
        legendText.titles= Arrays.asList(titles);
        setTitle(legendText);
        return (T) this;
    }

}
