package org.orbisgis.demat.v4;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;

import java.util.Map;

/**
 * When set, a selection is populated by input elements (also known as dynamic query
 * widgets) or by interacting with the corresponding legend. Direct manipulation interaction
 * is disabled by default; to re-enable it, set the selection's
 * [`on`](https://vega.github.io/vega-lite/docs/selection.html#common-selection-properties)
 * property.
 *
 * Legend bindings are restricted to selections that only specify a single field or
 * encoding.
 *
 * Query widget binding takes the form of Vega's [input element binding
 * definition](https://vega.github.io/vega/docs/signals/#bind) or can be a mapping between
 * projected field/encodings and binding definitions.
 *
 * __See also:__ [`bind`](https://vega.github.io/vega-lite/docs/bind.html) documentation.
 */
@JsonDeserialize(using = SingleBind.Deserializer.class)
@JsonSerialize(using = SingleBind.Serializer.class)
public class SingleBind {
    public Map<String, FluffyStream> unionMapValue;
    public String stringValue;

    static class Deserializer extends JsonDeserializer<SingleBind> {
        @Override
        public SingleBind deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            SingleBind value = new SingleBind();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case VALUE_STRING:
                    String string = jsonParser.readValueAs(String.class);
                    value.stringValue = string;
                    break;
                case START_OBJECT:
                    value.unionMapValue = jsonParser.readValueAs(Map.class);
                    break;
                default: throw new IOException("Cannot deserialize SingleBind");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<SingleBind> {
        @Override
        public void serialize(SingleBind obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.unionMapValue != null) {
                jsonGenerator.writeObject(obj.unionMapValue);
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
