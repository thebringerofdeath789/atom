package gnu.trove.stack;

/* loaded from: classes3.dex */
public interface TCharStack {
    void clear();

    char getNoEntryValue();

    char peek();

    char pop();

    void push(char c);

    int size();

    void toArray(char[] cArr);

    char[] toArray();
}