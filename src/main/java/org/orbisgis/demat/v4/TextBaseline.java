package org.orbisgis.demat.v4;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(using = TextBaseline.Deserializer.class)
@JsonSerialize(using = TextBaseline.Serializer.class)
public class TextBaseline {
    public TentacledExprRef tentacledExprRefValue;
    public String stringValue;

    static class Deserializer extends JsonDeserializer<TextBaseline> {
        @Override
        public TextBaseline deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            TextBaseline value = new TextBaseline();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case VALUE_STRING:
                    String string = jsonParser.readValueAs(String.class);
                    value.stringValue = string;
                    break;
                case START_OBJECT:
                    value.tentacledExprRefValue = jsonParser.readValueAs(TentacledExprRef.class);
                    break;
                default: throw new IOException("Cannot deserialize TextBaseline");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<TextBaseline> {
        @Override
        public void serialize(TextBaseline obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.tentacledExprRefValue != null) {
                jsonGenerator.writeObject(obj.tentacledExprRefValue);
                return;
            }
            if (obj.stringValue != null) {
                jsonGenerator.writeObject(obj.stringValue);
                return;
            }
            jsonGenerator.writeNull();
        }
    }
}
