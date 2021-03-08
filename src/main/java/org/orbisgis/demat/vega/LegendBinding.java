package org.orbisgis.demat.vega;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;

/**
 * When set, a selection is populated by interacting with the corresponding legend. Direct
 * manipulation interaction is disabled by default; to re-enable it, set the selection's
 * [`on`](https://vega.github.io/vega-lite/docs/selection.html#common-selection-properties)
 * property.
 *
 * Legend bindings are restricted to selections that only specify a single field or encoding.
 */
@JsonDeserialize(using = LegendBinding.Deserializer.class)
@JsonSerialize(using = LegendBinding.Serializer.class)
public class LegendBinding {
    public LegendStreamBinding legendStreamBindingValue;
    public String stringValue;

    static class Deserializer extends JsonDeserializer<LegendBinding> {
        @Override
        public LegendBinding deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            LegendBinding value = new LegendBinding();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case VALUE_STRING:
                    String string = jsonParser.readValueAs(String.class);
                    value.stringValue = string;
                    break;
                case START_OBJECT:
                    value.legendStreamBindingValue = jsonParser.readValueAs(LegendStreamBinding.class);
                    break;
                default: throw new IOException("Cannot deserialize LegendBinding");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<LegendBinding> {
        @Override
        public void serialize(LegendBinding obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.legendStreamBindingValue != null) {
                jsonGenerator.writeObject(obj.legendStreamBindingValue);
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
