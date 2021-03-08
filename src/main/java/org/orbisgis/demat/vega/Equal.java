package org.orbisgis.demat.vega;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;

/**
 * The value that the field should be equal to.
 */
@JsonDeserialize(using = Equal.Deserializer.class)
@JsonSerialize(using = Equal.Serializer.class)
public class Equal {
    public Double doubleValue;
    public Boolean boolValue;
    public EqualDateTime equalDateTimeValue;
    public String stringValue;

    static class Deserializer extends JsonDeserializer<Equal> {
        @Override
        public Equal deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            Equal value = new Equal();
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
                    value.equalDateTimeValue = jsonParser.readValueAs(EqualDateTime.class);
                    break;
                default: throw new IOException("Cannot deserialize Equal");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<Equal> {
        @Override
        public void serialize(Equal obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.doubleValue != null) {
                jsonGenerator.writeObject(obj.doubleValue);
                return;
            }
            if (obj.boolValue != null) {
                jsonGenerator.writeObject(obj.boolValue);
                return;
            }
            if (obj.equalDateTimeValue != null) {
                jsonGenerator.writeObject(obj.equalDateTimeValue);
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
