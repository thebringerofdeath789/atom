package com.mapbox.api.matching.v5;

import com.google.gson.GsonBuilder;
import com.mapbox.api.directions.v5.DirectionsAdapterFactory;
import com.mapbox.api.directions.v5.DirectionsCriteria;
import com.mapbox.api.directions.v5.utils.FormatUtils;
import com.mapbox.api.matching.v5.AutoValue_MapboxMapMatching;
import com.mapbox.api.matching.v5.models.MapMatchingAdapterFactory;
import com.mapbox.api.matching.v5.models.MapMatchingResponse;
import com.mapbox.core.MapboxService;
import com.mapbox.core.exceptions.ServicesException;
import com.mapbox.core.utils.ApiCallHelper;
import com.mapbox.core.utils.MapboxUtils;
import com.mapbox.core.utils.TextUtils;
import com.mapbox.geojson.Point;
import java.io.IOException;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* loaded from: classes3.dex */
public abstract class MapboxMapMatching extends MapboxService<MapMatchingResponse, MapMatchingService> {
    public static final String IGNORE_ACCESS = "access";
    public static final String IGNORE_ONEWAYS = "oneways";
    public static final String IGNORE_RESTRICTIONS = "restrictions";

    @Target({ElementType.ANNOTATION_TYPE, ElementType.PARAMETER})
    @Retention(RetentionPolicy.CLASS)
    public @interface IgnoreScope {
    }

    abstract String accessToken();

    abstract String annotations();

    abstract String approaches();

    abstract Boolean bannerInstructions();

    @Override // com.mapbox.core.MapboxService
    protected abstract String baseUrl();

    abstract String clientAppName();

    abstract String coordinates();

    abstract String geometries();

    abstract String ignore();

    abstract String language();

    abstract String overview();

    abstract String profile();

    abstract String radiuses();

    abstract Boolean roundaboutExits();

    abstract Boolean steps();

    abstract Boolean tidy();

    abstract String timestamps();

    abstract Boolean usePostMethod();

    abstract String user();

    abstract Boolean voiceInstructions();

    abstract String voiceUnits();

    abstract String waypointIndices();

    abstract String waypointNames();

    protected MapboxMapMatching() {
        super(MapMatchingService.class);
    }

    @Override // com.mapbox.core.MapboxService
    protected GsonBuilder getGsonBuilder() {
        return new GsonBuilder().registerTypeAdapterFactory(MapMatchingAdapterFactory.create()).registerTypeAdapterFactory(DirectionsAdapterFactory.create());
    }

    @Override // com.mapbox.core.MapboxService
    protected Call<MapMatchingResponse> initializeCall() {
        if (usePostMethod() == null) {
            return callForUrlLength();
        }
        if (usePostMethod().booleanValue()) {
            return post();
        }
        return get();
    }

    private Call<MapMatchingResponse> callForUrlLength() {
        Call<MapMatchingResponse> call = get();
        return call.request().url().getUrl().length() < 8192 ? call : post();
    }

    private Call<MapMatchingResponse> get() {
        return getService().getCall(ApiCallHelper.getHeaderUserAgent(clientAppName()), user(), profile(), coordinates(), accessToken(), geometries(), radiuses(), steps(), overview(), timestamps(), annotations(), language(), tidy(), roundaboutExits(), bannerInstructions(), voiceInstructions(), voiceUnits(), waypointIndices(), waypointNames(), ignore(), approaches());
    }

    private Call<MapMatchingResponse> post() {
        return getService().postCall(ApiCallHelper.getHeaderUserAgent(clientAppName()), user(), profile(), coordinates(), accessToken(), geometries(), radiuses(), steps(), overview(), timestamps(), annotations(), language(), tidy(), roundaboutExits(), bannerInstructions(), voiceInstructions(), voiceUnits(), waypointIndices(), waypointNames(), ignore(), approaches());
    }

    @Override // com.mapbox.core.MapboxService
    public Response<MapMatchingResponse> executeCall() throws IOException {
        return new MatchingResponseFactory(this).generate(getCall().execute());
    }

    @Override // com.mapbox.core.MapboxService
    public void enqueueCall(final Callback<MapMatchingResponse> callback) {
        getCall().enqueue(new Callback<MapMatchingResponse>() { // from class: com.mapbox.api.matching.v5.MapboxMapMatching.1
            @Override // retrofit2.Callback
            public void onResponse(Call<MapMatchingResponse> call, Response<MapMatchingResponse> response) {
                callback.onResponse(call, new MatchingResponseFactory(MapboxMapMatching.this).generate(response));
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<MapMatchingResponse> call, Throwable th) {
                callback.onFailure(call, th);
            }
        });
    }

    public static Builder builder() {
        return new AutoValue_MapboxMapMatching.Builder().baseUrl("https://api.mapbox.com").geometries(DirectionsCriteria.GEOMETRY_POLYLINE6).user("mapbox");
    }

    public static abstract class Builder {
        private String[] annotations;
        private String[] approaches;
        private List<Point> coordinates = new ArrayList();
        private String[] ignores;
        private Double[] radiuses;
        private String[] timestamps;
        private Integer[] waypointIndices;
        private String[] waypointNames;

