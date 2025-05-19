package gnu.trove.map;

import gnu.trove.TFloatCollection;
import gnu.trove.function.TFloatFunction;
import gnu.trove.iterator.TByteFloatIterator;
import gnu.trove.procedure.TByteFloatProcedure;
import gnu.trove.procedure.TByteProcedure;
import gnu.trove.procedure.TFloatProcedure;
import gnu.trove.set.TByteSet;
import java.util.Map;

/* loaded from: classes3.dex */
public interface TByteFloatMap {
    float adjustOrPutValue(byte b, float f, float f2);

    boolean adjustValue(byte b, float f);

    void clear();

    boolean containsKey(byte b);

    boolean containsValue(float f);

    boolean forEachEntry(TByteFloatProcedure tByteFloatProcedure);

    boolean forEachKey(TByteProcedure tByteProcedure);

    boolean forEachValue(TFloatProcedure tFloatProcedure);

    float get(byte b);

    byte getNoEntryKey();

    float getNoEntryValue();

    boolean increment(byte b);

    boolean isEmpty();

    TByteFloatIterator iterator();

    TByteSet keySet();

    byte[] keys();

    byte[] keys(byte[] bArr);

    float put(byte b, float f);

    void putAll(TByteFloatMap tByteFloatMap);

    void putAll(Map<? extends Byte, ? extends Float> map);

    float putIfAbsent(byte b, float f);

    float remove(byte b);

    boolean retainEntries(TByteFloatProcedure tByteFloatProcedure);

    int size();

    void transformValues(TFloatFunction tFloatFunction);

    TFloatCollection valueCollection();

    float[] values();

    float[] values(float[] fArr);
}
