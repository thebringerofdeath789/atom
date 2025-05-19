package gnu.trove;

import gnu.trove.impl.sync.TSynchronizedByteByteMap;
import gnu.trove.impl.sync.TSynchronizedByteCharMap;
import gnu.trove.impl.sync.TSynchronizedByteCollection;
import gnu.trove.impl.sync.TSynchronizedByteDoubleMap;
import gnu.trove.impl.sync.TSynchronizedByteFloatMap;
import gnu.trove.impl.sync.TSynchronizedByteIntMap;
import gnu.trove.impl.sync.TSynchronizedByteList;
import gnu.trove.impl.sync.TSynchronizedByteLongMap;
import gnu.trove.impl.sync.TSynchronizedByteObjectMap;
import gnu.trove.impl.sync.TSynchronizedByteSet;
import gnu.trove.impl.sync.TSynchronizedByteShortMap;
import gnu.trove.impl.sync.TSynchronizedCharByteMap;
import gnu.trove.impl.sync.TSynchronizedCharCharMap;
import gnu.trove.impl.sync.TSynchronizedCharCollection;
import gnu.trove.impl.sync.TSynchronizedCharDoubleMap;
import gnu.trove.impl.sync.TSynchronizedCharFloatMap;
import gnu.trove.impl.sync.TSynchronizedCharIntMap;
import gnu.trove.impl.sync.TSynchronizedCharList;
import gnu.trove.impl.sync.TSynchronizedCharLongMap;
import gnu.trove.impl.sync.TSynchronizedCharObjectMap;
import gnu.trove.impl.sync.TSynchronizedCharSet;
import gnu.trove.impl.sync.TSynchronizedCharShortMap;
import gnu.trove.impl.sync.TSynchronizedDoubleByteMap;
import gnu.trove.impl.sync.TSynchronizedDoubleCharMap;
import gnu.trove.impl.sync.TSynchronizedDoubleCollection;
import gnu.trove.impl.sync.TSynchronizedDoubleDoubleMap;
import gnu.trove.impl.sync.TSynchronizedDoubleFloatMap;
import gnu.trove.impl.sync.TSynchronizedDoubleIntMap;
import gnu.trove.impl.sync.TSynchronizedDoubleList;
import gnu.trove.impl.sync.TSynchronizedDoubleLongMap;
import gnu.trove.impl.sync.TSynchronizedDoubleObjectMap;
import gnu.trove.impl.sync.TSynchronizedDoubleSet;
import gnu.trove.impl.sync.TSynchronizedDoubleShortMap;
import gnu.trove.impl.sync.TSynchronizedFloatByteMap;
import gnu.trove.impl.sync.TSynchronizedFloatCharMap;
import gnu.trove.impl.sync.TSynchronizedFloatCollection;
import gnu.trove.impl.sync.TSynchronizedFloatDoubleMap;
import gnu.trove.impl.sync.TSynchronizedFloatFloatMap;
import gnu.trove.impl.sync.TSynchronizedFloatIntMap;
import gnu.trove.impl.sync.TSynchronizedFloatList;
import gnu.trove.impl.sync.TSynchronizedFloatLongMap;
import gnu.trove.impl.sync.TSynchronizedFloatObjectMap;
import gnu.trove.impl.sync.TSynchronizedFloatSet;
import gnu.trove.impl.sync.TSynchronizedFloatShortMap;
import gnu.trove.impl.sync.TSynchronizedIntByteMap;
import gnu.trove.impl.sync.TSynchronizedIntCharMap;
import gnu.trove.impl.sync.TSynchronizedIntCollection;
import gnu.trove.impl.sync.TSynchronizedIntDoubleMap;
import gnu.trove.impl.sync.TSynchronizedIntFloatMap;
import gnu.trove.impl.sync.TSynchronizedIntIntMap;
import gnu.trove.impl.sync.TSynchronizedIntList;
import gnu.trove.impl.sync.TSynchronizedIntLongMap;
import gnu.trove.impl.sync.TSynchronizedIntObjectMap;
import gnu.trove.impl.sync.TSynchronizedIntSet;
import gnu.trove.impl.sync.TSynchronizedIntShortMap;
import gnu.trove.impl.sync.TSynchronizedLongByteMap;
import gnu.trove.impl.sync.TSynchronizedLongCharMap;
import gnu.trove.impl.sync.TSynchronizedLongCollection;
import gnu.trove.impl.sync.TSynchronizedLongDoubleMap;
import gnu.trove.impl.sync.TSynchronizedLongFloatMap;
import gnu.trove.impl.sync.TSynchronizedLongIntMap;
import gnu.trove.impl.sync.TSynchronizedLongList;
import gnu.trove.impl.sync.TSynchronizedLongLongMap;
import gnu.trove.impl.sync.TSynchronizedLongObjectMap;
import gnu.trove.impl.sync.TSynchronizedLongSet;
import gnu.trove.impl.sync.TSynchronizedLongShortMap;
import gnu.trove.impl.sync.TSynchronizedObjectByteMap;
import gnu.trove.impl.sync.TSynchronizedObjectCharMap;
import gnu.trove.impl.sync.TSynchronizedObjectDoubleMap;
import gnu.trove.impl.sync.TSynchronizedObjectFloatMap;
import gnu.trove.impl.sync.TSynchronizedObjectIntMap;
import gnu.trove.impl.sync.TSynchronizedObjectLongMap;
import gnu.trove.impl.sync.TSynchronizedObjectShortMap;
import gnu.trove.impl.sync.TSynchronizedRandomAccessByteList;
import gnu.trove.impl.sync.TSynchronizedRandomAccessCharList;
import gnu.trove.impl.sync.TSynchronizedRandomAccessDoubleList;
import gnu.trove.impl.sync.TSynchronizedRandomAccessFloatList;
import gnu.trove.impl.sync.TSynchronizedRandomAccessIntList;
import gnu.trove.impl.sync.TSynchronizedRandomAccessLongList;
import gnu.trove.impl.sync.TSynchronizedRandomAccessShortList;
import gnu.trove.impl.sync.TSynchronizedShortByteMap;
import gnu.trove.impl.sync.TSynchronizedShortCharMap;
import gnu.trove.impl.sync.TSynchronizedShortCollection;
import gnu.trove.impl.sync.TSynchronizedShortDoubleMap;
import gnu.trove.impl.sync.TSynchronizedShortFloatMap;
import gnu.trove.impl.sync.TSynchronizedShortIntMap;
import gnu.trove.impl.sync.TSynchronizedShortList;
import gnu.trove.impl.sync.TSynchronizedShortLongMap;
import gnu.trove.impl.sync.TSynchronizedShortObjectMap;
import gnu.trove.impl.sync.TSynchronizedShortSet;
import gnu.trove.impl.sync.TSynchronizedShortShortMap;
import gnu.trove.impl.unmodifiable.TUnmodifiableByteByteMap;
import gnu.trove.impl.unmodifiable.TUnmodifiableByteCharMap;
import gnu.trove.impl.unmodifiable.TUnmodifiableByteCollection;
import gnu.trove.impl.unmodifiable.TUnmodifiableByteDoubleMap;
import gnu.trove.impl.unmodifiable.TUnmodifiableByteFloatMap;
import gnu.trove.impl.unmodifiable.TUnmodifiableByteIntMap;
import gnu.trove.impl.unmodifiable.TUnmodifiableByteList;
import gnu.trove.impl.unmodifiable.TUnmodifiableByteLongMap;
import gnu.trove.impl.unmodifiable.TUnmodifiableByteObjectMap;
import gnu.trove.impl.unmodifiable.TUnmodifiableByteSet;
import gnu.trove.impl.unmodifiable.TUnmodifiableByteShortMap;
import gnu.trove.impl.unmodifiable.TUnmodifiableCharByteMap;
import gnu.trove.impl.unmodifiable.TUnmodifiableCharCharMap;
import gnu.trove.impl.unmodifiable.TUnmodifiableCharCollection;
import gnu.trove.impl.unmodifiable.TUnmodifiableCharDoubleMap;
import gnu.trove.impl.unmodifiable.TUnmodifiableCharFloatMap;
import gnu.trove.impl.unmodifiable.TUnmodifiableCharIntMap;
import gnu.trove.impl.unmodifiable.TUnmodifiableCharList;
import gnu.trove.impl.unmodifiable.TUnmodifiableCharLongMap;
import gnu.trove.impl.unmodifiable.TUnmodifiableCharObjectMap;
import gnu.trove.impl.unmodifiable.TUnmodifiableCharSet;
import gnu.trove.impl.unmodifiable.TUnmodifiableCharShortMap;
import gnu.trove.impl.unmodifiable.TUnmodifiableDoubleByteMap;
import gnu.trove.impl.unmodifiable.TUnmodifiableDoubleCharMap;
import gnu.trove.impl.unmodifiable.TUnmodifiableDoubleCollection;
import gnu.trove.impl.unmodifiable.TUnmodifiableDoubleDoubleMap;
import gnu.trove.impl.unmodifiable.TUnmodifiableDoubleFloatMap;
import gnu.trove.impl.unmodifiable.TUnmodifiableDoubleIntMap;
import gnu.trove.impl.unmodifiable.TUnmodifiableDoubleList;
import gnu.trove.impl.unmodifiable.TUnmodifiableDoubleLongMap;
import gnu.trove.impl.unmodifiable.TUnmodifiableDoubleObjectMap;
import gnu.trove.impl.unmodifiable.TUnmodifiableDoubleSet;
import gnu.trove.impl.unmodifiable.TUnmodifiableDoubleShortMap;
import gnu.trove.impl.unmodifiable.TUnmodifiableFloatByteMap;
import gnu.trove.impl.unmodifiable.TUnmodifiableFloatCharMap;
import gnu.trove.impl.unmodifiable.TUnmodifiableFloatCollection;
import gnu.trove.impl.unmodifiable.TUnmodifiableFloatDoubleMap;
import gnu.trove.impl.unmodifiable.TUnmodifiableFloatFloatMap;
import gnu.trove.impl.unmodifiable.TUnmodifiableFloatIntMap;
import gnu.trove.impl.unmodifiable.TUnmodifiableFloatList;
import gnu.trove.impl.unmodifiable.TUnmodifiableFloatLongMap;
import gnu.trove.impl.unmodifiable.TUnmodifiableFloatObjectMap;
import gnu.trove.impl.unmodifiable.TUnmodifiableFloatSet;
import gnu.trove.impl.unmodifiable.TUnmodifiableFloatShortMap;
import gnu.trove.impl.unmodifiable.TUnmodifiableIntByteMap;
import gnu.trove.impl.unmodifiable.TUnmodifiableIntCharMap;
import gnu.trove.impl.unmodifiable.TUnmodifiableIntCollection;
import gnu.trove.impl.unmodifiable.TUnmodifiableIntDoubleMap;
import gnu.trove.impl.unmodifiable.TUnmodifiableIntFloatMap;
import gnu.trove.impl.unmodifiable.TUnmodifiableIntIntMap;
import gnu.trove.impl.unmodifiable.TUnmodifiableIntList;
import gnu.trove.impl.unmodifiable.TUnmodifiableIntLongMap;
import gnu.trove.impl.unmodifiable.TUnmodifiableIntObjectMap;
import gnu.trove.impl.unmodifiable.TUnmodifiableIntSet;
import gnu.trove.impl.unmodifiable.TUnmodifiableIntShortMap;
import gnu.trove.impl.unmodifiable.TUnmodifiableLongByteMap;
import gnu.trove.impl.unmodifiable.TUnmodifiableLongCharMap;
import gnu.trove.impl.unmodifiable.TUnmodifiableLongCollection;
import gnu.trove.impl.unmodifiable.TUnmodifiableLongDoubleMap;
import gnu.trove.impl.unmodifiable.TUnmodifiableLongFloatMap;
import gnu.trove.impl.unmodifiable.TUnmodifiableLongIntMap;
import gnu.trove.impl.unmodifiable.TUnmodifiableLongList;
import gnu.trove.impl.unmodifiable.TUnmodifiableLongLongMap;
import gnu.trove.impl.unmodifiable.TUnmodifiableLongObjectMap;
import gnu.trove.impl.unmodifiable.TUnmodifiableLongSet;
import gnu.trove.impl.unmodifiable.TUnmodifiableLongShortMap;
import gnu.trove.impl.unmodifiable.TUnmodifiableObjectByteMap;
import gnu.trove.impl.unmodifiable.TUnmodifiableObjectCharMap;
import gnu.trove.impl.unmodifiable.TUnmodifiableObjectDoubleMap;
import gnu.trove.impl.unmodifiable.TUnmodifiableObjectFloatMap;
import gnu.trove.impl.unmodifiable.TUnmodifiableObjectIntMap;
import gnu.trove.impl.unmodifiable.TUnmodifiableObjectLongMap;
import gnu.trove.impl.unmodifiable.TUnmodifiableObjectShortMap;
import gnu.trove.impl.unmodifiable.TUnmodifiableRandomAccessByteList;
import gnu.trove.impl.unmodifiable.TUnmodifiableRandomAccessCharList;
import gnu.trove.impl.unmodifiable.TUnmodifiableRandomAccessDoubleList;
import gnu.trove.impl.unmodifiable.TUnmodifiableRandomAccessFloatList;
import gnu.trove.impl.unmodifiable.TUnmodifiableRandomAccessIntList;
import gnu.trove.impl.unmodifiable.TUnmodifiableRandomAccessLongList;
import gnu.trove.impl.unmodifiable.TUnmodifiableRandomAccessShortList;
import gnu.trove.impl.unmodifiable.TUnmodifiableShortByteMap;
import gnu.trove.impl.unmodifiable.TUnmodifiableShortCharMap;
import gnu.trove.impl.unmodifiable.TUnmodifiableShortCollection;
import gnu.trove.impl.unmodifiable.TUnmodifiableShortDoubleMap;
import gnu.trove.impl.unmodifiable.TUnmodifiableShortFloatMap;
import gnu.trove.impl.unmodifiable.TUnmodifiableShortIntMap;
import gnu.trove.impl.unmodifiable.TUnmodifiableShortList;
import gnu.trove.impl.unmodifiable.TUnmodifiableShortLongMap;
import gnu.trove.impl.unmodifiable.TUnmodifiableShortObjectMap;
import gnu.trove.impl.unmodifiable.TUnmodifiableShortSet;
import gnu.trove.impl.unmodifiable.TUnmodifiableShortShortMap;
import gnu.trove.list.TByteList;
import gnu.trove.list.TCharList;
import gnu.trove.list.TDoubleList;
import gnu.trove.list.TFloatList;
import gnu.trove.list.TIntList;
import gnu.trove.list.TLongList;
import gnu.trove.list.TShortList;
import gnu.trove.map.TByteByteMap;
import gnu.trove.map.TByteCharMap;
import gnu.trove.map.TByteDoubleMap;
import gnu.trove.map.TByteFloatMap;
import gnu.trove.map.TByteIntMap;
import gnu.trove.map.TByteLongMap;
import gnu.trove.map.TByteObjectMap;
import gnu.trove.map.TByteShortMap;
import gnu.trove.map.TCharByteMap;
import gnu.trove.map.TCharCharMap;
import gnu.trove.map.TCharDoubleMap;
import gnu.trove.map.TCharFloatMap;
import gnu.trove.map.TCharIntMap;
import gnu.trove.map.TCharLongMap;
import gnu.trove.map.TCharObjectMap;
import gnu.trove.map.TCharShortMap;
import gnu.trove.map.TDoubleByteMap;
import gnu.trove.map.TDoubleCharMap;
import gnu.trove.map.TDoubleDoubleMap;
import gnu.trove.map.TDoubleFloatMap;
import gnu.trove.map.TDoubleIntMap;
import gnu.trove.map.TDoubleLongMap;
import gnu.trove.map.TDoubleObjectMap;
import gnu.trove.map.TDoubleShortMap;
import gnu.trove.map.TFloatByteMap;
import gnu.trove.map.TFloatCharMap;
import gnu.trove.map.TFloatDoubleMap;
import gnu.trove.map.TFloatFloatMap;
import gnu.trove.map.TFloatIntMap;
import gnu.trove.map.TFloatLongMap;
import gnu.trove.map.TFloatObjectMap;
import gnu.trove.map.TFloatShortMap;
import gnu.trove.map.TIntByteMap;
import gnu.trove.map.TIntCharMap;
import gnu.trove.map.TIntDoubleMap;
import gnu.trove.map.TIntFloatMap;
import gnu.trove.map.TIntIntMap;
import gnu.trove.map.TIntLongMap;
import gnu.trove.map.TIntObjectMap;
import gnu.trove.map.TIntShortMap;
import gnu.trove.map.TLongByteMap;
import gnu.trove.map.TLongCharMap;
import gnu.trove.map.TLongDoubleMap;
import gnu.trove.map.TLongFloatMap;
import gnu.trove.map.TLongIntMap;
import gnu.trove.map.TLongLongMap;
import gnu.trove.map.TLongObjectMap;
import gnu.trove.map.TLongShortMap;
import gnu.trove.map.TObjectByteMap;
import gnu.trove.map.TObjectCharMap;
import gnu.trove.map.TObjectDoubleMap;
import gnu.trove.map.TObjectFloatMap;
import gnu.trove.map.TObjectIntMap;
import gnu.trove.map.TObjectLongMap;
import gnu.trove.map.TObjectShortMap;
import gnu.trove.map.TShortByteMap;
import gnu.trove.map.TShortCharMap;
import gnu.trove.map.TShortDoubleMap;
import gnu.trove.map.TShortFloatMap;
import gnu.trove.map.TShortIntMap;
import gnu.trove.map.TShortLongMap;
import gnu.trove.map.TShortObjectMap;
import gnu.trove.map.TShortShortMap;
import gnu.trove.set.TByteSet;
import gnu.trove.set.TCharSet;
import gnu.trove.set.TDoubleSet;
import gnu.trove.set.TFloatSet;
import gnu.trove.set.TIntSet;
import gnu.trove.set.TLongSet;
import gnu.trove.set.TShortSet;
import java.util.RandomAccess;

