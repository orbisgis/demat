package org.orbisgis.demat

import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.orbisgis.data.H2GIS


import static org.orbisgis.demat.Plot.*

class PlotWithSQL {

    public static H2GIS h2GIS

    @BeforeAll
    static void beforeAll() {
        h2GIS = H2GIS.open("./target/${this.getClass().getName()};AUTO_SERVER=TRUE")
    }

    @Test
    void testSimpleBarChart() {
        h2GIS.load(GroovyPlotTest.class.getClassLoader().getResource("rsu_geoindicators.geojson"), true)
        def rows = h2GIS.rows("""select sum(st_area(the_geom)) as area , classes  from 
        (SELECT the_geom, case when WATER_FRACTION<0.1 then '< 0.1'
        when WATER_FRACTION>=0.1 and WATER_FRACTION<0.3  then '0.1 - 0.3'
         when WATER_FRACTION>=0.3 and WATER_FRACTION<0.5 then '0.3 - 0.5'
          when WATER_FRACTION>=0.5 and WATER_FRACTION<0.7 then '0.5 - 0.7'
          else  '> 0.7' end as classes, from rsu_geoindicators) as foo group by classes """)
        Chart chart = Chart(Data(rows)).encode(X("CLASSES").nominal(), Y("AREA").quantitative()).mark_bar()
       // chart.save("/tmp/${testInfo.displayName}.html")
        //chart.width(800).show()
    }

    @Test
    void testSimpleMap() {
        h2GIS.load(GroovyPlotTest.class.getClassLoader().getResource("rsu_geoindicators.geojson"), true)
        h2GIS.save("(select st_precisionreducer(the_geom, 4) as the_geom, BUILDING_FRACTION from rsu_geoindicators)", "/tmp/test.geojson")
        def  data = Read.geojson("/tmp/test.geojson")

        Chart chart = Maps().choroplethMap(data).field("properties.BUILDING_FRACTION").legend("Building fractions").domain(Arrays.asList(0, 0.1, 0.2, 0.3));
        chart.show();
    }

    @Test
    void testJson() {
        h2GIS.load(GroovyPlotTest.class.getClassLoader().getResource("rsu_geoindicators.geojson"), true)
        def rows = h2GIS.getTable("""(select sum(st_area(the_geom)) as area , classes  from 
        (SELECT the_geom, case when WATER_FRACTION<0.1 then '< 0.1'
        when WATER_FRACTION>=0.1 and WATER_FRACTION<0.3  then '0.1 - 0.3'
         when WATER_FRACTION>=0.3 and WATER_FRACTION<0.5 then '0.3 - 0.5'
          when WATER_FRACTION>=0.5 and WATER_FRACTION<0.7 then '0.5 - 0.7'
          else  '> 0.7' end as classes, from rsu_geoindicators) as foo group by classes) """.toString())
        Chart chart = Chart(Data(rows)).encode(X("CLASSES").nominal(), Y("AREA").quantitative()).mark_bar()
        chart.show()
        //chart.width(800).show()
    }
}
