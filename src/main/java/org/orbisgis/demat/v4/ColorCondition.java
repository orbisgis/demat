package org.orbisgis.demat.v4;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;
import com.fasterxml.jackson.core.type.*;
import java.util.List;

@JsonDeserialize(using = ColorCondition.Deserializer.class)
@JsonSerialize(using = ColorCondition.Serializer.class)
public class ColorCondition {
    public ConditionalPredicateValueDefGradientStringNullExprRefClass conditionalPredicateValueDefGradientStringNullExprRefClassValue;
    public List<ConditionalValueDefGradientStringNullExprRef> conditionalValueDefGradientStringNullExprRefArrayValue;

    static class Deserializer extends JsonDeserializer<ColorCondition> {
        @Override
        public ColorCondition deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            ColorCondition value = new ColorCondition();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case START_ARRAY:
                    value.conditionalValueDefGradientStringNullExprRefArrayValue = jsonParser.readValueAs(new TypeReference<List<ConditionalValueDefGradientStringNullExprRef>>() {});
                    break;
                case START_OBJECT:
                    value.conditionalPredicateValueDefGradientStringNullExprRefClassValue = jsonParser.readValueAs(ConditionalPredicateValueDefGradientStringNullExprRefClass.class);
                    break;
                default: throw new IOException("Cannot deserialize ColorCondition");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<ColorCondition> {
        @Override
        public void serialize(ColorCondition obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.conditionalPredicateValueDefGradientStringNullExprRefClassValue != null) {
                jsonGenerator.writeObject(obj.conditionalPredicateValueDefGradientStringNullExprRefClassValue);
                return;
            }
            if (obj.conditionalValueDefGradientStringNullExprRefArrayValue != null) {
                jsonGenerator.writeObject(obj.conditionalValueDefGradientStringNullExprRefArrayValue);
                return;
            }
            jsonGenerator.writeNull();
        }
    }
}
