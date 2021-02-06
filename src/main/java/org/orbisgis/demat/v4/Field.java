package org.orbisgis.demat.v4;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;

/**
 * __Required.__ A string defining the name of the field from which to pull a data value or
 * an object defining iterated values from the
 * [`repeat`](https://vega.github.io/vega-lite/docs/repeat.html) operator.
 *
 * __See also:__ [`field`](https://vega.github.io/vega-lite/docs/field.html) documentation.
 *
 * __Notes:__ 1)  Dots (`.`) and brackets (`[` and `]`) can be used to access nested objects
 * (e.g., `"field": "foo.bar"` and `"field": "foo['bar']"`). If field names contain dots or
 * brackets but are not nested, you can use `\\` to escape dots and brackets (e.g.,
 * `"a\\.b"` and `"a\\[0\\]"`). See more details about escaping in the [field
 * documentation](https://vega.github.io/vega-lite/docs/field.html). 2) `field` is not
 * required if `aggregate` is `count`.
 *
 * The data [field](https://vega.github.io/vega-lite/docs/field.html) to sort by.
 *
 * __Default value:__ If unspecified, defaults to the field specified in the outer data
 * reference.
 */
@JsonDeserialize(using = Field.Deserializer.class)
@JsonSerialize(using = Field.Serializer.class)
public class Field {
    public RepeatRef repeatRefValue;
    public String stringValue;

    public Field() {
    }

    public Field(String stringValue) {
        this.stringValue=stringValue;
    }

    static class Deserializer extends JsonDeserializer<Field> {
        @Override
        public Field deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            Field value = new Field();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case VALUE_STRING:
                    String string = jsonParser.readValueAs(String.class);
                    value.stringValue = string;
                    break;
                case START_OBJECT:
                    value.repeatRefValue = jsonParser.readValueAs(RepeatRef.class);
                    break;
                default: throw new IOException("Cannot deserialize Field");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<Field> {
        @Override
        public void serialize(Field obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.repeatRefValue != null) {
                jsonGenerator.writeObject(obj.repeatRefValue);
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
