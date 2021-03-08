package org.orbisgis.demat.vega;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;

/**
 * One of: (1) integer value representing the month from `1`-`12`. `1` represents January;
 * (2) case-insensitive month name (e.g., `"January"`); (3) case-insensitive, 3-character
 * short month name (e.g., `"Jan"`).
 */
@JsonDeserialize(using = Month.Deserializer.class)
@JsonSerialize(using = Month.Serializer.class)
public class Month {
    public Double doubleValue;
    public String stringValue;

    static class Deserializer extends JsonDeserializer<Month> {
        @Override
        public Month deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            Month value = new Month();
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
                default: throw new IOException("Cannot deserialize Month");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<Month> {
        @Override
        public void serialize(Month obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.doubleValue != null) {
                jsonGenerator.writeObject(obj.doubleValue);
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
