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

@JsonDeserialize(using = FluffyConditionalPredicateValueDefFontStyleNullExprRef.Deserializer.class)
@JsonSerialize(using = FluffyConditionalPredicateValueDefFontStyleNullExprRef.Serializer.class)
public class FluffyConditionalPredicateValueDefFontStyleNullExprRef {
    public PurpleConditionalPredicateValueDefFontStyleNullExprRef purpleConditionalPredicateValueDefFontStyleNullExprRefValue;
    public List<ConditionalPredicateValueDefFontStyleNullExprRef> conditionalPredicateValueDefFontStyleNullExprRefArrayValue;

    static class Deserializer extends JsonDeserializer<FluffyConditionalPredicateValueDefFontStyleNullExprRef> {
        @Override
        public FluffyConditionalPredicateValueDefFontStyleNullExprRef deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            FluffyConditionalPredicateValueDefFontStyleNullExprRef value = new FluffyConditionalPredicateValueDefFontStyleNullExprRef();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case START_ARRAY:
                    value.conditionalPredicateValueDefFontStyleNullExprRefArrayValue = jsonParser.readValueAs(new TypeReference<List<ConditionalPredicateValueDefFontStyleNullExprRef>>() {});
                    break;
                case START_OBJECT:
                    value.purpleConditionalPredicateValueDefFontStyleNullExprRefValue = jsonParser.readValueAs(PurpleConditionalPredicateValueDefFontStyleNullExprRef.class);
                    break;
                default: throw new IOException("Cannot deserialize FluffyConditionalPredicateValueDefFontStyleNullExprRef");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<FluffyConditionalPredicateValueDefFontStyleNullExprRef> {
        @Override
        public void serialize(FluffyConditionalPredicateValueDefFontStyleNullExprRef obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.purpleConditionalPredicateValueDefFontStyleNullExprRefValue != null) {
                jsonGenerator.writeObject(obj.purpleConditionalPredicateValueDefFontStyleNullExprRefValue);
                return;
            }
            if (obj.conditionalPredicateValueDefFontStyleNullExprRefArrayValue != null) {
                jsonGenerator.writeObject(obj.conditionalPredicateValueDefFontStyleNullExprRefArrayValue);
                return;
            }
            jsonGenerator.writeNull();
        }
    }
}
