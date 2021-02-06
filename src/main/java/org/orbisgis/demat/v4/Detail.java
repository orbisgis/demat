package org.orbisgis.demat.v4;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;
import com.fasterxml.jackson.core.type.*;
import java.util.List;

@JsonDeserialize(using = Detail.Deserializer.class)
@JsonSerialize(using = Detail.Serializer.class)
public class Detail {
    public TypedFieldDef typedFieldDefValue;
    public List<TypedFieldDef> typedFieldDefArrayValue;

    static class Deserializer extends JsonDeserializer<Detail> {
        @Override
        public Detail deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            Detail value = new Detail();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case START_ARRAY:
                    value.typedFieldDefArrayValue = jsonParser.readValueAs(new TypeReference<List<TypedFieldDef>>() {});
                    break;
                case START_OBJECT:
                    value.typedFieldDefValue = jsonParser.readValueAs(TypedFieldDef.class);
                    break;
                default: throw new IOException("Cannot deserialize Detail");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<Detail> {
        @Override
        public void serialize(Detail obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.typedFieldDefValue != null) {
                jsonGenerator.writeObject(obj.typedFieldDefValue);
                return;
            }
            if (obj.typedFieldDefArrayValue != null) {
                jsonGenerator.writeObject(obj.typedFieldDefArrayValue);
                return;
            }
            jsonGenerator.writeNull();
        }
    }
}
