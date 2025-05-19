package org.apache.commons.collections;

import java.io.PrintStream;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.SortedMap;
import java.util.TreeMap;
import org.apache.commons.collections.map.FixedSizeMap;
import org.apache.commons.collections.map.FixedSizeSortedMap;
import org.apache.commons.collections.map.LazyMap;
import org.apache.commons.collections.map.LazySortedMap;
import org.apache.commons.collections.map.ListOrderedMap;
import org.apache.commons.collections.map.MultiValueMap;
import org.apache.commons.collections.map.PredicatedMap;
import org.apache.commons.collections.map.PredicatedSortedMap;
import org.apache.commons.collections.map.TransformedMap;
import org.apache.commons.collections.map.TransformedSortedMap;
import org.apache.commons.collections.map.TypedMap;
import org.apache.commons.collections.map.TypedSortedMap;
import org.apache.commons.collections.map.UnmodifiableMap;
import org.apache.commons.collections.map.UnmodifiableSortedMap;
import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes4.dex */
public class MapUtils {
    public static final Map EMPTY_MAP = UnmodifiableMap.decorate(new HashMap(1));
    public static final SortedMap EMPTY_SORTED_MAP = UnmodifiableSortedMap.decorate(new TreeMap());
    private static final String INDENT_STRING = "    ";

    public static Object getObject(Map map, Object obj) {
        if (map != null) {
            return map.get(obj);
        }
        return null;
    }

    public static String getString(Map map, Object obj) {
        Object obj2;
        if (map == null || (obj2 = map.get(obj)) == null) {
            return null;
        }
        return obj2.toString();
    }

    public static Boolean getBoolean(Map map, Object obj) {
        Object obj2;
        if (map == null || (obj2 = map.get(obj)) == null) {
            return null;
        }
        if (obj2 instanceof Boolean) {
            return (Boolean) obj2;
        }
        if (obj2 instanceof String) {
            return new Boolean((String) obj2);
        }
        if (obj2 instanceof Number) {
            return ((Number) obj2).intValue() != 0 ? Boolean.TRUE : Boolean.FALSE;
        }
        return null;
    }

    public static Number getNumber(Map map, Object obj) {
        Object obj2;
        if (map == null || (obj2 = map.get(obj)) == null) {
            return null;
        }
        if (obj2 instanceof Number) {
            return (Number) obj2;
        }
        if (!(obj2 instanceof String)) {
            return null;
        }
        try {
            return NumberFormat.getInstance().parse((String) obj2);
        } catch (ParseException unused) {
            return null;
        }
    }

    public static Byte getByte(Map map, Object obj) {
        Number number = getNumber(map, obj);
        if (number == null) {
            return null;
        }
        if (number instanceof Byte) {
            return (Byte) number;
        }
        return new Byte(number.byteValue());
    }

    public static Short getShort(Map map, Object obj) {
        Number number = getNumber(map, obj);
        if (number == null) {
            return null;
        }
        if (number instanceof Short) {
            return (Short) number;
        }
        return new Short(number.shortValue());
    }

    public static Integer getInteger(Map map, Object obj) {
        Number number = getNumber(map, obj);
        if (number == null) {
            return null;
        }
        if (number instanceof Integer) {
            return (Integer) number;
        }
        return new Integer(number.intValue());
    }

    public static Long getLong(Map map, Object obj) {
        Number number = getNumber(map, obj);
        if (number == null) {
            return null;
        }
        if (number instanceof Long) {
            return (Long) number;
        }
        return new Long(number.longValue());
    }

    public static Float getFloat(Map map, Object obj) {
        Number number = getNumber(map, obj);
        if (number == null) {
            return null;
        }
        if (number instanceof Float) {
            return (Float) number;
        }
        return new Float(number.floatValue());
    }

    public static Double getDouble(Map map, Object obj) {
        Number number = getNumber(map, obj);
        if (number == null) {
            return null;
        }
        if (number instanceof Double) {
            return (Double) number;
        }
        return new Double(number.doubleValue());
    }

