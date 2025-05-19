package com.mapbox.api.optimization.v1;

import com.mapbox.api.optimization.v1.MapboxOptimization;
import java.util.Objects;
import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes3.dex */
final class AutoValue_MapboxOptimization extends MapboxOptimization {
    private final String accessToken;
    private final String annotations;
    private final String baseUrl;
    private final String bearings;
    private final String clientAppName;
    private final String coordinates;
    private final String destination;
    private final String distributions;
    private final String geometries;
    private final String language;
    private final String overview;
    private final String profile;
    private final String radiuses;
    private final Boolean roundTrip;
    private final String source;
    private final Boolean steps;
    private final String user;

    private AutoValue_MapboxOptimization(String str, String str2, Boolean bool, String str3, String str4, String str5, String str6, String str7, Boolean bool2, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15) {
        this.user = str;
        this.profile = str2;
        this.roundTrip = bool;
        this.distributions = str3;
        this.source = str4;
        this.destination = str5;
        this.geometries = str6;
        this.overview = str7;
        this.steps = bool2;
        this.clientAppName = str8;
        this.accessToken = str9;
        this.baseUrl = str10;
        this.language = str11;
        this.radiuses = str12;
        this.bearings = str13;
        this.coordinates = str14;
        this.annotations = str15;
    }

    @Override // com.mapbox.api.optimization.v1.MapboxOptimization
    String user() {
        return this.user;
    }

    @Override // com.mapbox.api.optimization.v1.MapboxOptimization
    String profile() {
        return this.profile;
    }

    @Override // com.mapbox.api.optimization.v1.MapboxOptimization
    Boolean roundTrip() {
        return this.roundTrip;
    }

    @Override // com.mapbox.api.optimization.v1.MapboxOptimization
    String distributions() {
        return this.distributions;
    }

    @Override // com.mapbox.api.optimization.v1.MapboxOptimization
    String source() {
        return this.source;
    }

    @Override // com.mapbox.api.optimization.v1.MapboxOptimization
    String destination() {
        return this.destination;
    }

    @Override // com.mapbox.api.optimization.v1.MapboxOptimization
    String geometries() {
        return this.geometries;
    }

    @Override // com.mapbox.api.optimization.v1.MapboxOptimization
    String overview() {
        return this.overview;
    }

    @Override // com.mapbox.api.optimization.v1.MapboxOptimization
    Boolean steps() {
        return this.steps;
    }

    @Override // com.mapbox.api.optimization.v1.MapboxOptimization
    String clientAppName() {
        return this.clientAppName;
    }

    @Override // com.mapbox.api.optimization.v1.MapboxOptimization
    String accessToken() {
        return this.accessToken;
    }

    @Override // com.mapbox.api.optimization.v1.MapboxOptimization, com.mapbox.core.MapboxService
    protected String baseUrl() {
        return this.baseUrl;
    }

    @Override // com.mapbox.api.optimization.v1.MapboxOptimization
    String language() {
        return this.language;
    }

    @Override // com.mapbox.api.optimization.v1.MapboxOptimization
    String radiuses() {
        return this.radiuses;
    }

    @Override // com.mapbox.api.optimization.v1.MapboxOptimization
    String bearings() {
        return this.bearings;
    }

    @Override // com.mapbox.api.optimization.v1.MapboxOptimization
    String coordinates() {
        return this.coordinates;
    }

    @Override // com.mapbox.api.optimization.v1.MapboxOptimization
    String annotations() {
        return this.annotations;
    }

    public String toString() {
        return "MapboxOptimization{user=" + this.user + ", profile=" + this.profile + ", roundTrip=" + this.roundTrip + ", distributions=" + this.distributions + ", source=" + this.source + ", destination=" + this.destination + ", geometries=" + this.geometries + ", overview=" + this.overview + ", steps=" + this.steps + ", clientAppName=" + this.clientAppName + ", accessToken=" + this.accessToken + ", baseUrl=" + this.baseUrl + ", language=" + this.language + ", radiuses=" + this.radiuses + ", bearings=" + this.bearings + ", coordinates=" + this.coordinates + ", annotations=" + this.annotations + StringSubstitutor.DEFAULT_VAR_END;
    }

