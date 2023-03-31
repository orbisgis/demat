package org.orbisgis.demat

import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInfo
import org.orbisgis.data.H2GIS

import static org.orbisgis.demat.Plot.*

class PlotWithSQL {

    public static H2GIS h2GIS

    @BeforeAll
    static void beforeAll() {
        h2GIS = H2GIS.open("./target/${this.getClass().getName()};AUTO_SERVER=TRUE")
    }

    @Test
    void testSimpleBarChart(TestInfo testInfo) {
        h2GIS.load(GroovyPlotTest.class.getClassLoader().getResource("rsu_geoindicators.geojson"), true)
        def rows = h2GIS.rows("""select sum(st_area(the_geom)) as area , classes  from 
        (SELECT the_geom, case when WATER_FRACTION<0.1 then '< 0.1'
        when WATER_FRACTION>=0.1 and WATER_FRACTION<0.3  then '0.1 - 0.3'
         when WATER_FRACTION>=0.3 and WATER_FRACTION<0.5 then '0.3 - 0.5'
          when WATER_FRACTION>=0.5 and WATER_FRACTION<0.7 then '0.5 - 0.7'
          else  '> 0.7' end as classes, from rsu_geoindicators) as foo group by classes """)
        Chart chart = Chart(Data(rows)).encode(X("CLASSES").nominal(), Y("AREA").quantitative()).mark_bar()
        chart.save("/tmp/${testInfo.displayName}.html")
        //chart.width(800).show()
    }
}
