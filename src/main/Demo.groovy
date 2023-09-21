import org.orbisgis.demat.vega.data.Data

import static org.orbisgis.demat.Plot.*

Plot(Projection().azimuthalEquidistant().rotate([0,90,180]),
        Layer(
                Chart(Data(Graticule().step([45,45]))).mark(Geoshape().filled(false).
                strokeWidth(0.2).color("black")),
                Chart(Data([[   "theta": 0, "r": 100, "label": "N"],
                               ["theta": 22.5, "r": 125, "label": "NNE"],
                               ["theta": 45, "r": 100, "label": "NE"],
                               ["theta": 90, "r": 100, "label": "E"],
                               ["theta": 135, "r": 100, "label": "SE"],
                               ["theta": -180, "r": 100, "label": "S"],
                               ["theta": -135, "r": 100, "label": "SW"],
                               ["theta": -90, "r": 100, "label": "W"],
                                ["theta": -45, "r": 100, "label": "NW"]])).encode(Longitude("theta"),
                                Latitude("r"),Text("label")).mark(Text()),
                Chart(Data()).mark(Arc().theta(Radians(-22.5)).theta2(Radians(22.5)).radius(100)),
                Chart(Data()).mark(Arc().theta(Radians(22.5)).theta2(Radians(67.5)).radius(10)),
                Chart(Data()).mark(Arc().theta(Radians(67.5)).theta2(Radians(112.5)).radius(80)),
                Chart(Data()).mark(Arc().theta(Radians(112.5)).theta2(Radians(157.5)).radius(50)),
                Chart(Data()).mark(Arc().theta(Radians(157.5)).theta2(Radians(202.5)).radius(150)),
                Chart(Data()).mark(Arc().theta(Radians(202.5)).theta2(Radians(247.5)).radius(10)),
                Chart(Data()).mark(Arc().theta(Radians(247.5)).theta2(Radians(292.5)).radius(115)),
                Chart(Data()).mark(Arc().theta(Radians(292.5)).theta2(Radians(337.5)).radius(50))
        )).height(500).width(500).save("/tmp/test.png")