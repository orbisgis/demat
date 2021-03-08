package org.orbisgis.demat.vega;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(using = Height.Deserializer.class)
@JsonSerialize(using = Height.Serializer.class)
public class Height {
    public Double doubleValue;
    public Step stepValue;
    public String stringValue;

    static class Deserializer extends JsonDeserializer<Height> {
        @Override
        public Height deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            Height value = new Height();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case VALUE_NUMBER_INT:
                case VALUE_NUMBER_FLOAT:
                    value.doubleValue = jsonParser.readValueAs(Double.class);
                    break;
                case VALUE_STRING:
                    String string = jsonParser.readValueAs(String.class);
                    value.stringValue = string;
                    break;
                case START_OBJECT:
                    value.stepValue = jsonParser.readValueAs(Step.class);
                    break;
                default: throw new IOException("Cannot deserialize Height");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<Height> {
        @Override
        public void serialize(Height obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.doubleValue != null) {
                jsonGenerator.writeObject(obj.doubleValue);
                return;
            }
            if (obj.stepValue != null) {
                jsonGenerator.writeObject(obj.stepValue);
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
