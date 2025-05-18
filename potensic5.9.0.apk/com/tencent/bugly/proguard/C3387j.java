package com.tencent.bugly.proguard;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.j */
/* loaded from: classes3.dex */
public final class C3387j {

    /* renamed from: a */
    private ByteBuffer f3382a;

    /* renamed from: b */
    private String f3383b;

    public C3387j(int i) {
        this.f3383b = "GBK";
        this.f3382a = ByteBuffer.allocate(i);
    }

    public C3387j() {
        this(128);
    }

    /* renamed from: a */
    public final ByteBuffer m2147a() {
        return this.f3382a;
    }

    /* renamed from: b */
    public final byte[] m2159b() {
        byte[] bArr = new byte[this.f3382a.position()];
        System.arraycopy(this.f3382a.array(), 0, bArr, 0, this.f3382a.position());
        return bArr;
    }

    /* renamed from: a */
    private void m2144a(int i) {
        if (this.f3382a.remaining() < i) {
            ByteBuffer allocate = ByteBuffer.allocate((this.f3382a.capacity() + i) << 1);
            allocate.put(this.f3382a.array(), 0, this.f3382a.position());
            this.f3382a = allocate;
        }
    }

    /* renamed from: b */
    private void m2145b(byte b, int i) {
        if (i < 15) {
            this.f3382a.put((byte) (b | (i << 4)));
        } else {
            if (i < 256) {
                this.f3382a.put((byte) (b | 240));
                this.f3382a.put((byte) i);
                return;
            }
            throw new C3379b("tag is too large: " + i);
        }
    }

    /* renamed from: a */
    public final void m2157a(boolean z, int i) {
        m2148a(z ? (byte) 1 : (byte) 0, i);
    }

    /* renamed from: a */
    public final void m2148a(byte b, int i) {
        m2144a(3);
        if (b == 0) {
            m2145b((byte) 12, i);
        } else {
            m2145b((byte) 0, i);
            this.f3382a.put(b);
        }
    }

    /* renamed from: a */
    public final void m2156a(short s, int i) {
        m2144a(4);
        if (s >= -128 && s <= 127) {
            m2148a((byte) s, i);
        } else {
            m2145b((byte) 1, i);
            this.f3382a.putShort(s);
        }
    }

    /* renamed from: a */
    public final void m2149a(int i, int i2) {
        m2144a(6);
        if (i >= -32768 && i <= 32767) {
            m2156a((short) i, i2);
        } else {
            m2145b((byte) 2, i2);
            this.f3382a.putInt(i);
        }
    }

    /* renamed from: a */
    public final void m2150a(long j, int i) {
        m2144a(10);
        if (j >= -2147483648L && j <= 2147483647L) {
            m2149a((int) j, i);
        } else {
            m2145b((byte) 3, i);
            this.f3382a.putLong(j);
        }
    }

    /* renamed from: a */
    public final void m2153a(String str, int i) {
        byte[] bytes;
        try {
            bytes = str.getBytes(this.f3383b);
        } catch (UnsupportedEncodingException unused) {
            bytes = str.getBytes();
        }
        m2144a(bytes.length + 10);
        if (bytes.length > 255) {
            m2145b((byte) 7, i);
            this.f3382a.putInt(bytes.length);
            this.f3382a.put(bytes);
        } else {
            m2145b((byte) 6, i);
            this.f3382a.put((byte) bytes.length);
            this.f3382a.put(bytes);
        }
    }

    /* renamed from: a */
    public final <K, V> void m2155a(Map<K, V> map, int i) {
        m2144a(8);
        m2145b((byte) 8, i);
        m2149a(map == null ? 0 : map.size(), 0);
        if (map != null) {
            for (Map.Entry<K, V> entry : map.entrySet()) {
                m2152a(entry.getKey(), 0);
                m2152a(entry.getValue(), 1);
            }
        }
    }

    /* renamed from: a */
    public final void m2158a(byte[] bArr, int i) {
        m2144a(bArr.length + 8);
        m2145b((byte) 13, i);
        m2145b((byte) 0, 0);
        m2149a(bArr.length, 0);
        this.f3382a.put(bArr);
    }

