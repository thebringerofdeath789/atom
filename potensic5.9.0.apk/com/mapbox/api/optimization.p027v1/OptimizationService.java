package com.mapbox.api.optimization.p027v1;

import com.mapbox.api.optimization.p027v1.models.OptimizationResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

/* loaded from: classes3.dex */
public interface OptimizationService {
    @GET("optimized-trips/v1/{user}/{profile}/{coordinates}")
    Call<OptimizationResponse> getCall(@Header("User-Agent") String str, @Path("user") String str2, @Path("profile") String str3, @Path("coordinates") String str4, @Query("access_token") String str5, @Query("roundtrip") Boolean bool, @Query("radiuses") String str6, @Query("bearings") String str7, @Query("steps") Boolean bool2, @Query("overview") String str8, @Query("geometries") String str9, @Query("annotations") String str10, @Query("destination") String str11, @Query("source") String str12, @Query("language") String str13, @Query("distributions") String str14);
}