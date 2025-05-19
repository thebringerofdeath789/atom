package com.mapbox.api.speech.v1;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/* loaded from: classes3.dex */
public interface SpeechService {
    @GET("/voice/v1/speak/{text}")
    Call<ResponseBody> getCall(@Path("text") String str, @Query("textType") String str2, @Query("language") String str3, @Query("outputFormat") String str4, @Query("access_token") String str5);
}
