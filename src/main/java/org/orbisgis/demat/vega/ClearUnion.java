package org.orbisgis.demat.vega;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(using = ClearUnion.Deserializer.class)
@JsonSerialize(using = ClearUnion.Serializer.class)
public class ClearUnion {
    public ClearDerivedStream clearDerivedStreamValue;
    public Boolean boolValue;
    public String stringValue;

    static class Deserializer extends JsonDeserializer<ClearUnion> {
        @Override
        public ClearUnion deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            ClearUnion value = new ClearUnion();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case VALUE_TRUE:
                case VALUE_FALSE:
                    value.boolValue = jsonParser.readValueAs(Boolean.class);
                    break;
                case VALUE_STRING:
                    String string = jsonParser.readValueAs(String.class);
                    value.stringValue = string;
                    break;
                case START_OBJECT:
                    value.clearDerivedStreamValue = jsonParser.readValueAs(ClearDerivedStream.class);
                    break;
                default: throw new IOException("Cannot deserialize ClearUnion");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<ClearUnion> {
        @Override
        public void serialize(ClearUnion obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.clearDerivedStreamValue != null) {
                jsonGenerator.writeObject(obj.clearDerivedStreamValue);
                return;
            }
            if (obj.boolValue != null) {
                jsonGenerator.writeObject(obj.boolValue);
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
