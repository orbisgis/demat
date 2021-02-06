package org.orbisgis.demat.v4;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(using = Spacing.Deserializer.class)
@JsonSerialize(using = Spacing.Serializer.class)
public class Spacing {
    public Double doubleValue;
    public RowColNumber rowColNumberValue;

    static class Deserializer extends JsonDeserializer<Spacing> {
        @Override
        public Spacing deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            Spacing value = new Spacing();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case VALUE_NUMBER_INT:
                case VALUE_NUMBER_FLOAT:
                    value.doubleValue = jsonParser.readValueAs(Double.class);
                    break;
                case START_OBJECT:
                    value.rowColNumberValue = jsonParser.readValueAs(RowColNumber.class);
                    break;
                default: throw new IOException("Cannot deserialize Spacing");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<Spacing> {
        @Override
        public void serialize(Spacing obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.doubleValue != null) {
                jsonGenerator.writeObject(obj.doubleValue);
                return;
            }
            if (obj.rowColNumberValue != null) {
                jsonGenerator.writeObject(obj.rowColNumberValue);
                return;
            }
            jsonGenerator.writeNull();
        }
    }
}
