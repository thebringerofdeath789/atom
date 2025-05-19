package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;

/* loaded from: classes5.dex */
public final class Value extends Fixed1ArgFunction {
    private static final int MIN_DISTANCE_BETWEEN_THOUSANDS_SEPARATOR = 4;
    private static final Double ZERO = new Double(0.0d);

    @Override // org.apache.poi.ss.formula.functions.Function1Arg
    public ValueEval evaluate(int i, int i2, ValueEval valueEval) {
        try {
            Double convertTextToNumber = convertTextToNumber(OperandResolver.coerceValueToString(OperandResolver.getSingleValue(valueEval, i, i2)));
            if (convertTextToNumber == null) {
                return ErrorEval.VALUE_INVALID;
            }
            return new NumberEval(convertTextToNumber.doubleValue());
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    private static Double convertTextToNumber(String str) {
        int length = str.length();
        boolean z = false;
        int i = 0;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        while (i < length) {
            char charAt = str.charAt(i);
            if (Character.isDigit(charAt) || charAt == '.') {
                break;
            }
            if (charAt != ' ') {
                if (charAt != '$') {
                    if (charAt != '+') {
                        if (charAt != '-' || z3 || z4) {
                            return null;
                        }
                        z3 = true;
                    } else {
                        if (z3 || z4) {
                            return null;
                        }
                        z4 = true;
                    }
                } else {
                    if (z2) {
                        return null;
                    }
                    z2 = true;
                }
            }
            i++;
        }
        if (i >= length) {
            if (z2 || z3 || z4) {
                return null;
            }
            return ZERO;
        }
        StringBuffer stringBuffer = new StringBuffer(length);
        int i2 = -32768;
        int i3 = i;
        boolean z5 = false;
        while (i3 < length) {
            char charAt2 = str.charAt(i3);
            if (Character.isDigit(charAt2)) {
                stringBuffer.append(charAt2);
            } else if (charAt2 != ' ') {
                if (charAt2 != '%') {
                    if (charAt2 != ',') {
                        if (charAt2 != '.') {
                            if ((charAt2 != 'E' && charAt2 != 'e') || i3 - i2 < 4) {
                                return null;
                            }
                            stringBuffer.append(str.substring(i3));
                            i3 = length;
                        } else {
                            if (z || i3 - i2 < 4) {
                                return null;
                            }
                            stringBuffer.append('.');
                            z = true;
                        }
                    } else {
                        if (z || i3 - i2 < 4) {
                            return null;
                        }
                        i2 = i3;
                    }
                }
                z5 = true;
            } else {
                String trim = str.substring(i3).trim();
                if (!trim.equals("%")) {
                    if (trim.length() > 0) {
                        return null;
                    }
                }
                z5 = true;
            }
            i3++;
        }
        if (!z && i3 - i2 < 4) {
            return null;
        }
        try {
            double parseDouble = Double.parseDouble(stringBuffer.toString());
            if (z3) {
                parseDouble = -parseDouble;
            }
            double doubleValue = new Double(parseDouble).doubleValue();
            if (z5) {
                doubleValue /= 100.0d;
            }
            return Double.valueOf(doubleValue);
        } catch (NumberFormatException unused) {
            return null;
        }
    }
}
