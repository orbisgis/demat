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
 * When truthy, allows a user to interactively move an interval selection back-and-forth.
 * Can be `true`, `false` (to disable panning), or a [Vega event stream
 * definition](https://vega.github.io/vega/docs/event-streams/) which must include a start
 * and end event to trigger continuous panning.
 *
 * __Default value:__ `true`, which corresponds to `[mousedown, window:mouseup] >
 * window:mousemove!` which corresponds to clicks and dragging within an interval selection
 * to reposition it.
 *
 * __See also:__ [`translate`](https://vega.github.io/vega-lite/docs/translate.html)
 * documentation.
 *
 * When truthy, allows a user to interactively resize an interval selection. Can be `true`,
 * `false` (to disable zooming), or a [Vega event stream
 * definition](https://vega.github.io/vega/docs/event-streams/). Currently, only `wheel`
 * events are supported.
 *
 * __Default value:__ `true`, which corresponds to `wheel!`.
 *
 * __See also:__ [`zoom`](https://vega.github.io/vega-lite/docs/zoom.html) documentation.
 *
 * Controls whether data values should be toggled or only ever inserted into multi
 * selections. Can be `true`, `false` (for insertion only), or a [Vega
 * expression](https://vega.github.io/vega/docs/expressions/).
 *
 * __Default value:__ `true`, which corresponds to `event.shiftKey` (i.e., data values are
 * toggled when a user interacts with the shift-key pressed).
 *
 * Setting the value to the Vega expression `"true"` will toggle data values without the
 * user pressing the shift-key.
 *
 * __See also:__ [`toggle`](https://vega.github.io/vega-lite/docs/toggle.html) documentation.
 */
@JsonDeserialize(using = Translate.Deserializer.class)
@JsonSerialize(using = Translate.Serializer.class)
public class Translate {
    public Boolean boolValue;
    public String stringValue;

    static class Deserializer extends JsonDeserializer<Translate> {
        @Override
        public Translate deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            Translate value = new Translate();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case VALUE_TRUE:
                case VALUE_FALSE:
                    value.boolValue = jsonParser.readValueAs(Boolean.class);
                    break;
                case VALUE_STRING:
                    String string = jsonParser.readValueAs(String.class);
                    value.stringValue = string;
                    break;
                default: throw new IOException("Cannot deserialize Translate");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<Translate> {
        @Override
        public void serialize(Translate obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.boolValue != null) {
                jsonGenerator.writeObject(obj.boolValue);
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
