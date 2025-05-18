package gnu.trove.map;

import gnu.trove.TByteCollection;
import gnu.trove.function.TByteFunction;
import gnu.trove.iterator.TDoubleByteIterator;
import gnu.trove.procedure.TByteProcedure;
import gnu.trove.procedure.TDoubleByteProcedure;
import gnu.trove.procedure.TDoubleProcedure;
import gnu.trove.set.TDoubleSet;
import java.util.Map;

/* loaded from: classes3.dex */
public interface TDoubleByteMap {
    byte adjustOrPutValue(double d, byte b, byte b2);

    boolean adjustValue(double d, byte b);

    void clear();

    boolean containsKey(double d);

    boolean containsValue(byte b);

    boolean forEachEntry(TDoubleByteProcedure tDoubleByteProcedure);

    boolean forEachKey(TDoubleProcedure tDoubleProcedure);

    boolean forEachValue(TByteProcedure tByteProcedure);

    byte get(double d);

    double getNoEntryKey();

    byte getNoEntryValue();

    boolean increment(double d);

    boolean isEmpty();

    TDoubleByteIterator iterator();

    TDoubleSet keySet();

    double[] keys();

    double[] keys(double[] dArr);

    byte put(double d, byte b);

    void putAll(TDoubleByteMap tDoubleByteMap);

    void putAll(Map<? extends Double, ? extends Byte> map);

    byte putIfAbsent(double d, byte b);

    byte remove(double d);

    boolean retainEntries(TDoubleByteProcedure tDoubleByteProcedure);

    int size();

    void transformValues(TByteFunction tByteFunction);

    TByteCollection valueCollection();

    byte[] values();

    byte[] values(byte[] bArr);
}