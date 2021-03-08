package org.orbisgis.demat.vega;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;

/**
 * A string describing the mark type (one of `"bar"`, `"circle"`, `"square"`, `"tick"`,
 * `"line"`, `"area"`, `"point"`, `"rule"`, `"geoshape"`, and `"text"`) or a [mark
 * definition object](https://vega.github.io/vega-lite/docs/mark.html#mark-def).
 */
@JsonDeserialize(using = Mark.Deserializer.class)
@JsonSerialize(using = Mark.Serializer.class)
public class Mark {
    public Def defValue;
    public String stringValue;

    static class Deserializer extends JsonDeserializer<Mark> {
        @Override
        public Mark deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            Mark value = new Mark();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case VALUE_STRING:
                    String string = jsonParser.readValueAs(String.class);
                    value.stringValue = string;
                    break;
                case START_OBJECT:
                    value.defValue = jsonParser.readValueAs(Def.class);
                    break;
                default: throw new IOException("Cannot deserialize AnyMark");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<Mark> {
        @Override
        public void serialize(Mark obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.defValue != null) {
                jsonGenerator.writeObject(obj.defValue);
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
