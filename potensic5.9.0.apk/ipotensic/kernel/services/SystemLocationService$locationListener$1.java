package com.ipotensic.kernel.services;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import com.ipotensic.baselib.DDLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SystemLocationService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016J$\u0010\n\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016\u00a8\u0006\u000f"}, d2 = {"com/ipotensic/kernel/services/SystemLocationService$locationListener$1", "Landroid/location/LocationListener;", "onLocationChanged", "", "location", "Landroid/location/Location;", "onProviderDisabled", "provider", "", "onProviderEnabled", "onStatusChanged", NotificationCompat.CATEGORY_STATUS, "", "extras", "Landroid/os/Bundle;", "Kernel_mapboxRelease"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class SystemLocationService$locationListener$1 implements LocationListener {
    SystemLocationService$locationListener$1() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0049, code lost:
    
        r1 = com.ipotensic.kernel.services.SystemLocationService.this.locationChangedListener;
     */
    @Override // android.location.LocationListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onLocationChanged(Location location) {
        String str;
        OnLocationChangedListener onLocationChangedListener;
        Intrinsics.checkParameterIsNotNull(location, "location");
        str = SystemLocationService.this.TAG;
        DDLog.e(str, "\u5f53\u524d\u5b9a\u4f4d:" + location.getLatitude() + "," + location.getLongitude() + "," + location.getAccuracy());
        if (location.getAccuracy() >= 70.0f || onLocationChangedListener == null) {
            return;
        }
        onLocationChangedListener.onSystemLocationChanged(location.getLatitude(), location.getLongitude(), location.getAccuracy());
    }

    @Override // android.location.LocationListener
    public void onStatusChanged(String provider, int r2, Bundle extras) {
        String str;
        str = SystemLocationService.this.TAG;
        DDLog.e(str, "gps\u72b6\u6001\u53d8\u5316");
    }

    @Override // android.location.LocationListener
    public void onProviderEnabled(String provider) {
        String str;
        OnLocationChangedListener onLocationChangedListener;
        Intrinsics.checkParameterIsNotNull(provider, "provider");
        str = SystemLocationService.this.TAG;
        DDLog.e(str, "gps\u4f4d\u7f6e\u670d\u52a1\u5f00\u542f");
        onLocationChangedListener = SystemLocationService.this.locationChangedListener;
        if (onLocationChangedListener != null) {
            onLocationChangedListener.onGpsSystemOpen();
        }
    }

    @Override // android.location.LocationListener
    public void onProviderDisabled(String provider) {
        String str;
        OnLocationChangedListener onLocationChangedListener;
        Intrinsics.checkParameterIsNotNull(provider, "provider");
        str = SystemLocationService.this.TAG;
        DDLog.e(str, "gps\u4f4d\u7f6e\u670d\u52a1\u5173\u95ed");
        onLocationChangedListener = SystemLocationService.this.locationChangedListener;
        if (onLocationChangedListener != null) {
            onLocationChangedListener.onGpsSystemClose();
        }
    }
}