package org.orbisgis.demat.v4;

import com.fasterxml.jackson.annotation.*;

public class TimeUnitParams {
    private Double maxbins;
    private Double step;
    private TimeUnit unit;
    private Boolean utc;

    /**
     * If no `unit` is specified, maxbins is used to infer time units.
     */
    @JsonProperty("maxbins")
    public Double getMaxbins() { return maxbins; }
    @JsonProperty("maxbins")
    public void setMaxbins(Double value) { this.maxbins = value; }

    /**
     * The number of steps between bins, in terms of the least significant unit provided.
     */
    @JsonProperty("step")
    public Double getStep() { return step; }
    @JsonProperty("step")
    public void setStep(Double value) { this.step = value; }

    /**
     * Defines how date-time values should be binned.
     */
    @JsonProperty("unit")
    public TimeUnit getUnit() { return unit; }
    @JsonProperty("unit")
    public void setUnit(TimeUnit value) { this.unit = value; }

    /**
     * True to use UTC timezone. Equivalent to using a `utc` prefixed `TimeUnit`.
     */
    @JsonProperty("utc")
    public Boolean getUTC() { return utc; }
    @JsonProperty("utc")
    public void setUTC(Boolean value) { this.utc = value; }
}
