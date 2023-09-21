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

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;
import com.fasterxml.jackson.core.type.*;
import java.util.List;

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
@JsonDeserialize(using = SortUnion.Deserializer.class)
@JsonSerialize(using = SortUnion.Serializer.class)
public class SortUnion {
    public List<SelectionInitInterval> unionArrayValue;
    public EncodingSortField encodingSortFieldValue;
    public Sort enumValue;

    static class Deserializer extends JsonDeserializer<SortUnion> {
        @Override
        public SortUnion deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            SortUnion value = new SortUnion();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case VALUE_STRING:
                    String string = jsonParser.readValueAs(String.class);
                    try {
                        value.enumValue = Sort.forValue(string);
                    } catch (Exception ex) {
                        // Ignored
                    }
                    break;
                case START_ARRAY:
                    value.unionArrayValue = jsonParser.readValueAs(new TypeReference<List<SelectionInitInterval>>() {});
                    break;
                case START_OBJECT:
                    value.encodingSortFieldValue = jsonParser.readValueAs(EncodingSortField.class);
                    break;
                default: throw new IOException("Cannot deserialize SortUnion");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<SortUnion> {
        @Override
        public void serialize(SortUnion obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.unionArrayValue != null) {
                jsonGenerator.writeObject(obj.unionArrayValue);
                return;
            }
            if (obj.encodingSortFieldValue != null) {
                jsonGenerator.writeObject(obj.encodingSortFieldValue);
                return;
            }
            if (obj.enumValue != null) {
                jsonGenerator.writeObject(obj.enumValue);
                return;
            }
            jsonGenerator.writeNull();
        }
    }
}
