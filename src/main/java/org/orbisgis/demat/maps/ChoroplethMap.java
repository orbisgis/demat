package org.orbisgis.demat.maps;

import org.orbisgis.demat.vega.ScaleType;

/**
 * Class to create a choropleth map
 */
public class ChoroplethMap extends AbstractGeoChart<ChoroplethMap> {

    public ChoroplethMap field(String field, ScaleType method) {
        this.getEncoding().getColor().setField(field);
        this.getEncoding().getColor().getScale().setType(method);
        return this;
    }

    ChoroplethMap quantile(){
        this.getEncoding().getColor().getScale().quantile();
        return this;
    }
}
