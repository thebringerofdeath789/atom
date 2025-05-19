package org.apache.poi.xslf.model.geom;

import java.util.regex.Matcher;

/* loaded from: classes5.dex */
public class AbsExpression implements Expression {
    private String arg;

    AbsExpression(Matcher matcher) {
        this.arg = matcher.group(1);
    }

    @Override // org.apache.poi.xslf.model.geom.Expression
    public double evaluate(Context context) {
        return Math.abs(context.getValue(this.arg));
    }
}
