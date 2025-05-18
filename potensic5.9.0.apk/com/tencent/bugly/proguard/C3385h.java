package com.tencent.bugly.proguard;

import java.util.List;
import java.util.Map;
import org.apache.commons.beanutils.PropertyUtils;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.h */
/* loaded from: classes3.dex */
public final class C3385h {

    /* renamed from: a */
    private StringBuilder f3376a;

    /* renamed from: b */
    private int f3377b;

    /* renamed from: a */
    private void m2107a(String str) {
        for (int i = 0; i < this.f3377b; i++) {
            this.f3376a.append('\t');
        }
        if (str != null) {
            this.f3376a.append(str).append(": ");
        }
    }

    public C3385h(StringBuilder sb, int i) {
        this.f3377b = 0;
        this.f3376a = sb;
        this.f3377b = i;
    }

    /* renamed from: a */
    public final C3385h m2115a(boolean z, String str) {
        m2107a(str);
        this.f3376a.append(z ? 'T' : 'F').append('\n');
        return this;
    }

    /* renamed from: a */
    public final C3385h m2108a(byte b, String str) {
        m2107a(str);
        this.f3376a.append((int) b).append('\n');
        return this;
    }

    /* renamed from: a */
    public final C3385h m2114a(short s, String str) {
        m2107a(str);
        this.f3376a.append((int) s).append('\n');
        return this;
    }

    /* renamed from: a */
    public final C3385h m2109a(int i, String str) {
        m2107a(str);
        this.f3376a.append(i).append('\n');
        return this;
    }

    /* renamed from: a */
    public final C3385h m2110a(long j, String str) {
        m2107a(str);
        this.f3376a.append(j).append('\n');
        return this;
    }

    /* renamed from: a */
    public final C3385h m2112a(String str, String str2) {
        m2107a(str2);
        if (str == null) {
            this.f3376a.append("null\n");
        } else {
            this.f3376a.append(str).append('\n');
        }
        return this;
    }

    /* renamed from: a */
    public final C3385h m2116a(byte[] bArr, String str) {
        m2107a(str);
        if (bArr == null) {
            this.f3376a.append("null\n");
            return this;
        }
        if (bArr.length == 0) {
            this.f3376a.append(bArr.length).append(", []\n");
            return this;
        }
        this.f3376a.append(bArr.length).append(", [\n");
        C3385h c3385h = new C3385h(this.f3376a, this.f3377b + 1);
        for (byte b : bArr) {
            c3385h.m2107a(null);
            c3385h.f3376a.append((int) b).append('\n');
        }
        m2107a(null);
        this.f3376a.append(PropertyUtils.INDEXED_DELIM2).append('\n');
        return this;
    }

    /* renamed from: a */
    public final <K, V> C3385h m2113a(Map<K, V> map, String str) {
        m2107a(str);
        if (map == null) {
            this.f3376a.append("null\n");
            return this;
        }
        if (map.isEmpty()) {
            this.f3376a.append(map.size()).append(", {}\n");
            return this;
        }
        this.f3376a.append(map.size()).append(", {\n");
        C3385h c3385h = new C3385h(this.f3376a, this.f3377b + 1);
        C3385h c3385h2 = new C3385h(this.f3376a, this.f3377b + 2);
        for (Map.Entry<K, V> entry : map.entrySet()) {
            c3385h.m2107a(null);
            c3385h.f3376a.append(PropertyUtils.MAPPED_DELIM).append('\n');
            c3385h2.m2105a((C3385h) entry.getKey(), (String) null);
            c3385h2.m2105a((C3385h) entry.getValue(), (String) null);
            c3385h.m2107a(null);
            c3385h.f3376a.append(PropertyUtils.MAPPED_DELIM2).append('\n');
        }
        m2107a(null);
        this.f3376a.append('}').append('\n');
        return this;
    }

