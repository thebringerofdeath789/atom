package gnu.trove.map;

import gnu.trove.TFloatCollection;
import gnu.trove.function.TFloatFunction;
import gnu.trove.iterator.TShortFloatIterator;
import gnu.trove.procedure.TFloatProcedure;
import gnu.trove.procedure.TShortFloatProcedure;
import gnu.trove.procedure.TShortProcedure;
import gnu.trove.set.TShortSet;
import java.util.Map;

/* loaded from: classes3.dex */
public interface TShortFloatMap {
    float adjustOrPutValue(short s, float f, float f2);

    boolean adjustValue(short s, float f);

    void clear();

    boolean containsKey(short s);

    boolean containsValue(float f);

    boolean forEachEntry(TShortFloatProcedure tShortFloatProcedure);

    boolean forEachKey(TShortProcedure tShortProcedure);

    boolean forEachValue(TFloatProcedure tFloatProcedure);

    float get(short s);

    short getNoEntryKey();

    float getNoEntryValue();

    boolean increment(short s);

    boolean isEmpty();

    TShortFloatIterator iterator();

    TShortSet keySet();

    short[] keys();

    short[] keys(short[] sArr);

    float put(short s, float f);

    void putAll(TShortFloatMap tShortFloatMap);

    void putAll(Map<? extends Short, ? extends Float> map);

    float putIfAbsent(short s, float f);

    float remove(short s);

    boolean retainEntries(TShortFloatProcedure tShortFloatProcedure);

    int size();

    void transformValues(TFloatFunction tFloatFunction);

    TFloatCollection valueCollection();

    float[] values();

    float[] values(float[] fArr);
}