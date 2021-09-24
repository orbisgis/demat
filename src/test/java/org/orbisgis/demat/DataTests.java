package org.orbisgis.demat;

import org.orbisgis.demat.vega.data.Data;

import java.io.IOException;

public class DataTests {


    /**
     * Load the cars json file provided by vega-lite code source
     *
     * @return
     */
    public static Data cars() {
        try {
            return Read.fromJSON(DataTests.class.getResourceAsStream("cars.json"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Load the seattle_weather json file provided by vega-lite code source
     *
     * @return
     */
    public static Data seattle_weather() {
        try {
            return Read.csv(DataTests.class.getResourceAsStream("seattle-weather.csv"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
