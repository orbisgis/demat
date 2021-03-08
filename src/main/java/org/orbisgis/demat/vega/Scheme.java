package org.orbisgis.demat.vega;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;

/**
 * A string indicating a color
 * [scheme](https://vega.github.io/vega-lite/docs/scale.html#scheme) name (e.g.,
 * `"category10"` or `"blues"`) or a [scheme parameter
 * object](https://vega.github.io/vega-lite/docs/scale.html#scheme-params).
 *
 * Discrete color schemes may be used with
 * [discrete](https://vega.github.io/vega-lite/docs/scale.html#discrete) or
 * [discretizing](https://vega.github.io/vega-lite/docs/scale.html#discretizing) scales.
 * Continuous color schemes are intended for use with color scales.
 *
 * For the full list of supported schemes, please refer to the [Vega
 * Scheme](https://vega.github.io/vega/docs/schemes/#reference) reference.
 */
@JsonDeserialize(using = Scheme.Deserializer.class)
@JsonSerialize(using = Scheme.Serializer.class)
public class Scheme {
    public SchemeParams schemeParamsValue;
    public String stringValue;

    static class Deserializer extends JsonDeserializer<Scheme> {
        @Override
        public Scheme deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            Scheme value = new Scheme();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case VALUE_STRING:
                    String string = jsonParser.readValueAs(String.class);
                    value.stringValue = string;
                    break;
                case START_OBJECT:
                    value.schemeParamsValue = jsonParser.readValueAs(SchemeParams.class);
                    break;
                default: throw new IOException("Cannot deserialize Scheme");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<Scheme> {
        @Override
        public void serialize(Scheme obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.schemeParamsValue != null) {
                jsonGenerator.writeObject(obj.schemeParamsValue);
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
