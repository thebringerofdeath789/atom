package com.baidu.lbsapi.auth;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;

/* compiled from: HttpsHelper.java */
/* renamed from: com.baidu.lbsapi.auth.i */
/* loaded from: classes.dex */
public class C0628i {

    /* renamed from: a */
    private Context f237a;

    /* renamed from: b */
    private String f238b = null;

    /* renamed from: c */
    private HashMap<String, String> f239c = null;

    /* renamed from: d */
    private String f240d = null;

    public C0628i(Context context) {
        this.f237a = context;
    }

    /* renamed from: a */
    protected String m210a(HashMap<String, String> hashMap) {
        HashMap<String, String> m209c = m209c(hashMap);
        this.f239c = m209c;
        this.f238b = m209c.get("url");
        HttpsURLConnection m208b = m208b();
        if (m208b == null) {
            C0621b.m179c("syncConnect failed,httpsURLConnection is null");
            return this.f240d;
        }
        m206a(m208b);
        return this.f240d;
    }

    /* renamed from: a */
    protected boolean m211a() {
        C0621b.m177a("checkNetwork start");
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.f237a.getSystemService("connectivity");
            if (connectivityManager == null) {
                return false;
            }
            if (Build.VERSION.SDK_INT >= 29) {
                NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
                return networkCapabilities != null && networkCapabilities.hasCapability(12) && networkCapabilities.hasCapability(16);
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
                return false;
            }
            C0621b.m177a("checkNetwork end");
            return true;
        } catch (Exception e) {
            if (C0621b.f226a) {
                e.printStackTrace();
            }
            return false;
        }
    }

    /* renamed from: b */
    private HttpsURLConnection m208b() {
        HttpsURLConnection httpsURLConnection;
        try {
            URL url = new URL(this.f238b);
            C0621b.m177a("https URL: " + this.f238b);
            String m205a = m205a(this.f237a);
            if (m205a != null && !m205a.equals("")) {
                C0621b.m177a("checkNetwork = " + m205a);
                if (m205a.equals("cmwap")) {
                    httpsURLConnection = (HttpsURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.0.0.172", 80)));
                } else if (m205a.equals("ctwap")) {
                    httpsURLConnection = (HttpsURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.0.0.200", 80)));
                } else {
                    httpsURLConnection = (HttpsURLConnection) url.openConnection();
                }
                httpsURLConnection.setHostnameVerifier(new C0629j(this));
                httpsURLConnection.setDoInput(true);
                httpsURLConnection.setDoOutput(true);
                httpsURLConnection.setRequestMethod("POST");
                httpsURLConnection.setConnectTimeout(50000);
                httpsURLConnection.setReadTimeout(50000);
                return httpsURLConnection;
            }
            C0621b.m179c("Current network is not available.");
            this.f240d = ErrorMessage.m149a(-10, "Current network is not available.");
            return null;
        } catch (MalformedURLException e) {
            if (C0621b.f226a) {
                e.printStackTrace();
                C0621b.m177a(e.getMessage());
            }
            this.f240d = ErrorMessage.m149a(-11, "Auth server could not be parsed as a URL.");
            return null;
        } catch (Exception e2) {
            if (C0621b.f226a) {
                e2.printStackTrace();
                C0621b.m177a(e2.getMessage());
            }
            this.f240d = ErrorMessage.m149a(-11, "Init httpsurlconnection failed.");
            return null;
        }
    }

    /* renamed from: a */
    private String m205a(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return null;
            }
            if (Build.VERSION.SDK_INT >= 29) {
                NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
                if (networkCapabilities != null) {
                    return networkCapabilities.hasTransport(1) ? "WIFI" : networkCapabilities.hasTransport(0) ? "CELLULAR" : networkCapabilities.hasTransport(3) ? "ETHERNET" : networkCapabilities.hasTransport(6) ? "LoWPAN" : networkCapabilities.hasTransport(4) ? "VPN" : networkCapabilities.hasTransport(5) ? "WifiAware" : "wifi";
                }
                return "wifi";
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                String extraInfo = activeNetworkInfo.getExtraInfo();
                return extraInfo != null ? (extraInfo.trim().toLowerCase().equals("cmwap") || extraInfo.trim().toLowerCase().equals("uniwap") || extraInfo.trim().toLowerCase().equals("3gwap") || extraInfo.trim().toLowerCase().equals("ctwap")) ? extraInfo.trim().toLowerCase().equals("ctwap") ? "ctwap" : "cmwap" : "wifi" : "wifi";
            }
            return null;
        } catch (Exception e) {
            if (C0621b.f226a) {
                e.printStackTrace();
            }
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:113:0x01ce, code lost:
    
        if (com.baidu.lbsapi.auth.C0621b.f226a == false) goto L128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x016b, code lost:
    
        r14.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x019c, code lost:
    
        if (com.baidu.lbsapi.auth.C0621b.f226a == false) goto L128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x0169, code lost:
    
        if (com.baidu.lbsapi.auth.C0621b.f226a == false) goto L128;
     */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01a5 A[Catch: all -> 0x0136, TryCatch #20 {all -> 0x0136, blocks: (B:8:0x0031, B:130:0x013b, B:132:0x013f, B:133:0x0142, B:117:0x0171, B:119:0x0175, B:120:0x0178, B:103:0x01a1, B:105:0x01a5, B:106:0x01a8), top: B:7:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01c7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0175 A[Catch: all -> 0x0136, TryCatch #20 {all -> 0x0136, blocks: (B:8:0x0031, B:130:0x013b, B:132:0x013f, B:133:0x0142, B:117:0x0171, B:119:0x0175, B:120:0x0178, B:103:0x01a1, B:105:0x01a5, B:106:0x01a8), top: B:7:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0195 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:132:0x013f A[Catch: all -> 0x0136, TryCatch #20 {all -> 0x0136, blocks: (B:8:0x0031, B:130:0x013b, B:132:0x013f, B:133:0x0142, B:117:0x0171, B:119:0x0175, B:120:0x0178, B:103:0x01a1, B:105:0x01a5, B:106:0x01a8), top: B:7:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0161 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x01d3 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ff A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b5 A[Catch: all -> 0x010e, TryCatch #12 {all -> 0x010e, blocks: (B:55:0x00b1, B:57:0x00b5, B:58:0x00d2), top: B:54:0x00b1 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00f9 A[Catch: Exception -> 0x011f, IOException -> 0x0121, MalformedURLException -> 0x0123, all -> 0x0125, TRY_LEAVE, TryCatch #1 {all -> 0x0125, blocks: (B:10:0x0035, B:69:0x0113, B:71:0x011b, B:72:0x011e, B:61:0x00f1, B:63:0x00f9, B:19:0x0092, B:21:0x009a), top: B:9:0x0035 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0111 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x011b A[Catch: Exception -> 0x011f, IOException -> 0x0121, MalformedURLException -> 0x0123, all -> 0x0125, TryCatch #1 {all -> 0x0125, blocks: (B:10:0x0035, B:69:0x0113, B:71:0x011b, B:72:0x011e, B:61:0x00f1, B:63:0x00f9, B:19:0x0092, B:21:0x009a), top: B:9:0x0035 }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m206a(javax.net.ssl.HttpsURLConnection r14) {
        /*
            Method dump skipped, instructions count: 573
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.lbsapi.auth.C0628i.m206a(javax.net.ssl.HttpsURLConnection):void");
    }

    /* renamed from: b */
    private static String m207b(HashMap<String, String> hashMap) throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            if (z) {
                z = false;
            } else {
                sb.append("&");
            }
            sb.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
            sb.append("=");
            sb.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
        }
        return sb.toString();
    }

    /* renamed from: c */
    private HashMap<String, String> m209c(HashMap<String, String> hashMap) {
        HashMap<String, String> hashMap2 = new HashMap<>();
        Iterator<String> it = hashMap.keySet().iterator();
        while (it.hasNext()) {
            String str = it.next().toString();
            hashMap2.put(str, hashMap.get(str));
        }
        return hashMap2;
    }
}