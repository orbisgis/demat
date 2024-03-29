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
import org.junit.jupiter.api.io.TempDir
import org.orbisgis.demat.vega.Def
import org.orbisgis.demat.vega.Mark
import org.orbisgis.demat.vega.MarkFill
import org.orbisgis.demat.vega.MarkStroke
import org.orbisgis.demat.vega.data.Data

import static org.orbisgis.demat.DataTests.*
import static org.orbisgis.demat.Plot.*
import org.junit.jupiter.api.io.CleanupMode;

/**
 * @author Erwan Bocher, CNRS 2021 - 2023
 */
class GroovyPlotTest {


    private static Data GRID_INDICATORS = null
    private static Data RSU_GEOINDICATORS = null

    @TempDir(cleanup = CleanupMode.NEVER)
    static File folder

    @BeforeAll
    static void loadData() {
        LinkedHashMap geojson = (LinkedHashMap) Read.json(GroovyPlotTest.class.getClassLoader().getResourceAsStream("rsu_geoindicators.geojson"))
        RSU_GEOINDICATORS = Data((List<Map>) geojson.get("features"))
        geojson = (LinkedHashMap) Read.json(GroovyPlotTest.class.getClassLoader().getResourceAsStream("grid_indicators.geojson"))
        GRID_INDICATORS = Data((List<Map>) geojson.get("features"))
    }

    @Test
    void testSimpleBarChart() {
        def chart = Chart(Data([
                ["a": "A", "b": 28], ["a": "B", "b": 55], ["a": "C", "b": 43],
                ["a": "D", "b": 91], ["a": "E", "b": 81], ["a": "F", "b": 53],
                ["a": "G", "b": 19], ["a": "H", "b": 87], ["a": "I", "b": 52]])).mark(Bar())
                encode(X("a").nominal(), Y("b").quantitative())
        chart.save(File.createTempFile("demat",".svg", folder))
    }

    @Test
    void testSimpleBarChartReplaceLabels() {
        def chart = Chart(Data([
                ["a": "A", "b": 28], ["a": "B", "b": 55], ["a": "C", "b": 43],
                ["a": "D", "b": 91], ["a": "E", "b": 81], ["a": "F", "b": 53],
                ["a": "G", "b": 19], ["a": "H", "b": 87], ["a": "I", "b": 52]])).mark(Bar()).
                encode(X("a").nominal().replaceLabels(["A": "Demat", "B": "is", "C": "good"]), Y("b").quantitative())
        chart.save(File.createTempFile("demat",".svg", folder))
    }

    @Test
    void testMinusXSortedOnYAxisAggregateBarChart() {
        def chart = Chart(Data([
                ["age": 0,"people": 1483789], ["age": 0,"people": 1450376],
                ["age": 5,"people": 2411067], ["age": 5,"people": 1359668],
                ["age": 10,"people": 1260099], ["age": 10,"people": 1216114]])).mark(Bar())
                .encode(X("people").sum().title("population"), Y("age").ordinal().sort_minusX())
        chart.save(File.createTempFile("demat",".svg", folder))
    }

    @Test
    void testXSortedOnYAxisAggregateBarChart() {
        def chart = Chart(Data([
                ["age": 0,"people": 1483789], ["age": 0,"people": 1450376],
                ["age": 5,"people": 2411067], ["age": 5,"people": 1359668],
                ["age": 10,"people": 1260099], ["age": 10,"people": 1216114]])).mmark(Bar())
                .encode(X("people").sum().title("population"), Y("age").ordinal().sort_x())
        chart.save(File.createTempFile("demat",".svg", folder))
    }

    @Test
    void testMinusYSortedOnYAxisAggregateBarChart() {
        def chart = Chart(Data([
                ["age": 0,"people": 1483789], ["age": 0,"people": 1450376],
                ["age": 5,"people": 2411067], ["age": 5,"people": 1359668],
                ["age": 10,"people": 1260099], ["age": 10,"people": 1216114]])).mark(Bar())
                .encode(X("people").sum().title("population"), Y("age").ordinal().sort_minusY())
        chart.save(File.createTempFile("demat",".svg", folder))
    }

