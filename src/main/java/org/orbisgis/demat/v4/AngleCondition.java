package org.orbisgis.demat.v4;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;
import com.fasterxml.jackson.core.type.*;
import java.util.List;

@JsonDeserialize(using = AngleCondition.Deserializer.class)
@JsonSerialize(using = AngleCondition.Serializer.class)
public class AngleCondition {
    public ConditionalPredicateValueDefNumberExprRefClass conditionalPredicateValueDefNumberExprRefClassValue;
    public List<ConditionalValueDefNumberExprRef> conditionalValueDefNumberExprRefArrayValue;

    static class Deserializer extends JsonDeserializer<AngleCondition> {
        @Override
        public AngleCondition deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            AngleCondition value = new AngleCondition();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case START_ARRAY:
                    value.conditionalValueDefNumberExprRefArrayValue = jsonParser.readValueAs(new TypeReference<List<ConditionalValueDefNumberExprRef>>() {});
                    break;
                case START_OBJECT:
                    value.conditionalPredicateValueDefNumberExprRefClassValue = jsonParser.readValueAs(ConditionalPredicateValueDefNumberExprRefClass.class);
                    break;
                default: throw new IOException("Cannot deserialize AngleCondition");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<AngleCondition> {
        @Override
        public void serialize(AngleCondition obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.conditionalPredicateValueDefNumberExprRefClassValue != null) {
                jsonGenerator.writeObject(obj.conditionalPredicateValueDefNumberExprRefClassValue);
                return;
            }
            if (obj.conditionalValueDefNumberExprRefArrayValue != null) {
                jsonGenerator.writeObject(obj.conditionalValueDefNumberExprRefArrayValue);
                return;
            }
            jsonGenerator.writeNull();
        }
    }
}
