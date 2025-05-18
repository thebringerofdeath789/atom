package com.ipotensic.kernel.services;

import android.location.GnssStatus;
import androidx.core.app.NotificationCompat;
import com.ipotensic.baselib.DDLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SystemLocationService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016\u00a8\u0006\u0006"}, d2 = {"com/ipotensic/kernel/services/SystemLocationService$gpsNumCallback$1", "Landroid/location/GnssStatus$Callback;", "onSatelliteStatusChanged", "", NotificationCompat.CATEGORY_STATUS, "Landroid/location/GnssStatus;", "Kernel_mapboxRelease"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class SystemLocationService$gpsNumCallback$1 extends GnssStatus.Callback {
    SystemLocationService$gpsNumCallback$1() {
    }

    @Override // android.location.GnssStatus.Callback
    public void onSatelliteStatusChanged(GnssStatus r4) {
        String str;
        OnLocationChangedListener onLocationChangedListener;
        Intrinsics.checkParameterIsNotNull(r4, "status");
        super.onSatelliteStatusChanged(r4);
        int satelliteCount = r4.getSatelliteCount();
        str = SystemLocationService.this.TAG;
        DDLog.e(str, "\u536b\u661f\u6570\u91cf:" + satelliteCount);
        onLocationChangedListener = SystemLocationService.this.locationChangedListener;
        if (onLocationChangedListener != null) {
            onLocationChangedListener.onSatelliteCount(satelliteCount);
        }
    }
}