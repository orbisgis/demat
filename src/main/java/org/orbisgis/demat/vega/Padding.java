package org.orbisgis.demat.vega;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;

/**
 * The default visualization padding, in pixels, from the edge of the visualization canvas
 * to the data rectangle. If a number, specifies padding for all sides. If an object, the
 * value should have the format `{"left": 5, "top": 5, "right": 5, "bottom": 5}` to specify
 * padding for each side of the visualization.
 *
 * __Default value__: `5`
 */
@JsonDeserialize(using = Padding.Deserializer.class)
@JsonSerialize(using = Padding.Serializer.class)
public class Padding {
    public Double doubleValue;
    public MagentaExprRef magentaExprRefValue;

    static class Deserializer extends JsonDeserializer<Padding> {
        @Override
        public Padding deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            Padding value = new Padding();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case VALUE_NUMBER_INT:
                case VALUE_NUMBER_FLOAT:
                    value.doubleValue = jsonParser.readValueAs(Double.class);
                    break;
                case START_OBJECT:
                    value.magentaExprRefValue = jsonParser.readValueAs(MagentaExprRef.class);
                    break;
                default: throw new IOException("Cannot deserialize Padding");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<Padding> {
        @Override
        public void serialize(Padding obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.doubleValue != null) {
                jsonGenerator.writeObject(obj.doubleValue);
                return;
            }
            if (obj.magentaExprRefValue != null) {
                jsonGenerator.writeObject(obj.magentaExprRefValue);
                return;
            }
            jsonGenerator.writeNull();
        }
    }
}
