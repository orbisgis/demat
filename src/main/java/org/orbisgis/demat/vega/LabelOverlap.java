package org.orbisgis.demat.vega;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;

/**
 * The strategy to use for resolving overlap of axis labels. If `false` (the default), no
 * overlap reduction is attempted. If set to `true` or `"parity"`, a strategy of removing
 * every other label is used (this works well for standard linear axes). If set to
 * `"greedy"`, a linear scan of the labels is performed, removing any labels that overlaps
 * with the last visible label (this often works better for log-scaled axes).
 *
 * __Default value:__ `true` for non-nominal fields with non-log scales; `"greedy"` for log
 * scales; otherwise `false`.
 *
 * The strategy to use for resolving overlap of labels in gradient legends. If `false`, no
 * overlap reduction is attempted. If set to `true` or `"parity"`, a strategy of removing
 * every other label is used. If set to `"greedy"`, a linear scan of the labels is
 * performed, removing any label that overlaps with the last visible label (this often works
 * better for log-scaled axes).
 *
 * __Default value:__ `"greedy"` for `log scales otherwise `true`.
 */
@JsonDeserialize(using = LabelOverlap.Deserializer.class)
@JsonSerialize(using = LabelOverlap.Serializer.class)
public class LabelOverlap {
    public Boolean boolValue;
    public BackgroundExprRef backgroundExprRefValue;
    public String stringValue;

    static class Deserializer extends JsonDeserializer<LabelOverlap> {
        @Override
        public LabelOverlap deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            LabelOverlap value = new LabelOverlap();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case VALUE_TRUE:
                case VALUE_FALSE:
                    value.boolValue = jsonParser.readValueAs(Boolean.class);
                    break;
                case VALUE_STRING:
                    String string = jsonParser.readValueAs(String.class);
                    value.stringValue = string;
                    break;
                case START_OBJECT:
                    value.backgroundExprRefValue = jsonParser.readValueAs(BackgroundExprRef.class);
                    break;
                default: throw new IOException("Cannot deserialize LabelOverlap");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<LabelOverlap> {
        @Override
        public void serialize(LabelOverlap obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.boolValue != null) {
                jsonGenerator.writeObject(obj.boolValue);
                return;
            }
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
