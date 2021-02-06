package org.orbisgis.demat.v4;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(using = MarkConfigExprOrSignalRefFill.Deserializer.class)
@JsonSerialize(using = MarkConfigExprOrSignalRefFill.Serializer.class)
public class MarkConfigExprOrSignalRefFill {
    public FluffyLinearGradient fluffyLinearGradientValue;
    public String stringValue;

    static class Deserializer extends JsonDeserializer<MarkConfigExprOrSignalRefFill> {
        @Override
        public MarkConfigExprOrSignalRefFill deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            MarkConfigExprOrSignalRefFill value = new MarkConfigExprOrSignalRefFill();
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

    static class Serializer extends JsonSerializer<MarkConfigExprOrSignalRefFill> {
        @Override
        public void serialize(MarkConfigExprOrSignalRefFill obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
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
