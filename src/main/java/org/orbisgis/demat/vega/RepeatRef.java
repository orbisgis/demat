package org.orbisgis.demat.vega;

import com.fasterxml.jackson.annotation.*;

/**
 * Reference to a repeated value.
 */
public class RepeatRef {
    private RepeatEnum repeat;

    @JsonProperty("repeat")
    public RepeatEnum getRepeat() { return repeat; }
    @JsonProperty("repeat")
    public void setRepeat(RepeatEnum value) { this.repeat = value; }
}
