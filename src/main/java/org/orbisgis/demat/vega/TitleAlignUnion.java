package org.orbisgis.demat.vega;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(using = TitleAlignUnion.Deserializer.class)
@JsonSerialize(using = TitleAlignUnion.Serializer.class)
public class TitleAlignUnion {
    public BackgroundExprRef backgroundExprRefValue;
    public Align enumValue;

    static class Deserializer extends JsonDeserializer<TitleAlignUnion> {
        @Override
        public TitleAlignUnion deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            TitleAlignUnion value = new TitleAlignUnion();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case VALUE_STRING:
                    String string = jsonParser.readValueAs(String.class);
                    try {
                        value.enumValue = Align.forValue(string);
                    } catch (Exception ex) {
                        // Ignored
                    }
                    break;
                case START_OBJECT:
                    value.backgroundExprRefValue = jsonParser.readValueAs(BackgroundExprRef.class);
                    break;
                default: throw new IOException("Cannot deserialize TitleAlignUnion");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<TitleAlignUnion> {
        @Override
        public void serialize(TitleAlignUnion obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
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
