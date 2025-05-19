package org.apache.poi.xslf.model.geom;

import java.util.regex.Matcher;

/* loaded from: classes5.dex */
public class IfElseExpression implements Expression {
    private String arg1;
    private String arg2;
    private String arg3;

    IfElseExpression(Matcher matcher) {
        this.arg1 = matcher.group(1);
        this.arg2 = matcher.group(2);
        this.arg3 = matcher.group(3);
    }

    @Override // org.apache.poi.xslf.model.geom.Expression
    public double evaluate(Context context) {
        return context.getValue(this.arg1) > 0.0d ? context.getValue(this.arg2) : context.getValue(this.arg3);
    }
}
