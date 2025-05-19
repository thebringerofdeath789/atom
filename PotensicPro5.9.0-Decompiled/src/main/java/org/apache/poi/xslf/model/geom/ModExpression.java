package org.apache.poi.xslf.model.geom;

import java.util.regex.Matcher;

/* loaded from: classes5.dex */
public class ModExpression implements Expression {
    private String arg1;
    private String arg2;
    private String arg3;

    ModExpression(Matcher matcher) {
        this.arg1 = matcher.group(1);
        this.arg2 = matcher.group(2);
        this.arg3 = matcher.group(3);
    }

    @Override // org.apache.poi.xslf.model.geom.Expression
    public double evaluate(Context context) {
        double value = context.getValue(this.arg1);
        double value2 = context.getValue(this.arg2);
        double value3 = context.getValue(this.arg3);
        return Math.sqrt((value * value) + (value2 * value2) + (value3 * value3));
    }
}
