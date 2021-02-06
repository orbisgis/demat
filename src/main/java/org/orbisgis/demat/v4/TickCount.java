package org.orbisgis.demat.v4;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(using = TickCount.Deserializer.class)
@JsonSerialize(using = TickCount.Serializer.class)
public class TickCount {
    public Double doubleValue;
    public TickCountTimeIntervalStep tickCountTimeIntervalStepValue;
    public TimeInterval enumValue;

    static class Deserializer extends JsonDeserializer<TickCount> {
        @Override
        public TickCount deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            TickCount value = new TickCount();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case VALUE_NUMBER_INT:
                case VALUE_NUMBER_FLOAT:
                    value.doubleValue = jsonParser.readValueAs(Double.class);
                    break;
                case VALUE_STRING:
                    String string = jsonParser.readValueAs(String.class);
                    try {
                        value.enumValue = TimeInterval.forValue(string);
                    } catch (Exception ex) {
                        // Ignored
                    }
                    break;
                case START_OBJECT:
                    value.tickCountTimeIntervalStepValue = jsonParser.readValueAs(TickCountTimeIntervalStep.class);
                    break;
                default: throw new IOException("Cannot deserialize TickCount");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<TickCount> {
        @Override
        public void serialize(TickCount obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.doubleValue != null) {
                jsonGenerator.writeObject(obj.doubleValue);
                return;
            }
            if (obj.tickCountTimeIntervalStepValue != null) {
                jsonGenerator.writeObject(obj.tickCountTimeIntervalStepValue);
                return;
            }
            if (obj.enumValue != null) {
                jsonGenerator.writeObject(obj.enumValue);
                return;
            }
            jsonGenerator.writeNull();
        }
    }
}
