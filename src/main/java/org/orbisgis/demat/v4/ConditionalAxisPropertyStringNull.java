package org.orbisgis.demat.v4;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(using = ConditionalAxisPropertyStringNull.Deserializer.class)
@JsonSerialize(using = ConditionalAxisPropertyStringNull.Serializer.class)
public class ConditionalAxisPropertyStringNull {
    public StickyExprRef stickyExprRefValue;
    public String stringValue;

    static class Deserializer extends JsonDeserializer<ConditionalAxisPropertyStringNull> {
        @Override
        public ConditionalAxisPropertyStringNull deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            ConditionalAxisPropertyStringNull value = new ConditionalAxisPropertyStringNull();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case VALUE_STRING:
                    String string = jsonParser.readValueAs(String.class);
                    value.stringValue = string;
                    break;
                case START_OBJECT:
                    value.stickyExprRefValue = jsonParser.readValueAs(StickyExprRef.class);
                    break;
                default: throw new IOException("Cannot deserialize ConditionalAxisPropertyStringNull");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<ConditionalAxisPropertyStringNull> {
        @Override
        public void serialize(ConditionalAxisPropertyStringNull obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.stickyExprRefValue != null) {
                jsonGenerator.writeObject(obj.stickyExprRefValue);
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
