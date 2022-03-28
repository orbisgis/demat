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
 * The alignment to apply to grid rows and columns. The supported string values are `"all"`,
 * `"each"`, and `"none"`.
 *
 * - For `"none"`, a flow layout will be used, in which adjacent subviews are simply placed
 * one after the other. - For `"each"`, subviews will be aligned into a clean grid
 * structure, but each row or column may be of variable size. - For `"all"`, subviews will
 * be aligned and each row or column will be sized identically based on the maximum observed
 * size. String values for this property will be applied to both grid rows and columns.
 *
 * Alternatively, an object value of the form `{"row": string, "column": string}` can be
 * used to supply different alignments for rows and columns.
 *
 * __Default value:__ `"all"`.
 */
@JsonDeserialize(using = ViewAlign.Deserializer.class)
@JsonSerialize(using = ViewAlign.Serializer.class)
public class ViewAlign {
    public RowColLayoutAlign rowColLayoutAlignValue;
    public LayoutAlign enumValue;

    static class Deserializer extends JsonDeserializer<ViewAlign> {
        @Override
        public ViewAlign deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            ViewAlign value = new ViewAlign();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case VALUE_STRING:
                    String string = jsonParser.readValueAs(String.class);
                    try {
                        value.enumValue = LayoutAlign.forValue(string);
                    } catch (Exception ex) {
                        // Ignored
                    }
                    break;
                case START_OBJECT:
                    value.rowColLayoutAlignValue = jsonParser.readValueAs(RowColLayoutAlign.class);
                    break;
                default: throw new IOException("Cannot deserialize CoordinateAlign");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<ViewAlign> {
        @Override
        public void serialize(ViewAlign obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.rowColLayoutAlignValue != null) {
                jsonGenerator.writeObject(obj.rowColLayoutAlignValue);
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
