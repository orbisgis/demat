package org.orbisgis.demat.vega;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(using = GridOpacityUnion.Deserializer.class)
@JsonSerialize(using = GridOpacityUnion.Serializer.class)
public class GridOpacityUnion {
    public Double doubleValue;
    public GridOpacityExprRef gridOpacityExprRefValue;

    static class Deserializer extends JsonDeserializer<GridOpacityUnion> {
        @Override
        public GridOpacityUnion deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            GridOpacityUnion value = new GridOpacityUnion();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case VALUE_NUMBER_INT:
                case VALUE_NUMBER_FLOAT:
                    value.doubleValue = jsonParser.readValueAs(Double.class);
                    break;
                case START_OBJECT:
                    value.gridOpacityExprRefValue = jsonParser.readValueAs(GridOpacityExprRef.class);
                    break;
                default: throw new IOException("Cannot deserialize GridOpacityUnion");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<GridOpacityUnion> {
        @Override
        public void serialize(GridOpacityUnion obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.doubleValue != null) {
                jsonGenerator.writeObject(obj.doubleValue);
                return;
            }
            if (obj.gridOpacityExprRefValue != null) {
                jsonGenerator.writeObject(obj.gridOpacityExprRefValue);
                return;
            }
            jsonGenerator.writeNull();
        }
    }
}
