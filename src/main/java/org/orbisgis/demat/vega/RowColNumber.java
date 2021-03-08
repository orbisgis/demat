package org.orbisgis.demat.vega;

import com.fasterxml.jackson.annotation.*;

public class RowColNumber {
    private Double column;
    private Double row;

    @JsonProperty("column")
    public Double getColumn() { return column; }
    @JsonProperty("column")
    public void setColumn(Double value) { this.column = value; }

    @JsonProperty("row")
    public Double getRow() { return row; }
    @JsonProperty("row")
    public void setRow(Double value) { this.row = value; }
}
