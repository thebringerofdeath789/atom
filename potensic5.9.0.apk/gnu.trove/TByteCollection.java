package gnu.trove;

import gnu.trove.iterator.TByteIterator;
import gnu.trove.procedure.TByteProcedure;
import java.util.Collection;

/* loaded from: classes3.dex */
public interface TByteCollection {
    public static final long serialVersionUID = 1;

    boolean add(byte b);

    boolean addAll(TByteCollection tByteCollection);

    boolean addAll(Collection<? extends Byte> collection);

    boolean addAll(byte[] bArr);

    void clear();

    boolean contains(byte b);

    boolean containsAll(TByteCollection tByteCollection);

    boolean containsAll(Collection<?> collection);

    boolean containsAll(byte[] bArr);

    boolean equals(Object obj);

    boolean forEach(TByteProcedure tByteProcedure);

    byte getNoEntryValue();

    int hashCode();

    boolean isEmpty();

    TByteIterator iterator();

    boolean remove(byte b);

    boolean removeAll(TByteCollection tByteCollection);

    boolean removeAll(Collection<?> collection);

    boolean removeAll(byte[] bArr);

    boolean retainAll(TByteCollection tByteCollection);

    boolean retainAll(Collection<?> collection);

    boolean retainAll(byte[] bArr);

    int size();

    byte[] toArray();

    byte[] toArray(byte[] bArr);
}