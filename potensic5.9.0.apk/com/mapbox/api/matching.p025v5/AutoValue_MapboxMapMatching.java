package com.mapbox.api.matching.p025v5;

import com.mapbox.api.matching.p025v5.MapboxMapMatching;
import java.util.Objects;
import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes3.dex */
final class AutoValue_MapboxMapMatching extends MapboxMapMatching {
    private final String accessToken;
    private final String annotations;
    private final String approaches;
    private final Boolean bannerInstructions;
    private final String baseUrl;
    private final String clientAppName;
    private final String coordinates;
    private final String geometries;
    private final String ignore;
    private final String language;
    private final String overview;
    private final String profile;
    private final String radiuses;
    private final Boolean roundaboutExits;
    private final Boolean steps;
    private final Boolean tidy;
    private final String timestamps;
    private final Boolean usePostMethod;
    private final String user;
    private final Boolean voiceInstructions;
    private final String voiceUnits;
    private final String waypointIndices;
    private final String waypointNames;

    private AutoValue_MapboxMapMatching(Boolean bool, String str, String str2, Boolean bool2, String str3, String str4, String str5, String str6, String str7, Boolean bool3, String str8, String str9, String str10, String str11, Boolean bool4, Boolean bool5, Boolean bool6, String str12, String str13, String str14, String str15, String str16, String str17) {
        this.usePostMethod = bool;
        this.clientAppName = str;
        this.accessToken = str2;
        this.tidy = bool2;
        this.user = str3;
        this.profile = str4;
        this.coordinates = str5;
        this.geometries = str6;
        this.radiuses = str7;
        this.steps = bool3;
        this.overview = str8;
        this.timestamps = str9;
        this.annotations = str10;
        this.language = str11;
        this.roundaboutExits = bool4;
        this.bannerInstructions = bool5;
        this.voiceInstructions = bool6;
        this.voiceUnits = str12;
        this.waypointIndices = str13;
        this.waypointNames = str14;
        this.ignore = str15;
        this.approaches = str16;
        this.baseUrl = str17;
    }

    @Override // com.mapbox.api.matching.p025v5.MapboxMapMatching
    Boolean usePostMethod() {
        return this.usePostMethod;
    }

    @Override // com.mapbox.api.matching.p025v5.MapboxMapMatching
    String clientAppName() {
        return this.clientAppName;
    }

    @Override // com.mapbox.api.matching.p025v5.MapboxMapMatching
    String accessToken() {
        return this.accessToken;
    }

    @Override // com.mapbox.api.matching.p025v5.MapboxMapMatching
    Boolean tidy() {
        return this.tidy;
    }

    @Override // com.mapbox.api.matching.p025v5.MapboxMapMatching
    String user() {
        return this.user;
    }

    @Override // com.mapbox.api.matching.p025v5.MapboxMapMatching
    String profile() {
        return this.profile;
    }

    @Override // com.mapbox.api.matching.p025v5.MapboxMapMatching
    String coordinates() {
        return this.coordinates;
    }

    @Override // com.mapbox.api.matching.p025v5.MapboxMapMatching
    String geometries() {
        return this.geometries;
    }

    @Override // com.mapbox.api.matching.p025v5.MapboxMapMatching
    String radiuses() {
        return this.radiuses;
    }

    @Override // com.mapbox.api.matching.p025v5.MapboxMapMatching
    Boolean steps() {
        return this.steps;
    }

    @Override // com.mapbox.api.matching.p025v5.MapboxMapMatching
    String overview() {
        return this.overview;
    }

    @Override // com.mapbox.api.matching.p025v5.MapboxMapMatching
    String timestamps() {
        return this.timestamps;
    }

    @Override // com.mapbox.api.matching.p025v5.MapboxMapMatching
    String annotations() {
        return this.annotations;
    }

    @Override // com.mapbox.api.matching.p025v5.MapboxMapMatching
    String language() {
        return this.language;
    }

    @Override // com.mapbox.api.matching.p025v5.MapboxMapMatching
    Boolean roundaboutExits() {
        return this.roundaboutExits;
    }

    @Override // com.mapbox.api.matching.p025v5.MapboxMapMatching
    Boolean bannerInstructions() {
        return this.bannerInstructions;
    }

    @Override // com.mapbox.api.matching.p025v5.MapboxMapMatching
    Boolean voiceInstructions() {
        return this.voiceInstructions;
    }

    @Override // com.mapbox.api.matching.p025v5.MapboxMapMatching
    String voiceUnits() {
        return this.voiceUnits;
    }

    @Override // com.mapbox.api.matching.p025v5.MapboxMapMatching
    String waypointIndices() {
        return this.waypointIndices;
    }

