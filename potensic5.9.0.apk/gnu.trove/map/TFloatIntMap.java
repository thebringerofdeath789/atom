package gnu.trove.map;

import gnu.trove.TIntCollection;
import gnu.trove.function.TIntFunction;
import gnu.trove.iterator.TFloatIntIterator;
import gnu.trove.procedure.TFloatIntProcedure;
import gnu.trove.procedure.TFloatProcedure;
import gnu.trove.procedure.TIntProcedure;
import gnu.trove.set.TFloatSet;
import java.util.Map;

/* loaded from: classes3.dex */
public interface TFloatIntMap {
    int adjustOrPutValue(float f, int i, int i2);

    boolean adjustValue(float f, int i);

    void clear();

    boolean containsKey(float f);

    boolean containsValue(int i);

    boolean forEachEntry(TFloatIntProcedure tFloatIntProcedure);

    boolean forEachKey(TFloatProcedure tFloatProcedure);

    boolean forEachValue(TIntProcedure tIntProcedure);

    int get(float f);

    float getNoEntryKey();

    int getNoEntryValue();

    boolean increment(float f);

    boolean isEmpty();

    TFloatIntIterator iterator();

    TFloatSet keySet();

    float[] keys();

    float[] keys(float[] fArr);

    int put(float f, int i);

    void putAll(TFloatIntMap tFloatIntMap);

    void putAll(Map<? extends Float, ? extends Integer> map);

    int putIfAbsent(float f, int i);

    int remove(float f);

    boolean retainEntries(TFloatIntProcedure tFloatIntProcedure);

    int size();

    void transformValues(TIntFunction tIntFunction);

    TIntCollection valueCollection();

    int[] values();

    int[] values(int[] iArr);
}