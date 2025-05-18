package com.logan.flight.data.recv;

import com.ipotensic.baselib.netty.ParseUtil;
import com.ipotensic.baselib.utils.UnitUtil;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FlightRevRecord.kt */
@Metadata(m2336bv = {1, 0, 3}, m2337d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010Q\u001a\u00020R2\b\u0010S\u001a\u0004\u0018\u00010T2\u0006\u0010U\u001a\u00020\u0019H\u0014J\b\u0010V\u001a\u00020WH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0005\"\u0004\b\t\u0010\u0007R\u001a\u0010\n\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0005\"\u0004\b\u000b\u0010\u0007R\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0005\"\u0004\b\r\u0010\u0007R\u001a\u0010\u000e\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0005\"\u0004\b\u000f\u0010\u0007R\u001a\u0010\u0010\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0005\"\u0004\b\u0011\u0010\u0007R\u001a\u0010\u0012\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0005\"\u0004\b\u0013\u0010\u0007R\u001a\u0010\u0014\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0005\"\u0004\b\u0015\u0010\u0007R\u001a\u0010\u0016\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0005\"\u0004\b\u0017\u0010\u0007R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR\u001a\u0010!\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001b\"\u0004\b#\u0010\u001dR\u001a\u0010$\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001b\"\u0004\b&\u0010\u001dR\u001a\u0010'\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001b\"\u0004\b)\u0010\u001dR\u001a\u0010*\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001b\"\u0004\b,\u0010\u001dR\u001a\u0010-\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u001b\"\u0004\b/\u0010\u001dR\u001a\u00100\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u001b\"\u0004\b2\u0010\u001dR\u001a\u00103\u001a\u000204X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001a\u00109\u001a\u000204X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u00106\"\u0004\b;\u00108R\u001a\u0010<\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u001b\"\u0004\b>\u0010\u001dR\u001a\u0010?\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u001b\"\u0004\bA\u0010\u001dR\u001a\u0010B\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u001b\"\u0004\bD\u0010\u001dR\u001a\u0010E\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u001b\"\u0004\bG\u0010\u001dR\u001a\u0010H\u001a\u00020IX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u001a\u0010N\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\u001b\"\u0004\bP\u0010\u001d¨\u0006X"}, m2338d2 = {"Lcom/logan/flight/data/recv/FlightRevRecord;", "Lcom/logan/flight/data/recv/BaseFlightRevData;", "()V", "isFlight", "", "()Z", "setFlight", "(Z)V", "isFollowing", "setFollowing", "isHotCircle", "setHotCircle", "isLanding", "setLanding", "isPointFly", "setPointFly", "isPointFlyFinished", "setPointFlyFinished", "isReceiveGps", "setReceiveGps", "isReturning", "setReturning", "isUnLock", "setUnLock", "maxFlightDistance", "", "getMaxFlightDistance", "()I", "setMaxFlightDistance", "(I)V", "maxFlightHeight", "getMaxFlightHeight", "setMaxFlightHeight", "pitch", "getPitch", "setPitch", "remainTime", "getRemainTime", "setRemainTime", "reserve", "getReserve", "setReserve", "reserve0", "getReserve0", "setReserve0", "roll", "getRoll", "setRoll", "singleFlightDuration", "getSingleFlightDuration", "setSingleFlightDuration", "singleFlightEndTime", "", "getSingleFlightEndTime", "()J", "setSingleFlightEndTime", "(J)V", "singleFlightStartTime", "getSingleFlightStartTime", "setSingleFlightStartTime", "singleMileageFlown", "getSingleMileageFlown", "setSingleMileageFlown", "sorties", "getSorties", "setSorties", "totalFlightDuration", "getTotalFlightDuration", "setTotalFlightDuration", "totalMileageFlown", "getTotalMileageFlown", "setTotalMileageFlown", "windSpeed", "", "getWindSpeed", "()F", "setWindSpeed", "(F)V", "yaw", "getYaw", "setYaw", "parseData", "", "data", "", "payloadIndex", "toString", "", "Protocols_release"}, m2339k = 1, m2340mv = {1, 1, 15})
/* loaded from: classes.dex */
public final class FlightRevRecord extends BaseFlightRevData {
    private boolean isFlight;
    private boolean isFollowing;
    private boolean isHotCircle;
    private boolean isLanding;
    private boolean isPointFly;
    private boolean isPointFlyFinished;
    private boolean isReceiveGps;
    private boolean isReturning;
    private boolean isUnLock;
    private int maxFlightDistance;
    private int maxFlightHeight;
    private int pitch;
    private int remainTime;
    private int reserve;
    private int reserve0;
    private int roll;
    private int singleFlightDuration;
    private long singleFlightEndTime;
    private long singleFlightStartTime;
    private int singleMileageFlown;
    private int sorties;
    private int totalFlightDuration;
    private int totalMileageFlown;
    private float windSpeed;
    private int yaw;

