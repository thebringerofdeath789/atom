package com.tencent.mmkv;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

/* loaded from: classes3.dex */
public class MMKVContentProvider extends ContentProvider {
    protected static final String FUNCTION_NAME = "mmkvFromAshmemID";
    protected static final String KEY = "KEY";
    protected static final String KEY_CRYPT = "KEY_CRYPT";
    protected static final String KEY_MODE = "KEY_MODE";
    protected static final String KEY_SIZE = "KEY_SIZE";
    private static Uri gUri;

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    protected static Uri contentUri(Context context) {
        String queryAuthority;
        Uri uri = gUri;
        if (uri != null) {
            return uri;
        }
        if (context == null || (queryAuthority = queryAuthority(context)) == null) {
            return null;
        }
        Uri parse = Uri.parse("content://" + queryAuthority);
        gUri = parse;
        return parse;
    }

    private Bundle mmkvFromAshmemID(String ashmemID, int size, int mode, String cryptKey) throws RuntimeException {
        MMKV mmkvWithAshmemID = MMKV.mmkvWithAshmemID(getContext(), ashmemID, size, mode, cryptKey);
        ParcelableMMKV parcelableMMKV = new ParcelableMMKV(mmkvWithAshmemID);
        Log.i("MMKV", ashmemID + " fd = " + mmkvWithAshmemID.ashmemFD() + ", meta fd = " + mmkvWithAshmemID.ashmemMetaFD());
        Bundle bundle = new Bundle();
        bundle.putParcelable("KEY", parcelableMMKV);
        return bundle;
    }

    private static String queryAuthority(Context context) {
        ProviderInfo providerInfo;
        try {
            ComponentName componentName = new ComponentName(context, MMKVContentProvider.class.getName());
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (providerInfo = packageManager.getProviderInfo(componentName, 0)) == null) {
                return null;
            }
            return providerInfo.authority;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        String queryAuthority;
        Context context = getContext();
        if (context == null || (queryAuthority = queryAuthority(context)) == null) {
            return false;
        }
        if (gUri != null) {
            return true;
        }
        gUri = Uri.parse("content://" + queryAuthority);
        return true;
    }

    protected static String getProcessNameByPID(Context context, int pid) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null) {
            return "";
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
            if (runningAppProcessInfo.pid == pid) {
                return runningAppProcessInfo.processName;
            }
        }
        return "";
    }

    @Override // android.content.ContentProvider
    public Bundle call(String method, String mmapID, Bundle extras) {
        if (method.equals(FUNCTION_NAME) && extras != null) {
            try {
                return mmkvFromAshmemID(mmapID, extras.getInt(KEY_SIZE), extras.getInt(KEY_MODE), extras.getString(KEY_CRYPT));
            } catch (Exception e) {
                Log.e("MMKV", e.getMessage());
            }
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        throw new UnsupportedOperationException("Not implement in MMKV");
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        throw new UnsupportedOperationException("Not implement in MMKV");
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        throw new UnsupportedOperationException("Not implement in MMKV");
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues values) {
        throw new UnsupportedOperationException("Not implement in MMKV");
    }
}