    /* renamed from: a */
    private <T> C3385h m2106a(T[] tArr, String str) {
        m2107a(str);
        if (tArr == null) {
            this.f3376a.append("null\n");
            return this;
        }
        if (tArr.length == 0) {
            this.f3376a.append(tArr.length).append(", []\n");
            return this;
        }
        this.f3376a.append(tArr.length).append(", [\n");
        C3385h c3385h = new C3385h(this.f3376a, this.f3377b + 1);
        for (T t : tArr) {
            c3385h.m2105a((C3385h) t, (String) null);
        }
        m2107a(null);
        this.f3376a.append(PropertyUtils.INDEXED_DELIM2).append('\n');
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    private <T> C3385h m2105a(T t, String str) {
        if (t == 0) {
            this.f3376a.append("null\n");
        } else if (t instanceof Byte) {
            byte byteValue = ((Byte) t).byteValue();
            m2107a(str);
            this.f3376a.append((int) byteValue).append('\n');
        } else if (t instanceof Boolean) {
            boolean booleanValue = ((Boolean) t).booleanValue();
            m2107a(str);
            this.f3376a.append(booleanValue ? 'T' : 'F').append('\n');
        } else if (t instanceof Short) {
            short shortValue = ((Short) t).shortValue();
            m2107a(str);
            this.f3376a.append((int) shortValue).append('\n');
        } else if (t instanceof Integer) {
            int intValue = ((Integer) t).intValue();
            m2107a(str);
            this.f3376a.append(intValue).append('\n');
        } else if (t instanceof Long) {
            long longValue = ((Long) t).longValue();
            m2107a(str);
            this.f3376a.append(longValue).append('\n');
        } else if (t instanceof Float) {
            float floatValue = ((Float) t).floatValue();
            m2107a(str);
            this.f3376a.append(floatValue).append('\n');
        } else if (t instanceof Double) {
            double doubleValue = ((Double) t).doubleValue();
            m2107a(str);
            this.f3376a.append(doubleValue).append('\n');
        } else if (t instanceof String) {
            m2112a((String) t, str);
        } else if (t instanceof Map) {
            m2113a((Map) t, str);
        } else if (t instanceof List) {
            List list = (List) t;
            if (list == null) {
                m2107a(str);
                this.f3376a.append("null\t");
            } else {
                m2106a(list.toArray(), str);
            }
        } else if (t instanceof AbstractC3388k) {
            m2111a((AbstractC3388k) t, str);
        } else if (t instanceof byte[]) {
            m2116a((byte[]) t, str);
        } else if (t instanceof boolean[]) {
            m2105a((C3385h) t, str);
        } else {
            int i = 0;
            if (t instanceof short[]) {
                short[] sArr = (short[]) t;
                m2107a(str);
                if (sArr == null) {
                    this.f3376a.append("null\n");
                } else if (sArr.length == 0) {
                    this.f3376a.append(sArr.length).append(", []\n");
                } else {
                    this.f3376a.append(sArr.length).append(", [\n");
                    C3385h c3385h = new C3385h(this.f3376a, this.f3377b + 1);
                    int length = sArr.length;
                    while (i < length) {
                        short s = sArr[i];
                        c3385h.m2107a(null);
                        c3385h.f3376a.append((int) s).append('\n');
                        i++;
                    }
                    m2107a(null);
                    this.f3376a.append(PropertyUtils.INDEXED_DELIM2).append('\n');
                }
            } else if (t instanceof int[]) {
                int[] iArr = (int[]) t;
                m2107a(str);
                if (iArr == null) {
                    this.f3376a.append("null\n");
                } else if (iArr.length == 0) {
                    this.f3376a.append(iArr.length).append(", []\n");
                } else {
                    this.f3376a.append(iArr.length).append(", [\n");
                    C3385h c3385h2 = new C3385h(this.f3376a, this.f3377b + 1);
                    int length2 = iArr.length;
                    while (i < length2) {
                        int i2 = iArr[i];
                        c3385h2.m2107a(null);
                        c3385h2.f3376a.append(i2).append('\n');
                        i++;
                    }
                    m2107a(null);
                    this.f3376a.append(PropertyUtils.INDEXED_DELIM2).append('\n');
                }
            } else if (t instanceof long[]) {
                long[] jArr = (long[]) t;
                m2107a(str);
                if (jArr == null) {
                    this.f3376a.append("null\n");
                } else if (jArr.length == 0) {
                    this.f3376a.append(jArr.length).append(", []\n");
                } else {
                    this.f3376a.append(jArr.length).append(", [\n");
                    C3385h c3385h3 = new C3385h(this.f3376a, this.f3377b + 1);
                    int length3 = jArr.length;
                    while (i < length3) {
                        long j = jArr[i];
                        c3385h3.m2107a(null);
                        c3385h3.f3376a.append(j).append('\n');
                        i++;
                    }
                    m2107a(null);
                    this.f3376a.append(PropertyUtils.INDEXED_DELIM2).append('\n');
                }
            } else if (t instanceof float[]) {
                float[] fArr = (float[]) t;
                m2107a(str);
                if (fArr == null) {
                    this.f3376a.append("null\n");
                } else if (fArr.length == 0) {
                    this.f3376a.append(fArr.length).append(", []\n");
                } else {
                    this.f3376a.append(fArr.length).append(", [\n");
                    C3385h c3385h4 = new C3385h(this.f3376a, this.f3377b + 1);
                    int length4 = fArr.length;
                    while (i < length4) {
                        float f = fArr[i];
                        c3385h4.m2107a(null);
                        c3385h4.f3376a.append(f).append('\n');
                        i++;
                    }
                    m2107a(null);
                    this.f3376a.append(PropertyUtils.INDEXED_DELIM2).append('\n');
                }
            } else if (t instanceof double[]) {
                double[] dArr = (double[]) t;
                m2107a(str);
                if (dArr == null) {
                    this.f3376a.append("null\n");
                } else if (dArr.length == 0) {
                    this.f3376a.append(dArr.length).append(", []\n");
                } else {
                    this.f3376a.append(dArr.length).append(", [\n");
                    C3385h c3385h5 = new C3385h(this.f3376a, this.f3377b + 1);
                    int length5 = dArr.length;
                    while (i < length5) {
                        double d = dArr[i];
                        c3385h5.m2107a(null);
                        c3385h5.f3376a.append(d).append('\n');
                        i++;
                    }
                    m2107a(null);
                    this.f3376a.append(PropertyUtils.INDEXED_DELIM2).append('\n');
                }
            } else if (t.getClass().isArray()) {
                m2106a((Object[]) t, str);
            } else {
                throw new C3379b("write object error: unsupport type.");
            }
        }
        return this;
    }

    /* renamed from: a */
    public final C3385h m2111a(AbstractC3388k abstractC3388k, String str) {
        m2107a(str);
        this.f3376a.append('{').append('\n');
        if (abstractC3388k == null) {
            this.f3376a.append('\t').append("null");
        } else {
            abstractC3388k.mo2098a(this.f3376a, this.f3377b + 1);
        }
        m2107a(null);
        this.f3376a.append('}').append('\n');
        return this;
    }
}