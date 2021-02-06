
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInfo
import org.orbisgis.demat.Demat
import org.orbisgis.demat.v4.Encoding
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class DematTest {

    public static Logger logger = LoggerFactory.getLogger(DematTest.class)


    @Test
    void testSimpleBarChart(TestInfo testInfo){
        Encoding encoding = Demat.encoding();
        encoding.x=Demat.X("a").nominal();
        encoding.y= Demat.Y("b").quantitive();
        def plot = Demat.chart().data([
                ["a": "A", "b": 28], ["a": "B", "b": 55], ["a": "C", "b": 43],
                ["a": "D", "b": 91], ["a": "E", "b": 81], ["a": "F", "b": 53],
                ["a": "G", "b": 19], ["a": "H", "b": 87], ["a": "I", "b": 52] ]).mark_bar().
                encoding(encoding)
        plot.save("target/${testInfo.displayName}.html",true)
    }

    @Test
    void testResponsiveBarChart(TestInfo testInfo){
        def plot = Mad.Chart(values :Mad.fromJson(getClass().getResourceAsStream("cars.json"))).mark_bar()
                .encoding(X.field("Origin"),Y.field().count() )
        plot.save("target/${testInfo.displayName}.html",true)
    }

    @Test
    void testDisplayMap (TestInfo testInfo){
        def geojson = Mad.fromJson(getClass().getResourceAsStream("rsu_geoindicators.geojson"))
        def  plot = Mad.Chart(values :geojson.features).height(500).width(700).description("A simple Map" ).mark_geoshape()
        plot.save("target/${testInfo.displayName}.html",true)
    }

    @Test
    void testDisplayMapCartesianGrid (TestInfo testInfo){
        def geojson = Mad.fromJson(new File("/home/ebocher/Autres/codes/geoclimate2/geoclimate/osm/target/geoclimate_chain/osm_Pont-de-Veyle/road.geojson"))
        def  plot = Mad.Chart(values :geojson.features).height(500).width(700).description("A simple Map" ).mark_geoshape()
        plot.save("target/${testInfo.displayName}.html",true)
    }

    @Test
    void testDisplayMapWithCustomMark (TestInfo testInfo){
        def geojson = Mad.fromJson(getClass().getResourceAsStream("rsu_geoindicators.geojson"))
        def plot = Mad.Chart(values :geojson.features[0..10]).description("A Map with custom mark").height(500).width(700).mark(
                type:"geoshape", fill: "#eee", stroke:"#757575")
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
        def geojson = Mad.fromJson(new File("/tmp/geoclimate_chain/osm_angers/grid_indicators.geojson"))
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