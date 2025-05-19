package org.apache.commons.lang3.reflect;

import java.lang.reflect.Method;
import java.util.function.Function;

/* compiled from: lambda */
/* renamed from: org.apache.commons.lang3.reflect.-$$Lambda$MethodUtils$f4V08ybZbKWgnlJBV31Le5OJCvE, reason: invalid class name */
/* loaded from: classes4.dex */
public final /* synthetic */ class $$Lambda$MethodUtils$f4V08ybZbKWgnlJBV31Le5OJCvE implements Function {
    public static final /* synthetic */ $$Lambda$MethodUtils$f4V08ybZbKWgnlJBV31Le5OJCvE INSTANCE = new $$Lambda$MethodUtils$f4V08ybZbKWgnlJBV31Le5OJCvE();

    private /* synthetic */ $$Lambda$MethodUtils$f4V08ybZbKWgnlJBV31Le5OJCvE() {
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        String method;
        method = ((Method) obj).toString();
        return method;
    }
}
