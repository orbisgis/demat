package org.orbisgis.demat.v4;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(using = GridDashOffsetUnion.Deserializer.class)
@JsonSerialize(using = GridDashOffsetUnion.Serializer.class)
public class GridDashOffsetUnion {
    public Double doubleValue;
    public GridDashOffsetExprRef gridDashOffsetExprRefValue;

    static class Deserializer extends JsonDeserializer<GridDashOffsetUnion> {
        @Override
        public GridDashOffsetUnion deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            GridDashOffsetUnion value = new GridDashOffsetUnion();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case VALUE_NUMBER_INT:
                case VALUE_NUMBER_FLOAT:
                    value.doubleValue = jsonParser.readValueAs(Double.class);
                    break;
                case START_OBJECT:
                    value.gridDashOffsetExprRefValue = jsonParser.readValueAs(GridDashOffsetExprRef.class);
                    break;
                default: throw new IOException("Cannot deserialize GridDashOffsetUnion");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<GridDashOffsetUnion> {
        @Override
        public void serialize(GridDashOffsetUnion obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.doubleValue != null) {
                jsonGenerator.writeObject(obj.doubleValue);
                return;
            }
            if (obj.gridDashOffsetExprRefValue != null) {
                jsonGenerator.writeObject(obj.gridDashOffsetExprRefValue);
                return;
            }
            jsonGenerator.writeNull();
        }
    }
}
