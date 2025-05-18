package com.mapbox.api.speech.p029v1;

import com.mapbox.api.speech.p029v1.MapboxSpeech;
import java.util.Objects;
import okhttp3.Cache;
import okhttp3.Interceptor;
import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes3.dex */
final class AutoValue_MapboxSpeech extends MapboxSpeech {
    private final String accessToken;
    private final String baseUrl;
    private final Cache cache;
    private final String instruction;
    private final Interceptor interceptor;
    private final String language;
    private final Interceptor networkInterceptor;
    private final String outputType;
    private final String textType;

    private AutoValue_MapboxSpeech(String str, String str2, String str3, Cache cache, Interceptor interceptor, Interceptor interceptor2, String str4, String str5, String str6) {
        this.language = str;
        this.textType = str2;
        this.outputType = str3;
        this.cache = cache;
        this.interceptor = interceptor;
        this.networkInterceptor = interceptor2;
        this.accessToken = str4;
        this.instruction = str5;
        this.baseUrl = str6;
    }

    @Override // com.mapbox.api.speech.p029v1.MapboxSpeech
    String language() {
        return this.language;
    }

    @Override // com.mapbox.api.speech.p029v1.MapboxSpeech
    String textType() {
        return this.textType;
    }

    @Override // com.mapbox.api.speech.p029v1.MapboxSpeech
    String outputType() {
        return this.outputType;
    }

    @Override // com.mapbox.api.speech.p029v1.MapboxSpeech
    Cache cache() {
        return this.cache;
    }

    @Override // com.mapbox.api.speech.p029v1.MapboxSpeech
    Interceptor interceptor() {
        return this.interceptor;
    }

    @Override // com.mapbox.api.speech.p029v1.MapboxSpeech
    Interceptor networkInterceptor() {
        return this.networkInterceptor;
    }

    @Override // com.mapbox.api.speech.p029v1.MapboxSpeech
    String accessToken() {
        return this.accessToken;
    }

    @Override // com.mapbox.api.speech.p029v1.MapboxSpeech
    String instruction() {
        return this.instruction;
    }

    @Override // com.mapbox.api.speech.p029v1.MapboxSpeech, com.mapbox.core.MapboxService
    protected String baseUrl() {
        return this.baseUrl;
    }

    public String toString() {
        return "MapboxSpeech{language=" + this.language + ", textType=" + this.textType + ", outputType=" + this.outputType + ", cache=" + this.cache + ", interceptor=" + this.interceptor + ", networkInterceptor=" + this.networkInterceptor + ", accessToken=" + this.accessToken + ", instruction=" + this.instruction + ", baseUrl=" + this.baseUrl + StringSubstitutor.DEFAULT_VAR_END;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MapboxSpeech)) {
            return false;
        }
        MapboxSpeech mapboxSpeech = (MapboxSpeech) obj;
        String str = this.language;
        if (str != null ? str.equals(mapboxSpeech.language()) : mapboxSpeech.language() == null) {
            String str2 = this.textType;
            if (str2 != null ? str2.equals(mapboxSpeech.textType()) : mapboxSpeech.textType() == null) {
                String str3 = this.outputType;
                if (str3 != null ? str3.equals(mapboxSpeech.outputType()) : mapboxSpeech.outputType() == null) {
                    Cache cache = this.cache;
                    if (cache != null ? cache.equals(mapboxSpeech.cache()) : mapboxSpeech.cache() == null) {
                        Interceptor interceptor = this.interceptor;
                        if (interceptor != null ? interceptor.equals(mapboxSpeech.interceptor()) : mapboxSpeech.interceptor() == null) {
                            Interceptor interceptor2 = this.networkInterceptor;
                            if (interceptor2 != null ? interceptor2.equals(mapboxSpeech.networkInterceptor()) : mapboxSpeech.networkInterceptor() == null) {
                                if (this.accessToken.equals(mapboxSpeech.accessToken()) && this.instruction.equals(mapboxSpeech.instruction()) && this.baseUrl.equals(mapboxSpeech.baseUrl())) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.language;
        int hashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.textType;
        int hashCode2 = (hashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.outputType;
        int hashCode3 = (hashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        Cache cache = this.cache;
        int hashCode4 = (hashCode3 ^ (cache == null ? 0 : cache.hashCode())) * 1000003;
        Interceptor interceptor = this.interceptor;
        int hashCode5 = (hashCode4 ^ (interceptor == null ? 0 : interceptor.hashCode())) * 1000003;
        Interceptor interceptor2 = this.networkInterceptor;
        return ((((((hashCode5 ^ (interceptor2 != null ? interceptor2.hashCode() : 0)) * 1000003) ^ this.accessToken.hashCode()) * 1000003) ^ this.instruction.hashCode()) * 1000003) ^ this.baseUrl.hashCode();
    }

    static final class Builder extends MapboxSpeech.Builder {
        private String accessToken;
        private String baseUrl;
        private Cache cache;
        private String instruction;
        private Interceptor interceptor;
        private String language;
        private Interceptor networkInterceptor;
        private String outputType;
        private String textType;

        Builder() {
        }

        @Override // com.mapbox.api.speech.v1.MapboxSpeech.Builder
        public MapboxSpeech.Builder language(String str) {
            this.language = str;
            return this;
        }

        @Override // com.mapbox.api.speech.v1.MapboxSpeech.Builder
        public MapboxSpeech.Builder textType(String str) {
            this.textType = str;
            return this;
        }

        @Override // com.mapbox.api.speech.v1.MapboxSpeech.Builder
        public MapboxSpeech.Builder outputType(String str) {
            this.outputType = str;
            return this;
        }

        @Override // com.mapbox.api.speech.v1.MapboxSpeech.Builder
        public MapboxSpeech.Builder cache(Cache cache) {
            this.cache = cache;
            return this;
        }

        @Override // com.mapbox.api.speech.v1.MapboxSpeech.Builder
        public MapboxSpeech.Builder interceptor(Interceptor interceptor) {
            this.interceptor = interceptor;
            return this;
        }

        @Override // com.mapbox.api.speech.v1.MapboxSpeech.Builder
        public MapboxSpeech.Builder networkInterceptor(Interceptor interceptor) {
            this.networkInterceptor = interceptor;
            return this;
        }

        @Override // com.mapbox.api.speech.v1.MapboxSpeech.Builder
        public MapboxSpeech.Builder accessToken(String str) {
            Objects.requireNonNull(str, "Null accessToken");
            this.accessToken = str;
            return this;
        }

        @Override // com.mapbox.api.speech.v1.MapboxSpeech.Builder
        public MapboxSpeech.Builder instruction(String str) {
            Objects.requireNonNull(str, "Null instruction");
            this.instruction = str;
            return this;
        }

        @Override // com.mapbox.api.speech.v1.MapboxSpeech.Builder
        public MapboxSpeech.Builder baseUrl(String str) {
            Objects.requireNonNull(str, "Null baseUrl");
            this.baseUrl = str;
            return this;
        }

        @Override // com.mapbox.api.speech.v1.MapboxSpeech.Builder
        MapboxSpeech autoBuild() {
            String str = this.accessToken == null ? " accessToken" : "";
            if (this.instruction == null) {
                str = str + " instruction";
            }
            if (this.baseUrl == null) {
                str = str + " baseUrl";
            }
            if (!str.isEmpty()) {
                throw new IllegalStateException("Missing required properties:" + str);
            }
            return new AutoValue_MapboxSpeech(this.language, this.textType, this.outputType, this.cache, this.interceptor, this.networkInterceptor, this.accessToken, this.instruction, this.baseUrl);
        }
    }
}