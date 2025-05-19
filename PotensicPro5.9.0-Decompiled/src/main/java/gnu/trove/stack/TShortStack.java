package gnu.trove.stack;

/* loaded from: classes3.dex */
public interface TShortStack {
    void clear();

    short getNoEntryValue();

    short peek();

    short pop();

    void push(short s);

    int size();

    void toArray(short[] sArr);

    short[] toArray();
}
