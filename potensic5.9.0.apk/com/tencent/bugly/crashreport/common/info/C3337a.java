package com.tencent.bugly.crashreport.common.info;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.bugly.C3329b;
import com.tencent.bugly.crashreport.InterfaceC3332a;
import com.tencent.bugly.proguard.C3401x;
import com.tencent.bugly.proguard.C3403z;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.apache.commons.lang3.BooleanUtils;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.crashreport.common.info.a */
/* loaded from: classes3.dex */
public final class C3337a {

    /* renamed from: Z */
    private static C3337a f2926Z;

    /* renamed from: B */
    public boolean f2928B;

    /* renamed from: F */
    public SharedPreferences f2932F;

    /* renamed from: G */
    private final Context f2933G;

    /* renamed from: H */
    private String f2934H;

    /* renamed from: I */
    private String f2935I;

    /* renamed from: U */
    private String f2947U;

    /* renamed from: c */
    public String f2969c;

    /* renamed from: d */
    public final String f2970d;

    /* renamed from: g */
    public final String f2973g;

    /* renamed from: h */
    public final String f2974h;

    /* renamed from: i */
    public final String f2975i;

    /* renamed from: j */
    public long f2976j;

    /* renamed from: k */
    public String f2977k;

    /* renamed from: l */
    public String f2978l;

    /* renamed from: m */
    public String f2979m;

    /* renamed from: p */
    public List<String> f2982p;

    /* renamed from: v */
    public boolean f2988v;

    /* renamed from: w */
    public String f2989w;

    /* renamed from: x */
    public String f2990x;

    /* renamed from: y */
    public String f2991y;

    /* renamed from: z */
    public String f2992z;

    /* renamed from: e */
    public boolean f2971e = true;

    /* renamed from: f */
    public String f2972f = "3.3.3";

    /* renamed from: J */
    private String f2936J = "unknown";

    /* renamed from: K */
    private String f2937K = "";

    /* renamed from: L */
    private String f2938L = null;

    /* renamed from: M */
    private long f2939M = -1;

    /* renamed from: N */
    private long f2940N = -1;

    /* renamed from: O */
    private long f2941O = -1;

    /* renamed from: P */
    private String f2942P = null;

    /* renamed from: Q */
    private String f2943Q = null;

    /* renamed from: R */
    private Map<String, PlugInBean> f2944R = null;

    /* renamed from: S */
    private boolean f2945S = true;

    /* renamed from: T */
    private String f2946T = null;

    /* renamed from: V */
    private Boolean f2948V = null;

    /* renamed from: W */
    private String f2949W = null;

    /* renamed from: n */
    public String f2980n = null;

    /* renamed from: o */
    public String f2981o = null;

    /* renamed from: X */
    private Map<String, PlugInBean> f2950X = null;

    /* renamed from: Y */
    private Map<String, PlugInBean> f2951Y = null;

    /* renamed from: aa */
    private int f2953aa = -1;

    /* renamed from: ab */
    private int f2954ab = -1;

    /* renamed from: ac */
    private Map<String, String> f2955ac = new HashMap();

    /* renamed from: ad */
    private Map<String, String> f2956ad = new HashMap();

    /* renamed from: ae */
    private Map<String, String> f2957ae = new HashMap();

    /* renamed from: af */
    private boolean f2958af = true;

    /* renamed from: q */
    public String f2983q = "unknown";

    /* renamed from: r */
    public long f2984r = 0;

    /* renamed from: s */
    public long f2985s = 0;

    /* renamed from: t */
    public long f2986t = 0;

    /* renamed from: u */
    public long f2987u = 0;

    /* renamed from: A */
    public boolean f2927A = false;

    /* renamed from: ag */
    private Boolean f2959ag = null;

    /* renamed from: ah */
    private Boolean f2960ah = null;

    /* renamed from: C */
    public HashMap<String, String> f2929C = new HashMap<>();

    /* renamed from: D */
    public List<String> f2930D = new ArrayList();

    /* renamed from: E */
    public InterfaceC3332a f2931E = null;

    /* renamed from: ai */
    private final Object f2961ai = new Object();

    /* renamed from: aj */
    private final Object f2962aj = new Object();

    /* renamed from: ak */
    private final Object f2963ak = new Object();

    /* renamed from: al */
    private final Object f2964al = new Object();

    /* renamed from: am */
    private final Object f2965am = new Object();

    /* renamed from: an */
    private final Object f2966an = new Object();

    /* renamed from: ao */
    private final Object f2967ao = new Object();

    /* renamed from: a */
    public final long f2952a = System.currentTimeMillis();

