package org.orbisgis.demat.v4;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;
import com.fasterxml.jackson.core.type.*;
import java.util.List;

@JsonDeserialize(using = ExprRefCondition.Deserializer.class)
@JsonSerialize(using = ExprRefCondition.Serializer.class)
public class ExprRefCondition {
    public ConditionCondition conditionConditionValue;
    public List<ConditionalPredicateValueDefAlignNullExprRef> conditionalPredicateValueDefAlignNullExprRefArrayValue;

    static class Deserializer extends JsonDeserializer<ExprRefCondition> {
        @Override
        public ExprRefCondition deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            ExprRefCondition value = new ExprRefCondition();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case START_ARRAY:
                    value.conditionalPredicateValueDefAlignNullExprRefArrayValue = jsonParser.readValueAs(new TypeReference<List<ConditionalPredicateValueDefAlignNullExprRef>>() {});
                    break;
                case START_OBJECT:
                    value.conditionConditionValue = jsonParser.readValueAs(ConditionCondition.class);
                    break;
                default: throw new IOException("Cannot deserialize ExprRefCondition");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<ExprRefCondition> {
        @Override
        public void serialize(ExprRefCondition obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.conditionConditionValue != null) {
                jsonGenerator.writeObject(obj.conditionConditionValue);
                return;
            }
            if (obj.conditionalPredicateValueDefAlignNullExprRefArrayValue != null) {
                jsonGenerator.writeObject(obj.conditionalPredicateValueDefAlignNullExprRefArrayValue);
                return;
            }
            jsonGenerator.writeNull();
        }
    }
}
