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
 * The default visualization padding, in pixels, from the edge of the visualization canvas
 * to the data rectangle. If a number, specifies padding for all sides. If an object, the
 * value should have the format `{"left": 5, "top": 5, "right": 5, "bottom": 5}` to specify
 * padding for each side of the visualization.
 *
 * __Default value__: `5`
 */
@JsonDeserialize(using = Padding.Deserializer.class)
@JsonSerialize(using = Padding.Serializer.class)
public class Padding {
    public Double doubleValue;
    public MagentaExprRef magentaExprRefValue;

    static class Deserializer extends JsonDeserializer<Padding> {
        @Override
        public Padding deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            Padding value = new Padding();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case VALUE_NUMBER_INT:
                case VALUE_NUMBER_FLOAT:
                    value.doubleValue = jsonParser.readValueAs(Double.class);
                    break;
                case START_OBJECT:
                    value.magentaExprRefValue = jsonParser.readValueAs(MagentaExprRef.class);
                    break;
                default: throw new IOException("Cannot deserialize Padding");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<Padding> {
        @Override
        public void serialize(Padding obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.doubleValue != null) {
                jsonGenerator.writeObject(obj.doubleValue);
                return;
            }
            if (obj.magentaExprRefValue != null) {
                jsonGenerator.writeObject(obj.magentaExprRefValue);
                return;
            }
            jsonGenerator.writeNull();
        }
    }
}
