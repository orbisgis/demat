package org.orbisgis.demat.v4;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;
import com.fasterxml.jackson.core.type.*;
import java.util.List;
import java.util.Map;

/**
 * The full data set, included inline. This can be an array of objects or primitive values,
 * an object, or a string. Arrays of primitive values are ingested as objects with a `data`
 * property. Strings are parsed according to the specified format type.
 */
@JsonDeserialize(using = URLDataInlineDataset.Deserializer.class)
@JsonSerialize(using = URLDataInlineDataset.Serializer.class)
public class URLDataInlineDataset {
    public List<InlineDataset> unionArrayValue;
    public Map<String, Object> anythingMapValue;
    public String stringValue;

    static class Deserializer extends JsonDeserializer<URLDataInlineDataset> {
        @Override
        public URLDataInlineDataset deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            URLDataInlineDataset value = new URLDataInlineDataset();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case VALUE_STRING:
                    String string = jsonParser.readValueAs(String.class);
                    value.stringValue = string;
                    break;
                case START_ARRAY:
                    value.unionArrayValue = jsonParser.readValueAs(new TypeReference<List<InlineDataset>>() {});
                    break;
                case START_OBJECT:
                    value.anythingMapValue = jsonParser.readValueAs(Map.class);
                    break;
                default: throw new IOException("Cannot deserialize URLDataInlineDataset");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<URLDataInlineDataset> {
        @Override
        public void serialize(URLDataInlineDataset obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.unionArrayValue != null) {
                jsonGenerator.writeObject(obj.unionArrayValue);
                return;
            }
            if (obj.anythingMapValue != null) {
                jsonGenerator.writeObject(obj.anythingMapValue);
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
