package gnu.trove.map;

import gnu.trove.TShortCollection;
import gnu.trove.function.TShortFunction;
import gnu.trove.iterator.TFloatShortIterator;
import gnu.trove.procedure.TFloatProcedure;
import gnu.trove.procedure.TFloatShortProcedure;
import gnu.trove.procedure.TShortProcedure;
import gnu.trove.set.TFloatSet;
import java.util.Map;

/* loaded from: classes3.dex */
public interface TFloatShortMap {
    short adjustOrPutValue(float f, short s, short s2);

    boolean adjustValue(float f, short s);

    void clear();

    boolean containsKey(float f);

    boolean containsValue(short s);

    boolean forEachEntry(TFloatShortProcedure tFloatShortProcedure);

    boolean forEachKey(TFloatProcedure tFloatProcedure);

    boolean forEachValue(TShortProcedure tShortProcedure);

    short get(float f);

    float getNoEntryKey();

    short getNoEntryValue();

    boolean increment(float f);

    boolean isEmpty();

    TFloatShortIterator iterator();

    TFloatSet keySet();

    float[] keys();

    float[] keys(float[] fArr);

    short put(float f, short s);

    void putAll(TFloatShortMap tFloatShortMap);

    void putAll(Map<? extends Float, ? extends Short> map);

    short putIfAbsent(float f, short s);

    short remove(float f);

    boolean retainEntries(TFloatShortProcedure tFloatShortProcedure);

    int size();

    void transformValues(TShortFunction tShortFunction);

    TShortCollection valueCollection();

    short[] values();

    short[] values(short[] sArr);
}