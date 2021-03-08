package org.orbisgis.demat.vega;

import com.fasterxml.jackson.annotation.*;

public class Parameter {
    private Binding bind;
    private String description;
    private String expr;
    private String name;
    private Object value;

    /**
     * Binds the parameter to an external input element such as a slider, selection list or
     * radio button group.
     */
    @JsonProperty("bind")
    public Binding getBind() { return bind; }
    @JsonProperty("bind")
    public void setBind(Binding value) { this.bind = value; }

    /**
     * A text description of the parameter, useful for inline documentation.
     */
    @JsonProperty("description")
    public String getDescription() { return description; }
    @JsonProperty("description")
    public void setDescription(String value) { this.description = value; }

    /**
     * An expression for the value of the parameter. This expression may include other
     * parameters, in which case the parameter will automatically update in response to upstream
     * parameter changes.
     */
    @JsonProperty("expr")
    public String getExpr() { return expr; }
    @JsonProperty("expr")
    public void setExpr(String value) { this.expr = value; }

    /**
     * Required. A unique name for the parameter. Parameter names should be valid JavaScript
     * identifiers: they should contain only alphanumeric characters (or “$”, or “_”) and may
     * not start with a digit. Reserved keywords that may not be used as parameter names are
     * "datum", "event", "item", and "parent".
     */
    @JsonProperty("name")
    public String getName() { return name; }
    @JsonProperty("name")
    public void setName(String value) { this.name = value; }

    /**
     * The initial value of the parameter.
     *
     * __Default value:__ `undefined`
     */
    @JsonProperty("value")
    public Object getValue() { return value; }
    @JsonProperty("value")
    public void setValue(Object value) { this.value = value; }
}
