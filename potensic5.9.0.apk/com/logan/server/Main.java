package com.logan.server;

import com.google.android.exoplayer2.util.MimeTypes;
import com.logan.server.jhttp.HttpConfig;
import com.logan.server.jhttp.HttpLog;
import com.logan.server.jhttp.HttpRequest;
import com.logan.server.jhttp.HttpResponse;
import com.logan.server.jhttp.HttpServer;
import com.logan.server.jhttp.IHttpRouter;
import java.io.IOException;
import net.lingala.zip4j.util.InternalZipConstants;

/* loaded from: classes3.dex */
public class Main {
    static final int PORT = 8080;
    static HttpServer server;

    public static void main(String[] strArr) {
        HttpLog.setLogLevel(0);
        HttpConfig.addCustomPageAction(404, new IHttpRouter() { // from class: com.logan.server.-$$Lambda$Main$jnQCQr5xlchc9layJ8siOy8DpHg
            @Override // com.logan.server.jhttp.IHttpRouter
            public final void onRoute(HttpRequest httpRequest, HttpResponse httpResponse) {
                httpResponse.append("404 Not Found, Powered by JHttp");
            }
        });
        try {
            HttpServer httpServer = new HttpServer(PORT);
            server = httpServer;
            httpServer.addRouter(InternalZipConstants.ZIP_FILE_SEPARATOR, new IHttpRouter() { // from class: com.logan.server.Main.1
                @Override // com.logan.server.jhttp.IHttpRouter
                public void onRoute(HttpRequest httpRequest, HttpResponse httpResponse) {
                    httpResponse.append("hello");
                }
            });
            server.addRouterRegex("/article/(\\w+)", new IHttpRouter() { // from class: com.logan.server.-$$Lambda$Main$Az_yTM1mc14vpL7qpmnrKH3bZWM
                @Override // com.logan.server.jhttp.IHttpRouter
                public final void onRoute(HttpRequest httpRequest, HttpResponse httpResponse) {
                    httpResponse.append(httpRequest.getPathinfo().group(1) + " an article");
                }
            });
            server.addRouter("/user", new IHttpRouter() { // from class: com.logan.server.-$$Lambda$Main$cxDQWRI9LpNockXiXz7_V4gFkZs
                @Override // com.logan.server.jhttp.IHttpRouter
                public final void onRoute(HttpRequest httpRequest, HttpResponse httpResponse) {
                    httpResponse.append("hello, " + httpRequest.get("user", ""));
                }
            });
            server.addRouter("/file", new IHttpRouter() { // from class: com.logan.server.-$$Lambda$Main$WYriVk0Bm6N34uN3ZVlWGGhYAc0
                @Override // com.logan.server.jhttp.IHttpRouter
                public final void onRoute(HttpRequest httpRequest, HttpResponse httpResponse) {
                    Main.lambda$main$3(httpRequest, httpResponse);
                }
            });
            server.addController("/comment/(?<action>\\w+)", ExampleCommentController.class);
            server.serv();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static /* synthetic */ void lambda$main$3(HttpRequest httpRequest, HttpResponse httpResponse) {
        try {
            System.out.println("输出");
            httpResponse.contentType(MimeTypes.VIDEO_H264);
            httpResponse.setIsFile(true);
            httpResponse.file("D:\\360MoveData\\Users\\Administrator\\Desktop\\相机存储文件.h264");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}