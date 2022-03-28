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
 * A constant value in visual domain (e.g., `"red"` / `"#0099ff"` / [gradient
 * definition](https://vega.github.io/vega-lite/docs/types.html#gradient) for color, values
 * between `0` to `1` for opacity).
 */
@JsonDeserialize(using = StrokeDashUnion.Deserializer.class)
@JsonSerialize(using = StrokeDashUnion.Serializer.class)
public class StrokeDashUnion {
    public List<Double> doubleArrayValue;
    public BackgroundExprRef backgroundExprRefValue;

    static class Deserializer extends JsonDeserializer<StrokeDashUnion> {
        @Override
        public StrokeDashUnion deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            StrokeDashUnion value = new StrokeDashUnion();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case START_ARRAY:
                    value.doubleArrayValue = jsonParser.readValueAs(new TypeReference<List<Double>>() {});
                    break;
                case START_OBJECT:
                    value.backgroundExprRefValue = jsonParser.readValueAs(BackgroundExprRef.class);
                    break;
                default: throw new IOException("Cannot deserialize StrokeDashUnion");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<StrokeDashUnion> {
        @Override
        public void serialize(StrokeDashUnion obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.doubleArrayValue != null) {
                jsonGenerator.writeObject(obj.doubleArrayValue);
                return;
            }
            if (obj.backgroundExprRefValue != null) {
                jsonGenerator.writeObject(obj.backgroundExprRefValue);
                return;
            }
            jsonGenerator.writeNull();
        }
    }
}