    @Override // com.mapbox.api.matching.p025v5.MapboxMapMatching
    String waypointNames() {
        return this.waypointNames;
    }

    @Override // com.mapbox.api.matching.p025v5.MapboxMapMatching
    String ignore() {
        return this.ignore;
    }

    @Override // com.mapbox.api.matching.p025v5.MapboxMapMatching
    String approaches() {
        return this.approaches;
    }

    @Override // com.mapbox.api.matching.p025v5.MapboxMapMatching, com.mapbox.core.MapboxService
    protected String baseUrl() {
        return this.baseUrl;
    }

    public String toString() {
        return "MapboxMapMatching{usePostMethod=" + this.usePostMethod + ", clientAppName=" + this.clientAppName + ", accessToken=" + this.accessToken + ", tidy=" + this.tidy + ", user=" + this.user + ", profile=" + this.profile + ", coordinates=" + this.coordinates + ", geometries=" + this.geometries + ", radiuses=" + this.radiuses + ", steps=" + this.steps + ", overview=" + this.overview + ", timestamps=" + this.timestamps + ", annotations=" + this.annotations + ", language=" + this.language + ", roundaboutExits=" + this.roundaboutExits + ", bannerInstructions=" + this.bannerInstructions + ", voiceInstructions=" + this.voiceInstructions + ", voiceUnits=" + this.voiceUnits + ", waypointIndices=" + this.waypointIndices + ", waypointNames=" + this.waypointNames + ", ignore=" + this.ignore + ", approaches=" + this.approaches + ", baseUrl=" + this.baseUrl + StringSubstitutor.DEFAULT_VAR_END;
    }

