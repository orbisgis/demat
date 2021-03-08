package org.orbisgis.demat.vega;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;
import com.fasterxml.jackson.core.type.*;
import java.util.List;

@JsonDeserialize(using = ConditionUnion.Deserializer.class)
@JsonSerialize(using = ConditionUnion.Serializer.class)
public class ConditionUnion {
    public ConditionClass conditionClassValue;
    public List<ConditionalPredicateValueDefColorNullExprRef> conditionalPredicateValueDefColorNullExprRefArrayValue;

    static class Deserializer extends JsonDeserializer<ConditionUnion> {
        @Override
        public ConditionUnion deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            ConditionUnion value = new ConditionUnion();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case START_ARRAY:
                    value.conditionalPredicateValueDefColorNullExprRefArrayValue = jsonParser.readValueAs(new TypeReference<List<ConditionalPredicateValueDefColorNullExprRef>>() {});
                    break;
                case START_OBJECT:
                    value.conditionClassValue = jsonParser.readValueAs(ConditionClass.class);
                    break;
                default: throw new IOException("Cannot deserialize ConditionUnion");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<ConditionUnion> {
        @Override
        public void serialize(ConditionUnion obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.conditionClassValue != null) {
                jsonGenerator.writeObject(obj.conditionClassValue);
                return;
            }
            if (obj.conditionalPredicateValueDefColorNullExprRefArrayValue != null) {
                jsonGenerator.writeObject(obj.conditionalPredicateValueDefColorNullExprRefArrayValue);
                return;
            }
            jsonGenerator.writeNull();
        }
    }
}
