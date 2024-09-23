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

import com.caoccao.javet.interop.V8Host
import com.caoccao.javet.interop.V8Runtime
import com.caoccao.javet.interop.converters.JavetProxyConverter
import com.caoccao.javet.interop.engine.IJavetEngine
import com.caoccao.javet.interop.engine.JavetEnginePool
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

/**
 * @author Erwan Bocher, CNRS 2023-2024
 */
class JavetTest {

    @Disabled
    @Test
    void testMapAsInput() {
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

        V8Host v8Host = V8Host.getNodeInstance()
        JavetEnginePool<V8Runtime> javetEnginePool = new JavetEnginePool<>()
        javetEnginePool.getConfig().setEngineGuardCheckIntervalMillis(1000)
        javetEnginePool.getConfig().setJSRuntimeType(v8Host.getJSRuntimeType())
        IJavetEngine iJavetEngine = javetEnginePool.getEngine()
        V8Runtime  v8Runtime = iJavetEngine.getV8Runtime()
        v8Runtime.allowEval(true)

        v8Runtime.getExecutor(new File("/tmp/demat/js/vega.js")).executeVoid()
        v8Runtime.getExecutor(new File("/tmp/demat/js/vega-lite.js")).executeVoid()


        JavetProxyConverter javetProxyConverter = new JavetProxyConverter()
        v8Runtime.setConverter(javetProxyConverter)
        v8Runtime.getGlobalObject().set("ObjectMapper", ObjectMapper.class)
        //Loading the function
        String function =
                "function main(jsonspec) {\n" +
                        "let  test = new ObjectMapper();\n"+
                        "let spec =  test.writeValueAsString(jsonspec);" +
                        "var vegaspec = vegaLite.compile(JSON.parse(spec)).spec;" +
                        "    var view = new vega.View(vega.parse(vegaspec))\n" +
                        "            .renderer('none')\n" +
                        "            .initialize()\n" +
                        "            .run()\n" +
                        "            ;\n" +
                        "return view.toSVG();"+
                "}" ;
        v8Runtime.getExecutor(function).executeVoid()

        System.out.println(v8Runtime.getGlobalObject().invokeObject("main", spec).toString());

        // Step 9: Enforce the GC to avoid memory leak. (Optional)
        System.gc();
        System.runFinalization();
        v8Runtime.lowMemoryNotification();

    }
}
