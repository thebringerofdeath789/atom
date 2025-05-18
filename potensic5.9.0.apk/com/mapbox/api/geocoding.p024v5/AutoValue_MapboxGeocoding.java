package com.mapbox.api.geocoding.p024v5;

import com.mapbox.api.geocoding.p024v5.MapboxGeocoding;
import java.util.Objects;
import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes3.dex */
final class AutoValue_MapboxGeocoding extends MapboxGeocoding {
    private final String accessToken;
    private final Boolean autocomplete;
    private final String baseUrl;
    private final String bbox;
    private final String clientAppName;
    private final String country;
    private final Boolean fuzzyMatch;
    private final String geocodingTypes;
    private final String languages;
    private final String limit;
    private final String mode;
    private final String proximity;
    private final String query;
    private final String reverseMode;

    private AutoValue_MapboxGeocoding(String str, String str2, String str3, String str4, String str5, String str6, String str7, Boolean bool, String str8, String str9, String str10, String str11, Boolean bool2, String str12) {
        this.query = str;
        this.mode = str2;
        this.accessToken = str3;
        this.baseUrl = str4;
        this.country = str5;
        this.proximity = str6;
        this.geocodingTypes = str7;
        this.autocomplete = bool;
        this.bbox = str8;
        this.limit = str9;
        this.languages = str10;
        this.reverseMode = str11;
        this.fuzzyMatch = bool2;
        this.clientAppName = str12;
    }

    @Override // com.mapbox.api.geocoding.p024v5.MapboxGeocoding
    String query() {
        return this.query;
    }

    @Override // com.mapbox.api.geocoding.p024v5.MapboxGeocoding
    String mode() {
        return this.mode;
    }

    @Override // com.mapbox.api.geocoding.p024v5.MapboxGeocoding
    String accessToken() {
        return this.accessToken;
    }

    @Override // com.mapbox.api.geocoding.p024v5.MapboxGeocoding, com.mapbox.core.MapboxService
    protected String baseUrl() {
        return this.baseUrl;
    }

    @Override // com.mapbox.api.geocoding.p024v5.MapboxGeocoding
    String country() {
        return this.country;
    }

    @Override // com.mapbox.api.geocoding.p024v5.MapboxGeocoding
    String proximity() {
        return this.proximity;
    }

    @Override // com.mapbox.api.geocoding.p024v5.MapboxGeocoding
    String geocodingTypes() {
        return this.geocodingTypes;
    }

    @Override // com.mapbox.api.geocoding.p024v5.MapboxGeocoding
    Boolean autocomplete() {
        return this.autocomplete;
    }

    @Override // com.mapbox.api.geocoding.p024v5.MapboxGeocoding
    String bbox() {
        return this.bbox;
    }

    @Override // com.mapbox.api.geocoding.p024v5.MapboxGeocoding
    String limit() {
        return this.limit;
    }

    @Override // com.mapbox.api.geocoding.p024v5.MapboxGeocoding
    String languages() {
        return this.languages;
    }

    @Override // com.mapbox.api.geocoding.p024v5.MapboxGeocoding
    String reverseMode() {
        return this.reverseMode;
    }

    @Override // com.mapbox.api.geocoding.p024v5.MapboxGeocoding
    Boolean fuzzyMatch() {
        return this.fuzzyMatch;
    }

    @Override // com.mapbox.api.geocoding.p024v5.MapboxGeocoding
    String clientAppName() {
        return this.clientAppName;
    }

