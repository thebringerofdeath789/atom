package com.ipotensic.kernel.services;

import android.content.Context;
import android.location.Criteria;
import android.location.GnssStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Bundle;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.configs.PhoneConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SystemLocationService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t*\u0002\u0007\u000f\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0014\u001a\u00020\u0015J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0017J\b\u0010\u001a\u001a\u00020\nH\u0016J\b\u0010\u001b\u001a\u00020\u0019H\u0016J\b\u0010\u001c\u001a\u00020\u0019H\u0007J\u0012\u0010\u001d\u001a\u00020\u00192\b\u0010\u001e\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u001f\u001a\u00020\u0019H\u0016J\b\u0010 \u001a\u00020\u0019H\u0016J\u0006\u0010!\u001a\u00020\u0019R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Lcom/ipotensic/kernel/services/SystemLocationService;", "Lcom/ipotensic/kernel/services/ILocationService;", "()V", "TAG", "", "kotlin.jvm.PlatformType", "gpsNumCallback", "com/ipotensic/kernel/services/SystemLocationService$gpsNumCallback$1", "Lcom/ipotensic/kernel/services/SystemLocationService$gpsNumCallback$1;", "isInit", "", "isRegister", "locationChangedListener", "Lcom/ipotensic/kernel/services/OnLocationChangedListener;", "locationListener", "com/ipotensic/kernel/services/SystemLocationService$locationListener$1", "Lcom/ipotensic/kernel/services/SystemLocationService$locationListener$1;", "locationManager", "Landroid/location/LocationManager;", "providerName", "getCriteria", "Landroid/location/Criteria;", "getRotate", "", "init", "", "isStart", "reStart", "registerListener", "setOnLocationChangedListener", "listener", TtmlNode.START, "stop", "unRegisterListener", "Kernel_mapboxRelease"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class SystemLocationService implements ILocationService {
    private boolean isInit;
    private boolean isRegister;
    private OnLocationChangedListener locationChangedListener;
    private LocationManager locationManager;
    private String providerName;
    private final String TAG = getClass().getSimpleName();
    private final SystemLocationService$locationListener$1 locationListener = new LocationListener() { // from class: com.ipotensic.kernel.services.SystemLocationService$locationListener$1
        /* JADX WARN: Code restructure failed: missing block: B:3:0x0049, code lost:
        
            r1 = r7.this$0.locationChangedListener;
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
        public void onStatusChanged(String provider, int status, Bundle extras) {
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
    };
    private final SystemLocationService$gpsNumCallback$1 gpsNumCallback = new GnssStatus.Callback() { // from class: com.ipotensic.kernel.services.SystemLocationService$gpsNumCallback$1
        @Override // android.location.GnssStatus.Callback
        public void onSatelliteStatusChanged(GnssStatus status) {
            String str;
            OnLocationChangedListener onLocationChangedListener;
            Intrinsics.checkParameterIsNotNull(status, "status");
            super.onSatelliteStatusChanged(status);
            int satelliteCount = status.getSatelliteCount();
            str = SystemLocationService.this.TAG;
            DDLog.e(str, "\u536b\u661f\u6570\u91cf:" + satelliteCount);
            onLocationChangedListener = SystemLocationService.this.locationChangedListener;
            if (onLocationChangedListener != null) {
                onLocationChangedListener.onSatelliteCount(satelliteCount);
            }
        }
    };

    @Override // com.ipotensic.kernel.services.ILocationService
    public float getRotate() {
        return 0.0f;
    }

    @Override // com.ipotensic.kernel.services.ILocationService
    public synchronized void init() {
        LocationProvider provider;
        if (this.locationManager == null) {
            DDLog.e(this.TAG, "\u5f00\u59cb\u521d\u59cb\u5316");
            Context context = PhoneConfig.applicationContext;
            LocationManager locationManager = (LocationManager) (context != null ? context.getSystemService("location") : null);
            this.locationManager = locationManager;
            if (locationManager != null) {
                LocationProvider provider2 = locationManager.getProvider("gps");
                if (provider2 != null) {
                    this.providerName = provider2.getName();
                } else {
                    String bestProvider = locationManager.getBestProvider(getCriteria(), true);
                    this.providerName = bestProvider;
                    if (bestProvider == null && (provider = locationManager.getProvider("network")) != null) {
                        this.providerName = provider.getName();
                    }
                }
                String str = this.providerName;
                if (str != null) {
                    Location lastKnownLocation = locationManager.getLastKnownLocation(str);
                    if (lastKnownLocation != null) {
                        OnLocationChangedListener onLocationChangedListener = this.locationChangedListener;
                        if (onLocationChangedListener != null) {
                            onLocationChangedListener.onSystemLocationChanged(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude(), lastKnownLocation.getAccuracy());
                        }
                        DDLog.e(this.TAG, "current:" + lastKnownLocation.getLatitude() + "," + lastKnownLocation.getLongitude() + "," + lastKnownLocation.getAccuracy());
                    }
                    this.isInit = true;
                }
            }
        }
    }

    @Override // com.ipotensic.kernel.services.ILocationService
    public void start() {
        registerListener();
    }

    @Override // com.ipotensic.kernel.services.ILocationService
    public void reStart() {
        stop();
        start();
    }

    @Override // com.ipotensic.kernel.services.ILocationService
    /* renamed from: isStart, reason: from getter */
    public boolean getIsRegister() {
        return this.isRegister;
    }

    @Override // com.ipotensic.kernel.services.ILocationService
    public void stop() {
        unRegisterListener();
    }

    @Override // com.ipotensic.kernel.services.ILocationService
    public void setOnLocationChangedListener(OnLocationChangedListener listener) {
        this.locationChangedListener = listener;
    }

    public final void registerListener() {
        if (this.isRegister || this.locationManager == null || this.providerName == null) {
            return;
        }
        DDLog.e(this.TAG, "\u5f00\u59cb\u76d1\u542c...");
        LocationManager locationManager = this.locationManager;
        if (locationManager == null) {
            Intrinsics.throwNpe();
        }
        String str = this.providerName;
        if (str == null) {
            Intrinsics.throwNpe();
        }
        locationManager.requestLocationUpdates(str, 1000L, 0.0f, this.locationListener);
        LocationManager locationManager2 = this.locationManager;
        if (locationManager2 == null) {
            Intrinsics.throwNpe();
        }
        locationManager2.registerGnssStatusCallback(this.gpsNumCallback);
        this.isRegister = true;
    }

    public final void unRegisterListener() {
        if (this.isRegister && this.locationManager != null && this.providerName != null) {
            DDLog.e(this.TAG, "\u6ce8\u9500\u76d1\u542c!!");
            LocationManager locationManager = this.locationManager;
            if (locationManager == null) {
                Intrinsics.throwNpe();
            }
            locationManager.removeUpdates(this.locationListener);
            LocationManager locationManager2 = this.locationManager;
            if (locationManager2 == null) {
                Intrinsics.throwNpe();
            }
            locationManager2.unregisterGnssStatusCallback(this.gpsNumCallback);
        }
        this.isRegister = false;
    }

    public final Criteria getCriteria() {
        Criteria criteria = new Criteria();
        criteria.setAccuracy(1);
        criteria.setAltitudeRequired(true);
        criteria.setBearingRequired(true);
        criteria.setCostAllowed(true);
        criteria.setPowerRequirement(3);
        return criteria;
    }
}