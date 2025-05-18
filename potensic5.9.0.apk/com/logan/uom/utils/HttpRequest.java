package com.logan.uom.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.listener.SimpleResultListener;
import com.ipotensic.baselib.okhttp.LoggingInterceptor;
import com.ipotensic.baselib.okhttp.LoggingLevel;
import com.logan.uom.UomConfig;
import com.logan.uom.bean.UomUploadBody;
import com.logan.uom.listeners.OnUomUploadListener;
import com.mapbox.mapboxsdk.style.layers.Property;
import io.netty.handler.codec.http.HttpHeaders;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

/* compiled from: HttpRequest.kt */
@Metadata(m2336bv = {1, 0, 3}, m2337d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002J\u001e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0007J)\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u0010\"\u00020\u0011H\u0007¢\u0006\u0002\u0010\u0012¨\u0006\u0013"}, m2338d2 = {"Lcom/logan/uom/utils/HttpRequest;", "", "()V", "getNoSSLOkHttpClient", "Lokhttp3/OkHttpClient;", "querySNRegisterState", "", "flightSNJson", "", "resultListener", "Lcom/ipotensic/baselib/listener/SimpleResultListener;", "", "uploadFlightRoute", "uploadListener", "Lcom/logan/uom/listeners/OnUomUploadListener;", TtmlNode.TAG_BODY, "", "Lcom/logan/uom/bean/UomUploadBody;", "(Lcom/logan/uom/listeners/OnUomUploadListener;[Lcom/logan/uom/bean/UomUploadBody;)V", "UomTask_release"}, m2339k = 1, m2340mv = {1, 1, 15})
/* loaded from: classes3.dex */
public final class HttpRequest {
    public static final HttpRequest INSTANCE = new HttpRequest();

    private HttpRequest() {
    }

    public final void uploadFlightRoute(OnUomUploadListener uploadListener, UomUploadBody... body) {
        Intrinsics.checkParameterIsNotNull(uploadListener, "uploadListener");
        Intrinsics.checkParameterIsNotNull(body, "body");
        String convertUomBodyToJson = UomConvert.INSTANCE.convertUomBodyToJson((UomUploadBody[]) Arrays.copyOf(body, body.length));
        DDLog.m1684e("uom json :" + convertUomBodyToJson);
        DDLog.m1684e("uom signature :" + SM3Util.encrypt(convertUomBodyToJson, UomConfig.APP_KEY));
        OkHttpClient noSSLOkHttpClient = getNoSSLOkHttpClient();
        Request.Builder builder = new Request.Builder();
        builder.addHeader("Content-Type", HttpHeaders.Values.APPLICATION_JSON);
        String encrypt = SM3Util.encrypt(convertUomBodyToJson, UomConfig.APP_KEY);
        Intrinsics.checkExpressionValueIsNotNull(encrypt, "SM3Util.encrypt(jsonData, UomConfig.APP_KEY)");
        builder.addHeader("signature", encrypt);
        builder.addHeader(Property.SYMBOL_Z_ORDER_SOURCE, String.valueOf(2));
        builder.addHeader("platform", UomConfig.HTTP_HEAD_PLATFORM);
        builder.addHeader("programVersion", UomConfig.HTTP_HEAD_PROGRAM_VERSION);
        try {
            ResponseBody body2 = noSSLOkHttpClient.newCall(builder.url(UomConfig.HTTP_URL_ADD_FLIGHT_ROUTE).post(RequestBody.INSTANCE.create(convertUomBodyToJson, MediaType.INSTANCE.parse("application/json; charset=utf-8"))).build()).execute().body();
            String string = body2 != null ? body2.string() : null;
            DDLog.m1684e("上传UOM成功 : " + string);
            JSONObject parseObject = JSON.parseObject(string);
            if (parseObject != null) {
                String string2 = parseObject.getString("result");
                int intValue = parseObject.getIntValue("code");
                if (string2.equals("success") && intValue == 200) {
                    uploadListener.onUploadSuccess();
                    return;
                } else {
                    uploadListener.onServerError(Integer.valueOf(intValue));
                    return;
                }
            }
            HttpRequest httpRequest = this;
            uploadListener.onServerError(null);
        } catch (Exception e) {
            DDLog.m1684e("上传UOM失败 : " + e);
            uploadListener.onUploadFailed(e);
        }
    }

    public final void querySNRegisterState(String flightSNJson, SimpleResultListener<Boolean> resultListener) {
        Intrinsics.checkParameterIsNotNull(flightSNJson, "flightSNJson");
        Intrinsics.checkParameterIsNotNull(resultListener, "resultListener");
        OkHttpClient noSSLOkHttpClient = getNoSSLOkHttpClient();
        Request.Builder builder = new Request.Builder();
        builder.addHeader("Content-Type", "application/json; charset=utf-8");
        try {
            ResponseBody body = noSSLOkHttpClient.newCall(builder.url(UomConfig.HTTP_URL_QUERY_REGISTER_ID).post(RequestBody.INSTANCE.create(flightSNJson, MediaType.INSTANCE.parse("application/json; charset=utf-8"))).build()).execute().body();
            DDLog.m1684e("查询UOM注册状态成功 : " + (body != null ? body.string() : null));
        } catch (Exception e) {
            DDLog.m1684e("查询UOM注册状态失败 : " + e);
            resultListener.onResult(false);
        }
    }

    private final OkHttpClient getNoSSLOkHttpClient() {
        try {
            TrustManager[] trustManagerArr = {new X509TrustManager() { // from class: com.logan.uom.utils.HttpRequest$getNoSSLOkHttpClient$trustAllCerts$1
                @Override // javax.net.ssl.X509TrustManager
                public void checkClientTrusted(X509Certificate[] chain, String authType) {
                    Intrinsics.checkParameterIsNotNull(chain, "chain");
                    Intrinsics.checkParameterIsNotNull(authType, "authType");
                }

                @Override // javax.net.ssl.X509TrustManager
                public void checkServerTrusted(X509Certificate[] chain, String authType) {
                    Intrinsics.checkParameterIsNotNull(chain, "chain");
                    Intrinsics.checkParameterIsNotNull(authType, "authType");
                }

                @Override // javax.net.ssl.X509TrustManager
                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[0];
                }
            }};
            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustManagerArr, new SecureRandom());
            Intrinsics.checkExpressionValueIsNotNull(sslContext, "sslContext");
            SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.addInterceptor(new LoggingInterceptor(LoggingLevel.ALL));
            Intrinsics.checkExpressionValueIsNotNull(sslSocketFactory, "sslSocketFactory");
            TrustManager trustManager = trustManagerArr[0];
            if (trustManager == null) {
                throw new TypeCastException("null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
            }
            builder.sslSocketFactory(sslSocketFactory, (X509TrustManager) trustManager);
            builder.hostnameVerifier(new HostnameVerifier() { // from class: com.logan.uom.utils.HttpRequest$getNoSSLOkHttpClient$1
                @Override // javax.net.ssl.HostnameVerifier
                public final boolean verify(String str, SSLSession sSLSession) {
                    return true;
                }
            });
            return builder.build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}