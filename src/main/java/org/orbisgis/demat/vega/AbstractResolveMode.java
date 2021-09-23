package org.orbisgis.demat.vega;

import com.fasterxml.jackson.annotation.JsonValue;

public abstract class AbstractResolveMode {

    ResolveMode resolveMode;

    @JsonValue
    public void setMode(ResolveMode resolveMode) {
        this.resolveMode = resolveMode;
    }

    @JsonValue
    public ResolveMode getResolveMode() {
        return resolveMode;
    }


    public AbstractResolveMode independent() {
        this.setMode(ResolveMode.INDEPENDENT);
        return this;
    }

    public AbstractResolveMode Shared() {
        this.setMode(ResolveMode.SHARED);
        return this;
    }

}
