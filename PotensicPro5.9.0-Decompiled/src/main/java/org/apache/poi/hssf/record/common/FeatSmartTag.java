package org.apache.poi.hssf.record.common;

import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.util.LittleEndianOutput;

/* loaded from: classes5.dex */
public final class FeatSmartTag implements SharedFeature {
    private byte[] data;

    public FeatSmartTag() {
        this.data = new byte[0];
    }

    public FeatSmartTag(RecordInputStream recordInputStream) {
        this.data = recordInputStream.readRemainder();
    }

    @Override // org.apache.poi.hssf.record.common.SharedFeature
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" [FEATURE SMART TAGS]\n");
        stringBuffer.append(" [/FEATURE SMART TAGS]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.common.SharedFeature
    public int getDataSize() {
        return this.data.length;
    }

    @Override // org.apache.poi.hssf.record.common.SharedFeature
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.write(this.data);
    }
}