    /* renamed from: b */
    public final byte f2968b = 1;

    private C3337a(Context context) {
        this.f2977k = null;
        this.f2978l = null;
        this.f2947U = null;
        this.f2979m = null;
        this.f2982p = null;
        this.f2988v = false;
        this.f2989w = null;
        this.f2990x = null;
        this.f2991y = null;
        this.f2992z = "";
        this.f2928B = false;
        this.f2933G = C3403z.m2271a(context);
        PackageInfo m1849b = AppInfo.m1849b(context);
        if (m1849b != null) {
            try {
                String str = m1849b.versionName;
                this.f2977k = str;
                this.f2989w = str;
                this.f2990x = Integer.toString(m1849b.versionCode);
            } catch (Throwable th) {
                if (!C3401x.m2247a(th)) {
                    th.printStackTrace();
                }
            }
        }
        this.f2969c = AppInfo.m1846a(context);
        this.f2970d = AppInfo.m1845a(Process.myPid());
        this.f2973g = C3338b.m1918k();
        String m1899a = C3338b.m1899a();
        this.f2974h = m1899a;
        this.f2978l = AppInfo.m1850c(context);
        String str2 = "Android " + C3338b.m1902b() + ",level " + C3338b.m1904c();
        this.f2975i = str2;
        String str3 = m1899a + ";" + str2;
        Map<String, String> m1851d = AppInfo.m1851d(context);
        if (m1851d != null) {
            try {
                this.f2982p = AppInfo.m1847a(m1851d);
                String str4 = m1851d.get("BUGLY_APPID");
                if (str4 != null) {
                    this.f2947U = str4;
                    m1871c("APP_ID", str4);
                }
                String str5 = m1851d.get("BUGLY_APP_VERSION");
                if (str5 != null) {
                    this.f2977k = str5;
                }
                String str6 = m1851d.get("BUGLY_APP_CHANNEL");
                if (str6 != null) {
                    this.f2979m = str6;
                }
                String str7 = m1851d.get("BUGLY_ENABLE_DEBUG");
                if (str7 != null) {
                    this.f2988v = str7.equalsIgnoreCase(BooleanUtils.TRUE);
                }
                String str8 = m1851d.get("com.tencent.rdm.uuid");
                if (str8 != null) {
                    this.f2991y = str8;
                }
                String str9 = m1851d.get("BUGLY_APP_BUILD_NO");
                if (!TextUtils.isEmpty(str9)) {
                    Integer.parseInt(str9);
                }
                String str10 = m1851d.get("BUGLY_AREA");
                if (str10 != null) {
                    this.f2992z = str10;
                }
            } catch (Throwable th2) {
                if (!C3401x.m2247a(th2)) {
                    th2.printStackTrace();
                }
            }
        }
        try {
            if (!context.getDatabasePath("bugly_db_").exists()) {
                this.f2928B = true;
                C3401x.m2251c("App is first time to be installed on the device.", new Object[0]);
            }
        } catch (Throwable th3) {
            if (C3329b.f2869c) {
                th3.printStackTrace();
            }
        }
        this.f2932F = C3403z.m2272a("BUGLY_COMMON_VALUES", context);
        C3401x.m2251c("com info create end", new Object[0]);
    }

    /* renamed from: a */
    public final boolean m1864a() {
        return this.f2958af;
    }

    /* renamed from: a */
    public final void m1863a(boolean z) {
        this.f2958af = z;
        InterfaceC3332a interfaceC3332a = this.f2931E;
        if (interfaceC3332a != null) {
            interfaceC3332a.setNativeIsAppForeground(z);
        }
    }

    /* renamed from: a */
    public static synchronized C3337a m1854a(Context context) {
        C3337a c3337a;
        synchronized (C3337a.class) {
            if (f2926Z == null) {
                f2926Z = new C3337a(context);
            }
            c3337a = f2926Z;
        }
        return c3337a;
    }

    /* renamed from: b */
    public static synchronized C3337a m1855b() {
        C3337a c3337a;
        synchronized (C3337a.class) {
            c3337a = f2926Z;
        }
        return c3337a;
    }

    /* renamed from: c */
    public final String m1869c() {
        return this.f2972f;
    }

    /* renamed from: d */
    public final void m1872d() {
        synchronized (this.f2961ai) {
            this.f2934H = UUID.randomUUID().toString();
        }
    }

    /* renamed from: e */
    public final String m1874e() {
        String str;
        synchronized (this.f2961ai) {
            if (this.f2934H == null) {
                synchronized (this.f2961ai) {
                    this.f2934H = UUID.randomUUID().toString();
                }
            }
            str = this.f2934H;
        }
        return str;
    }

