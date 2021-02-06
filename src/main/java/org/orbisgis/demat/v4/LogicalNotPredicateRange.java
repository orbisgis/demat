package org.orbisgis.demat.v4;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;
import com.fasterxml.jackson.core.type.*;
import java.util.List;

/**
 * An array of inclusive minimum and maximum values for a field value of a data item to be
 * included in the filtered data.
 */
@JsonDeserialize(using = LogicalNotPredicateRange.Deserializer.class)
@JsonSerialize(using = LogicalNotPredicateRange.Serializer.class)
public class LogicalNotPredicateRange {
    public List<PurpleRange> unionArrayValue;
    public BackgroundExprRef backgroundExprRefValue;

    static class Deserializer extends JsonDeserializer<LogicalNotPredicateRange> {
        @Override
        public LogicalNotPredicateRange deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            LogicalNotPredicateRange value = new LogicalNotPredicateRange();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case START_ARRAY:
                    value.unionArrayValue = jsonParser.readValueAs(new TypeReference<List<PurpleRange>>() {});
                    break;
                case START_OBJECT:
                    value.backgroundExprRefValue = jsonParser.readValueAs(BackgroundExprRef.class);
                    break;
                default: throw new IOException("Cannot deserialize LogicalNotPredicateRange");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<LogicalNotPredicateRange> {
        @Override
        public void serialize(LogicalNotPredicateRange obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
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
