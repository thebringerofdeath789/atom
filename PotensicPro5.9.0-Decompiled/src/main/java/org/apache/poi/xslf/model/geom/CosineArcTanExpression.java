package org.apache.poi.xslf.model.geom;

import java.util.regex.Matcher;

/* loaded from: classes5.dex */
public class CosineArcTanExpression implements Expression {
    private String arg1;
    private String arg2;
    private String arg3;

    CosineArcTanExpression(Matcher matcher) {
        this.arg1 = matcher.group(1);
        this.arg2 = matcher.group(2);
        this.arg3 = matcher.group(3);
    }

    @Override // org.apache.poi.xslf.model.geom.Expression
    public double evaluate(Context context) {
        return context.getValue(this.arg1) * Math.cos(Math.atan(context.getValue(this.arg3) / context.getValue(this.arg2)));
    }
}