/* loaded from: classes3.dex */
public class TCollections {
    private TCollections() {
    }

    public static TDoubleCollection unmodifiableCollection(TDoubleCollection tDoubleCollection) {
        return new TUnmodifiableDoubleCollection(tDoubleCollection);
    }

    public static TFloatCollection unmodifiableCollection(TFloatCollection tFloatCollection) {
        return new TUnmodifiableFloatCollection(tFloatCollection);
    }

    public static TIntCollection unmodifiableCollection(TIntCollection tIntCollection) {
        return new TUnmodifiableIntCollection(tIntCollection);
    }

    public static TLongCollection unmodifiableCollection(TLongCollection tLongCollection) {
        return new TUnmodifiableLongCollection(tLongCollection);
    }

    public static TByteCollection unmodifiableCollection(TByteCollection tByteCollection) {
        return new TUnmodifiableByteCollection(tByteCollection);
    }

    public static TShortCollection unmodifiableCollection(TShortCollection tShortCollection) {
        return new TUnmodifiableShortCollection(tShortCollection);
    }

    public static TCharCollection unmodifiableCollection(TCharCollection tCharCollection) {
        return new TUnmodifiableCharCollection(tCharCollection);
    }

    public static TDoubleSet unmodifiableSet(TDoubleSet tDoubleSet) {
        return new TUnmodifiableDoubleSet(tDoubleSet);
    }

