package com.mapbox.api.speech.v1;

import com.mapbox.api.speech.v1.AutoValue_MapboxSpeech;
import com.mapbox.core.MapboxService;
import com.mapbox.core.exceptions.ServicesException;
import com.mapbox.core.utils.TextUtils;
import java.util.logging.Logger;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;

/* loaded from: classes3.dex */
public abstract class MapboxSpeech extends MapboxService<ResponseBody, SpeechService> {
    private static final Logger LOGGER = Logger.getLogger(MapboxSpeech.class.getName());

    abstract String accessToken();

    @Override // com.mapbox.core.MapboxService
    protected abstract String baseUrl();

    abstract Cache cache();

    abstract String instruction();

    abstract Interceptor interceptor();

    abstract String language();

    abstract Interceptor networkInterceptor();

    abstract String outputType();

    abstract String textType();

    protected MapboxSpeech() {
        super(SpeechService.class);
    }

    @Override // com.mapbox.core.MapboxService
    protected Call<ResponseBody> initializeCall() {
        return getService().getCall(instruction(), textType(), language(), outputType(), accessToken());
    }

    @Override // com.mapbox.core.MapboxService
    public synchronized OkHttpClient getOkHttpClient() {
        if (this.okHttpClient == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            if (isEnableDebug()) {
                HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
                httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
                builder.addInterceptor(httpLoggingInterceptor);
            }
            if (cache() != null) {
                builder.cache(cache());
            }
            if (interceptor() != null) {
                builder.addInterceptor(interceptor());
            }
            if (networkInterceptor() != null) {
                builder.addNetworkInterceptor(networkInterceptor());
            }
            this.okHttpClient = builder.build();
        }
        return this.okHttpClient;
    }

    public static Builder builder() {
        return new AutoValue_MapboxSpeech.Builder().baseUrl("https://api.mapbox.com");
    }

    public static abstract class Builder {
        public abstract Builder accessToken(String str);

        abstract MapboxSpeech autoBuild();

        public abstract Builder baseUrl(String str);

        public abstract Builder cache(Cache cache);

        public abstract Builder instruction(String str);

        public abstract Builder interceptor(Interceptor interceptor);

        public abstract Builder language(String str);

        public abstract Builder networkInterceptor(Interceptor interceptor);

        public abstract Builder outputType(String str);

        public abstract Builder textType(String str);

        public MapboxSpeech build() {
            MapboxSpeech autoBuild = autoBuild();
            if (TextUtils.isEmpty(autoBuild.instruction())) {
                throw new ServicesException("Non-null, non-empty instruction text is required.");
            }
            return autoBuild;
        }
    }
}
