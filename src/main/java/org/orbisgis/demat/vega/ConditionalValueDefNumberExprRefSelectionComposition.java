package org.orbisgis.demat.vega;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;

/**
 * Filter using a selection name or a logical composition of selection names.
 *
 * A [selection name](https://vega.github.io/vega-lite/docs/selection.html), or a series of
 * [composed selections](https://vega.github.io/vega-lite/docs/selection.html#compose).
 */
@JsonDeserialize(using = ConditionalValueDefNumberExprRefSelectionComposition.Deserializer.class)
@JsonSerialize(using = ConditionalValueDefNumberExprRefSelectionComposition.Serializer.class)
public class ConditionalValueDefNumberExprRefSelectionComposition {
    public Selection selectionValue;
    public String stringValue;

    static class Deserializer extends JsonDeserializer<ConditionalValueDefNumberExprRefSelectionComposition> {
        @Override
        public ConditionalValueDefNumberExprRefSelectionComposition deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            ConditionalValueDefNumberExprRefSelectionComposition value = new ConditionalValueDefNumberExprRefSelectionComposition();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case VALUE_STRING:
                    String string = jsonParser.readValueAs(String.class);
                    value.stringValue = string;
                    break;
                case START_OBJECT:
                    value.selectionValue = jsonParser.readValueAs(Selection.class);
                    break;
                default: throw new IOException("Cannot deserialize ConditionalValueDefNumberExprRefSelectionComposition");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<ConditionalValueDefNumberExprRefSelectionComposition> {
        @Override
        public void serialize(ConditionalValueDefNumberExprRefSelectionComposition obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.selectionValue != null) {
                jsonGenerator.writeObject(obj.selectionValue);
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
