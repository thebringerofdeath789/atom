package com.mapbox.core;

import com.google.gson.GsonBuilder;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/* loaded from: classes3.dex */
public abstract class MapboxService<T, S> {
    public static final int MAX_URL_SIZE = 8192;
    private Call<T> call;
    private Call.Factory callFactory;
    private boolean enableDebug;
    protected OkHttpClient okHttpClient;
    private Retrofit retrofit;
    private S service;
    private final Class<S> serviceType;

    protected abstract String baseUrl();

    protected abstract retrofit2.Call<T> initializeCall();

    public MapboxService(Class<S> cls) {
        this.serviceType = cls;
    }

    protected retrofit2.Call<T> getCall() {
        if (this.call == null) {
            this.call = initializeCall();
        }
        return this.call;
    }

    public Response<T> executeCall() throws IOException {
        return getCall().execute();
    }

    public void enqueueCall(Callback<T> callback) {
        getCall().enqueue(callback);
    }

    public void cancelCall() {
        getCall().cancel();
    }

    public retrofit2.Call<T> cloneCall() {
        return getCall().clone();
    }

    protected S getService() {
        S s = this.service;
        if (s != null) {
            return s;
        }
        Retrofit.Builder addConverterFactory = new Retrofit.Builder().baseUrl(baseUrl()).addConverterFactory(GsonConverterFactory.create(getGsonBuilder().create()));
        if (getCallFactory() != null) {
            addConverterFactory.callFactory(getCallFactory());
        } else {
            addConverterFactory.client(getOkHttpClient());
        }
        Retrofit build = addConverterFactory.build();
        this.retrofit = build;
        S s2 = (S) build.create(this.serviceType);
        this.service = s2;
        return s2;
    }

    public Retrofit getRetrofit() {
        return this.retrofit;
    }

    protected GsonBuilder getGsonBuilder() {
        return new GsonBuilder();
    }

    public boolean isEnableDebug() {
        return this.enableDebug;
    }

    public void enableDebug(boolean z) {
        this.enableDebug = z;
    }

    public Call.Factory getCallFactory() {
        return this.callFactory;
    }

    public void setCallFactory(Call.Factory factory) {
        this.callFactory = factory;
    }

    protected synchronized OkHttpClient getOkHttpClient() {
        if (this.okHttpClient == null) {
            if (isEnableDebug()) {
                HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
                httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
                OkHttpClient.Builder builder = new OkHttpClient.Builder();
                builder.addInterceptor(httpLoggingInterceptor);
                this.okHttpClient = builder.build();
            } else {
                this.okHttpClient = new OkHttpClient();
            }
        }
        return this.okHttpClient;
    }
}
