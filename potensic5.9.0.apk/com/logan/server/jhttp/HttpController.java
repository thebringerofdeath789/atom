package com.logan.server.jhttp;

import java.util.regex.Matcher;

/* loaded from: classes3.dex */
public class HttpController implements IHttpRouter {
    protected HttpRequest request;
    protected HttpResponse response;

    @Override // com.logan.server.jhttp.IHttpRouter
    public void onRoute(HttpRequest httpRequest, HttpResponse httpResponse) {
        this.request = httpRequest;
        this.response = httpResponse;
        Matcher pathinfo = httpRequest.getPathinfo();
        String group = (pathinfo == null || pathinfo.groupCount() == 0) ? null : pathinfo.group("action");
        if (group == null) {
            httpResponse.setStatus(404);
            return;
        }
        try {
            getClass().getMethod(group, new Class[0]).invoke(this, new Object[0]);
        } catch (Exception unused) {
            httpResponse.setStatus(404);
        }
    }
}