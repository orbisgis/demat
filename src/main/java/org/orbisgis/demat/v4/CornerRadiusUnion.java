package org.orbisgis.demat.v4;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(using = CornerRadiusUnion.Deserializer.class)
@JsonSerialize(using = CornerRadiusUnion.Serializer.class)
public class CornerRadiusUnion {
    public Double doubleValue;
    public BackgroundExprRef backgroundExprRefValue;

    static class Deserializer extends JsonDeserializer<CornerRadiusUnion> {
        @Override
        public CornerRadiusUnion deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            CornerRadiusUnion value = new CornerRadiusUnion();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case VALUE_NUMBER_INT:
                case VALUE_NUMBER_FLOAT:
                    value.doubleValue = jsonParser.readValueAs(Double.class);
                    break;
                case START_OBJECT:
                    value.backgroundExprRefValue = jsonParser.readValueAs(BackgroundExprRef.class);
                    break;
                default: throw new IOException("Cannot deserialize CornerRadiusUnion");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<CornerRadiusUnion> {
        @Override
        public void serialize(CornerRadiusUnion obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.doubleValue != null) {
                jsonGenerator.writeObject(obj.doubleValue);
                return;
            }
            if (obj.backgroundExprRefValue != null) {
                jsonGenerator.writeObject(obj.backgroundExprRefValue);
                return;
            }
            jsonGenerator.writeNull();
        }
    }
}
