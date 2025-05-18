package com.mapbox.api.directions.p022v5.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.mapbox.api.directions.p022v5.DirectionsAdapterFactory;
import com.mapbox.api.directions.p022v5.models.AutoValue_DirectionsResponse;
import com.mapbox.api.directions.p022v5.models.C$AutoValue_DirectionsResponse;
import com.mapbox.api.directions.p022v5.models.DirectionsJsonObject;
import com.mapbox.geojson.Point;
import com.mapbox.geojson.PointAsCoordinatesTypeAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class DirectionsResponse extends DirectionsJsonObject {
    public abstract String code();

    public abstract String message();

    public abstract Metadata metadata();

    public abstract List<DirectionsRoute> routes();

    public abstract Builder toBuilder();

    public abstract String uuid();

    public abstract List<DirectionsWaypoint> waypoints();

    public static Builder builder() {
        return new C$AutoValue_DirectionsResponse.Builder();
    }

    public static TypeAdapter<DirectionsResponse> typeAdapter(Gson gson) {
        return new AutoValue_DirectionsResponse.GsonTypeAdapter(gson);
    }

    public static DirectionsResponse fromJson(String str) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(DirectionsAdapterFactory.create());
        gsonBuilder.registerTypeAdapter(Point.class, new PointAsCoordinatesTypeAdapter());
        return ((DirectionsResponse) gsonBuilder.create().fromJson(str, DirectionsResponse.class)).toBuilder().build();
    }

    @Deprecated
    public static DirectionsResponse fromJson(String str, RouteOptions routeOptions, String str2) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(DirectionsAdapterFactory.create());
        gsonBuilder.registerTypeAdapter(Point.class, new PointAsCoordinatesTypeAdapter());
        DirectionsResponse directionsResponse = (DirectionsResponse) gsonBuilder.create().fromJson(str, DirectionsResponse.class);
        if (routeOptions != null) {
            directionsResponse = directionsResponse.updateWithRequestData(routeOptions);
        }
        return directionsResponse.toBuilder().uuid(str2).build();
    }

    public static DirectionsResponse fromJson(String str, RouteOptions routeOptions) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(DirectionsAdapterFactory.create());
        gsonBuilder.registerTypeAdapter(Point.class, new PointAsCoordinatesTypeAdapter());
        return ((DirectionsResponse) gsonBuilder.create().fromJson(str, DirectionsResponse.class)).updateWithRequestData(routeOptions);
    }

    public DirectionsResponse updateWithRequestData(RouteOptions routeOptions) {
        ArrayList arrayList = new ArrayList();
        Iterator<DirectionsRoute> it = routes().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().toBuilder().routeOptions(routeOptions).build());
        }
        return toBuilder().routes(arrayList).build();
    }

    public static abstract class Builder extends DirectionsJsonObject.Builder<Builder> {
        abstract DirectionsResponse autoBuild();

        public abstract Builder code(String str);

        public abstract Builder message(String str);

        public abstract Builder metadata(Metadata metadata);

        public abstract Builder routes(List<DirectionsRoute> list);

        abstract List<DirectionsRoute> routes();

        public abstract Builder uuid(String str);

        abstract String uuid();

        public abstract Builder waypoints(List<DirectionsWaypoint> list);

        public DirectionsResponse build() {
            ArrayList arrayList = new ArrayList(routes().size());
            for (int i = 0; i < routes().size(); i++) {
                arrayList.add(i, routes().get(i).toBuilder().routeIndex(String.valueOf(i)).requestUuid(uuid()).build());
            }
            routes(arrayList);
            return autoBuild();
        }
    }
}