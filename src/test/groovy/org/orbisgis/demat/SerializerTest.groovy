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

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.module.SimpleModule
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.io.CleanupMode
import org.junit.jupiter.api.io.TempDir
import org.orbisgis.data.H2GIS
import org.orbisgis.data.api.dataset.ISpatialTable

class SerializerTest {

    @TempDir(cleanup = CleanupMode.ALWAYS)
    static File folder
    public static H2GIS h2GIS

    @BeforeAll
    static void init() {
        h2GIS = H2GIS.open("${folder.getAbsolutePath()+File.separator+ this.getClass().getName()}")
        h2GIS.load(SerializerTest.class.getClassLoader().getResource("rsu_geoindicators.geojson"), true)
    }

    @Test
    void saveISpatialTableTest(){
        ObjectMapper mapper = new ObjectMapper()
        SimpleModule module = new SimpleModule()
        module.addSerializer(ISpatialTable.class, new SpatialTableSerializer())
        mapper.registerModule(module)
        String serialized = mapper.writeValueAsString(h2GIS.getSpatialTable("(SELECT the_geom from rsu_geoindicators limit 1)"))
        Assertions.assertEquals("[{\"type\":\"Feature\",\"geometry\":{\"type\":\"Polygon\",\"coordinates\":[[[4.866735,46.263463],[4.866611,46.263508],[4.866568,46.263558],[4.866583,46.263596],[4.866645,46.263637],[4.866866,46.26371],[4.866915,46.263688],[4.866799,46.263561],[4.8667,46.26356],[4.866738,46.2635],[4.866735,46.263463]]]}}]",
        serialized)
    }

    @Test
    void saveITableTest(){
        ObjectMapper mapper = new ObjectMapper()
        SimpleModule module = new SimpleModule()
        module.addSerializer(org.orbisgis.data.api.dataset.ITable.class, new TableSerializer())
        mapper.registerModule(module)
        String serialized = mapper.writeValueAsString(h2GIS.getTable("(SELECT id_rsu from rsu_geoindicators limit 1)"))
        Assertions.assertEquals("[{\"properties\":{\"ID_RSU\":4}}]", serialized)
    }
}
