# Demat



Demat is a French Brittany word to said Hello (http://devri.bzh/dictionnaire/d/demat/).

Demat is a java library to generate [Vega-lite](https://vega.github.io/vega-lite/) representations.


Demat is under active development, nothing is stable ;-)


# Use it

Let's run this script with Groovy

```groovy
@GrabResolver(name = 'orbisgis', root = 'https://oss.sonatype.org/content/repositories/snapshots/')
@Grab(group = 'org.orbisgis', module = 'demat', version = '0.0.7-SNAPSHOT')

import static org.orbisgis.demat.Demat.*

def chart = Chart().description("A simple bar chart").name("A simple name")
        .data(new Object[][]{{"a", "b", "c"}, {1, 22, 12}, {200, 300, 400}})
        .mark_bar()
        .encode(X("a").nominal(), Y("b").quantitative())
chart.show()
```

shows https://vega.github.io/vega-lite/examples/bar.html

