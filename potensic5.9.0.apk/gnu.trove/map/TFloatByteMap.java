package gnu.trove.map;

import gnu.trove.TByteCollection;
import gnu.trove.function.TByteFunction;
import gnu.trove.iterator.TFloatByteIterator;
import gnu.trove.procedure.TByteProcedure;
import gnu.trove.procedure.TFloatByteProcedure;
import gnu.trove.procedure.TFloatProcedure;
import gnu.trove.set.TFloatSet;
import java.util.Map;

/* loaded from: classes3.dex */
public interface TFloatByteMap {
    byte adjustOrPutValue(float f, byte b, byte b2);

    boolean adjustValue(float f, byte b);

    void clear();

    boolean containsKey(float f);

    boolean containsValue(byte b);

    boolean forEachEntry(TFloatByteProcedure tFloatByteProcedure);

    boolean forEachKey(TFloatProcedure tFloatProcedure);

    boolean forEachValue(TByteProcedure tByteProcedure);

    byte get(float f);

    float getNoEntryKey();

    byte getNoEntryValue();

    boolean increment(float f);

    boolean isEmpty();

    TFloatByteIterator iterator();

    TFloatSet keySet();

    float[] keys();

    float[] keys(float[] fArr);

    byte put(float f, byte b);

    void putAll(TFloatByteMap tFloatByteMap);

    void putAll(Map<? extends Float, ? extends Byte> map);

    byte putIfAbsent(float f, byte b);

    byte remove(float f);

    boolean retainEntries(TFloatByteProcedure tFloatByteProcedure);

    int size();

    void transformValues(TByteFunction tByteFunction);

    TByteCollection valueCollection();

    byte[] values();

    byte[] values(byte[] bArr);
}