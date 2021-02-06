package org.orbisgis.demat.v4;

import com.fasterxml.jackson.annotation.*;

public class RowColBoolean {
    private Boolean column;
    private Boolean row;

    @JsonProperty("column")
    public Boolean getColumn() { return column; }
    @JsonProperty("column")
    public void setColumn(Boolean value) { this.column = value; }

    @JsonProperty("row")
    public Boolean getRow() { return row; }
    @JsonProperty("row")
    public void setRow(Boolean value) { this.row = value; }
}
