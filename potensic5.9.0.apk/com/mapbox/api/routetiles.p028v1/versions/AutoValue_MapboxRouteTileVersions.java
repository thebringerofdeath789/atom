package com.mapbox.api.routetiles.p028v1.versions;

import com.mapbox.api.routetiles.p028v1.versions.MapboxRouteTileVersions;
import java.util.Objects;
import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes3.dex */
final class AutoValue_MapboxRouteTileVersions extends MapboxRouteTileVersions {
    private final String accessToken;
    private final String baseUrl;
    private final String clientAppName;

    private AutoValue_MapboxRouteTileVersions(String str, String str2, String str3) {
        this.clientAppName = str;
        this.accessToken = str2;
        this.baseUrl = str3;
    }

    @Override // com.mapbox.api.routetiles.p028v1.versions.MapboxRouteTileVersions
    String clientAppName() {
        return this.clientAppName;
    }

    @Override // com.mapbox.api.routetiles.p028v1.versions.MapboxRouteTileVersions
    String accessToken() {
        return this.accessToken;
    }

    @Override // com.mapbox.api.routetiles.p028v1.versions.MapboxRouteTileVersions, com.mapbox.core.MapboxService
    protected String baseUrl() {
        return this.baseUrl;
    }

    public String toString() {
        return "MapboxRouteTileVersions{clientAppName=" + this.clientAppName + ", accessToken=" + this.accessToken + ", baseUrl=" + this.baseUrl + StringSubstitutor.DEFAULT_VAR_END;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MapboxRouteTileVersions)) {
            return false;
        }
        MapboxRouteTileVersions mapboxRouteTileVersions = (MapboxRouteTileVersions) obj;
        String str = this.clientAppName;
        if (str != null ? str.equals(mapboxRouteTileVersions.clientAppName()) : mapboxRouteTileVersions.clientAppName() == null) {
            if (this.accessToken.equals(mapboxRouteTileVersions.accessToken()) && this.baseUrl.equals(mapboxRouteTileVersions.baseUrl())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.clientAppName;
        return (((((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003) ^ this.accessToken.hashCode()) * 1000003) ^ this.baseUrl.hashCode();
    }

    @Override // com.mapbox.api.routetiles.p028v1.versions.MapboxRouteTileVersions
    public MapboxRouteTileVersions.Builder toBuilder() {
        return new Builder(this);
    }

    static final class Builder extends MapboxRouteTileVersions.Builder {
        private String accessToken;
        private String baseUrl;
        private String clientAppName;

        Builder() {
        }

        private Builder(MapboxRouteTileVersions mapboxRouteTileVersions) {
            this.clientAppName = mapboxRouteTileVersions.clientAppName();
            this.accessToken = mapboxRouteTileVersions.accessToken();
            this.baseUrl = mapboxRouteTileVersions.baseUrl();
        }

        @Override // com.mapbox.api.routetiles.v1.versions.MapboxRouteTileVersions.Builder
        public MapboxRouteTileVersions.Builder clientAppName(String str) {
            this.clientAppName = str;
            return this;
        }

        @Override // com.mapbox.api.routetiles.v1.versions.MapboxRouteTileVersions.Builder
        public MapboxRouteTileVersions.Builder accessToken(String str) {
            Objects.requireNonNull(str, "Null accessToken");
            this.accessToken = str;
            return this;
        }

        @Override // com.mapbox.api.routetiles.v1.versions.MapboxRouteTileVersions.Builder
        public MapboxRouteTileVersions.Builder baseUrl(String str) {
            Objects.requireNonNull(str, "Null baseUrl");
            this.baseUrl = str;
            return this;
        }

        @Override // com.mapbox.api.routetiles.v1.versions.MapboxRouteTileVersions.Builder
        MapboxRouteTileVersions autoBuild() {
            String str = this.accessToken == null ? " accessToken" : "";
            if (this.baseUrl == null) {
                str = str + " baseUrl";
            }
            if (!str.isEmpty()) {
                throw new IllegalStateException("Missing required properties:" + str);
            }
            return new AutoValue_MapboxRouteTileVersions(this.clientAppName, this.accessToken, this.baseUrl);
        }
    }
}