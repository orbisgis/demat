package org.orbisgis.demat.swt;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.orbisgis.demat.Chart;
import org.orbisgis.demat.Plot;
import org.orbisgis.demat.RendererNotFoundException;

import java.io.File;

import static org.orbisgis.demat.Plot.*;

public class SWTRendererTest {

    @Disabled
    @Test
    void testSimpleBarChart(TestInfo testInfo) throws RendererNotFoundException {
        Chart chart = Chart(Data(new Object[][]{{"a", "b", "c"}, {1, 202, 12}, {200, 300, 400}})).mark_bar()
                .encode(X("a").nominal(), Y("b"), Tooltip("b")).width(200);
        chart.show();
    }

    @Disabled
    @Test
    void testPlot(TestInfo testInfo) throws Exception {
        Plot plot = Plot( Data(new File("/home/ebocher/Autres/codes/demat/demat-core/src/test/resources/org/orbisgis/demat/rsu_geoindicators.geojson")));
        plot.height(600);
        Chart chart = Maps().uniqueValuesMap().field("properties.ID_RSU");
        Chart chart2 = Maps().choroplethMap().field("properties.WATER_FRACTION");
        Chart chart3 = Maps().choroplethMap().field("properties.BUILDING_FRACTION");
        plot.concat(2, chart, chart2, chart3).show();
    }

    @Disabled
    @Test
    void testPlot2(TestInfo testInfo) throws Exception {
        Plot plot = Plot( Data(new File("/home/ebocher/Autres/data/geoclimate/bdtopo_v2_Redon/rsu_lcz.geojson")));
        plot.height(600);
        Chart chart = Maps().uniqueValuesMap().field("properties.ID_RSU");
        Chart chart2 = Maps().uniqueValuesMap().field("properties.LCZ_PRIMARY");
        plot.concat(2, chart, chart2).show();
    }


}
