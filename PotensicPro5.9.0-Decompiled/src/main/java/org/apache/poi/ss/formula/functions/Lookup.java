package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.TwoDEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.formula.functions.LookupUtils;

/* loaded from: classes5.dex */
public final class Lookup extends Var2or3ArgFunction {
    @Override // org.apache.poi.ss.formula.functions.Function2Arg
    public ValueEval evaluate(int i, int i2, ValueEval valueEval, ValueEval valueEval2) {
        throw new RuntimeException("Two arg version of LOOKUP not supported yet");
    }

    @Override // org.apache.poi.ss.formula.functions.Function3Arg
    public ValueEval evaluate(int i, int i2, ValueEval valueEval, ValueEval valueEval2, ValueEval valueEval3) {
        try {
            ValueEval singleValue = OperandResolver.getSingleValue(valueEval, i, i2);
            TwoDEval resolveTableArrayArg = LookupUtils.resolveTableArrayArg(valueEval2);
            TwoDEval resolveTableArrayArg2 = LookupUtils.resolveTableArrayArg(valueEval3);
            LookupUtils.ValueVector createVector = createVector(resolveTableArrayArg);
            LookupUtils.ValueVector createVector2 = createVector(resolveTableArrayArg2);
            if (createVector.getSize() > createVector2.getSize()) {
                throw new RuntimeException("Lookup vector and result vector of differing sizes not supported yet");
            }
            return createVector2.getItem(LookupUtils.lookupIndexOfValue(singleValue, createVector, true));
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    private static LookupUtils.ValueVector createVector(TwoDEval twoDEval) {
        LookupUtils.ValueVector createVector = LookupUtils.createVector(twoDEval);
        if (createVector != null) {
            return createVector;
        }
        throw new RuntimeException("non-vector lookup or result areas not supported yet");
    }
}
