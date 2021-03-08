package org.orbisgis.demat

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInfo
import org.orbisgis.demat.vega.*;

class GroovyDematTest {



    @Test
    void testSimpleBarChart(TestInfo testInfo){
        View plot = Demat.view().data([
                ["a": "A", "b": 28], ["a": "B", "b": 55], ["a": "C", "b": 43],
                ["a": "D", "b": 91], ["a": "E", "b": 81], ["a": "F", "b": 53],
                ["a": "G", "b": 19], ["a": "H", "b": 87], ["a": "I", "b": 52] ]).mark_bar().
                encoding(Demat.X("a").nominal(),Demat.Y("b").quantitative() )
        plot.save("target/${testInfo.displayName}.html",true)
    }

    @Test
    void testResponsiveBarChart(TestInfo testInfo){
        def plot =  Demat.view().data(Demat.toData(getClass().getClassLoader().getResourceAsStream("cars.json"))).mark_bar()
                .encoding(Demat.X("Origin"), Demat.Y().count())
        plot.save("target/${testInfo.displayName}.html",true)
    }

    @Test
    void testDisplayMap (TestInfo testInfo){
        def geojson = Demat.fromJson(getClass().getClassLoader().getResourceAsStream("rsu_geoindicators.geojson"))
        View plot = Demat.view().data(geojson).height(500).width(500).mark_geoshape();
        plot.save("target/${testInfo.displayName}.html",true)
    }

    @Test
    void testDisplayMapWithCustomMark (TestInfo testInfo){
        def geojson = Demat.fromJson(getClass().getClassLoader().getResourceAsStream("rsu_geoindicators.geojson"))
        Mark mark= new Mark();
        Def definition = new Def();
        definition.type="geoshape"
        MarkFill markFillDef = new MarkFill()
        markFillDef.stringValue="#eee"
        definition.fill=markFillDef
        MarkStroke markStrokeDef= new MarkStroke();
        markStrokeDef.stringValue="#757575"
        definition.stroke=markStrokeDef
        mark.defValue=definition
        View plot = Demat.view().data(geojson).height(500).width(500).mark(mark)
        plot.save("target/${testInfo.displayName}.html",true)
    }

    @Test
    void testDisplayMapWithInterval (TestInfo testInfo) throws IOException {
        def geojson = Demat.fromJson(getClass().getClassLoader().getResourceAsStream("rsu_geoindicators.geojson"));
        Scale scale = new Scale();
        Domain domain = new Domain();
        domain.values = [0, 10, 20, 30]
        scale.setDomain(domain);
        ScaleRange scaleRange = new ScaleRange();
        scaleRange.unionArrayValue=["orange", "green", "blue"];
        scale.setRange(scaleRange)
        Color color = Demat.color("properties.BUILDING_FRACTION").quantitative();
        color.setScale(scale);
        View view = Demat.view().data(geojson).description("A Map with unique values").height(500).width(700).mark_geoshape().
                encoding(color).projection(ProjectionType.IDENTITY);
        view.save( "target/"+testInfo.getDisplayName()+".html",true);
    }
}