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
 * Copyright (C) 2021-2024 CNRS (Lab-STICC UMR CNRS 6285)
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

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInfo
import org.junit.jupiter.api.io.CleanupMode
import org.junit.jupiter.api.io.TempDir
import org.orbisgis.data.H2GIS

import static org.orbisgis.demat.Plot.*


/**
 * @author Erwan Bocher, CNRS 2023-2024
 */
class ChartsTest {

    @TempDir(cleanup = CleanupMode.ALWAYS)
    static File folder
    private TestInfo testInfo
    private static H2GIS h2GIS

    @BeforeAll
    static void init(){
        folder = new File("/tmp/test")
        folder.mkdir()
        h2GIS = H2GIS.open("${folder.getAbsolutePath()+File.separator+ this.getClass().getName()}")
        h2GIS.load(ChartsTest.class.getResource("grid_indicators.geojson"), true)
    }

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
    void testGeoShape() {
          def spec =
          [  data : [
                      values : h2GIS.getSpatialTable("(SELECT the_geom FROM grid_indicators limit 10)")],
              mark: [type : "geoshape", stroke: "blue", strokeWidth:1, "fill":null], projection:[type:"identity"],
                  "height":800, "width":800
          ]
        toSVG(spec,File.createTempFile(testInfo.displayName, ".svg", folder))
    }

    @Test
    void testGeoShape2() {
        def spec =
                [  data : [
                        url : ChartsTest.class.getResource("rsu_geoindicators.geojson").getPath()],
                   mark: [type : "geoshape", stroke: "blue", strokeWidth:1, "fill":null], projection:[type:"identity"],
                   "height":800, "width":800
                ]
        toSVG(spec, "/tmp/test.svg")//File.createTempFile(testInfo.displayName, ".svg", folder))
    }

    @Test
    void testSimpleChart() {
        def spec =
                [  data : [
                        values : h2GIS.getTable("(SELECT LCZ_PRIMARY, SUM(ST_AREA(THE_GEOM)) AS AREA FROM grid_indicators group by LCZ_PRIMARY ORDER BY LCZ_PRIMARY)")],
                   mark: [type : "bar"],
                        encoding:[ x:[field:"LCZ_PRIMARY", type: "nominal"], y:[field:"AREA", type:"quantitative"],
                                   color:[field:"LCZ_PRIMARY", type: "nominal"]],
                   "height":800, "width":800
                ]
        toSVG(spec, File.createTempFile(testInfo.displayName, ".svg", folder))
    }

    @Test
    void testPolarChart(){
        def spec=[
                "height":500,"width":500,
                "projection":["type" : "azimuthalEquidistant", "rotate" : [0,90,180]],
                "layer":[
                        ["data": ["values":[[   "theta": 0, "r": 100, "label": "N"],
                                            ["theta": 22.5, "r": 125, "label": "NNE"],
                                            ["theta": 45, "r": 100, "label": "NE"],
                                            ["theta": 90, "r": 100, "label": "E"],
                                            ["theta": 135, "r": 100, "label": "SE"],
                                            ["theta": -180, "r": 100, "label": "S"],
                                            ["theta": -135, "r": 100, "label": "SW"],
                                            ["theta": -90, "r": 100, "label": "W"],
                                            ["theta": -45, "r": 100, "label": "NW"]]],
                         "encoding":["longitude": ["field":"theta"], "latitude":["field":"r"], "text":["field":"label"]],
                         "mark":"text"],
                        ["data":["values":[[]]],
                         "mark":["type":"arc","theta":Math.toRadians(-22.5),"theta2":Math.toRadians(22.5),
                                 "radius":100]
                        ],  ["data":["values":[[]]],
                             "mark":["type":"arc","theta":Math.toRadians(22.5),"theta2":Math.toRadians(67.5),
                                     "radius":10]
                        ],  ["data":["values":[[]]],
                             "mark":["type":"arc","theta":Math.toRadians(67.5),"theta2":Math.toRadians(112.5),
                                     "radius":20]
                        ],  ["data":["values":[[]]],
                             "mark":["type":"arc","theta":Math.toRadians(112.5),"theta2":Math.toRadians(157.5),
                                     "radius":80]
                        ],  ["data":["values":[[]]],
                             "mark":["type":"arc","theta":Math.toRadians(157.5),"theta2":Math.toRadians(202.5),
                                     "radius":100]
                        ],  ["data":["values":[[]]],
                             "mark":["type":"arc","theta":Math.toRadians(202.5),"theta2":Math.toRadians(247.5),
                                     "radius":150]
                        ],  ["data":["values":[[]]],
                             "mark":["type":"arc","theta":Math.toRadians(247.5),"theta2":Math.toRadians(292.5),
                                     "radius":100]
                        ],  ["data":["values":[[]]],
                             "mark":["type":"arc","theta":Math.toRadians(292.5),"theta2":Math.toRadians(337.5),
                                     "radius":100]
                        ],
                        ["data": [
                                "graticule": [
                                        "step": [
                                                45,
                                                45
                                        ]
                                ]
                        ],
                         "mark": [
                                 "type": "geoshape", "filled":false, "strokeWidth":0.2,"color":"black"
                         ]]
                ]
        ]
        toSVG(spec, File.createTempFile(testInfo.displayName, ".svg", folder))
    }

    @Test
    void testSpecLocalFile() {
        def spec = [data: [url:"/test"]]
        findDeep(spec )
        Assertions.assertEquals([data: [url:"/test"]],spec )
        spec = [data: [url:"/test.json"]]
        findDeep(spec )
        Assertions.assertTrue(spec.data.values instanceof LocalFile )
    }
}