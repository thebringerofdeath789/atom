package com.logan.flight.data.recv;

import com.ipotensic.baselib.netty.ParseUtil;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.beanutils.PropertyUtils;

/* compiled from: FlightRevNoFlyZone.kt */
@Metadata(m2336bv = {1, 0, 3}, m2337d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000  2\u00020\u00012\u00020\u0002:\u0001 B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0018\u001a\u00020\u0000H\u0014J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0005H\u0014J\b\u0010\u001e\u001a\u00020\u001fH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001a\u0010\u0011\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\u001a\u0010\u0013\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001a\u0010\u0015\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0007\"\u0004\b\u0017\u0010\t¨\u0006!"}, m2338d2 = {"Lcom/logan/flight/data/recv/FlightRevNoFlyZone;", "Lcom/logan/flight/data/recv/BaseFlightRevData;", "", "()V", "distance", "", "getDistance", "()I", "setDistance", "(I)V", "isLocatedNoFlyZone", "", "()Z", "setLocatedNoFlyZone", "(Z)V", "isNearLocatedNoFlyZone", "setNearLocatedNoFlyZone", "isNearRestrictedZone", "setNearRestrictedZone", "isRestrictedZone", "setRestrictedZone", "status_2", "getStatus_2", "setStatus_2", "clone", "parseData", "", "data", "", "index", "toString", "", "Companion", "Protocols_release"}, m2339k = 1, m2340mv = {1, 1, 15})
/* loaded from: classes.dex */
public final class FlightRevNoFlyZone extends BaseFlightRevData implements Cloneable {
    public static final int TOUCH_THRESHOLD = 3;
    private int distance;
    private boolean isLocatedNoFlyZone;
    private boolean isNearLocatedNoFlyZone;
    private boolean isNearRestrictedZone;
    private boolean isRestrictedZone;
    private int status_2;

    /* renamed from: isLocatedNoFlyZone, reason: from getter */
    public final boolean getIsLocatedNoFlyZone() {
        return this.isLocatedNoFlyZone;
    }

    public final void setLocatedNoFlyZone(boolean z) {
        this.isLocatedNoFlyZone = z;
    }

    /* renamed from: isRestrictedZone, reason: from getter */
    public final boolean getIsRestrictedZone() {
        return this.isRestrictedZone;
    }

    public final void setRestrictedZone(boolean z) {
        this.isRestrictedZone = z;
    }

    /* renamed from: isNearLocatedNoFlyZone, reason: from getter */
    public final boolean getIsNearLocatedNoFlyZone() {
        return this.isNearLocatedNoFlyZone;
    }

    public final void setNearLocatedNoFlyZone(boolean z) {
        this.isNearLocatedNoFlyZone = z;
    }

    /* renamed from: isNearRestrictedZone, reason: from getter */
    public final boolean getIsNearRestrictedZone() {
        return this.isNearRestrictedZone;
    }

    public final void setNearRestrictedZone(boolean z) {
        this.isNearRestrictedZone = z;
    }

    public final int getStatus_2() {
        return this.status_2;
    }

    public final void setStatus_2(int i) {
        this.status_2 = i;
    }

    public final int getDistance() {
        return this.distance;
    }

    public final void setDistance(int i) {
        this.distance = i;
    }

    @Override // com.logan.flight.data.recv.BaseFlightRevData
    protected void parseData(byte[] data, int index) {
        Intrinsics.checkParameterIsNotNull(data, "data");
        this.isLocatedNoFlyZone = ParseUtil.getBit(data[index], 0) == 1;
        this.isRestrictedZone = ParseUtil.getBit(data[index], 1) == 1;
        this.isNearLocatedNoFlyZone = ParseUtil.getBit(data[index], 2) == 1;
        this.isNearRestrictedZone = ParseUtil.getBit(data[index], 3) == 1;
        this.status_2 = ParseUtil.getIntFromByteArr(data, index + 4);
        this.distance = ParseUtil.getIntFromByteArr(data, index + 8);
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public FlightRevNoFlyZone m2620clone() throws CloneNotSupportedException {
        Object clone = super.clone();
        if (clone != null) {
            return (FlightRevNoFlyZone) clone;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.logan.flight.data.recv.FlightRevNoFlyZone");
    }

    public String toString() {
        return "FlightRevNoFlyZone(isLocatedNoFlyZone=" + this.isLocatedNoFlyZone + ",isRestrictedZone=" + this.isRestrictedZone + ",isNearLocatedNoFlyZone=" + this.isNearLocatedNoFlyZone + ",isNearRestrictedZone=" + this.isNearRestrictedZone + ",status_2=" + this.status_2 + ",distance=" + this.distance + PropertyUtils.MAPPED_DELIM2;
    }
}