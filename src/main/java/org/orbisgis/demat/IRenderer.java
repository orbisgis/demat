package org.orbisgis.demat;

import java.io.IOException;

public interface IRenderer {
    void show();

    String save() throws IOException;

    String save(String path) throws IOException;

}
