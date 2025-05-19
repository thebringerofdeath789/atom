package android.util;

/* loaded from: classes.dex */
public abstract class FloatProperty<T> extends Property<T, Float> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.util.Property
    public abstract Float get(T t);

    public abstract void setValue(T t, float f);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.util.Property
    public /* bridge */ /* synthetic */ Float get(Object obj) {
        return get((FloatProperty<T>) obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.util.Property
    public /* bridge */ /* synthetic */ void set(Object obj, Float f) {
        set2((FloatProperty<T>) obj, f);
    }

    public FloatProperty(String str) {
        super(Float.class, str);
    }

    /* renamed from: set, reason: avoid collision after fix types in other method */
    public final void set2(T t, Float f) {
        setValue(t, f.floatValue());
    }
}
