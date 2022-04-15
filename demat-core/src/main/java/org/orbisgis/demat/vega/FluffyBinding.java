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

import java.util.List;

/**
 * Binds the parameter to an external input element such as a slider, selection list or
 * radio button group.
 */
public class FluffyBinding {
    private Double debounce;
    private String element;
    private String input;
    private String name;
    private String type;
    private List<String> labels;
    private List<Object> options;
    private Double max;
    private Double min;
    private Double step;
    private String autocomplete;
    private String placeholder;
    private List<Stream> between;
    private Boolean consume;
    private LegendText filter;
    private String markname;
    private MarkType marktype;
    private String source;
    private Double throttle;
    private Stream stream;
    private List<Stream> merge;

    @JsonProperty("debounce")
    public Double getDebounce() { return debounce; }
    @JsonProperty("debounce")
    public void setDebounce(Double value) { this.debounce = value; }

    @JsonProperty("element")
    public String getElement() { return element; }
    @JsonProperty("element")
    public void setElement(String value) { this.element = value; }

    @JsonProperty("input")
    public String getInput() { return input; }
    @JsonProperty("input")
    public void setInput(String value) { this.input = value; }

    @JsonProperty("name")
    public String getName() { return name; }
    @JsonProperty("name")
    public void setName(String value) { this.name = value; }

    @JsonProperty("type")
    public String getType() { return type; }
    @JsonProperty("type")
    public void setType(String value) { this.type = value; }

    @JsonProperty("labels")
    public List<String> getLabels() { return labels; }
    @JsonProperty("labels")
    public void setLabels(List<String> value) { this.labels = value; }

    @JsonProperty("options")
    public List<Object> getOptions() { return options; }
    @JsonProperty("options")
    public void setOptions(List<Object> value) { this.options = value; }

    @JsonProperty("max")
    public Double getMax() { return max; }
    @JsonProperty("max")
    public void setMax(Double value) { this.max = value; }

    @JsonProperty("min")
    public Double getMin() { return min; }
    @JsonProperty("min")
    public void setMin(Double value) { this.min = value; }

    @JsonProperty("step")
    public Double getStep() { return step; }
    @JsonProperty("step")
    public void setStep(Double value) { this.step = value; }

    @JsonProperty("autocomplete")
    public String getAutocomplete() { return autocomplete; }
    @JsonProperty("autocomplete")
    public void setAutocomplete(String value) { this.autocomplete = value; }

    @JsonProperty("placeholder")
    public String getPlaceholder() { return placeholder; }
    @JsonProperty("placeholder")
    public void setPlaceholder(String value) { this.placeholder = value; }

    @JsonProperty("between")
    public List<Stream> getBetween() { return between; }
    @JsonProperty("between")
    public void setBetween(List<Stream> value) { this.between = value; }

    @JsonProperty("consume")
    public Boolean getConsume() { return consume; }
    @JsonProperty("consume")
    public void setConsume(Boolean value) { this.consume = value; }

    @JsonProperty("filter")
    public LegendText getFilter() { return filter; }
    @JsonProperty("filter")
    public void setFilter(LegendText value) { this.filter = value; }

    @JsonProperty("markname")
    public String getMarkname() { return markname; }
    @JsonProperty("markname")
    public void setMarkname(String value) { this.markname = value; }

    @JsonProperty("marktype")
    public MarkType getMarktype() { return marktype; }
    @JsonProperty("marktype")
    public void setMarktype(MarkType value) { this.marktype = value; }

    @JsonProperty("source")
    public String getSource() { return source; }
    @JsonProperty("source")
    public void setSource(String value) { this.source = value; }

    @JsonProperty("throttle")
    public Double getThrottle() { return throttle; }
    @JsonProperty("throttle")
    public void setThrottle(Double value) { this.throttle = value; }

    @JsonProperty("stream")
    public Stream getStream() { return stream; }
    @JsonProperty("stream")
    public void setStream(Stream value) { this.stream = value; }

    @JsonProperty("merge")
    public List<Stream> getMerge() { return merge; }
    @JsonProperty("merge")
    public void setMerge(List<Stream> value) { this.merge = value; }
}
