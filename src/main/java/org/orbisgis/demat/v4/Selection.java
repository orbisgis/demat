package org.orbisgis.demat.v4;

import com.fasterxml.jackson.annotation.*;
import java.util.List;

public class Selection {
    private ConditionalValueDefNumberExprRefSelectionComposition not;
    private List<SelectionCompositionElement> and;
    private List<SelectionCompositionElement> or;

    @JsonProperty("not")
    public ConditionalValueDefNumberExprRefSelectionComposition getNot() { return not; }
    @JsonProperty("not")
    public void setNot(ConditionalValueDefNumberExprRefSelectionComposition value) { this.not = value; }

    @JsonProperty("and")
    public List<SelectionCompositionElement> getAnd() { return and; }
    @JsonProperty("and")
    public void setAnd(List<SelectionCompositionElement> value) { this.and = value; }

    @JsonProperty("or")
    public List<SelectionCompositionElement> getOr() { return or; }
    @JsonProperty("or")
    public void setOr(List<SelectionCompositionElement> value) { this.or = value; }
}
