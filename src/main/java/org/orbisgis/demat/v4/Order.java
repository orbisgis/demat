package org.orbisgis.demat.v4;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;
import com.fasterxml.jackson.core.type.*;
import java.util.List;

@JsonDeserialize(using = Order.Deserializer.class)
@JsonSerialize(using = Order.Serializer.class)
public class Order {
    public OrderDef orderDefValue;
    public List<OrderFieldDef> orderFieldDefArrayValue;

    static class Deserializer extends JsonDeserializer<Order> {
        @Override
        public Order deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            Order value = new Order();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case START_ARRAY:
                    value.orderFieldDefArrayValue = jsonParser.readValueAs(new TypeReference<List<OrderFieldDef>>() {});
                    break;
                case START_OBJECT:
                    value.orderDefValue = jsonParser.readValueAs(OrderDef.class);
                    break;
                default: throw new IOException("Cannot deserialize Order");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<Order> {
        @Override
        public void serialize(Order obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.orderDefValue != null) {
                jsonGenerator.writeObject(obj.orderDefValue);
                return;
            }
            if (obj.orderFieldDefArrayValue != null) {
                jsonGenerator.writeObject(obj.orderFieldDefArrayValue);
                return;
            }
            jsonGenerator.writeNull();
        }
    }
}
