package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.ThreeDEval;
import org.apache.poi.ss.formula.TwoDEval;
import org.apache.poi.ss.formula.eval.RefEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* loaded from: classes5.dex */
final class CountUtils {

    public interface I_MatchAreaPredicate extends I_MatchPredicate {
        boolean matches(TwoDEval twoDEval, int i, int i2);
    }

    public interface I_MatchPredicate {
        boolean matches(ValueEval valueEval);
    }

    private CountUtils() {
    }

    public static int countMatchingCellsInArea(ThreeDEval threeDEval, I_MatchPredicate i_MatchPredicate) {
        int i = 0;
        for (int firstSheetIndex = threeDEval.getFirstSheetIndex(); firstSheetIndex <= threeDEval.getLastSheetIndex(); firstSheetIndex++) {
            int height = threeDEval.getHeight();
            int width = threeDEval.getWidth();
            for (int i2 = 0; i2 < height; i2++) {
                for (int i3 = 0; i3 < width; i3++) {
                    ValueEval value = threeDEval.getValue(firstSheetIndex, i2, i3);
                    if ((!(i_MatchPredicate instanceof I_MatchAreaPredicate) || ((I_MatchAreaPredicate) i_MatchPredicate).matches(threeDEval, i2, i3)) && i_MatchPredicate.matches(value)) {
                        i++;
                    }
                }
            }
        }
        return i;
    }

    public static int countMatchingCellsInRef(RefEval refEval, I_MatchPredicate i_MatchPredicate) {
        int i = 0;
        for (int firstSheetIndex = refEval.getFirstSheetIndex(); firstSheetIndex <= refEval.getLastSheetIndex(); firstSheetIndex++) {
            if (i_MatchPredicate.matches(refEval.getInnerValueEval(firstSheetIndex))) {
                i++;
            }
        }
        return i;
    }

    public static int countArg(ValueEval valueEval, I_MatchPredicate i_MatchPredicate) {
        if (valueEval == null) {
            throw new IllegalArgumentException("eval must not be null");
        }
        if (valueEval instanceof ThreeDEval) {
            return countMatchingCellsInArea((ThreeDEval) valueEval, i_MatchPredicate);
        }
        if (valueEval instanceof TwoDEval) {
            throw new IllegalArgumentException("Count requires 3D Evals, 2D ones aren't supported");
        }
        if (valueEval instanceof RefEval) {
            return countMatchingCellsInRef((RefEval) valueEval, i_MatchPredicate);
        }
        return i_MatchPredicate.matches(valueEval) ? 1 : 0;
    }
}
