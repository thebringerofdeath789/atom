package android.util;

/* loaded from: classes.dex */
public abstract class IntProperty<T> extends Property<T, Integer> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.util.Property
    public abstract Integer get(T t);

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

    public IntProperty(String str) {
        super(Integer.class, str);
    }

    /* renamed from: set, reason: avoid collision after fix types in other method */
    public final void set2(T t, Integer num) {
        setValue(t, num.intValue());
    }
}
