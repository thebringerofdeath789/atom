package org.apache.poi.ss.formula.functions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* loaded from: classes5.dex */
public class Imaginary extends Fixed1ArgFunction implements FreeRefFunction {
    public static final int GROUP1_REAL_SIGN = 1;
    public static final String GROUP1_REAL_SIGN_REGEX = "([+-]?)";
    public static final int GROUP2_IMAGINARY_INTEGER_OR_DOUBLE = 2;
    public static final String GROUP2_REAL_INTEGER_OR_DOUBLE_REGEX = "([0-9]+\\.[0-9]+|[0-9]*)";
    public static final int GROUP3_IMAGINARY_SIGN = 3;
    public static final String GROUP3_IMAGINARY_SIGN_REGEX = "([+-]?)";
    public static final int GROUP4_IMAGINARY_INTEGER_OR_DOUBLE = 4;
    public static final String GROUP4_IMAGINARY_INTEGER_OR_DOUBLE_REGEX = "([0-9]+\\.[0-9]+|[0-9]*)";
    public static final String GROUP5_IMAGINARY_GROUP_REGEX = "([ij]?)";
    public static final FreeRefFunction instance = new Imaginary();
    public static final Pattern COMPLEX_NUMBER_PATTERN = Pattern.compile("([+-]?)([0-9]+\\.[0-9]+|[0-9]*)([+-]?)([0-9]+\\.[0-9]+|[0-9]*)([ij]?)");

    @Override // org.apache.poi.ss.formula.functions.Function1Arg
    public ValueEval evaluate(int i, int i2, ValueEval valueEval) {
        try {
            Matcher matcher = COMPLEX_NUMBER_PATTERN.matcher(OperandResolver.coerceValueToString(OperandResolver.getSingleValue(valueEval, i, i2)));
            boolean z = true;
            if (matcher.matches()) {
                String group = matcher.group(5);
                if (!group.equals(Complex.DEFAULT_SUFFIX) && !group.equals(Complex.SUPPORTED_SUFFIX)) {
                    z = false;
                }
                if (group.length() == 0) {
                    return new StringEval(String.valueOf(0));
                }
                String str = "";
                if (z) {
                    String group2 = matcher.group(3);
                    if (group2.length() != 0 && !group2.equals("+")) {
                        str = group2;
                    }
                    String group3 = matcher.group(4);
                    if (group3.length() != 0) {
                        str = str + group3;
                    } else {
                        str = str + "1";
                    }
                }
                return new StringEval(str);
            }
            return ErrorEval.NUM_ERROR;
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] valueEvalArr, OperationEvaluationContext operationEvaluationContext) {
        if (valueEvalArr.length != 1) {
            return ErrorEval.VALUE_INVALID;
        }
        return evaluate(operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex(), valueEvalArr[0]);
    }
}
