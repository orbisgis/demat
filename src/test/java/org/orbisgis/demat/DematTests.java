package org.orbisgis.demat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.orbisgis.demat.v4.*;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;

public class DematTests {


    @Test
    void testSimpleBarChart(TestInfo testInfo) throws IOException {
        XClass x = Demat.X("a").nominal();
        YClass y = Demat.Y("b").quantitative();
        View view = Demat.view().description("A simple bar chart").name("A simple name")
                .data(new Object[][]{{"a", "b", "c"}, {1, 22, 12}, {200, 300, 400}})
                .mark_bar()
                .encoding(x, y);
        view.save( "target/"+testInfo.getDisplayName()+".html",true);
    }

    @Test
    void testResponsiveBarChart(TestInfo testInfo) throws IOException {
        XClass x = Demat.X("Origin");
        YClass y = Demat.Y().count();
        LinkedHashMap<Object, Object> data = Demat.fromJson(DematTests.class.getResourceAsStream("cars.json"));
        View chart = Demat.view().description("A grouping bar").name("Counting cars")
                .data(data)
                .mark_bar()
                .encoding(x,y);
        chart.save( "target/"+testInfo.getDisplayName()+".html",true);
    }

    @Test
    void testHorizontalConcat(TestInfo testInfo) throws IOException {
        XClass x = Demat.X("a").nominal();
        YClass y = Demat.Y("b").quantitative();
        View view = Demat.view().description("A simple bar chart to concat").name("A simple name")
                .data(new Object[][]{{"a", "b", "c"}, {1, 22, 12}, {200, 300, 400}});
        View bar_one = Demat.view().mark_bar().encoding(x, y);
        y = Demat.Y("c").quantitative();
        View bar_two  = Demat.view().mark_bar().encoding(x, y);
        view.hconcat(bar_one, bar_two);
        view.save( "target/"+testInfo.getDisplayName()+".html",true);
    }

    @Test
    void testDisplayMapUniqueColorMark (TestInfo testInfo) throws IOException {
        LinkedHashMap<Object, Object> geojson = Demat.fromJson(new File("/home/ebocher/Autres/codes/demat/src/test/resources/org/orbisgis/demat/rsu_geoindicators.geojson"));
        ColorClass color = Demat.color("properties.BUILDING_FRACTION").quantitative();
        View view = Demat.view().data(geojson).description("A Map with unique values").height(500).width(700).mark_geoshape().
                encoding(color).projection(ProjectionType.IDENTITY);
        view.save( "target/"+testInfo.getDisplayName()+".html",true);
    }

}