    @Test
    void testYSortedOnYAxisAggregateBarChart() {
        def chart = Chart(Data([
                ["age": 0,"people": 1483789], ["age": 0,"people": 1450376],
                ["age": 5,"people": 2411067], ["age": 5,"people": 1359668],
                ["age": 10,"people": 1260099], ["age": 10,"people": 1216114]])).mark(Bar())
                .encode(X("people").sum().title("population"), Y("age").ordinal().sort_y())
        chart.save(File.createTempFile("demat",".svg", folder))
    }

    @Test
    void testMinusXSortedOnXAxisAggregateBarChart() {
        def chart = Chart(Data([
                ["age": 0,"people": 1483789], ["age": 0,"people": 1450376],
                ["age": 5,"people": 2411067], ["age": 5,"people": 1359668],
                ["age": 10,"people": 1260099], ["age": 10,"people": 1216114]])).mark(Bar())
                .encode(X("age").ordinal().sort_minusX(), Y("people").sum().title("population"))
        chart.save(File.createTempFile("demat",".svg", folder))
    }

    @Test
    void testXSortedOnXAxisAggregateBarChart() {
        def chart = Chart(Data([
                ["age": 0,"people": 1483789], ["age": 0,"people": 1450376],
                ["age": 5,"people": 2411067], ["age": 5,"people": 1359668],
                ["age": 10,"people": 1260099], ["age": 10,"people": 1216114]])).mark(Bar())
                .encode(X("age").ordinal().sort_x(), Y("people").sum().title("population"))
        chart.save(File.createTempFile("demat",".svg", folder))
    }

    @Test
    void testMinusYSortedOnXAxisAggregateBarChart() {
        def chart = Chart(Data([
                ["age": 0,"people": 1483789], ["age": 0,"people": 1450376],
                ["age": 5,"people": 2411067], ["age": 5,"people": 1359668],
                ["age": 10,"people": 1260099], ["age": 10,"people": 1216114]])).mark(Bar())
                .encode(X("age").ordinal().sort_minusY(), Y("people").sum().title("population"))
        chart.save(File.createTempFile("demat",".svg", folder))
    }

    @Test
    void testYSortedOnXAxisAggregateBarChart() {
        def chart = Chart(Data([
                ["age": 0,"people": 1483789], ["age": 0,"people": 1450376],
                ["age": 5,"people": 2411067], ["age": 5,"people": 1359668],
                ["age": 10,"people": 1260099], ["age": 10,"people": 1216114]])).mark(Bar())
                .encode(X("age").ordinal().sort_y(), Y("people").sum().title("population"))
        chart.save(File.createTempFile("demat",".svg", folder))
    }

    @Test
    void testXAscendingSortedAggregateBarChart() {
        def chart = Chart(Data([
                ["age": 0,"people": 1483789], ["age": 0,"people": 1450376],
                ["age": 5,"people": 2411067], ["age": 5,"people": 1359668],
                ["age": 10,"people": 1260099], ["age": 10,"people": 1216114]])).mark(Bar())
                .encode(X("people").sum().sort_ascending().title("population"), Y("age").ordinal())
        chart.save(File.createTempFile("demat",".svg", folder))
    }

    @Test
    void testYAscendingSortedAggregateBarChart() {
        def chart = Chart(Data([
                ["age": 0,"people": 1483789], ["age": 0,"people": 1450376],
                ["age": 5,"people": 2411067], ["age": 5,"people": 1359668],
                ["age": 10,"people": 1260099], ["age": 10,"people": 1216114]])).mark(Bar())
                .encode(X("people").sum().title("population"), Y("age").ordinal().sort_ascending())
        chart.save(File.createTempFile("demat",".svg", folder))
    }

    @Test
    void testXDescendingSortedAggregateBarChart() {
        def chart = Chart(Data([
                ["age": 0,"people": 1483789], ["age": 0,"people": 1450376],
                ["age": 5,"people": 2411067], ["age": 5,"people": 1359668],
                ["age": 10,"people": 1260099], ["age": 10,"people": 1216114]])).mark(Bar())
                .encode(X("people").sum().sort_descending().title("population"), Y("age").ordinal())
        chart.save(File.createTempFile("demat",".svg", folder))
    }

    @Test
    void testYDescendingSortedAggregateBarChart() {
        def chart = Chart(Data([
                ["age": 0,"people": 1483789], ["age": 0,"people": 1450376],
                ["age": 5,"people": 2411067], ["age": 5,"people": 1359668],
                ["age": 10,"people": 1260099], ["age": 10,"people": 1216114]])).mark(Bar())
                .encode(X("people").sum().title("population"), Y("age").ordinal().sort_descending())
        chart.save(File.createTempFile("demat",".svg", folder))
    }

