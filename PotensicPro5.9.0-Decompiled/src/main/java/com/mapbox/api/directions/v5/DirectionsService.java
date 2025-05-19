package com.mapbox.api.directions.v5;

import com.mapbox.api.directions.v5.models.DirectionsResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/* loaded from: classes3.dex */
interface DirectionsService {
    @GET("directions/v5/{user}/{profile}/{coordinates}")
    Call<DirectionsResponse> getCall(@Header("User-Agent") String str, @Path("user") String str2, @Path("profile") String str3, @Path("coordinates") String str4, @Query("access_token") String str5, @Query("alternatives") Boolean bool, @Query("geometries") String str6, @Query("overview") String str7, @Query("radiuses") String str8, @Query("steps") Boolean bool2, @Query("bearings") String str9, @Query("avoid_maneuver_radius") Double d, @Query("layers") String str10, @Query("continue_straight") Boolean bool3, @Query("annotations") String str11, @Query("language") String str12, @Query("roundabout_exits") Boolean bool4, @Query("voice_instructions") Boolean bool5, @Query("banner_instructions") Boolean bool6, @Query("voice_units") String str13, @Query("exclude") String str14, @Query("include") String str15, @Query("approaches") String str16, @Query("waypoints") String str17, @Query("waypoint_names") String str18, @Query("waypoint_targets") String str19, @Query("enable_refresh") Boolean bool7, @Query("walking_speed") Double d2, @Query("walkway_bias") Double d3, @Query("alley_bias") Double d4, @Query("snapping_include_closures") String str20, @Query("snapping_include_static_closures") String str21, @Query("arrive_by") String str22, @Query("depart_at") String str23, @Query("max_height") Double d5, @Query("max_width") Double d6, @Query("max_weight") Double d7, @Query("compute_toll_cost") Boolean bool8, @Query("metadata") Boolean bool9);

    @FormUrlEncoded
    @POST("directions/v5/{user}/{profile}")
    Call<DirectionsResponse> postCall(@Header("User-Agent") String str, @Path("user") String str2, @Path("profile") String str3, @Field("coordinates") String str4, @Query("access_token") String str5, @Field("alternatives") Boolean bool, @Field("geometries") String str6, @Field("overview") String str7, @Field("radiuses") String str8, @Field("steps") Boolean bool2, @Field("bearings") String str9, @Field("avoid_maneuver_radius") Double d, @Field("layers") String str10, @Field("continue_straight") Boolean bool3, @Field("annotations") String str11, @Field("language") String str12, @Field("roundabout_exits") Boolean bool4, @Field("voice_instructions") Boolean bool5, @Field("banner_instructions") Boolean bool6, @Field("voice_units") String str13, @Field("exclude") String str14, @Field("include") String str15, @Field("approaches") String str16, @Field("waypoints") String str17, @Field("waypoint_names") String str18, @Field("waypoint_targets") String str19, @Field("enable_refresh") Boolean bool7, @Field("walking_speed") Double d2, @Field("walkway_bias") Double d3, @Field("alley_bias") Double d4, @Field("snapping_include_closures") String str20, @Field("snapping_include_static_closures") String str21, @Field("arrive_by") String str22, @Field("depart_at") String str23, @Field("max_height") Double d5, @Field("max_width") Double d6, @Field("max_weight") Double d7, @Field("compute_toll_cost") Boolean bool8, @Field("metadata") Boolean bool9);
}
