package org.orbisgis.demat.vega;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;
import com.fasterxml.jackson.core.type.*;
import java.util.List;

@JsonDeserialize(using = AxisGridDash.Deserializer.class)
@JsonSerialize(using = AxisGridDash.Serializer.class)
public class AxisGridDash {
    public List<Double> doubleArrayValue;
    public PurpleExprRef purpleExprRefValue;

    static class Deserializer extends JsonDeserializer<AxisGridDash> {
        @Override
        public AxisGridDash deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            AxisGridDash value = new AxisGridDash();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case START_ARRAY:
                    value.doubleArrayValue = jsonParser.readValueAs(new TypeReference<List<Double>>() {});
                    break;
                case START_OBJECT:
                    value.purpleExprRefValue = jsonParser.readValueAs(PurpleExprRef.class);
                    break;
                default: throw new IOException("Cannot deserialize AxisGridDash");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<AxisGridDash> {
        @Override
        public void serialize(AxisGridDash obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.doubleArrayValue != null) {
                jsonGenerator.writeObject(obj.doubleArrayValue);
                return;
            }
            if (obj.purpleExprRefValue != null) {
                jsonGenerator.writeObject(obj.purpleExprRefValue);
                return;
            }
            jsonGenerator.writeNull();
        }
    }
}
