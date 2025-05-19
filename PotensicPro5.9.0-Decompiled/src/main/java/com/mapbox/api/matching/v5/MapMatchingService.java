package com.mapbox.api.matching.v5;

import com.mapbox.api.matching.v5.models.MapMatchingResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/* loaded from: classes3.dex */
public interface MapMatchingService {
    @GET("matching/v5/{user}/{profile}/{coordinates}")
    Call<MapMatchingResponse> getCall(@Header("User-Agent") String str, @Path("user") String str2, @Path("profile") String str3, @Path("coordinates") String str4, @Query("access_token") String str5, @Query("geometries") String str6, @Query("radiuses") String str7, @Query("steps") Boolean bool, @Query("overview") String str8, @Query("timestamps") String str9, @Query("annotations") String str10, @Query("language") String str11, @Query("tidy") Boolean bool2, @Query("roundabout_exits") Boolean bool3, @Query("banner_instructions") Boolean bool4, @Query("voice_instructions") Boolean bool5, @Query("voice_units") String str12, @Query("waypoints") String str13, @Query("waypoint_names") String str14, @Query("ignore") String str15, @Query("approaches") String str16);

    @FormUrlEncoded
    @POST("matching/v5/{user}/{profile}")
    Call<MapMatchingResponse> postCall(@Header("User-Agent") String str, @Path("user") String str2, @Path("profile") String str3, @Field("coordinates") String str4, @Query("access_token") String str5, @Field("geometries") String str6, @Field("radiuses") String str7, @Field("steps") Boolean bool, @Field("overview") String str8, @Field("timestamps") String str9, @Field("annotations") String str10, @Field("language") String str11, @Field("tidy") Boolean bool2, @Field("roundabout_exits") Boolean bool3, @Field("banner_instructions") Boolean bool4, @Field("voice_instructions") Boolean bool5, @Field("voice_units") String str12, @Field("waypoints") String str13, @Field("waypoint_names") String str14, @Field("ignore") String str15, @Field("approaches") String str16);
}
