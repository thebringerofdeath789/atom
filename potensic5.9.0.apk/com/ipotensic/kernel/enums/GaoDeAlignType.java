package com.ipotensic.kernel.enums;

import kotlin.Metadata;

/* compiled from: GaoDeAlignType.kt */
@Metadata(m2336bv = {1, 0, 3}, m2337d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, m2338d2 = {"Lcom/ipotensic/kernel/enums/GaoDeAlignType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "ALIGN_LEFT", "ALIGN_RIGHT", "ALIGN_BOTTOM", "ALIGN_TOP", "ALIGN_CENTER_HORIZONTAL", "ALIGN_CENTER_VERTICAL", "Kernel_mapboxRelease"}, m2339k = 1, m2340mv = {1, 1, 15})
/* loaded from: classes2.dex */
public enum GaoDeAlignType {
    ALIGN_LEFT(1),
    ALIGN_RIGHT(2),
    ALIGN_BOTTOM(16),
    ALIGN_TOP(8),
    ALIGN_CENTER_HORIZONTAL(4),
    ALIGN_CENTER_VERTICAL(32);

    private final int value;

    GaoDeAlignType(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}