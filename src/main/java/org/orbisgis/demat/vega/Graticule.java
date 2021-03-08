package org.orbisgis.demat.vega;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;

/**
 * Generate graticule GeoJSON data for geographic reference lines.
 */
@JsonDeserialize(using = Graticule.Deserializer.class)
@JsonSerialize(using = Graticule.Serializer.class)
public class Graticule {
    public Boolean boolValue;
    public GraticuleParams graticuleParamsValue;

    static class Deserializer extends JsonDeserializer<Graticule> {
        @Override
        public Graticule deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            Graticule value = new Graticule();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case VALUE_TRUE:
                case VALUE_FALSE:
                    value.boolValue = jsonParser.readValueAs(Boolean.class);
                    break;
                case START_OBJECT:
                    value.graticuleParamsValue = jsonParser.readValueAs(GraticuleParams.class);
                    break;
                default: throw new IOException("Cannot deserialize Graticule");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<Graticule> {
        @Override
        public void serialize(Graticule obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.boolValue != null) {
                jsonGenerator.writeObject(obj.boolValue);
                return;
            }
            if (obj.graticuleParamsValue != null) {
                jsonGenerator.writeObject(obj.graticuleParamsValue);
                return;
            }
            jsonGenerator.writeNull();
        }
    }
}
