package org.orbisgis.demat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.orbisgis.demat.v4.*;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class DematTests {


    @Test
    void testSimpleBarChart(TestInfo testInfo) throws IOException {
        Encoding encoding = Demat.encoding();
        XClass x = Demat.X("a").nominal();
        YClass y = Demat.Y("b").quantitive();
        encoding.setX(x);
        encoding.setY(y);
        Chart chart = Demat.chart().description("A simple bar chart").name("A simple name")
                .data(new Object[][]{{"a", "b", "c"}, {1, 22, 12}, {200, 300, 400}})
                .mark_bar()
                .encoding(encoding);
        chart.save("/tmp/erwan.html", true);
    }

    @Test
    void testResponsiveBarChart(TestInfo testInfo) throws IOException {
        Encoding encoding = Demat.encoding();
        XClass x = Demat.X("Origin");
        YClass y = Demat.Y().count();
        encoding.setX(x);
        encoding.setY(y);
        List<Map> data = Demat.fromJson(new File("/home/ebocher/Autres/codes/demat/src/test/resources/org/orbisgis/demat/cars.json"));
        Chart chart = Demat.chart().description("A grouping bar").name("Counting cars")
                .data(data)
                .mark_bar()
                .encoding(encoding);
        chart.save("/tmp/erwan_count.html", true);
    }


}
