package com.logan.server;

import com.google.android.exoplayer2.util.MimeTypes;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.okhttp.OnResultListener;
import com.logan.server.Server;
import com.logan.server.jhttp.HttpConfig;
import com.logan.server.jhttp.HttpRequest;
import com.logan.server.jhttp.HttpResponse;
import com.logan.server.jhttp.HttpServer;
import com.logan.server.jhttp.IHttpRouter;
import java.io.File;
import java.io.IOException;
import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.commons.text.lookup.StringLookupFactory;

/* loaded from: classes3.dex */
public class Server implements IHttpServer {
    public static final int PORT = 8088;
    private static volatile Server instance;
    private String path;
    private HttpServer server;
    private String router = StringLookupFactory.KEY_FILE;
    private boolean isStart = false;
    private boolean isRealTime = false;
    private boolean isKeepRunning = false;

    private Server() {
    }

    public static Server get() {
        if (instance == null) {
            synchronized (HttpServer.class) {
                if (instance == null) {
                    Server server = new Server();
                    instance = server;
                    return server;
                }
            }
        }
        return instance;
    }

    @Override // com.logan.server.IHttpServer
    public boolean isKeepRunning() {
        return this.isKeepRunning;
    }

    @Override // com.logan.server.IHttpServer
    public String setPath(String str) {
        this.path = str;
        this.isRealTime = str == null;
        if (str != null && !new File(str).exists()) {
            return getUrl();
        }
        return getUrl();
    }

    public boolean isRealTime() {
        return this.isRealTime;
    }

    @Override // com.logan.server.IHttpServer
    public void setKeepRunning(boolean z) {
        this.isKeepRunning = z;
        HttpServer httpServer = this.server;
        if (httpServer != null) {
            httpServer.setKeepRunning(z);
        }
    }

    public String getUrl() {
        return String.format("http://192.168.0.248:%d/%s", Integer.valueOf(PORT), this.router);
    }

    public boolean isStart() {
        return this.isStart;
    }

    @Override // com.logan.server.IHttpServer
    public void execute(OnResultListener onResultListener) {
        if (!this.isStart) {
            this.isStart = true;
            PhoneConfig.threadPool.execute(new AnonymousClass1(onResultListener));
        } else if (onResultListener != null) {
            onResultListener.onSuccess(true);
        }
    }

    /* renamed from: com.logan.server.Server$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ OnResultListener val$resultListener;

        AnonymousClass1(OnResultListener onResultListener) {
            this.val$resultListener = onResultListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                HttpConfig.addCustomPageAction(404, new IHttpRouter() { // from class: com.logan.server.-$$Lambda$Server$1$kDmQHuYQ9qi2-v836crh39QGTh8
                    @Override // com.logan.server.jhttp.IHttpRouter
                    public final void onRoute(HttpRequest httpRequest, HttpResponse httpResponse) {
                        httpResponse.append("404 Not Found, Powered by JHttp");
                    }
                });
                Server.this.server = new HttpServer(Server.PORT);
                Server.this.server.addRouter(InternalZipConstants.ZIP_FILE_SEPARATOR + Server.this.router, new IHttpRouter() { // from class: com.logan.server.-$$Lambda$Server$1$RUA9bTjBVHRhM93O-WUd5DSgkv0
                    @Override // com.logan.server.jhttp.IHttpRouter
                    public final void onRoute(HttpRequest httpRequest, HttpResponse httpResponse) {
                        Server.AnonymousClass1.this.lambda$run$1$Server$1(httpRequest, httpResponse);
                    }
                });
                Server.this.server.addController("/comment/(?<action>\\w+)", ExampleCommentController.class);
                PhoneConfig.mainHandler.post(new Runnable() { // from class: com.logan.server.Server.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AnonymousClass1.this.val$resultListener != null) {
                            AnonymousClass1.this.val$resultListener.onSuccess(true);
                        }
                    }
                });
                Server.this.server.serv();
                Server.this.isStart = false;
            } catch (IOException e) {
                e.printStackTrace();
                OnResultListener onResultListener = this.val$resultListener;
                if (onResultListener != null) {
                    onResultListener.onSuccess(false);
                }
            }
        }

        public /* synthetic */ void lambda$run$1$Server$1(HttpRequest httpRequest, HttpResponse httpResponse) {
            try {
                if (Server.this.isKeepRunning) {
                    System.out.println("收到请求：" + Server.this.path);
                    System.out.println("收到请求详情：" + httpRequest.headers());
                    httpResponse.contentType(MimeTypes.VIDEO_MPEG);
                    if (Server.this.path != null) {
                        httpResponse.file(Server.this.path);
                    } else {
                        httpResponse.setIsFile(false);
                    }
                }
            } catch (IOException e) {
                System.out.println("接收消息错误:" + e.getMessage());
            }
        }
    }

    @Override // com.logan.server.IHttpServer
    public void stopStream() {
        PhoneConfig.threadPool.execute(new Runnable() { // from class: com.logan.server.Server.2
            @Override // java.lang.Runnable
            public void run() {
                if (Server.this.server != null) {
                    Server.this.server.stop(null);
                }
            }
        });
    }
}
