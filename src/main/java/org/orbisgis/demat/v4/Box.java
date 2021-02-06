package org.orbisgis.demat.v4;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(using = Box.Deserializer.class)
@JsonSerialize(using = Box.Serializer.class)
public class Box {
    public Boolean boolValue;
    public MarkConfigExprOrSignalRef markConfigExprOrSignalRefValue;

    static class Deserializer extends JsonDeserializer<Box> {
        @Override
        public Box deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            Box value = new Box();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case VALUE_TRUE:
                case VALUE_FALSE:
                    value.boolValue = jsonParser.readValueAs(Boolean.class);
                    break;
                case START_OBJECT:
                    value.markConfigExprOrSignalRefValue = jsonParser.readValueAs(MarkConfigExprOrSignalRef.class);
                    break;
                default: throw new IOException("Cannot deserialize Box");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<Box> {
        @Override
        public void serialize(Box obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.boolValue != null) {
                jsonGenerator.writeObject(obj.boolValue);
                return;
            }
            if (obj.markConfigExprOrSignalRefValue != null) {
                jsonGenerator.writeObject(obj.markConfigExprOrSignalRefValue);
                return;
            }
            jsonGenerator.writeNull();
        }
    }
}
