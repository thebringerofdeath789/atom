package com.bumptech.glide.load.data;

import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.util.ContentLengthInputStream;
import com.google.android.exoplayer2.DefaultLoadControl;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

/* loaded from: classes.dex */
public class HttpUrlFetcher implements DataFetcher<InputStream> {
    private static final HttpUrlConnectionFactory DEFAULT_CONNECTION_FACTORY = new DefaultHttpUrlConnectionFactory();
    private static final int MAXIMUM_REDIRECTS = 5;
    private static final String TAG = "HttpUrlFetcher";
    private final HttpUrlConnectionFactory connectionFactory;
    private final GlideUrl glideUrl;
    private volatile boolean isCancelled;
    private InputStream stream;
    private HttpURLConnection urlConnection;

    interface HttpUrlConnectionFactory {
        HttpURLConnection build(URL url) throws IOException;
    }

    public HttpUrlFetcher(GlideUrl glideUrl) {
        this(glideUrl, DEFAULT_CONNECTION_FACTORY);
    }

    HttpUrlFetcher(GlideUrl glideUrl, HttpUrlConnectionFactory httpUrlConnectionFactory) {
        this.glideUrl = glideUrl;
        this.connectionFactory = httpUrlConnectionFactory;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.load.data.DataFetcher
    public InputStream loadData(Priority priority) throws Exception {
        return loadDataWithRedirects(this.glideUrl.toURL(), 0, null, this.glideUrl.getHeaders());
    }

    private InputStream loadDataWithRedirects(URL url, int i, URL url2, Map<String, String> map) throws IOException {
        if (i >= 5) {
            throw new IOException("Too many (> 5) redirects!");
        }
        if (url2 != null) {
            try {
                if (url.toURI().equals(url2.toURI())) {
                    throw new IOException("In re-direct loop");
                }
            } catch (URISyntaxException unused) {
            }
        }
        this.urlConnection = this.connectionFactory.build(url);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            this.urlConnection.addRequestProperty(entry.getKey(), entry.getValue());
        }
        this.urlConnection.setConnectTimeout(DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_MS);
        this.urlConnection.setReadTimeout(DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_MS);
        this.urlConnection.setUseCaches(false);
        this.urlConnection.setDoInput(true);
        this.urlConnection.connect();
        if (this.isCancelled) {
            return null;
        }
        int responseCode = this.urlConnection.getResponseCode();
        int i2 = responseCode / 100;
        if (i2 == 2) {
            return getStreamForSuccessfulRequest(this.urlConnection);
        }
        if (i2 != 3) {
            if (responseCode == -1) {
                throw new IOException("Unable to retrieve response code from HttpUrlConnection.");
            }
            throw new IOException("Request failed " + responseCode + ": " + this.urlConnection.getResponseMessage());
        }
        String headerField = this.urlConnection.getHeaderField("Location");
        if (TextUtils.isEmpty(headerField)) {
            throw new IOException("Received empty or null redirect url");
        }
        return loadDataWithRedirects(new URL(url, headerField), i + 1, url, map);
    }

    private InputStream getStreamForSuccessfulRequest(HttpURLConnection httpURLConnection) throws IOException {
        if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
            this.stream = ContentLengthInputStream.obtain(httpURLConnection.getInputStream(), httpURLConnection.getContentLength());
        } else {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Got non empty content encoding: " + httpURLConnection.getContentEncoding());
            }
            this.stream = httpURLConnection.getInputStream();
        }
        return this.stream;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cleanup() {
        InputStream inputStream = this.stream;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.urlConnection;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public String getId() {
        return this.glideUrl.getCacheKey();
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cancel() {
        this.isCancelled = true;
    }

    private static class DefaultHttpUrlConnectionFactory implements HttpUrlConnectionFactory {
        private DefaultHttpUrlConnectionFactory() {
        }

        @Override // com.bumptech.glide.load.data.HttpUrlFetcher.HttpUrlConnectionFactory
        public HttpURLConnection build(URL url) throws IOException {
            return (HttpURLConnection) url.openConnection();
        }
    }
}