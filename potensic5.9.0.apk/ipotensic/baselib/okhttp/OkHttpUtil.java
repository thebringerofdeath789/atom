package com.ipotensic.baselib.okhttp;

import android.util.Log;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.share2.ShareContentType;
import io.netty.handler.codec.http.multipart.HttpPostBodyUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/* loaded from: classes2.dex */
public class OkHttpUtil {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static volatile OkHttpUtil instance;
    private Call downloadCall;
    private Call galleryCall;
    private OkHttpClient galleryClient;
    private OkHttpClient okHttpClient;
    private Call uploadCall;
    private final String TAG = "DDLog";
    private final MediaType REQUEST_TYPE_JSON = MediaType.parse("application/json; charset=utf-8");
    private final MediaType REQUEST_TYPE_IMAGE = MediaType.parse(ShareContentType.IMAGE);
    private final MediaType REQUEST_TYPE_VIDEO = MediaType.parse(ShareContentType.VIDEO);
    private final int TIMEOUT = 20;

    private OkHttpUtil() {
        this.okHttpClient = null;
        this.galleryClient = null;
        this.okHttpClient = new OkHttpClient.Builder().addInterceptor(new LoggingInterceptor(LoggingLevel.ALL)).connectTimeout(20L, TimeUnit.SECONDS).retryOnConnectionFailure(false).build();
        this.galleryClient = new OkHttpClient.Builder().connectTimeout(20L, TimeUnit.SECONDS).retryOnConnectionFailure(true).build();
    }

    public static OkHttpUtil getInstance() {
        if (instance == null) {
            synchronized (OkHttpUtil.class) {
                if (instance == null) {
                    OkHttpUtil okHttpUtil = new OkHttpUtil();
                    instance = okHttpUtil;
                    return okHttpUtil;
                }
            }
        }
        return instance;
    }

    /* renamed from: com.ipotensic.baselib.okhttp.OkHttpUtil$1 */
    class AnonymousClass1 implements Callback {
        final /* synthetic */ CallBackString val$callback;

        AnonymousClass1(CallBackString callBackString) {
            r2 = callBackString;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            r2.onError(((Integer) call.request().tag()).intValue(), iOException);
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) throws IOException {
            r2.onSuccess(((Integer) call.request().tag()).intValue(), call, response);
        }
    }

