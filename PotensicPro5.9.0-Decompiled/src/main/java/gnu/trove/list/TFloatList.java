package gnu.trove.list;

import gnu.trove.TFloatCollection;
import gnu.trove.function.TFloatFunction;
import gnu.trove.procedure.TFloatProcedure;
import java.util.Random;

/* loaded from: classes3.dex */
public interface TFloatList extends TFloatCollection {
    void add(float[] fArr);

    void add(float[] fArr, int i, int i2);

    @Override // gnu.trove.TFloatCollection
    boolean add(float f);

    int binarySearch(float f);

    int binarySearch(float f, int i, int i2);

    @Override // gnu.trove.TFloatCollection
    void clear();

    @Override // gnu.trove.TFloatCollection
    boolean contains(float f);

    void fill(float f);

    void fill(int i, int i2, float f);

    @Override // gnu.trove.TFloatCollection
    boolean forEach(TFloatProcedure tFloatProcedure);

    boolean forEachDescending(TFloatProcedure tFloatProcedure);

    float get(int i);

    @Override // gnu.trove.TFloatCollection
    float getNoEntryValue();

    TFloatList grep(TFloatProcedure tFloatProcedure);

    int indexOf(float f);

    int indexOf(int i, float f);

    void insert(int i, float f);

    void insert(int i, float[] fArr);

    void insert(int i, float[] fArr, int i2, int i3);

    TFloatList inverseGrep(TFloatProcedure tFloatProcedure);

    @Override // gnu.trove.TFloatCollection
    boolean isEmpty();

    int lastIndexOf(float f);

    int lastIndexOf(int i, float f);

    float max();

    float min();

    void remove(int i, int i2);

    @Override // gnu.trove.TFloatCollection
    boolean remove(float f);

    float removeAt(int i);

    float replace(int i, float f);

    void reverse();

    void reverse(int i, int i2);

    float set(int i, float f);

    void set(int i, float[] fArr);

    void set(int i, float[] fArr, int i2, int i3);

    void shuffle(Random random);

    @Override // gnu.trove.TFloatCollection
    int size();

    void sort();

    void sort(int i, int i2);

    TFloatList subList(int i, int i2);

    float sum();

    @Override // gnu.trove.TFloatCollection
    float[] toArray();

    float[] toArray(int i, int i2);

    @Override // gnu.trove.TFloatCollection
    float[] toArray(float[] fArr);

    float[] toArray(float[] fArr, int i, int i2);

    float[] toArray(float[] fArr, int i, int i2, int i3);

    void transformValues(TFloatFunction tFloatFunction);
}
