package com.ipotensic.baselib.okhttp;

import com.ipotensic.baselib.DDLog;
import java.io.EOFException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import net.lingala.zip4j.util.InternalZipConstants;
import okhttp3.Connection;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.BufferedSource;

/* loaded from: classes2.dex */
public final class LoggingInterceptor implements Interceptor {
    private static final int MAX_LENGTH = 1024;
    private final String TAG = "DDLog-Http-Interceptor";
    private final Charset UTF8 = Charset.forName("UTF-8");
    private volatile LoggingLevel level;

    public interface Logger {
        public static final Logger DEFAULT = new Logger() { // from class: com.ipotensic.baselib.okhttp.LoggingInterceptor.Logger.1
            @Override // com.ipotensic.baselib.okhttp.LoggingInterceptor.Logger
            public void log(String str) {
                Platform.get().log(str, 4, null);
            }
        };
        public static final Logger WARN = new Logger() { // from class: com.ipotensic.baselib.okhttp.LoggingInterceptor.Logger.2
            @Override // com.ipotensic.baselib.okhttp.LoggingInterceptor.Logger
            public void log(String str) {
                Platform.get().log(str, 5, null);
            }
        };

        void log(String str);
    }

    public LoggingInterceptor(LoggingLevel loggingLevel) {
        this.level = LoggingLevel.NONE;
        this.level = loggingLevel;
        if (this.level == null) {
            this.level = LoggingLevel.SINGLE;
        }
    }

    public LoggingInterceptor setLevel(LoggingLevel loggingLevel) {
        this.level = loggingLevel;
        if (this.level == null) {
            this.level = LoggingLevel.BODY;
        }
        return this;
    }

    public LoggingLevel getLevel() {
        return this.level;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        return logIntercept(chain);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0054, code lost:
    
        return r7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Response logIntercept(Interceptor.Chain chain) throws IOException {
        Request build = chain.request().newBuilder().addHeader("Connection", "close").build();
        long nanoTime = System.nanoTime();
        try {
            Response proceed = chain.proceed(build);
            String httpHeaderString = getHttpHeaderString(build, proceed, TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - nanoTime), chain);
            switch (AnonymousClass1.$SwitchMap$com$ipotensic$baselib$okhttp$LoggingLevel[this.level.ordinal()]) {
                case 1:
                    printUrlBody(build, proceed);
                    break;
                case 2:
                    printSingle(build, proceed, httpHeaderString);
                    break;
                case 3:
                    printState(httpHeaderString);
                    break;
                case 4:
                    printHeaders(build, proceed, httpHeaderString);
                    break;
                case 5:
                    printBody(build, proceed, httpHeaderString);
                    break;
                case 6:
                    printAll(build, proceed, httpHeaderString);
                    break;
            }
        } catch (IOException e) {
            print(String.format("\u2523\u2501\u2501\u2501 [HTTP FAILED] url:%s exception:%s", build.url(), e.getMessage()));
            throw e;
        }
    }

