package org.orbisgis.demat.v4;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;

/**
 * Predicate for triggering the condition
 *
 * The `filter` property must be a predication definition, which can take one of the
 * following forms:
 *
 * 1) an [expression](https://vega.github.io/vega-lite/docs/types.html#expression) string,
 * where `datum` can be used to refer to the current data object. For example, `{filter:
 * "datum.b2 > 60"}` would make the output data includes only items that have values in the
 * field `b2` over 60.
 *
 * 2) one of the [field
 * predicates](https://vega.github.io/vega-lite/docs/predicate.html#field-predicate):
 * [`equal`](https://vega.github.io/vega-lite/docs/predicate.html#field-equal-predicate),
 * [`lt`](https://vega.github.io/vega-lite/docs/predicate.html#lt-predicate),
 * [`lte`](https://vega.github.io/vega-lite/docs/predicate.html#lte-predicate),
 * [`gt`](https://vega.github.io/vega-lite/docs/predicate.html#gt-predicate),
 * [`gte`](https://vega.github.io/vega-lite/docs/predicate.html#gte-predicate),
 * [`range`](https://vega.github.io/vega-lite/docs/predicate.html#range-predicate),
 * [`oneOf`](https://vega.github.io/vega-lite/docs/predicate.html#one-of-predicate), or
 * [`valid`](https://vega.github.io/vega-lite/docs/predicate.html#valid-predicate),
 *
 * 3) a [selection
 * predicate](https://vega.github.io/vega-lite/docs/predicate.html#selection-predicate),
 * which define the names of a selection that the data point should belong to (or a logical
 * composition of selections).
 *
 * 4) a [logical
 * composition](https://vega.github.io/vega-lite/docs/predicate.html#composition) of (1),
 * (2), or (3).
 */
@JsonDeserialize(using = PredicateCompositionElement.Deserializer.class)
@JsonSerialize(using = PredicateCompositionElement.Serializer.class)
public class PredicateCompositionElement {
    public Predicate predicateValue;
    public String stringValue;

    static class Deserializer extends JsonDeserializer<PredicateCompositionElement> {
        @Override
        public PredicateCompositionElement deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            PredicateCompositionElement value = new PredicateCompositionElement();
            switch (jsonParser.currentToken()) {
                case VALUE_STRING:
                    String string = jsonParser.readValueAs(String.class);
                    value.stringValue = string;
                    break;
                case START_OBJECT:
                    value.predicateValue = jsonParser.readValueAs(Predicate.class);
                    break;
                default: throw new IOException("Cannot deserialize PredicateCompositionElement");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<PredicateCompositionElement> {
        @Override
        public void serialize(PredicateCompositionElement obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.predicateValue != null) {
                jsonGenerator.writeObject(obj.predicateValue);
                return;
            }
            if (obj.stringValue != null) {
                jsonGenerator.writeObject(obj.stringValue);
                return;
            }
            throw new IOException("PredicateCompositionElement must not be null");
        }
    }
}
