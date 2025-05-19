package com.mapbox.api.geocoding.v5;

import com.google.gson.GsonBuilder;
import com.mapbox.api.geocoding.v5.AutoValue_MapboxGeocoding;
import com.mapbox.api.geocoding.v5.models.GeocodingAdapterFactory;
import com.mapbox.api.geocoding.v5.models.GeocodingResponse;
import com.mapbox.core.MapboxService;
import com.mapbox.core.exceptions.ServicesException;
import com.mapbox.core.utils.ApiCallHelper;
import com.mapbox.core.utils.MapboxUtils;
import com.mapbox.core.utils.TextUtils;
import com.mapbox.geojson.BoundingBox;
import com.mapbox.geojson.GeometryAdapterFactory;
import com.mapbox.geojson.Point;
import com.mapbox.geojson.gson.BoundingBoxTypeAdapter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* loaded from: classes3.dex */
public abstract class MapboxGeocoding extends MapboxService<GeocodingResponse, GeocodingService> {
    private Call<List<GeocodingResponse>> batchCall;

    abstract String accessToken();

    abstract Boolean autocomplete();

    @Override // com.mapbox.core.MapboxService
    protected abstract String baseUrl();

    abstract String bbox();

    abstract String clientAppName();

    abstract String country();

    abstract Boolean fuzzyMatch();

    abstract String geocodingTypes();

    abstract String languages();

    abstract String limit();

    abstract String mode();

    abstract String proximity();

    abstract String query();

    abstract String reverseMode();

    protected MapboxGeocoding() {
        super(GeocodingService.class);
    }

    @Override // com.mapbox.core.MapboxService
    protected GsonBuilder getGsonBuilder() {
        return new GsonBuilder().registerTypeAdapterFactory(GeocodingAdapterFactory.create()).registerTypeAdapterFactory(GeometryAdapterFactory.create()).registerTypeAdapterFactory(SingleElementSafeListTypeAdapter.FACTORY).registerTypeAdapter(BoundingBox.class, new BoundingBoxTypeAdapter());
    }

    @Override // com.mapbox.core.MapboxService
    protected Call<GeocodingResponse> initializeCall() {
        if (mode().contains(GeocodingCriteria.MODE_PLACES_PERMANENT)) {
            throw new IllegalArgumentException("Use getBatchCall() for batch calls.");
        }
        return getService().getCall(ApiCallHelper.getHeaderUserAgent(clientAppName()), mode(), query(), accessToken(), country(), proximity(), geocodingTypes(), autocomplete(), bbox(), limit(), languages(), reverseMode(), fuzzyMatch());
    }

    private Call<List<GeocodingResponse>> getBatchCall() {
        Call<List<GeocodingResponse>> call = this.batchCall;
        if (call != null) {
            return call;
        }
        if (mode().equals(GeocodingCriteria.MODE_PLACES)) {
            throw new ServicesException("Use getCall() for non-batch calls or set the mode to `permanent` for batch requests.");
        }
        Call<List<GeocodingResponse>> batchCall = getService().getBatchCall(ApiCallHelper.getHeaderUserAgent(clientAppName()), mode(), query(), accessToken(), country(), proximity(), geocodingTypes(), autocomplete(), bbox(), limit(), languages(), reverseMode(), fuzzyMatch());
        this.batchCall = batchCall;
        return batchCall;
    }

    public Response<List<GeocodingResponse>> executeBatchCall() throws IOException {
        return getBatchCall().execute();
    }

    public void enqueueBatchCall(Callback<List<GeocodingResponse>> callback) {
        getBatchCall().enqueue(callback);
    }

    public void cancelBatchCall() {
        getBatchCall().cancel();
    }

    public Call<List<GeocodingResponse>> cloneBatchCall() {
        return getBatchCall().clone();
    }

    public static Builder builder() {
        return new AutoValue_MapboxGeocoding.Builder().baseUrl("https://api.mapbox.com").mode(GeocodingCriteria.MODE_PLACES);
    }

    public static abstract class Builder {
        private List<String> countries = new ArrayList();
        private List<String> intersectionStreets = new ArrayList();

        public abstract Builder accessToken(String str);

        abstract MapboxGeocoding autoBuild();

        public abstract Builder autocomplete(Boolean bool);

        public abstract Builder baseUrl(String str);

        public abstract Builder bbox(String str);

