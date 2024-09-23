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


import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

/**
 * @author Erwan Bocher, CNRS 2023-2024
 */
public class LocalFile {
    private final String path;

    public LocalFile(String path) {
        this.path=path;
    }

    public String getPath() {
        return path;
    }

    public Object getObject() {
        try {
            File file = Paths.get(path).toFile();
            if (FileUtils.isExtensionWellFormated(file, "json", "geojson")) {
                return FileUtils.json(file);
            } else if (FileUtils.isExtensionWellFormated(file,"csv")) {
                return FileUtils.csv(file);
            } else if (FileUtils.isExtensionWellFormated(file, "tsv")) {
                return FileUtils.tsv(file);
            }else{
                throw new RuntimeException("Unsupported file "+ path);
            }
        } catch (IOException e) {
            throw new RuntimeException("Cannot read the file "+ path);
        }
    }
}
