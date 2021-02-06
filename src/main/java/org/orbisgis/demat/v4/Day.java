package org.orbisgis.demat.v4;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;

/**
 * Value representing the day of a week. This can be one of: (1) integer value -- `1`
 * represents Monday; (2) case-insensitive day name (e.g., `"Monday"`); (3)
 * case-insensitive, 3-character short day name (e.g., `"Mon"`).
 *
 * **Warning:** A DateTime definition object with `day`** should not be combined with
 * `year`, `quarter`, `month`, or `date`.
 */
@JsonDeserialize(using = Day.Deserializer.class)
@JsonSerialize(using = Day.Serializer.class)
public class Day {
    public Double doubleValue;
    public String stringValue;

    static class Deserializer extends JsonDeserializer<Day> {
        @Override
        public Day deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            Day value = new Day();
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
                default: throw new IOException("Cannot deserialize Day");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<Day> {
        @Override
        public void serialize(Day obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
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
