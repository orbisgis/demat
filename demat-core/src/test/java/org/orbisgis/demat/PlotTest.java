package org.orbisgis.demat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.orbisgis.demat.vega.TimeUnit;
import org.orbisgis.demat.vega.data.Data;

import java.io.File;
import java.io.IOException;
import java.util.*;

import static org.orbisgis.demat.Plot.Chart;
import static org.orbisgis.demat.Plot.Plot;
import static org.orbisgis.demat.Plot.*;

public class PlotTest {

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
    void testSimpleBarChart(TestInfo testInfo) throws IOException {
        Chart chart = Chart(Data(new Object[][]{{"a", "b", "c"}, {1, 202, 12}, {200, 300, 400}})).mark_bar()
                .encode(X("a").nominal(), Y("b"), Tooltip("b"));
        chart.save("target/" + testInfo.getDisplayName() + ".html");
        //chart.show();
    }

    @Test
    void testSimpleBarChartRenameLegendX(TestInfo testInfo) throws IOException {
        HashMap newLabels = new HashMap();
        newLabels.put(1, "super");
        newLabels.put(2, "demat");
        Chart chart = Chart(Data(new Object[][]{{"a", "b", "c"}, {1, 202, 12}, {200, 300, 400}})).mark_bar()
                .encode(X("a").nominal().replaceLabels(newLabels), Y("b"), Tooltip("b"));
        chart.save("target/" + testInfo.getDisplayName() + ".html");
        //chart.show();
    }

    @Test
    void testSimpleBarChartCalculateFilter(TestInfo testInfo) throws IOException {
        Chart chart = Chart(Data(new Object[][]{{"a", "b", "c"}, {1, -202, 12}, {200, -300, 400}})).mark_bar()
                .encode(X("a").nominal(), Y("b_abs")).calculate("abs(datum.b)", "b_abs").filter("datum.b> -300");
        chart.save("target/" + testInfo.getDisplayName() + ".html");
        //chart.show();
    }

    @Test
    void testResponsiveBarChart(TestInfo testInfo) throws IOException {
        Chart chart = Chart(DataTests.cars()).mark_bar()
                .encode(X("Origin"), Y().count()).description("A grouping bar").name("Counting cars");
        //chart.show();
        chart.save("target/" + testInfo.getDisplayName() + ".html");
    }

    @Test
    void testStackedBarChartWithRoundedCorners(TestInfo testInfo) throws IOException {
        Chart chart = Chart(DataTests.seattle_weather())
                .mark_bar()
                .encode(X("date").ordinal().timeUnit(TimeUnit.MONTH), Y().count(), Color("weather"));
        chart.save("target/" + testInfo.getDisplayName() + ".html");
        //chart.show();
    }

    @Test
    void testHorizontalConcat(TestInfo testInfo) throws IOException {
        Plot plot = Plot(Data(new Object[][]{{"a", "b", "c"}, {1, 22, 12}, {200, 300, 400}}));
        Chart chart = Chart().mark_bar()
                .encode(X("a").nominal(), Y("b").quantitative());
        Chart chart2 = Chart().mark_line()
                .encode(X("a").nominal(), Y("b").quantitative());
        plot.hconcat(chart, chart2).save("target/" + testInfo.getDisplayName() + ".html");
    }

    @Test
    void testUniqueValuesMap(TestInfo testInfo) throws IOException {
        Chart chart = Maps().uniqueValuesMap(RSU_GEOINDICATORS).field("properties.BUILDING_FRACTION");
        //chart.show();
    }

    @Test
    void testUniqueValuesMapCustomColor(TestInfo testInfo) throws IOException {
        Chart chart = Maps().uniqueValuesMap(RSU_GEOINDICATORS).field("properties.BUILDING_FRACTION").
                range(Arrays.asList("green", "blue", "black")).legend("Building fractions");
        //chart.show();
    }

    @Test
    void testChoropleth(TestInfo testInfo) throws IOException {
        Chart chart = Maps().choroplethMap(RSU_GEOINDICATORS).field("properties.BUILDING_FRACTION").legend("Building fractions");
        //chart.show();
    }

    @Test
    void testChoroplethDiscretizingScales(TestInfo testInfo) throws IOException {
        Chart chart = Maps().choroplethMap(RSU_GEOINDICATORS).field("properties.BUILDING_FRACTION", Quantile()).legend("Building fractions");
        //chart.show();
    }

    @Test
    void testChoroplethDiscretizingScales2(TestInfo testInfo) throws IOException {
        Chart chart = Maps().choroplethMap(RSU_GEOINDICATORS).field("properties.BUILDING_FRACTION").legend("Building fractions").domain(Arrays.asList(0, 0.1, 0.2, 0.3));
        //chart.show();
    }

