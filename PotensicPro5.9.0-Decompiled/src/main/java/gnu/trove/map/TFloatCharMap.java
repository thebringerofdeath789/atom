package gnu.trove.map;

import gnu.trove.TCharCollection;
import gnu.trove.function.TCharFunction;
import gnu.trove.iterator.TFloatCharIterator;
import gnu.trove.procedure.TCharProcedure;
import gnu.trove.procedure.TFloatCharProcedure;
import gnu.trove.procedure.TFloatProcedure;
import gnu.trove.set.TFloatSet;
import java.util.Map;

/* loaded from: classes3.dex */
public interface TFloatCharMap {
    char adjustOrPutValue(float f, char c, char c2);

    boolean adjustValue(float f, char c);

    void clear();

    boolean containsKey(float f);

    boolean containsValue(char c);

    boolean forEachEntry(TFloatCharProcedure tFloatCharProcedure);

    boolean forEachKey(TFloatProcedure tFloatProcedure);

    boolean forEachValue(TCharProcedure tCharProcedure);

    char get(float f);

    float getNoEntryKey();

    char getNoEntryValue();

    boolean increment(float f);

    boolean isEmpty();

    TFloatCharIterator iterator();

    TFloatSet keySet();

    float[] keys();

    float[] keys(float[] fArr);

    char put(float f, char c);

    void putAll(TFloatCharMap tFloatCharMap);

    void putAll(Map<? extends Float, ? extends Character> map);

    char putIfAbsent(float f, char c);

    char remove(float f);

    boolean retainEntries(TFloatCharProcedure tFloatCharProcedure);

    int size();

    void transformValues(TCharFunction tCharFunction);

    TCharCollection valueCollection();

    char[] values();

    char[] values(char[] cArr);
}
