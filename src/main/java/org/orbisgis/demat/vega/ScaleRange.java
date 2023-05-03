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

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.IOException;
import java.util.List;

/**
 * The range of the scale. One of:
 *
 * - A string indicating a [pre-defined named scale
 * range](https://vega.github.io/vega-lite/docs/scale.html#range-config) (e.g., example,
 * `"symbol"`, or `"diverging"`).
 *
 * - For [continuous scales](https://vega.github.io/vega-lite/docs/scale.html#continuous),
 * two-element array indicating  minimum and maximum values, or an array with more than two
 * entries for specifying a [piecewise
 * scale](https://vega.github.io/vega-lite/docs/scale.html#piecewise).
 *
 * - For [discrete](https://vega.github.io/vega-lite/docs/scale.html#discrete) and
 * [discretizing](https://vega.github.io/vega-lite/docs/scale.html#discretizing) scales, an
 * array of desired output values or an object with a `field` property representing the
 * range values.  For example, if a field `color` contains CSS color names, we can set
 * `range` to `{field: "color"}`.
 *
 * __Notes:__
 *
 * 1) For color scales you can also specify a color
 * [`scheme`](https://vega.github.io/vega-lite/docs/scale.html#scheme) instead of `range`.
 *
 * 2) Any directly specified `range` for `x` and `y` channels will be ignored. Range can be
 * customized via the view's corresponding
 * [size](https://vega.github.io/vega-lite/docs/size.html) (`width` and `height`).
 */
@JsonDeserialize(using = ScaleRange.Deserializer.class)
@JsonSerialize(using = ScaleRange.Serializer.class)
public class ScaleRange {
    public List<Object> values;
    public RangeField rangeField;
    public RangeEnum rangeEnum;


    public static ScaleRange build(Object[] elements) {
        ScaleRange scaleRange = new ScaleRange();
        for (Object element : elements) {
            if (element instanceof List) {
                scaleRange.values = (List<Object>) element;
            } else if (element instanceof RangeField) {
                scaleRange.rangeField = (RangeField) element;
            } else if (element instanceof RangeEnum) {
                scaleRange.rangeEnum = (RangeEnum) element;
            }
        }
        return scaleRange;
    }


    static class Deserializer extends JsonDeserializer<ScaleRange> {
        @Override
        public ScaleRange deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            ScaleRange value = new ScaleRange();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case VALUE_STRING:
                    String string = jsonParser.readValueAs(String.class);
                    try {
                        value.rangeEnum = RangeEnum.forValue(string);
                    } catch (Exception ex) {
                        // Ignored
                    }
                    break;
                case START_ARRAY:
                    value.values = jsonParser.readValueAs(List.class);
                    break;
                case START_OBJECT:
                    value.rangeField = jsonParser.readValueAs(RangeField.class);
                    break;
                default: throw new IOException("Cannot deserialize ScaleRange");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<ScaleRange> {
        @Override
        public void serialize(ScaleRange obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.values != null) {
                jsonGenerator.writeObject(obj.values);
                return;
            }
            if (obj.rangeField != null) {
                jsonGenerator.writeObject(obj.rangeField);
                return;
            }
            if (obj.rangeEnum != null) {
                jsonGenerator.writeObject(obj.rangeEnum);
                return;
            }
            jsonGenerator.writeNull();
        }
    }
}
