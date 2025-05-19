package org.apache.poi.xslf.model.geom;

import java.util.regex.Matcher;

/* loaded from: classes5.dex */
public class SinExpression implements Expression {
    private String arg1;
    private String arg2;

    SinExpression(Matcher matcher) {
        this.arg1 = matcher.group(1);
        this.arg2 = matcher.group(2);
    }

    @Override // org.apache.poi.xslf.model.geom.Expression
    public double evaluate(Context context) {
        return context.getValue(this.arg1) * Math.sin(Math.toRadians(context.getValue(this.arg2) / 60000.0d));
    }
}