    /* renamed from: f */
    public final String m1876f() {
        if (C3403z.m2294a((String) null)) {
            return this.f2947U;
        }
        return null;
    }

    /* renamed from: a */
    public final void m1861a(String str) {
        this.f2947U = str;
        m1871c("APP_ID", str);
    }

    /* renamed from: g */
    public final String m1878g() {
        String str;
        synchronized (this.f2966an) {
            str = this.f2936J;
        }
        return str;
    }

    /* renamed from: b */
    public final void m1866b(String str) {
        synchronized (this.f2966an) {
            if (str == null) {
                str = "10000";
            }
            this.f2936J = str;
        }
    }

    /* renamed from: b */
    public final void m1868b(boolean z) {
        this.f2945S = z;
    }

    /* renamed from: h */
    public final String m1880h() {
        String str;
        String str2 = this.f2935I;
        if (str2 != null) {
            return str2;
        }
        if (this.f2945S) {
            if (this.f2938L == null) {
                this.f2938L = C3338b.m1900a(this.f2933G);
            }
            str = this.f2938L;
        } else {
            str = "";
        }
        this.f2935I = str;
        return str;
    }

    /* renamed from: c */
    public final void m1870c(String str) {
        this.f2935I = str;
        synchronized (this.f2967ao) {
            this.f2956ad.put("E8", str);
        }
    }

    /* renamed from: d */
    public final synchronized void m1873d(String str) {
        String str2 = str;
    }

    /* renamed from: i */
    public final synchronized String m1881i() {
        return this.f2937K;
    }

    /* renamed from: e */
    public final synchronized void m1875e(String str) {
        this.f2937K = str;
    }

    /* renamed from: j */
    public final long m1882j() {
        if (this.f2939M <= 0) {
            this.f2939M = C3338b.m1906d();
        }
        return this.f2939M;
    }

    /* renamed from: k */
    public final long m1883k() {
        if (this.f2940N <= 0) {
            this.f2940N = C3338b.m1910f();
        }
        return this.f2940N;
    }

    /* renamed from: l */
    public final long m1884l() {
        if (this.f2941O <= 0) {
            this.f2941O = C3338b.m1915h();
        }
        return this.f2941O;
    }

    /* renamed from: m */
    public final String m1885m() {
        if (this.f2942P == null) {
            this.f2942P = C3338b.m1901a(this.f2933G, true);
        }
        return this.f2942P;
    }

    /* renamed from: n */
    public final String m1886n() {
        if (this.f2943Q == null) {
            this.f2943Q = C3338b.m1907d(this.f2933G);
        }
        return this.f2943Q;
    }

    /* renamed from: a */
    public final void m1862a(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        synchronized (this.f2962aj) {
            this.f2929C.put(str, str2);
        }
    }

