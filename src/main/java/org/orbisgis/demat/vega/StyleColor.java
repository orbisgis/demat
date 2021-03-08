package org.orbisgis.demat.vega;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(using = StyleColor.Deserializer.class)
@JsonSerialize(using = StyleColor.Serializer.class)
public class StyleColor {
    public TentacledLinearGradient tentacledLinearGradientValue;
    public String stringValue;

    static class Deserializer extends JsonDeserializer<StyleColor> {
        @Override
        public StyleColor deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            StyleColor value = new StyleColor();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case VALUE_STRING:
                    String string = jsonParser.readValueAs(String.class);
                    value.stringValue = string;
                    break;
                case START_OBJECT:
                    value.tentacledLinearGradientValue = jsonParser.readValueAs(TentacledLinearGradient.class);
                    break;
                default: throw new IOException("Cannot deserialize StyleColor");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<StyleColor> {
        @Override
        public void serialize(StyleColor obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.tentacledLinearGradientValue != null) {
                jsonGenerator.writeObject(obj.tentacledLinearGradientValue);
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
