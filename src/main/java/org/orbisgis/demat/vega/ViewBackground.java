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
package org.orbisgis.demat.vega;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.orbisgis.demat.vega.legend.LegendText;

/**
 * An object defining the view background's fill and stroke.
 *
 * __Default value:__ none (transparent)
 *
 * __Deprecated:__ Please avoid using width in a unit spec that's a part of a layer spec.
 */
public class ViewBackground {
    private CornerRadius cornerRadius;
    private Cursor cursor;
    private Background fill;
    private Opacity fillOpacity;
    private CornerRadius opacity;
    private Background stroke;
    private Cap strokeCap;
    private StrokeDashUnion strokeDash;
    private CornerRadius strokeDashOffset;
    private StrokeJoinUnion strokeJoin;
    private CornerRadius strokeMiterLimit;
    private Opacity strokeOpacity;
    private FontSize strokeWidth;
    private LegendText style;

    @JsonProperty("cornerRadius")
    public CornerRadius getCornerRadius() { return cornerRadius; }
    @JsonProperty("cornerRadius")
    public void setCornerRadius(CornerRadius value) { this.cornerRadius = value; }

    /**
     * The mouse cursor used over the view. Any valid [CSS cursor
     * type](https://developer.mozilla.org/en-US/docs/Web/CSS/cursor#Values) can be used.
     */
    @JsonProperty("cursor")
    public Cursor getCursor() { return cursor; }
    @JsonProperty("cursor")
    public void setCursor(Cursor value) { this.cursor = value; }

    /**
     * The fill color.
     *
     * __Default value:__ `undefined`
     */
    @JsonProperty("fill")
    public Background getFill() { return fill; }
    @JsonProperty("fill")
    public void setFill(Background value) { this.fill = value; }

    @JsonProperty("fillOpacity")
    public Opacity getFillOpacity() { return fillOpacity; }
    @JsonProperty("fillOpacity")
    public void setFillOpacity(Opacity value) { this.fillOpacity = value; }

    /**
     * The overall opacity (value between [0,1]).
     *
     * __Default value:__ `0.7` for non-aggregate plots with `point`, `tick`, `circle`, or
     * `square` marks or layered `bar` charts and `1` otherwise.
     */
    @JsonProperty("opacity")
    public CornerRadius getOpacity() { return opacity; }
    @JsonProperty("opacity")
    public void setOpacity(CornerRadius value) { this.opacity = value; }

    /**
     * The stroke color.
     *
     * __Default value:__ `"#ddd"`
     */
    @JsonProperty("stroke")
    public Background getStroke() { return stroke; }
    @JsonProperty("stroke")
    public void setStroke(Background value) { this.stroke = value; }

    @JsonProperty("strokeCap")
    public Cap getStrokeCap() { return strokeCap; }
    @JsonProperty("strokeCap")
    public void setStrokeCap(Cap value) { this.strokeCap = value; }

    @JsonProperty("strokeDash")
    public StrokeDashUnion getStrokeDash() { return strokeDash; }
    @JsonProperty("strokeDash")
    public void setStrokeDash(StrokeDashUnion value) { this.strokeDash = value; }

    @JsonProperty("strokeDashOffset")
    public CornerRadius getStrokeDashOffset() { return strokeDashOffset; }
    @JsonProperty("strokeDashOffset")
    public void setStrokeDashOffset(CornerRadius value) { this.strokeDashOffset = value; }

    @JsonProperty("strokeJoin")
    public StrokeJoinUnion getStrokeJoin() { return strokeJoin; }
    @JsonProperty("strokeJoin")
    public void setStrokeJoin(StrokeJoinUnion value) { this.strokeJoin = value; }

    @JsonProperty("strokeMiterLimit")
    public CornerRadius getStrokeMiterLimit() { return strokeMiterLimit; }
    @JsonProperty("strokeMiterLimit")
    public void setStrokeMiterLimit(CornerRadius value) { this.strokeMiterLimit = value; }

    @JsonProperty("strokeOpacity")
    public Opacity getStrokeOpacity() { return strokeOpacity; }
    @JsonProperty("strokeOpacity")
    public void setStrokeOpacity(Opacity value) { this.strokeOpacity = value; }

    @JsonProperty("strokeWidth")
    public FontSize getStrokeWidth() { return strokeWidth; }
    @JsonProperty("strokeWidth")
    public void setStrokeWidth(FontSize value) { this.strokeWidth = value; }

    /**
     * A string or array of strings indicating the name of custom styles to apply to the view
     * background. A style is a named collection of mark property defaults defined within the
     * [style configuration](https://vega.github.io/vega-lite/docs/mark.html#style-config). If
     * style is an array, later styles will override earlier styles.
     *
     * __Default value:__ `"cell"` __Note:__ Any specified view background properties will
     * augment the default style.
     */
    @JsonProperty("style")
    public LegendText getStyle() { return style; }
    @JsonProperty("style")
    public void setStyle(LegendText value) { this.style = value; }
}
