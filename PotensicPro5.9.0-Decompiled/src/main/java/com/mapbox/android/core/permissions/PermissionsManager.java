package com.mapbox.android.core.permissions;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes3.dex */
public class PermissionsManager {
    private static final String BACKGROUND_LOCATION_PERMISSION = "android.permission.ACCESS_BACKGROUND_LOCATION";
    private static final String COARSE_LOCATION_PERMISSION = "android.permission.ACCESS_COARSE_LOCATION";
    private static final String FINE_LOCATION_PERMISSION = "android.permission.ACCESS_FINE_LOCATION";
    private static final String LOG_TAG = "PermissionsManager";
    private final int REQUEST_PERMISSIONS_CODE = 0;
    private PermissionsListener listener;

    public PermissionsManager(PermissionsListener permissionsListener) {
        this.listener = permissionsListener;
    }

    public PermissionsListener getListener() {
        return this.listener;
    }

    public void setListener(PermissionsListener permissionsListener) {
        this.listener = permissionsListener;
    }

    private static boolean isPermissionGranted(Context context, String str) {
        return ContextCompat.checkSelfPermission(context, str) == 0;
    }

    private static boolean isCoarseLocationPermissionGranted(Context context) {
        return isPermissionGranted(context, "android.permission.ACCESS_COARSE_LOCATION");
    }

    private static boolean isFineLocationPermissionGranted(Context context) {
        return isPermissionGranted(context, "android.permission.ACCESS_FINE_LOCATION");
    }

    public static boolean isBackgroundLocationPermissionGranted(Context context) {
        if (Build.VERSION.SDK_INT >= 29) {
            return isPermissionGranted(context, "android.permission.ACCESS_BACKGROUND_LOCATION");
        }
        return areLocationPermissionsGranted(context);
    }

    public static boolean areLocationPermissionsGranted(Context context) {
        return isCoarseLocationPermissionGranted(context) || isFineLocationPermissionGranted(context);
    }

    public static boolean areRuntimePermissionsRequired() {
        return Build.VERSION.SDK_INT >= 23;
    }

    public void requestLocationPermissions(Activity activity) {
        try {
            String[] strArr = activity.getPackageManager().getPackageInfo(activity.getPackageName(), 4096).requestedPermissions;
            if (strArr != null) {
                List asList = Arrays.asList(strArr);
                boolean contains = asList.contains("android.permission.ACCESS_FINE_LOCATION");
                boolean contains2 = asList.contains("android.permission.ACCESS_COARSE_LOCATION");
                boolean contains3 = asList.contains("android.permission.ACCESS_BACKGROUND_LOCATION");
                if (contains) {
                    requestLocationPermissions(activity, true, contains3);
                } else if (contains2) {
                    requestLocationPermissions(activity, false, contains3);
                } else {
                    Log.w(LOG_TAG, "Location permissions are missing");
                }
            }
        } catch (Exception e) {
            Log.w(LOG_TAG, e.getMessage());
        }
    }

    private void requestLocationPermissions(Activity activity, boolean z, boolean z2) {
        ArrayList arrayList = new ArrayList();
        if (z) {
            arrayList.add("android.permission.ACCESS_FINE_LOCATION");
        } else {
            arrayList.add("android.permission.ACCESS_COARSE_LOCATION");
        }
        if (Build.VERSION.SDK_INT >= 29 && z2) {
            arrayList.add("android.permission.ACCESS_BACKGROUND_LOCATION");
        }
        requestPermissions(activity, (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    private void requestPermissions(Activity activity, String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(activity, str)) {
                arrayList.add(str);
            }
        }
        if (this.listener != null && arrayList.size() > 0) {
            this.listener.onExplanationNeeded(arrayList);
        }
        ActivityCompat.requestPermissions(activity, strArr, 0);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        PermissionsListener permissionsListener;
        if (i == 0 && (permissionsListener = this.listener) != null) {
            boolean z = false;
            if (iArr.length > 0 && iArr[0] == 0) {
                z = true;
            }
            permissionsListener.onPermissionResult(z);
        }
    }
}
