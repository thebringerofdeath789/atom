package org.apache.poi.ss.formula.functions;

import java.util.Date;
import java.util.GregorianCalendar;
import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.usermodel.DateUtil;

/* loaded from: classes5.dex */
public class EOMonth implements FreeRefFunction {
    public static final FreeRefFunction instance = new EOMonth();

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] valueEvalArr, OperationEvaluationContext operationEvaluationContext) {
        if (valueEvalArr.length != 2) {
            return ErrorEval.VALUE_INVALID;
        }
        try {
            double singleOperandEvaluate = NumericFunction.singleOperandEvaluate(valueEvalArr[0], operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex());
            int singleOperandEvaluate2 = (int) NumericFunction.singleOperandEvaluate(valueEvalArr[1], operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex());
            if (singleOperandEvaluate >= 0.0d && singleOperandEvaluate < 1.0d) {
                singleOperandEvaluate = 1.0d;
            }
            Date javaDate = DateUtil.getJavaDate(singleOperandEvaluate, false);
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            gregorianCalendar.setTime(javaDate);
            gregorianCalendar.set(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5), 0, 0, 0);
            gregorianCalendar.set(14, 0);
            gregorianCalendar.add(2, singleOperandEvaluate2 + 1);
            gregorianCalendar.set(5, 1);
            gregorianCalendar.add(5, -1);
            return new NumberEval(DateUtil.getExcelDate(gregorianCalendar.getTime()));
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }
}
