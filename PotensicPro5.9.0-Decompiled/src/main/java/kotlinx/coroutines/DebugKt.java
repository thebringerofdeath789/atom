package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Debug.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u000f\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030\u0010H\u0000\"\u0010\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0007\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u0018\u0010\t\u001a\u00020\u0003*\u00020\n8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\"\u0018\u0010\r\u001a\u00020\u0003*\u00020\n8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\f¨\u0006\u0011"}, d2 = {"DEBUG", "", "DEBUG_PROPERTY_NAME", "", "DEBUG_PROPERTY_VALUE_AUTO", "DEBUG_PROPERTY_VALUE_OFF", "DEBUG_PROPERTY_VALUE_ON", "RECOVER_STACKTRACES", "STACKTRACE_RECOVERY_PROPERTY_NAME", "classSimpleName", "", "getClassSimpleName", "(Ljava/lang/Object;)Ljava/lang/String;", "hexAddress", "getHexAddress", "toDebugString", "Lkotlin/coroutines/Continuation;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 13})
/* loaded from: classes4.dex */
public final class DebugKt {
    public static final boolean DEBUG;
    public static final String DEBUG_PROPERTY_NAME = "kotlinx.coroutines.debug";
    public static final String DEBUG_PROPERTY_VALUE_AUTO = "auto";
    public static final String DEBUG_PROPERTY_VALUE_OFF = "off";
    public static final String DEBUG_PROPERTY_VALUE_ON = "on";
    public static final boolean RECOVER_STACKTRACES;
    public static final String STACKTRACE_RECOVERY_PROPERTY_NAME = "kotlinx.coroutines.stacktrace.recovery";

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0025, code lost:
    
        if (r0.equals("auto") != false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0030, code lost:
    
        if (r0.equals("off") != false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0039, code lost:
    
        if (r0.equals("on") != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0044, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0042, code lost:
    
        if (r0.equals("") != false) goto L24;
     */
    static {
        /*
            java.lang.String r0 = "kotlinx.coroutines.debug"
            java.lang.String r0 = kotlinx.coroutines.internal.SystemPropsKt.systemProp(r0)
            r1 = 1
            r2 = 0
            if (r0 != 0) goto Lb
            goto L27
        Lb:
            int r3 = r0.hashCode()
            if (r3 == 0) goto L3c
            r4 = 3551(0xddf, float:4.976E-42)
            if (r3 == r4) goto L33
            r4 = 109935(0x1ad6f, float:1.54052E-40)
            if (r3 == r4) goto L2a
            r4 = 3005871(0x2dddaf, float:4.212122E-39)
            if (r3 != r4) goto L50
            java.lang.String r3 = "auto"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L50
        L27:
            java.lang.Class<kotlinx.coroutines.CoroutineId> r0 = kotlinx.coroutines.CoroutineId.class
            goto L45
        L2a:
            java.lang.String r3 = "off"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L50
            goto L45
        L33:
            java.lang.String r2 = "on"
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L50
            goto L44
        L3c:
            java.lang.String r2 = ""
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L50
        L44:
            r2 = r1
        L45:
            kotlinx.coroutines.DebugKt.DEBUG = r2
            java.lang.String r0 = "kotlinx.coroutines.stacktrace.recovery"
            boolean r0 = kotlinx.coroutines.internal.SystemPropsKt.systemProp(r0, r1)
            kotlinx.coroutines.DebugKt.RECOVER_STACKTRACES = r0
            return
        L50:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "System property 'kotlinx.coroutines.debug' has unrecognized value '"
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r0 = r1.append(r0)
            r1 = 39
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.DebugKt.<clinit>():void");
    }

    public static final String getHexAddress(Object receiver$0) {
        Intrinsics.checkParameterIsNotNull(receiver$0, "receiver$0");
        String hexString = Integer.toHexString(System.identityHashCode(receiver$0));
        Intrinsics.checkExpressionValueIsNotNull(hexString, "Integer.toHexString(System.identityHashCode(this))");
        return hexString;
    }

    public static final String toDebugString(Continuation<?> receiver$0) {
        Object m51constructorimpl;
        Intrinsics.checkParameterIsNotNull(receiver$0, "receiver$0");
        if (receiver$0 instanceof DispatchedContinuation) {
            return receiver$0.toString();
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            m51constructorimpl = Result.m51constructorimpl(receiver$0 + '@' + getHexAddress(receiver$0));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m51constructorimpl = Result.m51constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m54exceptionOrNullimpl(m51constructorimpl) != null) {
            m51constructorimpl = receiver$0.getClass().getName() + '@' + getHexAddress(receiver$0);
        }
        return (String) m51constructorimpl;
    }

    public static final String getClassSimpleName(Object receiver$0) {
        Intrinsics.checkParameterIsNotNull(receiver$0, "receiver$0");
        String simpleName = receiver$0.getClass().getSimpleName();
        Intrinsics.checkExpressionValueIsNotNull(simpleName, "this::class.java.simpleName");
        return simpleName;
    }
}