    public void get(int i, String str, CallBackString callBackString) {
        this.okHttpClient.newCall(new Request.Builder().url(str).tag(Integer.valueOf(i)).get().build()).enqueue(new Callback() { // from class: com.ipotensic.baselib.okhttp.OkHttpUtil.1
            final /* synthetic */ CallBackString val$callback;

            AnonymousClass1(CallBackString callBackString2) {
                r2 = callBackString2;
            }

            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                r2.onError(((Integer) call.request().tag()).intValue(), iOException);
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                r2.onSuccess(((Integer) call.request().tag()).intValue(), call, response);
            }
        });
    }

    /* renamed from: com.ipotensic.baselib.okhttp.OkHttpUtil$2 */
    class AnonymousClass2 implements Callback {
        final /* synthetic */ CallBackString val$callback;

        AnonymousClass2(CallBackString callBackString) {
            r2 = callBackString;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            r2.onError(((Integer) call.request().tag()).intValue(), iOException);
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) throws IOException {
            r2.onSuccess(((Integer) call.request().tag()).intValue(), call, response);
        }
    }

    public void get1(int i, String str, CallBackString callBackString) {
        ClientManager.getInstance().getClient().newCall(new Request.Builder().url(str).tag(Integer.valueOf(i)).get().build()).enqueue(new Callback() { // from class: com.ipotensic.baselib.okhttp.OkHttpUtil.2
            final /* synthetic */ CallBackString val$callback;

            AnonymousClass2(CallBackString callBackString2) {
                r2 = callBackString2;
            }

            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                r2.onError(((Integer) call.request().tag()).intValue(), iOException);
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                r2.onSuccess(((Integer) call.request().tag()).intValue(), call, response);
            }
        });
    }

    public String getSync(int i, String str) throws Exception {
        return this.okHttpClient.newCall(new Request.Builder().url(str).tag(Integer.valueOf(i)).get().build()).execute().body().string();
    }

    public void get(int i, String str, String str2, String str3, CallBackUtil callBackUtil) {
        Request.Builder builder = new Request.Builder();
        builder.tag(Integer.valueOf(i));
        builder.addHeader(str2, str3.trim());
        builder.url(str);
        this.okHttpClient.newCall(builder.build()).enqueue(new Callback() { // from class: com.ipotensic.baselib.okhttp.OkHttpUtil.3
            final /* synthetic */ CallBackUtil val$callBack;

            AnonymousClass3(CallBackUtil callBackUtil2) {
                r2 = callBackUtil2;
            }

            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                r2.onError(((Integer) call.request().tag()).intValue(), call, iOException);
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                r2.onSuccess(((Integer) call.request().tag()).intValue(), call, response);
            }
        });
    }

    /* renamed from: com.ipotensic.baselib.okhttp.OkHttpUtil$3 */
    class AnonymousClass3 implements Callback {
        final /* synthetic */ CallBackUtil val$callBack;

        AnonymousClass3(CallBackUtil callBackUtil2) {
            r2 = callBackUtil2;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            r2.onError(((Integer) call.request().tag()).intValue(), call, iOException);
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) throws IOException {
            r2.onSuccess(((Integer) call.request().tag()).intValue(), call, response);
        }
    }

    public void post(int i, String str, CallBackString callBackString) {
        this.okHttpClient.newCall(new Request.Builder().url(str).tag(Integer.valueOf(i)).post(RequestBody.create((MediaType) null, "")).build()).enqueue(new Callback() { // from class: com.ipotensic.baselib.okhttp.OkHttpUtil.4
            final /* synthetic */ CallBackString val$callback;

            AnonymousClass4(CallBackString callBackString2) {
                r2 = callBackString2;
            }

            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                r2.onError(((Integer) call.request().tag()).intValue(), iOException);
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                r2.onSuccess(((Integer) call.request().tag()).intValue(), call, response);
            }
        });
    }

    /* renamed from: com.ipotensic.baselib.okhttp.OkHttpUtil$4 */
    class AnonymousClass4 implements Callback {
        final /* synthetic */ CallBackString val$callback;

        AnonymousClass4(CallBackString callBackString2) {
            r2 = callBackString2;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            r2.onError(((Integer) call.request().tag()).intValue(), iOException);
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) throws IOException {
            r2.onSuccess(((Integer) call.request().tag()).intValue(), call, response);
        }
    }

    public void postJson(int i, String str, String str2, CallBackUtil callBackUtil) {
        Request.Builder builder = new Request.Builder();
        builder.tag(Integer.valueOf(i));
        builder.post(RequestBody.create(this.REQUEST_TYPE_JSON, str2));
        builder.url(str);
        Request build = builder.build();
        OkHttpClient okHttpClient = this.okHttpClient;
        if (okHttpClient != null) {
            okHttpClient.newCall(build).enqueue(new Callback() { // from class: com.ipotensic.baselib.okhttp.OkHttpUtil.5
                final /* synthetic */ CallBackUtil val$callBack;

                AnonymousClass5(CallBackUtil callBackUtil2) {
                    r2 = callBackUtil2;
                }

                @Override // okhttp3.Callback
                public void onFailure(Call call, IOException iOException) {
                    CallBackUtil callBackUtil2 = r2;
                    if (callBackUtil2 != null) {
                        callBackUtil2.onError(((Integer) call.request().tag()).intValue(), call, iOException);
                    }
                }

                @Override // okhttp3.Callback
                public void onResponse(Call call, Response response) throws IOException {
                    CallBackUtil callBackUtil2 = r2;
                    if (callBackUtil2 != null) {
                        callBackUtil2.onSuccess(((Integer) call.request().tag()).intValue(), call, response);
                    }
                }
            });
        }
    }

    /* renamed from: com.ipotensic.baselib.okhttp.OkHttpUtil$5 */
    class AnonymousClass5 implements Callback {
        final /* synthetic */ CallBackUtil val$callBack;

        AnonymousClass5(CallBackUtil callBackUtil2) {
            r2 = callBackUtil2;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            CallBackUtil callBackUtil2 = r2;
            if (callBackUtil2 != null) {
                callBackUtil2.onError(((Integer) call.request().tag()).intValue(), call, iOException);
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) throws IOException {
            CallBackUtil callBackUtil2 = r2;
            if (callBackUtil2 != null) {
                callBackUtil2.onSuccess(((Integer) call.request().tag()).intValue(), call, response);
            }
        }
    }

    public void postJson(int i, String str, String str2, CallBackString callBackString) {
        Request.Builder builder = new Request.Builder();
        builder.tag(Integer.valueOf(i));
        builder.post(RequestBody.create(this.REQUEST_TYPE_JSON, str2));
        builder.url(str);
        ClientManager.getInstance().getClient().newCall(builder.build()).enqueue(new Callback() { // from class: com.ipotensic.baselib.okhttp.OkHttpUtil.6
            final /* synthetic */ CallBackString val$callBack;

            AnonymousClass6(CallBackString callBackString2) {
                r2 = callBackString2;
            }

            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                DDLog.e("\u8bf7\u6c42\u9519\u8bef:" + iOException.getClass().getSimpleName() + "," + iOException.getMessage());
                CallBackString callBackString2 = r2;
                if (callBackString2 != null) {
                    callBackString2.onError(((Integer) call.request().tag()).intValue(), iOException);
                }
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                CallBackString callBackString2 = r2;
                if (callBackString2 != null) {
                    callBackString2.onSuccess(((Integer) call.request().tag()).intValue(), call, response);
                }
            }
        });
    }

    /* renamed from: com.ipotensic.baselib.okhttp.OkHttpUtil$6 */
    class AnonymousClass6 implements Callback {
        final /* synthetic */ CallBackString val$callBack;

        AnonymousClass6(CallBackString callBackString2) {
            r2 = callBackString2;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            DDLog.e("\u8bf7\u6c42\u9519\u8bef:" + iOException.getClass().getSimpleName() + "," + iOException.getMessage());
            CallBackString callBackString2 = r2;
            if (callBackString2 != null) {
                callBackString2.onError(((Integer) call.request().tag()).intValue(), iOException);
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) throws IOException {
            CallBackString callBackString2 = r2;
            if (callBackString2 != null) {
                callBackString2.onSuccess(((Integer) call.request().tag()).intValue(), call, response);
            }
        }
    }

    public void postJsonSync(int i, String str, String str2, CallBackString callBackString) {
        try {
            Request.Builder builder = new Request.Builder();
            builder.tag(Integer.valueOf(i));
            builder.post(RequestBody.create(this.REQUEST_TYPE_JSON, str2));
            builder.url(str);
            Call newCall = ClientManager.getInstance().getClient().newCall(builder.build());
            Response execute = newCall.execute();
            if (callBackString != null) {
                callBackString.onSuccess(i, newCall, execute);
            }
        } catch (Exception e) {
            if (callBackString != null) {
                callBackString.onError(i, e);
            }
        }
    }

    public void postJson(int i, String str, String str2, Map<String, String> map, CallBackUtil callBackUtil) {
        Request.Builder builder = new Request.Builder();
        builder.tag(Integer.valueOf(i));
        for (String str3 : map.keySet()) {
            String str4 = map.get(str3);
            if (str4 == null) {
                builder.addHeader(str3, "");
            } else {
                builder.addHeader(str3, str4);
            }
        }
        builder.post(RequestBody.create(this.REQUEST_TYPE_JSON, str2));
        builder.url(str);
        Request build = builder.build();
        OkHttpClient okHttpClient = this.okHttpClient;
        if (okHttpClient != null) {
            okHttpClient.newCall(build).enqueue(new Callback() { // from class: com.ipotensic.baselib.okhttp.OkHttpUtil.7
                final /* synthetic */ CallBackUtil val$callBack;

                AnonymousClass7(CallBackUtil callBackUtil2) {
                    r2 = callBackUtil2;
                }

                @Override // okhttp3.Callback
                public void onFailure(Call call, IOException iOException) {
                    CallBackUtil callBackUtil2 = r2;
                    if (callBackUtil2 != null) {
                        callBackUtil2.onError(((Integer) call.request().tag()).intValue(), call, iOException);
                    }
                }

                @Override // okhttp3.Callback
                public void onResponse(Call call, Response response) throws IOException {
                    CallBackUtil callBackUtil2 = r2;
                    if (callBackUtil2 != null) {
                        callBackUtil2.onSuccess(((Integer) call.request().tag()).intValue(), call, response);
                    }
                }
            });
        }
    }

    /* renamed from: com.ipotensic.baselib.okhttp.OkHttpUtil$7 */
    class AnonymousClass7 implements Callback {
        final /* synthetic */ CallBackUtil val$callBack;

        AnonymousClass7(CallBackUtil callBackUtil2) {
            r2 = callBackUtil2;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            CallBackUtil callBackUtil2 = r2;
            if (callBackUtil2 != null) {
                callBackUtil2.onError(((Integer) call.request().tag()).intValue(), call, iOException);
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) throws IOException {
            CallBackUtil callBackUtil2 = r2;
            if (callBackUtil2 != null) {
                callBackUtil2.onSuccess(((Integer) call.request().tag()).intValue(), call, response);
            }
        }
    }

    public void postJsonAndFile(int i, String str, HashMap<String, String> hashMap, String str2, File file, CallBackUtil callBackUtil) {
        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.setType(MultipartBody.FORM);
        for (String str3 : hashMap.keySet()) {
            builder.addFormDataPart(str3, hashMap.get(str3));
        }
        builder.addFormDataPart(str2, file.getName(), RequestBody.create(this.REQUEST_TYPE_IMAGE, file));
        Request build = new Request.Builder().tag(Integer.valueOf(i)).url(str).post(builder.build()).build();
        DDLog.e("okhttp client:" + this.okHttpClient);
        if (ClientManager.getInstance().getClient() != null) {
            ClientManager.getInstance().getClient().newCall(build).enqueue(new Callback() { // from class: com.ipotensic.baselib.okhttp.OkHttpUtil.8
                final /* synthetic */ CallBackUtil val$callBack;

                AnonymousClass8(CallBackUtil callBackUtil2) {
                    r2 = callBackUtil2;
                }

                @Override // okhttp3.Callback
                public void onFailure(Call call, IOException iOException) {
                    CallBackUtil callBackUtil2 = r2;
                    if (callBackUtil2 != null) {
                        callBackUtil2.onError(((Integer) call.request().tag()).intValue(), call, iOException);
                    }
                }

                @Override // okhttp3.Callback
                public void onResponse(Call call, Response response) throws IOException {
                    CallBackUtil callBackUtil2 = r2;
                    if (callBackUtil2 != null) {
                        callBackUtil2.onSuccess(((Integer) call.request().tag()).intValue(), call, response);
                    }
                }
            });
        }
    }

    /* renamed from: com.ipotensic.baselib.okhttp.OkHttpUtil$8 */
    class AnonymousClass8 implements Callback {
        final /* synthetic */ CallBackUtil val$callBack;

        AnonymousClass8(CallBackUtil callBackUtil2) {
            r2 = callBackUtil2;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            CallBackUtil callBackUtil2 = r2;
            if (callBackUtil2 != null) {
                callBackUtil2.onError(((Integer) call.request().tag()).intValue(), call, iOException);
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) throws IOException {
            CallBackUtil callBackUtil2 = r2;
            if (callBackUtil2 != null) {
                callBackUtil2.onSuccess(((Integer) call.request().tag()).intValue(), call, response);
            }
        }
    }

    public void postFile(int i, String str, HashMap<String, String> hashMap, String str2, String str3, CallBackString callBackString) {
        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.setType(MultipartBody.FORM);
        if (hashMap == null) {
            return;
        }
        for (String str4 : hashMap.keySet()) {
            String str5 = hashMap.get(str4);
            if (str5 == null) {
                builder.addFormDataPart(str4, "");
            } else {
                builder.addFormDataPart(str4, str5);
            }
        }
        File file = new File(str3);
        if (file.exists()) {
            builder.addFormDataPart(str2, file.getName(), RequestBody.create(this.REQUEST_TYPE_JSON, file));
        }
        ClientManager.getInstance().getClient().newCall(new Request.Builder().tag(Integer.valueOf(i)).url(str).post(builder.build()).build()).enqueue(new Callback() { // from class: com.ipotensic.baselib.okhttp.OkHttpUtil.9
            final /* synthetic */ CallBackString val$callBack;

            AnonymousClass9(CallBackString callBackString2) {
                r2 = callBackString2;
            }

            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                CallBackString callBackString2 = r2;
                if (callBackString2 != null) {
                    callBackString2.onError(((Integer) call.request().tag()).intValue(), iOException);
                }
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                CallBackString callBackString2 = r2;
                if (callBackString2 != null) {
                    callBackString2.onSuccess(((Integer) call.request().tag()).intValue(), call, response);
                }
            }
        });
    }

    /* renamed from: com.ipotensic.baselib.okhttp.OkHttpUtil$9 */
    class AnonymousClass9 implements Callback {
        final /* synthetic */ CallBackString val$callBack;

        AnonymousClass9(CallBackString callBackString2) {
            r2 = callBackString2;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            CallBackString callBackString2 = r2;
            if (callBackString2 != null) {
                callBackString2.onError(((Integer) call.request().tag()).intValue(), iOException);
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) throws IOException {
            CallBackString callBackString2 = r2;
            if (callBackString2 != null) {
                callBackString2.onSuccess(((Integer) call.request().tag()).intValue(), call, response);
            }
        }
    }

    public void postFileSync(int i, String str, HashMap<String, String> hashMap, String str2, String str3, CallBackString callBackString) {
        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.setType(MultipartBody.FORM);
        if (hashMap == null) {
            return;
        }
        for (String str4 : hashMap.keySet()) {
            String str5 = hashMap.get(str4);
            if (str5 == null) {
                builder.addFormDataPart(str4, "");
            } else {
                builder.addFormDataPart(str4, str5);
            }
        }
        File file = new File(str3);
        if (file.exists()) {
            builder.addFormDataPart(str2, file.getName(), RequestBody.create(this.REQUEST_TYPE_JSON, file));
        }
        ClientManager.getInstance().getClient().newCall(new Request.Builder().tag(Integer.valueOf(i)).url(str).post(builder.build()).build()).enqueue(new Callback() { // from class: com.ipotensic.baselib.okhttp.OkHttpUtil.10
            final /* synthetic */ CallBackString val$callBack;

            AnonymousClass10(CallBackString callBackString2) {
                r2 = callBackString2;
            }

            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                DDLog.e("\u4e0a\u4f20\u5931\u8d25:" + iOException.getMessage());
                CallBackString callBackString2 = r2;
                if (callBackString2 != null) {
                    callBackString2.onError(((Integer) call.request().tag()).intValue(), iOException);
                }
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                CallBackString callBackString2 = r2;
                if (callBackString2 != null) {
                    callBackString2.onSuccess(((Integer) call.request().tag()).intValue(), call, response);
                }
            }
        });
    }

    /* renamed from: com.ipotensic.baselib.okhttp.OkHttpUtil$10 */
    class AnonymousClass10 implements Callback {
        final /* synthetic */ CallBackString val$callBack;

        AnonymousClass10(CallBackString callBackString2) {
            r2 = callBackString2;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            DDLog.e("\u4e0a\u4f20\u5931\u8d25:" + iOException.getMessage());
            CallBackString callBackString2 = r2;
            if (callBackString2 != null) {
                callBackString2.onError(((Integer) call.request().tag()).intValue(), iOException);
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) throws IOException {
            CallBackString callBackString2 = r2;
            if (callBackString2 != null) {
                callBackString2.onSuccess(((Integer) call.request().tag()).intValue(), call, response);
            }
        }
    }

    public void postJsonAndFiles(int i, String str, HashMap<String, String> hashMap, String str2, String[] strArr, CallBackString callBackString) {
        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.setType(MultipartBody.FORM);
        for (String str3 : hashMap.keySet()) {
            builder.addFormDataPart(str3, hashMap.get(str3));
        }
        for (String str4 : strArr) {
            if (str4 != null) {
                File file = new File(str4);
                if (file.exists()) {
                    builder.addFormDataPart(str2, file.getName(), RequestBody.create(this.REQUEST_TYPE_IMAGE, file));
                }
            }
        }
        ClientManager.getInstance().getClient().newCall(new Request.Builder().tag(Integer.valueOf(i)).url(str).post(builder.build()).build()).enqueue(new Callback() { // from class: com.ipotensic.baselib.okhttp.OkHttpUtil.11
            final /* synthetic */ CallBackString val$callBack;

            AnonymousClass11(CallBackString callBackString2) {
                r2 = callBackString2;
            }

            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                CallBackString callBackString2 = r2;
                if (callBackString2 != null) {
                    callBackString2.onError(((Integer) call.request().tag()).intValue(), iOException);
                }
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                CallBackString callBackString2 = r2;
                if (callBackString2 != null) {
                    callBackString2.onSuccess(((Integer) call.request().tag()).intValue(), call, response);
                }
            }
        });
    }

    /* renamed from: com.ipotensic.baselib.okhttp.OkHttpUtil$11 */
    class AnonymousClass11 implements Callback {
        final /* synthetic */ CallBackString val$callBack;

        AnonymousClass11(CallBackString callBackString2) {
            r2 = callBackString2;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            CallBackString callBackString2 = r2;
            if (callBackString2 != null) {
                callBackString2.onError(((Integer) call.request().tag()).intValue(), iOException);
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) throws IOException {
            CallBackString callBackString2 = r2;
            if (callBackString2 != null) {
                callBackString2.onSuccess(((Integer) call.request().tag()).intValue(), call, response);
            }
        }
    }

    public void postJsonAndImageVideo(int i, String str, HashMap<String, String> hashMap, String str2, String str3, String str4, String[] strArr, CallBackString callBackString) {
        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.setType(MultipartBody.FORM);
        for (String str5 : hashMap.keySet()) {
            String str6 = hashMap.get(str5);
            if (str6 == null) {
                builder.addFormDataPart(str5, "");
            } else {
                builder.addFormDataPart(str5, str6);
            }
        }
        for (String str7 : strArr) {
            if (str7 != null) {
                File file = new File(str7);
                if (file.exists()) {
                    builder.addFormDataPart(str2, file.getName(), RequestBody.create(this.REQUEST_TYPE_IMAGE, file));
                }
            }
        }
        if (str3 != null) {
            File file2 = new File(str3);
            if (file2.exists()) {
                builder.addFormDataPart("video", file2.getName(), RequestBody.create(this.REQUEST_TYPE_VIDEO, file2));
            }
        }
        if (str4 != null) {
            File file3 = new File(str4);
            if (file3.exists()) {
                builder.addFormDataPart("video_thumbnail", file3.getName(), RequestBody.create(this.REQUEST_TYPE_IMAGE, file3));
            }
        }
        ClientManager.getInstance().getClient().newCall(new Request.Builder().tag(Integer.valueOf(i)).url(str).post(builder.build()).build()).enqueue(new Callback() { // from class: com.ipotensic.baselib.okhttp.OkHttpUtil.12
            final /* synthetic */ CallBackString val$callBack;

            AnonymousClass12(CallBackString callBackString2) {
                r2 = callBackString2;
            }

            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                CallBackString callBackString2 = r2;
                if (callBackString2 != null) {
                    callBackString2.onError(((Integer) call.request().tag()).intValue(), iOException);
                }
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                CallBackString callBackString2 = r2;
                if (callBackString2 != null) {
                    callBackString2.onSuccess(((Integer) call.request().tag()).intValue(), call, response);
                }
            }
        });
    }

    /* renamed from: com.ipotensic.baselib.okhttp.OkHttpUtil$12 */
    class AnonymousClass12 implements Callback {
        final /* synthetic */ CallBackString val$callBack;

        AnonymousClass12(CallBackString callBackString2) {
            r2 = callBackString2;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            CallBackString callBackString2 = r2;
            if (callBackString2 != null) {
                callBackString2.onError(((Integer) call.request().tag()).intValue(), iOException);
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) throws IOException {
            CallBackString callBackString2 = r2;
            if (callBackString2 != null) {
                callBackString2.onSuccess(((Integer) call.request().tag()).intValue(), call, response);
            }
        }
    }

    public synchronized void downloadGalleryFileSync(int i, String str, String str2, String str3, long j, DownloadListener downloadListener) throws Exception {
        DDLog.e("DDLog", "\u4e0b\u8f7d\u6587\u4ef61: " + str);
        Request build = new Request.Builder().url(str).tag(Integer.valueOf(i)).get().build();
        OkHttpClient okHttpClient = this.galleryClient;
        if (okHttpClient != null) {
            Call newCall = okHttpClient.newCall(build);
            this.galleryCall = newCall;
            saveFile(newCall.execute(), str2, str3, j, downloadListener);
        }
    }

    public void downloadFileSync(int i, String str, String str2, String str3, long j, DownloadListener downloadListener) throws Exception {
        DDLog.e("DDLog", "\u4e0b\u8f7d\u6587\u4ef61: " + str);
        Call newCall = ClientManager.getInstance().getClient().newCall(new Request.Builder().url(str).tag(Integer.valueOf(i)).get().build());
        this.downloadCall = newCall;
        saveFile(newCall.execute(), str2, str3, j, downloadListener);
    }

    public synchronized void downloadUpgradeFileSync(String str, int i, String str2, String str3, String str4, long j, DownloadListener downloadListener) throws Exception {
        DDLog.e("DDLog", "\u4e0b\u8f7d\u6587\u4ef6: " + str2);
        Call newCall = ClientManager.getInstance().getClient().newCall(new Request.Builder().url(str2).tag(Integer.valueOf(i)).get().build());
        this.downloadCall = newCall;
        saveUpgradeFile(str, newCall.execute(), str3, str4, j, downloadListener);
    }

    public synchronized void downloadUpgradeFileSyncManual(String str, String str2, int i, String str3, String str4, String str5, long j, DownloadListener2 downloadListener2) throws Exception {
        DDLog.e("DDLog", "\u4e0b\u8f7d\u6587\u4ef6: " + str3);
        Call newCall = ClientManager.getInstance().getClient().newCall(new Request.Builder().url(str3).tag(Integer.valueOf(i)).get().build());
        this.downloadCall = newCall;
        saveUpgradeFileManual(str, str2, newCall.execute(), str4, str5, j, downloadListener2);
    }

    public void cancelDownload() {
        Call call = this.downloadCall;
        if (call != null && !call.getCanceled()) {
            this.downloadCall.cancel();
        }
        Call call2 = this.galleryCall;
        if (call2 == null || call2.getCanceled()) {
            return;
        }
        this.galleryCall.cancel();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00c1 A[Catch: IOException -> 0x00c9, TryCatch #0 {IOException -> 0x00c9, blocks: (B:49:0x00b8, B:51:0x00c1, B:53:0x00c6), top: B:48:0x00b8 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00c6 A[Catch: IOException -> 0x00c9, TRY_LEAVE, TryCatch #0 {IOException -> 0x00c9, blocks: (B:49:0x00b8, B:51:0x00c1, B:53:0x00c6), top: B:48:0x00b8 }] */
    /* JADX WARN: Type inference failed for: r11v1, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void saveFile(Response response, String str, String str2, long j, DownloadListener downloadListener) {
        ?? r11;
        FileOutputStream fileOutputStream;
        InputStream inputStream;
        byte[] bArr = new byte[8192];
        InputStream inputStream2 = null;
        r13 = null;
        File file = null;
        try {
            try {
                try {
                    downloadListener.onDownloadStart();
                    inputStream = response.body().byteStream();
                    try {
                        try {
                            long contentLength = response.body().getContentLength();
                            long j2 = 0;
                            File file2 = new File(str);
                            if (!file2.exists()) {
                                file2.mkdirs();
                            }
                            File file3 = new File(file2, str2);
                            try {
                                fileOutputStream = new FileOutputStream(file3);
                                while (true) {
                                    try {
                                        int read = inputStream.read(bArr);
                                        if (read == -1) {
                                            break;
                                        }
                                        j2 += read;
                                        fileOutputStream.write(bArr, 0, read);
                                        downloadListener.onDownloadProgress((j2 * 100.0f) / contentLength, contentLength);
                                    } catch (Exception e) {
                                        file = file3;
                                        e = e;
                                        e.printStackTrace();
                                        Log.i("DDLog", "\u4e0b\u8f7d\u6587\u4ef6downlaod error: " + e.getMessage());
                                        if (file != null && file.exists()) {
                                            file.delete();
                                        }
                                        downloadListener.onDownloadError(e);
                                        response.body().close();
                                        if (inputStream != null) {
                                            inputStream.close();
                                        }
                                        if (fileOutputStream == null) {
                                            return;
                                        }
                                        fileOutputStream.close();
                                    }
                                }
                                fileOutputStream.flush();
                                downloadListener.onDownloadEnd(file3.getAbsolutePath());
                                response.body().close();
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                            } catch (Exception e2) {
                                file = file3;
                                e = e2;
                                fileOutputStream = null;
                            }
                        } catch (Throwable th) {
                            th = th;
                            str2 = null;
                            inputStream2 = inputStream;
                            r11 = str2;
                            try {
                                response.body().close();
                                if (inputStream2 != null) {
                                    inputStream2.close();
                                }
                                if (r11 != 0) {
                                    r11.close();
                                }
                            } catch (IOException unused) {
                            }
                            throw th;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        fileOutputStream = null;
                    }
                } catch (Exception e4) {
                    e = e4;
                    fileOutputStream = null;
                    inputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    r11 = 0;
                    response.body().close();
                    if (inputStream2 != null) {
                    }
                    if (r11 != 0) {
                    }
                    throw th;
                }
                fileOutputStream.close();
            } catch (IOException unused2) {
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00bc A[Catch: IOException -> 0x00c4, TryCatch #2 {IOException -> 0x00c4, blocks: (B:49:0x00b3, B:51:0x00bc, B:53:0x00c1), top: B:48:0x00b3 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00c1 A[Catch: IOException -> 0x00c4, TRY_LEAVE, TryCatch #2 {IOException -> 0x00c4, blocks: (B:49:0x00b3, B:51:0x00bc, B:53:0x00c1), top: B:48:0x00b3 }] */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v3, types: [java.io.FileOutputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void saveUpgradeFile(String str, Response response, String str2, String str3, long j, DownloadListener downloadListener) {
        ?? r11;
        FileOutputStream fileOutputStream;
        InputStream inputStream;
        byte[] bArr = new byte[8192];
        InputStream inputStream2 = null;
        r13 = null;
        File file = null;
        try {
            try {
                try {
                    downloadListener.onDownloadStart();
                    inputStream = response.body().byteStream();
                    try {
                        try {
                            long contentLength = response.body().getContentLength();
                            long j2 = 0;
                            File file2 = new File(str2);
                            if (!file2.exists()) {
                                file2.mkdirs();
                            }
                            File file3 = new File(file2, str3);
                            try {
                                fileOutputStream = new FileOutputStream(file3);
                                while (true) {
                                    try {
                                        int read = inputStream.read(bArr);
                                        if (read == -1) {
                                            break;
                                        }
                                        j2 += read;
                                        fileOutputStream.write(bArr, 0, read);
                                        downloadListener.onDownloadProgress((100 * j2) / contentLength, contentLength);
                                    } catch (Exception e) {
                                        e = e;
                                        file = file3;
                                        e.printStackTrace();
                                        Log.i("DDLog", "downlaod error: " + e.getMessage());
                                        if (file != null && file.exists()) {
                                            file.delete();
                                        }
                                        downloadListener.onDownloadError(e);
                                        response.body().close();
                                        if (inputStream != null) {
                                            inputStream.close();
                                        }
                                        if (fileOutputStream == null) {
                                            return;
                                        }
                                        fileOutputStream.close();
                                    }
                                }
                                fileOutputStream.flush();
                                downloadListener.onDownloadEnd(file3.getAbsolutePath(), str);
                                response.body().close();
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                            } catch (Exception e2) {
                                e = e2;
                                fileOutputStream = null;
                            }
                        } catch (Throwable th) {
                            th = th;
                            str3 = null;
                            inputStream2 = inputStream;
                            r11 = str3;
                            try {
                                response.body().close();
                                if (inputStream2 != null) {
                                    inputStream2.close();
                                }
                                if (r11 != 0) {
                                    r11.close();
                                }
                            } catch (IOException unused) {
                            }
                            throw th;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        fileOutputStream = null;
                    }
                } catch (Exception e4) {
                    e = e4;
                    fileOutputStream = null;
                    inputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    r11 = 0;
                    response.body().close();
                    if (inputStream2 != null) {
                    }
                    if (r11 != 0) {
                    }
                    throw th;
                }
                fileOutputStream.close();
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (IOException unused2) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00ae A[Catch: IOException -> 0x00b6, TryCatch #1 {IOException -> 0x00b6, blocks: (B:49:0x00a5, B:51:0x00ae, B:53:0x00b3), top: B:48:0x00a5 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00b3 A[Catch: IOException -> 0x00b6, TRY_LEAVE, TryCatch #1 {IOException -> 0x00b6, blocks: (B:49:0x00a5, B:51:0x00ae, B:53:0x00b3), top: B:48:0x00a5 }] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v3, types: [java.io.FileOutputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void saveUpgradeFileManual(String str, String str2, Response response, String str3, String str4, long j, DownloadListener2 downloadListener2) {
        ?? r10;
        FileOutputStream fileOutputStream;
        InputStream inputStream;
        byte[] bArr = new byte[8192];
        InputStream inputStream2 = null;
        r12 = null;
        File file = null;
        try {
            try {
                try {
                    inputStream = response.body().byteStream();
                    try {
                        try {
                            response.body().getContentLength();
                            long j2 = 0;
                            File file2 = new File(str3);
                            if (!file2.exists()) {
                                file2.mkdirs();
                            }
                            File file3 = new File(file2, str4);
                            try {
                                fileOutputStream = new FileOutputStream(file3);
                                while (true) {
                                    try {
                                        int read = inputStream.read(bArr);
                                        if (read == -1) {
                                            break;
                                        }
                                        j2 += read;
                                        fileOutputStream.write(bArr, 0, read);
                                        downloadListener2.onDownloadProgress(j2);
                                    } catch (Exception e) {
                                        e = e;
                                        file = file3;
                                        DDLog.e("\u4e0b\u8f7d\u56fa\u4ef6\u5931\u8d25 : " + e.getMessage());
                                        if (file != null && file.exists()) {
                                            file.delete();
                                        }
                                        downloadListener2.onDownloadError(e);
                                        response.body().close();
                                        if (inputStream != null) {
                                            inputStream.close();
                                        }
                                        if (fileOutputStream == null) {
                                            return;
                                        }
                                        fileOutputStream.close();
                                    }
                                }
                                fileOutputStream.flush();
                                downloadListener2.onDownloadEnd(file3.getAbsolutePath(), str, str2);
                                response.body().close();
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                            } catch (Exception e2) {
                                e = e2;
                                fileOutputStream = null;
                            }
                        } catch (Throwable th) {
                            th = th;
                            str4 = null;
                            inputStream2 = inputStream;
                            r10 = str4;
                            try {
                                response.body().close();
                                if (inputStream2 != null) {
                                    inputStream2.close();
                                }
                                if (r10 != 0) {
                                    r10.close();
                                }
                            } catch (IOException unused) {
                            }
                            throw th;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        fileOutputStream = null;
                    }
                } catch (Exception e4) {
                    e = e4;
                    fileOutputStream = null;
                    inputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    r10 = 0;
                    response.body().close();
                    if (inputStream2 != null) {
                    }
                    if (r10 != 0) {
                    }
                    throw th;
                }
                fileOutputStream.close();
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (IOException unused2) {
        }
    }

    public void postUploadProgressFiles(int i, String str, Map<String, String> map, String str2, String[] strArr, CallBackString callBackString, OnUploadProgressListener onUploadProgressListener) {
        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.setType(MultipartBody.FORM);
        for (String str3 : map.keySet()) {
            String str4 = map.get(str3);
            if (str4 == null) {
                builder.addFormDataPart(str3, "");
            } else {
                builder.addFormDataPart(str3, str4);
            }
        }
        if (strArr != null) {
            for (String str5 : strArr) {
                File file = new File(str5);
                if (file.exists()) {
                    builder.addFormDataPart(str2, file.getName(), RequestBody.create(MediaType.parse(getMimeType(file.getName())), file));
                }
            }
        }
        Call newCall = ClientManager.getInstance().getClient().newCall(new Request.Builder().tag(Integer.valueOf(i)).url(str).post(onUploadProgressListener != null ? new ProgressRequestBody(builder.build(), onUploadProgressListener) : builder.build()).build());
        this.uploadCall = newCall;
        newCall.enqueue(new Callback() { // from class: com.ipotensic.baselib.okhttp.OkHttpUtil.13
            final /* synthetic */ CallBackString val$callBack;

            AnonymousClass13(CallBackString callBackString2) {
                r2 = callBackString2;
            }

            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                CallBackString callBackString2 = r2;
                if (callBackString2 != null) {
                    callBackString2.onError(((Integer) call.request().tag()).intValue(), iOException);
                }
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                CallBackString callBackString2 = r2;
                if (callBackString2 != null) {
                    callBackString2.onSuccess(((Integer) call.request().tag()).intValue(), call, response);
                }
            }
        });
    }

    /* renamed from: com.ipotensic.baselib.okhttp.OkHttpUtil$13 */
    class AnonymousClass13 implements Callback {
        final /* synthetic */ CallBackString val$callBack;

        AnonymousClass13(CallBackString callBackString2) {
            r2 = callBackString2;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            CallBackString callBackString2 = r2;
            if (callBackString2 != null) {
                callBackString2.onError(((Integer) call.request().tag()).intValue(), iOException);
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) throws IOException {
            CallBackString callBackString2 = r2;
            if (callBackString2 != null) {
                callBackString2.onSuccess(((Integer) call.request().tag()).intValue(), call, response);
            }
        }
    }

    public void cancelUpload() {
        Call call = this.uploadCall;
        if (call == null || call.getCanceled()) {
            return;
        }
        this.uploadCall.cancel();
    }

    private String getMimeType(String str) {
        String contentTypeFor = URLConnection.getFileNameMap().getContentTypeFor(str);
        return contentTypeFor == null ? HttpPostBodyUtil.DEFAULT_BINARY_CONTENT_TYPE : contentTypeFor;
    }
}