package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;

/* loaded from: classes5.dex */
public class Mirr extends MultiOperandNumericFunction {
    @Override // org.apache.poi.ss.formula.functions.MultiOperandNumericFunction
    protected int getMaxNumOperands() {
        return 3;
    }

    public Mirr() {
        super(false, false);
    }

    @Override // org.apache.poi.ss.formula.functions.MultiOperandNumericFunction
    protected double evaluate(double[] dArr) throws EvaluationException {
        double d = dArr[dArr.length - 1];
        double d2 = dArr[dArr.length - 2];
        int length = dArr.length - 2;
        double[] dArr2 = new double[length];
        System.arraycopy(dArr, 0, dArr2, 0, length);
        boolean z = true;
        for (int i = 0; i < length; i++) {
            z &= dArr2[i] < 0.0d;
        }
        if (z) {
            return -1.0d;
        }
        boolean z2 = true;
        for (int i2 = 0; i2 < length; i2++) {
            z2 &= dArr2[i2] > 0.0d;
        }
        if (z2) {
            throw new EvaluationException(ErrorEval.DIV_ZERO);
        }
        return mirr(dArr2, d, d2);
    }

    private static double mirr(double[] dArr, double d, double d2) {
        double d3;
        int length = dArr.length - 1;
        int length2 = dArr.length;
        double d4 = 0.0d;
        double d5 = 0.0d;
        int i = 0;
        int i2 = 0;
        while (true) {
            d3 = 1.0d;
            if (i >= length2) {
                break;
            }
            double d6 = dArr[i];
            if (d6 < d4) {
                d5 += d6 / Math.pow((d + 1.0d) + d2, i2);
                i2++;
            }
            i++;
            d4 = 0.0d;
        }
        int length3 = dArr.length;
        int i3 = 0;
        double d7 = 0.0d;
        while (i3 < length3) {
            double d8 = dArr[i3];
            if (d8 > 0.0d) {
                d7 += d8 * Math.pow(d + d3, length - i2);
                i2++;
            }
            i3++;
            d3 = 1.0d;
        }
        if (d7 == 0.0d || d5 == 0.0d) {
            return 0.0d;
        }
        return Math.pow((-d7) / d5, 1.0d / length) - 1.0d;
    }
}
