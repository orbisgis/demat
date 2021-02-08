package org.orbisgis.demat.v4;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(using = MarkFill.Deserializer.class)
@JsonSerialize(using = MarkFill.Serializer.class)
public class MarkFill {
    public FluffyLinearGradient fluffyLinearGradientValue;
    public String stringValue;

    static class Deserializer extends JsonDeserializer<MarkFill> {
        @Override
        public MarkFill deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            MarkFill value = new MarkFill();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case VALUE_STRING:
                    String string = jsonParser.readValueAs(String.class);
                    value.stringValue = string;
                    break;
                case START_OBJECT:
                    value.fluffyLinearGradientValue = jsonParser.readValueAs(FluffyLinearGradient.class);
                    break;
                default: throw new IOException("Cannot deserialize MarkConfigExprOrSignalRefFill");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<MarkFill> {
        @Override
        public void serialize(MarkFill obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.fluffyLinearGradientValue != null) {
                jsonGenerator.writeObject(obj.fluffyLinearGradientValue);
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