        public abstract Builder clientAppName(String str);

        public abstract Builder country(String str);

        public abstract Builder fuzzyMatch(Boolean bool);

        abstract Builder geocodingTypes(String str);

        public abstract Builder languages(String str);

        abstract Builder limit(String str);

        public abstract Builder mode(String str);

        abstract Builder proximity(String str);

        public abstract Builder query(String str);

        public abstract Builder reverseMode(String str);

        public Builder query(Point point) {
            query(String.format(Locale.US, "%s,%s", TextUtils.formatCoordinate(point.longitude()), TextUtils.formatCoordinate(point.latitude())));
            return this;
        }

        public Builder proximity(Point point) {
            proximity(String.format(Locale.US, "%s,%s", TextUtils.formatCoordinate(point.longitude()), Double.valueOf(point.latitude())));
            return this;
        }

        public Builder geocodingTypes(String... strArr) {
            geocodingTypes(TextUtils.join(",", strArr));
            return this;
        }

        public Builder country(Locale locale) {
            this.countries.add(locale.getCountry());
            return this;
        }

        public Builder country(String... strArr) {
            this.countries.addAll(Arrays.asList(strArr));
            return this;
        }

        public Builder bbox(BoundingBox boundingBox) {
            bbox(boundingBox.southwest().longitude(), boundingBox.southwest().latitude(), boundingBox.northeast().longitude(), boundingBox.northeast().latitude());
            return this;
        }

        public Builder bbox(Point point, Point point2) {
            bbox(point.longitude(), point.latitude(), point2.longitude(), point2.latitude());
            return this;
        }

        public Builder bbox(double d, double d2, double d3, double d4) {
            bbox(String.format(Locale.US, "%s,%s,%s,%s", TextUtils.formatCoordinate(d), TextUtils.formatCoordinate(d2), TextUtils.formatCoordinate(d3), TextUtils.formatCoordinate(d4)));
            return this;
        }

        public Builder limit(int i) {
            limit(String.valueOf(i));
            return this;
        }

        public Builder languages(Locale... localeArr) {
            String[] strArr = new String[localeArr.length];
            for (int i = 0; i < localeArr.length; i++) {
                strArr[i] = localeArr[i].getLanguage();
            }
            languages(TextUtils.join(",", strArr));
            return this;
        }

        public Builder intersectionStreets(String str, String str2) {
            this.intersectionStreets.add(str);
            this.intersectionStreets.add(str2);
            return this;
        }

        public MapboxGeocoding build() {
            if (!this.countries.isEmpty()) {
                country(TextUtils.join(",", this.countries.toArray()));
            }
            if (this.intersectionStreets.size() == 2) {
                query(TextUtils.join(" and ", this.intersectionStreets.toArray()));
                geocodingTypes(GeocodingCriteria.TYPE_ADDRESS);
            }
            MapboxGeocoding autoBuild = autoBuild();
            if (!MapboxUtils.isAccessTokenValid(autoBuild.accessToken())) {
                throw new ServicesException("Using Mapbox Services requires setting a valid access token.");
            }
            if (autoBuild.query().isEmpty()) {
                throw new ServicesException("A query with at least one character or digit is required.");
            }
            if (autoBuild.reverseMode() != null && autoBuild.limit() != null && !autoBuild.limit().equals("1")) {
                throw new ServicesException("Limit must be combined with a single type parameter");
            }
            if (this.intersectionStreets.size() == 2) {
                if (!autoBuild.mode().equals(GeocodingCriteria.MODE_PLACES) && !autoBuild.mode().equals(GeocodingCriteria.MODE_PLACES_PERMANENT)) {
                    throw new ServicesException("Geocoding mode must be GeocodingCriteria.MODE_PLACES or GeocodingCriteria.MODE_PLACES_PERMANENT for intersection search.");
                }
                if (TextUtils.isEmpty(autoBuild.geocodingTypes()) || !autoBuild.geocodingTypes().equals(GeocodingCriteria.TYPE_ADDRESS)) {
                    throw new ServicesException("Geocoding type must be set to Geocoding Criteria.TYPE_ADDRESS for intersection search.");
                }
                if (TextUtils.isEmpty(autoBuild.proximity())) {
                    throw new ServicesException("Geocoding proximity must be set for intersection search.");
                }
            }
            return autoBuild;
        }
    }
}
