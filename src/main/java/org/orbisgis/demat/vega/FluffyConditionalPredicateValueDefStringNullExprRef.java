package org.orbisgis.demat.vega;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;
import com.fasterxml.jackson.core.type.*;
import java.util.List;

@JsonDeserialize(using = FluffyConditionalPredicateValueDefStringNullExprRef.Deserializer.class)
@JsonSerialize(using = FluffyConditionalPredicateValueDefStringNullExprRef.Serializer.class)
public class FluffyConditionalPredicateValueDefStringNullExprRef {
    public PurpleConditionalPredicateValueDefStringNullExprRef purpleConditionalPredicateValueDefStringNullExprRefValue;
    public List<ConditionalPredicateValueDefStringNullExprRef> conditionalPredicateValueDefStringNullExprRefArrayValue;

    static class Deserializer extends JsonDeserializer<FluffyConditionalPredicateValueDefStringNullExprRef> {
        @Override
        public FluffyConditionalPredicateValueDefStringNullExprRef deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            FluffyConditionalPredicateValueDefStringNullExprRef value = new FluffyConditionalPredicateValueDefStringNullExprRef();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case START_ARRAY:
                    value.conditionalPredicateValueDefStringNullExprRefArrayValue = jsonParser.readValueAs(new TypeReference<List<ConditionalPredicateValueDefStringNullExprRef>>() {});
                    break;
                case START_OBJECT:
                    value.purpleConditionalPredicateValueDefStringNullExprRefValue = jsonParser.readValueAs(PurpleConditionalPredicateValueDefStringNullExprRef.class);
                    break;
                default: throw new IOException("Cannot deserialize FluffyConditionalPredicateValueDefStringNullExprRef");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<FluffyConditionalPredicateValueDefStringNullExprRef> {
        @Override
        public void serialize(FluffyConditionalPredicateValueDefStringNullExprRef obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.purpleConditionalPredicateValueDefStringNullExprRefValue != null) {
                jsonGenerator.writeObject(obj.purpleConditionalPredicateValueDefStringNullExprRefValue);
                return;
            }
            if (obj.conditionalPredicateValueDefStringNullExprRefArrayValue != null) {
                jsonGenerator.writeObject(obj.conditionalPredicateValueDefStringNullExprRefArrayValue);
                return;
            }
            jsonGenerator.writeNull();
        }
    }
}
