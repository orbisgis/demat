package org.orbisgis.demat.v4;

import com.fasterxml.jackson.annotation.*;
import java.util.List;

/**
 * Data source or selection for secondary data reference.
 */
public class Lookup {
    private Data data;
    private List<String> fields;
    private String key;
    private String selection;

    /**
     * Secondary data source to lookup in.
     */
    @JsonProperty("data")
    public Data getData() { return data; }
    @JsonProperty("data")
    public void setData(Data value) { this.data = value; }

    /**
     * Fields in foreign data or selection to lookup. If not specified, the entire object is
     * queried.
     */
    @JsonProperty("fields")
    public List<String> getFields() { return fields; }
    @JsonProperty("fields")
    public void setFields(List<String> value) { this.fields = value; }

    /**
     * Key in data to lookup.
     */
    @JsonProperty("key")
    public String getKey() { return key; }
    @JsonProperty("key")
    public void setKey(String value) { this.key = value; }

    /**
     * Selection name to look up.
     */
    @JsonProperty("selection")
    public String getSelection() { return selection; }
    @JsonProperty("selection")
    public void setSelection(String value) { this.selection = value; }
}
