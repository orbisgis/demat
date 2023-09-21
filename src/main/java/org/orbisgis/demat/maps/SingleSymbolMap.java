package org.orbisgis.demat.maps;

import org.orbisgis.demat.Chart;
import org.orbisgis.demat.vega.Domain;
import org.orbisgis.demat.vega.legend.LegendText;

import java.util.Arrays;
import java.util.List;

public class SingleSymbolMap extends Chart {


    public SingleSymbolMap domain(List<Object> values) {
        Domain domain = new Domain();
        domain.values = values;
        this.getEncoding().getColor().getScale().setDomain(domain);
        return this;
    }

    public SingleSymbolMap stroke(String color) {
        this.getMark().def.stroke(color);
        return this;
    }

    public SingleSymbolMap strokeWidth(double width) {
        this.getMark().def.strokeWidth(width);
        return this;
    }

    public SingleSymbolMap fill(String color) {
        this.getMark().def.fill(color);
        return this;
    }
}
