package org.orbisgis.demat.v4;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;
import com.fasterxml.jackson.core.type.*;
import java.util.List;

@JsonDeserialize(using = RepeatUnion.Deserializer.class)
@JsonSerialize(using = RepeatUnion.Serializer.class)
public class RepeatUnion {
    public List<String> stringArrayValue;
    public RepeatMapping repeatMappingValue;

    static class Deserializer extends JsonDeserializer<RepeatUnion> {
        @Override
        public RepeatUnion deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            RepeatUnion value = new RepeatUnion();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case START_ARRAY:
                    value.stringArrayValue = jsonParser.readValueAs(new TypeReference<List<String>>() {});
                    break;
                case START_OBJECT:
                    value.repeatMappingValue = jsonParser.readValueAs(RepeatMapping.class);
                    break;
                default: throw new IOException("Cannot deserialize RepeatUnion");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<RepeatUnion> {
        @Override
        public void serialize(RepeatUnion obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.stringArrayValue != null) {
                jsonGenerator.writeObject(obj.stringArrayValue);
                return;
            }
            if (obj.repeatMappingValue != null) {
                jsonGenerator.writeObject(obj.repeatMappingValue);
                return;
            }
            jsonGenerator.writeNull();
        }
    }
}
