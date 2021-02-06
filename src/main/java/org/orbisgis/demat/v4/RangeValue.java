package org.orbisgis.demat.v4;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;
import com.fasterxml.jackson.core.type.*;
import java.util.List;

@JsonDeserialize(using = RangeValue.Deserializer.class)
@JsonSerialize(using = RangeValue.Serializer.class)
public class RangeValue {
    public List<Object> anythingArrayValue;
    public RangeRange rangeRangeValue;
    public RangeEnum enumValue;

    static class Deserializer extends JsonDeserializer<RangeValue> {
        @Override
        public RangeValue deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            RangeValue value = new RangeValue();
            switch (jsonParser.currentToken()) {
                case VALUE_STRING:
                    String string = jsonParser.readValueAs(String.class);
                    try {
                        value.enumValue = RangeEnum.forValue(string);
                    } catch (Exception ex) {
                        // Ignored
                    }
                    break;
                case START_ARRAY:
                    value.anythingArrayValue = jsonParser.readValueAs(new TypeReference<List<Object>>() {});
                    break;
                case START_OBJECT:
                    value.rangeRangeValue = jsonParser.readValueAs(RangeRange.class);
                    break;
                default: throw new IOException("Cannot deserialize RangeValue");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<RangeValue> {
        @Override
        public void serialize(RangeValue obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.anythingArrayValue != null) {
                jsonGenerator.writeObject(obj.anythingArrayValue);
                return;
            }
            if (obj.rangeRangeValue != null) {
                jsonGenerator.writeObject(obj.rangeRangeValue);
                return;
            }
            if (obj.enumValue != null) {
                jsonGenerator.writeObject(obj.enumValue);
                return;
            }
            throw new IOException("RangeValue must not be null");
        }
    }
}
