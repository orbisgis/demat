package org.orbisgis.demat.v4;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(using = LegendUnion.Deserializer.class)
@JsonSerialize(using = LegendUnion.Serializer.class)
public class LegendUnion {
    public OnDerivedStream onDerivedStreamValue;
    public String stringValue;

    static class Deserializer extends JsonDeserializer<LegendUnion> {
        @Override
        public LegendUnion deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            LegendUnion value = new LegendUnion();
            switch (jsonParser.currentToken()) {
                case VALUE_STRING:
                    String string = jsonParser.readValueAs(String.class);
                    value.stringValue = string;
                    break;
                case START_OBJECT:
                    value.onDerivedStreamValue = jsonParser.readValueAs(OnDerivedStream.class);
                    break;
                default: throw new IOException("Cannot deserialize LegendUnion");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<LegendUnion> {
        @Override
        public void serialize(LegendUnion obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.onDerivedStreamValue != null) {
                jsonGenerator.writeObject(obj.onDerivedStreamValue);
                return;
            }
            if (obj.stringValue != null) {
                jsonGenerator.writeObject(obj.stringValue);
                return;
            }
            throw new IOException("LegendUnion must not be null");
        }
    }
}
