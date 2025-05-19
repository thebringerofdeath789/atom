package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.eval.BlankEval;
import org.apache.poi.ss.formula.eval.BoolEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.MissingArgEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;

/* loaded from: classes5.dex */
public final class IfFunc extends Var2or3ArgFunction {
    @Override // org.apache.poi.ss.formula.functions.Function2Arg
    public ValueEval evaluate(int i, int i2, ValueEval valueEval, ValueEval valueEval2) {
        try {
            if (evaluateFirstArg(valueEval, i, i2)) {
                return valueEval2 == MissingArgEval.instance ? BlankEval.instance : valueEval2;
            }
            return BoolEval.FALSE;
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    @Override // org.apache.poi.ss.formula.functions.Function3Arg
    public ValueEval evaluate(int i, int i2, ValueEval valueEval, ValueEval valueEval2, ValueEval valueEval3) {
        try {
            return evaluateFirstArg(valueEval, i, i2) ? valueEval2 == MissingArgEval.instance ? BlankEval.instance : valueEval2 : valueEval3 == MissingArgEval.instance ? BlankEval.instance : valueEval3;
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    public static boolean evaluateFirstArg(ValueEval valueEval, int i, int i2) throws EvaluationException {
        Boolean coerceValueToBoolean = OperandResolver.coerceValueToBoolean(OperandResolver.getSingleValue(valueEval, i, i2), false);
        if (coerceValueToBoolean == null) {
            return false;
        }
        return coerceValueToBoolean.booleanValue();
    }
}
