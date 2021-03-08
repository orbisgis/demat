package org.orbisgis.demat.vega;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

/**
 * The imputation method to use for the field value of imputed data objects. One of
 * `"value"`, `"mean"`, `"median"`, `"max"` or `"min"`.
 *
 * __Default value:__  `"value"`
 */
public enum ImputeParamsMethod {
    MAX, MEAN, MEDIAN, MIN, VALUE;

    @JsonValue
    public String toValue() {
        switch (this) {
            case MAX: return "max";
            case MEAN: return "mean";
            case MEDIAN: return "median";
            case MIN: return "min";
            case VALUE: return "value";
        }
        return null;
    }

    @JsonCreator
    public static ImputeParamsMethod forValue(String value) throws IOException {
        if (value.equals("max")) return MAX;
        if (value.equals("mean")) return MEAN;
        if (value.equals("median")) return MEDIAN;
        if (value.equals("min")) return MIN;
        if (value.equals("value")) return VALUE;
        throw new IOException("Cannot deserialize ImputeParamsMethod");
    }
}
