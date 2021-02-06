package org.orbisgis.demat.v4;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(using = TitleOrientUnion.Deserializer.class)
@JsonSerialize(using = TitleOrientUnion.Serializer.class)
public class TitleOrientUnion {
    public BackgroundExprRef backgroundExprRefValue;
    public Orient enumValue;

    static class Deserializer extends JsonDeserializer<TitleOrientUnion> {
        @Override
        public TitleOrientUnion deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            TitleOrientUnion value = new TitleOrientUnion();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case VALUE_STRING:
                    String string = jsonParser.readValueAs(String.class);
                    try {
                        value.enumValue = Orient.forValue(string);
                    } catch (Exception ex) {
                        // Ignored
                    }
                    break;
                case START_OBJECT:
                    value.backgroundExprRefValue = jsonParser.readValueAs(BackgroundExprRef.class);
                    break;
                default: throw new IOException("Cannot deserialize TitleOrientUnion");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<TitleOrientUnion> {
        @Override
        public void serialize(TitleOrientUnion obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
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
