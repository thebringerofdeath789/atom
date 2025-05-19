package com.mapbox.api.geocoding.v5;

import com.mapbox.api.geocoding.v5.models.GeocodingResponse;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

/* loaded from: classes3.dex */
public interface GeocodingService {
    @GET("/geocoding/v5/{mode}/{query}.json")
    Call<List<GeocodingResponse>> getBatchCall(@Header("User-Agent") String str, @Path("mode") String str2, @Path("query") String str3, @Query("access_token") String str4, @Query("country") String str5, @Query("proximity") String str6, @Query("types") String str7, @Query("autocomplete") Boolean bool, @Query("bbox") String str8, @Query("limit") String str9, @Query("language") String str10, @Query("reverseMode") String str11, @Query("fuzzyMatch") Boolean bool2);

    @GET("/geocoding/v5/{mode}/{query}.json")
    Call<GeocodingResponse> getCall(@Header("User-Agent") String str, @Path("mode") String str2, @Path("query") String str3, @Query("access_token") String str4, @Query("country") String str5, @Query("proximity") String str6, @Query("types") String str7, @Query("autocomplete") Boolean bool, @Query("bbox") String str8, @Query("limit") String str9, @Query("language") String str10, @Query("reverseMode") String str11, @Query("fuzzyMatch") Boolean bool2);
}
