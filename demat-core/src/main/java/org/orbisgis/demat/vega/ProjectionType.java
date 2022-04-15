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
 * The cartographic projection to use. This value is case-insensitive, for example
 * `"albers"` and `"Albers"` indicate the same projection type. You can find all valid
 * projection types [in the
 * documentation](https://vega.github.io/vega-lite/docs/projection.html#projection-types).
 *
 * __Default value:__ `mercator`
 */
public enum ProjectionType {
    ALBERS, ALBERS_USA, AZIMUTHAL_EQUAL_AREA, AZIMUTHAL_EQUIDISTANT, CONIC_CONFORMAL, CONIC_EQUAL_AREA, CONIC_EQUIDISTANT, EQUAL_EARTH, EQUIRECTANGULAR, GNOMONIC, IDENTITY, MERCATOR, NATURAL_EARTH1, ORTHOGRAPHIC, STEREOGRAPHIC, TRANSVERSE_MERCATOR;

    @JsonValue
    public String toValue() {
        switch (this) {
            case ALBERS: return "albers";
            case ALBERS_USA: return "albersUsa";
            case AZIMUTHAL_EQUAL_AREA: return "azimuthalEqualArea";
            case AZIMUTHAL_EQUIDISTANT: return "azimuthalEquidistant";
            case CONIC_CONFORMAL: return "conicConformal";
            case CONIC_EQUAL_AREA: return "conicEqualArea";
            case CONIC_EQUIDISTANT: return "conicEquidistant";
            case EQUAL_EARTH: return "equalEarth";
            case EQUIRECTANGULAR: return "equirectangular";
            case GNOMONIC: return "gnomonic";
            case IDENTITY: return "identity";
            case MERCATOR: return "mercator";
            case NATURAL_EARTH1: return "naturalEarth1";
            case ORTHOGRAPHIC: return "orthographic";
            case STEREOGRAPHIC: return "stereographic";
            case TRANSVERSE_MERCATOR: return "transverseMercator";
        }
        return null;
    }

    @JsonCreator
    public static ProjectionType forValue(String value) throws IOException {
        if (value.equals("albers")) return ALBERS;
        if (value.equals("albersUsa")) return ALBERS_USA;
        if (value.equals("azimuthalEqualArea")) return AZIMUTHAL_EQUAL_AREA;
        if (value.equals("azimuthalEquidistant")) return AZIMUTHAL_EQUIDISTANT;
        if (value.equals("conicConformal")) return CONIC_CONFORMAL;
        if (value.equals("conicEqualArea")) return CONIC_EQUAL_AREA;
        if (value.equals("conicEquidistant")) return CONIC_EQUIDISTANT;
        if (value.equals("equalEarth")) return EQUAL_EARTH;
        if (value.equals("equirectangular")) return EQUIRECTANGULAR;
        if (value.equals("gnomonic")) return GNOMONIC;
        if (value.equals("identity")) return IDENTITY;
        if (value.equals("mercator")) return MERCATOR;
        if (value.equals("naturalEarth1")) return NATURAL_EARTH1;
        if (value.equals("orthographic")) return ORTHOGRAPHIC;
        if (value.equals("stereographic")) return STEREOGRAPHIC;
        if (value.equals("transverseMercator")) return TRANSVERSE_MERCATOR;
        throw new IOException("Cannot deserialize ProjectionType");
    }
}
