package org.orbisgis.demat.vega;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;
import com.fasterxml.jackson.core.type.*;
import java.util.List;

@JsonDeserialize(using = PurpleStream.Deserializer.class)
@JsonSerialize(using = PurpleStream.Serializer.class)
public class PurpleStream {
    public Double doubleValue;
    public PurpleBinding purpleBindingValue;
    public List<Object> anythingArrayValue;
    public String stringValue;

    static class Deserializer extends JsonDeserializer<PurpleStream> {
        @Override
        public PurpleStream deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            PurpleStream value = new PurpleStream();
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
                    value.purpleBindingValue = jsonParser.readValueAs(PurpleBinding.class);
                    break;
                default: throw new IOException("Cannot deserialize PurpleStream");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<PurpleStream> {
        @Override
        public void serialize(PurpleStream obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.doubleValue != null) {
                jsonGenerator.writeObject(obj.doubleValue);
                return;
            }
            if (obj.purpleBindingValue != null) {
                jsonGenerator.writeObject(obj.purpleBindingValue);
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
            throw new IOException("PurpleStream must not be null");
        }
    }
}
