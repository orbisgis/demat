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
 *
 * The data [field](https://vega.github.io/vega-lite/docs/field.html) to sort by.
 *
 * __Default value:__ If unspecified, defaults to the field specified in the outer data
 * reference.
 */
@JsonDeserialize(using = Field.Deserializer.class)
@JsonSerialize(using = Field.Serializer.class)
public class Field {
    public RepeatRef repeatRefValue;
    public String stringValue;

    public Field() {
    }

    public Field(String stringValue) {
        this.stringValue=stringValue;
    }

    static class Deserializer extends JsonDeserializer<Field> {
        @Override
        public Field deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            Field value = new Field();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case VALUE_STRING:
                    String string = jsonParser.readValueAs(String.class);
                    value.stringValue = string;
                    break;
                case START_OBJECT:
                    value.repeatRefValue = jsonParser.readValueAs(RepeatRef.class);
                    break;
                default: throw new IOException("Cannot deserialize Field");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<Field> {
        @Override
        public void serialize(Field obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.repeatRefValue != null) {
                jsonGenerator.writeObject(obj.repeatRefValue);
                return;
            }
            if (obj.stringValue != null) {
                jsonGenerator.writeObject(obj.stringValue);
                return;
            }
            jsonGenerator.writeNull();
        }
    }
}
