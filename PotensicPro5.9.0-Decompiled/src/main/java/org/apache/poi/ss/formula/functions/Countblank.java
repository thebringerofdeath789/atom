package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.ThreeDEval;
import org.apache.poi.ss.formula.eval.BlankEval;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.RefEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.formula.functions.CountUtils;

/* loaded from: classes5.dex */
public final class Countblank extends Fixed1ArgFunction {
    private static final CountUtils.I_MatchPredicate predicate = new CountUtils.I_MatchPredicate() { // from class: org.apache.poi.ss.formula.functions.Countblank.1
        @Override // org.apache.poi.ss.formula.functions.CountUtils.I_MatchPredicate
        public boolean matches(ValueEval valueEval) {
            return valueEval == BlankEval.instance;
        }
    };

    @Override // org.apache.poi.ss.formula.functions.Function1Arg
    public ValueEval evaluate(int i, int i2, ValueEval valueEval) {
        int countMatchingCellsInArea;
        if (valueEval instanceof RefEval) {
            countMatchingCellsInArea = CountUtils.countMatchingCellsInRef((RefEval) valueEval, predicate);
        } else if (valueEval instanceof ThreeDEval) {
            countMatchingCellsInArea = CountUtils.countMatchingCellsInArea((ThreeDEval) valueEval, predicate);
        } else {
            throw new IllegalArgumentException("Bad range arg type (" + valueEval.getClass().getName() + ")");
        }
        return new NumberEval(countMatchingCellsInArea);
    }
}
