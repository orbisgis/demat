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
 * The window or aggregation operation to apply within a window (e.g., `"rank"`, `"lead"`,
 * `"sum"`, `"average"` or `"count"`). See the list of all supported operations
 * [here](https://vega.github.io/vega-lite/docs/window.html#ops).
 *
 * The aggregation operation to apply to the fields (e.g., `"sum"`, `"average"`, or
 * `"count"`). See the [full list of supported aggregation
 * operations](https://vega.github.io/vega-lite/docs/aggregate.html#ops) for more
 * information.
 *
 * The aggregation operation to apply (e.g., `"sum"`, `"average"` or `"count"`). See the
 * list of all supported operations
 * [here](https://vega.github.io/vega-lite/docs/aggregate.html#ops).
 */
public enum Op {
    ARGMAX, ARGMIN, AVERAGE, CI0, CI1, COUNT, CUME_DIST, DENSE_RANK, DISTINCT, FIRST_VALUE, LAG, LAST_VALUE, LEAD, MAX, MEAN, MEDIAN, MIN, MISSING, NTH_VALUE, NTILE, PERCENT_RANK, PRODUCT, Q1, Q3, RANK, ROW_NUMBER, STDERR, STDEV, STDEVP, SUM, VALID, VALUES, VARIANCE, VARIANCEP;

    @JsonValue
    public String toValue() {
        switch (this) {
            case ARGMAX: return "argmax";
            case ARGMIN: return "argmin";
            case AVERAGE: return "average";
            case CI0: return "ci0";
            case CI1: return "ci1";
            case COUNT: return "count";
            case CUME_DIST: return "cume_dist";
            case DENSE_RANK: return "dense_rank";
            case DISTINCT: return "distinct";
            case FIRST_VALUE: return "first_value";
            case LAG: return "lag";
            case LAST_VALUE: return "last_value";
            case LEAD: return "lead";
            case MAX: return "max";
            case MEAN: return "mean";
            case MEDIAN: return "median";
            case MIN: return "min";
            case MISSING: return "missing";
            case NTH_VALUE: return "nth_value";
            case NTILE: return "ntile";
            case PERCENT_RANK: return "percent_rank";
            case PRODUCT: return "product";
            case Q1: return "q1";
            case Q3: return "q3";
            case RANK: return "rank";
            case ROW_NUMBER: return "row_number";
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
    public static Op forValue(String value) throws IOException {
        if (value.equals("argmax")) return ARGMAX;
        if (value.equals("argmin")) return ARGMIN;
        if (value.equals("average")) return AVERAGE;
        if (value.equals("ci0")) return CI0;
        if (value.equals("ci1")) return CI1;
        if (value.equals("count")) return COUNT;
        if (value.equals("cume_dist")) return CUME_DIST;
        if (value.equals("dense_rank")) return DENSE_RANK;
        if (value.equals("distinct")) return DISTINCT;
        if (value.equals("first_value")) return FIRST_VALUE;
        if (value.equals("lag")) return LAG;
        if (value.equals("last_value")) return LAST_VALUE;
        if (value.equals("lead")) return LEAD;
        if (value.equals("max")) return MAX;
        if (value.equals("mean")) return MEAN;
        if (value.equals("median")) return MEDIAN;
        if (value.equals("min")) return MIN;
        if (value.equals("missing")) return MISSING;
        if (value.equals("nth_value")) return NTH_VALUE;
        if (value.equals("ntile")) return NTILE;
        if (value.equals("percent_rank")) return PERCENT_RANK;
        if (value.equals("product")) return PRODUCT;
        if (value.equals("q1")) return Q1;
        if (value.equals("q3")) return Q3;
        if (value.equals("rank")) return RANK;
        if (value.equals("row_number")) return ROW_NUMBER;
        if (value.equals("stderr")) return STDERR;
        if (value.equals("stdev")) return STDEV;
        if (value.equals("stdevp")) return STDEVP;
        if (value.equals("sum")) return SUM;
        if (value.equals("valid")) return VALID;
        if (value.equals("values")) return VALUES;
        if (value.equals("variance")) return VARIANCE;
        if (value.equals("variancep")) return VARIANCEP;
        throw new IOException("Cannot deserialize Op");
    }
}
