package org.orbisgis.demat.vega;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(using = Point.Deserializer.class)
@JsonSerialize(using = Point.Serializer.class)
public class Point {
    public Boolean boolValue;
    public OverlayMarkDef overlayMarkDefValue;
    public String stringValue;

    static class Deserializer extends JsonDeserializer<Point> {
        @Override
        public Point deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            Point value = new Point();
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
                    value.overlayMarkDefValue = jsonParser.readValueAs(OverlayMarkDef.class);
                    break;
                default: throw new IOException("Cannot deserialize Point");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<Point> {
        @Override
        public void serialize(Point obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.boolValue != null) {
                jsonGenerator.writeObject(obj.boolValue);
                return;
            }
            if (obj.overlayMarkDefValue != null) {
                jsonGenerator.writeObject(obj.overlayMarkDefValue);
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
