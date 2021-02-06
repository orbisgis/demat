package org.orbisgis.demat.v4;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;

/**
 * Aggregation function for the field (e.g., `"mean"`, `"sum"`, `"median"`, `"min"`,
 * `"max"`, `"count"`).
 *
 * __Default value:__ `undefined` (None)
 *
 * __See also:__ [`aggregate`](https://vega.github.io/vega-lite/docs/aggregate.html)
 * documentation.
 */
@JsonDeserialize(using = Aggregate.Deserializer.class)
@JsonSerialize(using = Aggregate.Serializer.class)
public class Aggregate {
    public ArgmDef argmDefValue;
    public NonArgAggregateOp enumValue;

    static class Deserializer extends JsonDeserializer<Aggregate> {
        @Override
        public Aggregate deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            Aggregate value = new Aggregate();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case VALUE_STRING:
                    String string = jsonParser.readValueAs(String.class);
                    try {
                        value.enumValue = NonArgAggregateOp.forValue(string);
                    } catch (Exception ex) {
                        // Ignored
                    }
                    break;
                case START_OBJECT:
                    value.argmDefValue = jsonParser.readValueAs(ArgmDef.class);
                    break;
                default: throw new IOException("Cannot deserialize Aggregate");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<Aggregate> {
        @Override
        public void serialize(Aggregate obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.argmDefValue != null) {
                jsonGenerator.writeObject(obj.argmDefValue);
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
