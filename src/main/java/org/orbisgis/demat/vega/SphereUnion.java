package org.orbisgis.demat.vega;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;

/**
 * Generate sphere GeoJSON data for the full globe.
 */
@JsonDeserialize(using = SphereUnion.Deserializer.class)
@JsonSerialize(using = SphereUnion.Serializer.class)
public class SphereUnion {
    public Boolean boolValue;
    public SphereClass sphereClassValue;

    static class Deserializer extends JsonDeserializer<SphereUnion> {
        @Override
        public SphereUnion deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            SphereUnion value = new SphereUnion();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case VALUE_TRUE:
                case VALUE_FALSE:
                    value.boolValue = jsonParser.readValueAs(Boolean.class);
                    break;
                case START_OBJECT:
                    value.sphereClassValue = jsonParser.readValueAs(SphereClass.class);
                    break;
                default: throw new IOException("Cannot deserialize SphereUnion");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<SphereUnion> {
        @Override
        public void serialize(SphereUnion obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.boolValue != null) {
                jsonGenerator.writeObject(obj.boolValue);
                return;
            }
            if (obj.sphereClassValue != null) {
                jsonGenerator.writeObject(obj.sphereClassValue);
                return;
            }
            jsonGenerator.writeNull();
        }
    }
}