    @Test
    void testXColorSortedAggregateBarChart() {
        def chart = Chart(Data([
                ["category": "A","sex": 1,"people": 1483789], ["category": "B","sex": 2,"people": 1450376],
                ["category": "C","sex": 1,"people": 2411067], ["category": "D","sex": 2,"people": 1359668],
                ["category": "E","sex": 1,"people": 1260099], ["category": "F","sex": 2,"people": 1216114]])).mark(Bar())
                .encode(X("category").sort_color().title("population"), Y("people").quantitative(),Color("sex"))
        chart.save(File.createTempFile("demat",".svg", folder))
    }

    @Test
    void testYColorSortedAggregateBarChart() {
        def chart = Chart(Data([
                ["category": "A","sex": 1,"people": 1483789], ["category": "B","sex": 2,"people": 1450376],
                ["category": "C","sex": 1,"people": 2411067], ["category": "D","sex": 2,"people": 1359668],
                ["category": "E","sex": 1,"people": 1260099], ["category": "F","sex": 2,"people": 1216114]])).mark(Bar())
                .encode(X("people").quantitative(), Y("category").sort_color().title("population"),Color("sex"))
        chart.save(File.createTempFile("demat",".svg", folder))
    }

    @Test
    void testYMinusColorSortedAggregateBarChart() {
        def chart = Chart(Data([
                ["category": "A","sex": 1,"people": 1483789], ["category": "B","sex": 2,"people": 1450376],
                ["category": "C","sex": 1,"people": 2411067], ["category": "D","sex": 2,"people": 1359668],
                ["category": "E","sex": 1,"people": 1260099], ["category": "F","sex": 2,"people": 1216114]])).mark(Bar())
                .encode(X("people").quantitative(), Y("category").sort_minusColor().title("population"),Color("sex"))
        chart.save(File.createTempFile("demat",".svg", folder))
    }

    @Test
    void testXMinusColorSortedAggregateBarChart() {
        def chart = Chart(Data([
                ["category": "A","sex": 1,"people": 1483789], ["category": "B","sex": 2,"people": 1450376],
                ["category": "C","sex": 1,"people": 2411067], ["category": "D","sex": 2,"people": 1359668],
                ["category": "E","sex": 1,"people": 1260099], ["category": "F","sex": 2,"people": 1216114]])).mark(Bar())
                .encode(X("category").sort_minusColor().title("population"), Y("people").quantitative(),Color("sex"))
        chart.save(File.createTempFile("demat",".svg", folder))
    }

    @Test
    void testResponsiveBarChart() {
        def chart = Chart(cars()).mark(Bar())
                .encode(X("Origin"), Y().count())
        chart.save(File.createTempFile("demat",".svg", folder))
    }

    @Test
    void testSimpleHistogram() {
        def chart = Chart(cars()).mark(Bar())
                .encode(X("Cylinders").quantitative().bin(true), Y().count())
        chart.save(File.createTempFile("demat",".svg", folder))
    }

    @Test
    void testSimpleStackedAreaChart() {
        def chart = Chart(seattle_weather()).mark(Area())
                .encode(X("date").temporal(), Y("precipitation").quantitative(), Color("weather").nominal())
        chart.save(File.createTempFile("demat",".svg", folder))
    }

    @Test
    void testSimpleStackedAreaChartColored() {
        def chart = Chart(seattle_weather()).mark(Area())
                .encode(X("date").temporal(), Y("precipitation").quantitative(),
                        Color("weather", ["drizzle": "red","rain": "blue", "sun":"yellow"]).nominal())
        chart.save(File.createTempFile("demat",".svg", folder))
    }

    @Test
    void testSimpleStripPlot() {
        def chart = Chart(cars()).mark(Tick())
                .encode(X("Horsepower").quantitative(), Y("Cylinders").ordinal())
        chart.save(File.createTempFile("demat",".svg", folder))
    }

    @Test
    void testHorizontalStackedBarChart() {
        def chart = Chart(seattle_weather()).mark(Bar())
                .encode(X("precipitation").sum(), Y('weather'))
        chart.save(File.createTempFile("demat",".svg", folder))
    }