    public String toString() {
        return "MapboxGeocoding{query=" + this.query + ", mode=" + this.mode + ", accessToken=" + this.accessToken + ", baseUrl=" + this.baseUrl + ", country=" + this.country + ", proximity=" + this.proximity + ", geocodingTypes=" + this.geocodingTypes + ", autocomplete=" + this.autocomplete + ", bbox=" + this.bbox + ", limit=" + this.limit + ", languages=" + this.languages + ", reverseMode=" + this.reverseMode + ", fuzzyMatch=" + this.fuzzyMatch + ", clientAppName=" + this.clientAppName + StringSubstitutor.DEFAULT_VAR_END;
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        Boolean bool;
        String str4;
        String str5;
        String str6;
        String str7;
        Boolean bool2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MapboxGeocoding)) {
            return false;
        }
        MapboxGeocoding mapboxGeocoding = (MapboxGeocoding) obj;
        if (this.query.equals(mapboxGeocoding.query()) && this.mode.equals(mapboxGeocoding.mode()) && this.accessToken.equals(mapboxGeocoding.accessToken()) && this.baseUrl.equals(mapboxGeocoding.baseUrl()) && ((str = this.country) != null ? str.equals(mapboxGeocoding.country()) : mapboxGeocoding.country() == null) && ((str2 = this.proximity) != null ? str2.equals(mapboxGeocoding.proximity()) : mapboxGeocoding.proximity() == null) && ((str3 = this.geocodingTypes) != null ? str3.equals(mapboxGeocoding.geocodingTypes()) : mapboxGeocoding.geocodingTypes() == null) && ((bool = this.autocomplete) != null ? bool.equals(mapboxGeocoding.autocomplete()) : mapboxGeocoding.autocomplete() == null) && ((str4 = this.bbox) != null ? str4.equals(mapboxGeocoding.bbox()) : mapboxGeocoding.bbox() == null) && ((str5 = this.limit) != null ? str5.equals(mapboxGeocoding.limit()) : mapboxGeocoding.limit() == null) && ((str6 = this.languages) != null ? str6.equals(mapboxGeocoding.languages()) : mapboxGeocoding.languages() == null) && ((str7 = this.reverseMode) != null ? str7.equals(mapboxGeocoding.reverseMode()) : mapboxGeocoding.reverseMode() == null) && ((bool2 = this.fuzzyMatch) != null ? bool2.equals(mapboxGeocoding.fuzzyMatch()) : mapboxGeocoding.fuzzyMatch() == null)) {
            String str8 = this.clientAppName;
            if (str8 == null) {
                if (mapboxGeocoding.clientAppName() == null) {
                    return true;
                }
            } else if (str8.equals(mapboxGeocoding.clientAppName())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = (((((((this.query.hashCode() ^ 1000003) * 1000003) ^ this.mode.hashCode()) * 1000003) ^ this.accessToken.hashCode()) * 1000003) ^ this.baseUrl.hashCode()) * 1000003;
        String str = this.country;
        int hashCode2 = (hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.proximity;
        int hashCode3 = (hashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.geocodingTypes;
        int hashCode4 = (hashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        Boolean bool = this.autocomplete;
        int hashCode5 = (hashCode4 ^ (bool == null ? 0 : bool.hashCode())) * 1000003;
        String str4 = this.bbox;
        int hashCode6 = (hashCode5 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.limit;
        int hashCode7 = (hashCode6 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        String str6 = this.languages;
        int hashCode8 = (hashCode7 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        String str7 = this.reverseMode;
        int hashCode9 = (hashCode8 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003;
        Boolean bool2 = this.fuzzyMatch;
        int hashCode10 = (hashCode9 ^ (bool2 == null ? 0 : bool2.hashCode())) * 1000003;
        String str8 = this.clientAppName;
        return hashCode10 ^ (str8 != null ? str8.hashCode() : 0);
    }

    static final class Builder extends MapboxGeocoding.Builder {
        private String accessToken;
        private Boolean autocomplete;
        private String baseUrl;
        private String bbox;
        private String clientAppName;
        private String country;
        private Boolean fuzzyMatch;
        private String geocodingTypes;
        private String languages;
        private String limit;
        private String mode;
        private String proximity;
        private String query;
        private String reverseMode;

        Builder() {
        }

        @Override // com.mapbox.api.geocoding.v5.MapboxGeocoding.Builder
        public MapboxGeocoding.Builder query(String str) {
            Objects.requireNonNull(str, "Null query");
            this.query = str;
            return this;
        }

        @Override // com.mapbox.api.geocoding.v5.MapboxGeocoding.Builder
        public MapboxGeocoding.Builder mode(String str) {
            Objects.requireNonNull(str, "Null mode");
            this.mode = str;
            return this;
        }

        @Override // com.mapbox.api.geocoding.v5.MapboxGeocoding.Builder
        public MapboxGeocoding.Builder accessToken(String str) {
            Objects.requireNonNull(str, "Null accessToken");
            this.accessToken = str;
            return this;
        }

        @Override // com.mapbox.api.geocoding.v5.MapboxGeocoding.Builder
        public MapboxGeocoding.Builder baseUrl(String str) {
            Objects.requireNonNull(str, "Null baseUrl");
            this.baseUrl = str;
            return this;
        }

        @Override // com.mapbox.api.geocoding.v5.MapboxGeocoding.Builder
        public MapboxGeocoding.Builder country(String str) {
            this.country = str;
            return this;
        }

        @Override // com.mapbox.api.geocoding.v5.MapboxGeocoding.Builder
        MapboxGeocoding.Builder proximity(String str) {
            this.proximity = str;
            return this;
        }

        @Override // com.mapbox.api.geocoding.v5.MapboxGeocoding.Builder
        MapboxGeocoding.Builder geocodingTypes(String str) {
            this.geocodingTypes = str;
            return this;
        }

        @Override // com.mapbox.api.geocoding.v5.MapboxGeocoding.Builder
        public MapboxGeocoding.Builder autocomplete(Boolean bool) {
            this.autocomplete = bool;
            return this;
        }

        @Override // com.mapbox.api.geocoding.v5.MapboxGeocoding.Builder
        public MapboxGeocoding.Builder bbox(String str) {
            this.bbox = str;
            return this;
        }

        @Override // com.mapbox.api.geocoding.v5.MapboxGeocoding.Builder
        MapboxGeocoding.Builder limit(String str) {
            this.limit = str;
            return this;
        }

        @Override // com.mapbox.api.geocoding.v5.MapboxGeocoding.Builder
        public MapboxGeocoding.Builder languages(String str) {
            this.languages = str;
            return this;
        }

        @Override // com.mapbox.api.geocoding.v5.MapboxGeocoding.Builder
        public MapboxGeocoding.Builder reverseMode(String str) {
            this.reverseMode = str;
            return this;
        }

        @Override // com.mapbox.api.geocoding.v5.MapboxGeocoding.Builder
        public MapboxGeocoding.Builder fuzzyMatch(Boolean bool) {
            this.fuzzyMatch = bool;
            return this;
        }

        @Override // com.mapbox.api.geocoding.v5.MapboxGeocoding.Builder
        public MapboxGeocoding.Builder clientAppName(String str) {
            this.clientAppName = str;
            return this;
        }

        @Override // com.mapbox.api.geocoding.v5.MapboxGeocoding.Builder
        MapboxGeocoding autoBuild() {
            String str = this.query == null ? " query" : "";
            if (this.mode == null) {
                str = str + " mode";
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
            return new AutoValue_MapboxGeocoding(this.query, this.mode, this.accessToken, this.baseUrl, this.country, this.proximity, this.geocodingTypes, this.autocomplete, this.bbox, this.limit, this.languages, this.reverseMode, this.fuzzyMatch, this.clientAppName);
        }
    }
}