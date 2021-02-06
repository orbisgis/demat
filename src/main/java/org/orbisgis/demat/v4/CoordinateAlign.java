package org.orbisgis.demat.v4;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;

/**
 * The alignment to apply to grid rows and columns. The supported string values are `"all"`,
 * `"each"`, and `"none"`.
 *
 * - For `"none"`, a flow layout will be used, in which adjacent subviews are simply placed
 * one after the other. - For `"each"`, subviews will be aligned into a clean grid
 * structure, but each row or column may be of variable size. - For `"all"`, subviews will
 * be aligned and each row or column will be sized identically based on the maximum observed
 * size. String values for this property will be applied to both grid rows and columns.
 *
 * Alternatively, an object value of the form `{"row": string, "column": string}` can be
 * used to supply different alignments for rows and columns.
 *
 * __Default value:__ `"all"`.
 */
@JsonDeserialize(using = CoordinateAlign.Deserializer.class)
@JsonSerialize(using = CoordinateAlign.Serializer.class)
public class CoordinateAlign {
    public RowColLayoutAlign rowColLayoutAlignValue;
    public LayoutAlign enumValue;

    static class Deserializer extends JsonDeserializer<CoordinateAlign> {
        @Override
        public CoordinateAlign deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            CoordinateAlign value = new CoordinateAlign();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case VALUE_STRING:
                    String string = jsonParser.readValueAs(String.class);
                    try {
                        value.enumValue = LayoutAlign.forValue(string);
                    } catch (Exception ex) {
                        // Ignored
                    }
                    break;
                case START_OBJECT:
                    value.rowColLayoutAlignValue = jsonParser.readValueAs(RowColLayoutAlign.class);
                    break;
                default: throw new IOException("Cannot deserialize CoordinateAlign");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<CoordinateAlign> {
        @Override
        public void serialize(CoordinateAlign obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.rowColLayoutAlignValue != null) {
                jsonGenerator.writeObject(obj.rowColLayoutAlignValue);
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
