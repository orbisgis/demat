package org.orbisgis.demat.v4;

import com.fasterxml.jackson.annotation.*;

public class AxisResolveMap {
    private ResolveMode x;
    private ResolveMode y;

    @JsonProperty("x")
    public ResolveMode getX() { return x; }
    @JsonProperty("x")
    public void setX(ResolveMode value) { this.x = value; }

    @JsonProperty("y")
    public ResolveMode getY() { return y; }
    @JsonProperty("y")
    public void setY(ResolveMode value) { this.y = value; }
}
