package com.ipotensic.kernel.bean;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.beanutils.PropertyUtils;

/* compiled from: DroneNoticeBean.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b&\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u00a2\u0006\u0002\u0010\u000fJ\t\u0010(\u001a\u00020\u0003H\u00c6\u0003J\t\u0010)\u001a\u00020\u0005H\u00c6\u0003J\t\u0010*\u001a\u00020\u0007H\u00c6\u0003J\t\u0010+\u001a\u00020\tH\u00c6\u0003J\t\u0010,\u001a\u00020\u000bH\u00c6\u0003J\t\u0010-\u001a\u00020\u000bH\u00c6\u0003J\t\u0010.\u001a\u00020\u000eH\u00c6\u0003JO\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u00c6\u0001J\u0013\u00100\u001a\u00020\u000b2\b\u00101\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u00102\u001a\u00020\u000eH\u0016J\b\u00103\u001a\u00020\u0005H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\f\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0014\"\u0004\b\u0017\u0010\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'\u00a8\u00064"}, d2 = {"Lcom/ipotensic/kernel/bean/DroneNoticeBean;", "", "errorCode", "Lcom/ipotensic/kernel/bean/ErrorCode;", "param", "", "reminderTime", "", NotificationCompat.CATEGORY_STATUS, "Lcom/ipotensic/kernel/bean/TipStatus;", "isNeedPrompt", "", "isPlayComplete", "showTime", "", "(Lcom/ipotensic/kernel/bean/ErrorCode;Ljava/lang/String;JLcom/ipotensic/kernel/bean/TipStatus;ZZI)V", "getErrorCode", "()Lcom/ipotensic/kernel/bean/ErrorCode;", "setErrorCode", "(Lcom/ipotensic/kernel/bean/ErrorCode;)V", "()Z", "setNeedPrompt", "(Z)V", "setPlayComplete", "getParam", "()Ljava/lang/String;", "setParam", "(Ljava/lang/String;)V", "getReminderTime", "()J", "setReminderTime", "(J)V", "getShowTime", "()I", "setShowTime", "(I)V", "getStatus", "()Lcom/ipotensic/kernel/bean/TipStatus;", "setStatus", "(Lcom/ipotensic/kernel/bean/TipStatus;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "Kernel_mapboxRelease"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final /* data */ class DroneNoticeBean {
    private ErrorCode errorCode;
    private boolean isNeedPrompt;
    private boolean isPlayComplete;
    private String param;
    private long reminderTime;
    private int showTime;
    private TipStatus status;

    public DroneNoticeBean() {
        this(null, null, 0L, null, false, false, 0, 127, null);
    }

    /* renamed from: component1, reason: from getter */
    public final ErrorCode getErrorCode() {
        return this.errorCode;
    }

    /* renamed from: component2, reason: from getter */
    public final String getParam() {
        return this.param;
    }

    /* renamed from: component3, reason: from getter */
    public final long getReminderTime() {
        return this.reminderTime;
    }

    /* renamed from: component4, reason: from getter */
    public final TipStatus getStatus() {
        return this.status;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getIsNeedPrompt() {
        return this.isNeedPrompt;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getIsPlayComplete() {
        return this.isPlayComplete;
    }

    /* renamed from: component7, reason: from getter */
    public final int getShowTime() {
        return this.showTime;
    }

    public final DroneNoticeBean copy(ErrorCode errorCode, String param, long reminderTime, TipStatus status, boolean isNeedPrompt, boolean isPlayComplete, int showTime) {
        Intrinsics.checkParameterIsNotNull(errorCode, "errorCode");
        Intrinsics.checkParameterIsNotNull(param, "param");
        Intrinsics.checkParameterIsNotNull(status, "status");
        return new DroneNoticeBean(errorCode, param, reminderTime, status, isNeedPrompt, isPlayComplete, showTime);
    }

    public DroneNoticeBean(ErrorCode errorCode, String param, long j, TipStatus status, boolean z, boolean z2, int i) {
        Intrinsics.checkParameterIsNotNull(errorCode, "errorCode");
        Intrinsics.checkParameterIsNotNull(param, "param");
        Intrinsics.checkParameterIsNotNull(status, "status");
        this.errorCode = errorCode;
        this.param = param;
        this.reminderTime = j;
        this.status = status;
        this.isNeedPrompt = z;
        this.isPlayComplete = z2;
        this.showTime = i;
    }

    public /* synthetic */ DroneNoticeBean(ErrorCode errorCode, String str, long j, TipStatus tipStatus, boolean z, boolean z2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? ErrorCode.UNOWNED : errorCode, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? System.currentTimeMillis() : j, (i2 & 8) != 0 ? TipStatus.IGNORE : tipStatus, (i2 & 16) != 0 ? true : z, (i2 & 32) != 0 ? false : z2, (i2 & 64) != 0 ? 3 : i);
    }

    public final ErrorCode getErrorCode() {
        return this.errorCode;
    }

    public final void setErrorCode(ErrorCode errorCode) {
        Intrinsics.checkParameterIsNotNull(errorCode, "<set-?>");
        this.errorCode = errorCode;
    }

    public final String getParam() {
        return this.param;
    }

    public final void setParam(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.param = str;
    }

    public final long getReminderTime() {
        return this.reminderTime;
    }

    public final void setReminderTime(long j) {
        this.reminderTime = j;
    }

    public final TipStatus getStatus() {
        return this.status;
    }

    public final void setStatus(TipStatus tipStatus) {
        Intrinsics.checkParameterIsNotNull(tipStatus, "<set-?>");
        this.status = tipStatus;
    }

    public final boolean isNeedPrompt() {
        return this.isNeedPrompt;
    }

    public final void setNeedPrompt(boolean z) {
        this.isNeedPrompt = z;
    }

    public final boolean isPlayComplete() {
        return this.isPlayComplete;
    }

    public final void setPlayComplete(boolean z) {
        this.isPlayComplete = z;
    }

    public final int getShowTime() {
        return this.showTime;
    }

    public final void setShowTime(int i) {
        this.showTime = i;
    }

    public boolean equals(Object other) {
        return (other instanceof DroneNoticeBean) && this.errorCode == ((DroneNoticeBean) other).errorCode;
    }

    public String toString() {
        return "DroneNoticeBean(errorCode=" + this.errorCode.name() + ", param=" + this.param + ", reminderTime=" + this.reminderTime + ", status=" + this.status + ", isNeedPrompt=" + this.isNeedPrompt + ", isPlayComplete=" + this.isPlayComplete + ", showTime=" + this.showTime + PropertyUtils.MAPPED_DELIM2;
    }

    public int hashCode() {
        return this.errorCode.getCodeName();
    }
}