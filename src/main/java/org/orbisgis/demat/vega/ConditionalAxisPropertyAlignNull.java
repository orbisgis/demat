package org.orbisgis.demat.vega;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(using = ConditionalAxisPropertyAlignNull.Deserializer.class)
@JsonSerialize(using = ConditionalAxisPropertyAlignNull.Serializer.class)
public class ConditionalAxisPropertyAlignNull {
    public FluffyExprRef fluffyExprRefValue;
    public Align enumValue;

    static class Deserializer extends JsonDeserializer<ConditionalAxisPropertyAlignNull> {
        @Override
        public ConditionalAxisPropertyAlignNull deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            ConditionalAxisPropertyAlignNull value = new ConditionalAxisPropertyAlignNull();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case VALUE_STRING:
                    String string = jsonParser.readValueAs(String.class);
                    try {
                        value.enumValue = Align.forValue(string);
                    } catch (Exception ex) {
                        // Ignored
                    }
                    break;
                case START_OBJECT:
                    value.fluffyExprRefValue = jsonParser.readValueAs(FluffyExprRef.class);
                    break;
                default: throw new IOException("Cannot deserialize ConditionalAxisPropertyAlignNull");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<ConditionalAxisPropertyAlignNull> {
        @Override
        public void serialize(ConditionalAxisPropertyAlignNull obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.fluffyExprRefValue != null) {
                jsonGenerator.writeObject(obj.fluffyExprRefValue);
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
