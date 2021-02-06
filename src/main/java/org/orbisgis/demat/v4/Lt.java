package org.orbisgis.demat.v4;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(using = Lt.Deserializer.class)
@JsonSerialize(using = Lt.Serializer.class)
public class Lt {
    public Double doubleValue;
    public GtDateTime gtDateTimeValue;
    public String stringValue;

    static class Deserializer extends JsonDeserializer<Lt> {
        @Override
        public Lt deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            Lt value = new Lt();
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
                    value.gtDateTimeValue = jsonParser.readValueAs(GtDateTime.class);
                    break;
                default: throw new IOException("Cannot deserialize Lt");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<Lt> {
        @Override
        public void serialize(Lt obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.doubleValue != null) {
                jsonGenerator.writeObject(obj.doubleValue);
                return;
            }
            if (obj.gtDateTimeValue != null) {
                jsonGenerator.writeObject(obj.gtDateTimeValue);
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