    public final int getSorties() {
        return this.sorties;
    }

    public final void setSorties(int i) {
        this.sorties = i;
    }

    public final long getSingleFlightStartTime() {
        return this.singleFlightStartTime;
    }

    public final void setSingleFlightStartTime(long j) {
        this.singleFlightStartTime = j;
    }

    public final long getSingleFlightEndTime() {
        return this.singleFlightEndTime;
    }

    public final void setSingleFlightEndTime(long j) {
        this.singleFlightEndTime = j;
    }

    public final int getMaxFlightHeight() {
        return this.maxFlightHeight;
    }

    public final void setMaxFlightHeight(int i) {
        this.maxFlightHeight = i;
    }

    public final int getMaxFlightDistance() {
        return this.maxFlightDistance;
    }

    public final void setMaxFlightDistance(int i) {
        this.maxFlightDistance = i;
    }

    public final float getWindSpeed() {
        return this.windSpeed;
    }

    public final void setWindSpeed(float f) {
        this.windSpeed = f;
    }

    public final int getReserve0() {
        return this.reserve0;
    }

    public final void setReserve0(int i) {
        this.reserve0 = i;
    }

    public final int getTotalMileageFlown() {
        return this.totalMileageFlown;
    }

    public final void setTotalMileageFlown(int i) {
        this.totalMileageFlown = i;
    }

    public final int getTotalFlightDuration() {
        return this.totalFlightDuration;
    }

    public final void setTotalFlightDuration(int i) {
        this.totalFlightDuration = i;
    }

    public final int getSingleFlightDuration() {
        return this.singleFlightDuration;
    }

    public final void setSingleFlightDuration(int i) {
        this.singleFlightDuration = i;
    }

    public final int getSingleMileageFlown() {
        return this.singleMileageFlown;
    }

    public final void setSingleMileageFlown(int i) {
        this.singleMileageFlown = i;
    }

    /* renamed from: isUnLock, reason: from getter */
    public final boolean getIsUnLock() {
        return this.isUnLock;
    }

    public final void setUnLock(boolean z) {
        this.isUnLock = z;
    }

    /* renamed from: isFlight, reason: from getter */
    public final boolean getIsFlight() {
        return this.isFlight;
    }

    public final void setFlight(boolean z) {
        this.isFlight = z;
    }

    /* renamed from: isReceiveGps, reason: from getter */
    public final boolean getIsReceiveGps() {
        return this.isReceiveGps;
    }

    public final void setReceiveGps(boolean z) {
        this.isReceiveGps = z;
    }

    /* renamed from: isFollowing, reason: from getter */
    public final boolean getIsFollowing() {
        return this.isFollowing;
    }

    public final void setFollowing(boolean z) {
        this.isFollowing = z;
    }

    /* renamed from: isHotCircle, reason: from getter */
    public final boolean getIsHotCircle() {
        return this.isHotCircle;
    }

    public final void setHotCircle(boolean z) {
        this.isHotCircle = z;
    }

    /* renamed from: isPointFly, reason: from getter */
    public final boolean getIsPointFly() {
        return this.isPointFly;
    }

    public final void setPointFly(boolean z) {
        this.isPointFly = z;
    }

    /* renamed from: isPointFlyFinished, reason: from getter */
    public final boolean getIsPointFlyFinished() {
        return this.isPointFlyFinished;
    }

    public final void setPointFlyFinished(boolean z) {
        this.isPointFlyFinished = z;
    }

    /* renamed from: isReturning, reason: from getter */
    public final boolean getIsReturning() {
        return this.isReturning;
    }

    public final void setReturning(boolean z) {
        this.isReturning = z;
    }

    /* renamed from: isLanding, reason: from getter */
    public final boolean getIsLanding() {
        return this.isLanding;
    }

    public final void setLanding(boolean z) {
        this.isLanding = z;
    }

    public final int getReserve() {
        return this.reserve;
    }

    public final void setReserve(int i) {
        this.reserve = i;
    }

