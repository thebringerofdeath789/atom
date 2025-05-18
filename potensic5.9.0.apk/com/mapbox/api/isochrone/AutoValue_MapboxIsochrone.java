package com.mapbox.api.isochrone;

import com.mapbox.api.isochrone.MapboxIsochrone;
import java.util.Objects;
import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes3.dex */
final class AutoValue_MapboxIsochrone extends MapboxIsochrone {
    private final String accessToken;
    private final String baseUrl;
    private final String contoursColors;
    private final String contoursMinutes;
    private final String coordinates;
    private final Float denoise;
    private final Float generalize;
    private final Boolean polygons;
    private final String profile;
    private final String user;

    private AutoValue_MapboxIsochrone(String str, String str2, String str3, String str4, String str5, String str6, String str7, Boolean bool, Float f, Float f2) {
        this.baseUrl = str;
        this.accessToken = str2;
        this.user = str3;
        this.profile = str4;
        this.coordinates = str5;
        this.contoursMinutes = str6;
        this.contoursColors = str7;
        this.polygons = bool;
        this.denoise = f;
        this.generalize = f2;
    }

    @Override // com.mapbox.api.isochrone.MapboxIsochrone, com.mapbox.core.MapboxService
    protected String baseUrl() {
        return this.baseUrl;
    }

    @Override // com.mapbox.api.isochrone.MapboxIsochrone
    String accessToken() {
        return this.accessToken;
    }

    @Override // com.mapbox.api.isochrone.MapboxIsochrone
    String user() {
        return this.user;
    }

    @Override // com.mapbox.api.isochrone.MapboxIsochrone
    String profile() {
        return this.profile;
    }

    @Override // com.mapbox.api.isochrone.MapboxIsochrone
    String coordinates() {
        return this.coordinates;
    }

    @Override // com.mapbox.api.isochrone.MapboxIsochrone
    String contoursMinutes() {
        return this.contoursMinutes;
    }

    @Override // com.mapbox.api.isochrone.MapboxIsochrone
    String contoursColors() {
        return this.contoursColors;
    }

    @Override // com.mapbox.api.isochrone.MapboxIsochrone
    Boolean polygons() {
        return this.polygons;
    }

    @Override // com.mapbox.api.isochrone.MapboxIsochrone
    Float denoise() {
        return this.denoise;
    }

    @Override // com.mapbox.api.isochrone.MapboxIsochrone
    Float generalize() {
        return this.generalize;
    }

    public String toString() {
        return "MapboxIsochrone{baseUrl=" + this.baseUrl + ", accessToken=" + this.accessToken + ", user=" + this.user + ", profile=" + this.profile + ", coordinates=" + this.coordinates + ", contoursMinutes=" + this.contoursMinutes + ", contoursColors=" + this.contoursColors + ", polygons=" + this.polygons + ", denoise=" + this.denoise + ", generalize=" + this.generalize + StringSubstitutor.DEFAULT_VAR_END;
    }

