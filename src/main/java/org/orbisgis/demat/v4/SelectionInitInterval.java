package org.orbisgis.demat.v4;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(using = SelectionInitInterval.Deserializer.class)
@JsonSerialize(using = SelectionInitInterval.Serializer.class)
public class SelectionInitInterval {
    public String stringValue;
    public Double doubleValue;
    public Boolean boolValue;
    public DateTime dateTimeValue;

    static class Deserializer extends JsonDeserializer<SelectionInitInterval> {
        @Override
        public SelectionInitInterval deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            SelectionInitInterval value = new SelectionInitInterval();
            switch (jsonParser.currentToken()) {
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
                    value.dateTimeValue = jsonParser.readValueAs(DateTime.class);
                    break;
                default: throw new IOException("Cannot deserialize SelectionInitInterval");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<SelectionInitInterval> {
        @Override
        public void serialize(SelectionInitInterval obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.stringValue != null) {
                jsonGenerator.writeObject(obj.stringValue);
                return;
            }
            if (obj.doubleValue != null) {
                jsonGenerator.writeObject(obj.doubleValue);
                return;
            }
            if (obj.boolValue != null) {
                jsonGenerator.writeObject(obj.boolValue);
                return;
            }
            if (obj.dateTimeValue != null) {
                jsonGenerator.writeObject(obj.dateTimeValue);
                return;
            }
            throw new IOException("SelectionInitInterval must not be null");
        }
    }
}
