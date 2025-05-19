package com.tencent.bugly.proguard;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: classes3.dex */
public final class j {
    private ByteBuffer a;
    private String b;

    public j(int i) {
        this.b = "GBK";
        this.a = ByteBuffer.allocate(i);
    }

    public j() {
        this(128);
    }

    public final ByteBuffer a() {
        return this.a;
    }

    public final byte[] b() {
        byte[] bArr = new byte[this.a.position()];
        System.arraycopy(this.a.array(), 0, bArr, 0, this.a.position());
        return bArr;
    }

    private void a(int i) {
        if (this.a.remaining() < i) {
            ByteBuffer allocate = ByteBuffer.allocate((this.a.capacity() + i) << 1);
            allocate.put(this.a.array(), 0, this.a.position());
            this.a = allocate;
        }
    }

    private void b(byte b, int i) {
        if (i < 15) {
            this.a.put((byte) (b | (i << 4)));
        } else {
            if (i < 256) {
                this.a.put((byte) (b | 240));
                this.a.put((byte) i);
                return;
            }
            throw new b("tag is too large: " + i);
        }
    }

    public final void a(boolean z, int i) {
        a(z ? (byte) 1 : (byte) 0, i);
    }

    public final void a(byte b, int i) {
        a(3);
        if (b == 0) {
            b((byte) 12, i);
        } else {
            b((byte) 0, i);
            this.a.put(b);
        }
    }

    public final void a(short s, int i) {
        a(4);
        if (s >= -128 && s <= 127) {
            a((byte) s, i);
        } else {
            b((byte) 1, i);
            this.a.putShort(s);
        }
    }

    public final void a(int i, int i2) {
        a(6);
        if (i >= -32768 && i <= 32767) {
            a((short) i, i2);
        } else {
            b((byte) 2, i2);
            this.a.putInt(i);
        }
    }

    public final void a(long j, int i) {
        a(10);
        if (j >= -2147483648L && j <= 2147483647L) {
            a((int) j, i);
        } else {
            b((byte) 3, i);
            this.a.putLong(j);
        }
    }

    public final void a(String str, int i) {
        byte[] bytes;
        try {
            bytes = str.getBytes(this.b);
        } catch (UnsupportedEncodingException unused) {
            bytes = str.getBytes();
        }
        a(bytes.length + 10);
        if (bytes.length > 255) {
            b((byte) 7, i);
            this.a.putInt(bytes.length);
            this.a.put(bytes);
        } else {
            b((byte) 6, i);
            this.a.put((byte) bytes.length);
            this.a.put(bytes);
        }
    }

    public final <K, V> void a(Map<K, V> map, int i) {
        a(8);
        b((byte) 8, i);
        a(map == null ? 0 : map.size(), 0);
        if (map != null) {
            for (Map.Entry<K, V> entry : map.entrySet()) {
                a(entry.getKey(), 0);
                a(entry.getValue(), 1);
            }
        }
    }

    public final void a(byte[] bArr, int i) {
        a(bArr.length + 8);
        b((byte) 13, i);
        b((byte) 0, 0);
        a(bArr.length, 0);
        this.a.put(bArr);
    }

    public final <T> void a(Collection<T> collection, int i) {
        a(8);
        b((byte) 9, i);
        a(collection == null ? 0 : collection.size(), 0);
        if (collection != null) {
            Iterator<T> it = collection.iterator();
            while (it.hasNext()) {
                a(it.next(), 0);
            }
        }
    }

    public final void a(k kVar, int i) {
        a(2);
        b((byte) 10, i);
        kVar.a(this);
        a(2);
        b((byte) 11, 0);
    }

    public final void a(Object obj, int i) {
        if (obj instanceof Byte) {
            a(((Byte) obj).byteValue(), i);
            return;
        }
        if (obj instanceof Boolean) {
            a(((Boolean) obj).booleanValue() ? (byte) 1 : (byte) 0, i);
            return;
        }
        if (obj instanceof Short) {
            a(((Short) obj).shortValue(), i);
            return;
        }
        if (obj instanceof Integer) {
            a(((Integer) obj).intValue(), i);
            return;
        }
        if (obj instanceof Long) {
            a(((Long) obj).longValue(), i);
            return;
        }
        if (obj instanceof Float) {
            float floatValue = ((Float) obj).floatValue();
            a(6);
            b((byte) 4, i);
            this.a.putFloat(floatValue);
            return;
        }
        if (obj instanceof Double) {
            double doubleValue = ((Double) obj).doubleValue();
            a(10);
            b((byte) 5, i);
            this.a.putDouble(doubleValue);
            return;
        }
        if (obj instanceof String) {
            a((String) obj, i);
            return;
        }
        if (obj instanceof Map) {
            a((Map) obj, i);
            return;
        }
        if (obj instanceof List) {
            a((Collection) obj, i);
            return;
        }
        if (obj instanceof k) {
            a(2);
            b((byte) 10, i);
            ((k) obj).a(this);
            a(2);
            b((byte) 11, 0);
            return;
        }
        if (obj instanceof byte[]) {
            a((byte[]) obj, i);
            return;
        }
        if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            a(8);
            b((byte) 9, i);
            a(zArr.length, 0);
            for (boolean z : zArr) {
                a(z ? (byte) 1 : (byte) 0, 0);
            }
            return;
        }
        if (obj instanceof short[]) {
            short[] sArr = (short[]) obj;
            a(8);
            b((byte) 9, i);
            a(sArr.length, 0);
            for (short s : sArr) {
                a(s, 0);
            }
            return;
        }
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            a(8);
            b((byte) 9, i);
            a(iArr.length, 0);
            for (int i2 : iArr) {
                a(i2, 0);
            }
            return;
        }
        if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            a(8);
            b((byte) 9, i);
            a(jArr.length, 0);
            for (long j : jArr) {
                a(j, 0);
            }
            return;
        }
        if (obj instanceof float[]) {
            float[] fArr = (float[]) obj;
            a(8);
            b((byte) 9, i);
            a(fArr.length, 0);
            for (float f : fArr) {
                a(6);
                b((byte) 4, 0);
                this.a.putFloat(f);
            }
            return;
        }
        if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            a(8);
            b((byte) 9, i);
            a(dArr.length, 0);
            for (double d : dArr) {
                a(10);
                b((byte) 5, 0);
                this.a.putDouble(d);
            }
            return;
        }
        if (obj.getClass().isArray()) {
            Object[] objArr = (Object[]) obj;
            a(8);
            b((byte) 9, i);
            a(objArr.length, 0);
            for (Object obj2 : objArr) {
                a(obj2, 0);
            }
            return;
        }
        if (obj instanceof Collection) {
            a((Collection) obj, i);
            return;
        }
        throw new b("write object error: unsupport type. " + obj.getClass());
    }

    public final int a(String str) {
        this.b = str;
        return 0;
    }
}
