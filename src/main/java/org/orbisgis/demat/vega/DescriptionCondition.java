package org.orbisgis.demat.vega;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;
import com.fasterxml.jackson.core.type.*;
import java.util.List;

@JsonDeserialize(using = DescriptionCondition.Deserializer.class)
@JsonSerialize(using = DescriptionCondition.Serializer.class)
public class DescriptionCondition {
    public PurpleConditionalExprRef purpleConditionalExprRefValue;
    public List<PurpleConditionalValueDefStringExprRef> purpleConditionalValueDefStringExprRefArrayValue;

    static class Deserializer extends JsonDeserializer<DescriptionCondition> {
        @Override
        public DescriptionCondition deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            DescriptionCondition value = new DescriptionCondition();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case START_ARRAY:
                    value.purpleConditionalValueDefStringExprRefArrayValue = jsonParser.readValueAs(new TypeReference<List<PurpleConditionalValueDefStringExprRef>>() {});
                    break;
                case START_OBJECT:
                    value.purpleConditionalExprRefValue = jsonParser.readValueAs(PurpleConditionalExprRef.class);
                    break;
                default: throw new IOException("Cannot deserialize DescriptionCondition");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<DescriptionCondition> {
        @Override
        public void serialize(DescriptionCondition obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.purpleConditionalExprRefValue != null) {
                jsonGenerator.writeObject(obj.purpleConditionalExprRefValue);
                return;
            }
            if (obj.purpleConditionalValueDefStringExprRefArrayValue != null) {
                jsonGenerator.writeObject(obj.purpleConditionalValueDefStringExprRefArrayValue);
                return;
            }
            jsonGenerator.writeNull();
        }
    }
}
