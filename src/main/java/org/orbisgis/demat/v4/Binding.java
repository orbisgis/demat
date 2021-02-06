package org.orbisgis.demat.v4;

import com.fasterxml.jackson.annotation.*;
import java.util.List;

/**
 * Binds the parameter to an external input element such as a slider, selection list or
 * radio button group.
 */
public class Binding {
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
}
