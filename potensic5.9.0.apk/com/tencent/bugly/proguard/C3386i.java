package com.tencent.bugly.proguard;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.i */
/* loaded from: classes3.dex */
public final class C3386i {

    /* renamed from: a */
    private ByteBuffer f3378a;

    /* renamed from: b */
    private String f3379b = "GBK";

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.proguard.i$a */
    public static class a {

        /* renamed from: a */
        public byte f3380a;

        /* renamed from: b */
        public int f3381b;
    }

    public C3386i() {
    }

    public C3386i(byte[] bArr) {
        this.f3378a = ByteBuffer.wrap(bArr);
    }

    public C3386i(byte[] bArr, int i) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        this.f3378a = wrap;
        wrap.position(4);
    }

    /* renamed from: a */
    public final void m2140a(byte[] bArr) {
        ByteBuffer byteBuffer = this.f3378a;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        this.f3378a = ByteBuffer.wrap(bArr);
    }

    /* renamed from: a */
    private static int m2119a(a aVar, ByteBuffer byteBuffer) {
        byte b = byteBuffer.get();
        aVar.f3380a = (byte) (b & 15);
        aVar.f3381b = (b & 240) >> 4;
        if (aVar.f3381b != 15) {
            return 1;
        }
        aVar.f3381b = byteBuffer.get();
        return 2;
    }

    /* renamed from: a */
    private boolean m2123a(int i) {
        a aVar;
        try {
            aVar = new a();
            while (true) {
                int m2119a = m2119a(aVar, this.f3378a.duplicate());
                if (i <= aVar.f3381b || aVar.f3380a == 11) {
                    break;
                }
                ByteBuffer byteBuffer = this.f3378a;
                byteBuffer.position(byteBuffer.position() + m2119a);
                m2122a(aVar.f3380a);
            }
        } catch (C3384g | BufferUnderflowException unused) {
        }
        return i == aVar.f3381b;
    }

    /* renamed from: a */
    private void m2121a() {
        a aVar = new a();
        do {
            m2119a(aVar, this.f3378a);
            m2122a(aVar.f3380a);
        } while (aVar.f3380a != 11);
    }

    /* renamed from: a */
    private void m2122a(byte b) {
        int i = 0;
        switch (b) {
            case 0:
                ByteBuffer byteBuffer = this.f3378a;
                byteBuffer.position(byteBuffer.position() + 1);
                return;
            case 1:
                ByteBuffer byteBuffer2 = this.f3378a;
                byteBuffer2.position(byteBuffer2.position() + 2);
                return;
            case 2:
                ByteBuffer byteBuffer3 = this.f3378a;
                byteBuffer3.position(byteBuffer3.position() + 4);
                return;
            case 3:
                ByteBuffer byteBuffer4 = this.f3378a;
                byteBuffer4.position(byteBuffer4.position() + 8);
                return;
            case 4:
                ByteBuffer byteBuffer5 = this.f3378a;
                byteBuffer5.position(byteBuffer5.position() + 4);
                return;
            case 5:
                ByteBuffer byteBuffer6 = this.f3378a;
                byteBuffer6.position(byteBuffer6.position() + 8);
                return;
            case 6:
                int i2 = this.f3378a.get();
                if (i2 < 0) {
                    i2 += 256;
                }
                ByteBuffer byteBuffer7 = this.f3378a;
                byteBuffer7.position(byteBuffer7.position() + i2);
                return;
            case 7:
                int i3 = this.f3378a.getInt();
                ByteBuffer byteBuffer8 = this.f3378a;
                byteBuffer8.position(byteBuffer8.position() + i3);
                return;
            case 8:
                int m2133a = m2133a(0, 0, true);
                while (i < (m2133a << 1)) {
                    a aVar = new a();
                    m2119a(aVar, this.f3378a);
                    m2122a(aVar.f3380a);
                    i++;
                }
                return;
            case 9:
                int m2133a2 = m2133a(0, 0, true);
                while (i < m2133a2) {
                    a aVar2 = new a();
                    m2119a(aVar2, this.f3378a);
                    m2122a(aVar2.f3380a);
                    i++;
                }
                return;
            case 10:
                m2121a();
                return;
            case 11:
            case 12:
                return;
            case 13:
                a aVar3 = new a();
                m2119a(aVar3, this.f3378a);
                if (aVar3.f3380a != 0) {
                    throw new C3384g("skipField with invalid type, type value: " + ((int) b) + ", " + ((int) aVar3.f3380a));
                }
                int m2133a3 = m2133a(0, 0, true);
                ByteBuffer byteBuffer9 = this.f3378a;
                byteBuffer9.position(byteBuffer9.position() + m2133a3);
                return;
            default:
                throw new C3384g("invalid type.");
        }
    }

    /* renamed from: a */
    public final boolean m2141a(int i, boolean z) {
        return m2132a((byte) 0, i, z) != 0;
    }

    /* renamed from: a */
    public final byte m2132a(byte b, int i, boolean z) {
        if (!m2123a(i)) {
            if (z) {
                throw new C3384g("require field not exist.");
            }
            return b;
        }
        a aVar = new a();
        m2119a(aVar, this.f3378a);
        byte b2 = aVar.f3380a;
        if (b2 == 0) {
            return this.f3378a.get();
        }
        if (b2 == 12) {
            return (byte) 0;
        }
        throw new C3384g("type mismatch.");
    }

    /* renamed from: a */
    public final short m2139a(short s, int i, boolean z) {
        if (!m2123a(i)) {
            if (z) {
                throw new C3384g("require field not exist.");
            }
            return s;
        }
        a aVar = new a();
        m2119a(aVar, this.f3378a);
        byte b = aVar.f3380a;
        if (b == 0) {
            return this.f3378a.get();
        }
        if (b == 1) {
            return this.f3378a.getShort();
        }
        if (b == 12) {
            return (short) 0;
        }
        throw new C3384g("type mismatch.");
    }

    /* renamed from: a */
    public final int m2133a(int i, int i2, boolean z) {
        if (!m2123a(i2)) {
            if (z) {
                throw new C3384g("require field not exist.");
            }
            return i;
        }
        a aVar = new a();
        m2119a(aVar, this.f3378a);
        byte b = aVar.f3380a;
        if (b == 0) {
            return this.f3378a.get();
        }
        if (b == 1) {
            return this.f3378a.getShort();
        }
        if (b == 2) {
            return this.f3378a.getInt();
        }
        if (b == 12) {
            return 0;
        }
        throw new C3384g("type mismatch.");
    }

    /* renamed from: a */
    public final long m2135a(long j, int i, boolean z) {
        int i2;
        if (!m2123a(i)) {
            if (z) {
                throw new C3384g("require field not exist.");
            }
            return j;
        }
        a aVar = new a();
        m2119a(aVar, this.f3378a);
        byte b = aVar.f3380a;
        if (b == 0) {
            i2 = this.f3378a.get();
        } else if (b == 1) {
            i2 = this.f3378a.getShort();
        } else {
            if (b != 2) {
                if (b == 3) {
                    return this.f3378a.getLong();
                }
                if (b == 12) {
                    return 0L;
                }
                throw new C3384g("type mismatch.");
            }
            i2 = this.f3378a.getInt();
        }
        return i2;
    }

    /* renamed from: a */
    private float m2118a(float f, int i, boolean z) {
        if (!m2123a(i)) {
            if (z) {
                throw new C3384g("require field not exist.");
            }
            return f;
        }
        a aVar = new a();
        m2119a(aVar, this.f3378a);
        byte b = aVar.f3380a;
        if (b == 4) {
            return this.f3378a.getFloat();
        }
        if (b == 12) {
            return 0.0f;
        }
        throw new C3384g("type mismatch.");
    }

    /* renamed from: a */
    private double m2117a(double d, int i, boolean z) {
        if (!m2123a(i)) {
            if (z) {
                throw new C3384g("require field not exist.");
            }
            return d;
        }
        a aVar = new a();
        m2119a(aVar, this.f3378a);
        byte b = aVar.f3380a;
        if (b == 4) {
            return this.f3378a.getFloat();
        }
        if (b == 5) {
            return this.f3378a.getDouble();
        }
        if (b == 12) {
            return 0.0d;
        }
        throw new C3384g("type mismatch.");
    }

    /* renamed from: b */
    public final String m2142b(int i, boolean z) {
        if (!m2123a(i)) {
            if (z) {
                throw new C3384g("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        m2119a(aVar, this.f3378a);
        byte b = aVar.f3380a;
        if (b == 6) {
            int i2 = this.f3378a.get();
            if (i2 < 0) {
                i2 += 256;
            }
            byte[] bArr = new byte[i2];
            this.f3378a.get(bArr);
            try {
                return new String(bArr, this.f3379b);
            } catch (UnsupportedEncodingException unused) {
                return new String(bArr);
            }
        }
        if (b == 7) {
            int i3 = this.f3378a.getInt();
            if (i3 > 104857600 || i3 < 0) {
                throw new C3384g("String too long: " + i3);
            }
            byte[] bArr2 = new byte[i3];
            this.f3378a.get(bArr2);
            try {
                return new String(bArr2, this.f3379b);
            } catch (UnsupportedEncodingException unused2) {
                return new String(bArr2);
            }
        }
        throw new C3384g("type mismatch.");
    }

    /* renamed from: a */
    public final <K, V> HashMap<K, V> m2138a(Map<K, V> map, int i, boolean z) {
        return (HashMap) m2120a(new HashMap(), map, i, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    private <K, V> Map<K, V> m2120a(Map<K, V> map, Map<K, V> map2, int i, boolean z) {
        if (map2 == null || map2.isEmpty()) {
            return new HashMap();
        }
        Map.Entry<K, V> next = map2.entrySet().iterator().next();
        K key = next.getKey();
        V value = next.getValue();
        if (m2123a(i)) {
            a aVar = new a();
            m2119a(aVar, this.f3378a);
            if (aVar.f3380a == 8) {
                int m2133a = m2133a(0, 0, true);
                if (m2133a < 0) {
                    throw new C3384g("size invalid: " + m2133a);
                }
                for (int i2 = 0; i2 < m2133a; i2++) {
                    map.put(m2137a((C3386i) key, 0, true), m2137a((C3386i) value, 1, true));
                }
            } else {
                throw new C3384g("type mismatch.");
            }
        } else if (z) {
            throw new C3384g("require field not exist.");
        }
        return map;
    }

    /* renamed from: d */
    private boolean[] m2126d(int i, boolean z) {
        if (!m2123a(i)) {
            if (z) {
                throw new C3384g("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        m2119a(aVar, this.f3378a);
        if (aVar.f3380a == 9) {
            int m2133a = m2133a(0, 0, true);
            if (m2133a < 0) {
                throw new C3384g("size invalid: " + m2133a);
            }
            boolean[] zArr = new boolean[m2133a];
            for (int i2 = 0; i2 < m2133a; i2++) {
                zArr[i2] = m2132a((byte) 0, 0, true) != 0;
            }
            return zArr;
        }
        throw new C3384g("type mismatch.");
    }

    /* renamed from: c */
    public final byte[] m2143c(int i, boolean z) {
        if (!m2123a(i)) {
            if (z) {
                throw new C3384g("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        m2119a(aVar, this.f3378a);
        byte b = aVar.f3380a;
        if (b == 9) {
            int m2133a = m2133a(0, 0, true);
            if (m2133a < 0) {
                throw new C3384g("size invalid: " + m2133a);
            }
            byte[] bArr = new byte[m2133a];
            for (int i2 = 0; i2 < m2133a; i2++) {
                bArr[i2] = m2132a(bArr[0], 0, true);
            }
            return bArr;
        }
        if (b == 13) {
            a aVar2 = new a();
            m2119a(aVar2, this.f3378a);
            if (aVar2.f3380a != 0) {
                throw new C3384g("type mismatch, tag: " + i + ", type: " + ((int) aVar.f3380a) + ", " + ((int) aVar2.f3380a));
            }
            int m2133a2 = m2133a(0, 0, true);
            if (m2133a2 < 0) {
                throw new C3384g("invalid size, tag: " + i + ", type: " + ((int) aVar.f3380a) + ", " + ((int) aVar2.f3380a) + ", size: " + m2133a2);
            }
            byte[] bArr2 = new byte[m2133a2];
            this.f3378a.get(bArr2);
            return bArr2;
        }
        throw new C3384g("type mismatch.");
    }

    /* renamed from: e */
    private short[] m2127e(int i, boolean z) {
        if (!m2123a(i)) {
            if (z) {
                throw new C3384g("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        m2119a(aVar, this.f3378a);
        if (aVar.f3380a == 9) {
            int m2133a = m2133a(0, 0, true);
            if (m2133a < 0) {
                throw new C3384g("size invalid: " + m2133a);
            }
            short[] sArr = new short[m2133a];
            for (int i2 = 0; i2 < m2133a; i2++) {
                sArr[i2] = m2139a(sArr[0], 0, true);
            }
            return sArr;
        }
        throw new C3384g("type mismatch.");
    }

    /* renamed from: f */
    private int[] m2128f(int i, boolean z) {
        if (!m2123a(i)) {
            if (z) {
                throw new C3384g("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        m2119a(aVar, this.f3378a);
        if (aVar.f3380a == 9) {
            int m2133a = m2133a(0, 0, true);
            if (m2133a < 0) {
                throw new C3384g("size invalid: " + m2133a);
            }
            int[] iArr = new int[m2133a];
            for (int i2 = 0; i2 < m2133a; i2++) {
                iArr[i2] = m2133a(iArr[0], 0, true);
            }
            return iArr;
        }
        throw new C3384g("type mismatch.");
    }

    /* renamed from: g */
    private long[] m2129g(int i, boolean z) {
        if (!m2123a(i)) {
            if (z) {
                throw new C3384g("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        m2119a(aVar, this.f3378a);
        if (aVar.f3380a == 9) {
            int m2133a = m2133a(0, 0, true);
            if (m2133a < 0) {
                throw new C3384g("size invalid: " + m2133a);
            }
            long[] jArr = new long[m2133a];
            for (int i2 = 0; i2 < m2133a; i2++) {
                jArr[i2] = m2135a(jArr[0], 0, true);
            }
            return jArr;
        }
        throw new C3384g("type mismatch.");
    }

    /* renamed from: h */
    private float[] m2130h(int i, boolean z) {
        if (!m2123a(i)) {
            if (z) {
                throw new C3384g("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        m2119a(aVar, this.f3378a);
        if (aVar.f3380a == 9) {
            int m2133a = m2133a(0, 0, true);
            if (m2133a < 0) {
                throw new C3384g("size invalid: " + m2133a);
            }
            float[] fArr = new float[m2133a];
            for (int i2 = 0; i2 < m2133a; i2++) {
                fArr[i2] = m2118a(fArr[0], 0, true);
            }
            return fArr;
        }
        throw new C3384g("type mismatch.");
    }

    /* renamed from: i */
    private double[] m2131i(int i, boolean z) {
        if (!m2123a(i)) {
            if (z) {
                throw new C3384g("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        m2119a(aVar, this.f3378a);
        if (aVar.f3380a == 9) {
            int m2133a = m2133a(0, 0, true);
            if (m2133a < 0) {
                throw new C3384g("size invalid: " + m2133a);
            }
            double[] dArr = new double[m2133a];
            for (int i2 = 0; i2 < m2133a; i2++) {
                dArr[i2] = m2117a(dArr[0], 0, true);
            }
            return dArr;
        }
        throw new C3384g("type mismatch.");
    }

    /* renamed from: a */
    private <T> T[] m2124a(T[] tArr, int i, boolean z) {
        if (tArr == null || tArr.length == 0) {
            throw new C3384g("unable to get type of key and value.");
        }
        return (T[]) m2125b(tArr[0], i, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: b */
    private <T> T[] m2125b(T t, int i, boolean z) {
        if (!m2123a(i)) {
            if (z) {
                throw new C3384g("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        m2119a(aVar, this.f3378a);
        if (aVar.f3380a == 9) {
            int m2133a = m2133a(0, 0, true);
            if (m2133a < 0) {
                throw new C3384g("size invalid: " + m2133a);
            }
            T[] tArr = (T[]) ((Object[]) Array.newInstance(t.getClass(), m2133a));
            for (int i2 = 0; i2 < m2133a; i2++) {
                tArr[i2] = m2137a((C3386i) t, 0, true);
            }
            return tArr;
        }
        throw new C3384g("type mismatch.");
    }

    /* renamed from: a */
    public final AbstractC3388k m2136a(AbstractC3388k abstractC3388k, int i, boolean z) {
        if (!m2123a(i)) {
            if (z) {
                throw new C3384g("require field not exist.");
            }
            return null;
        }
        try {
            AbstractC3388k abstractC3388k2 = (AbstractC3388k) abstractC3388k.getClass().newInstance();
            a aVar = new a();
            m2119a(aVar, this.f3378a);
            if (aVar.f3380a != 10) {
                throw new C3384g("type mismatch.");
            }
            abstractC3388k2.mo2096a(this);
            m2121a();
            return abstractC3388k2;
        } catch (Exception e) {
            throw new C3384g(e.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public final <T> Object m2137a(T t, int i, boolean z) {
        if (t instanceof Byte) {
            return Byte.valueOf(m2132a((byte) 0, i, z));
        }
        if (t instanceof Boolean) {
            return Boolean.valueOf(m2132a((byte) 0, i, z) != 0);
        }
        if (t instanceof Short) {
            return Short.valueOf(m2139a((short) 0, i, z));
        }
        if (t instanceof Integer) {
            return Integer.valueOf(m2133a(0, i, z));
        }
        if (t instanceof Long) {
            return Long.valueOf(m2135a(0L, i, z));
        }
        if (t instanceof Float) {
            return Float.valueOf(m2118a(0.0f, i, z));
        }
        if (t instanceof Double) {
            return Double.valueOf(m2117a(0.0d, i, z));
        }
        if (t instanceof String) {
            return String.valueOf(m2142b(i, z));
        }
        if (t instanceof Map) {
            return (HashMap) m2120a(new HashMap(), (Map) t, i, z);
        }
        if (t instanceof List) {
            List list = (List) t;
            if (list == null || list.isEmpty()) {
                return new ArrayList();
            }
            Object[] m2125b = m2125b(list.get(0), i, z);
            if (m2125b == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Object obj : m2125b) {
                arrayList.add(obj);
            }
            return arrayList;
        }
        if (t instanceof AbstractC3388k) {
            return m2136a((AbstractC3388k) t, i, z);
        }
        if (t.getClass().isArray()) {
            if ((t instanceof byte[]) || (t instanceof Byte[])) {
                return m2143c(i, z);
            }
            if (t instanceof boolean[]) {
                return m2126d(i, z);
            }
            if (t instanceof short[]) {
                return m2127e(i, z);
            }
            if (t instanceof int[]) {
                return m2128f(i, z);
            }
            if (t instanceof long[]) {
                return m2129g(i, z);
            }
            if (t instanceof float[]) {
                return m2130h(i, z);
            }
            if (t instanceof double[]) {
                return m2131i(i, z);
            }
            return m2124a((Object[]) t, i, z);
        }
        throw new C3384g("read object error: unsupport type.");
    }

    /* renamed from: a */
    public final int m2134a(String str) {
        this.f3379b = str;
        return 0;
    }
}