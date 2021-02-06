package org.orbisgis.demat.v4;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;
import com.fasterxml.jackson.core.type.*;
import java.util.List;

@JsonDeserialize(using = StickyConditionalPredicateValueDefNumberNullExprRef.Deserializer.class)
@JsonSerialize(using = StickyConditionalPredicateValueDefNumberNullExprRef.Serializer.class)
public class StickyConditionalPredicateValueDefNumberNullExprRef {
    public FluffyConditionalPredicateValueDefNumberNullExprRef fluffyConditionalPredicateValueDefNumberNullExprRefValue;
    public List<ConditionalPredicateValueDefNumberNullExprRefElement> conditionalPredicateValueDefNumberNullExprRefElementArrayValue;

    static class Deserializer extends JsonDeserializer<StickyConditionalPredicateValueDefNumberNullExprRef> {
        @Override
        public StickyConditionalPredicateValueDefNumberNullExprRef deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            StickyConditionalPredicateValueDefNumberNullExprRef value = new StickyConditionalPredicateValueDefNumberNullExprRef();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case START_ARRAY:
                    value.conditionalPredicateValueDefNumberNullExprRefElementArrayValue = jsonParser.readValueAs(new TypeReference<List<ConditionalPredicateValueDefNumberNullExprRefElement>>() {});
                    break;
                case START_OBJECT:
                    value.fluffyConditionalPredicateValueDefNumberNullExprRefValue = jsonParser.readValueAs(FluffyConditionalPredicateValueDefNumberNullExprRef.class);
                    break;
                default: throw new IOException("Cannot deserialize StickyConditionalPredicateValueDefNumberNullExprRef");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<StickyConditionalPredicateValueDefNumberNullExprRef> {
        @Override
        public void serialize(StickyConditionalPredicateValueDefNumberNullExprRef obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.fluffyConditionalPredicateValueDefNumberNullExprRefValue != null) {
                jsonGenerator.writeObject(obj.fluffyConditionalPredicateValueDefNumberNullExprRefValue);
                return;
            }
            if (obj.conditionalPredicateValueDefNumberNullExprRefElementArrayValue != null) {
                jsonGenerator.writeObject(obj.conditionalPredicateValueDefNumberNullExprRefElementArrayValue);
                return;
            }
            jsonGenerator.writeNull();
        }
    }
}
