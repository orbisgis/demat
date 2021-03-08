package org.orbisgis.demat.vega;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;
import com.fasterxml.jackson.core.type.*;
import java.util.List;

@JsonDeserialize(using = ExprRefConditionUnion.Deserializer.class)
@JsonSerialize(using = ExprRefConditionUnion.Serializer.class)
public class ExprRefConditionUnion {
    public ConditionConditionClass conditionConditionClassValue;
    public List<ConditionalPredicateValueDefTextBaselineNullExprRef> conditionalPredicateValueDefTextBaselineNullExprRefArrayValue;

    static class Deserializer extends JsonDeserializer<ExprRefConditionUnion> {
        @Override
        public ExprRefConditionUnion deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            ExprRefConditionUnion value = new ExprRefConditionUnion();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case START_ARRAY:
                    value.conditionalPredicateValueDefTextBaselineNullExprRefArrayValue = jsonParser.readValueAs(new TypeReference<List<ConditionalPredicateValueDefTextBaselineNullExprRef>>() {});
                    break;
                case START_OBJECT:
                    value.conditionConditionClassValue = jsonParser.readValueAs(ConditionConditionClass.class);
                    break;
                default: throw new IOException("Cannot deserialize ExprRefConditionUnion");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<ExprRefConditionUnion> {
        @Override
        public void serialize(ExprRefConditionUnion obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.conditionConditionClassValue != null) {
                jsonGenerator.writeObject(obj.conditionConditionClassValue);
                return;
            }
            if (obj.conditionalPredicateValueDefTextBaselineNullExprRefArrayValue != null) {
                jsonGenerator.writeObject(obj.conditionalPredicateValueDefTextBaselineNullExprRefArrayValue);
                return;
            }
            jsonGenerator.writeNull();
        }
    }
}
