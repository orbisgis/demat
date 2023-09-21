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
 * CSS color property to use as the background of the entire view.
 *
 * __Default value:__ `"white"`
 *
 * The color of the header label, can be in hex color code or regular color name.
 *
 * Color of the header title, can be in hex color code or regular color name.
 *
 * For text marks, the vertical text baseline. One of `"alphabetic"` (default), `"top"`,
 * `"middle"`, `"bottom"`, `"line-top"`, `"line-bottom"`, or an expression reference that
 * provides one of the valid values. The `"line-top"` and `"line-bottom"` values operate
 * similarly to `"top"` and `"bottom"`, but are calculated relative to the `lineHeight`
 * rather than `fontSize` alone.
 *
 * For range marks, the vertical alignment of the marks. One of `"top"`, `"middle"`,
 * `"bottom"`.
 *
 * __Note:__ Expression reference is *not* supported for range marks.
 *
 * The vertical text baseline for the header labels. One of `"alphabetic"` (default),
 * `"top"`, `"middle"`, `"bottom"`, `"line-top"`, or `"line-bottom"`. The `"line-top"` and
 * `"line-bottom"` values operate similarly to `"top"` and `"bottom"`, but are calculated
 * relative to the `titleLineHeight` rather than `titleFontSize` alone.
 *
 * The vertical text baseline for the header title. One of `"alphabetic"` (default),
 * `"top"`, `"middle"`, `"bottom"`, `"line-top"`, or `"line-bottom"`. The `"line-top"` and
 * `"line-bottom"` values operate similarly to `"top"` and `"bottom"`, but are calculated
 * relative to the `titleLineHeight` rather than `titleFontSize` alone.
 *
 * __Default value:__ `"middle"`
 */
@JsonDeserialize(using = Background.Deserializer.class)
@JsonSerialize(using = Background.Serializer.class)
public class Background {

    public ExprRef expressionValue;
    public String value;

    static class Deserializer extends JsonDeserializer<Background> {
        @Override
        public Background deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            Background value = new Background();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case VALUE_STRING:
                    String string = jsonParser.readValueAs(String.class);
                    value.value = string;
                    break;
                case START_OBJECT:
                    value.expressionValue = jsonParser.readValueAs(ExprRef.class);
                    break;
                default: throw new IOException("Cannot deserialize BackgroundUnion");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<Background> {
        @Override
        public void serialize(Background obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.expressionValue != null) {
                jsonGenerator.writeObject(obj.expressionValue);
                return;
            }
            if (obj.value != null) {
                jsonGenerator.writeObject(obj.value);
                return;
            }
            jsonGenerator.writeNull();
        }
    }
}
