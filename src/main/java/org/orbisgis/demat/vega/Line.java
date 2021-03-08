package org.orbisgis.demat.vega;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(using = Line.Deserializer.class)
@JsonSerialize(using = Line.Serializer.class)
public class Line {
    public Boolean boolValue;
    public OverlayMarkDef overlayMarkDefValue;

    static class Deserializer extends JsonDeserializer<Line> {
        @Override
        public Line deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            Line value = new Line();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case VALUE_TRUE:
                case VALUE_FALSE:
                    value.boolValue = jsonParser.readValueAs(Boolean.class);
                    break;
                case START_OBJECT:
                    value.overlayMarkDefValue = jsonParser.readValueAs(OverlayMarkDef.class);
                    break;
                default: throw new IOException("Cannot deserialize Line");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<Line> {
        @Override
        public void serialize(Line obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.boolValue != null) {
                jsonGenerator.writeObject(obj.boolValue);
                return;
            }
            if (obj.overlayMarkDefValue != null) {
                jsonGenerator.writeObject(obj.overlayMarkDefValue);
                return;
            }
            jsonGenerator.writeNull();
        }
    }
}
