package org.orbisgis.demat.vega.layout;


import org.orbisgis.demat.vega.LayerElement;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to create a layer
 */
public class Layer {

    List<LayerElement> layerElements;

    public Layer(){
        this.layerElements = new ArrayList<>();
    }

    public List<LayerElement> getLayerElements() {
        return layerElements;
    }

    public void setLayerElement(LayerElement layerElement) {
       layerElements.add(layerElement);
    }
}
