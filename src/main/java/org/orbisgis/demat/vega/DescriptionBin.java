package org.orbisgis.demat.vega;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(using = DescriptionBin.Deserializer.class)
@JsonSerialize(using = DescriptionBin.Serializer.class)
public class DescriptionBin {
    public Boolean boolValue;
    public BinParams binParamsValue;
    public String stringValue;

    static class Deserializer extends JsonDeserializer<DescriptionBin> {
        @Override
        public DescriptionBin deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            DescriptionBin value = new DescriptionBin();
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
                    value.binParamsValue = jsonParser.readValueAs(BinParams.class);
                    break;
                default: throw new IOException("Cannot deserialize DescriptionBin");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<DescriptionBin> {
        @Override
        public void serialize(DescriptionBin obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.boolValue != null) {
                jsonGenerator.writeObject(obj.boolValue);
                return;
            }
            if (obj.binParamsValue != null) {
                jsonGenerator.writeObject(obj.binParamsValue);
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
