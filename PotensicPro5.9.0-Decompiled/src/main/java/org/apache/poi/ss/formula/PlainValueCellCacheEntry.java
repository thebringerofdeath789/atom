package org.apache.poi.ss.formula;

import org.apache.poi.ss.formula.eval.ValueEval;

/* loaded from: classes5.dex */
final class PlainValueCellCacheEntry extends CellCacheEntry {
    public PlainValueCellCacheEntry(ValueEval valueEval) {
        updateValue(valueEval);
    }
}
