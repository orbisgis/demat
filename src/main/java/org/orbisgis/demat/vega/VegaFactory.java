package org.orbisgis.demat.vega;

public class VegaFactory {


    static  ExprRef createExpression(String expression) {
        ExprRef exprRef = new ExprRef();
        exprRef.setExpr(expression);
        return exprRef;
    }

    static  CornerRadius createCornerExpression(ExprRef expression) {
        CornerRadius c = new CornerRadius();
        c.exprRef = expression;
        return c;
    }

    static  CornerRadius createCornerExpression(String expression) {
        CornerRadius c = new CornerRadius();
        c.exprRef = createExpression(expression);
        return c;
    }

    static  CornerRadius createCornerValue(double value) {
        CornerRadius c = new CornerRadius();
        c.value = value;
        return c;
    }

    public static Opacity createOpacity(double value) {
        Opacity opacity = new Opacity();
        opacity.value =value;
        return  opacity;
    }

    public static Opacity createOpacity(String expression) {
        Opacity opacity = new Opacity();
        opacity.exprRef =createExpression(expression);
        return  opacity;
    }

    /**
     * Create a coordinate value
     * @param value
     * @return
     */
    public static  Coordinate createCoordinateValue(Number value){
        Coordinate coordinate =  new Coordinate();
        coordinate.doubleValue= value.doubleValue();
        return coordinate;
    }

    /**
     * Create a coordinate value
     * @param value
     * @return
     */
    public static Coordinate createCoordinateValue(String value){
        Coordinate coordinate =  new Coordinate();
        coordinate.stringValue= value;
        return coordinate;
    }

    /**
     * Create a coordinate value
     * @param expression
     * @return
     */
    public static Coordinate createCoordinateExpression(String expression){
        Coordinate coordinate =  new Coordinate();
        coordinate.backgroundExprRefValue= createExpression(expression);
        return coordinate;
    }

    public static MarkColorConfig createMarkColorConfig(String value) {
        MarkColorConfig markColorConfig = new MarkColorConfig();
        markColorConfig.value = value;
        return markColorConfig;
    }
}
