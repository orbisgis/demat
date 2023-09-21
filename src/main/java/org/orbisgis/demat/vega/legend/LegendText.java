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
package org.orbisgis.demat.vega.legend;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.IOException;
import java.util.List;

/**
 * A string or array of strings indicating the name of custom styles to apply to the mark. A
 * style is a named collection of mark property defaults defined within the [style
 * configuration](https://vega.github.io/vega-lite/docs/mark.html#style-config). If style is
 * an array, later styles will override earlier styles. Any [mark
 * properties](https://vega.github.io/vega-lite/docs/encoding.html#mark-prop) explicitly
 * defined within the `encoding` will override a style default.
 *
 * __Default value:__ The mark's name. For example, a bar mark will have style `"bar"` by
 * default. __Note:__ Any specified style will augment the default style. For example, a bar
 * mark with `"style": "foo"` will receive from `config.style.bar` and `config.style.foo`
 * (the specified style `"foo"` has higher precedence).
 *
 * A string or array of strings indicating the name of custom styles to apply to the axis. A
 * style is a named collection of axis property defined within the [style
 * configuration](https://vega.github.io/vega-lite/docs/mark.html#style-config). If style is
 * an array, later styles will override earlier styles.
 *
 * __Default value:__ (none) __Note:__ Any specified style will augment the default style.
 * For example, an x-axis mark with `"style": "foo"` will use `config.axisX` and
 * `config.style.foo` (the specified style `"foo"` has higher precedence).
 *
 * Placeholder text if the `text` channel is not specified
 *
 * The subtitle Text.
 *
 * A [mark style property](https://vega.github.io/vega-lite/docs/config.html#style) to apply
 * to the title text mark.
 *
 * __Default value:__ `"group-title"`.
 *
 * Output field names. This can be either a string or an array of strings with two elements
 * denoting the name for the fields for stack start and stack end respectively. If a single
 * string(e.g., `"val"`) is provided, the end field will be `"val_end"`.
 *
 * A string or array of strings indicating the name of custom styles to apply to the view
 * background. A style is a named collection of mark property defaults defined within the
 * [style configuration](https://vega.github.io/vega-lite/docs/mark.html#style-config). If
 * style is an array, later styles will override earlier styles.
 *
 * __Default value:__ `"cell"` __Note:__ Any specified view background properties will
 * augment the default style.
 */
@JsonDeserialize(using = LegendText.Deserializer.class)
@JsonSerialize(using = LegendText.Serializer.class)
public class LegendText {
    public List<String> titles;
    public String title;

    static class Deserializer extends JsonDeserializer<LegendText> {
        @Override
        public LegendText deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            LegendText value = new LegendText();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case VALUE_STRING:
                    String string = jsonParser.readValueAs(String.class);
                    value.title = string;
                    break;
                case START_ARRAY:
                    value.titles = jsonParser.readValueAs(new TypeReference<List<String>>() {
                    });
                    break;
                default: throw new IOException("Cannot deserialize LegendText");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<LegendText> {
        @Override
        public void serialize(LegendText obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.titles != null) {
                jsonGenerator.writeObject(obj.titles);
                return;
            }
            if (obj.title != null) {
                jsonGenerator.writeObject(obj.title);
                return;
            }
            jsonGenerator.writeNull();
        }
    }
}
