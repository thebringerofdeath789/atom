package org.apache.poi.xslf.model.geom;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes5.dex */
public class ExpressionParser {
    static final HashMap<String, Class> impls;

    static {
        HashMap<String, Class> hashMap = new HashMap<>();
        impls = hashMap;
        hashMap.put("\\*/ +([\\-\\w]+) +([\\-\\w]+) +([\\-\\w]+)", MultiplyDivideExpression.class);
        hashMap.put("\\+- +([\\-\\w]+) +([\\-\\w]+) +([\\-\\w]+)( 0)?", AddSubtractExpression.class);
        hashMap.put("\\+/ +([\\-\\w]+) +([\\-\\w]+) +([\\-\\w]+)", AddDivideExpression.class);
        hashMap.put("\\?: +([\\-\\w]+) +([\\-\\w]+) +([\\-\\w]+)", IfElseExpression.class);
        hashMap.put("val +([\\-\\w]+)", LiteralValueExpression.class);
        hashMap.put("abs +([\\-\\w]+)", AbsExpression.class);
        hashMap.put("sqrt +([\\-\\w]+)", SqrtExpression.class);
        hashMap.put("max +([\\-\\w]+) +([\\-\\w]+)", MaxExpression.class);
        hashMap.put("min +([\\-\\w]+) +([\\-\\w]+)", MinExpression.class);
        hashMap.put("at2 +([\\-\\w]+) +([\\-\\w]+)", ArcTanExpression.class);
        hashMap.put("sin +([\\-\\w]+) +([\\-\\w]+)", SinExpression.class);
        hashMap.put("cos +([\\-\\w]+) +([\\-\\w]+)", CosExpression.class);
        hashMap.put("tan +([\\-\\w]+) +([\\-\\w]+)", TanExpression.class);
        hashMap.put("cat2 +([\\-\\w]+) +([\\-\\w]+) +([\\-\\w]+)", CosineArcTanExpression.class);
        hashMap.put("sat2 +([\\-\\w]+) +([\\-\\w]+) +([\\-\\w]+)", SinArcTanExpression.class);
        hashMap.put("pin +([\\-\\w]+) +([\\-\\w]+) +([\\-\\w]+)", PinExpression.class);
        hashMap.put("mod +([\\-\\w]+) +([\\-\\w]+) +([\\-\\w]+)", ModExpression.class);
    }

    public static Expression parse(String str) {
        for (String str2 : impls.keySet()) {
            Matcher matcher = Pattern.compile(str2).matcher(str);
            if (matcher.matches()) {
                try {
                    return (Expression) impls.get(str2).getDeclaredConstructor(Matcher.class).newInstance(matcher);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
        throw new RuntimeException("Unsupported formula: " + str);
    }
}
