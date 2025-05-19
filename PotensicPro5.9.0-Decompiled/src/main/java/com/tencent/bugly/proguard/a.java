package com.tencent.bugly.proguard;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import com.tencent.bugly.crashreport.biz.UserInfoBean;
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
/* loaded from: classes3.dex */
public class a {
    private static Proxy e;
    protected HashMap<String, HashMap<String, byte[]>> a = new HashMap<>();
    protected String b;
    i c;
    private HashMap<String, Object> d;

    a() {
        new HashMap();
        this.d = new HashMap<>();
        this.b = "GBK";
        this.c = new i();
    }

    public static void a(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            e = null;
        } else {
            e = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(str, i));
        }
    }

    public static void a(InetAddress inetAddress, int i) {
        if (inetAddress == null) {
            e = null;
        } else {
            e = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(inetAddress, i));
        }
    }

    public void a(String str) {
        this.b = str;
    }

    public static Proxy b() {
        return e;
    }

    public static aq a(UserInfoBean userInfoBean) {
        if (userInfoBean == null) {
            return null;
        }
        aq aqVar = new aq();
        aqVar.a = userInfoBean.e;
        aqVar.e = userInfoBean.j;
        aqVar.d = userInfoBean.c;
        aqVar.c = userInfoBean.d;
        aqVar.g = userInfoBean.o == 1;
        int i = userInfoBean.b;
        if (i == 1) {
            aqVar.b = (byte) 1;
        } else if (i == 2) {
            aqVar.b = (byte) 4;
        } else if (i == 3) {
            aqVar.b = (byte) 2;
        } else if (i == 4) {
            aqVar.b = (byte) 3;
        } else {
            if (userInfoBean.b < 10 || userInfoBean.b >= 20) {
                x.e("unknown uinfo type %d ", Integer.valueOf(userInfoBean.b));
                return null;
            }
            aqVar.b = (byte) userInfoBean.b;
        }
        aqVar.f = new HashMap();
        if (userInfoBean.p >= 0) {
            aqVar.f.put("C01", new StringBuilder().append(userInfoBean.p).toString());
        }
        if (userInfoBean.q >= 0) {
            aqVar.f.put("C02", new StringBuilder().append(userInfoBean.q).toString());
        }
        if (userInfoBean.r != null && userInfoBean.r.size() > 0) {
            for (Map.Entry<String, String> entry : userInfoBean.r.entrySet()) {
                aqVar.f.put("C03_" + entry.getKey(), entry.getValue());
            }
        }
        if (userInfoBean.s != null && userInfoBean.s.size() > 0) {
            for (Map.Entry<String, String> entry2 : userInfoBean.s.entrySet()) {
                aqVar.f.put("C04_" + entry2.getKey(), entry2.getValue());
            }
        }
        aqVar.f.put("A36", new StringBuilder().append(!userInfoBean.l).toString());
        aqVar.f.put("F02", new StringBuilder().append(userInfoBean.g).toString());
        aqVar.f.put("F03", new StringBuilder().append(userInfoBean.h).toString());
        aqVar.f.put("F04", userInfoBean.j);
        aqVar.f.put("F05", new StringBuilder().append(userInfoBean.i).toString());
        aqVar.f.put("F06", userInfoBean.m);
        aqVar.f.put("F10", new StringBuilder().append(userInfoBean.k).toString());
        x.c("summary type %d vm:%d", Byte.valueOf(aqVar.b), Integer.valueOf(aqVar.f.size()));
        return aqVar;
    }

    public static String a(ArrayList<String> arrayList) {
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

    public <T> void a(String str, T t) {
        if (str == null) {
            throw new IllegalArgumentException("put key can not is null");
        }
        if (t == null) {
            throw new IllegalArgumentException("put value can not is null");
        }
        if (t instanceof Set) {
            throw new IllegalArgumentException("can not support Set");
        }
        j jVar = new j();
        jVar.a(this.b);
        jVar.a(t, 0);
        byte[] a = l.a(jVar.a());
        HashMap<String, byte[]> hashMap = new HashMap<>(1);
        ArrayList<String> arrayList = new ArrayList<>(1);
        a(arrayList, t);
        hashMap.put(a(arrayList), a);
        this.d.remove(str);
        this.a.put(str, hashMap);
    }

    public static ar a(List<UserInfoBean> list, int i) {
        com.tencent.bugly.crashreport.common.info.a b;
        if (list == null || list.size() == 0 || (b = com.tencent.bugly.crashreport.common.info.a.b()) == null) {
            return null;
        }
        b.o();
        ar arVar = new ar();
        arVar.b = b.d;
        arVar.c = b.h();
        ArrayList<aq> arrayList = new ArrayList<>();
        Iterator<UserInfoBean> it = list.iterator();
        while (it.hasNext()) {
            aq a = a(it.next());
            if (a != null) {
                arrayList.add(a);
            }
        }
        arVar.d = arrayList;
        arVar.e = new HashMap();
        arVar.e.put("A7", b.g);
        arVar.e.put("A6", b.n());
        arVar.e.put("A5", b.m());
        arVar.e.put("A2", new StringBuilder().append(b.k()).toString());
        arVar.e.put("A1", new StringBuilder().append(b.k()).toString());
        arVar.e.put("A24", b.i);
        arVar.e.put("A17", new StringBuilder().append(b.l()).toString());
        arVar.e.put("A15", b.q());
        arVar.e.put("A13", new StringBuilder().append(b.r()).toString());
        arVar.e.put("F08", b.w);
        arVar.e.put("F09", b.x);
        Map<String, String> y = b.y();
        if (y != null && y.size() > 0) {
            for (Map.Entry<String, String> entry : y.entrySet()) {
                arVar.e.put("C04_" + entry.getKey(), entry.getValue());
            }
        }
        if (i == 1) {
            arVar.a = (byte) 1;
        } else {
            if (i != 2) {
                x.e("unknown up type %d ", Integer.valueOf(i));
                return null;
            }
            arVar.a = (byte) 2;
        }
        return arVar;
    }

    public static <T extends k> T a(byte[] bArr, Class<T> cls) {
        if (bArr != null && bArr.length > 0) {
            try {
                T newInstance = cls.newInstance();
                i iVar = new i(bArr);
                iVar.a("utf-8");
                newInstance.a(iVar);
                return newInstance;
            } catch (Throwable th) {
                if (!x.b(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    public static am a(Context context, int i, byte[] bArr) {
        com.tencent.bugly.crashreport.common.info.a b = com.tencent.bugly.crashreport.common.info.a.b();
        StrategyBean c = com.tencent.bugly.crashreport.common.strategy.a.a().c();
        if (b == null || c == null) {
            x.e("Can not create request pkg for parameters is invalid.", new Object[0]);
            return null;
        }
        try {
            am amVar = new am();
            synchronized (b) {
                amVar.a = 1;
                amVar.b = b.f();
                amVar.c = b.c;
                amVar.d = b.k;
                amVar.e = b.m;
                amVar.f = b.f;
                amVar.g = i;
                if (bArr == null) {
                    bArr = "".getBytes();
                }
                amVar.h = bArr;
                amVar.i = b.h;
                amVar.j = b.i;
                amVar.k = new HashMap();
                amVar.l = b.e();
                amVar.m = c.n;
                amVar.o = b.h();
                amVar.p = com.tencent.bugly.crashreport.common.info.b.b(context);
                amVar.q = System.currentTimeMillis();
                amVar.r = b.i();
                amVar.s = b.h();
                amVar.t = amVar.p;
                b.getClass();
                amVar.n = "com.tencent.bugly";
                amVar.k.put("A26", b.s());
                amVar.k.put("A62", new StringBuilder().append(b.D()).toString());
                amVar.k.put("A63", new StringBuilder().append(b.E()).toString());
                amVar.k.put("F11", new StringBuilder().append(b.B).toString());
                amVar.k.put("F12", new StringBuilder().append(b.A).toString());
                amVar.k.put("D3", b.l);
                if (com.tencent.bugly.b.b != null) {
                    for (com.tencent.bugly.a aVar : com.tencent.bugly.b.b) {
                        if (aVar.versionKey != null && aVar.version != null) {
                            amVar.k.put(aVar.versionKey, aVar.version);
                        }
                    }
                }
                amVar.k.put("G15", z.b("G15", ""));
                amVar.k.put("D4", z.b("D4", SessionDescription.SUPPORTED_SDP_VERSION));
            }
            Map<String, String> x = b.x();
            if (x != null) {
                for (Map.Entry<String, String> entry : x.entrySet()) {
                    amVar.k.put(entry.getKey(), entry.getValue());
                }
            }
            return amVar;
        } catch (Throwable th) {
            if (!x.b(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    private void a(ArrayList<String> arrayList, Object obj) {
        if (obj.getClass().isArray()) {
            if (!obj.getClass().getComponentType().toString().equals("byte")) {
                throw new IllegalArgumentException("only byte[] is supported");
            }
            if (Array.getLength(obj) > 0) {
                arrayList.add("java.util.List");
                a(arrayList, Array.get(obj, 0));
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
                a(arrayList, list.get(0));
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
                a(arrayList, obj2);
                return;
            }
            arrayList.add("?");
            arrayList.add("?");
            return;
        }
        arrayList.add(obj.getClass().getName());
    }

    public byte[] a() {
        j jVar = new j(0);
        jVar.a(this.b);
        jVar.a((Map) this.a, 0);
        return l.a(jVar.a());
    }

    public static byte[] a(Object obj) {
        try {
            d dVar = new d();
            dVar.c();
            dVar.a("utf-8");
            dVar.a(1);
            dVar.b("RqdServer");
            dVar.c("sync");
            dVar.a("detail", (String) obj);
            return dVar.a();
        } catch (Throwable th) {
            if (x.b(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    public void a(byte[] bArr) {
        this.c.a(bArr);
        this.c.a(this.b);
        HashMap hashMap = new HashMap(1);
        HashMap hashMap2 = new HashMap(1);
        hashMap2.put("", new byte[0]);
        hashMap.put("", hashMap2);
        this.a = this.c.a((Map) hashMap, 0, false);
    }

    public static an b(byte[] bArr) {
        if (bArr != null) {
            try {
                d dVar = new d();
                dVar.c();
                dVar.a("utf-8");
                dVar.a(bArr);
                Object b = dVar.b("detail", new an());
                if (an.class.isInstance(b)) {
                    return (an) an.class.cast(b);
                }
                return null;
            } catch (Throwable th) {
                if (!x.b(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    public static byte[] a(k kVar) {
        try {
            j jVar = new j();
            jVar.a("utf-8");
            kVar.a(jVar);
            return jVar.b();
        } catch (Throwable th) {
            if (x.b(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }
}
