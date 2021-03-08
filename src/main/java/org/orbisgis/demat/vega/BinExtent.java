package org.orbisgis.demat.vega;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;
import com.fasterxml.jackson.core.type.*;
import java.util.List;

/**
 * A two-element (`[min, max]`) array indicating the range of desired bin values.
 */
@JsonDeserialize(using = BinExtent.Deserializer.class)
@JsonSerialize(using = BinExtent.Serializer.class)
public class BinExtent {
    public List<Double> doubleArrayValue;
    public BinExtentClass binExtentClassValue;

    static class Deserializer extends JsonDeserializer<BinExtent> {
        @Override
        public BinExtent deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            BinExtent value = new BinExtent();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case START_ARRAY:
                    value.doubleArrayValue = jsonParser.readValueAs(new TypeReference<List<Double>>() {});
                    break;
                case START_OBJECT:
                    value.binExtentClassValue = jsonParser.readValueAs(BinExtentClass.class);
                    break;
                default: throw new IOException("Cannot deserialize BinExtent");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<BinExtent> {
        @Override
        public void serialize(BinExtent obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.doubleArrayValue != null) {
                jsonGenerator.writeObject(obj.doubleArrayValue);
                return;
            }
            if (obj.binExtentClassValue != null) {
                jsonGenerator.writeObject(obj.binExtentClassValue);
                return;
            }
            jsonGenerator.writeNull();
        }
    }
}
