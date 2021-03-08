package org.orbisgis.demat.vega;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum TimeInterval {
    DAY, HOUR, MILLISECOND, MINUTE, MONTH, SECOND, WEEK, YEAR;

    @JsonValue
    public String toValue() {
        switch (this) {
            case DAY: return "day";
            case HOUR: return "hour";
            case MILLISECOND: return "millisecond";
            case MINUTE: return "minute";
            case MONTH: return "month";
            case SECOND: return "second";
            case WEEK: return "week";
            case YEAR: return "year";
        }
        return null;
    }

    @JsonCreator
    public static TimeInterval forValue(String value) throws IOException {
        if (value.equals("day")) return DAY;
        if (value.equals("hour")) return HOUR;
        if (value.equals("millisecond")) return MILLISECOND;
        if (value.equals("minute")) return MINUTE;
        if (value.equals("month")) return MONTH;
        if (value.equals("second")) return SECOND;
        if (value.equals("week")) return WEEK;
        if (value.equals("year")) return YEAR;
        throw new IOException("Cannot deserialize TimeInterval");
    }
}
