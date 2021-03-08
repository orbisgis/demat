package org.orbisgis.demat.vega;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;
import com.fasterxml.jackson.core.type.*;
import java.util.List;

@JsonDeserialize(using = FluffyConditionalPredicateValueDefFontStyleNullExprRef.Deserializer.class)
@JsonSerialize(using = FluffyConditionalPredicateValueDefFontStyleNullExprRef.Serializer.class)
public class FluffyConditionalPredicateValueDefFontStyleNullExprRef {
    public PurpleConditionalPredicateValueDefFontStyleNullExprRef purpleConditionalPredicateValueDefFontStyleNullExprRefValue;
    public List<ConditionalPredicateValueDefFontStyleNullExprRef> conditionalPredicateValueDefFontStyleNullExprRefArrayValue;

    static class Deserializer extends JsonDeserializer<FluffyConditionalPredicateValueDefFontStyleNullExprRef> {
        @Override
        public FluffyConditionalPredicateValueDefFontStyleNullExprRef deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            FluffyConditionalPredicateValueDefFontStyleNullExprRef value = new FluffyConditionalPredicateValueDefFontStyleNullExprRef();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case START_ARRAY:
                    value.conditionalPredicateValueDefFontStyleNullExprRefArrayValue = jsonParser.readValueAs(new TypeReference<List<ConditionalPredicateValueDefFontStyleNullExprRef>>() {});
                    break;
                case START_OBJECT:
                    value.purpleConditionalPredicateValueDefFontStyleNullExprRefValue = jsonParser.readValueAs(PurpleConditionalPredicateValueDefFontStyleNullExprRef.class);
                    break;
                default: throw new IOException("Cannot deserialize FluffyConditionalPredicateValueDefFontStyleNullExprRef");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<FluffyConditionalPredicateValueDefFontStyleNullExprRef> {
        @Override
        public void serialize(FluffyConditionalPredicateValueDefFontStyleNullExprRef obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.purpleConditionalPredicateValueDefFontStyleNullExprRefValue != null) {
                jsonGenerator.writeObject(obj.purpleConditionalPredicateValueDefFontStyleNullExprRefValue);
                return;
            }
            if (obj.conditionalPredicateValueDefFontStyleNullExprRefArrayValue != null) {
                jsonGenerator.writeObject(obj.conditionalPredicateValueDefFontStyleNullExprRefArrayValue);
                return;
            }
            jsonGenerator.writeNull();
        }
    }
}