    public static Map getMap(Map map, Object obj) {
        Object obj2;
        if (map == null || (obj2 = map.get(obj)) == null || !(obj2 instanceof Map)) {
            return null;
        }
        return (Map) obj2;
    }

    public static Object getObject(Map map, Object obj, Object obj2) {
        Object obj3;
        return (map == null || (obj3 = map.get(obj)) == null) ? obj2 : obj3;
    }

    public static String getString(Map map, Object obj, String str) {
        String string = getString(map, obj);
        return string == null ? str : string;
    }

    public static Boolean getBoolean(Map map, Object obj, Boolean bool) {
        Boolean bool2 = getBoolean(map, obj);
        return bool2 == null ? bool : bool2;
    }

    public static Number getNumber(Map map, Object obj, Number number) {
        Number number2 = getNumber(map, obj);
        return number2 == null ? number : number2;
    }

    public static Byte getByte(Map map, Object obj, Byte b) {
        Byte b2 = getByte(map, obj);
        return b2 == null ? b : b2;
    }

    public static Short getShort(Map map, Object obj, Short sh) {
        Short sh2 = getShort(map, obj);
        return sh2 == null ? sh : sh2;
    }

    public static Integer getInteger(Map map, Object obj, Integer num) {
        Integer integer = getInteger(map, obj);
        return integer == null ? num : integer;
    }

    public static Long getLong(Map map, Object obj, Long l) {
        Long l2 = getLong(map, obj);
        return l2 == null ? l : l2;
    }

    public static Float getFloat(Map map, Object obj, Float f) {
        Float f2 = getFloat(map, obj);
        return f2 == null ? f : f2;
    }

    public static Double getDouble(Map map, Object obj, Double d) {
        Double d2 = getDouble(map, obj);
        return d2 == null ? d : d2;
    }

    public static Map getMap(Map map, Object obj, Map map2) {
        Map map3 = getMap(map, obj);
        return map3 == null ? map2 : map3;
    }

