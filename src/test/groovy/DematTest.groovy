
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInfo
import org.orbisgis.demat.Demat
import org.orbisgis.demat.View
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.orbisgis.demat.v4.*;

class DematTest {

    public static Logger logger = LoggerFactory.getLogger(DematTest.class)


    @Test
    void testSimpleBarChart(TestInfo testInfo){
        View plot = Demat.view().data([
                ["a": "A", "b": 28], ["a": "B", "b": 55], ["a": "C", "b": 43],
                ["a": "D", "b": 91], ["a": "E", "b": 81], ["a": "F", "b": 53],
                ["a": "G", "b": 19], ["a": "H", "b": 87], ["a": "I", "b": 52] ]).mark_bar().
                encoding(Demat.X("a").nominal(),Demat.Y("b").quantitive() )
        plot.save("target/${testInfo.displayName}.html",true)
    }

    @Test
    void testResponsiveBarChart(TestInfo testInfo){
        def plot =  Demat.chart().data(Demat.fromJson(getClass().getResourceAsStream("cars.json"))).mark_bar()
                .encoding(Coordinate.field("Origin"),Y.field().count() )
        plot.save("target/${testInfo.displayName}.html",true)
    }

    @Test
    void testDisplayMap (TestInfo testInfo){
        def geojson = Demat.fromJson(new File("/home/ebocher/Autres/codes/demat/src/test/resources/org/orbisgis/demat/rsu_geoindicators.geojson"))
        View plot = Demat.view().data(geojson).height(500).width(500).mark_geoshape();
        plot.save("target/${testInfo.displayName}.html",true)
    }

    @Test
    void testDisplayMapWithCustomMark (TestInfo testInfo){
        def geojson = Demat.fromJson(new File("/home/ebocher/Autres/codes/demat/src/test/resources/org/orbisgis/demat/rsu_geoindicators.geojson"))
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
        def geojson = Demat.fromJson(new File("/home/ebocher/Autres/codes/demat/src/test/resources/org/orbisgis/demat/rsu_geoindicators.geojson"));
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

    @Test
    void testDisplayMapCartesianGrid (TestInfo testInfo){
        def geojson = Mad.fromJson(new File("/home/ebocher/Autres/codes/geoclimate2/geoclimate/osm/target/geoclimate_chain/osm_Pont-de-Veyle/road.geojson"))
        def  plot = Mad.Chart(values :geojson.features).height(500).width(700).description("A simple Map" ).mark_geoshape()
        plot.save("target/${testInfo.displayName}.html",true)
    }

    @Test
    void testDisplayMapUniqueColorMark (TestInfo testInfo){
        def geojson = Mad.fromJson(getClass().getResourceAsStream("rsu_geoindicators.geojson"))
        def plot = Mad.Chart(values :geojson.features[0..3]).description("A Map with unique values").height(500).width(700).mark_geoshape().
                encoding(Color.field("properties.BUILDING_FRACTION").quantitative())
        plot.save("target/${testInfo.displayName}.html",true)
    }

    @Test
    void testDisplayMapGradientRepeat (TestInfo testInfo){
        def geojson = Mad.fromJson(getClass().getResourceAsStream("rsu_geoindicators.geojson"))
        def plot = Mad.Chart(values :geojson.features[0..10]).description("A Map with unique values").repeat(["row":["properties.BUILDING_FRACTION", "properties.WATER_FRACTION"]]).height(500).width(700).mark_geoshape().
                encoding(Color.field(["repeat":"row"]).quantitative().scale("scheme":"Oranges").legend(["title":"Fraction", "format":"%"])).resolve("scale": [
            "color": "independent"])
        plot.save("target/${testInfo.displayName}.html",true)
    }

    @Test
    void testDisplayCorpenicus(TestInfo testInfo){
        def geojson = Demat.fromJson(new File("/home/ebocher/Autres/codes/demat/src/test/resources/org/orbisgis/demat/rsu_geoindicators.geojson"))
        X x = Demat.X("a").nominal();
        Y y = Demat.Y("b").quantitive();
        View view = Demat.view().description("A concatenation of horizontal maps")
                .data(geojson);
        View bar_one = Demat.view().mark_bar().encoding(x, y);
        y = Demat.Y("c").quantitive();
        View bar_two  = Demat.view().mark_bar().encoding(x, y);
        view.hconcat(bar_one, bar_two);
        view.save( "target/"+testInfo.getDisplayName()+".html",true);

        def plot = Mad.Chart(values :geojson.features).projection("type":"identity").description("A Map with unique values").height(500).width(700).
                repeat(["row":["properties.BUILDING_FRACTION", "properties.WATER_FRACTION"]]).
                mark(["type":"geoshape",  "stroke": "green"]).
                encoding(Color.field(["repeat":"row"]).quantitative().scale("scheme":"Oranges").legend(["title":"Fraction", "format":"%"]))
        plot.save("target/${testInfo.displayName}.html",true)
    }

    @Test
    void testDisplayCorpenicus2(TestInfo testInfo){
        def geojson = Mad.fromJson(new File("/tmp/geoclimate_chain/osm_angers/grid_indicators.geojson"))
        def plot = Mad.Chart(values :geojson.features).projection(["type":"identity"]).description("A Map with unique values").height(500).width(700).
                repeat(["row":["properties.BUILDING_FRACTION", "properties.WATER_FRACTION"]]).
                mark_geoshape().
                encoding(Color.field(["repeat":"row"]).quantitative().scale("scheme":"Oranges").legend(["title":"Fraction", "format":"%"]))
        plot.save("target/${testInfo.displayName}.html",true)

    }
}