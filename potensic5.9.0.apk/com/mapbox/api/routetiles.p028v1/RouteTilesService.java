package com.mapbox.api.routetiles.p028v1;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

/* loaded from: classes3.dex */
public interface RouteTilesService {
    @GET("route-tiles/v1/{coordinates}")
    Call<ResponseBody> getCall(@Header("User-Agent") String str, @Path("coordinates") String str2, @Query("version") String str3, @Query("access_token") String str4);
}