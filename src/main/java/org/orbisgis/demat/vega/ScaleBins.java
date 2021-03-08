package org.orbisgis.demat.vega;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;
import com.fasterxml.jackson.core.type.*;
import java.util.List;

/**
 * Bin boundaries can be provided to scales as either an explicit array of bin boundaries or
 * as a bin specification object. The legal values are: - An [array](../types/#Array)
 * literal of bin boundary values. For example, `[0, 5, 10, 15, 20]`. The array must include
 * both starting and ending boundaries. The previous example uses five values to indicate a
 * total of four bin intervals: [0-5), [5-10), [10-15), [15-20]. Array literals may include
 * signal references as elements. - A [bin specification
 * object](https://vega.github.io/vega-lite/docs/scale.html#bins) that indicates the bin
 * _step_ size, and optionally the _start_ and _stop_ boundaries. - An array of bin
 * boundaries over the scale domain. If provided, axes and legends will use the bin
 * boundaries to inform the choice of tick marks and text labels.
 */
@JsonDeserialize(using = ScaleBins.Deserializer.class)
@JsonSerialize(using = ScaleBins.Serializer.class)
public class ScaleBins {
    public List<Double> doubleArrayValue;
    public ScaleBinParams scaleBinParamsValue;

    static class Deserializer extends JsonDeserializer<ScaleBins> {
        @Override
        public ScaleBins deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            ScaleBins value = new ScaleBins();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case START_ARRAY:
                    value.doubleArrayValue = jsonParser.readValueAs(new TypeReference<List<Double>>() {});
                    break;
                case START_OBJECT:
                    value.scaleBinParamsValue = jsonParser.readValueAs(ScaleBinParams.class);
                    break;
                default: throw new IOException("Cannot deserialize ScaleBins");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<ScaleBins> {
        @Override
        public void serialize(ScaleBins obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.doubleArrayValue != null) {
                jsonGenerator.writeObject(obj.doubleArrayValue);
                return;
            }
            if (obj.scaleBinParamsValue != null) {
                jsonGenerator.writeObject(obj.scaleBinParamsValue);
                return;
            }
            jsonGenerator.writeNull();
        }
    }
}
