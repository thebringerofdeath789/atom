package org.apache.poi.xslf.model.geom;

import java.util.regex.Matcher;

/* loaded from: classes5.dex */
public class ArcTanExpression implements Expression {
    private String arg1;
    private String arg2;

    ArcTanExpression(Matcher matcher) {
        this.arg1 = matcher.group(1);
        this.arg2 = matcher.group(2);
    }

    @Override // org.apache.poi.xslf.model.geom.Expression
    public double evaluate(Context context) {
        return Math.atan(context.getValue(this.arg2) / context.getValue(this.arg1));
    }
}