    public static TFloatSet unmodifiableSet(TFloatSet tFloatSet) {
        return new TUnmodifiableFloatSet(tFloatSet);
    }

    public static TIntSet unmodifiableSet(TIntSet tIntSet) {
        return new TUnmodifiableIntSet(tIntSet);
    }

    public static TLongSet unmodifiableSet(TLongSet tLongSet) {
        return new TUnmodifiableLongSet(tLongSet);
    }

    public static TByteSet unmodifiableSet(TByteSet tByteSet) {
        return new TUnmodifiableByteSet(tByteSet);
    }

    public static TShortSet unmodifiableSet(TShortSet tShortSet) {
        return new TUnmodifiableShortSet(tShortSet);
    }

    public static TCharSet unmodifiableSet(TCharSet tCharSet) {
        return new TUnmodifiableCharSet(tCharSet);
    }

    public static TDoubleList unmodifiableList(TDoubleList tDoubleList) {
        return tDoubleList instanceof RandomAccess ? new TUnmodifiableRandomAccessDoubleList(tDoubleList) : new TUnmodifiableDoubleList(tDoubleList);
    }

    public static TFloatList unmodifiableList(TFloatList tFloatList) {
        return tFloatList instanceof RandomAccess ? new TUnmodifiableRandomAccessFloatList(tFloatList) : new TUnmodifiableFloatList(tFloatList);
    }

