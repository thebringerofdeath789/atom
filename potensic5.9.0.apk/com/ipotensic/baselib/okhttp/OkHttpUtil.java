package com.ipotensic.baselib.okhttp;

import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.share2.ShareContentType;
import io.netty.handler.codec.http.multipart.HttpPostBodyUtil;
import java.io.File;
import java.io.IOException;
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

    public void get(int i, String str, final CallBackString callBackString) {
        this.okHttpClient.newCall(new Request.Builder().url(str).tag(Integer.valueOf(i)).get().build()).enqueue(new Callback() { // from class: com.ipotensic.baselib.okhttp.OkHttpUtil.1
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                callBackString.onError(((Integer) call.request().tag()).intValue(), iOException);
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                callBackString.onSuccess(((Integer) call.request().tag()).intValue(), call, response);
            }
        });
    }

    public void get1(int i, String str, final CallBackString callBackString) {
        ClientManager.getInstance().getClient().newCall(new Request.Builder().url(str).tag(Integer.valueOf(i)).get().build()).enqueue(new Callback() { // from class: com.ipotensic.baselib.okhttp.OkHttpUtil.2
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                callBackString.onError(((Integer) call.request().tag()).intValue(), iOException);
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                callBackString.onSuccess(((Integer) call.request().tag()).intValue(), call, response);
            }
        });
    }

    public String getSync(int i, String str) throws Exception {
        return this.okHttpClient.newCall(new Request.Builder().url(str).tag(Integer.valueOf(i)).get().build()).execute().body().string();
    }

    public void get(int i, String str, String str2, String str3, final CallBackUtil callBackUtil) {
        Request.Builder builder = new Request.Builder();
        builder.tag(Integer.valueOf(i));
        builder.addHeader(str2, str3.trim());
        builder.url(str);
        this.okHttpClient.newCall(builder.build()).enqueue(new Callback() { // from class: com.ipotensic.baselib.okhttp.OkHttpUtil.3
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                callBackUtil.onError(((Integer) call.request().tag()).intValue(), call, iOException);
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                callBackUtil.onSuccess(((Integer) call.request().tag()).intValue(), call, response);
            }
        });
    }

    public void post(int i, String str, final CallBackString callBackString) {
        this.okHttpClient.newCall(new Request.Builder().url(str).tag(Integer.valueOf(i)).post(RequestBody.create((MediaType) null, "")).build()).enqueue(new Callback() { // from class: com.ipotensic.baselib.okhttp.OkHttpUtil.4
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                callBackString.onError(((Integer) call.request().tag()).intValue(), iOException);
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                callBackString.onSuccess(((Integer) call.request().tag()).intValue(), call, response);
            }
        });
    }

    public void postJson(int i, String str, String str2, final CallBackUtil callBackUtil) {
        Request.Builder builder = new Request.Builder();
        builder.tag(Integer.valueOf(i));
        builder.post(RequestBody.create(this.REQUEST_TYPE_JSON, str2));
        builder.url(str);
        Request build = builder.build();
        OkHttpClient okHttpClient = this.okHttpClient;
        if (okHttpClient != null) {
            okHttpClient.newCall(build).enqueue(new Callback() { // from class: com.ipotensic.baselib.okhttp.OkHttpUtil.5
                @Override // okhttp3.Callback
                public void onFailure(Call call, IOException iOException) {
                    CallBackUtil callBackUtil2 = callBackUtil;
                    if (callBackUtil2 != null) {
                        callBackUtil2.onError(((Integer) call.request().tag()).intValue(), call, iOException);
                    }
                }

                @Override // okhttp3.Callback
                public void onResponse(Call call, Response response) throws IOException {
                    CallBackUtil callBackUtil2 = callBackUtil;
                    if (callBackUtil2 != null) {
                        callBackUtil2.onSuccess(((Integer) call.request().tag()).intValue(), call, response);
                    }
                }
            });
        }
    }

    public void postJson(int i, String str, String str2, final CallBackString callBackString) {
        Request.Builder builder = new Request.Builder();
        builder.tag(Integer.valueOf(i));
        builder.post(RequestBody.create(this.REQUEST_TYPE_JSON, str2));
        builder.url(str);
        ClientManager.getInstance().getClient().newCall(builder.build()).enqueue(new Callback() { // from class: com.ipotensic.baselib.okhttp.OkHttpUtil.6
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                DDLog.m1684e("请求错误:" + iOException.getClass().getSimpleName() + "," + iOException.getMessage());
                CallBackString callBackString2 = callBackString;
                if (callBackString2 != null) {
                    callBackString2.onError(((Integer) call.request().tag()).intValue(), iOException);
                }
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                CallBackString callBackString2 = callBackString;
                if (callBackString2 != null) {
                    callBackString2.onSuccess(((Integer) call.request().tag()).intValue(), call, response);
                }
            }
        });
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

    public void postJson(int i, String str, String str2, Map<String, String> map, final CallBackUtil callBackUtil) {
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
                @Override // okhttp3.Callback
                public void onFailure(Call call, IOException iOException) {
                    CallBackUtil callBackUtil2 = callBackUtil;
                    if (callBackUtil2 != null) {
                        callBackUtil2.onError(((Integer) call.request().tag()).intValue(), call, iOException);
                    }
                }

                @Override // okhttp3.Callback
                public void onResponse(Call call, Response response) throws IOException {
                    CallBackUtil callBackUtil2 = callBackUtil;
                    if (callBackUtil2 != null) {
                        callBackUtil2.onSuccess(((Integer) call.request().tag()).intValue(), call, response);
                    }
                }
            });
        }
    }

    public void postJsonAndFile(int i, String str, HashMap<String, String> hashMap, String str2, File file, final CallBackUtil callBackUtil) {
        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.setType(MultipartBody.FORM);
        for (String str3 : hashMap.keySet()) {
            builder.addFormDataPart(str3, hashMap.get(str3));
        }
        builder.addFormDataPart(str2, file.getName(), RequestBody.create(this.REQUEST_TYPE_IMAGE, file));
        Request build = new Request.Builder().tag(Integer.valueOf(i)).url(str).post(builder.build()).build();
        DDLog.m1684e("okhttp client:" + this.okHttpClient);
        if (ClientManager.getInstance().getClient() != null) {
            ClientManager.getInstance().getClient().newCall(build).enqueue(new Callback() { // from class: com.ipotensic.baselib.okhttp.OkHttpUtil.8
                @Override // okhttp3.Callback
                public void onFailure(Call call, IOException iOException) {
                    CallBackUtil callBackUtil2 = callBackUtil;
                    if (callBackUtil2 != null) {
                        callBackUtil2.onError(((Integer) call.request().tag()).intValue(), call, iOException);
                    }
                }

                @Override // okhttp3.Callback
                public void onResponse(Call call, Response response) throws IOException {
                    CallBackUtil callBackUtil2 = callBackUtil;
                    if (callBackUtil2 != null) {
                        callBackUtil2.onSuccess(((Integer) call.request().tag()).intValue(), call, response);
                    }
                }
            });
        }
    }

    public void postFile(int i, String str, HashMap<String, String> hashMap, String str2, String str3, final CallBackString callBackString) {
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
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                CallBackString callBackString2 = callBackString;
                if (callBackString2 != null) {
                    callBackString2.onError(((Integer) call.request().tag()).intValue(), iOException);
                }
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                CallBackString callBackString2 = callBackString;
                if (callBackString2 != null) {
                    callBackString2.onSuccess(((Integer) call.request().tag()).intValue(), call, response);
                }
            }
        });
    }

    public void postFileSync(int i, String str, HashMap<String, String> hashMap, String str2, String str3, final CallBackString callBackString) {
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
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                DDLog.m1684e("上传失败:" + iOException.getMessage());
                CallBackString callBackString2 = callBackString;
                if (callBackString2 != null) {
                    callBackString2.onError(((Integer) call.request().tag()).intValue(), iOException);
                }
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                CallBackString callBackString2 = callBackString;
                if (callBackString2 != null) {
                    callBackString2.onSuccess(((Integer) call.request().tag()).intValue(), call, response);
                }
            }
        });
    }

    public void postJsonAndFiles(int i, String str, HashMap<String, String> hashMap, String str2, String[] strArr, final CallBackString callBackString) {
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
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                CallBackString callBackString2 = callBackString;
                if (callBackString2 != null) {
                    callBackString2.onError(((Integer) call.request().tag()).intValue(), iOException);
                }
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                CallBackString callBackString2 = callBackString;
                if (callBackString2 != null) {
                    callBackString2.onSuccess(((Integer) call.request().tag()).intValue(), call, response);
                }
            }
        });
    }

    public void postJsonAndImageVideo(int i, String str, HashMap<String, String> hashMap, String str2, String str3, String str4, String[] strArr, final CallBackString callBackString) {
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
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                CallBackString callBackString2 = callBackString;
                if (callBackString2 != null) {
                    callBackString2.onError(((Integer) call.request().tag()).intValue(), iOException);
                }
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                CallBackString callBackString2 = callBackString;
                if (callBackString2 != null) {
                    callBackString2.onSuccess(((Integer) call.request().tag()).intValue(), call, response);
                }
            }
        });
    }

    public synchronized void downloadGalleryFileSync(int i, String str, String str2, String str3, long j, DownloadListener downloadListener) throws Exception {
        DDLog.m1685e("DDLog", "下载文件1: " + str);
        Request build = new Request.Builder().url(str).tag(Integer.valueOf(i)).get().build();
        OkHttpClient okHttpClient = this.galleryClient;
        if (okHttpClient != null) {
            Call newCall = okHttpClient.newCall(build);
            this.galleryCall = newCall;
            saveFile(newCall.execute(), str2, str3, j, downloadListener);
        }
    }

    public void downloadFileSync(int i, String str, String str2, String str3, long j, DownloadListener downloadListener) throws Exception {
        DDLog.m1685e("DDLog", "下载文件1: " + str);
        Call newCall = ClientManager.getInstance().getClient().newCall(new Request.Builder().url(str).tag(Integer.valueOf(i)).get().build());
        this.downloadCall = newCall;
        saveFile(newCall.execute(), str2, str3, j, downloadListener);
    }

    public synchronized void downloadUpgradeFileSync(String str, int i, String str2, String str3, String str4, long j, DownloadListener downloadListener) throws Exception {
        DDLog.m1685e("DDLog", "下载文件: " + str2);
        Call newCall = ClientManager.getInstance().getClient().newCall(new Request.Builder().url(str2).tag(Integer.valueOf(i)).get().build());
        this.downloadCall = newCall;
        saveUpgradeFile(str, newCall.execute(), str3, str4, j, downloadListener);
    }

    public synchronized void downloadUpgradeFileSyncManual(String str, String str2, int i, String str3, String str4, String str5, long j, DownloadListener2 downloadListener2) throws Exception {
        DDLog.m1685e("DDLog", "下载文件: " + str3);
        Call newCall = ClientManager.getInstance().getClient().newCall(new Request.Builder().url(str3).tag(Integer.valueOf(i)).get().build());
        this.downloadCall = newCall;
        saveUpgradeFileManual(str, str2, newCall.execute(), str4, str5, j, downloadListener2);
    }

    public void cancelDownload() {
        Call call = this.downloadCall;
        if (call != null && !call.isCanceled()) {
            this.downloadCall.cancel();
        }
        Call call2 = this.galleryCall;
        if (call2 == null || call2.isCanceled()) {
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
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void saveFile(okhttp3.Response r9, java.lang.String r10, java.lang.String r11, long r12, com.ipotensic.baselib.okhttp.DownloadListener r14) {
        /*
            r8 = this;
            r12 = 8192(0x2000, float:1.148E-41)
            byte[] r12 = new byte[r12]
            r13 = 0
            r14.onDownloadStart()     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L76
            okhttp3.ResponseBody r0 = r9.body()     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L76
            java.io.InputStream r0 = r0.byteStream()     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L76
            okhttp3.ResponseBody r1 = r9.body()     // Catch: java.lang.Throwable -> L6d java.lang.Exception -> L70
            long r1 = r1.contentLength()     // Catch: java.lang.Throwable -> L6d java.lang.Exception -> L70
            r3 = 0
            java.io.File r5 = new java.io.File     // Catch: java.lang.Throwable -> L6d java.lang.Exception -> L70
            r5.<init>(r10)     // Catch: java.lang.Throwable -> L6d java.lang.Exception -> L70
            boolean r10 = r5.exists()     // Catch: java.lang.Throwable -> L6d java.lang.Exception -> L70
            if (r10 != 0) goto L28
            r5.mkdirs()     // Catch: java.lang.Throwable -> L6d java.lang.Exception -> L70
        L28:
            java.io.File r10 = new java.io.File     // Catch: java.lang.Throwable -> L6d java.lang.Exception -> L70
            r10.<init>(r5, r11)     // Catch: java.lang.Throwable -> L6d java.lang.Exception -> L70
            java.io.FileOutputStream r11 = new java.io.FileOutputStream     // Catch: java.lang.Exception -> L67 java.lang.Throwable -> L6d
            r11.<init>(r10)     // Catch: java.lang.Exception -> L67 java.lang.Throwable -> L6d
        L32:
            int r13 = r0.read(r12)     // Catch: java.lang.Exception -> L63 java.lang.Throwable -> Lb6
            r5 = -1
            if (r13 == r5) goto L49
            long r5 = (long) r13     // Catch: java.lang.Exception -> L63 java.lang.Throwable -> Lb6
            long r3 = r3 + r5
            r5 = 0
            r11.write(r12, r5, r13)     // Catch: java.lang.Exception -> L63 java.lang.Throwable -> Lb6
            float r13 = (float) r3     // Catch: java.lang.Exception -> L63 java.lang.Throwable -> Lb6
            r5 = 1120403456(0x42c80000, float:100.0)
            float r13 = r13 * r5
            float r5 = (float) r1     // Catch: java.lang.Exception -> L63 java.lang.Throwable -> Lb6
            float r13 = r13 / r5
            r14.onDownloadProgress(r13, r1)     // Catch: java.lang.Exception -> L63 java.lang.Throwable -> Lb6
            goto L32
        L49:
            r11.flush()     // Catch: java.lang.Exception -> L63 java.lang.Throwable -> Lb6
            java.lang.String r12 = r10.getAbsolutePath()     // Catch: java.lang.Exception -> L63 java.lang.Throwable -> Lb6
            r14.onDownloadEnd(r12)     // Catch: java.lang.Exception -> L63 java.lang.Throwable -> Lb6
            okhttp3.ResponseBody r9 = r9.body()     // Catch: java.io.IOException -> Lb5
            r9.close()     // Catch: java.io.IOException -> Lb5
            if (r0 == 0) goto L5f
            r0.close()     // Catch: java.io.IOException -> Lb5
        L5f:
            r11.close()     // Catch: java.io.IOException -> Lb5
            goto Lb5
        L63:
            r12 = move-exception
            r13 = r10
            r10 = r12
            goto L79
        L67:
            r11 = move-exception
            r7 = r13
            r13 = r10
            r10 = r11
            r11 = r7
            goto L79
        L6d:
            r10 = move-exception
            r11 = r13
            goto Lb7
        L70:
            r10 = move-exception
            r11 = r13
            goto L79
        L73:
            r10 = move-exception
            r11 = r13
            goto Lb8
        L76:
            r10 = move-exception
            r11 = r13
            r0 = r11
        L79:
            r10.printStackTrace()     // Catch: java.lang.Throwable -> Lb6
            java.lang.String r12 = "DDLog"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb6
            r1.<init>()     // Catch: java.lang.Throwable -> Lb6
            java.lang.String r2 = "下载文件downlaod error: "
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> Lb6
            java.lang.String r2 = r10.getMessage()     // Catch: java.lang.Throwable -> Lb6
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> Lb6
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> Lb6
            android.util.Log.i(r12, r1)     // Catch: java.lang.Throwable -> Lb6
            if (r13 == 0) goto La3
            boolean r12 = r13.exists()     // Catch: java.lang.Throwable -> Lb6
            if (r12 == 0) goto La3
            r13.delete()     // Catch: java.lang.Throwable -> Lb6
        La3:
            r14.onDownloadError(r10)     // Catch: java.lang.Throwable -> Lb6
            okhttp3.ResponseBody r9 = r9.body()     // Catch: java.io.IOException -> Lb5
            r9.close()     // Catch: java.io.IOException -> Lb5
            if (r0 == 0) goto Lb2
            r0.close()     // Catch: java.io.IOException -> Lb5
        Lb2:
            if (r11 == 0) goto Lb5
            goto L5f
        Lb5:
            return
        Lb6:
            r10 = move-exception
        Lb7:
            r13 = r0
        Lb8:
            okhttp3.ResponseBody r9 = r9.body()     // Catch: java.io.IOException -> Lc9
            r9.close()     // Catch: java.io.IOException -> Lc9
            if (r13 == 0) goto Lc4
            r13.close()     // Catch: java.io.IOException -> Lc9
        Lc4:
            if (r11 == 0) goto Lc9
            r11.close()     // Catch: java.io.IOException -> Lc9
        Lc9:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ipotensic.baselib.okhttp.OkHttpUtil.saveFile(okhttp3.Response, java.lang.String, java.lang.String, long, com.ipotensic.baselib.okhttp.DownloadListener):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00bc A[Catch: IOException -> 0x00c4, TryCatch #2 {IOException -> 0x00c4, blocks: (B:49:0x00b3, B:51:0x00bc, B:53:0x00c1), top: B:48:0x00b3 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00c1 A[Catch: IOException -> 0x00c4, TRY_LEAVE, TryCatch #2 {IOException -> 0x00c4, blocks: (B:49:0x00b3, B:51:0x00bc, B:53:0x00c1), top: B:48:0x00b3 }] */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v3, types: [java.io.FileOutputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void saveUpgradeFile(java.lang.String r8, okhttp3.Response r9, java.lang.String r10, java.lang.String r11, long r12, com.ipotensic.baselib.okhttp.DownloadListener r14) {
        /*
            r7 = this;
            r12 = 8192(0x2000, float:1.148E-41)
            byte[] r12 = new byte[r12]
            r13 = 0
            r14.onDownloadStart()     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L71
            okhttp3.ResponseBody r0 = r9.body()     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L71
            java.io.InputStream r0 = r0.byteStream()     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L71
            okhttp3.ResponseBody r1 = r9.body()     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6b
            long r1 = r1.contentLength()     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6b
            r3 = 0
            java.io.File r5 = new java.io.File     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6b
            r5.<init>(r10)     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6b
            boolean r10 = r5.exists()     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6b
            if (r10 != 0) goto L28
            r5.mkdirs()     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6b
        L28:
            java.io.File r10 = new java.io.File     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6b
            r10.<init>(r5, r11)     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6b
            java.io.FileOutputStream r11 = new java.io.FileOutputStream     // Catch: java.lang.Exception -> L64 java.lang.Throwable -> L68
            r11.<init>(r10)     // Catch: java.lang.Exception -> L64 java.lang.Throwable -> L68
        L32:
            int r13 = r0.read(r12)     // Catch: java.lang.Exception -> L62 java.lang.Throwable -> Lb1
            r5 = -1
            if (r13 == r5) goto L48
            long r5 = (long) r13     // Catch: java.lang.Exception -> L62 java.lang.Throwable -> Lb1
            long r3 = r3 + r5
            r5 = 0
            r11.write(r12, r5, r13)     // Catch: java.lang.Exception -> L62 java.lang.Throwable -> Lb1
            r5 = 100
            long r5 = r5 * r3
            long r5 = r5 / r1
            float r13 = (float) r5     // Catch: java.lang.Exception -> L62 java.lang.Throwable -> Lb1
            r14.onDownloadProgress(r13, r1)     // Catch: java.lang.Exception -> L62 java.lang.Throwable -> Lb1
            goto L32
        L48:
            r11.flush()     // Catch: java.lang.Exception -> L62 java.lang.Throwable -> Lb1
            java.lang.String r12 = r10.getAbsolutePath()     // Catch: java.lang.Exception -> L62 java.lang.Throwable -> Lb1
            r14.onDownloadEnd(r12, r8)     // Catch: java.lang.Exception -> L62 java.lang.Throwable -> Lb1
            okhttp3.ResponseBody r8 = r9.body()     // Catch: java.io.IOException -> Lb0
            r8.close()     // Catch: java.io.IOException -> Lb0
            if (r0 == 0) goto L5e
            r0.close()     // Catch: java.io.IOException -> Lb0
        L5e:
            r11.close()     // Catch: java.io.IOException -> Lb0
            goto Lb0
        L62:
            r8 = move-exception
            goto L66
        L64:
            r8 = move-exception
            r11 = r13
        L66:
            r13 = r10
            goto L74
        L68:
            r8 = move-exception
            r11 = r13
            goto Lb2
        L6b:
            r8 = move-exception
            r11 = r13
            goto L74
        L6e:
            r8 = move-exception
            r11 = r13
            goto Lb3
        L71:
            r8 = move-exception
            r11 = r13
            r0 = r11
        L74:
            r8.printStackTrace()     // Catch: java.lang.Throwable -> Lb1
            java.lang.String r10 = "DDLog"
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb1
            r12.<init>()     // Catch: java.lang.Throwable -> Lb1
            java.lang.String r1 = "downlaod error: "
            java.lang.StringBuilder r12 = r12.append(r1)     // Catch: java.lang.Throwable -> Lb1
            java.lang.String r1 = r8.getMessage()     // Catch: java.lang.Throwable -> Lb1
            java.lang.StringBuilder r12 = r12.append(r1)     // Catch: java.lang.Throwable -> Lb1
            java.lang.String r12 = r12.toString()     // Catch: java.lang.Throwable -> Lb1
            android.util.Log.i(r10, r12)     // Catch: java.lang.Throwable -> Lb1
            if (r13 == 0) goto L9e
            boolean r10 = r13.exists()     // Catch: java.lang.Throwable -> Lb1
            if (r10 == 0) goto L9e
            r13.delete()     // Catch: java.lang.Throwable -> Lb1
        L9e:
            r14.onDownloadError(r8)     // Catch: java.lang.Throwable -> Lb1
            okhttp3.ResponseBody r8 = r9.body()     // Catch: java.io.IOException -> Lb0
            r8.close()     // Catch: java.io.IOException -> Lb0
            if (r0 == 0) goto Lad
            r0.close()     // Catch: java.io.IOException -> Lb0
        Lad:
            if (r11 == 0) goto Lb0
            goto L5e
        Lb0:
            return
        Lb1:
            r8 = move-exception
        Lb2:
            r13 = r0
        Lb3:
            okhttp3.ResponseBody r9 = r9.body()     // Catch: java.io.IOException -> Lc4
            r9.close()     // Catch: java.io.IOException -> Lc4
            if (r13 == 0) goto Lbf
            r13.close()     // Catch: java.io.IOException -> Lc4
        Lbf:
            if (r11 == 0) goto Lc4
            r11.close()     // Catch: java.io.IOException -> Lc4
        Lc4:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ipotensic.baselib.okhttp.OkHttpUtil.saveUpgradeFile(java.lang.String, okhttp3.Response, java.lang.String, java.lang.String, long, com.ipotensic.baselib.okhttp.DownloadListener):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00ae A[Catch: IOException -> 0x00b6, TryCatch #1 {IOException -> 0x00b6, blocks: (B:49:0x00a5, B:51:0x00ae, B:53:0x00b3), top: B:48:0x00a5 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00b3 A[Catch: IOException -> 0x00b6, TRY_LEAVE, TryCatch #1 {IOException -> 0x00b6, blocks: (B:49:0x00a5, B:51:0x00ae, B:53:0x00b3), top: B:48:0x00a5 }] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v3, types: [java.io.FileOutputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void saveUpgradeFileManual(java.lang.String r6, java.lang.String r7, okhttp3.Response r8, java.lang.String r9, java.lang.String r10, long r11, com.ipotensic.baselib.okhttp.DownloadListener2 r13) {
        /*
            r5 = this;
            r11 = 8192(0x2000, float:1.148E-41)
            byte[] r11 = new byte[r11]
            r12 = 0
            okhttp3.ResponseBody r0 = r8.body()     // Catch: java.lang.Throwable -> L65 java.lang.Exception -> L68
            java.io.InputStream r0 = r0.byteStream()     // Catch: java.lang.Throwable -> L65 java.lang.Exception -> L68
            okhttp3.ResponseBody r1 = r8.body()     // Catch: java.lang.Throwable -> L5f java.lang.Exception -> L62
            r1.contentLength()     // Catch: java.lang.Throwable -> L5f java.lang.Exception -> L62
            r1 = 0
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L5f java.lang.Exception -> L62
            r3.<init>(r9)     // Catch: java.lang.Throwable -> L5f java.lang.Exception -> L62
            boolean r9 = r3.exists()     // Catch: java.lang.Throwable -> L5f java.lang.Exception -> L62
            if (r9 != 0) goto L24
            r3.mkdirs()     // Catch: java.lang.Throwable -> L5f java.lang.Exception -> L62
        L24:
            java.io.File r9 = new java.io.File     // Catch: java.lang.Throwable -> L5f java.lang.Exception -> L62
            r9.<init>(r3, r10)     // Catch: java.lang.Throwable -> L5f java.lang.Exception -> L62
            java.io.FileOutputStream r10 = new java.io.FileOutputStream     // Catch: java.lang.Exception -> L5b java.lang.Throwable -> L5f
            r10.<init>(r9)     // Catch: java.lang.Exception -> L5b java.lang.Throwable -> L5f
        L2e:
            int r12 = r0.read(r11)     // Catch: java.lang.Exception -> L59 java.lang.Throwable -> La3
            r3 = -1
            if (r12 == r3) goto L3f
            long r3 = (long) r12     // Catch: java.lang.Exception -> L59 java.lang.Throwable -> La3
            long r1 = r1 + r3
            r3 = 0
            r10.write(r11, r3, r12)     // Catch: java.lang.Exception -> L59 java.lang.Throwable -> La3
            r13.onDownloadProgress(r1)     // Catch: java.lang.Exception -> L59 java.lang.Throwable -> La3
            goto L2e
        L3f:
            r10.flush()     // Catch: java.lang.Exception -> L59 java.lang.Throwable -> La3
            java.lang.String r11 = r9.getAbsolutePath()     // Catch: java.lang.Exception -> L59 java.lang.Throwable -> La3
            r13.onDownloadEnd(r11, r6, r7)     // Catch: java.lang.Exception -> L59 java.lang.Throwable -> La3
            okhttp3.ResponseBody r6 = r8.body()     // Catch: java.io.IOException -> La2
            r6.close()     // Catch: java.io.IOException -> La2
            if (r0 == 0) goto L55
            r0.close()     // Catch: java.io.IOException -> La2
        L55:
            r10.close()     // Catch: java.io.IOException -> La2
            goto La2
        L59:
            r6 = move-exception
            goto L5d
        L5b:
            r6 = move-exception
            r10 = r12
        L5d:
            r12 = r9
            goto L6b
        L5f:
            r6 = move-exception
            r10 = r12
            goto La4
        L62:
            r6 = move-exception
            r10 = r12
            goto L6b
        L65:
            r6 = move-exception
            r10 = r12
            goto La5
        L68:
            r6 = move-exception
            r10 = r12
            r0 = r10
        L6b:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La3
            r7.<init>()     // Catch: java.lang.Throwable -> La3
            java.lang.String r9 = "下载固件失败 : "
            java.lang.StringBuilder r7 = r7.append(r9)     // Catch: java.lang.Throwable -> La3
            java.lang.String r9 = r6.getMessage()     // Catch: java.lang.Throwable -> La3
            java.lang.StringBuilder r7 = r7.append(r9)     // Catch: java.lang.Throwable -> La3
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> La3
            com.ipotensic.baselib.DDLog.m1684e(r7)     // Catch: java.lang.Throwable -> La3
            if (r12 == 0) goto L90
            boolean r7 = r12.exists()     // Catch: java.lang.Throwable -> La3
            if (r7 == 0) goto L90
            r12.delete()     // Catch: java.lang.Throwable -> La3
        L90:
            r13.onDownloadError(r6)     // Catch: java.lang.Throwable -> La3
            okhttp3.ResponseBody r6 = r8.body()     // Catch: java.io.IOException -> La2
            r6.close()     // Catch: java.io.IOException -> La2
            if (r0 == 0) goto L9f
            r0.close()     // Catch: java.io.IOException -> La2
        L9f:
            if (r10 == 0) goto La2
            goto L55
        La2:
            return
        La3:
            r6 = move-exception
        La4:
            r12 = r0
        La5:
            okhttp3.ResponseBody r7 = r8.body()     // Catch: java.io.IOException -> Lb6
            r7.close()     // Catch: java.io.IOException -> Lb6
            if (r12 == 0) goto Lb1
            r12.close()     // Catch: java.io.IOException -> Lb6
        Lb1:
            if (r10 == 0) goto Lb6
            r10.close()     // Catch: java.io.IOException -> Lb6
        Lb6:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ipotensic.baselib.okhttp.OkHttpUtil.saveUpgradeFileManual(java.lang.String, java.lang.String, okhttp3.Response, java.lang.String, java.lang.String, long, com.ipotensic.baselib.okhttp.DownloadListener2):void");
    }

    public void postUploadProgressFiles(int i, String str, Map<String, String> map, String str2, String[] strArr, final CallBackString callBackString, OnUploadProgressListener onUploadProgressListener) {
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
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                CallBackString callBackString2 = callBackString;
                if (callBackString2 != null) {
                    callBackString2.onError(((Integer) call.request().tag()).intValue(), iOException);
                }
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                CallBackString callBackString2 = callBackString;
                if (callBackString2 != null) {
                    callBackString2.onSuccess(((Integer) call.request().tag()).intValue(), call, response);
                }
            }
        });
    }

    public void cancelUpload() {
        Call call = this.uploadCall;
        if (call == null || call.isCanceled()) {
            return;
        }
        this.uploadCall.cancel();
    }

    private String getMimeType(String str) {
        String contentTypeFor = URLConnection.getFileNameMap().getContentTypeFor(str);
        return contentTypeFor == null ? HttpPostBodyUtil.DEFAULT_BINARY_CONTENT_TYPE : contentTypeFor;
    }
}