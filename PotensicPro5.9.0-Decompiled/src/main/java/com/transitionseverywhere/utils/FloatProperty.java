package com.transitionseverywhere.utils;

/* loaded from: classes3.dex */
public abstract class FloatProperty<T> extends android.util.FloatProperty<T> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.util.FloatProperty, android.util.Property
    public /* bridge */ /* synthetic */ Float get(Object obj) {
        return get((FloatProperty<T>) obj);
    }

    public FloatProperty() {
        super(null);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.util.FloatProperty, android.util.Property
    public Float get(T t) {
        return Float.valueOf(0.0f);
    }
}
