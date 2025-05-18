package com.tencent.bugly.proguard;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import com.tencent.bugly.AbstractC3328a;
import com.tencent.bugly.C3329b;
import com.tencent.bugly.crashreport.biz.UserInfoBean;
import com.tencent.bugly.crashreport.common.info.C3337a;
import com.tencent.bugly.crashreport.common.info.C3338b;
import com.tencent.bugly.crashreport.common.strategy.C3340a;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import java.lang.reflect.Array;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.impl.schema.SoapEncSchemaTypeSystem;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.a */
/* loaded from: classes3.dex */
public class C3360a {

    /* renamed from: e */
    private static Proxy f3228e;

    /* renamed from: a */
    protected HashMap<String, HashMap<String, byte[]>> f3229a = new HashMap<>();

    /* renamed from: b */
    protected String f3230b;

    /* renamed from: c */
    C3386i f3231c;

    /* renamed from: d */
    private HashMap<String, Object> f3232d;

    C3360a() {
        new HashMap();
        this.f3232d = new HashMap<>();
        this.f3230b = "GBK";
        this.f3231c = new C3386i();
    }

    /* renamed from: a */
    public static void m2067a(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            f3228e = null;
        } else {
            f3228e = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(str, i));
        }
    }

    /* renamed from: a */
    public static void m2068a(InetAddress inetAddress, int i) {
        if (inetAddress == null) {
            f3228e = null;
        } else {
            f3228e = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(inetAddress, i));
        }
    }

    /* renamed from: a */
    public void mo2074a(String str) {
        this.f3230b = str;
    }

    /* renamed from: b */
    public static Proxy m2073b() {
        return f3228e;
    }

    /* renamed from: a */
    public static C3377aq m2063a(UserInfoBean userInfoBean) {
        if (userInfoBean == null) {
            return null;
        }
        C3377aq c3377aq = new C3377aq();
        c3377aq.f3341a = userInfoBean.f2879e;
        c3377aq.f3345e = userInfoBean.f2884j;
        c3377aq.f3344d = userInfoBean.f2877c;
        c3377aq.f3343c = userInfoBean.f2878d;
        c3377aq.f3347g = userInfoBean.f2889o == 1;
        int i = userInfoBean.f2876b;
        if (i == 1) {
            c3377aq.f3342b = (byte) 1;
        } else if (i == 2) {
            c3377aq.f3342b = (byte) 4;
        } else if (i == 3) {
            c3377aq.f3342b = (byte) 2;
        } else if (i == 4) {
            c3377aq.f3342b = (byte) 3;
        } else {
            if (userInfoBean.f2876b < 10 || userInfoBean.f2876b >= 20) {
                C3401x.m2253e("unknown uinfo type %d ", Integer.valueOf(userInfoBean.f2876b));
                return null;
            }
            c3377aq.f3342b = (byte) userInfoBean.f2876b;
        }
        c3377aq.f3346f = new HashMap();
        if (userInfoBean.f2890p >= 0) {
            c3377aq.f3346f.put("C01", new StringBuilder().append(userInfoBean.f2890p).toString());
        }
        if (userInfoBean.f2891q >= 0) {
            c3377aq.f3346f.put("C02", new StringBuilder().append(userInfoBean.f2891q).toString());
        }
        if (userInfoBean.f2892r != null && userInfoBean.f2892r.size() > 0) {
            for (Map.Entry<String, String> entry : userInfoBean.f2892r.entrySet()) {
                c3377aq.f3346f.put("C03_" + entry.getKey(), entry.getValue());
            }
        }
        if (userInfoBean.f2893s != null && userInfoBean.f2893s.size() > 0) {
            for (Map.Entry<String, String> entry2 : userInfoBean.f2893s.entrySet()) {
                c3377aq.f3346f.put("C04_" + entry2.getKey(), entry2.getValue());
            }
        }
        c3377aq.f3346f.put("A36", new StringBuilder().append(!userInfoBean.f2886l).toString());
        c3377aq.f3346f.put("F02", new StringBuilder().append(userInfoBean.f2881g).toString());
        c3377aq.f3346f.put("F03", new StringBuilder().append(userInfoBean.f2882h).toString());
        c3377aq.f3346f.put("F04", userInfoBean.f2884j);
        c3377aq.f3346f.put("F05", new StringBuilder().append(userInfoBean.f2883i).toString());
        c3377aq.f3346f.put("F06", userInfoBean.f2887m);
        c3377aq.f3346f.put("F10", new StringBuilder().append(userInfoBean.f2885k).toString());
        C3401x.m2251c("summary type %d vm:%d", Byte.valueOf(c3377aq.f3342b), Integer.valueOf(c3377aq.f3346f.size()));
        return c3377aq;
    }

    /* renamed from: a */
    public static String m2066a(ArrayList<String> arrayList) {
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        while (true) {
            String str = "map";
            if (i < arrayList.size()) {
                String str2 = arrayList.get(i);
                if (str2.equals("java.lang.Integer") || str2.equals(XmlErrorCodes.INT)) {
                    str = "int32";
                } else if (str2.equals("java.lang.Boolean") || str2.equals(XmlErrorCodes.BOOLEAN)) {
                    str = "bool";
                } else if (str2.equals("java.lang.Byte") || str2.equals("byte")) {
                    str = "char";
                } else if (str2.equals("java.lang.Double") || str2.equals(XmlErrorCodes.DOUBLE)) {
                    str = XmlErrorCodes.DOUBLE;
                } else if (str2.equals("java.lang.Float") || str2.equals(XmlErrorCodes.FLOAT)) {
                    str = XmlErrorCodes.FLOAT;
                } else if (str2.equals("java.lang.Long") || str2.equals(XmlErrorCodes.LONG)) {
                    str = "int64";
                } else if (str2.equals("java.lang.Short") || str2.equals("short")) {
                    str = "short";
                } else {
                    if (str2.equals("java.lang.Character")) {
                        throw new IllegalArgumentException("can not support java.lang.Character");
                    }
                    if (str2.equals("java.lang.String")) {
                        str = "string";
                    } else if (str2.equals("java.util.List")) {
                        str = XmlErrorCodes.LIST;
                    } else if (!str2.equals("java.util.Map")) {
                        str = str2;
                    }
                }
                arrayList.set(i, str);
                i++;
            } else {
                Collections.reverse(arrayList);
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    String str3 = arrayList.get(i2);
                    if (str3.equals(XmlErrorCodes.LIST)) {
                        int i3 = i2 - 1;
                        arrayList.set(i3, "<" + arrayList.get(i3));
                        arrayList.set(0, arrayList.get(0) + ">");
                    } else if (str3.equals("map")) {
                        int i4 = i2 - 1;
                        arrayList.set(i4, "<" + arrayList.get(i4) + ",");
                        arrayList.set(0, arrayList.get(0) + ">");
                    } else if (str3.equals(SoapEncSchemaTypeSystem.SOAP_ARRAY)) {
                        int i5 = i2 - 1;
                        arrayList.set(i5, "<" + arrayList.get(i5));
                        arrayList.set(0, arrayList.get(0) + ">");
                    }
                }
                Collections.reverse(arrayList);
                Iterator<String> it = arrayList.iterator();
                while (it.hasNext()) {
                    stringBuffer.append(it.next());
                }
                return stringBuffer.toString();
            }
        }
    }

    /* renamed from: a */
    public <T> void mo2075a(String str, T t) {
        if (str == null) {
            throw new IllegalArgumentException("put key can not is null");
        }
        if (t == null) {
            throw new IllegalArgumentException("put value can not is null");
        }
        if (t instanceof Set) {
            throw new IllegalArgumentException("can not support Set");
        }
        C3387j c3387j = new C3387j();
        c3387j.m2146a(this.f3230b);
        c3387j.m2152a(t, 0);
        byte[] m2164a = C3389l.m2164a(c3387j.m2147a());
        HashMap<String, byte[]> hashMap = new HashMap<>(1);
        ArrayList<String> arrayList = new ArrayList<>(1);
        m2069a(arrayList, t);
        hashMap.put(m2066a(arrayList), m2164a);
        this.f3232d.remove(str);
        this.f3229a.put(str, hashMap);
    }

    /* renamed from: a */
    public static C3378ar m2064a(List<UserInfoBean> list, int i) {
        C3337a m1855b;
        if (list == null || list.size() == 0 || (m1855b = C3337a.m1855b()) == null) {
            return null;
        }
        m1855b.m1887o();
        C3378ar c3378ar = new C3378ar();
        c3378ar.f3352b = m1855b.f2970d;
        c3378ar.f3353c = m1855b.m1880h();
        ArrayList<C3377aq> arrayList = new ArrayList<>();
        Iterator<UserInfoBean> it = list.iterator();
        while (it.hasNext()) {
            C3377aq m2063a = m2063a(it.next());
            if (m2063a != null) {
                arrayList.add(m2063a);
            }
        }
        c3378ar.f3354d = arrayList;
        c3378ar.f3355e = new HashMap();
        c3378ar.f3355e.put("A7", m1855b.f2973g);
        c3378ar.f3355e.put("A6", m1855b.m1886n());
        c3378ar.f3355e.put("A5", m1855b.m1885m());
        c3378ar.f3355e.put("A2", new StringBuilder().append(m1855b.m1883k()).toString());
        c3378ar.f3355e.put("A1", new StringBuilder().append(m1855b.m1883k()).toString());
        c3378ar.f3355e.put("A24", m1855b.f2975i);
        c3378ar.f3355e.put("A17", new StringBuilder().append(m1855b.m1884l()).toString());
        c3378ar.f3355e.put("A15", m1855b.m1889q());
        c3378ar.f3355e.put("A13", new StringBuilder().append(m1855b.m1890r()).toString());
        c3378ar.f3355e.put("F08", m1855b.f2989w);
        c3378ar.f3355e.put("F09", m1855b.f2990x);
        Map<String, String> m1897y = m1855b.m1897y();
        if (m1897y != null && m1897y.size() > 0) {
            for (Map.Entry<String, String> entry : m1897y.entrySet()) {
                c3378ar.f3355e.put("C04_" + entry.getKey(), entry.getValue());
            }
        }
        if (i == 1) {
            c3378ar.f3351a = (byte) 1;
        } else {
            if (i != 2) {
                C3401x.m2253e("unknown up type %d ", Integer.valueOf(i));
                return null;
            }
            c3378ar.f3351a = (byte) 2;
        }
        return c3378ar;
    }

    /* renamed from: a */
    public static <T extends AbstractC3388k> T m2065a(byte[] bArr, Class<T> cls) {
        if (bArr != null && bArr.length > 0) {
            try {
                T newInstance = cls.newInstance();
                C3386i c3386i = new C3386i(bArr);
                c3386i.m2134a("utf-8");
                newInstance.mo2096a(c3386i);
                return newInstance;
            } catch (Throwable th) {
                if (!C3401x.m2250b(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    public static C3373am m2062a(Context context, int i, byte[] bArr) {
        C3337a m1855b = C3337a.m1855b();
        StrategyBean m1937c = C3340a.m1927a().m1937c();
        if (m1855b == null || m1937c == null) {
            C3401x.m2253e("Can not create request pkg for parameters is invalid.", new Object[0]);
            return null;
        }
        try {
            C3373am c3373am = new C3373am();
            synchronized (m1855b) {
                c3373am.f3289a = 1;
                c3373am.f3290b = m1855b.m1876f();
                c3373am.f3291c = m1855b.f2969c;
                c3373am.f3292d = m1855b.f2977k;
                c3373am.f3293e = m1855b.f2979m;
                c3373am.f3294f = m1855b.f2972f;
                c3373am.f3295g = i;
                if (bArr == null) {
                    bArr = "".getBytes();
                }
                c3373am.f3296h = bArr;
                c3373am.f3297i = m1855b.f2974h;
                c3373am.f3298j = m1855b.f2975i;
                c3373am.f3299k = new HashMap();
                c3373am.f3300l = m1855b.m1874e();
                c3373am.f3301m = m1937c.f3009n;
                c3373am.f3303o = m1855b.m1880h();
                c3373am.f3304p = C3338b.m1903b(context);
                c3373am.f3305q = System.currentTimeMillis();
                c3373am.f3306r = m1855b.m1881i();
                c3373am.f3307s = m1855b.m1880h();
                c3373am.f3308t = c3373am.f3304p;
                m1855b.getClass();
                c3373am.f3302n = "com.tencent.bugly";
                c3373am.f3299k.put("A26", m1855b.m1891s());
                c3373am.f3299k.put("A62", new StringBuilder().append(m1855b.m1858D()).toString());
                c3373am.f3299k.put("A63", new StringBuilder().append(m1855b.m1859E()).toString());
                c3373am.f3299k.put("F11", new StringBuilder().append(m1855b.f2928B).toString());
                c3373am.f3299k.put("F12", new StringBuilder().append(m1855b.f2927A).toString());
                c3373am.f3299k.put("D3", m1855b.f2978l);
                if (C3329b.f2868b != null) {
                    for (AbstractC3328a abstractC3328a : C3329b.f2868b) {
                        if (abstractC3328a.versionKey != null && abstractC3328a.version != null) {
                            c3373am.f3299k.put(abstractC3328a.versionKey, abstractC3328a.version);
                        }
                    }
                }
                c3373am.f3299k.put("G15", C3403z.m2300b("G15", ""));
                c3373am.f3299k.put("D4", C3403z.m2300b("D4", SessionDescription.SUPPORTED_SDP_VERSION));
            }
            Map<String, String> m1896x = m1855b.m1896x();
            if (m1896x != null) {
                for (Map.Entry<String, String> entry : m1896x.entrySet()) {
                    c3373am.f3299k.put(entry.getKey(), entry.getValue());
                }
            }
            return c3373am;
        } catch (Throwable th) {
            if (!C3401x.m2250b(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* renamed from: a */
    private void m2069a(ArrayList<String> arrayList, Object obj) {
        if (obj.getClass().isArray()) {
            if (!obj.getClass().getComponentType().toString().equals("byte")) {
                throw new IllegalArgumentException("only byte[] is supported");
            }
            if (Array.getLength(obj) > 0) {
                arrayList.add("java.util.List");
                m2069a(arrayList, Array.get(obj, 0));
                return;
            } else {
                arrayList.add(SoapEncSchemaTypeSystem.SOAP_ARRAY);
                arrayList.add("?");
                return;
            }
        }
        if (obj instanceof Array) {
            throw new IllegalArgumentException("can not support Array, please use List");
        }
        if (obj instanceof List) {
            arrayList.add("java.util.List");
            List list = (List) obj;
            if (list.size() > 0) {
                m2069a(arrayList, list.get(0));
                return;
            } else {
                arrayList.add("?");
                return;
            }
        }
        if (obj instanceof Map) {
            arrayList.add("java.util.Map");
            Map map = (Map) obj;
            if (map.size() > 0) {
                Object next = map.keySet().iterator().next();
                Object obj2 = map.get(next);
                arrayList.add(next.getClass().getName());
                m2069a(arrayList, obj2);
                return;
            }
            arrayList.add("?");
            arrayList.add("?");
            return;
        }
        arrayList.add(obj.getClass().getName());
    }

    /* renamed from: a */
    public byte[] mo2077a() {
        C3387j c3387j = new C3387j(0);
        c3387j.m2146a(this.f3230b);
        c3387j.m2155a((Map) this.f3229a, 0);
        return C3389l.m2164a(c3387j.m2147a());
    }

    /* renamed from: a */
    public static byte[] m2071a(Object obj) {
        try {
            C3381d c3381d = new C3381d();
            c3381d.mo2100c();
            c3381d.mo2074a("utf-8");
            c3381d.m2101a(1);
            c3381d.m2102b("RqdServer");
            c3381d.m2103c("sync");
            c3381d.mo2075a("detail", (String) obj);
            return c3381d.mo2077a();
        } catch (Throwable th) {
            if (C3401x.m2250b(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public void mo2076a(byte[] bArr) {
        this.f3231c.m2140a(bArr);
        this.f3231c.m2134a(this.f3230b);
        HashMap hashMap = new HashMap(1);
        HashMap hashMap2 = new HashMap(1);
        hashMap2.put("", new byte[0]);
        hashMap.put("", hashMap2);
        this.f3229a = this.f3231c.m2138a((Map) hashMap, 0, false);
    }

    /* renamed from: b */
    public static C3374an m2072b(byte[] bArr) {
        if (bArr != null) {
            try {
                C3381d c3381d = new C3381d();
                c3381d.mo2100c();
                c3381d.mo2074a("utf-8");
                c3381d.mo2076a(bArr);
                Object b = c3381d.m2099b("detail", new C3374an());
                if (C3374an.class.isInstance(b)) {
                    return (C3374an) C3374an.class.cast(b);
                }
                return null;
            } catch (Throwable th) {
                if (!C3401x.m2250b(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    public static byte[] m2070a(AbstractC3388k abstractC3388k) {
        try {
            C3387j c3387j = new C3387j();
            c3387j.m2146a("utf-8");
            abstractC3388k.mo2097a(c3387j);
            return c3387j.m2159b();
        } catch (Throwable th) {
            if (C3401x.m2250b(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }
}