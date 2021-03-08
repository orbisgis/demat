package org.orbisgis.demat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.orbisgis.demat.vega.*;

import java.io.IOException;
import java.util.*;

public class DematTest {


    @Test
    void testSimpleBarChart(TestInfo testInfo) throws IOException {
        X x = Demat.X("a").nominal();
        Y y = Demat.Y("b").quantitative();
        View view = Demat.view().description("A simple bar chart").name("A simple name")
                .data(new Object[][]{{"a", "b", "c"}, {1, 22, 12}, {200, 300, 400}})
                .mark_bar()
                .encoding(x, y);
        view.save( "target/"+testInfo.getDisplayName()+".html",true);
    }

    @Test
    void testResponsiveBarChart(TestInfo testInfo) throws IOException {
        X x = Demat.X("Origin");
        Y y = Demat.Y().count();
        Data data =  Demat.toData(getClass().getClassLoader().getResourceAsStream("cars.json"));
        View chart = Demat.view().description("A grouping bar").name("Counting cars")
                .data(data)
                .mark_bar()
                .encoding(x,y);
        chart.save( "target/"+testInfo.getDisplayName()+".html",true);
    }

    @Test
    void testHorizontalConcat(TestInfo testInfo) throws IOException {
        X x = Demat.X("a").nominal();
        Y y = Demat.Y("b").quantitative();
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
        LinkedHashMap<Object, Object> geojson = (LinkedHashMap<Object, Object>) Demat.fromJson(getClass().getClassLoader().getResourceAsStream("rsu_geoindicators.geojson"));
        Color color = Demat.color("properties.BUILDING_FRACTION").quantitative();
        View view = Demat.view().data(geojson).description("A Map with unique values").height(500).width(700).mark_geoshape().
                encoding(color).projection(ProjectionType.IDENTITY);
        view.save( "target/"+testInfo.getDisplayName()+".html",true);
        view.show();
    }

    @Test
    void testDisplayMapWithInterval (TestInfo testInfo) throws IOException {
        LinkedHashMap<Object, Object> geojson = (LinkedHashMap<Object, Object>) Demat.fromJson(getClass().getClassLoader().getResourceAsStream("grid_indicators.geojson"));
        List features = (List) geojson.get("features");
        Scale scale = new Scale();
        Domain domain = new Domain();
        domain.values = new Integer[]{0, 3, 5, 10, 20, 30, 50};//{0d, 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 1d};
        scale.setDomain(domain);
        Projection projection = new Projection();
        projection.setType(ProjectionType.IDENTITY);
        projection.setReflectY(true);
        Color color = Demat.color("properties.AVG_HEIGHT_ROOF").quantitative();
        color.setScale(scale);
        Legend legend = new Legend();
        legend.setTitle("Height average in meters");
        color.setLegend(legend);
            View view = Demat.view().data(features).description("A Map with color intervals").height(500).width(700).mark_geoshape().
                encoding(color).projection(projection);
        view.save( "target/"+testInfo.getDisplayName()+".html",true);
        view.show();
    }

    @Test
    void testDisplayMapWithIntervalConcat(TestInfo testInfo) throws IOException {
        LinkedHashMap<Object, Object> geojson = (LinkedHashMap<Object, Object>) Demat.fromJson(getClass().getClassLoader().getResourceAsStream("rsu_geoindicators.geojson"));
        List features = (List) geojson.get("features");
        Scale scale = new Scale();
        Domain domain = new Domain();
        domain.values = new Double[]{0d, 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 1d};
        scale.setDomain(domain);
        Projection projection = new Projection();
        projection.setType(ProjectionType.IDENTITY);
        projection.setReflectY(true);
        Color color = Demat.color("properties.BUILDING_FRACTION").quantitative();
        color.setScale(scale);
        View view = Demat.view().data(features).description("A Map with unique values").projection(projection);
        View map1  = Demat.view().height(400).width(400).mark_geoshape().
                encoding(color).title("Building");;
        Color color2 = Demat.color("properties.WATER_FRACTION").quantitative();
        color.setScale(scale);
        Legend legend = new Legend();
        legend.setFormat("%");
        legend.setTitle("Fraction of area in percentage");
        color.setLegend(legend);
        View map2  = Demat.view().height(400).width(400).mark_geoshape().
                encoding(color2).title("Water");
        view.hconcat(map1,map2);
    }

