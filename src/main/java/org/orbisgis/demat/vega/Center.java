package org.orbisgis.demat.vega;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(using = Center.Deserializer.class)
@JsonSerialize(using = Center.Serializer.class)
public class Center {
    public Boolean boolValue;
    public RowColBoolean rowColBooleanValue;

    static class Deserializer extends JsonDeserializer<Center> {
        @Override
        public Center deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            Center value = new Center();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case VALUE_TRUE:
                case VALUE_FALSE:
                    value.boolValue = jsonParser.readValueAs(Boolean.class);
                    break;
                case START_OBJECT:
                    value.rowColBooleanValue = jsonParser.readValueAs(RowColBoolean.class);
                    break;
                default: throw new IOException("Cannot deserialize Center");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<Center> {
        @Override
        public void serialize(Center obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.boolValue != null) {
                jsonGenerator.writeObject(obj.boolValue);
                return;
            }
            if (obj.rowColBooleanValue != null) {
                jsonGenerator.writeObject(obj.rowColBooleanValue);
                return;
            }
            jsonGenerator.writeNull();
        }
    }
}
