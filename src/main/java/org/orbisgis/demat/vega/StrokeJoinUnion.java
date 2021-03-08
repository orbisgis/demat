package org.orbisgis.demat.vega;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(using = StrokeJoinUnion.Deserializer.class)
@JsonSerialize(using = StrokeJoinUnion.Serializer.class)
public class StrokeJoinUnion {
    public BackgroundExprRef backgroundExprRefValue;
    public StrokeJoin enumValue;

    static class Deserializer extends JsonDeserializer<StrokeJoinUnion> {
        @Override
        public StrokeJoinUnion deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            StrokeJoinUnion value = new StrokeJoinUnion();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case VALUE_STRING:
                    String string = jsonParser.readValueAs(String.class);
                    try {
                        value.enumValue = StrokeJoin.forValue(string);
                    } catch (Exception ex) {
                        // Ignored
                    }
                    break;
                case START_OBJECT:
                    value.backgroundExprRefValue = jsonParser.readValueAs(BackgroundExprRef.class);
                    break;
                default: throw new IOException("Cannot deserialize StrokeJoinUnion");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<StrokeJoinUnion> {
        @Override
        public void serialize(StrokeJoinUnion obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.backgroundExprRefValue != null) {
                jsonGenerator.writeObject(obj.backgroundExprRefValue);
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
