package org.orbisgis.demat.vega;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;
import com.fasterxml.jackson.core.type.*;
import java.util.List;

/**
 * A constant value in visual domain (e.g., `"red"` / `"#0099ff"` / [gradient
 * definition](https://vega.github.io/vega-lite/docs/types.html#gradient) for color, values
 * between `0` to `1` for opacity).
 *
 * The title text.
 */
@JsonDeserialize(using = ConditionalValueDefTextExprRefText.Deserializer.class)
@JsonSerialize(using = ConditionalValueDefTextExprRefText.Serializer.class)
public class ConditionalValueDefTextExprRefText {
    public List<String> stringArrayValue;
    public BackgroundExprRef backgroundExprRefValue;
    public String stringValue;

    static class Deserializer extends JsonDeserializer<ConditionalValueDefTextExprRefText> {
        @Override
        public ConditionalValueDefTextExprRefText deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            ConditionalValueDefTextExprRefText value = new ConditionalValueDefTextExprRefText();
            switch (jsonParser.currentToken()) {
                case VALUE_STRING:
                    String string = jsonParser.readValueAs(String.class);
                    value.stringValue = string;
                    break;
                case START_ARRAY:
                    value.stringArrayValue = jsonParser.readValueAs(new TypeReference<List<String>>() {});
                    break;
                case START_OBJECT:
                    value.backgroundExprRefValue = jsonParser.readValueAs(BackgroundExprRef.class);
                    break;
                default: throw new IOException("Cannot deserialize ConditionalValueDefTextExprRefText");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<ConditionalValueDefTextExprRefText> {
        @Override
        public void serialize(ConditionalValueDefTextExprRefText obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.stringArrayValue != null) {
                jsonGenerator.writeObject(obj.stringArrayValue);
                return;
            }
            if (obj.backgroundExprRefValue != null) {
                jsonGenerator.writeObject(obj.backgroundExprRefValue);
                return;
            }
            if (obj.stringValue != null) {
                jsonGenerator.writeObject(obj.stringValue);
                return;
            }
            throw new IOException("ConditionalValueDefTextExprRefText must not be null");
        }
    }
}
