package org.orbisgis.demat.vega;

import com.fasterxml.jackson.annotation.*;

public class ScaleResolveMap {
    private ResolveMode angle;
    private ResolveMode color;
    private ResolveMode fill;
    private ResolveMode fillOpacity;
    private ResolveMode opacity;
    private ResolveMode radius;
    private ResolveMode shape;
    private ResolveMode size;
    private ResolveMode stroke;
    private ResolveMode strokeDash;
    private ResolveMode strokeOpacity;
    private ResolveMode strokeWidth;
    private ResolveMode theta;
    private ResolveMode x;
    private ResolveMode y;

    @JsonProperty("angle")
    public ResolveMode getAngle() { return angle; }
    @JsonProperty("angle")
    public void setAngle(ResolveMode value) { this.angle = value; }

    @JsonProperty("color")
    public ResolveMode getColor() { return color; }
    @JsonProperty("color")
    public void setColor(ResolveMode value) { this.color = value; }

    @JsonProperty("fill")
    public ResolveMode getFill() { return fill; }
    @JsonProperty("fill")
    public void setFill(ResolveMode value) { this.fill = value; }

    @JsonProperty("fillOpacity")
    public ResolveMode getFillOpacity() { return fillOpacity; }
    @JsonProperty("fillOpacity")
    public void setFillOpacity(ResolveMode value) { this.fillOpacity = value; }

    @JsonProperty("opacity")
    public ResolveMode getOpacity() { return opacity; }
    @JsonProperty("opacity")
    public void setOpacity(ResolveMode value) { this.opacity = value; }

    @JsonProperty("radius")
    public ResolveMode getRadius() { return radius; }
    @JsonProperty("radius")
    public void setRadius(ResolveMode value) { this.radius = value; }

    @JsonProperty("shape")
    public ResolveMode getShape() { return shape; }
    @JsonProperty("shape")
    public void setShape(ResolveMode value) { this.shape = value; }

    @JsonProperty("size")
    public ResolveMode getSize() { return size; }
    @JsonProperty("size")
    public void setSize(ResolveMode value) { this.size = value; }

    @JsonProperty("stroke")
    public ResolveMode getStroke() { return stroke; }
    @JsonProperty("stroke")
    public void setStroke(ResolveMode value) { this.stroke = value; }

    @JsonProperty("strokeDash")
    public ResolveMode getStrokeDash() { return strokeDash; }
    @JsonProperty("strokeDash")
    public void setStrokeDash(ResolveMode value) { this.strokeDash = value; }

    @JsonProperty("strokeOpacity")
    public ResolveMode getStrokeOpacity() { return strokeOpacity; }
    @JsonProperty("strokeOpacity")
    public void setStrokeOpacity(ResolveMode value) { this.strokeOpacity = value; }

    @JsonProperty("strokeWidth")
    public ResolveMode getStrokeWidth() { return strokeWidth; }
    @JsonProperty("strokeWidth")
    public void setStrokeWidth(ResolveMode value) { this.strokeWidth = value; }

    @JsonProperty("theta")
    public ResolveMode getTheta() { return theta; }
    @JsonProperty("theta")
    public void setTheta(ResolveMode value) { this.theta = value; }

    @JsonProperty("x")
    public ResolveMode getX() { return x; }
    @JsonProperty("x")
    public void setX(ResolveMode value) { this.x = value; }

    @JsonProperty("y")
    public ResolveMode getY() { return y; }
    @JsonProperty("y")
    public void setY(ResolveMode value) { this.y = value; }
}
