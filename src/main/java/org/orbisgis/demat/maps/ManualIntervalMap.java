package org.orbisgis.demat.maps;

import org.orbisgis.demat.vega.ScaleRange;

public class ManualIntervalMap extends AbstractGeoChart<ManualIntervalMap> {

    public ManualIntervalMap range(Object... elements) {
        this.getEncoding().getColor().getScale().setRange(ScaleRange.build(elements));
        return this;
    }
}
