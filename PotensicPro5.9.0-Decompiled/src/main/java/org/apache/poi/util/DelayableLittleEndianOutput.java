package org.apache.poi.util;

/* loaded from: classes5.dex */
public interface DelayableLittleEndianOutput extends LittleEndianOutput {
    LittleEndianOutput createDelayedOutput(int i);
}
