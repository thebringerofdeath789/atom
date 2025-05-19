package gnu.trove.map;

import gnu.trove.TDoubleCollection;
import gnu.trove.function.TDoubleFunction;
import gnu.trove.iterator.TByteDoubleIterator;
import gnu.trove.procedure.TByteDoubleProcedure;
import gnu.trove.procedure.TByteProcedure;
import gnu.trove.procedure.TDoubleProcedure;
import gnu.trove.set.TByteSet;
import java.util.Map;

/* loaded from: classes3.dex */
public interface TByteDoubleMap {
    double adjustOrPutValue(byte b, double d, double d2);

    boolean adjustValue(byte b, double d);

    void clear();

    boolean containsKey(byte b);

    boolean containsValue(double d);

    boolean forEachEntry(TByteDoubleProcedure tByteDoubleProcedure);

    boolean forEachKey(TByteProcedure tByteProcedure);

    boolean forEachValue(TDoubleProcedure tDoubleProcedure);

    double get(byte b);

    byte getNoEntryKey();

    double getNoEntryValue();

    boolean increment(byte b);

    boolean isEmpty();

    TByteDoubleIterator iterator();

    TByteSet keySet();

    byte[] keys();

    byte[] keys(byte[] bArr);

    double put(byte b, double d);

    void putAll(TByteDoubleMap tByteDoubleMap);

    void putAll(Map<? extends Byte, ? extends Double> map);

    double putIfAbsent(byte b, double d);

    double remove(byte b);

    boolean retainEntries(TByteDoubleProcedure tByteDoubleProcedure);

    int size();

    void transformValues(TDoubleFunction tDoubleFunction);

    TDoubleCollection valueCollection();

    double[] values();

    double[] values(double[] dArr);
}
