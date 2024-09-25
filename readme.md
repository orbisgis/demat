# Demat



Demat is a French Brittany word to said Hello (http://devri.bzh/dictionnaire/d/demat/).

Demat is a java library to generate [Vega-lite](https://vega.github.io/vega-lite/) representations.

Demat uses the excellent [JAVET](https://github.com/caoccao/Javet) library to execute JS code.


# Use it

Let's run this script with Groovy to draw a simple bar chart and save it in a svg file.

```groovy
@GrabConfig(systemClassLoader=true)
@Grab(group = 'org.orbisgis', module = 'demat', version = '1.0.0')

import static org.orbisgis.demat.Plot.*

def spec = [
        description:"A simple bar chart with embedded data.",
        data: [values: [
                ["a": "A", "b": 28], ["a": "B", "b": 55], ["a": "C", "b": 43],
                ["a": "D", "b": 91], ["a": "E", "b": 81], ["a": "F", "b": 53],
                ["a": "G", "b": 19], ["a": "H", "b": 87], ["a": "I", "b": 52]]
        ],
        mark:"bar",
        encoding : [x : [field:"a",axis:[LabelAngle:0],type:"nominal"],
                    y:  [field:"b","type":"quantitative"]]]
toSVG(spec,  "/tmp/bar_chart.svg")
```

shows https://vega.github.io/vega-lite/examples/bar.html

Use online data.

```groovy
@GrabConfig(systemClassLoader=true)
@Grab(group = 'org.orbisgis', module = 'demat', version = '1.0.0')

import static org.orbisgis.demat.Plot.*

def spec=[
        "height":500,"width":500,
        "projection":["type" : "albersUsa"],
        "data":["url": "https://raw.githubusercontent.com/vega/vega-datasets/refs/heads/main/data/us-10m.json",
                "format": [
                    "type": "topojson",
                    "feature": "counties"
                ]],
        "transform": [["lookup": "id",
                       "from": [
                        "data": [
                                "url": "https://raw.githubusercontent.com/vega/vega-datasets/refs/heads/main/data/unemployment.tsv"],
                        "key": "id",
                        "fields": ["rate"]]
                      ]],
        "mark": "geoshape",
        "encoding": [
            "color": [
                "field": "rate",
                "type": "quantitative"
            ]
            ]
        ]
toSVG(spec,  "/tmp/bar_chart.svg")
```
shows https://vega.github.io/vega-lite/examples/geo_choropleth.html
