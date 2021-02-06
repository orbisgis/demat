package org.orbisgis.demat.v4;

import com.fasterxml.jackson.annotation.*;
import java.util.Map;

/**
 * An object that specifies the format for parsing the data.
 */
public class DataFormat {
    private Map<String, String> parse;
    private String type;
    private String delimiter;
    private String property;
    private String feature;
    private String mesh;

    /**
     * If set to `null`, disable type inference based on the spec and only use type inference
     * based on the data. Alternatively, a parsing directive object can be provided for explicit
     * data types. Each property of the object corresponds to a field name, and the value to the
     * desired data type (one of `"number"`, `"boolean"`, `"date"`, or null (do not parse the
     * field)). For example, `"parse": {"modified_on": "date"}` parses the `modified_on` field
     * in each input record a Date value.
     *
     * For `"date"`, we parse data based using Javascript's
     * [`Date.parse()`](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Date/parse).
     * For Specific date formats can be provided (e.g., `{foo: "date:'%m%d%Y'"}`), using the
     * [d3-time-format syntax](https://github.com/d3/d3-time-format#locale_format). UTC date
     * format parsing is supported similarly (e.g., `{foo: "utc:'%m%d%Y'"}`). See more about
     * [UTC time](https://vega.github.io/vega-lite/docs/timeunit.html#utc)
     */
    @JsonProperty("parse")
    public Map<String, String> getParse() { return parse; }
    @JsonProperty("parse")
    public void setParse(Map<String, String> value) { this.parse = value; }

    /**
     * Type of input data: `"json"`, `"csv"`, `"tsv"`, `"dsv"`.
     *
     * __Default value:__  The default format type is determined by the extension of the file
     * URL. If no extension is detected, `"json"` will be used by default.
     */
    @JsonProperty("type")
    public String getType() { return type; }
    @JsonProperty("type")
    public void setType(String value) { this.type = value; }

    /**
     * The delimiter between records. The delimiter must be a single character (i.e., a single
     * 16-bit code unit); so, ASCII delimiters are fine, but emoji delimiters are not.
     */
    @JsonProperty("delimiter")
    public String getDelimiter() { return delimiter; }
    @JsonProperty("delimiter")
    public void setDelimiter(String value) { this.delimiter = value; }

    /**
     * The JSON property containing the desired data. This parameter can be used when the loaded
     * JSON file may have surrounding structure or meta-data. For example `"property":
     * "values.features"` is equivalent to retrieving `json.values.features` from the loaded
     * JSON object.
     */
    @JsonProperty("property")
    public String getProperty() { return property; }
    @JsonProperty("property")
    public void setProperty(String value) { this.property = value; }

    /**
     * The name of the TopoJSON object set to convert to a GeoJSON feature collection. For
     * example, in a map of the world, there may be an object set named `"countries"`. Using the
     * feature property, we can extract this set and generate a GeoJSON feature object for each
     * country.
     */
    @JsonProperty("feature")
    public String getFeature() { return feature; }
    @JsonProperty("feature")
    public void setFeature(String value) { this.feature = value; }

    /**
     * The name of the TopoJSON object set to convert to mesh. Similar to the `feature` option,
     * `mesh` extracts a named TopoJSON object set.   Unlike the `feature` option, the
     * corresponding geo data is returned as a single, unified mesh instance, not as individual
     * GeoJSON features. Extracting a mesh is useful for more efficiently drawing borders or
     * other geographic elements that you do not need to associate with specific regions such as
     * individual countries, states or counties.
     */
    @JsonProperty("mesh")
    public String getMesh() { return mesh; }
    @JsonProperty("mesh")
    public void setMesh(String value) { this.mesh = value; }
}
