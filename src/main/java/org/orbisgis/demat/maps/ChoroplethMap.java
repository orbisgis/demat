package org.orbisgis.demat.maps;

import org.orbisgis.demat.vega.ScaleType;

public class ChoroplethMap extends AbstractGeoChart<ChoroplethMap> {


    public ChoroplethMap field(String field, ScaleType method) {
        this.getEncoding().getColor().setField(field);
        return this;
    }
}
