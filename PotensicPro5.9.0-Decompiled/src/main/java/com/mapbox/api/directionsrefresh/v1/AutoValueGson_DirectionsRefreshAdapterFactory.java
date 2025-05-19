package com.mapbox.api.directionsrefresh.v1;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.mapbox.api.directionsrefresh.v1.models.DirectionsRefreshResponse;
import com.mapbox.api.directionsrefresh.v1.models.DirectionsRouteRefresh;
import com.mapbox.api.directionsrefresh.v1.models.RouteLegRefresh;

/* loaded from: classes3.dex */
final class AutoValueGson_DirectionsRefreshAdapterFactory extends DirectionsRefreshAdapterFactory {
    AutoValueGson_DirectionsRefreshAdapterFactory() {
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        Class<? super T> rawType = typeToken.getRawType();
        if (DirectionsRefreshResponse.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) DirectionsRefreshResponse.typeAdapter(gson);
        }
        if (DirectionsRouteRefresh.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) DirectionsRouteRefresh.typeAdapter(gson);
        }
        if (RouteLegRefresh.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) RouteLegRefresh.typeAdapter(gson);
        }
        return null;
    }
}
