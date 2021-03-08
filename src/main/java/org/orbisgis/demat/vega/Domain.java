package org.orbisgis.demat.vega;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;

/**
 * Customized domain values in the form of constant values or dynamic values driven by a
 * selection.
 *
 * 1) Constant `domain` for _quantitative_ fields can take one of the following forms:
 *
 * - A two-element array with minimum and maximum values. To create a diverging scale, this
 * two-element array can be combined with the `domainMid` property. - An array with more
 * than two entries, for [Piecewise quantitative
 * scales](https://vega.github.io/vega-lite/docs/scale.html#piecewise). - A string value
 * `"unaggregated"`, if the input field is aggregated, to indicate that the domain should
 * include the raw data values prior to the aggregation.
 *
 * 2) Constant `domain` for _temporal_ fields can be a two-element array with minimum and
 * maximum values, in the form of either timestamps or the [DateTime definition
 * objects](https://vega.github.io/vega-lite/docs/types.html#datetime).
 *
 * 3) Constant `domain` for _ordinal_ and _nominal_ fields can be an array that lists valid
 * input values.
 *
 * 4) To combine (union) specified constant domain with the field's values, `domain` can be
 * an object with a `unionWith` property that specify constant domain to be combined. For
 * example, `domain: {unionWith: [0, 100]}` for a quantitative scale means that the scale
 * domain always includes `[0, 100]`, but will include other values in the fields beyond
 * `[0, 100]`.
 *
 * 5) Domain can also takes an object defining a field or encoding of a selection that
 * [interactively
 * determines](https://vega.github.io/vega-lite/docs/selection.html#scale-domains) the scale
 * domain.
 */
@JsonDeserialize(using = Domain.Deserializer.class)
@JsonSerialize(using = Domain.Serializer.class)
public class Domain {
    public Object[] values;
    public DomainUnionWith domainUnionWithValue;
    public String stringValue;

    static class Deserializer extends JsonDeserializer<Domain> {
        @Override
        public Domain deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            Domain value = new Domain();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case VALUE_STRING:
                    String string = jsonParser.readValueAs(String.class);
                    value.stringValue = string;
                    break;
                case START_ARRAY:
                    value.values = jsonParser.readValueAs(Object[].class);
                    break;
                case START_OBJECT:
                    value.domainUnionWithValue = jsonParser.readValueAs(DomainUnionWith.class);
                    break;
                default: throw new IOException("Cannot deserialize DomainUnion");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<Domain> {
        @Override
        public void serialize(Domain obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.values != null) {
                jsonGenerator.writeObject(obj.values);
                return;
            }
            if (obj.domainUnionWithValue != null) {
                jsonGenerator.writeObject(obj.domainUnionWithValue);
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