    /* renamed from: a */
    public final <T> void m2154a(Collection<T> collection, int i) {
        m2144a(8);
        m2145b((byte) 9, i);
        m2149a(collection == null ? 0 : collection.size(), 0);
        if (collection != null) {
            Iterator<T> it = collection.iterator();
            while (it.hasNext()) {
                m2152a(it.next(), 0);
            }
        }
    }

    /* renamed from: a */
    public final void m2151a(AbstractC3388k abstractC3388k, int i) {
        m2144a(2);
        m2145b((byte) 10, i);
        abstractC3388k.mo2097a(this);
        m2144a(2);
        m2145b((byte) 11, 0);
    }

    /* renamed from: a */
    public final void m2152a(Object obj, int i) {
        if (obj instanceof Byte) {
            m2148a(((Byte) obj).byteValue(), i);
            return;
        }
        if (obj instanceof Boolean) {
            m2148a(((Boolean) obj).booleanValue() ? (byte) 1 : (byte) 0, i);
            return;
        }
        if (obj instanceof Short) {
            m2156a(((Short) obj).shortValue(), i);
            return;
        }
        if (obj instanceof Integer) {
            m2149a(((Integer) obj).intValue(), i);
            return;
        }
        if (obj instanceof Long) {
            m2150a(((Long) obj).longValue(), i);
            return;
        }
        if (obj instanceof Float) {
            float floatValue = ((Float) obj).floatValue();
            m2144a(6);
            m2145b((byte) 4, i);
            this.f3382a.putFloat(floatValue);
            return;
        }
        if (obj instanceof Double) {
            double doubleValue = ((Double) obj).doubleValue();
            m2144a(10);
            m2145b((byte) 5, i);
            this.f3382a.putDouble(doubleValue);
            return;
        }
        if (obj instanceof String) {
            m2153a((String) obj, i);
            return;
        }
        if (obj instanceof Map) {
            m2155a((Map) obj, i);
            return;
        }
        if (obj instanceof List) {
            m2154a((Collection) obj, i);
            return;
        }
        if (obj instanceof AbstractC3388k) {
            m2144a(2);
            m2145b((byte) 10, i);
            ((AbstractC3388k) obj).mo2097a(this);
            m2144a(2);
            m2145b((byte) 11, 0);
            return;
        }
        if (obj instanceof byte[]) {
            m2158a((byte[]) obj, i);
            return;
        }
        if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            m2144a(8);
            m2145b((byte) 9, i);
            m2149a(zArr.length, 0);
            for (boolean z : zArr) {
                m2148a(z ? (byte) 1 : (byte) 0, 0);
            }
            return;
        }
        if (obj instanceof short[]) {
            short[] sArr = (short[]) obj;
            m2144a(8);
            m2145b((byte) 9, i);
            m2149a(sArr.length, 0);
            for (short s : sArr) {
                m2156a(s, 0);
            }
            return;
        }
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            m2144a(8);
            m2145b((byte) 9, i);
            m2149a(iArr.length, 0);
            for (int i2 : iArr) {
                m2149a(i2, 0);
            }
            return;
        }
        if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            m2144a(8);
            m2145b((byte) 9, i);
            m2149a(jArr.length, 0);
            for (long j : jArr) {
                m2150a(j, 0);
            }
            return;
        }
        if (obj instanceof float[]) {
            float[] fArr = (float[]) obj;
            m2144a(8);
            m2145b((byte) 9, i);
            m2149a(fArr.length, 0);
            for (float f : fArr) {
                m2144a(6);
                m2145b((byte) 4, 0);
                this.f3382a.putFloat(f);
            }
            return;
        }
        if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            m2144a(8);
            m2145b((byte) 9, i);
            m2149a(dArr.length, 0);
            for (double d : dArr) {
                m2144a(10);
                m2145b((byte) 5, 0);
                this.f3382a.putDouble(d);
            }
            return;
        }
        if (obj.getClass().isArray()) {
            Object[] objArr = (Object[]) obj;
            m2144a(8);
            m2145b((byte) 9, i);
            m2149a(objArr.length, 0);
            for (Object obj2 : objArr) {
                m2152a(obj2, 0);
            }
            return;
        }
        if (obj instanceof Collection) {
            m2154a((Collection) obj, i);
            return;
        }
        throw new C3379b("write object error: unsupport type. " + obj.getClass());
    }

    /* renamed from: a */
    public final int m2146a(String str) {
        this.f3383b = str;
        return 0;
    }
}