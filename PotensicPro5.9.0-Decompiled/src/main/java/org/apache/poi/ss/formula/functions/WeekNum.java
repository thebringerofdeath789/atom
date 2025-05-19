package org.apache.poi.ss.formula.functions;

import java.util.Calendar;
import java.util.GregorianCalendar;
import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.usermodel.DateUtil;

/* loaded from: classes5.dex */
public class WeekNum extends Fixed2ArgFunction implements FreeRefFunction {
    public static final FreeRefFunction instance = new WeekNum();

    @Override // org.apache.poi.ss.formula.functions.Function2Arg
    public ValueEval evaluate(int i, int i2, ValueEval valueEval, ValueEval valueEval2) {
        try {
            double singleOperandEvaluate = NumericFunction.singleOperandEvaluate(valueEval, i, i2);
            new GregorianCalendar().setTime(DateUtil.getJavaDate(singleOperandEvaluate, false));
            try {
                int coerceValueToInt = OperandResolver.coerceValueToInt(OperandResolver.getSingleValue(valueEval2, i, i2));
                if (coerceValueToInt != 1 && coerceValueToInt != 2) {
                    return ErrorEval.NUM_ERROR;
                }
                return new NumberEval(getWeekNo(r6, coerceValueToInt));
            } catch (EvaluationException unused) {
                return ErrorEval.NUM_ERROR;
            }
        } catch (EvaluationException unused2) {
            return ErrorEval.VALUE_INVALID;
        }
    }

    public int getWeekNo(Calendar calendar, int i) {
        if (i == 1) {
            calendar.setFirstDayOfWeek(1);
        } else {
            calendar.setFirstDayOfWeek(2);
        }
        return calendar.get(3);
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] valueEvalArr, OperationEvaluationContext operationEvaluationContext) {
        if (valueEvalArr.length == 2) {
            return evaluate(operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex(), valueEvalArr[0], valueEvalArr[1]);
        }
        return ErrorEval.VALUE_INVALID;
    }
}
