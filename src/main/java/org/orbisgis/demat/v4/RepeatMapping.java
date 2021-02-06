package org.orbisgis.demat.v4;

import com.fasterxml.jackson.annotation.*;
import java.util.List;

/**
 * Definition for fields to be repeated. One of: 1) An array of fields to be repeated. If
 * `"repeat"` is an array, the field can be referred to as `{"repeat": "repeat"}`. The
 * repeated views are laid out in a wrapped row. You can set the number of columns to
 * control the wrapping. 2) An object that maps `"row"` and/or `"column"` to the listed
 * fields to be repeated along the particular orientations. The objects `{"repeat": "row"}`
 * and `{"repeat": "column"}` can be used to refer to the repeated field respectively.
 */
public class RepeatMapping {
    private List<String> column;
    private List<String> row;
    private List<String> layer;

    /**
     * An array of fields to be repeated horizontally.
     */
    @JsonProperty("column")
    public List<String> getColumn() { return column; }
    @JsonProperty("column")
    public void setColumn(List<String> value) { this.column = value; }

    /**
     * An array of fields to be repeated vertically.
     */
    @JsonProperty("row")
    public List<String> getRow() { return row; }
    @JsonProperty("row")
    public void setRow(List<String> value) { this.row = value; }

    /**
     * An array of fields to be repeated as layers.
     */
    @JsonProperty("layer")
    public List<String> getLayer() { return layer; }
    @JsonProperty("layer")
    public void setLayer(List<String> value) { this.layer = value; }
}
