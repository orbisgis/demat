import org.h2gis.utilities.jts_utils.GeometryFeatureUtils
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInfo
import org.orbisgis.data.H2GIS
import org.orbisgis.demat.PlotUtils
import static org.orbisgis.demat.Plot.*


class SimpleBarChartTest {

    //@TempDir(cleanup = CleanupMode.ALWAYS)
    static File folder
    private TestInfo testInfo;


    @BeforeEach
    void initEach(TestInfo testInfo) {
        this.testInfo = testInfo;
    }


    @BeforeAll
    static void init() {
        folder = new File("/tmp/")
        folder.mkdir()
    }

    @Test
    void testSimpleBarChart() {
        def spec = [
                description:"A simple bar chart with embedded data.",
                data: [values: [
                        ["a": "A", "b": 28], ["a": "B", "b": 55], ["a": "C", "b": 43],
                        ["a": "D", "b": 91], ["a": "E", "b": 81], ["a": "F", "b": 53],
                        ["a": "G", "b": 19], ["a": "H", "b": 87], ["a": "I", "b": 52]]
                      ],
                mark:"bar",
                encoding : [x : [field:"a",axis:[LabelAngle:0],type:"nominal"],
                            y:  [field:"b","type":"quantitative"]]]

        toSVG(spec, File.createTempFile(testInfo.displayName, ".svg", folder))
    }

    @Test
    void testStackedBarChart2() {
        H2GIS h2GIS = H2GIS.open("/tmp/db")
        h2GIS.load(SimpleBarChartTest.class.getClassLoader().getResource("rsu_geoindicators.geojson"), true)
          def chart =
          [  data : [
                      values : PlotUtils.toFeatures(h2GIS.getSpatialTable("(SELECT * FROM rsu_indicators)"))],
              mark: [type : "geoshape", stroke: "blue", strokeWidth:1, "fill":null], projection:[type:"identity"],
                  "height":800, "width":800
          ]
        def  path = new File("/tmp/mychart.svg")
        toSVG(chart, path)
    }

}