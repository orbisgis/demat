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
package org.orbisgis.demat;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

public class SWTBrowserIcons {


    public static final String REFRESH = "refresh.png";
    static String PRINT_SCREEN = "picture_save.png";
    static String SAVE = "save.png";
    static String CANCEL = "cancel.png";

    /**
     * Return an image to be used as icon
     * @param display
     * @param imagePath
     * @return
     */
    public static Image getIcon(Display display, String imagePath) {
        Image image = new Image(display, SWTBrowserIcons.class.getResourceAsStream(imagePath));
        return image;
    }
}

