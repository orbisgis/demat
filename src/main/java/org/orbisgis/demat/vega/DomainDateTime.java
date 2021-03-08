package org.orbisgis.demat.vega;

import com.fasterxml.jackson.annotation.*;

/**
 * Object for defining datetime in Vega-Lite Filter. If both month and quarter are provided,
 * month has higher precedence. `day` cannot be combined with other date. We accept string
 * for month and day names.
 */
public class DomainDateTime {
    private Double date;
    private Day day;
    private Double hours;
    private Double milliseconds;
    private Double minutes;
    private Month month;
    private Double quarter;
    private Double seconds;
    private Boolean utc;
    private Double year;
    private String expr;

    /**
     * Integer value representing the date (day of the month) from 1-31.
     */
    @JsonProperty("date")
    public Double getDate() { return date; }
    @JsonProperty("date")
    public void setDate(Double value) { this.date = value; }

    /**
     * Value representing the day of a week. This can be one of: (1) integer value -- `1`
     * represents Monday; (2) case-insensitive day name (e.g., `"Monday"`); (3)
     * case-insensitive, 3-character short day name (e.g., `"Mon"`).
     *
     * **Warning:** A DateTime definition object with `day`** should not be combined with
     * `year`, `quarter`, `month`, or `date`.
     */
    @JsonProperty("day")
    public Day getDay() { return day; }
    @JsonProperty("day")
    public void setDay(Day value) { this.day = value; }

    /**
     * Integer value representing the hour of a day from 0-23.
     */
    @JsonProperty("hours")
    public Double getHours() { return hours; }
    @JsonProperty("hours")
    public void setHours(Double value) { this.hours = value; }

    /**
     * Integer value representing the millisecond segment of time.
     */
    @JsonProperty("milliseconds")
    public Double getMilliseconds() { return milliseconds; }
    @JsonProperty("milliseconds")
    public void setMilliseconds(Double value) { this.milliseconds = value; }

    /**
     * Integer value representing the minute segment of time from 0-59.
     */
    @JsonProperty("minutes")
    public Double getMinutes() { return minutes; }
    @JsonProperty("minutes")
    public void setMinutes(Double value) { this.minutes = value; }

    /**
     * One of: (1) integer value representing the month from `1`-`12`. `1` represents January;
     * (2) case-insensitive month name (e.g., `"January"`); (3) case-insensitive, 3-character
     * short month name (e.g., `"Jan"`).
     */
    @JsonProperty("month")
    public Month getMonth() { return month; }
    @JsonProperty("month")
    public void setMonth(Month value) { this.month = value; }

    /**
     * Integer value representing the quarter of the year (from 1-4).
     */
    @JsonProperty("quarter")
    public Double getQuarter() { return quarter; }
    @JsonProperty("quarter")
    public void setQuarter(Double value) { this.quarter = value; }

    /**
     * Integer value representing the second segment (0-59) of a time value
     */
    @JsonProperty("seconds")
    public Double getSeconds() { return seconds; }
    @JsonProperty("seconds")
    public void setSeconds(Double value) { this.seconds = value; }

    /**
     * A boolean flag indicating if date time is in utc time. If false, the date time is in
     * local time
     */
    @JsonProperty("utc")
    public Boolean getUTC() { return utc; }
    @JsonProperty("utc")
    public void setUTC(Boolean value) { this.utc = value; }

    /**
     * Integer value representing the year.
     */
    @JsonProperty("year")
    public Double getYear() { return year; }
    @JsonProperty("year")
    public void setYear(Double value) { this.year = value; }

    /**
     * Vega expression (which can refer to Vega-Lite parameters).
     */
    @JsonProperty("expr")
    public String getExpr() { return expr; }
    @JsonProperty("expr")
    public void setExpr(String value) { this.expr = value; }
}
