package org.orbisgis.demat.vega;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

/**
 * The type of scale. Vega-Lite supports the following categories of scale types:
 *
 * 1) [**Continuous Scales**](https://vega.github.io/vega-lite/docs/scale.html#continuous)
 * -- mapping continuous domains to continuous output ranges
 * ([`"linear"`](https://vega.github.io/vega-lite/docs/scale.html#linear),
 * [`"pow"`](https://vega.github.io/vega-lite/docs/scale.html#pow),
 * [`"sqrt"`](https://vega.github.io/vega-lite/docs/scale.html#sqrt),
 * [`"symlog"`](https://vega.github.io/vega-lite/docs/scale.html#symlog),
 * [`"log"`](https://vega.github.io/vega-lite/docs/scale.html#log),
 * [`"time"`](https://vega.github.io/vega-lite/docs/scale.html#time),
 * [`"utc"`](https://vega.github.io/vega-lite/docs/scale.html#utc).
 *
 * 2) [**Discrete Scales**](https://vega.github.io/vega-lite/docs/scale.html#discrete) --
 * mapping discrete domains to discrete
 * ([`"ordinal"`](https://vega.github.io/vega-lite/docs/scale.html#ordinal)) or continuous
 * ([`"band"`](https://vega.github.io/vega-lite/docs/scale.html#band) and
 * [`"point"`](https://vega.github.io/vega-lite/docs/scale.html#point)) output ranges.
 *
 * 3) [**Discretizing
 * Scales**](https://vega.github.io/vega-lite/docs/scale.html#discretizing) -- mapping
 * continuous domains to discrete output ranges
 * [`"bin-ordinal"`](https://vega.github.io/vega-lite/docs/scale.html#bin-ordinal),
 * [`"quantile"`](https://vega.github.io/vega-lite/docs/scale.html#quantile),
 * [`"quantize"`](https://vega.github.io/vega-lite/docs/scale.html#quantize) and
 * [`"threshold"`](https://vega.github.io/vega-lite/docs/scale.html#threshold).
 *
 * __Default value:__ please see the [scale type
 * table](https://vega.github.io/vega-lite/docs/scale.html#type).
 */
public enum ScaleType {
    BAND, BIN_ORDINAL, IDENTITY, LINEAR, LOG, ORDINAL, POINT, POW, QUANTILE, QUANTIZE, SEQUENTIAL, SQRT, SYMLOG, THRESHOLD, TIME, UTC;

    @JsonValue
    public String toValue() {
        switch (this) {
            case BAND: return "band";
            case BIN_ORDINAL: return "bin-ordinal";
            case IDENTITY: return "identity";
            case LINEAR: return "linear";
            case LOG: return "log";
            case ORDINAL: return "ordinal";
            case POINT: return "point";
            case POW: return "pow";
            case QUANTILE: return "quantile";
            case QUANTIZE: return "quantize";
            case SEQUENTIAL: return "sequential";
            case SQRT: return "sqrt";
            case SYMLOG: return "symlog";
            case THRESHOLD: return "threshold";
            case TIME: return "time";
            case UTC: return "utc";
        }
        return null;
    }

    @JsonCreator
    public static ScaleType forValue(String value) throws IOException {
        if (value.equals("band")) return BAND;
        if (value.equals("bin-ordinal")) return BIN_ORDINAL;
        if (value.equals("identity")) return IDENTITY;
        if (value.equals("linear")) return LINEAR;
        if (value.equals("log")) return LOG;
        if (value.equals("ordinal")) return ORDINAL;
        if (value.equals("point")) return POINT;
        if (value.equals("pow")) return POW;
        if (value.equals("quantile")) return QUANTILE;
        if (value.equals("quantize")) return QUANTIZE;
        if (value.equals("sequential")) return SEQUENTIAL;
        if (value.equals("sqrt")) return SQRT;
        if (value.equals("symlog")) return SYMLOG;
        if (value.equals("threshold")) return THRESHOLD;
        if (value.equals("time")) return TIME;
        if (value.equals("utc")) return UTC;
        throw new IOException("Cannot deserialize ScaleType");
    }
}
