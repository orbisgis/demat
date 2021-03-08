package org.orbisgis.demat.vega;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;
import com.fasterxml.jackson.core.type.*;
import java.util.List;

@JsonDeserialize(using = AxisBandTickDash.Deserializer.class)
@JsonSerialize(using = AxisBandTickDash.Serializer.class)
public class AxisBandTickDash {
    public List<Double> doubleArrayValue;
    public CunningExprRef cunningExprRefValue;

    static class Deserializer extends JsonDeserializer<AxisBandTickDash> {
        @Override
        public AxisBandTickDash deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            AxisBandTickDash value = new AxisBandTickDash();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case START_ARRAY:
                    value.doubleArrayValue = jsonParser.readValueAs(new TypeReference<List<Double>>() {});
                    break;
                case START_OBJECT:
                    value.cunningExprRefValue = jsonParser.readValueAs(CunningExprRef.class);
                    break;
                default: throw new IOException("Cannot deserialize AxisBandTickDash");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<AxisBandTickDash> {
        @Override
        public void serialize(AxisBandTickDash obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.doubleArrayValue != null) {
                jsonGenerator.writeObject(obj.doubleArrayValue);
                return;
            }
            if (obj.cunningExprRefValue != null) {
                jsonGenerator.writeObject(obj.cunningExprRefValue);
                return;
            }
            jsonGenerator.writeNull();
        }
    }
}
