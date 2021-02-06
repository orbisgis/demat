package org.orbisgis.demat.v4;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;
import com.fasterxml.jackson.core.type.*;
import java.util.List;

/**
 * Explicitly set the visible axis tick values.
 *
 * Explicitly set the visible legend values.
 */
@JsonDeserialize(using = Values.Deserializer.class)
@JsonSerialize(using = Values.Serializer.class)
public class Values {
    public List<SelectionInitInterval> unionArrayValue;
    public BackgroundExprRef backgroundExprRefValue;

    static class Deserializer extends JsonDeserializer<Values> {
        @Override
        public Values deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            Values value = new Values();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case START_ARRAY:
                    value.unionArrayValue = jsonParser.readValueAs(new TypeReference<List<SelectionInitInterval>>() {});
                    break;
                case START_OBJECT:
                    value.backgroundExprRefValue = jsonParser.readValueAs(BackgroundExprRef.class);
                    break;
                default: throw new IOException("Cannot deserialize Values");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<Values> {
        @Override
        public void serialize(Values obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.unionArrayValue != null) {
                jsonGenerator.writeObject(obj.unionArrayValue);
                return;
            }
            if (obj.backgroundExprRefValue != null) {
                jsonGenerator.writeObject(obj.backgroundExprRefValue);
                return;
            }
            jsonGenerator.writeNull();
        }
    }
}
