package com.mapbox.android.telemetry.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import com.mapbox.android.core.crashreporter.MapboxUncaughtExceptionHanlder;
import com.mapbox.android.telemetry.BuildConfig;
import com.mapbox.android.telemetry.errors.TokenChangeBroadcastReceiver;
import com.mapbox.android.telemetry.location.LocationCollectionClient;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class MapboxTelemetryInitProvider extends ContentProvider {
    private static final String EMPTY_APPLICATION_ID_PROVIDER_AUTHORITY = "com.mapbox.android.telemetry.provider.mapboxtelemetryinitprovider";
    private static final String TAG = "MbxTelemInitProvider";

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        try {
            TokenChangeBroadcastReceiver.register(getContext());
            MapboxUncaughtExceptionHanlder.install(getContext(), "com.mapbox.android.telemetry", BuildConfig.VERSION_NAME);
            LocationCollectionClient.install(getContext(), TimeUnit.HOURS.toMillis(24L));
            return false;
        } catch (Throwable th) {
            Log.e(TAG, th.toString());
            return false;
        }
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        checkContentProviderAuthority(providerInfo);
        super.attachInfo(context, providerInfo);
    }

    private static void checkContentProviderAuthority(ProviderInfo providerInfo) {
        if (providerInfo == null) {
            throw new IllegalStateException("MapboxTelemetryInitProvider: ProviderInfo cannot be null.");
        }
        if (EMPTY_APPLICATION_ID_PROVIDER_AUTHORITY.equals(providerInfo.authority)) {
            throw new IllegalStateException("Incorrect provider authority in manifest. Most likely due to a missing applicationId variable in application's build.gradle.");
        }
    }
}