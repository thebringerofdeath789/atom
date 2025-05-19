package com.mapbox.api.directionsrefresh.v1;

import com.mapbox.api.directionsrefresh.v1.models.DirectionsRefreshResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

/* loaded from: classes3.dex */
public interface DirectionsRefreshService {
    @GET("directions-refresh/v1/mapbox/driving-traffic/{request_id}/{route_index}/{leg_index}")
    Call<DirectionsRefreshResponse> getCall(@Header("User-Agent") String str, @Path("request_id") String str2, @Path("route_index") int i, @Path("leg_index") int i2, @Query("access_token") String str3);
}
