package com.transitionseverywhere.utils;

import android.os.Build;
import android.util.Property;

/* loaded from: classes3.dex */
public abstract class IntProperty<T> extends Property<T, Integer> {
    public abstract void setValue(T t, int i);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.util.Property
    public /* bridge */ /* synthetic */ Integer get(Object obj) {
        return get((IntProperty<T>) obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.util.Property
    public /* bridge */ /* synthetic */ void set(Object obj, Integer num) {
        set2((IntProperty<T>) obj, num);
    }

    public IntProperty() {
        super(Integer.class, null);
    }

    /* renamed from: set, reason: avoid collision after fix types in other method */
    public final void set2(T t, Integer num) {
        setValue(t, num.intValue());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.util.Property
    public Integer get(T t) {
        return 0;
    }

    public Property<T, Integer> optimize() {
        return Build.VERSION.SDK_INT > 18 ? new android.util.IntProperty<T>(null) { // from class: com.transitionseverywhere.utils.IntProperty.1
            @Override // android.util.IntProperty, android.util.Property
            public /* bridge */ /* synthetic */ Integer get(Object obj) {
                return get((AnonymousClass1) obj);
            }

            @Override // android.util.IntProperty
            public void setValue(T t, int i) {
                IntProperty.this.setValue(t, i);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.util.IntProperty, android.util.Property
            public Integer get(T t) {
                return IntProperty.this.get((IntProperty) t);
            }
        } : this;
    }
}
