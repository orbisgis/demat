package org.orbisgis.demat.decoration;

import org.orbisgis.demat.Chart;
import org.orbisgis.demat.PlotUtils;
import org.orbisgis.demat.vega.CornerRadius;
import org.orbisgis.demat.vega.Def;
import org.orbisgis.demat.vega.Mark;
import org.orbisgis.demat.vega.TextDef;
import org.orbisgis.demat.vega.data.Data;
import org.orbisgis.demat.vega.data.DataValues;

import java.util.HashMap;

/**
 * A Text chart to manage text decoration on a chart
 */
public class Source extends Chart{

    public Source(){
        Mark mark = new Mark();
        Def def = new Def();
        def.setType("text");
        mark.def= def;
        this.setMark(mark);
        Data data = new Data();
        DataValues dataValues =  new DataValues();
        dataValues.anythingMapValue= new HashMap<>();
        data.setDataValues(dataValues);
        this.setData(data);
    }

    public Source text(String text){
        Def def = this.getMark().def;
        TextDef textDef =  new TextDef();
        textDef.value =text;
        def.setText(textDef);
        return this;
    }

    public Source dx(double value){
        Def def = this.getMark().def;
        CornerRadius dx = new CornerRadius();
        dx.value=value;
        def.setDx(dx);
        return this;
    }

    public Source dy(double value){
        Def def = this.getMark().def;
        CornerRadius dy = new CornerRadius();
        dy.value=value;
        def.setDy(dy);
        return this;
    }

}
