package org.orbisgis.demat.v4;

import com.fasterxml.jackson.annotation.*;

public class RangeClass {
    private String field;

    @JsonProperty("field")
    public String getField() { return field; }
    @JsonProperty("field")
    public void setField(String value) { this.field = value; }
}
