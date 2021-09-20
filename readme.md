# Demat



Demat is a French Brittany word to said Hello (http://devri.bzh/dictionnaire/d/demat/).

Demat is a java library to generate [Vega-lite](https://vega.github.io/vega-lite/) representations.


Demat is under active development, nothing is stable ;-)


# Use it

Let's run this script with Groovy

```groovy
@GrabResolver(name='orbisgis', root='https://nexus.orbisgis.org/repository/orbisgis/')
@Grab(group='org.orbisgis', module='demat', version='0.0.4')

import  static org.orbisgis.demat.Demat.*;

def chart = Chart().description("A simple bar chart").name("A simple name")
        .data(new Object[][]{{"a", "b", "c"}, {1, 22, 12}, {200, 300, 400}})
        .mark_bar()
        .encode(x("a").nominal(), y("b").quantitative());
chart.show();

```

shows https://vega.github.io/vega-lite/examples/bar.html




