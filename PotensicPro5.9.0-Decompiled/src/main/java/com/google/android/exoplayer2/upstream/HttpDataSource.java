package com.google.android.exoplayer2.upstream;

import android.text.TextUtils;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Ascii;
import com.google.common.base.Predicate;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public interface HttpDataSource extends DataSource {
    public static final Predicate<String> REJECT_PAYWALL_TYPES = new Predicate() { // from class: com.google.android.exoplayer2.upstream.-$$Lambda$HttpDataSource$o2aZq1U3VuZMiJMBGf5bdq5nNDk
        @Override // com.google.common.base.Predicate
        public final boolean apply(Object obj) {
            return HttpDataSource.lambda$static$0((String) obj);
        }
    };

    public interface Factory extends DataSource.Factory {
        @Override // com.google.android.exoplayer2.upstream.DataSource.Factory
        HttpDataSource createDataSource();

        @Deprecated
        RequestProperties getDefaultRequestProperties();

        Factory setDefaultRequestProperties(Map<String, String> map);
    }

    void clearAllRequestProperties();

    void clearRequestProperty(String str);

    void close() throws HttpDataSourceException;

    int getResponseCode();

    Map<String, List<String>> getResponseHeaders();

    long open(DataSpec dataSpec) throws HttpDataSourceException;

    int read(byte[] bArr, int i, int i2) throws HttpDataSourceException;

    void setRequestProperty(String str, String str2);

    public static final class RequestProperties {
        private final Map<String, String> requestProperties = new HashMap();
        private Map<String, String> requestPropertiesSnapshot;

        public synchronized void set(String str, String str2) {
            this.requestPropertiesSnapshot = null;
            this.requestProperties.put(str, str2);
        }

        public synchronized void set(Map<String, String> map) {
            this.requestPropertiesSnapshot = null;
            this.requestProperties.putAll(map);
        }

        public synchronized void clearAndSet(Map<String, String> map) {
            this.requestPropertiesSnapshot = null;
            this.requestProperties.clear();
            this.requestProperties.putAll(map);
        }

        public synchronized void remove(String str) {
            this.requestPropertiesSnapshot = null;
            this.requestProperties.remove(str);
        }

        public synchronized void clear() {
            this.requestPropertiesSnapshot = null;
            this.requestProperties.clear();
        }

        public synchronized Map<String, String> getSnapshot() {
            if (this.requestPropertiesSnapshot == null) {
                this.requestPropertiesSnapshot = Collections.unmodifiableMap(new HashMap(this.requestProperties));
            }
            return this.requestPropertiesSnapshot;
        }
    }

    public static abstract class BaseFactory implements Factory {
        private final RequestProperties defaultRequestProperties = new RequestProperties();

        protected abstract HttpDataSource createDataSourceInternal(RequestProperties requestProperties);

        @Override // com.google.android.exoplayer2.upstream.HttpDataSource.Factory, com.google.android.exoplayer2.upstream.DataSource.Factory
        public final HttpDataSource createDataSource() {
            return createDataSourceInternal(this.defaultRequestProperties);
        }

        @Override // com.google.android.exoplayer2.upstream.HttpDataSource.Factory
        @Deprecated
        public final RequestProperties getDefaultRequestProperties() {
            return this.defaultRequestProperties;
        }

        @Override // com.google.android.exoplayer2.upstream.HttpDataSource.Factory
        public final Factory setDefaultRequestProperties(Map<String, String> map) {
            this.defaultRequestProperties.clearAndSet(map);
            return this;
        }
    }

    static /* synthetic */ boolean lambda$static$0(String str) {
        if (str == null) {
            return false;
        }
        String lowerCase = Ascii.toLowerCase(str);
        if (TextUtils.isEmpty(lowerCase)) {
            return false;
        }
        return ((lowerCase.contains("text") && !lowerCase.contains(MimeTypes.TEXT_VTT)) || lowerCase.contains("html") || lowerCase.contains("xml")) ? false : true;
    }

    public static class HttpDataSourceException extends IOException {
        public static final int TYPE_CLOSE = 3;
        public static final int TYPE_OPEN = 1;
        public static final int TYPE_READ = 2;
        public final DataSpec dataSpec;
        public final int type;

        @Documented
        @Retention(RetentionPolicy.SOURCE)
        public @interface Type {
        }

        public HttpDataSourceException(DataSpec dataSpec, int i) {
            this.dataSpec = dataSpec;
            this.type = i;
        }

        public HttpDataSourceException(String str, DataSpec dataSpec, int i) {
            super(str);
            this.dataSpec = dataSpec;
            this.type = i;
        }

        public HttpDataSourceException(IOException iOException, DataSpec dataSpec, int i) {
            super(iOException);
            this.dataSpec = dataSpec;
            this.type = i;
        }

        public HttpDataSourceException(String str, IOException iOException, DataSpec dataSpec, int i) {
            super(str, iOException);
            this.dataSpec = dataSpec;
            this.type = i;
        }
    }

    public static final class CleartextNotPermittedException extends HttpDataSourceException {
        public CleartextNotPermittedException(IOException iOException, DataSpec dataSpec) {
            super("Cleartext HTTP traffic not permitted. See https://exoplayer.dev/issues/cleartext-not-permitted", iOException, dataSpec, 1);
        }
    }

    public static final class InvalidContentTypeException extends HttpDataSourceException {
        public final String contentType;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public InvalidContentTypeException(java.lang.String r4, com.google.android.exoplayer2.upstream.DataSpec r5) {
            /*
                r3 = this;
                java.lang.String r0 = java.lang.String.valueOf(r4)
                int r1 = r0.length()
                java.lang.String r2 = "Invalid content type: "
                if (r1 == 0) goto L11
                java.lang.String r0 = r2.concat(r0)
                goto L16
            L11:
                java.lang.String r0 = new java.lang.String
                r0.<init>(r2)
            L16:
                r1 = 1
                r3.<init>(r0, r5, r1)
                r3.contentType = r4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.upstream.HttpDataSource.InvalidContentTypeException.<init>(java.lang.String, com.google.android.exoplayer2.upstream.DataSpec):void");
        }
    }

    public static final class InvalidResponseCodeException extends HttpDataSourceException {
        public final Map<String, List<String>> headerFields;
        public final byte[] responseBody;
        public final int responseCode;
        public final String responseMessage;

        @Deprecated
        public InvalidResponseCodeException(int i, Map<String, List<String>> map, DataSpec dataSpec) {
            this(i, null, map, dataSpec, Util.EMPTY_BYTE_ARRAY);
        }

        @Deprecated
        public InvalidResponseCodeException(int i, String str, Map<String, List<String>> map, DataSpec dataSpec) {
            this(i, str, map, dataSpec, Util.EMPTY_BYTE_ARRAY);
        }

        public InvalidResponseCodeException(int i, String str, Map<String, List<String>> map, DataSpec dataSpec, byte[] bArr) {
            super(new StringBuilder(26).append("Response code: ").append(i).toString(), dataSpec, 1);
            this.responseCode = i;
            this.responseMessage = str;
            this.headerFields = map;
            this.responseBody = bArr;
        }
    }
}
