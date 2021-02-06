package org.orbisgis.demat.v4;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;
import com.fasterxml.jackson.core.type.*;
import java.util.List;

@JsonDeserialize(using = StrokeDashCondition.Deserializer.class)
@JsonSerialize(using = StrokeDashCondition.Serializer.class)
public class StrokeDashCondition {
    public ConditionalSelectionValueDefNumberExprRefClass conditionalSelectionValueDefNumberExprRefClassValue;
    public List<ConditionalValueDefNumberExprRefElement> conditionalValueDefNumberExprRefElementArrayValue;

    static class Deserializer extends JsonDeserializer<StrokeDashCondition> {
        @Override
        public StrokeDashCondition deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            StrokeDashCondition value = new StrokeDashCondition();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case START_ARRAY:
                    value.conditionalValueDefNumberExprRefElementArrayValue = jsonParser.readValueAs(new TypeReference<List<ConditionalValueDefNumberExprRefElement>>() {});
                    break;
                case START_OBJECT:
                    value.conditionalSelectionValueDefNumberExprRefClassValue = jsonParser.readValueAs(ConditionalSelectionValueDefNumberExprRefClass.class);
                    break;
                default: throw new IOException("Cannot deserialize StrokeDashCondition");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<StrokeDashCondition> {
        @Override
        public void serialize(StrokeDashCondition obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.conditionalSelectionValueDefNumberExprRefClassValue != null) {
                jsonGenerator.writeObject(obj.conditionalSelectionValueDefNumberExprRefClassValue);
                return;
            }
            if (obj.conditionalValueDefNumberExprRefElementArrayValue != null) {
                jsonGenerator.writeObject(obj.conditionalValueDefNumberExprRefElementArrayValue);
                return;
            }
            jsonGenerator.writeNull();
        }
    }
}
