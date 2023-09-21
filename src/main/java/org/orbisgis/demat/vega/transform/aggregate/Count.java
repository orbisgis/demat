package org.orbisgis.demat.vega.transform.aggregate;

import org.orbisgis.demat.vega.transform.AggregateOp;
import org.orbisgis.demat.vega.transform.AggregatedFieldDef;

public class Count extends AggregatedFieldDef {

    public Count(String asField){
        this.setOp(AggregateOp.COUNT);
        this.setAs(asField);
    }
}
