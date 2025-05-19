package org.apache.poi.ss.formula;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes5.dex */
final class FormulaCellCache {
    private final Map<Object, FormulaCellCacheEntry> _formulaEntriesByCell = new HashMap();

    interface IEntryOperation {
        void processEntry(FormulaCellCacheEntry formulaCellCacheEntry);
    }

    public CellCacheEntry[] getCacheEntries() {
        FormulaCellCacheEntry[] formulaCellCacheEntryArr = new FormulaCellCacheEntry[this._formulaEntriesByCell.size()];
        this._formulaEntriesByCell.values().toArray(formulaCellCacheEntryArr);
        return formulaCellCacheEntryArr;
    }

    public void clear() {
        this._formulaEntriesByCell.clear();
    }

    public FormulaCellCacheEntry get(EvaluationCell evaluationCell) {
        return this._formulaEntriesByCell.get(evaluationCell.getIdentityKey());
    }

    public void put(EvaluationCell evaluationCell, FormulaCellCacheEntry formulaCellCacheEntry) {
        this._formulaEntriesByCell.put(evaluationCell.getIdentityKey(), formulaCellCacheEntry);
    }

    public FormulaCellCacheEntry remove(EvaluationCell evaluationCell) {
        return this._formulaEntriesByCell.remove(evaluationCell.getIdentityKey());
    }

    public void applyOperation(IEntryOperation iEntryOperation) {
        Iterator<FormulaCellCacheEntry> it = this._formulaEntriesByCell.values().iterator();
        while (it.hasNext()) {
            iEntryOperation.processEntry(it.next());
        }
    }
}
