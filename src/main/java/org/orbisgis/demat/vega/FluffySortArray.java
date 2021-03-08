package org.orbisgis.demat.vega;

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;
import com.fasterxml.jackson.core.type.*;
import java.util.List;

/**
 * Sort order for the encoded field.
 *
 * For continuous fields (quantitative or temporal), `sort` can be either `"ascending"` or
 * `"descending"`.
 *
 * For discrete fields, `sort` can be one of the following: - `"ascending"` or
 * `"descending"` -- for sorting by the values' natural order in JavaScript. - [A sort field
 * definition](https://vega.github.io/vega-lite/docs/sort.html#sort-field) for sorting by
 * another field. - [An array specifying the field values in preferred
 * order](https://vega.github.io/vega-lite/docs/sort.html#sort-array). In this case, the
 * sort order will obey the values in the array, followed by any unspecified values in their
 * original order. For discrete time field, values in the sort array can be [date-time
 * definition objects](types#datetime). In addition, for time units `"month"` and `"day"`,
 * the values can be the month or day names (case insensitive) or their 3-letter initials
 * (e.g., `"Mon"`, `"Tue"`). - `null` indicating no sort.
 *
 * __Default value:__ `"ascending"`
 *
 * __Note:__ `null` is not supported for `row` and `column`.
 */
@JsonDeserialize(using = FluffySortArray.Deserializer.class)
@JsonSerialize(using = FluffySortArray.Serializer.class)
public class FluffySortArray {
    public List<SelectionInitInterval> unionArrayValue;
    public EncodingSortFieldFieldName encodingSortFieldFieldNameValue;
    public SortOrder enumValue;

    static class Deserializer extends JsonDeserializer<FluffySortArray> {
        @Override
        public FluffySortArray deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            FluffySortArray value = new FluffySortArray();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case VALUE_STRING:
                    String string = jsonParser.readValueAs(String.class);
                    try {
                        value.enumValue = SortOrder.forValue(string);
                    } catch (Exception ex) {
                        // Ignored
                    }
                    break;
                case START_ARRAY:
                    value.unionArrayValue = jsonParser.readValueAs(new TypeReference<List<SelectionInitInterval>>() {});
                    break;
                case START_OBJECT:
                    value.encodingSortFieldFieldNameValue = jsonParser.readValueAs(EncodingSortFieldFieldName.class);
                    break;
                default: throw new IOException("Cannot deserialize FluffySortArray");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<FluffySortArray> {
        @Override
        public void serialize(FluffySortArray obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.unionArrayValue != null) {
                jsonGenerator.writeObject(obj.unionArrayValue);
                return;
            }
            if (obj.encodingSortFieldFieldNameValue != null) {
                jsonGenerator.writeObject(obj.encodingSortFieldFieldNameValue);
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
