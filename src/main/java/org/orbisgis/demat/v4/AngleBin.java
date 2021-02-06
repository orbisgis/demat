package org.orbisgis.demat.v4;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;

/**
 * An object indicating bin properties, or simply `true` for using default bin parameters.
 */
@JsonDeserialize(using = AngleBin.Deserializer.class)
@JsonSerialize(using = AngleBin.Serializer.class)
public class AngleBin {
    public Boolean boolValue;
    public BinParams binParamsValue;

    static class Deserializer extends JsonDeserializer<AngleBin> {
        @Override
        public AngleBin deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            AngleBin value = new AngleBin();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case VALUE_TRUE:
                case VALUE_FALSE:
                    value.boolValue = jsonParser.readValueAs(Boolean.class);
                    break;
                case START_OBJECT:
                    value.binParamsValue = jsonParser.readValueAs(BinParams.class);
                    break;
                default: throw new IOException("Cannot deserialize AngleBin");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<AngleBin> {
        @Override
        public void serialize(AngleBin obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.boolValue != null) {
                jsonGenerator.writeObject(obj.boolValue);
                return;
            }
            if (obj.binParamsValue != null) {
                jsonGenerator.writeObject(obj.binParamsValue);
                return;
            }
            jsonGenerator.writeNull();
        }
    }
}
