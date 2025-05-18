package com.logan.flight.enums;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: NormalCmdType.kt */
@Metadata(m2336bv = {1, 0, 3}, m2337d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\n\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, m2338d2 = {"Lcom/logan/flight/enums/NormalCmdType;", "", "value", "", "(Ljava/lang/String;IS)V", "getValue", "()S", "GET_GIMBAL_VERSION", "SET_ESC_VOICE", "GET_CURRENT_OR_TEMP_LIMIT", "MAG_CALIBRATION_ANSWER", "ENTER_QUIT_MAG_CALIBRATION", "MAG_CALIBRATION_TIMEOUT", "Companion", "Protocols_release"}, m2339k = 1, m2340mv = {1, 1, 15})
/* loaded from: classes.dex */
public enum NormalCmdType {
    GET_GIMBAL_VERSION(1),
    SET_ESC_VOICE(2),
    GET_CURRENT_OR_TEMP_LIMIT(3),
    MAG_CALIBRATION_ANSWER(4),
    ENTER_QUIT_MAG_CALIBRATION(5),
    MAG_CALIBRATION_TIMEOUT(6);


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final short value;

    NormalCmdType(short s) {
        this.value = s;
    }

    public final short getValue() {
        return this.value;
    }

    /* compiled from: NormalCmdType.kt */
    @Metadata(m2336bv = {1, 0, 3}, m2337d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\n\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, m2338d2 = {"Lcom/logan/flight/enums/NormalCmdType$Companion;", "", "()V", "findValue", "Lcom/logan/flight/enums/NormalCmdType;", "cmd", "", "Protocols_release"}, m2339k = 1, m2340mv = {1, 1, 15})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final NormalCmdType findValue(short cmd) {
            for (NormalCmdType normalCmdType : NormalCmdType.values()) {
                if (cmd == normalCmdType.getValue()) {
                    return normalCmdType;
                }
            }
            return null;
        }
    }
}