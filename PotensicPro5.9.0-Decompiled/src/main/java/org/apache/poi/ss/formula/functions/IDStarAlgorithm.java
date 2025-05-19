package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.eval.ValueEval;

/* loaded from: classes5.dex */
public interface IDStarAlgorithm {
    ValueEval getResult();

    boolean processMatch(ValueEval valueEval);

    void reset();
}
