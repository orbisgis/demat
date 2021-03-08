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
