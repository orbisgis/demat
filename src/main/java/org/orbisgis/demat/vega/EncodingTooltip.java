package org.orbisgis.demat.vega;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;
import com.fasterxml.jackson.core.type.*;
import java.util.List;

@JsonDeserialize(using = EncodingTooltip.Deserializer.class)
@JsonSerialize(using = EncodingTooltip.Serializer.class)
public class EncodingTooltip {
    public FieldOrDatumDefWithConditionStringFieldDefString fieldOrDatumDefWithConditionStringFieldDefStringValue;
    public List<StringFieldDef> stringFieldDefArrayValue;

    static class Deserializer extends JsonDeserializer<EncodingTooltip> {
        @Override
        public EncodingTooltip deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            EncodingTooltip value = new EncodingTooltip();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case START_ARRAY:
                    value.stringFieldDefArrayValue = jsonParser.readValueAs(new TypeReference<List<StringFieldDef>>() {});
                    break;
                case START_OBJECT:
                    value.fieldOrDatumDefWithConditionStringFieldDefStringValue = jsonParser.readValueAs(FieldOrDatumDefWithConditionStringFieldDefString.class);
                    break;
                default: throw new IOException("Cannot deserialize EncodingTooltip");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<EncodingTooltip> {
        @Override
        public void serialize(EncodingTooltip obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.fieldOrDatumDefWithConditionStringFieldDefStringValue != null) {
                jsonGenerator.writeObject(obj.fieldOrDatumDefWithConditionStringFieldDefStringValue);
                return;
            }
            if (obj.stringFieldDefArrayValue != null) {
                jsonGenerator.writeObject(obj.stringFieldDefArrayValue);
                return;
            }
            jsonGenerator.writeNull();
        }
    }
}
