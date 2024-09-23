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

import com.kitfox.svg.SVGDiagram;
import com.kitfox.svg.SVGException;
import com.kitfox.svg.SVGUniverse;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Map;

import static java.awt.RenderingHints.*;
import static java.awt.image.BufferedImage.TYPE_INT_ARGB;

/**
 * @author Erwan Bocher, CNRS 2023-2024
 */
public class SvgRasterizer {
    public final static Map<Object, Object> RENDERING_HINTS = Map.of(
            KEY_ANTIALIASING,
            VALUE_ANTIALIAS_ON,
            KEY_ALPHA_INTERPOLATION,
            VALUE_ALPHA_INTERPOLATION_QUALITY,
            KEY_COLOR_RENDERING,
            VALUE_COLOR_RENDER_QUALITY,
            KEY_DITHERING,
            VALUE_DITHER_DISABLE,
            KEY_FRACTIONALMETRICS,
            VALUE_FRACTIONALMETRICS_ON,
            KEY_INTERPOLATION,
            VALUE_INTERPOLATION_NEAREST_NEIGHBOR,
            KEY_RENDERING,
            VALUE_RENDER_QUALITY,
            KEY_STROKE_CONTROL,
            VALUE_STROKE_PURE,
            KEY_TEXT_ANTIALIASING,
            VALUE_TEXT_ANTIALIAS_ON
    );

    private final static SVGUniverse sRenderer = new SVGUniverse();

    /**
     * Rasterizes a vector graphic to a given size using a {@link BufferedImage}.
     * The rendering hints are set to produce high quality output.
     *
     * @param path   Fully qualified path to the image resource to rasterize.
     * @param ratio  The ratio to scale the image. Default if 1
     * @return The rasterized {@link Image}.
     * @throws SVGException Could not open, read, parse, or render SVG data.
     */
    public BufferedImage rasterize(final InputStream path, final float ratio )
            throws SVGException, IOException {
        final SVGDiagram diagram = loadDiagram( path );
        final float wDiagram = diagram.getWidth();
        final float hDiagram = diagram.getHeight();
        final Dimension srcDim = new Dimension( (int) wDiagram, (int) hDiagram );

        final Dimension scaled = fit( srcDim, ratio );
        final int wScaled = (int) scaled.getWidth();
        final int hScaled = (int) scaled.getHeight();

        final BufferedImage image = new BufferedImage( wScaled, hScaled, TYPE_INT_ARGB );

        final Graphics2D g = image.createGraphics();
        g.setRenderingHints( RENDERING_HINTS );

        final java.awt.geom.AffineTransform transform = g.getTransform();
        transform.setToScale( wScaled / wDiagram, hScaled / hDiagram );

        g.setTransform( transform );
        diagram.render( g );
        g.dispose();

        return image;
    }

    /**
     * Gets an instance of {@link URL} that references a file in the
     * application's resources.
     *
     * @param path The full path (starting at the root), relative to the
     *             application or JAR file's resources directory.
     * @return A {@link URL} to the file or {@code null} if the path does not
     * point to a resource.
     */
    private URL getResourceUrl(final String path ) {
        return SvgRasterizer.class.getResource( path );
    }

    /**
     * Loads the resource specified by the given path into an instance of
     * {@link SVGDiagram} that can be rasterized into a bitmap format. The
     * {@link SVGUniverse} class will
     *
     * @param path The full path (starting at the root), relative to the
     *             application or JAR file's resources directory.
     * @return An {@link SVGDiagram} that can be rasterized onto a
     * {@link BufferedImage}.
     */
    private SVGDiagram loadDiagram(final InputStream path ) throws IOException {
        final java.net.URI uri = sRenderer.loadSVG( path, "name" );
        final SVGDiagram diagram = sRenderer.getDiagram( uri );
        return applySettings( diagram );
    }

    /**
     * Instructs the SVG renderer to rasterize the image even if it would be
     * clipped.
     *
     * @param diagram The {@link SVGDiagram} to render.
     * @return The same instance with ignore clip heuristics set to {@code true}.
     */
    private SVGDiagram applySettings( final SVGDiagram diagram ) {
        diagram.setIgnoringClipHeuristic( true );
        return diagram;
    }

    /**
     * Scales the given source {@link Dimension} to the destination
     * {@link Dimension}, maintaining the aspect ratio with respect to
     * the best fit.
     *
     * @param src The original vector graphic dimensions to change.
     * @param ratio The desired ratio  to scale.
     * @return The given source dimensions scaled to the destination dimensions,
     * maintaining the aspect ratio.
     */
    private Dimension fit( final Dimension src, final float ratio ) {
        final double srcWidth = src.getWidth();
        final double srcHeight = src.getHeight();

        // Scale both dimensions with respect to the best fit ratio.
        return new Dimension( (int) (srcWidth * ratio), (int) (srcHeight * ratio) );
    }

    /**
     * Save the SVG as image
     * @param svg
     * @param outputFile
     * @throws SVGException
     * @throws IOException
     */
    void save(String svg, final float ratio, File outputFile) throws SVGException, IOException {
        BufferedImage bufferedImage = rasterize(new ByteArrayInputStream(svg.getBytes()), ratio);
        ImageIO.write(bufferedImage, "png", outputFile);
    }
}
