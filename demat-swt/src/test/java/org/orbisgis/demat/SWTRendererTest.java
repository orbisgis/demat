package org.orbisgis.demat;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.orbisgis.demat.Plot.*;

public class SWTRendererTest {

    @Disabled
    @Test
    void testSimpleBarChart(TestInfo testInfo) throws RendererNotFoundException {
        Chart chart = Chart(Data(new Object[][]{{"a", "b", "c"}, {1, 202, 12}, {200, 300, 400}})).mark_bar()
                .encode(X("a").nominal(), Y("b"), Tooltip("b"));
        chart.show();
    }

    @Disabled
    @Test
    void testPlot(TestInfo testInfo) throws IOException, RendererNotFoundException {
        LinkedHashMap geojson = (LinkedHashMap) Read.json(SWTRendererTest.class.getClassLoader().getResourceAsStream("rsu_geoindicators.geojson"));
        Plot plot = Plot( Data((List<Map>) geojson.get("features")));
        Chart chart = Maps().uniqueValuesMap().field("properties.ID_RSU");
        Chart chart2 = Maps().choroplethMap().field("properties.WATER_FRACTION");
        Chart chart3 = Maps().choroplethMap().field("properties.BUILDING_FRACTION");

        plot.concat(2, chart, chart2, chart3).show();
    }


}
