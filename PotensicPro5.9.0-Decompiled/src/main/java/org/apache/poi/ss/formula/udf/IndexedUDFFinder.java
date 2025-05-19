package org.apache.poi.ss.formula.udf;

import java.util.HashMap;
import org.apache.poi.ss.formula.functions.FreeRefFunction;
import org.apache.poi.util.Internal;

@Internal
/* loaded from: classes5.dex */
public class IndexedUDFFinder extends AggregatingUDFFinder {
    private final HashMap<Integer, String> _funcMap;

    public IndexedUDFFinder(UDFFinder... uDFFinderArr) {
        super(uDFFinderArr);
        this._funcMap = new HashMap<>();
    }

    @Override // org.apache.poi.ss.formula.udf.AggregatingUDFFinder, org.apache.poi.ss.formula.udf.UDFFinder
    public FreeRefFunction findFunction(String str) {
        FreeRefFunction findFunction = super.findFunction(str);
        if (findFunction != null) {
            this._funcMap.put(Integer.valueOf(getFunctionIndex(str)), str);
        }
        return findFunction;
    }

    public String getFunctionName(int i) {
        return this._funcMap.get(Integer.valueOf(i));
    }

    public int getFunctionIndex(String str) {
        return str.hashCode();
    }
}