    public static TIntList unmodifiableList(TIntList tIntList) {
        return tIntList instanceof RandomAccess ? new TUnmodifiableRandomAccessIntList(tIntList) : new TUnmodifiableIntList(tIntList);
    }

    public static TLongList unmodifiableList(TLongList tLongList) {
        return tLongList instanceof RandomAccess ? new TUnmodifiableRandomAccessLongList(tLongList) : new TUnmodifiableLongList(tLongList);
    }

    public static TByteList unmodifiableList(TByteList tByteList) {
        return tByteList instanceof RandomAccess ? new TUnmodifiableRandomAccessByteList(tByteList) : new TUnmodifiableByteList(tByteList);
    }

    public static TShortList unmodifiableList(TShortList tShortList) {
        return tShortList instanceof RandomAccess ? new TUnmodifiableRandomAccessShortList(tShortList) : new TUnmodifiableShortList(tShortList);
    }

    public static TCharList unmodifiableList(TCharList tCharList) {
        return tCharList instanceof RandomAccess ? new TUnmodifiableRandomAccessCharList(tCharList) : new TUnmodifiableCharList(tCharList);
    }

    public static TDoubleDoubleMap unmodifiableMap(TDoubleDoubleMap tDoubleDoubleMap) {
        return new TUnmodifiableDoubleDoubleMap(tDoubleDoubleMap);
    }

    public static TDoubleFloatMap unmodifiableMap(TDoubleFloatMap tDoubleFloatMap) {
        return new TUnmodifiableDoubleFloatMap(tDoubleFloatMap);
    }

    public static TDoubleIntMap unmodifiableMap(TDoubleIntMap tDoubleIntMap) {
        return new TUnmodifiableDoubleIntMap(tDoubleIntMap);
    }

    public static TDoubleLongMap unmodifiableMap(TDoubleLongMap tDoubleLongMap) {
        return new TUnmodifiableDoubleLongMap(tDoubleLongMap);
    }

    public static TDoubleByteMap unmodifiableMap(TDoubleByteMap tDoubleByteMap) {
        return new TUnmodifiableDoubleByteMap(tDoubleByteMap);
    }

    public static TDoubleShortMap unmodifiableMap(TDoubleShortMap tDoubleShortMap) {
        return new TUnmodifiableDoubleShortMap(tDoubleShortMap);
    }

    public static TDoubleCharMap unmodifiableMap(TDoubleCharMap tDoubleCharMap) {
        return new TUnmodifiableDoubleCharMap(tDoubleCharMap);
    }

    public static TFloatDoubleMap unmodifiableMap(TFloatDoubleMap tFloatDoubleMap) {
        return new TUnmodifiableFloatDoubleMap(tFloatDoubleMap);
    }

    public static TFloatFloatMap unmodifiableMap(TFloatFloatMap tFloatFloatMap) {
        return new TUnmodifiableFloatFloatMap(tFloatFloatMap);
    }

    public static TFloatIntMap unmodifiableMap(TFloatIntMap tFloatIntMap) {
        return new TUnmodifiableFloatIntMap(tFloatIntMap);
    }

    public static TFloatLongMap unmodifiableMap(TFloatLongMap tFloatLongMap) {
        return new TUnmodifiableFloatLongMap(tFloatLongMap);
    }

    public static TFloatByteMap unmodifiableMap(TFloatByteMap tFloatByteMap) {
        return new TUnmodifiableFloatByteMap(tFloatByteMap);
    }

    public static TFloatShortMap unmodifiableMap(TFloatShortMap tFloatShortMap) {
        return new TUnmodifiableFloatShortMap(tFloatShortMap);
    }

    public static TFloatCharMap unmodifiableMap(TFloatCharMap tFloatCharMap) {
        return new TUnmodifiableFloatCharMap(tFloatCharMap);
    }

    public static TIntDoubleMap unmodifiableMap(TIntDoubleMap tIntDoubleMap) {
        return new TUnmodifiableIntDoubleMap(tIntDoubleMap);
    }

    public static TIntFloatMap unmodifiableMap(TIntFloatMap tIntFloatMap) {
        return new TUnmodifiableIntFloatMap(tIntFloatMap);
    }

    public static TIntIntMap unmodifiableMap(TIntIntMap tIntIntMap) {
        return new TUnmodifiableIntIntMap(tIntIntMap);
    }

    public static TIntLongMap unmodifiableMap(TIntLongMap tIntLongMap) {
        return new TUnmodifiableIntLongMap(tIntLongMap);
    }

    public static TIntByteMap unmodifiableMap(TIntByteMap tIntByteMap) {
        return new TUnmodifiableIntByteMap(tIntByteMap);
    }

    public static TIntShortMap unmodifiableMap(TIntShortMap tIntShortMap) {
        return new TUnmodifiableIntShortMap(tIntShortMap);
    }

    public static TIntCharMap unmodifiableMap(TIntCharMap tIntCharMap) {
        return new TUnmodifiableIntCharMap(tIntCharMap);
    }

    public static TLongDoubleMap unmodifiableMap(TLongDoubleMap tLongDoubleMap) {
        return new TUnmodifiableLongDoubleMap(tLongDoubleMap);
    }

