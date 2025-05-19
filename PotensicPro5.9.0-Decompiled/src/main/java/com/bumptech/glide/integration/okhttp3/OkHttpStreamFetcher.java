package com.bumptech.glide.integration.okhttp3;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.util.ContentLengthInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import okhttp3.Call;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* loaded from: classes.dex */
public class OkHttpStreamFetcher implements DataFetcher<InputStream> {
    private volatile Call call;
    private final Call.Factory client;
    private ResponseBody responseBody;
    private InputStream stream;
    private final GlideUrl url;

    public OkHttpStreamFetcher(Call.Factory factory, GlideUrl glideUrl) {
        this.client = factory;
        this.url = glideUrl;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.load.data.DataFetcher
    public InputStream loadData(Priority priority) throws Exception {
        Request.Builder url = new Request.Builder().url(this.url.toStringUrl());
        for (Map.Entry<String, String> entry : this.url.getHeaders().entrySet()) {
            url.addHeader(entry.getKey(), entry.getValue());
        }
        this.call = this.client.newCall(url.build());
        Response execute = this.call.execute();
        this.responseBody = execute.body();
        if (!execute.isSuccessful()) {
            throw new IOException("Request failed with code: " + execute.code());
        }
        InputStream obtain = ContentLengthInputStream.obtain(this.responseBody.byteStream(), this.responseBody.getContentLength());
        this.stream = obtain;
        return obtain;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cleanup() {
        try {
            InputStream inputStream = this.stream;
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (IOException unused) {
        }
        ResponseBody responseBody = this.responseBody;
        if (responseBody != null) {
            responseBody.close();
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public String getId() {
        return this.url.getCacheKey();
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cancel() {
        Call call = this.call;
        if (call != null) {
            call.cancel();
        }
    }
}
