package org.orbisgis.demat.vega;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

/**
 * The imputation method to use for the field value of imputed data objects. One of
 * `"value"`, `"mean"`, `"median"`, `"max"` or `"min"`.
 *
 * __Default value:__  `"value"`
 *
 * The functional form of the regression model. One of `"linear"`, `"log"`, `"exp"`,
 * `"pow"`, `"quad"`, or `"poly"`.
 *
 * __Default value:__ `"linear"`
 */
public enum TransformMethod {
    EXP, LINEAR, LOG, MAX, MEAN, MEDIAN, MIN, POLY, POW, QUAD, VALUE;

    @JsonValue
    public String toValue() {
        switch (this) {
            case EXP: return "exp";
            case LINEAR: return "linear";
            case LOG: return "log";
            case MAX: return "max";
            case MEAN: return "mean";
            case MEDIAN: return "median";
            case MIN: return "min";
            case POLY: return "poly";
            case POW: return "pow";
            case QUAD: return "quad";
            case VALUE: return "value";
        }
        return null;
    }

    @JsonCreator
    public static TransformMethod forValue(String value) throws IOException {
        if (value.equals("exp")) return EXP;
        if (value.equals("linear")) return LINEAR;
        if (value.equals("log")) return LOG;
        if (value.equals("max")) return MAX;
        if (value.equals("mean")) return MEAN;
        if (value.equals("median")) return MEDIAN;
        if (value.equals("min")) return MIN;
        if (value.equals("poly")) return POLY;
        if (value.equals("pow")) return POW;
        if (value.equals("quad")) return QUAD;
        if (value.equals("value")) return VALUE;
        throw new IOException("Cannot deserialize TransformMethod");
    }
}
