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

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

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
 *
 * Data type based on level of measurement
 */
public enum Type {
    GEOJSON, NOMINAL, ORDINAL, QUANTITATIVE, TEMPORAL;

    @JsonValue
    public String toValue() {
        switch (this) {
            case GEOJSON: return "geojson";
            case NOMINAL: return "nominal";
            case ORDINAL: return "ordinal";
            case QUANTITATIVE: return "quantitative";
            case TEMPORAL: return "temporal";
        }
        return null;
    }

    @JsonCreator
    public static Type forValue(String value) throws IOException {
        if (value.equals("geojson")) return GEOJSON;
        if (value.equals("nominal")) return NOMINAL;
        if (value.equals("ordinal")) return ORDINAL;
        if (value.equals("quantitative")) return QUANTITATIVE;
        if (value.equals("temporal")) return TEMPORAL;
        throw new IOException("Cannot deserialize Type");
    }
}