    public boolean equals(Object obj) {
        String str;
        Boolean bool;
        Float f;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MapboxIsochrone)) {
            return false;
        }
        MapboxIsochrone mapboxIsochrone = (MapboxIsochrone) obj;
        if (this.baseUrl.equals(mapboxIsochrone.baseUrl()) && this.accessToken.equals(mapboxIsochrone.accessToken()) && this.user.equals(mapboxIsochrone.user()) && this.profile.equals(mapboxIsochrone.profile()) && this.coordinates.equals(mapboxIsochrone.coordinates()) && this.contoursMinutes.equals(mapboxIsochrone.contoursMinutes()) && ((str = this.contoursColors) != null ? str.equals(mapboxIsochrone.contoursColors()) : mapboxIsochrone.contoursColors() == null) && ((bool = this.polygons) != null ? bool.equals(mapboxIsochrone.polygons()) : mapboxIsochrone.polygons() == null) && ((f = this.denoise) != null ? f.equals(mapboxIsochrone.denoise()) : mapboxIsochrone.denoise() == null)) {
            Float f2 = this.generalize;
            if (f2 == null) {
                if (mapboxIsochrone.generalize() == null) {
                    return true;
                }
            } else if (f2.equals(mapboxIsochrone.generalize())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = (((((((((((this.baseUrl.hashCode() ^ 1000003) * 1000003) ^ this.accessToken.hashCode()) * 1000003) ^ this.user.hashCode()) * 1000003) ^ this.profile.hashCode()) * 1000003) ^ this.coordinates.hashCode()) * 1000003) ^ this.contoursMinutes.hashCode()) * 1000003;
        String str = this.contoursColors;
        int hashCode2 = (hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        Boolean bool = this.polygons;
        int hashCode3 = (hashCode2 ^ (bool == null ? 0 : bool.hashCode())) * 1000003;
        Float f = this.denoise;
        int hashCode4 = (hashCode3 ^ (f == null ? 0 : f.hashCode())) * 1000003;
        Float f2 = this.generalize;
        return hashCode4 ^ (f2 != null ? f2.hashCode() : 0);
    }

    static final class Builder extends MapboxIsochrone.Builder {
        private String accessToken;
        private String baseUrl;
        private String contoursColors;
        private String contoursMinutes;
        private String coordinates;
        private Float denoise;
        private Float generalize;
        private Boolean polygons;
        private String profile;
        private String user;

        Builder() {
        }

        @Override // com.mapbox.api.isochrone.MapboxIsochrone.Builder
        public MapboxIsochrone.Builder baseUrl(String str) {
            Objects.requireNonNull(str, "Null baseUrl");
            this.baseUrl = str;
            return this;
        }

        @Override // com.mapbox.api.isochrone.MapboxIsochrone.Builder
        public MapboxIsochrone.Builder accessToken(String str) {
            Objects.requireNonNull(str, "Null accessToken");
            this.accessToken = str;
            return this;
        }

        @Override // com.mapbox.api.isochrone.MapboxIsochrone.Builder
        public MapboxIsochrone.Builder user(String str) {
            Objects.requireNonNull(str, "Null user");
            this.user = str;
            return this;
        }

        @Override // com.mapbox.api.isochrone.MapboxIsochrone.Builder
        public MapboxIsochrone.Builder profile(String str) {
            Objects.requireNonNull(str, "Null profile");
            this.profile = str;
            return this;
        }

        @Override // com.mapbox.api.isochrone.MapboxIsochrone.Builder
        public MapboxIsochrone.Builder coordinates(String str) {
            Objects.requireNonNull(str, "Null coordinates");
            this.coordinates = str;
            return this;
        }

        @Override // com.mapbox.api.isochrone.MapboxIsochrone.Builder
        MapboxIsochrone.Builder contoursMinutes(String str) {
            Objects.requireNonNull(str, "Null contoursMinutes");
            this.contoursMinutes = str;
            return this;
        }

        @Override // com.mapbox.api.isochrone.MapboxIsochrone.Builder
        MapboxIsochrone.Builder contoursColors(String str) {
            this.contoursColors = str;
            return this;
        }

        @Override // com.mapbox.api.isochrone.MapboxIsochrone.Builder
        public MapboxIsochrone.Builder polygons(Boolean bool) {
            this.polygons = bool;
            return this;
        }

        @Override // com.mapbox.api.isochrone.MapboxIsochrone.Builder
        public MapboxIsochrone.Builder denoise(Float f) {
            this.denoise = f;
            return this;
        }

        @Override // com.mapbox.api.isochrone.MapboxIsochrone.Builder
        public MapboxIsochrone.Builder generalize(Float f) {
            this.generalize = f;
            return this;
        }

        @Override // com.mapbox.api.isochrone.MapboxIsochrone.Builder
        MapboxIsochrone autoBuild() {
            String str = this.baseUrl == null ? " baseUrl" : "";
            if (this.accessToken == null) {
                str = str + " accessToken";
            }
            if (this.user == null) {
                str = str + " user";
            }
            if (this.profile == null) {
                str = str + " profile";
            }
            if (this.coordinates == null) {
                str = str + " coordinates";
            }
            if (this.contoursMinutes == null) {
                str = str + " contoursMinutes";
            }
            if (!str.isEmpty()) {
                throw new IllegalStateException("Missing required properties:" + str);
            }
            return new AutoValue_MapboxIsochrone(this.baseUrl, this.accessToken, this.user, this.profile, this.coordinates, this.contoursMinutes, this.contoursColors, this.polygons, this.denoise, this.generalize);
        }
    }
}