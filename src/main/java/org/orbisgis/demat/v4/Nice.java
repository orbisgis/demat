package org.orbisgis.demat.v4;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;

/**
 * Extending the domain so that it starts and ends on nice round values. This method
 * typically modifies the scale’s domain, and may only extend the bounds to the nearest
 * round value. Nicing is useful if the domain is computed from data and may be irregular.
 * For example, for a domain of _[0.201479…, 0.996679…]_, a nice domain might be _[0.2,
 * 1.0]_.
 *
 * For quantitative scales such as linear, `nice` can be either a boolean flag or a number.
 * If `nice` is a number, it will represent a desired tick count. This allows greater
 * control over the step size used to extend the bounds, guaranteeing that the returned
 * ticks will exactly cover the domain.
 *
 * For temporal fields with time and utc scales, the `nice` value can be a string indicating
 * the desired time interval. Legal values are `"millisecond"`, `"second"`, `"minute"`,
 * `"hour"`, `"day"`, `"week"`, `"month"`, and `"year"`. Alternatively, `time` and `utc`
 * scales can accept an object-valued interval specifier of the form `{"interval": "month",
 * "step": 3}`, which includes a desired number of interval steps. Here, the domain would
 * snap to quarter (Jan, Apr, Jul, Oct) boundaries.
 *
 * __Default value:__ `true` for unbinned _quantitative_ fields; `false` otherwise.
 */
@JsonDeserialize(using = Nice.Deserializer.class)
@JsonSerialize(using = Nice.Serializer.class)
public class Nice {
    public Boolean boolValue;
    public Double doubleValue;
    public NiceTimeIntervalStep niceTimeIntervalStepValue;
    public TimeInterval enumValue;

    static class Deserializer extends JsonDeserializer<Nice> {
        @Override
        public Nice deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            Nice value = new Nice();
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
                    try {
                        value.enumValue = TimeInterval.forValue(string);
                    } catch (Exception ex) {
                        // Ignored
                    }
                    break;
                case START_OBJECT:
                    value.niceTimeIntervalStepValue = jsonParser.readValueAs(NiceTimeIntervalStep.class);
                    break;
                default: throw new IOException("Cannot deserialize Nice");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<Nice> {
        @Override
        public void serialize(Nice obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.boolValue != null) {
                jsonGenerator.writeObject(obj.boolValue);
                return;
            }
            if (obj.doubleValue != null) {
                jsonGenerator.writeObject(obj.doubleValue);
                return;
            }
            if (obj.niceTimeIntervalStepValue != null) {
                jsonGenerator.writeObject(obj.niceTimeIntervalStepValue);
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
