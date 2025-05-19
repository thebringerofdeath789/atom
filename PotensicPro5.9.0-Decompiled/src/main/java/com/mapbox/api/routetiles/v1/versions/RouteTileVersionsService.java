package com.mapbox.api.routetiles.v1.versions;

import com.mapbox.api.routetiles.v1.versions.models.RouteTileVersionsResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/* loaded from: classes3.dex */
public interface RouteTileVersionsService {
    @GET("route-tiles/v1/versions?")
    Call<RouteTileVersionsResponse> getCall(@Header("User-Agent") String str, @Query("access_token") String str2);
}