    public static TLongFloatMap unmodifiableMap(TLongFloatMap tLongFloatMap) {
        return new TUnmodifiableLongFloatMap(tLongFloatMap);
    }

    public static TLongIntMap unmodifiableMap(TLongIntMap tLongIntMap) {
        return new TUnmodifiableLongIntMap(tLongIntMap);
    }

    public static TLongLongMap unmodifiableMap(TLongLongMap tLongLongMap) {
        return new TUnmodifiableLongLongMap(tLongLongMap);
    }

    public static TLongByteMap unmodifiableMap(TLongByteMap tLongByteMap) {
        return new TUnmodifiableLongByteMap(tLongByteMap);
    }

    public static TLongShortMap unmodifiableMap(TLongShortMap tLongShortMap) {
        return new TUnmodifiableLongShortMap(tLongShortMap);
    }

    public static TLongCharMap unmodifiableMap(TLongCharMap tLongCharMap) {
        return new TUnmodifiableLongCharMap(tLongCharMap);
    }

    public static TByteDoubleMap unmodifiableMap(TByteDoubleMap tByteDoubleMap) {
        return new TUnmodifiableByteDoubleMap(tByteDoubleMap);
    }

    public static TByteFloatMap unmodifiableMap(TByteFloatMap tByteFloatMap) {
        return new TUnmodifiableByteFloatMap(tByteFloatMap);
    }

    public static TByteIntMap unmodifiableMap(TByteIntMap tByteIntMap) {
        return new TUnmodifiableByteIntMap(tByteIntMap);
    }

    public static TByteLongMap unmodifiableMap(TByteLongMap tByteLongMap) {
        return new TUnmodifiableByteLongMap(tByteLongMap);
    }

    public static TByteByteMap unmodifiableMap(TByteByteMap tByteByteMap) {
        return new TUnmodifiableByteByteMap(tByteByteMap);
    }

    public static TByteShortMap unmodifiableMap(TByteShortMap tByteShortMap) {
        return new TUnmodifiableByteShortMap(tByteShortMap);
    }

    public static TByteCharMap unmodifiableMap(TByteCharMap tByteCharMap) {
        return new TUnmodifiableByteCharMap(tByteCharMap);
    }

    public static TShortDoubleMap unmodifiableMap(TShortDoubleMap tShortDoubleMap) {
        return new TUnmodifiableShortDoubleMap(tShortDoubleMap);
    }

    public static TShortFloatMap unmodifiableMap(TShortFloatMap tShortFloatMap) {
        return new TUnmodifiableShortFloatMap(tShortFloatMap);
    }

    public static TShortIntMap unmodifiableMap(TShortIntMap tShortIntMap) {
        return new TUnmodifiableShortIntMap(tShortIntMap);
    }

    public static TShortLongMap unmodifiableMap(TShortLongMap tShortLongMap) {
        return new TUnmodifiableShortLongMap(tShortLongMap);
    }

    public static TShortByteMap unmodifiableMap(TShortByteMap tShortByteMap) {
        return new TUnmodifiableShortByteMap(tShortByteMap);
    }

    public static TShortShortMap unmodifiableMap(TShortShortMap tShortShortMap) {
        return new TUnmodifiableShortShortMap(tShortShortMap);
    }

    public static TShortCharMap unmodifiableMap(TShortCharMap tShortCharMap) {
        return new TUnmodifiableShortCharMap(tShortCharMap);
    }

    public static TCharDoubleMap unmodifiableMap(TCharDoubleMap tCharDoubleMap) {
        return new TUnmodifiableCharDoubleMap(tCharDoubleMap);
    }

    public static TCharFloatMap unmodifiableMap(TCharFloatMap tCharFloatMap) {
        return new TUnmodifiableCharFloatMap(tCharFloatMap);
    }

    public static TCharIntMap unmodifiableMap(TCharIntMap tCharIntMap) {
        return new TUnmodifiableCharIntMap(tCharIntMap);
    }

    public static TCharLongMap unmodifiableMap(TCharLongMap tCharLongMap) {
        return new TUnmodifiableCharLongMap(tCharLongMap);
    }

    public static TCharByteMap unmodifiableMap(TCharByteMap tCharByteMap) {
        return new TUnmodifiableCharByteMap(tCharByteMap);
    }

    public static TCharShortMap unmodifiableMap(TCharShortMap tCharShortMap) {
        return new TUnmodifiableCharShortMap(tCharShortMap);
    }

    public static TCharCharMap unmodifiableMap(TCharCharMap tCharCharMap) {
        return new TUnmodifiableCharCharMap(tCharCharMap);
    }

    public static <V> TDoubleObjectMap<V> unmodifiableMap(TDoubleObjectMap<V> tDoubleObjectMap) {
        return new TUnmodifiableDoubleObjectMap(tDoubleObjectMap);
    }

    public static <V> TFloatObjectMap<V> unmodifiableMap(TFloatObjectMap<V> tFloatObjectMap) {
        return new TUnmodifiableFloatObjectMap(tFloatObjectMap);
    }

    public static <V> TIntObjectMap<V> unmodifiableMap(TIntObjectMap<V> tIntObjectMap) {
        return new TUnmodifiableIntObjectMap(tIntObjectMap);
    }

    public static <V> TLongObjectMap<V> unmodifiableMap(TLongObjectMap<V> tLongObjectMap) {
        return new TUnmodifiableLongObjectMap(tLongObjectMap);
    }

    public static <V> TByteObjectMap<V> unmodifiableMap(TByteObjectMap<V> tByteObjectMap) {
        return new TUnmodifiableByteObjectMap(tByteObjectMap);
    }

    public static <V> TShortObjectMap<V> unmodifiableMap(TShortObjectMap<V> tShortObjectMap) {
        return new TUnmodifiableShortObjectMap(tShortObjectMap);
    }

    public static <V> TCharObjectMap<V> unmodifiableMap(TCharObjectMap<V> tCharObjectMap) {
        return new TUnmodifiableCharObjectMap(tCharObjectMap);
    }

    public static <K> TObjectDoubleMap<K> unmodifiableMap(TObjectDoubleMap<K> tObjectDoubleMap) {
        return new TUnmodifiableObjectDoubleMap(tObjectDoubleMap);
    }

    public static <K> TObjectFloatMap<K> unmodifiableMap(TObjectFloatMap<K> tObjectFloatMap) {
        return new TUnmodifiableObjectFloatMap(tObjectFloatMap);
    }

    public static <K> TObjectIntMap<K> unmodifiableMap(TObjectIntMap<K> tObjectIntMap) {
        return new TUnmodifiableObjectIntMap(tObjectIntMap);
    }

