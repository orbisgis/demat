package org.orbisgis.demat.v4;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;
import com.fasterxml.jackson.core.type.*;
import java.util.List;

@JsonDeserialize(using = ShapeCondition.Deserializer.class)
@JsonSerialize(using = ShapeCondition.Serializer.class)
public class ShapeCondition {
    public ConditionalPredicateValueDefStringNullExprRefClass conditionalPredicateValueDefStringNullExprRefClassValue;
    public List<ConditionalValueDefStringNullExprRef> conditionalValueDefStringNullExprRefArrayValue;

    static class Deserializer extends JsonDeserializer<ShapeCondition> {
        @Override
        public ShapeCondition deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            ShapeCondition value = new ShapeCondition();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case START_ARRAY:
                    value.conditionalValueDefStringNullExprRefArrayValue = jsonParser.readValueAs(new TypeReference<List<ConditionalValueDefStringNullExprRef>>() {});
                    break;
                case START_OBJECT:
                    value.conditionalPredicateValueDefStringNullExprRefClassValue = jsonParser.readValueAs(ConditionalPredicateValueDefStringNullExprRefClass.class);
                    break;
                default: throw new IOException("Cannot deserialize ShapeCondition");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<ShapeCondition> {
        @Override
        public void serialize(ShapeCondition obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.conditionalPredicateValueDefStringNullExprRefClassValue != null) {
                jsonGenerator.writeObject(obj.conditionalPredicateValueDefStringNullExprRefClassValue);
                return;
            }
            if (obj.conditionalValueDefStringNullExprRefArrayValue != null) {
                jsonGenerator.writeObject(obj.conditionalValueDefStringNullExprRefArrayValue);
                return;
            }
            jsonGenerator.writeNull();
        }
    }
}