    public static boolean getBooleanValue(Map map, Object obj) {
        Boolean bool = getBoolean(map, obj);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public static byte getByteValue(Map map, Object obj) {
        Byte b = getByte(map, obj);
        if (b == null) {
            return (byte) 0;
        }
        return b.byteValue();
    }

    public static short getShortValue(Map map, Object obj) {
        Short sh = getShort(map, obj);
        if (sh == null) {
            return (short) 0;
        }
        return sh.shortValue();
    }

    public static int getIntValue(Map map, Object obj) {
        Integer integer = getInteger(map, obj);
        if (integer == null) {
            return 0;
        }
        return integer.intValue();
    }

    public static long getLongValue(Map map, Object obj) {
        Long l = getLong(map, obj);
        if (l == null) {
            return 0L;
        }
        return l.longValue();
    }

    public static float getFloatValue(Map map, Object obj) {
        Float f = getFloat(map, obj);
        if (f == null) {
            return 0.0f;
        }
        return f.floatValue();
    }

    public static double getDoubleValue(Map map, Object obj) {
        Double d = getDouble(map, obj);
        if (d == null) {
            return 0.0d;
        }
        return d.doubleValue();
    }

    public static boolean getBooleanValue(Map map, Object obj, boolean z) {
        Boolean bool = getBoolean(map, obj);
        return bool == null ? z : bool.booleanValue();
    }

    public static byte getByteValue(Map map, Object obj, byte b) {
        Byte b2 = getByte(map, obj);
        return b2 == null ? b : b2.byteValue();
    }

    public static short getShortValue(Map map, Object obj, short s) {
        Short sh = getShort(map, obj);
        return sh == null ? s : sh.shortValue();
    }

    public static int getIntValue(Map map, Object obj, int i) {
        Integer integer = getInteger(map, obj);
        return integer == null ? i : integer.intValue();
    }

    public static long getLongValue(Map map, Object obj, long j) {
        Long l = getLong(map, obj);
        return l == null ? j : l.longValue();
    }

    public static float getFloatValue(Map map, Object obj, float f) {
        Float f2 = getFloat(map, obj);
        return f2 == null ? f : f2.floatValue();
    }

    public static double getDoubleValue(Map map, Object obj, double d) {
        Double d2 = getDouble(map, obj);
        return d2 == null ? d : d2.doubleValue();
    }

    public static Properties toProperties(Map map) {
        Properties properties = new Properties();
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                properties.put(entry.getKey(), entry.getValue());
            }
        }
        return properties;
    }

    public static Map toMap(ResourceBundle resourceBundle) {
        Enumeration<String> keys = resourceBundle.getKeys();
        HashMap hashMap = new HashMap();
        while (keys.hasMoreElements()) {
            String nextElement = keys.nextElement();
            hashMap.put(nextElement, resourceBundle.getObject(nextElement));
        }
        return hashMap;
    }

    public static void verbosePrint(PrintStream printStream, Object obj, Map map) {
        verbosePrintInternal(printStream, obj, map, new ArrayStack(), false);
    }

    public static void debugPrint(PrintStream printStream, Object obj, Map map) {
        verbosePrintInternal(printStream, obj, map, new ArrayStack(), true);
    }

    protected static void logInfo(Exception exc) {
        System.out.println(new StringBuffer().append("INFO: Exception: ").append(exc).toString());
    }

    private static void verbosePrintInternal(PrintStream printStream, Object obj, Map map, ArrayStack arrayStack, boolean z) {
        printIndent(printStream, arrayStack.size());
        if (map == null) {
            if (obj != null) {
                printStream.print(obj);
                printStream.print(" = ");
            }
            printStream.println("null");
            return;
        }
        if (obj != null) {
            printStream.print(obj);
            printStream.println(" = ");
        }
        printIndent(printStream, arrayStack.size());
        printStream.println("{");
        arrayStack.push(map);
        for (Map.Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            if ((value instanceof Map) && !arrayStack.contains(value)) {
                if (key == null) {
                    key = "null";
                }
                verbosePrintInternal(printStream, key, (Map) value, arrayStack, z);
            } else {
                printIndent(printStream, arrayStack.size());
                printStream.print(key);
                printStream.print(" = ");
                int indexOf = arrayStack.indexOf(value);
                if (indexOf == -1) {
                    printStream.print(value);
                } else if (arrayStack.size() - 1 == indexOf) {
                    printStream.print("(this Map)");
                } else {
                    printStream.print(new StringBuffer().append("(ancestor[").append(((arrayStack.size() - 1) - indexOf) - 1).append("] Map)").toString());
                }
                if (z && value != null) {
                    printStream.print(' ');
                    printStream.println(value.getClass().getName());
                } else {
                    printStream.println();
                }
            }
        }
        arrayStack.pop();
        printIndent(printStream, arrayStack.size());
        printStream.println(z ? new StringBuffer().append("} ").append(map.getClass().getName()).toString() : StringSubstitutor.DEFAULT_VAR_END);
    }

    private static void printIndent(PrintStream printStream, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            printStream.print(INDENT_STRING);
        }
    }

    public static Map invertMap(Map map) {
        HashMap hashMap = new HashMap(map.size());
        for (Map.Entry entry : map.entrySet()) {
            hashMap.put(entry.getValue(), entry.getKey());
        }
        return hashMap;
    }

    public static void safeAddToMap(Map map, Object obj, Object obj2) throws NullPointerException {
        if (obj2 == null) {
            map.put(obj, "");
        } else {
            map.put(obj, obj2);
        }
    }

    public static Map putAll(Map map, Object[] objArr) {
        map.size();
        if (objArr != null && objArr.length != 0) {
            int i = 0;
            Object obj = objArr[0];
            if (obj instanceof Map.Entry) {
                while (i < objArr.length) {
                    Map.Entry entry = (Map.Entry) objArr[i];
                    map.put(entry.getKey(), entry.getValue());
                    i++;
                }
            } else if (obj instanceof KeyValue) {
                while (i < objArr.length) {
                    KeyValue keyValue = (KeyValue) objArr[i];
                    map.put(keyValue.getKey(), keyValue.getValue());
                    i++;
                }
            } else if (obj instanceof Object[]) {
                for (int i2 = 0; i2 < objArr.length; i2++) {
                    Object[] objArr2 = (Object[]) objArr[i2];
                    if (objArr2 == null || objArr2.length < 2) {
                        throw new IllegalArgumentException(new StringBuffer().append("Invalid array element: ").append(i2).toString());
                    }
                    map.put(objArr2[0], objArr2[1]);
                }
            } else {
                while (i < objArr.length - 1) {
                    int i3 = i + 1;
                    map.put(objArr[i], objArr[i3]);
                    i = i3 + 1;
                }
            }
        }
        return map;
    }

    public static boolean isEmpty(Map map) {
        return map == null || map.isEmpty();
    }

    public static boolean isNotEmpty(Map map) {
        return !isEmpty(map);
    }

    public static Map synchronizedMap(Map map) {
        return Collections.synchronizedMap(map);
    }

    public static Map unmodifiableMap(Map map) {
        return UnmodifiableMap.decorate(map);
    }

    public static Map predicatedMap(Map map, Predicate predicate, Predicate predicate2) {
        return PredicatedMap.decorate(map, predicate, predicate2);
    }

    public static Map typedMap(Map map, Class cls, Class cls2) {
        return TypedMap.decorate(map, cls, cls2);
    }

    public static Map transformedMap(Map map, Transformer transformer, Transformer transformer2) {
        return TransformedMap.decorate(map, transformer, transformer2);
    }

    public static Map fixedSizeMap(Map map) {
        return FixedSizeMap.decorate(map);
    }

    public static Map lazyMap(Map map, Factory factory) {
        return LazyMap.decorate(map, factory);
    }

    public static Map lazyMap(Map map, Transformer transformer) {
        return LazyMap.decorate(map, transformer);
    }

    public static Map orderedMap(Map map) {
        return ListOrderedMap.decorate(map);
    }

    public static Map multiValueMap(Map map) {
        return MultiValueMap.decorate(map);
    }

    public static Map multiValueMap(Map map, Class cls) {
        return MultiValueMap.decorate(map, cls);
    }

    public static Map multiValueMap(Map map, Factory factory) {
        return MultiValueMap.decorate(map, factory);
    }

    public static Map synchronizedSortedMap(SortedMap sortedMap) {
        return Collections.synchronizedSortedMap(sortedMap);
    }

    public static Map unmodifiableSortedMap(SortedMap sortedMap) {
        return UnmodifiableSortedMap.decorate(sortedMap);
    }

    public static SortedMap predicatedSortedMap(SortedMap sortedMap, Predicate predicate, Predicate predicate2) {
        return PredicatedSortedMap.decorate(sortedMap, predicate, predicate2);
    }

    public static SortedMap typedSortedMap(SortedMap sortedMap, Class cls, Class cls2) {
        return TypedSortedMap.decorate(sortedMap, cls, cls2);
    }

    public static SortedMap transformedSortedMap(SortedMap sortedMap, Transformer transformer, Transformer transformer2) {
        return TransformedSortedMap.decorate(sortedMap, transformer, transformer2);
    }

    public static SortedMap fixedSizeSortedMap(SortedMap sortedMap) {
        return FixedSizeSortedMap.decorate(sortedMap);
    }

    public static SortedMap lazySortedMap(SortedMap sortedMap, Factory factory) {
        return LazySortedMap.decorate(sortedMap, factory);
    }

    public static SortedMap lazySortedMap(SortedMap sortedMap, Transformer transformer) {
        return LazySortedMap.decorate(sortedMap, transformer);
    }
}
