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


import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.io.CleanupMode
import org.junit.jupiter.api.io.TempDir

import java.nio.file.Files
import java.nio.file.Path
import java.util.stream.Collectors
import static org.orbisgis.demat.Plot.*

/**
 * @author Erwan Bocher, CNRS 2023-2024
 */
class BatchSpecsTest {

    @TempDir(cleanup = CleanupMode.ALWAYS)
    static File folder


    /**
     * Enable this test to run all vega test cases
     */
    @Disabled
    @Test
    void runBatchTest(){
        //folder = new File("/tmp/demat")
        //folder.mkdir()
        String data_path =new File(BatchSpecsTest.getResource("/data").toURI()).getAbsolutePath()
        Path specs_path =new File(BatchSpecsTest.getResource("/specs").toURI()).toPath()
        //specs_path = new File("/tmp/specs/geo_custom_projection.vl.json").toPath()
        List<Path> specs = Files.walk(specs_path)
                .filter(Files::isRegularFile)
                .collect(Collectors.toList())
        specs.each {it->
            String fileName = it.toFile().getName()
            //Do not draw in svg interactive vega spec
            if(!fileName.startsWith("interactive")) {
                def jsonSpec = FileUtils.json(it.toFile())
                replaceDeep(jsonSpec, "data", data_path)
                try {
                    println("Rendering spec ${fileName}")
                    //toJSON(jsonSpec,File.createTempFile(fileName, ".json", folder) )
                    toSVG(jsonSpec, File.createTempFile(fileName, ".svg", folder))
                    //toPNG(jsonSpec, File.createTempFile(fileName, ".png", folder))
                    println("Spec ${fileName} rendered")
                }
                catch (Exception ex) {
                    println("Error on " + it)
                }
            }
        }
    }

    static def replace (Map data, String key, String data_path) {
            String url = data."url"
            if (url) {
                if (url.startsWith("data") && url.endsWith(".json")) {
                    //Let's replace it with local values
                    //Remove data/
                    def data_json = FileUtils.json(new File("${data_path}${File.separator}${url.substring(5)}"))
                    data.remove("url")
                    data.put("values", data_json)
                } else if (url.startsWith("data") && url.endsWith(".csv")) {
                    //Let's replace it with local values
                    //Remove data/
                    def data_json = FileUtils.csv(new File("${data_path}${File.separator}${url.substring(5)}"))
                    data.remove("url")
                    data.put("values", data_json)
                } else if (url.startsWith("data") && url.endsWith(".tsv")) {
                    //Let's replace it with local values
                    //Remove data/
                    def data_json = FileUtils.tsv(new File("${data_path}${File.separator}${url.substring(5)}"))
                    data.remove("url")
                    data.put("values", data_json)
                }
            }
    }

    static def replaceDeep(def m, String key, String data_path) {
        if (m instanceof List) {
            m.each { it ->
                replaceDeep(it, key, data_path)
            }
        } else if (m instanceof Map) {
            m.each { k, v ->
                if (k == key) {
                    replace(v, key, data_path)
                } else {
                    replaceDeep(v, key, data_path)
                }
            }
        }
    }
}
