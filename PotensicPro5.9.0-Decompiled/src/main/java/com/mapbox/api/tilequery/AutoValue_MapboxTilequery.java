package com.mapbox.api.tilequery;

import com.mapbox.api.tilequery.MapboxTilequery;
import java.util.Objects;
import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes3.dex */
final class AutoValue_MapboxTilequery extends MapboxTilequery {
    private final String accessToken;
    private final String baseUrl;
    private final Boolean dedupe;
    private final String geometry;
    private final String layers;
    private final Integer limit;
    private final String query;
    private final Integer radius;
    private final String tilesetIds;

    private AutoValue_MapboxTilequery(String str, String str2, String str3, String str4, Integer num, Integer num2, Boolean bool, String str5, String str6) {
        this.baseUrl = str;
        this.accessToken = str2;
        this.tilesetIds = str3;
        this.query = str4;
        this.radius = num;
        this.limit = num2;
        this.dedupe = bool;
        this.geometry = str5;
        this.layers = str6;
    }

    @Override // com.mapbox.api.tilequery.MapboxTilequery, com.mapbox.core.MapboxService
    protected String baseUrl() {
        return this.baseUrl;
    }

    @Override // com.mapbox.api.tilequery.MapboxTilequery
    String accessToken() {
        return this.accessToken;
    }

    @Override // com.mapbox.api.tilequery.MapboxTilequery
    String tilesetIds() {
        return this.tilesetIds;
    }

    @Override // com.mapbox.api.tilequery.MapboxTilequery
    String query() {
        return this.query;
    }

    @Override // com.mapbox.api.tilequery.MapboxTilequery
    Integer radius() {
        return this.radius;
    }

    @Override // com.mapbox.api.tilequery.MapboxTilequery
    Integer limit() {
        return this.limit;
    }

    @Override // com.mapbox.api.tilequery.MapboxTilequery
    Boolean dedupe() {
        return this.dedupe;
    }

    @Override // com.mapbox.api.tilequery.MapboxTilequery
    String geometry() {
        return this.geometry;
    }

    @Override // com.mapbox.api.tilequery.MapboxTilequery
    String layers() {
        return this.layers;
    }

    public String toString() {
        return "MapboxTilequery{baseUrl=" + this.baseUrl + ", accessToken=" + this.accessToken + ", tilesetIds=" + this.tilesetIds + ", query=" + this.query + ", radius=" + this.radius + ", limit=" + this.limit + ", dedupe=" + this.dedupe + ", geometry=" + this.geometry + ", layers=" + this.layers + StringSubstitutor.DEFAULT_VAR_END;
    }

    public boolean equals(Object obj) {
        Integer num;
        Integer num2;
        Boolean bool;
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MapboxTilequery)) {
            return false;
        }
        MapboxTilequery mapboxTilequery = (MapboxTilequery) obj;
        if (this.baseUrl.equals(mapboxTilequery.baseUrl()) && this.accessToken.equals(mapboxTilequery.accessToken()) && this.tilesetIds.equals(mapboxTilequery.tilesetIds()) && this.query.equals(mapboxTilequery.query()) && ((num = this.radius) != null ? num.equals(mapboxTilequery.radius()) : mapboxTilequery.radius() == null) && ((num2 = this.limit) != null ? num2.equals(mapboxTilequery.limit()) : mapboxTilequery.limit() == null) && ((bool = this.dedupe) != null ? bool.equals(mapboxTilequery.dedupe()) : mapboxTilequery.dedupe() == null) && ((str = this.geometry) != null ? str.equals(mapboxTilequery.geometry()) : mapboxTilequery.geometry() == null)) {
            String str2 = this.layers;
            if (str2 == null) {
                if (mapboxTilequery.layers() == null) {
                    return true;
                }
            } else if (str2.equals(mapboxTilequery.layers())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = (((((((this.baseUrl.hashCode() ^ 1000003) * 1000003) ^ this.accessToken.hashCode()) * 1000003) ^ this.tilesetIds.hashCode()) * 1000003) ^ this.query.hashCode()) * 1000003;
        Integer num = this.radius;
        int hashCode2 = (hashCode ^ (num == null ? 0 : num.hashCode())) * 1000003;
        Integer num2 = this.limit;
        int hashCode3 = (hashCode2 ^ (num2 == null ? 0 : num2.hashCode())) * 1000003;
        Boolean bool = this.dedupe;
        int hashCode4 = (hashCode3 ^ (bool == null ? 0 : bool.hashCode())) * 1000003;
        String str = this.geometry;
        int hashCode5 = (hashCode4 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.layers;
        return hashCode5 ^ (str2 != null ? str2.hashCode() : 0);
    }

    static final class Builder extends MapboxTilequery.Builder {
        private String accessToken;
        private String baseUrl;
        private Boolean dedupe;
        private String geometry;
        private String layers;
        private Integer limit;
        private String query;
        private Integer radius;
        private String tilesetIds;

        Builder() {
        }

        @Override // com.mapbox.api.tilequery.MapboxTilequery.Builder
        public MapboxTilequery.Builder baseUrl(String str) {
            Objects.requireNonNull(str, "Null baseUrl");
            this.baseUrl = str;
            return this;
        }

        @Override // com.mapbox.api.tilequery.MapboxTilequery.Builder
        public MapboxTilequery.Builder accessToken(String str) {
            Objects.requireNonNull(str, "Null accessToken");
            this.accessToken = str;
            return this;
        }

        @Override // com.mapbox.api.tilequery.MapboxTilequery.Builder
        public MapboxTilequery.Builder tilesetIds(String str) {
            Objects.requireNonNull(str, "Null tilesetIds");
            this.tilesetIds = str;
            return this;
        }

        @Override // com.mapbox.api.tilequery.MapboxTilequery.Builder
        public MapboxTilequery.Builder query(String str) {
            Objects.requireNonNull(str, "Null query");
            this.query = str;
            return this;
        }

        @Override // com.mapbox.api.tilequery.MapboxTilequery.Builder
        public MapboxTilequery.Builder radius(Integer num) {
            this.radius = num;
            return this;
        }

        @Override // com.mapbox.api.tilequery.MapboxTilequery.Builder
        public MapboxTilequery.Builder limit(Integer num) {
            this.limit = num;
            return this;
        }

        @Override // com.mapbox.api.tilequery.MapboxTilequery.Builder
        public MapboxTilequery.Builder dedupe(Boolean bool) {
            this.dedupe = bool;
            return this;
        }

        @Override // com.mapbox.api.tilequery.MapboxTilequery.Builder
        public MapboxTilequery.Builder geometry(String str) {
            this.geometry = str;
            return this;
        }

        @Override // com.mapbox.api.tilequery.MapboxTilequery.Builder
        public MapboxTilequery.Builder layers(String str) {
            this.layers = str;
            return this;
        }

        @Override // com.mapbox.api.tilequery.MapboxTilequery.Builder
        MapboxTilequery autoBuild() {
            String str = this.baseUrl == null ? " baseUrl" : "";
            if (this.accessToken == null) {
                str = str + " accessToken";
            }
            if (this.tilesetIds == null) {
                str = str + " tilesetIds";
            }
            if (this.query == null) {
                str = str + " query";
            }
            if (!str.isEmpty()) {
                throw new IllegalStateException("Missing required properties:" + str);
            }
            return new AutoValue_MapboxTilequery(this.baseUrl, this.accessToken, this.tilesetIds, this.query, this.radius, this.limit, this.dedupe, this.geometry, this.layers);
        }
    }
}
