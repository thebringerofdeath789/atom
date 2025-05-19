package com.ipotensic.baselib.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Parcelable;
import com.tencent.mmkv.MMKV;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.apache.commons.beanutils.FluentPropertyBeanIntrospector;

/* compiled from: MMKVUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 (2\u00020\u0001:\u0001(B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u0018\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\bJ\u0018\u0010\f\u001a\u00020\r2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\rJ\u001f\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u0018\u0010\u0011\u001a\u00020\u00122\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u0012J\u0018\u0010\u0013\u001a\u00020\u00142\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u0014J\u001f\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u0016¢\u0006\u0002\u0010\u0017J3\u0010\u0018\u001a\u0004\u0018\u0001H\u0019\"\n\b\u0000\u0010\u0019*\u0004\u0018\u00010\u001a2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u0002H\u0019\u0018\u00010\u001b¢\u0006\u0002\u0010\u001cJ\u001c\u0010\u001d\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ(\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u001f2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u001fJ\u0010\u0010 \u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0016\u0010!\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u0001J\"\u0010#\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0010\u0010$\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u001fJ\u000e\u0010%\u001a\u00020\u00062\u0006\u0010&\u001a\u00020'R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/ipotensic/baselib/utils/MMKVUtils;", "", "()V", "mv", "Lcom/tencent/mmkv/MMKV;", "clearAll", "", "getBoolean", "", "key", "", "defaultValue", "getBytes", "", "getDouble", "", "(Ljava/lang/String;D)Ljava/lang/Double;", "getFloat", "", "getInt", "", "getLong", "", "(Ljava/lang/String;J)Ljava/lang/Long;", "getParcelable", "T", "Landroid/os/Parcelable;", "Ljava/lang/Class;", "(Ljava/lang/String;Ljava/lang/Class;)Landroid/os/Parcelable;", "getString", "getStringSet", "", "removeKey", FluentPropertyBeanIntrospector.DEFAULT_WRITE_METHOD_PREFIX, "value", "setStringSet", "sets", "testImportSharedPreferences", "context", "Landroid/content/Context;", "Companion", "BaseLib_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class MMKVUtils {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy instance$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<MMKVUtils>() { // from class: com.ipotensic.baselib.utils.MMKVUtils$Companion$instance$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final MMKVUtils invoke() {
            return new MMKVUtils(null);
        }
    });
    private MMKV mv;

    public static final MMKVUtils getInstance() {
        return INSTANCE.getInstance();
    }

    private MMKVUtils() {
        this.mv = MMKV.defaultMMKV();
    }

    public /* synthetic */ MMKVUtils(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: MMKVUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R!\u0010\u0003\u001a\u00020\u00048FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\b\u0010\t\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/ipotensic/baselib/utils/MMKVUtils$Companion;", "", "()V", "instance", "Lcom/ipotensic/baselib/utils/MMKVUtils;", "instance$annotations", "getInstance", "()Lcom/ipotensic/baselib/utils/MMKVUtils;", "instance$delegate", "Lkotlin/Lazy;", "BaseLib_release"}, k = 1, mv = {1, 1, 15})
    public static final class Companion {
        static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Companion.class), "instance", "getInstance()Lcom/ipotensic/baselib/utils/MMKVUtils;"))};

        @JvmStatic
        public static /* synthetic */ void instance$annotations() {
        }

        public final MMKVUtils getInstance() {
            Lazy lazy = MMKVUtils.instance$delegate;
            Companion companion = MMKVUtils.INSTANCE;
            KProperty kProperty = $$delegatedProperties[0];
            return (MMKVUtils) lazy.getValue();
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final void set(String key, Object value) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        Intrinsics.checkParameterIsNotNull(value, "value");
        if (value instanceof String) {
            MMKV mmkv = this.mv;
            if (mmkv != null) {
                mmkv.encode(key, (String) value);
                return;
            }
            return;
        }
        if (value instanceof Integer) {
            MMKV mmkv2 = this.mv;
            if (mmkv2 != null) {
                mmkv2.encode(key, ((Number) value).intValue());
                return;
            }
            return;
        }
        if (value instanceof Double) {
            MMKV mmkv3 = this.mv;
            if (mmkv3 != null) {
                mmkv3.encode(key, ((Number) value).doubleValue());
                return;
            }
            return;
        }
        if (value instanceof Float) {
            MMKV mmkv4 = this.mv;
            if (mmkv4 != null) {
                mmkv4.encode(key, ((Number) value).floatValue());
                return;
            }
            return;
        }
        if (value instanceof Boolean) {
            MMKV mmkv5 = this.mv;
            if (mmkv5 != null) {
                mmkv5.encode(key, ((Boolean) value).booleanValue());
                return;
            }
            return;
        }
        if (value instanceof Long) {
            MMKV mmkv6 = this.mv;
            if (mmkv6 != null) {
                mmkv6.encode(key, ((Number) value).longValue());
                return;
            }
            return;
        }
        if (value instanceof byte[]) {
            MMKV mmkv7 = this.mv;
            if (mmkv7 != null) {
                mmkv7.encode(key, (byte[]) value);
                return;
            }
            return;
        }
        if (!(value instanceof Parcelable)) {
            throw new IllegalStateException("Unsupported value type");
        }
        MMKV mmkv8 = this.mv;
        if (mmkv8 != null) {
            mmkv8.encode(key, (Parcelable) value);
        }
    }

    public final void setStringSet(String key, Set<String> sets) {
        MMKV mmkv = this.mv;
        if (mmkv != null) {
            mmkv.encode(key, sets);
        }
    }

    public final int getInt(String key, int defaultValue) {
        MMKV mmkv = this.mv;
        if (mmkv != null) {
            Integer.valueOf(mmkv.decodeInt(key, defaultValue));
        }
        return defaultValue;
    }

    public final Double getDouble(String key, double defaultValue) {
        MMKV mmkv = this.mv;
        if (mmkv != null) {
            return Double.valueOf(mmkv.decodeDouble(key, defaultValue));
        }
        return null;
    }

    public final Long getLong(String key, long defaultValue) {
        MMKV mmkv = this.mv;
        if (mmkv != null) {
            return Long.valueOf(mmkv.decodeLong(key, defaultValue));
        }
        return null;
    }

    public final boolean getBoolean(String key, boolean defaultValue) {
        MMKV mmkv = this.mv;
        if (mmkv != null) {
            Boolean.valueOf(mmkv.decodeBool(key, defaultValue));
        }
        return defaultValue;
    }

    public final float getFloat(String key, float defaultValue) {
        MMKV mmkv = this.mv;
        if (mmkv != null) {
            Float.valueOf(mmkv.decodeFloat(key, defaultValue));
        }
        return defaultValue;
    }

    public final byte[] getBytes(String key, byte[] defaultValue) {
        Intrinsics.checkParameterIsNotNull(defaultValue, "defaultValue");
        MMKV mmkv = this.mv;
        if (mmkv != null) {
            mmkv.decodeBytes(key, defaultValue);
        }
        return defaultValue;
    }

    public final String getString(String key, String defaultValue) {
        MMKV mmkv = this.mv;
        if (mmkv != null) {
            mmkv.decodeString(key);
        }
        return defaultValue;
    }

    public final Set<String> getStringSet(String key, Set<String> defaultValue) {
        MMKV mmkv = this.mv;
        if (mmkv != null) {
            return mmkv.decodeStringSet(key, defaultValue);
        }
        return null;
    }

    public final <T extends Parcelable> T getParcelable(String key, Class<T> defaultValue) {
        MMKV mmkv = this.mv;
        if (mmkv != null) {
            return (T) mmkv.decodeParcelable(key, defaultValue);
        }
        return null;
    }

    public final void removeKey(String key) {
        MMKV mmkv = this.mv;
        if (mmkv != null) {
            mmkv.removeValueForKey(key);
        }
    }

    public final void clearAll() {
        MMKV mmkv = this.mv;
        if (mmkv != null) {
            mmkv.clearAll();
        }
    }

    public final void testImportSharedPreferences(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        SharedPreferences sharedPreferences = context.getSharedPreferences("MY_SP", 0);
        MMKV mmkv = this.mv;
        if (mmkv != null) {
            mmkv.importFromSharedPreferences(sharedPreferences);
        }
        sharedPreferences.edit().clear().commit();
    }
}
