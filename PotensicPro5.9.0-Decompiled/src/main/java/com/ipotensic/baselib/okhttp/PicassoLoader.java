package com.ipotensic.baselib.okhttp;

import android.content.Context;
import android.net.Uri;
import com.squareup.picasso.Downloader;
import com.squareup.picasso.Picasso;
import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes2.dex */
public class PicassoLoader {
    public static Picasso with(Context context) {
        return new Picasso.Builder(context).downloader(new OkHttpDownloader(ClientManager.getInstance().getClient())).build();
    }

    private static class OkHttpDownloader implements Downloader {
        private OkHttpClient client;

        public OkHttpDownloader(OkHttpClient okHttpClient) {
            this.client = okHttpClient;
        }

        @Override // com.squareup.picasso.Downloader
        public Downloader.Response load(Uri uri, int i) throws IOException {
            Response execute = this.client.newCall(new Request.Builder().url(uri.toString()).build()).execute();
            int code = execute.code();
            if (code >= 300) {
                execute.body().close();
                throw new Downloader.ResponseException(code + StringUtils.SPACE + execute.message(), i, code);
            }
            boolean z = execute.cacheResponse() != null;
            ResponseBody body = execute.body();
            return new Downloader.Response(body.byteStream(), z, body.getContentLength());
        }

        @Override // com.squareup.picasso.Downloader
        public void shutdown() {
            OkHttpClient okHttpClient = this.client;
            if (okHttpClient != null) {
                try {
                    okHttpClient.cache().delete();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
