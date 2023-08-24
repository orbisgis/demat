package org.orbisgis.demat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.io.CleanupMode;
import org.junit.jupiter.api.io.TempDir;
import org.orbisgis.data.H2GIS;
import org.orbisgis.data.api.dataset.ISpatialTable;
import org.orbisgis.demat.maps.ManualIntervalMap;
import org.orbisgis.demat.vega.TimeUnit;
import org.orbisgis.demat.vega.data.Data;

import java.io.File;
import java.io.IOException;
import java.util.*;

import static org.orbisgis.demat.Plot.Chart;
import static org.orbisgis.demat.Plot.Plot;
import static org.orbisgis.demat.Plot.*;

public class PlotTest {

    @TempDir(cleanup = CleanupMode.NEVER)
    static File folder;

    private static Data GRID_INDICATORS = null;
    private static Data RSU_GEOINDICATORS = null;

    @BeforeAll
    public static void loadData() throws IOException {
        LinkedHashMap geojson = (LinkedHashMap) Read.json(PlotTest.class.getClassLoader().getResourceAsStream("rsu_geoindicators.geojson"));
        RSU_GEOINDICATORS = Data((List<Map>) geojson.get("features"));
        geojson = (LinkedHashMap) Read.json(PlotTest.class.getClassLoader().getResourceAsStream("grid_indicators.geojson"));
        GRID_INDICATORS = Data((List<Map>) geojson.get("features"));
    }

    @Test
    void testSimpleBarChart() throws IOException {
        Chart chart = Chart(Data(new Object[][]{{"a", "b", "c"}, {1, 202, 12}, {200, 300, 400}})).mark(Bar())
                .encode(X("a").nominal(), Y("b"), Tooltip("b"));
        chart.save(File.createTempFile("demat",".svg", folder));
    }

    @Test
    void testSimpleBarChartRenameLegendX() throws IOException {
        HashMap newLabels = new HashMap();
        newLabels.put(1, "super");
        newLabels.put(2, "demat");
        Chart chart = Chart(Data(new Object[][]{{"a", "b", "c"}, {1, 202, 12}, {200, 300, 400}})).mark(Bar())
                .encode(X("a").nominal().replaceLabels(newLabels), Y("b"), Tooltip("b"));
        chart.save(File.createTempFile("demat",".svg", folder));
    }

    @Test
    void testSimpleBarChartCalculateFilter() throws IOException {
        Chart chart = Chart(Data(new Object[][]{{"a", "b", "c"}, {1, -202, 12}, {200, -300, 400}})).mark(Bar())
                .encode(X("a").nominal(), Y("b_abs")).calculate("abs(datum.b)", "b_abs").filter("datum.b> -300");
        chart.save(File.createTempFile("demat",".svg", folder));
    }

    @Test
    void testResponsiveBarChart() throws IOException {
        Chart chart = Chart(DataTests.cars()).mark(Bar())
                .encode(X("Origin"), Y().count()).description("A grouping bar").name("Counting cars");
        chart.save(File.createTempFile("demat",".svg", folder));
    }

    @Test
    void testBarChartWithTextWindow() throws IOException {
        Chart chart = Chart(DataTests.cars()).mark(Bar())
                .encode(X("Origin"), Y().count(), Text("The bar")).description("A grouping bar").name("Counting cars");
        chart.save(File.createTempFile("demat",".svg", folder));
    }

    @Test
    void testStackedBarChartWithRoundedCorners() throws IOException {
        Chart chart = Chart(DataTests.seattle_weather())
                .mark(Bar())
                .encode(X("date").ordinal().timeUnit(TimeUnit.MONTH), Y().count(), Color("weather"));
        chart.save(File.createTempFile("demat",".svg", folder));
    }

    @Test
    void testHorizontalConcat(TestInfo testInfo) throws IOException {
        Plot plot = Plot(Data(new Object[][]{{"a", "b", "c"}, {1, 22, 12}, {200, 300, 400}}));
        Chart chart = Chart().mark(Bar())
                .encode(X("a").nominal(), Y("b").quantitative());
        Chart chart2 = Chart().mark(Line())
                .encode(X("a").nominal(), Y("b").quantitative());
        plot.hconcat(chart, chart2).save(File.createTempFile("demat",".svg", folder));
    }

    @Test
    void testUniqueValuesMap(TestInfo testInfo) throws IOException {
        Chart chart = UniqueValuesMap(RSU_GEOINDICATORS).field("properties.BUILDING_FRACTION");
        chart.save(File.createTempFile("demat",".svg", folder));
    }

