package retrofit2;

import java.io.IOException;
import java.util.Objects;
import javax.annotation.Nullable;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;

/* loaded from: classes6.dex */
final class OkHttpCall<T> implements Call<T> {
    private final Object[] args;
    private final Call.Factory callFactory;
    private volatile boolean canceled;

    @Nullable
    private Throwable creationFailure;
    private boolean executed;

    @Nullable
    private okhttp3.Call rawCall;
    private final RequestFactory requestFactory;
    private final Converter<ResponseBody, T> responseConverter;

    OkHttpCall(RequestFactory requestFactory, Object[] objArr, Call.Factory factory, Converter<ResponseBody, T> converter) {
        this.requestFactory = requestFactory;
        this.args = objArr;
        this.callFactory = factory;
        this.responseConverter = converter;
    }

    @Override // retrofit2.Call
    public OkHttpCall<T> clone() {
        return new OkHttpCall<>(this.requestFactory, this.args, this.callFactory, this.responseConverter);
    }

    @Override // retrofit2.Call
    public synchronized Request request() {
        okhttp3.Call call = this.rawCall;
        if (call != null) {
            return call.request();
        }
        Throwable th = this.creationFailure;
        if (th != null) {
            if (th instanceof IOException) {
                throw new RuntimeException("Unable to create request.", this.creationFailure);
            }
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            throw ((Error) th);
        }
        try {
            okhttp3.Call createRawCall = createRawCall();
            this.rawCall = createRawCall;
            return createRawCall.request();
        } catch (IOException e) {
            this.creationFailure = e;
            throw new RuntimeException("Unable to create request.", e);
        } catch (Error e2) {
            e = e2;
            Utils.throwIfFatal(e);
            this.creationFailure = e;
            throw e;
        } catch (RuntimeException e3) {
            e = e3;
            Utils.throwIfFatal(e);
            this.creationFailure = e;
            throw e;
        }
    }

    @Override // retrofit2.Call
    public void enqueue(final Callback<T> callback) {
        okhttp3.Call call;
        Throwable th;
        Objects.requireNonNull(callback, "callback == null");
        synchronized (this) {
            if (this.executed) {
                throw new IllegalStateException("Already executed.");
            }
            this.executed = true;
            call = this.rawCall;
            th = this.creationFailure;
            if (call == null && th == null) {
                try {
                    okhttp3.Call createRawCall = createRawCall();
                    this.rawCall = createRawCall;
                    call = createRawCall;
                } catch (Throwable th2) {
                    th = th2;
                    Utils.throwIfFatal(th);
                    this.creationFailure = th;
                }
            }
        }
        if (th != null) {
            callback.onFailure(this, th);
            return;
        }
        if (this.canceled) {
            call.cancel();
        }
        call.enqueue(new okhttp3.Callback() { // from class: retrofit2.OkHttpCall.1
            @Override // okhttp3.Callback
            public void onResponse(okhttp3.Call call2, okhttp3.Response response) {
                try {
                    try {
                        callback.onResponse(OkHttpCall.this, OkHttpCall.this.parseResponse(response));
                    } catch (Throwable th3) {
                        Utils.throwIfFatal(th3);
                        th3.printStackTrace();
                    }
                } catch (Throwable th4) {
                    Utils.throwIfFatal(th4);
                    callFailure(th4);
                }
            }

            @Override // okhttp3.Callback
            public void onFailure(okhttp3.Call call2, IOException iOException) {
                callFailure(iOException);
            }

            private void callFailure(Throwable th3) {
                try {
                    callback.onFailure(OkHttpCall.this, th3);
                } catch (Throwable th4) {
                    Utils.throwIfFatal(th4);
                    th4.printStackTrace();
                }
            }
        });
    }

    @Override // retrofit2.Call
    public synchronized boolean isExecuted() {
        return this.executed;
    }

    @Override // retrofit2.Call
    public Response<T> execute() throws IOException {
        okhttp3.Call call;
        synchronized (this) {
            if (this.executed) {
                throw new IllegalStateException("Already executed.");
            }
            this.executed = true;
            Throwable th = this.creationFailure;
            if (th != null) {
                if (th instanceof IOException) {
                    throw ((IOException) th);
                }
                if (th instanceof RuntimeException) {
                    throw ((RuntimeException) th);
                }
                throw ((Error) th);
            }
            call = this.rawCall;
            if (call == null) {
                try {
                    call = createRawCall();
                    this.rawCall = call;
                } catch (IOException | Error | RuntimeException e) {
                    Utils.throwIfFatal(e);
                    this.creationFailure = e;
                    throw e;
                }
            }
        }
        if (this.canceled) {
            call.cancel();
        }
        return parseResponse(call.execute());
    }

