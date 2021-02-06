package org.orbisgis.demat.v4;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;

/**
 * CSS color property to use as the background of the entire view.
 *
 * __Default value:__ `"white"`
 *
 * The color of the header label, can be in hex color code or regular color name.
 *
 * Color of the header title, can be in hex color code or regular color name.
 *
 * For text marks, the vertical text baseline. One of `"alphabetic"` (default), `"top"`,
 * `"middle"`, `"bottom"`, `"line-top"`, `"line-bottom"`, or an expression reference that
 * provides one of the valid values. The `"line-top"` and `"line-bottom"` values operate
 * similarly to `"top"` and `"bottom"`, but are calculated relative to the `lineHeight`
 * rather than `fontSize` alone.
 *
 * For range marks, the vertical alignment of the marks. One of `"top"`, `"middle"`,
 * `"bottom"`.
 *
 * __Note:__ Expression reference is *not* supported for range marks.
 *
 * The vertical text baseline for the header labels. One of `"alphabetic"` (default),
 * `"top"`, `"middle"`, `"bottom"`, `"line-top"`, or `"line-bottom"`. The `"line-top"` and
 * `"line-bottom"` values operate similarly to `"top"` and `"bottom"`, but are calculated
 * relative to the `titleLineHeight` rather than `titleFontSize` alone.
 *
 * The vertical text baseline for the header title. One of `"alphabetic"` (default),
 * `"top"`, `"middle"`, `"bottom"`, `"line-top"`, or `"line-bottom"`. The `"line-top"` and
 * `"line-bottom"` values operate similarly to `"top"` and `"bottom"`, but are calculated
 * relative to the `titleLineHeight` rather than `titleFontSize` alone.
 *
 * __Default value:__ `"middle"`
 */
@JsonDeserialize(using = BackgroundUnion.Deserializer.class)
@JsonSerialize(using = BackgroundUnion.Serializer.class)
public class BackgroundUnion {
    public BackgroundExprRef backgroundExprRefValue;
    public String stringValue;

    static class Deserializer extends JsonDeserializer<BackgroundUnion> {
        @Override
        public BackgroundUnion deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            BackgroundUnion value = new BackgroundUnion();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case VALUE_STRING:
                    String string = jsonParser.readValueAs(String.class);
                    value.stringValue = string;
                    break;
                case START_OBJECT:
                    value.backgroundExprRefValue = jsonParser.readValueAs(BackgroundExprRef.class);
                    break;
                default: throw new IOException("Cannot deserialize BackgroundUnion");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<BackgroundUnion> {
        @Override
        public void serialize(BackgroundUnion obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.backgroundExprRefValue != null) {
                jsonGenerator.writeObject(obj.backgroundExprRefValue);
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
