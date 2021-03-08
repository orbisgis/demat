package org.orbisgis.demat.vega;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;
import com.fasterxml.jackson.core.type.*;
import java.util.List;

@JsonDeserialize(using = AxisBandGridDash.Deserializer.class)
@JsonSerialize(using = AxisBandGridDash.Serializer.class)
public class AxisBandGridDash {
    public List<Double> doubleArrayValue;
    public AmbitiousExprRef ambitiousExprRefValue;

    static class Deserializer extends JsonDeserializer<AxisBandGridDash> {
        @Override
        public AxisBandGridDash deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            AxisBandGridDash value = new AxisBandGridDash();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case START_ARRAY:
                    value.doubleArrayValue = jsonParser.readValueAs(new TypeReference<List<Double>>() {});
                    break;
                case START_OBJECT:
                    value.ambitiousExprRefValue = jsonParser.readValueAs(AmbitiousExprRef.class);
                    break;
                default: throw new IOException("Cannot deserialize AxisBandGridDash");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<AxisBandGridDash> {
        @Override
        public void serialize(AxisBandGridDash obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.doubleArrayValue != null) {
                jsonGenerator.writeObject(obj.doubleArrayValue);
                return;
            }
            if (obj.ambitiousExprRefValue != null) {
                jsonGenerator.writeObject(obj.ambitiousExprRefValue);
                return;
            }
            jsonGenerator.writeNull();
        }
    }
}
