package com.logan.flight.data.recv;

import com.google.android.exoplayer2.source.rtsp.RtspHeaders;
import com.ipotensic.baselib.netty.ParseUtil;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.UInt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FlightRevGpsSignalTest.kt */
@Metadata(m2336bv = {1, 0, 3}, m2337d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u001d\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010.\u001a\u00020\u0000H\u0016J\u0018\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u000b2\u0006\u00102\u001a\u00020\u0005H\u0014J\b\u00103\u001a\u000204H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001a\u0010\u0013\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001a\u0010\u0016\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\u001a\u0010\u0019\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR\u001a\u0010\u001c\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\tR\u001a\u0010\u001f\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\r\"\u0004\b!\u0010\u000fR\u001a\u0010\"\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0007\"\u0004\b$\u0010\tR\u001a\u0010%\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0007\"\u0004\b'\u0010\tR\u001a\u0010(\u001a\u00020)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-¨\u00065"}, m2338d2 = {"Lcom/logan/flight/data/recv/FlightRevGpsSignalTest;", "Lcom/logan/flight/data/recv/BaseFlightRevData;", "", "()V", "bd_satellites_num", "", "getBd_satellites_num", "()I", "setBd_satellites_num", "(I)V", "bd_signal_to_noise_ratio", "", "getBd_signal_to_noise_ratio", "()[B", "setBd_signal_to_noise_ratio", "([B)V", "ga_satellites_num", "getGa_satellites_num", "setGa_satellites_num", "ga_signal_to_noise_ratio", "getGa_signal_to_noise_ratio", "setGa_signal_to_noise_ratio", "gl_satellites_num", "getGl_satellites_num", "setGl_satellites_num", "gl_signal_to_noise_ratio", "getGl_signal_to_noise_ratio", "setGl_signal_to_noise_ratio", "gp_satellites_num", "getGp_satellites_num", "setGp_satellites_num", "gp_signal_to_noise_ratio", "getGp_signal_to_noise_ratio", "setGp_signal_to_noise_ratio", "gps_home_accuracy", "getGps_home_accuracy", "setGps_home_accuracy", "gps_speed_accuracy", "getGps_speed_accuracy", "setGps_speed_accuracy", RtspHeaders.TIMESTAMP, "", "getTimestamp", "()J", "setTimestamp", "(J)V", "clone", "parseData", "", "data", "index", "toString", "", "Protocols_release"}, m2339k = 1, m2340mv = {1, 1, 15})
/* loaded from: classes.dex */
public final class FlightRevGpsSignalTest extends BaseFlightRevData implements Cloneable {
    private int bd_satellites_num;
    private int ga_satellites_num;
    private int gl_satellites_num;
    private int gp_satellites_num;
    private int gps_home_accuracy;
    private int gps_speed_accuracy;
    private long timestamp;
    private byte[] gp_signal_to_noise_ratio = new byte[30];
    private byte[] bd_signal_to_noise_ratio = new byte[30];
    private byte[] ga_signal_to_noise_ratio = new byte[20];
    private byte[] gl_signal_to_noise_ratio = new byte[20];

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final void setTimestamp(long j) {
        this.timestamp = j;
    }

    public final int getGp_satellites_num() {
        return this.gp_satellites_num;
    }

    public final void setGp_satellites_num(int i) {
        this.gp_satellites_num = i;
    }

    public final int getBd_satellites_num() {
        return this.bd_satellites_num;
    }

    public final void setBd_satellites_num(int i) {
        this.bd_satellites_num = i;
    }

    public final int getGa_satellites_num() {
        return this.ga_satellites_num;
    }

    public final void setGa_satellites_num(int i) {
        this.ga_satellites_num = i;
    }

    public final int getGl_satellites_num() {
        return this.gl_satellites_num;
    }

    public final void setGl_satellites_num(int i) {
        this.gl_satellites_num = i;
    }

    public final byte[] getGp_signal_to_noise_ratio() {
        return this.gp_signal_to_noise_ratio;
    }

    public final void setGp_signal_to_noise_ratio(byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "<set-?>");
        this.gp_signal_to_noise_ratio = bArr;
    }

    public final byte[] getBd_signal_to_noise_ratio() {
        return this.bd_signal_to_noise_ratio;
    }

    public final void setBd_signal_to_noise_ratio(byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "<set-?>");
        this.bd_signal_to_noise_ratio = bArr;
    }

    public final byte[] getGa_signal_to_noise_ratio() {
        return this.ga_signal_to_noise_ratio;
    }

    public final void setGa_signal_to_noise_ratio(byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "<set-?>");
        this.ga_signal_to_noise_ratio = bArr;
    }

    public final byte[] getGl_signal_to_noise_ratio() {
        return this.gl_signal_to_noise_ratio;
    }

    public final void setGl_signal_to_noise_ratio(byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "<set-?>");
        this.gl_signal_to_noise_ratio = bArr;
    }

    public final int getGps_speed_accuracy() {
        return this.gps_speed_accuracy;
    }

    public final void setGps_speed_accuracy(int i) {
        this.gps_speed_accuracy = i;
    }

    public final int getGps_home_accuracy() {
        return this.gps_home_accuracy;
    }

    public final void setGps_home_accuracy(int i) {
        this.gps_home_accuracy = i;
    }

    @Override // com.logan.flight.data.recv.BaseFlightRevData
    protected void parseData(byte[] data, int index) {
        Intrinsics.checkParameterIsNotNull(data, "data");
        this.timestamp = UInt.m2733constructorimpl(ParseUtil.getIntFromByteArr(data, index)) & 4294967295L;
        this.gp_satellites_num = data[index + 4];
        this.ga_satellites_num = data[index + 5];
        this.bd_satellites_num = data[index + 6];
        this.gl_satellites_num = data[index + 7];
        byte[] bArr = this.gp_signal_to_noise_ratio;
        System.arraycopy(data, index + 8, bArr, 0, bArr.length);
        byte[] bArr2 = this.bd_signal_to_noise_ratio;
        System.arraycopy(data, index + 38, bArr2, 0, bArr2.length);
        byte[] bArr3 = this.ga_signal_to_noise_ratio;
        System.arraycopy(data, index + 68, bArr3, 0, bArr3.length);
        byte[] bArr4 = this.gl_signal_to_noise_ratio;
        System.arraycopy(data, index + 88, bArr4, 0, bArr4.length);
        this.gps_speed_accuracy = ParseUtil.getUnsignedShortFromByteArr(data, index + 108);
        this.gps_home_accuracy = ParseUtil.getUnsignedShortFromByteArr(data, index + 110);
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public FlightRevGpsSignalTest m2618clone() {
        Object clone = super.clone();
        if (clone != null) {
            return (FlightRevGpsSignalTest) clone;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.logan.flight.data.recv.FlightRevGpsSignalTest");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("开机时长:" + this.timestamp + " \n");
        sb.append("GP搜星数:" + this.gp_satellites_num + " \t GA搜星数:" + this.ga_satellites_num + " \t BD搜星数:" + this.bd_satellites_num + " \t GL搜星数:" + this.gl_satellites_num + " \n");
        sb.append("速度质量:" + this.gps_speed_accuracy + " \t 位置质量:" + this.gps_home_accuracy);
        String sb2 = sb.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb2, "sb.toString()");
        return sb2;
    }
}