package org.orbisgis.demat;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.orbisgis.demat.vega.Data;
import org.orbisgis.demat.vega.DataValues;
import org.orbisgis.demat.vega.InlineDataset;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
     *
     * @param reader
     * @return
     * @throws IOException
     */
    public static Data toData(InputStream reader) throws IOException {
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
    public static Object json(File jsonFile) throws IOException {
        if(Read.isExtensionWellFormated(jsonFile, "json")) {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(jsonFile, Object.class);
        }
        throw new RuntimeException("Cannot read as json file.");
    }


    /**
     * Check if the file has the good extension
     * @param file
     * @param prefix
     * @return
     */
    public static boolean isExtensionWellFormated(File file, String prefix) {
        if(file==null){
            throw new RuntimeException("The file is null.");
        }
        if(file.isFile()){
            throw new RuntimeException("The file is a directory.");
        }
        if(file.exists()){
            throw new RuntimeException("The file doesn't exist.");
        }
        String path = file.getAbsolutePath();
        String extension = "";
        int i = path.lastIndexOf('.');
        if (i >= 0) {
            extension = path.substring(i + 1);
        }
        return extension.equalsIgnoreCase(prefix);
    }

    /**
     * Read a CSV inputstream and convert it to a Data object
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
