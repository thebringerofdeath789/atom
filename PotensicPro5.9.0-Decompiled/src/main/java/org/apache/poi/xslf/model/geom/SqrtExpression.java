package org.apache.poi.xslf.model.geom;

import java.util.regex.Matcher;

/* loaded from: classes5.dex */
public class SqrtExpression implements Expression {
    private String arg;

    SqrtExpression(Matcher matcher) {
        this.arg = matcher.group(1);
    }

    @Override // org.apache.poi.xslf.model.geom.Expression
    public double evaluate(Context context) {
        return Math.sqrt(context.getValue(this.arg));
    }
}
