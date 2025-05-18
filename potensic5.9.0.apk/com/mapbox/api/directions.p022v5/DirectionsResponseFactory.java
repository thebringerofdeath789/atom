package com.mapbox.api.directions.p022v5;

import com.mapbox.api.directions.p022v5.models.DirectionsResponse;
import com.mapbox.api.directions.p022v5.models.RouteOptions;
import retrofit2.Response;

/* loaded from: classes3.dex */
class DirectionsResponseFactory {
    DirectionsResponseFactory() {
    }

    static Response<DirectionsResponse> generate(RouteOptions routeOptions, Response<DirectionsResponse> response) {
        return isNotSuccessful(response) ? response : Response.success(response.body().updateWithRequestData(routeOptions), response.raw());
    }

    private static boolean isNotSuccessful(Response<DirectionsResponse> response) {
        return !response.isSuccessful() || response.body() == null;
    }
}