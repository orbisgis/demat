package org.orbisgis.demat.v4;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(using = StyleTooltip.Deserializer.class)
@JsonSerialize(using = StyleTooltip.Serializer.class)
public class StyleTooltip {
    public Double doubleValue;
    public Boolean boolValue;
    public FluffyTooltipContent fluffyTooltipContentValue;
    public String stringValue;

    static class Deserializer extends JsonDeserializer<StyleTooltip> {
        @Override
        public StyleTooltip deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            StyleTooltip value = new StyleTooltip();
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
                    value.fluffyTooltipContentValue = jsonParser.readValueAs(FluffyTooltipContent.class);
                    break;
                default: throw new IOException("Cannot deserialize StyleTooltip");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<StyleTooltip> {
        @Override
        public void serialize(StyleTooltip obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.doubleValue != null) {
                jsonGenerator.writeObject(obj.doubleValue);
                return;
            }
            if (obj.boolValue != null) {
                jsonGenerator.writeObject(obj.boolValue);
                return;
            }
            if (obj.fluffyTooltipContentValue != null) {
                jsonGenerator.writeObject(obj.fluffyTooltipContentValue);
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
