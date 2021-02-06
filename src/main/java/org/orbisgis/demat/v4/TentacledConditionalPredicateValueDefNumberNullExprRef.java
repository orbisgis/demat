package org.orbisgis.demat.v4;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;
import com.fasterxml.jackson.core.type.*;
import java.util.List;

@JsonDeserialize(using = TentacledConditionalPredicateValueDefNumberNullExprRef.Deserializer.class)
@JsonSerialize(using = TentacledConditionalPredicateValueDefNumberNullExprRef.Serializer.class)
public class TentacledConditionalPredicateValueDefNumberNullExprRef {
    public PurpleConditionalPredicateValueDefNumberNullExprRef purpleConditionalPredicateValueDefNumberNullExprRefValue;
    public List<ConditionalPredicateValueDefNumberNullExprRef> conditionalPredicateValueDefNumberNullExprRefArrayValue;

    static class Deserializer extends JsonDeserializer<TentacledConditionalPredicateValueDefNumberNullExprRef> {
        @Override
        public TentacledConditionalPredicateValueDefNumberNullExprRef deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            TentacledConditionalPredicateValueDefNumberNullExprRef value = new TentacledConditionalPredicateValueDefNumberNullExprRef();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case START_ARRAY:
                    value.conditionalPredicateValueDefNumberNullExprRefArrayValue = jsonParser.readValueAs(new TypeReference<List<ConditionalPredicateValueDefNumberNullExprRef>>() {});
                    break;
                case START_OBJECT:
                    value.purpleConditionalPredicateValueDefNumberNullExprRefValue = jsonParser.readValueAs(PurpleConditionalPredicateValueDefNumberNullExprRef.class);
                    break;
                default: throw new IOException("Cannot deserialize TentacledConditionalPredicateValueDefNumberNullExprRef");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<TentacledConditionalPredicateValueDefNumberNullExprRef> {
        @Override
        public void serialize(TentacledConditionalPredicateValueDefNumberNullExprRef obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.purpleConditionalPredicateValueDefNumberNullExprRefValue != null) {
                jsonGenerator.writeObject(obj.purpleConditionalPredicateValueDefNumberNullExprRefValue);
                return;
            }
            if (obj.conditionalPredicateValueDefNumberNullExprRefArrayValue != null) {
                jsonGenerator.writeObject(obj.conditionalPredicateValueDefNumberNullExprRefArrayValue);
                return;
            }
            jsonGenerator.writeNull();
        }
    }
}
