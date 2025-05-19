package com.mapbox.mapboxsdk;

import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.mapbox.android.accounts.v1.MapboxAccounts;
import com.mapbox.mapboxsdk.log.Logger;
import org.apache.commons.lang3.time.DateUtils;

/* loaded from: classes3.dex */
class AccountsManager {
    private static final String PREFERENCE_TIMESTAMP = "com.mapbox.mapboxsdk.accounts.timestamp";
    private static final String PREFERENCE_USER_ID = "com.mapbox.mapboxsdk.accounts.userid";
    private static final String TAG = "Mbgl-AccountsManager";
    private boolean isManaged;
    private SharedPreferences sharedPreferences;
    private String skuToken;
    private long timestamp;
    private String userId;

    static boolean isExpired(long j, long j2) {
        return j - j2 > DateUtils.MILLIS_PER_HOUR;
    }

    AccountsManager() {
        this.isManaged = isSkuTokenManaged();
        initialize();
    }

    AccountsManager(SharedPreferences sharedPreferences, boolean z) {
        this.sharedPreferences = sharedPreferences;
        this.isManaged = z;
        initialize();
    }

    private void initialize() {
        retrieveSkuTokenAndTimestamp();
        if (this.isManaged) {
            validateRotation();
        }
    }

    private boolean isSkuTokenManaged() {
        try {
            ApplicationInfo retrieveApplicationInfo = retrieveApplicationInfo();
            if (retrieveApplicationInfo.metaData != null) {
                return retrieveApplicationInfo.metaData.getBoolean("com.mapbox.ManageSkuToken", true);
            }
            return true;
        } catch (Exception e) {
            Logger.e(TAG, "Failed to read the package metadata: ", e);
            return true;
        }
    }

    private ApplicationInfo retrieveApplicationInfo() throws PackageManager.NameNotFoundException {
        return Mapbox.getApplicationContext().getPackageManager().getApplicationInfo(Mapbox.getApplicationContext().getPackageName(), 128);
    }

    private void retrieveSkuTokenAndTimestamp() {
        SharedPreferences sharedPreferences = getSharedPreferences();
        this.skuToken = sharedPreferences.getString("com.mapbox.mapboxsdk.accounts.skutoken", "");
        this.timestamp = sharedPreferences.getLong(PREFERENCE_TIMESTAMP, 0L);
    }

    private void validateRotation() {
        if (TextUtils.isEmpty(this.skuToken) || this.timestamp == 0) {
            String generateSkuToken = generateSkuToken(getUserId());
            this.skuToken = generateSkuToken;
            this.timestamp = persistRotation(generateSkuToken);
        }
    }

    String getSkuToken() {
        if (this.isManaged) {
            if (isExpired()) {
                String generateSkuToken = generateSkuToken(getUserId());
                this.skuToken = generateSkuToken;
                this.timestamp = persistRotation(generateSkuToken);
            }
        } else {
            this.skuToken = getSharedPreferences().getString("com.mapbox.mapboxsdk.accounts.skutoken", "");
        }
        return this.skuToken;
    }

    private boolean isExpired() {
        return isExpired(getNow(), this.timestamp);
    }

    private long persistRotation(String str) {
        long now = getNow();
        SharedPreferences.Editor edit = getSharedPreferences().edit();
        edit.putLong(PREFERENCE_TIMESTAMP, now);
        edit.putString("com.mapbox.mapboxsdk.accounts.skutoken", str);
        edit.apply();
        return now;
    }

    private SharedPreferences getSharedPreferences() {
        if (this.sharedPreferences == null) {
            this.sharedPreferences = Mapbox.getApplicationContext().getSharedPreferences("MapboxSharedPreferences", 0);
        }
        return this.sharedPreferences;
    }

    static long getNow() {
        return System.currentTimeMillis();
    }

    private synchronized String getUserId() {
        if (!TextUtils.isEmpty(this.userId)) {
            return this.userId;
        }
        String string = getSharedPreferences().getString(PREFERENCE_USER_ID, "");
        this.userId = string;
        if (TextUtils.isEmpty(string)) {
            this.userId = generateUserId();
            SharedPreferences.Editor edit = getSharedPreferences().edit();
            edit.putString(PREFERENCE_USER_ID, this.userId);
            if (!edit.commit()) {
                Logger.e(TAG, "Failed to save user id.");
            }
        }
        return this.userId;
    }

    private String generateUserId() {
        return MapboxAccounts.obtainEndUserId();
    }

    private String generateSkuToken(String str) {
        return MapboxAccounts.obtainMapsSkuUserToken(str);
    }
}
