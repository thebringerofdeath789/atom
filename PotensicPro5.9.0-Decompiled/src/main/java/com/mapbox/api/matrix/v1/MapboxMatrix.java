package com.mapbox.api.matrix.v1;

import com.google.gson.GsonBuilder;
import com.mapbox.api.directions.v5.DirectionsAdapterFactory;
import com.mapbox.api.directions.v5.utils.FormatUtils;
import com.mapbox.api.matrix.v1.AutoValue_MapboxMatrix;
import com.mapbox.api.matrix.v1.models.MatrixResponse;
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
public abstract class MapboxMatrix extends MapboxService<MatrixResponse, MatrixService> {
    abstract String accessToken();

    abstract String annotations();

    abstract String approaches();

    @Override // com.mapbox.core.MapboxService
    protected abstract String baseUrl();

    abstract String clientAppName();

    abstract String coordinates();

    abstract String destinations();

    abstract String profile();

    abstract String sources();

    abstract String user();

    protected MapboxMatrix() {
        super(MatrixService.class);
    }

    @Override // com.mapbox.core.MapboxService
    protected GsonBuilder getGsonBuilder() {
        return new GsonBuilder().registerTypeAdapterFactory(MatrixAdapterFactory.create()).registerTypeAdapterFactory(DirectionsAdapterFactory.create());
    }

    @Override // com.mapbox.core.MapboxService
    protected Call<MatrixResponse> initializeCall() {
        return getService().getCall(ApiCallHelper.getHeaderUserAgent(clientAppName()), user(), profile(), coordinates(), accessToken(), annotations(), approaches(), destinations(), sources());
    }

    public static Builder builder() {
        return new AutoValue_MapboxMatrix.Builder().baseUrl("https://api.mapbox.com").profile("driving").user("mapbox");
    }

    public static abstract class Builder {
        private String[] annotations;
        private String[] approaches;
        private Integer coordinateListSizeLimit;
        private List<Point> coordinates = new ArrayList();
        private Integer[] destinations;
        private Integer[] sources;

        public abstract Builder accessToken(String str);

        abstract Builder annotations(String str);

        abstract Builder approaches(String str);

        abstract MapboxMatrix autoBuild();

        public abstract Builder baseUrl(String str);

        public abstract Builder clientAppName(String str);

        abstract Builder coordinates(String str);

        abstract Builder destinations(String str);

        public abstract Builder profile(String str);

        abstract Builder sources(String str);

        public abstract Builder user(String str);

        public Builder coordinates(List<Point> list) {
            this.coordinates.addAll(list);
            return this;
        }

        public Builder coordinate(Point point) {
            this.coordinates.add(point);
            return this;
        }

        public Builder addAnnotations(String... strArr) {
            this.annotations = strArr;
            return this;
        }

        public Builder addApproaches(String... strArr) {
            this.approaches = strArr;
            return this;
        }

        public Builder destinations(Integer... numArr) {
            this.destinations = numArr;
            return this;
        }

        public Builder sources(Integer... numArr) {
            this.sources = numArr;
            return this;
        }

        public Builder coordinateListSizeLimit(Integer num) {
            this.coordinateListSizeLimit = num;
            return this;
        }

        public MapboxMatrix build() {
            List<Point> list = this.coordinates;
            if (list == null || list.size() < 2) {
                throw new ServicesException("At least two coordinates must be provided with your API request.");
            }
            Integer num = this.coordinateListSizeLimit;
            if (num != null && num.intValue() < 0) {
                throw new ServicesException("If you're going to use the coordinateListSizeLimit() method, please pass through a number that's greater than zero.");
            }
            if (this.coordinateListSizeLimit == null && this.coordinates.size() > 25) {
                throw new ServicesException("A maximum of 25 coordinates is the default  allowed for this API. If your Mapbox account has been enabled by the Mapbox team to make a request with more than 25 coordinates, please use the builder's coordinateListSizeLimit() method and pass through your account-specific maximum.");
            }
            Integer num2 = this.coordinateListSizeLimit;
            if (num2 != null && num2.intValue() < this.coordinates.size()) {
                throw new ServicesException("If you're going to use the coordinateListSizeLimit() method, please pass through a number that's equal to or greater than the size of your coordinate list.");
            }
            coordinates(formatCoordinates(this.coordinates));
            sources(TextUtils.join(";", this.sources));
            destinations(TextUtils.join(";", this.destinations));
            annotations(TextUtils.join(",", this.annotations));
            approaches(TextUtils.join(";", this.approaches));
            MapboxMatrix autoBuild = autoBuild();
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
