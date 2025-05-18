package com.ipotensic.baselib.okhttp;

import com.ipotensic.baselib.DDLog;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.ForwardingSink;
import okio.Okio;
import okio.Sink;

/* loaded from: classes2.dex */
public class ProgressRequestBody extends RequestBody {
    private BufferedSink bufferedSink;
    private OnUploadProgressListener callBack;
    private final RequestBody requestBody;

    ProgressRequestBody(RequestBody requestBody, OnUploadProgressListener onUploadProgressListener) {
        this.requestBody = requestBody;
        this.callBack = onUploadProgressListener;
    }

    @Override // okhttp3.RequestBody
    /* renamed from: contentType */
    public MediaType getContentType() {
        return this.requestBody.getContentType();
    }

    @Override // okhttp3.RequestBody
    public long contentLength() throws IOException {
        return this.requestBody.contentLength();
    }

    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink bufferedSink) throws IOException {
        if (this.bufferedSink == null) {
            this.bufferedSink = Okio.buffer(sink(bufferedSink));
        }
        this.requestBody.writeTo(this.bufferedSink);
        this.bufferedSink.flush();
    }

    private Sink sink(BufferedSink bufferedSink) {
        return new ForwardingSink(bufferedSink) { // from class: com.ipotensic.baselib.okhttp.ProgressRequestBody.1
            long bytesWritten = 0;
            long contentLength = 0;

            @Override // okio.ForwardingSink, okio.Sink
            public void write(Buffer buffer, long j) {
                try {
                    super.write(buffer, j);
                    if (this.contentLength == 0) {
                        this.contentLength = ProgressRequestBody.this.contentLength();
                    }
                    if (this.bytesWritten == 0) {
                        ProgressRequestBody.this.callBack.onStart();
                    }
                    long j2 = this.bytesWritten + j;
                    this.bytesWritten = j2;
                    ProgressRequestBody.this.callBack.onProgress((j2 * 1.0f) / this.contentLength, this.contentLength);
                    if (this.bytesWritten == this.contentLength) {
                        ProgressRequestBody.this.callBack.onEnd();
                    }
                } catch (Exception e) {
                    DDLog.e("\u4e0a\u4f20\u51fa\u9519:" + e.getLocalizedMessage());
                }
            }
        };
    }
}