    private okhttp3.Call createRawCall() throws IOException {
        okhttp3.Call newCall = this.callFactory.newCall(this.requestFactory.create(this.args));
        Objects.requireNonNull(newCall, "Call.Factory returned null.");
        return newCall;
    }

    Response<T> parseResponse(okhttp3.Response response) throws IOException {
        ResponseBody body = response.body();
        okhttp3.Response build = response.newBuilder().body(new NoContentResponseBody(body.get$contentType(), body.getContentLength())).build();
        int code = build.code();
        if (code < 200 || code >= 300) {
            try {
                return Response.error(Utils.buffer(body), build);
            } finally {
                body.close();
            }
        }
        if (code == 204 || code == 205) {
            body.close();
            return Response.success((Object) null, build);
        }
        ExceptionCatchingResponseBody exceptionCatchingResponseBody = new ExceptionCatchingResponseBody(body);
        try {
            return Response.success(this.responseConverter.convert(exceptionCatchingResponseBody), build);
        } catch (RuntimeException e) {
            exceptionCatchingResponseBody.throwIfCaught();
            throw e;
        }
    }

    @Override // retrofit2.Call
    public void cancel() {
        okhttp3.Call call;
        this.canceled = true;
        synchronized (this) {
            call = this.rawCall;
        }
        if (call != null) {
            call.cancel();
        }
    }

    @Override // retrofit2.Call
    public boolean isCanceled() {
        boolean z = true;
        if (this.canceled) {
            return true;
        }
        synchronized (this) {
            okhttp3.Call call = this.rawCall;
            if (call == null || !call.getCanceled()) {
                z = false;
            }
        }
        return z;
    }

    static final class NoContentResponseBody extends ResponseBody {
        private final long contentLength;

        @Nullable
        private final MediaType contentType;

        NoContentResponseBody(@Nullable MediaType mediaType, long j) {
            this.contentType = mediaType;
            this.contentLength = j;
        }

        @Override // okhttp3.ResponseBody
        /* renamed from: contentType */
        public MediaType get$contentType() {
            return this.contentType;
        }

        @Override // okhttp3.ResponseBody
        /* renamed from: contentLength */
        public long getContentLength() {
            return this.contentLength;
        }

        @Override // okhttp3.ResponseBody
        /* renamed from: source */
        public BufferedSource getSource() {
            throw new IllegalStateException("Cannot read raw response body of a converted body.");
        }
    }

    static final class ExceptionCatchingResponseBody extends ResponseBody {
        private final ResponseBody delegate;
        private final BufferedSource delegateSource;

        @Nullable
        IOException thrownException;

        ExceptionCatchingResponseBody(ResponseBody responseBody) {
            this.delegate = responseBody;
            this.delegateSource = Okio.buffer(new ForwardingSource(responseBody.getSource()) { // from class: retrofit2.OkHttpCall.ExceptionCatchingResponseBody.1
                @Override // okio.ForwardingSource, okio.Source
                public long read(Buffer buffer, long j) throws IOException {
                    try {
                        return super.read(buffer, j);
                    } catch (IOException e) {
                        ExceptionCatchingResponseBody.this.thrownException = e;
                        throw e;
                    }
                }
            });
        }

        @Override // okhttp3.ResponseBody
        /* renamed from: contentType */
        public MediaType get$contentType() {
            return this.delegate.get$contentType();
        }

        @Override // okhttp3.ResponseBody
        /* renamed from: contentLength */
        public long getContentLength() {
            return this.delegate.getContentLength();
        }

        @Override // okhttp3.ResponseBody
        /* renamed from: source */
        public BufferedSource getSource() {
            return this.delegateSource;
        }

        @Override // okhttp3.ResponseBody, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.delegate.close();
        }

        void throwIfCaught() throws IOException {
            IOException iOException = this.thrownException;
            if (iOException != null) {
                throw iOException;
            }
        }
    }
}
