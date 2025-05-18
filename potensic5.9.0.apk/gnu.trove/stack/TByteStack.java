package gnu.trove.stack;

/* loaded from: classes3.dex */
public interface TByteStack {
    void clear();

    byte getNoEntryValue();

    byte peek();

    byte pop();

    void push(byte b);

    int size();

    void toArray(byte[] bArr);

    byte[] toArray();
}