package org.orbisgis.demat;

import org.orbisgis.demat.vega.Filter;
import org.orbisgis.demat.vega.Height;
import org.orbisgis.demat.vega.Title;
import org.orbisgis.demat.vega.transform.Transform;
import org.orbisgis.demat.vega.legend.LegendText;

import java.util.ArrayList;
import java.util.List;

public interface ViewCommonMethods<T> {


    default T description(String description) {
        if (this instanceof Plot) {
            ((Plot) this).view.setDescription(description);
        } else if (this instanceof Chart) {
            ((Chart) this).setDescription(description);
        }
        return (T) this;
    }

    default T name(String name) {
        if (this instanceof Plot) {
            ((Plot) this).view.setName(name);
        } else if (this instanceof Chart) {
            ((Chart) this).setName(name);
        }
        return (T) this;
    }

    /**
     * Set height to the plot or chart
     *
     * @param height
     * @return
     */
    default T height(double height) {
        Height height_ = new Height();
        height_.size = height;
        if (this instanceof Plot) {
            ((Plot) this).view.setHeight(height_);
        } else if (this instanceof Chart) {
            ((Chart) this).setHeight(height_);
        }
        return (T) this;
    }

    /**
     * Set width to the plot or chart
     *
     * @param width
     * @return
     */
    default T width(double width) {
        Height height_ = new Height();
        height_.size = width;
        if (this instanceof Plot) {
            ((Plot) this).view.setWidth(height_);
        } else if (this instanceof Chart) {
            ((Chart) this).setWidth(height_);
        }
        return (T) this;
    }

    default T title(List titles) {
        Title title = new Title();
        title.titles = titles;
        if (this instanceof Plot) {
            ((Plot) this).view.setTitle(title);
        } else if (this instanceof Chart) {
            ((Chart) this).setTitle(title);
        }
        return (T) this;
    }

    default T title(String title) {
        Title title_ = new Title();
        title_.title = title;
        if (this instanceof Plot) {
            ((Plot) this).view.setTitle(title_);
        } else if (this instanceof Chart) {
            ((Chart) this).setTitle(title_);
        }
        return (T) this;
    }

    default T filter(String expression) {
        if (this instanceof Plot) {
            Plot plot = ((Plot) this);
            List<Transform> trans_ = plot.view.getTransform();
            if (trans_ == null) {
                trans_ = new ArrayList<>();
            }
            Transform transform = new Transform();
            Filter filter = new Filter();
            filter.expression = expression;
            transform.setFilter(filter);
            trans_.add(transform);
            plot.view.setTransform(trans_);
        } else if (this instanceof Chart) {
            Chart chart = ((Chart) this);
            List<Transform> trans_ = chart.getTransform();
            if (trans_ == null) {
                trans_ = new ArrayList<>();
            }
            Transform transform = new Transform();
            Filter filter = new Filter();
            filter.expression = expression;
            transform.setFilter(filter);
            trans_.add(transform);
            chart.setTransform(trans_);
        }
        return (T) this;
    }

    default T calculate(String expression, String alias) {
        if (this instanceof Plot) {
            Plot plot = ((Plot) this);
            List<Transform> trans_ = plot.view.getTransform();
            if (trans_ == null) {
                trans_ = new ArrayList<>();
            }
            Transform transform = new Transform();
            transform.setCalculate(expression);
            LegendText legendText = new LegendText();
            legendText.title = alias;
            transform.setAs(legendText);
            trans_.add(transform);
            plot.view.setTransform(trans_);
        } else if (this instanceof Chart) {
            Chart chart = ((Chart) this);
            List<Transform> trans_ = chart.getTransform();
            if (trans_ == null) {
                trans_ = new ArrayList<>();
            }
            Transform transform = new Transform();
            transform.setCalculate(expression);
            LegendText legendText = new LegendText();
            legendText.title = alias;
            transform.setAs(legendText);
            trans_.add(transform);
            chart.setTransform(trans_);
        }
        return (T) this;
    }
}
