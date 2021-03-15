/*
 * DEMAT is java wrapper on top of the vega-lite library
 *
 * Demat is breton word to said "Hello".
 *
 * DEMAT is part of the OrbisGIS platform.
 *
 * OrbisGIS platform is a set of open source tools to access, process, display
 * and share geographical informations.
 *
 * It is leaded by CNRS within the French Lab-STICC laboratory <http://www.lab-sticc.fr/>,
 * DECIDE team of Vannes.
 *
 * OrbisGIS is dedicated to research in GIScience.
 *
 * The GIS group of the DECIDE team is located at :
 *
 * Laboratoire Lab-STICC – CNRS UMR 6285
 * Equipe DECIDE
 * UNIVERSITÉ DE BRETAGNE-SUD
 * Institut Universitaire de Technologie de Vannes
 * 8, Rue Montaigne - BP 561 56017 Vannes Cedex
 *
 * DEMAT is distributed under LGPL 3 license.
 *
 * Copyright (C) 2021 CNRS (Lab-STICC UMR CNRS 6285)
 *
 *
 * DEMAT is free software: you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * DEMAT is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * DEMAT. If not, see <http://www.gnu.org/licenses/>.
 *
 * For more information, please consult: <http://www.orbisgis.org/>
 * or contact directly:
 * info_at_ orbisgis.org
 */
package org.orbisgis.demat.vega;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

/**
 * Defines how date-time values should be binned.
 */
public enum TimeUnit {
    DATE, DAY, DAYHOURS, DAYHOURSMINUTES, DAYHOURSMINUTESSECONDS, DAYOFYEAR, HOURS, HOURSMINUTES, HOURSMINUTESSECONDS, MILLISECONDS, MINUTES, MINUTESSECONDS, MONTH, MONTHDATE, MONTHDATEHOURS, MONTHDATEHOURSMINUTES, MONTHDATEHOURSMINUTESSECONDS, QUARTER, QUARTERMONTH, SECONDS, SECONDSMILLISECONDS, UTCDATE, UTCDAY, UTCDAYHOURS, UTCDAYHOURSMINUTES, UTCDAYHOURSMINUTESSECONDS, UTCDAYOFYEAR, UTCHOURS, UTCHOURSMINUTES, UTCHOURSMINUTESSECONDS, UTCMILLISECONDS, UTCMINUTES, UTCMINUTESSECONDS, UTCMONTH, UTCMONTHDATE, UTCMONTHDATEHOURS, UTCMONTHDATEHOURSMINUTES, UTCMONTHDATEHOURSMINUTESSECONDS, UTCQUARTER, UTCQUARTERMONTH, UTCSECONDS, UTCSECONDSMILLISECONDS, UTCWEEK, UTCWEEKDAY, UTCWEEKDAYHOURSMINUTES, UTCWEEKDAYHOURSMINUTESSECONDS, UTCWEEKSDAYHOURS, UTCYEAR, UTCYEARDAYOFYEAR, UTCYEARMONTH, UTCYEARMONTHDATE, UTCYEARMONTHDATEHOURS, UTCYEARMONTHDATEHOURSMINUTES, UTCYEARMONTHDATEHOURSMINUTESSECONDS, UTCYEARQUARTER, UTCYEARQUARTERMONTH, UTCYEARWEEK, UTCYEARWEEKDAY, UTCYEARWEEKDAYHOURS, UTCYEARWEEKDAYHOURSMINUTES, UTCYEARWEEKDAYHOURSMINUTESSECONDS, WEEK, WEEKDAY, WEEKDAYHOURSMINUTES, WEEKDAYHOURSMINUTESSECONDS, WEEKSDAYHOURS, YEAR, YEARDAYOFYEAR, YEARMONTH, YEARMONTHDATE, YEARMONTHDATEHOURS, YEARMONTHDATEHOURSMINUTES, YEARMONTHDATEHOURSMINUTESSECONDS, YEARQUARTER, YEARQUARTERMONTH, YEARWEEK, YEARWEEKDAY, YEARWEEKDAYHOURS, YEARWEEKDAYHOURSMINUTES, YEARWEEKDAYHOURSMINUTESSECONDS;

