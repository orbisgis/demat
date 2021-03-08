package org.orbisgis.demat.vega;

import com.fasterxml.jackson.annotation.*;

public class BinExtentClass {
    private String field;
    private String selection;
    private SingleDefUnitChannel encoding;

    /**
     * The field name to extract selected values for, when a selection is
     * [projected](https://vega.github.io/vega-lite/docs/project.html) over multiple fields or
     * encodings.
     */
    @JsonProperty("field")
    public String getField() { return field; }
    @JsonProperty("field")
    public void setField(String value) { this.field = value; }

    /**
     * The name of a selection.
     */
    @JsonProperty("selection")
    public String getSelection() { return selection; }
    @JsonProperty("selection")
    public void setSelection(String value) { this.selection = value; }

    /**
     * The encoding channel to extract selected values for, when a selection is
     * [projected](https://vega.github.io/vega-lite/docs/project.html) over multiple fields or
     * encodings.
     */
    @JsonProperty("encoding")
    public SingleDefUnitChannel getEncoding() { return encoding; }
    @JsonProperty("encoding")
    public void setEncoding(SingleDefUnitChannel value) { this.encoding = value; }
}
