package org.orbisgis.demat.vega;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

/**
 * An [aggregate operation](https://vega.github.io/vega-lite/docs/aggregate.html#ops) to
 * perform on the field prior to sorting (e.g., `"count"`, `"mean"` and `"median"`). An
 * aggregation is required when there are multiple values of the sort field for each encoded
 * data field. The input data objects will be aggregated, grouped by the encoded data
 * field.
 *
 * For a full list of operations, please see the documentation for
 * [aggregate](https://vega.github.io/vega-lite/docs/aggregate.html#ops).
 *
 * __Default value:__ `"sum"` for stacked plots. Otherwise, `"min"`.
 */
public enum NonArgAggregateOp {
    AVERAGE, CI0, CI1, COUNT, DISTINCT, MAX, MEAN, MEDIAN, MIN, MISSING, PRODUCT, Q1, Q3, STDERR, STDEV, STDEVP, SUM, VALID, VALUES, VARIANCE, VARIANCEP;

    @JsonValue
    public String toValue() {
        switch (this) {
            case AVERAGE: return "average";
            case CI0: return "ci0";
            case CI1: return "ci1";
            case COUNT: return "count";
            case DISTINCT: return "distinct";
            case MAX: return "max";
            case MEAN: return "mean";
            case MEDIAN: return "median";
            case MIN: return "min";
            case MISSING: return "missing";
            case PRODUCT: return "product";
            case Q1: return "q1";
            case Q3: return "q3";
            case STDERR: return "stderr";
            case STDEV: return "stdev";
            case STDEVP: return "stdevp";
            case SUM: return "sum";
            case VALID: return "valid";
            case VALUES: return "values";
            case VARIANCE: return "variance";
            case VARIANCEP: return "variancep";
        }
        return null;
    }

    @JsonCreator
    public static NonArgAggregateOp forValue(String value) throws IOException {
        if (value.equals("average")) return AVERAGE;
        if (value.equals("ci0")) return CI0;
        if (value.equals("ci1")) return CI1;
        if (value.equals("count")) return COUNT;
        if (value.equals("distinct")) return DISTINCT;
        if (value.equals("max")) return MAX;
        if (value.equals("mean")) return MEAN;
        if (value.equals("median")) return MEDIAN;
        if (value.equals("min")) return MIN;
        if (value.equals("missing")) return MISSING;
        if (value.equals("product")) return PRODUCT;
        if (value.equals("q1")) return Q1;
        if (value.equals("q3")) return Q3;
        if (value.equals("stderr")) return STDERR;
        if (value.equals("stdev")) return STDEV;
        if (value.equals("stdevp")) return STDEVP;
        if (value.equals("sum")) return SUM;
        if (value.equals("valid")) return VALID;
        if (value.equals("values")) return VALUES;
        if (value.equals("variance")) return VARIANCE;
        if (value.equals("variancep")) return VARIANCEP;
        throw new IOException("Cannot deserialize NonArgAggregateOp");
    }
}
