package org.orbisgis.demat;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.locationtech.jts.geom.Envelope;
import org.orbisgis.demat.vega.*;
import org.orbisgis.demat.vega.data.Data;
import org.orbisgis.demat.vega.data.SequenceParams;
import org.orbisgis.demat.vega.encoding.X;
import org.orbisgis.demat.vega.encoding.Y;
import org.orbisgis.demat.vega.transform.Transform;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OSMLayer {

    private static final double MAX_ZOOM = 20;
    static String TILE_URL_PARAM = "tile_url";
    static String ZOOM_LEVEL_PARAM = "zoom_level";
    private double zoom_level =17;

    private String tile_url = "https://tile.openstreetmap.org/";

    double lat, lon;

    /**
     *
     * "projection": {
     *        "center": { "expr": "[-2.079943,47.654317]"},
     *        "rotate": {"expr": "[0, 0, 0]"},
     *        "scale": {"expr": "tile_size * pow(2, zoom_level) / (2 * PI)"},
     *        "translate": {"expr": "[param_2, map_height]"},
     *        "type": "mercator"}
     * @return
     */
    public Projection getProjection() {
        Projection projection = new Projection();
        projection.setCenter(Arrays.asList(getLat(), getLon()));
        projection.setRotate("[0, 0, 0]");
        projection.setScale("tile_size * pow(2, zoom_level) / (2 * PI)");
        projection.setTranslate("[map_width, map_height]");
        projection.setType(ProjectionType.MERCATOR);
        return projection;
    }

    public void setCenter(double lat, double lon){
        this.lat =lat;
        this.lon=lon;
    }

    public void setTile_url(String tile_url) {
        this.tile_url = tile_url;
    }

    public String getTile_url() {
        return tile_url;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    /**
     * Get the parameters used to compute the tile URL
     *
     * "params": [
     *     {
     *       "name": "tile_url",
     *       "value": "https://tile.opentopomap.org/"
     *     },
     *     {"name": "param_8", "expr": "tile_url"},
     *     {"name": "param_9", "expr": "ceil(zoom_level)"},
     *     {"name": "param_10", "expr": "pow(2, param_9)"},
     *     {"name": "param_11", "expr": "tile_size * pow(2, zoom_level - param_9)"},
     *     {"name": "param_12", "expr": "invert('projection', [0, 0])"},
     *     {"name": "param_13", "expr": "(param_12[0] + 180) / 360 * param_10"},
     *     {"name": "param_14", "expr": "floor(param_13)"},
     *     {
     *       "name": "param_15",
     *       "expr": "round((floor(param_13) - param_13) * param_11)"
     *     },
     *     {
     *       "name": "param_16",
     *       "expr": "(1 - log(tan(param_12[1] * PI / 180) + 1 / cos(param_12[1] * PI / 180)) / PI) / 2 * param_10"
     *     },
     *     {"name": "param_17", "expr": "floor(param_16)"},
     *     {
     *       "name": "param_18",
     *       "expr": "round((floor(param_16)-param_16) * param_11)"
     *     },
     *     {
     *       "name": "zoom_level",
     *       "value": 17
     *     },
     *     {"name": "map_", "expr": "width / 2"},
     *     {"name": "map_height", "expr": "height / 2"},
     *     {"name": "tile_size", "value": 256}
     *   ]
     * @return
     */
    public List getParameters() {
        List<Parameter> parameters = new ArrayList<>();

        parameters.add(getTileUrlParameter());
        Parameter param_8 = new Parameter();
        param_8.setName("param_8");
        param_8.setExpr(TILE_URL_PARAM);
        parameters.add(param_8);

        Parameter param_9 = new Parameter();
        param_9.setName("param_9");
        param_9.setExpr("ceil(zoom_level)");
        parameters.add(param_9);

        Parameter param_10 = new Parameter();
        param_10.setName("param_10");
        param_10.setExpr("pow(2, param_9)");
        parameters.add(param_10);

        Parameter param_11 = new Parameter();
        param_11.setName("param_11");
        param_11.setExpr("tile_size * pow(2, zoom_level - param_9)");
        parameters.add(param_11);

        Parameter param_12 = new Parameter();
        param_12.setName("param_12");
        param_12.setExpr("invert('projection', [0, 0])");
        parameters.add(param_12);

        Parameter param_13 = new Parameter();
        param_13.setName("param_13");
        param_13.setExpr("(param_12[0] + 180) / 360 * param_10");
        parameters.add(param_13);

        Parameter param_14 = new Parameter();
        param_14.setName("param_14");
        param_14.setExpr("floor(param_13)");
        parameters.add(param_14);

        Parameter param_15 = new Parameter();
        param_15.setName("param_15");
        param_15.setExpr("round((floor(param_13) - param_13) * param_11)");
        parameters.add(param_15);

        Parameter param_16 = new Parameter();
        param_16.setName("param_16");
        param_16.setExpr("(1 - log(tan(param_12[1] * PI / 180) + 1 / cos(param_12[1] * PI / 180)) / PI) / 2 * param_10");
        parameters.add(param_16);

        Parameter param_17 = new Parameter();
        param_17.setName("param_17");
        param_17.setExpr("floor(param_16)");
        parameters.add(param_17);

        Parameter param_18 = new Parameter();
        param_18.setName("param_18");
        param_18.setExpr("round((floor(param_16)-param_16) * param_11)");
        parameters.add(param_18);

        Parameter map_width = new Parameter();
        map_width.setName("map_width");
        map_width.setExpr("width / 2");
        parameters.add(map_width);

        Parameter map_height = new Parameter();
        map_height.setName("map_height");
        map_height.setExpr("height / 2");
        parameters.add(map_height);

        Parameter tile_size = new Parameter();
        tile_size.setName("tile_size");
        tile_size.setValue(256);
        parameters.add(tile_size);

        parameters.add(getZoomParameter());
        return parameters;

    }

    public Parameter getZoomParameter() {
        Parameter zoomParameter = new Parameter();
        zoomParameter.setName("zoom_level");
        zoomParameter.setValue(getZoomLevel());
        return zoomParameter;
    }

    private double getZoomLevel() {
        return this.zoom_level;
    }

    public  void setZoomLevel(double zoom_level) {
        this.zoom_level=zoom_level;
    }


    Parameter getTileUrlParameter() {
        Parameter tile_url = new Parameter();
        tile_url.setName(TILE_URL_PARAM);
        tile_url.setValue(getTile_url());
        return tile_url;
    }


    /**
     * "data": {
     * "sequence": {"start": 0, "stop": 4, "as": "a"},
     * "name": "tile_list"
     * }
     *
     * @return
     */
    Data getDataTileList() {
        Data data = new Data();
        SequenceParams sequenceParams = new SequenceParams();
        sequenceParams.setStart(0);
        sequenceParams.setStop(4);
        sequenceParams.setAs("a");
        data.setSequence(sequenceParams);
        data.setName("tile_list");
        return data;
    }

    /**
     * "mark": {
     * "type": "image",
     * "clip": true,
     * "height": {"expr": "param_11"},
     * "width": {"expr": "param_11"}
     * }
     *
     * @return
     */
    Mark getMarkImage() {
        Mark mark = new Mark();
        Def def = new Def();
        def.setClip(true);
        CornerRadius exp = new CornerRadius();
        ExprRef exprRef = new ExprRef();
        exprRef.setExpr("param_11");
        exp.exprRef = exprRef;
        def.setHeight(exp);
        def.setWidth(exp);
        def.setType("image");
        mark.def = def;
        return mark;
    }

    /**
     * "encoding": {
     * "url": {"field": "url", "type": "nominal"},
     * "x": {"field": "x", "scale": null, "type": "quantitative"},
     * "y": {"field": "y", "scale": null, "type": "quantitative"}
     * }
     *
     * @return
     */
    LayerEncoding getEncoding() {
        LayerEncoding encoding = new LayerEncoding();
        URLClass urlClass = new URLClass();
        Field field_url = new Field();
        field_url.stringValue = "url";
        urlClass.setField(field_url);
        urlClass.setType(Type.NOMINAL);
        encoding.setURL(urlClass);
        X x = new X();
        x.quantitative();
        Field x_field = new Field();
        x_field.stringValue = "x";
        x.setScale(null);
        x.setField(x_field);
        encoding.setX(x);
        Y y = new Y();
        y.quantitative();
        Field y_field = new Field();
        y_field.stringValue = "y";
        y.setScale(null);
        y.setField(y_field);
        encoding.setY(y);
        return encoding;
    }


    /**
     * "transform": [
     * {"calculate": "sequence(0, 4)", "as": "b"},
     * {"flatten": ["b"]},
     * {
     * "calculate": "param_8 + param_9 + '/' + (datum.a + param_14 + param_10) % param_10 + '/' + ((datum.b + param_17)) + '.png'",
     * "as": "url"
     * },
     * {
     * "calculate": "(datum.a * param_11 + param_15) + (param_11 / 2)",
     * "as": "x"
     * },
     * {
     * "calculate": "(datum.b * param_11 + param_18) + (param_11 / 2)",
     * "as": "y"
     * }
     * ]
     *
     * @return
     */
    List<Transform> getTransform() {
        List<Transform> trans_ = new ArrayList<>();
        Transform calculate = new Transform();
        calculate.setCalculate("sequence(0, 4)");
        calculate.setAs("b");
        trans_.add(calculate);

        Transform flatten = new Transform();
        flatten.setFlatten("b");
        trans_.add(flatten);

        Transform calculate_url = new Transform();
        calculate_url.setCalculate("param_8 + param_9 + '/' + (datum.a + param_14 + param_10) % param_10 + '/' + ((datum.b + param_17)) + '.png'");
        calculate_url.setAs("url");
        trans_.add(calculate_url);

        Transform calculate_x = new Transform();
        calculate_x.setCalculate("(datum.a * param_11 + param_15) + (param_11 / 2)");
        calculate_x.setAs("x");
        trans_.add(calculate_x);

        Transform calculate_y = new Transform();
        calculate_y.setCalculate("(datum.b * param_11 + param_18) + (param_11 / 2)");
        calculate_y.setAs("y");
        trans_.add(calculate_y);

        return trans_;
    }

    public double getZoomToFitBounds(Envelope bounds)
    {
        bounds.expandBy(0.05);
        double latlength = bounds.getWidth();
        double  lonlength = bounds.getHeight();

        double zoomlon =  Math.ceil(log2(360 * 2/lonlength));
        double zoomlat =  Math.ceil(log2(180 * 2/latlength));
        return Math.min(Math.max(zoomlon, zoomlat), MAX_ZOOM);

    }

    public static double log2(double N)    {
        return (Math.log(N) / Math.log(2));
    }
    /**
     *
     * @param bounds
     * @param view_width
     * @param view_height
     * @return
     */
    public static double getZoomForExtent (Envelope bounds, int view_width, int view_height) {
        var maxResolution= 2000;
        var width = bounds.getWidth();
        var height = bounds.getHeight();
        var deg_per_pixel = (width > height ? width / view_width : height / view_height);
        var zoom = Math.log(maxResolution / deg_per_pixel) / Math.log(2);
        return Math.min(Math.floor(Math.max(zoom, 0)), MAX_ZOOM);
    }

    public LayerElement getTileLayer(){
        LayerElement layerElement = new LayerElement();
        layerElement.setData(getDataTileList());
        layerElement.setMark(getMarkImage());
        layerElement.setEncoding(getEncoding());
        layerElement.setTransform(getTransform());
        return layerElement;
    }

    /*
    {
  "layer": [
    {
      "data": {
        "sequence": {"start": 0, "stop": 4, "as": "a"},
        "name": "tile_list"
      },
      "mark": {
        "type": "image",
        "clip": true,
        "height": {"expr": "param_11"},
        "width": {"expr": "param_11"}
      },
      "encoding": {
        "url": {"field": "url", "type": "nominal"},
        "x": {"field": "x", "scale": null, "type": "quantitative"},
        "y": {"field": "y", "scale": null, "type": "quantitative"}
      },
      "transform": [
        {"calculate": "sequence(0, 4)", "as": "b"},
        {"flatten": ["b"]},
        {
          "calculate": "param_8 + param_9 + '/' + (datum.a + param_14 + param_10) % param_10 + '/' + ((datum.b + param_17)) + '.png'",
          "as": "url"
        },
        {
          "calculate": "(datum.a * param_11 + param_15) + (param_11 / 2)",
          "as": "x"
        },
        {
          "calculate": "(datum.b * param_11 + param_18) + (param_11 / 2)",
          "as": "y"
        }
      ]
    },
    {
      "mark": {
        "type": "geoshape"
      },
      "projection": {
        "center": { "expr": "[-2.079943,47.654317]"},
        "rotate": {"expr": "[0, 0, 0]"},
        "scale": {"expr": "tile_size * pow(2, zoom_level) / (2 * PI)"},
        "translate": {"expr": "[param_2, map_height]"},
        "type": "mercator"
      }
    }
  ],
  "height": 400,
  "params": [
    {
      "name": "tile_url",
      "value": "https://tile.opentopomap.org/"
    },
    {"name": "param_8", "expr": "tile_url"},
    {"name": "param_9", "expr": "ceil(zoom_level)"},
    {"name": "param_10", "expr": "pow(2, param_9)"},
    {"name": "param_11", "expr": "tile_size * pow(2, zoom_level - param_9)"},
    {"name": "param_12", "expr": "invert('projection', [0, 0])"},
    {"name": "param_13", "expr": "(param_12[0] + 180) / 360 * param_10"},
    {"name": "param_14", "expr": "floor(param_13)"},
    {
      "name": "param_15",
      "expr": "round((floor(param_13) - param_13) * param_11)"
    },
    {
      "name": "param_16",
      "expr": "(1 - log(tan(param_12[1] * PI / 180) + 1 / cos(param_12[1] * PI / 180)) / PI) / 2 * param_10"
    },
    {"name": "param_17", "expr": "floor(param_16)"},
    {
      "name": "param_18",
      "expr": "round((floor(param_16)-param_16) * param_11)"
    },
    {
      "name": "zoom_level",
      "value": 17
    },
    {"name": "map_", "expr": "width / 2"},
    {"name": "map_height", "expr": "height / 2"},
    {"name": "tile_size", "value": 256}
  ],
  "width": 400,
  "$schema": "https://vega.github.io/schema/vega-lite/v5.6.1.json"
}
     */

    public static void main(String[] args) throws JsonProcessingException {
        OSMLayer osmParameters = new OSMLayer();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        System.out.println(objectMapper.writeValueAsString(osmParameters.getProjection()));
    }

}