    /* renamed from: com.ipotensic.baselib.okhttp.LoggingInterceptor$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ipotensic$baselib$okhttp$LoggingLevel;

        static {
            int[] iArr = new int[LoggingLevel.values().length];
            $SwitchMap$com$ipotensic$baselib$okhttp$LoggingLevel = iArr;
            try {
                iArr[LoggingLevel.URL_BODY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$okhttp$LoggingLevel[LoggingLevel.SINGLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$okhttp$LoggingLevel[LoggingLevel.STATE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$okhttp$LoggingLevel[LoggingLevel.HEADERS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$okhttp$LoggingLevel[LoggingLevel.BODY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$okhttp$LoggingLevel[LoggingLevel.ALL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    private void printUrlBody(Request request, Response response) throws IOException {
        String responseBody = getResponseBody(request, response);
        String format = String.format("%s %s %s", getHeaderSymbol(), request.url(), responseBody);
        if (format.length() > 1024) {
            print(String.format("%s %s", getHeaderSymbol(), request.url()));
            printLong(responseBody);
            printEnd();
            return;
        }
        print(format);
    }

    private void printLong(String str) {
        int length = str.length();
        if (length <= 1024) {
            print(str);
            return;
        }
        int i = length / 1024;
        if (length % 1024 != 0) {
            i++;
        }
        for (int i2 = 1; i2 <= i; i2++) {
            if (i2 < i) {
                print(str.substring((i2 - 1) * 1024, i2 * 1024));
            } else {
                print(str.substring((i2 - 1) * 1024, length));
            }
        }
    }

    private void printHeaders(Request request, Response response, String str) throws IOException {
        print(str);
        printHttpHeaders(request, response);
        printEnd();
    }

    private void print(String str) {
        DDLog.e("DDLog-Http-Interceptor", "print: " + str);
    }

    private void printBody(Request request, Response response, String str) throws IOException {
        print(str);
        printLong(getResponseBody(request, response));
        printEnd();
    }

    private void printSingle(Request request, Response response, String str) throws IOException {
        String responseBody = getResponseBody(request, response);
        String format = String.format("%s %s", str, responseBody);
        if (format.length() > 1024) {
            print(str);
            printLong(responseBody);
        } else {
            print(format);
        }
    }

    private void printState(String str) {
        print(str);
    }

    private void printEnd() {
        print("\u2517\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501 End \u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\n");
    }

    private String getHttpHeaderString(Request request, Response response, long j, Interceptor.Chain chain) {
        return String.format("%s %s", getHeaderSymbol(), getHttpStateString(request, response, j, chain));
    }

    private String getHttpStateString(Request request, Response response, long j, Interceptor.Chain chain) {
        Connection connection = chain.connection();
        return String.format(Locale.getDefault(), "[%s %d %s][%s %dms] %s", request.method(), Integer.valueOf(response.code()), response.message(), connection != null ? connection.protocol() : Protocol.HTTP_1_1, Long.valueOf(j), request.url());
    }

    private String getHeaderSymbol() {
        return (this.level == LoggingLevel.SINGLE || this.level == LoggingLevel.URL_BODY || this.level == LoggingLevel.STATE) ? "\u2523\u2501" : "\u250f\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501 Start \u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501 \n";
    }

    private void printAll(Request request, Response response, String str) throws IOException {
        print(str);
        printLong(getResponseBody(request, response));
        printHttpHeaders(request, response);
        printEnd();
    }

    private void printHttpHeaders(Request request, Response response) throws IOException {
        RequestBody body = request.body();
        if (body != null) {
            print("Content-Length: " + body.contentLength());
            MediaType contentType = body.getContentType();
            if (contentType != null) {
                print("Content-Type: " + contentType);
            }
            Headers headers = request.headers();
            int size = headers.size();
            for (int i = 0; i < size; i++) {
                String name = headers.name(i);
                if (!"Content-Type".equalsIgnoreCase(name) && !"Content-Length".equalsIgnoreCase(name)) {
                    print(name + ": " + headers.value(i));
                }
            }
        }
        Headers headers2 = response.headers();
        if (headers2 != null) {
            int size2 = headers2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                print(headers2.name(i2) + ": " + headers2.value(i2));
            }
        }
    }

    private String getResponseBody(Request request, Response response) throws IOException {
        if (!HttpHeaders.hasBody(response)) {
            return "[No Response Body]";
        }
        ResponseBody body = response.body();
        BufferedSource bodySource = body.getBodySource();
        bodySource.request(Long.MAX_VALUE);
        Buffer bufferField = bodySource.getBufferField();
        if (isEncoded(request.headers())) {
            return "[Body: Encoded]";
        }
        if (!isPlaintext(bufferField)) {
            String url = request.url().getUrl();
            return !url.contains("?") ? String.format("[File:%s]", url.substring(url.lastIndexOf(InternalZipConstants.ZIP_FILE_SEPARATOR) + 1)) : "[Body: Not readable]";
        }
        Charset charset = this.UTF8;
        MediaType mediaType = body.get$contentType();
        if (mediaType != null) {
            charset = mediaType.charset(this.UTF8);
        }
        return bufferField.clone().readString(charset);
    }

    private boolean isPlaintext(Buffer buffer) {
        try {
            Buffer buffer2 = new Buffer();
            buffer.copyTo(buffer2, 0L, buffer.size() < 64 ? buffer.size() : 64L);
            for (int i = 0; i < 16; i++) {
                if (buffer2.exhausted()) {
                    return true;
                }
                int readUtf8CodePoint = buffer2.readUtf8CodePoint();
                if (Character.isISOControl(readUtf8CodePoint) && !Character.isWhitespace(readUtf8CodePoint)) {
                    return false;
                }
            }
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }

    private boolean isEncoded(Headers headers) {
        String str = headers.get("Content-Encoding");
        return (str == null || str.equalsIgnoreCase("identity")) ? false : true;
    }
}