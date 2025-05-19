package okhttp3.logging;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import okhttp3.Connection;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.BufferedSource;
import okio.GzipSource;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.formula.functions.Complex;

/* compiled from: HttpLoggingInterceptor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002\u001e\u001fB\u0011\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\r\u0010\u000b\u001a\u00020\tH\u0007¢\u0006\u0002\b\u0012J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u000e\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u0007J\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t@GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\n\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lokhttp3/logging/HttpLoggingInterceptor;", "Lokhttp3/Interceptor;", "logger", "Lokhttp3/logging/HttpLoggingInterceptor$Logger;", "(Lokhttp3/logging/HttpLoggingInterceptor$Logger;)V", "headersToRedact", "", "", "<set-?>", "Lokhttp3/logging/HttpLoggingInterceptor$Level;", "level", "getLevel", "()Lokhttp3/logging/HttpLoggingInterceptor$Level;", "(Lokhttp3/logging/HttpLoggingInterceptor$Level;)V", "bodyHasUnknownEncoding", "", "headers", "Lokhttp3/Headers;", "-deprecated_level", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "logHeader", "", Complex.DEFAULT_SUFFIX, "", "redactHeader", "name", "setLevel", "Level", "Logger", "okhttp-logging-interceptor"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class HttpLoggingInterceptor implements Interceptor {
    private volatile Set<String> headersToRedact;
    private volatile Level level;
    private final Logger logger;

    /* compiled from: HttpLoggingInterceptor.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lokhttp3/logging/HttpLoggingInterceptor$Level;", "", "(Ljava/lang/String;I)V", "NONE", "BASIC", "HEADERS", "BODY", "okhttp-logging-interceptor"}, k = 1, mv = {1, 4, 0})
    public enum Level {
        NONE,
        BASIC,
        HEADERS,
        BODY
    }

    public HttpLoggingInterceptor() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public HttpLoggingInterceptor(Logger logger) {
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.logger = logger;
        this.headersToRedact = SetsKt.emptySet();
        this.level = Level.NONE;
    }

    public /* synthetic */ HttpLoggingInterceptor(Logger logger, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Logger.DEFAULT : logger);
    }

    public final Level getLevel() {
        return this.level;
    }

    public final void level(Level level) {
        Intrinsics.checkNotNullParameter(level, "<set-?>");
        this.level = level;
    }

    /* compiled from: HttpLoggingInterceptor.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bæ\u0080\u0001\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lokhttp3/logging/HttpLoggingInterceptor$Logger;", "", "log", "", "message", "", "Companion", "okhttp-logging-interceptor"}, k = 1, mv = {1, 4, 0})
    public interface Logger {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        public static final Logger DEFAULT = new Companion.DefaultLogger();

        void log(String message);

        /* compiled from: HttpLoggingInterceptor.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000¨\u0006\u0001\u0082\u0002\u0007\n\u0005\b\u0091F0\u0001¨\u0006\u0006"}, d2 = {"Lokhttp3/logging/HttpLoggingInterceptor$Logger$Companion;", "", "()V", "DEFAULT", "Lokhttp3/logging/HttpLoggingInterceptor$Logger;", "DefaultLogger", "okhttp-logging-interceptor"}, k = 1, mv = {1, 4, 0})
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = null;

            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* compiled from: HttpLoggingInterceptor.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lokhttp3/logging/HttpLoggingInterceptor$Logger$Companion$DefaultLogger;", "Lokhttp3/logging/HttpLoggingInterceptor$Logger;", "()V", "log", "", "message", "", "okhttp-logging-interceptor"}, k = 1, mv = {1, 4, 0})
            private static final class DefaultLogger implements Logger {
                @Override // okhttp3.logging.HttpLoggingInterceptor.Logger
                public void log(String message) {
                    Intrinsics.checkNotNullParameter(message, "message");
                    Platform.log$default(Platform.INSTANCE.get(), message, 0, null, 6, null);
                }
            }
        }
    }

    public final void redactHeader(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        TreeSet treeSet = new TreeSet(StringsKt.getCASE_INSENSITIVE_ORDER(StringCompanionObject.INSTANCE));
        TreeSet treeSet2 = treeSet;
        CollectionsKt.addAll(treeSet2, this.headersToRedact);
        treeSet2.add(name);
        this.headersToRedact = treeSet;
    }

    public final HttpLoggingInterceptor setLevel(Level level) {
        Intrinsics.checkNotNullParameter(level, "level");
        HttpLoggingInterceptor httpLoggingInterceptor = this;
        httpLoggingInterceptor.level = level;
        return httpLoggingInterceptor;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to var", replaceWith = @ReplaceWith(expression = "level", imports = {}))
    /* renamed from: -deprecated_level, reason: not valid java name and from getter */
    public final Level getLevel() {
        return this.level;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        String str;
        char c;
        String str2;
        Charset UTF_8;
        Charset UTF_82;
        Intrinsics.checkNotNullParameter(chain, "chain");
        Level level = this.level;
        Request request = chain.request();
        if (level == Level.NONE) {
            return chain.proceed(request);
        }
        boolean z = level == Level.BODY;
        boolean z2 = z || level == Level.HEADERS;
        RequestBody body = request.body();
        Connection connection = chain.connection();
        String str3 = "--> " + request.method() + ' ' + request.url() + (connection != null ? StringUtils.SPACE + connection.protocol() : "");
        if (!z2 && body != null) {
            str3 = str3 + " (" + body.contentLength() + "-byte body)";
        }
        this.logger.log(str3);
        if (z2) {
            Headers headers = request.headers();
            if (body != null) {
                MediaType contentType = body.getContentType();
                if (contentType != null && headers.get("Content-Type") == null) {
                    this.logger.log("Content-Type: " + contentType);
                }
                if (body.contentLength() != -1 && headers.get("Content-Length") == null) {
                    this.logger.log("Content-Length: " + body.contentLength());
                }
            }
            int size = headers.size();
            for (int i = 0; i < size; i++) {
                logHeader(headers, i);
            }
            if (!z || body == null) {
                this.logger.log("--> END " + request.method());
            } else if (bodyHasUnknownEncoding(request.headers())) {
                this.logger.log("--> END " + request.method() + " (encoded body omitted)");
            } else if (body.isDuplex()) {
                this.logger.log("--> END " + request.method() + " (duplex request body omitted)");
            } else if (body.isOneShot()) {
                this.logger.log("--> END " + request.method() + " (one-shot body omitted)");
            } else {
                Buffer buffer = new Buffer();
                body.writeTo(buffer);
                MediaType contentType2 = body.getContentType();
                if (contentType2 == null || (UTF_82 = contentType2.charset(StandardCharsets.UTF_8)) == null) {
                    UTF_82 = StandardCharsets.UTF_8;
                    Intrinsics.checkNotNullExpressionValue(UTF_82, "UTF_8");
                }
                this.logger.log("");
                if (Utf8Kt.isProbablyUtf8(buffer)) {
                    this.logger.log(buffer.readString(UTF_82));
                    this.logger.log("--> END " + request.method() + " (" + body.contentLength() + "-byte body)");
                } else {
                    this.logger.log("--> END " + request.method() + " (binary " + body.contentLength() + "-byte body omitted)");
                }
            }
        }
        long nanoTime = System.nanoTime();
        try {
            Response proceed = chain.proceed(request);
            long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - nanoTime);
            ResponseBody body2 = proceed.body();
            Intrinsics.checkNotNull(body2);
            long contentLength = body2.getContentLength();
            String str4 = contentLength != -1 ? contentLength + "-byte" : "unknown-length";
            Logger logger = this.logger;
            StringBuilder append = new StringBuilder().append("<-- ").append(proceed.code());
            if (proceed.message().length() == 0) {
                str = "-byte body omitted)";
                str2 = "";
                c = ' ';
            } else {
                str = "-byte body omitted)";
                c = ' ';
                str2 = String.valueOf(' ') + proceed.message();
            }
            logger.log(append.append(str2).append(c).append(proceed.request().url()).append(" (").append(millis).append("ms").append(!z2 ? ", " + str4 + " body" : "").append(PropertyUtils.MAPPED_DELIM2).toString());
            if (z2) {
                Headers headers2 = proceed.headers();
                int size2 = headers2.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    logHeader(headers2, i2);
                }
                if (!z || !HttpHeaders.promisesBody(proceed)) {
                    this.logger.log("<-- END HTTP");
                } else if (bodyHasUnknownEncoding(proceed.headers())) {
                    this.logger.log("<-- END HTTP (encoded body omitted)");
                } else {
                    BufferedSource bodySource = body2.getBodySource();
                    bodySource.request(Long.MAX_VALUE);
                    Buffer buffer2 = bodySource.getBuffer();
                    Long l = (Long) null;
                    if (StringsKt.equals("gzip", headers2.get("Content-Encoding"), true)) {
                        l = Long.valueOf(buffer2.size());
                        GzipSource gzipSource = new GzipSource(buffer2.clone());
                        Throwable th = (Throwable) null;
                        try {
                            Buffer buffer3 = new Buffer();
                            buffer3.writeAll(gzipSource);
                            CloseableKt.closeFinally(gzipSource, th);
                            buffer2 = buffer3;
                        } finally {
                        }
                    }
                    MediaType mediaType = body2.get$contentType();
                    if (mediaType == null || (UTF_8 = mediaType.charset(StandardCharsets.UTF_8)) == null) {
                        UTF_8 = StandardCharsets.UTF_8;
                        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
                    }
                    if (!Utf8Kt.isProbablyUtf8(buffer2)) {
                        this.logger.log("");
                        this.logger.log("<-- END HTTP (binary " + buffer2.size() + str);
                        return proceed;
                    }
                    if (contentLength != 0) {
                        this.logger.log("");
                        this.logger.log(buffer2.clone().readString(UTF_8));
                    }
                    if (l != null) {
                        this.logger.log("<-- END HTTP (" + buffer2.size() + "-byte, " + l + "-gzipped-byte body)");
                    } else {
                        this.logger.log("<-- END HTTP (" + buffer2.size() + "-byte body)");
                    }
                }
            }
            return proceed;
        } catch (Exception e) {
            this.logger.log("<-- HTTP FAILED: " + e);
            throw e;
        }
    }

    private final void logHeader(Headers headers, int i) {
        this.logger.log(headers.name(i) + ": " + (this.headersToRedact.contains(headers.name(i)) ? "██" : headers.value(i)));
    }

    private final boolean bodyHasUnknownEncoding(Headers headers) {
        String str = headers.get("Content-Encoding");
        return (str == null || StringsKt.equals(str, "identity", true) || StringsKt.equals(str, "gzip", true)) ? false : true;
    }
}
