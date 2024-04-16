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

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInfo
import org.junit.jupiter.api.io.CleanupMode
import org.junit.jupiter.api.io.TempDir
import org.orbisgis.data.H2GIS

import static org.orbisgis.demat.Plot.*


class SimpleBarChartTest {

    @TempDir(cleanup = CleanupMode.ALWAYS)
    static File folder
    private TestInfo testInfo;


    @BeforeEach
    void initEach(TestInfo testInfo) {
        this.testInfo = testInfo;
    }


    @Test
    void testSimpleBarChart() {
        def spec = [
                description:"A simple bar chart with embedded data.",
                data: [values: [
                        ["a": "A", "b": 28], ["a": "B", "b": 55], ["a": "C", "b": 43],
                        ["a": "D", "b": 91], ["a": "E", "b": 81], ["a": "F", "b": 53],
                        ["a": "G", "b": 19], ["a": "H", "b": 87], ["a": "I", "b": 52]]
                      ],
                mark:"bar",
                encoding : [x : [field:"a",axis:[LabelAngle:0],type:"nominal"],
                            y:  [field:"b","type":"quantitative"]]]
        toSVG(spec, File.createTempFile(testInfo.displayName, ".svg", folder))
    }

    @Test
    void testStackedBarChart2() {
        H2GIS h2GIS = H2GIS.open("${folder.getAbsolutePath()+File.separator+ this.getClass().getName()}")
        h2GIS.load(SimpleBarChartTest.class.getClassLoader().getResource("rsu_geoindicators.geojson"), true)
          def spec =
          [  data : [
                      values : h2GIS.getSpatialTable("(SELECT the_geom FROM rsu_geoindicators limit 10)")],
              mark: [type : "geoshape", stroke: "blue", strokeWidth:1, "fill":null], projection:[type:"identity"],
                  "height":800, "width":800
          ]
        toSVG(spec, File.createTempFile(testInfo.displayName, ".svg", folder))
    }

    @Test
    void testStackedBarChart3() {
        def spec =
                [  data : [
                        values : toValues(SimpleBarChartTest.class.getClassLoader().getResource("rsu_geoindicators.geojson"))],
                   mark: [type : "geoshape", stroke: "blue", strokeWidth:1, "fill":null], projection:[type:"identity"],
                   "height":800, "width":800
                ]
        toSVG(spec, File.createTempFile(testInfo.displayName, ".svg", folder))
    }

}