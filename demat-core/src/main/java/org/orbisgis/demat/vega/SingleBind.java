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

import java.util.Map;

/**
 * When set, a selection is populated by input elements (also known as dynamic query
 * widgets) or by interacting with the corresponding legend. Direct manipulation interaction
 * is disabled by default; to re-enable it, set the selection's
 * [`on`](https://vega.github.io/vega-lite/docs/selection.html#common-selection-properties)
 * property.
 *
 * Legend bindings are restricted to selections that only specify a single field or
 * encoding.
 *
 * Query widget binding takes the form of Vega's [input element binding
 * definition](https://vega.github.io/vega/docs/signals/#bind) or can be a mapping between
 * projected field/encodings and binding definitions.
 *
 * __See also:__ [`bind`](https://vega.github.io/vega-lite/docs/bind.html) documentation.
 */
@JsonDeserialize(using = SingleBind.Deserializer.class)
@JsonSerialize(using = SingleBind.Serializer.class)
public class SingleBind {
    public Map<String, FluffyStream> unionMapValue;
    public String stringValue;

    static class Deserializer extends JsonDeserializer<SingleBind> {
        @Override
        public SingleBind deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            SingleBind value = new SingleBind();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case VALUE_STRING:
                    String string = jsonParser.readValueAs(String.class);
                    value.stringValue = string;
                    break;
                case START_OBJECT:
                    value.unionMapValue = jsonParser.readValueAs(Map.class);
                    break;
                default: throw new IOException("Cannot deserialize SingleBind");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<SingleBind> {
        @Override
        public void serialize(SingleBind obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.unionMapValue != null) {
                jsonGenerator.writeObject(obj.unionMapValue);
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