    public final int getRemainTime() {
        return this.remainTime;
    }

    public final void setRemainTime(int i) {
        this.remainTime = i;
    }

    public final int getRoll() {
        return this.roll;
    }

    public final void setRoll(int i) {
        this.roll = i;
    }

    public final int getPitch() {
        return this.pitch;
    }

    public final void setPitch(int i) {
        this.pitch = i;
    }

    public final int getYaw() {
        return this.yaw;
    }

    public final void setYaw(int i) {
        this.yaw = i;
    }

    @Override // com.logan.flight.data.recv.BaseFlightRevData
    protected void parseData(byte[] data, int payloadIndex) {
        this.sorties = ParseUtil.getIntFromByteArr(data, payloadIndex);
        this.singleFlightStartTime = UInt.m2733constructorimpl(ParseUtil.getIntFromByteArr(data, payloadIndex + 4)) & 4294967295L;
        this.singleFlightEndTime = UInt.m2733constructorimpl(ParseUtil.getIntFromByteArr(data, payloadIndex + 8)) & 4294967295L;
        this.maxFlightHeight = ParseUtil.getUnsignedShortFromByteArr(data, payloadIndex + 12);
        this.maxFlightDistance = ParseUtil.getUnsignedShortFromByteArr(data, payloadIndex + 14);
        this.windSpeed = UnitUtil.keepTwoDigit(ParseUtil.getUnsignedShortFromByteArr(data, payloadIndex + 16) / 100.0f);
        this.totalMileageFlown = ParseUtil.getIntFromByteArr(data, payloadIndex + 20);
        this.totalFlightDuration = ParseUtil.getIntFromByteArr(data, payloadIndex + 24);
        this.singleFlightDuration = ParseUtil.getIntFromByteArr(data, payloadIndex + 28);
        this.singleMileageFlown = ParseUtil.getIntFromByteArr(data, payloadIndex + 32);
        if (data == null) {
            Intrinsics.throwNpe();
        }
        byte b = data[payloadIndex + 36];
        this.isUnLock = ParseUtil.getBit(b, 0) == 1;
        this.isFlight = ParseUtil.getBit(b, 1) == 1;
        this.isReceiveGps = ParseUtil.getBit(b, 2) == 1;
        this.isFollowing = ParseUtil.getBit(b, 3) == 1;
        this.isHotCircle = ParseUtil.getBit(b, 4) == 1;
        this.isPointFlyFinished = ParseUtil.getBit(b, 5) == 0 && this.isPointFly;
        this.isPointFly = ParseUtil.getBit(b, 5) == 1;
        this.isReturning = ParseUtil.getBit(b, 6) == 1;
        this.isLanding = ParseUtil.getBit(b, 7) == 1;
        this.reserve = ParseUtil.getIntFromByteArr(data, payloadIndex + 40);
        this.remainTime = ParseUtil.getUnsignedShortFromByteArr(data, payloadIndex + 44);
        this.roll = ParseUtil.getSignedShortFromByteArr(data, payloadIndex + 46);
        this.pitch = ParseUtil.getSignedShortFromByteArr(data, payloadIndex + 48);
        this.yaw = ParseUtil.getSignedShortFromByteArr(data, payloadIndex + 50);
    }

    public String toString() {
        return "FlightRevRecord(sorties=" + this.sorties + ", singleFlightStartTime=" + this.singleFlightStartTime + ", singleFlightEndTime=" + this.singleFlightEndTime + ", maxFlightHeight=" + this.maxFlightHeight + ", maxFlightDistance=" + this.maxFlightDistance + ", windSpeed=" + this.windSpeed + ", totalMileageFlown=" + this.totalMileageFlown + ", totalFlightDuration=" + this.totalFlightDuration + ", singleFlightDuration=" + this.singleFlightDuration + ", singleMileageFlown=" + this.singleMileageFlown + ", isUnLock=" + this.isUnLock + ", isFlight=" + this.isFlight + ", isReceiveGps=" + this.isReceiveGps + ", isFollowing=" + this.isFollowing + ", isHotCircle=" + this.isHotCircle + ", isPointFly=" + this.isPointFly + ", isPointFlyFinished=" + this.isPointFlyFinished + ", isReturning=" + this.isReturning + ", isLanding=" + this.isLanding + ", remainTime=" + this.remainTime + ", roll=" + this.roll + ", pitch=" + this.pitch + ", yaw=" + this.yaw;
    }
}