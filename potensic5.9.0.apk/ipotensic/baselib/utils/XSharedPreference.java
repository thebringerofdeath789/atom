package com.ipotensic.baselib.utils;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KProperty;

/* compiled from: XSharedPreference.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0001J\u001a\u0010\u0010\u001a\u00020\u0011*\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\bX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/ipotensic/baselib/utils/XSharedPreference;", "", "()V", "SP_NAME", "", "sharedPreferences", "Landroid/content/SharedPreferences;", "tempKV", "", "init", "", "context", "Landroid/content/Context;", "save", "key", "value", "saveValue", "", "Landroid/content/SharedPreferences$Editor;", "Companion", "BaseLib_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class XSharedPreference {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy instance$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<XSharedPreference>() { // from class: com.ipotensic.baselib.utils.XSharedPreference$Companion$instance$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final XSharedPreference invoke() {
            return new XSharedPreference();
        }
    });
    private final String SP_NAME = "MY_SP";
    private SharedPreferences sharedPreferences;
    private Map<String, Object> tempKV;

    public static final XSharedPreference getInstance() {
        return INSTANCE.getInstance();
    }

    /* compiled from: XSharedPreference.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R!\u0010\u0003\u001a\u00020\u00048FX\u0087\u0084\u0002\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/ipotensic/baselib/utils/XSharedPreference$Companion;", "", "()V", "instance", "Lcom/ipotensic/baselib/utils/XSharedPreference;", "instance$annotations", "getInstance", "()Lcom/ipotensic/baselib/utils/XSharedPreference;", "instance$delegate", "Lkotlin/Lazy;", "BaseLib_release"}, k = 1, mv = {1, 1, 15})
    public static final class Companion {
        static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Companion.class), "instance", "getInstance()Lcom/ipotensic/baselib/utils/XSharedPreference;"))};

        @JvmStatic
        public static /* synthetic */ void instance$annotations() {
        }

        public final XSharedPreference getInstance() {
            Lazy lazy = XSharedPreference.instance$delegate;
            Companion companion = XSharedPreference.INSTANCE;
            KProperty kProperty = $$delegatedProperties[0];
            return (XSharedPreference) lazy.getValue();
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final void init(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        SharedPreferences sharedPreferences = context.getSharedPreferences(this.SP_NAME, 0);
        Intrinsics.checkExpressionValueIsNotNull(sharedPreferences, "context.getSharedPrefere\u2026AME,Context.MODE_PRIVATE)");
        this.sharedPreferences = sharedPreferences;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
        }
        Map<String, ?> all = sharedPreferences.getAll();
        if (all == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.Any>");
        }
        this.tempKV = TypeIntrinsics.asMutableMap(all);
    }

    public final boolean saveValue(SharedPreferences.Editor saveValue, String key, Object value) {
        Intrinsics.checkParameterIsNotNull(saveValue, "$this$saveValue");
        Intrinsics.checkParameterIsNotNull(key, "key");
        Intrinsics.checkParameterIsNotNull(value, "value");
        Map<String, Object> map = this.tempKV;
        if (map == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tempKV");
        }
        if (map.containsKey(key)) {
            Map<String, Object> map2 = this.tempKV;
            if (map2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tempKV");
            }
            Object obj = map2.get(key);
            if (((obj instanceof String) && obj.equals(value)) || Intrinsics.areEqual(obj, value)) {
                return true;
            }
        }
        if (value instanceof String) {
            saveValue.putString(key, (String) value);
        } else if (value instanceof Integer) {
            saveValue.putInt(key, ((Number) value).intValue());
        } else if (value instanceof Boolean) {
            saveValue.putBoolean(key, ((Boolean) value).booleanValue());
        } else if (value instanceof Float) {
            saveValue.putFloat(key, ((Number) value).floatValue());
        } else if (value instanceof Long) {
            saveValue.putLong(key, ((Number) value).longValue());
        } else if (value instanceof Double) {
            saveValue.putFloat(key, (float) ((Number) value).doubleValue());
        } else if (value instanceof Short) {
            saveValue.putInt(key, ((Number) value).shortValue());
        }
        boolean commit = saveValue.commit();
        if (commit) {
            Map<String, Object> map3 = this.tempKV;
            if (map3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tempKV");
            }
            map3.put(key, value);
        }
        return commit;
    }

    public final void save(String key, Object value) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        Intrinsics.checkParameterIsNotNull(value, "value");
        SharedPreferences sharedPreferences = this.sharedPreferences;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
        }
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Intrinsics.checkExpressionValueIsNotNull(editor, "editor");
        saveValue(editor, key, value);
    }
}