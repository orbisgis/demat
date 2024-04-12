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
package org.orbisgis.demat;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Utilities to read data, json and csv
 *
 * @author Erwan Bocher, CNRS 2021 - 2023
 */
public class Read {


    /**
     *
     * @param reader
     * @return
     * @throws IOException
     */
    public static Object json(InputStream reader)  {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(reader, Object.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *
     * @param jsonFile
     * @return
     * @throws IOException
     */
    public static Object json(File jsonFile) throws IOException {
        if(FileUtils.isExtensionWellFormated(jsonFile, "json", "geojson")) {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(jsonFile, Object.class);
        }
        throw new RuntimeException("Cannot read as json file.");
    }

    /**
     *
     * @param jsonFile
     * @return
     * @throws IOException
     */
    public static Object geojson(File jsonFile) throws IOException {
        if(FileUtils.isExtensionWellFormated(jsonFile,  "json", "geojson")) {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(jsonFile, Object.class);
        }
        throw new RuntimeException("Cannot read as json file.");
    }


    /**
     * Read a CSV {@link File} and convert it to a Data object
     * @param csvFile
     * @return
     * @throws IOException
     */
    public static List csv(File csvFile) throws IOException {
        if(FileUtils.isExtensionWellFormated(csvFile,  "csv")) {
            String line = "";
            //use comma as separator
            String splitBy = ",";

            ArrayList lines = new ArrayList();
            try (BufferedReader br =
                         new BufferedReader(new FileReader(csvFile))) {

                //Header
                line = br.readLine();
                String[] header = null;
                if (line != null) {
                    header = line.split(splitBy);
                }
                while ((line = br.readLine()) != null) {
                    Map<String, Object> values = new HashMap<>();
                    String[] csvValues = line.split(splitBy);
                    for (int i = 0; i < header.length; i++) {
                        values.put(header[i], csvValues[i]);
                    }
                    lines.add(values);
                }
            }

            return lines;
        }
        return null;
    }
}