    @Test
    void testLineChart() {
        def chart = Chart(seattle_weather()).mark(Line())
                .encode(X("date").temporal(), Y('precipitation').quantitative())
        chart.save(File.createTempFile("demat",".svg", folder))
    }

    @Test
    void testPointChart() {
        def chart = Chart(seattle_weather()).mark(Point())
                .encode(X("date").temporal(), Y('precipitation').quantitative(), Color('weather'))
        chart.save(File.createTempFile("demat",".svg", folder))
    }

    @Test
    void testSquareChart() {
        def chart = Chart(seattle_weather()).mark(Square())
                .encode(X("date").temporal(), Y('precipitation').quantitative(), Color('weather'))
        chart.save(File.createTempFile("demat",".svg", folder))
    }

    @Test
    void testTextTableHeatmap() {
        Chart rectChart = Chart().mark(Rect()).encode(Color("num_cars",
                Legend().horizontal().gradientLength(120)).quantitative().title("Count of Records"))
        Chart textChart = Chart().mark(Text()).encode(Text("num_cars").quantitative(),
        Color(Condition("datum['num_cars'] < 40", "black"), Gradient("white")))

        Plot(cars(),Title(["This is a global title ", "With a subTitle"], TitleParams().left()),
                Transform(Count("num_cars"), GroupBy("Origin", "Cylinders")),
                Encoding(Y("Origin").ordinal(), X("Cylinders").ordinal())).layer(rectChart, textChart)
               .save(File.createTempFile("demat",".svg", folder))
    }

    @Test
    void testDisplayMap () {
        def chart = Chart(RSU_GEOINDICATORS).height(500).width(500).mark(Geoshape())
        chart.save(File.createTempFile("demat",".svg", folder))
    }

    @Test
    void testDisplayMapJSON () {
        def chart = Chart(Data("{\"type\":\"Feature\",\"geometry\":{\"type\":\"Polygon\",\"coordinates\":[[[4.866735,46.263463],[4.866611,46.263508],[4.866568,46.263558],[4.866583,46.263596],[4.866645,46.263637],[4.866866,46.26371],[4.866915,46.263688],[4.866799,46.263561],[4.8667,46.26356],[4.866738,46.2635],[4.866735,46.263463]]]}}")).height(500).width(500).mark(Geoshape())
        chart.save(File.createTempFile("demat",".svg", folder))
    }

    @Test
    void testDisplayMapWithCustomMark (){
        Mark mark = new Mark()
        Def definition = new Def()
        definition.type = "geoshape"
        MarkFill markFill = new MarkFill()
        markFill.color = "#eee"
        definition.fill = markFill
        MarkStroke markStrokeDef = new MarkStroke()
        markStrokeDef.color = "#757575"
        definition.stroke = markStrokeDef
        mark.def = definition
        def chart = Chart(RSU_GEOINDICATORS, mark).height(500).width(500)
        chart.save(File.createTempFile("demat",".svg", folder))
    }

    @Test
    void testDisplayMapWithInterval() throws IOException {
        def chart = ChoroplethMap(RSU_GEOINDICATORS).
                field("properties.HIGH_VEGETATION_FRACTION").domain([0, 0.1, 0.2, 0.5])
                .range(["orange", "green", "blue", "black"])
                .labels("{'0': 'Low', '0.1': 'Moderate', '0.2': 'High', '0.5': 'Very high'}[datum.label]")
                .title("A Map with interval")
                .height(500).width(700)
        chart.save(File.createTempFile("demat",".svg", folder))
    }

    @Test
    void testWithDataSet(){
        def data_1 = Data([
                ["a": "A", "b": 28], ["a": "B", "b": 55], ["a": "C", "b": 43],
                ["a": "D", "b": 91], ["a": "E", "b": 81], ["a": "F", "b": 53],
                ["a": "G", "b": 19], ["a": "H", "b": 87], ["a": "I", "b": 52]])
        data_1.setName("data_1")
        def data_2 = Data([
                ["category": "A","sex": 1,"people": 1483789], ["category": "B","sex": 2,"people": 1450376],
                ["category": "C","sex": 1,"people": 2411067], ["category": "D","sex": 2,"people": 1359668],
                ["category": "E","sex": 1,"people": 1260099], ["category": "F","sex": 2,"people": 1216114]])
        data_2.setName("data_2")
        def plot = Plot(DataSet(data_1,data_2))
        def chart_1 = Chart(Data().name("data_1")).mark(Bar()).
                encode(X("a").nominal(), Y("b").quantitative())
        def chart_2 = Chart(Data().name("data_2")).mark(Bar())
                .encode(X("category").sort_color().title("population"), Y("people").quantitative(),Color("sex"))
        plot.concat(chart_1, chart_2).save(File.createTempFile("demat",".svg", folder))
    }

