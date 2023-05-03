package org.orbisgis.demat

import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.io.CleanupMode
import org.junit.jupiter.api.io.TempDir
import org.orbisgis.data.H2GIS


import static org.orbisgis.demat.Plot.*

class PlotWithSQL {

    @TempDir(cleanup = CleanupMode.NEVER)
    static File folder

    public static H2GIS h2GIS

    @BeforeAll
    static void beforeAll() {
        h2GIS = H2GIS.open("${folder.getAbsolutePath()+File.separator+ this.getClass().getName()};AUTO_SERVER=TRUE")
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
        chart.save(File.createTempFile("demat",".svg", folder))
    }

    @Test
    void testMapFromTable() {
        h2GIS.load(GroovyPlotTest.class.getClassLoader().getResource("rsu_geoindicators.geojson"), true)
        Chart chart = Maps().choropleth(h2GIS.getSpatialTable("rsu_geoindicators").columns("BUILDING_FRACTION", "the_geom")).field("properties.BUILDING_FRACTION").legend("Building fractions").domain(Arrays.asList(0, 0.1, 0.2, 0.3));
        chart.save(File.createTempFile("demat",".svg", folder))
    }

    @Test
    void testFilterTable() {
        h2GIS.load(GroovyPlotTest.class.getClassLoader().getResource("rsu_geoindicators.geojson"), true)
        def rows = h2GIS.getTable("""(select sum(st_area(the_geom)) as area , classes  from 
        (SELECT the_geom, case when WATER_FRACTION<0.1 then '< 0.1'
        when WATER_FRACTION>=0.1 and WATER_FRACTION<0.3  then '0.1 - 0.3'
         when WATER_FRACTION>=0.3 and WATER_FRACTION<0.5 then '0.3 - 0.5'
          when WATER_FRACTION>=0.5 and WATER_FRACTION<0.7 then '0.5 - 0.7'
          else  '> 0.7' end as classes, from rsu_geoindicators) as foo group by classes) """.toString())
        Chart chart = Chart(rows).encode(X("CLASSES").nominal(), Y("AREA").quantitative()).mark_bar()
        Plot().layer(chart, Source("Data computed with GeoClimate").dx(-10).dy(170)).save(File.createTempFile("demat",".svg", folder))
    }
}
