package gnu.trove.stack;

/* loaded from: classes3.dex */
public interface TIntStack {
    void clear();

    int getNoEntryValue();

    int peek();

    int pop();

    void push(int i);

    int size();

    void toArray(int[] iArr);

    int[] toArray();
}