    @Test
    void testUniqueValuesMapCustomColor(TestInfo testInfo) throws IOException {
        Chart chart = UniqueValuesMap(RSU_GEOINDICATORS).field("properties.BUILDING_FRACTION").
                range(Arrays.asList("green", "blue", "black")).legend("Building fractions");
        chart.save(File.createTempFile("demat",".svg", folder));
    }

    @Test
    void testChoropleth(TestInfo testInfo) throws IOException {
        Chart chart = ChoroplethMap(RSU_GEOINDICATORS).field("properties.BUILDING_FRACTION").legend("Building fractions");
        chart.save(File.createTempFile("demat",".svg", folder));
    }

    @Test
    void testChoroplethDiscretizingScales(TestInfo testInfo) throws IOException {
        Chart chart = ChoroplethMap(RSU_GEOINDICATORS).field("properties.BUILDING_FRACTION", Quantile()).legend("Building fractions");
        chart.save(File.createTempFile("demat",".svg", folder));
    }

    @Test
    void testChoroplethDiscretizingScales2(TestInfo testInfo) throws IOException {
        Chart chart = ChoroplethMap(RSU_GEOINDICATORS).field("properties.BUILDING_FRACTION").legend("Building fractions").domain(Arrays.asList(0, 0.1, 0.2, 0.3));
        chart.save(File.createTempFile("demat",".svg", folder));
    }

    @Test
    void testManualIntervalMap(TestInfo testInfo) throws IOException {
        Chart chart = ManualIntervalMap(RSU_GEOINDICATORS).field("properties.BUILDING_FRACTION").legend("Building fractions").
                domain(Arrays.asList(0.1, 0.2, 0.3)).scheme("accent");
        chart.save(File.createTempFile("demat",".svg", folder));
    }

    @Disabled
    @Test
    void testLCZAVGInterval(TestInfo testInfo) throws IOException {
        LinkedHashMap geojson = (LinkedHashMap) Read.json(new File("/home/ebocher/Téléchargements/1629214262874_BuildingEstimation_WithoutToulouse/NANTES_RsuIndic.geojson"));
        Plot plot = Plot(Data((List<Map>) geojson.get("features")));
        Chart chart = ManualIntervalMap().field("properties.AVG_HEIGHT_ROOF_TRUE")
                .filter("datum.properties.AVG_HEIGHT_ROOF_TRUE>0 && datum.properties.AVG_ESTIMATED>0.9")
                .domain(Arrays.asList(0, 5, 7.5, 10, 12.5, 15, 20)).scheme("turbo").reflectY().title("AVG_HEIGHT_ROOF_TRUE");
        Chart chart2 = Plot.ManualIntervalMap().field("properties.AVG_HEIGHT_ROOF")
                .filter("datum.properties.AVG_HEIGHT_ROOF_TRUE>0 && datum.properties.AVG_ESTIMATED>0.9")
                .domain(Arrays.asList(0, 5, 7.5, 10, 12.5, 15, 20)).scheme("turbo").reflectY().legend("Height value (in meters)").title("AVG_HEIGHT_ROOF");
        plot.concat(chart, chart2).save(File.createTempFile("demat",".svg", folder));
    }

