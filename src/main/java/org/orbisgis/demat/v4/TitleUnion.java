package org.orbisgis.demat.v4;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;
import com.fasterxml.jackson.core.type.*;
import java.util.List;

/**
 * Title for the plot.
 */
@JsonDeserialize(using = TitleUnion.Deserializer.class)
@JsonSerialize(using = TitleUnion.Serializer.class)
public class TitleUnion {
    public List<String> stringArrayValue;
    public TitleParams titleParamsValue;
    public String stringValue;

    static class Deserializer extends JsonDeserializer<TitleUnion> {
        @Override
        public TitleUnion deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            TitleUnion value = new TitleUnion();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case VALUE_STRING:
                    String string = jsonParser.readValueAs(String.class);
                    value.stringValue = string;
                    break;
                case START_ARRAY:
                    value.stringArrayValue = jsonParser.readValueAs(new TypeReference<List<String>>() {});
                    break;
                case START_OBJECT:
                    value.titleParamsValue = jsonParser.readValueAs(TitleParams.class);
                    break;
                default: throw new IOException("Cannot deserialize TitleUnion");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<TitleUnion> {
        @Override
        public void serialize(TitleUnion obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.stringArrayValue != null) {
                jsonGenerator.writeObject(obj.stringArrayValue);
                return;
            }
            if (obj.titleParamsValue != null) {
                jsonGenerator.writeObject(obj.titleParamsValue);
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