    public boolean equals(Object obj) {
        Boolean bool;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        Boolean bool2;
        String str6;
        String str7;
        String str8;
        String str9;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MapboxOptimization)) {
            return false;
        }
        MapboxOptimization mapboxOptimization = (MapboxOptimization) obj;
        if (this.user.equals(mapboxOptimization.user()) && this.profile.equals(mapboxOptimization.profile()) && ((bool = this.roundTrip) != null ? bool.equals(mapboxOptimization.roundTrip()) : mapboxOptimization.roundTrip() == null) && ((str = this.distributions) != null ? str.equals(mapboxOptimization.distributions()) : mapboxOptimization.distributions() == null) && ((str2 = this.source) != null ? str2.equals(mapboxOptimization.source()) : mapboxOptimization.source() == null) && ((str3 = this.destination) != null ? str3.equals(mapboxOptimization.destination()) : mapboxOptimization.destination() == null) && ((str4 = this.geometries) != null ? str4.equals(mapboxOptimization.geometries()) : mapboxOptimization.geometries() == null) && ((str5 = this.overview) != null ? str5.equals(mapboxOptimization.overview()) : mapboxOptimization.overview() == null) && ((bool2 = this.steps) != null ? bool2.equals(mapboxOptimization.steps()) : mapboxOptimization.steps() == null) && ((str6 = this.clientAppName) != null ? str6.equals(mapboxOptimization.clientAppName()) : mapboxOptimization.clientAppName() == null) && this.accessToken.equals(mapboxOptimization.accessToken()) && this.baseUrl.equals(mapboxOptimization.baseUrl()) && ((str7 = this.language) != null ? str7.equals(mapboxOptimization.language()) : mapboxOptimization.language() == null) && ((str8 = this.radiuses) != null ? str8.equals(mapboxOptimization.radiuses()) : mapboxOptimization.radiuses() == null) && ((str9 = this.bearings) != null ? str9.equals(mapboxOptimization.bearings()) : mapboxOptimization.bearings() == null) && this.coordinates.equals(mapboxOptimization.coordinates())) {
            String str10 = this.annotations;
            if (str10 == null) {
                if (mapboxOptimization.annotations() == null) {
                    return true;
                }
            } else if (str10.equals(mapboxOptimization.annotations())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = (((this.user.hashCode() ^ 1000003) * 1000003) ^ this.profile.hashCode()) * 1000003;
        Boolean bool = this.roundTrip;
        int hashCode2 = (hashCode ^ (bool == null ? 0 : bool.hashCode())) * 1000003;
        String str = this.distributions;
        int hashCode3 = (hashCode2 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.source;
        int hashCode4 = (hashCode3 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.destination;
        int hashCode5 = (hashCode4 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.geometries;
        int hashCode6 = (hashCode5 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.overview;
        int hashCode7 = (hashCode6 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        Boolean bool2 = this.steps;
        int hashCode8 = (hashCode7 ^ (bool2 == null ? 0 : bool2.hashCode())) * 1000003;
        String str6 = this.clientAppName;
        int hashCode9 = (((((hashCode8 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003) ^ this.accessToken.hashCode()) * 1000003) ^ this.baseUrl.hashCode()) * 1000003;
        String str7 = this.language;
        int hashCode10 = (hashCode9 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003;
        String str8 = this.radiuses;
        int hashCode11 = (hashCode10 ^ (str8 == null ? 0 : str8.hashCode())) * 1000003;
        String str9 = this.bearings;
        int hashCode12 = (((hashCode11 ^ (str9 == null ? 0 : str9.hashCode())) * 1000003) ^ this.coordinates.hashCode()) * 1000003;
        String str10 = this.annotations;
        return hashCode12 ^ (str10 != null ? str10.hashCode() : 0);
    }

    static final class Builder extends MapboxOptimization.Builder {
        private String accessToken;
        private String annotations;
        private String baseUrl;
        private String bearings;
        private String clientAppName;
        private String coordinates;
        private String destination;
        private String distributions;
        private String geometries;
        private String language;
        private String overview;
        private String profile;
        private String radiuses;
        private Boolean roundTrip;
        private String source;
        private Boolean steps;
        private String user;

        Builder() {
        }

        @Override // com.mapbox.api.optimization.v1.MapboxOptimization.Builder
        public MapboxOptimization.Builder user(String str) {
            Objects.requireNonNull(str, "Null user");
            this.user = str;
            return this;
        }

        @Override // com.mapbox.api.optimization.v1.MapboxOptimization.Builder
        public MapboxOptimization.Builder profile(String str) {
            Objects.requireNonNull(str, "Null profile");
            this.profile = str;
            return this;
        }

        @Override // com.mapbox.api.optimization.v1.MapboxOptimization.Builder
        public MapboxOptimization.Builder roundTrip(Boolean bool) {
            this.roundTrip = bool;
            return this;
        }

        @Override // com.mapbox.api.optimization.v1.MapboxOptimization.Builder
        MapboxOptimization.Builder distributions(String str) {
            this.distributions = str;
            return this;
        }

        @Override // com.mapbox.api.optimization.v1.MapboxOptimization.Builder
        public MapboxOptimization.Builder source(String str) {
            this.source = str;
            return this;
        }

        @Override // com.mapbox.api.optimization.v1.MapboxOptimization.Builder
        public MapboxOptimization.Builder destination(String str) {
            this.destination = str;
            return this;
        }

        @Override // com.mapbox.api.optimization.v1.MapboxOptimization.Builder
        public MapboxOptimization.Builder geometries(String str) {
            this.geometries = str;
            return this;
        }

        @Override // com.mapbox.api.optimization.v1.MapboxOptimization.Builder
        public MapboxOptimization.Builder overview(String str) {
            this.overview = str;
            return this;
        }

        @Override // com.mapbox.api.optimization.v1.MapboxOptimization.Builder
        public MapboxOptimization.Builder steps(Boolean bool) {
            this.steps = bool;
            return this;
        }

        @Override // com.mapbox.api.optimization.v1.MapboxOptimization.Builder
        public MapboxOptimization.Builder clientAppName(String str) {
            this.clientAppName = str;
            return this;
        }

        @Override // com.mapbox.api.optimization.v1.MapboxOptimization.Builder
        public MapboxOptimization.Builder accessToken(String str) {
            Objects.requireNonNull(str, "Null accessToken");
            this.accessToken = str;
            return this;
        }

        @Override // com.mapbox.api.optimization.v1.MapboxOptimization.Builder
        public MapboxOptimization.Builder baseUrl(String str) {
            Objects.requireNonNull(str, "Null baseUrl");
            this.baseUrl = str;
            return this;
        }

        @Override // com.mapbox.api.optimization.v1.MapboxOptimization.Builder
        public MapboxOptimization.Builder language(String str) {
            this.language = str;
            return this;
        }

        @Override // com.mapbox.api.optimization.v1.MapboxOptimization.Builder
        MapboxOptimization.Builder radiuses(String str) {
            this.radiuses = str;
            return this;
        }

        @Override // com.mapbox.api.optimization.v1.MapboxOptimization.Builder
        MapboxOptimization.Builder bearings(String str) {
            this.bearings = str;
            return this;
        }

        @Override // com.mapbox.api.optimization.v1.MapboxOptimization.Builder
        MapboxOptimization.Builder coordinates(String str) {
            Objects.requireNonNull(str, "Null coordinates");
            this.coordinates = str;
            return this;
        }

        @Override // com.mapbox.api.optimization.v1.MapboxOptimization.Builder
        MapboxOptimization.Builder annotations(String str) {
            this.annotations = str;
            return this;
        }

        @Override // com.mapbox.api.optimization.v1.MapboxOptimization.Builder
        MapboxOptimization autoBuild() {
            String str = this.user == null ? " user" : "";
            if (this.profile == null) {
                str = str + " profile";
            }
            if (this.accessToken == null) {
                str = str + " accessToken";
            }
            if (this.baseUrl == null) {
                str = str + " baseUrl";
            }
            if (this.coordinates == null) {
                str = str + " coordinates";
            }
            if (!str.isEmpty()) {
                throw new IllegalStateException("Missing required properties:" + str);
            }
            return new AutoValue_MapboxOptimization(this.user, this.profile, this.roundTrip, this.distributions, this.source, this.destination, this.geometries, this.overview, this.steps, this.clientAppName, this.accessToken, this.baseUrl, this.language, this.radiuses, this.bearings, this.coordinates, this.annotations);
        }
    }
}
