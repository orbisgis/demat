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

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.IOException;

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
@JsonDeserialize(using = Scheme.Deserializer.class)
@JsonSerialize(using = Scheme.Serializer.class)
public class Scheme {
    public SchemeParams schemeParamsValue;
    public String value;

    static class Deserializer extends JsonDeserializer<Scheme> {
        @Override
        public Scheme deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            Scheme value = new Scheme();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case VALUE_STRING:
                    String string = jsonParser.readValueAs(String.class);
                    value.value = string;
                    break;
                case START_OBJECT:
                    value.schemeParamsValue = jsonParser.readValueAs(SchemeParams.class);
                    break;
                default: throw new IOException("Cannot deserialize Scheme");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<Scheme> {
        @Override
        public void serialize(Scheme obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.schemeParamsValue != null) {
                jsonGenerator.writeObject(obj.schemeParamsValue);
                return;
            }
            if (obj.value != null) {
                jsonGenerator.writeObject(obj.value);
                return;
            }
            jsonGenerator.writeNull();
        }
    }

    //TODO https://vega.github.io/vega/docs/schemes/
    static Scheme redpurple() {
        Scheme scheme = new Scheme();
        scheme.value = "redpurple";
        return scheme;
    }

}
