package org.orbisgis.demat.v4;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;
import com.fasterxml.jackson.core.type.*;
import java.util.List;

@JsonDeserialize(using = FluffyStream.Deserializer.class)
@JsonSerialize(using = FluffyStream.Serializer.class)
public class FluffyStream {
    public Double doubleValue;
    public FluffyBinding fluffyBindingValue;
    public List<Object> anythingArrayValue;
    public String stringValue;

    static class Deserializer extends JsonDeserializer<FluffyStream> {
        @Override
        public FluffyStream deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            FluffyStream value = new FluffyStream();
            switch (jsonParser.currentToken()) {
                case VALUE_NUMBER_INT:
                case VALUE_NUMBER_FLOAT:
                    value.doubleValue = jsonParser.readValueAs(Double.class);
                    break;
                case VALUE_STRING:
                    String string = jsonParser.readValueAs(String.class);
                    value.stringValue = string;
                    break;
                case START_ARRAY:
                    value.anythingArrayValue = jsonParser.readValueAs(new TypeReference<List<Object>>() {});
                    break;
                case START_OBJECT:
                    value.fluffyBindingValue = jsonParser.readValueAs(FluffyBinding.class);
                    break;
                default: throw new IOException("Cannot deserialize FluffyStream");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<FluffyStream> {
        @Override
        public void serialize(FluffyStream obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.doubleValue != null) {
                jsonGenerator.writeObject(obj.doubleValue);
                return;
            }
            if (obj.fluffyBindingValue != null) {
                jsonGenerator.writeObject(obj.fluffyBindingValue);
                return;
            }
            if (obj.anythingArrayValue != null) {
                jsonGenerator.writeObject(obj.anythingArrayValue);
                return;
            }
            if (obj.stringValue != null) {
                jsonGenerator.writeObject(obj.stringValue);
                return;
            }
            throw new IOException("FluffyStream must not be null");
        }
    }
}
