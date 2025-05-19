package com.mapbox.api.optimization.v1;

import com.google.gson.GsonBuilder;
import com.mapbox.api.directions.v5.DirectionsAdapterFactory;
import com.mapbox.api.directions.v5.DirectionsCriteria;
import com.mapbox.api.directions.v5.models.Bearing;
import com.mapbox.api.directions.v5.utils.FormatUtils;
import com.mapbox.api.optimization.v1.AutoValue_MapboxOptimization;
import com.mapbox.api.optimization.v1.models.OptimizationAdapterFactory;
import com.mapbox.api.optimization.v1.models.OptimizationResponse;
import com.mapbox.core.MapboxService;
import com.mapbox.core.exceptions.ServicesException;
import com.mapbox.core.utils.ApiCallHelper;
import com.mapbox.core.utils.MapboxUtils;
import com.mapbox.core.utils.TextUtils;
import com.mapbox.geojson.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import retrofit2.Call;

/* loaded from: classes3.dex */
public abstract class MapboxOptimization extends MapboxService<OptimizationResponse, OptimizationService> {
    abstract String accessToken();

    abstract String annotations();

    @Override // com.mapbox.core.MapboxService
    protected abstract String baseUrl();

    abstract String bearings();

    abstract String clientAppName();

    abstract String coordinates();

    abstract String destination();

    abstract String distributions();

    abstract String geometries();

    abstract String language();

    abstract String overview();

    abstract String profile();

    abstract String radiuses();

    abstract Boolean roundTrip();

    abstract String source();

    abstract Boolean steps();

    abstract String user();

    protected MapboxOptimization() {
        super(OptimizationService.class);
    }

    @Override // com.mapbox.core.MapboxService
    protected GsonBuilder getGsonBuilder() {
        return new GsonBuilder().registerTypeAdapterFactory(OptimizationAdapterFactory.create()).registerTypeAdapterFactory(DirectionsAdapterFactory.create());
    }

    @Override // com.mapbox.core.MapboxService
    protected Call<OptimizationResponse> initializeCall() {
        return getService().getCall(ApiCallHelper.getHeaderUserAgent(clientAppName()), user(), profile(), coordinates(), accessToken(), roundTrip(), radiuses(), bearings(), steps(), overview(), geometries(), annotations(), destination(), source(), language(), distributions());
    }

    public static Builder builder() {
        return new AutoValue_MapboxOptimization.Builder().baseUrl("https://api.mapbox.com").profile("driving").user("mapbox").geometries(DirectionsCriteria.GEOMETRY_POLYLINE6);
    }

    public static abstract class Builder {
        private String[] annotations;
        private double[] radiuses;
        private List<Integer[]> distributions = new ArrayList();
        private List<Bearing> bearings = new ArrayList();
        private List<Point> coordinates = new ArrayList();

        public abstract Builder accessToken(String str);

        abstract Builder annotations(String str);

        abstract MapboxOptimization autoBuild();

        public abstract Builder baseUrl(String str);

        abstract Builder bearings(String str);

        public abstract Builder clientAppName(String str);

        abstract Builder coordinates(String str);

        public abstract Builder destination(String str);

        abstract Builder distributions(String str);

        public abstract Builder geometries(String str);

        public abstract Builder language(String str);

        public abstract Builder overview(String str);

        public abstract Builder profile(String str);

        abstract Builder radiuses(String str);

        public abstract Builder roundTrip(Boolean bool);

        public abstract Builder source(String str);

        public abstract Builder steps(Boolean bool);

        public abstract Builder user(String str);

        public Builder coordinates(List<Point> list) {
            this.coordinates.addAll(list);
            return this;
        }

        public Builder coordinate(Point point) {
            this.coordinates.add(point);
            return this;
        }

        public Builder radiuses(double... dArr) {
            this.radiuses = dArr;
            return this;
        }

        public Builder bearing(double d, double d2) {
            this.bearings.add(Bearing.builder().angle(d).degrees(d2).build());
            return this;
        }

        public Builder annotations(String... strArr) {
            this.annotations = strArr;
            return this;
        }

        public Builder language(Locale locale) {
            if (locale != null) {
                language(locale.getLanguage());
            }
            return this;
        }

        public Builder distribution(Integer num, Integer num2) {
            this.distributions.add(new Integer[]{num, num2});
            return this;
        }

        public MapboxOptimization build() {
            List<Point> list = this.coordinates;
            if (list == null || list.size() < 2) {
                throw new ServicesException("At least two coordinates must be provided with your APIrequest.");
            }
            coordinates(formatCoordinates(this.coordinates));
            bearings(FormatUtils.formatBearings(this.bearings));
            annotations(TextUtils.join(",", this.annotations));
            radiuses(TextUtils.formatRadiuses(this.radiuses));
            distributions(FormatUtils.formatDistributions(this.distributions));
            MapboxOptimization autoBuild = autoBuild();
            if (MapboxUtils.isAccessTokenValid(autoBuild.accessToken())) {
                return autoBuild;
            }
            throw new ServicesException("Using Mapbox Services requires setting a valid access token.");
        }

        private static String formatCoordinates(List<Point> list) {
            ArrayList arrayList = new ArrayList();
            for (Point point : list) {
                arrayList.add(String.format(Locale.US, "%s,%s", FormatUtils.formatDouble(point.longitude()), FormatUtils.formatDouble(point.latitude())));
            }
            return TextUtils.join(";", arrayList.toArray());
        }
    }
}
