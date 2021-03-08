package org.orbisgis.demat.vega;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(using = GridColorUnion.Deserializer.class)
@JsonSerialize(using = GridColorUnion.Serializer.class)
public class GridColorUnion {
    public GridColorExprRef gridColorExprRefValue;
    public String stringValue;

    static class Deserializer extends JsonDeserializer<GridColorUnion> {
        @Override
        public GridColorUnion deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            GridColorUnion value = new GridColorUnion();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case VALUE_STRING:
                    String string = jsonParser.readValueAs(String.class);
                    value.stringValue = string;
                    break;
                case START_OBJECT:
                    value.gridColorExprRefValue = jsonParser.readValueAs(GridColorExprRef.class);
                    break;
                default: throw new IOException("Cannot deserialize GridColorUnion");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<GridColorUnion> {
        @Override
        public void serialize(GridColorUnion obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.gridColorExprRefValue != null) {
                jsonGenerator.writeObject(obj.gridColorExprRefValue);
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
