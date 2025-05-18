package com.mapbox.api.isochrone;

import com.mapbox.geojson.FeatureCollection;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/* loaded from: classes3.dex */
public interface IsochroneService {
    @GET("/isochrone/v1/{user}/{profile}/{coordinates}")
    Call<FeatureCollection> getCall(@Path("user") String str, @Path("profile") String str2, @Path("coordinates") String str3, @Query("contours_minutes") String str4, @Query("access_token") String str5, @Query("contours_colors") String str6, @Query("polygons") Boolean bool, @Query("denoise") Float f, @Query("generalize") Float f2);
}