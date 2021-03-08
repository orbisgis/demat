package org.orbisgis.demat.vega;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;

/**
 * Default color.
 *
 * __Default value:__ <span style="color: #4682b4;">&#9632;</span> `"#4682b4"`
 *
 * __Note:__ - This property cannot be used in a [style
 * config](https://vega.github.io/vega-lite/docs/mark.html#style-config). - The `fill` and
 * `stroke` properties have higher precedence than `color` and will override `color`.
 */
@JsonDeserialize(using = MarkConfigExprOrSignalRefColor.Deserializer.class)
@JsonSerialize(using = MarkConfigExprOrSignalRefColor.Serializer.class)
public class MarkConfigExprOrSignalRefColor {
    public PurpleLinearGradient purpleLinearGradientValue;
    public String stringValue;

    static class Deserializer extends JsonDeserializer<MarkConfigExprOrSignalRefColor> {
        @Override
        public MarkConfigExprOrSignalRefColor deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            MarkConfigExprOrSignalRefColor value = new MarkConfigExprOrSignalRefColor();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case VALUE_STRING:
                    String string = jsonParser.readValueAs(String.class);
                    value.stringValue = string;
                    break;
                case START_OBJECT:
                    value.purpleLinearGradientValue = jsonParser.readValueAs(PurpleLinearGradient.class);
                    break;
                default: throw new IOException("Cannot deserialize MarkConfigExprOrSignalRefColor");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<MarkConfigExprOrSignalRefColor> {
        @Override
        public void serialize(MarkConfigExprOrSignalRefColor obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.purpleLinearGradientValue != null) {
                jsonGenerator.writeObject(obj.purpleLinearGradientValue);
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
