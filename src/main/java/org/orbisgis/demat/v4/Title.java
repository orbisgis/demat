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
@JsonDeserialize(using = Title.Deserializer.class)
@JsonSerialize(using = Title.Serializer.class)
public class Title {
    public List<String> stringArrayValue;
    public TitleParams titleParamsValue;
    public String title;

    static class Deserializer extends JsonDeserializer<Title> {
        @Override
        public Title deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            Title value = new Title();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case VALUE_STRING:
                    String string = jsonParser.readValueAs(String.class);
                    value.title = string;
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

    static class Serializer extends JsonSerializer<Title> {
        @Override
        public void serialize(Title obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.stringArrayValue != null) {
                jsonGenerator.writeObject(obj.stringArrayValue);
                return;
            }
            if (obj.titleParamsValue != null) {
                jsonGenerator.writeObject(obj.titleParamsValue);
                return;
            }
            if (obj.title != null) {
                jsonGenerator.writeObject(obj.title);
                return;
            }
            jsonGenerator.writeNull();
        }
    }
}
