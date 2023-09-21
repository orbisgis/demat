package org.orbisgis.demat.maps;

import org.orbisgis.demat.vega.ScaleRange;

public class UniqueValuesMap extends AbstractGeoChart<UniqueValuesMap> {

    public UniqueValuesMap range(Object... elements) {
        this.getEncoding().getColor().getScale().setRange(ScaleRange.build(elements));
        return this;
    }
}
