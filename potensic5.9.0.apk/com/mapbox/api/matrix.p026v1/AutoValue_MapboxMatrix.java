package com.mapbox.api.matrix.p026v1;

import com.mapbox.api.matrix.p026v1.MapboxMatrix;
import java.util.Objects;
import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes3.dex */
final class AutoValue_MapboxMatrix extends MapboxMatrix {
    private final String accessToken;
    private final String annotations;
    private final String approaches;
    private final String baseUrl;
    private final String clientAppName;
    private final String coordinates;
    private final String destinations;
    private final String profile;
    private final String sources;
    private final String user;

    private AutoValue_MapboxMatrix(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        this.clientAppName = str;
        this.user = str2;
        this.coordinates = str3;
        this.accessToken = str4;
        this.profile = str5;
        this.sources = str6;
        this.annotations = str7;
        this.approaches = str8;
        this.destinations = str9;
        this.baseUrl = str10;
    }

    @Override // com.mapbox.api.matrix.p026v1.MapboxMatrix
    String clientAppName() {
        return this.clientAppName;
    }

    @Override // com.mapbox.api.matrix.p026v1.MapboxMatrix
    String user() {
        return this.user;
    }

    @Override // com.mapbox.api.matrix.p026v1.MapboxMatrix
    String coordinates() {
        return this.coordinates;
    }

    @Override // com.mapbox.api.matrix.p026v1.MapboxMatrix
    String accessToken() {
        return this.accessToken;
    }

    @Override // com.mapbox.api.matrix.p026v1.MapboxMatrix
    String profile() {
        return this.profile;
    }

    @Override // com.mapbox.api.matrix.p026v1.MapboxMatrix
    String sources() {
        return this.sources;
    }

    @Override // com.mapbox.api.matrix.p026v1.MapboxMatrix
    String annotations() {
        return this.annotations;
    }

    @Override // com.mapbox.api.matrix.p026v1.MapboxMatrix
    String approaches() {
        return this.approaches;
    }

    @Override // com.mapbox.api.matrix.p026v1.MapboxMatrix
    String destinations() {
        return this.destinations;
    }

    @Override // com.mapbox.api.matrix.p026v1.MapboxMatrix, com.mapbox.core.MapboxService
    protected String baseUrl() {
        return this.baseUrl;
    }

