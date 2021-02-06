package org.orbisgis.demat.v4;

import com.fasterxml.jackson.annotation.*;

public class ArgmDef {
    private String argmax;
    private String argmin;

    @JsonProperty("argmax")
    public String getArgmax() { return argmax; }
    @JsonProperty("argmax")
    public void setArgmax(String value) { this.argmax = value; }

    @JsonProperty("argmin")
    public String getArgmin() { return argmin; }
    @JsonProperty("argmin")
    public void setArgmin(String value) { this.argmin = value; }
}
