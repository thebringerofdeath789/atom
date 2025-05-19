package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.BlankEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.MissingArgEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;

/* loaded from: classes5.dex */
public final class Indirect implements FreeRefFunction {
    public static final FreeRefFunction instance = new Indirect();

    private Indirect() {
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] valueEvalArr, OperationEvaluationContext operationEvaluationContext) {
        boolean z = true;
        if (valueEvalArr.length < 1) {
            return ErrorEval.VALUE_INVALID;
        }
        try {
            String coerceValueToString = OperandResolver.coerceValueToString(OperandResolver.getSingleValue(valueEvalArr[0], operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex()));
            int length = valueEvalArr.length;
            if (length != 1) {
                if (length == 2) {
                    z = evaluateBooleanArg(valueEvalArr[1], operationEvaluationContext);
                } else {
                    return ErrorEval.VALUE_INVALID;
                }
            }
            return evaluateIndirect(operationEvaluationContext, coerceValueToString, z);
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    private static boolean evaluateBooleanArg(ValueEval valueEval, OperationEvaluationContext operationEvaluationContext) throws EvaluationException {
        ValueEval singleValue = OperandResolver.getSingleValue(valueEval, operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex());
        if (singleValue == BlankEval.instance || singleValue == MissingArgEval.instance) {
            return false;
        }
        return OperandResolver.coerceValueToBoolean(singleValue, false).booleanValue();
    }

    private static ValueEval evaluateIndirect(OperationEvaluationContext operationEvaluationContext, String str, boolean z) {
        String str2;
        String str3;
        String trim;
        String str4;
        int lastIndexOf = str.lastIndexOf(33);
        if (lastIndexOf < 0) {
            str2 = null;
            str3 = null;
        } else {
            String[] parseWorkbookAndSheetName = parseWorkbookAndSheetName(str.subSequence(0, lastIndexOf));
            if (parseWorkbookAndSheetName == null) {
                return ErrorEval.REF_INVALID;
            }
            str2 = parseWorkbookAndSheetName[0];
            String str5 = parseWorkbookAndSheetName[1];
            str = str.substring(lastIndexOf + 1);
            str3 = str5;
        }
        int indexOf = str.indexOf(58);
        if (indexOf < 0) {
            str4 = str.trim();
            trim = null;
        } else {
            String trim2 = str.substring(0, indexOf).trim();
            trim = str.substring(indexOf + 1).trim();
            str4 = trim2;
        }
        return operationEvaluationContext.getDynamicReference(str2, str3, str4, trim, z);
    }

    private static String[] parseWorkbookAndSheetName(CharSequence charSequence) {
        int i;
        String str;
        int length = charSequence.length() - 1;
        if (length < 0 || canTrim(charSequence)) {
            return null;
        }
        char charAt = charSequence.charAt(0);
        if (Character.isWhitespace(charAt)) {
            return null;
        }
        if (charAt != '\'') {
            if (charAt != '[') {
                return new String[]{null, charSequence.toString()};
            }
            int lastIndexOf = charSequence.toString().lastIndexOf(93);
            if (lastIndexOf < 0) {
                return null;
            }
            CharSequence subSequence = charSequence.subSequence(1, lastIndexOf);
            if (canTrim(subSequence)) {
                return null;
            }
            CharSequence subSequence2 = charSequence.subSequence(lastIndexOf + 1, charSequence.length());
            if (canTrim(subSequence2)) {
                return null;
            }
            return new String[]{subSequence.toString(), subSequence2.toString()};
        }
        if (charSequence.charAt(length) != '\'') {
            return null;
        }
        char charAt2 = charSequence.charAt(1);
        if (Character.isWhitespace(charAt2)) {
            return null;
        }
        if (charAt2 == '[') {
            int lastIndexOf2 = charSequence.toString().lastIndexOf(93);
            if (lastIndexOf2 < 0 || (str = unescapeString(charSequence.subSequence(2, lastIndexOf2))) == null || canTrim(str)) {
                return null;
            }
            i = lastIndexOf2 + 1;
        } else {
            i = 1;
            str = null;
        }
        String unescapeString = unescapeString(charSequence.subSequence(i, length));
        if (unescapeString == null) {
            return null;
        }
        return new String[]{str, unescapeString};
    }

    private static String unescapeString(CharSequence charSequence) {
        char charAt;
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        int i = 0;
        while (i < length) {
            char charAt2 = charSequence.charAt(i);
            if (charAt2 == '\'') {
                i++;
                if (i >= length || (charAt = charSequence.charAt(i)) != '\'') {
                    return null;
                }
                charAt2 = charAt;
            }
            sb.append(charAt2);
            i++;
        }
        return sb.toString();
    }

    private static boolean canTrim(CharSequence charSequence) {
        int length = charSequence.length() - 1;
        if (length < 0) {
            return false;
        }
        return Character.isWhitespace(charSequence.charAt(0)) || Character.isWhitespace(charSequence.charAt(length));
    }
}