    @JsonValue
    public String toValue() {
        switch (this) {
            case DATE: return "date";
            case DAY: return "day";
            case DAYHOURS: return "dayhours";
            case DAYHOURSMINUTES: return "dayhoursminutes";
            case DAYHOURSMINUTESSECONDS: return "dayhoursminutesseconds";
            case DAYOFYEAR: return "dayofyear";
            case HOURS: return "hours";
            case HOURSMINUTES: return "hoursminutes";
            case HOURSMINUTESSECONDS: return "hoursminutesseconds";
            case MILLISECONDS: return "milliseconds";
            case MINUTES: return "minutes";
            case MINUTESSECONDS: return "minutesseconds";
            case MONTH: return "month";
            case MONTHDATE: return "monthdate";
            case MONTHDATEHOURS: return "monthdatehours";
            case MONTHDATEHOURSMINUTES: return "monthdatehoursminutes";
            case MONTHDATEHOURSMINUTESSECONDS: return "monthdatehoursminutesseconds";
            case QUARTER: return "quarter";
            case QUARTERMONTH: return "quartermonth";
            case SECONDS: return "seconds";
            case SECONDSMILLISECONDS: return "secondsmilliseconds";
            case UTCDATE: return "utcdate";
            case UTCDAY: return "utcday";
            case UTCDAYHOURS: return "utcdayhours";
            case UTCDAYHOURSMINUTES: return "utcdayhoursminutes";
            case UTCDAYHOURSMINUTESSECONDS: return "utcdayhoursminutesseconds";
            case UTCDAYOFYEAR: return "utcdayofyear";
            case UTCHOURS: return "utchours";
            case UTCHOURSMINUTES: return "utchoursminutes";
            case UTCHOURSMINUTESSECONDS: return "utchoursminutesseconds";
            case UTCMILLISECONDS: return "utcmilliseconds";
            case UTCMINUTES: return "utcminutes";
            case UTCMINUTESSECONDS: return "utcminutesseconds";
            case UTCMONTH: return "utcmonth";
            case UTCMONTHDATE: return "utcmonthdate";
            case UTCMONTHDATEHOURS: return "utcmonthdatehours";
            case UTCMONTHDATEHOURSMINUTES: return "utcmonthdatehoursminutes";
            case UTCMONTHDATEHOURSMINUTESSECONDS: return "utcmonthdatehoursminutesseconds";
            case UTCQUARTER: return "utcquarter";
            case UTCQUARTERMONTH: return "utcquartermonth";
            case UTCSECONDS: return "utcseconds";
            case UTCSECONDSMILLISECONDS: return "utcsecondsmilliseconds";
            case UTCWEEK: return "utcweek";
            case UTCWEEKDAY: return "utcweekday";
            case UTCWEEKDAYHOURSMINUTES: return "utcweekdayhoursminutes";
            case UTCWEEKDAYHOURSMINUTESSECONDS: return "utcweekdayhoursminutesseconds";
            case UTCWEEKSDAYHOURS: return "utcweeksdayhours";
            case UTCYEAR: return "utcyear";
            case UTCYEARDAYOFYEAR: return "utcyeardayofyear";
            case UTCYEARMONTH: return "utcyearmonth";
            case UTCYEARMONTHDATE: return "utcyearmonthdate";
            case UTCYEARMONTHDATEHOURS: return "utcyearmonthdatehours";
            case UTCYEARMONTHDATEHOURSMINUTES: return "utcyearmonthdatehoursminutes";
            case UTCYEARMONTHDATEHOURSMINUTESSECONDS: return "utcyearmonthdatehoursminutesseconds";
            case UTCYEARQUARTER: return "utcyearquarter";
            case UTCYEARQUARTERMONTH: return "utcyearquartermonth";
            case UTCYEARWEEK: return "utcyearweek";
            case UTCYEARWEEKDAY: return "utcyearweekday";
            case UTCYEARWEEKDAYHOURS: return "utcyearweekdayhours";
            case UTCYEARWEEKDAYHOURSMINUTES: return "utcyearweekdayhoursminutes";
            case UTCYEARWEEKDAYHOURSMINUTESSECONDS: return "utcyearweekdayhoursminutesseconds";
            case WEEK: return "week";
            case WEEKDAY: return "weekday";
            case WEEKDAYHOURSMINUTES: return "weekdayhoursminutes";
            case WEEKDAYHOURSMINUTESSECONDS: return "weekdayhoursminutesseconds";
            case WEEKSDAYHOURS: return "weeksdayhours";
            case YEAR: return "year";
            case YEARDAYOFYEAR: return "yeardayofyear";
            case YEARMONTH: return "yearmonth";
            case YEARMONTHDATE: return "yearmonthdate";
            case YEARMONTHDATEHOURS: return "yearmonthdatehours";
            case YEARMONTHDATEHOURSMINUTES: return "yearmonthdatehoursminutes";
            case YEARMONTHDATEHOURSMINUTESSECONDS: return "yearmonthdatehoursminutesseconds";
            case YEARQUARTER: return "yearquarter";
            case YEARQUARTERMONTH: return "yearquartermonth";
            case YEARWEEK: return "yearweek";
            case YEARWEEKDAY: return "yearweekday";
            case YEARWEEKDAYHOURS: return "yearweekdayhours";
            case YEARWEEKDAYHOURSMINUTES: return "yearweekdayhoursminutes";
            case YEARWEEKDAYHOURSMINUTESSECONDS: return "yearweekdayhoursminutesseconds";
        }
        return null;
    }

