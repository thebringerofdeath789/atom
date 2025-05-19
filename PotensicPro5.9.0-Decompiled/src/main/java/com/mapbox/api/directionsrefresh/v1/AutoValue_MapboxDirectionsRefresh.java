package com.mapbox.api.directionsrefresh.v1;

import com.mapbox.api.directionsrefresh.v1.MapboxDirectionsRefresh;
import java.util.Objects;
import okhttp3.Interceptor;
import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes3.dex */
final class AutoValue_MapboxDirectionsRefresh extends MapboxDirectionsRefresh {
    private final String accessToken;
    private final String baseUrl;
    private final String clientAppName;
    private final Interceptor interceptor;
    private final int legIndex;
    private final String requestId;
    private final int routeIndex;

    private AutoValue_MapboxDirectionsRefresh(String str, int i, int i2, String str2, String str3, String str4, Interceptor interceptor) {
        this.requestId = str;
        this.routeIndex = i;
        this.legIndex = i2;
        this.accessToken = str2;
        this.clientAppName = str3;
        this.baseUrl = str4;
        this.interceptor = interceptor;
    }

    @Override // com.mapbox.api.directionsrefresh.v1.MapboxDirectionsRefresh
    String requestId() {
        return this.requestId;
    }

    @Override // com.mapbox.api.directionsrefresh.v1.MapboxDirectionsRefresh
    int routeIndex() {
        return this.routeIndex;
    }

    @Override // com.mapbox.api.directionsrefresh.v1.MapboxDirectionsRefresh
    int legIndex() {
        return this.legIndex;
    }

    @Override // com.mapbox.api.directionsrefresh.v1.MapboxDirectionsRefresh
    String accessToken() {
        return this.accessToken;
    }

    @Override // com.mapbox.api.directionsrefresh.v1.MapboxDirectionsRefresh
    String clientAppName() {
        return this.clientAppName;
    }

    @Override // com.mapbox.api.directionsrefresh.v1.MapboxDirectionsRefresh, com.mapbox.core.MapboxService
    protected String baseUrl() {
        return this.baseUrl;
    }

    @Override // com.mapbox.api.directionsrefresh.v1.MapboxDirectionsRefresh
    Interceptor interceptor() {
        return this.interceptor;
    }

    public String toString() {
        return "MapboxDirectionsRefresh{requestId=" + this.requestId + ", routeIndex=" + this.routeIndex + ", legIndex=" + this.legIndex + ", accessToken=" + this.accessToken + ", clientAppName=" + this.clientAppName + ", baseUrl=" + this.baseUrl + ", interceptor=" + this.interceptor + StringSubstitutor.DEFAULT_VAR_END;
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MapboxDirectionsRefresh)) {
            return false;
        }
        MapboxDirectionsRefresh mapboxDirectionsRefresh = (MapboxDirectionsRefresh) obj;
        if (this.requestId.equals(mapboxDirectionsRefresh.requestId()) && this.routeIndex == mapboxDirectionsRefresh.routeIndex() && this.legIndex == mapboxDirectionsRefresh.legIndex() && this.accessToken.equals(mapboxDirectionsRefresh.accessToken()) && ((str = this.clientAppName) != null ? str.equals(mapboxDirectionsRefresh.clientAppName()) : mapboxDirectionsRefresh.clientAppName() == null) && this.baseUrl.equals(mapboxDirectionsRefresh.baseUrl())) {
            Interceptor interceptor = this.interceptor;
            if (interceptor == null) {
                if (mapboxDirectionsRefresh.interceptor() == null) {
                    return true;
                }
            } else if (interceptor.equals(mapboxDirectionsRefresh.interceptor())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = (((((((this.requestId.hashCode() ^ 1000003) * 1000003) ^ this.routeIndex) * 1000003) ^ this.legIndex) * 1000003) ^ this.accessToken.hashCode()) * 1000003;
        String str = this.clientAppName;
        int hashCode2 = (((hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003) ^ this.baseUrl.hashCode()) * 1000003;
        Interceptor interceptor = this.interceptor;
        return hashCode2 ^ (interceptor != null ? interceptor.hashCode() : 0);
    }

    @Override // com.mapbox.api.directionsrefresh.v1.MapboxDirectionsRefresh
    public MapboxDirectionsRefresh.Builder toBuilder() {
        return new Builder(this);
    }

    static final class Builder extends MapboxDirectionsRefresh.Builder {
        private String accessToken;
        private String baseUrl;
        private String clientAppName;
        private Interceptor interceptor;
        private Integer legIndex;
        private String requestId;
        private Integer routeIndex;

        Builder() {
        }

        private Builder(MapboxDirectionsRefresh mapboxDirectionsRefresh) {
            this.requestId = mapboxDirectionsRefresh.requestId();
            this.routeIndex = Integer.valueOf(mapboxDirectionsRefresh.routeIndex());
            this.legIndex = Integer.valueOf(mapboxDirectionsRefresh.legIndex());
            this.accessToken = mapboxDirectionsRefresh.accessToken();
            this.clientAppName = mapboxDirectionsRefresh.clientAppName();
            this.baseUrl = mapboxDirectionsRefresh.baseUrl();
            this.interceptor = mapboxDirectionsRefresh.interceptor();
        }

        @Override // com.mapbox.api.directionsrefresh.v1.MapboxDirectionsRefresh.Builder
        public MapboxDirectionsRefresh.Builder requestId(String str) {
            Objects.requireNonNull(str, "Null requestId");
            this.requestId = str;
            return this;
        }

        @Override // com.mapbox.api.directionsrefresh.v1.MapboxDirectionsRefresh.Builder
        public MapboxDirectionsRefresh.Builder routeIndex(int i) {
            this.routeIndex = Integer.valueOf(i);
            return this;
        }

        @Override // com.mapbox.api.directionsrefresh.v1.MapboxDirectionsRefresh.Builder
        public MapboxDirectionsRefresh.Builder legIndex(int i) {
            this.legIndex = Integer.valueOf(i);
            return this;
        }

        @Override // com.mapbox.api.directionsrefresh.v1.MapboxDirectionsRefresh.Builder
        public MapboxDirectionsRefresh.Builder accessToken(String str) {
            Objects.requireNonNull(str, "Null accessToken");
            this.accessToken = str;
            return this;
        }

        @Override // com.mapbox.api.directionsrefresh.v1.MapboxDirectionsRefresh.Builder
        public MapboxDirectionsRefresh.Builder clientAppName(String str) {
            this.clientAppName = str;
            return this;
        }

        @Override // com.mapbox.api.directionsrefresh.v1.MapboxDirectionsRefresh.Builder
        public MapboxDirectionsRefresh.Builder baseUrl(String str) {
            Objects.requireNonNull(str, "Null baseUrl");
            this.baseUrl = str;
            return this;
        }

        @Override // com.mapbox.api.directionsrefresh.v1.MapboxDirectionsRefresh.Builder
        public MapboxDirectionsRefresh.Builder interceptor(Interceptor interceptor) {
            this.interceptor = interceptor;
            return this;
        }

        @Override // com.mapbox.api.directionsrefresh.v1.MapboxDirectionsRefresh.Builder
        public MapboxDirectionsRefresh build() {
            String str = this.requestId == null ? " requestId" : "";
            if (this.routeIndex == null) {
                str = str + " routeIndex";
            }
            if (this.legIndex == null) {
                str = str + " legIndex";
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
            return new AutoValue_MapboxDirectionsRefresh(this.requestId, this.routeIndex.intValue(), this.legIndex.intValue(), this.accessToken, this.clientAppName, this.baseUrl, this.interceptor);
        }
    }
}
