package gnu.trove.list;

import gnu.trove.TByteCollection;
import gnu.trove.function.TByteFunction;
import gnu.trove.procedure.TByteProcedure;
import java.util.Random;

/* loaded from: classes3.dex */
public interface TByteList extends TByteCollection {
    void add(byte[] bArr);

    void add(byte[] bArr, int i, int i2);

    @Override // gnu.trove.TByteCollection
    boolean add(byte b);

    int binarySearch(byte b);

    int binarySearch(byte b, int i, int i2);

    @Override // gnu.trove.TByteCollection
    void clear();

    @Override // gnu.trove.TByteCollection
    boolean contains(byte b);

    void fill(byte b);

    void fill(int i, int i2, byte b);

    @Override // gnu.trove.TByteCollection
    boolean forEach(TByteProcedure tByteProcedure);

    boolean forEachDescending(TByteProcedure tByteProcedure);

    byte get(int i);

    @Override // gnu.trove.TByteCollection
    byte getNoEntryValue();

    TByteList grep(TByteProcedure tByteProcedure);

    int indexOf(byte b);

    int indexOf(int i, byte b);

    void insert(int i, byte b);

    void insert(int i, byte[] bArr);

    void insert(int i, byte[] bArr, int i2, int i3);

    TByteList inverseGrep(TByteProcedure tByteProcedure);

    @Override // gnu.trove.TByteCollection
    boolean isEmpty();

    int lastIndexOf(byte b);

    int lastIndexOf(int i, byte b);

    byte max();

    byte min();

    void remove(int i, int i2);

    @Override // gnu.trove.TByteCollection
    boolean remove(byte b);

    byte removeAt(int i);

    byte replace(int i, byte b);

    void reverse();

    void reverse(int i, int i2);

    byte set(int i, byte b);

    void set(int i, byte[] bArr);

    void set(int i, byte[] bArr, int i2, int i3);

    void shuffle(Random random);

    @Override // gnu.trove.TByteCollection
    int size();

    void sort();

    void sort(int i, int i2);

    TByteList subList(int i, int i2);

    byte sum();

    @Override // gnu.trove.TByteCollection
    byte[] toArray();

    byte[] toArray(int i, int i2);

    @Override // gnu.trove.TByteCollection
    byte[] toArray(byte[] bArr);

    byte[] toArray(byte[] bArr, int i, int i2);

    byte[] toArray(byte[] bArr, int i, int i2, int i3);

    void transformValues(TByteFunction tByteFunction);
}