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
@JsonDeserialize(using = SelectionCompositionElement.Deserializer.class)
@JsonSerialize(using = SelectionCompositionElement.Serializer.class)
public class SelectionCompositionElement {
    public Selection selectionValue;
    public String stringValue;

    static class Deserializer extends JsonDeserializer<SelectionCompositionElement> {
        @Override
        public SelectionCompositionElement deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            SelectionCompositionElement value = new SelectionCompositionElement();
            switch (jsonParser.currentToken()) {
                case VALUE_STRING:
                    String string = jsonParser.readValueAs(String.class);
                    value.stringValue = string;
                    break;
                case START_OBJECT:
                    value.selectionValue = jsonParser.readValueAs(Selection.class);
                    break;
                default: throw new IOException("Cannot deserialize SelectionCompositionElement");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<SelectionCompositionElement> {
        @Override
        public void serialize(SelectionCompositionElement obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.selectionValue != null) {
                jsonGenerator.writeObject(obj.selectionValue);
                return;
            }
            if (obj.stringValue != null) {
                jsonGenerator.writeObject(obj.stringValue);
                return;
            }
            throw new IOException("SelectionCompositionElement must not be null");
        }
    }
}
