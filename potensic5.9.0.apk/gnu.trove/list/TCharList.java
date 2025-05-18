package gnu.trove.list;

import gnu.trove.TCharCollection;
import gnu.trove.function.TCharFunction;
import gnu.trove.procedure.TCharProcedure;
import java.util.Random;

/* loaded from: classes3.dex */
public interface TCharList extends TCharCollection {
    void add(char[] cArr);

    void add(char[] cArr, int i, int i2);

    @Override // gnu.trove.TCharCollection
    boolean add(char c);

    int binarySearch(char c);

    int binarySearch(char c, int i, int i2);

    @Override // gnu.trove.TCharCollection
    void clear();

    @Override // gnu.trove.TCharCollection
    boolean contains(char c);

    void fill(char c);

    void fill(int i, int i2, char c);

    @Override // gnu.trove.TCharCollection
    boolean forEach(TCharProcedure tCharProcedure);

    boolean forEachDescending(TCharProcedure tCharProcedure);

    char get(int i);

    @Override // gnu.trove.TCharCollection
    char getNoEntryValue();

    TCharList grep(TCharProcedure tCharProcedure);

    int indexOf(char c);

    int indexOf(int i, char c);

    void insert(int i, char c);

    void insert(int i, char[] cArr);

    void insert(int i, char[] cArr, int i2, int i3);

    TCharList inverseGrep(TCharProcedure tCharProcedure);

    @Override // gnu.trove.TCharCollection
    boolean isEmpty();

    int lastIndexOf(char c);

    int lastIndexOf(int i, char c);

    char max();

    char min();

    void remove(int i, int i2);

    @Override // gnu.trove.TCharCollection
    boolean remove(char c);

    char removeAt(int i);

    char replace(int i, char c);

    void reverse();

    void reverse(int i, int i2);

    char set(int i, char c);

    void set(int i, char[] cArr);

    void set(int i, char[] cArr, int i2, int i3);

    void shuffle(Random random);

    @Override // gnu.trove.TCharCollection
    int size();

    void sort();

    void sort(int i, int i2);

    TCharList subList(int i, int i2);

    char sum();

    @Override // gnu.trove.TCharCollection
    char[] toArray();

    char[] toArray(int i, int i2);

    @Override // gnu.trove.TCharCollection
    char[] toArray(char[] cArr);

    char[] toArray(char[] cArr, int i, int i2);

    char[] toArray(char[] cArr, int i, int i2, int i3);

    void transformValues(TCharFunction tCharFunction);
}