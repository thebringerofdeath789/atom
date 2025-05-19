package com.mapbox.api.directions.v5;

import com.mapbox.api.directions.v5.MapboxDirections;
import com.mapbox.api.directions.v5.models.RouteOptions;
import java.util.Objects;
import okhttp3.EventListener;
import okhttp3.Interceptor;
import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes3.dex */
final class AutoValue_MapboxDirections extends MapboxDirections {
    private final String accessToken;
    private final String clientAppName;
    private final EventListener eventListener;
    private final Interceptor interceptor;
    private final Interceptor networkInterceptor;
    private final RouteOptions routeOptions;
    private final Boolean usePostMethod;

    private AutoValue_MapboxDirections(String str, RouteOptions routeOptions, String str2, Interceptor interceptor, Interceptor interceptor2, EventListener eventListener, Boolean bool) {
        this.accessToken = str;
        this.routeOptions = routeOptions;
        this.clientAppName = str2;
        this.interceptor = interceptor;
        this.networkInterceptor = interceptor2;
        this.eventListener = eventListener;
        this.usePostMethod = bool;
    }

    @Override // com.mapbox.api.directions.v5.MapboxDirections
    String accessToken() {
        return this.accessToken;
    }

    @Override // com.mapbox.api.directions.v5.MapboxDirections
    RouteOptions routeOptions() {
        return this.routeOptions;
    }

    @Override // com.mapbox.api.directions.v5.MapboxDirections
    String clientAppName() {
        return this.clientAppName;
    }

    @Override // com.mapbox.api.directions.v5.MapboxDirections
    Interceptor interceptor() {
        return this.interceptor;
    }

    @Override // com.mapbox.api.directions.v5.MapboxDirections
    Interceptor networkInterceptor() {
        return this.networkInterceptor;
    }

    @Override // com.mapbox.api.directions.v5.MapboxDirections
    EventListener eventListener() {
        return this.eventListener;
    }

    @Override // com.mapbox.api.directions.v5.MapboxDirections
    Boolean usePostMethod() {
        return this.usePostMethod;
    }

    public String toString() {
        return "MapboxDirections{accessToken=" + this.accessToken + ", routeOptions=" + this.routeOptions + ", clientAppName=" + this.clientAppName + ", interceptor=" + this.interceptor + ", networkInterceptor=" + this.networkInterceptor + ", eventListener=" + this.eventListener + ", usePostMethod=" + this.usePostMethod + StringSubstitutor.DEFAULT_VAR_END;
    }

    public boolean equals(Object obj) {
        String str;
        Interceptor interceptor;
        Interceptor interceptor2;
        EventListener eventListener;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MapboxDirections)) {
            return false;
        }
        MapboxDirections mapboxDirections = (MapboxDirections) obj;
        if (this.accessToken.equals(mapboxDirections.accessToken()) && this.routeOptions.equals(mapboxDirections.routeOptions()) && ((str = this.clientAppName) != null ? str.equals(mapboxDirections.clientAppName()) : mapboxDirections.clientAppName() == null) && ((interceptor = this.interceptor) != null ? interceptor.equals(mapboxDirections.interceptor()) : mapboxDirections.interceptor() == null) && ((interceptor2 = this.networkInterceptor) != null ? interceptor2.equals(mapboxDirections.networkInterceptor()) : mapboxDirections.networkInterceptor() == null) && ((eventListener = this.eventListener) != null ? eventListener.equals(mapboxDirections.eventListener()) : mapboxDirections.eventListener() == null)) {
            Boolean bool = this.usePostMethod;
            if (bool == null) {
                if (mapboxDirections.usePostMethod() == null) {
                    return true;
                }
            } else if (bool.equals(mapboxDirections.usePostMethod())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = (((this.accessToken.hashCode() ^ 1000003) * 1000003) ^ this.routeOptions.hashCode()) * 1000003;
        String str = this.clientAppName;
        int hashCode2 = (hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        Interceptor interceptor = this.interceptor;
        int hashCode3 = (hashCode2 ^ (interceptor == null ? 0 : interceptor.hashCode())) * 1000003;
        Interceptor interceptor2 = this.networkInterceptor;
        int hashCode4 = (hashCode3 ^ (interceptor2 == null ? 0 : interceptor2.hashCode())) * 1000003;
        EventListener eventListener = this.eventListener;
        int hashCode5 = (hashCode4 ^ (eventListener == null ? 0 : eventListener.hashCode())) * 1000003;
        Boolean bool = this.usePostMethod;
        return hashCode5 ^ (bool != null ? bool.hashCode() : 0);
    }

    @Override // com.mapbox.api.directions.v5.MapboxDirections
    public MapboxDirections.Builder toBuilder() {
        return new Builder(this);
    }

    static final class Builder extends MapboxDirections.Builder {
        private String accessToken;
        private String clientAppName;
        private EventListener eventListener;
        private Interceptor interceptor;
        private Interceptor networkInterceptor;
        private RouteOptions routeOptions;
        private Boolean usePostMethod;

        Builder() {
        }

        private Builder(MapboxDirections mapboxDirections) {
            this.accessToken = mapboxDirections.accessToken();
            this.routeOptions = mapboxDirections.routeOptions();
            this.clientAppName = mapboxDirections.clientAppName();
            this.interceptor = mapboxDirections.interceptor();
            this.networkInterceptor = mapboxDirections.networkInterceptor();
            this.eventListener = mapboxDirections.eventListener();
            this.usePostMethod = mapboxDirections.usePostMethod();
        }

        @Override // com.mapbox.api.directions.v5.MapboxDirections.Builder
        public MapboxDirections.Builder accessToken(String str) {
            Objects.requireNonNull(str, "Null accessToken");
            this.accessToken = str;
            return this;
        }

        @Override // com.mapbox.api.directions.v5.MapboxDirections.Builder
        public MapboxDirections.Builder routeOptions(RouteOptions routeOptions) {
            Objects.requireNonNull(routeOptions, "Null routeOptions");
            this.routeOptions = routeOptions;
            return this;
        }

        @Override // com.mapbox.api.directions.v5.MapboxDirections.Builder
        public MapboxDirections.Builder clientAppName(String str) {
            this.clientAppName = str;
            return this;
        }

        @Override // com.mapbox.api.directions.v5.MapboxDirections.Builder
        public MapboxDirections.Builder interceptor(Interceptor interceptor) {
            this.interceptor = interceptor;
            return this;
        }

        @Override // com.mapbox.api.directions.v5.MapboxDirections.Builder
        public MapboxDirections.Builder networkInterceptor(Interceptor interceptor) {
            this.networkInterceptor = interceptor;
            return this;
        }

        @Override // com.mapbox.api.directions.v5.MapboxDirections.Builder
        public MapboxDirections.Builder eventListener(EventListener eventListener) {
            this.eventListener = eventListener;
            return this;
        }

        @Override // com.mapbox.api.directions.v5.MapboxDirections.Builder
        public MapboxDirections.Builder usePostMethod(Boolean bool) {
            this.usePostMethod = bool;
            return this;
        }

        @Override // com.mapbox.api.directions.v5.MapboxDirections.Builder
        public MapboxDirections build() {
            String str = this.accessToken == null ? " accessToken" : "";
            if (this.routeOptions == null) {
                str = str + " routeOptions";
            }
            if (!str.isEmpty()) {
                throw new IllegalStateException("Missing required properties:" + str);
            }
            return new AutoValue_MapboxDirections(this.accessToken, this.routeOptions, this.clientAppName, this.interceptor, this.networkInterceptor, this.eventListener, this.usePostMethod);
        }
    }
}
