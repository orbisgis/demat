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
 * How the visualization size should be determined. If a string, should be one of `"pad"`,
 * `"fit"` or `"none"`. Object values can additionally specify parameters for content sizing
 * and automatic resizing.
 *
 * __Default value__: `pad`
 */
@JsonDeserialize(using = Autosize.Deserializer.class)
@JsonSerialize(using = Autosize.Serializer.class)
public class Autosize {
    public AutoSizeParams autoSizeParamsValue;
    public AutosizeType enumValue;

    static class Deserializer extends JsonDeserializer<Autosize> {
        @Override
        public Autosize deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            Autosize value = new Autosize();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case VALUE_STRING:
                    String string = jsonParser.readValueAs(String.class);
                    try {
                        value.enumValue = AutosizeType.forValue(string);
                    } catch (Exception ex) {
                        // Ignored
                    }
                    break;
                case START_OBJECT:
                    value.autoSizeParamsValue = jsonParser.readValueAs(AutoSizeParams.class);
                    break;
                default: throw new IOException("Cannot deserialize Autosize");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<Autosize> {
        @Override
        public void serialize(Autosize obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.autoSizeParamsValue != null) {
                jsonGenerator.writeObject(obj.autoSizeParamsValue);
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
