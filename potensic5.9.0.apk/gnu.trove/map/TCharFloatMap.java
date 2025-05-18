package gnu.trove.map;

import gnu.trove.TFloatCollection;
import gnu.trove.function.TFloatFunction;
import gnu.trove.iterator.TCharFloatIterator;
import gnu.trove.procedure.TCharFloatProcedure;
import gnu.trove.procedure.TCharProcedure;
import gnu.trove.procedure.TFloatProcedure;
import gnu.trove.set.TCharSet;
import java.util.Map;

/* loaded from: classes3.dex */
public interface TCharFloatMap {
    float adjustOrPutValue(char c, float f, float f2);

    boolean adjustValue(char c, float f);

    void clear();

    boolean containsKey(char c);

    boolean containsValue(float f);

    boolean forEachEntry(TCharFloatProcedure tCharFloatProcedure);

    boolean forEachKey(TCharProcedure tCharProcedure);

    boolean forEachValue(TFloatProcedure tFloatProcedure);

    float get(char c);

    char getNoEntryKey();

    float getNoEntryValue();

    boolean increment(char c);

    boolean isEmpty();

    TCharFloatIterator iterator();

    TCharSet keySet();

    char[] keys();

    char[] keys(char[] cArr);

    float put(char c, float f);

    void putAll(TCharFloatMap tCharFloatMap);

    void putAll(Map<? extends Character, ? extends Float> map);

    float putIfAbsent(char c, float f);

    float remove(char c);

    boolean retainEntries(TCharFloatProcedure tCharFloatProcedure);

    int size();

    void transformValues(TFloatFunction tFloatFunction);

    TFloatCollection valueCollection();

    float[] values();

    float[] values(float[] fArr);
}