    @Test
    void testDomainScaleRangeBarChart() {
        def chart = Chart(Data([
                ["a": "A", "b": 28], ["a": "B", "b": 55], ["a": "C", "b": 43],
                ["a": "D", "b": 91], ["a": "E", "b": 81], ["a": "F", "b": 53],
                ["a": "G", "b": 19], ["a": "H", "b": 87], ["a": "I", "b": 52]])).mark(Bar()).
                encode(X("a").nominal(), Y("b").quantitative(), Color("b",Scale(Domain([28,55]), Range(['#8b0101', '#cc0200']))))
        chart.save(File.createTempFile("demat",".svg", folder))
    }

    @Test
    void testLabelsLegendBarChart() {
        def chart = Chart(Data([
                ["a": "A", "b": 28], ["a": "B", "b": 55], ["a": "C", "b": 43],
                ["a": "D", "b": 91], ["a": "E", "b": 81], ["a": "F", "b": 53],
                ["a": "G", "b": 19], ["a": "H", "b": 87], ["a": "I", "b": 52]])).mark(Bar()).
                encode(X("a").nominal(), Y("b").quantitative(),
                        Color("b",Scale(Domain([28,55]), Range(['#8b0101', '#cc0200'])),
                                Legend("A title for the legend").labels("{'28': 'Slow', '55': 'Fast'}[datum.label]")))
        chart.save(File.createTempFile("demat",".svg", folder))
    }

    @Test
    void testBoxPlot() {
        def chart = Chart(Data([
                ["a": "A", "b": 28], ["a": "B", "b": 55], ["a": "C", "b": 43],
                ["a": "D", "b": 91], ["a": "E", "b": 81], ["a": "F", "b": 53],
                ["a": "G", "b": 19], ["a": "H", "b": 87], ["a": "I", "b": 52]])).mark(BoxPlot()).
                encode(X("b").quantitative())
        chart.save(File.createTempFile("demat",".svg", folder))
    }

    @Test
    void testPieChart() {
        def chart = Chart(Data([
                ["category": 1, "value": 4],
                ["category": 2, "value": 6],
                ["category": 3, "value": 10],
                ["category": 4, "value": 3],
                ["category": 5, "value": 7],
                ["category": 6, "value": 8]])).mark(Arc()).
                encode(Theta("value").quantitative(), Color("category").nominal())
        chart.save(File.createTempFile("demat",".svg", folder))
    }

    @Test
    void testDonutChart() {
        def chart = Chart(Data([
                ["category": 1, "value": 4],
                ["category": 2, "value": 6],
                ["category": 3, "value": 10],
                ["category": 4, "value": 3],
                ["category": 5, "value": 7],
                ["category": 6, "value": 8]])).mark(Arc().innerRadius(50)).
                encode(Theta("value").quantitative(), Color("category").nominal())
        chart.show()
        chart.save(File.createTempFile("demat",".svg", folder))
    }

    @Test
    void testPieChartCustom() {
        def chart = Chart(Data([
                ["category": 1, "value": 4],
                ["category": 2, "value": 6],
                ["category": 3, "value": 10],
                ["category": 4, "value": 3],
                ["category": 5, "value": 7],
                ["category": 6, "value": 8]])).mark(Arc().tooltip(true)).
                encode(Theta("value").quantitative(), Color("category").nominal())
        chart.save(File.createTempFile("demat",".svg", folder))
    }

