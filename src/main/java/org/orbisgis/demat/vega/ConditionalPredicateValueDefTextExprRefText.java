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
@JsonDeserialize(using = ConditionalPredicateValueDefTextExprRefText.Deserializer.class)
@JsonSerialize(using = ConditionalPredicateValueDefTextExprRefText.Serializer.class)
public class ConditionalPredicateValueDefTextExprRefText {
    public List<String> stringArrayValue;
    public BackgroundExprRef backgroundExprRefValue;
    public String stringValue;

    static class Deserializer extends JsonDeserializer<ConditionalPredicateValueDefTextExprRefText> {
        @Override
        public ConditionalPredicateValueDefTextExprRefText deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            ConditionalPredicateValueDefTextExprRefText value = new ConditionalPredicateValueDefTextExprRefText();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
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
                default: throw new IOException("Cannot deserialize ConditionalPredicateValueDefTextExprRefText");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<ConditionalPredicateValueDefTextExprRefText> {
        @Override
        public void serialize(ConditionalPredicateValueDefTextExprRefText obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
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
            jsonGenerator.writeNull();
        }
    }
}
