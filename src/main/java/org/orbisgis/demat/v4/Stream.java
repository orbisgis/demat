package org.orbisgis.demat.v4;

import com.fasterxml.jackson.annotation.*;
import java.util.List;

public class Stream {
    private List<Stream> between;
    private Boolean consume;
    private Double debounce;
    private LegendText filter;
    private String markname;
    private MarkType marktype;
    private String source;
    private Double throttle;
    private String type;
    private Stream stream;
    private List<Stream> merge;

    @JsonProperty("between")
    public List<Stream> getBetween() { return between; }
    @JsonProperty("between")
    public void setBetween(List<Stream> value) { this.between = value; }

    @JsonProperty("consume")
    public Boolean getConsume() { return consume; }
    @JsonProperty("consume")
    public void setConsume(Boolean value) { this.consume = value; }

    @JsonProperty("debounce")
    public Double getDebounce() { return debounce; }
    @JsonProperty("debounce")
    public void setDebounce(Double value) { this.debounce = value; }

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

    @JsonProperty("type")
    public String getType() { return type; }
    @JsonProperty("type")
    public void setType(String value) { this.type = value; }

    @JsonProperty("stream")
    public Stream getStream() { return stream; }
    @JsonProperty("stream")
    public void setStream(Stream value) { this.stream = value; }

    @JsonProperty("merge")
    public List<Stream> getMerge() { return merge; }
    @JsonProperty("merge")
    public void setMerge(List<Stream> value) { this.merge = value; }
}
