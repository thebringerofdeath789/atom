package org.apache.poi.xslf.model.geom;

import java.util.regex.Matcher;

/* loaded from: classes5.dex */
public class MaxExpression implements Expression {
    private String arg1;
    private String arg2;

    MaxExpression(Matcher matcher) {
        this.arg1 = matcher.group(1);
        this.arg2 = matcher.group(2);
    }

    @Override // org.apache.poi.xslf.model.geom.Expression
    public double evaluate(Context context) {
        return Math.max(context.getValue(this.arg1), context.getValue(this.arg2));
    }
}
