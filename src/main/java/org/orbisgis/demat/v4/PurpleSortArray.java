package org.orbisgis.demat.v4;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;
import com.fasterxml.jackson.core.type.*;
import java.util.List;

@JsonDeserialize(using = PurpleSortArray.Deserializer.class)
@JsonSerialize(using = PurpleSortArray.Serializer.class)
public class PurpleSortArray {
    public List<SelectionInitInterval> unionArrayValue;
    public SortEncodingSortField sortEncodingSortFieldValue;
    public SortOrder enumValue;

    static class Deserializer extends JsonDeserializer<PurpleSortArray> {
        @Override
        public PurpleSortArray deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            PurpleSortArray value = new PurpleSortArray();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case VALUE_STRING:
                    String string = jsonParser.readValueAs(String.class);
                    try {
                        value.enumValue = SortOrder.forValue(string);
                    } catch (Exception ex) {
                        // Ignored
                    }
                    break;
                case START_ARRAY:
                    value.unionArrayValue = jsonParser.readValueAs(new TypeReference<List<SelectionInitInterval>>() {});
                    break;
                case START_OBJECT:
                    value.sortEncodingSortFieldValue = jsonParser.readValueAs(SortEncodingSortField.class);
                    break;
                default: throw new IOException("Cannot deserialize PurpleSortArray");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<PurpleSortArray> {
        @Override
        public void serialize(PurpleSortArray obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.unionArrayValue != null) {
                jsonGenerator.writeObject(obj.unionArrayValue);
                return;
            }
            if (obj.sortEncodingSortFieldValue != null) {
                jsonGenerator.writeObject(obj.sortEncodingSortFieldValue);
                return;
            }
            if (obj.enumValue != null) {
                jsonGenerator.writeObject(obj.enumValue);
                return;
            }
            jsonGenerator.writeNull();
        }
    }
}
