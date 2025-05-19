package com.mapbox.api.matrix.v1;

import com.mapbox.api.matrix.v1.models.MatrixResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

/* loaded from: classes3.dex */
public interface MatrixService {
    @GET("directions-matrix/v1/{user}/{profile}/{coordinates}")
    Call<MatrixResponse> getCall(@Header("User-Agent") String str, @Path("user") String str2, @Path("profile") String str3, @Path("coordinates") String str4, @Query("access_token") String str5, @Query("annotations") String str6, @Query("approaches") String str7, @Query("destinations") String str8, @Query("sources") String str9);
}
