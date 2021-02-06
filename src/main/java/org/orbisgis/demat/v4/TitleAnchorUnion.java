package org.orbisgis.demat.v4;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(using = TitleAnchorUnion.Deserializer.class)
@JsonSerialize(using = TitleAnchorUnion.Serializer.class)
public class TitleAnchorUnion {
    public BackgroundExprRef backgroundExprRefValue;
    public TitleAnchorEnum enumValue;

    static class Deserializer extends JsonDeserializer<TitleAnchorUnion> {
        @Override
        public TitleAnchorUnion deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            TitleAnchorUnion value = new TitleAnchorUnion();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case VALUE_STRING:
                    String string = jsonParser.readValueAs(String.class);
                    try {
                        value.enumValue = TitleAnchorEnum.forValue(string);
                    } catch (Exception ex) {
                        // Ignored
                    }
                    break;
                case START_OBJECT:
                    value.backgroundExprRefValue = jsonParser.readValueAs(BackgroundExprRef.class);
                    break;
                default: throw new IOException("Cannot deserialize TitleAnchorUnion");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<TitleAnchorUnion> {
        @Override
        public void serialize(TitleAnchorUnion obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
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
