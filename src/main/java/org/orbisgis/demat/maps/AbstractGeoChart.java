package org.orbisgis.demat.maps;

import org.orbisgis.demat.Chart;
import org.orbisgis.demat.vega.Domain;
import org.orbisgis.demat.vega.LegendText;
import org.orbisgis.demat.vega.Scheme;

import java.util.List;

public class AbstractGeoChart<T extends Chart> extends Chart {


    public T field(String field) {
        this.getEncoding().getColor().setField(field);
        return (T) this;
    }

    public T legend(String title) {
        LegendText legendText = new LegendText();
        legendText.stringValue = title;
        this.getEncoding().getColor().setTitle(legendText);
        return (T) this;
    }

    public T domain(List<Object> values) {
        Domain domain = new Domain();
        domain.values = values;
        this.getEncoding().getColor().getScale().setDomain(domain);
        return (T) this;
    }

    public T scheme(String value) {
        Scheme scheme = new Scheme();
        scheme.value = value;
        this.getEncoding().getColor().getScale().setScheme(scheme);
        return (T) this;
    }

    @Override
    public T filter(String expression) {
        return (T) super.filter(expression);
    }

    public T reflectY() {
        this.getProjection().setReflectY(true);
        return (T) this;
    }

    public T reflectX() {
        this.getProjection().setReflectX(true);
        return (T) this;
    }
}
