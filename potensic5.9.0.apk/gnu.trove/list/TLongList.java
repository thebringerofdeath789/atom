package gnu.trove.list;

import gnu.trove.TLongCollection;
import gnu.trove.function.TLongFunction;
import gnu.trove.procedure.TLongProcedure;
import java.util.Random;

/* loaded from: classes3.dex */
public interface TLongList extends TLongCollection {
    void add(long[] jArr);

    void add(long[] jArr, int i, int i2);

    @Override // gnu.trove.TLongCollection
    boolean add(long j);

    int binarySearch(long j);

    int binarySearch(long j, int i, int i2);

    @Override // gnu.trove.TLongCollection
    void clear();

    @Override // gnu.trove.TLongCollection
    boolean contains(long j);

    void fill(int i, int i2, long j);

    void fill(long j);

    @Override // gnu.trove.TLongCollection
    boolean forEach(TLongProcedure tLongProcedure);

    boolean forEachDescending(TLongProcedure tLongProcedure);

    long get(int i);

    @Override // gnu.trove.TLongCollection
    long getNoEntryValue();

    TLongList grep(TLongProcedure tLongProcedure);

    int indexOf(int i, long j);

    int indexOf(long j);

    void insert(int i, long j);

    void insert(int i, long[] jArr);

    void insert(int i, long[] jArr, int i2, int i3);

    TLongList inverseGrep(TLongProcedure tLongProcedure);

    @Override // gnu.trove.TLongCollection
    boolean isEmpty();

    int lastIndexOf(int i, long j);

    int lastIndexOf(long j);

    long max();

    long min();

    void remove(int i, int i2);

    @Override // gnu.trove.TLongCollection
    boolean remove(long j);

    long removeAt(int i);

    long replace(int i, long j);

    void reverse();

    void reverse(int i, int i2);

    long set(int i, long j);

    void set(int i, long[] jArr);

    void set(int i, long[] jArr, int i2, int i3);

    void shuffle(Random random);

    @Override // gnu.trove.TLongCollection
    int size();

    void sort();

    void sort(int i, int i2);

    TLongList subList(int i, int i2);

    long sum();

    @Override // gnu.trove.TLongCollection
    long[] toArray();

    long[] toArray(int i, int i2);

    @Override // gnu.trove.TLongCollection
    long[] toArray(long[] jArr);

    long[] toArray(long[] jArr, int i, int i2);

    long[] toArray(long[] jArr, int i, int i2, int i3);

    void transformValues(TLongFunction tLongFunction);
}