    public boolean equals(Object obj) {
        Boolean bool;
        String str;
        Boolean bool2;
        String str2;
        String str3;
        String str4;
        String str5;
        Boolean bool3;
        Boolean bool4;
        Boolean bool5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MapboxMapMatching)) {
            return false;
        }
        MapboxMapMatching mapboxMapMatching = (MapboxMapMatching) obj;
        Boolean bool6 = this.usePostMethod;
        if (bool6 != null ? bool6.equals(mapboxMapMatching.usePostMethod()) : mapboxMapMatching.usePostMethod() == null) {
            String str11 = this.clientAppName;
            if (str11 != null ? str11.equals(mapboxMapMatching.clientAppName()) : mapboxMapMatching.clientAppName() == null) {
                if (this.accessToken.equals(mapboxMapMatching.accessToken()) && ((bool = this.tidy) != null ? bool.equals(mapboxMapMatching.tidy()) : mapboxMapMatching.tidy() == null) && this.user.equals(mapboxMapMatching.user()) && this.profile.equals(mapboxMapMatching.profile()) && this.coordinates.equals(mapboxMapMatching.coordinates()) && this.geometries.equals(mapboxMapMatching.geometries()) && ((str = this.radiuses) != null ? str.equals(mapboxMapMatching.radiuses()) : mapboxMapMatching.radiuses() == null) && ((bool2 = this.steps) != null ? bool2.equals(mapboxMapMatching.steps()) : mapboxMapMatching.steps() == null) && ((str2 = this.overview) != null ? str2.equals(mapboxMapMatching.overview()) : mapboxMapMatching.overview() == null) && ((str3 = this.timestamps) != null ? str3.equals(mapboxMapMatching.timestamps()) : mapboxMapMatching.timestamps() == null) && ((str4 = this.annotations) != null ? str4.equals(mapboxMapMatching.annotations()) : mapboxMapMatching.annotations() == null) && ((str5 = this.language) != null ? str5.equals(mapboxMapMatching.language()) : mapboxMapMatching.language() == null) && ((bool3 = this.roundaboutExits) != null ? bool3.equals(mapboxMapMatching.roundaboutExits()) : mapboxMapMatching.roundaboutExits() == null) && ((bool4 = this.bannerInstructions) != null ? bool4.equals(mapboxMapMatching.bannerInstructions()) : mapboxMapMatching.bannerInstructions() == null) && ((bool5 = this.voiceInstructions) != null ? bool5.equals(mapboxMapMatching.voiceInstructions()) : mapboxMapMatching.voiceInstructions() == null) && ((str6 = this.voiceUnits) != null ? str6.equals(mapboxMapMatching.voiceUnits()) : mapboxMapMatching.voiceUnits() == null) && ((str7 = this.waypointIndices) != null ? str7.equals(mapboxMapMatching.waypointIndices()) : mapboxMapMatching.waypointIndices() == null) && ((str8 = this.waypointNames) != null ? str8.equals(mapboxMapMatching.waypointNames()) : mapboxMapMatching.waypointNames() == null) && ((str9 = this.ignore) != null ? str9.equals(mapboxMapMatching.ignore()) : mapboxMapMatching.ignore() == null) && ((str10 = this.approaches) != null ? str10.equals(mapboxMapMatching.approaches()) : mapboxMapMatching.approaches() == null) && this.baseUrl.equals(mapboxMapMatching.baseUrl())) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        Boolean bool = this.usePostMethod;
        int hashCode = ((bool == null ? 0 : bool.hashCode()) ^ 1000003) * 1000003;
        String str = this.clientAppName;
        int hashCode2 = (((hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003) ^ this.accessToken.hashCode()) * 1000003;
        Boolean bool2 = this.tidy;
        int hashCode3 = (((((((((hashCode2 ^ (bool2 == null ? 0 : bool2.hashCode())) * 1000003) ^ this.user.hashCode()) * 1000003) ^ this.profile.hashCode()) * 1000003) ^ this.coordinates.hashCode()) * 1000003) ^ this.geometries.hashCode()) * 1000003;
        String str2 = this.radiuses;
        int hashCode4 = (hashCode3 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        Boolean bool3 = this.steps;
        int hashCode5 = (hashCode4 ^ (bool3 == null ? 0 : bool3.hashCode())) * 1000003;
        String str3 = this.overview;
        int hashCode6 = (hashCode5 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.timestamps;
        int hashCode7 = (hashCode6 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.annotations;
        int hashCode8 = (hashCode7 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        String str6 = this.language;
        int hashCode9 = (hashCode8 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        Boolean bool4 = this.roundaboutExits;
        int hashCode10 = (hashCode9 ^ (bool4 == null ? 0 : bool4.hashCode())) * 1000003;
        Boolean bool5 = this.bannerInstructions;
        int hashCode11 = (hashCode10 ^ (bool5 == null ? 0 : bool5.hashCode())) * 1000003;
        Boolean bool6 = this.voiceInstructions;
        int hashCode12 = (hashCode11 ^ (bool6 == null ? 0 : bool6.hashCode())) * 1000003;
        String str7 = this.voiceUnits;
        int hashCode13 = (hashCode12 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003;
        String str8 = this.waypointIndices;
        int hashCode14 = (hashCode13 ^ (str8 == null ? 0 : str8.hashCode())) * 1000003;
        String str9 = this.waypointNames;
        int hashCode15 = (hashCode14 ^ (str9 == null ? 0 : str9.hashCode())) * 1000003;
        String str10 = this.ignore;
        int hashCode16 = (hashCode15 ^ (str10 == null ? 0 : str10.hashCode())) * 1000003;
        String str11 = this.approaches;
        return ((hashCode16 ^ (str11 != null ? str11.hashCode() : 0)) * 1000003) ^ this.baseUrl.hashCode();
    }

    static final class Builder extends MapboxMapMatching.Builder {
        private String accessToken;
        private String annotations;
        private String approaches;
        private Boolean bannerInstructions;
        private String baseUrl;
        private String clientAppName;
        private String coordinates;
        private String geometries;
        private String ignore;
        private String language;
        private String overview;
        private String profile;
        private String radiuses;
        private Boolean roundaboutExits;
        private Boolean steps;
        private Boolean tidy;
        private String timestamps;
        private Boolean usePostMethod;
        private String user;
        private Boolean voiceInstructions;
        private String voiceUnits;
        private String waypointIndices;
        private String waypointNames;

        Builder() {
        }

        @Override // com.mapbox.api.matching.v5.MapboxMapMatching.Builder
        MapboxMapMatching.Builder usePostMethod(Boolean bool) {
            this.usePostMethod = bool;
            return this;
        }

        @Override // com.mapbox.api.matching.v5.MapboxMapMatching.Builder
        public MapboxMapMatching.Builder clientAppName(String str) {
            this.clientAppName = str;
            return this;
        }

        @Override // com.mapbox.api.matching.v5.MapboxMapMatching.Builder
        public MapboxMapMatching.Builder accessToken(String str) {
            Objects.requireNonNull(str, "Null accessToken");
            this.accessToken = str;
            return this;
        }

        @Override // com.mapbox.api.matching.v5.MapboxMapMatching.Builder
        public MapboxMapMatching.Builder tidy(Boolean bool) {
            this.tidy = bool;
            return this;
        }

        @Override // com.mapbox.api.matching.v5.MapboxMapMatching.Builder
        public MapboxMapMatching.Builder user(String str) {
            Objects.requireNonNull(str, "Null user");
            this.user = str;
            return this;
        }

        @Override // com.mapbox.api.matching.v5.MapboxMapMatching.Builder
        public MapboxMapMatching.Builder profile(String str) {
            Objects.requireNonNull(str, "Null profile");
            this.profile = str;
            return this;
        }

        @Override // com.mapbox.api.matching.v5.MapboxMapMatching.Builder
        protected MapboxMapMatching.Builder coordinates(String str) {
            Objects.requireNonNull(str, "Null coordinates");
            this.coordinates = str;
            return this;
        }

        @Override // com.mapbox.api.matching.v5.MapboxMapMatching.Builder
        public MapboxMapMatching.Builder geometries(String str) {
            Objects.requireNonNull(str, "Null geometries");
            this.geometries = str;
            return this;
        }

        @Override // com.mapbox.api.matching.v5.MapboxMapMatching.Builder
        MapboxMapMatching.Builder radiuses(String str) {
            this.radiuses = str;
            return this;
        }

        @Override // com.mapbox.api.matching.v5.MapboxMapMatching.Builder
        public MapboxMapMatching.Builder steps(Boolean bool) {
            this.steps = bool;
            return this;
        }

        @Override // com.mapbox.api.matching.v5.MapboxMapMatching.Builder
        public MapboxMapMatching.Builder overview(String str) {
            this.overview = str;
            return this;
        }

        @Override // com.mapbox.api.matching.v5.MapboxMapMatching.Builder
        protected MapboxMapMatching.Builder timestamps(String str) {
            this.timestamps = str;
            return this;
        }

        @Override // com.mapbox.api.matching.v5.MapboxMapMatching.Builder
        protected MapboxMapMatching.Builder annotations(String str) {
            this.annotations = str;
            return this;
        }

        @Override // com.mapbox.api.matching.v5.MapboxMapMatching.Builder
        public MapboxMapMatching.Builder language(String str) {
            this.language = str;
            return this;
        }

        @Override // com.mapbox.api.matching.v5.MapboxMapMatching.Builder
        public MapboxMapMatching.Builder roundaboutExits(Boolean bool) {
            this.roundaboutExits = bool;
            return this;
        }

        @Override // com.mapbox.api.matching.v5.MapboxMapMatching.Builder
        public MapboxMapMatching.Builder bannerInstructions(Boolean bool) {
            this.bannerInstructions = bool;
            return this;
        }

        @Override // com.mapbox.api.matching.v5.MapboxMapMatching.Builder
        public MapboxMapMatching.Builder voiceInstructions(Boolean bool) {
            this.voiceInstructions = bool;
            return this;
        }

        @Override // com.mapbox.api.matching.v5.MapboxMapMatching.Builder
        public MapboxMapMatching.Builder voiceUnits(String str) {
            this.voiceUnits = str;
            return this;
        }

        @Override // com.mapbox.api.matching.v5.MapboxMapMatching.Builder
        MapboxMapMatching.Builder waypointIndices(String str) {
            this.waypointIndices = str;
            return this;
        }

        @Override // com.mapbox.api.matching.v5.MapboxMapMatching.Builder
        MapboxMapMatching.Builder waypointNames(String str) {
            this.waypointNames = str;
            return this;
        }

        @Override // com.mapbox.api.matching.v5.MapboxMapMatching.Builder
        MapboxMapMatching.Builder ignore(String str) {
            this.ignore = str;
            return this;
        }

        @Override // com.mapbox.api.matching.v5.MapboxMapMatching.Builder
        MapboxMapMatching.Builder approaches(String str) {
            this.approaches = str;
            return this;
        }

        @Override // com.mapbox.api.matching.v5.MapboxMapMatching.Builder
        public MapboxMapMatching.Builder baseUrl(String str) {
            Objects.requireNonNull(str, "Null baseUrl");
            this.baseUrl = str;
            return this;
        }

        @Override // com.mapbox.api.matching.v5.MapboxMapMatching.Builder
        protected MapboxMapMatching autoBuild() {
            String str = this.accessToken == null ? " accessToken" : "";
            if (this.user == null) {
                str = str + " user";
            }
            if (this.profile == null) {
                str = str + " profile";
            }
            if (this.coordinates == null) {
                str = str + " coordinates";
            }
            if (this.geometries == null) {
                str = str + " geometries";
            }
            if (this.baseUrl == null) {
                str = str + " baseUrl";
            }
            if (!str.isEmpty()) {
                throw new IllegalStateException("Missing required properties:" + str);
            }
            return new AutoValue_MapboxMapMatching(this.usePostMethod, this.clientAppName, this.accessToken, this.tidy, this.user, this.profile, this.coordinates, this.geometries, this.radiuses, this.steps, this.overview, this.timestamps, this.annotations, this.language, this.roundaboutExits, this.bannerInstructions, this.voiceInstructions, this.voiceUnits, this.waypointIndices, this.waypointNames, this.ignore, this.approaches, this.baseUrl);
        }
    }
}