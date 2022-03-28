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

import org.eclipse.swt.SWT;
import org.eclipse.swt.SWTError;
import org.eclipse.swt.browser.*;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.ImageTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.program.Program;
import org.eclipse.swt.widgets.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class SWTBrowser {

    public static final void launch(String url) {
        Display display = new Display();
        final Shell shell = new Shell(display);
        GridLayout gridLayout = new GridLayout();
        gridLayout.numColumns = 3;
        shell.setLayout(gridLayout);

        ToolBar bottomToolbar = new ToolBar(shell, SWT.FLAT | SWT.HORIZONTAL | SWT.RIGHT);

        ToolItem print = new ToolItem(bottomToolbar, SWT.PUSH);
        print.setText("Copy screen");
        print.setImage(SWTBrowserIcons.getIcon(display, SWTBrowserIcons.PRINT_SCREEN));

        ToolItem saveAs = new ToolItem(bottomToolbar, SWT.PUSH);
        saveAs.setText("Save");
        saveAs.setImage(SWTBrowserIcons.getIcon(display, SWTBrowserIcons.SAVE));

        ToolItem refresh = new ToolItem(bottomToolbar, SWT.PUSH);
        refresh.setText("Refresh");
        refresh.setImage(SWTBrowserIcons.getIcon(display, SWTBrowserIcons.REFRESH));

        ToolItem cancel = new ToolItem(bottomToolbar, SWT.PUSH);
        cancel.setText("Stop");
        cancel.setImage(SWTBrowserIcons.getIcon(display, SWTBrowserIcons.CANCEL));

        bottomToolbar.setLayout(gridLayout);



        final Browser browser;
        try {
            browser = new Browser(shell, SWT.NONE);
        }catch (SWTError e) {
            System.out.println("Could not instantiate Browser: " + e.getMessage());
            display.dispose();
            return;
        }
        GridData data = new GridData();
        data.horizontalAlignment = GridData.FILL;
        data.verticalAlignment = GridData.FILL;
        data.horizontalSpan = 3;
        data.grabExcessHorizontalSpace = true;
        data.grabExcessVerticalSpace = true;
        browser.setLayoutData(data);
        final Label status = new Label(shell, SWT.NONE);
        data = new GridData(GridData.FILL_HORIZONTAL);
        data.horizontalSpan = 2;
        status.setLayoutData(data);
        final ProgressBar progressBar = new ProgressBar(shell, SWT.NONE);
        data = new GridData();
        data.horizontalAlignment = GridData.END;
        progressBar.setLayoutData(data);

        /* event handling */
        Listener listener = new Listener() {
            public void handleEvent(Event event) {
                ToolItem item = (ToolItem) event.widget;
                String string = item.getText();
                if (string.equals("Stop")) {
                    browser.stop();
                } else if (string.equals("Save")) {
                    String[] SUPPORTED_FORMATS = new String[] { "png", "svg", "pdf" };
                    FileDialog saveDialog = new FileDialog(shell, SWT.SAVE);
                    String[] extensions = new String[SUPPORTED_FORMATS.length];
                    String[] filterNames = new String[SUPPORTED_FORMATS.length];
                    for (int i = 0; i < SUPPORTED_FORMATS.length; i++) {
                        extensions[i] = "*." + SUPPORTED_FORMATS[i];
                        filterNames[i] = SUPPORTED_FORMATS[i].toUpperCase() + " (*." + SUPPORTED_FORMATS[i] + ")";
                    }
                    saveDialog.setFilterExtensions(extensions);
                    saveDialog.setFilterNames(filterNames);
                    String filePath = saveDialog.open();
                    if (filePath == null) {
                        return;
                    }

                    int imageType = SWT.IMAGE_BMP;
                    {
                        String filePathLower = filePath.toLowerCase();
                        if (filePathLower.endsWith(".png")) {
                            imageType = SWT.IMAGE_PNG;
                        } else if (filePathLower.endsWith(".gif")) {
                            imageType = SWT.IMAGE_GIF;
                        }
                    }

                    Image image = new Image(Display.getDefault(), browser.getBounds());
                    GC gc = new GC(image);
                    try {
                        browser.print(gc);
                    } finally {
                        gc.dispose();
                    }
                    ImageLoader imageLoader = new ImageLoader();
                    imageLoader.data = new ImageData[1];
                    imageLoader.data[0] = image.getImageData();
                    File outFile = new File(filePath);
                    try (OutputStream fos = new FileOutputStream(outFile)) {
                        imageLoader.save(fos, imageType);
                    } catch (IOException e) {
                        int style = SWT.ICON_ERROR;
                        MessageBox messageBox = new MessageBox(shell, style);
                        messageBox.setMessage("Cannot save the page");
                    }
                    Program.launch(outFile.getAbsolutePath());

                }
                else if(string.equals("Copy screen")){
                    Image image = new Image(Display.getDefault(), browser.getBounds());
                    GC gc = new GC(image);
                    try {
                        browser.print(gc);
                    } finally {
                        gc.dispose();
                    }
                    ImageTransfer imageTransfer = ImageTransfer.getInstance();
                    Clipboard clipboard = new Clipboard(Display.getCurrent());
                    clipboard.setContents(new Object[] {image.getImageData()}, new Transfer[]{imageTransfer});
                }
                else if (string.equals("Refresh")) {
                    browser.refresh();
                }
            }
        };

        saveAs.addListener(SWT.Selection, listener);
        cancel.addListener(SWT.Selection, listener);
        print.addListener(SWT.Selection, listener);
        refresh.addListener(SWT.Selection, listener);
        browser.addProgressListener(new ProgressListener() {
            public void changed(ProgressEvent event) {
                if (event.total == 0)
                    return;
                int ratio = event.current * 100 / event.total;
                progressBar.setSelection(ratio);
            }
            public void completed(ProgressEvent event) {
                progressBar.setSelection(0);
            }
        });
        browser.addStatusTextListener(new StatusTextListener() {
            public void changed(StatusTextEvent event) {
                status.setText(event.text);
            }
        });

        shell.open();

        browser.setUrl(url);
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }
        display.dispose();
    }
}
