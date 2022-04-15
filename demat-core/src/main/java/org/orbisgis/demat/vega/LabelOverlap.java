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
 * The strategy to use for resolving overlap of axis labels. If `false` (the default), no
 * overlap reduction is attempted. If set to `true` or `"parity"`, a strategy of removing
 * every other label is used (this works well for standard linear axes). If set to
 * `"greedy"`, a linear scan of the labels is performed, removing any labels that overlaps
 * with the last visible label (this often works better for log-scaled axes).
 *
 * __Default value:__ `true` for non-nominal fields with non-log scales; `"greedy"` for log
 * scales; otherwise `false`.
 *
 * The strategy to use for resolving overlap of labels in gradient legends. If `false`, no
 * overlap reduction is attempted. If set to `true` or `"parity"`, a strategy of removing
 * every other label is used. If set to `"greedy"`, a linear scan of the labels is
 * performed, removing any label that overlaps with the last visible label (this often works
 * better for log-scaled axes).
 *
 * __Default value:__ `"greedy"` for `log scales otherwise `true`.
 */
@JsonDeserialize(using = LabelOverlap.Deserializer.class)
@JsonSerialize(using = LabelOverlap.Serializer.class)
public class LabelOverlap {
    public Boolean boolValue;
    public BackgroundExprRef backgroundExprRefValue;
    public String stringValue;

    static class Deserializer extends JsonDeserializer<LabelOverlap> {
        @Override
        public LabelOverlap deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            LabelOverlap value = new LabelOverlap();
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
                case START_OBJECT:
                    value.backgroundExprRefValue = jsonParser.readValueAs(BackgroundExprRef.class);
                    break;
                default: throw new IOException("Cannot deserialize LabelOverlap");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<LabelOverlap> {
        @Override
        public void serialize(LabelOverlap obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.boolValue != null) {
                jsonGenerator.writeObject(obj.boolValue);
                return;
            }
            if (obj.backgroundExprRefValue != null) {
                jsonGenerator.writeObject(obj.backgroundExprRefValue);
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
