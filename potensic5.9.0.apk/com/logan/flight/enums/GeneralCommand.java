package com.logan.flight.enums;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: GeneralCommand.kt */
@Metadata(m2336bv = {1, 0, 3}, m2337d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\n\n\u0002\b\u0006\b\u0086\u0001\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\t"}, m2338d2 = {"Lcom/logan/flight/enums/GeneralCommand;", "", "cmd", "", "(Ljava/lang/String;IS)V", "getCmd", "()S", "IMU_CAL_RESULT", "Companion", "Protocols_release"}, m2339k = 1, m2340mv = {1, 1, 15})
/* loaded from: classes.dex */
public enum GeneralCommand {
    IMU_CAL_RESULT(1);


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final short cmd;

    GeneralCommand(short s) {
        this.cmd = s;
    }

    public final short getCmd() {
        return this.cmd;
    }

    /* compiled from: GeneralCommand.kt */
    @Metadata(m2336bv = {1, 0, 3}, m2337d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\n\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, m2338d2 = {"Lcom/logan/flight/enums/GeneralCommand$Companion;", "", "()V", "findCmd", "Lcom/logan/flight/enums/GeneralCommand;", "cmd", "", "Protocols_release"}, m2339k = 1, m2340mv = {1, 1, 15})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final GeneralCommand findCmd(short cmd) {
            for (GeneralCommand generalCommand : GeneralCommand.values()) {
                if (cmd == generalCommand.getCmd()) {
                    return generalCommand;
                }
            }
            return null;
        }
    }
}