package org.apache.poi.hssf.record.common;

import org.apache.poi.util.LittleEndianOutput;

/* loaded from: classes5.dex */
public interface SharedFeature {
    int getDataSize();

    void serialize(LittleEndianOutput littleEndianOutput);

    String toString();
}
