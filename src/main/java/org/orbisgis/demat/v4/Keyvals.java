package org.orbisgis.demat.v4;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;
import com.fasterxml.jackson.core.type.*;
import java.util.List;

@JsonDeserialize(using = Keyvals.Deserializer.class)
@JsonSerialize(using = Keyvals.Serializer.class)
public class Keyvals {
    public List<Object> anythingArrayValue;
    public ImputeSequence imputeSequenceValue;

    static class Deserializer extends JsonDeserializer<Keyvals> {
        @Override
        public Keyvals deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            Keyvals value = new Keyvals();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case START_ARRAY:
                    value.anythingArrayValue = jsonParser.readValueAs(new TypeReference<List<Object>>() {});
                    break;
                case START_OBJECT:
                    value.imputeSequenceValue = jsonParser.readValueAs(ImputeSequence.class);
                    break;
                default: throw new IOException("Cannot deserialize Keyvals");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<Keyvals> {
        @Override
        public void serialize(Keyvals obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.anythingArrayValue != null) {
                jsonGenerator.writeObject(obj.anythingArrayValue);
                return;
            }
            if (obj.imputeSequenceValue != null) {
                jsonGenerator.writeObject(obj.imputeSequenceValue);
                return;
            }
            jsonGenerator.writeNull();
        }
    }
}
