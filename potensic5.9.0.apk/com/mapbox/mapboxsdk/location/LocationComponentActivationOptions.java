package com.mapbox.mapboxsdk.location;

import android.content.Context;
import com.mapbox.android.core.location.LocationEngine;
import com.mapbox.android.core.location.LocationEngineRequest;
import com.mapbox.mapboxsdk.maps.Style;
import java.util.Objects;

/* loaded from: classes3.dex */
public class LocationComponentActivationOptions {
    private final Context context;
    private final LocationComponentOptions locationComponentOptions;
    private final LocationEngine locationEngine;
    private final LocationEngineRequest locationEngineRequest;
    private final Style style;
    private final int styleRes;
    private final boolean useDefaultLocationEngine;
    private final boolean useSpecializedLocationLayer;

    private LocationComponentActivationOptions(Context context, Style style, LocationEngine locationEngine, LocationEngineRequest locationEngineRequest, LocationComponentOptions locationComponentOptions, int i, boolean z, boolean z2) {
        this.context = context;
        this.style = style;
        this.locationEngine = locationEngine;
        this.locationEngineRequest = locationEngineRequest;
        this.locationComponentOptions = locationComponentOptions;
        this.styleRes = i;
        this.useDefaultLocationEngine = z;
        this.useSpecializedLocationLayer = z2;
    }

    public static Builder builder(Context context, Style style) {
        return new Builder(context, style);
    }

    public Context context() {
        return this.context;
    }

    public Style style() {
        return this.style;
    }

    public LocationEngine locationEngine() {
        return this.locationEngine;
    }

    public LocationEngineRequest locationEngineRequest() {
        return this.locationEngineRequest;
    }

    public LocationComponentOptions locationComponentOptions() {
        return this.locationComponentOptions;
    }

    public int styleRes() {
        return this.styleRes;
    }

    public boolean useDefaultLocationEngine() {
        return this.useDefaultLocationEngine;
    }

    public boolean useSpecializedLocationLayer() {
        return this.useSpecializedLocationLayer;
    }

    public static class Builder {
        private final Context context;
        private LocationComponentOptions locationComponentOptions;
        private LocationEngine locationEngine;
        private LocationEngineRequest locationEngineRequest;
        private final Style style;
        private int styleRes;
        private boolean useDefaultLocationEngine = true;
        private boolean useSpecializedLocationLayer = false;

        public Builder(Context context, Style style) {
            this.context = context;
            this.style = style;
        }

        public Builder locationEngine(LocationEngine locationEngine) {
            this.locationEngine = locationEngine;
            return this;
        }

        public Builder locationEngineRequest(LocationEngineRequest locationEngineRequest) {
            this.locationEngineRequest = locationEngineRequest;
            return this;
        }

        public Builder locationComponentOptions(LocationComponentOptions locationComponentOptions) {
            this.locationComponentOptions = locationComponentOptions;
            return this;
        }

        public Builder styleRes(int i) {
            this.styleRes = i;
            return this;
        }

        public Builder useDefaultLocationEngine(boolean z) {
            this.useDefaultLocationEngine = z;
            return this;
        }

        public Builder useSpecializedLocationLayer(boolean z) {
            this.useSpecializedLocationLayer = z;
            return this;
        }

        public LocationComponentActivationOptions build() {
            if (this.styleRes != 0 && this.locationComponentOptions != null) {
                throw new IllegalArgumentException("You've provided both a style resource and a LocationComponentOptions object to the LocationComponentActivationOptions builder. You can't use both and you must choose one of the two to style the LocationComponent.");
            }
            Objects.requireNonNull(this.context, "Context in LocationComponentActivationOptions is null.");
            Style style = this.style;
            Objects.requireNonNull(style, "Style in LocationComponentActivationOptions is null. Make sure the Style object isn't null. Wait for the map to fully load before passing the Style object to LocationComponentActivationOptions.");
            if (!style.isFullyLoaded()) {
                throw new IllegalArgumentException("Style in LocationComponentActivationOptions isn't fully loaded. Wait for the map to fully load before passing the Style object to LocationComponentActivationOptions.");
            }
            return new LocationComponentActivationOptions(this.context, this.style, this.locationEngine, this.locationEngineRequest, this.locationComponentOptions, this.styleRes, this.useDefaultLocationEngine, this.useSpecializedLocationLayer);
        }
    }
}