    @Test
    void testDisplayMapWithIntervalWrappable(TestInfo testInfo) throws IOException {
        LinkedHashMap<Object, Object> geojson = (LinkedHashMap<Object, Object>) Demat.fromJson(getClass().getClassLoader().getResourceAsStream("grid_indicators.geojson"));
        List features = (List) geojson.get("features");
        Scale scale = new Scale();
        Domain domain = new Domain();
        domain.values = new Double[]{0d, 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 1d};
        scale.setDomain(domain);
        Projection projection = new Projection();
        projection.setType(ProjectionType.IDENTITY);
        projection.setReflectY(true);
        Legend legend = new Legend();
        legend.setFormat("%");
        legend.setTitle("Fraction of area in percentage");
        Color color = Demat.color("properties.BUILDING_FRACTION").quantitative();
        color.setScale(scale);
        color.setLegend(legend);
        View view = Demat.view().data(features).description("A Map with unique values");
        View map1  = Demat.view().height(400).width(400).mark_geoshape().
                encoding(color).title("Building").projection(projection);
        Color color2 = color.copy();
        color2.setField("properties.ROAD_FRACTION");
        View map2  = Demat.view().height(400).width(400).mark_geoshape().
                encoding(color2).title("Road").projection(projection);
        Color color3 = color.copy();
        color3.setField("properties.IMPERVIOUS_FRACTION");
        View map3  = Demat.view().height(400).width(400).mark_geoshape().
                encoding(color3).title("Impervious").projection(projection);
        Color color4 = color.copy();
        color4.setField("properties.WATER_FRACTION");
        View map4  = Demat.view().height(400).width(400).mark_geoshape().
                encoding(color4).title("Water").projection(projection);
        Color color5 = color.copy();
        color5.setField("properties.LOW_VEGETATION_FRACTION");
        View map5  = Demat.view().height(400).width(400).mark_geoshape().
                encoding(color5).title("Low vegetation").projection(projection);
        Color color6 = color.copy();
        color6.setField("properties.HIGH_VEGETATION_FRACTION");
        View map6  = Demat.view().height(400).width(400).mark_geoshape().
                encoding(color6).title("High vegetation").projection(projection);
        view.concat(2, map1,map2, map3, map4,map5,map6);
        view.save( "target/"+testInfo.getDisplayName()+".html",true);
    }

    @Test
    void testDisplayMapWithColorSchemeWrappable(TestInfo testInfo) throws IOException {
        LinkedHashMap<Object, Object> geojson = (LinkedHashMap<Object, Object>) Demat.fromJson(getClass().getClassLoader().getResourceAsStream("grid_indicators.geojson"));
        List features = (List) geojson.get("features");
        Scale scale = new Scale();
        Domain domain = new Domain();
        domain.values = new Double[]{0d, 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 1d};
        scale.setDomain(domain);
        Scheme scheme = new Scheme();
        scheme.stringValue="Oranges";
        scale.setScheme(scheme);
        Projection projection = new Projection();
        projection.setType(ProjectionType.IDENTITY);
        projection.setReflectY(true);
        Legend legend = new Legend();
        legend.setFormat("%");
        legend.setTitle("Fraction of area in percentage");
        HashMap<String, String> fieldNames = new HashMap<String, String>();
        fieldNames.put("LCZ 1: Compact high-rise", "LCZ1_1");
        fieldNames.put("LCZ 2: Compact mid-rise", "LCZ1_2");
        fieldNames.put("LCZ 3: Compact low-rise", "LCZ1_3");
        fieldNames.put("LCZ 4: Open high-rise", "LCZ1_4");
        fieldNames.put("LCZ 5: Open mid-rise", "LCZ1_5");
        fieldNames.put("LCZ 6: Open low-rise", "LCZ1_6");
        fieldNames.put("LCZ 7: Lightweight low-rise", "LCZ1_7");
        fieldNames.put("LCZ 8: Large low-rise", "LCZ1_8");
        fieldNames.put("LCZ 9: Sparsely built", "LCZ1_9");
        fieldNames.put("LCZ 101: Dense trees", "LCZ1_101");
        fieldNames.put("LCZ 102: Scattered trees", "LCZ1_102");
        fieldNames.put("LCZ 104: Low plants", "LCZ1_104");
        fieldNames.put("LCZ 105: Bare rock or paved", "LCZ1_105");
        fieldNames.put("LCZ 107: Water", "LCZ1_107");

        Color color = Demat.color("properties.LCZ1_1").quantitative();
        color.setScale(scale);
        color.setLegend(legend);
        View view = Demat.view().data(features).description("A wrappable map with color scheme and a datum transformation");

        View[]  views = new View[fieldNames.size()];
        int i=0;
        ArrayList<Transform> transforms = new ArrayList<>();
        for (Map.Entry<String, String> field :
                fieldNames.entrySet()) {
            Transform transform = new Transform();
            transform.setCalculate("datum.properties."+field.getValue()+"/812756");
            LegendText legendText = new LegendText();
            legendText.stringValue="res_"+field.getValue();
            transform.setAs(legendText);
            Color color_tmp = color.copy();
            color_tmp.setField("res_"+field.getValue());
            View map_  = Demat.view().height(400).width(400).mark_geoshape().
                    encoding(color_tmp).title(field.getKey()).projection(projection);
            transforms.add(transform);
            views[i] = map_;
            i++;
        }
        view.setTransform(transforms);
        view.concat(2, views);
        view.save( "target/"+testInfo.getDisplayName()+".html",true);
        view.show();
    }

}