        public abstract Builder accessToken(String str);

        protected abstract Builder annotations(String str);

        abstract Builder approaches(String str);

        protected abstract MapboxMapMatching autoBuild();

        public abstract Builder bannerInstructions(Boolean bool);

        public abstract Builder baseUrl(String str);

        public abstract Builder clientAppName(String str);

        protected abstract Builder coordinates(String str);

        public abstract Builder geometries(String str);

        abstract Builder ignore(String str);

        public abstract Builder language(String str);

        public abstract Builder overview(String str);

        public abstract Builder profile(String str);

        abstract Builder radiuses(String str);

        public abstract Builder roundaboutExits(Boolean bool);

        public abstract Builder steps(Boolean bool);

        public abstract Builder tidy(Boolean bool);

        protected abstract Builder timestamps(String str);

        abstract Builder usePostMethod(Boolean bool);

        public abstract Builder user(String str);

        public abstract Builder voiceInstructions(Boolean bool);

        public abstract Builder voiceUnits(String str);

        abstract Builder waypointIndices(String str);

        abstract Builder waypointNames(String str);

        public Builder post() {
            usePostMethod(true);
            return this;
        }

        public Builder get() {
            usePostMethod(false);
            return this;
        }

        public Builder radiuses(Double... dArr) {
            this.radiuses = dArr;
            return this;
        }

        @Deprecated
        public Builder waypoints(Integer... numArr) {
            this.waypointIndices = numArr;
            return this;
        }

        public Builder waypointIndices(Integer... numArr) {
            this.waypointIndices = numArr;
            return this;
        }

        public Builder annotations(String... strArr) {
            this.annotations = strArr;
            return this;
        }

        public Builder timestamps(String... strArr) {
            this.timestamps = strArr;
            return this;
        }

        public Builder coordinates(List<Point> list) {
            this.coordinates.addAll(list);
            return this;
        }

        public Builder coordinate(Point point) {
            this.coordinates.add(point);
            return this;
        }

        public Builder language(Locale locale) {
            if (locale != null) {
                language(locale.getLanguage());
            }
            return this;
        }

        public Builder addApproaches(String... strArr) {
            this.approaches = strArr;
            return this;
        }

        public Builder addWaypointNames(String... strArr) {
            this.waypointNames = strArr;
            return this;
        }

        public Builder addIgnore(String... strArr) {
            this.ignores = strArr;
            return this;
        }

        public MapboxMapMatching build() {
            List<Point> list = this.coordinates;
            if (list == null || list.size() < 2) {
                throw new ServicesException("At least two coordinates must be provided with your API request.");
            }
            Double[] dArr = this.radiuses;
            if (dArr != null && dArr.length != this.coordinates.size()) {
                throw new ServicesException("There must be as many radiuses as there are coordinates.");
            }
            String[] strArr = this.timestamps;
            if (strArr != null && strArr.length != this.coordinates.size()) {
                throw new ServicesException("There must be as many timestamps as there are coordinates.");
            }
            Integer[] numArr = this.waypointIndices;
            if (numArr != null) {
                if (numArr.length < 2) {
                    throw new ServicesException("Waypoints must be a list of at least two indexes separated by ';'");
                }
                if (numArr[0].intValue() == 0) {
                    Integer[] numArr2 = this.waypointIndices;
                    if (numArr2[numArr2.length - 1].intValue() == this.coordinates.size() - 1) {
                        int i = 1;
                        while (true) {
                            Integer[] numArr3 = this.waypointIndices;
                            if (i >= numArr3.length - 1) {
                                break;
                            }
                            if (numArr3[i].intValue() < 0 || this.waypointIndices[i].intValue() >= this.coordinates.size()) {
                                break;
                            }
                            i++;
                        }
                        throw new ServicesException("Waypoints index too large (no corresponding coordinate)");
                    }
                }
                throw new ServicesException("Waypoints must contain indices of the first and last coordinates");
            }
            String[] strArr2 = this.waypointNames;
            if (strArr2 != null) {
                waypointNames(FormatUtils.join(";", Arrays.asList(strArr2)));
            }
            String[] strArr3 = this.approaches;
            if (strArr3 != null) {
                if (strArr3.length != this.coordinates.size()) {
                    throw new ServicesException("Number of approach elements must match number of coordinates provided.");
                }
                String join = FormatUtils.join(";", Arrays.asList(this.approaches));
                if (join == null) {
                    throw new ServicesException("All approaches values must be one of curb, unrestricted");
                }
                approaches(join);
            }
            String[] strArr4 = this.ignores;
            if (strArr4 != null) {
                ignore(FormatUtils.join(",", Arrays.asList(strArr4)));
            }
            coordinates(formatCoordinates(this.coordinates));
            timestamps(TextUtils.join(";", this.timestamps));
            annotations(TextUtils.join(",", this.annotations));
            radiuses(TextUtils.join(";", this.radiuses));
            waypointIndices(TextUtils.join(";", this.waypointIndices));
            MapboxMapMatching autoBuild = autoBuild();
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