    @Test
    void testManualIntervalMap(TestInfo testInfo) throws IOException {
        Chart chart = Maps().manualIntervalMap(RSU_GEOINDICATORS).field("properties.BUILDING_FRACTION").legend("Building fractions").
                domain(Arrays.asList(0.1, 0.2, 0.3)).scheme("accent");
        //chart.show();
    }

    @Disabled
    @Test
    void testLCZAVGInterval(TestInfo testInfo) throws IOException, RendererNotFoundException {
        LinkedHashMap geojson = (LinkedHashMap) Read.json(new File("/home/ebocher/Téléchargements/1629214262874_BuildingEstimation_WithoutToulouse/NANTES_RsuIndic.geojson"));
        Plot plot = Plot(Data((List<Map>) geojson.get("features")));
        Chart chart = Maps().manualIntervalMap().field("properties.AVG_HEIGHT_ROOF_TRUE")
                .filter("datum.properties.AVG_HEIGHT_ROOF_TRUE>0 && datum.properties.AVG_ESTIMATED>0.9")
                .domain(Arrays.asList(0, 5, 7.5, 10, 12.5, 15, 20)).scheme("turbo").reflectY().title("AVG_HEIGHT_ROOF_TRUE");
        Chart chart2 = Maps().manualIntervalMap().field("properties.AVG_HEIGHT_ROOF")
                .filter("datum.properties.AVG_HEIGHT_ROOF_TRUE>0 && datum.properties.AVG_ESTIMATED>0.9")
                .domain(Arrays.asList(0, 5, 7.5, 10, 12.5, 15, 20)).scheme("turbo").reflectY().legend("Height value (in meters)").title("AVG_HEIGHT_ROOF");
        plot.concat(chart, chart2).show();
    }

    @Disabled
    @Test
    void testLCZAVG(TestInfo testInfo) throws IOException {
        List mapIntervals = Arrays.asList(5, 7.5, 10, 12.5, 15, 20);
        List<String> colorSchem = Arrays.asList("#00c0ff", "blue", "green", "orange", "red", "purple", "black");
        LinkedHashMap geojson = (LinkedHashMap) Read.json(new File("/home/ebocher/Téléchargements/1629214262874_BuildingEstimation_WithoutToulouse/NANTES_RsuIndic.geojson"));
        Plot plot = Plot(Data((List<Map>) geojson.get("features")));
        Chart chart = Maps().manualIntervalMap().field("properties.AVG_HEIGHT_ROOF_TRUE")
                .filter("datum.properties.AVG_HEIGHT_ROOF_TRUE>0 && datum.properties.AVG_ESTIMATED>0.9")
                .domain(mapIntervals).range(colorSchem).reflectY().legend("Reference building", "height value (m)");
        Chart chart2 = Maps().manualIntervalMap().field("properties.AVG_HEIGHT_ROOF")
                .filter("datum.properties.AVG_HEIGHT_ROOF_TRUE>0 && datum.properties.AVG_ESTIMATED>0.9")
                .domain(mapIntervals).range(colorSchem).reflectY().legend("Estimated building", "height value (m)");
        Chart chart3 = Maps().manualIntervalMap().field("abs")
                .filter("datum.properties.AVG_HEIGHT_ROOF_TRUE>0 && datum.properties.AVG_ESTIMATED>0.9").calculate("abs(datum.properties.DIFF_AVG_HEIGHT_ROOF)", "abs")
                .domain(Arrays.asList(2.5, 5)).range(Arrays.asList("green", "orange", "red")).reflectY().legend("Absolute building", "height error value (m)");
        Chart chart4 = Maps().manualIntervalMap().field("properties.AVG_ESTIMATED")
                .filter("datum.properties.AVG_HEIGHT_ROOF_TRUE>0 && datum.properties.AVG_ESTIMATED<0.9")
                .domain(Arrays.asList(0.3, 0.6)).range(Arrays.asList("green", "orange", "red")).reflectY().legend("Fraction of OSM buildings", "having height information");

        plot.concat(2, chart, chart2, chart3, chart4).resolve(ScaleResolve(ColorResolve().independent()));//.show();
    }


    @Disabled
    @Test
    void testCont(TestInfo testInfo) throws IOException {
        Plot plot = Plot(RSU_GEOINDICATORS);
        Chart chart = Maps().uniqueValuesMap().field("properties.ID_RSU");
        Chart chart2 = Maps().choroplethMap().field("properties.WATER_FRACTION");
        //plot.concat(chart, chart2).show();
    }

    @Disabled
    @Test
    void testDebug(TestInfo testInfo) throws IOException {
        //Plot().resolve(ScaleResolve(ColorResolve().independent())).show();
    }
}