    public static <K> TObjectLongMap<K> unmodifiableMap(TObjectLongMap<K> tObjectLongMap) {
        return new TUnmodifiableObjectLongMap(tObjectLongMap);
    }

    public static <K> TObjectByteMap<K> unmodifiableMap(TObjectByteMap<K> tObjectByteMap) {
        return new TUnmodifiableObjectByteMap(tObjectByteMap);
    }

    public static <K> TObjectShortMap<K> unmodifiableMap(TObjectShortMap<K> tObjectShortMap) {
        return new TUnmodifiableObjectShortMap(tObjectShortMap);
    }

    public static <K> TObjectCharMap<K> unmodifiableMap(TObjectCharMap<K> tObjectCharMap) {
        return new TUnmodifiableObjectCharMap(tObjectCharMap);
    }

    public static TDoubleCollection synchronizedCollection(TDoubleCollection tDoubleCollection) {
        return new TSynchronizedDoubleCollection(tDoubleCollection);
    }

    static TDoubleCollection synchronizedCollection(TDoubleCollection tDoubleCollection, Object obj) {
        return new TSynchronizedDoubleCollection(tDoubleCollection, obj);
    }

    public static TFloatCollection synchronizedCollection(TFloatCollection tFloatCollection) {
        return new TSynchronizedFloatCollection(tFloatCollection);
    }

    static TFloatCollection synchronizedCollection(TFloatCollection tFloatCollection, Object obj) {
        return new TSynchronizedFloatCollection(tFloatCollection, obj);
    }

    public static TIntCollection synchronizedCollection(TIntCollection tIntCollection) {
        return new TSynchronizedIntCollection(tIntCollection);
    }

    static TIntCollection synchronizedCollection(TIntCollection tIntCollection, Object obj) {
        return new TSynchronizedIntCollection(tIntCollection, obj);
    }

    public static TLongCollection synchronizedCollection(TLongCollection tLongCollection) {
        return new TSynchronizedLongCollection(tLongCollection);
    }

    static TLongCollection synchronizedCollection(TLongCollection tLongCollection, Object obj) {
        return new TSynchronizedLongCollection(tLongCollection, obj);
    }

    public static TByteCollection synchronizedCollection(TByteCollection tByteCollection) {
        return new TSynchronizedByteCollection(tByteCollection);
    }

    static TByteCollection synchronizedCollection(TByteCollection tByteCollection, Object obj) {
        return new TSynchronizedByteCollection(tByteCollection, obj);
    }

    public static TShortCollection synchronizedCollection(TShortCollection tShortCollection) {
        return new TSynchronizedShortCollection(tShortCollection);
    }

    static TShortCollection synchronizedCollection(TShortCollection tShortCollection, Object obj) {
        return new TSynchronizedShortCollection(tShortCollection, obj);
    }

    public static TCharCollection synchronizedCollection(TCharCollection tCharCollection) {
        return new TSynchronizedCharCollection(tCharCollection);
    }

    static TCharCollection synchronizedCollection(TCharCollection tCharCollection, Object obj) {
        return new TSynchronizedCharCollection(tCharCollection, obj);
    }

    public static TDoubleSet synchronizedSet(TDoubleSet tDoubleSet) {
        return new TSynchronizedDoubleSet(tDoubleSet);
    }

    static TDoubleSet synchronizedSet(TDoubleSet tDoubleSet, Object obj) {
        return new TSynchronizedDoubleSet(tDoubleSet, obj);
    }

    public static TFloatSet synchronizedSet(TFloatSet tFloatSet) {
        return new TSynchronizedFloatSet(tFloatSet);
    }

    static TFloatSet synchronizedSet(TFloatSet tFloatSet, Object obj) {
        return new TSynchronizedFloatSet(tFloatSet, obj);
    }

    public static TIntSet synchronizedSet(TIntSet tIntSet) {
        return new TSynchronizedIntSet(tIntSet);
    }

    static TIntSet synchronizedSet(TIntSet tIntSet, Object obj) {
        return new TSynchronizedIntSet(tIntSet, obj);
    }

    public static TLongSet synchronizedSet(TLongSet tLongSet) {
        return new TSynchronizedLongSet(tLongSet);
    }

    static TLongSet synchronizedSet(TLongSet tLongSet, Object obj) {
        return new TSynchronizedLongSet(tLongSet, obj);
    }

    public static TByteSet synchronizedSet(TByteSet tByteSet) {
        return new TSynchronizedByteSet(tByteSet);
    }

    static TByteSet synchronizedSet(TByteSet tByteSet, Object obj) {
        return new TSynchronizedByteSet(tByteSet, obj);
    }

    public static TShortSet synchronizedSet(TShortSet tShortSet) {
        return new TSynchronizedShortSet(tShortSet);
    }

    static TShortSet synchronizedSet(TShortSet tShortSet, Object obj) {
        return new TSynchronizedShortSet(tShortSet, obj);
    }

    public static TCharSet synchronizedSet(TCharSet tCharSet) {
        return new TSynchronizedCharSet(tCharSet);
    }

    static TCharSet synchronizedSet(TCharSet tCharSet, Object obj) {
        return new TSynchronizedCharSet(tCharSet, obj);
    }

    public static TDoubleList synchronizedList(TDoubleList tDoubleList) {
        return tDoubleList instanceof RandomAccess ? new TSynchronizedRandomAccessDoubleList(tDoubleList) : new TSynchronizedDoubleList(tDoubleList);
    }

    static TDoubleList synchronizedList(TDoubleList tDoubleList, Object obj) {
        return tDoubleList instanceof RandomAccess ? new TSynchronizedRandomAccessDoubleList(tDoubleList, obj) : new TSynchronizedDoubleList(tDoubleList, obj);
    }

    public static TFloatList synchronizedList(TFloatList tFloatList) {
        return tFloatList instanceof RandomAccess ? new TSynchronizedRandomAccessFloatList(tFloatList) : new TSynchronizedFloatList(tFloatList);
    }

    static TFloatList synchronizedList(TFloatList tFloatList, Object obj) {
        return tFloatList instanceof RandomAccess ? new TSynchronizedRandomAccessFloatList(tFloatList, obj) : new TSynchronizedFloatList(tFloatList, obj);
    }

    public static TIntList synchronizedList(TIntList tIntList) {
        return tIntList instanceof RandomAccess ? new TSynchronizedRandomAccessIntList(tIntList) : new TSynchronizedIntList(tIntList);
    }

