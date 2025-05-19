package org.apache.poi.openxml4j.opc;

/* loaded from: classes5.dex */
public enum CompressionOption {
    FAST(1),
    MAXIMUM(9),
    NORMAL(-1),
    NOT_COMPRESSED(0);

    private final int value;

    CompressionOption(int i) {
        this.value = i;
    }

    public int value() {
        return this.value;
    }
}
