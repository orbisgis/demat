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
