package com.bumptech.glide.load.model;

import com.bumptech.glide.load.data.DataFetcher;
import java.net.URL;

/* loaded from: classes.dex */
public class UrlLoader<T> implements ModelLoader<URL, T> {
    private final ModelLoader<GlideUrl, T> glideUrlLoader;

    public UrlLoader(ModelLoader<GlideUrl, T> modelLoader) {
        this.glideUrlLoader = modelLoader;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public DataFetcher<T> getResourceFetcher(URL url, int i, int i2) {
        return this.glideUrlLoader.getResourceFetcher(new GlideUrl(url), i, i2);
    }
}
