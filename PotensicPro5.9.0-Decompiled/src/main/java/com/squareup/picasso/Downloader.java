package com.squareup.picasso;

import android.graphics.Bitmap;
import android.net.Uri;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes3.dex */
public interface Downloader {
    Response load(Uri uri, int i) throws IOException;

    void shutdown();

    public static class ResponseException extends IOException {
        final boolean localCacheOnly;
        final int responseCode;

        public ResponseException(String str, int i, int i2) {
            super(str);
            this.localCacheOnly = NetworkPolicy.isOfflineOnly(i);
            this.responseCode = i2;
        }
    }

    public static class Response {
        final Bitmap bitmap;
        final boolean cached;
        final long contentLength;
        final InputStream stream;

        @Deprecated
        public Response(Bitmap bitmap, boolean z) {
            if (bitmap == null) {
                throw new IllegalArgumentException("Bitmap may not be null.");
            }
            this.stream = null;
            this.bitmap = bitmap;
            this.cached = z;
            this.contentLength = -1L;
        }

        @Deprecated
        public Response(InputStream inputStream, boolean z) {
            this(inputStream, z, -1L);
        }

        @Deprecated
        public Response(Bitmap bitmap, boolean z, long j) {
            this(bitmap, z);
        }

        public Response(InputStream inputStream, boolean z, long j) {
            if (inputStream == null) {
                throw new IllegalArgumentException("Stream may not be null.");
            }
            this.stream = inputStream;
            this.bitmap = null;
            this.cached = z;
            this.contentLength = j;
        }

        public InputStream getInputStream() {
            return this.stream;
        }

        @Deprecated
        public Bitmap getBitmap() {
            return this.bitmap;
        }

        public long getContentLength() {
            return this.contentLength;
        }
    }
}
