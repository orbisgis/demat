package org.orbisgis.demat;

import com.caoccao.javet.exceptions.JavetException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class Plot {

    // The folder to store the vega-lite libraries
    private static String DEMAT_FOLDER = System.getProperty("java.io.tmpdir") + File.separator + "demat";

    private static String VEGA_SCHEMA = "https://vega.github.io/schema/vega-lite/v5.json";

    /**
     * Method to transform the VEGA spec as SVG file
     */
    static public void toSVG(Map spec, File path) throws IOException, JavetException {
            if(spec==null || spec.isEmpty()){
                throw new RuntimeException("The input spec cannot be null or empty");
            }
            //Put the default vega json schema
            spec.put("$schema", VEGA_SCHEMA);
            ObjectMapper objectMapper = new ObjectMapper();

            IOUtils.saveAsSVG(objectMapper.writeValueAsString(spec),DEMAT_FOLDER, path, true);
    }

    /**
     * Method to transform the VEGA spec as JSON file
     */
    static public void toJSON(Map spec, File path) throws IOException, JavetException {
        if(spec==null || spec.isEmpty()){
            throw new RuntimeException("The input spec cannot be null or empty");
        }
        //Put the default vega json schema
        spec.put("$schema", VEGA_SCHEMA);
        ObjectMapper objectMapper = new ObjectMapper();
        IOUtils.saveAsJSON(objectMapper.writeValueAsString(spec), path, true);
    }

}
