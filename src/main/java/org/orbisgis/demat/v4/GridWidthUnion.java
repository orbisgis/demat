package org.orbisgis.demat.v4;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(using = GridWidthUnion.Deserializer.class)
@JsonSerialize(using = GridWidthUnion.Serializer.class)
public class GridWidthUnion {
    public Double doubleValue;
    public GridWidthExprRef gridWidthExprRefValue;

    static class Deserializer extends JsonDeserializer<GridWidthUnion> {
        @Override
        public GridWidthUnion deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            GridWidthUnion value = new GridWidthUnion();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case VALUE_NUMBER_INT:
                case VALUE_NUMBER_FLOAT:
                    value.doubleValue = jsonParser.readValueAs(Double.class);
                    break;
                case START_OBJECT:
                    value.gridWidthExprRefValue = jsonParser.readValueAs(GridWidthExprRef.class);
                    break;
                default: throw new IOException("Cannot deserialize GridWidthUnion");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<GridWidthUnion> {
        @Override
        public void serialize(GridWidthUnion obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.doubleValue != null) {
                jsonGenerator.writeObject(obj.doubleValue);
                return;
            }
            if (obj.gridWidthExprRefValue != null) {
                jsonGenerator.writeObject(obj.gridWidthExprRefValue);
                return;
            }
            jsonGenerator.writeNull();
        }
    }
}
