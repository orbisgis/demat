package org.orbisgis.demat.vega;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;

/**
 * Time unit for the field to be tested.
 *
 * Time unit (e.g., `year`, `yearmonth`, `month`, `hours`) for a temporal field. or [a
 * temporal field that gets casted as
 * ordinal](https://vega.github.io/vega-lite/docs/type.html#cast).
 *
 * __Default value:__ `undefined` (None)
 *
 * __See also:__ [`timeUnit`](https://vega.github.io/vega-lite/docs/timeunit.html)
 * documentation.
 *
 * The timeUnit.
 */
@JsonDeserialize(using = TimeUnitUnion.Deserializer.class)
@JsonSerialize(using = TimeUnitUnion.Serializer.class)
public class TimeUnitUnion {
    public TimeUnitParams timeUnitParams;
    public TimeUnit enumValue;

    public TimeUnitUnion() {
    }

    public TimeUnitUnion(TimeUnit timeUnit) {
        this.enumValue=timeUnit;
    }

    static class Deserializer extends JsonDeserializer<TimeUnitUnion> {
        @Override
        public TimeUnitUnion deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            TimeUnitUnion value = new TimeUnitUnion();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case VALUE_STRING:
                    String string = jsonParser.readValueAs(String.class);
                    try {
                        value.enumValue = TimeUnit.forValue(string);
                    } catch (Exception ex) {
                        // Ignored
                    }
                    break;
                case START_OBJECT:
                    value.timeUnitParams = jsonParser.readValueAs(TimeUnitParams.class);
                    break;
                default: throw new IOException("Cannot deserialize TimeUnitUnion");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<TimeUnitUnion> {
        @Override
        public void serialize(TimeUnitUnion obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.timeUnitParams != null) {
                jsonGenerator.writeObject(obj.timeUnitParams);
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
