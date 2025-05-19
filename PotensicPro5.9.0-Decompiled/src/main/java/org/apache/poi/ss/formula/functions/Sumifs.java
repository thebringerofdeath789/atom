package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.AreaEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.RefEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.formula.functions.CountUtils;

/* loaded from: classes5.dex */
public final class Sumifs implements FreeRefFunction {
    public static final FreeRefFunction instance = new Sumifs();

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] valueEvalArr, OperationEvaluationContext operationEvaluationContext) {
        if (valueEvalArr.length < 3 || valueEvalArr.length % 2 == 0) {
            return ErrorEval.VALUE_INVALID;
        }
        int i = 0;
        try {
            AreaEval convertRangeArg = convertRangeArg(valueEvalArr[0]);
            int i2 = 1;
            int length = (valueEvalArr.length - 1) / 2;
            AreaEval[] areaEvalArr = new AreaEval[length];
            CountUtils.I_MatchPredicate[] i_MatchPredicateArr = new CountUtils.I_MatchPredicate[length];
            while (i2 < valueEvalArr.length) {
                areaEvalArr[i] = convertRangeArg(valueEvalArr[i2]);
                i_MatchPredicateArr[i] = Countif.createCriteriaPredicate(valueEvalArr[i2 + 1], operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex());
                i2 += 2;
                i++;
            }
            validateCriteriaRanges(areaEvalArr, convertRangeArg);
            return new NumberEval(sumMatchingCells(areaEvalArr, i_MatchPredicateArr, convertRangeArg));
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    private void validateCriteriaRanges(AreaEval[] areaEvalArr, AreaEval areaEval) throws EvaluationException {
        for (AreaEval areaEval2 : areaEvalArr) {
            if (areaEval2.getHeight() != areaEval.getHeight() || areaEval2.getWidth() != areaEval.getWidth()) {
                throw EvaluationException.invalidValue();
            }
        }
    }

    private static double sumMatchingCells(AreaEval[] areaEvalArr, CountUtils.I_MatchPredicate[] i_MatchPredicateArr, AreaEval areaEval) {
        boolean z;
        int height = areaEval.getHeight();
        int width = areaEval.getWidth();
        double d = 0.0d;
        for (int i = 0; i < height; i++) {
            for (int i2 = 0; i2 < width; i2++) {
                int i3 = 0;
                while (true) {
                    if (i3 >= areaEvalArr.length) {
                        z = true;
                        break;
                    }
                    if (!i_MatchPredicateArr[i3].matches(areaEvalArr[i3].getRelativeValue(i, i2))) {
                        z = false;
                        break;
                    }
                    i3++;
                }
                if (z) {
                    d += accumulate(areaEval, i, i2);
                }
            }
        }
        return d;
    }

    private static double accumulate(AreaEval areaEval, int i, int i2) {
        ValueEval relativeValue = areaEval.getRelativeValue(i, i2);
        if (relativeValue instanceof NumberEval) {
            return ((NumberEval) relativeValue).getNumberValue();
        }
        return 0.0d;
    }

    private static AreaEval convertRangeArg(ValueEval valueEval) throws EvaluationException {
        if (valueEval instanceof AreaEval) {
            return (AreaEval) valueEval;
        }
        if (valueEval instanceof RefEval) {
            return ((RefEval) valueEval).offset(0, 0, 0, 0);
        }
        throw new EvaluationException(ErrorEval.VALUE_INVALID);
    }
}
