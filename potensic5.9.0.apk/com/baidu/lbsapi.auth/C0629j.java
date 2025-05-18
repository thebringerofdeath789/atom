package com.baidu.lbsapi.auth;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

/* compiled from: HttpsHelper.java */
/* renamed from: com.baidu.lbsapi.auth.j */
/* loaded from: classes.dex */
class C0629j implements HostnameVerifier {

    /* renamed from: a */
    final /* synthetic */ C0628i f241a;

    C0629j(C0628i c0628i) {
        this.f241a = c0628i;
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        if ("api.map.baidu.com".equals(str)) {
            return true;
        }
        return HttpsURLConnection.getDefaultHostnameVerifier().verify(str, sSLSession);
    }
}