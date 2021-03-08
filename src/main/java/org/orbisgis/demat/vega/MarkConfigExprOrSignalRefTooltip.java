package org.orbisgis.demat.vega;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(using = MarkConfigExprOrSignalRefTooltip.Deserializer.class)
@JsonSerialize(using = MarkConfigExprOrSignalRefTooltip.Serializer.class)
public class MarkConfigExprOrSignalRefTooltip {
    public Double doubleValue;
    public Boolean boolValue;
    public PurpleTooltipContent purpleTooltipContentValue;
    public String stringValue;

    static class Deserializer extends JsonDeserializer<MarkConfigExprOrSignalRefTooltip> {
        @Override
        public MarkConfigExprOrSignalRefTooltip deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            MarkConfigExprOrSignalRefTooltip value = new MarkConfigExprOrSignalRefTooltip();
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
                    value.purpleTooltipContentValue = jsonParser.readValueAs(PurpleTooltipContent.class);
                    break;
                default: throw new IOException("Cannot deserialize MarkConfigExprOrSignalRefTooltip");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<MarkConfigExprOrSignalRefTooltip> {
        @Override
        public void serialize(MarkConfigExprOrSignalRefTooltip obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.doubleValue != null) {
                jsonGenerator.writeObject(obj.doubleValue);
                return;
            }
            if (obj.boolValue != null) {
                jsonGenerator.writeObject(obj.boolValue);
                return;
            }
            if (obj.purpleTooltipContentValue != null) {
                jsonGenerator.writeObject(obj.purpleTooltipContentValue);
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
