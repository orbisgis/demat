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
package org.orbisgis.demat;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.h2gis.utilities.jts_utils.GeometryFeatureUtils;
import org.orbisgis.data.api.dataset.ISpatialTable;
import org.orbisgis.data.api.dataset.ITable;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;

/**
 * This class is used to serialize a {@code ITable} as json
 *
 * @author Erwan Bocher, CNRS 2023-2024
 */
public class TableSerializer extends StdSerializer<ITable> {

    public TableSerializer() {
        this(null);
    }

    public TableSerializer(Class<ITable> t) {
        super(t);
    }

    @Override
    public void serialize(ITable table, JsonGenerator jgen, SerializerProvider serializerProvider) throws IOException {
        if(table instanceof ISpatialTable){
            try {
                ISpatialTable spatialTable = table.getSpatialTable();
                ArrayList json = new ArrayList<>();
                Object geomCol = spatialTable.getGeometricColumns().stream().findFirst().get();
                Collection<String> columns = spatialTable.getColumnNames();
                columns.remove(geomCol);
                int colummSize = columns.size();
                while (spatialTable.next()) {
                    LinkedHashMap<String, Object> feature =  new LinkedHashMap();
                    feature.put("type", "Feature");
                    feature.putAll(GeometryFeatureUtils.toMap(spatialTable.getGeometry()));
                    if(colummSize>0) {
                        feature.put("properties", GeometryFeatureUtils.getProperties((ResultSet) spatialTable, columns));
                    }
                    json.add(feature);
                }
                jgen.writeObject(json);
            } catch (Exception e) {
                throw new IOException("Cannot serialize the spatial table " + table.getName(), e);
            }
        }
        else {
            try {
                ArrayList json = new ArrayList<>();
                Collection<String> columns = table.getColumnNames();
                int colummSize = columns.size();
                while (table.next()) {
                    if (colummSize > 0) {
                        json.add(GeometryFeatureUtils.getProperties((ResultSet) table, columns));
                    }
                }
                jgen.writeObject(json);
            } catch (Exception e) {
                throw new IOException("Cannot serialize the table " + table.getName(), e);
            }
        }
    }
}
