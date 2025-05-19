package gnu.trove.set;

import gnu.trove.TByteCollection;
import gnu.trove.iterator.TByteIterator;
import gnu.trove.procedure.TByteProcedure;
import java.util.Collection;

/* loaded from: classes3.dex */
public interface TByteSet extends TByteCollection {
    @Override // gnu.trove.TByteCollection
    boolean add(byte b);

    @Override // gnu.trove.TByteCollection
    boolean addAll(TByteCollection tByteCollection);

    @Override // gnu.trove.TByteCollection
    boolean addAll(Collection<? extends Byte> collection);

    @Override // gnu.trove.TByteCollection
    boolean addAll(byte[] bArr);

    @Override // gnu.trove.TByteCollection
    void clear();

    @Override // gnu.trove.TByteCollection
    boolean contains(byte b);

    @Override // gnu.trove.TByteCollection
    boolean containsAll(TByteCollection tByteCollection);

    @Override // gnu.trove.TByteCollection
    boolean containsAll(Collection<?> collection);

    @Override // gnu.trove.TByteCollection
    boolean containsAll(byte[] bArr);

    @Override // gnu.trove.TByteCollection
    boolean equals(Object obj);

    @Override // gnu.trove.TByteCollection
    boolean forEach(TByteProcedure tByteProcedure);

    @Override // gnu.trove.TByteCollection
    byte getNoEntryValue();

    @Override // gnu.trove.TByteCollection
    int hashCode();

    @Override // gnu.trove.TByteCollection
    boolean isEmpty();

    @Override // gnu.trove.TByteCollection
    TByteIterator iterator();

    @Override // gnu.trove.TByteCollection
    boolean remove(byte b);

    @Override // gnu.trove.TByteCollection
    boolean removeAll(TByteCollection tByteCollection);

    @Override // gnu.trove.TByteCollection
    boolean removeAll(Collection<?> collection);

    @Override // gnu.trove.TByteCollection
    boolean removeAll(byte[] bArr);

    @Override // gnu.trove.TByteCollection
    boolean retainAll(TByteCollection tByteCollection);

    @Override // gnu.trove.TByteCollection
    boolean retainAll(Collection<?> collection);

    @Override // gnu.trove.TByteCollection
    boolean retainAll(byte[] bArr);

    @Override // gnu.trove.TByteCollection
    int size();

    @Override // gnu.trove.TByteCollection
    byte[] toArray();

    @Override // gnu.trove.TByteCollection
    byte[] toArray(byte[] bArr);
}
