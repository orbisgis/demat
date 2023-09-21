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
import org.h2gis.utilities.JDBCUtilities;
import org.h2gis.utilities.jts_utils.GeometryFeatureUtils;
import org.orbisgis.data.api.dataset.ISpatialTable;
import org.orbisgis.data.api.dataset.ITable;
import org.orbisgis.data.api.dsl.IFilterBuilder;
import org.orbisgis.demat.vega.LayerElement;
import org.orbisgis.demat.vega.LayerEncoding;
import org.orbisgis.demat.vega.data.Data;
import org.orbisgis.demat.vega.data.DataValues;
import org.orbisgis.demat.vega.data.InlineDataset;
import org.orbisgis.demat.vega.encoding.Encoding;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.*;

/**
 * Some Plot utilities
 *
 * @author Erwan Bocher, CNRS 2021 - 2023
 */
public class PlotUtils {


    /**
     * Create a data object from a {@link ISpatialTable}
     *
     * @param spatialTable
     * @return
     */
    public static Data urlData(ISpatialTable spatialTable) throws Exception {
        Data urlData = new Data();
        urlData.setDataValues(dataValues(spatialTable));
        return urlData;
    }

    public static DataValues dataValues(ISpatialTable spatialTable) throws Exception {
        DataValues dataValues = new DataValues();
        ArrayList<InlineDataset> geojson = new ArrayList<>();
        Object geomCol = spatialTable.getGeometricColumns().stream().findFirst().get();
        Collection<String> columns = spatialTable.getColumns();
        columns.remove(geomCol);
        int colummSize = columns.size();
        while (spatialTable.next()) {
            InlineDataset row = new InlineDataset();
            LinkedHashMap<String, Object> feature = new LinkedHashMap();
            feature.put("type", "Feature");
            feature.putAll(GeometryFeatureUtils.toMap(spatialTable.getGeometry()));
            if (colummSize > 0) {
                feature.put("properties", getProperties(spatialTable, columns));
            }
            row.anythingMapValue = feature;
            geojson.add(row);
        }
        dataValues.unionArrayValue = geojson;
        return dataValues;
    }

    /**
     * Create a data object from a {@link ITable}
     *
     * @param table
     * @return
     */
    public static Data urlData(ITable table) throws Exception {
        Data urlData = new Data();
        urlData.setDataValues(dataValues(table));
        return urlData;
    }

    public static DataValues dataValues(ITable table) throws Exception {
        Collection<String> columns = table.getColumns();
        int colummSize = columns.size();
        if (colummSize > 0) {
            DataValues urlDataInlineDataset = new DataValues();
            ArrayList<InlineDataset> geojson = new ArrayList<>();
            while (table.next()) {
                InlineDataset row = new InlineDataset();
                row.anythingMapValue = getProperties(table, columns);
                geojson.add(row);
            }
            urlDataInlineDataset.unionArrayValue = geojson;
            return urlDataInlineDataset;
        }
        return null;
    }

    private static LinkedHashMap getProperties(ITable table, Collection<String> columns) throws Exception {
        LinkedHashMap properties = new LinkedHashMap();
        for (String column : columns) {
            properties.put(column, table.getObject(column));
        }
        return properties;
    }


    /**
     * Create a data object from a map of values
     *
     * @param values
     * @return
     */
    public static Data urlData(LinkedHashMap values) {
        Data urlData = new Data();
        DataValues urlDataInlineDataset = new DataValues();
        urlDataInlineDataset.anythingMapValue = values;
        urlData.setDataValues(urlDataInlineDataset);
        return urlData;
    }

    public static Data urlData(Object[][] values) {
        Data urlData = new Data();
        urlData.setDataValues(urlDataInlineDataset(values));
        return urlData;
    }


    public static Data urlData(List<Map> values) {
        Data urlData = new Data();
        urlData.setDataValues(urlDataInlineDataset(values));
        return urlData;
    }

    public static DataValues urlDataInlineDataset(List<Map> values) {
        List<InlineDataset> inlines = new ArrayList<InlineDataset>();
        for (Map map : values) {
            InlineDataset inlineDataset = new InlineDataset();
            inlineDataset.anythingMapValue = map;
            inlines.add(inlineDataset);
        }
        DataValues urlDataInlineDataset = new DataValues();
        urlDataInlineDataset.unionArrayValue = inlines;
        return urlDataInlineDataset;
    }

