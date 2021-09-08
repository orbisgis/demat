/*
 * DEMAT is java wrapper on top of the vega-lite library
 *
 * Demat is breton word to said "Hello".
 *
 * DEMAT is part of the OrbisGIS platform.
 *
 * OrbisGIS platform is a set of open source tools to access, process, display
 * and share geographical informations.
 *
 * It is leaded by CNRS within the French Lab-STICC laboratory <http://www.lab-sticc.fr/>,
 * DECIDE team of Vannes.
 *
 * OrbisGIS is dedicated to research in GIScience.
 *
 * The GIS group of the DECIDE team is located at :
 *
 * Laboratoire Lab-STICC – CNRS UMR 6285
 * Equipe DECIDE
 * UNIVERSITÉ DE BRETAGNE-SUD
 * Institut Universitaire de Technologie de Vannes
 * 8, Rue Montaigne - BP 561 56017 Vannes Cedex
 *
 * DEMAT is distributed under LGPL 3 license.
 *
 * Copyright (C) 2021 CNRS (Lab-STICC UMR CNRS 6285)
 *
 *
 * DEMAT is free software: you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * DEMAT is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * DEMAT. If not, see <http://www.gnu.org/licenses/>.
 *
 * For more information, please consult: <http://www.orbisgis.org/>
 * or contact directly:
 * info_at_ orbisgis.org
 */
package org.orbisgis.demat

import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInfo
import org.orbisgis.demat.vega.*

import static org.orbisgis.demat.Demat.*

/**
 * @author Erwan Bocher, CNRS 2021
 */
class GroovyDematTest {


    private static Data GRID_INDICATORS = null;
    private static Data RSU_GEOINDICATORS = null;

    @BeforeAll
    public static void loadData(){
        LinkedHashMap geojson = (LinkedHashMap) Read.json(DematTest.class.getClassLoader().getResourceAsStream("rsu_geoindicators.geojson"));
        RSU_GEOINDICATORS = data((List<Map>) geojson.get("features"));
        geojson = (LinkedHashMap) Read.json(DematTest.class.getClassLoader().getResourceAsStream("grid_indicators.geojson"));
        GRID_INDICATORS = data((List<Map>) geojson.get("features"));
    }

    @Test
    void testSimpleBarChart(TestInfo testInfo){
        View plot = view().data([
                ["a": "A", "b": 28], ["a": "B", "b": 55], ["a": "C", "b": 43],
                ["a": "D", "b": 91], ["a": "E", "b": 81], ["a": "F", "b": 53],
                ["a": "G", "b": 19], ["a": "H", "b": 87], ["a": "I", "b": 52] ]).mark_bar().
                encode(x("a").nominal(),y("b").quantitative() )
       plot.save("target/${testInfo.displayName}.html",true)
    }

    @Test
    void testResponsiveBarChart(TestInfo testInfo){
        def plot =  view().data(cars()).mark_bar()
                .encode(x("Origin"), y().count())
        plot.save("target/${testInfo.displayName}.html",true)
    }

    @Test
    void testSimpleHistogram(TestInfo testInfo){
        def plot =  view().data(cars()).mark_bar()
                .encode(x("Cylinders").quantitative().bin(true), y().count())
        plot.save("target/${testInfo.displayName}.html",true)
    }

    @Test
    void testSimpleStackedAreaChart(TestInfo testInfo){
        def plot =  view().data(seattle_weather()).mark_area()
                .encode(x("date").temporal(), y("precipitation").quantitative(), color("weather").nominal())
        plot.save("target/${testInfo.displayName}.html",true)
    }

    @Test
    void testSimpleStripPlot(TestInfo testInfo){
        def plot =  view().data(cars()).mark_tick()
                .encode(x("Horsepower").quantitative(), y("Cylinders").ordinal())
        plot.save("target/${testInfo.displayName}.html",true)
    }

    @Test
    void testHorizontalStackedBarChart(TestInfo testInfo){
        def plot =  view().data(seattle_weather()).mark_bar()
                .encode(x("precipitation").sum(), y('weather'))
        plot.save("target/${testInfo.displayName}.html",true)
    }

    @Test
    void testLineChart(TestInfo testInfo){
        def plot =  view().data(seattle_weather()).mark_line()
                .encode(x("date").temporal(), y('precipitation').quantitative())
        plot.save("target/${testInfo.displayName}.html",true)
    }

    @Test
    void testPointChart(TestInfo testInfo){
        def plot =  view().data(seattle_weather()).mark_point()
                .encode(x("date").temporal(), y('precipitation').quantitative(), color('weather'))
        plot.save("target/${testInfo.displayName}.html",true)
    }

    @Test
    void testDisplayMap (TestInfo testInfo){
        View plot = view().data(RSU_GEOINDICATORS).height(500).width(500).mark_geoshape();
        plot.save("target/${testInfo.displayName}.html",true)
    }

    @Test
    void testDisplayMapJSON (TestInfo testInfo){
        View plot = view().data("{\"type\":\"Feature\",\"geometry\":{\"type\":\"Polygon\",\"coordinates\":[[[4.866735,46.263463],[4.866611,46.263508],[4.866568,46.263558],[4.866583,46.263596],[4.866645,46.263637],[4.866866,46.26371],[4.866915,46.263688],[4.866799,46.263561],[4.8667,46.26356],[4.866738,46.2635],[4.866735,46.263463]]]}}").height(500).width(500).mark_geoshape();
        plot.save("target/${testInfo.displayName}.html",true)
        //plot.show()
    }

    @Test
    void testDisplayMapWithCustomMark (TestInfo testInfo){
        Mark mark= new Mark();
        Def definition = new Def();
        definition.type="geoshape"
        MarkFill markFill = new MarkFill()
        markFill.color="#eee"
        definition.fill=markFill
        MarkStroke markStrokeDef= new MarkStroke()
        markStrokeDef.color="#757575"
        definition.stroke=markStrokeDef
        mark.defValue=definition
        View plot = view().data(RSU_GEOINDICATORS).height(500).width(500).mark(mark)
        plot.save("target/${testInfo.displayName}.html",true)
        //plot.show()
    }

    @Test
    void testDisplayMapWithInterval (TestInfo testInfo) throws IOException {
        View view = view().data(RSU_GEOINDICATORS)
                .description("A Map with interval")
                .height(500).width(700)
                .mark_geoshape()
                .encode(color("properties.HIGH_VEGETATION_FRACTION",
                        scale(domain([0, 0.1, 0.2, 0.5]), range(["orange", "green", "blue"])))
                        .quantitative())
                .projection(ProjectionType.IDENTITY);
        //view.save( "target/"+testInfo.getDisplayName()+".html",true);
        //view.show()
    }

}