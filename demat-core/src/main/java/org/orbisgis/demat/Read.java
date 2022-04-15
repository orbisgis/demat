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
import org.orbisgis.demat.vega.data.Data;
import org.orbisgis.demat.vega.data.DataValues;
import org.orbisgis.demat.vega.data.InlineDataset;

import java.io.*;
import java.util.*;

/**
 * Utilities to read data, json and csv
 *
 * @author Erwan Bocher, CNRS 2021
 */
public class Read {

    /**
     * Read a CSV file and convert it to a Data object
     * @param csvFile
     * @return
     * @throws IOException
     */
    public  static Data csv(File csvFile) throws IOException {
        if(isExtensionWellFormated(csvFile, "csv")) {
            List<InlineDataset> inlines = new ArrayList<InlineDataset>();
            String line = "";
            //use comma as separator
            String splitBy = ",";
            try (BufferedReader br =
                         new BufferedReader(new FileReader(csvFile))) {
                //Header
                line = br.readLine();
                String[]  header = null;
                if(line!=null){
                    header = line.split(splitBy);
                }
                while ((line = br.readLine()) != null)
                {
                    Map<String, Object> values = new HashMap<>();
                    String[] csvValues = line.split(splitBy);
                    for (int i = 0; i < header.length; i++) {
                        values.put(header[i], csvValues[i]);
                    }
                    InlineDataset inlineDataset = new InlineDataset();
                    inlineDataset.anythingMapValue=values;
                    inlines.add(inlineDataset);
                }
            }
            if(inlines.isEmpty()){
                return null;
            }
            Data data = new Data();
            DataValues dataValues = new DataValues();
            dataValues.unionArrayValue = inlines;
            data.setValues(dataValues);
            return data;
        }
        return null;
    }


    /**
     * @param reader
     * @return
     * @throws IOException
     */
    public static Data fromJSON(InputStream reader) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(reader, Data.class);
    }

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
    public static <T> T json(File jsonFile) throws IOException {
        if(Read.isExtensionWellFormated(jsonFile, "json")) {
            ObjectMapper mapper = new ObjectMapper();
            return (T) mapper.readValue(jsonFile, Object.class);
        }else if(Read.isExtensionWellFormated(jsonFile, "geojson")){
            ObjectMapper mapper = new ObjectMapper();
            LinkedHashMap result = mapper.readValue(jsonFile, LinkedHashMap.class);
            return (T) result.get("features");
        }
        throw new RuntimeException("Cannot read as json file.");
    }


    /**
     * Check if the file has the good extension
     * @param file
     * @param prefixes
     * @return
     */
    public static boolean isExtensionWellFormated(File file, String... prefixes) {
        if(file==null){
            throw new RuntimeException("The file is null.");
        }
        if(file.isDirectory()){
            throw new RuntimeException("The file is a directory.");
        }
        if(!file.exists()){
            throw new RuntimeException("The file doesn't exist.");
        }
        String path = file.getAbsolutePath();
        String extension = "";
        int i = path.lastIndexOf('.');
        if (i >= 0) {
            extension = path.substring(i + 1);
        }

        for (String prefix:prefixes) {
            if(prefix!=null && !prefix.isEmpty()) {
                if(extension.equalsIgnoreCase(prefix)){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Read a CSV {@link InputStream} and convert it to a Data object
     * @param inputStream
     * @return
     * @throws IOException
     */
    public static Data csv(InputStream inputStream) throws IOException {
        if(inputStream==null){
            throw new RuntimeException("The input stream data is null");
        }

        String line = "";
        //use comma as separator
        String splitBy = ",";
        List<InlineDataset> inlines = new ArrayList<InlineDataset>();
        try (BufferedReader br =
                     new BufferedReader(new InputStreamReader(inputStream))) {

            //Header
            line = br.readLine();
            String[]  header = null;
            if(line!=null){
                header = line.split(splitBy);
            }
            while ((line = br.readLine()) != null)
            {
                Map<String, Object> values = new HashMap<>();
                String[] csvValues = line.split(splitBy);
                for (int i = 0; i < header.length; i++) {
                    values.put(header[i], csvValues[i]);
                }
                InlineDataset inlineDataset = new InlineDataset();
                inlineDataset.anythingMapValue=values;
                inlines.add(inlineDataset);
            }
        }
        if(inlines.isEmpty()){
            return null;
        }
        Data data = new Data();
        DataValues dataValues = new DataValues();
        dataValues.unionArrayValue = inlines;
        data.setValues(dataValues);
        return data;
    }
}
