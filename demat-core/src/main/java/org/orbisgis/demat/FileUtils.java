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

import java.io.*;

/**
 * @author Erwan Bocher, CNRS
 */
public class FileUtils {

    public static final int DEFAULT_BUFFER_SIZE = 16384;

    public static final String[] JS_FILES = new String[]{
            "vega.js", "vega-lite.js",
            "vega-embed.js"
    };

    public static final String JS_FOLDER = "js";

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
}
