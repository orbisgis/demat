package org.orbisgis.demat.maps;

import org.orbisgis.demat.Chart;
import org.orbisgis.demat.vega.Domain;
import org.orbisgis.demat.vega.ProjectionType;
import org.orbisgis.demat.vega.ScaleRange;
import org.orbisgis.demat.vega.Scheme;
import org.orbisgis.demat.vega.legend.LegendText;

import java.util.Arrays;
import java.util.List;

/**
 * Abstract class to manage map chart
 * @param <T>
 */
public class AbstractGeoChart<T extends Chart> extends Chart {


    public T range(Object... elements) {
        this.getEncoding().getColor().getScale().setRange(ScaleRange.build(elements));
        return (T) this;
    }

    public T field(String field) {
        this.getEncoding().getColor().setField(field);
        return (T) this;
    }

    public T legend(List titles) {
        LegendText legendText = new LegendText();
        legendText.titles = titles;
        this.getEncoding().getColor().setTitle(legendText);
        return (T) this;
    }

    public T legend(String... title) {
        LegendText legendText = new LegendText();
        legendText.titles = Arrays.asList(title);
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

    @Override
    public T calculate(String expression, String alias) {
        return (T) super.calculate(expression, alias);
    }

    public T reflectY() {
        this.getProjection().setReflectY(true);
        return (T) this;
    }

    public T reflectX() {
        this.getProjection().setReflectX(true);
        return (T) this;
    }

    public T projection_identity() {
        this.getProjection().setType(ProjectionType.IDENTITY);
        return (T) this;
    }
    /**
     * Change the labels of the legend
     * @param labels
     */
    public T labels(String labels) {
        this.getEncoding().getColor().getLegend().setLabelExpr(labels);
        return (T) this;
    }

}
