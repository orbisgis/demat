package org.orbisgis.demat.v4;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;

/**
 * How the visualization size should be determined. If a string, should be one of `"pad"`,
 * `"fit"` or `"none"`. Object values can additionally specify parameters for content sizing
 * and automatic resizing.
 *
 * __Default value__: `pad`
 */
@JsonDeserialize(using = Autosize.Deserializer.class)
@JsonSerialize(using = Autosize.Serializer.class)
public class Autosize {
    public AutoSizeParams autoSizeParamsValue;
    public AutosizeType enumValue;

    static class Deserializer extends JsonDeserializer<Autosize> {
        @Override
        public Autosize deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            Autosize value = new Autosize();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case VALUE_STRING:
                    String string = jsonParser.readValueAs(String.class);
                    try {
                        value.enumValue = AutosizeType.forValue(string);
                    } catch (Exception ex) {
                        // Ignored
                    }
                    break;
                case START_OBJECT:
                    value.autoSizeParamsValue = jsonParser.readValueAs(AutoSizeParams.class);
                    break;
                default: throw new IOException("Cannot deserialize Autosize");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<Autosize> {
        @Override
        public void serialize(Autosize obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.autoSizeParamsValue != null) {
                jsonGenerator.writeObject(obj.autoSizeParamsValue);
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
