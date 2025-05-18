package com.mapbox.api.isochrone;

import com.google.gson.GsonBuilder;
import com.mapbox.api.isochrone.AutoValue_MapboxIsochrone;
import com.mapbox.core.MapboxService;
import com.mapbox.core.exceptions.ServicesException;
import com.mapbox.core.utils.MapboxUtils;
import com.mapbox.core.utils.TextUtils;
import com.mapbox.geojson.FeatureCollection;
import com.mapbox.geojson.GeometryAdapterFactory;
import com.mapbox.geojson.Point;
import com.mapbox.geojson.gson.GeoJsonAdapterFactory;
import java.util.Locale;
import retrofit2.Call;

/* loaded from: classes3.dex */
public abstract class MapboxIsochrone extends MapboxService<FeatureCollection, IsochroneService> {
    abstract String accessToken();

    @Override // com.mapbox.core.MapboxService
    protected abstract String baseUrl();

    abstract String contoursColors();

    abstract String contoursMinutes();

    abstract String coordinates();

    abstract Float denoise();

    abstract Float generalize();

    abstract Boolean polygons();

    abstract String profile();

    abstract String user();

    protected MapboxIsochrone() {
        super(IsochroneService.class);
    }

    @Override // com.mapbox.core.MapboxService
    protected GsonBuilder getGsonBuilder() {
        return new GsonBuilder().registerTypeAdapterFactory(GeoJsonAdapterFactory.create()).registerTypeAdapterFactory(GeometryAdapterFactory.create());
    }

    @Override // com.mapbox.core.MapboxService
    protected Call<FeatureCollection> initializeCall() {
        return getService().getCall(user(), profile(), coordinates(), contoursMinutes(), accessToken(), contoursColors(), polygons(), denoise(), generalize());
    }

    public static Builder builder() {
        return new AutoValue_MapboxIsochrone.Builder().baseUrl("https://api.mapbox.com").user("mapbox");
    }

    public static abstract class Builder {
        private String[] contoursColors;
        private Integer[] contoursMinutes;

        public abstract Builder accessToken(String str);

        abstract MapboxIsochrone autoBuild();

        public abstract Builder baseUrl(String str);

        abstract Builder contoursColors(String str);

        abstract Builder contoursMinutes(String str);

        public abstract Builder coordinates(String str);

        public abstract Builder denoise(Float f);

        public abstract Builder generalize(Float f);

        public abstract Builder polygons(Boolean bool);

        public abstract Builder profile(String str);

        public abstract Builder user(String str);

        public Builder coordinates(Point point) {
            coordinates(String.format(Locale.US, "%s,%s", TextUtils.formatCoordinate(point.longitude()), TextUtils.formatCoordinate(point.latitude())));
            return this;
        }

        public Builder addContoursMinutes(Integer... numArr) {
            this.contoursMinutes = numArr;
            return this;
        }

        public Builder addContoursColors(String... strArr) {
            this.contoursColors = strArr;
            return this;
        }

        public MapboxIsochrone build() {
            Integer[] numArr;
            int intValue;
            Integer[] numArr2 = this.contoursMinutes;
            if (numArr2 != null) {
                if (numArr2.length < 1) {
                    throw new ServicesException("A query with at least one specified minute amount is required.");
                }
                if (numArr2.length >= 2) {
                    int i = 0;
                    do {
                        Integer[] numArr3 = this.contoursMinutes;
                        if (i < numArr3.length - 1) {
                            intValue = numArr3[i].intValue();
                            i++;
                        }
                    } while (intValue <= this.contoursMinutes[i].intValue());
                    throw new ServicesException("The minutes must be listed in order from the lowest number to the highest number.");
                }
                contoursMinutes(TextUtils.join(",", this.contoursMinutes));
            }
            String[] strArr = this.contoursColors;
            if (strArr != null) {
                contoursColors(TextUtils.join(",", strArr));
            }
            String[] strArr2 = this.contoursColors;
            if (strArr2 != null && (numArr = this.contoursMinutes) != null && strArr2.length != numArr.length) {
                throw new ServicesException("Number of color elements must match number of minute elements provided.");
            }
            MapboxIsochrone autoBuild = autoBuild();
            if (!MapboxUtils.isAccessTokenValid(autoBuild.accessToken())) {
                throw new ServicesException("Using the Mapbox Isochrone API requires setting a valid access token.");
            }
            if (TextUtils.isEmpty(autoBuild.coordinates())) {
                throw new ServicesException("A query with longitude and latitude values is required.");
            }
            if (TextUtils.isEmpty(autoBuild.profile())) {
                throw new ServicesException("A query with a set Directions profile (cycling, walking, or driving) is required.");
            }
            if (TextUtils.isEmpty(autoBuild.contoursMinutes())) {
                throw new ServicesException("A query with at least one specified minute amount is required.");
            }
            if (autoBuild.contoursColors() == null || !autoBuild.contoursColors().contains("#")) {
                return autoBuild;
            }
            throw new ServicesException("Make sure that none of the contour color HEX values have a # in front of it. Provide a list of the HEX values without any # symbols.");
        }
    }
}