    @Test
    void testPieChartDirections() {
        Data data = Data([["category": "N", "value": 236142.1],
                     ["category": "NNE", "value": 198490.641],
                     ["category": "NE", "value": 180178.693],
                     ["category": "ENE", "value": 225907.263],
                     ["category": "E", "value": 285517.046],
                     ["category": "ESE", "value": 314869.103],
                     ["category": "SE", "value": 401478.068],
                     ["category": "SSE", "value": 329396.276],
                     ["category": "S", "value": 208707.178],
                     ["category": "SSW", "value": 359787.985],
                     ["category": "SW", "value": 153546.442],
                     ["category": "WSW", "value": 93985.971],
                     ["category": "W", "value": 51060.691],
                     ["category": "WNW", "value": 107711.766],
                     ["category": "NW", "value": 309127.719],
                     ["category": "NNW", "value": 449500.89]])

        Plot(data, Encoding(Theta("category").nominal(),
                Radius("value", Scale().quantile().zero().rangeMin(5)), Color().value("#87afe0")))
                .layer(Mark(Arc().innerRadius(20).stroke("#55759a")),
                        Chart().mark(Text().radiusOffset(20)).encode(Text("category").nominal())).save("/tmp/donut.svg")
    }

    @Test
    void testConcatMaps() throws IOException {
        def chart = ChoroplethMap(RSU_GEOINDICATORS).
                field("properties.HIGH_VEGETATION_FRACTION").domain([0, 0.1, 0.2, 0.5])
                .range(["orange", "green", "blue", "black"])
                .labels("{'0': 'Low', '0.1': 'Moderate', '0.2': 'High', '0.5': 'Very high'}[datum.label]")
                .title("HIGH_VEGETATION_FRACTION")
                .height(500).width(700)

        def chart1 = ChoroplethMap(RSU_GEOINDICATORS).
                field("properties.LOW_VEGETATION_FRACTION").domain([0, 0.1, 0.2, 0.5])
                .range(["orange", "green", "blue", "black"])
                .labels("{'0': 'Low', '0.1': 'Moderate', '0.2': 'High', '0.5': 'Very high'}[datum.label]").legend("Fraction")
                .title("LOW_VEGETATION_FRACTION")
                .height(500).width(700)
        chart.save("/tmp/test.json")
        Plot().concat(chart, chart1).save(File.createTempFile("demat",".svg", folder))
    }

    @Test
    void testPolarChart()  throws IOException {
        lot(Projection().azimuthalEquidistant().rotate([0,90,180]),
                Layer(
                        Chart(Data(Graticule().step([45,45]))).mark(Geoshape().filled(false).
                                strokeWidth(0.2).color("black")),
                        Chart(Data([[   "theta": 0, "r": 100, "label": "N"],
                                    ["theta": 22.5, "r": 125, "label": "NNE"],
                                    ["theta": 45, "r": 100, "label": "NE"],
                                    ["theta": 90, "r": 100, "label": "E"],
                                    ["theta": 135, "r": 100, "label": "SE"],
                                    ["theta": -180, "r": 100, "label": "S"],
                                    ["theta": -135, "r": 100, "label": "SW"],
                                    ["theta": -90, "r": 100, "label": "W"],
                                    ["theta": -45, "r": 100, "label": "NW"]])).encode(Longitude("theta"),
                                Latitude("r"),Text("label")).mark(Text()),
                        Chart(Data()).mark(Arc().theta(Radians(-22.5)).theta2(Radians(22.5)).radius(100)),
                        Chart(Data()).mark(Arc().theta(Radians(22.5)).theta2(Radians(67.5)).radius(10)),
                        Chart(Data()).mark(Arc().theta(Radians(67.5)).theta2(Radians(112.5)).radius(80)),
                        Chart(Data()).mark(Arc().theta(Radians(112.5)).theta2(Radians(157.5)).radius(50)),
                        Chart(Data()).mark(Arc().theta(Radians(157.5)).theta2(Radians(202.5)).radius(150)),
                        Chart(Data()).mark(Arc().theta(Radians(202.5)).theta2(Radians(247.5)).radius(10)),
                        Chart(Data()).mark(Arc().theta(Radians(247.5)).theta2(Radians(292.5)).radius(115)),
                        Chart(Data()).mark(Arc().theta(Radians(292.5)).theta2(Radians(337.5)).radius(50))
                )).height(500).width(500).save(File.createTempFile("demat",".svg", folder))
    }


    //Exemples
    /*
    Add text source
    {
      "data": {"name": "empty"},
      "mark": {
        "type": "text",
        "dx": -85,
        "dy": 10,
        "text": "(C) OpenStreetMap contributors"
      },
      "encoding": {
        "x": {"value": {"expr": 400}},
        "y": {"value": {"expr": 400}}
        //"width" : default param
      }
    }
     */
}