    @JsonCreator
    public static TimeUnit forValue(String value) throws IOException {
        if (value.equals("date")) return DATE;
        if (value.equals("day")) return DAY;
        if (value.equals("dayhours")) return DAYHOURS;
        if (value.equals("dayhoursminutes")) return DAYHOURSMINUTES;
        if (value.equals("dayhoursminutesseconds")) return DAYHOURSMINUTESSECONDS;
        if (value.equals("dayofyear")) return DAYOFYEAR;
        if (value.equals("hours")) return HOURS;
        if (value.equals("hoursminutes")) return HOURSMINUTES;
        if (value.equals("hoursminutesseconds")) return HOURSMINUTESSECONDS;
        if (value.equals("milliseconds")) return MILLISECONDS;
        if (value.equals("minutes")) return MINUTES;
        if (value.equals("minutesseconds")) return MINUTESSECONDS;
        if (value.equals("month")) return MONTH;
        if (value.equals("monthdate")) return MONTHDATE;
        if (value.equals("monthdatehours")) return MONTHDATEHOURS;
        if (value.equals("monthdatehoursminutes")) return MONTHDATEHOURSMINUTES;
        if (value.equals("monthdatehoursminutesseconds")) return MONTHDATEHOURSMINUTESSECONDS;
        if (value.equals("quarter")) return QUARTER;
        if (value.equals("quartermonth")) return QUARTERMONTH;
        if (value.equals("seconds")) return SECONDS;
        if (value.equals("secondsmilliseconds")) return SECONDSMILLISECONDS;
        if (value.equals("utcdate")) return UTCDATE;
        if (value.equals("utcday")) return UTCDAY;
        if (value.equals("utcdayhours")) return UTCDAYHOURS;
        if (value.equals("utcdayhoursminutes")) return UTCDAYHOURSMINUTES;
        if (value.equals("utcdayhoursminutesseconds")) return UTCDAYHOURSMINUTESSECONDS;
        if (value.equals("utcdayofyear")) return UTCDAYOFYEAR;
        if (value.equals("utchours")) return UTCHOURS;
        if (value.equals("utchoursminutes")) return UTCHOURSMINUTES;
        if (value.equals("utchoursminutesseconds")) return UTCHOURSMINUTESSECONDS;
        if (value.equals("utcmilliseconds")) return UTCMILLISECONDS;
        if (value.equals("utcminutes")) return UTCMINUTES;
        if (value.equals("utcminutesseconds")) return UTCMINUTESSECONDS;
        if (value.equals("utcmonth")) return UTCMONTH;
        if (value.equals("utcmonthdate")) return UTCMONTHDATE;
        if (value.equals("utcmonthdatehours")) return UTCMONTHDATEHOURS;
        if (value.equals("utcmonthdatehoursminutes")) return UTCMONTHDATEHOURSMINUTES;
        if (value.equals("utcmonthdatehoursminutesseconds")) return UTCMONTHDATEHOURSMINUTESSECONDS;
        if (value.equals("utcquarter")) return UTCQUARTER;
        if (value.equals("utcquartermonth")) return UTCQUARTERMONTH;
        if (value.equals("utcseconds")) return UTCSECONDS;
        if (value.equals("utcsecondsmilliseconds")) return UTCSECONDSMILLISECONDS;
        if (value.equals("utcweek")) return UTCWEEK;
        if (value.equals("utcweekday")) return UTCWEEKDAY;
        if (value.equals("utcweekdayhoursminutes")) return UTCWEEKDAYHOURSMINUTES;
        if (value.equals("utcweekdayhoursminutesseconds")) return UTCWEEKDAYHOURSMINUTESSECONDS;
        if (value.equals("utcweeksdayhours")) return UTCWEEKSDAYHOURS;
        if (value.equals("utcyear")) return UTCYEAR;
        if (value.equals("utcyeardayofyear")) return UTCYEARDAYOFYEAR;
        if (value.equals("utcyearmonth")) return UTCYEARMONTH;
        if (value.equals("utcyearmonthdate")) return UTCYEARMONTHDATE;
        if (value.equals("utcyearmonthdatehours")) return UTCYEARMONTHDATEHOURS;
        if (value.equals("utcyearmonthdatehoursminutes")) return UTCYEARMONTHDATEHOURSMINUTES;
        if (value.equals("utcyearmonthdatehoursminutesseconds")) return UTCYEARMONTHDATEHOURSMINUTESSECONDS;
        if (value.equals("utcyearquarter")) return UTCYEARQUARTER;
        if (value.equals("utcyearquartermonth")) return UTCYEARQUARTERMONTH;
        if (value.equals("utcyearweek")) return UTCYEARWEEK;
        if (value.equals("utcyearweekday")) return UTCYEARWEEKDAY;
        if (value.equals("utcyearweekdayhours")) return UTCYEARWEEKDAYHOURS;
        if (value.equals("utcyearweekdayhoursminutes")) return UTCYEARWEEKDAYHOURSMINUTES;
        if (value.equals("utcyearweekdayhoursminutesseconds")) return UTCYEARWEEKDAYHOURSMINUTESSECONDS;
        if (value.equals("week")) return WEEK;
        if (value.equals("weekday")) return WEEKDAY;
        if (value.equals("weekdayhoursminutes")) return WEEKDAYHOURSMINUTES;
        if (value.equals("weekdayhoursminutesseconds")) return WEEKDAYHOURSMINUTESSECONDS;
        if (value.equals("weeksdayhours")) return WEEKSDAYHOURS;
        if (value.equals("year")) return YEAR;
        if (value.equals("yeardayofyear")) return YEARDAYOFYEAR;
        if (value.equals("yearmonth")) return YEARMONTH;
        if (value.equals("yearmonthdate")) return YEARMONTHDATE;
        if (value.equals("yearmonthdatehours")) return YEARMONTHDATEHOURS;
        if (value.equals("yearmonthdatehoursminutes")) return YEARMONTHDATEHOURSMINUTES;
        if (value.equals("yearmonthdatehoursminutesseconds")) return YEARMONTHDATEHOURSMINUTESSECONDS;
        if (value.equals("yearquarter")) return YEARQUARTER;
        if (value.equals("yearquartermonth")) return YEARQUARTERMONTH;
        if (value.equals("yearweek")) return YEARWEEK;
        if (value.equals("yearweekday")) return YEARWEEKDAY;
        if (value.equals("yearweekdayhours")) return YEARWEEKDAYHOURS;
        if (value.equals("yearweekdayhoursminutes")) return YEARWEEKDAYHOURSMINUTES;
        if (value.equals("yearweekdayhoursminutesseconds")) return YEARWEEKDAYHOURSMINUTESSECONDS;
        throw new IOException("Cannot deserialize TimeUnit");
    }
}