    /* renamed from: o */
    public final String m1887o() {
        try {
            Map<String, ?> all = this.f2933G.getSharedPreferences("BuglySdkInfos", 0).getAll();
            if (!all.isEmpty()) {
                synchronized (this.f2962aj) {
                    for (Map.Entry<String, ?> entry : all.entrySet()) {
                        try {
                            this.f2929C.put(entry.getKey(), entry.getValue().toString());
                        } catch (Throwable th) {
                            C3401x.m2247a(th);
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            C3401x.m2247a(th2);
        }
        if (!this.f2929C.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, String> entry2 : this.f2929C.entrySet()) {
                sb.append("[");
                sb.append(entry2.getKey());
                sb.append(",");
                sb.append(entry2.getValue());
                sb.append("] ");
            }
            C3401x.m2251c("SDK_INFO = %s", sb.toString());
            m1871c("SDK_INFO", sb.toString());
            return sb.toString();
        }
        C3401x.m2251c("SDK_INFO is empty", new Object[0]);
        return null;
    }

    /* renamed from: p */
    public final synchronized Map<String, PlugInBean> m1888p() {
        return null;
    }

    /* renamed from: q */
    public final String m1889q() {
        if (this.f2946T == null) {
            this.f2946T = C3338b.m1917j();
        }
        return this.f2946T;
    }

    /* renamed from: r */
    public final Boolean m1890r() {
        if (this.f2948V == null) {
            this.f2948V = Boolean.valueOf(C3338b.m1919l());
        }
        return this.f2948V;
    }

    /* renamed from: s */
    public final String m1891s() {
        if (this.f2949W == null) {
            String str = C3338b.m1905c(this.f2933G);
            this.f2949W = str;
            C3401x.m2246a("ROM ID: %s", str);
        }
        return this.f2949W;
    }

    /* renamed from: t */
    public final Map<String, String> m1892t() {
        synchronized (this.f2963ak) {
            if (this.f2955ac.size() <= 0) {
                return null;
            }
            return new HashMap(this.f2955ac);
        }
    }

    /* renamed from: f */
    public final String m1877f(String str) {
        String remove;
        if (C3403z.m2294a(str)) {
            C3401x.m2252d("key should not be empty %s", str);
            return null;
        }
        synchronized (this.f2963ak) {
            remove = this.f2955ac.remove(str);
        }
        return remove;
    }

    /* renamed from: u */
    public final void m1893u() {
        synchronized (this.f2963ak) {
            this.f2955ac.clear();
        }
    }

    /* renamed from: g */
    public final String m1879g(String str) {
        String str2;
        if (C3403z.m2294a(str)) {
            C3401x.m2252d("key should not be empty %s", str);
            return null;
        }
        synchronized (this.f2963ak) {
            str2 = this.f2955ac.get(str);
        }
        return str2;
    }

    /* renamed from: b */
    public final void m1867b(String str, String str2) {
        if (C3403z.m2294a(str) || C3403z.m2294a(str2)) {
            C3401x.m2252d("key&value should not be empty %s %s", str, str2);
            return;
        }
        synchronized (this.f2963ak) {
            this.f2955ac.put(str, str2);
        }
    }

    /* renamed from: v */
    public final int m1894v() {
        int size;
        synchronized (this.f2963ak) {
            size = this.f2955ac.size();
        }
        return size;
    }

    /* renamed from: w */
    public final Set<String> m1895w() {
        Set<String> keySet;
        synchronized (this.f2963ak) {
            keySet = this.f2955ac.keySet();
        }
        return keySet;
    }

    /* renamed from: x */
    public final Map<String, String> m1896x() {
        synchronized (this.f2967ao) {
            if (this.f2956ad.size() <= 0) {
                return null;
            }
            return new HashMap(this.f2956ad);
        }
    }

    /* renamed from: c */
    public final void m1871c(String str, String str2) {
        if (C3403z.m2294a(str) || C3403z.m2294a(str2)) {
            C3401x.m2252d("server key&value should not be empty %s %s", str, str2);
            return;
        }
        synchronized (this.f2964al) {
            this.f2957ae.put(str, str2);
        }
    }

    /* renamed from: y */
    public final Map<String, String> m1897y() {
        synchronized (this.f2964al) {
            if (this.f2957ae.size() <= 0) {
                return null;
            }
            return new HashMap(this.f2957ae);
        }
    }

    /* renamed from: a */
    public final void m1860a(int i) {
        synchronized (this.f2965am) {
            int i2 = this.f2953aa;
            if (i2 != i) {
                this.f2953aa = i;
                C3401x.m2246a("user scene tag %d changed to tag %d", Integer.valueOf(i2), Integer.valueOf(this.f2953aa));
            }
        }
    }

    /* renamed from: z */
    public final int m1898z() {
        int i;
        synchronized (this.f2965am) {
            i = this.f2953aa;
        }
        return i;
    }

    /* renamed from: b */
    public final void m1865b(int i) {
        int i2 = this.f2954ab;
        if (i2 != 24096) {
            this.f2954ab = 24096;
            C3401x.m2246a("server scene tag %d changed to tag %d", Integer.valueOf(i2), Integer.valueOf(this.f2954ab));
        }
    }

    /* renamed from: A */
    public final int m1856A() {
        return this.f2954ab;
    }

    /* renamed from: B */
    public final synchronized Map<String, PlugInBean> m1857B() {
        return null;
    }

    /* renamed from: C */
    public static int m1853C() {
        return C3338b.m1904c();
    }

    /* renamed from: D */
    public final boolean m1858D() {
        if (this.f2959ag == null) {
            this.f2959ag = Boolean.valueOf(C3338b.m1909e(this.f2933G));
            C3401x.m2246a("Is it a virtual machine? " + this.f2959ag, new Object[0]);
        }
        return this.f2959ag.booleanValue();
    }

    /* renamed from: E */
    public final boolean m1859E() {
        if (this.f2960ah == null) {
            this.f2960ah = Boolean.valueOf(C3338b.m1911f(this.f2933G));
            C3401x.m2246a("Does it has hook frame? " + this.f2960ah, new Object[0]);
        }
        return this.f2960ah.booleanValue();
    }
}