    public static DataValues urlDataInlineDataset(Object[][] values) {
        DataValues urlDataInlineDataset = new DataValues();
        List<InlineDataset> inlines = new ArrayList<InlineDataset>();
        if (values.length == 0) {
            urlDataInlineDataset.unionArrayValue = inlines;
        } else {
            Object[] firstRow = values[0];
            for (int i = 1; i < values.length; i++) {
                InlineDataset inlineDataset = new InlineDataset();
                Map<String, Object> rows = new HashMap<>();
                Object[] cols = values[i];
                for (int j = 0; j < values.length; j++) {
                    rows.put(String.valueOf(firstRow[j]), cols[j]);
                }
                inlineDataset.anythingMapValue = rows;
                inlines.add(inlineDataset);
            }
            urlDataInlineDataset.unionArrayValue = inlines;
        }
        return urlDataInlineDataset;
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


    /**
     * Convert a Chart to a LayerElement
     *
     * @param chart
     * @return
     */
    public static LayerElement chartToLayerElement(Chart chart) {
        LayerElement layerElement = new LayerElement();
        layerElement.setData(chart.getData());
        layerElement.setLayer(chart.getLayer());
        layerElement.setMark(chart.getMark());
        layerElement.setDescription(chart.getDescription());
        layerElement.setHeight(chart.getHeight());
        layerElement.setWidth(chart.getWidth());
        layerElement.setName(chart.getName());
        layerElement.setProjection(chart.getProjection());
        layerElement.setResolve(chart.getResolve());
        layerElement.setSelection(chart.getSelection());
        layerElement.setTitle(chart.getTitle());
        layerElement.setTransform(chart.getTransform());
        layerElement.setView(chart.getViewBackground());
        Encoding chartEncoding = chart.getEncoding();
        if (chartEncoding != null) {
            LayerEncoding layerEncoding = new LayerEncoding();
            layerEncoding.setAngle(chartEncoding.getAngle());
            layerEncoding.setColor(chartEncoding.getColor());
            layerEncoding.setDescription(chartEncoding.getDescription());
            layerEncoding.setDetail(chartEncoding.getDetail());
            layerEncoding.setFill(chartEncoding.getFill());
            layerEncoding.setFillOpacity(chartEncoding.getFillOpacity());
            layerEncoding.setHref(chartEncoding.getHref());
            layerEncoding.setKey(chartEncoding.getKey());
            layerEncoding.setLatitude(chartEncoding.getLatitude());
            layerEncoding.setLatitude2(chartEncoding.getLatitude2());
            layerEncoding.setLongitude(chartEncoding.getLongitude());
            layerEncoding.setLongitude2(chartEncoding.getLongitude2());
            layerEncoding.setOpacity(chartEncoding.getOpacity());
            layerEncoding.setOrder(chartEncoding.getOrder());
            layerEncoding.setRadius(chartEncoding.getRadius());
            layerEncoding.setRadius2(chartEncoding.getRadius2());
            layerEncoding.setShape(chartEncoding.getShape());
            layerEncoding.setSize(chartEncoding.getSize());
            layerEncoding.setStroke(chartEncoding.getStroke());
            layerEncoding.setStrokeDash(chartEncoding.getStrokeDash());
            layerEncoding.setStrokeOpacity(chartEncoding.getStrokeOpacity());
            layerEncoding.setStrokeWidth(chartEncoding.getStrokeWidth());
            layerEncoding.setText(chartEncoding.getText());
            layerEncoding.setTheta(chartEncoding.getTheta());
            layerEncoding.setTheta2(chartEncoding.getTheta2());
            layerEncoding.setTooltip(chartEncoding.getTooltip());
            layerEncoding.setURL(chartEncoding.getURL());
            layerEncoding.setX(chartEncoding.getX());
            layerEncoding.setX2(chartEncoding.getX2());
            layerEncoding.setXError(chartEncoding.getXError());
            layerEncoding.setXError2(chartEncoding.getXError2());
            layerEncoding.setY(chartEncoding.getY());
            layerEncoding.setY2(chartEncoding.getY2());
            layerEncoding.setYError(chartEncoding.getYError());
            layerEncoding.setYError2(chartEncoding.getYError2());
            layerElement.setEncoding(layerEncoding);
        }
        return layerElement;
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
