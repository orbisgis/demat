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
