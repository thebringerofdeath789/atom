package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.formula.functions.AggregateFunction;

/* loaded from: classes5.dex */
public final class Irr implements Function {
    @Override // org.apache.poi.ss.formula.functions.Function
    public ValueEval evaluate(ValueEval[] valueEvalArr, int i, int i2) {
        if (valueEvalArr.length == 0 || valueEvalArr.length > 2) {
            return ErrorEval.VALUE_INVALID;
        }
        try {
            double irr = irr(AggregateFunction.ValueCollector.collectValues(valueEvalArr[0]), valueEvalArr.length == 2 ? NumericFunction.singleOperandEvaluate(valueEvalArr[1], i, i2) : 0.1d);
            NumericFunction.checkValue(irr);
            return new NumberEval(irr);
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    public static double irr(double[] dArr) {
        return irr(dArr, 0.1d);
    }

    public static double irr(double[] dArr, double d) {
        int i = 0;
        while (i < 20) {
            double d2 = 0.0d;
            int i2 = 0;
            double d3 = 0.0d;
            while (i2 < dArr.length) {
                double d4 = 1.0d + d;
                d2 += dArr[i2] / Math.pow(d4, i2);
                double d5 = (-i2) * dArr[i2];
                i2++;
                d3 += d5 / Math.pow(d4, i2);
            }
            double d6 = d - (d2 / d3);
            if (Math.abs(d6 - d) <= 1.0E-7d) {
                return d6;
            }
            i++;
            d = d6;
        }
        return Double.NaN;
    }
}
