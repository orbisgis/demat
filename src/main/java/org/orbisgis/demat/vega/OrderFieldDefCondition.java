package org.orbisgis.demat.vega;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;
import com.fasterxml.jackson.core.type.*;
import java.util.List;

/**
 * One or more value definition(s) with [a selection or a test
 * predicate](https://vega.github.io/vega-lite/docs/condition.html).
 *
 * __Note:__ A field definition's `condition` property can only contain [conditional value
 * definitions](https://vega.github.io/vega-lite/docs/condition.html#value) since Vega-Lite
 * only allows at most one encoded field per encoding channel.
 */
@JsonDeserialize(using = OrderFieldDefCondition.Deserializer.class)
@JsonSerialize(using = OrderFieldDefCondition.Serializer.class)
public class OrderFieldDefCondition {
    public ConditionalPredicateValueDefNumberClass conditionalPredicateValueDefNumberClassValue;
    public List<ConditionalValueDefNumber> conditionalValueDefNumberArrayValue;

    static class Deserializer extends JsonDeserializer<OrderFieldDefCondition> {
        @Override
        public OrderFieldDefCondition deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            OrderFieldDefCondition value = new OrderFieldDefCondition();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case START_ARRAY:
                    value.conditionalValueDefNumberArrayValue = jsonParser.readValueAs(new TypeReference<List<ConditionalValueDefNumber>>() {});
                    break;
                case START_OBJECT:
                    value.conditionalPredicateValueDefNumberClassValue = jsonParser.readValueAs(ConditionalPredicateValueDefNumberClass.class);
                    break;
                default: throw new IOException("Cannot deserialize OrderFieldDefCondition");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<OrderFieldDefCondition> {
        @Override
        public void serialize(OrderFieldDefCondition obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.conditionalPredicateValueDefNumberClassValue != null) {
                jsonGenerator.writeObject(obj.conditionalPredicateValueDefNumberClassValue);
                return;
            }
            if (obj.conditionalValueDefNumberArrayValue != null) {
                jsonGenerator.writeObject(obj.conditionalValueDefNumberArrayValue);
                return;
            }
            jsonGenerator.writeNull();
        }
    }
}
