package gnu.trove;

import gnu.trove.decorator.TByteByteMapDecorator;
import gnu.trove.decorator.TByteCharMapDecorator;
import gnu.trove.decorator.TByteDoubleMapDecorator;
import gnu.trove.decorator.TByteFloatMapDecorator;
import gnu.trove.decorator.TByteIntMapDecorator;
import gnu.trove.decorator.TByteListDecorator;
import gnu.trove.decorator.TByteLongMapDecorator;
import gnu.trove.decorator.TByteObjectMapDecorator;
import gnu.trove.decorator.TByteSetDecorator;
import gnu.trove.decorator.TByteShortMapDecorator;
import gnu.trove.decorator.TCharByteMapDecorator;
import gnu.trove.decorator.TCharCharMapDecorator;
import gnu.trove.decorator.TCharDoubleMapDecorator;
import gnu.trove.decorator.TCharFloatMapDecorator;
import gnu.trove.decorator.TCharIntMapDecorator;
import gnu.trove.decorator.TCharListDecorator;
import gnu.trove.decorator.TCharLongMapDecorator;
import gnu.trove.decorator.TCharObjectMapDecorator;
import gnu.trove.decorator.TCharSetDecorator;
import gnu.trove.decorator.TCharShortMapDecorator;
import gnu.trove.decorator.TDoubleByteMapDecorator;
import gnu.trove.decorator.TDoubleCharMapDecorator;
import gnu.trove.decorator.TDoubleDoubleMapDecorator;
import gnu.trove.decorator.TDoubleFloatMapDecorator;
import gnu.trove.decorator.TDoubleIntMapDecorator;
import gnu.trove.decorator.TDoubleListDecorator;
import gnu.trove.decorator.TDoubleLongMapDecorator;
import gnu.trove.decorator.TDoubleObjectMapDecorator;
import gnu.trove.decorator.TDoubleSetDecorator;
import gnu.trove.decorator.TDoubleShortMapDecorator;
import gnu.trove.decorator.TFloatByteMapDecorator;
import gnu.trove.decorator.TFloatCharMapDecorator;
import gnu.trove.decorator.TFloatDoubleMapDecorator;
import gnu.trove.decorator.TFloatFloatMapDecorator;
import gnu.trove.decorator.TFloatIntMapDecorator;
import gnu.trove.decorator.TFloatListDecorator;
import gnu.trove.decorator.TFloatLongMapDecorator;
import gnu.trove.decorator.TFloatObjectMapDecorator;
import gnu.trove.decorator.TFloatSetDecorator;
import gnu.trove.decorator.TFloatShortMapDecorator;
import gnu.trove.decorator.TIntByteMapDecorator;
import gnu.trove.decorator.TIntCharMapDecorator;
import gnu.trove.decorator.TIntDoubleMapDecorator;
import gnu.trove.decorator.TIntFloatMapDecorator;
import gnu.trove.decorator.TIntIntMapDecorator;
import gnu.trove.decorator.TIntListDecorator;
import gnu.trove.decorator.TIntLongMapDecorator;
import gnu.trove.decorator.TIntObjectMapDecorator;
import gnu.trove.decorator.TIntSetDecorator;
import gnu.trove.decorator.TIntShortMapDecorator;
import gnu.trove.decorator.TLongByteMapDecorator;
import gnu.trove.decorator.TLongCharMapDecorator;
import gnu.trove.decorator.TLongDoubleMapDecorator;
import gnu.trove.decorator.TLongFloatMapDecorator;
import gnu.trove.decorator.TLongIntMapDecorator;
import gnu.trove.decorator.TLongListDecorator;
import gnu.trove.decorator.TLongLongMapDecorator;
import gnu.trove.decorator.TLongObjectMapDecorator;
import gnu.trove.decorator.TLongSetDecorator;
import gnu.trove.decorator.TLongShortMapDecorator;
import gnu.trove.decorator.TObjectByteMapDecorator;
import gnu.trove.decorator.TObjectCharMapDecorator;
import gnu.trove.decorator.TObjectDoubleMapDecorator;
import gnu.trove.decorator.TObjectFloatMapDecorator;
import gnu.trove.decorator.TObjectIntMapDecorator;
import gnu.trove.decorator.TObjectLongMapDecorator;
import gnu.trove.decorator.TObjectShortMapDecorator;
import gnu.trove.decorator.TShortByteMapDecorator;
import gnu.trove.decorator.TShortCharMapDecorator;
import gnu.trove.decorator.TShortDoubleMapDecorator;
import gnu.trove.decorator.TShortFloatMapDecorator;
import gnu.trove.decorator.TShortIntMapDecorator;
import gnu.trove.decorator.TShortListDecorator;
import gnu.trove.decorator.TShortLongMapDecorator;
import gnu.trove.decorator.TShortObjectMapDecorator;
import gnu.trove.decorator.TShortSetDecorator;
import gnu.trove.decorator.TShortShortMapDecorator;
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
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public class TDecorators {
    private TDecorators() {
    }

    public static Map<Double, Double> wrap(TDoubleDoubleMap tDoubleDoubleMap) {
        return new TDoubleDoubleMapDecorator(tDoubleDoubleMap);
    }

    public static Map<Double, Float> wrap(TDoubleFloatMap tDoubleFloatMap) {
        return new TDoubleFloatMapDecorator(tDoubleFloatMap);
    }

    public static Map<Double, Integer> wrap(TDoubleIntMap tDoubleIntMap) {
        return new TDoubleIntMapDecorator(tDoubleIntMap);
    }

    public static Map<Double, Long> wrap(TDoubleLongMap tDoubleLongMap) {
        return new TDoubleLongMapDecorator(tDoubleLongMap);
    }

    public static Map<Double, Byte> wrap(TDoubleByteMap tDoubleByteMap) {
        return new TDoubleByteMapDecorator(tDoubleByteMap);
    }

    public static Map<Double, Short> wrap(TDoubleShortMap tDoubleShortMap) {
        return new TDoubleShortMapDecorator(tDoubleShortMap);
    }

    public static Map<Double, Character> wrap(TDoubleCharMap tDoubleCharMap) {
        return new TDoubleCharMapDecorator(tDoubleCharMap);
    }

    public static Map<Float, Double> wrap(TFloatDoubleMap tFloatDoubleMap) {
        return new TFloatDoubleMapDecorator(tFloatDoubleMap);
    }

    public static Map<Float, Float> wrap(TFloatFloatMap tFloatFloatMap) {
        return new TFloatFloatMapDecorator(tFloatFloatMap);
    }

    public static Map<Float, Integer> wrap(TFloatIntMap tFloatIntMap) {
        return new TFloatIntMapDecorator(tFloatIntMap);
    }

    public static Map<Float, Long> wrap(TFloatLongMap tFloatLongMap) {
        return new TFloatLongMapDecorator(tFloatLongMap);
    }

    public static Map<Float, Byte> wrap(TFloatByteMap tFloatByteMap) {
        return new TFloatByteMapDecorator(tFloatByteMap);
    }

    public static Map<Float, Short> wrap(TFloatShortMap tFloatShortMap) {
        return new TFloatShortMapDecorator(tFloatShortMap);
    }

    public static Map<Float, Character> wrap(TFloatCharMap tFloatCharMap) {
        return new TFloatCharMapDecorator(tFloatCharMap);
    }

    public static Map<Integer, Double> wrap(TIntDoubleMap tIntDoubleMap) {
        return new TIntDoubleMapDecorator(tIntDoubleMap);
    }

    public static Map<Integer, Float> wrap(TIntFloatMap tIntFloatMap) {
        return new TIntFloatMapDecorator(tIntFloatMap);
    }

    public static Map<Integer, Integer> wrap(TIntIntMap tIntIntMap) {
        return new TIntIntMapDecorator(tIntIntMap);
    }

    public static Map<Integer, Long> wrap(TIntLongMap tIntLongMap) {
        return new TIntLongMapDecorator(tIntLongMap);
    }

    public static Map<Integer, Byte> wrap(TIntByteMap tIntByteMap) {
        return new TIntByteMapDecorator(tIntByteMap);
    }

    public static Map<Integer, Short> wrap(TIntShortMap tIntShortMap) {
        return new TIntShortMapDecorator(tIntShortMap);
    }

    public static Map<Integer, Character> wrap(TIntCharMap tIntCharMap) {
        return new TIntCharMapDecorator(tIntCharMap);
    }

    public static Map<Long, Double> wrap(TLongDoubleMap tLongDoubleMap) {
        return new TLongDoubleMapDecorator(tLongDoubleMap);
    }

    public static Map<Long, Float> wrap(TLongFloatMap tLongFloatMap) {
        return new TLongFloatMapDecorator(tLongFloatMap);
    }

    public static Map<Long, Integer> wrap(TLongIntMap tLongIntMap) {
        return new TLongIntMapDecorator(tLongIntMap);
    }

    public static Map<Long, Long> wrap(TLongLongMap tLongLongMap) {
        return new TLongLongMapDecorator(tLongLongMap);
    }

    public static Map<Long, Byte> wrap(TLongByteMap tLongByteMap) {
        return new TLongByteMapDecorator(tLongByteMap);
    }

    public static Map<Long, Short> wrap(TLongShortMap tLongShortMap) {
        return new TLongShortMapDecorator(tLongShortMap);
    }

    public static Map<Long, Character> wrap(TLongCharMap tLongCharMap) {
        return new TLongCharMapDecorator(tLongCharMap);
    }

    public static Map<Byte, Double> wrap(TByteDoubleMap tByteDoubleMap) {
        return new TByteDoubleMapDecorator(tByteDoubleMap);
    }

    public static Map<Byte, Float> wrap(TByteFloatMap tByteFloatMap) {
        return new TByteFloatMapDecorator(tByteFloatMap);
    }

    public static Map<Byte, Integer> wrap(TByteIntMap tByteIntMap) {
        return new TByteIntMapDecorator(tByteIntMap);
    }

    public static Map<Byte, Long> wrap(TByteLongMap tByteLongMap) {
        return new TByteLongMapDecorator(tByteLongMap);
    }

    public static Map<Byte, Byte> wrap(TByteByteMap tByteByteMap) {
        return new TByteByteMapDecorator(tByteByteMap);
    }

    public static Map<Byte, Short> wrap(TByteShortMap tByteShortMap) {
        return new TByteShortMapDecorator(tByteShortMap);
    }

    public static Map<Byte, Character> wrap(TByteCharMap tByteCharMap) {
        return new TByteCharMapDecorator(tByteCharMap);
    }

    public static Map<Short, Double> wrap(TShortDoubleMap tShortDoubleMap) {
        return new TShortDoubleMapDecorator(tShortDoubleMap);
    }

    public static Map<Short, Float> wrap(TShortFloatMap tShortFloatMap) {
        return new TShortFloatMapDecorator(tShortFloatMap);
    }

    public static Map<Short, Integer> wrap(TShortIntMap tShortIntMap) {
        return new TShortIntMapDecorator(tShortIntMap);
    }

    public static Map<Short, Long> wrap(TShortLongMap tShortLongMap) {
        return new TShortLongMapDecorator(tShortLongMap);
    }

    public static Map<Short, Byte> wrap(TShortByteMap tShortByteMap) {
        return new TShortByteMapDecorator(tShortByteMap);
    }

    public static Map<Short, Short> wrap(TShortShortMap tShortShortMap) {
        return new TShortShortMapDecorator(tShortShortMap);
    }

    public static Map<Short, Character> wrap(TShortCharMap tShortCharMap) {
        return new TShortCharMapDecorator(tShortCharMap);
    }

    public static Map<Character, Double> wrap(TCharDoubleMap tCharDoubleMap) {
        return new TCharDoubleMapDecorator(tCharDoubleMap);
    }

    public static Map<Character, Float> wrap(TCharFloatMap tCharFloatMap) {
        return new TCharFloatMapDecorator(tCharFloatMap);
    }

    public static Map<Character, Integer> wrap(TCharIntMap tCharIntMap) {
        return new TCharIntMapDecorator(tCharIntMap);
    }

    public static Map<Character, Long> wrap(TCharLongMap tCharLongMap) {
        return new TCharLongMapDecorator(tCharLongMap);
    }

    public static Map<Character, Byte> wrap(TCharByteMap tCharByteMap) {
        return new TCharByteMapDecorator(tCharByteMap);
    }

    public static Map<Character, Short> wrap(TCharShortMap tCharShortMap) {
        return new TCharShortMapDecorator(tCharShortMap);
    }

    public static Map<Character, Character> wrap(TCharCharMap tCharCharMap) {
        return new TCharCharMapDecorator(tCharCharMap);
    }

    public static <T> Map<T, Double> wrap(TObjectDoubleMap<T> tObjectDoubleMap) {
        return new TObjectDoubleMapDecorator(tObjectDoubleMap);
    }

    public static <T> Map<T, Float> wrap(TObjectFloatMap<T> tObjectFloatMap) {
        return new TObjectFloatMapDecorator(tObjectFloatMap);
    }

    public static <T> Map<T, Integer> wrap(TObjectIntMap<T> tObjectIntMap) {
        return new TObjectIntMapDecorator(tObjectIntMap);
    }

    public static <T> Map<T, Long> wrap(TObjectLongMap<T> tObjectLongMap) {
        return new TObjectLongMapDecorator(tObjectLongMap);
    }

    public static <T> Map<T, Byte> wrap(TObjectByteMap<T> tObjectByteMap) {
        return new TObjectByteMapDecorator(tObjectByteMap);
    }

    public static <T> Map<T, Short> wrap(TObjectShortMap<T> tObjectShortMap) {
        return new TObjectShortMapDecorator(tObjectShortMap);
    }

    public static <T> Map<T, Character> wrap(TObjectCharMap<T> tObjectCharMap) {
        return new TObjectCharMapDecorator(tObjectCharMap);
    }

    public static <T> Map<Double, T> wrap(TDoubleObjectMap<T> tDoubleObjectMap) {
        return new TDoubleObjectMapDecorator(tDoubleObjectMap);
    }

    public static <T> Map<Float, T> wrap(TFloatObjectMap<T> tFloatObjectMap) {
        return new TFloatObjectMapDecorator(tFloatObjectMap);
    }

    public static <T> Map<Integer, T> wrap(TIntObjectMap<T> tIntObjectMap) {
        return new TIntObjectMapDecorator(tIntObjectMap);
    }

    public static <T> Map<Long, T> wrap(TLongObjectMap<T> tLongObjectMap) {
        return new TLongObjectMapDecorator(tLongObjectMap);
    }

    public static <T> Map<Byte, T> wrap(TByteObjectMap<T> tByteObjectMap) {
        return new TByteObjectMapDecorator(tByteObjectMap);
    }

    public static <T> Map<Short, T> wrap(TShortObjectMap<T> tShortObjectMap) {
        return new TShortObjectMapDecorator(tShortObjectMap);
    }

    public static <T> Map<Character, T> wrap(TCharObjectMap<T> tCharObjectMap) {
        return new TCharObjectMapDecorator(tCharObjectMap);
    }

    public static Set<Double> wrap(TDoubleSet tDoubleSet) {
        return new TDoubleSetDecorator(tDoubleSet);
    }

    public static Set<Float> wrap(TFloatSet tFloatSet) {
        return new TFloatSetDecorator(tFloatSet);
    }

    public static Set<Integer> wrap(TIntSet tIntSet) {
        return new TIntSetDecorator(tIntSet);
    }

    public static Set<Long> wrap(TLongSet tLongSet) {
        return new TLongSetDecorator(tLongSet);
    }

    public static Set<Byte> wrap(TByteSet tByteSet) {
        return new TByteSetDecorator(tByteSet);
    }

    public static Set<Short> wrap(TShortSet tShortSet) {
        return new TShortSetDecorator(tShortSet);
    }

    public static Set<Character> wrap(TCharSet tCharSet) {
        return new TCharSetDecorator(tCharSet);
    }

    public static List<Double> wrap(TDoubleList tDoubleList) {
        return new TDoubleListDecorator(tDoubleList);
    }

    public static List<Float> wrap(TFloatList tFloatList) {
        return new TFloatListDecorator(tFloatList);
    }

    public static List<Integer> wrap(TIntList tIntList) {
        return new TIntListDecorator(tIntList);
    }

    public static List<Long> wrap(TLongList tLongList) {
        return new TLongListDecorator(tLongList);
    }

    public static List<Byte> wrap(TByteList tByteList) {
        return new TByteListDecorator(tByteList);
    }

    public static List<Short> wrap(TShortList tShortList) {
        return new TShortListDecorator(tShortList);
    }

    public static List<Character> wrap(TCharList tCharList) {
        return new TCharListDecorator(tCharList);
    }
}
