package com.mapbox.android.telemetry;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* loaded from: classes3.dex */
class ConfigurationClient implements Callback {
    private static final String ACCESS_TOKEN_QUERY_PARAMETER = "access_token";
    private static final String CHINA_CONFIG_ENDPOINT = "api.mapbox.cn";
    private static final String COM_CONFIG_ENDPOINT = "api.mapbox.com";
    private static final long DAY_IN_MILLIS = 86400000;
    private static final Map<Environment, String> ENDPOINTS = new HashMap<Environment, String>() { // from class: com.mapbox.android.telemetry.ConfigurationClient.1
        {
            put(Environment.COM, ConfigurationClient.COM_CONFIG_ENDPOINT);
            put(Environment.STAGING, ConfigurationClient.COM_CONFIG_ENDPOINT);
            put(Environment.CHINA, ConfigurationClient.CHINA_CONFIG_ENDPOINT);
        }
    };
    private static final String EVENT_CONFIG_SEGMENT = "events-config";
    private static final String HTTPS_SCHEME = "https";
    private static final String LOG_TAG = "ConfigurationClient";
    private static final String MAPBOX_CONFIG_SYNC_KEY_TIMESTAMP = "mapboxConfigSyncTimestamp";
    private static final String USER_AGENT_REQUEST_HEADER = "User-Agent";
    private final String accessToken;
    private final OkHttpClient client;
    private final Context context;
    private final List<ConfigurationChangeHandler> handlers = new CopyOnWriteArrayList();
    private final String userAgent;

    ConfigurationClient(Context context, String str, String str2, OkHttpClient okHttpClient) {
        this.context = context;
        this.userAgent = str;
        this.accessToken = str2;
        this.client = okHttpClient;
    }

    void addHandler(ConfigurationChangeHandler configurationChangeHandler) {
        this.handlers.add(configurationChangeHandler);
    }

    boolean shouldUpdate() {
        return System.currentTimeMillis() - TelemetryUtils.obtainSharedPreferences(this.context).getLong(MAPBOX_CONFIG_SYNC_KEY_TIMESTAMP, 0L) >= 86400000;
    }

    void update() {
        this.client.newCall(new Request.Builder().url(generateRequestUrl(this.context, this.accessToken)).header("User-Agent", this.userAgent).build()).enqueue(this);
    }

    @Override // okhttp3.Callback
    public void onFailure(Call call, IOException iOException) {
        saveTimestamp();
    }

    @Override // okhttp3.Callback
    public void onResponse(Call call, Response response) throws IOException {
        ResponseBody body;
        saveTimestamp();
        if (response == null || (body = response.body()) == null) {
            return;
        }
        for (ConfigurationChangeHandler configurationChangeHandler : this.handlers) {
            if (configurationChangeHandler != null) {
                configurationChangeHandler.onUpdate(body.string());
            }
        }
    }

    private void saveTimestamp() {
        SharedPreferences.Editor edit = TelemetryUtils.obtainSharedPreferences(this.context).edit();
        edit.putLong(MAPBOX_CONFIG_SYNC_KEY_TIMESTAMP, System.currentTimeMillis());
        edit.apply();
    }

    private static HttpUrl generateRequestUrl(Context context, String str) {
        return new HttpUrl.Builder().scheme(HTTPS_SCHEME).host(determineConfigEndpoint(context)).addPathSegment(EVENT_CONFIG_SEGMENT).addQueryParameter(ACCESS_TOKEN_QUERY_PARAMETER, str).build();
    }

    private static String determineConfigEndpoint(Context context) {
        EnvironmentResolver upVar = new EnvironmentChain().setup();
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || applicationInfo.metaData == null) {
                return COM_CONFIG_ENDPOINT;
            }
            return ENDPOINTS.get(upVar.obtainServerInformation(applicationInfo.metaData).getEnvironment());
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(LOG_TAG, e.getMessage());
            return COM_CONFIG_ENDPOINT;
        }
    }
}
