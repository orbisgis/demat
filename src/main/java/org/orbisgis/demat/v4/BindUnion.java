package org.orbisgis.demat.v4;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;

import java.util.Map;

@JsonDeserialize(using = BindUnion.Deserializer.class)
@JsonSerialize(using = BindUnion.Serializer.class)
public class BindUnion {
    public Map<String, PurpleStream> unionMapValue;
    public String stringValue;

    static class Deserializer extends JsonDeserializer<BindUnion> {
        @Override
        public BindUnion deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            BindUnion value = new BindUnion();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case VALUE_STRING:
                    String string = jsonParser.readValueAs(String.class);
                    value.stringValue = string;
                    break;
                case START_OBJECT:
                    value.unionMapValue = jsonParser.readValueAs(Map.class);
                    break;
                default: throw new IOException("Cannot deserialize BindUnion");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<BindUnion> {
        @Override
        public void serialize(BindUnion obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.unionMapValue != null) {
                jsonGenerator.writeObject(obj.unionMapValue);
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
