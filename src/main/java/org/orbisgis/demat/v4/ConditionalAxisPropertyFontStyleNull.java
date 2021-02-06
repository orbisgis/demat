package org.orbisgis.demat.v4;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(using = ConditionalAxisPropertyFontStyleNull.Deserializer.class)
@JsonSerialize(using = ConditionalAxisPropertyFontStyleNull.Serializer.class)
public class ConditionalAxisPropertyFontStyleNull {
    public IndigoExprRef indigoExprRefValue;
    public String stringValue;

    static class Deserializer extends JsonDeserializer<ConditionalAxisPropertyFontStyleNull> {
        @Override
        public ConditionalAxisPropertyFontStyleNull deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            ConditionalAxisPropertyFontStyleNull value = new ConditionalAxisPropertyFontStyleNull();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case VALUE_STRING:
                    String string = jsonParser.readValueAs(String.class);
                    value.stringValue = string;
                    break;
                case START_OBJECT:
                    value.indigoExprRefValue = jsonParser.readValueAs(IndigoExprRef.class);
                    break;
                default: throw new IOException("Cannot deserialize ConditionalAxisPropertyFontStyleNull");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<ConditionalAxisPropertyFontStyleNull> {
        @Override
        public void serialize(ConditionalAxisPropertyFontStyleNull obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.indigoExprRefValue != null) {
                jsonGenerator.writeObject(obj.indigoExprRefValue);
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
