package org.orbisgis.demat.v4;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;
import com.fasterxml.jackson.core.type.*;
import java.util.List;

@JsonDeserialize(using = AxisTickDash.Deserializer.class)
@JsonSerialize(using = AxisTickDash.Serializer.class)
public class AxisTickDash {
    public List<Double> doubleArrayValue;
    public HilariousExprRef hilariousExprRefValue;

    static class Deserializer extends JsonDeserializer<AxisTickDash> {
        @Override
        public AxisTickDash deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            AxisTickDash value = new AxisTickDash();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case START_ARRAY:
                    value.doubleArrayValue = jsonParser.readValueAs(new TypeReference<List<Double>>() {});
                    break;
                case START_OBJECT:
                    value.hilariousExprRefValue = jsonParser.readValueAs(HilariousExprRef.class);
                    break;
                default: throw new IOException("Cannot deserialize AxisTickDash");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<AxisTickDash> {
        @Override
        public void serialize(AxisTickDash obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.doubleArrayValue != null) {
                jsonGenerator.writeObject(obj.doubleArrayValue);
                return;
            }
            if (obj.hilariousExprRefValue != null) {
                jsonGenerator.writeObject(obj.hilariousExprRefValue);
                return;
            }
            jsonGenerator.writeNull();
        }
    }
}
