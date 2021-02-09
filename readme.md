# Demat



Demat is a French Brittany word to said Hello (http://devri.bzh/dictionnaire/d/demat/).

Demat is a java library to generate [Vega-lite](https://vega.github.io/vega-lite/) representations.


Demat is under active development, nothing is stable ;-)


# Use it

The folowing code : 
```java

x x = Demat.X("a").nominal();
Y y = Demat.Y("b").quantitative();
View view = Demat.view().description("A simple bar chart").name("A simple name")
                .data(new Object[][]{{"a", "b", "c"}, {1, 22, 12}, {200, 300, 400}})
                .mark_bar()
                .encoding(x, y);
view.save( "/tmp/mybar.html");

```

shows https://vega.github.io/vega-lite/examples/bar.html
