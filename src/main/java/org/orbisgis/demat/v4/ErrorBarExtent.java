package org.orbisgis.demat.v4;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

/**
 * The extent of the band. Available options include: - `"ci"`: Extend the band to the
 * confidence interval of the mean. - `"stderr"`: The size of band are set to the value of
 * standard error, extending from the mean. - `"stdev"`: The size of band are set to the
 * value of standard deviation, extending from the mean. - `"iqr"`: Extend the band to the
 * q1 and q3.
 *
 * __Default value:__ `"stderr"`.
 *
 * The extent of the rule. Available options include: - `"ci"`: Extend the rule to the
 * confidence interval of the mean. - `"stderr"`: The size of rule are set to the value of
 * standard error, extending from the mean. - `"stdev"`: The size of rule are set to the
 * value of standard deviation, extending from the mean. - `"iqr"`: Extend the rule to the
 * q1 and q3.
 *
 * __Default value:__ `"stderr"`.
 */
public enum ErrorBarExtent {
    CI, IQR, STDERR, STDEV;

    @JsonValue
    public String toValue() {
        switch (this) {
            case CI: return "ci";
            case IQR: return "iqr";
            case STDERR: return "stderr";
            case STDEV: return "stdev";
        }
        return null;
    }

    @JsonCreator
    public static ErrorBarExtent forValue(String value) throws IOException {
        if (value.equals("ci")) return CI;
        if (value.equals("iqr")) return IQR;
        if (value.equals("stderr")) return STDERR;
        if (value.equals("stdev")) return STDEV;
        throw new IOException("Cannot deserialize ErrorBarExtent");
    }
}
