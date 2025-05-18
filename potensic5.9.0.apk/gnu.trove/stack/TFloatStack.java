package gnu.trove.stack;

/* loaded from: classes3.dex */
public interface TFloatStack {
    void clear();

    float getNoEntryValue();

    float peek();

    float pop();

    void push(float f);

    int size();

    void toArray(float[] fArr);

    float[] toArray();
}