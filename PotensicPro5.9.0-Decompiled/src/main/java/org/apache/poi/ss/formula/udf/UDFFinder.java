package org.apache.poi.ss.formula.udf;

import org.apache.poi.ss.formula.atp.AnalysisToolPak;
import org.apache.poi.ss.formula.functions.FreeRefFunction;

/* loaded from: classes5.dex */
public interface UDFFinder {
    public static final UDFFinder DEFAULT = new AggregatingUDFFinder(AnalysisToolPak.instance);

    FreeRefFunction findFunction(String str);
}
