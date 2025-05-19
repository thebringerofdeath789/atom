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
/* loaded from: classes.dex */
public class i {
    private Context a;
    private String b = null;
    private HashMap<String, String> c = null;
    private String d = null;

    public i(Context context) {
        this.a = context;
    }

    protected String a(HashMap<String, String> hashMap) {
        HashMap<String, String> c = c(hashMap);
        this.c = c;
        this.b = c.get("url");
        HttpsURLConnection b = b();
        if (b == null) {
            b.c("syncConnect failed,httpsURLConnection is null");
            return this.d;
        }
        a(b);
        return this.d;
    }

    protected boolean a() {
        b.a("checkNetwork start");
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.a.getSystemService("connectivity");
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
            b.a("checkNetwork end");
            return true;
        } catch (Exception e) {
            if (b.a) {
                e.printStackTrace();
            }
            return false;
        }
    }

    private HttpsURLConnection b() {
        HttpsURLConnection httpsURLConnection;
        try {
            URL url = new URL(this.b);
            b.a("https URL: " + this.b);
            String a = a(this.a);
            if (a != null && !a.equals("")) {
                b.a("checkNetwork = " + a);
                if (a.equals("cmwap")) {
                    httpsURLConnection = (HttpsURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.0.0.172", 80)));
                } else if (a.equals("ctwap")) {
                    httpsURLConnection = (HttpsURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.0.0.200", 80)));
                } else {
                    httpsURLConnection = (HttpsURLConnection) url.openConnection();
                }
                httpsURLConnection.setHostnameVerifier(new j(this));
                httpsURLConnection.setDoInput(true);
                httpsURLConnection.setDoOutput(true);
                httpsURLConnection.setRequestMethod("POST");
                httpsURLConnection.setConnectTimeout(50000);
                httpsURLConnection.setReadTimeout(50000);
                return httpsURLConnection;
            }
            b.c("Current network is not available.");
            this.d = ErrorMessage.a(-10, "Current network is not available.");
            return null;
        } catch (MalformedURLException e) {
            if (b.a) {
                e.printStackTrace();
                b.a(e.getMessage());
            }
            this.d = ErrorMessage.a(-11, "Auth server could not be parsed as a URL.");
            return null;
        } catch (Exception e2) {
            if (b.a) {
                e2.printStackTrace();
                b.a(e2.getMessage());
            }
            this.d = ErrorMessage.a(-11, "Init httpsurlconnection failed.");
            return null;
        }
    }

    private String a(Context context) {
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
            if (b.a) {
                e.printStackTrace();
            }
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:113:0x01ce, code lost:
    
        if (com.baidu.lbsapi.auth.b.a == false) goto L128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x016b, code lost:
    
        r14.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x019c, code lost:
    
        if (com.baidu.lbsapi.auth.b.a == false) goto L128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x0169, code lost:
    
        if (com.baidu.lbsapi.auth.b.a == false) goto L128;
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
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(javax.net.ssl.HttpsURLConnection r14) {
        /*
            Method dump skipped, instructions count: 573
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.lbsapi.auth.i.a(javax.net.ssl.HttpsURLConnection):void");
    }

    private static String b(HashMap<String, String> hashMap) throws UnsupportedEncodingException {
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

    private HashMap<String, String> c(HashMap<String, String> hashMap) {
        HashMap<String, String> hashMap2 = new HashMap<>();
        Iterator<String> it = hashMap.keySet().iterator();
        while (it.hasNext()) {
            String str = it.next().toString();
            hashMap2.put(str, hashMap.get(str));
        }
        return hashMap2;
    }
}
