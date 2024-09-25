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

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Erwan Bocher, CNRS 2023-2024
 */
public class FileUtils {

    public static final int DEFAULT_BUFFER_SIZE = 16384;

    public static final String[] JS_FILES = new String[]{
            "vega.js", "vega-lite.js",
            "vega-embed.js"
    };

    public static final String JS_FOLDER = "js";

    /**
     * Deploy the vega js files into a script folder
     * @param scriptDir directory to store the js scripts
     * @throws IOException an exception if the js files cannot be deployed
     */
    public static void deployJSFiles(File scriptDir) throws IOException {
        File jsFolder = new File(scriptDir, JS_FOLDER);
        if (!jsFolder.exists()) {
            if (!jsFolder.mkdirs()) {
                throw new IOException("Can't create js folder '" + jsFolder.getAbsolutePath() + "'");
            }
        }
        for (String fileName : JS_FILES) {
            File jsFile = new File(jsFolder, fileName);
            if (!jsFile.exists()) {
                InputStream fis = FileUtils.class.getResourceAsStream(fileName);
                if (fis != null) {
                    try (FileOutputStream fos = new FileOutputStream(new File(jsFolder, fileName))) {
                        try {
                            copyStream(fis, fos, DEFAULT_BUFFER_SIZE);
                        } catch (Exception e) {
                            throw new IOException("Error copying js file " + fileName, e);
                        } finally {
                            if (fis != null) {
                                fis.close();
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Read entire input stream and writes all data to output stream
     * then closes input and flushed output
     */
    public static void copyStream(InputStream inputStream, OutputStream outputStream,
                                  int bufferSize)
            throws IOException {
        try {
            byte[] writeBuffer = new byte[bufferSize];
            for (int br = inputStream.read(writeBuffer); br != -1; br = inputStream.read(writeBuffer)) {
                outputStream.write(writeBuffer, 0, br);
            }
            outputStream.flush();
        } finally {
            inputStream.close();
        }
    }

    /**
     * Check if the file has the good extension
     * @param file input file
     * @param prefixes file extension
     * @return true is the extension is supported
     */
    public static boolean isExtensionWellFormated(File file, String... prefixes) {
        if(file==null){
            throw new RuntimeException("The file is null.");
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
     * Read a json file
     * @param jsonFile input json file
     * @return a map with all json values
     */
    public static Object json(File jsonFile) throws IOException {
        if(FileUtils.isExtensionWellFormated(jsonFile, "json", "geojson")) {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(jsonFile, Object.class);
        }
        throw new RuntimeException("Cannot read as json file.");
    }

    /**
     * Read a geojson file
     * @param jsonFile input geojson file
     * @return a map with all json values
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
     * @param csvFile input csv file
     * @return csv data as list
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
    /**
     * Read a CSV {@link File} and convert it to a Data object
     * @param tsvFile input tsv file
     * @return tsv data as list
     */
    public static List tsv(File tsvFile) throws IOException {
        if(FileUtils.isExtensionWellFormated(tsvFile,  "tsv")) {
            String line = "";
            //use tabular as separator
            String splitBy = "\t";
            ArrayList lines = new ArrayList();
            try (BufferedReader br =
                         new BufferedReader(new FileReader(tsvFile))) {
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

    /**
     * Method to open a browser
     * Used by ImageJ
     *
     * @param url to open the browser
     */
    public static void openBrowser(String url) throws Exception {
        if (url == null || url.isEmpty()) {
            throw new RuntimeException("The URL cannot be null or empty");
        }
        String osname = System.getProperty("os.name");
        boolean isWin = osname.startsWith("windows");
        boolean isMac = !isWin && osname.startsWith("mac");
        if (isMac) {
            Runtime.getRuntime().exec("open " + url);
        } else if (isWin) {
            String cmd = "rundll32 url.dll,FileProtocolHandler " + url;
            if (osname.startsWith("Windows 2000"))
                cmd = "rundll32 shell32.dll,ShellExec_RunDLL " + url;
            Process process = Runtime.getRuntime().exec(cmd);
            // This avoids a memory leak on some versions of Java on Windows.
            // That's hinted at in <http://developer.java.sun.com/developer/qow/archive/68/>.
            try {
                process.waitFor();
                process.exitValue();
            } catch (InterruptedException ie) {
                throw new IOException("InterruptedException while launching browser: " + ie.getMessage());
            }
        } else {
            // Assume Linux or Unix
            // Based on BareBonesBrowserLaunch (http://www.centerkey.com/java/browser/)
            // The utility 'xdg-open' launches the URL in the user's preferred browser,
            // therefore we try to use it first, before trying to discover other browsers.
            String[] browsers = {"xdg-open", "netscape", "firefox", "konqueror", "mozilla", "opera", "epiphany", "lynx"};
            String browserName = null;
            try {
                for (int count = 0; count < browsers.length && browserName == null; count++) {
                    String[] c = new String[]{"which", browsers[count]};
                    if (Runtime.getRuntime().exec(c).waitFor() == 0)
                        browserName = browsers[count];
                }
                if (browserName == null) {
                    throw new RuntimeException("Could not find a browser");
                } else {
                    Runtime.getRuntime().exec(new String[]{browserName, url});
                }
            } catch (Exception e) {
                throw new IOException("Exception while launching browser: " + e.getMessage());
            }
        }
    }
}
