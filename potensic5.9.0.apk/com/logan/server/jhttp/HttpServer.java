package com.logan.server.jhttp;

import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.okhttp.OnResultListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class HttpServer implements IOnHttpRequest {
    private static final int POOL_MULTIPLE = 4;
    private HttpHandler httpHandler;
    private int port;
    private OnResultListener resultListener;
    private ServerSocket serverSocket;
    private boolean listening = false;
    private boolean keepRunning = true;
    private Map<String, IHttpRouter> routerMap = new HashMap();
    private Map<String, IHttpRouter> regexRouterMap = new HashMap();
    private Map<String, Class<?>> controllerMap = new HashMap();
    private ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 4);

    public HttpServer(int i) throws IOException {
        this.serverSocket = null;
        this.port = i;
        this.serverSocket = new ServerSocket(this.port);
    }

    public void setKeepRunning(boolean z) {
        this.keepRunning = z;
    }

    public void serv() {
        System.out.println("开始监听端口");
        this.listening = true;
        while (this.listening) {
            try {
                Socket accept = this.serverSocket.accept();
                System.out.println("New socket accepted");
                accept.setKeepAlive(true);
                if (this.keepRunning) {
                    HttpHandler httpHandler = new HttpHandler(accept, this);
                    this.httpHandler = httpHandler;
                    this.executorService.execute(httpHandler);
                }
            } catch (Exception e) {
                e.printStackTrace();
                this.executorService.shutdown();
                try {
                    if (!this.executorService.awaitTermination(60L, TimeUnit.SECONDS)) {
                        this.executorService.shutdownNow();
                    }
                } catch (InterruptedException unused) {
                    this.executorService.shutdownNow();
                    Thread.currentThread().interrupt();
                }
            }
        }
        System.out.println("停止服务器线程");
        try {
            this.serverSocket.close();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.listening = false;
        PhoneConfig.mainHandler.post(new Runnable() { // from class: com.logan.server.jhttp.HttpServer.1
            @Override // java.lang.Runnable
            public void run() {
                if (HttpServer.this.resultListener != null) {
                    HttpServer.this.resultListener.onSuccess(true);
                }
            }
        });
    }

    public void stop(OnResultListener onResultListener) {
        HttpHandler httpHandler = this.httpHandler;
        if (httpHandler != null) {
            httpHandler.stop();
        }
    }

    public void addRouter(String str, IHttpRouter iHttpRouter) {
        this.routerMap.put(str, iHttpRouter);
    }

    public void addRouterRegex(String str, IHttpRouter iHttpRouter) {
        this.regexRouterMap.put(str, iHttpRouter);
    }

    public void addController(String str, Class<?> cls) {
        this.controllerMap.put(str, cls);
    }

    public void removeRouter(String str) {
        this.routerMap.remove(str);
    }

    @Override // com.logan.server.jhttp.IOnHttpRequest
    public void onRequest(HttpRequest httpRequest, HttpResponse httpResponse) {
        IHttpRouter iHttpRouter;
        HttpLog.m1734I("%s %s", httpRequest.getMethod(), httpRequest.getUrl());
        String path = httpRequest.getPath();
        if (this.routerMap.containsKey(path) && (iHttpRouter = this.routerMap.get(path)) != null) {
            iHttpRouter.onRoute(httpRequest, httpResponse);
            return;
        }
        for (Map.Entry<String, IHttpRouter> entry : this.regexRouterMap.entrySet()) {
            Matcher matcher = Pattern.compile(entry.getKey()).matcher(path);
            if (matcher.find()) {
                httpRequest.setPathinfo(matcher);
                entry.getValue().onRoute(httpRequest, httpResponse);
                return;
            }
        }
        for (Map.Entry<String, Class<?>> entry2 : this.controllerMap.entrySet()) {
            Matcher matcher2 = Pattern.compile(entry2.getKey()).matcher(path);
            if (matcher2.find()) {
                try {
                    HttpController httpController = (HttpController) entry2.getValue().newInstance();
                    httpRequest.setPathinfo(matcher2);
                    httpController.onRoute(httpRequest, httpResponse);
                    return;
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e2) {
                    e2.printStackTrace();
                }
            }
        }
        httpResponse.setStatus(404);
    }
}