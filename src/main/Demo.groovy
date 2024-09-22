
import static org.orbisgis.demat.Plot.*

/*
def spec=[
        "height":500,"width":500,
        "projection":["type" : "albersUsa"],
        "data":["url": "https://raw.githubusercontent.com/orbisgis/demat/refs/heads/main/src/test/resources/data/us-10m.json",
                "format": [
                    "type": "topojson",
                    "feature": "counties"
                ]],
        "transform": [["lookup": "id",
                       "from": [
                        "data": [
                                "url": "https://raw.githubusercontent.com/orbisgis/demat/refs/heads/main/src/test/resources/data/unemployment.tsv"],
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
*/

def spec=[
        "height":500,"width":500,
        "projection":["type" : "albersUsa"],
        "data":["url": "../orbisgis/demat/refs/heads/main/src/test/resources/data/us-10m.json",
                "format": [
                        "type": "topojson",
                        "feature": "counties"
                ]],
        "mark": "geoshape"
]
toSVG(spec, "/tmp/map.svg")