package org.orbisgis.demat.v4;

import com.fasterxml.jackson.annotation.*;

public class RowColLayoutAlign {
    private LayoutAlign column;
    private LayoutAlign row;

    @JsonProperty("column")
    public LayoutAlign getColumn() { return column; }
    @JsonProperty("column")
    public void setColumn(LayoutAlign value) { this.column = value; }

    @JsonProperty("row")
    public LayoutAlign getRow() { return row; }
    @JsonProperty("row")
    public void setRow(LayoutAlign value) { this.row = value; }
}
