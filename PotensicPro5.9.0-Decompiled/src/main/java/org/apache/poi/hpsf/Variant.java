package org.apache.poi.hpsf;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class Variant {
    public static final int VT_ARRAY = 8192;
    public static final int VT_BLOB = 65;
    public static final int VT_BLOB_OBJECT = 70;
    public static final int VT_BOOL = 11;
    public static final int VT_BSTR = 8;
    public static final int VT_BYREF = 16384;
    public static final int VT_CARRAY = 28;
    public static final int VT_CF = 71;
    public static final int VT_CLSID = 72;
    public static final int VT_CY = 6;
    public static final int VT_DATE = 7;
    public static final int VT_DECIMAL = 14;
    public static final int VT_DISPATCH = 9;
    public static final int VT_EMPTY = 0;
    public static final int VT_ERROR = 10;
    public static final int VT_FILETIME = 64;
    public static final int VT_HRESULT = 25;
    public static final int VT_I1 = 16;
    public static final int VT_I2 = 2;
    public static final int VT_I4 = 3;
    public static final int VT_I8 = 20;
    public static final int VT_ILLEGAL = 65535;
    public static final int VT_ILLEGALMASKED = 4095;
    public static final int VT_INT = 22;
    public static final int VT_LPSTR = 30;
    public static final int VT_LPWSTR = 31;
    public static final int VT_NULL = 1;
    public static final int VT_PTR = 26;
    public static final int VT_R4 = 4;
    public static final int VT_R8 = 5;
    public static final int VT_RESERVED = 32768;
    public static final int VT_SAFEARRAY = 27;
    public static final int VT_STORAGE = 67;
    public static final int VT_STORED_OBJECT = 69;
    public static final int VT_STREAM = 66;
    public static final int VT_STREAMED_OBJECT = 68;
    public static final int VT_TYPEMASK = 4095;
    public static final int VT_UI1 = 17;
    public static final int VT_UI2 = 18;
    public static final int VT_UI4 = 19;
    public static final int VT_UI8 = 21;
    public static final int VT_UINT = 23;
    public static final int VT_UNKNOWN = 13;
    public static final int VT_USERDEFINED = 29;
    public static final int VT_VARIANT = 12;
    public static final int VT_VECTOR = 4096;
    public static final int VT_VERSIONED_STREAM = 73;
    public static final int VT_VOID = 24;
    private static Map<Long, Integer> numberToLength;
    private static Map<Long, String> numberToName;
    public static final Integer LENGTH_UNKNOWN = -2;
    public static final Integer LENGTH_VARIABLE = -1;
    public static final Integer LENGTH_0 = 0;
    public static final Integer LENGTH_2 = 2;
    public static final Integer LENGTH_4 = 4;
    public static final Integer LENGTH_8 = 8;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(0L, "VT_EMPTY");
        hashMap.put(1L, "VT_NULL");
        hashMap.put(2L, "VT_I2");
        hashMap.put(3L, "VT_I4");
        hashMap.put(4L, "VT_R4");
        hashMap.put(5L, "VT_R8");
        hashMap.put(6L, "VT_CY");
        hashMap.put(7L, "VT_DATE");
        hashMap.put(8L, "VT_BSTR");
        hashMap.put(9L, "VT_DISPATCH");
        hashMap.put(10L, "VT_ERROR");
        hashMap.put(11L, "VT_BOOL");
        hashMap.put(12L, "VT_VARIANT");
        hashMap.put(13L, "VT_UNKNOWN");
        hashMap.put(14L, "VT_DECIMAL");
        hashMap.put(16L, "VT_I1");
        hashMap.put(17L, "VT_UI1");
        hashMap.put(18L, "VT_UI2");
        hashMap.put(19L, "VT_UI4");
        hashMap.put(20L, "VT_I8");
        hashMap.put(21L, "VT_UI8");
        hashMap.put(22L, "VT_INT");
        hashMap.put(23L, "VT_UINT");
        hashMap.put(24L, "VT_VOID");
        hashMap.put(25L, "VT_HRESULT");
        hashMap.put(26L, "VT_PTR");
        hashMap.put(27L, "VT_SAFEARRAY");
        hashMap.put(28L, "VT_CARRAY");
        hashMap.put(29L, "VT_USERDEFINED");
        hashMap.put(30L, "VT_LPSTR");
        hashMap.put(31L, "VT_LPWSTR");
        hashMap.put(64L, "VT_FILETIME");
        hashMap.put(65L, "VT_BLOB");
        hashMap.put(66L, "VT_STREAM");
        hashMap.put(67L, "VT_STORAGE");
        hashMap.put(68L, "VT_STREAMED_OBJECT");
        hashMap.put(69L, "VT_STORED_OBJECT");
        hashMap.put(70L, "VT_BLOB_OBJECT");
        hashMap.put(71L, "VT_CF");
        hashMap.put(72L, "VT_CLSID");
        HashMap hashMap2 = new HashMap(hashMap.size(), 1.0f);
        hashMap2.putAll(hashMap);
        numberToName = Collections.unmodifiableMap(hashMap2);
        HashMap hashMap3 = new HashMap();
        hashMap3.put(0L, 0);
        hashMap3.put(1L, -2);
        hashMap3.put(2L, 2);
        hashMap3.put(3L, 4);
        hashMap3.put(4L, 4);
        hashMap3.put(5L, 8);
        hashMap3.put(6L, -2);
        hashMap3.put(7L, -2);
        hashMap3.put(8L, -2);
        hashMap3.put(9L, -2);
        hashMap3.put(10L, -2);
        hashMap3.put(11L, -2);
        hashMap3.put(12L, -2);
        hashMap3.put(13L, -2);
        hashMap3.put(14L, -2);
        hashMap3.put(16L, -2);
        hashMap3.put(17L, -2);
        hashMap3.put(18L, -2);
        hashMap3.put(19L, -2);
        hashMap3.put(20L, -2);
        hashMap3.put(21L, -2);
        hashMap3.put(22L, -2);
        hashMap3.put(23L, -2);
        hashMap3.put(24L, -2);
        hashMap3.put(25L, -2);
        hashMap3.put(26L, -2);
        hashMap3.put(27L, -2);
        hashMap3.put(28L, -2);
        hashMap3.put(29L, -2);
        hashMap3.put(30L, -1);
        hashMap3.put(31L, -2);
        hashMap3.put(64L, 8);
        hashMap3.put(65L, -2);
        hashMap3.put(66L, -2);
        hashMap3.put(67L, -2);
        hashMap3.put(68L, -2);
        hashMap3.put(69L, -2);
        hashMap3.put(70L, -2);
        hashMap3.put(71L, -2);
        hashMap3.put(72L, -2);
        HashMap hashMap4 = new HashMap(hashMap.size(), 1.0f);
        hashMap4.putAll(hashMap3);
        numberToLength = Collections.unmodifiableMap(hashMap4);
    }

    public static String getVariantName(long j) {
        String str = numberToName.get(Long.valueOf(j));
        return str != null ? str : "unknown variant type";
    }

    public static int getVariantLength(long j) {
        Integer num = numberToLength.get(Long.valueOf((int) j));
        if (num == null) {
            return -2;
        }
        return num.intValue();
    }
}
