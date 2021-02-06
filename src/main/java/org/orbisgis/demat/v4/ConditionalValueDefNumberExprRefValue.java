package org.orbisgis.demat.v4;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(using = ConditionalValueDefNumberExprRefValue.Deserializer.class)
@JsonSerialize(using = ConditionalValueDefNumberExprRefValue.Serializer.class)
public class ConditionalValueDefNumberExprRefValue {
    public Double doubleValue;
    public BackgroundExprRef backgroundExprRefValue;

    static class Deserializer extends JsonDeserializer<ConditionalValueDefNumberExprRefValue> {
        @Override
        public ConditionalValueDefNumberExprRefValue deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            ConditionalValueDefNumberExprRefValue value = new ConditionalValueDefNumberExprRefValue();
            switch (jsonParser.currentToken()) {
                case VALUE_NUMBER_INT:
                case VALUE_NUMBER_FLOAT:
                    value.doubleValue = jsonParser.readValueAs(Double.class);
                    break;
                case START_OBJECT:
                    value.backgroundExprRefValue = jsonParser.readValueAs(BackgroundExprRef.class);
                    break;
                default: throw new IOException("Cannot deserialize ConditionalValueDefNumberExprRefValue");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<ConditionalValueDefNumberExprRefValue> {
        @Override
        public void serialize(ConditionalValueDefNumberExprRefValue obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.doubleValue != null) {
                jsonGenerator.writeObject(obj.doubleValue);
                return;
            }
            if (obj.backgroundExprRefValue != null) {
                jsonGenerator.writeObject(obj.backgroundExprRefValue);
                return;
            }
            throw new IOException("ConditionalValueDefNumberExprRefValue must not be null");
        }
    }
}
