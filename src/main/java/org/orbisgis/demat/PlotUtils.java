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


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.orbisgis.demat.vega.data.Data;
import org.orbisgis.demat.vega.data.DataValues;
import org.orbisgis.demat.vega.data.InlineDataset;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Some view utilities
 *
 * @author Erwan Bocher, CNRS 2021
 */
public class PlotUtils {


    public static Data urlData(LinkedHashMap values) {
        Data urlData = new Data();
        DataValues urlDataInlineDataset = new DataValues();
        urlDataInlineDataset.anythingMapValue = values;
        urlData.setValues(urlDataInlineDataset);
        return urlData;
    }

    public static Data urlData(Object[][] values){
        Data urlData = new Data();
        urlData.setValues(urlDataInlineDataset(values));
        return urlData;
    }


    public static Data urlData(List<Map> values){
        Data urlData = new Data();
        urlData.setValues(urlDataInlineDataset(values));
        return urlData;
    }

    public static DataValues urlDataInlineDataset(List<Map> values) {
        List<InlineDataset> inlines = new ArrayList<InlineDataset>();
        for (Map map :values) {
            InlineDataset inlineDataset = new InlineDataset();
            inlineDataset.anythingMapValue=map;
            inlines.add(inlineDataset);
        }
        DataValues urlDataInlineDataset = new DataValues();
        urlDataInlineDataset.unionArrayValue=inlines;
        return urlDataInlineDataset;
    }

    public static DataValues urlDataInlineDataset(Object[][] values){
        List<InlineDataset> inlines = new ArrayList<InlineDataset>();
        Object[] firstRow = values[0];
        for (int i = 1; i < values.length ; i++) {
            InlineDataset inlineDataset = new InlineDataset();
            Map<String, Object> rows = new HashMap<>();
            Object[] cols = values[i];
            for (int j = 0; j < values.length ; j++) {
                rows.put(String.valueOf(firstRow[j]), cols[j]);
            }
            inlineDataset.anythingMapValue= rows;
            inlines.add(inlineDataset);
        }
        DataValues urlDataInlineDataset = new DataValues();
        urlDataInlineDataset.unionArrayValue=inlines;
        return urlDataInlineDataset;
    }

    /**
     * Method to open a browser
     * Used by ImageJ
     *
     * @param url
     * @throws Exception
     */
    public static void  openBrowser( String url) throws Exception {
        if (url==null || url.isEmpty()){
            throw new RuntimeException("The URL cannot be null or empty");
        }
        String osname = System.getProperty("os.name");
        boolean isWin = osname.startsWith("windows");
        boolean isMac = !isWin && osname.startsWith("mac");
        if (isMac) {
            Runtime.getRuntime().exec("open " + url);
        }else if (isWin) {
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
            String[] browsers = {"xdg-open", "netscape", "firefox", "konqueror", "mozilla", "opera", "epiphany", "lynx" };
            String browserName = null;
            try {
                for (int count=0; count<browsers.length && browserName==null; count++) {
                    String[] c = new String[] {"which", browsers[count]};
                    if (Runtime.getRuntime().exec(c).waitFor()==0)
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

    /**
     * Build a json representation of the view
     *
     * @param view
     * @return
     * @throws JsonProcessingException
     */
    public static String toJson(View view) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return objectMapper.writeValueAsString(view);
    }

    /**
     * Check the show directory file
     *
     * @return
     */
    public static File checkShowDir(String showDir) {
        File showDirFile = new File(showDir);
        if (!showDirFile.isDirectory() && !showDirFile.exists()) {
            showDirFile.mkdir();
        } else if (!showDirFile.isDirectory()) {
            throw new RuntimeException("Invalid directory path");
        }
        return showDirFile;
    }
}