    static TIntList synchronizedList(TIntList tIntList, Object obj) {
        return tIntList instanceof RandomAccess ? new TSynchronizedRandomAccessIntList(tIntList, obj) : new TSynchronizedIntList(tIntList, obj);
    }

    public static TLongList synchronizedList(TLongList tLongList) {
        return tLongList instanceof RandomAccess ? new TSynchronizedRandomAccessLongList(tLongList) : new TSynchronizedLongList(tLongList);
    }

    static TLongList synchronizedList(TLongList tLongList, Object obj) {
        return tLongList instanceof RandomAccess ? new TSynchronizedRandomAccessLongList(tLongList, obj) : new TSynchronizedLongList(tLongList, obj);
    }

    public static TByteList synchronizedList(TByteList tByteList) {
        return tByteList instanceof RandomAccess ? new TSynchronizedRandomAccessByteList(tByteList) : new TSynchronizedByteList(tByteList);
    }

    static TByteList synchronizedList(TByteList tByteList, Object obj) {
        return tByteList instanceof RandomAccess ? new TSynchronizedRandomAccessByteList(tByteList, obj) : new TSynchronizedByteList(tByteList, obj);
    }

    public static TShortList synchronizedList(TShortList tShortList) {
        return tShortList instanceof RandomAccess ? new TSynchronizedRandomAccessShortList(tShortList) : new TSynchronizedShortList(tShortList);
    }

    static TShortList synchronizedList(TShortList tShortList, Object obj) {
        return tShortList instanceof RandomAccess ? new TSynchronizedRandomAccessShortList(tShortList, obj) : new TSynchronizedShortList(tShortList, obj);
    }

    public static TCharList synchronizedList(TCharList tCharList) {
        return tCharList instanceof RandomAccess ? new TSynchronizedRandomAccessCharList(tCharList) : new TSynchronizedCharList(tCharList);
    }

    static TCharList synchronizedList(TCharList tCharList, Object obj) {
        return tCharList instanceof RandomAccess ? new TSynchronizedRandomAccessCharList(tCharList, obj) : new TSynchronizedCharList(tCharList, obj);
    }

    public static TDoubleDoubleMap synchronizedMap(TDoubleDoubleMap tDoubleDoubleMap) {
        return new TSynchronizedDoubleDoubleMap(tDoubleDoubleMap);
    }

    public static TDoubleFloatMap synchronizedMap(TDoubleFloatMap tDoubleFloatMap) {
        return new TSynchronizedDoubleFloatMap(tDoubleFloatMap);
    }

    public static TDoubleIntMap synchronizedMap(TDoubleIntMap tDoubleIntMap) {
        return new TSynchronizedDoubleIntMap(tDoubleIntMap);
    }

    public static TDoubleLongMap synchronizedMap(TDoubleLongMap tDoubleLongMap) {
        return new TSynchronizedDoubleLongMap(tDoubleLongMap);
    }

    public static TDoubleByteMap synchronizedMap(TDoubleByteMap tDoubleByteMap) {
        return new TSynchronizedDoubleByteMap(tDoubleByteMap);
    }

    public static TDoubleShortMap synchronizedMap(TDoubleShortMap tDoubleShortMap) {
        return new TSynchronizedDoubleShortMap(tDoubleShortMap);
    }

    public static TDoubleCharMap synchronizedMap(TDoubleCharMap tDoubleCharMap) {
        return new TSynchronizedDoubleCharMap(tDoubleCharMap);
    }

    public static TFloatDoubleMap synchronizedMap(TFloatDoubleMap tFloatDoubleMap) {
        return new TSynchronizedFloatDoubleMap(tFloatDoubleMap);
    }

    public static TFloatFloatMap synchronizedMap(TFloatFloatMap tFloatFloatMap) {
        return new TSynchronizedFloatFloatMap(tFloatFloatMap);
    }

    public static TFloatIntMap synchronizedMap(TFloatIntMap tFloatIntMap) {
        return new TSynchronizedFloatIntMap(tFloatIntMap);
    }

    public static TFloatLongMap synchronizedMap(TFloatLongMap tFloatLongMap) {
        return new TSynchronizedFloatLongMap(tFloatLongMap);
    }

    public static TFloatByteMap synchronizedMap(TFloatByteMap tFloatByteMap) {
        return new TSynchronizedFloatByteMap(tFloatByteMap);
    }

    public static TFloatShortMap synchronizedMap(TFloatShortMap tFloatShortMap) {
        return new TSynchronizedFloatShortMap(tFloatShortMap);
    }

    public static TFloatCharMap synchronizedMap(TFloatCharMap tFloatCharMap) {
        return new TSynchronizedFloatCharMap(tFloatCharMap);
    }

    public static TIntDoubleMap synchronizedMap(TIntDoubleMap tIntDoubleMap) {
        return new TSynchronizedIntDoubleMap(tIntDoubleMap);
    }

    public static TIntFloatMap synchronizedMap(TIntFloatMap tIntFloatMap) {
        return new TSynchronizedIntFloatMap(tIntFloatMap);
    }

    public static TIntIntMap synchronizedMap(TIntIntMap tIntIntMap) {
        return new TSynchronizedIntIntMap(tIntIntMap);
    }

    public static TIntLongMap synchronizedMap(TIntLongMap tIntLongMap) {
        return new TSynchronizedIntLongMap(tIntLongMap);
    }

    public static TIntByteMap synchronizedMap(TIntByteMap tIntByteMap) {
        return new TSynchronizedIntByteMap(tIntByteMap);
    }

    public static TIntShortMap synchronizedMap(TIntShortMap tIntShortMap) {
        return new TSynchronizedIntShortMap(tIntShortMap);
    }

    public static TIntCharMap synchronizedMap(TIntCharMap tIntCharMap) {
        return new TSynchronizedIntCharMap(tIntCharMap);
    }

    public static TLongDoubleMap synchronizedMap(TLongDoubleMap tLongDoubleMap) {
        return new TSynchronizedLongDoubleMap(tLongDoubleMap);
    }

    public static TLongFloatMap synchronizedMap(TLongFloatMap tLongFloatMap) {
        return new TSynchronizedLongFloatMap(tLongFloatMap);
    }

    public static TLongIntMap synchronizedMap(TLongIntMap tLongIntMap) {
        return new TSynchronizedLongIntMap(tLongIntMap);
    }

    public static TLongLongMap synchronizedMap(TLongLongMap tLongLongMap) {
        return new TSynchronizedLongLongMap(tLongLongMap);
    }

    public static TLongByteMap synchronizedMap(TLongByteMap tLongByteMap) {
        return new TSynchronizedLongByteMap(tLongByteMap);
    }

