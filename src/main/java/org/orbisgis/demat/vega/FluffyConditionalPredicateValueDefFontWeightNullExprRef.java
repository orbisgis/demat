package org.orbisgis.demat.vega;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;
import com.fasterxml.jackson.core.type.*;
import java.util.List;

@JsonDeserialize(using = FluffyConditionalPredicateValueDefFontWeightNullExprRef.Deserializer.class)
@JsonSerialize(using = FluffyConditionalPredicateValueDefFontWeightNullExprRef.Serializer.class)
public class FluffyConditionalPredicateValueDefFontWeightNullExprRef {
    public PurpleConditionalPredicateValueDefFontWeightNullExprRef purpleConditionalPredicateValueDefFontWeightNullExprRefValue;
    public List<ConditionalPredicateValueDefFontWeightNullExprRef> conditionalPredicateValueDefFontWeightNullExprRefArrayValue;

    static class Deserializer extends JsonDeserializer<FluffyConditionalPredicateValueDefFontWeightNullExprRef> {
        @Override
        public FluffyConditionalPredicateValueDefFontWeightNullExprRef deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            FluffyConditionalPredicateValueDefFontWeightNullExprRef value = new FluffyConditionalPredicateValueDefFontWeightNullExprRef();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case START_ARRAY:
                    value.conditionalPredicateValueDefFontWeightNullExprRefArrayValue = jsonParser.readValueAs(new TypeReference<List<ConditionalPredicateValueDefFontWeightNullExprRef>>() {});
                    break;
                case START_OBJECT:
                    value.purpleConditionalPredicateValueDefFontWeightNullExprRefValue = jsonParser.readValueAs(PurpleConditionalPredicateValueDefFontWeightNullExprRef.class);
                    break;
                default: throw new IOException("Cannot deserialize FluffyConditionalPredicateValueDefFontWeightNullExprRef");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<FluffyConditionalPredicateValueDefFontWeightNullExprRef> {
        @Override
        public void serialize(FluffyConditionalPredicateValueDefFontWeightNullExprRef obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.purpleConditionalPredicateValueDefFontWeightNullExprRefValue != null) {
                jsonGenerator.writeObject(obj.purpleConditionalPredicateValueDefFontWeightNullExprRefValue);
                return;
            }
            if (obj.conditionalPredicateValueDefFontWeightNullExprRefArrayValue != null) {
                jsonGenerator.writeObject(obj.conditionalPredicateValueDefFontWeightNullExprRefArrayValue);
                return;
            }
            jsonGenerator.writeNull();
        }
    }
}
