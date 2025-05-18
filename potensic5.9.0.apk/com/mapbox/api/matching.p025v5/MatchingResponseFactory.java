package com.mapbox.api.matching.p025v5;

import com.mapbox.api.directions.p022v5.models.RouteOptions;
import com.mapbox.api.matching.p025v5.models.MapMatchingMatching;
import com.mapbox.api.matching.p025v5.models.MapMatchingResponse;
import java.util.ArrayList;
import java.util.List;
import okhttp3.Response;
import retrofit2.Response;

/* loaded from: classes3.dex */
class MatchingResponseFactory {
    private static final String PLACEHOLDER_UUID = "mapmatching";
    private final MapboxMapMatching mapboxMapMatching;

    MatchingResponseFactory(MapboxMapMatching mapboxMapMatching) {
        this.mapboxMapMatching = mapboxMapMatching;
    }

    Response<MapMatchingResponse> generate(Response<MapMatchingResponse> response) {
        return isNotSuccessful(response) ? response : Response.success(response.body().toBuilder().matchings(generateRouteOptions(response)).build(), new Response.Builder().code(200).message("OK").protocol(response.raw().protocol()).headers(response.headers()).request(response.raw().request()).build());
    }

    private boolean isNotSuccessful(retrofit2.Response<MapMatchingResponse> response) {
        return !response.isSuccessful() || response.body() == null || response.body().matchings() == null || response.body().matchings().isEmpty();
    }

    private List<MapMatchingMatching> generateRouteOptions(retrofit2.Response<MapMatchingResponse> response) {
        List<MapMatchingMatching> matchings = response.body().matchings();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < matchings.size(); i++) {
            arrayList.add(matchings.get(i).toBuilder().routeOptions(RouteOptions.builder().profile(this.mapboxMapMatching.profile()).coordinates(this.mapboxMapMatching.coordinates()).annotations(this.mapboxMapMatching.annotations()).approaches(this.mapboxMapMatching.approaches()).language(this.mapboxMapMatching.language()).radiuses(this.mapboxMapMatching.radiuses()).user(this.mapboxMapMatching.user()).voiceInstructions(this.mapboxMapMatching.voiceInstructions()).bannerInstructions(this.mapboxMapMatching.bannerInstructions()).roundaboutExits(this.mapboxMapMatching.roundaboutExits()).geometries(this.mapboxMapMatching.geometries()).overview(this.mapboxMapMatching.overview()).steps(this.mapboxMapMatching.steps()).voiceUnits(this.mapboxMapMatching.voiceUnits()).waypointIndices(this.mapboxMapMatching.waypointIndices()).waypointNames(this.mapboxMapMatching.waypointNames()).baseUrl(this.mapboxMapMatching.baseUrl()).build()).requestUuid(PLACEHOLDER_UUID).routeIndex(String.valueOf(i)).build());
        }
        return arrayList;
    }
}