package org.orbisgis.demat.vega;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;

/**
 * The default width when the plot has non-arc marks and either a discrete x-field or no
 * x-field. The width can be either a number indicating a fixed width or an object in the
 * form of `{step: number}` defining the width per discrete step.
 *
 * __Default value:__ a step size based on `config.view.step`.
 */
@JsonDeserialize(using = DiscreteWidthUnion.Deserializer.class)
@JsonSerialize(using = DiscreteWidthUnion.Serializer.class)
public class DiscreteWidthUnion {
    public Double doubleValue;
    public DiscreteWidthClass discreteWidthClassValue;

    static class Deserializer extends JsonDeserializer<DiscreteWidthUnion> {
        @Override
        public DiscreteWidthUnion deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            DiscreteWidthUnion value = new DiscreteWidthUnion();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case VALUE_NUMBER_INT:
                case VALUE_NUMBER_FLOAT:
                    value.doubleValue = jsonParser.readValueAs(Double.class);
                    break;
                case START_OBJECT:
                    value.discreteWidthClassValue = jsonParser.readValueAs(DiscreteWidthClass.class);
                    break;
                default: throw new IOException("Cannot deserialize DiscreteWidthUnion");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<DiscreteWidthUnion> {
        @Override
        public void serialize(DiscreteWidthUnion obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.doubleValue != null) {
                jsonGenerator.writeObject(obj.doubleValue);
                return;
            }
            if (obj.discreteWidthClassValue != null) {
                jsonGenerator.writeObject(obj.discreteWidthClassValue);
                return;
            }
            jsonGenerator.writeNull();
        }
    }
}
