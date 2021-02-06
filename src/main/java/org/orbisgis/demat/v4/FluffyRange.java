package org.orbisgis.demat.v4;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;
import com.fasterxml.jackson.core.type.*;
import java.util.List;

@JsonDeserialize(using = FluffyRange.Deserializer.class)
@JsonSerialize(using = FluffyRange.Serializer.class)
public class FluffyRange {
    public Double doubleValue;
    public List<Double> doubleArrayValue;
    public BackgroundExprRef backgroundExprRefValue;
    public String stringValue;

    static class Deserializer extends JsonDeserializer<FluffyRange> {
        @Override
        public FluffyRange deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            FluffyRange value = new FluffyRange();
            switch (jsonParser.currentToken()) {
                case VALUE_NUMBER_INT:
                case VALUE_NUMBER_FLOAT:
                    value.doubleValue = jsonParser.readValueAs(Double.class);
                    break;
                case VALUE_STRING:
                    String string = jsonParser.readValueAs(String.class);
                    value.stringValue = string;
                    break;
                case START_ARRAY:
                    value.doubleArrayValue = jsonParser.readValueAs(new TypeReference<List<Double>>() {});
                    break;
                case START_OBJECT:
                    value.backgroundExprRefValue = jsonParser.readValueAs(BackgroundExprRef.class);
                    break;
                default: throw new IOException("Cannot deserialize FluffyRange");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<FluffyRange> {
        @Override
        public void serialize(FluffyRange obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.doubleValue != null) {
                jsonGenerator.writeObject(obj.doubleValue);
                return;
            }
            if (obj.doubleArrayValue != null) {
                jsonGenerator.writeObject(obj.doubleArrayValue);
                return;
            }
            if (obj.backgroundExprRefValue != null) {
                jsonGenerator.writeObject(obj.backgroundExprRefValue);
                return;
            }
            if (obj.stringValue != null) {
                jsonGenerator.writeObject(obj.stringValue);
                return;
            }
            throw new IOException("FluffyRange must not be null");
        }
    }
}
