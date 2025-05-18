package com.logan.uom.bean;

import com.logan.flight.type.Flight;
import com.logan.uom.enums.FlightStatus;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.litepal.crud.LitePalSupport;

/* compiled from: UomUploadBody.kt */
@Metadata(m2336bv = {1, 0, 3}, m2337d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b'\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001Be\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u0007¢\u0006\u0002\u0010\u0011J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0007HÆ\u0003J\t\u0010#\u001a\u00020\u0007HÆ\u0003J\t\u0010$\u001a\u00020\u0007HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\t\u0010&\u001a\u00020\u0007HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\t\u0010*\u001a\u00020\u0005HÆ\u0003J\t\u0010+\u001a\u00020\u0007HÆ\u0003J\t\u0010,\u001a\u00020\u0007HÆ\u0003J\u0081\u0001\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u0007HÆ\u0001J\u0013\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u000101HÖ\u0003J\u0006\u00102\u001a\u000203J\u0006\u00104\u001a\u000205J\t\u00106\u001a\u00020\u0007HÖ\u0001J\t\u00107\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\r\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0010\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\u000f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001cR\u0011\u0010\u000e\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0013¨\u00068"}, m2338d2 = {"Lcom/logan/uom/bean/UomUploadBody;", "Lorg/litepal/crud/LitePalSupport;", "sn", "", "timeMillis", "", "flightSorties", "", "flightStatusEnumName", "flightEnumName", "longitude", "latitude", "height", "altitude", "vs", "gs", "course", "(Ljava/lang/String;JILjava/lang/String;Ljava/lang/String;JJIIIII)V", "getAltitude", "()I", "getCourse", "getFlightEnumName", "()Ljava/lang/String;", "getFlightSorties", "getFlightStatusEnumName", "getGs", "getHeight", "getLatitude", "()J", "getLongitude", "getSn", "getTimeMillis", "getVs", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "getFlightEnum", "Lcom/logan/flight/type/Flight;", "getFlightStatusEnum", "Lcom/logan/uom/enums/FlightStatus;", "hashCode", "toString", "UomTask_release"}, m2339k = 1, m2340mv = {1, 1, 15})
/* loaded from: classes3.dex */
public final /* data */ class UomUploadBody extends LitePalSupport {
    private final int altitude;
    private final int course;
    private final String flightEnumName;
    private final int flightSorties;
    private final String flightStatusEnumName;
    private final int gs;
    private final int height;
    private final long latitude;
    private final long longitude;
    private final String sn;
    private final long timeMillis;
    private final int vs;

    /* renamed from: component1, reason: from getter */
    public final String getSn() {
        return this.sn;
    }

    /* renamed from: component10, reason: from getter */
    public final int getVs() {
        return this.vs;
    }

    /* renamed from: component11, reason: from getter */
    public final int getGs() {
        return this.gs;
    }

    /* renamed from: component12, reason: from getter */
    public final int getCourse() {
        return this.course;
    }

    /* renamed from: component2, reason: from getter */
    public final long getTimeMillis() {
        return this.timeMillis;
    }

    /* renamed from: component3, reason: from getter */
    public final int getFlightSorties() {
        return this.flightSorties;
    }

    /* renamed from: component4, reason: from getter */
    public final String getFlightStatusEnumName() {
        return this.flightStatusEnumName;
    }

    /* renamed from: component5, reason: from getter */
    public final String getFlightEnumName() {
        return this.flightEnumName;
    }

    /* renamed from: component6, reason: from getter */
    public final long getLongitude() {
        return this.longitude;
    }

    /* renamed from: component7, reason: from getter */
    public final long getLatitude() {
        return this.latitude;
    }

    /* renamed from: component8, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    /* renamed from: component9, reason: from getter */
    public final int getAltitude() {
        return this.altitude;
    }

    public final UomUploadBody copy(String sn, long timeMillis, int flightSorties, String flightStatusEnumName, String flightEnumName, long longitude, long latitude, int height, int altitude, int vs, int gs, int course) {
        Intrinsics.checkParameterIsNotNull(sn, "sn");
        Intrinsics.checkParameterIsNotNull(flightStatusEnumName, "flightStatusEnumName");
        Intrinsics.checkParameterIsNotNull(flightEnumName, "flightEnumName");
        return new UomUploadBody(sn, timeMillis, flightSorties, flightStatusEnumName, flightEnumName, longitude, latitude, height, altitude, vs, gs, course);
    }

    public boolean equals(Object other) {
        if (this != other) {
            if (other instanceof UomUploadBody) {
                UomUploadBody uomUploadBody = (UomUploadBody) other;
                if (Intrinsics.areEqual(this.sn, uomUploadBody.sn)) {
                    if (this.timeMillis == uomUploadBody.timeMillis) {
                        if ((this.flightSorties == uomUploadBody.flightSorties) && Intrinsics.areEqual(this.flightStatusEnumName, uomUploadBody.flightStatusEnumName) && Intrinsics.areEqual(this.flightEnumName, uomUploadBody.flightEnumName)) {
                            if (this.longitude == uomUploadBody.longitude) {
                                if (this.latitude == uomUploadBody.latitude) {
                                    if (this.height == uomUploadBody.height) {
                                        if (this.altitude == uomUploadBody.altitude) {
                                            if (this.vs == uomUploadBody.vs) {
                                                if (this.gs == uomUploadBody.gs) {
                                                    if (this.course == uomUploadBody.course) {
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.sn;
        int hashCode = str != null ? str.hashCode() : 0;
        long j = this.timeMillis;
        int i = ((((hashCode * 31) + ((int) (j ^ (j >>> 32)))) * 31) + this.flightSorties) * 31;
        String str2 = this.flightStatusEnumName;
        int hashCode2 = (i + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.flightEnumName;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        long j2 = this.longitude;
        int i2 = (hashCode3 + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        long j3 = this.latitude;
        return ((((((((((i2 + ((int) (j3 ^ (j3 >>> 32)))) * 31) + this.height) * 31) + this.altitude) * 31) + this.vs) * 31) + this.gs) * 31) + this.course;
    }

    public String toString() {
        return "UomUploadBody(sn=" + this.sn + ", timeMillis=" + this.timeMillis + ", flightSorties=" + this.flightSorties + ", flightStatusEnumName=" + this.flightStatusEnumName + ", flightEnumName=" + this.flightEnumName + ", longitude=" + this.longitude + ", latitude=" + this.latitude + ", height=" + this.height + ", altitude=" + this.altitude + ", vs=" + this.vs + ", gs=" + this.gs + ", course=" + this.course + ")";
    }

    public final String getSn() {
        return this.sn;
    }

    public final long getTimeMillis() {
        return this.timeMillis;
    }

    public final int getFlightSorties() {
        return this.flightSorties;
    }

    public final String getFlightStatusEnumName() {
        return this.flightStatusEnumName;
    }

    public final String getFlightEnumName() {
        return this.flightEnumName;
    }

    public final long getLongitude() {
        return this.longitude;
    }

    public final long getLatitude() {
        return this.latitude;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getAltitude() {
        return this.altitude;
    }

    public final int getVs() {
        return this.vs;
    }

    public final int getGs() {
        return this.gs;
    }

    public final int getCourse() {
        return this.course;
    }

    public UomUploadBody(String sn, long j, int i, String flightStatusEnumName, String flightEnumName, long j2, long j3, int i2, int i3, int i4, int i5, int i6) {
        Intrinsics.checkParameterIsNotNull(sn, "sn");
        Intrinsics.checkParameterIsNotNull(flightStatusEnumName, "flightStatusEnumName");
        Intrinsics.checkParameterIsNotNull(flightEnumName, "flightEnumName");
        this.sn = sn;
        this.timeMillis = j;
        this.flightSorties = i;
        this.flightStatusEnumName = flightStatusEnumName;
        this.flightEnumName = flightEnumName;
        this.longitude = j2;
        this.latitude = j3;
        this.height = i2;
        this.altitude = i3;
        this.vs = i4;
        this.gs = i5;
        this.course = i6;
    }

    public final Flight getFlightEnum() {
        return Flight.valueOf(this.flightEnumName);
    }

    public final FlightStatus getFlightStatusEnum() {
        return FlightStatus.valueOf(this.flightStatusEnumName);
    }
}