    public static TLongShortMap synchronizedMap(TLongShortMap tLongShortMap) {
        return new TSynchronizedLongShortMap(tLongShortMap);
    }

    public static TLongCharMap synchronizedMap(TLongCharMap tLongCharMap) {
        return new TSynchronizedLongCharMap(tLongCharMap);
    }

    public static TByteDoubleMap synchronizedMap(TByteDoubleMap tByteDoubleMap) {
        return new TSynchronizedByteDoubleMap(tByteDoubleMap);
    }

    public static TByteFloatMap synchronizedMap(TByteFloatMap tByteFloatMap) {
        return new TSynchronizedByteFloatMap(tByteFloatMap);
    }

    public static TByteIntMap synchronizedMap(TByteIntMap tByteIntMap) {
        return new TSynchronizedByteIntMap(tByteIntMap);
    }

    public static TByteLongMap synchronizedMap(TByteLongMap tByteLongMap) {
        return new TSynchronizedByteLongMap(tByteLongMap);
    }

    public static TByteByteMap synchronizedMap(TByteByteMap tByteByteMap) {
        return new TSynchronizedByteByteMap(tByteByteMap);
    }

    public static TByteShortMap synchronizedMap(TByteShortMap tByteShortMap) {
        return new TSynchronizedByteShortMap(tByteShortMap);
    }

    public static TByteCharMap synchronizedMap(TByteCharMap tByteCharMap) {
        return new TSynchronizedByteCharMap(tByteCharMap);
    }

    public static TShortDoubleMap synchronizedMap(TShortDoubleMap tShortDoubleMap) {
        return new TSynchronizedShortDoubleMap(tShortDoubleMap);
    }

    public static TShortFloatMap synchronizedMap(TShortFloatMap tShortFloatMap) {
        return new TSynchronizedShortFloatMap(tShortFloatMap);
    }

    public static TShortIntMap synchronizedMap(TShortIntMap tShortIntMap) {
        return new TSynchronizedShortIntMap(tShortIntMap);
    }

    public static TShortLongMap synchronizedMap(TShortLongMap tShortLongMap) {
        return new TSynchronizedShortLongMap(tShortLongMap);
    }

    public static TShortByteMap synchronizedMap(TShortByteMap tShortByteMap) {
        return new TSynchronizedShortByteMap(tShortByteMap);
    }

    public static TShortShortMap synchronizedMap(TShortShortMap tShortShortMap) {
        return new TSynchronizedShortShortMap(tShortShortMap);
    }

    public static TShortCharMap synchronizedMap(TShortCharMap tShortCharMap) {
        return new TSynchronizedShortCharMap(tShortCharMap);
    }

    public static TCharDoubleMap synchronizedMap(TCharDoubleMap tCharDoubleMap) {
        return new TSynchronizedCharDoubleMap(tCharDoubleMap);
    }

    public static TCharFloatMap synchronizedMap(TCharFloatMap tCharFloatMap) {
        return new TSynchronizedCharFloatMap(tCharFloatMap);
    }

    public static TCharIntMap synchronizedMap(TCharIntMap tCharIntMap) {
        return new TSynchronizedCharIntMap(tCharIntMap);
    }

    public static TCharLongMap synchronizedMap(TCharLongMap tCharLongMap) {
        return new TSynchronizedCharLongMap(tCharLongMap);
    }

    public static TCharByteMap synchronizedMap(TCharByteMap tCharByteMap) {
        return new TSynchronizedCharByteMap(tCharByteMap);
    }

    public static TCharShortMap synchronizedMap(TCharShortMap tCharShortMap) {
        return new TSynchronizedCharShortMap(tCharShortMap);
    }

    public static TCharCharMap synchronizedMap(TCharCharMap tCharCharMap) {
        return new TSynchronizedCharCharMap(tCharCharMap);
    }

    public static <V> TDoubleObjectMap<V> synchronizedMap(TDoubleObjectMap<V> tDoubleObjectMap) {
        return new TSynchronizedDoubleObjectMap(tDoubleObjectMap);
    }

    public static <V> TFloatObjectMap<V> synchronizedMap(TFloatObjectMap<V> tFloatObjectMap) {
        return new TSynchronizedFloatObjectMap(tFloatObjectMap);
    }

    public static <V> TIntObjectMap<V> synchronizedMap(TIntObjectMap<V> tIntObjectMap) {
        return new TSynchronizedIntObjectMap(tIntObjectMap);
    }

    public static <V> TLongObjectMap<V> synchronizedMap(TLongObjectMap<V> tLongObjectMap) {
        return new TSynchronizedLongObjectMap(tLongObjectMap);
    }

    public static <V> TByteObjectMap<V> synchronizedMap(TByteObjectMap<V> tByteObjectMap) {
        return new TSynchronizedByteObjectMap(tByteObjectMap);
    }

    public static <V> TShortObjectMap<V> synchronizedMap(TShortObjectMap<V> tShortObjectMap) {
        return new TSynchronizedShortObjectMap(tShortObjectMap);
    }

    public static <V> TCharObjectMap<V> synchronizedMap(TCharObjectMap<V> tCharObjectMap) {
        return new TSynchronizedCharObjectMap(tCharObjectMap);
    }

    public static <K> TObjectDoubleMap<K> synchronizedMap(TObjectDoubleMap<K> tObjectDoubleMap) {
        return new TSynchronizedObjectDoubleMap(tObjectDoubleMap);
    }

    public static <K> TObjectFloatMap<K> synchronizedMap(TObjectFloatMap<K> tObjectFloatMap) {
        return new TSynchronizedObjectFloatMap(tObjectFloatMap);
    }

    public static <K> TObjectIntMap<K> synchronizedMap(TObjectIntMap<K> tObjectIntMap) {
        return new TSynchronizedObjectIntMap(tObjectIntMap);
    }

    public static <K> TObjectLongMap<K> synchronizedMap(TObjectLongMap<K> tObjectLongMap) {
        return new TSynchronizedObjectLongMap(tObjectLongMap);
    }

    public static <K> TObjectByteMap<K> synchronizedMap(TObjectByteMap<K> tObjectByteMap) {
        return new TSynchronizedObjectByteMap(tObjectByteMap);
    }

    public static <K> TObjectShortMap<K> synchronizedMap(TObjectShortMap<K> tObjectShortMap) {
        return new TSynchronizedObjectShortMap(tObjectShortMap);
    }

    public static <K> TObjectCharMap<K> synchronizedMap(TObjectCharMap<K> tObjectCharMap) {
        return new TSynchronizedObjectCharMap(tObjectCharMap);
    }
}
