package org.orbisgis.demat.v4;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(using = OnUnion.Deserializer.class)
@JsonSerialize(using = OnUnion.Serializer.class)
public class OnUnion {
    public OnDerivedStream onDerivedStreamValue;
    public String stringValue;

    static class Deserializer extends JsonDeserializer<OnUnion> {
        @Override
        public OnUnion deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            OnUnion value = new OnUnion();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case VALUE_STRING:
                    String string = jsonParser.readValueAs(String.class);
                    value.stringValue = string;
                    break;
                case START_OBJECT:
                    value.onDerivedStreamValue = jsonParser.readValueAs(OnDerivedStream.class);
                    break;
                default: throw new IOException("Cannot deserialize OnUnion");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<OnUnion> {
        @Override
        public void serialize(OnUnion obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.onDerivedStreamValue != null) {
                jsonGenerator.writeObject(obj.onDerivedStreamValue);
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
