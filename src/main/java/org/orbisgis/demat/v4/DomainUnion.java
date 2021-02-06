package org.orbisgis.demat.v4;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;
import com.fasterxml.jackson.core.type.*;
import java.util.List;

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
@JsonDeserialize(using = DomainUnion.Deserializer.class)
@JsonSerialize(using = DomainUnion.Serializer.class)
public class DomainUnion {
    public List<Domain> unionArrayValue;
    public DomainUnionWith domainUnionWithValue;
    public String stringValue;

    static class Deserializer extends JsonDeserializer<DomainUnion> {
        @Override
        public DomainUnion deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            DomainUnion value = new DomainUnion();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case VALUE_STRING:
                    String string = jsonParser.readValueAs(String.class);
                    value.stringValue = string;
                    break;
                case START_ARRAY:
                    value.unionArrayValue = jsonParser.readValueAs(new TypeReference<List<Domain>>() {});
                    break;
                case START_OBJECT:
                    value.domainUnionWithValue = jsonParser.readValueAs(DomainUnionWith.class);
                    break;
                default: throw new IOException("Cannot deserialize DomainUnion");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<DomainUnion> {
        @Override
        public void serialize(DomainUnion obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.unionArrayValue != null) {
                jsonGenerator.writeObject(obj.unionArrayValue);
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
