package org.orbisgis.demat.v4;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(using = Domain.Deserializer.class)
@JsonSerialize(using = Domain.Serializer.class)
public class Domain {
    public Double doubleValue;
    public Boolean boolValue;
    public DomainDateTime domainDateTimeValue;
    public String stringValue;

    static class Deserializer extends JsonDeserializer<Domain> {
        @Override
        public Domain deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            Domain value = new Domain();
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
                case VALUE_STRING:
                    String string = jsonParser.readValueAs(String.class);
                    value.stringValue = string;
                    break;
                case START_OBJECT:
                    value.domainDateTimeValue = jsonParser.readValueAs(DomainDateTime.class);
                    break;
                default: throw new IOException("Cannot deserialize Domain");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<Domain> {
        @Override
        public void serialize(Domain obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.doubleValue != null) {
                jsonGenerator.writeObject(obj.doubleValue);
                return;
            }
            if (obj.boolValue != null) {
                jsonGenerator.writeObject(obj.boolValue);
                return;
            }
            if (obj.domainDateTimeValue != null) {
                jsonGenerator.writeObject(obj.domainDateTimeValue);
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
