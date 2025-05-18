package com.opencsv.bean;

import java.util.Map;
import java.util.function.Function;

/* compiled from: lambda */
/* renamed from: com.opencsv.bean.-$$Lambda$kD2gyJeP3PcrLMDu6_8bXivD2ts, reason: invalid class name */
/* loaded from: classes3.dex */
public final /* synthetic */ class $$Lambda$kD2gyJeP3PcrLMDu6_8bXivD2ts implements Function {
    public static final /* synthetic */ $$Lambda$kD2gyJeP3PcrLMDu6_8bXivD2ts INSTANCE = new $$Lambda$kD2gyJeP3PcrLMDu6_8bXivD2ts();

    private /* synthetic */ $$Lambda$kD2gyJeP3PcrLMDu6_8bXivD2ts() {
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return (String) ((Map.Entry) obj).getKey();
    }
}