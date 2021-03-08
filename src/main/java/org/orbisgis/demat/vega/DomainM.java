package org.orbisgis.demat.vega;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(using = DomainM.Deserializer.class)
@JsonSerialize(using = DomainM.Serializer.class)
public class DomainM {
    public Double doubleValue;
    public DomainMaxDateTime domainMaxDateTimeValue;

    static class Deserializer extends JsonDeserializer<DomainM> {
        @Override
        public DomainM deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            DomainM value = new DomainM();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case VALUE_NUMBER_INT:
                case VALUE_NUMBER_FLOAT:
                    value.doubleValue = jsonParser.readValueAs(Double.class);
                    break;
                case START_OBJECT:
                    value.domainMaxDateTimeValue = jsonParser.readValueAs(DomainMaxDateTime.class);
                    break;
                default: throw new IOException("Cannot deserialize DomainM");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<DomainM> {
        @Override
        public void serialize(DomainM obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.doubleValue != null) {
                jsonGenerator.writeObject(obj.doubleValue);
                return;
            }
            if (obj.domainMaxDateTimeValue != null) {
                jsonGenerator.writeObject(obj.domainMaxDateTimeValue);
                return;
            }
            jsonGenerator.writeNull();
        }
    }
}
