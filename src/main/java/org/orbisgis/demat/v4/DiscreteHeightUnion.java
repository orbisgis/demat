package org.orbisgis.demat.v4;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;

/**
 * The default height when the plot has non arc marks and either a discrete y-field or no
 * y-field. The height can be either a number indicating a fixed height or an object in the
 * form of `{step: number}` defining the height per discrete step.
 *
 * __Default value:__ a step size based on `config.view.step`.
 */
@JsonDeserialize(using = DiscreteHeightUnion.Deserializer.class)
@JsonSerialize(using = DiscreteHeightUnion.Serializer.class)
public class DiscreteHeightUnion {
    public Double doubleValue;
    public DiscreteHeightClass discreteHeightClassValue;

    static class Deserializer extends JsonDeserializer<DiscreteHeightUnion> {
        @Override
        public DiscreteHeightUnion deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            DiscreteHeightUnion value = new DiscreteHeightUnion();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case VALUE_NUMBER_INT:
                case VALUE_NUMBER_FLOAT:
                    value.doubleValue = jsonParser.readValueAs(Double.class);
                    break;
                case START_OBJECT:
                    value.discreteHeightClassValue = jsonParser.readValueAs(DiscreteHeightClass.class);
                    break;
                default: throw new IOException("Cannot deserialize DiscreteHeightUnion");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<DiscreteHeightUnion> {
        @Override
        public void serialize(DiscreteHeightUnion obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.doubleValue != null) {
                jsonGenerator.writeObject(obj.doubleValue);
                return;
            }
            if (obj.discreteHeightClassValue != null) {
                jsonGenerator.writeObject(obj.discreteHeightClassValue);
                return;
            }
            jsonGenerator.writeNull();
        }
    }
}
