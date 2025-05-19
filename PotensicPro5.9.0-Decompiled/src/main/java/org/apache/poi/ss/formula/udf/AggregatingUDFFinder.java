package org.apache.poi.ss.formula.udf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import org.apache.poi.ss.formula.functions.FreeRefFunction;

/* loaded from: classes5.dex */
public class AggregatingUDFFinder implements UDFFinder {
    private final Collection<UDFFinder> _usedToolPacks;

    public AggregatingUDFFinder(UDFFinder... uDFFinderArr) {
        ArrayList arrayList = new ArrayList(uDFFinderArr.length);
        this._usedToolPacks = arrayList;
        arrayList.addAll(Arrays.asList(uDFFinderArr));
    }

    @Override // org.apache.poi.ss.formula.udf.UDFFinder
    public FreeRefFunction findFunction(String str) {
        Iterator<UDFFinder> it = this._usedToolPacks.iterator();
        while (it.hasNext()) {
            FreeRefFunction findFunction = it.next().findFunction(str);
            if (findFunction != null) {
                return findFunction;
            }
        }
        return null;
    }

    public void add(UDFFinder uDFFinder) {
        this._usedToolPacks.add(uDFFinder);
    }
}
