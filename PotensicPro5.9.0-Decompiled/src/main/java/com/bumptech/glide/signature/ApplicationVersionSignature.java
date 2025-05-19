package com.bumptech.glide.signature;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.bumptech.glide.load.Key;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public final class ApplicationVersionSignature {
    private static final ConcurrentHashMap<String, Key> PACKAGE_NAME_TO_KEY = new ConcurrentHashMap<>();

    public static Key obtain(Context context) {
        String packageName = context.getPackageName();
        ConcurrentHashMap<String, Key> concurrentHashMap = PACKAGE_NAME_TO_KEY;
        Key key = concurrentHashMap.get(packageName);
        if (key != null) {
            return key;
        }
        Key obtainVersionSignature = obtainVersionSignature(context);
        Key putIfAbsent = concurrentHashMap.putIfAbsent(packageName, obtainVersionSignature);
        return putIfAbsent == null ? obtainVersionSignature : putIfAbsent;
    }

    static void reset() {
        PACKAGE_NAME_TO_KEY.clear();
    }

    private static Key obtainVersionSignature(Context context) {
        PackageInfo packageInfo;
        String uuid;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            packageInfo = null;
        }
        if (packageInfo != null) {
            uuid = String.valueOf(packageInfo.versionCode);
        } else {
            uuid = UUID.randomUUID().toString();
        }
        return new StringSignature(uuid);
    }

    private ApplicationVersionSignature() {
    }
}
