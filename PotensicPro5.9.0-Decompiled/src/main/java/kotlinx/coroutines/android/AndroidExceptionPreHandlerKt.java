package kotlinx.coroutines.android;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidExceptionPreHandler.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0002"}, d2 = {"getter", "Ljava/lang/reflect/Method;", "kotlinx-coroutines-android"}, k = 2, mv = {1, 1, 13})
/* loaded from: classes4.dex */
public final class AndroidExceptionPreHandlerKt {
    private static final Method getter;

    static {
        Method method = null;
        try {
            boolean z = false;
            Method it = Thread.class.getDeclaredMethod("getUncaughtExceptionPreHandler", new Class[0]);
            Intrinsics.checkExpressionValueIsNotNull(it, "it");
            if (Modifier.isPublic(it.getModifiers())) {
                if (Modifier.isStatic(it.getModifiers())) {
                    z = true;
                }
            }
            if (z) {
                method = it;
            }
        } catch (Throwable unused) {
        }
        getter = method;
    }
}
