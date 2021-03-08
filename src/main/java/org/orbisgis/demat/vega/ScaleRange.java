package org.orbisgis.demat.vega;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;

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
    public Object[] unionArrayValue;
    public RangeClass rangeClassValue;
    public RangeEnum enumValue;

    static class Deserializer extends JsonDeserializer<ScaleRange> {
        @Override
        public ScaleRange deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            ScaleRange value = new ScaleRange();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case VALUE_STRING:
                    String string = jsonParser.readValueAs(String.class);
                    try {
                        value.enumValue = RangeEnum.forValue(string);
                    } catch (Exception ex) {
                        // Ignored
                    }
                    break;
                case START_ARRAY:
                    value.unionArrayValue = jsonParser.readValueAs(Object[].class);
                    break;
                case START_OBJECT:
                    value.rangeClassValue = jsonParser.readValueAs(RangeClass.class);
                    break;
                default: throw new IOException("Cannot deserialize ScaleRange");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<ScaleRange> {
        @Override
        public void serialize(ScaleRange obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.unionArrayValue != null) {
                jsonGenerator.writeObject(obj.unionArrayValue);
                return;
            }
            if (obj.rangeClassValue != null) {
                jsonGenerator.writeObject(obj.rangeClassValue);
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
