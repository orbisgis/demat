package org.orbisgis.demat.vega;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.IOException;

@JsonDeserialize(using = MarkStroke.Deserializer.class)
@JsonSerialize(using = MarkStroke.Serializer.class)
public class MarkStroke {
    public FluffyLinearGradient fluffyLinearGradientValue;
    public String stringValue;

    static class Deserializer extends JsonDeserializer<MarkStroke> {
        @Override
        public MarkStroke deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            MarkStroke value = new MarkStroke();
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

    static class Serializer extends JsonSerializer<MarkStroke> {
        @Override
        public void serialize(MarkStroke obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
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
