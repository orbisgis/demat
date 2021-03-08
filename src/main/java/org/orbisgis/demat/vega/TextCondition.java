package org.orbisgis.demat.vega;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;
import com.fasterxml.jackson.core.type.*;
import java.util.List;

@JsonDeserialize(using = TextCondition.Deserializer.class)
@JsonSerialize(using = TextCondition.Serializer.class)
public class TextCondition {
    public Conditional conditionalValue;
    public List<ConditionalValueDefTextExprRef> conditionalValueDefTextExprRefArrayValue;

    static class Deserializer extends JsonDeserializer<TextCondition> {
        @Override
        public TextCondition deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            TextCondition value = new TextCondition();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case START_ARRAY:
                    value.conditionalValueDefTextExprRefArrayValue = jsonParser.readValueAs(new TypeReference<List<ConditionalValueDefTextExprRef>>() {});
                    break;
                case START_OBJECT:
                    value.conditionalValue = jsonParser.readValueAs(Conditional.class);
                    break;
                default: throw new IOException("Cannot deserialize TextCondition");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<TextCondition> {
        @Override
        public void serialize(TextCondition obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.conditionalValue != null) {
                jsonGenerator.writeObject(obj.conditionalValue);
                return;
            }
            if (obj.conditionalValueDefTextExprRefArrayValue != null) {
                jsonGenerator.writeObject(obj.conditionalValueDefTextExprRefArrayValue);
                return;
            }
            jsonGenerator.writeNull();
        }
    }
}
