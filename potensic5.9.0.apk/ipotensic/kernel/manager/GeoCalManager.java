package com.ipotensic.kernel.manager;

import com.logan.flight.data.FlightRevData;
import com.logan.flight.data.recv.FlightRevFlightInfoData;
import com.logan.flight.data.recv.FlightRevSettingData;
import com.logan.flight.data.recv.FlightRevStateData;
import com.mapbox.geojson.Point;
import com.mapbox.turf.TurfMeasurement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GeoCalManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\nR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0015"}, d2 = {"Lcom/ipotensic/kernel/manager/GeoCalManager;", "", "()V", "flightInfoData", "Lcom/logan/flight/data/recv/FlightRevFlightInfoData;", "getFlightInfoData", "()Lcom/logan/flight/data/recv/FlightRevFlightInfoData;", "setFlightInfoData", "(Lcom/logan/flight/data/recv/FlightRevFlightInfoData;)V", "flightSettingData", "Lcom/logan/flight/data/recv/FlightRevSettingData;", "getFlightSettingData", "()Lcom/logan/flight/data/recv/FlightRevSettingData;", "setFlightSettingData", "(Lcom/logan/flight/data/recv/FlightRevSettingData;)V", "check", "", "revFlightGpsInfo", "revFlightSettingInfo", "flightRevSettingData", "Companion", "Kernel_mapboxRelease"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class GeoCalManager {
    public static final int NEED_CAL_DISTANCE = 50;
    private FlightRevFlightInfoData flightInfoData;
    private FlightRevSettingData flightSettingData;

    public final FlightRevSettingData getFlightSettingData() {
        return this.flightSettingData;
    }

    public final void setFlightSettingData(FlightRevSettingData flightRevSettingData) {
        this.flightSettingData = flightRevSettingData;
    }

    public final FlightRevFlightInfoData getFlightInfoData() {
        return this.flightInfoData;
    }

    public final void setFlightInfoData(FlightRevFlightInfoData flightRevFlightInfoData) {
        this.flightInfoData = flightRevFlightInfoData;
    }

    public final void revFlightSettingInfo(FlightRevSettingData flightRevSettingData) {
        Intrinsics.checkParameterIsNotNull(flightRevSettingData, "flightRevSettingData");
        this.flightSettingData = flightRevSettingData;
        check();
    }

    public final void revFlightGpsInfo(FlightRevFlightInfoData flightInfoData) {
        Intrinsics.checkParameterIsNotNull(flightInfoData, "flightInfoData");
        this.flightInfoData = flightInfoData;
        check();
    }

    public final void check() {
        FlightRevFlightInfoData flightRevFlightInfoData = this.flightInfoData;
        if (flightRevFlightInfoData == null || this.flightSettingData == null) {
            return;
        }
        if (flightRevFlightInfoData == null) {
            Intrinsics.throwNpe();
        }
        if (flightRevFlightInfoData.getLat() == 0.0d) {
            FlightRevFlightInfoData flightRevFlightInfoData2 = this.flightInfoData;
            if (flightRevFlightInfoData2 == null) {
                Intrinsics.throwNpe();
            }
            if (flightRevFlightInfoData2.getLng() == 0.0d) {
                return;
            }
        }
        FlightRevFlightInfoData flightRevFlightInfoData3 = this.flightInfoData;
        if (flightRevFlightInfoData3 == null) {
            Intrinsics.throwNpe();
        }
        double lng = flightRevFlightInfoData3.getLng();
        FlightRevFlightInfoData flightRevFlightInfoData4 = this.flightInfoData;
        if (flightRevFlightInfoData4 == null) {
            Intrinsics.throwNpe();
        }
        Point fromLngLat = Point.fromLngLat(lng, flightRevFlightInfoData4.getLat());
        FlightRevSettingData flightRevSettingData = this.flightSettingData;
        if (flightRevSettingData == null) {
            Intrinsics.throwNpe();
        }
        double lastLongitude = flightRevSettingData.getLastLongitude();
        FlightRevSettingData flightRevSettingData2 = this.flightSettingData;
        if (flightRevSettingData2 == null) {
            Intrinsics.throwNpe();
        }
        if (TurfMeasurement.distance(fromLngLat, Point.fromLngLat(lastLongitude, flightRevSettingData2.getLastLatitude()), "kilometers") >= 50) {
            FlightRevData flightRevData = FlightRevData.get();
            Intrinsics.checkExpressionValueIsNotNull(flightRevData, "FlightRevData.get()");
            FlightRevStateData flightState = flightRevData.getFlightRevStateData();
            Intrinsics.checkExpressionValueIsNotNull(flightState, "flightState");
            if (flightState.getMode() == 2 && flightState.isOutdoor()) {
                flightState.isFlight();
            }
        }
    }
}