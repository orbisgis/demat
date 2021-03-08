package org.orbisgis.demat.vega;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;

/**
 * The interpolation method for range values. By default, a general interpolator for
 * numbers, dates, strings and colors (in HCL space) is used. For color ranges, this
 * property allows interpolation in alternative color spaces. Legal values include `rgb`,
 * `hsl`, `hsl-long`, `lab`, `hcl`, `hcl-long`, `cubehelix` and `cubehelix-long` ('-long'
 * variants use longer paths in polar coordinate spaces). If object-valued, this property
 * accepts an object with a string-valued _type_ property and an optional numeric _gamma_
 * property applicable to rgb and cubehelix interpolators. For more, see the [d3-interpolate
 * documentation](https://github.com/d3/d3-interpolate).
 *
 * * __Default value:__ `hcl`
 */
@JsonDeserialize(using = ScaleInterpolate.Deserializer.class)
@JsonSerialize(using = ScaleInterpolate.Serializer.class)
public class ScaleInterpolate {
    public Expression expressionValue;
    public ScaleInterpolateEnum enumValue;

    static class Deserializer extends JsonDeserializer<ScaleInterpolate> {
        @Override
        public ScaleInterpolate deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            ScaleInterpolate value = new ScaleInterpolate();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case VALUE_STRING:
                    String string = jsonParser.readValueAs(String.class);
                    try {
                        value.enumValue = ScaleInterpolateEnum.forValue(string);
                    } catch (Exception ex) {
                        // Ignored
                    }
                    break;
                case START_OBJECT:
                    value.expressionValue = jsonParser.readValueAs(Expression.class);
                    break;
                default: throw new IOException("Cannot deserialize ScaleInterpolate");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<ScaleInterpolate> {
        @Override
        public void serialize(ScaleInterpolate obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.expressionValue != null) {
                jsonGenerator.writeObject(obj.expressionValue);
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
