package gnu.trove.stack;

/* loaded from: classes3.dex */
public interface TLongStack {
    void clear();

    long getNoEntryValue();

    long peek();

    long pop();

    void push(long j);

    int size();

    void toArray(long[] jArr);

    long[] toArray();
}
