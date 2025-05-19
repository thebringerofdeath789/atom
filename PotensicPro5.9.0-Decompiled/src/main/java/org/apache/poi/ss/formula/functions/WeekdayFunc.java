package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.eval.BlankEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.MissingArgEval;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.usermodel.DateUtil;

/* loaded from: classes5.dex */
public final class WeekdayFunc implements Function {
    public static final Function instance = new WeekdayFunc();

    private WeekdayFunc() {
    }

    @Override // org.apache.poi.ss.formula.functions.Function
    public ValueEval evaluate(ValueEval[] valueEvalArr, int i, int i2) {
        int i3;
        try {
            if (valueEvalArr.length >= 1 && valueEvalArr.length <= 2) {
                double coerceValueToDouble = OperandResolver.coerceValueToDouble(OperandResolver.getSingleValue(valueEvalArr[0], i, i2));
                if (!DateUtil.isValidExcelDate(coerceValueToDouble)) {
                    return ErrorEval.NUM_ERROR;
                }
                int i4 = DateUtil.getJavaCalendar(coerceValueToDouble, false).get(7);
                if (valueEvalArr.length == 2) {
                    ValueEval singleValue = OperandResolver.getSingleValue(valueEvalArr[1], i, i2);
                    if (singleValue != MissingArgEval.instance && singleValue != BlankEval.instance) {
                        i3 = OperandResolver.coerceValueToInt(singleValue);
                        if (i3 == 2) {
                            i3 = 11;
                        }
                    }
                    return ErrorEval.NUM_ERROR;
                }
                i3 = 1;
                if (i3 != 1) {
                    if (i3 == 3) {
                        i4 = ((i4 + 6) - 1) % 7;
                    } else if (i3 >= 11 && i3 <= 17) {
                        i4 = (((i4 + 6) - (i3 - 10)) % 7) + 1;
                    } else {
                        return ErrorEval.NUM_ERROR;
                    }
                }
                return new NumberEval(i4);
            }
            return ErrorEval.VALUE_INVALID;
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }
}