    public String toString() {
        return "MapboxMatrix{clientAppName=" + this.clientAppName + ", user=" + this.user + ", coordinates=" + this.coordinates + ", accessToken=" + this.accessToken + ", profile=" + this.profile + ", sources=" + this.sources + ", annotations=" + this.annotations + ", approaches=" + this.approaches + ", destinations=" + this.destinations + ", baseUrl=" + this.baseUrl + StringSubstitutor.DEFAULT_VAR_END;
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        String str4;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MapboxMatrix)) {
            return false;
        }
        MapboxMatrix mapboxMatrix = (MapboxMatrix) obj;
        String str5 = this.clientAppName;
        if (str5 != null ? str5.equals(mapboxMatrix.clientAppName()) : mapboxMatrix.clientAppName() == null) {
            if (this.user.equals(mapboxMatrix.user()) && this.coordinates.equals(mapboxMatrix.coordinates()) && this.accessToken.equals(mapboxMatrix.accessToken()) && this.profile.equals(mapboxMatrix.profile()) && ((str = this.sources) != null ? str.equals(mapboxMatrix.sources()) : mapboxMatrix.sources() == null) && ((str2 = this.annotations) != null ? str2.equals(mapboxMatrix.annotations()) : mapboxMatrix.annotations() == null) && ((str3 = this.approaches) != null ? str3.equals(mapboxMatrix.approaches()) : mapboxMatrix.approaches() == null) && ((str4 = this.destinations) != null ? str4.equals(mapboxMatrix.destinations()) : mapboxMatrix.destinations() == null) && this.baseUrl.equals(mapboxMatrix.baseUrl())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.clientAppName;
        int hashCode = ((((((((((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003) ^ this.user.hashCode()) * 1000003) ^ this.coordinates.hashCode()) * 1000003) ^ this.accessToken.hashCode()) * 1000003) ^ this.profile.hashCode()) * 1000003;
        String str2 = this.sources;
        int hashCode2 = (hashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.annotations;
        int hashCode3 = (hashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.approaches;
        int hashCode4 = (hashCode3 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.destinations;
        return ((hashCode4 ^ (str5 != null ? str5.hashCode() : 0)) * 1000003) ^ this.baseUrl.hashCode();
    }

    static final class Builder extends MapboxMatrix.Builder {
        private String accessToken;
        private String annotations;
        private String approaches;
        private String baseUrl;
        private String clientAppName;
        private String coordinates;
        private String destinations;
        private String profile;
        private String sources;
        private String user;

        Builder() {
        }

        @Override // com.mapbox.api.matrix.v1.MapboxMatrix.Builder
        public MapboxMatrix.Builder clientAppName(String str) {
            this.clientAppName = str;
            return this;
        }

        @Override // com.mapbox.api.matrix.v1.MapboxMatrix.Builder
        public MapboxMatrix.Builder user(String str) {
            Objects.requireNonNull(str, "Null user");
            this.user = str;
            return this;
        }

        @Override // com.mapbox.api.matrix.v1.MapboxMatrix.Builder
        MapboxMatrix.Builder coordinates(String str) {
            Objects.requireNonNull(str, "Null coordinates");
            this.coordinates = str;
            return this;
        }

        @Override // com.mapbox.api.matrix.v1.MapboxMatrix.Builder
        public MapboxMatrix.Builder accessToken(String str) {
            Objects.requireNonNull(str, "Null accessToken");
            this.accessToken = str;
            return this;
        }

        @Override // com.mapbox.api.matrix.v1.MapboxMatrix.Builder
        public MapboxMatrix.Builder profile(String str) {
            Objects.requireNonNull(str, "Null profile");
            this.profile = str;
            return this;
        }

        @Override // com.mapbox.api.matrix.v1.MapboxMatrix.Builder
        MapboxMatrix.Builder sources(String str) {
            this.sources = str;
            return this;
        }

        @Override // com.mapbox.api.matrix.v1.MapboxMatrix.Builder
        MapboxMatrix.Builder annotations(String str) {
            this.annotations = str;
            return this;
        }

        @Override // com.mapbox.api.matrix.v1.MapboxMatrix.Builder
        MapboxMatrix.Builder approaches(String str) {
            this.approaches = str;
            return this;
        }

        @Override // com.mapbox.api.matrix.v1.MapboxMatrix.Builder
        MapboxMatrix.Builder destinations(String str) {
            this.destinations = str;
            return this;
        }

        @Override // com.mapbox.api.matrix.v1.MapboxMatrix.Builder
        public MapboxMatrix.Builder baseUrl(String str) {
            Objects.requireNonNull(str, "Null baseUrl");
            this.baseUrl = str;
            return this;
        }

        @Override // com.mapbox.api.matrix.v1.MapboxMatrix.Builder
        MapboxMatrix autoBuild() {
            String str = this.user == null ? " user" : "";
            if (this.coordinates == null) {
                str = str + " coordinates";
            }
            if (this.accessToken == null) {
                str = str + " accessToken";
            }
            if (this.profile == null) {
                str = str + " profile";
            }
            if (this.baseUrl == null) {
                str = str + " baseUrl";
            }
            if (!str.isEmpty()) {
                throw new IllegalStateException("Missing required properties:" + str);
            }
            return new AutoValue_MapboxMatrix(this.clientAppName, this.user, this.coordinates, this.accessToken, this.profile, this.sources, this.annotations, this.approaches, this.destinations, this.baseUrl);
        }
    }
}