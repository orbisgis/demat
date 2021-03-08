package org.orbisgis.demat.vega;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(using = StyleFill.Deserializer.class)
@JsonSerialize(using = StyleFill.Serializer.class)
public class StyleFill {
    public StickyLinearGradient stickyLinearGradientValue;
    public String stringValue;

    static class Deserializer extends JsonDeserializer<StyleFill> {
        @Override
        public StyleFill deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            StyleFill value = new StyleFill();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case VALUE_STRING:
                    String string = jsonParser.readValueAs(String.class);
                    value.stringValue = string;
                    break;
                case START_OBJECT:
                    value.stickyLinearGradientValue = jsonParser.readValueAs(StickyLinearGradient.class);
                    break;
                default: throw new IOException("Cannot deserialize StyleFill");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<StyleFill> {
        @Override
        public void serialize(StyleFill obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.stickyLinearGradientValue != null) {
                jsonGenerator.writeObject(obj.stickyLinearGradientValue);
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