    @Disabled
    @Test
    void testLCZAVG(TestInfo testInfo) throws IOException {
        List mapIntervals = Arrays.asList(5, 7.5, 10, 12.5, 15, 20);
        List<String> colorSchem = Arrays.asList("#00c0ff", "blue", "green", "orange", "red", "purple", "black");
        LinkedHashMap geojson = (LinkedHashMap) Read.json(new File("/home/ebocher/Téléchargements/1629214262874_BuildingEstimation_WithoutToulouse/NANTES_RsuIndic.geojson"));
        Plot plot = Plot(Data((List<Map>) geojson.get("features")));
        Chart chart = ManualIntervalMap().field("properties.AVG_HEIGHT_ROOF_TRUE")
                .filter("datum.properties.AVG_HEIGHT_ROOF_TRUE>0 && datum.properties.AVG_ESTIMATED>0.9")
                .domain(mapIntervals).range(colorSchem).reflectY().legend("Reference building", "height value (m)");
        Chart chart2 = ManualIntervalMap().field("properties.AVG_HEIGHT_ROOF")
                .filter("datum.properties.AVG_HEIGHT_ROOF_TRUE>0 && datum.properties.AVG_ESTIMATED>0.9")
                .domain(mapIntervals).range(colorSchem).reflectY().legend("Estimated building", "height value (m)");
        Chart chart3 = ManualIntervalMap().field("abs")
                .filter("datum.properties.AVG_HEIGHT_ROOF_TRUE>0 && datum.properties.AVG_ESTIMATED>0.9").calculate("abs(datum.properties.DIFF_AVG_HEIGHT_ROOF)", "abs")
                .domain(Arrays.asList(2.5, 5)).range(Arrays.asList("green", "orange", "red")).reflectY().legend("Absolute building", "height error value (m)");
        Chart chart4 = ManualIntervalMap().field("properties.AVG_ESTIMATED")
                .filter("datum.properties.AVG_HEIGHT_ROOF_TRUE>0 && datum.properties.AVG_ESTIMATED<0.9")
                .domain(Arrays.asList(0.3, 0.6)).range(Arrays.asList("green", "orange", "red")).reflectY().legend("Fraction of OSM buildings", "having height information");

        plot.concat(2, chart, chart2, chart3, chart4).resolve(ScaleResolve(ColorResolve().independent())).save(File.createTempFile("demat",".svg", folder));

    }


    @Disabled
    @Test
    void testCont(TestInfo testInfo) throws IOException {
        Plot plot = Plot(RSU_GEOINDICATORS);
        Chart chart = UniqueValuesMap().field("properties.ID_RSU");
        Chart chart2 = ChoroplethMap().field("properties.WATER_FRACTION");
        plot.concat(chart, chart2).save(File.createTempFile("demat",".svg", folder));

    }

    @Disabled
    @Test
    void testDebug(TestInfo testInfo) throws IOException {
        Plot().resolve(ScaleResolve(ColorResolve().independent())).save(File.createTempFile("demat",".svg", folder));
    }

    @Disabled
    @Test
    void testIntegration(TestInfo testInfo) throws IOException {
        String jsonFile ="/home/ebocher/Autres/data/geoclimate/bdtopo_v2_Redon/rsu_lcz.geojson";
        jsonFile = "/media/ebocher/Extreme SSD/data/geoclimate/osm/Toulouse/rsu_lcz.geojson";

        long start = System.currentTimeMillis();
        /*Plot plot = Plot(GeoJSON(jsonFile));
        ManualIntervalMap map = Maps().manualIntervalMap().field("properties.LCZ_PRIMARY").domain(Arrays.asList( 1, 2, 3, 4, 5, 6,7,8,9,10)).scheme("turbo").reflectY();
*/
        //Chart chart = Chart().encode(X("properties.LCZ_PRIMARY"), Y("properties.LCZ_PRIMARY").count(),
          //      Color("properties.LCZ_PRIMARY")).mark_bar();

        long end = System.currentTimeMillis();
        System.out.println("First " +(end-start));
        //jsonFile ="/home/ebocher/Autres/data/geoclimate/bdtopo_v2_Redon/building.geojson";
        jsonFile = "/media/ebocher/Extreme SSD/data/geoclimate/osm/Toulouse/building.geojson";
        Data data = GeoJSON(jsonFile);
        Plot plot = Plot();
        long end2 = System.currentTimeMillis();
        System.out.println("First " +(end2-end));
        ManualIntervalMap map_buildings = ManualIntervalMap(data).field("properties.NB_LEV").scheme("turbo");

        plot.layer( map_buildings);

        plot.save(File.createTempFile("demat",".svg", folder));

    }

    @Test
    @Disabled
    void testMapOSMTile() throws Exception {
       H2GIS h2GIS= H2GIS.open(folder.getAbsolutePath()+File.separator+ this.getClass().getName()+";AUTO_SERVER=TRUE");
       h2GIS.load(PlotTest.class.getClassLoader().getResource("rsu_geoindicators.geojson"), true);

       ISpatialTable table  = h2GIS.getSpatialTable("rsu_geoindicators").columns("BUILDING_FRACTION", "the_geom")
                .filter("limit 2").getSpatialTable();

        Chart chart = ChoroplethMap(table).field("properties.BUILDING_FRACTION").legend("Building fractions").domain(Arrays.asList(0, 0.2, 0.3))
                .addOSMLayer();
        chart.show();
        //chart.save(File.createTempFile("demat",".svg", folder));
    }
}
