package com.ipotensic.baselib.mediadataretriever;

import android.content.Context;
import android.view.View;
import com.ipotensic.baselib.mediadataretriever.cache.CacheManager;
import com.ipotensic.baselib.mediadataretriever.cache.SettingBuilder;
import com.ipotensic.baselib.mediadataretriever.core.MediaDataRetrieverTaskLoader;
import com.ipotensic.baselib.mediadataretriever.entity.LoadTask;
import com.ipotensic.baselib.mediadataretriever.entity.MetadataKey;
import com.ipotensic.baselib.mediadataretriever.inter.OnMediaRetrieverLoadListener;
import java.util.Map;

/* loaded from: classes2.dex */
public class MediaRetriever {
    public static final int FULL_SCREEN_KIND = 2;
    public static final int MICRO_KIND = 3;
    public static final int MINI_KIND = 1;

    public static void init(SettingBuilder settingBuilder) {
        CacheManager.getInstance().init(settingBuilder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void checkCacheInit(View view) {
        if (CacheManager.getInstance().isHasInit() || view == null) {
            return;
        }
        Context context = view.getContext();
        init(new SettingBuilder().setContext(context).setCacheDir(context.getExternalCacheDir()).setDiskCacheValueCount(1).setMaxMemoryCacheSize(((int) Runtime.getRuntime().maxMemory()) / 8).setMaxDiskCacheSize(SettingBuilder.DEFAULT_MAX_CACHE_SIZE).setCacheKeyProvider(new SettingBuilder.DefaultCacheKeyProvider()));
    }

    public static RetrieverBuilder withVideo(String str) {
        return new RetrieverBuilder(1, str);
    }

    public static RetrieverBuilder withAudio(String str) {
        return new RetrieverBuilder(2, str);
    }

    public static class RetrieverBuilder {
        private String dataSource;
        private int errorHolder;
        private Map<String, String> headers;
        private MetadataKey[] keys;
        private int placeHolder;
        private int sourceType;
        private int thumbnailType;
        private long time = -1;
        private int option = -1;

        public void into(View view) {
            into(view, null);
        }

        public void into(View view, OnMediaRetrieverLoadListener onMediaRetrieverLoadListener) {
            MediaRetriever.checkCacheInit(view);
            createLoadTask(view, onMediaRetrieverLoadListener);
        }

        private void createLoadTask(View view, OnMediaRetrieverLoadListener onMediaRetrieverLoadListener) {
            MediaDataRetrieverTaskLoader.load(new LoadTask(this.sourceType, this.dataSource, view, this.placeHolder, this.errorHolder, this.time, this.option, this.thumbnailType, this.keys, this.headers, onMediaRetrieverLoadListener));
        }

        public void into(OnMediaRetrieverLoadListener onMediaRetrieverLoadListener) {
            createLoadTask(null, onMediaRetrieverLoadListener);
        }

        public RetrieverBuilder(int i, String str) {
            this.sourceType = 1;
            this.sourceType = i;
            this.dataSource = str;
        }

        public RetrieverBuilder frameAt(long j) {
            this.time = j;
            return this;
        }

        public RetrieverBuilder option(int i) {
            this.option = i;
            return this;
        }

        public RetrieverBuilder metaKeys(MetadataKey[] metadataKeyArr) {
            this.keys = metadataKeyArr;
            return this;
        }

        public RetrieverBuilder headers(Map<String, String> map) {
            this.headers = map;
            return this;
        }

        public RetrieverBuilder thumbnailType(int i) {
            this.thumbnailType = i;
            return this;
        }

        public RetrieverBuilder placeHolder(int i) {
            this.placeHolder = i;
            return this;
        }

        public RetrieverBuilder errorHolder(int i) {
            this.errorHolder = i;
            return this;
        }
    }
}
