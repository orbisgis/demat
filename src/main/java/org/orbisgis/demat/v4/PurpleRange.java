package org.orbisgis.demat.v4;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(using = PurpleRange.Deserializer.class)
@JsonSerialize(using = PurpleRange.Serializer.class)
public class PurpleRange {
    public Double doubleValue;
    public RangeDateTime rangeDateTimeValue;

    static class Deserializer extends JsonDeserializer<PurpleRange> {
        @Override
        public PurpleRange deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            PurpleRange value = new PurpleRange();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case VALUE_NUMBER_INT:
                case VALUE_NUMBER_FLOAT:
                    value.doubleValue = jsonParser.readValueAs(Double.class);
                    break;
                case START_OBJECT:
                    value.rangeDateTimeValue = jsonParser.readValueAs(RangeDateTime.class);
                    break;
                default: throw new IOException("Cannot deserialize PurpleRange");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<PurpleRange> {
        @Override
        public void serialize(PurpleRange obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.doubleValue != null) {
                jsonGenerator.writeObject(obj.doubleValue);
                return;
            }
            if (obj.rangeDateTimeValue != null) {
                jsonGenerator.writeObject(obj.rangeDateTimeValue);
                return;
            }
            jsonGenerator.writeNull();
        }
    }
}
