/*
 * DEMAT-SWT is SPI service to use Eclipse SWT Brower to
 * renderer vega-lite file build with the DEMAT wrapper.
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
 * DEMAT-SWT is distributed under LGPL 3 license.
 *
 * Copyright (C) 2022 CNRS (Lab-STICC UMR CNRS 6285)
 *
 *
 * DEMAT-SWT is free software: you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * DEMAT-SWT is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * DEMAT-SWT. If not, see <http://www.gnu.org/licenses/>.
 *
 * For more information, please consult: <http://www.orbisgis.org/>
 * or contact directly:
 * info_at_ orbisgis.org
 */
package org.orbisgis.demat.swt;

import org.orbisgis.demat.*;

import java.io.File;
import java.io.IOException;

public class SWTFrame implements IRenderer {

    private String htmlDirectory = System.getProperty("java.io.tmpdir") + File.separator + "demat";

    @Override
    public String getHTMLDirectory() {
        return htmlDirectory;
    }

    @Override
    public void show(Plot plot) throws RendererNotFoundException {
        try {
            File outputFile = File.createTempFile("demat", ".html", PlotUtils.checkShowDir(getHTMLDirectory()));
            plot.setHTMLDirectory(htmlDirectory);
            plot.save(outputFile, true);
            SWTBrowser.launch(outputFile.getAbsolutePath());
        } catch (IOException e) {
            throw  new RendererNotFoundException(e.getLocalizedMessage());
        }
    }

    @Override
    public void show(Chart chart) throws RendererNotFoundException {
        try {
            File outputFile = File.createTempFile("demat", ".html", PlotUtils.checkShowDir(getHTMLDirectory()));
            chart.setHTMLDirectory(htmlDirectory);
            chart.save(outputFile, true);
            SWTBrowser.launch(outputFile.getAbsolutePath());
        } catch (IOException e) {
            throw  new RendererNotFoundException(e.getLocalizedMessage());
        }
    }

}
