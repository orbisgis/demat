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

import java.io.File;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;

public class RendererService {

    private static RendererService service;
    private ServiceLoader<IRenderer> loader;

    private RendererService() {
        loader = ServiceLoader.load(IRenderer.class);
    }

    public static synchronized RendererService getInstance() {
        if (service == null) {
            service = new RendererService();
        }
        return service;
    }

    /**
     * Method to get a renderer for a Plot from a SPI service
     *
     * @param plot
     */
    public void show(Plot plot) {
        try {
            boolean rendererFounded = false;
            Iterator<IRenderer> renderers = loader.iterator();
            while (renderers.hasNext()) {
                IRenderer renderer = renderers.next();
                try {
                    renderer.show(plot);
                    return;
                } catch (RendererNotFoundException e) {
                    //Eat this
                }
            }
            //Use the OS browser because we cannot find a rendering service
            if (!rendererFounded) {
                try {
                    String htmlDirectory = System.getProperty("java.io.tmpdir") + File.separator + "demat";
                    plot.setHTMLDirectory(htmlDirectory);
                    File outputFile = File.createTempFile("demat", ".html", PlotUtils.checkShowDir(htmlDirectory));
                    plot.save(outputFile, true);
                    PlotUtils.openBrowser(outputFile.getAbsolutePath());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

            }
        } catch (ServiceConfigurationError serviceError) {
            serviceError.printStackTrace();
        }
    }

    /**
     * Method to get a renderer for a Chart from a SPI service
     *
     * @param chart
     */
    public void show(Chart chart) {
        try {
            boolean rendererFounded = false;
            Iterator<IRenderer> renderers = loader.iterator();
            while (renderers.hasNext()) {
                IRenderer renderer = renderers.next();
                try {
                    renderer.show(chart);
                    rendererFounded = true;
                } catch (RendererNotFoundException e) {
                    //Eat this
                }
            }
            //Use the OS browser because we cannot find a rendering service
            if (!rendererFounded) {
                try {
                    File outputFile = File.createTempFile("demat", ".html", PlotUtils.checkShowDir(chart.getHTMLDirectory()));
                    chart.save(outputFile, true);
                    PlotUtils.openBrowser(outputFile.getAbsolutePath());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

            }
        } catch (ServiceConfigurationError serviceError) {
            serviceError.printStackTrace();
        }
    }

}
