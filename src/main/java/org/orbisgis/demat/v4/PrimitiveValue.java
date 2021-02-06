package org.orbisgis.demat.v4;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;

/**
 * A constant value in data domain.
 */
@JsonDeserialize(using = PrimitiveValue.Deserializer.class)
@JsonSerialize(using = PrimitiveValue.Serializer.class)
public class PrimitiveValue {
    public Double doubleValue;
    public Boolean boolValue;
    public RepeatRefClass repeatRefClassValue;
    public String stringValue;

    static class Deserializer extends JsonDeserializer<PrimitiveValue> {
        @Override
        public PrimitiveValue deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            PrimitiveValue value = new PrimitiveValue();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case VALUE_NUMBER_INT:
                case VALUE_NUMBER_FLOAT:
                    value.doubleValue = jsonParser.readValueAs(Double.class);
                    break;
                case VALUE_TRUE:
                case VALUE_FALSE:
                    value.boolValue = jsonParser.readValueAs(Boolean.class);
                    break;
                case VALUE_STRING:
                    String string = jsonParser.readValueAs(String.class);
                    value.stringValue = string;
                    break;
                case START_OBJECT:
                    value.repeatRefClassValue = jsonParser.readValueAs(RepeatRefClass.class);
                    break;
                default: throw new IOException("Cannot deserialize PrimitiveValue");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<PrimitiveValue> {
        @Override
        public void serialize(PrimitiveValue obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.doubleValue != null) {
                jsonGenerator.writeObject(obj.doubleValue);
                return;
            }
            if (obj.boolValue != null) {
                jsonGenerator.writeObject(obj.boolValue);
                return;
            }
            if (obj.repeatRefClassValue != null) {
                jsonGenerator.writeObject(obj.repeatRefClassValue);
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
