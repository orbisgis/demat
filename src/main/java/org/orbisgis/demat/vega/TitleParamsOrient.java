package org.orbisgis.demat.vega;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(using = TitleParamsOrient.Deserializer.class)
@JsonSerialize(using = TitleParamsOrient.Serializer.class)
public class TitleParamsOrient {
    public BackgroundExprRef backgroundExprRefValue;
    public TitleOrient enumValue;

    static class Deserializer extends JsonDeserializer<TitleParamsOrient> {
        @Override
        public TitleParamsOrient deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            TitleParamsOrient value = new TitleParamsOrient();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case VALUE_STRING:
                    String string = jsonParser.readValueAs(String.class);
                    try {
                        value.enumValue = TitleOrient.forValue(string);
                    } catch (Exception ex) {
                        // Ignored
                    }
                    break;
                case START_OBJECT:
                    value.backgroundExprRefValue = jsonParser.readValueAs(BackgroundExprRef.class);
                    break;
                default: throw new IOException("Cannot deserialize TitleParamsOrient");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<TitleParamsOrient> {
        @Override
        public void serialize(TitleParamsOrient obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.backgroundExprRefValue != null) {
                jsonGenerator.writeObject(obj.backgroundExprRefValue);
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
