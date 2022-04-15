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
 * Predicate for triggering the condition
 *
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
@JsonDeserialize(using = PredicateCompositionElement.Deserializer.class)
@JsonSerialize(using = PredicateCompositionElement.Serializer.class)
public class PredicateCompositionElement {
    public Predicate predicateValue;
    public String stringValue;

    static class Deserializer extends JsonDeserializer<PredicateCompositionElement> {
        @Override
        public PredicateCompositionElement deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            PredicateCompositionElement value = new PredicateCompositionElement();
            switch (jsonParser.currentToken()) {
                case VALUE_STRING:
                    String string = jsonParser.readValueAs(String.class);
                    value.stringValue = string;
                    break;
                case START_OBJECT:
                    value.predicateValue = jsonParser.readValueAs(Predicate.class);
                    break;
                default: throw new IOException("Cannot deserialize PredicateCompositionElement");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<PredicateCompositionElement> {
        @Override
        public void serialize(PredicateCompositionElement obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.predicateValue != null) {
                jsonGenerator.writeObject(obj.predicateValue);
                return;
            }
            if (obj.stringValue != null) {
                jsonGenerator.writeObject(obj.stringValue);
                return;
            }
            throw new IOException("PredicateCompositionElement must not be null");
        }
    }
}
