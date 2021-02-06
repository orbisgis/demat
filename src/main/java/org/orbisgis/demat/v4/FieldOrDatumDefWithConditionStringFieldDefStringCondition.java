package org.orbisgis.demat.v4;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;
import com.fasterxml.jackson.core.type.*;
import java.util.List;

@JsonDeserialize(using = FieldOrDatumDefWithConditionStringFieldDefStringCondition.Deserializer.class)
@JsonSerialize(using = FieldOrDatumDefWithConditionStringFieldDefStringCondition.Serializer.class)
public class FieldOrDatumDefWithConditionStringFieldDefStringCondition {
    public FluffyConditionalExprRef fluffyConditionalExprRefValue;
    public List<FluffyConditionalValueDefStringExprRef> fluffyConditionalValueDefStringExprRefArrayValue;

    static class Deserializer extends JsonDeserializer<FieldOrDatumDefWithConditionStringFieldDefStringCondition> {
        @Override
        public FieldOrDatumDefWithConditionStringFieldDefStringCondition deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            FieldOrDatumDefWithConditionStringFieldDefStringCondition value = new FieldOrDatumDefWithConditionStringFieldDefStringCondition();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case START_ARRAY:
                    value.fluffyConditionalValueDefStringExprRefArrayValue = jsonParser.readValueAs(new TypeReference<List<FluffyConditionalValueDefStringExprRef>>() {});
                    break;
                case START_OBJECT:
                    value.fluffyConditionalExprRefValue = jsonParser.readValueAs(FluffyConditionalExprRef.class);
                    break;
                default: throw new IOException("Cannot deserialize FieldOrDatumDefWithConditionStringFieldDefStringCondition");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<FieldOrDatumDefWithConditionStringFieldDefStringCondition> {
        @Override
        public void serialize(FieldOrDatumDefWithConditionStringFieldDefStringCondition obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.fluffyConditionalExprRefValue != null) {
                jsonGenerator.writeObject(obj.fluffyConditionalExprRefValue);
                return;
            }
            if (obj.fluffyConditionalValueDefStringExprRefArrayValue != null) {
                jsonGenerator.writeObject(obj.fluffyConditionalValueDefStringExprRefArrayValue);
                return;
            }
            jsonGenerator.writeNull();
        }
    }
}
