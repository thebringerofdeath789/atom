package com.ipotensic.kernel.bean;

import com.ipotensic.kernel.C1965R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.net.telnet.TelnetCommand;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'UNOWNED' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: ErrorCode.kt */
@Metadata(m2336bv = {1, 0, 3}, m2337d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b \b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001BQ\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0003\u0010\b\u001a\u00020\t\u0012\b\b\u0003\u0010\n\u001a\u00020\t\u0012\b\b\u0003\u0010\u000b\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0003\u0010\u000e\u001a\u00020\t¢\u0006\u0002\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\n\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010\u000b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0015\"\u0004\b\"\u0010\u0017R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010\u000e\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0015\"\u0004\b(\u0010\u0017j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,¨\u0006-"}, m2338d2 = {"Lcom/ipotensic/kernel/bean/ErrorCode;", "", "type", "Lcom/ipotensic/kernel/bean/WarnErrorType;", "code", "", "noticePriority", "Lcom/ipotensic/kernel/bean/TipPriority;", "codeName", "", "entryResId", "soundRawId", "isRepeatPrompt", "", "warnRightResId", "(Ljava/lang/String;ILcom/ipotensic/kernel/bean/WarnErrorType;JLcom/ipotensic/kernel/bean/TipPriority;IIIZI)V", "getCode", "()J", "setCode", "(J)V", "getCodeName", "()I", "setCodeName", "(I)V", "getEntryResId", "setEntryResId", "()Z", "setRepeatPrompt", "(Z)V", "getNoticePriority", "()Lcom/ipotensic/kernel/bean/TipPriority;", "setNoticePriority", "(Lcom/ipotensic/kernel/bean/TipPriority;)V", "getSoundRawId", "setSoundRawId", "getType", "()Lcom/ipotensic/kernel/bean/WarnErrorType;", "setType", "(Lcom/ipotensic/kernel/bean/WarnErrorType;)V", "getWarnRightResId", "setWarnRightResId", "UNOWNED", "NOFLY_FORCED_LANDING_PROGRESS", "NOFLY_FORCED_RETURN_PROGRESS", "ALTITUDE_EXCEEDED_HEIGHT_LIMIT", "Kernel_mapboxRelease"}, m2339k = 1, m2340mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class ErrorCode {
    private static final /* synthetic */ ErrorCode[] $VALUES;
    public static final ErrorCode ALTITUDE_EXCEEDED_HEIGHT_LIMIT;
    public static final ErrorCode NOFLY_FORCED_LANDING_PROGRESS;
    public static final ErrorCode NOFLY_FORCED_RETURN_PROGRESS;
    public static final ErrorCode UNOWNED;
    private long code;
    private int codeName;
    private int entryResId;
    private boolean isRepeatPrompt;
    private TipPriority noticePriority;
    private int soundRawId;
    private WarnErrorType type;
    private int warnRightResId;

    public static ErrorCode valueOf(String str) {
        return (ErrorCode) Enum.valueOf(ErrorCode.class, str);
    }

    public static ErrorCode[] values() {
        return (ErrorCode[]) $VALUES.clone();
    }

    private ErrorCode(String str, int i, WarnErrorType warnErrorType, long j, TipPriority tipPriority, int i2, int i3, int i4, boolean z, int i5) {
        this.type = warnErrorType;
        this.code = j;
        this.noticePriority = tipPriority;
        this.codeName = i2;
        this.entryResId = i3;
        this.soundRawId = i4;
        this.isRepeatPrompt = z;
        this.warnRightResId = i5;
    }

    public final WarnErrorType getType() {
        return this.type;
    }

    public final void setType(WarnErrorType warnErrorType) {
        Intrinsics.checkParameterIsNotNull(warnErrorType, "<set-?>");
        this.type = warnErrorType;
    }

    public final long getCode() {
        return this.code;
    }

    public final void setCode(long j) {
        this.code = j;
    }

    public final TipPriority getNoticePriority() {
        return this.noticePriority;
    }

    public final void setNoticePriority(TipPriority tipPriority) {
        Intrinsics.checkParameterIsNotNull(tipPriority, "<set-?>");
        this.noticePriority = tipPriority;
    }

    public final int getCodeName() {
        return this.codeName;
    }

    public final void setCodeName(int i) {
        this.codeName = i;
    }

    public final int getEntryResId() {
        return this.entryResId;
    }

    public final void setEntryResId(int i) {
        this.entryResId = i;
    }

    public final int getSoundRawId() {
        return this.soundRawId;
    }

    public final void setSoundRawId(int i) {
        this.soundRawId = i;
    }

    /* renamed from: isRepeatPrompt, reason: from getter */
    public final boolean getIsRepeatPrompt() {
        return this.isRepeatPrompt;
    }

    public final void setRepeatPrompt(boolean z) {
        this.isRepeatPrompt = z;
    }

    /* synthetic */ ErrorCode(String str, int i, WarnErrorType warnErrorType, long j, TipPriority tipPriority, int i2, int i3, int i4, boolean z, int i5, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, warnErrorType, j, tipPriority, (i6 & 8) != 0 ? -1 : i2, (i6 & 16) != 0 ? -1 : i3, (i6 & 32) != 0 ? -1 : i4, (i6 & 64) != 0 ? false : z, (i6 & 128) != 0 ? -1 : i5);
    }

    public final int getWarnRightResId() {
        return this.warnRightResId;
    }

    public final void setWarnRightResId(int i) {
        this.warnRightResId = i;
    }

    static {
        int i = 0;
        ErrorCode errorCode = new ErrorCode("UNOWNED", 0, WarnErrorType.WARN_NORMAL, 0L, TipPriority.NONE, 0, 0, 0, false, i, TelnetCommand.f4276EL, null);
        UNOWNED = errorCode;
        ErrorCode errorCode2 = new ErrorCode("NOFLY_FORCED_LANDING_PROGRESS", 1, WarnErrorType.WARN_LONGSHOW, 0L, TipPriority.HIGH, C1965R.string.toast_no_fly_zone_drone_is_forced_landing, C1965R.string.toast_no_fly_zone_drone_is_forced_landing, 0, false, 0, 224, null);
        NOFLY_FORCED_LANDING_PROGRESS = errorCode2;
        long j = 0;
        boolean z = false;
        int i2 = 0;
        int i3 = 224;
        DefaultConstructorMarker defaultConstructorMarker = null;
        ErrorCode errorCode3 = new ErrorCode("NOFLY_FORCED_RETURN_PROGRESS", 2, WarnErrorType.WARN_LONGSHOW, j, TipPriority.HIGH, C1965R.string.toast_approaching_the_no_fly_zone, C1965R.string.toast_approaching_the_no_fly_zone, i, z, i2, i3, defaultConstructorMarker);
        NOFLY_FORCED_RETURN_PROGRESS = errorCode3;
        ErrorCode errorCode4 = new ErrorCode("ALTITUDE_EXCEEDED_HEIGHT_LIMIT", 3, WarnErrorType.WARN_LONGSHOW, j, TipPriority.HIGH, C1965R.string.f2146x7aba9a22, C1965R.string.f2146x7aba9a22, i, z, i2, i3, defaultConstructorMarker);
        ALTITUDE_EXCEEDED_HEIGHT_LIMIT = errorCode4;
        $VALUES = new ErrorCode[]{errorCode, errorCode2, errorCode3, errorCode4};
    }
}