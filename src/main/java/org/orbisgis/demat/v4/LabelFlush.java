package org.orbisgis.demat.v4;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;

/**
 * Indicates if labels should be hidden if they exceed the axis range. If `false` (the
 * default) no bounds overlap analysis is performed. If `true`, labels will be hidden if
 * they exceed the axis range by more than 1 pixel. If this property is a number, it
 * specifies the pixel tolerance: the maximum amount by which a label bounding box may
 * exceed the axis range.
 *
 * __Default value:__ `false`.
 *
 * Indicates if the first and last axis labels should be aligned flush with the scale range.
 * Flush alignment for a horizontal axis will left-align the first label and right-align the
 * last label. For vertical axes, bottom and top text baselines are applied instead. If this
 * property is a number, it also indicates the number of pixels by which to offset the first
 * and last labels; for example, a value of 2 will flush-align the first and last labels and
 * also push them 2 pixels outward from the center of the axis. The additional adjustment
 * can sometimes help the labels better visually group with corresponding axis ticks.
 *
 * __Default value:__ `true` for axis of a continuous x-scale. Otherwise, `false`.
 */
@JsonDeserialize(using = LabelFlush.Deserializer.class)
@JsonSerialize(using = LabelFlush.Serializer.class)
public class LabelFlush {
    public Double doubleValue;
    public Boolean boolValue;

    static class Deserializer extends JsonDeserializer<LabelFlush> {
        @Override
        public LabelFlush deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            LabelFlush value = new LabelFlush();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case VALUE_NUMBER_INT:
                case VALUE_NUMBER_FLOAT:
                    value.doubleValue = jsonParser.readValueAs(Double.class);
                    break;
                case VALUE_TRUE:
                case VALUE_FALSE:
                    value.boolValue = jsonParser.readValueAs(Boolean.class);
                    break;
                default: throw new IOException("Cannot deserialize LabelFlush");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<LabelFlush> {
        @Override
        public void serialize(LabelFlush obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.doubleValue != null) {
                jsonGenerator.writeObject(obj.doubleValue);
                return;
            }
            if (obj.boolValue != null) {
                jsonGenerator.writeObject(obj.boolValue);
                return;
            }
            jsonGenerator.writeNull();
        }
    }
}
