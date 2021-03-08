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
 */
@JsonDeserialize(using = StrokeDashUnion.Deserializer.class)
@JsonSerialize(using = StrokeDashUnion.Serializer.class)
public class StrokeDashUnion {
    public List<Double> doubleArrayValue;
    public BackgroundExprRef backgroundExprRefValue;

    static class Deserializer extends JsonDeserializer<StrokeDashUnion> {
        @Override
        public StrokeDashUnion deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            StrokeDashUnion value = new StrokeDashUnion();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case START_ARRAY:
                    value.doubleArrayValue = jsonParser.readValueAs(new TypeReference<List<Double>>() {});
                    break;
                case START_OBJECT:
                    value.backgroundExprRefValue = jsonParser.readValueAs(BackgroundExprRef.class);
                    break;
                default: throw new IOException("Cannot deserialize StrokeDashUnion");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<StrokeDashUnion> {
        @Override
        public void serialize(StrokeDashUnion obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.doubleArrayValue != null) {
                jsonGenerator.writeObject(obj.doubleArrayValue);
                return;
            }
            if (obj.backgroundExprRefValue != null) {
                jsonGenerator.writeObject(obj.backgroundExprRefValue);
                return;
            }
            jsonGenerator.writeNull();
        }
    }
}
