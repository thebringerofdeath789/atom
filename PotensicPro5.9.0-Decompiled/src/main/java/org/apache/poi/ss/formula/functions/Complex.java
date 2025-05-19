package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* loaded from: classes5.dex */
public class Complex extends Var2or3ArgFunction implements FreeRefFunction {
    public static final String DEFAULT_SUFFIX = "i";
    public static final String SUPPORTED_SUFFIX = "j";
    public static final FreeRefFunction instance = new Complex();

    @Override // org.apache.poi.ss.formula.functions.Function2Arg
    public ValueEval evaluate(int i, int i2, ValueEval valueEval, ValueEval valueEval2) {
        return evaluate(i, i2, valueEval, valueEval2, new StringEval(DEFAULT_SUFFIX));
    }

    @Override // org.apache.poi.ss.formula.functions.Function3Arg
    public ValueEval evaluate(int i, int i2, ValueEval valueEval, ValueEval valueEval2, ValueEval valueEval3) {
        try {
            try {
                double coerceValueToDouble = OperandResolver.coerceValueToDouble(OperandResolver.getSingleValue(valueEval, i, i2));
                try {
                    try {
                        double coerceValueToDouble2 = OperandResolver.coerceValueToDouble(OperandResolver.getSingleValue(valueEval2, i, i2));
                        String coerceValueToString = OperandResolver.coerceValueToString(valueEval3);
                        if (coerceValueToString.length() == 0) {
                            coerceValueToString = DEFAULT_SUFFIX;
                        }
                        if (coerceValueToString.equals(DEFAULT_SUFFIX.toUpperCase()) || coerceValueToString.equals(SUPPORTED_SUFFIX.toUpperCase())) {
                            return ErrorEval.VALUE_INVALID;
                        }
                        if (!coerceValueToString.equals(DEFAULT_SUFFIX) && !coerceValueToString.equals(SUPPORTED_SUFFIX)) {
                            return ErrorEval.VALUE_INVALID;
                        }
                        StringBuffer stringBuffer = new StringBuffer("");
                        if (coerceValueToDouble != 0.0d) {
                            if (isDoubleAnInt(coerceValueToDouble)) {
                                stringBuffer.append(new Double(coerceValueToDouble).intValue());
                            } else {
                                stringBuffer.append(coerceValueToDouble);
                            }
                        }
                        if (coerceValueToDouble2 != 0.0d) {
                            if (stringBuffer.length() != 0 && coerceValueToDouble2 > 0.0d) {
                                stringBuffer.append("+");
                            }
                            if (coerceValueToDouble2 != 1.0d && coerceValueToDouble2 != -1.0d) {
                                if (isDoubleAnInt(coerceValueToDouble2)) {
                                    stringBuffer.append(new Double(coerceValueToDouble2).intValue());
                                } else {
                                    stringBuffer.append(coerceValueToDouble2);
                                }
                            }
                            stringBuffer.append(coerceValueToString);
                        }
                        return new StringEval(stringBuffer.toString());
                    } catch (EvaluationException unused) {
                        return ErrorEval.VALUE_INVALID;
                    }
                } catch (EvaluationException e) {
                    return e.getErrorEval();
                }
            } catch (EvaluationException unused2) {
                return ErrorEval.VALUE_INVALID;
            }
        } catch (EvaluationException e2) {
            return e2.getErrorEval();
        }
    }

    private boolean isDoubleAnInt(double d) {
        return d == Math.floor(d) && !Double.isInfinite(d);
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] valueEvalArr, OperationEvaluationContext operationEvaluationContext) {
        if (valueEvalArr.length == 2) {
            return evaluate(operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex(), valueEvalArr[0], valueEvalArr[1]);
        }
        if (valueEvalArr.length == 3) {
            return evaluate(operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex(), valueEvalArr[0], valueEvalArr[1], valueEvalArr[2]);
        }
        return ErrorEval.VALUE_INVALID;
    }
}
