package org.orbisgis.demat.vega;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;
import com.fasterxml.jackson.core.type.*;
import java.util.List;
import java.util.Map;

@JsonDeserialize(using = Init.Deserializer.class)
@JsonSerialize(using = Init.Serializer.class)
public class Init {
    public Map<String, InitValue> unionMapValue;
    public List<Map<String, SelectionInit>> unionMapArrayValue;

    static class Deserializer extends JsonDeserializer<Init> {
        @Override
        public Init deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            Init value = new Init();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case START_ARRAY:
                    value.unionMapArrayValue = jsonParser.readValueAs(new TypeReference<List<Map>>() {});
                    break;
                case START_OBJECT:
                    value.unionMapValue = jsonParser.readValueAs(Map.class);
                    break;
                default: throw new IOException("Cannot deserialize Init");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<Init> {
        @Override
        public void serialize(Init obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.unionMapValue != null) {
                jsonGenerator.writeObject(obj.unionMapValue);
                return;
            }
            if (obj.unionMapArrayValue != null) {
                jsonGenerator.writeObject(obj.unionMapArrayValue);
                return;
            }
            jsonGenerator.writeNull();
        }
    }
}
