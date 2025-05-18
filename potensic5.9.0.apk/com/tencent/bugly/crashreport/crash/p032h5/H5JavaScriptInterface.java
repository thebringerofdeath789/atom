package com.tencent.bugly.crashreport.crash.p032h5;

import android.webkit.JavascriptInterface;
import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.bugly.crashreport.inner.InnerApi;
import com.tencent.bugly.proguard.C3401x;
import com.tencent.bugly.proguard.C3403z;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.commons.text.lookup.StringLookupFactory;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: BUGLY */
/* loaded from: classes3.dex */
public class H5JavaScriptInterface {

    /* renamed from: a */
    private static HashSet<Integer> f3189a = new HashSet<>();

    /* renamed from: b */
    private String f3190b = null;

    /* renamed from: c */
    private Thread f3191c = null;

    /* renamed from: d */
    private String f3192d = null;

    /* renamed from: e */
    private Map<String, String> f3193e = null;

    private H5JavaScriptInterface() {
    }

    public static H5JavaScriptInterface getInstance(CrashReport.WebViewInterface webViewInterface) {
        String str = null;
        if (webViewInterface == null || f3189a.contains(Integer.valueOf(webViewInterface.hashCode()))) {
            return null;
        }
        H5JavaScriptInterface h5JavaScriptInterface = new H5JavaScriptInterface();
        f3189a.add(Integer.valueOf(webViewInterface.hashCode()));
        Thread currentThread = Thread.currentThread();
        h5JavaScriptInterface.f3191c = currentThread;
        if (currentThread != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("\n");
            for (int i = 2; i < currentThread.getStackTrace().length; i++) {
                StackTraceElement stackTraceElement = currentThread.getStackTrace()[i];
                if (!stackTraceElement.toString().contains("crashreport")) {
                    sb.append(stackTraceElement.toString()).append("\n");
                }
            }
            str = sb.toString();
        }
        h5JavaScriptInterface.f3192d = str;
        HashMap hashMap = new HashMap();
        hashMap.put("[WebView] ContentDescription", new StringBuilder().append((Object) webViewInterface.getContentDescription()).toString());
        h5JavaScriptInterface.f3193e = hashMap;
        return h5JavaScriptInterface;
    }

    /* renamed from: a */
    private static C3354a m2034a(String str) {
        String string;
        if (str != null && str.length() > 0) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                C3354a c3354a = new C3354a();
                c3354a.f3194a = jSONObject.getString("projectRoot");
                if (c3354a.f3194a == null) {
                    return null;
                }
                c3354a.f3195b = jSONObject.getString("context");
                if (c3354a.f3195b == null) {
                    return null;
                }
                c3354a.f3196c = jSONObject.getString("url");
                if (c3354a.f3196c == null) {
                    return null;
                }
                c3354a.f3197d = jSONObject.getString("userAgent");
                if (c3354a.f3197d == null) {
                    return null;
                }
                c3354a.f3198e = jSONObject.getString(IjkMediaMeta.IJKM_KEY_LANGUAGE);
                if (c3354a.f3198e == null) {
                    return null;
                }
                c3354a.f3199f = jSONObject.getString("name");
                if (c3354a.f3199f == null || c3354a.f3199f.equals("null") || (string = jSONObject.getString("stacktrace")) == null) {
                    return null;
                }
                int indexOf = string.indexOf("\n");
                if (indexOf < 0) {
                    C3401x.m2252d("H5 crash stack's format is wrong!", new Object[0]);
                    return null;
                }
                c3354a.f3201h = string.substring(indexOf + 1);
                c3354a.f3200g = string.substring(0, indexOf);
                int indexOf2 = c3354a.f3200g.indexOf(":");
                if (indexOf2 > 0) {
                    c3354a.f3200g = c3354a.f3200g.substring(indexOf2 + 1);
                }
                c3354a.f3202i = jSONObject.getString(StringLookupFactory.KEY_FILE);
                if (c3354a.f3199f == null) {
                    return null;
                }
                c3354a.f3203j = jSONObject.getLong("lineNumber");
                if (c3354a.f3203j < 0) {
                    return null;
                }
                c3354a.f3204k = jSONObject.getLong("columnNumber");
                if (c3354a.f3204k < 0) {
                    return null;
                }
                C3401x.m2246a("H5 crash information is following: ", new Object[0]);
                C3401x.m2246a("[projectRoot]: " + c3354a.f3194a, new Object[0]);
                C3401x.m2246a("[context]: " + c3354a.f3195b, new Object[0]);
                C3401x.m2246a("[url]: " + c3354a.f3196c, new Object[0]);
                C3401x.m2246a("[userAgent]: " + c3354a.f3197d, new Object[0]);
                C3401x.m2246a("[language]: " + c3354a.f3198e, new Object[0]);
                C3401x.m2246a("[name]: " + c3354a.f3199f, new Object[0]);
                C3401x.m2246a("[message]: " + c3354a.f3200g, new Object[0]);
                C3401x.m2246a("[stacktrace]: \n" + c3354a.f3201h, new Object[0]);
                C3401x.m2246a("[file]: " + c3354a.f3202i, new Object[0]);
                C3401x.m2246a("[lineNumber]: " + c3354a.f3203j, new Object[0]);
                C3401x.m2246a("[columnNumber]: " + c3354a.f3204k, new Object[0]);
                return c3354a;
            } catch (Throwable th) {
                if (!C3401x.m2247a(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    @JavascriptInterface
    public void printLog(String str) {
        C3401x.m2252d("Log from js: %s", str);
    }

    @JavascriptInterface
    public void reportJSException(String str) {
        if (str == null) {
            C3401x.m2252d("Payload from JS is null.", new Object[0]);
            return;
        }
        String m2284a = C3403z.m2284a(str.getBytes());
        String str2 = this.f3190b;
        if (str2 != null && str2.equals(m2284a)) {
            C3401x.m2252d("Same payload from js. Please check whether you've injected bugly.js more than one times.", new Object[0]);
            return;
        }
        this.f3190b = m2284a;
        C3401x.m2252d("Handling JS exception ...", new Object[0]);
        C3354a m2034a = m2034a(str);
        if (m2034a == null) {
            C3401x.m2252d("Failed to parse payload.", new Object[0]);
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        if (m2034a.f3194a != null) {
            linkedHashMap2.put("[JS] projectRoot", m2034a.f3194a);
        }
        if (m2034a.f3195b != null) {
            linkedHashMap2.put("[JS] context", m2034a.f3195b);
        }
        if (m2034a.f3196c != null) {
            linkedHashMap2.put("[JS] url", m2034a.f3196c);
        }
        if (m2034a.f3197d != null) {
            linkedHashMap2.put("[JS] userAgent", m2034a.f3197d);
        }
        if (m2034a.f3202i != null) {
            linkedHashMap2.put("[JS] file", m2034a.f3202i);
        }
        if (m2034a.f3203j != 0) {
            linkedHashMap2.put("[JS] lineNumber", Long.toString(m2034a.f3203j));
        }
        linkedHashMap.putAll(linkedHashMap2);
        linkedHashMap.putAll(this.f3193e);
        linkedHashMap.put("Java Stack", this.f3192d);
        Thread thread = this.f3191c;
        if (m2034a != null) {
            InnerApi.postH5CrashAsync(thread, m2034a.f3199f, m2034a.f3200g, m2034a.f3201h, linkedHashMap);
        }
    }
}