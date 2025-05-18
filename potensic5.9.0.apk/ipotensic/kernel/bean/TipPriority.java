package com.ipotensic.kernel.bean;

import kotlin.Metadata;

/* compiled from: TipPriority.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r\u00a8\u0006\u000e"}, d2 = {"Lcom/ipotensic/kernel/bean/TipPriority;", "", "level", "", "(Ljava/lang/String;II)V", "getLevel", "()I", "setLevel", "(I)V", "NONE", "SAFE", "LOW", "MEDIUM", "HIGH", "Kernel_mapboxRelease"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public enum TipPriority {
    NONE(0),
    SAFE(1),
    LOW(2),
    MEDIUM(3),
    HIGH(4);

    private int level;

    TipPriority(int i) {
        this.level = i;
    }

    public final int getLevel() {
        return this.level;
    }

    public final void setLevel(int i) {
        this.level = i;
    }
}