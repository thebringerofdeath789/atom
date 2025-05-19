package com.mapbox.api.tilequery;

import com.mapbox.geojson.FeatureCollection;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/* loaded from: classes3.dex */
public interface TilequeryService {
    @GET("/v4/{tilesetIds}/tilequery/{query}.json")
    Call<List<FeatureCollection>> getBatchCall(@Path("tilesetIds") String str, @Path("query") String str2, @Query("access_token") String str3, @Query("radius") Integer num, @Query("limit") Integer num2, @Query("dedupe") Boolean bool, @Query("geometry") String str4, @Query("layers") String str5);

    @GET("/v4/{tilesetIds}/tilequery/{query}.json")
    Call<FeatureCollection> getCall(@Path("tilesetIds") String str, @Path("query") String str2, @Query("access_token") String str3, @Query("radius") Integer num, @Query("limit") Integer num2, @Query("dedupe") Boolean bool, @Query("geometry") String str4, @Query("layers") String str5);
}
