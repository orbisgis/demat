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
import org.orbisgis.demat.vega.Def
import org.orbisgis.demat.vega.Mark
import org.orbisgis.demat.vega.MarkFill
import org.orbisgis.demat.vega.MarkStroke

import static org.orbisgis.demat.Plot.*

/**
 * @author Erwan Bocher, CNRS 2021
 */
class GroovyPlotTest {


    private static def GRID_INDICATORS = null;
    private static def RSU_GEOINDICATORS = null;

    @BeforeAll
    static void loadData() {
        LinkedHashMap geojson = (LinkedHashMap) Read.json(GroovyPlotTest.class.getClassLoader().getResourceAsStream("rsu_geoindicators.geojson"));
        RSU_GEOINDICATORS = Data((List<Map>) geojson.get("features"));
        geojson = (LinkedHashMap) Read.json(GroovyPlotTest.class.getClassLoader().getResourceAsStream("grid_indicators.geojson"));
        GRID_INDICATORS = Data((List<Map>) geojson.get("features"));
    }

    @Test
    void testSimpleBarChart(TestInfo testInfo) {
        def chart = Chart(Data([
                ["a": "A", "b": 28], ["a": "B", "b": 55], ["a": "C", "b": 43],
                ["a": "D", "b": 91], ["a": "E", "b": 81], ["a": "F", "b": 53],
                ["a": "G", "b": 19], ["a": "H", "b": 87], ["a": "I", "b": 52]])).mark_bar().
                encode(X("a").nominal(), Y("b").quantitative())
        chart.save("target/${testInfo.displayName}.html")
        //chart.show()
    }

    @Test
    void testResponsiveBarChart(TestInfo testInfo) {
        def chart = Chart(cars()).mark_bar()
                .encode(X("Origin"), Y().count())
        chart.save("target/${testInfo.displayName}.html")
    }

    @Test
    void testSimpleHistogram(TestInfo testInfo) {
        def chart = Chart(cars()).mark_bar()
                .encode(X("Cylinders").quantitative().bin(true), Y().count())
        chart.save("target/${testInfo.displayName}.html")
    }

    @Test
    void testSimpleStackedAreaChart(TestInfo testInfo) {
        def chart = Chart(seattle_weather()).mark_area()
                .encode(X("date").temporal(), Y("precipitation").quantitative(), Color("weather").nominal())
        chart.save("target/${testInfo.displayName}.html")
    }

    @Test
    void testSimpleStripPlot(TestInfo testInfo) {
        def chart = Chart(cars()).mark_tick()
                .encode(X("Horsepower").quantitative(), Y("Cylinders").ordinal())
        chart.save("target/${testInfo.displayName}.html")
    }

    @Test
    void testHorizontalStackedBarChart(TestInfo testInfo) {
        def chart = Chart(seattle_weather()).mark_bar()
                .encode(X("precipitation").sum(), Y('weather'))
        chart.save("target/${testInfo.displayName}.html")
    }

    @Test
    void testLineChart(TestInfo testInfo) {
        def chart = Chart(seattle_weather()).mark_line()
                .encode(X("date").temporal(), Y('precipitation').quantitative())
        chart.save("target/${testInfo.displayName}.html")
    }

    @Test
    void testPointChart(TestInfo testInfo) {
        def chart = Chart(seattle_weather()).mark_point()
                .encode(X("date").temporal(), Y('precipitation').quantitative(), color('weather'))
        chart.save("target/${testInfo.displayName}.html")
    }

    @Test
    void testDisplayMap (TestInfo testInfo) {
        def chart = Chart(RSU_GEOINDICATORS).height(500).width(500).mark_geoshape();
        chart.save("target/${testInfo.displayName}.html")
    }

    @Test
    void testDisplayMapJSON (TestInfo testInfo) {
        def chart = Chart("{\"type\":\"Feature\",\"geometry\":{\"type\":\"Polygon\",\"coordinates\":[[[4.866735,46.263463],[4.866611,46.263508],[4.866568,46.263558],[4.866583,46.263596],[4.866645,46.263637],[4.866866,46.26371],[4.866915,46.263688],[4.866799,46.263561],[4.8667,46.26356],[4.866738,46.2635],[4.866735,46.263463]]]}}").height(500).width(500).mark_geoshape();
        chart.save("target/${testInfo.displayName}.html")
        //chart.show()
    }

    @Test
    void testDisplayMapWithCustomMark (TestInfo testInfo){
        Mark mark = new Mark();
        Def definition = new Def();
        definition.type = "geoshape"
        MarkFill markFill = new MarkFill()
        markFill.color = "#eee"
        definition.fill = markFill
        MarkStroke markStrokeDef = new MarkStroke()
        markStrokeDef.color = "#757575"
        definition.stroke = markStrokeDef
        mark.defValue = definition
        def chart = Chart(RSU_GEOINDICATORS).height(500).width(500).mark(mark)
        chart.save("target/${testInfo.displayName}.html")
        //chart.show()
    }

    @Test
    void testDisplayMapWithInterval (TestInfo testInfo) throws IOException {
        def chart = Maps().choroplethMap(RSU_GEOINDICATORS).field("properties.HIGH_VEGETATION_FRACTION").domain([0, 0.1, 0.2, 0.5]).range(["orange", "green", "blue", "black"])
                .title("A Map with interval")
                .height(500).width(700)
                .projection_identity()
        chart.save("target/" + testInfo.getDisplayName() + ".html");
        //chart.show()
    }
}