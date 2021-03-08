package org.orbisgis.demat.vega;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.io.IOException;

@JsonDeserialize(using = Data.Deserializer.class)
public class Data {
    private DataFormat format;
    private String name;
    private String url;
    private DataValues values;
    private SequenceParams sequence;
    private SphereUnion sphere;
    private Graticule graticule;

    /**
     * An object that specifies the format for parsing the data.
     */
    @JsonProperty("format")
    public DataFormat getFormat() { return format; }
    @JsonProperty("format")
    public void setFormat(DataFormat value) { this.format = value; }

    /**
     * Provide a placeholder name and bind data at runtime.
     */
    @JsonProperty("name")
    public String getName() { return name; }
    @JsonProperty("name")
    public void setName(String value) { this.name = value; }

    /**
     * An URL from which to load the data set. Use the `format.type` property to ensure the
     * loaded data is correctly parsed.
     */
    @JsonProperty("url")
    public String getURL() { return url; }
    @JsonProperty("url")
    public void setURL(String value) { this.url = value; }

    /**
     * The full data set, included inline. This can be an array of objects or primitive values,
     * an object, or a string. Arrays of primitive values are ingested as objects with a `data`
     * property. Strings are parsed according to the specified format type.
     */
    @JsonProperty("values")
    public DataValues getValues() { return values; }
    @JsonProperty("values")
    public void setValues(DataValues value) { this.values = value; }

    /**
     * Generate a sequence of numbers.
     */
    @JsonProperty("sequence")
    public SequenceParams getSequence() { return sequence; }
    @JsonProperty("sequence")
    public void setSequence(SequenceParams value) { this.sequence = value; }

    /**
     * Generate sphere GeoJSON data for the full globe.
     */
    @JsonProperty("sphere")
    public SphereUnion getSphere() { return sphere; }
    @JsonProperty("sphere")
    public void setSphere(SphereUnion value) { this.sphere = value; }

    /**
     * Generate graticule GeoJSON data for geographic reference lines.
     */
    @JsonProperty("graticule")
    public Graticule getGraticule() { return graticule; }
    @JsonProperty("graticule")
    public void setGraticule(Graticule value) { this.graticule = value; }


    static class Deserializer extends JsonDeserializer<Data> {
        @Override
        public Data deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            Data data = new Data();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case VALUE_STRING:
                    break;
                case START_ARRAY:
                    data.values = jsonParser.readValueAs(DataValues.class);
                    break;
                case START_OBJECT:
                    break;
                default: throw new IOException("Cannot deserialize DataValues");
            }
            return data;
        }
    }
}
