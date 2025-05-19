package com.bumptech.glide.integration.okhttp3;

import android.content.Context;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.GenericLoaderFactory;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.stream.StreamModelLoader;
import java.io.InputStream;
import okhttp3.Call;
import okhttp3.OkHttpClient;

/* loaded from: classes.dex */
public class OkHttpUrlLoader implements StreamModelLoader<GlideUrl> {
    private final Call.Factory client;

    public OkHttpUrlLoader(Call.Factory factory) {
        this.client = factory;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public DataFetcher<InputStream> getResourceFetcher(GlideUrl glideUrl, int i, int i2) {
        return new OkHttpStreamFetcher(this.client, glideUrl);
    }

    public static class Factory implements ModelLoaderFactory<GlideUrl, InputStream> {
        private static volatile Call.Factory internalClient;
        private Call.Factory client;

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }

        public Factory() {
            this(getInternalClient());
        }

        public Factory(Call.Factory factory) {
            this.client = factory;
        }

        private static Call.Factory getInternalClient() {
            if (internalClient == null) {
                synchronized (Factory.class) {
                    if (internalClient == null) {
                        internalClient = new OkHttpClient();
                    }
                }
            }
            return internalClient;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader<GlideUrl, InputStream> build(Context context, GenericLoaderFactory genericLoaderFactory) {
            return new OkHttpUrlLoader(this.client);
        }
    }
}
