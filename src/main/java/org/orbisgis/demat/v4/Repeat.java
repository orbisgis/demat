package org.orbisgis.demat.v4;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;
import com.fasterxml.jackson.core.type.*;
import java.util.List;

@JsonDeserialize(using = Repeat.Deserializer.class)
@JsonSerialize(using = Repeat.Serializer.class)
public class Repeat {
    public List<String> stringArrayValue;
    public RepeatMapping repeatMappingValue;

    static class Deserializer extends JsonDeserializer<Repeat> {
        @Override
        public Repeat deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            Repeat value = new Repeat();
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

    static class Serializer extends JsonSerializer<Repeat> {
        @Override
        public void serialize(Repeat obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
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
