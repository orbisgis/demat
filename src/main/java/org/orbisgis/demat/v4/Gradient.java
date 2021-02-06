package org.orbisgis.demat.v4;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(using = Gradient.Deserializer.class)
@JsonSerialize(using = Gradient.Serializer.class)
public class Gradient {
    public ValueLinearGradient valueLinearGradientValue;
    public String stringValue;

    static class Deserializer extends JsonDeserializer<Gradient> {
        @Override
        public Gradient deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            Gradient value = new Gradient();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case VALUE_STRING:
                    String string = jsonParser.readValueAs(String.class);
                    value.stringValue = string;
                    break;
                case START_OBJECT:
                    value.valueLinearGradientValue = jsonParser.readValueAs(ValueLinearGradient.class);
                    break;
                default: throw new IOException("Cannot deserialize Gradient");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<Gradient> {
        @Override
        public void serialize(Gradient obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.valueLinearGradientValue != null) {
                jsonGenerator.writeObject(obj.valueLinearGradientValue);
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
