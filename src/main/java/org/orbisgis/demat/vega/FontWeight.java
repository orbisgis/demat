package org.orbisgis.demat.vega;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(using = FontWeight.Deserializer.class)
@JsonSerialize(using = FontWeight.Serializer.class)
public class FontWeight {
    public Double doubleValue;
    public IndecentExprRef indecentExprRefValue;
    public FontWeightEnum enumValue;

    static class Deserializer extends JsonDeserializer<FontWeight> {
        @Override
        public FontWeight deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            FontWeight value = new FontWeight();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case VALUE_NUMBER_INT:
                case VALUE_NUMBER_FLOAT:
                    value.doubleValue = jsonParser.readValueAs(Double.class);
                    break;
                case VALUE_STRING:
                    String string = jsonParser.readValueAs(String.class);
                    try {
                        value.enumValue = FontWeightEnum.forValue(string);
                    } catch (Exception ex) {
                        // Ignored
                    }
                    break;
                case START_OBJECT:
                    value.indecentExprRefValue = jsonParser.readValueAs(IndecentExprRef.class);
                    break;
                default: throw new IOException("Cannot deserialize FontWeight");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<FontWeight> {
        @Override
        public void serialize(FontWeight obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.doubleValue != null) {
                jsonGenerator.writeObject(obj.doubleValue);
                return;
            }
            if (obj.indecentExprRefValue != null) {
                jsonGenerator.writeObject(obj.indecentExprRefValue);
                return;
            }
            if (obj.enumValue != null) {
                jsonGenerator.writeObject(obj.enumValue);
                return;
            }
            jsonGenerator.writeNull();
        }
    }
}
