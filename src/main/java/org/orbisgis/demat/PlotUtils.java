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


import org.h2gis.utilities.JDBCUtilities;
import org.orbisgis.data.api.dataset.ITable;
import org.orbisgis.data.api.dsl.IFilterBuilder;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.*;

/**
 * Some Plot utilities
 *
 * @author Erwan Bocher, CNRS 2021 - 2024
 */
public class PlotUtils {


    private static LinkedHashMap getProperties(ITable table, Collection<String> columns) throws Exception {
        LinkedHashMap properties = new LinkedHashMap();
        for (String column : columns) {
            properties.put(column, table.getObject(column));
        }
        return properties;
    }

    /**
     * Method to open a browser
     * Used by ImageJ
     *
     * @param url
     * @throws Exception
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

    /**
     * Return the first no geometric column
     *
     * @param filteredTable
     * @return
     */
    public static String getFirstNoGeomColumn(IFilterBuilder filteredTable) {
        return getFirstNoGeomColumn(filteredTable.getTable());
    }

    /**
     * Return the first no geometric column
     *
     * @param table
     * @return
     */
    public static String getFirstNoGeomColumn(ITable table) {
        Map<String, String> columns = table.getColumnsTypes();
        return columns.entrySet().stream().filter(map -> !map.getValue().toLowerCase().startsWith("geometry")).findFirst().get().getKey();
    }

    /**
     * Return the first numeric column
     *
     * @param filteredTable
     * @return
     */
    public static String getFirstNumericColumn(IFilterBuilder filteredTable) {
        try {
            return JDBCUtilities.getFirstNumericColumn((ResultSetMetaData) filteredTable.getTable().getMetaData());
        } catch (SQLException e) {
            return null;
        }
    }

    /**
     * Return the first numeric column
     *
     * @param table
     * @return
     */
    public static String getFirstNumericColumn(ITable table) {
        try {
            return JDBCUtilities.getFirstNumericColumn((ResultSetMetaData) table.getMetaData());
        } catch (SQLException e) {
            return null;
        }
    }
}
