package org.orbisgis.demat.vega;

import com.fasterxml.jackson.annotation.*;
import java.util.List;

public class ImputeParams {
    private List<Double> frame;
    private Keyvals keyvals;
    private ImputeParamsMethod method;
    private Object value;

    /**
     * A frame specification as a two-element array used to control the window over which the
     * specified method is applied. The array entries should either be a number indicating the
     * offset from the current data object, or null to indicate unbounded rows preceding or
     * following the current data object. For example, the value `[-5, 5]` indicates that the
     * window should include five objects preceding and five objects following the current
     * object.
     *
     * __Default value:__:  `[null, null]` indicating that the window includes all objects.
     */
    @JsonProperty("frame")
    public List<Double> getFrame() { return frame; }
    @JsonProperty("frame")
    public void setFrame(List<Double> value) { this.frame = value; }

    /**
     * Defines the key values that should be considered for imputation. An array of key values
     * or an object defining a [number
     * sequence](https://vega.github.io/vega-lite/docs/impute.html#sequence-def).
     *
     * If provided, this will be used in addition to the key values observed within the input
     * data. If not provided, the values will be derived from all unique values of the `key`
     * field. For `impute` in `encoding`, the key field is the x-field if the y-field is
     * imputed, or vice versa.
     *
     * If there is no impute grouping, this property _must_ be specified.
     */
    @JsonProperty("keyvals")
    public Keyvals getKeyvals() { return keyvals; }
    @JsonProperty("keyvals")
    public void setKeyvals(Keyvals value) { this.keyvals = value; }

    /**
     * The imputation method to use for the field value of imputed data objects. One of
     * `"value"`, `"mean"`, `"median"`, `"max"` or `"min"`.
     *
     * __Default value:__  `"value"`
     */
    @JsonProperty("method")
    public ImputeParamsMethod getMethod() { return method; }
    @JsonProperty("method")
    public void setMethod(ImputeParamsMethod value) { this.method = value; }

    /**
     * The field value to use when the imputation `method` is `"value"`.
     */
    @JsonProperty("value")
    public Object getValue() { return value; }
    @JsonProperty("value")
    public void setValue(Object value) { this.value = value; }
}
