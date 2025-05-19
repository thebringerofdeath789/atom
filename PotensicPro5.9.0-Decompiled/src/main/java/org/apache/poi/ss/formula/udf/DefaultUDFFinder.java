package org.apache.poi.ss.formula.udf;

import java.util.HashMap;
import java.util.Map;
import org.apache.poi.ss.formula.functions.FreeRefFunction;

/* loaded from: classes5.dex */
public final class DefaultUDFFinder implements UDFFinder {
    private final Map<String, FreeRefFunction> _functionsByName;

    public DefaultUDFFinder(String[] strArr, FreeRefFunction[] freeRefFunctionArr) {
        int length = strArr.length;
        if (freeRefFunctionArr.length != length) {
            throw new IllegalArgumentException("Mismatch in number of function names and implementations");
        }
        HashMap hashMap = new HashMap((length * 3) / 2);
        for (int i = 0; i < freeRefFunctionArr.length; i++) {
            hashMap.put(strArr[i].toUpperCase(), freeRefFunctionArr[i]);
        }
        this._functionsByName = hashMap;
    }

    @Override // org.apache.poi.ss.formula.udf.UDFFinder
    public FreeRefFunction findFunction(String str) {
        return this._functionsByName.get(str.toUpperCase());
    }
}
