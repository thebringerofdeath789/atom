package com.mapbox.api.routetiles.p028v1;

import com.mapbox.api.routetiles.p028v1.MapboxRouteTiles;
import com.mapbox.geojson.BoundingBox;
import java.util.Objects;
import okhttp3.Interceptor;
import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes3.dex */
final class AutoValue_MapboxRouteTiles extends MapboxRouteTiles {
    private final String accessToken;
    private final String baseUrl;
    private final BoundingBox boundingBox;
    private final String clientAppName;
    private final Interceptor interceptor;
    private final Interceptor networkInterceptor;
    private final String version;

    private AutoValue_MapboxRouteTiles(String str, BoundingBox boundingBox, String str2, String str3, Interceptor interceptor, Interceptor interceptor2, String str4) {
        this.clientAppName = str;
        this.boundingBox = boundingBox;
        this.version = str2;
        this.accessToken = str3;
        this.interceptor = interceptor;
        this.networkInterceptor = interceptor2;
        this.baseUrl = str4;
    }

    @Override // com.mapbox.api.routetiles.p028v1.MapboxRouteTiles
    String clientAppName() {
        return this.clientAppName;
    }

    @Override // com.mapbox.api.routetiles.p028v1.MapboxRouteTiles
    BoundingBox boundingBox() {
        return this.boundingBox;
    }

    @Override // com.mapbox.api.routetiles.p028v1.MapboxRouteTiles
    String version() {
        return this.version;
    }

    @Override // com.mapbox.api.routetiles.p028v1.MapboxRouteTiles
    String accessToken() {
        return this.accessToken;
    }

    @Override // com.mapbox.api.routetiles.p028v1.MapboxRouteTiles
    Interceptor interceptor() {
        return this.interceptor;
    }

    @Override // com.mapbox.api.routetiles.p028v1.MapboxRouteTiles
    Interceptor networkInterceptor() {
        return this.networkInterceptor;
    }

    @Override // com.mapbox.api.routetiles.p028v1.MapboxRouteTiles, com.mapbox.core.MapboxService
    protected String baseUrl() {
        return this.baseUrl;
    }

    public String toString() {
        return "MapboxRouteTiles{clientAppName=" + this.clientAppName + ", boundingBox=" + this.boundingBox + ", version=" + this.version + ", accessToken=" + this.accessToken + ", interceptor=" + this.interceptor + ", networkInterceptor=" + this.networkInterceptor + ", baseUrl=" + this.baseUrl + StringSubstitutor.DEFAULT_VAR_END;
    }

    public boolean equals(Object obj) {
        Interceptor interceptor;
        Interceptor interceptor2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MapboxRouteTiles)) {
            return false;
        }
        MapboxRouteTiles mapboxRouteTiles = (MapboxRouteTiles) obj;
        String str = this.clientAppName;
        if (str != null ? str.equals(mapboxRouteTiles.clientAppName()) : mapboxRouteTiles.clientAppName() == null) {
            if (this.boundingBox.equals(mapboxRouteTiles.boundingBox()) && this.version.equals(mapboxRouteTiles.version()) && this.accessToken.equals(mapboxRouteTiles.accessToken()) && ((interceptor = this.interceptor) != null ? interceptor.equals(mapboxRouteTiles.interceptor()) : mapboxRouteTiles.interceptor() == null) && ((interceptor2 = this.networkInterceptor) != null ? interceptor2.equals(mapboxRouteTiles.networkInterceptor()) : mapboxRouteTiles.networkInterceptor() == null) && this.baseUrl.equals(mapboxRouteTiles.baseUrl())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.clientAppName;
        int hashCode = ((((((((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003) ^ this.boundingBox.hashCode()) * 1000003) ^ this.version.hashCode()) * 1000003) ^ this.accessToken.hashCode()) * 1000003;
        Interceptor interceptor = this.interceptor;
        int hashCode2 = (hashCode ^ (interceptor == null ? 0 : interceptor.hashCode())) * 1000003;
        Interceptor interceptor2 = this.networkInterceptor;
        return ((hashCode2 ^ (interceptor2 != null ? interceptor2.hashCode() : 0)) * 1000003) ^ this.baseUrl.hashCode();
    }

    @Override // com.mapbox.api.routetiles.p028v1.MapboxRouteTiles
    public MapboxRouteTiles.Builder toBuilder() {
        return new Builder(this);
    }

    static final class Builder extends MapboxRouteTiles.Builder {
        private String accessToken;
        private String baseUrl;
        private BoundingBox boundingBox;
        private String clientAppName;
        private Interceptor interceptor;
        private Interceptor networkInterceptor;
        private String version;

        Builder() {
        }

        private Builder(MapboxRouteTiles mapboxRouteTiles) {
            this.clientAppName = mapboxRouteTiles.clientAppName();
            this.boundingBox = mapboxRouteTiles.boundingBox();
            this.version = mapboxRouteTiles.version();
            this.accessToken = mapboxRouteTiles.accessToken();
            this.interceptor = mapboxRouteTiles.interceptor();
            this.networkInterceptor = mapboxRouteTiles.networkInterceptor();
            this.baseUrl = mapboxRouteTiles.baseUrl();
        }

        @Override // com.mapbox.api.routetiles.v1.MapboxRouteTiles.Builder
        public MapboxRouteTiles.Builder clientAppName(String str) {
            this.clientAppName = str;
            return this;
        }

        @Override // com.mapbox.api.routetiles.v1.MapboxRouteTiles.Builder
        public MapboxRouteTiles.Builder boundingBox(BoundingBox boundingBox) {
            Objects.requireNonNull(boundingBox, "Null boundingBox");
            this.boundingBox = boundingBox;
            return this;
        }

        @Override // com.mapbox.api.routetiles.v1.MapboxRouteTiles.Builder
        public MapboxRouteTiles.Builder version(String str) {
            Objects.requireNonNull(str, "Null version");
            this.version = str;
            return this;
        }

        @Override // com.mapbox.api.routetiles.v1.MapboxRouteTiles.Builder
        public MapboxRouteTiles.Builder accessToken(String str) {
            Objects.requireNonNull(str, "Null accessToken");
            this.accessToken = str;
            return this;
        }

        @Override // com.mapbox.api.routetiles.v1.MapboxRouteTiles.Builder
        public MapboxRouteTiles.Builder interceptor(Interceptor interceptor) {
            this.interceptor = interceptor;
            return this;
        }

        @Override // com.mapbox.api.routetiles.v1.MapboxRouteTiles.Builder
        public MapboxRouteTiles.Builder networkInterceptor(Interceptor interceptor) {
            this.networkInterceptor = interceptor;
            return this;
        }

        @Override // com.mapbox.api.routetiles.v1.MapboxRouteTiles.Builder
        public MapboxRouteTiles.Builder baseUrl(String str) {
            Objects.requireNonNull(str, "Null baseUrl");
            this.baseUrl = str;
            return this;
        }

        @Override // com.mapbox.api.routetiles.v1.MapboxRouteTiles.Builder
        MapboxRouteTiles autoBuild() {
            String str = this.boundingBox == null ? " boundingBox" : "";
            if (this.version == null) {
                str = str + " version";
            }
            if (this.accessToken == null) {
                str = str + " accessToken";
            }
            if (this.baseUrl == null) {
                str = str + " baseUrl";
            }
            if (!str.isEmpty()) {
                throw new IllegalStateException("Missing required properties:" + str);
            }
            return new AutoValue_MapboxRouteTiles(this.clientAppName, this.boundingBox, this.version, this.accessToken, this.interceptor, this.networkInterceptor, this.baseUrl);
        }
    }
}