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
package org.orbisgis.demat.vega.encoding;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.orbisgis.demat.vega.*;

/**
 * Text of the `text` mark.
 *
 * A FieldDef with Condition<ValueDef> {    condition: {value: ...},    field: ...,    ... }
 */
public class Text extends ChannelCommonMethods<Text>{
    private Aggregate aggregate;
    private Double band;
    private DescriptionBin bin;
    private TextCondition condition;
    private Field field;
    private Format format;
    private String formatType;
    private String labelExpr;
    private TimeUnitUnion timeUnit;
    private PrimitiveValue datum;
    private TextDef value;

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
     * One or more value definition(s) with [a selection or a test
     * predicate](https://vega.github.io/vega-lite/docs/condition.html).
     *
     * __Note:__ A field definition's `condition` property can only contain [conditional value
     * definitions](https://vega.github.io/vega-lite/docs/condition.html#value) since Vega-Lite
     * only allows at most one encoded field per encoding channel.
     *
     * A field definition or one or more value definition(s) with a selection predicate.
     */
    @JsonProperty("condition")
    public TextCondition getCondition() { return condition; }
    @JsonProperty("condition")
    public void setCondition(TextCondition value) { this.condition = value; }

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
     * When used with the default `"number"` and `"time"` format type, the text formatting
     * pattern for labels of guides (axes, legends, headers) and text marks.
     *
     * - If the format type is `"number"` (e.g., for quantitative fields), this is D3's [number
     * format pattern](https://github.com/d3/d3-format#locale_format). - If the format type is
     * `"time"` (e.g., for temporal fields), this is D3's [time format
     * pattern](https://github.com/d3/d3-time-format#locale_format).
     *
     * See the [format documentation](https://vega.github.io/vega-lite/docs/format.html) for
     * more examples.
     *
     * When used with a [custom
     * `formatType`](https://vega.github.io/vega-lite/docs/config.html#custom-format-type), this
     * value will be passed as `format` alongside `datum.value` to the registered function.
     *
     * __Default value:__  Derived from
     * [numberFormat](https://vega.github.io/vega-lite/docs/config.html#format) config for
     * number format and from
     * [timeFormat](https://vega.github.io/vega-lite/docs/config.html#format) config for time
     * format.
     */
    @JsonProperty("format")
    public Format getFormat() { return format; }
    @JsonProperty("format")
    public void setFormat(Format value) { this.format = value; }

    /**
     * The format type for labels. One of `"number"`, `"time"`, or a [registered custom format
     * type](https://vega.github.io/vega-lite/docs/config.html#custom-format-type).
     *
     * __Default value:__ - `"time"` for temporal fields and ordinal and nominal fields with
     * `timeUnit`. - `"number"` for quantitative fields as well as ordinal and nominal fields
     * without `timeUnit`.
     */
    @JsonProperty("formatType")
    public String getFormatType() { return formatType; }
    @JsonProperty("formatType")
    public void setFormatType(String value) { this.formatType = value; }

    /**
     * [Vega expression](https://vega.github.io/vega/docs/expressions/) for customizing labels
     * text.
     *
     * __Note:__ The label text and value can be assessed via the `label` and `value` properties
     * of the axis's backing `datum` object.
     */
    @JsonProperty("labelExpr")
    public String getLabelExpr() { return labelExpr; }
    @JsonProperty("labelExpr")
    public void setLabelExpr(String value) { this.labelExpr = value; }

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
    public TextDef getValue() { return value; }
    @JsonProperty("value")
    public void setValue(TextDef value) { this.value = value; }
}
